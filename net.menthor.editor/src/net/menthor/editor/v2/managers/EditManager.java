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

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Property;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.element.FoundElement;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.app.manager.AppGenericManager;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
import net.menthor.editor.v2.ui.dialog.edit.AssociationEditDialog;
import net.menthor.editor.v2.ui.dialog.edit.ClassEditDialog;
import net.menthor.editor.v2.ui.dialog.edit.GeneralizationEditDialog;
import net.menthor.editor.v2.ui.dialog.edit.GeneralizationSetEditDialog;
import net.menthor.editor.v2.ui.dialog.edit.GenericEditDialog;

public class EditManager extends AppGenericManager {

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
	public void edit(Object input){
		Object element = input;

		//gets element if the call is made from the diagram or error/warning/find tables
		if(input instanceof DiagramElement) {
			element = ((DiagramElement) input).getModelObject();
		}
		else if (input instanceof FoundElement) {
			element = ((FoundElement) input).getElement();
		}
		
		//runs appropriate action
    	if(element instanceof Element){
    		openDialog((Element)element);
    	}    	
    	else if (element instanceof StructureDiagram){    		
			AppTabManager.get().addEditor(element);
    	} 
    	else if (element instanceof OclDocument){
    		AppTabManager.get().addEditor(element);
    	}
	}
	
	/** Edit class */
	public ClassEditDialog callClassDialog(Classifier element, boolean modal){
		ClassEditDialog dialog = new ClassEditDialog(getParent(), getDiagramElement(element, ClassElement.class), (RefOntoUML.Classifier)element, true);
		showEditDialog(dialog);
		return dialog;
	}
	
	/** Edit generalization */
	public GeneralizationEditDialog callGeneralizationDialog(Generalization element, boolean modal){
		GeneralizationEditDialog dialog = new GeneralizationEditDialog(getParent(), getDiagramElement(element, GeneralizationElement.class), (RefOntoUML.Generalization)element,true);
		showEditDialog(dialog);
		return dialog;
	}
	
	/** Edit association */
	public AssociationEditDialog callAssociationDialog(Association element, boolean modal){
		AssociationEditDialog dialog = new AssociationEditDialog(getParent(), getDiagramElement(element, AssociationElement.class), (RefOntoUML.Relationship)element, true);
		showEditDialog(dialog);
		return dialog;
	}
	
	/** Edit generalization set */
	public GeneralizationSetEditDialog callGeneralizationSetDialog(GeneralizationSet element, boolean modal){
		GeneralizationSetEditDialog dialog = new GeneralizationSetEditDialog(getParent(), (GeneralizationSet)element, modal);
		showEditDialog(dialog);
		return dialog;
	}
	
	/** Edit constraint */
	public ClassEditDialog callConstraintxDialog(Constraintx element, boolean modal){
		ClassEditDialog dialog = null;
		RefOntoUML.Element context = ((RefOntoUML.Constraintx)element).getConstrainedElement().get(0);
		if (context instanceof RefOntoUML.Class){
			dialog = new ClassEditDialog(getParent(),getDiagramElement(context, ClassElement.class),(RefOntoUML.Classifier)context,true);
			showEditDialog(dialog, 2);
		}
		return dialog;
	}
	
	/** Edit comment */
	public JDialog callCommentDialog(Comment element, boolean modal){
		GenericEditDialog dialog = null;
		EObject container = element.eContainer();
		
		if(container==null)
			return dialog;
		
		//if comment is owned by Association
		if(container instanceof Association ){
			Association association = (Association) container;
			dialog = new AssociationEditDialog(getParent(), getDiagramElement(association, AssociationElement.class), association, true);
			showEditDialog(dialog, 3);
		}
		// if comment is owned by a Class
		else if (container instanceof RefOntoUML.Class){
			RefOntoUML.Class _class = (RefOntoUML.Class) container;
			dialog = new ClassEditDialog(getParent(), getDiagramElement(_class, ClassElement.class), _class, true);
			showEditDialog(dialog, 1);
		}
		
		return dialog;
	}
	
	/** Edit attribute or endpoint */
	public JDialog callPropertyDialog(Property property, boolean modal){
		GenericEditDialog dialog = null;
		EObject container = property.eContainer();
		
		if(container==null)
			return dialog;
		
		//if property is an end-point
		if(container instanceof Association ){
			Association association = (Association) container;
			dialog = new AssociationEditDialog(getParent(), getDiagramElement(association, AssociationElement.class), association, true);
			int tabIndex = 0;
			if(association.getMemberEnd().get(0).equals(property)) {
				tabIndex = 1;
			}
			else { 
				tabIndex = 2;
			}
			
			showEditDialog(dialog, tabIndex);
		}
		// if property is an attribute
		else if (container instanceof RefOntoUML.Class){
			RefOntoUML.Class _class = (RefOntoUML.Class) container;
			dialog = new ClassEditDialog(getParent(), getDiagramElement(_class, ClassElement.class), _class, true);
			showEditDialog(dialog, 0);
		}
		
		return dialog;
	}
	
	private void openDialog(RefOntoUML.Element element){
		if (element instanceof RefOntoUML.Class) {
			callClassDialog((RefOntoUML.Classifier)element, true);
		}
		else if (element instanceof RefOntoUML.DataType) {
			callClassDialog((RefOntoUML.Classifier)element, true);
		}
		else if (element instanceof RefOntoUML.Property) {
			callPropertyDialog((RefOntoUML.Property)element, true);
		}
		else if (element instanceof RefOntoUML.Association) {
			callAssociationDialog((RefOntoUML.Association)element, true);        				
		}
		else if (element instanceof RefOntoUML.Comment) {
			callCommentDialog((RefOntoUML.Comment)element, true);	            			
		}
		else if (element instanceof RefOntoUML.Constraintx) {
			callConstraintxDialog((RefOntoUML.Constraintx)element, true);
		}
		else if (element instanceof RefOntoUML.Generalization) {
			callGeneralizationDialog((RefOntoUML.Generalization)element, true );
		}
		else if (element instanceof RefOntoUML.GeneralizationSet) {
			callGeneralizationSetDialog((GeneralizationSet)element, true);
		}
	}	
	
	private <T extends DiagramElement> T getDiagramElement(Element element, Class<T> elementType) {
		
		OntoumlEditor diagEditor = AppTabManager.get().getCurrentDiagramEditor();
		StructureDiagram diagram = null;
		DiagramElement diagramElement = null;
		
		if(diagEditor != null) {
			diagram = diagEditor.getDiagram();
			diagramElement = OccurenceManager.get().getDiagramElement((RefOntoUML.Element)element,diagram);
			if (diagramElement!=null && elementType.isInstance(diagramElement)){
				return elementType.cast(diagramElement);
			}
		}
		return null;
	}
	
	private void showEditDialog(GenericEditDialog dialog) {
		showEditDialog(dialog,0);
	}
	
	private void showEditDialog(GenericEditDialog dialog, int tabIndex) {
		dialog.setLocationRelativeTo(getParent());
		dialog.selectTab(tabIndex);
		dialog.setVisible(true);
	}
}
