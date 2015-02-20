package net.menthor.ontouml2text.stringGenerator.patterns.naryPatterns;

import net.menthor.ontouml2text.descriptionSpace.DescriptionCategory;
import net.menthor.ontouml2text.stringGenerator.patterns.MediationPattern;
import net.menthor.ontouml2text.stringGenerator.patterns.NaryPattern;
import net.menthor.ontouml2text.stringGenerator.patterns.OptionalMultiplicityPattern;

public class OrdinaryOptionalMediationPattern extends NaryPattern implements MediationPattern, OptionalMultiplicityPattern {

	public OrdinaryOptionalMediationPattern(
			DescriptionCategory describedCategory) {
		super(describedCategory);
	}

}
