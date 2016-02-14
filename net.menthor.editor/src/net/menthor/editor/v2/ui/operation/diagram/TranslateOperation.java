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

import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.Connection;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.MoveNodeOperation;
import org.tinyuml.draw.MoveOperation;
import org.tinyuml.draw.Node;
import org.tinyuml.draw.TranslateConnectionOperation;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.StructureDiagram;

import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class TranslateOperation extends DiagramOperation {

	private static final long serialVersionUID = 2523534899493234371L;
	
	protected MoveOperation[] moveOperations;
	protected List<DiagramElement> elements = new ArrayList<DiagramElement>();
	
	public TranslateOperation(OntoumlEditor editor, final MoveOperation[] aMoveOperations) {
		this.ontoumlEditor = editor;
		this.operationType = OperationType.TRANSLATE;
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

	@Override
	public void run() {
		super.run();
		runWithoutNotifying();
		System.out.println(runStatus());
		notifier.notifyViewChange(this,isRedo ? ActionType.REDO : ActionType.DO,elements);		
	}

	@Override
	public void undo() {		
		super.undo();
		undoWithoutNotifying();
		System.out.println(undoStatus());
		notifier.notifyViewChange(this,ActionType.UNDO,elements);		
	}
	
	protected void runWithoutNotifying(){		
		for (MoveOperation moveOperation : moveOperations) {
			if(moveOperation instanceof MoveNodeOperation){
				moveOperation.run();
			}
			if(moveOperation instanceof TranslateConnectionOperation){
				Connection conn = ((TranslateConnectionOperation)moveOperation).getConnection();
				DiagramElement node1 = conn.getSourceDiagramElement();
				DiagramElement node2 = conn.getTargetDiagramElement();				
				if(node1 != null && node2 !=null && elements.contains(node1) && elements.contains(node2)) moveOperation.run();				
			}
		}				
		//move the connections related to every connection moved
		//this should be done through the MoveOperation and not by reseting points (FIXME)		
		for(DiagramElement elem: elements){			
			if (elem instanceof Node){
				Node node = (Node)elem;
				for(Connection c: node.getConnections()){					
					resetRelatedConnectionPoints(c);
				}
			}
		}
	}
	
	protected void undoWithoutNotifying(){		
		for (MoveOperation moveOperation : moveOperations) {
			if(moveOperation instanceof MoveNodeOperation){
				moveOperation.undo();
			}
			if(moveOperation instanceof TranslateConnectionOperation){
				Connection conn = ((TranslateConnectionOperation)moveOperation).getConnection();
				DiagramElement node1 = conn.getSourceDiagramElement();
				DiagramElement node2 = conn.getTargetDiagramElement();					
				if(node1 != null && node2 !=null && elements.contains(node1) && elements.contains(node2)) moveOperation.undo();				
			}
		}
	}
	
	private void resetRelatedConnectionPoints(Connection con){
		if(con.getConnections()!=null){
			for(Connection c2: con.getConnections()) { 
				c2.resetPoints();
				c2.invalidate();
			}	
		}
	}
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] "+ontoumlEditor.getDiagram()+": "+asString(elements);
	}
	
	public String runStatus(){
		return "["+operationType.pastTense()+"] "+ontoumlEditor.getDiagram()+": "+asString(elements);
	}
}
