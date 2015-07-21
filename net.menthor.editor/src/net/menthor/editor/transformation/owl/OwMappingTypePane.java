package net.menthor.editor.transformation.owl;

import net.menthor.common.transformation.MappingType;
import net.menthor.editor.transformation.MappingTypePane;

public class OwMappingTypePane extends MappingTypePane {

	private static final long serialVersionUID = -4968883469407719592L;
	
	public OwMappingTypePane()
	{
		super();
		MappingType mt = new MappingType(
			"SIMPLE",
			"Simple",
			"Static scenario where domain entities are represented "
			+ "directly according to the OntoUML stereotypes."
		);		
		addEntry(mt);
		
		mt = new MappingType(
			"OOTOS",
			"OOTOS",
			"Static scenario where it is considered structured datatypes, cardinalities, transitivity of material and parthood relations "
			+ "(as SWRL rules) and disjointness between substance sortals."
		);		
		addEntry(mt);
		selectEntry(mt.getIdentifier());
		
		mt = new MappingType(
			"REIFICATION",
			"Reification",
			"Static scenario where domain entities are represented in a reified way "
			+ "according to the OntoUML stereotypes. Although this mapping don't represent "
			+ "temporal aspects, it preserves ontologic aspects from the reference model, "
			+ "such as concept hierarchy."
		);		
		addEntry(mt);
			
		mt = new MappingType(
			"WORM_VIEW_A0",
			"Worm View A0",
			"Dynamic scenario where individual concepts are represented with "
			+ "its complete temporal slices. In this transformation all the "
			+ "information about the domain is on the temporal slices."
		);		
		addEntry(mt);
				
		mt = new MappingType(
			"WORM_VIEW_A1",
			"Worm View A1",
			"Dynamic scenario where the individual's necessary and immutable properties "
			+ "are represented (those that exists while the individual exist). In this "
			+ "transformation type is considered only the relations that imply in mutual "
			+ "existential dependency."
		);		
		addEntry(mt);
		
		mt = new MappingType(
			"WORM_VIEW_A2",
			"Worm View A2",
			"Dynamic scenario where the individual's necessary and immutable properties are "
			+ "represented (those that exists while the individual exist). In this transformation, "
			+ "relations that imply in unilateral existential depedency are interpreted as valid "
			+ "only during the dependee existence."
		);		
		addEntry(mt);
		
//		mt = new MappingType(
//			"UFO_RDF",
//			"UFO/RDF",
//			"(No Description)"
//		);		
//		addEntry(mt);		
	}
}