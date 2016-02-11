package net.menthor.editor.v2.commanders;

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

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.commands.AddNodeCommand;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlConnection;
import org.tinyuml.umldraw.shared.UmlNode;

import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.ui.manager.TabUIManager;

public class DuplicateCommander {

	// -------- Lazy Initialization

	private static class DuplicateLoader {
        private static final DuplicateCommander INSTANCE = new DuplicateCommander();
    }	
	public static DuplicateCommander get() { 
		return DuplicateLoader.INSTANCE; 
	}	
    private DuplicateCommander() {
        if (DuplicateLoader.INSTANCE != null) throw new IllegalStateException("DuplicateCommander already instantiated");
    }		
    
    // ----------------------------
	
	public HashMap<UmlNode, UmlNode> duplicateMap = new HashMap<UmlNode, UmlNode>();
	
	@SuppressWarnings("unchecked")
	public void duplicate(Object obj){
		duplicateMap.clear();
		if(obj instanceof List<?>) duplicate((List<DiagramElement>)obj);
		if(obj instanceof UmlNode) duplicateNode((UmlNode)obj);
	}
	
	public List<DiagramElement> duplicate(List<DiagramElement> diagramElements){		
		List<DiagramElement> newOnes = new ArrayList<DiagramElement>();
		newOnes.addAll(duplicateNodes(diagramElements));
		newOnes.addAll(duplicateConnections(diagramElements));
		return newOnes;
	}
	
	public List<UmlConnection> duplicateConnections(List<DiagramElement> diagramElements){
		List<UmlConnection> newOnes = new ArrayList<UmlConnection>();
		for(DiagramElement ce: diagramElements){
			if(ce instanceof UmlConnection) {
				UmlConnection duplicate = duplicateConnection((UmlConnection)ce);				
				newOnes.add(duplicate);
			}
		}
		return newOnes;
	}
	
	public UmlConnection duplicateConnection(UmlConnection conn){
//		DiagramEditor editor = diagramManager.getDiagramEditor((StructureDiagram)conn.getDiagram());
//		UmlNode node1 = duplicateMap.get(conn.getNode1());
//		UmlNode node2 = duplicateMap.get(conn.getNode2());
//		UmlConnection newConn = (UmlConnection)conn.clone();
		
		//change newConn ends
		/*OntoUMLParser.setSourceType(newConn.getRelationship(), (Classifier)node1.getClassifier());
		OntoUMLParser.setTargetType(newConn.getRelationship(), (Classifier)node2.getClassifier());
		newConn.setNode1(node1);
		newConn.setNode2(node2);		
		OccurenceManager.get().add(newConn.getRelationship(),newConn);						
		AddConnectionCommand cmd = new AddConnectionCommand(editor, conn.getDiagram(), newConn.getRelationship(), (Classifier)node1.getClassifier(), (Classifier)node2.getClassifier(), (RefOntoUML.Element)conn.getRelationship().eContainer());		
		cmd.run(); */
		
//		return newConn;
		return null;
	}
	
	public List<UmlNode> duplicateNodes(List<DiagramElement> diagramElements){
		List<UmlNode> newOnes = new ArrayList<UmlNode>();
		for(DiagramElement ce: diagramElements){
			if(ce instanceof UmlNode) {
				UmlNode duplicate = duplicateNode((UmlNode)ce);
				duplicateMap.put((UmlNode)ce, duplicate);
				newOnes.add(duplicate);
			}
		}
		return newOnes;
	}
	
	public UmlNode duplicateNode(UmlNode classElement){		
		UmlNode newClass = (UmlNode)classElement.clone();
		OccurenceManager.get().add(newClass.getClassifier(),newClass);
		OntoumlEditor editor = TabUIManager.get().getDiagramEditor((StructureDiagram)classElement.getDiagram());
		double x = classElement.getAbsoluteX2()+15;
		double y = classElement.getAbsoluteY2()+15;
		AddNodeCommand cmd = new AddNodeCommand(editor,newClass, x, y);		
		cmd.run();		
		return newClass;
	}
}
