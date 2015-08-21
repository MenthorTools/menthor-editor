package net.menthor.editor.finder;

import RefOntoUML.Element;
import RefOntoUML.NamedElement;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;

/** Feature Element class */
public class FeatureElement {
	
	RefOntoUML.Element element;
	
	public FeatureElement(RefOntoUML.Element element){
		this.element = element;
	}
	
	public Element getElement() { 
		return element; 
	}
	
	@Override
	public String toString(){
		String result = new String();			
		if (element instanceof RefOntoUML.Property){
			Property p = (Property)element;
			String owner = new String();
			if(p.getAssociation()==null){
				owner = ""+OntoUMLParser.getStereotype(p.eContainer())+" "+((NamedElement)p.eContainer()).getName();
			}else{
				owner = ""+OntoUMLParser.getStereotype(p.getAssociation())+" "+((NamedElement)p.getAssociation()).getName();
			}
			result += "Property "+p.getType().getName()+": ("+p.getName()+") ["+p.getLower()+","+p.getUpper()+"] "+" (owner: "+owner+")";
		}			
		return result;
	}
}