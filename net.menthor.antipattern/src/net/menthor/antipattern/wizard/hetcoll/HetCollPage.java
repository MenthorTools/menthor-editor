package net.menthor.antipattern.wizard.hetcoll;

import net.menthor.antipattern.hetcoll.HetCollAntipattern;
import net.menthor.antipattern.hetcoll.HetCollOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizardPage;

public abstract class HetCollPage extends AntipatternWizardPage<HetCollOccurrence, HetCollWizard> {
	
	/**
	 * Create the wizard.
	 */
	public HetCollPage(HetCollOccurrence hetColl) 
	{
		super(hetColl);		
		setTitle(HetCollAntipattern.getAntipatternInfo().getName());		
	}

}
