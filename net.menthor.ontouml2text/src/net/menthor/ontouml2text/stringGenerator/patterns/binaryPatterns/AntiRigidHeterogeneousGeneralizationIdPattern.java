package net.menthor.ontouml2text.stringGenerator.patterns.binaryPatterns;

import net.menthor.ontouml2text.descriptionSpace.DescriptionCategory;
import net.menthor.ontouml2text.stringGenerator.patterns.BinaryPattern;
import net.menthor.ontouml2text.stringGenerator.patterns.GeneralizationPattern;
import net.menthor.ontouml2text.stringGenerator.patterns.PatternCategory;

public class AntiRigidHeterogeneousGeneralizationIdPattern extends BinaryPattern 
	implements GeneralizationPattern{

	public AntiRigidHeterogeneousGeneralizationIdPattern(
			DescriptionCategory describedCategory,
			PatternCategory targetCategory) {
		super(describedCategory, targetCategory);
	}

}
