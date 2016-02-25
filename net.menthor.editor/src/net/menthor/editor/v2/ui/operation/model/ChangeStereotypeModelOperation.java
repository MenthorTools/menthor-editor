package net.menthor.editor.v2.ui.operation.model;

import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.OccurenceMap;

import RefOntoUML.Class;
import RefOntoUML.Classifier;
import RefOntoUML.Relationship;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.editor.v2.ui.operation.ModelOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class ChangeStereotypeModelOperation extends ModelOperation {

	private static final long serialVersionUID = 7518976801833128513L;
	
	public enum InvertMode {ENDPOINTS, MULTIPLICITIES, TYPES, NAMES};
	
	private Relationship relationship;
	private Classifier _class; 
	private RelationshipType newRelationshipType, oldRelationshipType;
	private ClassType newClassType, oldClassType;
	private boolean isClass;
	
	public ChangeStereotypeModelOperation(Relationship relationship, RelationshipType newRelationshipType){
		super();
		this.operationType = OperationType.MODIFY;

		this.relationship = relationship;
		this.newRelationshipType = newRelationshipType;
		this.oldRelationshipType = RelationshipType.getRelationEnum(relationship);
		this.isClass = false;
	}
	
	public ChangeStereotypeModelOperation(Classifier _class, ClassType newClassType){
		super();
		this.operationType = OperationType.MODIFY;
		
		this._class = _class;
		this.newClassType = newClassType;
		this.oldClassType = ClassType.getClassEnum(_class);
		this.isClass = true;
	}
		
	@Override
	public void undo(){
		super.undo();
		changeStereotype();
		System.out.println(undoStatus());
	}
	
	@Override
	public void run() {	    
		super.run();
		changeStereotype();
		System.out.println(runStatus());
	}
	
	private String undoStatus(){
		return "[undo "+operationType.presentTense()+"] : "+relationship;
	}

	private String runStatus(){
		return "["+operationType.pastTense()+"] : "+relationship;
	}
	
	private void changeStereotype(){
		if(isClass){
			changeClassStereotype();
		}
		else{
			changeRelationStereotype();
		}
	}
	
	/** Change relation stereotype */ 
	private void changeRelationStereotype(){
		
		RelationshipType stereotype;
		
		if(isUndo()){
			stereotype = oldRelationshipType;
		}
		else{
			stereotype = newRelationshipType;
		}
		
   		OutcomeFixer fixer = new OutcomeFixer(ProjectUIController.get().getProject().getModel());
   		Fix fix = fixer.changeRelationStereotypeTo(relationship, fixer.getRelationshipStereotype(stereotype.getName()));
   		relationship = fix.getAddedByType(Relationship.class).get(0);
   		
   		UpdateCommander.get().update(fix);
   	}
	
	/** Change a class stereotype */ 
	public void changeClassStereotype(){
		ClassType stereotype;
		
		if(isUndo()){
			stereotype = oldClassType;
		}
		else{
			stereotype = newClassType;
		}
		
		//gets existing diagram occurrences for the class subject to change
		List<DiagramElement> diagramElements = OccurenceMap.get().getDiagramElements(_class);		
   		
		OutcomeFixer fixer = new OutcomeFixer(ProjectUIController.get().getProject().getModel());
   		Fix fix = fixer.changeClassStereotypeTo(_class, fixer.getClassStereotype(stereotype.getName()));   	
   		_class = fix.getAddedByType(Class.class).get(0);
   		
   		//sets the coordinates to recreate the classes on the diagrams on the same position
   		for(DiagramElement de: diagramElements){
	   		if (de !=null && de instanceof ClassElement) {
	   			double x = ((ClassElement)de).getAbsoluteX1();
	   			double y = ((ClassElement)de).getAbsoluteY1();   	   		
	   	   		fix.setAddedPosition(fix.getAdded().get(0),x,y);
	   		}
   		}
   		
   		UpdateCommander.get().update(fix);
	}
}
