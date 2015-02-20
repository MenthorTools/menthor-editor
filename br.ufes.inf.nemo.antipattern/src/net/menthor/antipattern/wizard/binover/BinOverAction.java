package net.menthor.antipattern.wizard.binover;

import net.menthor.antipattern.binover.BinOverOccurrence;
import net.menthor.antipattern.binover.BinOverOccurrence.BinaryPropertyValue;
import net.menthor.antipattern.wizard.AntiPatternAction;
import RefOntoUML.Association;

public class BinOverAction extends AntiPatternAction<BinOverOccurrence>{

	private BinaryPropertyValue property;
	private Class<? extends Association> newStereotype;
	
	public BinOverAction(BinOverOccurrence ap) 
	{
		super(ap);
	}

	public enum Action { SET_BINARY_PROPERTY, SET_DISJOINTNESS, CHANGE_STEREOTYPE }
	
	public void setBinaryProperty(BinaryPropertyValue property){
		code=Action.SET_BINARY_PROPERTY;
		this.property = property;
	}
	
	public void setDisjointness(){
		code = Action.SET_DISJOINTNESS;
	}
	
	public void setChangeStereortype(Class<? extends Association> newStereotype){
		code = Action.CHANGE_STEREOTYPE;
		this.newStereotype = newStereotype;
	}
	
	@Override
	public void run() 
	{
		if(code==Action.SET_DISJOINTNESS)
			ap.makeEndsDisjoint();
		else if(code==Action.SET_BINARY_PROPERTY)
			ap.generateOCL(property);
		else if(code==Action.CHANGE_STEREOTYPE)
			ap.changeStereotype(newStereotype);
	}
	
	public BinaryPropertyValue getProperty() {
		return property;
	}

	@Override
	public String toString(){
		String result = "";
		if(code==Action.SET_BINARY_PROPERTY)
			result = "Create OCL constraint: Enforce "+property.toString().toLowerCase();
		else if(code==Action.SET_DISJOINTNESS)
			result = "Modify Model: Enforce disjointness between "+ap.getSource().getName()+" and "+ap.getTarget().getName();
		else if(code==Action.CHANGE_STEREOTYPE)
			result = "Modify Association : Change "+ap.getAssociation().getName()+" stereotype from "+BinOverWizard.getStereotypeName(ap.getAssociation().getClass())+" to "+
					 BinOverWizard.getStereotypeName(newStereotype);
		
		return result;
	}

	public Class<? extends Association> getNewStereotype() {
		return newStereotype;
	}

}
