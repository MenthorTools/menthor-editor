package net.menthor.ontouml2text.stringGenerator.patterns.unaryPatterns;

import java.util.ArrayList;
import java.util.List;

import net.menthor.ontouml2text.descriptionSpace.CategoryAttribute;
import net.menthor.ontouml2text.descriptionSpace.DescriptionCategory;
import net.menthor.ontouml2text.stringGenerator.patterns.UnaryPattern;

public class AttributePattern extends UnaryPattern {
	
	private List<CategoryAttribute> attributes;

	public AttributePattern(DescriptionCategory describedCategory) {
		super(describedCategory);	
		
		attributes = new ArrayList<CategoryAttribute>();
	}
	
	public List<CategoryAttribute> getAttributes() {
		return attributes;
	}

}
