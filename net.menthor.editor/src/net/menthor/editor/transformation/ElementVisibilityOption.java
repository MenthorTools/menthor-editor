package net.menthor.editor.transformation;

public class ElementVisibilityOption {

	private boolean hideClasses=false;
	private boolean hideDataTypes=false;
	private boolean hideAssociations=false;
	private boolean hideAttributes=false;
	private boolean hideEnds=false;
	private boolean hideProperties=false;
	private boolean hideGeneralizations=false;
	
	public void hideAll() 
	{ 
		hideClasses=true;
		hideDataTypes=true;
		hideAssociations=true;
		hideAttributes=true;
		hideEnds=true;
		hideProperties=true;
		hideGeneralizations=true;
	}
	
	public void showAll() 
	{ 
		hideClasses=false;
		hideDataTypes=false;
		hideAssociations=false;
		hideAttributes=false;
		hideEnds=false;
		hideProperties=false;
		hideGeneralizations=false;
	}
	
	public boolean isHiddenGeneralizations() { return hideGeneralizations; }
	public boolean isHiddenProperties() { return hideProperties; }
	public boolean isHiddenEnds() { return hideEnds; }
	public boolean isHiddenAttributes() { return hideAttributes; }
	public boolean isHiddenAssociations() { return hideAssociations; }
	public boolean isHiddenDataTypes() { return hideDataTypes; }
	public boolean isHiddenClasses() { return hideClasses; }
	
	public void hideClasses() { hideClasses=true; }
	public void hideDataTypes() { hideDataTypes=true; }
	public void hideAssociations() { hideAssociations=true; }
	public void hideAttributes() { hideAttributes=true; }
	public void hideEnds() { hideEnds=true; }
	public void hideProperties() { hideProperties=true; }
	public void hideGeneralizations() { hideGeneralizations=true; }
	
	public void showClasses() { hideClasses=false; }
	public void showDataTypes() { hideDataTypes=false; }
	public void showAssociations() { hideAssociations=false; }
	public void showAttributes() { hideAttributes=false; }
	public void showEnds() { hideEnds=false; }
	public void showProperties() { hideProperties=false; }
	public void showGeneralizations() { hideGeneralizations=false; }
	
}
