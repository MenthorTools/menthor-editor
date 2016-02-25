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
import org.tinyuml.draw.Node;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.OccurenceMap;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlNode;

import RefOntoUML.Classifier;
import RefOntoUML.Element;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.ui.operation.IDiagramOperation;
import net.menthor.editor.v2.ui.operation.model.AddModelOperation;

public class AddNodeOperation extends AddModelOperation implements IDiagramOperation {

	private static final long serialVersionUID = -3148409380703192555L;
	
	protected OntoumlEditor ontoumlEditor;
	protected StructureDiagram parent;
	protected DiagramElement diagramElement;
	protected double absx;
	protected double absy;	
	
	public AddNodeOperation(OntoumlEditor editor, UmlNode node, double x, double y){				
		super();
		ontoumlEditor = editor;		
		if(editor!=null) parent = editor.getDiagram();
		absx = x;
		absy = y;
		diagramElement = node;		
		if(diagramElement==null) diagramElement = OccurenceMap.get().getDiagramElement(element, parent);		
		if(diagramElement==null){			
			if(parent!=null) this.diagramElement = FactoryManager.get().createNode((RefOntoUML.Type)element, parent);
			else this.diagramElement = FactoryManager.get().createNode((RefOntoUML.Type)element, eContainer);					
		}		
		element = (RefOntoUML.Element)diagramElement.getModelObject();
		eContainer = (RefOntoUML.Element)element.eContainer();		
	}

	public OntoumlEditor getOntoumlEditor(){ return ontoumlEditor; }
	
	@Override
	public void undo(){		
		super.undoWithoutNotifying();
	
		parent.removeChild(diagramElement);		
		OccurenceMap.get().remove(diagramElement);		
		
		notifier.notifyChange(this, (Element)diagramElement.getModelObject());		
	}

	public void run(){			
		super.runWithoutNotifying();					
		
		parent.addChild(diagramElement);		
		if(diagramElement instanceof Node){			
			((Node)diagramElement).setAbsolutePos(absx, absy);
			showAttributesCompartment();
		}				
		
		notifier.notifyChange(this, (Element)diagramElement.getModelObject());		
	}	
		
	@Override
	public String undoMessage(){
		return super.undoMessage()+" and "+parent.toString();		
	}
		
	@Override
	public String runMessage(){
		return super.runMessage()+" and "+parent.toString();
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
