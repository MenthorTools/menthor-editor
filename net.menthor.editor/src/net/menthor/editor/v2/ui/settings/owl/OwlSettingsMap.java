package net.menthor.editor.v2.ui.settings.owl;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.menthor.common.settings.owl.OWL2Approach;
import net.menthor.common.settings.owl.OWL2Axiom;
import net.menthor.common.settings.owl.OWL2Destination;
import net.menthor.common.settings.owl.OWL2GeneralizationSet;
import net.menthor.common.settings.owl.OWL2Quality;
import net.menthor.common.settings.owl.OWL2Reasoner;
import net.menthor.common.settings.owl.OwlAxioms;
import net.menthor.common.settings.owl.OwlMappings;
import net.menthor.common.settings.owl.OwlOptions;
import net.menthor.editor.v2.util.DirectoryUtil;
import net.menthor.editor.v2.util.Util;
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
	private String dir = DirectoryUtil.getTempDir();
		
	//======================================================
	//CONSTRUCTOR & INITIALIZER
	//======================================================
	
	private OwlSettingsMap() {
		setdefault();
	}
	
	private void setdefault(){
		if(properties==null) properties = new Properties();
		if(properties!=null && properties.isEmpty()){
			properties.put(OWL2Axiom.ONTOLOGY_IRI.toString(), "http://www.menthor.net/myontology");
			properties.put(OWL2Axiom.ASYMMETRIC.toString(),"true");
			properties.put(OWL2Axiom.CARDINALITIES.toString(),"true");
			properties.put(OWL2Axiom.COMMENTS.toString(),"true");
			properties.put(OWL2Axiom.COMPLETENESS_OF_CLASSES.toString(),"true");
			properties.put(OWL2Axiom.DISJOINTNESS_OF_CLASSES.toString(),"true");
			properties.put(OWL2Axiom.DISJOINTNESS_OF_ASSOCIATIONS.toString(),"true");		
			properties.put(OWL2Axiom.DOMAIN.toString(),"true");
			properties.put(OWL2Axiom.FUNCTIONAL.toString(),"true");
			properties.put(OWL2Axiom.INVERSE.toString(),"true");
			properties.put(OWL2Axiom.INVERSE_FUNCTIONAL.toString(),"true");	    
			properties.put(OWL2Axiom.IRREFLEXIVE.toString(),"true");
			properties.put(OWL2Axiom.LABELS.toString(),"true");	    
			properties.put(OWL2Axiom.RANGE.toString(),"true");
			properties.put(OWL2Axiom.REFLEXIVE.toString(),"true");	    
			properties.put(OWL2Axiom.SWRL_RULES.toString(),"true");
			properties.put(OWL2Axiom.SYMMETRIC.toString(),"true");
			properties.put(OWL2Axiom.TRANSITIVE.toString(),"true");
			properties.put(OWL2Axiom.UFO_STRUCTURE.toString(),"true");		
			properties.put(OWL2Axiom.REASONER.toString(), OWL2Reasoner.UNSELECTED.toString());			
			properties.put("APPROACH", OWL2Approach.OOTOS.toString());
			properties.put("DESTINATION", OWL2Destination.TAB.toString());
		}
	}
	
	//======================================================
	//ENTRY: {OWL2DESTINATION, VALUE + "@" + "FILE-PATH" (if any) }
	//======================================================
	
	public void setDestination(OWL2Destination dest, String path){		
		if(properties != null) {
			if(dest.equals(OWL2Destination.FILE) && path!=null) properties.put("DESTINATION", dest.toString()+"@"+path);
			else properties.put("DESTINATION", dest.toString());
		}
	}
	
	public OWL2Destination getDestination(){
		if(properties != null) {
			String value = (String)properties.get("DESTINATION");
			if(value.contains("@")) value = value.split("@")[0];
			return OWL2Destination.getByName(value);
		}
		return null;		
	}

	public String getPath(){
		if(properties != null) {
			String value = (String)properties.get("DESTINATION");
			if(value.contains("@")) {
				value = value.split("@")[1];
				return value;
			}
		}
		return null;		
	}
	
	//======================================================
	//ENTRY: {OWL2Approach, VALUE}
	//======================================================
	
	public void setApproach(OWL2Approach approach){
		if(properties != null) properties.put("APPROACH", approach.toString());
	}
	
	public OWL2Approach getApproach(){
		if(properties != null) return OWL2Approach.getByName(((String)properties.get("APPROACH")));
		return null;		
	}
	
	//======================================================
	//ENTRY: {OWL2AXIOM, VALUE}
	//======================================================
	
	public void setReasoner(OWL2Reasoner reasoner){
		if(properties != null) properties.put(OWL2Axiom.REASONER.toString(), reasoner.toString());		
	}
	
	public void setValue(OWL2Axiom setting, Boolean value) {
		if(properties != null) properties.put(setting.toString(), value.toString());
	}
	
	public void setIRI(String iri){
		if(properties != null) properties.put(OWL2Axiom.ONTOLOGY_IRI.toString(),iri);
	}
		
	public OWL2Reasoner getReasoner(){
		if(properties != null) return OWL2Reasoner.getByName(((String)properties.get(OWL2Axiom.REASONER.toString())));
		return null;
	}
	
	public Boolean getValue(OWL2Axiom setting) {
		String str = (String)properties.get(setting.toString());
		if(properties != null) return Boolean.valueOf(str);
		else return null;
	}
	
	public String getIRI() {
		if(properties != null) return (String) properties.get(OWL2Axiom.ONTOLOGY_IRI.toString());
		else return null;
	}
	
	//==============================================================
	public void eraseMappings(OntoUMLParser refparser){
		ArrayList<String> toRemove = new ArrayList<String>();
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);
			if(pt != null){
				toRemove.add((String) key);
			}
		}
		for (String key : toRemove) {
			properties.remove(key);
		}
	}
	
	//==============================================================
	//ENTRY: {PRIMITIVE-UUID, OWL2DATATYPE}
	//ENTRY: {ATTRIBUTE-UUID, OWL2DATATYPE}
	//==============================================================
	
	public void setOwl2Datatype(RefOntoUML.Element elem, String owlDt){
		if(properties != null) {
			properties.put(OntoUMLParser.getUUIDFromElement(elem), owlDt);
		}
	}
	
	public String getOwl2Datatype(RefOntoUML.Element elem){
		if(properties != null) return (String)properties.get(OntoUMLParser.getUUIDFromElement(elem));
		return null;
	}
	
	/** This method returns all (stored) mappings of model primitiveTypes and attributes into owl dataTypes */
	public Map<RefOntoUML.Element, String> getOwl2Datatypes(OntoUMLParser refparser){
		Map<RefOntoUML.Element, String> result = new HashMap<RefOntoUML.Element, String>();
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);			
			if(pt!=null && (pt instanceof RefOntoUML.DataType || pt instanceof RefOntoUML.Property)) {
				String owlDt = (String)properties.get(key);
				result.put(pt,owlDt);
			}
		}
		return result;
	}
	
	/** This method returns all (stored) mappings of model primitiveTypes into owl dataTypes */
	public Map<RefOntoUML.Element, String> getOwl2Primitive(OntoUMLParser refparser){
		Map<RefOntoUML.Element, String> result = new HashMap<RefOntoUML.Element, String>();
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);			
			if(pt!=null && (pt instanceof RefOntoUML.DataType)) {
				String owlDt = (String)properties.get(key);
				result.put(pt,owlDt);
			}
		}
		return result;
	}
	
	/** This method returns all (stored) mappings of model attributes into owl dataTypes */
	public Map<RefOntoUML.Element, String> getOwl2Attribute(OntoUMLParser refparser){
		Map<RefOntoUML.Element, String> result = new HashMap<RefOntoUML.Element, String>();
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);			
			if(pt!=null && (pt instanceof RefOntoUML.Property)) {
				String owlDt = (String)properties.get(key);
				result.put(pt,owlDt);
			}
		}
		return result;
	}
	
	//==============================================================
	//ENTRY: {QUALITY-UUID. OWL2QUALITY}
	//==============================================================
	
	public void setOwl2Quality(RefOntoUML.Element elem, OWL2Quality q){
		if(properties != null) {
			properties.put(OntoUMLParser.getUUIDFromElement(elem), q.toString());
		}
	}
	
	public OWL2Quality getOwl2Quality(RefOntoUML.Element elem){
		if(properties != null) return OWL2Quality.getByName((String)properties.get(OntoUMLParser.getUUIDFromElement(elem)));
		return null;
	}
	
	/** This method returns all (stored) mappings of model qualities into owl quality mapping types */
	public Map<RefOntoUML.Element, OWL2Quality> getOwl2Quality(OntoUMLParser refparser){
		Map<RefOntoUML.Element, OWL2Quality> result = new HashMap<RefOntoUML.Element, OWL2Quality>();
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);			
			if(pt!=null && (pt instanceof Classifier) && refparser.isQuality((Classifier)pt)) {
				OWL2Quality owlDt = OWL2Quality.getByName((String)properties.get(key));
				result.put(pt,owlDt);
			}
		}
		return result;
	}
	
	//==============================================================
	//ENTRY: {GENSET-UUID, OWL2GENSET + "@" + BOOLEAN-CHOICE}
	//==============================================================
		
	public void setOwl2GenSet(RefOntoUML.Element elem, OWL2GeneralizationSet q, Boolean choice){
		if(properties != null) {
			properties.put(OntoUMLParser.getUUIDFromElement(elem), q.toString()+"@"+choice);
		}
	}
	
	public OWL2GeneralizationSet getOwl2GenSet(RefOntoUML.Element elem){		
		if(properties != null) {
			String value = (String)properties.get(OntoUMLParser.getUUIDFromElement(elem));
			return OWL2GeneralizationSet.getByName(value.split("@")[0]);
		}
		return null;
	}
	
	public Boolean getOwl2GenSetChoice(RefOntoUML.Element elem){
		if(properties != null) {
			String value = (String)properties.get(OntoUMLParser.getUUIDFromElement(elem));
			return Boolean.parseBoolean(value.split("@")[1]);
		}
		return null;
	}
	
	/** This method returns all (stored) mappings of model genSets into owl genSet mapping types */
	public Map<RefOntoUML.Element, OWL2GeneralizationSet> getOwl2GenSets(OntoUMLParser refparser){
		Map<RefOntoUML.Element, OWL2GeneralizationSet> result = new HashMap<RefOntoUML.Element, OWL2GeneralizationSet>();
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);			
			if(pt!=null && (pt instanceof GeneralizationSet)) {
				String value = ((String)properties.get(key));
				if(value.contains("@")){
					OWL2GeneralizationSet owlDt = OWL2GeneralizationSet.getByName(value.split("@")[0]);
					result.put(pt,owlDt);
				}
			}
		}
		return result;
	}
	
	/** This method returns all (stored) mappings of model genSets into boolean choices */
	public Map<RefOntoUML.Element, Boolean> getOwl2GenSetChoices(OntoUMLParser refparser){
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
	
	/** This method returns all (stored) mappings of model genSets in a matrix of 3 columns */
	public Object[][] getOwl2GenSetsAsMatrix(OntoUMLParser refparser){
		int size = getOwl2GenSets(refparser).size();
		Object[][] map = new Object[size][3];
		int i=0;
		for(Object key: properties.keySet()){
			RefOntoUML.Element pt = OntoUMLParser.getElementByUUID(refparser.getModel(), (String)key);			
			if(pt!=null && (pt instanceof GeneralizationSet)) {
				String value = ((String)properties.get(key));
				if(value.contains("@")){
					OWL2GeneralizationSet owlDt = OWL2GeneralizationSet.getByName(value.split("@")[0]);
					Boolean choice = Boolean.parseBoolean(value.split("@")[1]);
					map[i][0] = pt;
					map[i][1] = owlDt;
					map[i][2] = choice;
					i++;
				}
			}
		}
		return map;
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
	//based on the OwlOption class.That's why we need these methods below, 
	//to pass the correct parameter to a given Owl transformation.
	//====================================================================
	
	public OwlOptions getOwlOptions(OntoUMLParser refparser){		
		OwlOptions transOpt = new OwlOptions(getApproach(),getDestination(),getPath());		    		    		
		transOpt.setOwlAxioms(getOwlAxioms());		
		OwlMappings mappings = new OwlMappings();
		mappings.setAttributes(getOwl2Attribute(refparser));
		mappings.setGeneralizationSets(getOwl2GenSetsAsMatrix(refparser));										
		mappings.setPrimitives(getOwl2Primitive(refparser));										
		mappings.setQualities(getOwl2Quality(refparser));		
		transOpt.setOwlMappings(mappings);
		return transOpt;
	}
	
	private OwlAxioms getOwlAxioms() {			
		OwlAxioms opt = new OwlAxioms();		
		opt.setIRI(getIRI());
		opt.setValue(OWL2Axiom.DISJOINTNESS_OF_ASSOCIATIONS, getValue(OWL2Axiom.DISJOINTNESS_OF_ASSOCIATIONS));
		opt.setValue(OWL2Axiom.ASYMMETRIC, getValue(OWL2Axiom.ASYMMETRIC));
		opt.setValue(OWL2Axiom.CARDINALITIES, getValue(OWL2Axiom.CARDINALITIES));
		opt.setValue(OWL2Axiom.COMPLETENESS_OF_CLASSES, getValue(OWL2Axiom.COMPLETENESS_OF_CLASSES));
		opt.setValue(OWL2Axiom.DISJOINTNESS_OF_CLASSES, getValue(OWL2Axiom.DISJOINTNESS_OF_CLASSES));
		opt.setValue(OWL2Axiom.DOMAIN, getValue(OWL2Axiom.DOMAIN));
		opt.setValue(OWL2Axiom.FUNCTIONAL, getValue(OWL2Axiom.FUNCTIONAL));
		opt.setValue(OWL2Axiom.INVERSE, getValue(OWL2Axiom.INVERSE));
		opt.setValue(OWL2Axiom.INVERSE_FUNCTIONAL, getValue(OWL2Axiom.INVERSE_FUNCTIONAL));
		opt.setValue(OWL2Axiom.IRREFLEXIVE, getValue(OWL2Axiom.IRREFLEXIVE));
		opt.setValue(OWL2Axiom.RANGE, getValue(OWL2Axiom.RANGE));
		opt.setValue(OWL2Axiom.REFLEXIVE, getValue(OWL2Axiom.REFLEXIVE));
		opt.setValue(OWL2Axiom.SWRL_RULES, getValue(OWL2Axiom.SWRL_RULES));
		opt.setValue(OWL2Axiom.SYMMETRIC, getValue(OWL2Axiom.SYMMETRIC));
		opt.setValue(OWL2Axiom.TRANSITIVE, getValue(OWL2Axiom.TRANSITIVE));
		opt.setValue(OWL2Axiom.UFO_STRUCTURE, getValue(OWL2Axiom.UFO_STRUCTURE));
		opt.setValue(OWL2Axiom.COMMENTS, getValue(OWL2Axiom.COMMENTS));
		opt.setValue(OWL2Axiom.LABELS, getValue(OWL2Axiom.LABELS));
		opt.setValue(OWL2Axiom.OBJ_PROP_BY_ENDS, getValue(OWL2Axiom.OBJ_PROP_BY_ENDS));
		opt.setReasoner(getReasoner());
		return opt;
	}
}
