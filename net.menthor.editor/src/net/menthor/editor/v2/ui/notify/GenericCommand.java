package net.menthor.editor.v2.ui.notify;

import javax.swing.undo.AbstractUndoableEdit;

public abstract class GenericCommand extends AbstractUndoableEdit implements IUndoableCommand {

	private static final long serialVersionUID = 2761186015906877743L;
	
	protected Notifier notifier = Notifier.get();
	protected boolean isRedo = false;
	
	@Override
	public void redo(){
		isRedo = true;
		super.redo();
		run();	
	}
	
	public void run(){}
}
