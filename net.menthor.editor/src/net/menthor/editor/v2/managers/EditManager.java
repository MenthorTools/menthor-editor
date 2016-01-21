package net.menthor.editor.v2.managers;

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
import net.menthor.editor.v2.edit.AssociationEditDialog;
import net.menthor.editor.v2.edit.ClassEditDialog;
import net.menthor.editor.v2.edit.GeneralizationEditDialog;
import net.menthor.editor.v2.edit.GeneralizationSetEditDialog;

public class EditManager extends BaseManager {

	private static EditManager instance = new EditManager();
	public static EditManager get() { return instance; }
	
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
			diagramManager.openTab(element);
    	} else if (element instanceof OclDocument){
    		diagramManager.openTab(element);
    	} else if(element instanceof RefOntoUML.Element){
    		RefOntoUML.Element e = (RefOntoUML.Element)element;
    		openDialog(e);
    	}
	}
	
	/** Edit generalization set */
	public GeneralizationSetEditDialog callGeneralizationSetDialog(GeneralizationSet element, boolean modal){
		GeneralizationSetEditDialog dialog = new GeneralizationSetEditDialog(diagramManager.getFrame(), (GeneralizationSet)element, modal);
		dialog.setLocationRelativeTo(diagramManager.getFrame());
		dialog.setVisible(true);
		return dialog;
	}
	
	/** Edit generalization */
	public GeneralizationEditDialog callGeneralizationDialog(Generalization element, boolean modal){
		DiagramEditor diagEditor = diagramManager.getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		if(diagEditor != null)diagram = diagEditor.getDiagram();
		DiagramElement diagramElement = OccurenceManager.get().getDiagramElement((RefOntoUML.Element)element,diagram);
		GeneralizationEditDialog dialog = new GeneralizationEditDialog(diagramManager.getFrame(), (GeneralizationElement)diagramElement,(RefOntoUML.Generalization)element,true);
		dialog.setLocationRelativeTo(diagramManager.getFrame());
		dialog.setVisible(true);
		return dialog;
	}
	
	/** Edit constraint */
	public ClassEditDialog callConstraintxDialog(Constraintx element, boolean modal){
		RefOntoUML.Element context = ((RefOntoUML.Constraintx)element).getConstrainedElement().get(0);
		if (context instanceof RefOntoUML.Class){
			DiagramEditor diagEditor = diagramManager.getCurrentDiagramEditor();
			StructureDiagram diagram = null;
			if(diagEditor != null) diagram = diagEditor.getDiagram();
			DiagramElement diagramElement = OccurenceManager.get().getDiagramElement(context,diagram);
			ClassEditDialog dialog = new ClassEditDialog(diagramManager.getFrame(),(ClassElement)diagramElement,(RefOntoUML.Classifier)context,true);
			dialog.setLocationRelativeTo(diagramManager.getFrame());			
			dialog.selectTab(2); 
			dialog.setVisible(true);
			return dialog;
		}
		return null;
	}
	
	/** Edit comment */
	public JDialog callCommentDialog(Comment element, boolean modal){
		DiagramEditor diagEditor = diagramManager.getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		if(diagEditor != null) diagram = diagEditor.getDiagram();
		if (element.eContainer() instanceof RefOntoUML.Class){
			DiagramElement diagramElement = OccurenceManager.get().getDiagramElement((RefOntoUML.Element)element.eContainer(),diagram);
			ClassEditDialog dialog = new ClassEditDialog(diagramManager.getFrame(),(ClassElement)diagramElement, (RefOntoUML.Classifier)element.eContainer(), true);
			dialog.setLocationRelativeTo(diagramManager.getFrame());			
			if (element instanceof RefOntoUML.Comment) dialog.selectTab(1);
			dialog.setVisible(true);
			return dialog;
		}
		if (element.eContainer() instanceof RefOntoUML.Association){
			DiagramElement diagramElement = OccurenceManager.get().getDiagramElement((RefOntoUML.Element)element.eContainer(),diagram);
			AssociationEditDialog dialog = new AssociationEditDialog(diagramManager.getFrame(), (AssociationElement)diagramElement, (RefOntoUML.Relationship)element.eContainer(), true);
			dialog.setLocationRelativeTo(diagramManager.getFrame());			                			 
			if (element instanceof RefOntoUML.Comment) dialog.selectTab(3);
			dialog.setVisible(true);
			return dialog;
		}
		return null;
	}
	
	/** Edit association */
	public AssociationEditDialog callAssociationDialog(Association element, boolean modal){
		DiagramEditor diagEditor = diagramManager.getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		if(diagEditor != null) diagram = diagEditor.getDiagram();
		DiagramElement diagramElement = OccurenceManager.get().getDiagramElement(element,diagram);
		AssociationEditDialog dialog = new AssociationEditDialog(diagramManager.getFrame(), (AssociationElement)diagramElement, (RefOntoUML.Relationship)element, true);
		dialog.setLocationRelativeTo(diagramManager.getFrame());
		dialog.setVisible(true);
		return dialog;
	}

	/** Edit attribute or endpoint */
	public JDialog callPropertyDialog(Property element, boolean modal){
		Property p = (Property)element;
		DiagramEditor diagEditor = diagramManager.getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		if(diagEditor != null) diagram = diagEditor.getDiagram();
		if (p.getAssociation()!=null){
			DiagramElement diagramElement = OccurenceManager.get().getDiagramElement(p.getAssociation(),diagram);
			AssociationEditDialog dialog = new AssociationEditDialog(diagramManager.getFrame(), (AssociationElement)diagramElement, (RefOntoUML.Relationship)p.getAssociation(), true);
			dialog.setLocationRelativeTo(diagramManager.getFrame());			
			if(p.getAssociation().getMemberEnd().get(0).equals(p)) dialog.selectTab(1);
			else dialog.selectTab(2);
			dialog.setVisible(true);
			return dialog;
		}else{
			DiagramElement diagramElement = OccurenceManager.get().getDiagramElement((RefOntoUML.Element)p.eContainer(),diagram);
			ClassEditDialog dialog = new ClassEditDialog(diagramManager.getFrame(), (ClassElement)diagramElement,(RefOntoUML.Classifier)p.eContainer(),true);
			dialog.setLocationRelativeTo(diagramManager.getFrame());			
			dialog.selectTab(0);
			dialog.setVisible(true);
			return dialog;
		}
	}
	
	/** Edit class */
	public ClassEditDialog callClassDialog(Classifier element, boolean modal){
		DiagramEditor diagEditor = diagramManager.getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		if(diagEditor != null) diagram = diagEditor.getDiagram();
		DiagramElement diagramElement = OccurenceManager.get().getDiagramElement(element,diagram);
		ClassEditDialog dialog = new ClassEditDialog(diagramManager.getFrame(), (ClassElement)diagramElement, (RefOntoUML.Classifier)element, true);
		dialog.setLocationRelativeTo(diagramManager.getFrame());
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
