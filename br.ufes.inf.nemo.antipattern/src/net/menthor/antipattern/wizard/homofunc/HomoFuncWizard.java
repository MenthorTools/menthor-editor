package net.menthor.antipattern.wizard.homofunc;

import net.menthor.antipattern.homofunc.HomoFuncAntipattern;
import net.menthor.antipattern.homofunc.HomoFuncOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizard;
import net.menthor.antipattern.wizard.FinishingPage;
import net.menthor.antipattern.wizard.PresentationPage;

public class HomoFuncWizard extends AntipatternWizard {

	public FunctionalOrCollectionPage funcColPage;
	public CreatePartPage createPartPage;
	public CreateSubPartPage createSubPartPage;
	public FixNaturePage fixNaturePage;
	public DefineIdentityProviderPage defineIdenPage;
	public MemberOrSubCollectionPage memberColPage;
	
	public HomoFuncWizard(HomoFuncOccurrence ap) {
		super(ap,HomoFuncAntipattern.getAntipatternInfo().name);		
	}

	@Override
	public void addPages() 
	{
		funcColPage = new FunctionalOrCollectionPage((HomoFuncOccurrence)ap);
		createPartPage = new CreatePartPage((HomoFuncOccurrence)ap);
		createSubPartPage = new CreateSubPartPage((HomoFuncOccurrence)ap);
		fixNaturePage = new FixNaturePage((HomoFuncOccurrence)ap);
		defineIdenPage = new DefineIdentityProviderPage((HomoFuncOccurrence)ap);
		memberColPage = new MemberOrSubCollectionPage((HomoFuncOccurrence)ap);
		
		finishing = new FinishingPage();
		options = new HomoFuncRefactoringPage(getAp());
		
		presentation = new PresentationPage(
				HomoFuncAntipattern.getAntipatternInfo().name,
				HomoFuncAntipattern.getAntipatternInfo().acronym,
			ap.toString(),
			HomoFuncAntipattern.getAntipatternInfo().description,
			funcColPage, 
			options
		);
			
		addPage(presentation);	
		addPage(funcColPage);		
		addPage(createPartPage);
		addPage(createSubPartPage);
		addPage(fixNaturePage);
		addPage(defineIdenPage);
		addPage(memberColPage);
		addPage(options);
		addPage(finishing);
	}
	
	public HomoFuncOccurrence getAp() {
		return (HomoFuncOccurrence)ap;
	}
	
	public FunctionalOrCollectionPage getFunctionalOrCollectionPage()
	{
		return funcColPage;
	}
	public CreatePartPage getCreatePartPage()
	{
		return createPartPage;
	}
	public CreateSubPartPage getCreateSubPartPage()
	{
		return createSubPartPage;
	}
	public FixNaturePage getFixNaturePage()
	{
		return fixNaturePage;
	}
	public DefineIdentityProviderPage getDefineIdentityProviderPage()
	{
		return defineIdenPage;
	}
	public MemberOrSubCollectionPage getMemberOrSubCollectionPage()
	{
		return memberColPage;
	}
	
}