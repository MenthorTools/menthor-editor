

package net.menthor.editor.v2.ui.notify.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Relationship;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.ModelCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

public class DeleteElementModelCommand extends ModelCommand {

	private static final long serialVersionUID = 3798222350326038273L;

	protected RefOntoUML.Element element;
	
	/** requested list for deletion */
	protected List<Element> requestedList= new ArrayList<Element>();
	
	/** not requested for deletion but connected to some of the elements requested for deletion */
	protected List<Element> directRelationshipsList = new ArrayList<Element>(); 
	
	/** not requested for deletion but connected to an element which is also connected to a requested element */
	protected List<Element> indirectRelationshipsList = new ArrayList<Element>();
	
	protected List<Element> getAllElements(){
		List<Element> result = new ArrayList<>();
		result.addAll(requestedList);
		result.addAll(indirectRelationshipsList);
		result.addAll(directRelationshipsList);
		return result;
	}
	
	/** empty generalization sets that needed to be deleted */
	protected List<GeneralizationSet> deletedEmptyGenSets = new ArrayList<GeneralizationSet>();
	/** generalizations to be deleted with their generalization sets */
	protected Map<GeneralizationSet, Generalization> deletedGenMap = new HashMap<GeneralizationSet,Generalization>();
	/** generalization sets to be deleted with their generalizations */
	protected Map<Generalization, GeneralizationSet> deletedGenSetMap = new HashMap<Generalization,GeneralizationSet>();
			
	public DeleteElementModelCommand(){
		super();
		this.notificationType = NotificationType.DELETE;
	}
	
	public DeleteElementModelCommand(List<Element> elements){
		this();
		requestedList.addAll(elements);	
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();
		for (Element elem : requestedList){
			
			//get relationships which were not requested for deletion
			//but which are connected to some of the elements requested
			List<Relationship> list1 = refparser.getDirectRelationships(elem);			
			list1.removeAll(requestedList);
			for(Element e: list1) { 
				if(!directRelationshipsList.contains(e)) directRelationshipsList.add(e); 
			}	
			
			//get relationships which were not requested and which are not in the list of direct dependency
			//such as derivations or any other relationship between relationship		
			for(Element r: directRelationshipsList){ 
				List<Relationship> list2 = refparser.getDirectRelationships(r);
				list2.removeAll(requestedList);
				list2.removeAll(directRelationshipsList);
				for(Element e: list2){
					if(!indirectRelationshipsList.contains(e)) indirectRelationshipsList.add(e);						
				}				
			}	
		}			
	}
	
	@Override
	public void undo(){
		super.undo();
		undoWithoutNotifying();
		notifier.notify(this,getAllElements(), ActionType.UNDO);
	}

	@Override
	public void run(){
		super.run();
		runWithoutNotifying();
		notifier.notify(this,getAllElements(), isRedo ? ActionType.REDO : ActionType.DO);
	}
	
	protected void undoWithoutNotifying(){					
		undo(requestedList);
		undo(indirectRelationshipsList);
		undo(directRelationshipsList);
	}
	
	protected void runWithoutNotifying(){
		delete(indirectRelationshipsList);
		delete(directRelationshipsList);
		delete(requestedList);
	}
	
	private void delete (RefOntoUML.Element elem){		
		System.out.println("[delete] - Model - "+elem);
		AdapterFactoryEditingDomain domain = RefOntoUMLEditingDomain.getInstance().createDomain();
		DeleteCommand emfCommand = (DeleteCommand) DeleteCommand.create(domain, elem);
		RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(emfCommand);		
	}

	private void undo (RefOntoUML.Element elem){		
		System.out.println("[undo delete] - Model - "+elem);
		RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().undo();		
	}

	private void delete(List<RefOntoUML.Element> elemList){	
		deleteFirstElements(elemList);		
		deleteRelationships(elemList);	
		deleteTypes(elemList);
	}
	
	private void undo(List<Element> elemList){
		undoTypes(elemList);		
		undoRelationships(elemList);
		undoGeneralizationSets(elemList);
		undoLastElements(elemList);
	}
	
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
			if (elem instanceof RefOntoUML.Derivation)  undo(elem); 
			if (elem instanceof RefOntoUML.Comment) undo(elem);
			if (elem instanceof RefOntoUML.Constraintx) undo(elem);					
		}	
	}
	
	private void undoGeneralizationSets(List<Element> elemList){		
		for(Element elem: elemList) {			
			if (elem instanceof RefOntoUML.GeneralizationSet) {			
				undoGeneralizationSet((GeneralizationSet)elem);			
			}
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
			if ((elem instanceof RefOntoUML.Association) && !(elem instanceof RefOntoUML.Derivation)) undo(elem);
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
			if (elem instanceof RefOntoUML.Class || elem instanceof RefOntoUML.DataType) undo(elem);			
		}
	}
	
	/** delete a generalization along with its generalization sets */
	private void deleteGeneralization(Generalization gen){		
		//decouple generalization and its generalization sets		
		for(GeneralizationSet genSet: gen.getGeneralizationSet()) {			
			deletedGenMap.put(genSet,gen);
		}
		for(GeneralizationSet genSet: deletedGenMap.keySet()) { 
			genSet.getGeneralization().remove(gen); 
			gen.getGeneralizationSet().remove(genSet); 
		}		
		//delete remaining empty generalization sets		
		for(GeneralizationSet genSet: deletedGenMap.keySet()) {
			if(genSet.getGeneralization().size()==0) deletedEmptyGenSets.add(genSet);
		}				
		for(GeneralizationSet genSet: deletedEmptyGenSets) {
			deleteGeneralizationSet(genSet);			
		}		
		delete(gen);
	}
	
	/** undo deletion of a generalization with its generalization sets */
	private void undoGeneralization(Generalization gen){
		undo(gen);		
		//undo empty generalization sets that were emptied
		List<GeneralizationSet> genSetsForAddition = new ArrayList<GeneralizationSet>();
		for(GeneralizationSet genSet: deletedEmptyGenSets) {
			if(genSet.getGeneralization().size()==0) genSetsForAddition.add(genSet);
		}	
		for(GeneralizationSet genSet: genSetsForAddition) {
			undoGeneralizationSet(genSet);			
		}		
		//couple generalization and its generalization sets again
		List<GeneralizationSet> genSets = new ArrayList<GeneralizationSet>();
		for(GeneralizationSet genSet: deletedGenMap.keySet()) {			
			genSets.add(genSet);
		}
		for(GeneralizationSet genSet: genSets) { 
			genSet.getGeneralization().add(gen); 
			gen.getGeneralizationSet().add(genSet); 		
		}
	}
	
	/** delete generalization set along with its generalizations */
	private void deleteGeneralizationSet(GeneralizationSet elem){
		//decouple generalization sets and its generalizations before deletion
		for(Generalization gen: ((GeneralizationSet)elem).getGeneralization()){				
			if(gen!=null) deletedGenSetMap.put(gen,elem);			
		}			
		((GeneralizationSet)elem).getGeneralization().removeAll(deletedGenSetMap.keySet());		
		for(Generalization gen: deletedGenSetMap.keySet()){
			gen.getGeneralizationSet().remove(elem);			
		}		
		delete(elem);		
	}
	
	/** undo deletion of a generalization set with its generalizations */
	private void undoGeneralizationSet(GeneralizationSet elem){
		undo(elem);
		
		//couple generalization set and its generalizations again
		((GeneralizationSet)elem).getGeneralization().addAll(deletedGenSetMap.keySet());		
		for(Generalization gen: deletedGenSetMap.keySet()) {
			gen.getGeneralizationSet().add(elem);			
		}
	}
}
