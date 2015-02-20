package net.menthor.antipattern.wizard.freerole;

import net.menthor.antipattern.freerole.FreeRoleAntipattern;
import net.menthor.antipattern.freerole.FreeRoleOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizardPage;


public abstract class FreeRolePage extends AntipatternWizardPage<FreeRoleOccurrence, FreeRoleWizard> {
	
	protected int index = -1;

	/**
	 * Create the wizard.
	 */
	public FreeRolePage(FreeRoleOccurrence freeRole) 
	{
		super(freeRole);			
		setTitle(FreeRoleAntipattern.getAntipatternInfo().getName());		
	}
}
