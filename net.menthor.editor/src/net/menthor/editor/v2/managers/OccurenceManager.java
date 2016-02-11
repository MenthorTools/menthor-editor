package net.menthor.editor.v2.managers;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Element;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Property;
import RefOntoUML.Relationship;

import net.menthor.editor.v2.OntoumlDiagram;

public class OccurenceManager {

	// -------- Lazy Initialization
	
	private static class OccurenceLoader {
        private static final OccurenceManager INSTANCE = new OccurenceManager();
    }	
	public static OccurenceManager get() { 
		return OccurenceLoader.INSTANCE; 
	}	
    private OccurenceManager() {
        if (OccurenceLoader.INSTANCE != null) throw new IllegalStateException("OccurenceManager already instantiated");
    }	
    
    // ----------------------------
    
	/** a mapping between the abstract and concrete syntaxes */
	private HashMap<Element,List<DiagramElement>> map = new HashMap<Element, List<DiagramElement>>();
	
	/** add */
	public boolean add(Element element, DiagramElement diagramElement){	
		if (element==null || diagramElement==null) return false;		
		if(map.get(element)==null){
			List<DiagramElement> list = new ArrayList<DiagramElement>();
			list.add(diagramElement);
			map.put(element, list);
			return true;			
		}
		if(map.get(element)!=null){
			if(!map.get(element).contains(diagramElement)){				
				map.get(element).add(diagramElement);
				return true;
			}			
		}
		return false;
	}
	
	/** add */
	public boolean add (StructureDiagram diagram){
		boolean succeeds=false;		
		for(DiagramElement dElem: diagram.getChildren()){
			if (dElem instanceof ClassElement) {
				add(((ClassElement)dElem).getClassifier(), dElem);
				succeeds=true;
			}
			if (dElem instanceof AssociationElement) {
				add(((AssociationElement)dElem).getRelationship(), dElem);
				succeeds=true;
			}
			if (dElem instanceof GeneralizationElement) {
				add(((GeneralizationElement)dElem).getRelationship(), dElem);
				succeeds=true;
			}
		}
		return succeeds;
	}
	
	/** remove */
	public boolean remove(DiagramElement diagramElem){			
		RefOntoUML.Element element = getElement(diagramElem);
		if(element==null) return false;		
		if(element!=null){
			if(map.get(element).indexOf(diagramElem)!=-1){
				map.get(element).remove(diagramElem);	
				return true;
			}			
			if(map.get(element).size()==0){				
				map.remove(element);
				return false;
			}			
		}		
		return false;
	}
	
	/** print */
	public void print(){
		for(RefOntoUML.Element e: map.keySet()){	
			System.out.print(e+" - ");
			int idx = 0;
			for(DiagramElement de: map.get(e)){
				if(idx == map.get(e).size()-1) System.out.print(de.hashCode()+"|"+de.getDiagram());
				else System.out.print(de.hashCode()+"|"+de.getDiagram()+", ");
				idx++;				
			}			
			System.out.println();
		}
	}	
	
	/** get element */
	public RefOntoUML.Element getElement(DiagramElement value){    	
        for (Entry<RefOntoUML.Element,List<DiagramElement>> entry : map.entrySet()){
            if (entry.getValue().contains(value)) return entry.getKey();
        }
        return null;
    }	
	public List<Element> getElements(Collection<DiagramElement> diagramElements){
		List<Element> list = new ArrayList<Element>();		
		for(DiagramElement e: diagramElements){
			Element elem = getElement(e);
			if(elem!=null) list.add(elem);
		}
		return list;
	}
	public List<EObject> getElements(StructureDiagram diagram){
		List<EObject> elements = new ArrayList<EObject>();
		for(DiagramElement de: diagram.getChildren()){
			if(de instanceof ClassElement) {
				Classifier c = ((ClassElement)de).getClassifier();
				elements.add(c);
				if(c instanceof RefOntoUML.Class) {
					for(Property attr: ((RefOntoUML.Class)c).getOwnedAttribute()) {
						elements.add(attr);
						if(!elements.contains(attr.getType())) elements.add(attr.getType());
					}
				}
				if(c instanceof RefOntoUML.DataType) {
					for(Property attr: ((RefOntoUML.DataType)c).getOwnedAttribute()) {
						elements.add(attr);
						if(!elements.contains(attr.getType())) elements.add(attr.getType());
					}
				}
			}
			if(de instanceof AssociationElement) { 
				Association r = (Association)((AssociationElement)de).getRelationship();
				elements.add(r.getMemberEnd().get(0));
				elements.add(r.getMemberEnd().get(1));
				elements.add(r);								
			}
			if(de instanceof GeneralizationElement) {
				Relationship rel = ((GeneralizationElement)de).getRelationship();
				elements.add(rel);
				elements.addAll(((Generalization)rel).getGeneralizationSet());				 
			}
		}	
		return elements;
	}	
	
	/** get diagram elements */
	public List<DiagramElement> getDiagramElements (Element element){	
		if(map.get(element)!=null) return map.get(element);		
		if(element instanceof Property) return getDiagramElements((RefOntoUML.Element)element.eContainer());
		if(element instanceof EnumerationLiteral) return getDiagramElements(((RefOntoUML.EnumerationLiteral)element).getEnumeration());
		if (element instanceof GeneralizationSet){
			List<DiagramElement> result = new ArrayList<DiagramElement>();
			for(Generalization gen: ((RefOntoUML.GeneralizationSet)element).getGeneralization()){
				result.addAll(getDiagramElements(gen));
			}
			return result;
		}
		return new ArrayList<DiagramElement>();
	}
	/** get diagram elements */
	public DiagramElement getDiagramElement (Element element){
		List<DiagramElement> list = getDiagramElements(element);
		if(list.size()>0) return list.get(0);
		else return null;
	}
	public List<DiagramElement> getDiagramElements(Collection<Element> elements)	{
		List<DiagramElement> list = new ArrayList<DiagramElement>();		
		for(Element elem: elements){
			list.addAll(getDiagramElements(elem));
		}
		return list;
	}
	public List<DiagramElement> getDiagramElements(Collection<Element> elements, StructureDiagram diagram){
		List<DiagramElement> list = new ArrayList<DiagramElement>();
		for(DiagramElement de: getDiagramElements(elements)){			
			if (diagram.containsChild(de)) list.add(de);
		}		
		return list;
	}
	public DiagramElement getDiagramElement(Element element, StructureDiagram diagram){		
		List<DiagramElement> list = new ArrayList<DiagramElement>();		
		for(DiagramElement de: getDiagramElements(element)){					
			if (diagram.getChildren().contains(de)) list.add(de); 				
		}
		if(list.size()>0) return list.get(0);	
		//check those with no diagram
		for(DiagramElement de: getDiagramElements(element)){
			if(de.getDiagram()==null) return de;
		}								
		return null;
	}
		
	/** get diagrams */
	public List<OntoumlDiagram> getDiagrams(RefOntoUML.Element element){
		List<OntoumlDiagram> list = new ArrayList<OntoumlDiagram>();
		for(OntoumlDiagram d: ProjectManager.get().getProject().getDiagrams()){
			if(d instanceof StructureDiagram){
				StructureDiagram diagram = (StructureDiagram)d;				
				List<DiagramElement> dElems= getDiagramElements(element);
				for(DiagramElement elem: dElems){
					if (diagram.containsChild(elem)) {											
						list.add(diagram);
					}	
				}				
			}
		}
		return list;
	}

}
