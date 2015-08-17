package net.menthor.common.transformation;

import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;

public class MappingsEnforcement {

	private HashMap<EObject, Object> primitiveMappings = new HashMap<EObject, Object>();
	private HashMap<EObject, Object> attributeMappings = new HashMap<EObject, Object>();	
	private HashMap<EObject, Object> qualityMappings = new HashMap<EObject, Object>();	
	private Object[][] genSetMappings;
	
	public void setQualityMappings(HashMap<RefOntoUML.Element, Object> qualityMappings) 
	{
		for (Entry<RefOntoUML.Element, Object> entry : qualityMappings.entrySet()){
			this.qualityMappings.put(entry.getKey(),entry.getValue());
		}
	}
	
	public void setPrimitiveMappings(HashMap<RefOntoUML.Element, Object> primitiveMappings)
	{
		for (Entry<RefOntoUML.Element, Object> entry : primitiveMappings.entrySet()) {
			this.primitiveMappings.put(entry.getKey(),entry.getValue());
		}
	}
	
	public void setAttributeMappings(HashMap<RefOntoUML.Element, Object> attributeMappings) 
	{
		for (Entry<RefOntoUML.Element, Object> entry : attributeMappings.entrySet()) {
			this.attributeMappings.put(entry.getKey(),entry.getValue());
		}
	}	
	
	public void setGenSetMappings(Object[][] genSetMappings) 
	{
		this.genSetMappings = genSetMappings;
	}
	
	public Object[][] getGenSetMappings() { return genSetMappings; }	
	public HashMap<EObject, Object> getAttributeMappings() { return attributeMappings; }
	public HashMap<EObject, Object> getPrimitiveMappings() { return primitiveMappings; }
	public HashMap<EObject, Object> getQualityMappings() { return qualityMappings; }
}
