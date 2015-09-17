package net.menthor.editor.finder;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.parser.OntoUMLNameHelper;

public class FoundElement {

	protected EObject eobject;
	
	protected String name;
	protected String path;
	protected String stereotype;
	protected ArrayList<EObject> pathHierarchyList = new ArrayList<EObject>();
	
	public FoundElement(EObject eobject){
		this.eobject = eobject;
		name = OntoUMLNameHelper.getName(eobject);
		path = getPath(eobject);
		stereotype = OntoUMLNameHelper.getTypeName(eobject);
	}
	
	public String getName() { return name; } 
	public String getType() { return stereotype; }
	public String getPath() { return path; }
	public ArrayList<EObject> getPathHierarchy() { return pathHierarchyList; }
	public EObject getElement() { return eobject; }
	
	private String getPath (EObject e){
		String path = "";				
		if (e.eContainer()!=null) {
			path += getPath((e.eContainer()))+"::";				
		}
		path += OntoUMLNameHelper.getName(e)+"";
		pathHierarchyList.add(e);
		return path;
	}	
}
