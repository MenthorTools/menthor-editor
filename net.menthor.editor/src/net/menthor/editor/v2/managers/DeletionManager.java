package net.menthor.editor.v2.managers;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.jface.window.Window;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.DeleteElementCommand;
import org.tinyuml.ui.diagram.commands.DeleteGeneralizationSetCommand;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.Element;
import RefOntoUML.GeneralizationSet;
import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.ModelHelper;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.ProjectBrowser;
import net.menthor.editor.v2.OclDocument;

public class DeletionManager {
	
	public static ProjectBrowser browser;
	public static DiagramManager diagramManager;
	
	public static void setup(DiagramManager mg, ProjectBrowser pb){
		browser = pb;
		diagramManager = mg;
	}
	
	public static int confirmElementDeletion(Component parentWindow){
		return JOptionPane.showConfirmDialog(parentWindow, 
			"WARNING - Are you sure you want to delete the selected items from the model \n"
			+ "and from all the diagrams they might appear?", 
			"Deletion Manager", 
			JOptionPane.OK_CANCEL_OPTION, 
			JOptionPane.WARNING_MESSAGE, 
			null
		);
	}
	
	public static int confirmDiagramDeletion(Component parentWindow){
		return JOptionPane.showConfirmDialog(parentWindow, 
			"Are you sure that you want to delete this diagram?\nThis action CANNOT be undone.", 
			"Deletion Manager", 
			JOptionPane.OK_CANCEL_OPTION, 
			JOptionPane.WARNING_MESSAGE, 
			null
		);
	}
	
	public static int confirmOclDocDeletion(Component parentWindow){
		return JOptionPane.showConfirmDialog(parentWindow, 
			"Are you sure that you want to delete this document?\nThis action CANNOT be undone.", 
			"Deletion Manager", 
			JOptionPane.OK_CANCEL_OPTION, 
			JOptionPane.WARNING_MESSAGE, 
			null
		);
	}
	
	public static GeneralizationSet confirmGenSetDeletion(Component parentWindow, List<GeneralizationSet> genSets){
		return (GeneralizationSet) JOptionPane.showInputDialog(parentWindow,
			"Which generalization set do you want to delete?",
			"Deleting Generalization Set",
			JOptionPane.QUESTION_MESSAGE, 
			null, 
			genSets.toArray(), 
			genSets.toArray()[0]);
	}
	
	/** Delete any elements from the application, whether diagrams, documents, elements or from diagrma selection */
	public void delete(List<Object> elements){
		for(Object o: elements){
			DeletionManager.delete(o);
		}
	}
	
	/** Delete any element from the application, whether a diagram, document, element or from selection. */
	public static void delete(Object elem){	
		if (elem instanceof StructureDiagram){
			DeletionManager.deleteDiagram((StructureDiagram)elem, true);    					
		} 
		else if (elem instanceof OclDocument){
			DeletionManager.deleteOclDocument((OclDocument)elem, true);    					
		}
		else if (elem instanceof RefOntoUML.Element){				
			DeletionManager.deleteElement((RefOntoUML.Element)elem,true);    					    					
		} else{ 
			diagramManager.getCurrentDiagramEditor().deleteSelection(elem);
		}
	}
	
	/** Delete Ocl document from the browser, tab pane and application */
	public static void deleteOclDocument(OclDocument doc, boolean showwarning){
		int response = Window.OK;
		if (showwarning) response = DeletionManager.confirmOclDocDeletion(diagramManager);		
		if(response==Window.OK) {
			Models.getOclDocList().remove(doc);
			diagramManager.removeOclDocTab(doc);		
			browser.getTree().removeCurrentNode();
		}
	}
	
	public static void deleteDiagram(StructureDiagram diagram, boolean showwarning){
		int response = Window.OK;
		if (showwarning) response = DeletionManager.confirmDiagramDeletion(diagramManager);		
		if(response==Window.OK){
			eraseAllElements(diagramManager, diagram);
			diagramManager.getCurrentProject().getDiagrams().remove(diagram);
			diagramManager.removeDiagramFromTab(diagram);
			browser.getTree().removeCurrentNode();
		}	
	}

	/** Delete element from the model and every diagram in each it appears. */
	public static void deleteElement(RefOntoUML.Element element, boolean showwarning){	
		int response = Window.OK;
		if(showwarning) response = confirmElementDeletion(diagramManager);		
		if(response==Window.OK) {		
			List<RefOntoUML.Element> list = new ArrayList<RefOntoUML.Element>();
			list.add(element);
			deleteElements(list);
		}
	}
	
	/** Delete elements from the model and from every diagram they might appear. 
	 *  It shows a message before deletion. */
	public static void deleteElements(Collection<DiagramElement> diagramElements, boolean showmessage){	
		List<RefOntoUML.Element> list = (List<Element>) ModelHelper.getElements(diagramElements);
		int response = Window.OK;
		if(showmessage) response = confirmElementDeletion(diagramManager);
		if(response==Window.OK) deleteElements(list);		
	}
	
	/** Delete element from the model and from every diagram they might appear. **/
	public static void deleteElements(List<RefOntoUML.Element> elements){
		List<DiagramEditor> editors = diagramManager.getDiagramEditors(elements.get(0));		
		for(DiagramEditor ed: editors){
			if(elements.size()==1 && elements.get(0) instanceof GeneralizationSet){
				new DeleteGeneralizationSetCommand(ed, elements.get(0), diagramManager.getCurrentProject()).run();
			}else{
				new DeleteElementCommand(ed, elements, diagramManager.getCurrentProject(),true, true).run();
			}
		}
		if(editors==null || editors.size()==0) {
			if(elements.size()==1 && elements.get(0) instanceof GeneralizationSet){
				new DeleteGeneralizationSetCommand(null, elements.get(0), diagramManager.getCurrentProject()).run();
			}else{
				new DeleteElementCommand(null, elements, diagramManager.getCurrentProject(),true, false).run();
			}
		}
	}
	
	/** Erase element from a particular diagram. It does not delete the element from the model. */
	public static void eraseElement(DiagramEditor ed, RefOntoUML.Element element){		
		if(element instanceof GeneralizationSet) return;
		if(element instanceof Constraintx) return;
		if(element instanceof Comment) return;
		List<RefOntoUML.Element> list = new ArrayList<RefOntoUML.Element>();
		list.add(element);
		new DeleteElementCommand(ed,list, ed.getProject(),false,true).run();				
	}
	
	/** Delete all elements at the diagram */
	public static void eraseAllElements(DiagramManager manager, StructureDiagram diagram){
		DiagramEditor ed = manager.getDiagramEditor(diagram);
		for(DiagramElement delem: diagram.getChildren()) {
			if(delem instanceof ClassElement) DeletionManager.eraseElement(ed,((ClassElement)delem).getClassifier());
			if(delem instanceof AssociationElement) DeletionManager.eraseElement(ed,((AssociationElement)delem).getRelationship());
			if(delem instanceof GeneralizationElement) DeletionManager.eraseElement(ed,((GeneralizationElement)delem).getRelationship());
		}
	}
	
	/** Delete a generalization set from a list of selected diagram elements */
	public static void deleteGeneralizationSet(DiagramEditor d, List<DiagramElement> selectedElements){	
		List<GeneralizationSet> genSets = diagramManager.getGeneralizationSets(selectedElements);
		if(genSets.size()==0) return;
		if(genSets.size()==1){
			DeletionManager.deleteElement(genSets.get(0),true);
		}else{
			GeneralizationSet chosen = confirmGenSetDeletion(diagramManager, genSets);
			if(chosen!=null) DeletionManager.deleteElement(chosen,true);
		}			
	}
}
