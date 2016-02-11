package net.menthor.editor.v2.ui.notify.command;

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

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramCommand;
import net.menthor.editor.v2.ui.notify.Notification;
import net.menthor.editor.v2.ui.notify.NotificationType;

/**
 * @author John Guerson
 */
public class ClassVisibilityCommand extends DiagramCommand{

	private static final long serialVersionUID = -444736590798129291L;

	public OntoumlEditor editor;
	
	//maps the selected elements to the previous values
	public HashMap<ClassElement, Boolean> valueMap = new HashMap<ClassElement, Boolean>();
	public ArrayList<ClassElement> classList = new ArrayList<ClassElement>();
	public ArrayList<DiagramElement> diagramElementList = new ArrayList<DiagramElement>();
	
	public enum ClassVisibility { STEREOTYPE, PARENTS, NAMESPACE, ATTRIBUTES}
	public ClassVisibility visibility;
	
	public boolean value;
	
	private ClassVisibilityCommand(Notification editorNotification, ClassVisibility visibility, boolean value){
		this.editor = (OntoumlEditor)editorNotification.getDiagramEditor();
		notificator = editorNotification;
		this.visibility = visibility;
		this.value = value;
	}
	
	public ClassVisibilityCommand(Notification editorNotification, ClassElement element, ClassVisibility visibility, boolean value){
		this(editorNotification,visibility,value);
		this.classList.add(element);
		this.diagramElementList.add(element);
		populateMap();
	}
	
	public ClassVisibilityCommand(Notification editorNotification, List<ClassElement> selected, ClassVisibility visibility, boolean value) 
	{
		this(editorNotification,visibility,value);
		this.classList.addAll(selected);
		this.diagramElementList.addAll(selected);
		populateMap();
	}
	
	private void populateMap(){
		for (ClassElement element : classList) {
			
			switch(visibility){
				case STEREOTYPE:
					valueMap.put(element, element.showStereotypes());
					break;
				case PARENTS:
					valueMap.put(element, element.showNamespace());
					break;
				case NAMESPACE:
					valueMap.put(element, element.showNamespace());
					break;
				case ATTRIBUTES:
					valueMap.put(element, element.showAttributes());
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
	
		for (ClassElement element : classList) {
			switch(visibility){
			case STEREOTYPE:
				element.setShowStereotypes(valueMap.get(element));
				break;
			case PARENTS:
				element.setShowParents(valueMap.get(element));
				break;
			case NAMESPACE:
				element.setShowNamespace(valueMap.get(element));
				break;
			case ATTRIBUTES:
				element.setShowAttributes(valueMap.get(element));
				break;

			}
		}
		
		if(notificator!=null)
			notificator.notifyChange(this, diagramElementList, NotificationType.VISIBILITY_CHANGED, ActionType.UNDO);

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redo() {
		isRedo = true;
		super.redo();
		run();		
	}
	
	@Override
	public void run() {

		for (ClassElement element : classList) {
			switch(visibility){
			case STEREOTYPE:
				element.setShowStereotypes(value);
				break;
			case PARENTS:
				element.setShowParents(value);
				break;
			case NAMESPACE:
				element.setShowNamespace(value);
				break;
			case ATTRIBUTES:
				element.setShowAttributes(value);
				break;

			}
		}
		
		//notify
		if (notificator!=null) {
			notificator.notifyChange(this, diagramElementList, NotificationType.VISIBILITY_CHANGED, isRedo ? ActionType.REDO : ActionType.DO);		
						
		}	
		
	}
	
}
