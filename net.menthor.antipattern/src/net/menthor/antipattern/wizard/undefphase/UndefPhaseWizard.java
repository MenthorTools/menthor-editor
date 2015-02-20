package net.menthor.antipattern.wizard.undefphase;

import net.menthor.antipattern.undefphase.UndefPhaseAntipattern;
import net.menthor.antipattern.undefphase.UndefPhaseOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizard;
import net.menthor.antipattern.wizard.FinishingPage;
import net.menthor.antipattern.wizard.PresentationPage;

public class UndefPhaseWizard extends AntipatternWizard {

	protected UndefPhaseFirstPage firstPage;
	protected UndefPhaseSecondPage secondPage;
	protected UndefPhaseThirdPage thirdPage;
	protected UndefPhaseFourthPage fourthPage;
	protected UndefPhaseFifthPage fifthPage;
	
	public UndefPhaseWizard(UndefPhaseOccurrence ap) {
		super(ap, UndefPhaseAntipattern.getAntipatternInfo().name);	    
	}
    
	@Override
	public void addPages() 
	{	
		super.addPages();
		
		finishing = new FinishingPage();
		options = new UndefPhaseRefactoringPage((UndefPhaseOccurrence)ap);
				
		firstPage = new  UndefPhaseFirstPage((UndefPhaseOccurrence)ap);
		secondPage = new  UndefPhaseSecondPage((UndefPhaseOccurrence)ap);
		thirdPage = new  UndefPhaseThirdPage((UndefPhaseOccurrence)ap);
		fourthPage = new  UndefPhaseFourthPage((UndefPhaseOccurrence)ap);
		fifthPage = new  UndefPhaseFifthPage((UndefPhaseOccurrence)ap);
				
		presentation = new PresentationPage(
			UndefPhaseAntipattern.getAntipatternInfo().name,
			UndefPhaseAntipattern.getAntipatternInfo().acronym,
			ap.toString(),
			UndefPhaseAntipattern.getAntipatternInfo().description,
			firstPage,
			options
		);
		
		addPage(presentation);		
		addPage(firstPage);
		addPage(secondPage);
		addPage(thirdPage);
		addPage(fourthPage);
		addPage(fifthPage);
		addPage(options);
		addPage(finishing);
	}

	public UndefPhaseOccurrence getAp() {
		return ((UndefPhaseOccurrence)ap);
	}

	public UndefPhaseFirstPage getFirstPage() {
		return firstPage;
	}	
	public UndefPhaseSecondPage getSecondPage() {
		return secondPage;
	}
	public UndefPhaseThirdPage getThirdPage() {
		return thirdPage;
	}
	public UndefPhaseFourthPage getFourthPage() {
		return fourthPage;
	}
	public UndefPhaseFifthPage getFifthPage() {
		return fifthPage;
	}
}
