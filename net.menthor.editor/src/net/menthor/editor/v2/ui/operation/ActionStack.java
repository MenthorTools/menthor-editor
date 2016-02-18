package net.menthor.editor.v2.ui.operation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

import net.menthor.editor.v2.ui.app.AppBrowser;
import net.menthor.editor.v2.ui.app.manager.AppMessageManager;

public class ActionStack {

	// -------- Lazy Initialization
	
	private static class ActionStackLoader {
        private static final ActionStack INSTANCE = new ActionStack();
    }	
	public static ActionStack get() { 
		return ActionStackLoader.INSTANCE; 
	}	
    private ActionStack() {
    	editListeners.add(undoManager);
        if (ActionStackLoader.INSTANCE != null) throw new IllegalStateException("ActionStack already instantiated");
    }		
    
    // ----------------------------
    
	private List<UndoableEditListener> editListeners = new ArrayList<UndoableEditListener>();
	private UndoManager undoManager = new UndoManager(); 
	
	public UndoManager getUndoManager(){ return undoManager; }		
	public List<UndoableEditListener> getUndoableEditListeners(){ return editListeners; }
	
	public void register(GenericOperation op){
		ActionType actionType = getActionType(op);
		if(op instanceof ModelOperation) {
			register(AppBrowser.get(), op, actionType);
		}
		if(op instanceof IDiagramOperation) {
			register(((IDiagramOperation)op).getOntoumlEditor(), op, actionType);
		}
	}
	
	public void undo(){	
		if(getUndoManager().canUndo()) getUndoManager().undo();						
		else AppMessageManager.get().showInfo("Cannot Undo", "No other action to be undone.\n\n");
	}
	
	public void redo(){	
		if(getUndoManager().canRedo()) getUndoManager().redo();						
		else AppMessageManager.get().showInfo("Cannot Redo", "No other action to be redone.\n\n");
	}
	
	private void register(Object sourceComponent, UndoableEdit op, ActionType actionType){
		if(op !=null && actionType!=ActionType.UNDO){			
			UndoableEditEvent event = new UndoableEditEvent(sourceComponent, op);
			for (UndoableEditListener l : getUndoableEditListeners())  l.undoableEditHappened(event);
		}
	}
	
	private ActionType getActionType(GenericOperation op){
		ActionType actionType = ActionType.DO;
		if(op!=null && op.getActionType()!=null){
			actionType = op.getActionType();			
		}
		return actionType;
	}
		
}
