/**
 * Copyright(C) 2011-2014 by John Guerson, Tiago Prince, Antognoni Albuquerque
 *
 * This file is part of OLED (OntoUML Lightweight BaseEditor).
 * OLED is based on TinyUML and so is distributed under the same
 * license terms.
 *
 * OLED is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * OLED is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OLED; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package net.menthor.editor.umldraw.structure;


import net.menthor.editor.draw.LineConnectMethod;
import net.menthor.editor.model.ElementType;
import net.menthor.editor.model.RelationType;
import net.menthor.editor.umldraw.shared.UmlConnection;
import net.menthor.editor.umldraw.shared.UmlNode;

import org.eclipse.emf.ecore.EObject;


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
  UmlConnection createConnection(RelationType relationType, UmlNode node1, UmlNode node2);
  UmlConnection createConnection(RefOntoUML.Relationship relationship, UmlNode node1, UmlNode node2);
  
  UmlConnection createConnectionToCon(RelationType relationType, UmlNode node1, UmlConnection c2);
  UmlConnection createConnectionToCon(RefOntoUML.Relationship relationship, UmlNode node1, UmlConnection c2);
  
  UmlConnection createConnectionFromCon(RelationType relationType, UmlConnection c1, UmlNode node2);
  UmlConnection createConnectionFromCon(RefOntoUML.Relationship relationship, UmlConnection c1, UmlNode node2);
  
  UmlConnection createConnectionBetweenCon(RelationType relationType, UmlConnection c1, UmlConnection c2);
  UmlConnection createConnectionBetweenCon(RefOntoUML.Relationship relationship, UmlConnection c1, UmlConnection c2);
  
  /**
   * Asks the factory for the connect method of the specified RelationType.
   * @param relationType the RelationType
   * @return the LineConnectMethod
   */
  LineConnectMethod getConnectMethod(RelationType relationType);
}
