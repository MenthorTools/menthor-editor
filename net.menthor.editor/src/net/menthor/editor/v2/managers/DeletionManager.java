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

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.DeleteElementCommand;
import org.tinyuml.ui.diagram.commands.DeleteGeneralizationSetCommand;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.Element;
import RefOntoUML.GeneralizationSet;
import net.menthor.editor.ui.Models;
import net.menthor.editor.v2.OclDocument;

public class DeletionManager extends BaseManager {
		
	// -------- Lazy Initialization
	
	private static class DeletionLoader {
        private static final DeletionManager INSTANCE = new DeletionManager();
    }	
	public static DeletionManager get() { 
		return DeletionLoader.INSTANCE; 
	}	
    private DeletionManager() {
        if (DeletionLoader.INSTANCE != null) throw new IllegalStateException("DeletionManager already instantiated");
    }		
    
    // ----------------------------
	    
	public boolean confirmElementDeletion(Component parentWindow){
		return MessageManager.get().confirm(parentWindow, "Delete Element",
			"WARNING - Are you sure you want to delete the selected items from the model \n"
					+ "and from all the diagrams they might appear?");
	}
	
	public boolean confirmDiagramDeletion(Component parentWindow){
		return MessageManager.get().confirm(parentWindow,"Delete Diagram", 
			"WARNING - Are you sure you want to delete this diagram?\nThis action CANNOT be undone.");
	}
	
	public boolean confirmOclDocDeletion(Component parentWindow){
		return MessageManager.get().confirm(parentWindow,"Delete Ocl Document", 
			"WARNING - Are you sure you want to delete this document?\nThis action CANNOT be undone.");
	}
	
	public GeneralizationSet confirmGenSetDeletion(Component parentWindow, List<GeneralizationSet> genSets){
		return (GeneralizationSet) MessageManager.get().input(
			parentWindow,
			"Delete Generalization Set",
			"Which generalization set do you want to delete?",			 
			genSets.toArray(), 
			genSets.toArray()[0]
		);
	}
	
	/** Delete any elements from the application, whether diagrams, documents, elements or from diagrma selection */
	public void delete(List<Object> elements){
		for(Object o: elements){
			delete(o);
		}
	}
	
	/** Delete any element from the application, whether a diagram, document, element or from selection. */
	public void delete(Object input){
		Object elem = input;
		
		if(input instanceof DefaultMutableTreeNode){
			elem = ((DefaultMutableTreeNode) elem).getUserObject();
		}
		
		if (elem instanceof StructureDiagram){
			deleteDiagram((StructureDiagram)elem, true);    					
		} 
		else if (elem instanceof OclDocument){
			deleteOclDocument((OclDocument)elem, true);    					
		}
		else if (elem instanceof RefOntoUML.Element){				
			deleteElement((RefOntoUML.Element)elem,true);    					    					
		} else{ 
			TabManager.get().getCurrentDiagramEditor().deleteSelection(elem);
		}
	}
	
	/** Delete Ocl document from the browser, tab pane and application */
	public void deleteOclDocument(OclDocument doc, boolean showwarning){
		boolean response = true;
		if (showwarning) response = confirmOclDocDeletion(frame());		
		if(response) {
			Models.getOclDocList().remove(doc);
			TabManager.get().removeEditor(doc);		
			tree().removeCurrentNode();
		}
	}
	
	public void deleteDiagram(StructureDiagram diagram, boolean showwarning){
		boolean response = true;
		if (showwarning) response = confirmDiagramDeletion(frame());		
		if(response){
			eraseAllElements(diagram);
			ProjectManager.get().getProject().getDiagrams().remove(diagram);
			TabManager.get().removeEditor(diagram);
			tree().removeCurrentNode();
		}	
	}

	/** Delete element from the model and every diagram in each it appears. */
	public void deleteElement(RefOntoUML.Element element, boolean showwarning){	
		boolean response = true;
		if(showwarning) response = confirmElementDeletion(frame());		
		if(response) {		
			List<RefOntoUML.Element> list = new ArrayList<RefOntoUML.Element>();
			list.add(element);
			deleteElements(list);
		}
	}
	
	/** Delete elements from the model and from every diagram they might appear. 
	 *  It shows a message before deletion. */
	public void deleteElements(Collection<DiagramElement> diagramElements, boolean showmessage){	
		List<RefOntoUML.Element> list = (List<Element>) OccurenceManager.get().getElements(diagramElements);
		boolean response = true;
		if(showmessage) response = confirmElementDeletion(frame());
		if(response) deleteElements(list);		
	}
	
	/** Delete element from the model and from every diagram they might appear. **/
	public void deleteElements(List<RefOntoUML.Element> elements){
		
		HashSet<Element> dependencies = new HashSet<Element>();
		
		//if element is a Class or a Datatype, adds all connections attached to it to the deletion list
		for (Element element : elements) {
			dependencies.addAll(Models.getRefparser().getDirectRelationships(element));
		}
		
		elements.addAll(dependencies);
		
		List<DiagramEditor> editors = OccurenceManager.get().getDiagramEditors(elements.get(0));		
		for(DiagramEditor ed: editors){
			if(elements.size()==1 && elements.get(0) instanceof GeneralizationSet){
				new DeleteGeneralizationSetCommand(ed, elements.get(0)).run();
			}else{
				new DeleteElementCommand(ed, elements, true, true).run();
			}
		}
		if(editors==null || editors.size()==0) {
			if(elements.size()==1 && elements.get(0) instanceof GeneralizationSet){
				new DeleteGeneralizationSetCommand(null, elements.get(0)).run();
			}else{
				new DeleteElementCommand(null, elements, true, false).run();
			}
		}
	}
	
	/** Erase element from a particular diagram. It does not delete the element from the model. */
	public void eraseElement(DiagramEditor ed, RefOntoUML.Element element){		
		if(element instanceof GeneralizationSet) return;
		if(element instanceof Constraintx) return;
		if(element instanceof Comment) return;
		List<RefOntoUML.Element> list = new ArrayList<RefOntoUML.Element>();
		list.add(element);
		new DeleteElementCommand(ed,list,false,true).run();				
	}
	
	/** Delete all elements at the diagram */
	public void eraseAllElements(StructureDiagram diagram){
		DiagramEditor ed = TabManager.get().getDiagramEditor(diagram);
		for(DiagramElement delem: diagram.getChildren()) {
			if(delem instanceof ClassElement) eraseElement(ed,((ClassElement)delem).getClassifier());
			if(delem instanceof AssociationElement) eraseElement(ed,((AssociationElement)delem).getRelationship());
			if(delem instanceof GeneralizationElement) eraseElement(ed,((GeneralizationElement)delem).getRelationship());
		}
	}
	
	/** Delete a generalization set from a list of selected diagram elements */
	public void deleteGeneralizationSet(DiagramEditor d, List<DiagramElement> selectedElements){	
		List<GeneralizationSet> genSets = d.getGeneralizationSets(selectedElements);
		if(genSets.size()==0) return;
		if(genSets.size()==1){
			deleteElement(genSets.get(0),true);
		}else{
			GeneralizationSet chosen = confirmGenSetDeletion(frame(), genSets);
			if(chosen!=null) deleteElement(chosen,true);
		}			
	}
}
