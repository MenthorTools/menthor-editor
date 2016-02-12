package net.menthor.editor.v2.ui.notify.command;

/**
 * Copyright 2007 Wei-ju Wu
 *
 * This file is part of TinyUML.
 *
 * TinyUML is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * TinyUML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TinyUML; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.command.AddCommand;
import org.tinyuml.draw.CompositeElement;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.Node;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.SelectionHandler;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlNode;

import RefOntoUML.Classifier;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramCommand;
import net.menthor.editor.v2.ui.notify.Notification;
import net.menthor.editor.v2.ui.notify.NotificationType;

/**
 * This class implements a command to add nodes. It is introduced, because
 * AddElementCommand can not handle setting positions with nesting very
 * well.
 *
 * @author Wei-ju Wu, John Guerson
 */
public class AddNodeCommand extends DiagramCommand {

	private static final long serialVersionUID = -3148409380703192555L;
	
	private CompositeElement parent;
	private DiagramElement diagramElement;
	private double absx, absy;	
	private RefOntoUML.Element element;
	private RefOntoUML.Element eContainer;	
	private boolean addToDiagram;

	public AddNodeCommand(Notification editorNotification, UmlNode node, double x, double y){
		this(editorNotification, (CompositeElement)((OntoumlEditor)editorNotification.getDiagramEditor()).getDiagram(), 
		(RefOntoUML.Element)node.getClassifier(), x, y, (RefOntoUML.Element)node.getClassifier().eContainer());
	}
	
	public AddNodeCommand(Notification editorNotification, CompositeElement parent, RefOntoUML.Element element, double x, double y, RefOntoUML.Element eContainer) 
	{
		this.parent = parent;		
		this.notificator = editorNotification;		
		if(notificator==null) this.addToDiagram = false; else this.addToDiagram=true;
		this.element = element;		
		this.eContainer = eContainer;
		
		StructureDiagram diagram = null;
		if(notificator!=null) {
			OntoumlEditor editor = ((OntoumlEditor)notificator.getDiagramEditor());		
			if(editor!=null) diagram = editor.getDiagram();
		}		
		this.diagramElement = OccurenceManager.get().getDiagramElement(element, diagram);		
		if(this.diagramElement==null){			
			if(element instanceof RefOntoUML.Class || element instanceof RefOntoUML.Association || element instanceof RefOntoUML.DataType || element instanceof RefOntoUML.Generalization){				
				if(diagram==null) this.diagramElement = FactoryManager.get().createNode((RefOntoUML.Type)element, diagram);
				else this.diagramElement = FactoryManager.get().createNode((RefOntoUML.Type)element, eContainer);
			}			
		}
		
		absx = x;
		absy = y;
	}

	@Override
	public void undo() 
	{		
		super.undo();
				
		if(element!=null){
//			System.out.println("Undoing = "+element);
			RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().undo();
			UpdateCommander.get().updateFromDeletion(element);			
		}
		
		if(addToDiagram && diagramElement != null){
			parent.removeChild(diagramElement);			
			OccurenceManager.get().remove(diagramElement);
		}		
		
		if(notificator!=null){
			List<DiagramElement> elements = new ArrayList<DiagramElement>();
			elements.add(diagramElement);
			notificator.notifyChange(this, elements, NotificationType.ELEMENTS_ADDED, ActionType.UNDO);
			SelectionHandler selHandler = notificator.getDiagramEditor().getSelectionHandler();
			selHandler.elementRemoved(elements);
		}
		
	}

	@Override
	public void redo() 
	{	
		isRedo = true;
		super.redo();
		run();
	}

	public void run() 
	{				
		ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
				
		if(element!=null){
			addToModel(element);
			UpdateCommander.get().updateFromAddition(element);			
		}
		
		if(addToDiagram && diagramElement !=null){			
			addToDiagram(diagramElement,isRedo);
			OccurenceManager.get().add(element, ((ClassElement)diagramElement));
			list.add(diagramElement);
		}		
		
		if (notificator!=null) {
			notificator.notifyChange(this, (List<DiagramElement>) list, NotificationType.ELEMENTS_ADDED, isRedo ? ActionType.REDO : ActionType.DO);		
						
		}
	}	
	
	private void addToDiagram (DiagramElement element, boolean redo)
	{
		//Adds the element to the diagram
		parent.addChild(element);
//		element.setParent((CompositeNode)parent);
		
		if(element instanceof Node) {
			
			((Node)element).setAbsolutePos(absx, absy);
			
			// show attributes compartment if necessary
			Classifier c = ((ClassElement)element).getClassifier();
			if (c instanceof RefOntoUML.Class){
				if (((RefOntoUML.Class)c).getOwnedAttribute().size()>0){
					((ClassElement)element).setShowAttributes(true);
				}
			}
			if (c instanceof RefOntoUML.DataType){
				if (((RefOntoUML.DataType)c).getOwnedAttribute().size()>0){
					((ClassElement)element).setShowAttributes(true);
				}
			}
		}		
	}
	private void addToModel(RefOntoUML.Element element)
	{
//		System.out.println("Adding = "+element);
		if(eContainer==null){
			
			if (!(ProjectManager.get().getProject().getModel().getPackagedElement().contains(element)))
			{
				AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ProjectManager.get().getProject().getModel().getPackagedElement(), element);
				RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
			}
			
		}else{
			if (eContainer instanceof RefOntoUML.Package)
			{
				if (!(((RefOntoUML.Package)eContainer).getPackagedElement().contains(element)))
				{					
					AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ((RefOntoUML.Package)eContainer).getPackagedElement(), element);
					RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
				}
				
			}else if (eContainer instanceof RefOntoUML.Element && element instanceof RefOntoUML.Comment)
			{
				if (!(((RefOntoUML.Element)eContainer).getOwnedComment().contains(element)))
				{
					AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ((RefOntoUML.Element)eContainer).getOwnedComment(), element);
					RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
				}
				
			}else if (eContainer instanceof RefOntoUML.Classifier && element instanceof RefOntoUML.Constraintx)
			{
				if (!(((RefOntoUML.Constraintx)element).getConstrainedElement().contains((RefOntoUML.Classifier)eContainer)))						
				{
					AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ((RefOntoUML.Constraintx)element).getConstrainedElement(), (RefOntoUML.Classifier)eContainer);
					RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
				}
				
			}else if (eContainer instanceof RefOntoUML.Class && element instanceof RefOntoUML.Property)
			{
				if (!(((RefOntoUML.Class)eContainer).getOwnedAttribute().contains(element)))
				{
					AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ((RefOntoUML.Class)eContainer).getOwnedAttribute(), element);
					RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
				}
				
			}else if (eContainer instanceof RefOntoUML.DataType && element instanceof RefOntoUML.Property)
			{
				if (!(((RefOntoUML.DataType)eContainer).getOwnedAttribute().contains(element)))
				{
					AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ((RefOntoUML.DataType)eContainer).getOwnedAttribute(), element);
					RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
				}
			}			
		}		
	}	
}
