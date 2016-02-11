package org.tinyuml.ui.diagram.commands;

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
import java.util.HashMap;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;
import org.tinyuml.umldraw.AssociationElement;

/**
 * @author John Guerson
 */
public class AssociationVisibilityCommand extends GenericDiagramCommand{

	private static final long serialVersionUID = -444736590798129291L;

	public OntoumlEditor editor;
	//maps the selected elements to the previous values
	public HashMap<AssociationElement, Boolean> valueMap = new HashMap<AssociationElement, Boolean>();
	public ArrayList<AssociationElement> associationList = new ArrayList<AssociationElement>();
	public ArrayList<DiagramElement> diagramElementList = new ArrayList<DiagramElement>();
	
	public enum AssociationVisibility { NAME, ENDPOINTS, STEREOTYPE, MULTIPLICITY, SUBSETS, REDEFINES }
	public AssociationVisibility visibility;
	public boolean value;
	
	private AssociationVisibilityCommand(DiagramNotification editorNotification, AssociationVisibility visibility, boolean value){
		this.editor = (OntoumlEditor)editorNotification;
		notification = editorNotification;
		this.visibility = visibility;
		this.value = value;
	}
	
	public AssociationVisibilityCommand(DiagramNotification editorNotification, AssociationElement element, AssociationVisibility visibility, boolean value){
		this(editorNotification,visibility,value);
		this.associationList.add(element);
		this.diagramElementList.add(element);
		populateMap();
	}
	
	public AssociationVisibilityCommand(DiagramNotification editorNotification, List<AssociationElement> selected, AssociationVisibility visibility, boolean value) 
	{
		this(editorNotification,visibility,value);
		this.associationList.addAll(selected);
		this.diagramElementList.addAll(selected);
		populateMap();
	}
	
	private void populateMap(){
		for (AssociationElement association : associationList) {
			
			switch(visibility){
				case NAME:
					valueMap.put(association, association.showName());
					break;
				case STEREOTYPE:
					valueMap.put(association, association.showOntoUmlStereotype());
					break;
				case MULTIPLICITY:
					valueMap.put(association, association.showMultiplicities());
					break;
				case ENDPOINTS:
					valueMap.put(association, association.showRoles());
					break;
				case SUBSETS:
					valueMap.put(association, association.showSubsetting());
					break;
				case REDEFINES:
					valueMap.put(association, association.showRedefining());
					break;
			}
			
		}
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		super.undo();						
	
		for (AssociationElement association : associationList) {
			switch(visibility){
			case NAME:
				association.setShowName(valueMap.get(association));
				break;
			case STEREOTYPE:
				association.setShowOntoUmlStereotype(valueMap.get(association));
				break;
			case MULTIPLICITY:
				association.setShowMultiplicities(valueMap.get(association));
				break;
			case ENDPOINTS:
				association.setShowRoles(valueMap.get(association));
				break;
			case SUBSETS:
				association.setShowSubsetting(valueMap.get(association));
				break;
			case REDEFINES:
				association.setShowRedefining(valueMap.get(association));
				break;
			}
		}
		
		if(notification!=null)
			notification.notifyChange(diagramElementList, ChangeType.VISIBILITY_CHANGED, NotificationType.UNDO);

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
	
	@Override
	public void run() {

		for (AssociationElement association : associationList) {
			switch(visibility){
			case NAME:
				association.setShowName(value);
				break;
			case STEREOTYPE:
				association.setShowOntoUmlStereotype(value);
				break;
			case MULTIPLICITY:
				association.setShowMultiplicities(value);
				break;
			case ENDPOINTS:
				association.setShowRoles(value);
				break;
			case SUBSETS:
				association.setShowSubsetting(value);
				break;
			case REDEFINES:
				association.setShowRedefining(value);
				break;
			}
		}
		
		//notify
		if (notification!=null) {
			notification.notifyChange(diagramElementList, ChangeType.VISIBILITY_CHANGED, redo ? NotificationType.REDO : NotificationType.DO);			
			UndoableEditEvent event = new UndoableEditEvent(((OntoumlEditor)editor), this);
			for (UndoableEditListener l : ((OntoumlEditor)editor).editListeners)  l.undoableEditHappened(event);			
		}	
		
	}
	
}
