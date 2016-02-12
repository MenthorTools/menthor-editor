package net.menthor.editor.v2.ui.notify;

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
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.Label;
import org.tinyuml.draw.SimpleLabel;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.BaseConnection;

import RefOntoUML.Element;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.app.AppBrowser;
import net.menthor.editor.v2.ui.app.manager.AppMessageManager;

public class Notifier {

	// -------- Lazy Initialization
	
	private static class NotificationLoader {
        private static final Notifier INSTANCE = new Notifier();
    }	
	public static Notifier get() { 
		return NotificationLoader.INSTANCE; 
	}	
    private Notifier() {
    	editListeners.add(undoManager);
        if (NotificationLoader.INSTANCE != null) throw new IllegalStateException("Notifier already instantiated");
    }		
    
    // ----------------------------
    
	private List<UndoableEditListener> editListeners = new ArrayList<UndoableEditListener>();
	private UndoManager undoManager = new UndoManager(); 
	
	public UndoManager getUndoManager(){ return undoManager; }	
	
	public List<UndoableEditListener> getUndoableEditListeners(){ return editListeners; }
	
	public void undo(){	
		if(getUndoManager().canUndo()) getUndoManager().undo();						
		else AppMessageManager.get().showInfo("Cannot Undo", "No other action to be undone.\n\n");
	}
	
	public void redo(){	
		if(getUndoManager().canRedo()) getUndoManager().redo();						
		else AppMessageManager.get().showInfo("Cannot Redo", "No other action to be redone.\n\n");
	}
	
	//--- Notify application that a command caused a change on a model element ----
	
	public String notify(ModelCommand command, RefOntoUML.Element element, ActionType actionType){
		List<DiagramElement> diagramElements = OccurenceManager.get().getDiagramElements(element);
		if(diagramElements.size()>0){
			return notify(command, diagramElements, actionType);
		}else{
			eventHappened(AppBrowser.get(), command, actionType);
			notifyUpdateCommander(command.getNotificationType(), element);
			return null;
		}
	}
	
	public String notify(ModelCommand command, List<RefOntoUML.Element> elements, ActionType actionType){
		List<DiagramElement> diagramElements = OccurenceManager.get().getDiagramElements(elements);
		if(diagramElements.size()>0){
			return notify(command, diagramElements, actionType);
		}else{
			eventHappened(AppBrowser.get(), command, actionType);			
			for(Element e: elements) {
				notifyUpdateCommander(command.getNotificationType(), e);
			}
			return null;
		}
	}
	
	//--- Notify application that a command caused a change on a diagram element ----
	
	public String notify(GenericCommand command, DiagramElement element, ActionType actionType){
		List<DiagramElement> list = new ArrayList<DiagramElement>();
		list.add(element);
		return notify(command,list, actionType);
	}
	
	public String notify(GenericCommand command, List<DiagramElement> elements, ActionType actionType){
		if(elements.size()==0) return null;
		NotificationType changeType = command.getNotificationType();
		if(changeType==null) changeType = NotificationType.MODIFY;
		for(DiagramElement element: elements){
			StructureDiagram diagram = (StructureDiagram) element.getDiagram();
			ProjectManager.get().getProject().saveDiagramNeeded(diagram,true);		
			eventHappened(diagram, command, actionType);
			notifyUpdateCommander(changeType, element);			
		}
		String text = getStatus(elements, changeType, actionType);
		if(command !=null && command instanceof IDiagramCommand){
			IDiagramCommand diagramCmd = (IDiagramCommand)command;
			diagramCmd.getOntoumlEditor().getWrapper().getStatusBar().report(text);
		}
		return text;
	}
	
	//--- Notify application ---
	
	private void notifyUpdateCommander(NotificationType changeType, DiagramElement element){
		Element modelObject = (Element)element.getModelObject();
		notifyUpdateCommander(changeType, modelObject);
	}
	
	private void notifyUpdateCommander(NotificationType changeType, Element element){		
		if(changeType==NotificationType.ADD) UpdateCommander.get().updateFromAddition(element);
		if(changeType==NotificationType.DELETE) UpdateCommander.get().updateFromDeletion(element);		
		if(changeType==NotificationType.RENAME) UpdateCommander.get().updateFromChange(element, false);
		if(changeType==NotificationType.RENAME_LABEL) UpdateCommander.get().updateFromChange(element, false);
		if(changeType==NotificationType.RESIZE) UpdateCommander.get().updateFromChange(element, false);
		if(changeType==NotificationType.MODIFY) UpdateCommander.get().updateFromChange(element, false);
	}		
			
	//--- undoable event has happened ---
	
	private void eventHappened(Object sourceComponent, UndoableEdit command, ActionType actionType){
		if(command !=null && actionType!=ActionType.UNDO){			
			UndoableEditEvent event = new UndoableEditEvent(sourceComponent, command);
			for (UndoableEditListener l : getUndoableEditListeners())  l.undoableEditHappened(event);
		}
	}

	//--- status ---
	
	@SuppressWarnings("unused")
	private String getStatus(DiagramElement element, NotificationType notificationType, ActionType actionType){
		List<DiagramElement> l = new ArrayList<DiagramElement>();
		l.add(element);
		return getStatus(element, notificationType,actionType);
	}
	
	private String getStatus(List<DiagramElement> elements, NotificationType notificationType, ActionType actionType){
		StringBuilder sb = new StringBuilder();		
		sb.append(actionType.getName());		
		if(actionType==ActionType.DO) sb.append(notificationType.getPast());
		else sb.append(" "+notificationType.getPresent());
		if(elements.size()>0) sb.append(": "); else sb.append("...");
		for (int i = 0; i < elements.size(); i++){
			DiagramElement element = elements.get(i);			
			if(element instanceof ClassElement) sb.append(((ClassElement)element).getClassifier() + (i < elements.size()-1 ? ", " : ""));
			if(element instanceof BaseConnection) sb.append(((BaseConnection)element).getRelationship() + (i < elements.size()-1 ? ", " : ""));			
			if(element instanceof SimpleLabel) sb.append(((Label) element).getSource().getLabelText());			
		}
		return capitalize(sb.toString());
	}
			
	private String capitalize(String s){
		if (s.length() == 0) return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
}
