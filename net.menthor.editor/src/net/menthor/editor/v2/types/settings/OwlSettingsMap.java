package net.menthor.editor.v2.types.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import net.menthor.editor.v2.util.Directories;
import net.menthor.editor.v2.util.Util;

public final class OwlSettingsMap {
	
	private static OwlSettingsMap instance = new OwlSettingsMap();	
	public static OwlSettingsMap getInstance() { return instance; }
	
	private Properties properties=null;
	private String fileName = "owlcnf.xml";
	private String dir = Directories.getTempDir();
	
	private OwlSettingsMap() {
		load();
		store();
	}
	
//	public void setReasoner(OwlReasonerType reasoner){
//		Properties properties = load();
//		if(properties != null) properties.put(OwlSettingsType.REASONER, reasoner);		
//	}
//	
//	public void setValue(OwlSettingsType setting, Boolean value) {
//		Properties properties = load();
//		if(properties != null) properties.put(setting, value);
//	}
//	
//	public void setIRI(String iri){
//		Properties properties = load();
//		if(properties != null) properties.put(OwlSettingsType.ONTOLOGY_IRI,iri);
//	}
//		
//	public OwlReasonerType getReasoner(){
//		Properties properties = load();
//		if(properties != null) return (OwlReasonerType)properties.get(OwlSettingsType.REASONER);
//		return null;
//	}
//	
//	public Boolean getValue(OwlSettingsType setting) {
//		Properties properties = load();
//		if(properties != null) return (Boolean)properties.get(setting);
//		else return null;
//	}
//	
//	public String getIRI() {
//		Properties properties = load();
//		if(properties != null) return (String) properties.get(OwlSettingsType.ONTOLOGY_IRI);
//		else return null;
//	}
			
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
			properties.put(OwlSettingsType.ONTOLOGY_IRI.toString(), "http://www.menthor.net/your_ontology");
			properties.put(OwlSettingsType.ASYMMETRIC.toString(),true);
			properties.put(OwlSettingsType.CARDINALITIES.toString(),true);
			properties.put(OwlSettingsType.COMMENTS.toString(),true);				
			properties.put(OwlSettingsType.COMPLETENESS_OF_CLASSES.toString(),true);
			properties.put(OwlSettingsType.DISJOINTNESS_OF_ASSOCIATIONS.toString(),true);		
			properties.put(OwlSettingsType.DISJOINTNESS_OF_CLASSES.toString(),true);
			properties.put(OwlSettingsType.DISJOINTNESS_OF_OBJECT_PROPERTIES.toString(),true);		
			properties.put(OwlSettingsType.DOMAIN.toString(),true);
			properties.put(OwlSettingsType.FUNCTIONAL.toString(),true);
			properties.put(OwlSettingsType.INVERSE.toString(),true);
			properties.put(OwlSettingsType.INVERSE_FUNCTIONAL.toString(),true);	    
			properties.put(OwlSettingsType.IRREFLEXIVE.toString(),true);
			properties.put(OwlSettingsType.LABELS.toString(),true);	    
			properties.put(OwlSettingsType.RANGE.toString(),true);
			properties.put(OwlSettingsType.REFLEXIVE.toString(),true);	    
			properties.put(OwlSettingsType.SWRL_RULES.toString(),true);
			properties.put(OwlSettingsType.SYMMETRIC.toString(),true);
			properties.put(OwlSettingsType.TRANSITIVE.toString(),true);
			properties.put(OwlSettingsType.UFO_STRUCTURE.toString(),true);		
			properties.put(OwlSettingsType.REASONER.toString(), OwlReasonerType.UNSELECTED.toString());
		}
		return properties;
	}	
}
