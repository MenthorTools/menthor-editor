package net.menthor.editor.v2.managers;

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

import RefOntoUML.NamedElement;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.Models;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.elements.FoundElement;
import net.menthor.editor.v2.ui.DiagramListDialog;

public class FindManager extends BaseManager {

	// -------- Lazy Initialization

	private static class FindLoader {
        private static final FindManager INSTANCE = new FindManager();
    }	
	public static FindManager get() { 
		return FindLoader.INSTANCE; 
	}	
    private FindManager() {
        if (FindLoader.INSTANCE != null) throw new IllegalStateException("FindManager already instantiated");
    }		
    
    // ----------------------------
    
	/** show dialog with diagram occurrence of this element */
	public void findInDiagrams(Object element){
		RefOntoUML.Element refElem = null;
		if(element instanceof RefOntoUML.Element) refElem = (RefOntoUML.Element)element;
		if(element instanceof FoundElement) refElem = (RefOntoUML.Element)((FoundElement)element).getElement();
		List<OntoumlDiagram> diagrams = OccurenceManager.get().getDiagrams(refElem);
		DiagramListDialog.open(frame(), diagrams);		
	}
	
	/** select occurence of this element in the project tree*/
	public void findInProjectTree(Object element){
		RefOntoUML.Element refElem = null;
		if(element instanceof RefOntoUML.Element) refElem = (RefOntoUML.Element)element;
		if(element instanceof FoundElement) refElem = (RefOntoUML.Element)((FoundElement)element).getElement();
		tree().checkElement(refElem);
	}
	
	public List<FoundElement> findByName(String text){		
		List<FoundElement> result = new ArrayList<FoundElement>();
		OntoUMLParser refparser = Models.getRefparser();
		if(refparser!=null && text!=null /*&& !text.isEmpty()*/){
			for(EObject eobj: refparser.getAllInstances(EObject.class)){
				if (eobj instanceof NamedElement){
					String name = ((NamedElement)eobj).getName();
					if(name!=null){
						if(text.trim().isEmpty()) result.add(new FoundElement(eobj));
						else {
							if(name.trim().toLowerCase().compareToIgnoreCase(text)==0) result.add(new FoundElement(eobj));
							else if(name.trim().toLowerCase().contains(text.toLowerCase().trim())) result.add(new FoundElement(eobj));
						}
						
					}
				}
			}
		}		
		return result;
	}
}
