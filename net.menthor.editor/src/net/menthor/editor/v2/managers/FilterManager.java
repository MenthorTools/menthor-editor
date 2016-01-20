package net.menthor.editor.v2.managers;

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
import net.menthor.editor.ui.Models;

public class FilterManager extends BaseManager {

	private static FilterManager instance = new FilterManager();
	public static FilterManager get() { return instance; }
	
	/** Tell the application to work only with the set of elements contained in the diagram. */
	public void workingOnlyWith(StructureDiagram diagram){
		List<EObject> elements = OccurenceManager.get().getElements(diagram);
		OntoUMLParser refparser = Models.getRefparser();				
		refparser.select((ArrayList<EObject>)elements,true);
		List<EObject> added = refparser.autoSelectDependencies(OntoUMLParser.NO_HIERARCHY,false);
		elements.removeAll(added);
		elements.addAll(added);
		//browser.getTree().check(elements, true); //no checkbox on the browser				
		browser.getTree().updateUI();		
		Models.setRefparser(refparser);
	}
	
	/** Tell the application to work with all elements in the model. */
	public void workingWithAll(){
		OntoUMLParser refparser = Models.getRefparser();					
		//pb.getTree().checkModelElement(currentProject.getModel()); //no checkbox on the browser
		refparser.selectAll();		
		browser.getTree().updateUI();		
		Models.setRefparser(refparser);
	}
	
	/** Tell the application to work only with the checked elements in the tree. */
	public List<Object> workingOnlyWithChecked(){ //takes too long
		OntoUMLParser refparser = Models.getRefparser();
		List<Object> selected = browser.getTree().getCheckedElements();
		List<EObject> result = new ArrayList<EObject>();
		for(Object c: selected) result.add((EObject)c);
		refparser.select(result,true);		
		List<EObject> added = refparser.autoSelectDependencies(OntoUMLParser.NO_HIERARCHY,false);		
		selected.removeAll(added);
		selected.addAll(added);		
		//modeltree.getTree().checkModelElements(selected, true); //no checkbox on the browser		
		browser.getTree().updateUI();	
		Models.setRefparser(refparser);		
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
		OntoUMLParser refparser = Models.getRefparser();				
		refparser.select((ArrayList<EObject>)elements,true);
		List<EObject> added = refparser.autoSelectDependencies(OntoUMLParser.NO_HIERARCHY,false);
		elements.removeAll(added);
		elements.addAll(added);
		//check in the tree the selected elements of the parser		
		//modeltree.getTree().check(elements, true); //no checkbox on teh browser					
		browser.getTree().updateUI();		
		Models.setRefparser(refparser);
	}
	
}
