package net.menthor.editor.v2.ui.operation.model;

import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.OccurenceMap;

import RefOntoUML.Class;
import RefOntoUML.Element;
import RefOntoUML.Relationship;

import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;

import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.OntoUMLMetatype;
import net.menthor.editor.v2.types.RelationshipType;

import net.menthor.editor.v2.ui.controller.ProjectUIController;

import net.menthor.editor.v2.ui.operation.ModelOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class ChangeStereotypeModelOperation extends ModelOperation {

	private static final long serialVersionUID = 7518976801833128513L;
	
	private Element element;
	private List<DiagramElement> diagramElements;
	private OntoUMLMetatype newType, oldType;	
	private RefOntoUML.Package model = ProjectUIController.get().getProject().getModel();
	
	public ChangeStereotypeModelOperation(){
		super();
		this.operationType = OperationType.SUBSTITUTE;
	}
	
	public ChangeStereotypeModelOperation(RefOntoUML.Relationship element, RelationshipType newStereotype){
		this();
		this.element = element;
		diagramElements = OccurenceMap.get().getDiagramElements(element);
		this.newType = newStereotype;
		this.oldType = RelationshipType.getRelationshipType(element);
	}
	
	public ChangeStereotypeModelOperation(RefOntoUML.Classifier class_, ClassType newStereotype){
		this();
		this.element = class_;
		diagramElements = OccurenceMap.get().getDiagramElements(element);
		this.newType = newStereotype;
		this.oldType = ClassType.getClassType(class_);
	}
		
	public ChangeStereotypeModelOperation(RefOntoUML.Classifier datatype, DataType newStereotype){
		this();
		this.element = datatype;
		diagramElements = OccurenceMap.get().getDiagramElements(element);
		this.newType = newStereotype;
		this.oldType = DataType.getDataType(datatype);
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
		if(newType instanceof ClassType) fix = changeClassStereotype();
		if(newType instanceof DataType) fix = changeDataTypeStereotype();
		if(newType instanceof RelationshipType) fix = changeRelationshipStereotype();
		return fix;
	}
	
	private Fix changeRelationshipStereotype(){		
		RelationshipType stereotype = (RelationshipType)newType;		
		if(isUndo()) stereotype = (RelationshipType)oldType;				
		OutcomeFixer fixer = new OutcomeFixer(model);
   		Fix fix = fixer.changeRelationStereotypeTo(element, fixer.getRelationshipStereotype(stereotype.getName()));
   		element = fix.getAddedByType(Relationship.class).get(0);   		
   		return fix;   		
   	}
	
	@SuppressWarnings("unused")
	public Fix changeDataTypeStereotype(){
		DataType stereotype = (DataType)newType;		
		if(isUndo()) stereotype = (DataType)oldType;		
		OutcomeFixer fixer = new OutcomeFixer(model);
   		Fix fix = null;   		  		
		return fix;
	}
		 
	public Fix changeClassStereotype(){
		ClassType stereotype = (ClassType)newType;		
		if(isUndo()) stereotype = (ClassType)oldType;   		
		OutcomeFixer fixer = new OutcomeFixer(model);
   		Fix fix = fixer.changeClassStereotypeTo(element, fixer.getClassStereotype(stereotype.getName()));   	
   		element = fix.getAddedByType(Class.class).get(0);   		
   		diagramElements = OccurenceMap.get().getDiagramElements(element);   		
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
