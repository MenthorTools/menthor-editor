package net.menthor.editor.v2.ui.operation.model;

import RefOntoUML.NamedElement;
import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.ModelOperation;
import net.menthor.editor.v2.ui.operation.Notifier;
import net.menthor.editor.v2.ui.operation.OperationType;

public class RenameModelOperation extends ModelOperation {

	private static final long serialVersionUID = 1L;
	
	protected NamedElement namedElement;
	protected String newName;
	protected String oldName;
	
	public RenameModelOperation(){
		super();
		this.operationType = OperationType.RENAME;
	}
	
	public RenameModelOperation(NamedElement namedElement, String newName) {				
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
		System.out.println(undoStatus());
	}
	
	public void runWithoutNotifying(){
		namedElement.setName(newName);
		System.out.println(runStatus());
	}
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] Model: "+namedElement;
	}
	
	public String runStatus(){
		return "["+operationType.pastTense()+"] Model: "+namedElement;
	}
	
}
