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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.tinyuml.draw.CompositeElement;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.BaseConnection;
import org.tinyuml.umldraw.shared.UmlConnection;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.Property;
import RefOntoUML.Relationship;
import RefOntoUML.impl.AssociationImpl;
import RefOntoUML.impl.GeneralizationImpl;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

/**
 * This is an undoable creation command for a Connection.
 *
 * @author Wei-ju Wu, John Guerson
 */
public class AddConnectionCommand extends DiagramCommand {

	private static final long serialVersionUID = 2924451842640450250L;	
	private CompositeElement parent;
	private DiagramElement diagramElement;	
	private RefOntoUML.Element relationship;
	private Classifier source;
	private Classifier target;
	private EObject eContainer;	
	private boolean addToDiagram;

	public AddConnectionCommand(OntoumlEditor editor, UmlConnection conn){
		this(
			 editor, 
			(CompositeElement)editor.getDiagram(), 
			(RefOntoUML.Element)conn.getRelationship(), 
			(RefOntoUML.Classifier)conn.getSourceObject(), 
			(RefOntoUML.Classifier)conn.getTargetObject(), 
			(RefOntoUML.Element)conn.getRelationship().eContainer()
		);
	}
	
	public AddConnectionCommand(OntoumlEditor editor, CompositeElement parent, RefOntoUML.Element relationship, Classifier aSource, Classifier aTarget, EObject eContainer) {
		this.parent = parent;		
		this.ontoumlEditor = editor;
		
		if (ontoumlEditor==null) this.addToDiagram = false; 
		else this.addToDiagram=true;
		
		this.relationship = relationship;
		if(aSource==null) source = OntoUMLParser.getSourceType(relationship);
		else source = aSource;
		if(aTarget==null) target = OntoUMLParser.getTargetType(relationship);
		else target = aTarget;
		
		this.eContainer = eContainer;
		
		StructureDiagram diagram = null;
		if(ontoumlEditor!=null) diagram = editor.getDiagram();
		this.diagramElement = OccurenceManager.get().getDiagramElement(relationship, diagram);		
		if (diagramElement==null) diagramElement = OccurenceManager.get().getDiagramElement(relationship);
	}

	@Override
	public void undo() 
	{
		super.undo();
						
		if (relationship!=null){
//			System.out.println("Undoing ="+relationship);
			RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().undo();
			UpdateCommander.get().updateFromDeletion(relationship);
		}
		
		if(addToDiagram && diagramElement!=null){				
			parent.removeChild(diagramElement);
			OccurenceManager.get().remove(diagramElement);
			
			List<DiagramElement> elements = new ArrayList<DiagramElement>();
			elements.add(diagramElement);
			notificator.notify(this, elements, NotificationType.ADD, ActionType.UNDO);			
		}	
	}

	@Override
	public void redo() 
	{
		isRedo = true;
		super.redo();
		run();
	}

	public void run() {	    
					
		ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
		
		addToModel();		
		UpdateCommander.get().updateFromAddition(relationship);
		
		if(addToDiagram && diagramElement != null)
		{			
			addToDiagram(isRedo);
			OccurenceManager.get().add(relationship, diagramElement);	
			list.add(diagramElement);
		}
		
		if (notificator!=null) {
			notificator.notify(this, (List<DiagramElement>) list, NotificationType.ADD, isRedo ? ActionType.REDO : ActionType.DO);		
						
		}
	}
		
	@SuppressWarnings("unused")
	private void addToDiagram (boolean redo)
	{
		//set sides on the diagram element
		if (diagramElement instanceof BaseConnection) {                         
            BaseConnection connection = (BaseConnection) diagramElement;                            
            if (connection.getRelationship() instanceof GeneralizationImpl)
            {
            	GeneralizationImpl generalization  = (GeneralizationImpl) connection.getRelationship();
            	generalization.setSpecific(source);
            	generalization.setGeneral(target);
            }
            else if(connection.getRelationship() instanceof AssociationImpl)
            {
                AssociationImpl association  = (AssociationImpl) connection.getRelationship();
                association.getMemberEnd().get(0).setType(source);
                association.getMemberEnd().get(1).setType(target);                              
            }
		}
		
		//add to diagram
		parent.addChild(diagramElement);
//		diagramElement.setParent((CompositeNode)parent);
		
		// bug in designing. not best solution, but it works.
		Relationship relationship = ((UmlConnection)diagramElement).getRelationship();		
		if (source instanceof Relationship || target instanceof Relationship)  diagramElement.invalidate();		
	}
	
	private void addToModel()
	{			
//		System.out.println("Adding = "+relationship);
		if (relationship instanceof Association){
			
			//set sides on the element
			Property p1 = ((Association)relationship).getMemberEnd().get(0);
			Property p2 = ((Association)relationship).getMemberEnd().get(1);			
			if(source!=null) {
				p1.setType(source);
				p1.setName(source.getName().trim().toLowerCase());
			}			
			if(target!=null) {
				p2.setType(target);
				p2.setName(target.getName().trim().toLowerCase());
			}
			
			// add to model
			if(eContainer==null){
				AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ProjectManager.get().getProject().getModel().getPackagedElement(), relationship);
				RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
			}else{				
				AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ((RefOntoUML.Package)eContainer).getPackagedElement(), relationship);
				RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
			}			
		}
		if (relationship instanceof Generalization)
		{	
			//set sides on the element
			((Generalization)relationship).setSpecific(source);
			((Generalization)relationship).setSpecific(target);
			
			//add to model
			if(source!=null){
				AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ((RefOntoUML.Classifier)source).getGeneralization(), (RefOntoUML.Generalization)relationship);
				RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);				
			}
						
		}		
	}	
}

