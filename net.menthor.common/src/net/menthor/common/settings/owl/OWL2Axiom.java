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

import java.io.Serializable;

public enum OWL2Axiom implements Serializable {

	ONTOLOGY_IRI("The IRI of the ontology"),	
	DISJOINTNESS_OF_CLASSES(""),
	DISJOINTNESS_OF_ASSOCIATIONS(""),
	COMPLETENESS_OF_CLASSES(""),
	DOMAIN(""),
	RANGE(""),
	INVERSE(""),
	REFLEXIVE(""),
	IRREFLEXIVE(""),
	SYMMETRIC(""),
	ASYMMETRIC(""),
	TRANSITIVE(""),
	FUNCTIONAL(""),
	INVERSE_FUNCTIONAL(""),
	SWRL_RULES("Rules written in SWRL"),	
	CARDINALITIES(""),	
	UFO_STRUCTURE(""),	
	LABELS(""),
	COMMENTS(""),
	REASONER("The reasoner used to run inferences"),
	OBJ_PROP_BY_ENDS("");
		
	private String description;

	OWL2Axiom(String value)
	{
		this.description = value;
	}

	public String getDescription() { return description; }

	public static void main (String args[])
	{
		for(OWL2Axiom c: OWL2Axiom.values()){
			System.out.println(c);
		}
	}
}
