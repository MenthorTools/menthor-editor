package net.menthor.validator.meronymic.checkers;

import javax.swing.JDialog;

import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import RefOntoUML.parser.OntoUMLParser;

public abstract class MeronymicError<T> {
	
	T element;
	Fix fix;
	OutcomeFixer fixer;
	OntoUMLParser parser;
	
	public MeronymicError(OntoUMLParser parser, T element){
		this.element = element;
		this.parser = parser;
		
		fix = new Fix();
		fixer = new OutcomeFixer(parser.getModel());
	}
	
	public T getElement(){
		return element;
	}
	
	public Fix getFix() {
		return fix;
	}
	
	public abstract boolean hasAction();
	public abstract String getType();
	public abstract String getDescription();
	public abstract JDialog createDialog(JDialog parent);
	public abstract Fix fix();

	
}
