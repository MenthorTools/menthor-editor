package net.menthor.editor.v2.elements;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.parser.OntoUMLNameHelper;

public class FoundElement {

	protected EObject eobject;
	
	protected String name;
	protected String path;
	protected String stereotype;
	protected List<EObject> pathHierarchyList = new ArrayList<EObject>();
	
	public FoundElement(EObject eobject){
		this.eobject = eobject;
		name = OntoUMLNameHelper.getName(eobject);
		path = getPath(eobject);
		stereotype = OntoUMLNameHelper.getTypeName(eobject);
	}
	
	public String getName() { return name; } 
	public String getType() { return stereotype; }
	public String getPath() { return path; }
	public List<EObject> getPathHierarchy() { return pathHierarchyList; }
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
