package org.tinyuml.ui.diagram.commands;

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
import java.util.HashMap;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import org.eclipse.emf.edit.command.DeleteCommand;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;
import org.tinyuml.umldraw.GeneralizationElement;

import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import net.menthor.editor.v2.managers.UpdateManager;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;

/**
 * @author John Guerson
 */
public class DeleteGeneralizationSetCommand extends BaseDiagramCommand {

	private static final long serialVersionUID = 2924451842640450250L;	
	private RefOntoUML.Element genSet;
	private ArrayList<DiagramElement> diagramGenList = new ArrayList<DiagramElement>();
	private ArrayList<Generalization> generalizations = new ArrayList<Generalization>();
	
	public DeleteGeneralizationSetCommand(DiagramNotification editorNotification, RefOntoUML.Element genSet) {		
		this.notification = editorNotification;		
		this.genSet = genSet;		
		this.generalizations.addAll(((RefOntoUML.GeneralizationSet)genSet).getGeneralization());
		if(generalizations!=null && notification!=null){
			for(DiagramElement dElem: ((OntoumlEditor)notification).getDiagram().getChildren()){
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
			undoGeneralizationSet((RefOntoUML.GeneralizationSet)genSet);			
		}
		
		if(diagramGenList.size()>0){						
			for(DiagramElement genElem: diagramGenList){
				Generalization gen = (Generalization)((GeneralizationElement)genElem).getRelationship();
				UpdateManager.get().updateFromChange(gen,false);
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
			deleteGeneralizationSet((RefOntoUML.GeneralizationSet)genSet);						
		}
		
		if(diagramGenList.size()>0){						
			for(DiagramElement genElem: diagramGenList){
				Generalization gen = (Generalization)((GeneralizationElement)genElem).getRelationship();
				UpdateManager.get().updateFromChange(gen,false);
				list.add(genElem);
			}
		}		
		
		OntoumlEditor d = ((OntoumlEditor)notification);
		//notify
		if (d!=null) {
			d.notifyChange((List<DiagramElement>) list, ChangeType.ELEMENTS_MODIFIED, redo ? NotificationType.REDO : NotificationType.DO);			
			UndoableEditEvent event = new UndoableEditEvent(((OntoumlEditor)d), this);
			for (UndoableEditListener l : ((OntoumlEditor)d).editListeners)  l.undoableEditHappened(event);			
		}
		
	}
	
	
	// deleted generalization sets and its dependent generalizations
	private HashMap<Generalization, GeneralizationSet> decoupledGenSetMap = new HashMap<Generalization,GeneralizationSet>();
	
	private void deleteGeneralizationSet(GeneralizationSet elem)
	{
		//decouple generalization sets and its generalizations before deletion
		for(Generalization gen: ((GeneralizationSet)elem).getGeneralization())
		{				
			if(gen!=null) decoupledGenSetMap.put(gen,elem);			
		}			
		((GeneralizationSet)elem).getGeneralization().removeAll(decoupledGenSetMap.keySet());		
		for(Generalization gen: decoupledGenSetMap.keySet()) {
			gen.getGeneralizationSet().remove(elem);
			UpdateManager.get().updateFromChange(gen, false);
		}
		
		delete(elem);		
	}
	
	private void delete (RefOntoUML.Element elem)
	{			
//		System.out.println("Deleting = "+elem);
		DeleteCommand cmd = (DeleteCommand) DeleteCommand.create(RefOntoUMLEditingDomain.getInstance().createDomain(), elem);
		RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
		UpdateManager.get().updateFromDeletion(elem);
	}
	
	private void undoGeneralizationSet(GeneralizationSet elem)
	{
		undo(elem);
		
		//couple generalization set and its generalizations again
		((GeneralizationSet)elem).getGeneralization().addAll(decoupledGenSetMap.keySet());		
		for(Generalization gen: decoupledGenSetMap.keySet()) {
			gen.getGeneralizationSet().add(elem);
			UpdateManager.get().updateFromChange(gen, false);
		}
	}
	
	private void undo (RefOntoUML.Element elem)
	{		
//		System.out.println("Undoing = "+elem);
		RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().undo();
		UpdateManager.get().updateFromAddition(elem);
	}
}