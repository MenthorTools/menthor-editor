package net.menthor.editor.v2.ui.operation.model;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import RefOntoUML.Classifier;
import RefOntoUML.Comment;
import RefOntoUML.Element;
import RefOntoUML.Property;
import net.menthor.editor.v2.MenthorDomain;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.editor.v2.ui.operation.ModelOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class AddModelOperation extends ModelOperation {

	private static final long serialVersionUID = 7518976801833128513L;

	protected RefOntoUML.Element element;
	protected RefOntoUML.Element eContainer;	
	
	public AddModelOperation(){
		super();
		this.operationType = OperationType.ADD;
	}
	
	public AddModelOperation(RefOntoUML.Element element, RefOntoUML.Element eContainer){
		this();
		this.element = element;		
		this.eContainer = eContainer;
	}
	
	@Override
	public void undo(){
		undoWithoutNotifying();
		notifier.notifyChange(this, element);
	}
	
	@Override
	public void run() {		
		runWithoutNotifying();
		notifier.notifyChange(this, element);
	}
	
	@Override
	public String runMessage(){
		return super.runMessage()+element+" to "+eContainer;
	}
	
	@Override
	public String undoMessage(){
		return super.undoMessage()+element+" to "+eContainer;
	}
	
	public void undoWithoutNotifying(){
		super.undo();	
		MenthorDomain.get().createDomain().getCommandStack().undo();
		System.out.println(this.undoMessage());
	}
	
	public void runWithoutNotifying(){	
		super.run();
		RefOntoUML.Package model = ProjectUIController.get().getProject().getModel();
		AdapterFactoryEditingDomain domain = MenthorDomain.get().createDomain();
		
		AddCommand emfCommand = null;
		if(eContainer==null && !packageContains(model, element)){
			emfCommand = new AddCommand(domain, model.getPackagedElement(), element);			
		}
		else if(isPackage(eContainer) && !(packageContains(eContainer, element))){			
			emfCommand = new AddCommand(domain, asPackage(eContainer).getPackagedElement(), element);
		}
		else if(isClassifier(eContainer) && isGeneralization(element)){
			emfCommand = new AddCommand(domain, asClassifier(eContainer).getGeneralization(), element);
		}
		else if(isElement(eContainer) && isComment(element) && !elementContains(eContainer,asComment(element))){			
			emfCommand = new AddCommand(domain, asElement(eContainer).getOwnedComment(), element);
		}
		else if(isClassifier(eContainer) && isConstraintx(element) && !constraintxContains(element, asClassifier(eContainer))){
			emfCommand = new AddCommand(domain, asClassifier(eContainer).getOwnedRule(), asConstraintx(element));					
		}
		else if(isClass(eContainer) && isProperty(element) && !classContains(eContainer, asProperty(element))){
			emfCommand = new AddCommand(domain, ((RefOntoUML.Class)eContainer).getOwnedAttribute(), element);
		}
		else if (isDataType(eContainer) && isProperty(element) && !dataTypeContains(eContainer,asProperty(element))){
			emfCommand = new AddCommand(domain, ((RefOntoUML.DataType)eContainer).getOwnedAttribute(), element);
		}		
		if(emfCommand!=null) {
			domain.getCommandStack().execute(emfCommand);
		}		
		System.out.println(runMessage());
	}
	
	public boolean isClassifier(Object o){ return o instanceof RefOntoUML.Classifier; }	
	public boolean isPackage(Object o){ return o instanceof RefOntoUML.Package; }
	public boolean isComment(Object o){ return o instanceof RefOntoUML.Comment; }
	public boolean isConstraintx(Object o){ return o instanceof RefOntoUML.Constraintx; }
	public boolean isProperty(Object o){ return o instanceof RefOntoUML.Property; }
	public boolean isElement(Object o){ return o instanceof RefOntoUML.Element; }
	public boolean isClass(Object o){ return o instanceof RefOntoUML.Class; }
	public boolean isDataType(Object o){ return o instanceof RefOntoUML.DataType; }
	public boolean isGeneralization(Object o){ return o instanceof RefOntoUML.Generalization; }
	
	public RefOntoUML.Classifier asClassifier(Object o){ return (RefOntoUML.Classifier)o; }
	public RefOntoUML.Package asPackage(Object o){ return (RefOntoUML.Package)o; }
	public RefOntoUML.Class asClass(Object o){ return (RefOntoUML.Class)o; }
	public RefOntoUML.DataType asDataType(Object o){ return (RefOntoUML.DataType)o; }
	public RefOntoUML.Property asProperty(Object o){ return (RefOntoUML.Property)o; }
	public RefOntoUML.Element asElement(Object o){ return (RefOntoUML.Element)o; }
	public RefOntoUML.Comment asComment(Object o){ return (RefOntoUML.Comment)o; }
	public RefOntoUML.Constraintx asConstraintx(Object o){ return (RefOntoUML.Constraintx)o; }
	public RefOntoUML.Generalization asGeneralization(Object o){ return (RefOntoUML.Generalization)o; }
	
	public boolean packageContains(Object pack, Element e){
		return asPackage(pack).getPackagedElement().contains(e);
	}
	
	public boolean elementContains(Object o, Comment c){
		return asElement(o).getOwnedComment().contains(c);
	}
	
	public boolean constraintxContains(Object constraint, Classifier e){
		return asClassifier(e).getOwnedRule().contains(constraint);
	}
	
	public boolean classContains(Object class_, Property p){
		return asClass(class_).getOwnedAttribute().contains(p);
	}
	
	public boolean dataTypeContains(Object dataType, Property p){
		return asDataType(dataType).getOwnedAttribute().contains(p);
	}
}
