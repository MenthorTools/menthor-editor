package net.menthor.editor.ui;

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

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.NamedElement;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.elements.WarningElement;
import net.menthor.editor.v2.elements.ProblemElement.TypeProblem;

public class WarningVerificator {
	
	public OntoUMLParser refparser;
	public ArrayList<WarningElement> warnings = new ArrayList<WarningElement>();
	public double start =0 ;
	public double end =0 ;		
	
	public WarningVerificator(OntoUMLParser ontoparser)
	{
		this.refparser = ontoparser;
	}

	public ArrayList<WarningElement> getWarnings() { return warnings; }
	
	public String getTimingMessage()
	{
		return MessageFormat.format("Model verified in {0} ms, {1} warning(s) found", (end - start),  warnings.size());
	}
	
	public void run()
	{	
		start = System.currentTimeMillis();
		// # Warning : Unnamed name
		for(EObject c: refparser.getElements())
		{			
			if(c instanceof NamedElement){
				NamedElement ne = (NamedElement)c;
				if (ne.getName()==null || ne.getName().trim().isEmpty()) 
				{ 				
					String message = "Unnamed element";
					warnings.add(new WarningElement(c,0,message,TypeProblem.APP));
									
				}
			}
		}
		end = System.currentTimeMillis();
	}
}	
