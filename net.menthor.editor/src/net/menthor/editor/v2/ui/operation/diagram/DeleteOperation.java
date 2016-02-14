package net.menthor.editor.v2.ui.operation.diagram;

import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.CompositeNode;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Element;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.IDiagramOperation;
import net.menthor.editor.v2.ui.operation.model.DeleteModelOperation;

public class DeleteOperation extends DeleteModelOperation implements IDiagramOperation {

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
	
	public DeleteOperation(OntoumlEditor editor, List<Element> theElements, boolean onlyFromDiagram)	{
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
		if(!onlyFromDiagram) {
			super.runWithoutNotifying();
		}
		removeDiagramElements(indirectConnectionsList);
		removeDiagramElements(directConnectionsList);		
		removeDiagramElements(requestedDiagramElementList);
		notifier.notifyChange(this, isRedo ? ActionType.REDO : ActionType.DO, getAllElements());
	}
	
	@Override
	public void undo(){		
		if(!onlyFromDiagram) {
			super.undoWithoutNotifying();		
		}
		undoDiagramElements(requestedParentRelations);		
		undoDiagramElements(directParentRelations);		
		undoDiagramElements(indirectParentRelations);
		notifier.notifyChange(this,ActionType.UNDO, getAllElements());
	}
	
	private void removeDiagramElements(List<DiagramElement> diagramElemList){
		for (DiagramElement element : diagramElemList){
			System.out.println(runStatus(element));
			element.getParent().removeChild(element);
			element.getParent().invalidate();
			OccurenceManager.get().remove(element);
		}		
	}
	
	private void undoDiagramElements(List<ParentChildRelation> parentChildList){
		for (ParentChildRelation relation : parentChildList){
			System.out.println(undoStatus(relation.element));
			parent.addChild(relation.element);
			parent.invalidate();
			OccurenceManager.get().add((Element)relation.element.getModelObject(),relation.element);
		}
	}
	
	public List<DiagramElement> getAllDiagramElements(){
		List<DiagramElement> list = new ArrayList<DiagramElement>();
		list.addAll(requestedDiagramElementList);
		list.addAll(directConnectionsList);
		list.addAll(indirectConnectionsList);
		return list;
	}
	
	@Override
	public OntoumlEditor getOntoumlEditor() { return ontoumlEditor; }
	
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

	public boolean isOnlyFromDiagram(){ return onlyFromDiagram; }
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] "+ontoumlEditor.getDiagram()+": "+asString(getAllDiagramElements());
	}

	private String undoStatus(DiagramElement element){
		return "[undo "+operationType.presentTense()+"] "+ontoumlEditor.getDiagram()+": "+element;
	}
	
	public String runStatus(){
		return "["+operationType.pastTense()+"] "+ontoumlEditor.getDiagram()+": "+asString(getAllDiagramElements());
	}	
	private String runStatus(DiagramElement element){
		return "["+operationType.pastTense()+"] "+ontoumlEditor.getDiagram()+": "+element;
	}
	
	
}
