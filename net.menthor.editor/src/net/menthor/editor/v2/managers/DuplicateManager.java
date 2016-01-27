package net.menthor.editor.v2.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.AddNodeCommand;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlConnection;
import org.tinyuml.umldraw.shared.UmlNode;

public class DuplicateManager extends BaseManager {

	private static DuplicateManager instance = new DuplicateManager();
	public static DuplicateManager get() { return instance; }
	
	public HashMap<UmlNode, UmlNode> classDuplicateMap = new HashMap<UmlNode, UmlNode>();
	
	@SuppressWarnings("unchecked")
	public void duplicate(Object obj){
		classDuplicateMap.clear();
		if(obj instanceof List<?>) duplicate((List<DiagramElement>)obj);
		if(obj instanceof ClassElement) duplicateNode((ClassElement)obj);
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
		DiagramEditor editor = diagramManager.getDiagramEditor((StructureDiagram)conn.getDiagram());
		UmlNode node1 = classDuplicateMap.get(conn.getNode1());
		UmlNode node2 = classDuplicateMap.get(conn.getNode2());
		UmlConnection newConn = (UmlConnection)conn.clone();
		
		//change newConn ends
		/*OntoUMLParser.setSourceType(newConn.getRelationship(), (Classifier)node1.getClassifier());
		OntoUMLParser.setTargetType(newConn.getRelationship(), (Classifier)node2.getClassifier());
		newConn.setNode1(node1);
		newConn.setNode2(node2);		
		OccurenceManager.get().add(newConn.getRelationship(),newConn);						
		AddConnectionCommand cmd = new AddConnectionCommand(editor, conn.getDiagram(), newConn.getRelationship(), (Classifier)node1.getClassifier(), (Classifier)node2.getClassifier(), (RefOntoUML.Element)conn.getRelationship().eContainer());		
		cmd.run(); */
		
		return newConn;
	}
	
	public List<UmlNode> duplicateNodes(List<DiagramElement> diagramElements){
		List<UmlNode> newOnes = new ArrayList<UmlNode>();
		for(DiagramElement ce: diagramElements){
			if(ce instanceof UmlNode) {
				UmlNode duplicate = duplicateNode((UmlNode)ce);
				classDuplicateMap.put((ClassElement)ce, duplicate);
				newOnes.add(duplicate);
			}
		}
		return newOnes;
	}
	
	public UmlNode duplicateNode(UmlNode classElement){		
		UmlNode newClass = (UmlNode)classElement.clone();
		OccurenceManager.get().add(newClass.getClassifier(),newClass);
		DiagramEditor editor = diagramManager.getDiagramEditor((StructureDiagram)classElement.getDiagram());
		double x = classElement.getAbsoluteX2()+15;
		double y = classElement.getAbsoluteY2()+15;
		AddNodeCommand cmd = new AddNodeCommand(editor,editor.getDiagram(),newClass.getClassifier(), 
		x, y, (RefOntoUML.Element)newClass.getClassifier().eContainer());		
		cmd.run();		
		return newClass;
	}
}
