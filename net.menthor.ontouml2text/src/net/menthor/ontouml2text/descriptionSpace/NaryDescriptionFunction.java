package net.menthor.ontouml2text.descriptionSpace;


public abstract class NaryDescriptionFunction extends DescriptionFunction {

	public NaryDescriptionFunction(DescriptionCategory target,
			int targetMinMultiplicity, 
			int targetMaxMultiplicity) {
		super(target, targetMinMultiplicity, targetMaxMultiplicity);
	}

}
