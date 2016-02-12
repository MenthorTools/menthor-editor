package net.menthor.editor.v2.ui.notify.diagram;

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
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.edit.command.AddCommand;
import org.tinyuml.draw.CompositeElement;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.GeneralizationElement;

import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

/**
 * @author John Guerson
 */
public class AddGeneralizationSetCommand extends DiagramCommand {

	private static final long serialVersionUID = 2924451842640450250L;	
	@SuppressWarnings("unused")
	private CompositeElement parent;
	private RefOntoUML.Element genSet;
	private boolean addToDiagram;
	private RefOntoUML.Element eContainer;
	private ArrayList<DiagramElement> diagramGenList = new ArrayList<DiagramElement>();
	private ArrayList<Generalization> generalizations = new ArrayList<Generalization>();
	
	public AddGeneralizationSetCommand(OntoumlEditor editor, CompositeElement parent, RefOntoUML.Element genSet, Collection<Generalization> generalizations, RefOntoUML.Element eContainer) {
		this.parent = parent;		
		this.eContainer = eContainer;
		this.ontoumlEditor = editor;	
		if (ontoumlEditor==null) this.addToDiagram = false; else this.addToDiagram=true;		
		this.genSet = genSet;		
		this.generalizations .addAll(generalizations);
		if(generalizations!=null && ontoumlEditor!=null){			
			for(DiagramElement dElem: ontoumlEditor.getDiagram().getChildren()){
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
			UpdateCommander.get().updateFromDeletion(genSet);
		}
		
		if(addToDiagram && diagramGenList.size()>0){						
			for(DiagramElement genElem: diagramGenList){
				Generalization gen = (Generalization)((GeneralizationElement)genElem).getRelationship();
				UpdateCommander.get().updateFromChange(gen,false);
				list.add(genElem);
			}
		}		
		
		if(notifier!=null){		
			notifier.notify(this, diagramGenList, NotificationType.MODIFY, ActionType.UNDO);
		}
	}
	
	@Override
	public void run() {
		ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
		
		if(genSet!=null){
			addToModel(genSet, generalizations);
			UpdateCommander.get().updateFromAddition(genSet);			
		}
		
		if(addToDiagram && diagramGenList.size()>0){						
			for(DiagramElement genElem: diagramGenList){
				Generalization gen = (Generalization)((GeneralizationElement)genElem).getRelationship();
				UpdateCommander.get().updateFromChange(gen,false);
				list.add(genElem);
			}
		}		
		
		if (notifier!=null) {
			notifier.notify(this, (List<DiagramElement>) list, NotificationType.MODIFY, isRedo ? ActionType.REDO : ActionType.DO);			
		}
		
	}
	
	public void undoFromModel(RefOntoUML.Element genSet,  ArrayList<Generalization> generalizations)
	{
//		System.out.println("Undoing = "+genSet);
		RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().undo();
		
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
		
		AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ((RefOntoUML.Package)eContainer).getPackagedElement(), genSet);
		RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
	}

}
