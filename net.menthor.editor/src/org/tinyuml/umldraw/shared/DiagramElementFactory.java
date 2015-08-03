package org.tinyuml.umldraw.shared;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.LineConnectMethod;
import org.tinyuml.umldraw.StructureDiagram;

/**
 * Copyright 2007 Wei-ju Wu
 *
 * This file is part of TinyUML.
 *
 * TinyUML is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * TinyUML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TinyUML; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

import net.menthor.editor.model.ElementType;
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
  UmlNode createNode(ElementType elementType, StructureDiagram diagram);
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
