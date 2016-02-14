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

import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Generalization;
import net.menthor.editor.v2.ui.operation.IDiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;
import net.menthor.editor.v2.ui.operation.model.AddGeneralizationSetModelOperation;

public class AddGeneralizationSetOperation extends AddGeneralizationSetModelOperation implements IDiagramOperation {

	private static final long serialVersionUID = 2924451842640450250L;	
	
	protected OntoumlEditor ontoumlEditor;
	protected StructureDiagram parent;
	protected List<GeneralizationElement> diagramGeneralizations = new ArrayList<GeneralizationElement>();
	
	public AddGeneralizationSetOperation(OntoumlEditor editor, RefOntoUML.Element genSet, List<Generalization> generalizations, RefOntoUML.Element eContainer) {
		super();
		
		//there is no diagram element for generalization sets
		//therefore the operation type here is 'modify' because we only need to refresh
		//generalizations on diagrams
		this.operationType = OperationType.MODIFY;
		
		ontoumlEditor = editor;
		if(ontoumlEditor!=null) this.parent = editor.getDiagram();		
		this.element = genSet;
		this.eContainer=eContainer;				
		this.gens.addAll(generalizations);		
		if(generalizations!=null && parent!=null){			
			diagramGeneralizations.addAll(parent.getGeneralizations(gens));
		}
	}
	
	@Override
	public OntoumlEditor getOntoumlEditor() { return ontoumlEditor; }
	
	@Override
	public void undo(){
		super.undoWithoutNotifying();
		
		List<DiagramElement> list = new ArrayList<>();
		list.addAll(diagramGeneralizations);
		
		notifier.notifyViewChange(this, actionType, list);
	}
			
	@Override
	public String undoMessage(){
		return super.undoMessage().replace(eContainer.toString(), parent.toString()+" and "+eContainer.toString());		
	}
		
	@Override
	public String runMessage(){
		return super.runMessage().replace(eContainer.toString(), parent.toString()+" and "+eContainer.toString());
	}	
	
	@Override
	public void run() {		
		super.runWithoutNotifying();
		
		List<DiagramElement> list = new ArrayList<DiagramElement>();						
		list.addAll(diagramGeneralizations);		
		
		notifier.notifyViewChange(this, actionType,list);			
	}
}
