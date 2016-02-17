package net.menthor.editor.v2.ui.operation.model;

import java.text.ParseException;

import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Element;
import RefOntoUML.Meronymic;
import RefOntoUML.NamedElement;
import RefOntoUML.Property;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.ModelOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class MetaPropertyModelOperation extends ModelOperation {

	private static final long serialVersionUID = 7518976801833128513L;
	
	public enum MetaProperty {MULTIPLICITY, NAME, ABSTRACT, EXTENSIONAL, ESSENTIAL, INSEPARABLE, IMMUTABLE_PART, IMMUTABLE_WHOLE, SHAREABLE};
	
	private Element element;
	private MetaProperty metaProperty;
	
	private Object newValue, oldValue;
	
	public MetaPropertyModelOperation(Element element, MetaProperty metaProperty, Object newValue){
		super();
		this.operationType = OperationType.MODIFY;
		
		this.element = element;	
		this.metaProperty = metaProperty;
		this.newValue = newValue;
		this.oldValue = getCurrentValue();
	}
	
	private Object getCurrentValue(){
		switch (metaProperty) {
			case MULTIPLICITY:
				return RefOntoUMLFactoryUtil.getMultiplicityAsString((Property) element);
			case NAME:
				return ((NamedElement)element).getName();
			case ABSTRACT:
				return ((Classifier)element).isIsAbstract();
			case EXTENSIONAL:
				return ((Collective)element).isIsExtensional();
			case ESSENTIAL:
				return ((Meronymic)element).isIsEssential();
			case INSEPARABLE:
				return ((Meronymic)element).isIsInseparable();
			case IMMUTABLE_PART:
				return ((Meronymic)element).isIsImmutablePart();
			case IMMUTABLE_WHOLE:
				return ((Meronymic)element).isIsImmutableWhole();
			case SHAREABLE:
				return ((Meronymic)element).isIsShareable();
		}
		
		return null;
	}
	
	private void setValue(){
		Object value;
		
		if(actionType==ActionType.UNDO){
			value = oldValue;
		}
		else{
			value = newValue;
		}
		
		switch (metaProperty) {
			case MULTIPLICITY:
				try {
					RefOntoUMLFactoryUtil.setMultiplicityFromString((Property)element, (String)value);
				} catch (ParseException e) { }
				break;
			case NAME:
				((NamedElement)element).setName((String) value);
				break;
			case ABSTRACT:
				((Classifier)element).setIsAbstract((boolean)value);
				break;
			case EXTENSIONAL:
				((Collective)element).setIsExtensional((boolean)value);
				break;
			case ESSENTIAL:
				((Meronymic)element).setIsEssential((boolean)value);
				break;
			case INSEPARABLE:
				((Meronymic)element).setIsInseparable((boolean)value);
				break;
			case IMMUTABLE_PART:
				((Meronymic)element).setIsImmutablePart((boolean)value);
				break;
			case IMMUTABLE_WHOLE:
				((Meronymic)element).setIsImmutableWhole((boolean)value);
				break;
			case SHAREABLE:
				((Meronymic)element).setIsShareable((boolean)value);
				break;
		}
	}
	
	@Override
	public void undo(){
		super.undo();
		setValue();
		System.out.println(undoStatus());
		notifier.notifyChange(this, actionType, element);
	}
	
	@Override
	public void run() {	    
		super.run();
		setValue();
		System.out.println(runStatus());
		notifier.notifyChange(this, actionType, element);
	}
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] : "+element;
	}

	public String runStatus(){
		return "["+operationType.pastTense()+"] : "+element;
	}
	
	
}
