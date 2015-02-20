package net.menthor.antipattern.wizard.asscyc;

import net.menthor.antipattern.asscyc.AssCycAntipattern;
import net.menthor.antipattern.asscyc.AssCycOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizardPage;


public abstract class AssCycPage extends AntipatternWizardPage<AssCycOccurrence, AssCycWizard> {

	protected AssCycOccurrence occurrence;	
	
	/**
	 * Create the wizard.
	 */
	public AssCycPage(AssCycOccurrence asscyc) 
	{
		super(asscyc);		
		this.occurrence = asscyc;		
		setTitle(AssCycAntipattern.getAntipatternInfo().getName());		
	}

}
