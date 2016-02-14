package net.menthor.editor.v2.ui.operation;

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
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.app.AppBrowser;
import net.menthor.editor.v2.ui.app.manager.AppMessageManager;
import net.menthor.editor.v2.ui.operation.diagram.DeleteOperation;

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
	
	//--- undo & redo ---
	
	public void undo(){	
		if(getUndoManager().canUndo()) getUndoManager().undo();						
		else AppMessageManager.get().showInfo("Cannot Undo", "No other action to be undone.\n\n");
	}
	
	public void redo(){	
		if(getUndoManager().canRedo()) getUndoManager().redo();						
		else AppMessageManager.get().showInfo("Cannot Redo", "No other action to be redone.\n\n");
	}
	
	//--- Notify application ---
	
	public void notifyViewChange(GenericOperation op, ActionType actionType, List<DiagramElement> elements){
		registerUndoableOperation(op, actionType);
		notifyDiagrams(elements);
		reportStatus(op, actionType, elements);
	}
	
	public void notifyViewChange(final GenericOperation op, final ActionType actionType, final DiagramElement element){
		registerUndoableOperation(op, actionType);		
		notifyDiagrams(element);
		reportStatus(op, actionType, element);		
	}
	
	public void notifyChange(final GenericOperation op, final ActionType actionType, final List<Element> elements){		
		registerUndoableOperation(op, actionType);
		notifyDiagrams(elements);			
		notifyApplication(op, actionType, elements);		
		reportStatus(op, actionType, elements);	
	}
	
	public void notifyChange(final GenericOperation op, final ActionType actionType, final Element element){		
		registerUndoableOperation(op, actionType);		
		notifyDiagrams(element);
		notifyApplication(op, actionType, element);
		reportStatus(op, actionType, element);		
	}		

	//--- notify application a change has happened on element(s)
	//--- the application will update the parser, project browser, diagrams and 
	//--- and all tabs according to the operation executed
	
	/** notify application a change has happened from a operation */
	private void notifyApplication(GenericOperation op, ActionType actionType, Object elements){						
		notifyAdditions(op, actionType, elements); 
		notifyDeletions(op, actionType, elements);
		notifyModifications(op, actionType, elements);
	}
	
	@SuppressWarnings("unchecked")
	private void notifyModifications(GenericOperation op, ActionType actionType, Object elements){
		OperationType operType = getOperationType(op);
		if(operType!=OperationType.ADD || operType!=OperationType.DELETE) {
			if(elements instanceof List<?>) UpdateCommander.get().updateFromChange((List<Element>)elements, false);
			else UpdateCommander.get().updateFromChange((Element)elements, false);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void notifyDeletions(GenericOperation op, ActionType actionType, Object elements){
		OperationType operType = getOperationType(op);
		if(operType==OperationType.DELETE){			
			if(op instanceof DeleteOperation) {
				boolean isAChangeOnly = ((DeleteOperation)op).isOnlyFromDiagram();
				if(isAChangeOnly){
					if(elements instanceof List<?>) UpdateCommander.get().updateFromChange((List<Element>)elements, false);
					else UpdateCommander.get().updateFromChange((Element)elements, false);
					return;
				}
			}
			if(actionType==ActionType.UNDO) {
				if(elements instanceof List<?>) UpdateCommander.get().updateFromAddition((List<Element>)elements);
				else UpdateCommander.get().updateFromAddition((Element)elements);
			}else {
				if(elements instanceof List<?>) UpdateCommander.get().updateFromDeletion((List<Element>)elements);
				else UpdateCommander.get().updateFromDeletion((Element)elements);
			}							
		}
	}
	
	@SuppressWarnings("unchecked")
	private void notifyAdditions(GenericOperation op, ActionType actionType, Object elements){
		OperationType operType = getOperationType(op);
		if(operType==OperationType.ADD){
			if(actionType==ActionType.UNDO) {
				if(elements instanceof List<?>) UpdateCommander.get().updateFromDeletion((List<Element>)elements);
				else UpdateCommander.get().updateFromDeletion((Element)elements);
			}
			else {
				if(elements instanceof List<?>) UpdateCommander.get().updateFromAddition((List<Element>)elements);
				else UpdateCommander.get().updateFromAddition((Element)elements);
			}
		}
	}
	
	//--- notify diagrams a change has happened on element(s) ---
	
	/** diagrams in which this element appear must be notified. */
	private void notifyDiagrams(Element element){		
		List<DiagramElement> deList = OccurenceManager.get().getDiagramElements(element);
		for(DiagramElement elem: deList){
			StructureDiagram diagram = (StructureDiagram)elem.getDiagram();
			ProjectManager.get().getProject().saveDiagramNeeded(diagram,true);
		}
	}
	
	/** diagrams in which this element appear must be notified. */
	private void notifyDiagrams(DiagramElement de){
		StructureDiagram diagram = (StructureDiagram) de.getDiagram();
		ProjectManager.get().getProject().saveDiagramNeeded(diagram,true);
	}

	/** diagrams in which these elements appear must be notified. */
	private void notifyDiagrams(List<?> elements){
		for(Object de: elements){
			if(de instanceof DiagramElement) notifyDiagrams((DiagramElement)de);
			else if(de instanceof Element) notifyDiagrams((Element)de);
		}
	}
	
	//--- operation type for a command ---
	
	private OperationType getOperationType(GenericOperation op){
		OperationType changeType = op.getOperationType();
		if(changeType==null) changeType = OperationType.MODIFY;
		return changeType;
	}
	
	//--- register undoable event ---
	
	private void registerUndoableOperation(GenericOperation op, ActionType actionType){
		if(op instanceof ModelOperation) {
			registerUndoableEvent(AppBrowser.get(), op, actionType);
		}
		if(op instanceof IDiagramOperation) {
			registerUndoableEvent(((IDiagramOperation)op).getOntoumlEditor(), op, actionType);
		}
	}
	
	private void registerUndoableEvent(Object sourceComponent, UndoableEdit op, ActionType actionType){
		if(op !=null && actionType!=ActionType.UNDO){			
			UndoableEditEvent event = new UndoableEditEvent(sourceComponent, op);
			for (UndoableEditListener l : getUndoableEditListeners())  l.undoableEditHappened(event);
		}
	}

	//--- status ---
	
	private void reportStatus(GenericOperation op, ActionType actionType, Object element){	
		String status = getStatus(op, actionType, element);
		if(op !=null && op instanceof IDiagramOperation){
			IDiagramOperation diagramCmd = (IDiagramOperation)op;
			if(diagramCmd.getOntoumlEditor()!=null){
				diagramCmd.getOntoumlEditor().getWrapper().getStatusBar().report(status);
				diagramCmd.getOntoumlEditor().cancelEditing();
			}
		}
	}
	
	private String getStatus(GenericOperation op, ActionType actionType, Object element){
		List<Object> l = new ArrayList<>();
		l.add(element);
		return getStatus(op,actionType, l);
	}
	
	private String getStatus(GenericOperation op, ActionType actionType,List<Object> elements){
		StringBuilder sb = new StringBuilder();		
		sb.append(actionType.getName());		
		if(actionType==ActionType.DO) sb.append(op.getOperationType().pastTense());
		else sb.append(" "+op.getOperationType().presentTense());
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
