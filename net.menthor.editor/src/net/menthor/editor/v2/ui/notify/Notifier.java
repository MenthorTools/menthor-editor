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
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Element;
import net.menthor.editor.v2.commanders.UpdateCommander;
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
	
	//--- Notify application ---
	
	public void notifyChangeOnView(GenericCommand command, ActionType actionType, List<DiagramElement> elements){
		registerUndoableEvent(command, actionType);
		for(DiagramElement de: elements){				
			StructureDiagram diagram = (StructureDiagram) de.getDiagram();
			ProjectManager.get().getProject().saveDiagramNeeded(diagram,true);
			notifyApplication(command, actionType,(Element)de.getModelObject());
		}
		reportStatus(command, actionType, elements);
	}
	
	public void notifyChangeOnView(GenericCommand command, ActionType actionType, DiagramElement element){
		Element modelObject = (Element)element.getModelObject();
		StructureDiagram diagram = (StructureDiagram) element.getDiagram();
		ProjectManager.get().getProject().saveDiagramNeeded(diagram,true);
		registerUndoableEvent(command, actionType);		
		notifyApplication(command, actionType, modelObject);
		reportStatus(command, actionType, modelObject);	
	}
	
	public void notifyChange(GenericCommand command, ActionType actionType, List<Element> elements){		
		registerUndoableEvent(command, actionType);
		for(Element e: elements) {					
			notifyApplication(command, actionType, e);			
		}
		reportStatus(command, actionType, elements);
	}
	
	public void notifyChange(GenericCommand command, ActionType actionType, Element element){		
		registerUndoableEvent(command, actionType);		
		notifyApplication(command, actionType, element);
		reportStatus(command, actionType, element);
	}		

	//--- notify application ---
	
	private void notifyApplication(GenericCommand command, ActionType actionType, Element element){		
		NotificationType changeType = command.getNotificationType();
		if(changeType==null) changeType = NotificationType.MODIFY;	
		
		if(changeType==NotificationType.ADD){
			if(actionType==ActionType.UNDO) UpdateCommander.get().updateFromDeletion(element);
			else UpdateCommander.get().updateFromAddition(element);
		}
		
		if(changeType==NotificationType.DELETE) {
			if(actionType==ActionType.UNDO) UpdateCommander.get().updateFromAddition(element);
			else UpdateCommander.get().updateFromDeletion(element);		
		}
		
		if(changeType==NotificationType.RENAME) UpdateCommander.get().updateFromChange(element, false);
		if(changeType==NotificationType.RENAME_LABEL) UpdateCommander.get().updateFromChange(element, false);
		if(changeType==NotificationType.RESIZE) UpdateCommander.get().updateFromChange(element, false);
		if(changeType==NotificationType.MODIFY) UpdateCommander.get().updateFromChange(element, false);
	}
	
	//--- register undoable event ---
	
	private void registerUndoableEvent(GenericCommand command, ActionType actionType){
		if(command instanceof ModelCommand) {
			registerUndoableEvent(AppBrowser.get(), command, actionType);
		}
		if(command instanceof IDiagramCommand) {
			registerUndoableEvent(((IDiagramCommand)command).getOntoumlEditor(), command, actionType);
		}
	}
	
	private void registerUndoableEvent(Object sourceComponent, UndoableEdit command, ActionType actionType){
		if(command !=null && actionType!=ActionType.UNDO){			
			UndoableEditEvent event = new UndoableEditEvent(sourceComponent, command);
			for (UndoableEditListener l : getUndoableEditListeners())  l.undoableEditHappened(event);
		}
	}

	//--- status ---
	
	private void reportStatus(GenericCommand command, ActionType actionType, Object element){	
		String status = getStatus(command, actionType, element);
		if(command !=null && command instanceof IDiagramCommand){
			IDiagramCommand diagramCmd = (IDiagramCommand)command;
			diagramCmd.getOntoumlEditor().getWrapper().getStatusBar().report(status);
			diagramCmd.getOntoumlEditor().cancelEditing();
		}
	}
	
	private String getStatus(GenericCommand command, ActionType actionType, Object element){
		List<Object> l = new ArrayList<>();
		l.add(element);
		return getStatus(command,actionType, l);
	}
	
	private String getStatus(GenericCommand command, ActionType actionType,List<Object> elements){
		StringBuilder sb = new StringBuilder();		
		sb.append(actionType.getName());		
		if(actionType==ActionType.DO) sb.append(command.getNotificationType().getPast());
		else sb.append(" "+command.getNotificationType().getPresent());
		if(elements.size()>0) sb.append(": "); else sb.append("[empty]");
		for (int i = 0; i < elements.size(); i++){
			Object element = elements.get(i);						
			if(element instanceof SimpleLabel) sb.append(((Label) element).getSource().getLabelText());
			else sb.append(elements.get(i) + (i < elements.size()-1 ? ", " : ""));
		}
		return capitalize(sb.toString());
	}
			
	private String capitalize(String s){
		if (s.length() == 0) return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
}
