package net.menthor.editor.v2.ui.operation.model;

import RefOntoUML.NamedElement;
import net.menthor.editor.v2.ui.operation.ModelOperation;
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
		undoWithoutNotifying();
		notifier.notifyChange(this, namedElement);
	}
	
	@Override
	public void run() {
		runWithoutNotifying();
		notifier.notifyChange(this, namedElement);
	}
	
	public void undoWithoutNotifying(){
		super.undo();
		namedElement.setName(oldName);
		System.out.println(undoMessage());
	}
	
	public void runWithoutNotifying(){
		super.run();
		namedElement.setName(newName);
		System.out.println(runMessage());
	}
	
	@Override
	public String undoMessage(){
		return super.undoMessage()+namedElement+" to "+oldName;
	}
	
	@Override
	public String runMessage(){
		return super.runMessage()+namedElement+" to "+newName;
	}
	
}
