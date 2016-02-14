package net.menthor.editor.v2.ui.operation.diagram;

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

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlConnection;

import RefOntoUML.Element;
import RefOntoUML.Relationship;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.IDiagramOperation;
import net.menthor.editor.v2.ui.operation.model.AddModelOperation;

public class AddConnectionOperation extends AddModelOperation implements IDiagramOperation {

	private static final long serialVersionUID = 2924451842640450250L;	
	
	protected OntoumlEditor ontoumlEditor;	
	protected StructureDiagram parent;
	protected DiagramElement diagramElement;	
	
	public AddConnectionOperation(OntoumlEditor editor, UmlConnection conn){
		super();	
		ontoumlEditor = editor;
		if(ontoumlEditor!=null) parent = ontoumlEditor.getDiagram();
		diagramElement = conn;			
		if(diagramElement==null) diagramElement = OccurenceManager.get().getDiagramElement(element, parent);			
		if(diagramElement==null) diagramElement = OccurenceManager.get().getDiagramElement(element);
		element = (RefOntoUML.Element)diagramElement.getModelObject();		
		if(element!=null) {			 
			eContainer = (RefOntoUML.Element)element.eContainer();
		}				
	}
	
	public OntoumlEditor getOntoumlEditor(){ return ontoumlEditor; }
	
	@Override
	public void undo(){
		super.undo();					
		
		parent.removeChild(diagramElement);		
		OccurenceManager.get().remove(diagramElement);		
		
		System.out.println(undoStatus());
		notifier.notifyChange(this, ActionType.UNDO, (Element)diagramElement.getModelObject());			
	}

	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] "+parent.getName()+": "+diagramElement;
	}	
	public String runStatus(){
		return "["+operationType.pastTense()+"] "+parent.getName()+": "+diagramElement;
	}
	
	public void run() {	    
		super.runWithoutNotifying();
		
		parent.addChild(diagramElement);
		
		// small bug on drawing a derivation line. Not best solution, but it works...				
		Object source = OntoUMLParser.getSourceType(element); 
		Object target = OntoUMLParser.getTargetType(element);
		if (source instanceof Relationship || target instanceof Relationship)  {
			diagramElement.invalidate();
		}
		
		System.out.println(runStatus());
		notifier.notifyChange(this, isRedo ? ActionType.REDO : ActionType.DO, (Element)diagramElement.getModelObject());				
	}		
}

