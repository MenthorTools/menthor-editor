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
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.Selection;


/**
 * This class wraps a ConnectionSelection. We need this in order to properly
 * remove selections which are implemented as decorators.
 *
 * @author Wei-ju Wu
 */
public class UmlConnectionSelection implements Selection {

  private Selection selection;
  private UmlConnection connection;

  /**
   * Constructor.
   * @param conn the connection
   * @param wrappedSelection the wrapped selection
   */
  public UmlConnectionSelection(UmlConnection conn,
    Selection wrappedSelection) {
    selection = wrappedSelection;
    connection = conn;
  }

  /**
   * For testing only.
   */
  //public UmlConnectionSelection() { }

  /**
   * {@inheritDoc}
   */
  public DiagramElement getElement() {
    return connection;
  }

  /**
   * {@inheritDoc}
   */
  public List<DiagramElement> getElements() {
    List<DiagramElement> result = new ArrayList<DiagramElement>();
    result.add(connection);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isDragging() { return selection.isDragging(); }

  /**
   * {@inheritDoc}
   */
  public void startDragging(double xcoord, double ycoord) {
    selection.startDragging(xcoord, ycoord);
  }

  /**
   * {@inheritDoc}
   */
  public void stopDragging(double xcoord, double ycoord) {
    selection.stopDragging(xcoord, ycoord);
  }

  /**
   * {@inheritDoc}
   */
  public void cancelDragging() { selection.cancelDragging(); }

  /**
   * {@inheritDoc}
   */
  public void updatePosition(double xcoord, double ycoord) {
    selection.updatePosition(xcoord, ycoord);
  }

  /**
   * {@inheritDoc}
   */
  public void draw(DrawingContext drawingContext) {
    selection.draw(drawingContext);
  }

  /**
   * {@inheritDoc}
   */
  public boolean contains(double xcoord, double ycoord) {
    return selection.contains(xcoord, ycoord);
  }

  /**
   * {@inheritDoc}
   */
  public Cursor getCursorForPosition(double xcoord, double ycoord) {
    return selection.getCursorForPosition(xcoord, ycoord);
  }

  /**
   * {@inheritDoc}
   */
  public void updateDimensions() { selection.updateDimensions(); }
}
