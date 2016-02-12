package net.menthor.editor.v2.ui.notify;

public abstract class ModelCommand extends GenericCommand {
	
	private static final long serialVersionUID = 733613330226013575L;	

	@Override
	public void undo(){
		super.undo();		
	}
	
	@Override
	public void run(){
		super.run();		
	}
}
