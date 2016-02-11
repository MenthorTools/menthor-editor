package org.tinyuml.ui.diagram.commands;

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

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import org.tinyuml.draw.CompositeNode;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.Label;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.shared.BaseConnection;

import RefOntoUML.Classifier;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.managers.ProjectManager;

/**
 * This class represents a reversible operation that sets a Label to a new
 * text.
 *
 * @author Wei-ju Wu, John Guerson
 */
public class SetLabelTextCommand extends GenericDiagramCommand {

	private static final long serialVersionUID = 5701807952287882396L;
	private Label label;
	private String text, oldText;
	private CompositeNode parent;

	/**
	 * Constructor.
	 * @param aLabel the Label
	 * @param aText the new text
	 */
	public SetLabelTextCommand(DiagramNotification aNotification, Label aLabel, String aText) {
		this.notification = aNotification;
		label = aLabel;
		text = aText;
		oldText = aLabel.getNameLabelText();
		if (aLabel.getParent()!=null) { parent = aLabel.getParent().getParent();} 
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		OntoumlEditor d = ((OntoumlEditor)notification);
		
		String oldName = label.getNameLabelText();		
		label.setNameLabelText(text);
						
		if (parent instanceof ClassElement) 
		{
			Classifier element = (((ClassElement)parent).getClassifier());
									
			// replace all references in constraints
			for(OclDocument oclDoc: ProjectManager.get().getProject().getOclDocList())
			{
				String currentConstraints = oclDoc.getContentAsString();
				String newConstraints = currentConstraints.replaceAll(oldName,text);
				oclDoc.setContentAsString(newConstraints);
			}
			
			// update application accordingly
			UpdateCommander.get().updateFromChange(element, false);
						
		}else if (parent instanceof BaseConnection){
			
		}
		
		elements.add(parent);		
				
		//notify
		if (d!=null) {
			d.notifyChange((List<DiagramElement>) elements, ChangeType.LABEL_TEXT_SET, redo ? NotificationType.REDO : NotificationType.DO);			
			UndoableEditEvent event = new UndoableEditEvent(((OntoumlEditor)d), this);
			for (UndoableEditListener l : ((OntoumlEditor)d).editListeners)  l.undoableEditHappened(event);			
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redo() {
		redo = true;
		super.redo();
		run();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() 
	{
		super.undo();
		
		label.setNameLabelText(oldText);
				
		if (parent instanceof ClassElement) 
		{
			Classifier element = (((ClassElement)parent).getClassifier());
			
			// replace all references in constraints
			for(OclDocument oclDoc: ProjectManager.get().getProject().getOclDocList())
			{
				String currentConstraints = oclDoc.getContentAsString();
				String newConstraints = currentConstraints.replaceAll(text,oldText);
				oclDoc.setContentAsString(newConstraints);
			}
			
			// update application accordingly
			UpdateCommander.get().updateFromChange(element, false);
						
		}else if (parent instanceof BaseConnection){
			
		}
				
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		elements.add(parent);
		notification.notifyChange(elements, ChangeType.LABEL_TEXT_SET, NotificationType.UNDO);					
	}
}
