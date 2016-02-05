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

import javax.swing.JDialog;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Property;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.ui.AppFrame;
import net.menthor.editor.v2.ui.dialog.edit.AssociationEditDialog;
import net.menthor.editor.v2.ui.dialog.edit.ClassEditDialog;
import net.menthor.editor.v2.ui.dialog.edit.GeneralizationEditDialog;
import net.menthor.editor.v2.ui.dialog.edit.GeneralizationSetEditDialog;

public class EditManager extends BaseManager {

	// -------- Lazy Initialization

	private static class EditLoader {
        private static final EditManager INSTANCE = new EditManager();
    }	
	public static EditManager get() { 
		return EditLoader.INSTANCE; 
	}	
    private EditManager() {
        if (EditLoader.INSTANCE != null) throw new IllegalStateException("EditManager already instantiated");
    }		
    
    // ----------------------------
	
	public AppFrame getParent(){ return frame(); }
	
	/** edit */
	public void edit(Object element){
		if (element instanceof ClassElement) {
			ClassElement classElement = (ClassElement) element;			
			callClassDialog(classElement.getClassifier(),true);			
		} else if (element instanceof AssociationElement) {
			AssociationElement association = (AssociationElement) element;
			callAssociationDialog((Association)association.getRelationship(),true);
		} else if (element instanceof GeneralizationElement) {
			Generalization generalization = ((GeneralizationElement)element).getGeneralization();
			callGeneralizationDialog(generalization, true);			
		} else if (element instanceof StructureDiagram){    		
			TabManager.get().addEditor(element);
    	} else if (element instanceof OclDocument){
    		TabManager.get().addEditor(element);
    	} else if(element instanceof RefOntoUML.Element){
    		RefOntoUML.Element e = (RefOntoUML.Element)element;
    		openDialog(e);
    	}
	}
	
	/** Edit generalization set */
	public GeneralizationSetEditDialog callGeneralizationSetDialog(GeneralizationSet element, boolean modal){
		GeneralizationSetEditDialog dialog = new GeneralizationSetEditDialog(getParent(), (GeneralizationSet)element, modal);
		dialog.setLocationRelativeTo(getParent());
		dialog.setVisible(true);
		return dialog;
	}
	
	/** Edit generalization */
	public GeneralizationEditDialog callGeneralizationDialog(Generalization element, boolean modal){
		DiagramEditor diagEditor = TabManager.get().getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		if(diagEditor != null)diagram = diagEditor.getDiagram();
		DiagramElement diagramElement = OccurenceManager.get().getDiagramElement((RefOntoUML.Element)element,diagram);
		GeneralizationEditDialog dialog = new GeneralizationEditDialog(getParent(), (GeneralizationElement)diagramElement,(RefOntoUML.Generalization)element,true);
		dialog.setLocationRelativeTo(getParent());
		dialog.setVisible(true);
		return dialog;
	}
	
	/** Edit constraint */
	public ClassEditDialog callConstraintxDialog(Constraintx element, boolean modal){
		RefOntoUML.Element context = ((RefOntoUML.Constraintx)element).getConstrainedElement().get(0);
		if (context instanceof RefOntoUML.Class){
			DiagramEditor diagEditor = TabManager.get().getCurrentDiagramEditor();
			StructureDiagram diagram = null;
			if(diagEditor != null) diagram = diagEditor.getDiagram();
			DiagramElement diagramElement = OccurenceManager.get().getDiagramElement(context,diagram);
			ClassEditDialog dialog = new ClassEditDialog(getParent(),(ClassElement)diagramElement,(RefOntoUML.Classifier)context,true);
			dialog.setLocationRelativeTo(getParent());			
			dialog.selectTab(2); 
			dialog.setVisible(true);
			return dialog;
		}
		return null;
	}
	
	/** Edit comment */
	public JDialog callCommentDialog(Comment element, boolean modal){
		DiagramEditor diagEditor = TabManager.get().getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		if(diagEditor != null) diagram = diagEditor.getDiagram();
		if (element.eContainer() instanceof RefOntoUML.Class){
			DiagramElement diagramElement = OccurenceManager.get().getDiagramElement((RefOntoUML.Element)element.eContainer(),diagram);
			ClassEditDialog dialog = new ClassEditDialog(getParent(),(ClassElement)diagramElement, (RefOntoUML.Classifier)element.eContainer(), true);
			dialog.setLocationRelativeTo(getParent());			
			if (element instanceof RefOntoUML.Comment) dialog.selectTab(1);
			dialog.setVisible(true);
			return dialog;
		}
		if (element.eContainer() instanceof RefOntoUML.Association){
			DiagramElement diagramElement = OccurenceManager.get().getDiagramElement((RefOntoUML.Element)element.eContainer(),diagram);
			AssociationEditDialog dialog = new AssociationEditDialog(getParent(), (AssociationElement)diagramElement, (RefOntoUML.Relationship)element.eContainer(), true);
			dialog.setLocationRelativeTo(getParent());			                			 
			if (element instanceof RefOntoUML.Comment) dialog.selectTab(3);
			dialog.setVisible(true);
			return dialog;
		}
		return null;
	}
	
	/** Edit association */
	public AssociationEditDialog callAssociationDialog(Association element, boolean modal){
		DiagramEditor diagEditor = TabManager.get().getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		if(diagEditor != null) diagram = diagEditor.getDiagram();
		DiagramElement diagramElement = OccurenceManager.get().getDiagramElement(element,diagram);
		AssociationEditDialog dialog = new AssociationEditDialog(getParent(), (AssociationElement)diagramElement, (RefOntoUML.Relationship)element, true);
		dialog.setLocationRelativeTo(getParent());
		dialog.setVisible(true);
		return dialog;
	}

	/** Edit attribute or endpoint */
	public JDialog callPropertyDialog(Property element, boolean modal){
		Property p = (Property)element;
		DiagramEditor diagEditor = TabManager.get().getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		if(diagEditor != null) diagram = diagEditor.getDiagram();
		if (p.getAssociation()!=null){
			DiagramElement diagramElement = OccurenceManager.get().getDiagramElement(p.getAssociation(),diagram);
			AssociationEditDialog dialog = new AssociationEditDialog(getParent(), (AssociationElement)diagramElement, (RefOntoUML.Relationship)p.getAssociation(), true);
			dialog.setLocationRelativeTo(getParent());			
			if(p.getAssociation().getMemberEnd().get(0).equals(p)) dialog.selectTab(1);
			else dialog.selectTab(2);
			dialog.setVisible(true);
			return dialog;
		}else{
			DiagramElement diagramElement = OccurenceManager.get().getDiagramElement((RefOntoUML.Element)p.eContainer(),diagram);
			ClassEditDialog dialog = new ClassEditDialog(getParent(), (ClassElement)diagramElement,(RefOntoUML.Classifier)p.eContainer(),true);
			dialog.setLocationRelativeTo(getParent());			
			dialog.selectTab(0);
			dialog.setVisible(true);
			return dialog;
		}
	}
	
	/** Edit class */
	public ClassEditDialog callClassDialog(Classifier element, boolean modal){
		DiagramEditor diagEditor = TabManager.get().getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		if(diagEditor != null) diagram = diagEditor.getDiagram();
		DiagramElement diagramElement = OccurenceManager.get().getDiagramElement(element,diagram);
		ClassEditDialog dialog = new ClassEditDialog(getParent(), (ClassElement)diagramElement, (RefOntoUML.Classifier)element, true);
		dialog.setLocationRelativeTo(getParent());
		dialog.setVisible(true);
		return dialog;
	}
	
	private void openDialog(RefOntoUML.Element element){
		if (element instanceof RefOntoUML.Class) callClassDialog((RefOntoUML.Classifier)element, true);
		if (element instanceof RefOntoUML.DataType) callClassDialog((RefOntoUML.Classifier)element, true);
		if (element instanceof RefOntoUML.Property) callPropertyDialog((RefOntoUML.Property)element, true);
		if (element instanceof RefOntoUML.Association) callAssociationDialog((RefOntoUML.Association)element, true);        				
		if (element instanceof RefOntoUML.Comment) callCommentDialog((RefOntoUML.Comment)element, true);	            			
		if (element instanceof RefOntoUML.Constraintx) callConstraintxDialog((RefOntoUML.Constraintx)element, true);
		if (element instanceof RefOntoUML.Generalization) callGeneralizationDialog((RefOntoUML.Generalization)element, true );
		if (element instanceof RefOntoUML.GeneralizationSet) callGeneralizationSetDialog((GeneralizationSet)element, true);
	}	
}
