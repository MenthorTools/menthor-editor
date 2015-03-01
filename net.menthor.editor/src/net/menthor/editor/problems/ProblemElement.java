package net.menthor.editor.problems;

import net.menthor.editor.finder.FoundElement;

import org.eclipse.emf.ecore.EObject;

public class ProblemElement extends FoundElement {

	private String description = new String();
	public enum TypeProblem { SYNTACTIC, APP }
	public TypeProblem typeProblem = TypeProblem.APP;
	public int identifier = 0;
	
	public ProblemElement(EObject eobject, int identifier, String description, TypeProblem typeProblem) 
	{
		super(eobject);
		this.description = description;
		this.identifier=identifier;
		this.setTypeProblem(typeProblem);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeProblem getTypeProblem() {
		return typeProblem;
	}

	public void setTypeProblem(TypeProblem typeProblem) {
		this.typeProblem = typeProblem;
	}
	
	public String getTypeProblemString() { 
		if(typeProblem == TypeProblem.APP) return "Application";
		else if (typeProblem == TypeProblem.SYNTACTIC) return "Syntactical";
		return "Unkown";
	}

	public int getIdentifier() {
		return identifier;
	}

	public String getIdentifierString(){
		return String.format("%02d", identifier);
	}
	
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	
}
