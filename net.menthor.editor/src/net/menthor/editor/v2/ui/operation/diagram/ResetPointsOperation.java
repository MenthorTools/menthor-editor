package net.menthor.editor.v2.ui.operation.diagram;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.Connection;
import org.tinyuml.ui.diagram.OntoumlEditor;

import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class ResetPointsOperation extends DiagramOperation {

	private static final long serialVersionUID = -1321480473934728961L;

	protected Connection connection;
	protected List<Point2D> originalPoints;

	public ResetPointsOperation(OntoumlEditor editor, Connection conn) {
		this.ontoumlEditor = editor;
		this.connection = conn;
		this.operationType = OperationType.RESET_POINTS;
	}
	
	public void run() {
		super.run();
		runWithoutNotifying();
		System.out.println(runStatus());
		notifier.notifyViewChange(this,  isRedo ? ActionType.REDO : ActionType.DO, connection);		
	}
	
	protected void runWithoutNotifying(){
		originalPoints = clone(connection.getPoints());
		connection.resetPoints();		
	}
	
	private List<Point2D> clone(List<Point2D> points) {
		List<Point2D> result = new ArrayList<Point2D>();
		for (Point2D point : points) {
			result.add((Point2D) point.clone());
		}
		return result;
	}
	
	protected void undoWithoutNotifying(){
		connection.setPoints(originalPoints);		
	}
	
	@Override
	public void undo() {
		super.undo();		
		undoWithoutNotifying();		
		System.out.println(undoStatus());
		notifier.notifyViewChange(this, ActionType.UNDO,connection);
	}
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] "+ontoumlEditor.getDiagram()+": "+connection;
	}
	
	public String runStatus(){
		return "["+operationType.pastTense()+"] "+ontoumlEditor.getDiagram()+": "+connection;
	}
}
