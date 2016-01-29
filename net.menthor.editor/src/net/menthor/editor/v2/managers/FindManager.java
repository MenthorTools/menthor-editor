package net.menthor.editor.v2.managers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.NamedElement;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.Models;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.elements.FoundElement;
import net.menthor.editor.v2.ui.DiagramListDialog;

public class FindManager extends BaseManager {

	private static FindManager instance = new FindManager();
	public static FindManager get() { return instance; }
		
	/** show dialog with diagram occurrence of this element */
	public void findInDiagrams(Object element){
		RefOntoUML.Element refElem = null;
		if(element instanceof RefOntoUML.Element) refElem = (RefOntoUML.Element)element;
		if(element instanceof FoundElement) refElem = (RefOntoUML.Element)((FoundElement)element).getElement();
		List<OntoumlDiagram> diagrams = OccurenceManager.get().getDiagrams(refElem);
		DiagramListDialog.open(diagramManager.getFrame(), diagrams);		
	}
	
	/** select occurence of this element in the project tree*/
	public void findInProjectTree(Object element){
		RefOntoUML.Element refElem = null;
		if(element instanceof RefOntoUML.Element) refElem = (RefOntoUML.Element)element;
		if(element instanceof FoundElement) refElem = (RefOntoUML.Element)((FoundElement)element).getElement();
		browser.getTree().checkElement(refElem);
	}
	
	public List<FoundElement> findByName(String text){		
		List<FoundElement> result = new ArrayList<FoundElement>();
		OntoUMLParser refparser = Models.getRefparser();
		if(refparser!=null && text!=null /*&& !text.isEmpty()*/){
			for(EObject eobj: refparser.getAllInstances(EObject.class)){
				if (eobj instanceof NamedElement){
					String name = ((NamedElement)eobj).getName();
					if(name!=null){
						if(text.trim().isEmpty()) result.add(new FoundElement(eobj));
						else {
							if(name.trim().toLowerCase().compareToIgnoreCase(text)==0) result.add(new FoundElement(eobj));
							else if(name.trim().toLowerCase().contains(text.toLowerCase().trim())) result.add(new FoundElement(eobj));
						}
						
					}
				}
			}
		}		
		return result;
	}
}
