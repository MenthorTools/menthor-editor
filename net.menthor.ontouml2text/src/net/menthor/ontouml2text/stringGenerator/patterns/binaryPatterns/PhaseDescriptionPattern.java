package net.menthor.ontouml2text.stringGenerator.patterns.binaryPatterns;

import net.menthor.ontouml2text.descriptionSpace.DescriptionCategory;
import net.menthor.ontouml2text.stringGenerator.patterns.BinaryPattern;
import net.menthor.ontouml2text.stringGenerator.patterns.PatternCategory;
import net.menthor.ontouml2text.stringGenerator.patterns.PhasePattern;

public class PhaseDescriptionPattern extends BinaryPattern implements PhasePattern {

	public PhaseDescriptionPattern(DescriptionCategory describedCategory,
			PatternCategory targetCategory) {
		super(describedCategory, targetCategory);
	}

}
