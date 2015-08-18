package net.menthor.common.settings.owl;


public enum OWL2Approach {
	
	OOTOS("OTTOS","Static scenario where it is considered structured datatypes, cardinalities, transitivity of material and parthood relations "
	+ "(as SWRL rules) and disjointness between substance sortals."),		
				
	SIMPLE("Simple","Static scenario where domain entities are represented directly according to the OntoUML stereotypes."),
	
	REIFICATION("Reification","Static scenario where domain entities are represented in a reified way "
	+ "according to the OntoUML stereotypes. Although this mapping don't represent "
	+ "temporal aspects, it preserves ontologic aspects from the reference model, "
	+ "such as concept hierarchy."),
	
	WORM_VIEW_A0("Worm View 0","Dynamic scenario where individual concepts are represented with "
	+ "its complete temporal slices. In this transformation all the "
	+ "information about the domain is on the temporal slices."),
	
	WORM_VIEW_A1("Worm View 1","Dynamic scenario where the individual's necessary and immutable properties "
	+ "are represented (those that exists while the individual exist). In this "
	+ "transformation type is considered only the relations that imply in mutual "
	+ "existential dependency."),		
		
	WORM_VIEW_A2("Worm View 2","Dynamic scenario where the individual's necessary and immutable properties are "
	+ "represented (those that exists while the individual exist). In this transformation, "
	+ "relations that imply in unilateral existential depedency are interpreted as valid "
	+ "only during the dependee existence."),
	
	UFO_RDF("UFO/RDF","Should be more of a description here...");		
	
	private String description;
	private String name;
	
	OWL2Approach(String name, String description)
	{
		this.description = description;
		this.name = name;
	}

	public String getDescription() { return description; }
	public String getName() { return name; }
	
	public static OWL2Approach getByName(String name){
		if(OOTOS.getName().compareToIgnoreCase(name)==0) return OOTOS;
		if(SIMPLE.getName().compareToIgnoreCase(name)==0) return SIMPLE;
		if(REIFICATION.getName().compareToIgnoreCase(name)==0) return REIFICATION;
		if(WORM_VIEW_A0.getName().compareToIgnoreCase(name)==0) return WORM_VIEW_A0;
		if(WORM_VIEW_A1.getName().compareToIgnoreCase(name)==0) return WORM_VIEW_A1;
		if(WORM_VIEW_A2.getName().compareToIgnoreCase(name)==0) return WORM_VIEW_A2;
		if(UFO_RDF.getName().compareToIgnoreCase(name)==0) return UFO_RDF;
		return null;
	}
	
	public String toString(){
		return getName();
	}
	
	public static void main (String args[])
	{
		for(OWL2Approach c: OWL2Approach.values()){
			System.out.println(c);
		}
	}
}
