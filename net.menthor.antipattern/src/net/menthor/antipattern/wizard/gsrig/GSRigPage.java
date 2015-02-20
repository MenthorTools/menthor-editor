package net.menthor.antipattern.wizard.gsrig;

import net.menthor.antipattern.GSRig.GSRigAntipattern;
import net.menthor.antipattern.GSRig.GSRigOccurrence;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

public class GSRigPage extends WizardPage {

	protected GSRigOccurrence gsrig;	
	
	/**
	 * Create the wizard.
	 */
	public GSRigPage(GSRigOccurrence gsrig) 
	{
		super("GSRigPage");		
		this.gsrig = gsrig;		
		setTitle(GSRigAntipattern.getAntipatternInfo().getName());		
	}
	
	public GSRigWizard getGSRigWizard(){
		return (GSRigWizard)getWizard();
	}

	@Override
	public void createControl(Composite arg0) {
		
	}
	
	@Override
	public IWizardPage getPreviousPage(){
		getGSRigWizard().setCanFinish(false);
		return super.getPreviousPage();
	}
}
