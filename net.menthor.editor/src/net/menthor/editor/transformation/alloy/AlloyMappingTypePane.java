package net.menthor.editor.transformation.alloy;

import net.menthor.common.transformation.MappingType;
import net.menthor.editor.transformation.MappingTypePane;

public class AlloyMappingTypePane extends MappingTypePane {

	private static final long serialVersionUID = -4968883469407719592L;
	
	public AlloyMappingTypePane()
	{
		super();
		MappingType mt = new MappingType(
			"Branching",
			"Branching World",			
			"Branching scenario where worlds states are ordered as a tree with branches towards the future "+
			"capturing that the future may unfold in different ways, where no joining branches are allowed. "+
			"In this approach, classes are Alloy binary relations between worlds and objects whilst relationships "+
			"are Alloy ternary/4-ary relations indexed by worlds."			
		);
		addEntry(mt);
	}
}