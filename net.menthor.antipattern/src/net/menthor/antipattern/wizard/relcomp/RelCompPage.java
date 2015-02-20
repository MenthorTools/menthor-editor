package net.menthor.antipattern.wizard.relcomp;

import net.menthor.antipattern.relcomp.RelCompAntipattern;
import net.menthor.antipattern.relcomp.RelCompOccurrence;

import org.eclipse.jface.wizard.WizardPage;

/**
 * @author Tiago Sales
 * @author John Guerson
 *
 */

public abstract class RelCompPage extends WizardPage {

	protected RelCompOccurrence relComp;
	
	/**
	 * Create the wizard.
	 */
	public RelCompPage(RelCompOccurrence relComp) 
	{
		super("RelCompPage");				
		this.relComp = relComp;
				
		setTitle(RelCompAntipattern.getAntipatternInfo().getName());
	}
	
	public RelCompWizard getRelCompWizard(){
		return (RelCompWizard)getWizard();
	}
	
	public RelCompOccurrence getRelComp(){
		return relComp;
	}

}
