package net.menthor.antipattern.wizard.homofunc;

import net.menthor.antipattern.homofunc.HomoFuncAntipattern;
import net.menthor.antipattern.homofunc.HomoFuncOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizardPage;
import RefOntoUML.parser.OntoUMLNameHelper;

public abstract class HomoFuncPage extends AntipatternWizardPage<HomoFuncOccurrence, HomoFuncWizard> {
	
	/**
	 * Create the wizard.
	 */
	public HomoFuncPage(HomoFuncOccurrence homoFunc) 
	{
		super(homoFunc);		
		setTitle(HomoFuncAntipattern.getAntipatternInfo().getName());		
		setDescription(	"Whole: "+OntoUMLNameHelper.getTypeAndName(homoFunc.getWhole(), true, false)+", " +
						"Part: "+OntoUMLNameHelper.getTypeAndName(homoFunc.getPartEnd().getType(), true, false));
	}
}
