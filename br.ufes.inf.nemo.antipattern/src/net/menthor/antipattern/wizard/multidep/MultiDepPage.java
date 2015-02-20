package net.menthor.antipattern.wizard.multidep;

import net.menthor.antipattern.multidep.MultiDepAntipattern;
import net.menthor.antipattern.multidep.MultiDepOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizardPage;

public abstract class MultiDepPage extends AntipatternWizardPage<MultiDepOccurrence, MultiDepWizard> {
	
	/**
	 * Create the wizard.
	 */
	public MultiDepPage(MultiDepOccurrence multiDep) 
	{
		super(multiDep);		
		setTitle(MultiDepAntipattern.getAntipatternInfo().getName());		
	}
	
}
