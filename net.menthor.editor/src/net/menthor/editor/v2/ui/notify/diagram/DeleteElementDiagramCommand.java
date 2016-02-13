package net.menthor.editor.v2.ui.notify.diagram;

import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.CompositeNode;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Element;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.IDiagramCommand;
import net.menthor.editor.v2.ui.notify.model.DeleteElementModelCommand;

public class DeleteElementDiagramCommand extends DeleteElementModelCommand implements IDiagramCommand {

	private static final long serialVersionUID = 2456036038567915529L;	
	
	protected OntoumlEditor ontoumlEditor;
	protected StructureDiagram parent;
	protected boolean onlyFromDiagram;
	
	private List<DiagramElement> requestedDiagramElementList = new ArrayList<DiagramElement>();
	private List<DiagramElement> directConnectionsList = new ArrayList<DiagramElement>(); 
	private List<DiagramElement> indirectConnectionsList = new ArrayList<DiagramElement>();	
	private List<ParentChildRelation> requestedParentRelations = new ArrayList<ParentChildRelation>();
	private List<ParentChildRelation> directParentRelations = new ArrayList<ParentChildRelation>(); 
	private List<ParentChildRelation> indirectParentRelations = new ArrayList<ParentChildRelation>();
		
	@Override
	public OntoumlEditor getOntoumlEditor() {
		return ontoumlEditor;
	}
	
	public List<DiagramElement> getAllDiagramElements(){
		List<DiagramElement> list = new ArrayList<DiagramElement>();
		list.addAll(requestedDiagramElementList);
		list.addAll(directConnectionsList);
		list.addAll(indirectConnectionsList);
		return list;
	}
	
	/** A helper class to store the original parent child relation. */
	private static class ParentChildRelation {
		DiagramElement element;
		@SuppressWarnings("unused")
		CompositeNode parent;		
		public ParentChildRelation(DiagramElement anElement, CompositeNode aParent){
			parent = aParent;
			element = anElement;
		}
	}

	public DeleteElementDiagramCommand(OntoumlEditor editor, List<Element> theElements, boolean onlyFromDiagram)	{
		super(theElements);
		this.ontoumlEditor = editor;	
		this.onlyFromDiagram = onlyFromDiagram;
		if(ontoumlEditor!=null) parent = ontoumlEditor.getDiagram();
		if(parent!=null){
			requestedDiagramElementList.addAll(OccurenceManager.get().getDiagramElements(requestedList, parent));
			directConnectionsList.addAll(OccurenceManager.get().getDiagramElements(directRelationshipsList, parent));		
			indirectConnectionsList.addAll(OccurenceManager.get().getDiagramElements(indirectRelationshipsList, parent));
		}		
		for (DiagramElement elem : requestedDiagramElementList){
			requestedParentRelations.add(new ParentChildRelation(elem, elem.getParent()));
		}
		for(DiagramElement elem: directConnectionsList){
			directParentRelations.add(new ParentChildRelation(elem, elem.getParent()));
		}
		for(DiagramElement elem: indirectConnectionsList){
			indirectParentRelations.add(new ParentChildRelation(elem, elem.getParent()));
		}		
	}

	@Override
	public void run(){
		runWithoutNotifying();
		notifier.notifyChangeOnView(this, isRedo ? ActionType.REDO : ActionType.DO,getAllDiagramElements());		
	}

	protected void runWithoutNotifying(){
		if(!onlyFromDiagram) super.runWithoutNotifying();
		delete(indirectConnectionsList);
		delete(directConnectionsList);		
		delete(requestedDiagramElementList);
	}
	
	private void delete(List<DiagramElement> diagramElemList){
		for (DiagramElement element : diagramElemList){
			System.out.println("[delete] - "+parent.getName()+" - "+element);
			element.getParent().removeChild(element);
			element.getParent().invalidate();		
			OccurenceManager.get().remove(element);
		}		
	}
	
	@Override
	public void undo(){		
		undoWithoutNotifying();
		notifier.notifyChangeOnView(this,ActionType.UNDO,getAllDiagramElements());		
	}
	
	protected void undoWithoutNotifying(){
		if(!onlyFromDiagram) super.undoWithoutNotifying();		
		undo(requestedParentRelations);		
		undo(directParentRelations);		
		undo(indirectParentRelations);
	}
	
	private void undo(List<ParentChildRelation> parentChildList){
		for (ParentChildRelation relation : parentChildList){
			System.out.println("[undo delete] - "+parent.getName()+" - "+relation.element);
			parent.addChild(relation.element);
			parent.invalidate();
			OccurenceManager.get().add((Element)relation.element.getModelObject(),relation.element);
		}
	}
}
