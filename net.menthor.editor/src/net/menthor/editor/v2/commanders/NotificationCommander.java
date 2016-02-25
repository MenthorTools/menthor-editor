package net.menthor.editor.v2.commanders;

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

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.Label;
import org.tinyuml.draw.SimpleLabel;
import org.tinyuml.umldraw.OccurenceMap;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Element;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.GenericOperation;
import net.menthor.editor.v2.ui.operation.IDiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;
import net.menthor.editor.v2.ui.operation.diagram.DeleteOperation;

public class NotificationCommander {

	// -------- Lazy Initialization
	
	private static class NotificationLoader {
        private static final NotificationCommander INSTANCE = new NotificationCommander();
    }	
	public static NotificationCommander get() { 
		return NotificationLoader.INSTANCE; 
	}	
    private NotificationCommander() {
        if (NotificationLoader.INSTANCE != null) throw new IllegalStateException("Notifier already instantiated");
    }		
    
    //--- Notify application ---
	
	public void notifyViewChange(GenericOperation op, List<DiagramElement> elements){
		notifyDiagrams(elements);
		reportStatus(op, elements);
	}
	
	public void notifyViewChange(final GenericOperation op, final DiagramElement element){
		notifyDiagrams(element);
		reportStatus(op, element);		
	}
	
	public void notifyChange(final GenericOperation op, final List<Element> elements){		
		notifyDiagrams(elements);			
		notifyApplication(op, elements);		
		reportStatus(op, elements);	
	}
	
	public void notifyChange(final GenericOperation op, final Element element){		
		notifyDiagrams(element);
		notifyApplication(op, element);
		reportStatus(op, element);		
	}		

	//--- notify application a change has happened on element(s)
	//--- the application will update the parser, project browser, diagrams and 
	//--- and all tabs according to the operation executed
	
	/** notify application a change has happened from a operation */
	private void notifyApplication(GenericOperation op, Object elements){						
		notifyAdditions(op, elements); 
		notifyDeletions(op, elements);
		notifyModifications(op, elements);
	}
	
	@SuppressWarnings("unchecked")
	private void notifyModifications(GenericOperation op, Object elements){
		OperationType operType = getOperationType(op);		
		if(operType!=OperationType.ADD && operType!=OperationType.DELETE) {
			if(elements instanceof List<?>) {
				UpdateCommander.get().updateFromChange((List<Element>)elements, false);
			}
			else {
				UpdateCommander.get().updateFromChange((Element)elements, false);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void notifyDeletions(GenericOperation op, Object elements){
		OperationType operType = getOperationType(op);
		ActionType actionType = getActionType(op);
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
	private void notifyAdditions(GenericOperation op, Object elements){
		OperationType operType = getOperationType(op);
		ActionType actionType = getActionType(op);
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
		List<DiagramElement> deList = OccurenceMap.get().getDiagramElements(element);
		for(DiagramElement elem: deList){
			StructureDiagram diagram = (StructureDiagram)elem.getDiagram();
			ProjectUIController.get().getProject().saveDiagramNeeded(diagram,true);
		}
	}
	
	/** diagrams in which this element appear must be notified. */
	private void notifyDiagrams(DiagramElement de){
		StructureDiagram diagram = (StructureDiagram) de.getDiagram();
		ProjectUIController.get().getProject().saveDiagramNeeded(diagram,true);
	}

	/** diagrams in which these elements appear must be notified. */
	private void notifyDiagrams(List<?> elements){
		for(Object de: elements){
			if(de instanceof DiagramElement) notifyDiagrams((DiagramElement)de);
			else if(de instanceof Element) notifyDiagrams((Element)de);
		}
	}
	
	//--- type of operation  ---
	
	private OperationType getOperationType(GenericOperation op){
		OperationType changeType = op.getOperationType();
		if(changeType==null) changeType = OperationType.MODIFY;
		return changeType;
	}
	
	private ActionType getActionType(GenericOperation op){
		ActionType actionType = ActionType.DO;
		if(op!=null && op.getActionType()!=null){
			actionType = op.getActionType();			
		}
		return actionType;
	}
	
	
	//--- status ---
	
	private void reportStatus(GenericOperation op, Object element){	
		String status = getStatus(op, element);
		if(op !=null && op instanceof IDiagramOperation){
			IDiagramOperation diagramCmd = (IDiagramOperation)op;
			if(diagramCmd.getOntoumlEditor()!=null){
				diagramCmd.getOntoumlEditor().getWrapper().getStatusBar().report(status);
				diagramCmd.getOntoumlEditor().cancelEditing();
			}
		}
	}
	
	private String getStatus(GenericOperation op, Object element){
		List<Object> l = new ArrayList<>();
		l.add(element);
		return getStatus(op, l);
	}
	
	private String getStatus(GenericOperation op, List<Object> elements){
		StringBuilder sb = new StringBuilder();	
		ActionType actionType = getActionType(op);
		if(actionType!=null){
			sb.append(actionType.getName());
			if(actionType==ActionType.DO) sb.append(op.getOperationType().pastTense());
			else sb.append(" "+op.getOperationType().presentTense());
		}		
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
