package net.menthor.editor.v2.ui.notify;

import javax.swing.undo.AbstractUndoableEdit;

public abstract class GenericCommand extends AbstractUndoableEdit implements ICommand {

	private static final long serialVersionUID = 2761186015906877743L;
	
	protected boolean isRedo = false; //if this is a redo command or not
	
	@Override
	public void run() {
	
	}
}
