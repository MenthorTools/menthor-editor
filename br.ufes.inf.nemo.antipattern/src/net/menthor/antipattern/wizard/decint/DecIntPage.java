package net.menthor.antipattern.wizard.decint;

import net.menthor.antipattern.decint.DecIntAntipattern;
import net.menthor.antipattern.decint.DecIntOccurrence;

import org.eclipse.jface.wizard.WizardPage;


public abstract class DecIntPage extends WizardPage {

	protected DecIntOccurrence decint;	
	
	/**
	 * Create the wizard.
	 */
	public DecIntPage(DecIntOccurrence decint) 
	{
		super("DecIntPage");		
		this.decint = decint;		
		setTitle(DecIntAntipattern.getAntipatternInfo().getName());		
	}
	
	public DecIntWizard getDecIntWizard(){
		return (DecIntWizard)getWizard();
	}
}
