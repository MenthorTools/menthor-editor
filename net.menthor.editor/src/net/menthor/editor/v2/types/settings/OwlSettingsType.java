package net.menthor.editor.v2.types.settings;

import java.io.Serializable;

public enum OwlSettingsType implements Serializable {

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
	REASONER("");
	
	private String description;

	OwlSettingsType(String value)
	{
		this.description = value;
	}

	public String getDescription() { return description; }

	public static void main (String args[])
	{
		for(OwlSettingsType c: OwlSettingsType.values()){
			System.out.println(c);
		}
	}
}
