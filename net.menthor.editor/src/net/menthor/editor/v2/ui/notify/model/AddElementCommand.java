package net.menthor.editor.v2.ui.notify.model;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.notify.ModelCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

public class AddElementCommand extends ModelCommand {

	private static final long serialVersionUID = 7518976801833128513L;

	protected RefOntoUML.Element element;
	protected RefOntoUML.Element eContainer;	
	
	public AddElementCommand(){}
	
	public AddElementCommand(RefOntoUML.Element element, RefOntoUML.Element eContainer){
		this.element = element;		
		this.eContainer = eContainer;
	}
	
	@Override
	public void undo(){
		super.undo();		
		RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().undo();
		UpdateCommander.get().updateFromDeletion(element);
		notifier.notifyUndo(this, element, NotificationType.ADD);
	}
	
	@Override
	public void run() {	    
		super.run();	
		runWithoutNotifying();
		notifier.notifyDo(this, element, NotificationType.ADD);
	}
	
	public void runWithoutNotifying(){
		addToModel();
		UpdateCommander.get().updateFromAddition(element);
	}
	
	private void addToModel(){
		RefOntoUML.Package model = ProjectManager.get().getProject().getModel();
		AdapterFactoryEditingDomain domain = RefOntoUMLEditingDomain.getInstance().createDomain();
		AddCommand emfCommand = null;
		if(eContainer==null){			
			if(!(model.getPackagedElement().contains(element))) {
				emfCommand = new AddCommand(domain, model.getPackagedElement(), element);
			}
		}
		else if(eContainer instanceof RefOntoUML.Package){	
			RefOntoUML.Package pack = (RefOntoUML.Package)eContainer;
			if(!(pack.getPackagedElement().contains(element))){
				emfCommand = new AddCommand(domain, pack.getPackagedElement(), element);
			}
		}
		else if(eContainer instanceof RefOntoUML.Element && element instanceof RefOntoUML.Comment){			
			if (!(((RefOntoUML.Element)eContainer).getOwnedComment().contains(element))){
				emfCommand = new AddCommand(domain, ((RefOntoUML.Element)eContainer).getOwnedComment(), element);
			}
		}
		else if(eContainer instanceof RefOntoUML.Classifier && element instanceof RefOntoUML.Constraintx){
			if (!(((RefOntoUML.Constraintx)element).getConstrainedElement().contains((RefOntoUML.Classifier)eContainer))){
				emfCommand = new AddCommand(domain, ((RefOntoUML.Constraintx)element).getConstrainedElement(), (RefOntoUML.Classifier)eContainer);					
			}
		}
		else if (eContainer instanceof RefOntoUML.Class && element instanceof RefOntoUML.Property){
			if (!(((RefOntoUML.Class)eContainer).getOwnedAttribute().contains(element))){
				emfCommand = new AddCommand(domain, ((RefOntoUML.Class)eContainer).getOwnedAttribute(), element);
			}		
		}
		else if (eContainer instanceof RefOntoUML.DataType && element instanceof RefOntoUML.Property){
			if (!(((RefOntoUML.DataType)eContainer).getOwnedAttribute().contains(element))){
				emfCommand = new AddCommand(domain, ((RefOntoUML.DataType)eContainer).getOwnedAttribute(), element);
			}
		}			
		if(emfCommand!=null) RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(emfCommand);
	}
}
