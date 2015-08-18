package net.menthor.editor.v2.settings.owl;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.menthor.common.transformation.GenSetMappingType;
import net.menthor.common.transformation.OwlAxiomsEnforcement;
import net.menthor.common.transformation.OwlReasoner;
import net.menthor.common.transformation.QualityMappingType;

import net.menthor.editor.v2.util.Directories;
import net.menthor.editor.v2.util.Util;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.Classifier;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;

public final class OwlSettingsMap {
	
	//INSTANCE
	private static OwlSettingsMap instance = new OwlSettingsMap();	
	public static OwlSettingsMap getInstance() { return instance; }
	
	//XML FILE
	private String fileName = "owl-cnf.xml";
	public String getFileName(){ return fileName; }
	
	//PROPERTIES MAP
	private Properties properties=null;
	private String dir = Directories.getTempDir();
		
	//======================================================
	//CONSTRUCTOR & INITIALIZER
	//======================================================
	
	private OwlSettingsMap() {
		setdefault();
	}
	
	private void setdefault(){
		if(properties==null) properties = new Properties();
		if(properties!=null && properties.isEmpty()){
			properties.put(OwlAxiomsType.ONTOLOGY_IRI.toString(), "http://www.menthor.net/myontology");
			properties.put(OwlAxiomsType.ASYMMETRIC.toString(),"true");
			properties.put(OwlAxiomsType.CARDINALITIES.toString(),"true");
			properties.put(OwlAxiomsType.COMMENTS.toString(),"true");
			properties.put(OwlAxiomsType.COMPLETENESS_OF_CLASSES.toString(),"true");
			properties.put(OwlAxiomsType.DISJOINTNESS_OF_CLASSES.toString(),"true");
			properties.put(OwlAxiomsType.DISJOINTNESS_OF_ASSOCIATIONS.toString(),"true");		
			properties.put(OwlAxiomsType.DOMAIN.toString(),"true");
			properties.put(OwlAxiomsType.FUNCTIONAL.toString(),"true");
			properties.put(OwlAxiomsType.INVERSE.toString(),"true");
			properties.put(OwlAxiomsType.INVERSE_FUNCTIONAL.toString(),"true");	    
			properties.put(OwlAxiomsType.IRREFLEXIVE.toString(),"true");
			properties.put(OwlAxiomsType.LABELS.toString(),"true");	    
			properties.put(OwlAxiomsType.RANGE.toString(),"true");
			properties.put(OwlAxiomsType.REFLEXIVE.toString(),"true");	    
			properties.put(OwlAxiomsType.SWRL_RULES.toString(),"true");
			properties.put(OwlAxiomsType.SYMMETRIC.toString(),"true");
			properties.put(OwlAxiomsType.TRANSITIVE.toString(),"true");
			properties.put(OwlAxiomsType.UFO_STRUCTURE.toString(),"true");		
			properties.put(OwlAxiomsType.REASONER.toString(), OwlReasonerType.UNSELECTED.toString());
		}
	}
	
	//======================================================
	//ENTRY: {OWL AXIOMS TYPE, VALUE}
	//======================================================
	
	public void setReasoner(OwlReasonerType reasoner){
		if(properties != null) properties.put(OwlAxiomsType.REASONER.toString(), reasoner.toString());		
	}
	
	public void setValue(OwlAxiomsType setting, Boolean value) {
		if(properties != null) properties.put(setting.toString(), value.toString());
	}
	
	public void setIRI(String iri){
		if(properties != null) properties.put(OwlAxiomsType.ONTOLOGY_IRI.toString(),iri);
	}
		
	public OwlReasonerType getReasoner(){
		if(properties != null) return OwlReasonerType.getByName(((String)properties.get(OwlAxiomsType.REASONER.toString())));
		return null;
	}
	
	public Boolean getValue(OwlAxiomsType setting) {
		String str = (String)properties.get(setting.toString());
		if(properties != null) return Boolean.valueOf(str);
		else return null;
	}
	
	public String getIRI() {
		if(properties != null) return (String) properties.get(OwlAxiomsType.ONTOLOGY_IRI.toString());
		else return null;
	}
	
	//==============================================================
	//ENTRY: {PRIMITIVE-UUID, OWL DATA TYPE}
	//ENTRY: {ATTRIBUTE-UUID, OWL DATA TYPE}
	//==============================================================
	
	public void setOwlDatatype(RefOntoUML.Element elem, OWL2Datatype owlDt){
		if(properties != null) {
			properties.put(OntoUMLParser.getUUIDFromElement(elem), owlDt.toString());
		}
	}
	
	public OWL2Datatype getOwlDatatype(RefOntoUML.Element elem){
		if(properties != null) return OWL2Datatype.valueOf((String)properties.get(OntoUMLParser.getUUIDFromElement(elem)));
		return null;
	}
	
	/** This method returns all (stored) mappings of model primitiveTypes and attributes into owl dataTypes */
	public Map<RefOntoUML.Element, OWL2Datatype> getOwlDatatypes(OntoUMLParser refparser){
		Map<RefOntoUML.Element, OWL2Datatype> result = new HashMap<RefOntoUML.Element, OWL2Datatype>();
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);			
			if(pt!=null && (pt instanceof RefOntoUML.PrimitiveType || pt instanceof RefOntoUML.Property)) {
				OWL2Datatype owlDt = OWL2Datatype.valueOf((String)properties.get(key));
				result.put(pt,owlDt);
			}
		}
		return result;
	}
	
	//==============================================================
	//ENTRY: {QUALITY-UUID. OWL QUALITY MAPPING TYPE}
	//==============================================================
	
	public void setOwlQualityMappingType(RefOntoUML.Element elem, QualityMappingType q){
		if(properties != null) {
			properties.put(OntoUMLParser.getUUIDFromElement(elem), q.toString());
		}
	}
	
	public QualityMappingType getOwlQualityMappingType(RefOntoUML.Element elem){
		if(properties != null) return QualityMappingType.getByName((String)properties.get(OntoUMLParser.getUUIDFromElement(elem)));
		return null;
	}
	
	/** This method returns all (stored) mappings of model qualities into owl quality mapping types */
	public Map<RefOntoUML.Element, QualityMappingType> getOwlQualityMappingTypes(OntoUMLParser refparser){
		Map<RefOntoUML.Element, QualityMappingType> result = new HashMap<RefOntoUML.Element, QualityMappingType>();
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);			
			if(pt!=null && (pt instanceof Classifier) && refparser.isQuality((Classifier)pt)) {
				QualityMappingType owlDt = QualityMappingType.getByName((String)properties.get(key));
				result.put(pt,owlDt);
			}
		}
		return result;
	}
	
	//==============================================================
	//ENTRY: {GENSET-UUID, OWL GENSET MAPPING TYPE + "@" + CHOICE}
	//==============================================================
		
	public void setOwlGenSetMappingType(RefOntoUML.Element elem, GenSetMappingType q, Boolean choice){
		if(properties != null) {
			properties.put(OntoUMLParser.getUUIDFromElement(elem), q.toString()+"@"+choice);
		}
	}
	
	public GenSetMappingType getOwlGenSetMappingType(RefOntoUML.Element elem){		
		if(properties != null) {
			String value = (String)properties.get(OntoUMLParser.getUUIDFromElement(elem));
			return GenSetMappingType.getByName(value.split("@")[0]);
		}
		return null;
	}
	
	public Boolean getOwlGenSetChoice(RefOntoUML.Element elem){
		if(properties != null) {
			String value = (String)properties.get(OntoUMLParser.getUUIDFromElement(elem));
			return Boolean.parseBoolean(value.split("@")[1]);
		}
		return null;
	}
	
	/** This method returns all (stored) mappings of model genSets into owl genSet mapping types */
	public Map<RefOntoUML.Element, GenSetMappingType> getOwlGenSetMappingTypes(OntoUMLParser refparser){
		Map<RefOntoUML.Element, GenSetMappingType> result = new HashMap<RefOntoUML.Element, GenSetMappingType>();
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);			
			if(pt!=null && (pt instanceof GeneralizationSet)) {
				String value = ((String)properties.get(key));
				if(value.contains("@")){
					GenSetMappingType owlDt = GenSetMappingType.getByName(value.split("@")[0]);
					result.put(pt,owlDt);
				}
			}
		}
		return result;
	}
	
	/** This method returns all (stored) mappings of model genSets into boolean choices */
	public Map<RefOntoUML.Element, Boolean> getOwlGenSetChoices(OntoUMLParser refparser){
		Map<RefOntoUML.Element, Boolean> result = new HashMap<RefOntoUML.Element, Boolean>();
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);			
			if(pt!=null && (pt instanceof GeneralizationSet)) {
				String value = ((String)properties.get(key));
				if(value.contains("@")){
					Boolean owlDt = Boolean.parseBoolean(value.split("@")[1]);
					result.put(pt,owlDt);
				}
			}
		}
		return result;
	}
	
	//======================================================
	//SERIALIZATION
	//======================================================
	
	public boolean store(OutputStream out){
		if(properties != null) {			
			try {				
				properties.storeToXML(out, "Owl Settings File", "UTF-8");				
				return true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
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
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}		
		return false;
	}
	
	public Properties load(InputStream in){
		if(properties==null) properties = new Properties();		
		try {
			properties.loadFromXML(in);											
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
		if(properties.isEmpty()){
			setdefault();
		}
		return properties;
	}
	
	public Properties load() {
		if(properties==null) properties = new Properties();		
		File file = new File(Util.getCanonPath(dir, fileName));
		if(file.exists()) {
			try {
				FileInputStream in = new FileInputStream(file);
				properties.loadFromXML(in);
				Util.close(in);								
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}		
		if(properties.isEmpty()){
			setdefault();
		}
		return properties;
	}
	
	//====================================================================
	//Each Owl transformation has different parameters as arguments. They are
	//based on the OwlAxiomsEnforcement class and the OwlReasoner enum.
	//That's why we need these methods, to pass the correct parameter to a given
	//Owl transformation.
	//====================================================================
	
	public OwlAxiomsEnforcement getOwlAxiomsEnforcement() {			
		OwlAxiomsEnforcement opt = new OwlAxiomsEnforcement();
		opt.setAssociationDisjointness(getValue(OwlAxiomsType.DISJOINTNESS_OF_ASSOCIATIONS));
		opt.setAsymmetric(getValue(OwlAxiomsType.ASYMMETRIC));
		opt.setCardinality(getValue(OwlAxiomsType.CARDINALITIES));
		opt.setClassCompleteness(getValue(OwlAxiomsType.COMPLETENESS_OF_CLASSES));
		opt.setClassDisjointness(getValue(OwlAxiomsType.DISJOINTNESS_OF_CLASSES));
		opt.setDomain(getValue(OwlAxiomsType.DOMAIN));
		opt.setFunctional(getValue(OwlAxiomsType.FUNCTIONAL));
		opt.setInverse(getValue(OwlAxiomsType.INVERSE));
		opt.setInverseFunctional(getValue(OwlAxiomsType.INVERSE_FUNCTIONAL));
		opt.setIrreflexive(getValue(OwlAxiomsType.IRREFLEXIVE));
		opt.setRange(getValue(OwlAxiomsType.RANGE));
		opt.setReflexive(getValue(OwlAxiomsType.REFLEXIVE));
		opt.setSwrlRules(getValue(OwlAxiomsType.SWRL_RULES));
		opt.setSymmetric(getValue(OwlAxiomsType.SYMMETRIC));
		opt.setTransitive(getValue(OwlAxiomsType.TRANSITIVE));
		opt.setUfoStructure(getValue(OwlAxiomsType.UFO_STRUCTURE));
		opt.setComments(getValue(OwlAxiomsType.COMMENTS));
		opt.setLabels(getValue(OwlAxiomsType.LABELS));
		opt.setOwlReasoner(getOwlReasonerFromType(getReasoner()));
		return opt;
	}	
		
	private OwlReasoner getOwlReasonerFromType(OwlReasonerType type){
		if(type==OwlReasonerType.HERMIT) return OwlReasoner.Hermit;
		if(type==OwlReasonerType.PELLET) return OwlReasoner.Pellet;
		return OwlReasoner.Unselected;
	}
}
