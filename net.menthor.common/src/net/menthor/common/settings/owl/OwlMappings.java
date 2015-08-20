package net.menthor.common.settings.owl;

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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.Element;

public class OwlMappings {

	private HashMap<Element, OWL2Datatype> primitiveMap = new HashMap<Element, OWL2Datatype>();
	private HashMap<Element, OWL2Datatype> attributeMap = new HashMap<Element, OWL2Datatype>();	
	private HashMap<Element, OWL2Quality> qualityMap = new HashMap<Element, OWL2Quality>();	
	private Object[][] genSetMap;
	
	public HashMap<Element, OWL2Datatype> getAttributes() { return attributeMap; }
	public HashMap<Element, OWL2Datatype> getPrimitives() { return primitiveMap; }
	public HashMap<Element, OWL2Quality> getQualities() { return qualityMap; }
	public Object[][] getGeneralizationSets() { return genSetMap; }
	
	public void setQualities(Map<Element, OWL2Quality> qualityMappings){
		for (Entry<Element, OWL2Quality> entry : qualityMappings.entrySet()){
			this.qualityMap.put(entry.getKey(),entry.getValue());
		}
	}
	
	public void setPrimitives(Map<Element, OWL2Datatype> primitiveMappings){
		for (Entry<Element, OWL2Datatype> entry : primitiveMappings.entrySet()) {
			this.primitiveMap.put(entry.getKey(),entry.getValue());
		}
	}
	
	public void setAttributes(Map<Element, OWL2Datatype> attributeMappings){
		for (Entry<Element, OWL2Datatype> entry : attributeMappings.entrySet()) {
			this.attributeMap.put(entry.getKey(),entry.getValue());
		}
	}	
	
	public void setGeneralizationSets(Object[][] genSetMappings){ 
		this.genSetMap = genSetMappings;
	}

}
