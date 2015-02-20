package net.menthor.antipattern.wizard.relspec;

import net.menthor.antipattern.relspec.RelSpecAntipattern;
import net.menthor.antipattern.relspec.RelSpecOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizardPage;

/**
 * @author Tiago Sales
 * @author John Guerson
 *
 */

public abstract class RelSpecPage extends AntipatternWizardPage<RelSpecOccurrence, RelSpecWizard> {
	/**
	 * Create the wizard.
	 */
	public RelSpecPage(RelSpecOccurrence rs) 
	{
		super(rs);				
				
		setTitle(RelSpecAntipattern.getAntipatternInfo().getName());
	
	}

}
