package net.menthor.editor.v2.ui.operation.model;

import java.text.ParseException;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Element;
import RefOntoUML.Meronymic;
import RefOntoUML.NamedElement;
import RefOntoUML.Property;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.editor.v2.ui.operation.ModelOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class MetaPropertyModelOperation extends ModelOperation {

	private static final long serialVersionUID = 7518976801833128513L;
	
	public enum MetaProperty {MULTIPLICITY, NAME, ABSTRACT, DERIVED, EXTENSIONAL, ESSENTIAL, INSEPARABLE, IMMUTABLE_PART, IMMUTABLE_WHOLE, SHAREABLE};
	
	private Element element;
	private Meronymic meronymic;
	private Property property;
	private Collective collective;
	private Classifier classifier;
	private Association association;
	private NamedElement namedElement;
	
	private MetaProperty metaProperty;
	private Object newValue, oldValue;
	
	private MetaPropertyModelOperation(Element element){
		super();
		this.operationType = OperationType.MODIFY;
		this.element = element;	
	}
	
	public MetaPropertyModelOperation(Element element, MetaProperty metaProperty, Object newValue){
		this(element);
		this.metaProperty = metaProperty;
		this.oldValue = getCurrentValue();
		this.newValue = newValue;
	}
	
	public MetaPropertyModelOperation(Element element, MetaProperty metaProperty){
		this(element);
		this.metaProperty = metaProperty;
		this.oldValue = getCurrentValue();
		this.newValue = !((boolean)oldValue);
	}
		
	private Object getCurrentValue(){
		switch (metaProperty) {
			case MULTIPLICITY:
				property = (Property) element;
				return RefOntoUMLFactoryUtil.getMultiplicityAsString(property);
			case NAME:
				namedElement = (NamedElement)element; 
				return namedElement.getName();
			case ABSTRACT:
				classifier = (Classifier)element;
				return classifier.isIsAbstract();
			case EXTENSIONAL:
				collective = (Collective)element;
				return collective.isIsExtensional();
			case ESSENTIAL:
				meronymic = (Meronymic)element;
				return meronymic.isIsEssential();
			case INSEPARABLE:
				meronymic = (Meronymic)element;
				return meronymic.isIsInseparable();
			case IMMUTABLE_PART:
				meronymic = (Meronymic)element;
				return meronymic.isIsImmutablePart();
			case IMMUTABLE_WHOLE:
				meronymic = (Meronymic)element;
				return meronymic.isIsImmutableWhole();
			case SHAREABLE:
				meronymic = (Meronymic)element;
				return meronymic.isIsShareable();
			case DERIVED:
				association = (Association)element;
				return association.isIsDerived();
		}
		
		return null;
	}
	
	private void setValue(){
		Object value;
		
		if(isUndo()){
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
				namedElement.setName((String) value);
				break;
			case ABSTRACT:
				classifier.setIsAbstract((boolean)value);
				break;
			case EXTENSIONAL:
				collective.setIsExtensional((boolean)value);
				break;
			case ESSENTIAL:
				meronymic.setIsEssential((boolean)value);
				break;
			case INSEPARABLE:
				meronymic.setIsInseparable((boolean)value);
				break;
			case IMMUTABLE_PART:
				meronymic.setIsImmutablePart((boolean)value);
				break;
			case IMMUTABLE_WHOLE:
				meronymic.setIsImmutableWhole((boolean)value);
				break;
			case SHAREABLE:
				meronymic.setIsShareable((boolean)value);
				break;
			case DERIVED:
				association.setIsDerived((boolean)value);
				break;
		}
	}
	
	@Override
	public void undo(){
		super.undo();
		setValue();
		System.out.println(undoStatus());
		notifier.notifyChange(this, element);
	}
	
	@Override
	public void run() {	    
		super.run();
		setValue();
		System.out.println(runStatus());
		notifier.notifyChange(this, element);
	}
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] : "+element;
	}

	public String runStatus(){
		return "["+operationType.pastTense()+"] : "+element;
	}
	
	
}
