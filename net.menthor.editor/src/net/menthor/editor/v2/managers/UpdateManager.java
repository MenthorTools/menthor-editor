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

import javax.swing.SwingUtilities;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.AddGeneralizationSetCommand;
import org.tinyuml.ui.diagram.commands.AddNodeCommand;
import org.tinyuml.ui.diagram.commands.DiagramNotification;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.ui.Models;

public class UpdateManager extends BaseManager {

	// -------- Lazy Initialization
	
	private static class UpdateLoader {
        private static final UpdateManager INSTANCE = new UpdateManager();
    }	
	public static UpdateManager get() { 
		return UpdateLoader.INSTANCE; 
	}	
    private UpdateManager() {
        if (UpdateLoader.INSTANCE != null) throw new IllegalStateException("UpdateManager already instantiated");
    }		
    
    // ----------------------------
	
	/** Causes redraw of the corresponding diagram element */
	public void notifyChange(RefOntoUML.Element element){
		for(DiagramEditor diagramEditor: OccurenceManager.get().getDiagramEditors(element)){
			notifyChange(element,diagramEditor);
		}
	}
	
	/** Causes redraw of the corresponding diagram element */
	public void notifyChange(RefOntoUML.Element element, DiagramEditor d)	{		
		if (d!=null && !d.getDiagram().containsChild(element)) return;
		if (d!=null) {
			List<DiagramElement> diagramElements = OccurenceManager.get().getDiagramElements(element);
			for(DiagramElement de: diagramElements){
				if(de!=null){				
					List<DiagramElement> list = new ArrayList<DiagramElement>();
					list.add(de);
					//notify one by one
					d.notifyChange(list, ChangeType.ELEMENTS_MODIFIED, NotificationType.DO);
				}			
			}
		}		
	}
	
	/** Decide whether we remake the element or not in the diagram (delete it and add it again) */
	public boolean shouldRemakeIt(Object obj){
		boolean remakeIt=false;						
		if (obj instanceof RefOntoUML.Property) {												
			if (((RefOntoUML.Property)obj).getAssociation()!=null) remakeIt=true;	
			else remakeIt=false;		
		}						
		else if (obj instanceof RefOntoUML.Association) remakeIt=true;			
		else if (obj instanceof Generalization) remakeIt=true;
		else remakeIt=false;
		return remakeIt;
	}
	
	/** Update application from a set of fixes on the model */
	public void update(Fix fix){		
		if (fix==null) return;			
		updateFromAddition(fix);				
		updateFromChange(fix);		
		updateFromDeletion(fix);
		for(String str: fix.getAddedRules()){
			Models.getOclDocList().get(0).addContentAsString(str);		
		}
		return ;	
	}
	
	/** Update application from a set of deletions (fix) on the model */
	public void updateFromDeletion(Fix fix){
		for(Object obj: fix.getDeleted()){
			DeletionManager.get().deleteElement((RefOntoUML.Element)obj,false);				
		}
	}
	
	/** Update application from a set of changes (fix) on the model */
	public void updateFromChange(Fix fix){
		for(Object obj: fix.getModified()){
			boolean remakeIt= shouldRemakeIt(obj);
			updateFromChange((RefOntoUML.Element)obj, remakeIt);
		}
	}
	
	/** Update application from a set of additions (fix) on the model */
	public void updateFromAddition(Fix fix){
		DiagramEditor ed = TabManager.get().getCurrentDiagramEditor();
		
		//classes and datatypes with position set need to be added
		for(Object obj: fix.getAdded()){			
			if (obj instanceof RefOntoUML.Class||obj instanceof RefOntoUML.DataType) {	
				if (fix.getAddedPosition(obj).x!=-1 && fix.getAddedPosition(obj).y!=-1){						
					AddNodeCommand cmd = new AddNodeCommand((DiagramNotification)ed,ed.getDiagram(),(RefOntoUML.Element)obj,
					fix.getAddedPosition(obj).x,fix.getAddedPosition(obj).y, (RefOntoUML.Element)((EObject)obj).eContainer());		
					cmd.run();
				}else{
					AddNodeCommand cmd = new AddNodeCommand(null,null,(RefOntoUML.Element)obj,0,0,(RefOntoUML.Element)((EObject)obj).eContainer());		
					cmd.run();									
				}
			}			
		}
		
		//relationships and attributes
		for(Object obj: fix.getAdded()) { 
			if (obj instanceof RefOntoUML.Relationship) {
				UpdateManager.get().updateFromAddition((RefOntoUML.Element)obj);
				MoveManager.get().move((RefOntoUML.Element)obj, -1, -1, ed,false);
			}
			if(obj instanceof RefOntoUML.Property){		
				UpdateManager.get().updateFromAddition((RefOntoUML.Element)obj);
			}
		}	

		//generalization sets
		for(Object obj: fix.getAdded()) {
			if (obj instanceof RefOntoUML.GeneralizationSet){
				AddGeneralizationSetCommand cmd = new AddGeneralizationSetCommand((DiagramNotification)ed,ed.getDiagram(),(RefOntoUML.Element)obj,
				((GeneralizationSet)obj).getGeneralization(),(RefOntoUML.Element)((EObject)obj).eContainer());
				cmd.run(); 
			}
		}
	}	
	
	/** Update application from the addition of an element on the model */
	public void updateFromAddition(final RefOntoUML.Element addedElement){		
		//add to parser
		Models.getRefparser().addElement(addedElement);		
		//add to tree
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {								
				boolean found = tree().checkObject((EObject)addedElement);
				if(!found) {
					if(addedElement.eContainer()!=null) tree().checkObject(addedElement.eContainer());
					else if(addedElement instanceof EnumerationLiteral) tree().checkObject(((EnumerationLiteral)addedElement).getEnumeration());
					else tree().checkObject(ProjectManager.get().getProject().getModel());					
					tree().addChild(addedElement);					
				} else {
					if(addedElement instanceof Generalization){
						tree().checkObject(addedElement);
						tree().removeCurrentNode();
						tree().checkObject(addedElement.eContainer());
						tree().addChild(addedElement);
					}
				}
				tree().updateUI();						
			}
		});		
	}
	
	/** Update application from the addition of an element on the model */
	public void updateFromChange(final RefOntoUML.Element element, final boolean remakeIt){
		updateFromAddition(element);		
		//notify the change or simply remake the element
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				if (element instanceof RefOntoUML.Class || element instanceof RefOntoUML.DataType){
					notifyChange((Classifier)element);			
				}
				if (element instanceof RefOntoUML.Association){
					if (remakeIt) RemakeManager.get().remakeRelationship((RefOntoUML.Element)element);
					else notifyChange((RefOntoUML.Element)element);
				}
				if (element instanceof RefOntoUML.Property){
					Association assoc= ((RefOntoUML.Property)element).getAssociation();								
					if (assoc!=null){
						if(remakeIt) RemakeManager.get().remakeRelationship((RefOntoUML.Element)assoc);
						else  notifyChange((RefOntoUML.Element)assoc);
					}else{
						notifyChange((RefOntoUML.Element)(element).eContainer());
					}
				}		
				if (element instanceof RefOntoUML.Generalization){
					if (remakeIt) RemakeManager.get().remakeRelationship((RefOntoUML.Element)element); 
					else notifyChange((RefOntoUML.Element)element);
				}
				if(element instanceof RefOntoUML.GeneralizationSet){
					for(Generalization gen: ((RefOntoUML.GeneralizationSet) element).getGeneralization()) updateFromChange(gen,false);
				}
			}
		});
	}
	
	/** Update application from the deletion of an element on the model */
	public void updateFromDeletion(final RefOntoUML.Element deletedElement){		
		// deleted from parser
		Models.getRefparser().removeElement(deletedElement);
		//delete from the tree
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {						
				tree().remove(deletedElement);
			}
		});
	}
	
	public void updateProjectTree(){
		tree().updateUI();
	}
}
