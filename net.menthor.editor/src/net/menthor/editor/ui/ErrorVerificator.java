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
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.AggregationKind;
import RefOntoUML.Association;
import RefOntoUML.DataType;
import RefOntoUML.Meronymic;
import RefOntoUML.MixinClass;
import RefOntoUML.NamedElement;
import RefOntoUML.PrimitiveType;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.elements.ErrorElement;
import net.menthor.editor.v2.elements.ProblemElement.TypeProblem;

public class ErrorVerificator {

	public OntoUMLParser refparser;
	public ArrayList<ErrorElement> errors = new ArrayList<ErrorElement>();
	public double start =0 ;
	public double end =0 ;		
	
	public ErrorVerificator(OntoUMLParser ontoparser)
	{
		this.refparser = ontoparser;
	}

	public ArrayList<ErrorElement> getErrors() { return errors; }
	
	public String getTimingMessage(){
		return MessageFormat.format("Model verified in {0} ms, {1} error(s) found", (end - start),  errors.size());
	}
	
	public void run()
	{	
		start = System.currentTimeMillis();
		List<String> names = new ArrayList<String>();
		for(EObject c: refparser.getElements())
		{			
			if(c instanceof RefOntoUML.Class || c instanceof RefOntoUML.Relationship || c instanceof RefOntoUML.DataType)
			{
				// # Error : Invalid stereotype
				if (!refparser.isValidStereotype(c)) 
				{
					String message = "Invalid stereotype";
					errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
				}			
			}
			// # Error : Name contains an OCL keyword
			if(!(c instanceof PrimitiveType) && (c instanceof NamedElement))
			{
				if(refparser.isOCLkeyword(((NamedElement)c).getName())) 
				{
					String message = "Name contains an OCL keyword";
					errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
				}
			}
			// # Error : Mixin not abstract
			if((c instanceof MixinClass) && (((MixinClass)c).isIsAbstract()== false)) 
			{ 
				String message = "Mixin not abstract";
				errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
			}		
			// #Error : Association has more than two association ends
			if(c instanceof Association){
				if(((Association)c).getMemberEnd().size()!=2)			
				{ 
					String message = "Association has not two association ends";				
					errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
				}
			}
			// # Error : Whole must have aggregation kind equal to Composite or Shared.
			// # Error : Part must have aggregation kind equal to None.
			if(c instanceof Meronymic){
				Meronymic m = (Meronymic)c;
				if(m.getMemberEnd().size()==2)
				{
					if(m.wholeEnd().getAggregation().equals(AggregationKind.NONE)) 
					{
						String message = "Whole must have aggregation kind equal to composite or shared";
						errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
					}
					if(!m.partEnd().getAggregation().equals(AggregationKind.NONE)) 
					{
						String message = "Part must have aggregation kind equal to none";
						errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
					}
				}
			}
			// # Error : Property type is null
			if(c instanceof Property){
				if(((Property)c).getType()==null){
					String message = new String();
					if(((Property)c).getAssociation()==null) message = "Attribute type is null";
					else message = "Association end type is null";
					errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
				}
			}
			// # Error : Duplicated names
			if(c instanceof RefOntoUML.Class || c instanceof DataType){
				String name = ((NamedElement)c).getName();
				if(!names.contains(name)){
					names.add(name);	
				}else{
					String message = new String();
					message = "Duplicated Name. There is more than one type with that same name.";					
					errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
				}				
			}
		}
		end = System.currentTimeMillis();
	}
}
