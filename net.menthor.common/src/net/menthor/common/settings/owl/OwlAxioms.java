package net.menthor.common.settings.owl;

import java.util.HashMap;
import java.util.Map;

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

public class OwlAxioms {
	
	private String ontologyIri = new String();
	private Map<OWL2Axiom, Boolean> axiomsMap = new HashMap<OWL2Axiom, Boolean>();
	private OWL2Reasoner owlReasoner = OWL2Reasoner.UNSELECTED;
	
	public OwlAxioms(){
		axiomsMap.put(OWL2Axiom.ASYMMETRIC,false);
		axiomsMap.put(OWL2Axiom.CARDINALITIES,false);
		axiomsMap.put(OWL2Axiom.COMMENTS,false);
		axiomsMap.put(OWL2Axiom.COMPLETENESS_OF_CLASSES,false);
		axiomsMap.put(OWL2Axiom.DISJOINTNESS_OF_ASSOCIATIONS,false);
		axiomsMap.put(OWL2Axiom.DISJOINTNESS_OF_CLASSES,false);
		axiomsMap.put(OWL2Axiom.DOMAIN,false);
		axiomsMap.put(OWL2Axiom.FUNCTIONAL,false);
		axiomsMap.put(OWL2Axiom.INVERSE,false);
		axiomsMap.put(OWL2Axiom.INVERSE_FUNCTIONAL,false);
		axiomsMap.put(OWL2Axiom.IRREFLEXIVE,false);
		axiomsMap.put(OWL2Axiom.LABELS,false);
		axiomsMap.put(OWL2Axiom.RANGE,false);
		axiomsMap.put(OWL2Axiom.REFLEXIVE,false);
		axiomsMap.put(OWL2Axiom.SWRL_RULES,false);
		axiomsMap.put(OWL2Axiom.SYMMETRIC,false);
		axiomsMap.put(OWL2Axiom.TRANSITIVE,false);
		axiomsMap.put(OWL2Axiom.UFO_STRUCTURE,false);
		axiomsMap.put(OWL2Axiom.OBJ_PROP_BY_ENDS,false);
	}

	public void setValue(OWL2Axiom axiom, Boolean value) { 
		if(axiom!=OWL2Axiom.REASONER && axiom!=OWL2Axiom.ONTOLOGY_IRI)
			axiomsMap.put(axiom, value);		
	}
	
	public void setReasoner(OWL2Reasoner reasoner) { 
		this.owlReasoner=reasoner;		
	}
	
	public void setIRI(String ontologyIri) { 
		this.ontologyIri=ontologyIri;		
	}
	
	public String getIRI() { 
		return ontologyIri;		
	}
	
	public OWL2Reasoner getReasoner() {
		return owlReasoner;
	}
	
	public Boolean getValue(OWL2Axiom axiom) { 
		if(axiom!=OWL2Axiom.REASONER && axiom!=OWL2Axiom.ONTOLOGY_IRI)	
			return axiomsMap.get(axiom);
		return null;
	}
}
