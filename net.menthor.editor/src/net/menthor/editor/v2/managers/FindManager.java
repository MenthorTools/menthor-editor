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

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.OccurenceMap;
import org.tinyuml.umldraw.shared.BaseConnection;

import RefOntoUML.NamedElement;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.element.FoundElement;
import net.menthor.editor.v2.ui.controller.ProjectController;
import net.menthor.editor.v2.ui.util.DiagramListDialog;

public class FindManager extends AbstractManager {

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
		if(element instanceof DefaultMutableTreeNode)
			refElem = (RefOntoUML.Element)((DefaultMutableTreeNode) element).getUserObject();
		else if(element instanceof BaseConnection)
			refElem = ((BaseConnection) element).getRelationship();
		else if(element instanceof ClassElement)
			refElem = ((ClassElement) element).getClassifier();
		else if(element instanceof RefOntoUML.Element) 
			refElem = (RefOntoUML.Element)element;
		else if(element instanceof FoundElement) 
			refElem = (RefOntoUML.Element)((FoundElement)element).getElement();	
		
		List<OntoumlDiagram> diagrams = OccurenceMap.get().getDiagrams(refElem);
		DiagramListDialog.open(frame(), listener(), diagrams);
	}
	
	/** select occurrence of this element in the project tree
	 *  method called from Diagram and Find Tab
	 * */
	public void findInProjectTree(Object element){
		RefOntoUML.Element refElem = null;		
		if(element instanceof BaseConnection)
			refElem = ((BaseConnection) element).getRelationship();
		else if(element instanceof ClassElement)
			refElem = ((ClassElement) element).getClassifier();
		else if(element instanceof RefOntoUML.Element)
			refElem = (RefOntoUML.Element)element;
		else if(element instanceof FoundElement) 
			refElem = (RefOntoUML.Element)((FoundElement)element).getElement();		
		browser().getTree().checkObject(refElem);
	}
	
	public List<FoundElement> findByName(String text){		
		List<FoundElement> result = new ArrayList<FoundElement>();
		OntoUMLParser refparser = ProjectController.get().getProject().getRefParser();
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
