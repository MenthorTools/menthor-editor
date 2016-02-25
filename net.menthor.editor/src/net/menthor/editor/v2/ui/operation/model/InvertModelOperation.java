package net.menthor.editor.v2.ui.operation.model;

import org.tinyuml.umldraw.MenthorFactory;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.LiteralInteger;
import RefOntoUML.LiteralUnlimitedNatural;
import RefOntoUML.Property;
import RefOntoUML.Relationship;
import RefOntoUML.Type;
import net.menthor.editor.v2.ui.operation.ModelOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class InvertModelOperation extends ModelOperation {

	private static final long serialVersionUID = 7518976801833128513L;
	
	public enum InvertMode {ENDPOINTS, MULTIPLICITIES, TYPES, NAMES};
	
	private Generalization generalization;
	private Association association;
	private Relationship relationship;
	
	private InvertMode metaProperty;
	
	
	public InvertModelOperation(Relationship relationship, InvertMode metaProperty){
		super();
		this.operationType = OperationType.MODIFY;
		this.metaProperty = metaProperty;
		
		this.relationship = relationship;
		
		if(relationship instanceof Generalization) {
			generalization = (Generalization) relationship;
		}
		else if(relationship instanceof Association){
			association = (Association) relationship;
		}
	}
		
	private void invert(){
		switch (metaProperty) {
			case ENDPOINTS:
				invertEndPoints();
				break;
			case MULTIPLICITIES:
				invertEndMultiplicities();
				break;
			case TYPES:
				invertEndTypes();
				break;
			case NAMES:
				invertEndNames();
				break;			
		}
	}
	
	
	/** Invert end points of an association. */
	public void invertEndPoints(){
		if(relationship instanceof Association){
			Property source = association.getMemberEnd().get(0);
	   		Property target = association.getMemberEnd().get(1);	   		
	   		association.getMemberEnd().clear();	
	   		association.getOwnedEnd().clear();
	   		association.getNavigableOwnedEnd().clear();	   		
	   		association.getMemberEnd().add(target);
	   		association.getMemberEnd().add(source);   	
	   		association.getOwnedEnd().add(target);
	   		association.getOwnedEnd().add(source);
	   		association.getNavigableOwnedEnd().add(target);
	   		association.getNavigableOwnedEnd().add(source);	   		
		}
		else if (relationship instanceof Generalization){
			Classifier general = generalization.getGeneral();
			Classifier specific = generalization.getSpecific();			
			generalization.setSpecific(general);
			generalization.setGeneral(specific);			
		}		
	}
	
	/** Invert names of end points of an association. */
	public void invertEndNames(){
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		String sourceName = source.getName();
   		String targetName = target.getName();
   		source.setName(targetName);
   		target.setName(sourceName);
	}
	
	/** Invert multiplicities of end points of an association. */
	public void invertEndMultiplicities(){
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		LiteralInteger sourceLower = MenthorFactory.get().createLiteralInteger();
   		LiteralUnlimitedNatural sourceUpper = MenthorFactory.get().createLiteralUnlimitedNatural();
   		sourceLower.setValue(target.getLower());
   		sourceUpper.setValue(target.getUpper());   		
   		LiteralInteger targetLower = MenthorFactory.get().createLiteralInteger();
   		LiteralUnlimitedNatural targetUpper = MenthorFactory.get().createLiteralUnlimitedNatural();
   		targetUpper.setValue(source.getUpper());
   		targetLower.setValue(source.getLower());  	
   		source.setUpperValue(sourceUpper);
   		source.setLowerValue(sourceLower);
   		target.setUpperValue(targetUpper);
   		target.setLowerValue(targetLower);
	}
	
	/** Invert types of end points of an association. */
	public void invertEndTypes(){
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		Type sourceType = source.getType();
   		Type targetType = target.getType();
   		source.setType(targetType);
   		target.setType(sourceType);
	}
	
	
	@Override
	public void undo(){
		super.undo();
		invert();
		System.out.println(undoStatus());
		notifier.notifyChange(this, relationship);
	}
	
	@Override
	public void run() {	    
		super.run();
		invert();
		System.out.println(runStatus());
		notifier.notifyChange(this, relationship);
	}
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] : "+relationship;
	}

	public String runStatus(){
		return "["+operationType.pastTense()+"] : "+relationship;
	}
	
	
}
