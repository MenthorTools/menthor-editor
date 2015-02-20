package net.menthor.ontouml2text.stringGenerator.patterns.naryPatterns;

import net.menthor.ontouml2text.descriptionSpace.DescriptionCategory;
import net.menthor.ontouml2text.stringGenerator.patterns.FormalPattern;
import net.menthor.ontouml2text.stringGenerator.patterns.NaryPattern;
import net.menthor.ontouml2text.stringGenerator.patterns.OptionalMultiplicityPattern;

public class OptionalFormalAssociationPattern extends NaryPattern implements
		FormalPattern, OptionalMultiplicityPattern {

	public OptionalFormalAssociationPattern(
			DescriptionCategory describedCategory) {
		super(describedCategory);
	}

}
