package net.menthor.antipattern.wizard.depphase;

import net.menthor.antipattern.depphase.DepPhaseOccurrence;

import org.eclipse.jface.wizard.WizardPage;

public abstract class DepPhasePage extends WizardPage {

	protected DepPhaseOccurrence depPhase;	
	
	/**
	 * Create the wizard.
	 */
	public DepPhasePage(DepPhaseOccurrence depPhase) 
	{
		super("DepPhasePage");		
		this.depPhase = depPhase;		
				
	}
	
	protected String getRelatorList(){
		String relatorList = "";
		for (int i = 0; i < depPhase.getRelatorEnds().size(); i++) {
			if(i!=0)
				relatorList += ", ";
			relatorList += "<"+depPhase.getRelatorEnds().get(i).getType().getName()+">";
		}
		return relatorList;
	}
	
	public DepPhaseWizard getDepPhaseWizard(){
		return (DepPhaseWizard)getWizard();
	}
}
