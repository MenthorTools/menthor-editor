package net.menthor.editor.v2.managers;

import org.tinyuml.ui.diagram.DiagramEditor;

public class UndoManager extends BaseManager {

	private static UndoManager instance = new UndoManager();
	public static UndoManager get() { return instance; }
	
	public void undo(){	
		DiagramEditor editor = TabManager.get().getCurrentDiagramEditor();
		if(editor==null) return;		
		if(editor.canUndo()) editor.undo();
		else MessageManager.get().showError("Cannot Undo", "No other action to be undone.\n");
	}
}
