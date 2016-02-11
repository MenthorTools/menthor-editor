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

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import org.tinyuml.draw.Connection;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.MoveNodeOperation;
import org.tinyuml.draw.MoveOperation;
import org.tinyuml.draw.Node;
import org.tinyuml.draw.TranslateConnectionOperation;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;
import org.tinyuml.umldraw.StructureDiagram;


/**
 * This class represents the move of one or more diagram allElements.
 * Theoretically, this method simply executes the list of Commands and could
 * also execute anything else. The difference is that this method also
 * notifies the system about an element move.
 *
 * @author Wei-ju Wu, John Guerson
 */
public class MoveElementCommand extends GenericDiagramCommand {

	private static final long serialVersionUID = 2523534899493234371L;
	private MoveOperation[] moveOperations;
	private List<DiagramElement> elements = new ArrayList<DiagramElement>();
	
	/**
	 * Constructor.
	 * @param aNotification the notification
	 * @param aMoveOperations the move operations
	 */
	public MoveElementCommand(DiagramNotification aNotification, final MoveOperation[] aMoveOperations) {
		this.notification = aNotification;
		moveOperations = new MoveOperation[aMoveOperations.length];
		for (int i = 0; i < aMoveOperations.length; i++) {
			moveOperations[i] = aMoveOperations[i];
		}
		for (MoveOperation moveOperation : moveOperations) {			
			if(moveOperation instanceof MoveNodeOperation){
				if(!(((MoveNodeOperation)moveOperation).getNode() instanceof StructureDiagram)){					
					elements.add(((MoveNodeOperation)moveOperation).getNode());
				}
			}else {
				if(moveOperation instanceof TranslateConnectionOperation){
					elements.add(((TranslateConnectionOperation)moveOperation).getConnection());
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
				
		for (MoveOperation moveOperation : moveOperations) {
			if(moveOperation instanceof MoveNodeOperation){
				moveOperation.run();
			}
			if(moveOperation instanceof TranslateConnectionOperation){
				Connection conn = ((TranslateConnectionOperation)moveOperation).getConnection();
				Node node1 = conn.getNode1();
				Node node2 = conn.getNode2();
				Connection conn1 = conn.getConnection1();
				Connection conn2 = conn.getConnection2();
				if(node1 != null && node2 !=null && elements.contains(node1) && elements.contains(node2)) moveOperation.run();
				if(conn1 != null && conn2 !=null && elements.contains(conn1) && elements.contains(conn2)) moveOperation.run();
				if(conn1 != null && node2 !=null && elements.contains(conn1) && elements.contains(node2)) moveOperation.run();
				if(node1 != null && conn2 !=null && elements.contains(node1) && elements.contains(conn2)) moveOperation.run();
			}
		}
				
		//move the connections related to every connection moved
		//this should be done through the MoveOperation and not by reseting points
		for(DiagramElement elem: elements){			
			if (elem instanceof Node){
				Node node = (Node)elem;
				for(Connection c: node.getConnections()){					
					resetRelatedConnectionPoints((OntoumlEditor)notification, c);
				}
			}
		}

		OntoumlEditor d = ((OntoumlEditor)notification);
		//notify
		if (d!=null) {
			d.notifyChange((List<DiagramElement>) elements, ChangeType.ELEMENTS_MOVED, redo ? NotificationType.REDO : NotificationType.DO);			
			UndoableEditEvent event = new UndoableEditEvent(((OntoumlEditor)d), this);
			for (UndoableEditListener l : ((OntoumlEditor)d).editListeners)  l.undoableEditHappened(event);			
		}
	}

	public void resetRelatedConnectionPoints(OntoumlEditor notification, Connection con)
	{
		if(con.getConnections()!=null){
			for(Connection c2: con.getConnections()) { 
				c2.resetPoints();
				c2.invalidate();
			}	
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		
		super.undo();
						
		for (MoveOperation moveOperation : moveOperations) {
			if(moveOperation instanceof MoveNodeOperation){
				moveOperation.undo();
			}
			if(moveOperation instanceof TranslateConnectionOperation){
				Connection conn = ((TranslateConnectionOperation)moveOperation).getConnection();
				Node node1 = conn.getNode1();
				Node node2 = conn.getNode2();
				Connection conn1 = conn.getConnection1();
				Connection conn2 = conn.getConnection2();
				if(node1 != null && node2 !=null && elements.contains(node1) && elements.contains(node2)) moveOperation.undo();
				if(conn1 != null && conn2 !=null && elements.contains(conn1) && elements.contains(conn2)) moveOperation.undo();
				if(conn1 != null && node2 !=null && elements.contains(conn1) && elements.contains(node2)) moveOperation.undo();
				if(node1 != null && conn2 !=null && elements.contains(node1) && elements.contains(conn2)) moveOperation.undo();
			}
		}
		
		notification.notifyChange(elements, ChangeType.ELEMENTS_MOVED, NotificationType.UNDO);		
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
}
