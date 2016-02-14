package net.menthor.editor.v2.ui.operation.model;

import java.util.ArrayList;
import java.util.List;

import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import net.menthor.editor.v2.ui.operation.ActionType;

public class AddGeneralizationSetModelOperation extends AddModelOperation {

	private static final long serialVersionUID = 5068398335277160685L;

	protected List<Element> gens = new ArrayList<Element>();
		
	public AddGeneralizationSetModelOperation(){
		super();		
	}
	
	public AddGeneralizationSetModelOperation(RefOntoUML.Element element, RefOntoUML.Element eContainer, List<Generalization> gens){
		super(element, eContainer);		
		this.gens.addAll(gens);		
	}
	
	@Override
	public void undo(){
		super.undoWithoutNotifying();		
		
		((GeneralizationSet)element).getGeneralization().removeAll(gens);
		for(Element gen: gens) {
			((Generalization)gen).getGeneralizationSet().remove((GeneralizationSet)element); 		
		}
				
		System.out.println(undoStatus());
		notifier.notifyChange(this,ActionType.UNDO, element);		
	}
	
	@Override 
	public void run(){
		super.runWithoutNotifying();		
		
		for(Element g: gens){
			((GeneralizationSet)element).getGeneralization().add((Generalization)g);
		}
		for(Element gen: gens) {
			((Generalization)gen).getGeneralizationSet().add((GeneralizationSet)element); 		
		}
		
		System.out.println(runStatus());
		notifier.notifyChange(this, isRedo ? ActionType.REDO : ActionType.DO, element);		
	}	
}
