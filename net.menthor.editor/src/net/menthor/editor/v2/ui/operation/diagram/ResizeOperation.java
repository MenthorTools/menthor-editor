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

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

import org.tinyuml.draw.DoubleDimension;
import org.tinyuml.draw.Node;
import org.tinyuml.ui.diagram.OntoumlEditor;

import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class ResizeOperation extends DiagramOperation {

	private static final long serialVersionUID = -3090945928366890788L;

	protected Node element;
	protected Point2D newpos = new Point2D.Double(), oldpos = new Point2D.Double();
	protected Dimension2D newsize = new DoubleDimension(), oldsize = new DoubleDimension();
		
	public ResizeOperation(OntoumlEditor editor, Node anElement, Point2D aNewPos, Dimension2D aNewSize) {
		this.ontoumlEditor = editor;
		this.operationType = OperationType.RESIZE;
		element = anElement;
		newpos.setLocation(aNewPos);
		newsize.setSize(aNewSize);
		oldpos.setLocation(element.getAbsoluteX1(), element.getAbsoluteY1());
		oldsize.setSize(element.getSize().getWidth(), element.getSize().getHeight());
	}

	@Override
	public void run() {
		super.run();
		runWithoutNotifying();
		System.out.println(runStatus());
		notifier.notifyViewChange(this, isRedo ? ActionType.REDO : ActionType.DO,element);		
				
	}

	protected void runWithoutNotifying(){
		element.setAbsolutePos(newpos.getX(), newpos.getY());		
		element.setSize(newsize.getWidth(), newsize.getHeight());		
	}
	
	protected void undoWithoutNotifying(){
		element.setAbsolutePos(oldpos.getX(), oldpos.getY());
		element.setSize(oldsize.getWidth(), oldsize.getHeight());		
	}
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] "+ontoumlEditor.getDiagram()+": "+element;
	}
	
	public String runStatus(){
		return "["+operationType.pastTense()+"] "+ontoumlEditor.getDiagram()+": "+element;
	}
	
	@Override
	public void undo() {
		super.undo();
		undoWithoutNotifying();
		System.out.println(undoStatus());
		notifier.notifyViewChange(this, ActionType.UNDO,element);
	}
}
