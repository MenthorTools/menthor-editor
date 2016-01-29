package net.menthor.editor.v2.managers;

import org.tinyuml.ui.diagram.DiagramEditor;

public class RedoManager extends BaseManager {

	private static RedoManager instance = new RedoManager();
	public static RedoManager get() { return instance; }
	
	public void redo(){
		DiagramEditor editor = TabManager.get().getCurrentDiagramEditor();
		if(editor==null) return;		
		if(editor.canRedo()) editor.redo();
		else MessageManager.get().showError("Cannot Redo", "No other action to be redone.\n");			
	}
}
