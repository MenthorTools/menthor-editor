package net.menthor.ontouml2text.stringGenerator.patterns;

import net.menthor.ontouml2text.descriptionSpace.DescriptionCategory;

public abstract class DescriptionPattern {
	private DescriptionCategory describedCategory;
	
	public DescriptionPattern(DescriptionCategory describedCategory){
		this.describedCategory = describedCategory;
	}
	
	public DescriptionCategory getDescribedCategory() {
		return describedCategory;
	}
	
}
