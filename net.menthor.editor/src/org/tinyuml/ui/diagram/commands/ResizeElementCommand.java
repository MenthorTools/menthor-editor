package org.tinyuml.ui.diagram.commands;

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

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DoubleDimension;
import org.tinyuml.draw.Node;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;

/**
 * This class implements a resizing command.
 *
 * @author Wei-ju Wu, John Guerson
 */
public class ResizeElementCommand extends BaseDiagramCommand {

	private static final long serialVersionUID = -3090945928366890788L;
	private Node element;
	private Point2D newpos = new Point2D.Double(), oldpos = new Point2D.Double();
	private Dimension2D newsize = new DoubleDimension(), oldsize = new DoubleDimension();

	/**
	 * Constructor.
	 * @param aNotification the ModelNotification object
	 * @param anElement the element to resize
	 * @param aNewPos the new position
	 * @param aNewSize the new size
	 */
	public ResizeElementCommand(DiagramNotification aNotification, Node anElement, Point2D aNewPos, Dimension2D aNewSize) {
		this.notification = aNotification;
		element = anElement;
		newpos.setLocation(aNewPos);
		newsize.setSize(aNewSize);
		oldpos.setLocation(element.getAbsoluteX1(), element.getAbsoluteY1());
		oldsize.setSize(element.getSize().getWidth(), element.getSize().getHeight());
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		element.setAbsolutePos(newpos.getX(), newpos.getY());
		
		element.setSize(newsize.getWidth(), newsize.getHeight());
				
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		elements.add(element);
		
		DiagramEditor d = ((DiagramEditor)notification);
		//notify
		if (d!=null) {
			d.notifyChange((List<DiagramElement>) elements, ChangeType.ELEMENTS_RESIZED, redo ? NotificationType.REDO : NotificationType.DO);			
			UndoableEditEvent event = new UndoableEditEvent(((DiagramEditor)d), this);
			for (UndoableEditListener l : ((DiagramEditor)d).editListeners)  l.undoableEditHappened(event);			
		}		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redo() {
		redo = true;
		super.redo();
		run();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		super.undo();
		element.setAbsolutePos(oldpos.getX(), oldpos.getY());
		element.setSize(oldsize.getWidth(), oldsize.getHeight());
		
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		elements.add(element);
		notification.notifyChange(elements, ChangeType.ELEMENTS_RESIZED, NotificationType.UNDO);
	}
}
