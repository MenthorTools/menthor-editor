package net.menthor.common.transformation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import net.menthor.common.settings.owl.OWL2Quality;
import RefOntoUML.Element;

public class MappingsEnforcement {

	private HashMap<Element, OWL2Datatype> primitiveMappings = new HashMap<Element, OWL2Datatype>();
	private HashMap<Element, OWL2Datatype> attributeMappings = new HashMap<Element, OWL2Datatype>();	
	private HashMap<Element, OWL2Quality> qualityMappings = new HashMap<Element, OWL2Quality>();	
	private Object[][] genSetMappings;
	
	public void setQualityMappings(Map<Element, OWL2Quality> qualityMappings) 
	{
		for (Entry<Element, OWL2Quality> entry : qualityMappings.entrySet()){
			this.qualityMappings.put(entry.getKey(),entry.getValue());
		}
	}
	
	public void setPrimitiveMappings(Map<Element, OWL2Datatype> primitiveMappings)
	{
		for (Entry<Element, OWL2Datatype> entry : primitiveMappings.entrySet()) {
			this.primitiveMappings.put(entry.getKey(),entry.getValue());
		}
	}
	
	public void setAttributeMappings(Map<Element, OWL2Datatype> attributeMappings) 
	{
		for (Entry<Element, OWL2Datatype> entry : attributeMappings.entrySet()) {
			this.attributeMappings.put(entry.getKey(),entry.getValue());
		}
	}	
	
	public void setGenSetMappings(Object[][] genSetMappings) 
	{
		this.genSetMappings = genSetMappings;
	}
	
	public Object[][] getGenSetMappings() { return genSetMappings; }	
	public HashMap<Element, OWL2Datatype> getAttributeMappings() { return attributeMappings; }
	public HashMap<Element, OWL2Datatype> getPrimitiveMappings() { return primitiveMappings; }
	public HashMap<Element, OWL2Quality> getQualityMappings() { return qualityMappings; }
}
