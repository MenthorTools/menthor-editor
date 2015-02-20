package net.menthor.antipattern.wizard.mixiden;

import net.menthor.antipattern.mixiden.MixIdenAntipattern;
import net.menthor.antipattern.mixiden.MixIdenOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizard;
import net.menthor.antipattern.wizard.FinishingPage;
import net.menthor.antipattern.wizard.PresentationPage;
import RefOntoUML.Category;
import RefOntoUML.Mixin;
import RefOntoUML.RoleMixin;

public class MixIdenWizard extends AntipatternWizard {
	
	//TODO: ADD PAGE TO CHANGE THE CURRENT SUBTYPES IDENTITY PROVIDERS
	public MixIdenFirstPage firstPage;
	public MixIdenSecondPage secondPage;
	public MixIdenThirdPage thirdPage;
	protected String mixinName, mixinRigidity, mixinStereotype;
	
	public MixIdenWizard(MixIdenOccurrence mixIden) {
		super(mixIden,MixIdenAntipattern.getAntipatternInfo().name);
		
		mixinName = mixIden.getMixin().getName();
		
		if(mixIden.getMixin() instanceof Mixin){
			mixinRigidity = "semi-rigid";
			mixinStereotype = "Mixin";
		}
		if(mixIden.getMixin() instanceof RoleMixin){ 
			mixinRigidity = "anti-rigid";
			mixinStereotype = "RoleMixin";
		}
		if(mixIden.getMixin() instanceof Category){
			mixinRigidity = "rigid";
			mixinStereotype = "Category";
		}
	}

	@Override
	public void addPages() 
	{
		firstPage = new MixIdenFirstPage(getAp());
		secondPage = new MixIdenSecondPage(getAp());
		thirdPage = new MixIdenThirdPage(getAp());
		
		finishing = new FinishingPage();
		options = new MixIdenRefactoringPage(getAp());
		
		presentation = new PresentationPage(
			MixIdenAntipattern.getAntipatternInfo().name,
			MixIdenAntipattern.getAntipatternInfo().acronym,
			ap.toString(),
			MixIdenAntipattern.getAntipatternInfo().description,
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
	
	public MixIdenOccurrence getAp() {
		return (MixIdenOccurrence)ap;
	}
	
	public MixIdenFirstPage getFirstPage()
	{
		return firstPage;
	}
	
	public MixIdenSecondPage getSecondPage()
	{
		return secondPage;
	}
	
	public MixIdenThirdPage getThirdPage()
	{
		return thirdPage;
	}
	
	
}
