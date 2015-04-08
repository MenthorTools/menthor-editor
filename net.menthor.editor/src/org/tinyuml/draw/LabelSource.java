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

import java.io.Serializable;

/**
 * Implements an interface that returns a text source for a Label object.
 * @author Wei-ju Wu
 */
public interface LabelSource extends Serializable {

  /**
   * Returns the text.
   * @return the label text
   */
  String getLabelText();

  /**
   * Sets the label text.
   * @param aText the label text
   */
  void setLabelText(String aText);
  
}
