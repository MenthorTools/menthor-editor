package net.menthor.common.transformation;

import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.util.RefOntoUMLElement;

public class MappingsEnforcement {

	private HashMap<EObject, Object> primitiveMappings = new HashMap<EObject, Object>();
	private HashMap<EObject, Object> attributeMappings = new HashMap<EObject, Object>();	
	private HashMap<EObject, Object> qualityMappings = new HashMap<EObject, Object>();	
	private Object[][] genSetMappings;
	
	public void setQualityMappings(HashMap<RefOntoUMLElement, Object> qualityMappings) 
	{
		for (Entry<RefOntoUMLElement, Object> entry : qualityMappings.entrySet()){
			this.qualityMappings.put(entry.getKey().getElement(),entry.getValue());
		}
	}
	
	public void setPrimitiveMappings(HashMap<RefOntoUMLElement, Object> primitiveMappings)
	{
		for (Entry<RefOntoUMLElement, Object> entry : primitiveMappings.entrySet()) {
			this.primitiveMappings.put(entry.getKey().getElement(),entry.getValue());
		}
	}
	
	public void setAttributeMappings(HashMap<RefOntoUMLElement, Object> attributeMappings) 
	{
		for (Entry<RefOntoUMLElement, Object> entry : attributeMappings.entrySet()) {
			this.attributeMappings.put(entry.getKey().getElement(),entry.getValue());
		}
	}	
	
	public void setGenSetMappings(Object[][] genSetMappings) 
	{
		this.genSetMappings = genSetMappings;
	}
	
	public Object[][] getGenSetMappings() { return genSetMappings; }	
	public HashMap<EObject, Object> getAttributeMappings() { return attributeMappings; }
	public HashMap<EObject, Object> getPrimitiveMappings() { return primitiveMappings; }
}
