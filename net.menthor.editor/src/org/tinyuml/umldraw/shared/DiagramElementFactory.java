package org.tinyuml.umldraw.shared;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.LineConnectMethod;
import org.tinyuml.umldraw.StructureDiagram;

import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;


/**
 * DiagramElements should be created by invoking methods on this factory
 * interface.
 * 
 * @author Wei-ju Wu, John Guerson
 */
public interface DiagramElementFactory {

  //void setDiagram(StructureDiagram diagram);
	
  /**
   * Creates a node according to the specified UML element type.
   * @param elementType the UML model element type
   * @return the UMLNode for the element type
   */
  UmlNode createNode(ClassType elementType, StructureDiagram diagram);
  UmlNode createNode(DataType elementType, StructureDiagram diagram);
    
  UmlNode createNode(RefOntoUML.Type type, EObject eContainer, StructureDiagram diagram);
  
  /**
   * Creates a connection between the two given nodes using the specified
   * relation type.
   * @param relationType the relation type
   * @param node1 the first node
   * @param node2 the second node
   * @return the created connection
   */
  UmlConnection createConnection(RelationshipType relationType, UmlNode node1, UmlNode node2);
  UmlConnection createConnection(RefOntoUML.Relationship relationship, UmlNode node1, UmlNode node2);
  
  UmlConnection createConnectionToCon(RelationshipType relationType, UmlNode node1, UmlConnection c2);
  UmlConnection createConnectionToCon(RefOntoUML.Relationship relationship, UmlNode node1, UmlConnection c2);
  
  UmlConnection createConnectionFromCon(RelationshipType relationType, UmlConnection c1, UmlNode node2);
  UmlConnection createConnectionFromCon(RefOntoUML.Relationship relationship, UmlConnection c1, UmlNode node2);
  
  UmlConnection createConnectionBetweenCon(RelationshipType relationType, UmlConnection c1, UmlConnection c2);
  UmlConnection createConnectionBetweenCon(RefOntoUML.Relationship relationship, UmlConnection c1, UmlConnection c2);
  
  /**
   * Asks the factory for the connect method of the specified RelationType.
   * @param relationType the RelationType
   * @return the LineConnectMethod
   */
  LineConnectMethod getConnectMethod(RelationshipType relationType);
}
