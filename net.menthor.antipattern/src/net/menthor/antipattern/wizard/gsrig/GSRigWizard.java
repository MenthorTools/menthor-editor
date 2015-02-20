package net.menthor.antipattern.wizard.gsrig;

import net.menthor.antipattern.GSRig.GSRigAntipattern;
import net.menthor.antipattern.GSRig.GSRigOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizard;
import net.menthor.antipattern.wizard.FinishingPage;
import net.menthor.antipattern.wizard.PresentationPage;

public class GSRigWizard extends AntipatternWizard {

	public GSRigFirstPage firstPage;
	public GSRigSecondPage secondPage;
	public GSRigThirdPage thirdPage;
	public GSRigFourthPage fourthPage;
	public GSRigFifthPage fifthPage;
	public GSRigSixthPage sixthPage;
			
	public GSRigWizard(GSRigOccurrence ap) {
		super(ap,GSRigAntipattern.getAntipatternInfo().name);		
	}

	@Override
	public void addPages() 
	{
		firstPage = new GSRigFirstPage((GSRigOccurrence)ap);
		secondPage = new GSRigSecondPage((GSRigOccurrence)ap);
		thirdPage = new GSRigThirdPage((GSRigOccurrence)ap);
		fourthPage = new GSRigFourthPage((GSRigOccurrence)ap);
		fifthPage = new GSRigFifthPage((GSRigOccurrence)ap);
		sixthPage = new GSRigSixthPage((GSRigOccurrence)ap);
		
		finishing = new FinishingPage();
		options = new GSRigRefactoringPage(getAp());
		
		presentation = new PresentationPage(
				GSRigAntipattern.getAntipatternInfo().name,
				GSRigAntipattern.getAntipatternInfo().acronym,
			ap.toString(),
			GSRigAntipattern.getAntipatternInfo().description,
			firstPage,
			options
		);
			
		addPage(presentation);	
		addPage(firstPage);	
		addPage(secondPage);
		addPage(thirdPage);
		addPage(fourthPage);
		addPage(fifthPage);
		addPage(sixthPage);
		addPage(options);
		addPage(finishing);
	}
	
	public GSRigOccurrence getAp() {
		return (GSRigOccurrence)ap;
	}
	
	public GSRigFirstPage getFirstPage()
	{
		return firstPage;
	}
		
	public GSRigSecondPage getSecondPage()
	{
		return secondPage;
	}
	
	public GSRigThirdPage getThirdPage()
	{
		return thirdPage;
	}
	
	public GSRigFourthPage getFourthPage()
	{
		return fourthPage;	
	}
	
	public GSRigFifthPage getFifthPage()
	{
		return fifthPage;	
	}
	
	public GSRigSixthPage getSixthPage()
	{
		return sixthPage;	
	}
	
}

