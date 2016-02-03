package net.menthor.editor.v2.menu;

import java.util.ArrayList;

import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

public class MultiElementHelper {
	
	ArrayList<UmlDiagramElement> elements;
	
	public MultiElementHelper(ArrayList<UmlDiagramElement> elements) {
		this.elements = elements;
	}
	
	boolean hasAssociation(){
		for (UmlDiagramElement element : elements) {
			if(element instanceof AssociationElement)
				return true;
		}
		return false;
	}
	
	boolean hasGeneralization(){
		for (UmlDiagramElement element : elements) {
			if(element instanceof GeneralizationElement)
				return true;
		}
		return false;
	}
	
	boolean hasClass(){
		for (UmlDiagramElement element : elements) {
			if(element instanceof ClassElement)
				return true;
		}
		return false;
	}
	
	boolean onlyGeneralizations(){
		for (UmlDiagramElement element : elements) {
			if(!(element instanceof GeneralizationElement))
				return false;
		}
		return true;
	}
	
	boolean isSimpleContext(){
		return elements.size()==1;
	}

	public boolean hasConnection() {
		return hasAssociation() || hasGeneralization();
	}
}
