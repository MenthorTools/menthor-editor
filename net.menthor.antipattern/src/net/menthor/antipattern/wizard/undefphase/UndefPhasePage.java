package net.menthor.antipattern.wizard.undefphase;

import net.menthor.antipattern.undefphase.UndefPhaseAntipattern;
import net.menthor.antipattern.undefphase.UndefPhaseOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizardPage;

public abstract class UndefPhasePage extends AntipatternWizardPage<UndefPhaseOccurrence, UndefPhaseWizard> {
	
	/**
	 * Create the wizard.
	 */
	public UndefPhasePage(UndefPhaseOccurrence up) 
	{
		super(up);			
		setTitle(UndefPhaseAntipattern.getAntipatternInfo().getName());
	}
}