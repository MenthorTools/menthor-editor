package net.menthor.editor.v2.commanders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.OccurenceMap;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Classifier;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.ui.controller.BrowserUIController;
import net.menthor.editor.v2.ui.controller.MessageUIController;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.editor.v2.ui.controller.TabbedAreaUIController;
import net.menthor.editor.v2.ui.operation.diagram.DeleteOperation;
import net.menthor.editor.v2.ui.operation.model.DeleteModelOperation;

public class DeleteCommander extends GenericCommander {
		
	// -------- Lazy Initialization
	
	private static class DeletionLoader {
        private static final DeleteCommander INSTANCE = new DeleteCommander();
    }	
	public static DeleteCommander get() { 
		return DeletionLoader.INSTANCE; 
	}	
    private DeleteCommander() {
        if (DeletionLoader.INSTANCE != null) throw new IllegalStateException("DeletionCommander already instantiated");
    }		
    
    // ----------------------------
	
    public boolean confirmDeleteFromDiagram(){    	
		return MessageUIController.get().confirm("Delete from Diagram",
			"WARNING - Are you sure you want to delete the selected items from the diagram?\n"
					+ "They will remain available in the project browser?");
	}
    
	public boolean confirmElementDeletion(){
		return MessageUIController.get().confirm("Delete from Model",
			"WARNING - Are you sure you want to delete the selected items from the model \n"
					+ "and from all the diagrams they might appear?");
	}
	
	public boolean confirmDiagramDeletion(){
		return MessageUIController.get().confirm("Delete Diagram", 
			"WARNING - Are you sure you want to delete this diagram?\nThis action CANNOT be undone.");
	}
	
	public boolean confirmOclDocDeletion(){
		return MessageUIController.get().confirm("Delete Ocl Document", 
			"WARNING - Are you sure you want to delete this document?\nThis action CANNOT be undone.");
	}
	
	public GeneralizationSet confirmGenSetDeletion(List<GeneralizationSet> genSets){
		return (GeneralizationSet) MessageUIController.get().input(			
			"Delete Generalization Set",
			"Which generalization set do you want to delete?",			 
			genSets.toArray(), 
			genSets.toArray()[0]
		);
	}
	
	/** Delete any element from the application, whether a diagram, document, element or from selection. */
	public void delete(Object input){
		Object elem = input;		
		if(input instanceof DefaultMutableTreeNode){
			elem = ((DefaultMutableTreeNode) elem).getUserObject();
		}
		
		if (elem instanceof StructureDiagram){
			deleteDiagram((StructureDiagram)elem, true);    					
		} 
		else if (elem instanceof OclDocument){
			deleteOclDocument((OclDocument)elem, true);    					
		}
		else if (elem instanceof Element){
			deleteElement((Element) elem, true);
		}
		//if method is called from diagram
		else{
			List<DiagramElement> elements = setUpAsList(input, DiagramElement.class);
			deleteElements(elements, true);
		}
	}
	
	/** Delete Ocl document from the browser, tab pane and application */
	public void deleteOclDocument(OclDocument doc, boolean showwarning){
		boolean response = true;
		if (showwarning) {
			response = confirmOclDocDeletion();		
		}
		if(response) {
			ProjectUIController.get().getProject().getOclDocList().remove(doc);
			TabbedAreaUIController.get().remove(doc);		
			BrowserUIController.get().remove();
		}
	}
	
	public void deleteDiagram(StructureDiagram diagram, boolean showwarning){
		boolean response = true;
		if (showwarning) {
			response = confirmDiagramDeletion();		
		}
		if(response){
			deleteAllElementsFromDiagram(diagram);
			ProjectUIController.get().getProject().getDiagrams().remove(diagram);
			TabbedAreaUIController.get().remove(diagram);
			BrowserUIController.get().remove();
		}	
	}

	/** Delete element from the model and every diagram in each it appears. */
	public void deleteElement(RefOntoUML.Element element, boolean showwarning){	
		boolean response = true;
		if(showwarning) response = confirmElementDeletion();		
		if(response) {		
			List<RefOntoUML.Element> list = new ArrayList<RefOntoUML.Element>();
			list.add(element);
			deleteElements(list);
		}
	}
	
	/** Delete elements from the model and from every diagram they might appear. 
	 *  It shows a message before deletion. */
	public void deleteElements(List<DiagramElement> diagramElements, boolean showmessage){	
		if(diagramElements==null || diagramElements.size()==0)
			return;
		
		List<RefOntoUML.Element> list = (List<Element>) OccurenceMap.get().getElements(diagramElements);
		boolean response = true;
		if(showmessage) response = confirmElementDeletion();
		if(response) deleteElements(list);		
	}
	
	/** Delete element from the model and from every diagram they might appear. **/
	public void deleteElements(List<RefOntoUML.Element> elements){
		//TODO: I guess this is not right. Why get the editors from a single element?
		List<OntoumlEditor> editors = TabbedAreaUIController.get().getOntoumlEditors(elements.get(0));		
		if(editors==null || editors.size()==0) {			
			OntoUMLParser refparser = ProjectUIController.get().getProject().getRefParser();
			DeleteModelOperation cmd = new DeleteModelOperation(refparser, elements);
			cmd.run();			
			return;
		}
		for(OntoumlEditor ed: editors){			
			DeleteOperation cmd = new DeleteOperation(ed, elements, false);
			cmd.run();			

		}		
	}
	
	/** Deletes currently selected elements from the model and all diagrams they appear in */
	public void deleteCurrentSelection(){		
		deleteElements(SelectCommanderMode.get().getSelectedElements(),true);
	}
	
	/** Delete a generalization set from a list of selected diagram elements */
	public void deleteGeneralizationSet(OntoumlEditor d, List<DiagramElement> selectedElements){	
		List<GeneralizationSet> genSets = OccurenceMap.get().getGeneralizationSets(selectedElements);
		if(genSets.size()==0) return;
		if(genSets.size()==1){
			deleteElement(genSets.get(0),true);
		}else{
			GeneralizationSet chosen = confirmGenSetDeletion(genSets);
			if(chosen!=null) deleteElement(chosen,true);
		}			
	}

	
	
	// DELETE FROM DIAGRAM METHODS
	
	
	/** Erase elements from a particular diagram. It does not delete the element from the model. */
	public void deleteFromDiagram(OntoumlEditor editor, Object input){		
		List<DiagramElement> diagramElements = setUpAsList(input, DiagramElement.class);
		
		//Removes all diagrams in the input
		List<DiagramElement> diagrams = new ArrayList<DiagramElement>();
		for(DiagramElement de: diagramElements){
			if(de instanceof StructureDiagram){
				diagrams.add(de);
			}
		}
		diagramElements.removeAll(diagrams);
		
		//Removes all the elements in the input that are not contained by the diagram editor
		List<DiagramElement> elementsNotInTheCurrentEditor = new ArrayList<DiagramElement>();
		List<DiagramElement> containedByCurrentDiagram = editor.getDiagram().getChildren();
		for (DiagramElement de : diagramElements) {
			if(!containedByCurrentDiagram.contains(de)){
				elementsNotInTheCurrentEditor.add(de);
			}
		}
		diagramElements.removeAll(elementsNotInTheCurrentEditor);
		
		List<Element> modelElements = new ArrayList<Element>();
		for (DiagramElement de : diagramElements) {
			Object modelElement = de.getModelObject();
			if(modelElement instanceof Classifier || modelElement instanceof Generalization)
				modelElements.add((Element) modelElement);
		}
		
		new DeleteOperation(editor,modelElements,true).run();				
	}
	
	public void deleteFromDiagram(Object input){
		deleteFromDiagram(TabbedAreaUIController.get().getSelectedTopOntoumlEditor(),input);
	}
	
	/** Deletes currently selected elements from the current diagram */
	public void deleteCurrentSelectionFromDiagram(){
		OntoumlEditor editor = TabbedAreaUIController.get().getSelectedTopOntoumlEditor();
		deleteFromDiagram(editor, SelectCommanderMode.get().getSelectedElements());
	}
	
	/** Delete all elements at the diagram */
	public void deleteAllElementsFromDiagram(StructureDiagram diagram){
		OntoumlEditor ed = TabbedAreaUIController.get().getOntoumlEditor(diagram);
		deleteFromDiagram(ed,diagram.getChildren());
	}
	
	/** Delete generalization Set from selected elements in the diagram */
	public void deleteGeneralizationSet(){
		Collection<DiagramElement> diagramElementsList = SelectCommanderMode.get().getSelectedElements();
		deleteGeneralizationSet(diagramElementsList);
	}
	
	@SuppressWarnings("unchecked")
	public void deleteGeneralizationSet(Object genElems){
		if(genElems instanceof Collection<?>){
			deleteGeneralizationSet(currentEditor(),(List<DiagramElement>)genElems);		
		}
	}
	
}
