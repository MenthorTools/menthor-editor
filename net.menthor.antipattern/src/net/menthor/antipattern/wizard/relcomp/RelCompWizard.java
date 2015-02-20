package net.menthor.antipattern.wizard.relcomp;

import net.menthor.antipattern.relcomp.RelCompAntipattern;
import net.menthor.antipattern.relcomp.RelCompOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizard;
import net.menthor.antipattern.wizard.FinishingPage;
import net.menthor.antipattern.wizard.PresentationPage;

/**
 * @author Tiago Sales
 * @author John Guerson
 *
 */

public class RelCompWizard extends AntipatternWizard {

	protected RelCompFirstPage firstPage;
	protected RelCompSecondPage secondPage;
	protected RelCompThirdPage thirdPage;
	
	public RelCompWizard(RelCompOccurrence ap) {
		super(ap, RelCompAntipattern.getAntipatternInfo().name);	    
	}
    
	@Override
	public void addPages() 
	{	
		super.addPages();
		
		finishing = new FinishingPage();
		options = new RelCompRefactoringPage(getRelComp());
				
		firstPage = new RelCompFirstPage(getRelComp());
		secondPage = new RelCompSecondPage(getRelComp());
		thirdPage = new RelCompThirdPage(getRelComp());
		
		presentation = new PresentationPage(
			RelCompAntipattern.getAntipatternInfo().name,
			RelCompAntipattern.getAntipatternInfo().acronym,
			ap.toString(),
			RelCompAntipattern.getAntipatternInfo().description,
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

	public RelCompOccurrence getRelComp() {
		return (RelCompOccurrence)ap;
	}

	public RelCompFirstPage getFirstPage() {
		return firstPage;
	}

	public RelCompSecondPage getSecondPage() {
		return secondPage;
	}

	public RelCompThirdPage getThirdPage() {
		return thirdPage;
	}


}
