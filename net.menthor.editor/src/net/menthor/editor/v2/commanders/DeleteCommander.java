package net.menthor.editor.v2.commanders;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Classifier;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.app.manager.AppBrowserManager;
import net.menthor.editor.v2.ui.app.manager.AppMessageManager;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
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
		return AppMessageManager.get().confirm("Delete from Diagram",
			"WARNING - Are you sure you want to delete the selected items from the diagram?\n"
					+ "They will remain available in the project browser?");
	}
    
	public boolean confirmElementDeletion(){
		return AppMessageManager.get().confirm("Delete from Model",
			"WARNING - Are you sure you want to delete the selected items from the model \n"
					+ "and from all the diagrams they might appear?");
	}
	
	public boolean confirmDiagramDeletion(){
		return AppMessageManager.get().confirm("Delete Diagram", 
			"WARNING - Are you sure you want to delete this diagram?\nThis action CANNOT be undone.");
	}
	
	public boolean confirmOclDocDeletion(){
		return AppMessageManager.get().confirm("Delete Ocl Document", 
			"WARNING - Are you sure you want to delete this document?\nThis action CANNOT be undone.");
	}
	
	public GeneralizationSet confirmGenSetDeletion(List<GeneralizationSet> genSets){
		return (GeneralizationSet) AppMessageManager.get().input(			
			"Delete Generalization Set",
			"Which generalization set do you want to delete?",			 
			genSets.toArray(), 
			genSets.toArray()[0]
		);
	}
	
	/** Delete any elements from the application, whether diagrams, documents, elements or from diagrma selection */
	public void delete(List<Object> elements){
		for(Object o: elements){
			delete(o);
		}
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
		else if (elem instanceof RefOntoUML.Element){			
			deleteElement((RefOntoUML.Element)elem,true);    					    					
		}
	}
	
	/** Delete Ocl document from the browser, tab pane and application */
	public void deleteOclDocument(OclDocument doc, boolean showwarning){
		boolean response = true;
		if (showwarning) response = confirmOclDocDeletion();		
		if(response) {
			ProjectManager.get().getProject().getOclDocList().remove(doc);
			AppTabManager.get().removeEditor(doc);		
			AppBrowserManager.get().remove();
		}
	}
	
	public void deleteDiagram(StructureDiagram diagram, boolean showwarning){
		boolean response = true;
		if (showwarning) response = confirmDiagramDeletion();		
		if(response){
			eraseAllElements(diagram);
			ProjectManager.get().getProject().getDiagrams().remove(diagram);
			AppTabManager.get().removeEditor(diagram);
			AppBrowserManager.get().remove();
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
		List<RefOntoUML.Element> list = (List<Element>) OccurenceManager.get().getElements(diagramElements);
		boolean response = true;
		if(showmessage) response = confirmElementDeletion();
		if(response) deleteElements(list);		
	}
	
	/** Delete element from the model and from every diagram they might appear. **/
	public void deleteElements(List<RefOntoUML.Element> elements){		
		List<OntoumlEditor> editors = AppTabManager.get().getDiagramEditors(elements.get(0));		
		if(editors==null || editors.size()==0) {			
			DeleteModelOperation cmd = new DeleteModelOperation(elements);
			cmd.run();			
			return;
		}
		for(OntoumlEditor ed: editors){			
			DeleteOperation cmd = new DeleteOperation(ed, elements, false);
			cmd.run();			
		}		
	}
	
	/** Erase element from a particular diagram. It does not delete the element from the model. */
	public void eraseElement(OntoumlEditor editor, Object input){		
		
		List<DiagramElement> diagramElements = setUpList(input, DiagramElement.class);
		
		//no diagram in the list...
		List<DiagramElement> diagrams = new ArrayList<DiagramElement>();
		for(DiagramElement de: diagramElements){
			if(de instanceof StructureDiagram){
				diagrams.add(de);
			}
		}
		diagramElements.removeAll(diagrams);
		
		List<Element> modelElements = new ArrayList<Element>();
		for (DiagramElement de : diagramElements) {
			Object modelElement = de.getModelObject();
			if(modelElement instanceof Classifier || modelElement instanceof Generalization)
				modelElements.add((Element) modelElement);
		}
		
		new DeleteOperation(editor,modelElements,true).run();				
	}
	
	/** Delete all elements at the diagram */
	public void eraseAllElements(StructureDiagram diagram){
		OntoumlEditor ed = AppTabManager.get().getDiagramEditor(diagram);
		eraseElement(ed,diagram.getChildren());
	}
	
	/** Delete a generalization set from a list of selected diagram elements */
	public void deleteGeneralizationSet(OntoumlEditor d, List<DiagramElement> selectedElements){	
		List<GeneralizationSet> genSets = d.getGeneralizationSets(selectedElements);
		if(genSets.size()==0) return;
		if(genSets.size()==1){
			deleteElement(genSets.get(0),true);
		}else{
			GeneralizationSet chosen = confirmGenSetDeletion(genSets);
			if(chosen!=null) deleteElement(chosen,true);
		}			
	}
	
	//TODO: TEST THIS!
}
