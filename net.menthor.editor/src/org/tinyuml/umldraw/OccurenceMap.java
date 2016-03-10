package org.tinyuml.umldraw;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Element;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Property;
import RefOntoUML.Relationship;

import net.menthor.editor.v2.OntoumlDiagram;

public class OccurenceMap {

	// -------- Lazy Initialization
	
	private static class OccurenceLoader {
        private static final OccurenceMap INSTANCE = new OccurenceMap();
    }	
	public static OccurenceMap get() { 
		return OccurenceLoader.INSTANCE; 
	}	
    private OccurenceMap() {
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
	public void addAll(List<OntoumlDiagram> diagrams){		
		for(OntoumlDiagram sd: diagrams) add((StructureDiagram)sd);
	}
	
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
	public List<Element> getElements(List<DiagramElement> diagramElements){
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
		if(map.get(element)!=null) {
			return map.get(element);		
		}
		if(element instanceof Property) {
			return getDiagramElements((RefOntoUML.Element)element.eContainer());
		}
		if(element instanceof EnumerationLiteral) {
			return getDiagramElements(((RefOntoUML.EnumerationLiteral)element).getEnumeration());
		}
		if (element instanceof GeneralizationSet) {
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
	public List<DiagramElement> getDiagramElements(List<Element> elements)	{
		List<DiagramElement> list = new ArrayList<DiagramElement>();		
		for(Element elem: elements){
			list.addAll(getDiagramElements(elem));
		}
		return list;
	}
	public List<DiagramElement> getDiagramElements(List<Element> elements, StructureDiagram diagram){
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
		List<DiagramElement> dElems= getDiagramElements(element);
		
		for (DiagramElement diagramElement : dElems) {
			list.add(diagramElement.getDiagram());
		}
	
		return list;
	}
	
	public List<Generalization> getGeneralizations(List<DiagramElement> diagramElements){
		List<Generalization> gens = new ArrayList<Generalization>();		
		for(DiagramElement dElem: diagramElements){
			if (dElem instanceof GeneralizationElement){
				Generalization gen = ((GeneralizationElement)dElem).getGeneralization();				
				if(gen!=null) gens.add(gen);
			}
		}
		return gens;
	}

	public List<GeneralizationSet> getGeneralizationSets(List<DiagramElement> diagramElements){
		// retain only generalization sets from selected
		List<GeneralizationSet> genSets = new ArrayList<GeneralizationSet>();		
		for(DiagramElement dElem: diagramElements){
			if (dElem instanceof GeneralizationElement){
				Generalization gen = ((GeneralizationElement)dElem).getGeneralization();
				if (gen.getGeneralizationSet()!=null && !gen.getGeneralizationSet().isEmpty()) {
					for(GeneralizationSet gs: gen.getGeneralizationSet()) {
						if (!genSets.contains(gs)) genSets.add(gs);				
					}
				}
			}
		}
		return genSets;
	}

}
