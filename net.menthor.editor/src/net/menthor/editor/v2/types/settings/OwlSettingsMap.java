package net.menthor.editor.v2.types.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import net.menthor.common.transformation.OwlAxiomsEnforcement;
import net.menthor.common.transformation.OwlReasoner;

import net.menthor.editor.v2.util.Directories;
import net.menthor.editor.v2.util.Util;

public final class OwlSettingsMap {
	
	private static OwlSettingsMap instance = new OwlSettingsMap();	
	public static OwlSettingsMap getInstance() { return instance; }
	
	private String fileName = "owl-cnf.xml";
	public String getFileName(){ return fileName; }
	
	private Properties properties=null;
	private String dir = Directories.getTempDir();
		
	private OwlSettingsMap() {
		setdefault();
	}
	
	private void setdefault(){
		if(properties==null) properties = new Properties();
		if(properties!=null && properties.isEmpty()){
			properties.put(OwlSettingsType.ONTOLOGY_IRI.toString(), "http://www.menthor.net/myontology");
			properties.put(OwlSettingsType.ASYMMETRIC.toString(),"true");
			properties.put(OwlSettingsType.CARDINALITIES.toString(),"true");
			properties.put(OwlSettingsType.COMMENTS.toString(),"true");
			properties.put(OwlSettingsType.COMPLETENESS_OF_CLASSES.toString(),"true");
			properties.put(OwlSettingsType.DISJOINTNESS_OF_CLASSES.toString(),"true");
			properties.put(OwlSettingsType.DISJOINTNESS_OF_ASSOCIATIONS.toString(),"true");		
			properties.put(OwlSettingsType.DOMAIN.toString(),"true");
			properties.put(OwlSettingsType.FUNCTIONAL.toString(),"true");
			properties.put(OwlSettingsType.INVERSE.toString(),"true");
			properties.put(OwlSettingsType.INVERSE_FUNCTIONAL.toString(),"true");	    
			properties.put(OwlSettingsType.IRREFLEXIVE.toString(),"true");
			properties.put(OwlSettingsType.LABELS.toString(),"true");	    
			properties.put(OwlSettingsType.RANGE.toString(),"true");
			properties.put(OwlSettingsType.REFLEXIVE.toString(),"true");	    
			properties.put(OwlSettingsType.SWRL_RULES.toString(),"true");
			properties.put(OwlSettingsType.SYMMETRIC.toString(),"true");
			properties.put(OwlSettingsType.TRANSITIVE.toString(),"true");
			properties.put(OwlSettingsType.UFO_STRUCTURE.toString(),"true");		
			properties.put(OwlSettingsType.REASONER.toString(), OwlReasonerType.UNSELECTED.toString());
		}
	}
	
	public void setReasoner(OwlReasonerType reasoner){
		if(properties != null) properties.put(OwlSettingsType.REASONER.toString(), reasoner.toString());		
	}
	
	public void setValue(OwlSettingsType setting, Boolean value) {
		if(properties != null) properties.put(setting.toString(), value.toString());
	}
	
	public void setIRI(String iri){
		if(properties != null) properties.put(OwlSettingsType.ONTOLOGY_IRI.toString(),iri);
	}
		
	public OwlReasonerType getReasoner(){
		if(properties != null) return OwlReasonerType.getByName(((String)properties.get(OwlSettingsType.REASONER.toString())));
		return null;
	}
	
	public Boolean getValue(OwlSettingsType setting) {
		String str = (String)properties.get(setting.toString());
		if(properties != null) return Boolean.valueOf(str);
		else return null;
	}
	
	public String getIRI() {
		if(properties != null) return (String) properties.get(OwlSettingsType.ONTOLOGY_IRI.toString());
		else return null;
	}
			
	public boolean store(OutputStream out){
		if(properties != null) {			
			try {				
				properties.storeToXML(out, "Owl Settings File", "UTF-8");				
				return true;
			} catch (Exception ex) {}
		}		
		return false;
	}
	
	public boolean store(){
		if(properties != null) {
			File file = new File(Util.getCanonPath(dir, fileName));
			try {				
				FileOutputStream out = new FileOutputStream(file);
				properties.storeToXML(out, "Owl Settings File", "UTF-8");
				Util.close(out);
				return true;
			} catch (Exception ex) {}
		}		
		return false;
	}
	
	public Properties load(InputStream in){
		if(properties!=null) return properties;
		properties = new Properties();		
		try {
			properties.loadFromXML(in);											
		} catch (Exception ex) {}		
		if(properties.isEmpty()){
			setdefault();
		}
		return properties;
	}
	
	public Properties load() {
		if(properties!=null) return properties;
		properties = new Properties();		
		File file = new File(Util.getCanonPath(dir, fileName));
		if(file.exists()) {
			try {
				FileInputStream in = new FileInputStream(file);
				properties.loadFromXML(in);
				Util.close(in);								
			} catch (Exception ex) {}
		}		
		if(properties.isEmpty()){
			setdefault();
		}
		return properties;
	}
	
	public OwlAxiomsEnforcement getOwlAxiomsEnforcement() {			
		OwlAxiomsEnforcement opt = new OwlAxiomsEnforcement();
		opt.setAssociationDisjointness(getValue(OwlSettingsType.DISJOINTNESS_OF_ASSOCIATIONS));
		opt.setAsymmetric(getValue(OwlSettingsType.ASYMMETRIC));
		opt.setCardinality(getValue(OwlSettingsType.CARDINALITIES));
		opt.setClassCompleteness(getValue(OwlSettingsType.COMPLETENESS_OF_CLASSES));
		opt.setClassDisjointness(getValue(OwlSettingsType.DISJOINTNESS_OF_CLASSES));
		opt.setDomain(getValue(OwlSettingsType.DOMAIN));
		opt.setFunctional(getValue(OwlSettingsType.FUNCTIONAL));
		opt.setInverse(getValue(OwlSettingsType.INVERSE));
		opt.setInverseFunctional(getValue(OwlSettingsType.INVERSE_FUNCTIONAL));
		opt.setIrreflexive(getValue(OwlSettingsType.IRREFLEXIVE));
		opt.setRange(getValue(OwlSettingsType.RANGE));
		opt.setReflexive(getValue(OwlSettingsType.REFLEXIVE));
		opt.setSwrlRules(getValue(OwlSettingsType.SWRL_RULES));
		opt.setSymmetric(getValue(OwlSettingsType.SYMMETRIC));
		opt.setTransitive(getValue(OwlSettingsType.TRANSITIVE));
		opt.setUfoStructure(getValue(OwlSettingsType.UFO_STRUCTURE));
		opt.setComments(getValue(OwlSettingsType.COMMENTS));
		opt.setLabels(getValue(OwlSettingsType.LABELS));
		opt.setOwlReasoner(getOwlReasonerFromType(getReasoner()));
		return opt;
	}	
		
	private OwlReasoner getOwlReasonerFromType(OwlReasonerType type){
		if(type==OwlReasonerType.HERMIT) return OwlReasoner.Hermit;
		if(type==OwlReasonerType.PELLET) return OwlReasoner.Pellet;
		return OwlReasoner.Unselected;
	}
}
