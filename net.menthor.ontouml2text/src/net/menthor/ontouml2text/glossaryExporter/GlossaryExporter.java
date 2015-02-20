package net.menthor.ontouml2text.glossaryExporter;

import net.menthor.ontouml2text.descriptionSpace.DescriptionCategory;

public abstract class GlossaryExporter {
		
	public abstract void initilizeExportFile();
	
	public abstract void saveDescription(DescriptionCategory category, String description);
	
	public abstract void finalizeExportFile();
	
}
