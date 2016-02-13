package net.menthor.editor.v2.ui.notify.model;

import java.util.ArrayList;
import java.util.List;

import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.NotificationType;

public class AddGenSetModelCommand extends AddElementModelCommand {

	private static final long serialVersionUID = 5068398335277160685L;

	protected List<Element> gens = new ArrayList<Element>();
		
	public AddGenSetModelCommand(){
		super();
		this.notificationType = NotificationType.ADD;
	}
	
	public AddGenSetModelCommand(RefOntoUML.Element element, RefOntoUML.Element eContainer, List<Generalization> gens){
		this();
		this.element = element;		
		this.eContainer = eContainer;
		this.gens.addAll(gens);		
	}
	
	@Override
	public void undo(){
		undoWithoutNotifying();
		notifier.notifyChange(this,ActionType.UNDO, element);		
	}
	
	@Override 
	public void run(){
		runWithoutNotifying();
		notifier.notifyChange(this, isRedo ? ActionType.REDO : ActionType.DO, element);		
	}
	
	public void undoWithoutNotifying(){
		super.undoWithoutNotifying();
		((GeneralizationSet)element).getGeneralization().removeAll(gens);
		for(Element gen: gens) {
			((Generalization)gen).getGeneralizationSet().remove((GeneralizationSet)element); 		
		}
	}
	
	public void runWithoutNotifying(){
		super.runWithoutNotifying();
		for(Element g: gens){
			((GeneralizationSet)element).getGeneralization().add((Generalization)g);
		}
		for(Element gen: gens) {
			((Generalization)gen).getGeneralizationSet().add((GeneralizationSet)element); 		
		}
	}	
	
}
