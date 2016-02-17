package net.menthor.editor.v2.ui.operation.diagram;

import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.AssociationElement.ReadingDesign;

import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class ReadingDesignOperation extends DiagramOperation{

	private static final long serialVersionUID = -444736590798129291L;

	private ReadingDesign newReading, oldReading;
	private AssociationElement association;
	
	public ReadingDesignOperation(OntoumlEditor editor, AssociationElement association, ReadingDesign newReading){
		super();
		this.operationType = OperationType.VISIBILITY;
		this.ontoumlEditor = editor;		
		this.association = association;
		this.oldReading = association.getReadingDesign();
		this.newReading = newReading;
	}
	

	
	@Override
	public String undoMessage(){
		return super.undoMessage()+association;
	}
	
	@Override
	public String runMessage(){
		return super.runMessage()+association;
	}
	
	@Override
	public void undo() {
		super.undo();
		association.setReadingDesign(oldReading);
		notifier.notifyViewChange(this, association);
	}
	
	@Override
	public void run() {
		super.run();
		association.setReadingDesign(newReading);
		notifier.notifyViewChange(this, association);		
	}	
}
