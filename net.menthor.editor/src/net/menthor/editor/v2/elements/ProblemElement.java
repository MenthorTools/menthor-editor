package net.menthor.editor.v2.elements;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import org.eclipse.emf.ecore.EObject;

public class ProblemElement extends FoundElement {

	private String description = new String();
	public enum TypeProblem { SYNTACTIC, APP }
	public TypeProblem typeProblem = TypeProblem.APP;
	public int identifier = 0;
	
	public ProblemElement(EObject eobject, int identifier, String description, TypeProblem typeProblem){
		super(eobject);
		this.description = description;
		this.identifier=identifier;
		this.setTypeProblem(typeProblem);
	}

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public TypeProblem getTypeProblem() { return typeProblem; }
	public void setTypeProblem(TypeProblem typeProblem) { this.typeProblem = typeProblem; }
	
	public String getTypeProblemString() { 
		if(typeProblem == TypeProblem.APP) return "Application";
		else if (typeProblem == TypeProblem.SYNTACTIC) return "Syntactical";
		return "Unkown";
	}

	public int getIdentifier() { return identifier; }
	public String getIdentifierString(){ return String.format("%02d", identifier); }	
	public void setIdentifier(int identifier) { this.identifier = identifier; }	
}
