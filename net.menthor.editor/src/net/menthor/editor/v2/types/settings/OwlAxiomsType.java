package net.menthor.editor.v2.types.settings;

import java.io.Serializable;

public enum OwlAxiomsType implements Serializable {

	ONTOLOGY_IRI(""),	
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
	SWRL_RULES(""),	
	CARDINALITIES(""),	
	UFO_STRUCTURE(""),	
	LABELS(""),
	COMMENTS(""),
	REASONER(""),
	ASSOC_NAME_BY_ENDS("");	
	
	private String description;

	OwlAxiomsType(String value)
	{
		this.description = value;
	}

	public String getDescription() { return description; }

	public static void main (String args[])
	{
		for(OwlAxiomsType c: OwlAxiomsType.values()){
			System.out.println(c);
		}
	}
}
