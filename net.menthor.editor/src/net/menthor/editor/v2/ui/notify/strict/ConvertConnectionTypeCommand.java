package net.menthor.editor.v2.ui.notify.strict;

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

import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.Connection;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.shared.UmlConnection;

import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramStrictCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

/**
 * This class converts wrapped connection types.
 *
 * @author Wei-ju Wu, John Guerson
 */
public class ConvertConnectionTypeCommand extends DiagramStrictCommand {

	private static final long serialVersionUID = -8661812094443443847L;
	private UmlConnection connection;
	private Connection newconnection;
	private Connection oldconnection;

	/**
	 * Constructor.
	 * @param aNotification the Notification object
	 * @param umlconn the UmlConnection wrapped object
	 * @param theNewConnection the new connection to be wrapped
	 */
	public ConvertConnectionTypeCommand(OntoumlEditor editor, UmlConnection umlconn, Connection theNewConnection) {
		this.ontoumlEditor = editor;
		connection = umlconn;
		newconnection = theNewConnection;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		oldconnection = connection.getConnection();
		newconnection.copyData(oldconnection);
		connection.setConnection(newconnection);
		//in case of a derivation connected to a material, reset derivation's points
		for(Connection c: connection.getConnections()){
			c.resetPoints();
		}
		
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		elements.add(connection);
		
		if (notifier!=null) {
			notifier.notify(this,(List<DiagramElement>) elements, NotificationType.MODIFY_CONNECTION_TYPE, isRedo ? ActionType.REDO : ActionType.DO);		
						
		}		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		super.undo();
		connection.setConnection(oldconnection);
	
		List<DiagramElement> elements = new ArrayList<DiagramElement>();
		elements.add(connection);
		notifier.notify(this, elements, NotificationType.MODIFY_CONNECTION_TYPE, ActionType.UNDO);
	}

}
