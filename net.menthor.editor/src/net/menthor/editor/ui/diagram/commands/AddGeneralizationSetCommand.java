package net.menthor.editor.ui.diagram.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import net.menthor.editor.explorer.ProjectBrowser;
import net.menthor.editor.model.UmlProject;

import org.eclipse.emf.edit.command.AddCommand;
import org.tinyuml.draw.CompositeElement;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.BaseDiagramCommand;
import org.tinyuml.ui.diagram.commands.DiagramNotification;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;
import org.tinyuml.umldraw.GeneralizationElement;

import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;

/**
 * @author John Guerson
 */
public class AddGeneralizationSetCommand extends BaseDiagramCommand {

	private static final long serialVersionUID = 2924451842640450250L;	
	@SuppressWarnings("unused")
	private CompositeElement parent;
	private RefOntoUML.Element genSet;
	private boolean addToDiagram;
	private RefOntoUML.Element eContainer;
	private ArrayList<DiagramElement> diagramGenList = new ArrayList<DiagramElement>();
	private ArrayList<Generalization> generalizations = new ArrayList<Generalization>();
	
	public AddGeneralizationSetCommand(DiagramNotification editorNotification, CompositeElement parent, RefOntoUML.Element genSet, Collection<Generalization> generalizations, UmlProject project, RefOntoUML.Element eContainer) {
		this.parent = parent;
		this.project = project;
		this.eContainer = eContainer;
		this.notification = editorNotification;		
		if (notification==null) this.addToDiagram = false; else this.addToDiagram=true;		
		this.genSet = genSet;		
		this.generalizations .addAll(generalizations);
		if(generalizations!=null && notification!=null){			
			for(DiagramElement dElem: ((DiagramEditor)notification).getDiagram().getChildren()){
				if(dElem instanceof GeneralizationElement){
					GeneralizationElement genElem = (GeneralizationElement)dElem;
					if(generalizations.contains((Generalization)genElem.getRelationship())){ 
						diagramGenList.add(genElem);
					}
				}
			}
		}
	}
	
	@Override
	public void undo()
	{
		super.undo();
		
		ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
		
		if(genSet!=null){
			undoFromModel(genSet,generalizations);
			ProjectBrowser.frame.getDiagramManager().updateMenthorFromDeletion(genSet);
		}
		
		if(addToDiagram && diagramGenList.size()>0){						
			for(DiagramElement genElem: diagramGenList){
				Generalization gen = (Generalization)((GeneralizationElement)genElem).getRelationship();
				ProjectBrowser.frame.getDiagramManager().updateMenthorFromModification(gen,false);
				list.add(genElem);
			}
		}		
		
		if(notification!=null){		
			notification.notifyChange(diagramGenList, ChangeType.ELEMENTS_MODIFIED, NotificationType.UNDO);
		}
	}
	
	@Override
	public void redo() 
	{
		redo = true;
		super.redo();
		run();
	}

	@Override
	public void run() {
		ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
		
		if(genSet!=null){
			addToModel(genSet, generalizations);
			ProjectBrowser.frame.getDiagramManager().updateMenthorFromInclusion(genSet);			
		}
		
		if(addToDiagram && diagramGenList.size()>0){						
			for(DiagramElement genElem: diagramGenList){
				Generalization gen = (Generalization)((GeneralizationElement)genElem).getRelationship();
				ProjectBrowser.frame.getDiagramManager().updateMenthorFromModification(gen,false);
				list.add(genElem);
			}
		}		
		
		DiagramEditor d = ((DiagramEditor)notification);
		//notify
		if (d!=null) {
			d.notifyChange((List<DiagramElement>) list, ChangeType.ELEMENTS_MODIFIED, redo ? NotificationType.REDO : NotificationType.DO);			
			UndoableEditEvent event = new UndoableEditEvent(((DiagramEditor)d), this);
			for (UndoableEditListener l : ((DiagramEditor)d).editListeners)  l.undoableEditHappened(event);			
		}
		
	}
	
	public void undoFromModel(RefOntoUML.Element genSet,  ArrayList<Generalization> generalizations)
	{
//		System.out.println("Undoing = "+genSet);
		project.getEditingDomain().getCommandStack().undo();
		
		((GeneralizationSet)genSet).getGeneralization().removeAll(generalizations);
		for(Generalization gen: generalizations) {
			gen.getGeneralizationSet().remove((GeneralizationSet)genSet); 		
		}
	}
	
	public void addToModel(RefOntoUML.Element genSet,  ArrayList<Generalization> generalizations)
	{		
//		System.out.println("Adding = "+genSet);
		((GeneralizationSet)genSet).getGeneralization().addAll(generalizations);
		for(Generalization gen: generalizations) {
			gen.getGeneralizationSet().add((GeneralizationSet)genSet); 		
		}
		
		AddCommand cmd = new AddCommand(project.getEditingDomain(), ((RefOntoUML.Package)eContainer).getPackagedElement(), genSet);
		project.getEditingDomain().getCommandStack().execute(cmd);
	}

}
