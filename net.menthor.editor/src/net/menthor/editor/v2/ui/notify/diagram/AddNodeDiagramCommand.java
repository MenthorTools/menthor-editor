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

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.Node;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlNode;

import RefOntoUML.Classifier;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.IDiagramCommand;
import net.menthor.editor.v2.ui.notify.model.AddElementModelCommand;

public class AddNodeDiagramCommand extends AddElementModelCommand implements IDiagramCommand {

	private static final long serialVersionUID = -3148409380703192555L;
	
	protected OntoumlEditor ontoumlEditor;
	
	protected StructureDiagram parent;
	protected DiagramElement diagramElement;
	protected double absx;
	protected double absy;	
	
	public OntoumlEditor getOntoumlEditor(){
		return ontoumlEditor;
	}
	
	public AddNodeDiagramCommand(OntoumlEditor editor, UmlNode node, double x, double y){				
		super();
		ontoumlEditor = editor;		
		if(editor!=null) parent = editor.getDiagram();
		absx = x;
		absy = y;
		diagramElement = node;		
		if(diagramElement==null) diagramElement = OccurenceManager.get().getDiagramElement(element, parent);		
		if(diagramElement==null){			
			if(parent!=null) this.diagramElement = FactoryManager.get().createNode((RefOntoUML.Type)element, parent);
			else this.diagramElement = FactoryManager.get().createNode((RefOntoUML.Type)element, eContainer);					
		}		
		element = (RefOntoUML.Element)diagramElement.getModelObject();
		eContainer = (RefOntoUML.Element)element.eContainer();
	}

	@Override
	public void undo(){		
		super.undo();
		parent.removeChild(diagramElement);			
		OccurenceManager.get().remove(diagramElement);		
		notifier.notify(this, diagramElement, ActionType.UNDO);		
	}

	public void run(){				
		super.runWithoutNotifying();					
		addToDiagram();				
		notifier.notify(this, diagramElement, isRedo ? ActionType.REDO : ActionType.DO);		
	}	
	
	public void addToDiagram (){
		parent.addChild(diagramElement);
		if(diagramElement instanceof Node){			
			((Node)diagramElement).setAbsolutePos(absx, absy);
			showAttributesCompartment();
		}		
	}
	
	private void showAttributesCompartment(){
		Classifier c = ((ClassElement)diagramElement).getClassifier();
		if (c instanceof RefOntoUML.Class){
			if (((RefOntoUML.Class)c).getOwnedAttribute().size()>0){
				((ClassElement)diagramElement).setShowAttributes(true);
			}
		}
		if (c instanceof RefOntoUML.DataType){
			if (((RefOntoUML.DataType)c).getOwnedAttribute().size()>0){
				((ClassElement)diagramElement).setShowAttributes(true);
			}
		}
	}
	
}
