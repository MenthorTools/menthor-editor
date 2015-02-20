package net.menthor.antipattern.wizard.reprel;

import net.menthor.antipattern.reprel.RepRelAntipattern;
import net.menthor.antipattern.reprel.RepRelOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizard;
import net.menthor.antipattern.wizard.FinishingPage;
import net.menthor.antipattern.wizard.PresentationPage;

/**
 * @author Tiago Sales
 * @author John Guerson
 *
 */

public class RepRelWizard extends AntipatternWizard {

	protected RepRelFirstPage firstPage;
	protected RepRelSecondPage secondPage;
	protected RepRelThirdPage thirdPage;
	
	public RepRelWizard(RepRelOccurrence ap) {
		super(ap, RepRelAntipattern.getAntipatternInfo().name);	    
	}
    
	@Override
	public void addPages() 
	{	
		super.addPages();
		
		finishing = new FinishingPage();
		options = new RepRelRefactoringPage((RepRelOccurrence)ap);
				
		firstPage = new RepRelFirstPage((RepRelOccurrence)ap);
		secondPage = new RepRelSecondPage((RepRelOccurrence)ap);
		thirdPage = new RepRelThirdPage((RepRelOccurrence)ap);
		
		presentation = new PresentationPage(
			RepRelAntipattern.getAntipatternInfo().name,
			RepRelAntipattern.getAntipatternInfo().acronym,
			ap.toString(),
			RepRelAntipattern.getAntipatternInfo().description,
			firstPage,
			options
		);
		
		addPage(presentation);		
		addPage(firstPage);
		addPage(secondPage);
		addPage(thirdPage);
		addPage(options);
		addPage(finishing);
	}

	public RepRelOccurrence getAp() {
		return (RepRelOccurrence)ap;
	}

	public RepRelFirstPage getFirstPage() {
		return firstPage;
	}
	
	public RepRelSecondPage getSecondPage()
	{
		return secondPage;
	}
		
	public RepRelThirdPage getThirdPage()
	{
		return thirdPage;
	}
	
}
