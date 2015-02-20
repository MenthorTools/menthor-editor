package net.menthor.ontouml2text.stringGenerator.patterns;

import java.util.ArrayList;
import java.util.List;

import net.menthor.ontouml2text.descriptionSpace.*;

public abstract class NaryPattern extends DescriptionPattern {
	private List<PatternCategory> targetCategories;
	
	public NaryPattern(DescriptionCategory describedCategory) {
		super(describedCategory);
		
		this.targetCategories = new ArrayList<PatternCategory>();
	}
	
	public List<PatternCategory> getTargetCategories() {
		return targetCategories;
	}

}
