package net.menthor.editor.ui;

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

import net.menthor.editor.v2.edit.AssociationEditDialog;
import net.menthor.editor.v2.edit.ClassEditDialog;
import net.menthor.editor.v2.edit.GeneralizationEditDialog;
import net.menthor.editor.v2.edit.GeneralizationSetEditDialog;
import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Property;

/**
 * @author John Guerson
 */
public class ElementDialogCaller {

	public static GeneralizationSetEditDialog callGeneralizationSetDialog(MainFrame frame, GeneralizationSet element, boolean modal)
	{
		GeneralizationSetEditDialog dialog = new GeneralizationSetEditDialog(frame, (GeneralizationSet)element, modal);
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
		return dialog;
	}
	
	public static GeneralizationEditDialog callGeneralizationDialog(MainFrame frame, Generalization element, boolean modal)
	{
		DiagramEditor diagEditor = frame.getDiagramManager().getCurrentDiagramEditor();
		StructureDiagram diagram;
		if(diagEditor == null){
			diagram = null;
		}else{
			diagram = diagEditor.getDiagram();
		}
		DiagramElement diagramElement = ElementMapper.getDiagramElementByDiagram((RefOntoUML.Element)element,diagram);
		GeneralizationEditDialog dialog = new GeneralizationEditDialog(frame, (GeneralizationElement)diagramElement,(RefOntoUML.Generalization)element,true);
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
		return dialog;
	}
	
	public static ClassEditDialog callConstraintxDialog(MainFrame frame, Constraintx element, boolean modal)
	{
		RefOntoUML.Element context = ((RefOntoUML.Constraintx)element).getConstrainedElement().get(0);
		if (context instanceof RefOntoUML.Class)
		{
			DiagramEditor diagEditor = frame.getDiagramManager().getCurrentDiagramEditor();
			StructureDiagram diagram;
			if(diagEditor == null){
				diagram = null;
			}else{
				diagram = diagEditor.getDiagram();
			}	
			DiagramElement diagramElement = ElementMapper.getDiagramElementByDiagram(context,diagram);
			ClassEditDialog dialog = new ClassEditDialog(frame,(ClassElement)diagramElement,(RefOntoUML.Classifier)context,true);
			dialog.setLocationRelativeTo(frame);			
			dialog.selectTab(2); 
			dialog.setVisible(true);
			return dialog;
		}
		return null;
	}
	
	public static JDialog callCommentDialog(MainFrame frame, Comment element, boolean modal)
	{
		DiagramEditor diagEditor = frame.getDiagramManager().getCurrentDiagramEditor();
		StructureDiagram diagram;
		if(diagEditor == null){
			diagram = null;
		}else{
			diagram = diagEditor.getDiagram();
		}	
		if (element.eContainer() instanceof RefOntoUML.Class){
			DiagramElement diagramElement = ElementMapper.getDiagramElementByDiagram((RefOntoUML.Element)element.eContainer(),diagram);
			ClassEditDialog dialog = new ClassEditDialog(frame,(ClassElement)diagramElement, (RefOntoUML.Classifier)element.eContainer(), true);
			dialog.setLocationRelativeTo(frame);			
			if (element instanceof RefOntoUML.Comment) dialog.selectTab(1);
			dialog.setVisible(true);
			return dialog;
		}
		if (element.eContainer() instanceof RefOntoUML.Association){
			DiagramElement diagramElement = ElementMapper.getDiagramElementByDiagram((RefOntoUML.Element)element.eContainer(),diagram);
			AssociationEditDialog dialog = new AssociationEditDialog(frame, (AssociationElement)diagramElement, (RefOntoUML.Relationship)element.eContainer(), true);
			dialog.setLocationRelativeTo(frame);			                			 
			if (element instanceof RefOntoUML.Comment) dialog.selectTab(3);
			dialog.setVisible(true);
			return dialog;
		}
		return null;
	}
	
	public static AssociationEditDialog callAssociationDialog(MainFrame frame, Association element, boolean modal)
	{
		DiagramEditor diagEditor = frame.getDiagramManager().getCurrentDiagramEditor();
		StructureDiagram diagram;
		if(diagEditor == null){
			diagram = null;
		}else{
			diagram = diagEditor.getDiagram();
		}		
		DiagramElement diagramElement = ElementMapper.getDiagramElementByDiagram(element,diagram);
		AssociationEditDialog dialog = new AssociationEditDialog(frame, (AssociationElement)diagramElement, (RefOntoUML.Relationship)element, true);
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
		return dialog;
	}
	
	public static JDialog callPropertyDialog(MainFrame frame, Property element, boolean modal)
	{
		Property p = (Property)element;
		DiagramEditor diagEditor = frame.getDiagramManager().getCurrentDiagramEditor();
		StructureDiagram diagram;
		if(diagEditor == null){
			diagram = null;
		}else{
			diagram = diagEditor.getDiagram();
		}
		if (p.getAssociation()!=null){
			DiagramElement diagramElement = ElementMapper.getDiagramElementByDiagram(p.getAssociation(),diagram);
			AssociationEditDialog dialog = new AssociationEditDialog(frame, (AssociationElement)diagramElement, (RefOntoUML.Relationship)p.getAssociation(), true);
			dialog.setLocationRelativeTo(frame);			
			if(p.getAssociation().getMemberEnd().get(0).equals(p)) dialog.selectTab(1);
			else dialog.selectTab(2);
			dialog.setVisible(true);
			return dialog;
		}else{
			DiagramElement diagramElement = ElementMapper.getDiagramElementByDiagram((RefOntoUML.Element)p.eContainer(),diagram);
			ClassEditDialog dialog = new ClassEditDialog(frame, (ClassElement)diagramElement,(RefOntoUML.Classifier)p.eContainer(),true);
			dialog.setLocationRelativeTo(frame);			
			dialog.selectTab(0);
			dialog.setVisible(true);
			return dialog;
		}
	}
	
	public static ClassEditDialog callClassDialog(MainFrame frame, Classifier element, boolean modal)
	{
		DiagramEditor diagEditor = frame.getDiagramManager().getCurrentDiagramEditor();
		StructureDiagram diagram;
		if(diagEditor == null){
			diagram = null;
		}else{
			diagram = diagEditor.getDiagram();
		}
		DiagramElement diagramElement = ElementMapper.getDiagramElementByDiagram(element,diagram);
		ClassEditDialog dialog = new ClassEditDialog(frame, (ClassElement)diagramElement, (RefOntoUML.Classifier)element, true);
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
		return dialog;
	}
	
	public static void openDialog(RefOntoUML.Element element, MainFrame frame)
	{
		if (element instanceof RefOntoUML.Class)
		{
			ElementDialogCaller.callClassDialog(frame, (RefOntoUML.Classifier)element, true);
		}
		if ((element instanceof RefOntoUML.DataType) || (element instanceof RefOntoUML.Enumeration))
		{
			ElementDialogCaller.callClassDialog(frame, (RefOntoUML.Classifier)element, true);
		}		 
		else if (element instanceof RefOntoUML.Property)
		{
			ElementDialogCaller.callPropertyDialog(frame, (RefOntoUML.Property)element, true);
		} 
		else if (element instanceof RefOntoUML.Association)
		{
			ElementDialogCaller.callAssociationDialog(frame, (RefOntoUML.Association)element, true);        				
		} 
		else if (element instanceof RefOntoUML.Comment)
		{
			ElementDialogCaller.callCommentDialog(frame, (RefOntoUML.Comment)element, true);	            			
		} 
		else if (element instanceof RefOntoUML.Constraintx)
		{
			ElementDialogCaller.callConstraintxDialog(frame, (RefOntoUML.Constraintx)element, true);
		}
		else if (element instanceof RefOntoUML.Generalization)
		{
			ElementDialogCaller.callGeneralizationDialog(frame, (RefOntoUML.Generalization)element, true );
		} 
		else if (element instanceof RefOntoUML.GeneralizationSet)
		{            			
			ElementDialogCaller.callGeneralizationSetDialog(frame, (GeneralizationSet)element, true);
		}
	}
}
