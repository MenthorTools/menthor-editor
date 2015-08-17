package net.menthor.common.transformation;

import java.util.HashMap;
import java.util.Map.Entry;

public class MappingsEnforcement {

	private HashMap<Object, Object> primitiveMappings = new HashMap<Object, Object>();
	private HashMap<Object, Object> attributeMappings = new HashMap<Object, Object>();	
	private HashMap<Object, Object> qualityMappings = new HashMap<Object, Object>();	
	private Object[][] genSetMappings;
	
	public void setQualityMappings(HashMap<Object, Object> qualityMappings) 
	{
		for (Entry<Object, Object> entry : qualityMappings.entrySet()){
			this.qualityMappings.put(entry.getKey(),entry.getValue());
		}
	}
	
	public void setPrimitiveMappings(HashMap<Object, Object> primitiveMappings)
	{
		for (Entry<Object, Object> entry : primitiveMappings.entrySet()) {
			this.primitiveMappings.put(entry.getKey(),entry.getValue());
		}
	}
	
	public void setAttributeMappings(HashMap<Object, Object> attributeMappings) 
	{
		for (Entry<Object, Object> entry : attributeMappings.entrySet()) {
			this.attributeMappings.put(entry.getKey(),entry.getValue());
		}
	}	
	
	public void setGenSetMappings(Object[][] genSetMappings) 
	{
		this.genSetMappings = genSetMappings;
	}
	
	public Object[][] getGenSetMappings() { return genSetMappings; }	
	public HashMap<Object, Object> getAttributeMappings() { return attributeMappings; }
	public HashMap<Object, Object> getPrimitiveMappings() { return primitiveMappings; }
	public HashMap<Object, Object> getQualityMappings() { return qualityMappings; }
}
