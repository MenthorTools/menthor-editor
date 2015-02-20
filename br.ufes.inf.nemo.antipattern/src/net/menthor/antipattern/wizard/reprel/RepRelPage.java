package net.menthor.antipattern.wizard.reprel;

import net.menthor.antipattern.reprel.RepRelAntipattern;
import net.menthor.antipattern.reprel.RepRelOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizardPage;
import RefOntoUML.parser.OntoUMLNameHelper;

public abstract class RepRelPage extends AntipatternWizardPage<RepRelOccurrence, RepRelWizard> {

	protected String relator = "";
	
	public RepRelPage(RepRelOccurrence rr) 
	{
		super(rr);				
			
		setTitle(RepRelAntipattern.getAntipatternInfo().getName());
		
		if(rr!=null){
			setDescription("Relator: "+OntoUMLNameHelper.getName(rr.getRelator(), true, false));
			relator = OntoUMLNameHelper.getTypeAndName(rr.getRelator(), true, true);
		}
	}
	
	
	

}
