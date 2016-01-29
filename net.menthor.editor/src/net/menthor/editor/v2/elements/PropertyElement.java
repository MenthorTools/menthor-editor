package net.menthor.editor.v2.elements;

import RefOntoUML.Element;
import RefOntoUML.NamedElement;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;

public class PropertyElement {
	
	protected RefOntoUML.Element element;
	
	public PropertyElement(RefOntoUML.Element element){
		this.element = element;
	}
	
	public Element getElement() { return element; }
	
	@Override
	public String toString(){
		String result = new String();			
		if (element instanceof RefOntoUML.Property){
			Property p = (Property)element;
			String owner = new String();
			if(p.getAssociation()==null){
				owner = ""+OntoUMLParser.getStereotype((RefOntoUML.Element)p.eContainer())+" "+((NamedElement)p.eContainer()).getName();
			}else{
				owner = ""+OntoUMLParser.getStereotype(p.getAssociation())+" "+((NamedElement)p.getAssociation()).getName();
			}
			result += "Property "+p.getType().getName()+": ("+p.getName()+") ["+p.getLower()+","+p.getUpper()+"] "+" (owner: "+owner+")";
		}			
		return result;
	}
}