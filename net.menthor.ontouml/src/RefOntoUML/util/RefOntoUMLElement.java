package RefOntoUML.util;


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

import java.io.Serializable;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Generalization;
import RefOntoUML.Model;
import RefOntoUML.NamedElement;
import RefOntoUML.parser.OntoUMLNameHelper;

/**
 * @author John Guerson
 */

public class RefOntoUMLElement implements Serializable, Comparable<RefOntoUMLElement>{
	
	private static final long serialVersionUID = 6497601879574303331L;
	
	protected transient EObject element;
	protected String name;
	protected String type;
	protected String uniqueName="";	
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof RefOntoUMLElement)){
			return false;
		}
		return this.element.equals(((RefOntoUMLElement) obj).getElement());
	};
	
	/** 
	 * Create a CheckBox Tree Node Element from Element.
	 * 
	 * @param refElement
	 */
	public RefOntoUMLElement (EObject refElement) 
	{
		this(refElement,"");
	}
	
	/** 
	 * Create a CheckBox Tree Node Element from Element.
	 * 
	 * @param refElement
	 */
	public RefOntoUMLElement (EObject refElement, String uniqueName) 
	{
		this.element = refElement;
		
		if (refElement instanceof NamedElement) {
			NamedElement ne = (NamedElement) refElement;
			if(ne.getName()==null)
				name = "";
			else
				name = ne.getName();
		}
		if (refElement!=null){
			
			type = OntoUMLNameHelper.getTypeName(refElement);
		}
		if(refElement==null){
			type = "";
			name = "";			
		}
		
	    this.uniqueName= uniqueName; 
	}
		
	/**
	 * Create a CheckBox Tree Node Element from Name.
	 * 
	 * @param name
	 */
//	public OntoUMLElement (String name) 
//	{
//		this.name = name;
//	}	
	
	public String getUniqueName()
	{
		return uniqueName;
	}
	
	public String getTypeName()
	{
		return type;
	}
	
	/**
	 * To String.
	 */
	@Override
	public String toString() 
	{
		if (element instanceof Model)
		{
			if (name ==null) name = ""; 
			return type + " " + ((NamedElement)element).getName();
		}
		
		if (element instanceof Generalization)
		{			
			if (((Generalization)element).getGeneral()==null){
				return type + " null";
			}else{
				return type +" " + ((Generalization)element).getGeneral().getName();
			}
		}
		
		if (element instanceof RefOntoUML.Classifier)
		{
			return OntoUMLNameHelper.getTypeName(element, true)+" "+((NamedElement)element).getName();
		}
		
		if(element instanceof RefOntoUML.EnumerationLiteral){
			return OntoUMLNameHelper.getTypeName(element, true)+" "+((NamedElement)element).getName();
		}
		
		if (element instanceof RefOntoUML.Comment)
		{
			if(((RefOntoUML.Comment)element).getBody().length()>15)
				return type +" "+ ((RefOntoUML.Comment)element).getBody().substring(0,15)+" (...)";
			else
				return type +" "+ ((RefOntoUML.Comment)element).getBody();
		}
		
		if (element instanceof RefOntoUML.Constraintx)
		{			
			if(((RefOntoUML.Constraintx)element).getName()!=null){
				return type +" "+ ((RefOntoUML.Constraintx)element).getName();
			}else{
				return type +" null";
			}			
		}
		
		if (element instanceof RefOntoUML.GeneralizationSet)
		{		    
		    RefOntoUML.GeneralizationSet genset = (RefOntoUML.GeneralizationSet)element;
		    
		    String result = new String();
		    
		    result += "GeneralizationSet" + " " + ((NamedElement)element).getName() + " ";
		   
		    if (genset.parent()!=null){
		    	result += "{ ";
			    EList<Generalization> genlist = ((RefOntoUML.GeneralizationSet)element).getGeneralization();		    
			    int i=1;
			    for(Generalization gen: genlist)
			    {
			    	if (gen.getSpecific()!=null)
			    	{
			    		if(i < genlist.size()) result += gen.getSpecific().getName()+"->"+gen.getGeneral().getName()+", ";
			    		else result += gen.getSpecific().getName()+"->"+gen.getGeneral().getName() ;
			    	}
			    	i++;
			    }
			    result += " } ";
		    }
		    return result;		    
		}
		
		if (element instanceof RefOntoUML.Property)
		{		
			String TypeName;
			try{ TypeName = ((RefOntoUML.Property)element).getType().getName();}
			catch (Exception e) { TypeName = ""; }
			String name = ((RefOntoUML.Property)element).getName();
			Integer lower = ((RefOntoUML.Property)element).getLower();
			Integer upper = ((RefOntoUML.Property)element).getUpper();
			String lowerString = lower.toString();
			String upperString = upper.toString();
			if (lower == -1) lowerString = "*";
			if (upper == -1) upperString = "*";
						 
			return type+" "+name+"("+TypeName+")"+" ["+lowerString+","+upperString+"]";			
		}
		
		if (element instanceof RefOntoUML.Package && !(element instanceof RefOntoUML.Model))
		{
			if (name ==null) name = ""; 
			return type + " " + ((NamedElement)element).getName();
		}
		
		if (name == null || name.equals("")) 
		{	    
		    return type + " "+name;			
		}
		
		return type + " "+name;
	}
	
	public String getName()
	{
		return name;
	}
	/**
	 * Get Element.
	 */
	public EObject getElement() 
	{
		return element;
	}

	@Override
	public int compareTo(RefOntoUMLElement arg0) {
		int compareNames = this.name.compareTo(arg0.name);
		int compareTypes = this.type.compareTo(arg0.type);
		
		//if names are equals, order by type
		if(compareNames == 0){
			return compareTypes;
		}else{
			return compareNames;
		}
	}
}
