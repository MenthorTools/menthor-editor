package net.menthor.ontouml2text.descriptionSpace.descriptionFunctions;

import net.menthor.ontouml2text.descriptionSpace.BinaryDescriptionFunction;
import net.menthor.ontouml2text.descriptionSpace.DescriptionCategory;

public class Material extends BinaryDescriptionFunction {

	public Material(String label, 
			DescriptionCategory source,
			DescriptionCategory target, 
			int sourceMinMultiplicity,
			int sourceMaxMultiplicity, 
			int targetMinMultiplicity,
			int targetMaxMultiplicity) {
		super(label, source, target, sourceMinMultiplicity, sourceMaxMultiplicity,
				targetMinMultiplicity, targetMaxMultiplicity);
	}	

}
