package net.menthor.editor.transformation;

public class FilterOptions {

	private boolean disableClasses=false;
	private boolean disableDataTypes=false;
	private boolean disableAssociations=false;
	private boolean disableAttributes=false;
	private boolean disableEnds=false;
	private boolean disableProperties=false;
	private boolean disableGeneralizations=false;
	
	public void enableAll() 
	{ 
		disableClasses=false;
		disableDataTypes=false;
		disableAssociations=false;
		disableAttributes=false;
		disableEnds=false;
		disableProperties=false;
		disableGeneralizations=false;
	}
	
	public boolean isDisabledGeneralizations() { return disableGeneralizations; }
	public boolean isDisabledProperties() { return disableProperties; }
	public boolean isDisabledEnds() { return disableEnds; }
	public boolean isDisabledAttributes() { return disableAttributes; }
	public boolean isDisabledAssociations() { return disableAssociations; }
	public boolean isDisabledDataTypes() { return disableDataTypes; }
	public boolean isDisabledClasses() { return disableClasses; }
	
	public void disableClasses() { disableClasses=true; }
	public void disableDataTypes() { disableDataTypes=true; }
	public void disableAssociations() { disableAssociations=true; }
	public void disableAttributes() { disableAttributes=true; }
	public void disableEnds() { disableEnds=true; }
	public void disableProperties() { disableProperties=true; }
	public void disableGeneralizations() { disableGeneralizations=true; }
	
	public void enableClasses() { disableClasses=false; }
	public void enableDataTypes() { disableDataTypes=false; }
	public void enableAssociations() { disableAssociations=false; }
	public void enableAttributes() { disableAttributes=false; }
	public void enableEnds() { disableEnds=false; }
	public void enableProperties() { disableProperties=false; }
	public void enableGeneralizations() { disableGeneralizations=false; }
	
}
