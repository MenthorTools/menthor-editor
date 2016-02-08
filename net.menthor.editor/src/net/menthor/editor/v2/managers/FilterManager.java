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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.Property;
import RefOntoUML.Relationship;
import RefOntoUML.parser.OntoUMLParser;

public class FilterManager extends BaseManager {

	// -------- Lazy Initialization

	private static class FilerLoader {
        private static final FilterManager INSTANCE = new FilterManager();
    }	
	public static FilterManager get() { 
		return FilerLoader.INSTANCE; 
	}	
    private FilterManager() {
        if (FilerLoader.INSTANCE != null) throw new IllegalStateException("FilterManager already instantiated");
    }		
    
    // ----------------------------
	
	/** Tell the application to work only with the set of elements contained in the diagram. */
	public void workingOnlyWith(StructureDiagram diagram){
		List<EObject> elements = OccurenceManager.get().getElements(diagram);
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();				
		refparser.select((ArrayList<EObject>)elements,true);
		List<EObject> added = refparser.autoSelectDependencies(OntoUMLParser.NO_HIERARCHY,false);
		elements.removeAll(added);
		elements.addAll(added);
		//browser.getTree().check(elements, true); //no checkbox on the browser				
		tree().updateUI();		
	}
	
	/** Tell the application to work with all elements in the model. */
	public void workingWithAll(){
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();					
		//pb.getTree().checkModelElement(currentProject.getModel()); //no checkbox on the browser
		refparser.selectAll();		
		tree().updateUI();	
	}
	
	/** Tell the application to work only with the checked elements in the tree. */
	public List<Object> workingOnlyWithChecked(){ //takes too long
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();
		List<Object> selected = tree().getCheckedObjects();
		List<EObject> result = new ArrayList<EObject>();
		for(Object c: selected) result.add((EObject)c);
		refparser.select(result,true);		
		List<EObject> added = refparser.autoSelectDependencies(OntoUMLParser.NO_HIERARCHY,false);		
		selected.removeAll(added);
		selected.addAll(added);		
		//modeltree.getTree().checkModelElements(selected, true); //no checkbox on the browser		
		tree().updateUI();		
		return selected;
	}
	
	/** Tell the application to work only with the elements contained in these diagrams. */
	public void workingOnlyWith(ArrayList<StructureDiagram> diagrams){
		ArrayList<EObject> elements = new ArrayList<EObject>();
		for(StructureDiagram sd: diagrams) {
			for(DiagramElement de: sd.getChildren()){
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
		}
		//complete missing/mandatory dependencies on the parser
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();				
		refparser.select((ArrayList<EObject>)elements,true);
		List<EObject> added = refparser.autoSelectDependencies(OntoUMLParser.NO_HIERARCHY,false);
		elements.removeAll(added);
		elements.addAll(added);
		//check in the tree the selected elements of the parser		
		//modeltree.getTree().check(elements, true); //no checkbox on teh browser					
		tree().updateUI();		
	}
	
}
