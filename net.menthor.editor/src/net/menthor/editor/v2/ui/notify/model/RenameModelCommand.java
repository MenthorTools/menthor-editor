package net.menthor.editor.v2.ui.notify.model;

import RefOntoUML.NamedElement;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.ModelCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;
import net.menthor.editor.v2.ui.notify.Notifier;

public class RenameModelCommand extends ModelCommand {

	private static final long serialVersionUID = 1L;
	
	protected NamedElement namedElement;
	protected String newName;
	protected String oldName;
	
	public RenameModelCommand(){
		super();
		this.notificationType = NotificationType.RENAME;
	}
	
	public RenameModelCommand(NamedElement namedElement, String newName) {				
		this();
		this.namedElement = namedElement;		
		if(newName!=null){
			this.newName = newName;
		}else{ 
			this.newName = "";
		}
		if(namedElement.getName()!=null){
			this.oldName = namedElement.getName();
		}else{
			this.oldName = "";
		}		
	}

	@Override
	public void undo() {
		super.undo();
		undoWithoutNotifying();
		Notifier.get().notifyChange(this, ActionType.UNDO, namedElement);
	}
	
	@Override
	public void run() {
		super.run();
		runWithoutNotifying();
		Notifier.get().notifyChange(this, isRedo ? ActionType.REDO : ActionType.DO, namedElement);
	}
	
	public void undoWithoutNotifying(){
		namedElement.setName(oldName);
	}
	
	public void runWithoutNotifying(){
		namedElement.setName(newName);
	}
}
