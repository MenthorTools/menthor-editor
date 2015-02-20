package net.menthor.ontouml2text.descriptionSpace.descriptionFunctions;

import net.menthor.ontouml2text.descriptionSpace.DescriptionCategory;

public class SubquantityOf extends PartOf {

	public SubquantityOf(String label, 
			DescriptionCategory source,
			DescriptionCategory target, 
			int sourceMinMultiplicity,
			int sourceMaxMultiplicity, 
			int targetMinMultiplicity,
			int targetMaxMultiplicity, 
			boolean essencial, 
			boolean inseparable,
			boolean shareable) {
		super(label, source, target, sourceMinMultiplicity, sourceMaxMultiplicity,
				targetMinMultiplicity, targetMaxMultiplicity, essencial, inseparable,
				shareable);
	}

}
