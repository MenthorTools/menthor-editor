package net.menthor.antipattern.wizard.asscyc;

import net.menthor.antipattern.asscyc.AssCycAntipattern;
import net.menthor.antipattern.asscyc.AssCycOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizard;
import net.menthor.antipattern.wizard.FinishingPage;
import net.menthor.antipattern.wizard.PresentationPage;

public class AssCycWizard extends AntipatternWizard {

	public AssCycFirstPage firstPage;
	public AssCycSecondPage secondPage;
	
	public AssCycWizard(AssCycOccurrence ap) {
		super(ap,AssCycAntipattern.getAntipatternInfo().name);		
	}

	@Override
	public void addPages() 
	{
		firstPage = new AssCycFirstPage((AssCycOccurrence)ap);
		secondPage = new AssCycSecondPage((AssCycOccurrence)ap);
		
		finishing = new FinishingPage();
		options = new AssCycRefactoringPage(getAp());
		
		presentation = new PresentationPage(
			AssCycAntipattern.getAntipatternInfo().name,
			AssCycAntipattern.getAntipatternInfo().acronym,
			ap.toString(),
			AssCycAntipattern.getAntipatternInfo().description,
			firstPage,
			options
		);
			
		addPage(presentation);	
		addPage(firstPage);	
		addPage(secondPage);
		addPage(options);
		addPage(finishing);
	}
	
	public AssCycOccurrence getAp() {
		return (AssCycOccurrence)ap;
	}
	
	public AssCycFirstPage getFirstPage()
	{
		return firstPage;
	}
	public AssCycSecondPage getSecondPage()
	{
		return secondPage;
	}
	
	
}