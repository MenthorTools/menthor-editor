package org.tinyuml.umldraw;

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

import java.util.List;

import org.tinyuml.umldraw.shared.UmlDiagramElement;

public class MultiElementHelper {
	
	protected List<UmlDiagramElement> elements;
	
	public MultiElementHelper(List<UmlDiagramElement> elements) {
		this.elements = elements;
	}
	
	public boolean hasAssociation(){
		for (UmlDiagramElement element : elements) {
			if(element instanceof AssociationElement)
				return true;
		}
		return false;
	}
	
	public boolean hasGeneralization(){
		for (UmlDiagramElement element : elements) {
			if(element instanceof GeneralizationElement)
				return true;
		}
		return false;
	}
	
	public boolean hasClass(){
		for (UmlDiagramElement element : elements) {
			if(element instanceof ClassElement)
				return true;
		}
		return false;
	}
	
	public boolean onlyGeneralizations(){
		for (UmlDiagramElement element : elements) {
			if(!(element instanceof GeneralizationElement))
				return false;
		}
		return true;
	}
	
	public boolean isSingleContext(){
		return elements.size()==1;
	}

	public boolean hasConnection() {
		return hasAssociation() || hasGeneralization();
	}
}
