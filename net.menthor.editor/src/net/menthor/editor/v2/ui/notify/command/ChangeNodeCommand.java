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

import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.Node;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

/**
 * This class implements a command to add nodes. It is introduced, because
 * AddElementCommand can not handle setting positions with nesting very
 * well.
 *
 * @author Wei-ju Wu, John Guerson
 */
public class ChangeNodeCommand extends DiagramCommand {

	private static final long serialVersionUID = -3148409380703192555L;
	private Node element;
	private Node prvSnapshot;
	private Node nxtSnapshot;
	
	private ChangeDescription desc;

	/**
	 * Constructor.
	 * @param editorNotification a ModelNotification object
	 * @param parent the parent component
	 * @param node the created element
	 * @param x the absolute x position
	 * @param y the absolute y position
	 */
	public ChangeNodeCommand(OntoumlEditor editor, Node node, Node snapshot, ChangeDescription desc) {
		this.ontoumlEditor = editor;
		this.desc = desc;
		element = node;
		this.prvSnapshot = snapshot;
		nxtSnapshot = (Node) element.clone();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		super.undo();
		
		if(desc.getObjectChanges().size() > 0)
		{
			desc.applyAndReverse();	
			
			ChangeCommand cmd = new ChangeCommand(desc) { 
				@Override
				protected void doExecute() {}
			};
			
			RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
		}
		
		if(element instanceof ClassElement)
		{
			ClassElement clsElm = (ClassElement) element;
			if(!clsElm.compareTo((ClassElement) prvSnapshot))
				((ClassElement) prvSnapshot).copyDataTo(clsElm);
			
		}
		
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		elements.add(element);
		notificator.notify(this, elements, NotificationType.MODIFY, ActionType.UNDO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redo() {
		isRedo = true;
		super.redo();
		
		if(desc.getObjectChanges().size() > 0)
		{	
			desc.applyAndReverse();	
			
			ChangeCommand cmd = new ChangeCommand(desc) { 
				@Override
				protected void doExecute() {}
			};
			
			RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
		}
		
		if(element instanceof ClassElement)
		{
			ClassElement clsElm = (ClassElement) element;
			if(!clsElm.compareTo((ClassElement) nxtSnapshot))
				((ClassElement) nxtSnapshot).copyDataTo(clsElm);
		}
		
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		elements.add(element);
		notificator.notify(this, elements, NotificationType.MODIFY, ActionType.REDO);
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
				
		if(desc.getObjectChanges().size() > 0)
		{
			ChangeCommand cmd = new ChangeCommand(desc) { 
				@Override
				protected void doExecute() {}
			};
			
			RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
		}
		
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		elements.add(element);
		notificator.notify(this, elements, NotificationType.MODIFY, ActionType.DO);		
	}
}
