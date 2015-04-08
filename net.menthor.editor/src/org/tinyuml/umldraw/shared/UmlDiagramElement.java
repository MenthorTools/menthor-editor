package org.tinyuml.umldraw.shared;

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
import org.tinyuml.draw.DiagramElement;

import RefOntoUML.NamedElement;


/**
 * An interface to specialize on DiagramElement. It exposes the UML model
 * element and declares it specifically for use as a main element in UML
 * diagrams.
 * 
 * @author Wei-ju Wu
 */

public interface UmlDiagramElement extends DiagramElement {
  /**
   * Returns the model Element that belongs to this DiagramElement.
   * @return the model element
   */
  NamedElement getClassifier();
}
