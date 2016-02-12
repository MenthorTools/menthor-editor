package net.menthor.editor.v2.ui.notify.model;

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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;

import RefOntoUML.Classifier;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.ModelCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

public class AddRelationshipModelCommand extends ModelCommand {

	private static final long serialVersionUID = 2583245849126236206L;

	protected RefOntoUML.Element relationship;
	protected Classifier source;
	protected Classifier target;
	protected EObject eContainer;	
	
	public AddRelationshipModelCommand(){
		super();
		this.notificationType = NotificationType.ADD;
	}
	
	public AddRelationshipModelCommand(RefOntoUML.Element relationship, Classifier aSource, Classifier aTarget, EObject eContainer){
		this();
		this.relationship = relationship;
		this.eContainer = eContainer;		
		if(aSource==null) source = OntoUMLParser.getSourceType(relationship);
		else source = aSource;		
		if(aTarget==null) target = OntoUMLParser.getTargetType(relationship);
		else target = aTarget;			
	}
	
	@Override
	public void undo(){
		super.undo();		
		undoWithoutNotifying();
		notifier.notify(this, relationship, ActionType.UNDO);
	}
	
	@Override
	public void run() {	    
		super.run();	
		runWithoutNotifying();
		notifier.notify(this, relationship, isRedo ? ActionType.REDO : ActionType.DO);
	}
	
	public void undoWithoutNotifying(){
		RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().undo();
		System.out.println("[undo add] - Model - "+relationship);
	}
	
	public void runWithoutNotifying(){		
		OntoUMLParser.setSourceType(relationship, source);
		OntoUMLParser.setTargetType(relationship, target);		
		AdapterFactoryEditingDomain domain = RefOntoUMLEditingDomain.getInstance().createDomain();
		RefOntoUML.Package model = ProjectManager.get().getProject().getModel();
		AddCommand emfCommand = null;					
		if(relationship instanceof RefOntoUML.Generalization) {
			emfCommand = new AddCommand(domain, ((Classifier)eContainer).getGeneralization(), relationship);
		}
		if(relationship instanceof RefOntoUML.Association){
			if(eContainer==null) emfCommand = new AddCommand(domain, model.getPackagedElement(), relationship);
			else emfCommand = new AddCommand(domain, ((RefOntoUML.Package)eContainer).getPackagedElement(), relationship);			
		}	
		System.out.println("[add] - Model - "+relationship);
		if(emfCommand!=null)RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(emfCommand);
	}
}
