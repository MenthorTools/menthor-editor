package net.menthor.editor.v2.ui.operation.model;

import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.OccurenceMap;

import RefOntoUML.Class;
import RefOntoUML.Element;
import RefOntoUML.Relationship;
import RefOntoUML.stereotypes.ClassStereotype;
import RefOntoUML.stereotypes.DataTypeStereotype;
import RefOntoUML.stereotypes.OntoUMLStereotype;
import RefOntoUML.stereotypes.RelationshipStereotype;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import net.menthor.editor.v2.ui.controller.ProjectUIController;

import net.menthor.editor.v2.ui.operation.ModelOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class ChangeStereotypeModelOperation extends ModelOperation {

	private static final long serialVersionUID = 7518976801833128513L;
	
	private Element element;
	
	private OntoUMLStereotype newType, oldType;	
	private RefOntoUML.Package model = ProjectUIController.get().getProject().getModel();
	
	public ChangeStereotypeModelOperation(){
		super();
		this.operationType = OperationType.SUBSTITUTE;
	}
	
	public ChangeStereotypeModelOperation(RefOntoUML.Relationship element, RelationshipStereotype newStereotype){
		this();
		this.element = element;
		this.newType = newStereotype;
		this.oldType = RelationshipStereotype.getRelationshipType(element);
	}
	
	public ChangeStereotypeModelOperation(RefOntoUML.Classifier class_, ClassStereotype newStereotype){
		this();
		this.element = class_;
		this.newType = newStereotype;
		this.oldType = ClassStereotype.getClassType(class_);
	}
		
	public ChangeStereotypeModelOperation(RefOntoUML.Classifier datatype, DataTypeStereotype newStereotype){
		this();
		this.element = datatype;
		this.newType = newStereotype;
		this.oldType = DataTypeStereotype.getDataType(datatype);
	}
	
	private String undoStatus(){
		return "[undo "+operationType.presentTense()+"] : "+element;
	}

	private String runStatus(){
		return "["+operationType.pastTense()+"] : "+element;
	}
	
	@Override
	public void undo(){
		super.undo();
		Fix fix = changeStereotype();
		System.out.println(undoStatus());
		notifier.notifyChange(this, fix);		
	}
	
	@Override
	public void run() {	    
		super.run();
		Fix fix = changeStereotype();
		System.out.println(runStatus());
		notifier.notifyChange(this, fix);	
	}
	
	private Fix changeStereotype(){
		Fix fix = null;
		if(newType instanceof ClassStereotype) fix = changeClassStereotype();
		if(newType instanceof DataTypeStereotype) fix = changeDataTypeStereotype();
		if(newType instanceof RelationshipStereotype) fix = changeRelationshipStereotype();
		return fix;
	}
	
	private Fix changeRelationshipStereotype(){		
		RelationshipStereotype stereotype = (RelationshipStereotype)newType;		
		if(isUndo()) stereotype = (RelationshipStereotype)oldType;				
		OutcomeFixer fixer = new OutcomeFixer(model);
   		Fix fix = fixer.changeRelationStereotypeTo(element, fixer.getRelationshipStereotype(stereotype.getName()));
   		element = fix.getAddedByType(Relationship.class).get(0);   		
   		return fix;   		
   	}
	
	@SuppressWarnings("unused")
	public Fix changeDataTypeStereotype(){
		DataTypeStereotype stereotype = (DataTypeStereotype)newType;		
		if(isUndo()) stereotype = (DataTypeStereotype)oldType;		
		OutcomeFixer fixer = new OutcomeFixer(model);
   		Fix fix = null;   		  		
		return fix;
	}
		 
	public Fix changeClassStereotype(){
		ClassStereotype stereotype = (ClassStereotype)newType;		
		if(isUndo()) stereotype = (ClassStereotype)oldType;   		
		List<DiagramElement> diagramElements = OccurenceMap.get().getDiagramElements(element);
		OutcomeFixer fixer = new OutcomeFixer(model);   		
		Fix fix = fixer.changeClassStereotypeTo(element, fixer.getClassStereotype(stereotype.getName()));   	
   		element = fix.getAddedByType(Class.class).get(0);
   		for(DiagramElement de: diagramElements){
	   		if (de !=null && de instanceof ClassElement) {
	   			double x = ((ClassElement)de).getAbsoluteX1();
	   			double y = ((ClassElement)de).getAbsoluteY1();   	   		
	   	   		fix.setAddedPosition(fix.getAdded().get(0),x,y);
	   		}
   		}   		
   		return fix;
	}
}
