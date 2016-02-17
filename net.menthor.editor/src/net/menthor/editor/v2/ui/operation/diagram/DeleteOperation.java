package net.menthor.editor.v2.ui.operation.diagram;

import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.CompositeNode;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Element;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
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
		super(ProjectManager.get().getProject().getRefParser(),theElements);
		this.ontoumlEditor = editor;	
		this.onlyFromDiagram = onlyFromDiagram;
		if(ontoumlEditor!=null) parent = ontoumlEditor.getDiagram();
		if(parent!=null){
			requestedDiagramElementList.addAll(OccurenceManager.get().getDiagramElements(getChain().getRequested(), parent));
			directConnectionsList.addAll(OccurenceManager.get().getDiagramElements(getChain().getDirectRelationshipDependencies(), parent));		
			indirectConnectionsList.addAll(OccurenceManager.get().getDiagramElements(getChain().getIndirectRelationshipDependencies(), parent));
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
		notifier.notifyChange(this, actionType, getAllElements());				
	}
	
	@Override
	public void undo(){		
		if(!onlyFromDiagram) {
			super.undoWithoutNotifying();		
		}
		undoDiagramElements(requestedParentRelations);		
		undoDiagramElements(directParentRelations);		
		undoDiagramElements(indirectParentRelations);
		notifier.notifyChange(this,actionType, getAllElements());
	}
	
	private void removeDiagramElements(List<DiagramElement> diagramElemList){
		for (DiagramElement element : diagramElemList){
			System.out.println(runMessage(element));
			element.getParent().removeChild(element);
			element.getParent().invalidate();
			OccurenceManager.get().remove(element);
		}		
	}
	
	private void undoDiagramElements(List<ParentChildRelation> parentChildList){
		for (ParentChildRelation relation : parentChildList){
			System.out.println(undoMessage(relation.element));
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
	
	@Override
	public String undoMessage(){		
		if(!onlyFromDiagram) return super.undoMessage()+" and "+parent.toString();
		else {
			String msg = super.undoMessage();			
			return msg.substring(0, msg.indexOf("from"))+"from "+parent.toString();
		}
	}
	
	@Override
	public String runMessage(){		
		if(!onlyFromDiagram) return super.runMessage()+" and "+parent.toString();
		else{
			String msg = super.runMessage();
			return msg.substring(0, msg.indexOf("from"))+"from "+parent.toString();
		}		
	}	
	
	private String undoMessage(DiagramElement element){				
		String msg = super.undoMessage();
		return msg.substring(0, msg.indexOf("from"))+"from "+element.getParent().toString();	
	}
	
	private String runMessage(DiagramElement element){				
		String msg = super.runMessage();
		return msg.substring(0, msg.indexOf("from"))+"from "+element.getParent().toString();		
	}
	
	
}
