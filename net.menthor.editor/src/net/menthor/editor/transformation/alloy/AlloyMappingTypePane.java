package net.menthor.editor.transformation.alloy;

import net.menthor.editor.transformation.MappingType;
import net.menthor.editor.transformation.MappingTypePane;

public class AlloyMappingTypePane extends MappingTypePane {

	private static final long serialVersionUID = -4968883469407719592L;
	
	public AlloyMappingTypePane()
	{
		super();
		MappingType mt = new MappingType(
			"Branching",
			"Branching World",
			"(No Description)"
		);
		addEntry(mt);
	}
}