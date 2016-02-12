package net.menthor.editor.v2.ui.notify.diagram;

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

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.Connection;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;

import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

/**
 * This class implements a reversible command to reset a connection's points.
 *
 * @author Wei-ju Wu, John Guerson
 */
public class ResetPointsDiagramCommand extends DiagramCommand {

	private static final long serialVersionUID = -1321480473934728961L;
	private Connection connection;
	private List<Point2D> originalPoints;

	/**
	 * Constructor.
	 * @param aNotification the notification object
	 * @param conn the connection
	 */
	public ResetPointsDiagramCommand(OntoumlEditor editor, Connection conn) {
		this.ontoumlEditor = editor;
		connection = conn;
		this.notificationType = NotificationType.RESET_POINTS;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		originalPoints = clonePointList(connection.getPoints());
		connection.resetPoints();
		
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		elements.add(connection);
		
		if (notifier!=null) {
			notifier.notify(this, (List<DiagramElement>) elements, isRedo ? ActionType.REDO : ActionType.DO);		
						
		}		
	}

	/**
	 * Makes a defensive copy of a point list.
	 * @param points the point list to clone
	 * @return the cloned point list
	 */
	private List<Point2D> clonePointList(List<Point2D> points) {
		List<Point2D> result = new ArrayList<Point2D>();
		for (Point2D point : points) {
			result.add((Point2D) point.clone());
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		super.undo();
		connection.setPoints(originalPoints);
		
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		elements.add(connection);
		notifier.notify(this, elements, ActionType.UNDO);
	}
}
