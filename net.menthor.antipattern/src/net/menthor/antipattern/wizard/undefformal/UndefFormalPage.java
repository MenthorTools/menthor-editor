package net.menthor.antipattern.wizard.undefformal;

import net.menthor.antipattern.undefformal.UndefFormalAntipattern;
import net.menthor.antipattern.undefformal.UndefFormalOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizardPage;

public abstract class UndefFormalPage extends AntipatternWizardPage<UndefFormalOccurrence, UndefFormalWizard> {
	
	/**
	 * Create the wizard.
	 */
	public UndefFormalPage(UndefFormalOccurrence uf) 
	{
		super(uf);					
		setTitle(UndefFormalAntipattern.getAntipatternInfo().getName());
	}

}