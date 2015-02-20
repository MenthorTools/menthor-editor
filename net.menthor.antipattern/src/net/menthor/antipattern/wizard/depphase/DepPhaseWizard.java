package net.menthor.antipattern.wizard.depphase;

import java.util.ArrayList;

import net.menthor.antipattern.depphase.DepPhaseAntipattern;
import net.menthor.antipattern.depphase.DepPhaseOccurrence;
import net.menthor.antipattern.wizard.AntipatternWizard;
import net.menthor.antipattern.wizard.FinishingPage;
import net.menthor.antipattern.wizard.PresentationPage;

import org.eclipse.swt.widgets.List;

import RefOntoUML.Property;

public class DepPhaseWizard extends AntipatternWizard {

	public DepPhaseFirstPage firstPage;
	public DepPhaseSecondPage secondPage;
	
	public DepPhaseWizard(DepPhaseOccurrence ap) {
		super(ap,DepPhaseAntipattern.getAntipatternInfo().name);		
	}

	@Override
	public void addPages() 
	{
		firstPage = new DepPhaseFirstPage(getAp());
		secondPage = new DepPhaseSecondPage(getAp());
		
		finishing = new FinishingPage();
		options = new DepPhaseRefactoringPage(getAp());
		
		presentation = new PresentationPage(
			DepPhaseAntipattern.getAntipatternInfo().name,
			DepPhaseAntipattern.getAntipatternInfo().acronym,
			ap.toString(),
			DepPhaseAntipattern.getAntipatternInfo().description,
			firstPage,
			options
		);
			
		addPage(presentation);	
		addPage(firstPage);
		addPage(secondPage);
		addPage(options);
		addPage(finishing);
	}
	
	public DepPhaseOccurrence getAp() {
		return (DepPhaseOccurrence)ap;
	}
	
	public DepPhaseFirstPage getFirstPage()
	{
		return firstPage;
	}
	
	public DepPhaseSecondPage getSecondPage()
	{
		return secondPage;
	}
	
	protected ArrayList<Property> getPropertyFromList(List list){
		
		ArrayList<Property> result = new ArrayList<Property>();
		for (String item : list.getItems()) {
			Property p = getProperty(item);
			if(p!=null)
				result.add(p);
		}
		
		return result;	
	}
	
	protected Property getProperty(String propertyName){
		for(Property p: getAp().getRelatorEnds()){
			if(getAp().getParser().getStringRepresentation(p).compareToIgnoreCase(propertyName)==0) 
				return p;			
		}
		return null;
	}
	
	protected void addAllDependencies(List listToAdd, List listToRemove){
		if(listToAdd==null || listToRemove==null)
			return;
		
		listToAdd.removeAll();
		listToRemove.removeAll();
		
		for (Property p : getAp().getRelatorEnds())
			listToAdd.add(getAp().getParser().getStringRepresentation(p));
	}
	
	protected boolean contains(List list, String elem){
		for(String str: list.getItems()){
			if (str.equals(elem)) return true;
		}
		return false;
	}

}
