

package net.menthor.editor.v2.ui.operation.model;

import java.util.List;

import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;

import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.operation.ModelOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class DeleteModelOperation extends ModelOperation {

	private static final long serialVersionUID = 3798222350326038273L;

	protected ElementsDependencyChain depChain = new ElementsDependencyChain();
				
	public DeleteModelOperation(){
		super();
		this.operationType = OperationType.DELETE;
	}
	
	public DeleteModelOperation(OntoUMLParser refparser, List<Element> elements){
		this();		
		depChain.lookupForDependencies(refparser, elements);					
	}	
	
	public List<Element> getAllElements(){ return depChain.getAll(); }
	public ElementsDependencyChain getChain(){ return depChain; }
	
	@Override
	public void undo(){		
		undoWithoutNotifying();
		notifier.notifyChange(this,actionType,getAllElements());
	}

	@Override
	public void run(){		
		runWithoutNotifying();
		notifier.notifyChange(this,actionType, getAllElements());
	}
	
	protected void undoWithoutNotifying(){	
		super.undo();		
		undoDelete(depChain.getRequested());
		undoDelete(depChain.getDirectRelationshipDependencies());
		undoDelete(depChain.getIndirectRelationshipDependencies());
	}
	
	protected void runWithoutNotifying(){
		super.run();
		delete(depChain.getIndirectRelationshipDependencies());
		delete(depChain.getDirectRelationshipDependencies());
		delete(depChain.getRequested());
	}
	
	private void delete(List<RefOntoUML.Element> elemList){	
		deleteFirstElements(elemList);		
		deleteRelationships(elemList);	
		deleteTypes(elemList);
		deleteEmptyGeneralizationSets();
	}
		
	private void undoDelete(List<Element> elemList){
		undoEmptyGeneralizationSets();
		undoTypes(elemList);		
		undoRelationships(elemList);		
		undoLastElements(elemList);
	}
	
	//----- auxiliary delete/undo methods ------
	
	/** delete derivations, constraints, comments and generalization sets */
	private void deleteFirstElements(List<RefOntoUML.Element> elemList){	
		for(Element elem: elemList) {
			if (elem instanceof RefOntoUML.Derivation)  delete(elem); 
			if (elem instanceof RefOntoUML.Comment) delete(elem);
			if (elem instanceof RefOntoUML.Constraintx) delete(elem);
			if (elem instanceof RefOntoUML.GeneralizationSet) deleteGeneralizationSet((GeneralizationSet)elem);
		}				
	}
	
	/** undo deletion of derivations, comments and constraints */
	private void undoLastElements(List<Element> elemList){
		for(Element elem: elemList) {
			if (elem instanceof RefOntoUML.Derivation)  undoDelete(elem); 
			if (elem instanceof RefOntoUML.Comment) undoDelete(elem);
			if (elem instanceof RefOntoUML.Constraintx) undoDelete(elem);
			if (elem instanceof RefOntoUML.GeneralizationSet) undoGeneralizationSet((GeneralizationSet)elem);			
		}	
	}
	
	/** delete associations and generalizations */
	private void deleteRelationships(List<RefOntoUML.Element> elemList){
		for(Element elem: elemList) {				
			if (elem instanceof RefOntoUML.Association) delete(elem);
			if (elem instanceof RefOntoUML.Generalization) deleteGeneralization((Generalization)elem);
		}
	}
	
	/** undo deletion of associations and generalizations */
	private void undoRelationships(List<Element> elemList){
		for(Element elem: elemList) {				
			if ((elem instanceof RefOntoUML.Association) && !(elem instanceof RefOntoUML.Derivation)) undoDelete(elem);
			if (elem instanceof RefOntoUML.Generalization) undoGeneralization((Generalization)elem);
		}
	}
	
	/** delete classes and datatypes */
	private void deleteTypes(List<RefOntoUML.Element> elemList){
		for(Element elem: elemList) {
			if (elem instanceof RefOntoUML.Class || elem instanceof RefOntoUML.DataType) delete(elem);			
		}	
	}
	
	/** undo deletion of classes and datatypes */
	private void undoTypes(List<Element> elemList){		
		for(Element elem: elemList) {
			if (elem instanceof RefOntoUML.Class || elem instanceof RefOntoUML.DataType) undoDelete(elem);			
		}
	}
	
	private void deleteEmptyGeneralizationSets(){				
		for(GeneralizationSet gs: depChain.getEmptyGeneralizationSets()){
			deleteGeneralizationSet(gs);
		}
	}
	
	private void undoEmptyGeneralizationSets(){				
		for(GeneralizationSet gs: depChain.getEmptyGeneralizationSets()){
			undoGeneralizationSet(gs);
		}
	}
	
	/** delete a generalization along with its generalization sets */
	private void deleteGeneralization(Generalization gen){		
		//delete the dependency between this generalization and its generalization set
		GeneralizationSet genSet = depChain.getGeneralizationSet(gen); 
		genSet.getGeneralization().remove(gen); 
		gen.getGeneralizationSet().remove(genSet);
		
		delete(gen);
	}
	
	/** undo deletion of a generalization with its generalization sets */
	private void undoGeneralization(Generalization gen){
		undoDelete(gen);	

		GeneralizationSet genSet = depChain.getGeneralizationSet(gen);
		genSet.getGeneralization().add(gen); 
		gen.getGeneralizationSet().add(genSet);		
	}
	
	/** delete generalization set along with its generalizations */
	private void deleteGeneralizationSet(GeneralizationSet elem){
		//erase the dependencies between generalizations of the model that pointed to this genSet				
		for(Generalization gen: depChain.getGeneralizations(elem)){
			gen.getGeneralizationSet().remove(elem);
			((GeneralizationSet)elem).getGeneralization().remove(gen);
		}				
		delete(elem);		
	}
	
	/** undo deletion of a generalization set with its generalizations */
	private void undoGeneralizationSet(GeneralizationSet elem){
		undoDelete(elem);		
		//bring back the dependencies between the generalizations of the model that pointed to this genSet				
		for(Generalization gen: depChain.getGeneralizations(elem)) {
			gen.getGeneralizationSet().add(elem);	
			((GeneralizationSet)elem).getGeneralization().add(gen);
		}
	}	
	
	//------- real deletion happens here -------
	
	private void delete (RefOntoUML.Element elem){		
		System.out.println(runMessage(elem));		
		AdapterFactoryEditingDomain domain = RefOntoUMLEditingDomain.getInstance().createDomain();
		DeleteCommand emfCommand = (DeleteCommand) DeleteCommand.create(domain, elem);
		domain.getCommandStack().execute(emfCommand);		
	}

	private void undoDelete (RefOntoUML.Element elem){		
		RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().undo();
		System.out.println(undoMessage(elem));
	}
	
	//------- undo & redo messages -------
	
	@Override
	public String undoMessage(){
		if(depChain.getRequested().size()==0) return super.undoMessage();
		return super.undoMessage()+asString(getAllElements())+" from "+getAllElements().get(0).eContainer();
	}
	
	public String undoMessage(Element element){
		return super.undoMessage()+element+" from "+element.eContainer();
	}
	
	@Override
	public String runMessage(){
		if(depChain.getRequested().size()==0) return super.runMessage();
		return super.runMessage()+asString(getAllElements())+" from "+getAllElements().get(0).eContainer();
	}
	
	public String runMessage(Element element){
		return super.runMessage()+element+" from "+element.eContainer();
	}
		
}
