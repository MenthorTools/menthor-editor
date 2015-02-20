package net.menthor.antipattern.wizard.overlapping;

import java.util.ArrayList;

import net.menthor.antipattern.overlapping.OverlappingOccurrence;
import net.menthor.antipattern.partover.PartOverOccurrence;
import net.menthor.antipattern.relover.RelOverOccurrence;
import net.menthor.antipattern.wholeover.WholeOverOccurrence;

import org.eclipse.jface.wizard.IWizardPage;

import RefOntoUML.Property;

public class ExclusiveGroupPage extends OverlappingWizardPage{

	
	public ExclusiveGroupPage(String pageName, OverlappingOccurrence occurrence, int variationIndex) {
		super(pageName, occurrence, variationIndex);		
	}
	
	@Override
	public void registerActions(){
		//register one action for each valid action in the table
		getOverlappingWizard().removeAllActions(getVariationIndex(),OverlappingAction.Action.EXCLUSIVE);
		
		if(noButton.getSelection())
			return;
		
		for (ArrayList<Property> propertyEndList : getBuilder().getSelections()) {
			OverlappingAction action = new OverlappingAction(getOccurrence(),getVariation());
			action.setExclusive(propertyEndList);
			getOverlappingWizard().addAction(getVariationIndex(), action);
		}
	}
	
	@Override
	public IWizardPage getNextPage(){
		
		if(!yesButton.getSelection() && !noButton.getSelection())
			return null;
		
		registerActions();
		
		if(getOverlappingWizard().hasNextVariation(getVariationIndex())) {
			return getOverlappingWizard().getDisjointOverlappingPage(getVariationIndex()+1);
		}
		else {
			return getOverlappingWizard().getFinishing();
		}
	}

	@Override
	public String getQuestion() {
		String s = "Are there any EXCLUSIVE types?";
		
		if(occurrence instanceof WholeOverOccurrence)
			s = "Are there any EXCLUSIVE parts?";
		if(occurrence instanceof PartOverOccurrence)
			s = "Are there any EXCLUSIVE wholes?";
		if(occurrence instanceof RelOverOccurrence)
			s = "Are there any EXCLUSIVE mediated types?";
		
		return 	s+"\r\n\r\nIf you answer is \"Yes\" use the table below to specify which are EXCLUSIVE. " +
				"If your answer is \"No\", just go directly to the next page.";
	}
	
	
	
	
	
}
