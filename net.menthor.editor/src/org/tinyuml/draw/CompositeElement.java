package org.tinyuml.draw;

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

/**
 * This interface defines a composite diagram element.
 * @author Wei-ju Wu
 */
public interface CompositeElement {

  /**
   * Adds the specified child to this element.
   * @param child the child to add
   */
  void addChild(DiagramElement child);

  /**
   * Removes the specified child from this element.
   * @param child the child to remove
   */
  void removeChild(DiagramElement child);

  /**
   * Returns the child element at the specified position. Returns a NullElement
   * if no element is at that coordinate.
   * @param x the x coordinate
   * @param y the y coordinate
   * @return the element at the coordinate or the NullElement
   */
  DiagramElement getChildAt(double x, double y);
}
