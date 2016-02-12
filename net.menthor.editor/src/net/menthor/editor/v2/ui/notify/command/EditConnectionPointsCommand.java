package net.menthor.editor.v2.ui.notify.command;

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
import org.tinyuml.draw.RectilinearConnection;
import org.tinyuml.draw.SimpleConnection;
import org.tinyuml.draw.TreeConnection;
import org.tinyuml.ui.diagram.OntoumlEditor;

import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

/**
 * This class implements an unoable operation to set a new list of connection
 * points to a given connection.
 *
 * @author Wei-ju Wu
 */
public class EditConnectionPointsCommand extends DiagramCommand {

	private static final long serialVersionUID = -6538389889543538053L;
	private Connection connection;
	private List<Point2D> oldpoints, newpoints;

	/**
	 * Constructor.
	 * @param aNotification the notification object
	 * @param aConnection the connection object
	 * @param theNewpoints the new point list
	 */
	public EditConnectionPointsCommand(OntoumlEditor editor, Connection aConnection, List<Point2D> theNewpoints) {
		this.ontoumlEditor = editor;
		connection = aConnection;
		newpoints = clonePointList(theNewpoints);
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		oldpoints = clonePointList(connection.getPoints());
		
		List<DiagramElement> elements = new ArrayList<DiagramElement>();		
		
		if(connection instanceof RectilinearConnection) elements.add(((RectilinearConnection)connection).getOwnerConnection());
		if(connection instanceof SimpleConnection) elements.add(((SimpleConnection)connection).getOwnerConnection());
		if(connection instanceof TreeConnection) elements.add(((TreeConnection)connection).getOwnerConnection());
		
		connection.setPoints(newpoints);
		
		if(connection.getConnections()!=null){
			for(Connection c : connection.getConnections()){
				c.resetPoints();
			}
		}			
		
		if (notificator!=null) {
			notificator.notify(this, (List<DiagramElement>) elements, NotificationType.MODIFY_CONNECTION_POINTS, isRedo ? ActionType.REDO : ActionType.DO);		
						
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
		connection.setPoints(oldpoints);
		
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		
		if(connection instanceof RectilinearConnection) elements.add(((RectilinearConnection)connection).getOwnerConnection());
		if(connection instanceof SimpleConnection) elements.add(((SimpleConnection)connection).getOwnerConnection());
		if(connection instanceof TreeConnection) elements.add(((TreeConnection)connection).getOwnerConnection());
		
		notificator.notify(this,elements, NotificationType.MODIFY_CONNECTION_POINTS, ActionType.UNDO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redo() {
		isRedo = true;
		super.redo();
		run();
	}
}
