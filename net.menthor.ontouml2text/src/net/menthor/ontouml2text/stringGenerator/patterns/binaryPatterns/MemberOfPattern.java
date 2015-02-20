package net.menthor.ontouml2text.stringGenerator.patterns.binaryPatterns;

import net.menthor.ontouml2text.descriptionSpace.DescriptionCategory;
import net.menthor.ontouml2text.stringGenerator.patterns.BinaryPattern;
import net.menthor.ontouml2text.stringGenerator.patterns.PartOfPattern;
import net.menthor.ontouml2text.stringGenerator.patterns.PatternCategory;

public class MemberOfPattern extends BinaryPattern implements PartOfPattern {

	public MemberOfPattern(DescriptionCategory describedCategory,
			PatternCategory targetCategory) {
		super(describedCategory, targetCategory);
	}

}
