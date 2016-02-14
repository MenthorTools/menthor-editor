package net.menthor.editor.v2.ui.operation.diagram;

import org.tinyuml.draw.CompositeNode;
import org.tinyuml.draw.Label;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.ClassElement;

import RefOntoUML.Element;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class RenameLabelOperation extends DiagramOperation {

	private static final long serialVersionUID = 5701807952287882396L;
	
	protected Label label;
	protected String text, oldText;
	protected CompositeNode parent;

	public RenameLabelOperation(OntoumlEditor editor, Label aLabel, String aText) {
		this.ontoumlEditor = editor;
		this.operationType = OperationType.RENAME_LABEL;
		label = aLabel;
		text = aText;
		oldText = aLabel.getNameLabelText();
		if (aLabel.getParent()!=null) { parent = aLabel.getParent().getParent();} 
	}

	protected void runWithoutNotifying(){
		String oldName = label.getNameLabelText();		
		label.setNameLabelText(text);		
		// replace all references in constraints
		if (parent instanceof ClassElement){			
			for(OclDocument oclDoc: ProjectManager.get().getProject().getOclDocList()){
				String currentConstraints = oclDoc.getContentAsString();
				String newConstraints = currentConstraints.replaceAll(oldName,text);
				oclDoc.setContentAsString(newConstraints);
			}									
		}
	}

	protected void undoWithoutNotifying(){
		label.setNameLabelText(oldText);				
		// replace all references in constraints
		if (parent instanceof ClassElement){	
			for(OclDocument oclDoc: ProjectManager.get().getProject().getOclDocList()){
				String currentConstraints = oclDoc.getContentAsString();
				String newConstraints = currentConstraints.replaceAll(text,oldText);
				oclDoc.setContentAsString(newConstraints);
			}			
		}	
	}
	
	@Override
	public void run() {
		super.run();						
		runWithoutNotifying();		
		System.out.println(runStatus());
		notifier.notifyChange(this, isRedo ? ActionType.REDO : ActionType.DO, (Element)parent.getModelObject());			
	}
	
	@Override
	public void undo(){
		super.undo();		
		undoWithoutNotifying();
		System.out.println(undoStatus());
		notifier.notifyChange(this, ActionType.UNDO, (Element)parent.getModelObject());					
	}
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] "+ontoumlEditor.getDiagram()+": "+parent;
	}
	
	public String runStatus(){
		return "["+operationType.pastTense()+"] "+ontoumlEditor.getDiagram()+": "+parent;
	}
}
