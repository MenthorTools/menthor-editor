package net.menthor.editor.v2.ui.notify;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.Label;
import org.tinyuml.draw.SimpleLabel;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.BaseConnection;

import net.menthor.editor.v2.managers.ProjectManager;

public class Notification implements INotification {

	private OntoumlEditor diagramEditor;
	
	private List<UndoableEditListener> editListeners = new ArrayList<UndoableEditListener>();
	private UndoManager undoManager = new UndoManager(); 
	
	public UndoManager getUndoManager(){ return undoManager; }
	public OntoumlEditor getDiagramEditor(){ return diagramEditor; }
	public List<UndoableEditListener> getUndoableEditListeners(){ return editListeners; }
		
	public Notification(OntoumlEditor editor){
		this();
		diagramEditor = editor;		
	}
	
	public Notification(){
		editListeners.add(undoManager);	
	}
	
	public String notifyChange(GenericCommand command, List<DiagramElement> elements, NotificationType changeType, ActionType actionType){
		if(elements.size()==0) return null;		
		StructureDiagram diagram = (StructureDiagram) elements.get(0).getDiagram();
		ProjectManager.get().getProject().saveDiagramNeeded(diagram,true);		
		if(command !=null && actionType!=ActionType.UNDO){			
			UndoableEditEvent event = new UndoableEditEvent(diagram, command);
			for (UndoableEditListener l : getUndoableEditListeners())  l.undoableEditHappened(event);
		}
		String text = getStatus(elements, changeType, actionType);
		if(diagramEditor!=null){
			diagramEditor.getWrapper().getStatusBar().report(text);
		}
		return text;
	}
	
	private String getStatus(List<DiagramElement> elements, NotificationType notificationType, ActionType actionType){
		StringBuilder sb = new StringBuilder();		
		sb.append(actionTypeAsString(actionType));		
		sb.append(notificationTypeAsString(notificationType, actionType));
		if(elements.size()>0) sb.append(": "); else sb.append("...");
		for (int i = 0; i < elements.size(); i++){
			DiagramElement element = elements.get(i);			
			if(element instanceof ClassElement) sb.append(((ClassElement)element).getClassifier() + (i < elements.size()-1 ? ", " : ""));
			if(element instanceof BaseConnection) sb.append(((BaseConnection)element).getRelationship() + (i < elements.size()-1 ? ", " : ""));			
			if(element instanceof SimpleLabel) sb.append(((Label) element).getSource().getLabelText());			
		}
		return capitalize(sb.toString());
	}
	
	private String actionTypeAsString(ActionType actionType){
		if(actionType == ActionType.UNDO) {
			return "undo";
		} else if (actionType == ActionType.REDO) {
			return "redo";
		}
		return "";
	}
	
	private String notificationTypeAsString(NotificationType notificationType, ActionType actionType){
		switch (notificationType) {
			case ELEMENTS_ADDED: 
				if(actionType == ActionType.DO) return "added"; else return " add";				
			case ELEMENTS_REMOVED:
				if(actionType == ActionType.DO) return "deleted"; else return " delete";
			case ELEMENTS_DRAGGED:
				if(actionType == ActionType.DO) return "dragged"; else return " drag";
			case ELEMENTS_COLORED:
				if(actionType == ActionType.DO) return "colored"; else return " color";
			case ELEMENTS_ALIGNED:
				if(actionType == ActionType.DO) return "aligned"; else return " align";
			case VISIBILITY_CHANGED:
				if(actionType == ActionType.DO) return "visibility changed"; else return " change visibility";
			case ELEMENTS_MOVED:
				if(actionType == ActionType.DO) return "moved"; else return " move";
			case ELEMENTS_MODIFIED:
				if(actionType == ActionType.DO) return "modified"; else return " modify";
			case ELEMENTS_RESIZED:
				if(actionType == ActionType.DO) return "resized"; else return " resize";
			case CONNECTION_NAVEGABILITY_SET:
				if(actionType == ActionType.DO) return "navegability set"; else return " set navegability";
			case CONNECTION_TYPE_CONVERTED:
				if(actionType == ActionType.DO) return "connnection type converted"; else return " convert connnection type";
			case CONNECTION_POINT_EDITED:
				if(actionType == ActionType.DO) return "connection point edited"; else return " edit connnection point";
			case CONNECTION_POINTS_RESET:
				if(actionType == ActionType.DO) return "connection points reset"; else return " reset connection points";
			case LABEL_TEXT_SET:
				if(actionType == ActionType.DO) return "label text set"; else return " set label text";
			default:			
				break;
		}
		return "";
	}
	
	private String capitalize(String s){
		if (s.length() == 0) return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
}
