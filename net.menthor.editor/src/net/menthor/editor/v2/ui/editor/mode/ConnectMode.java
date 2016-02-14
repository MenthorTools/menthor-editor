package net.menthor.editor.v2.ui.editor.mode;

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

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.LineConnectMethod;
import org.tinyuml.draw.NullElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.shared.UmlConnection;

import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
import net.menthor.editor.v2.ui.operation.diagram.AddConnectionOperation;

public class ConnectMode implements IEditorMode {

	// -------- Lazy Initialization

	private static class ConnectModeLoader {
        private static final ConnectMode INSTANCE = new ConnectMode();
    }	
	public static ConnectMode get() { 
		return ConnectModeLoader.INSTANCE; 
	}	
    private ConnectMode() {
        if (ConnectModeLoader.INSTANCE != null) throw new IllegalStateException("ConnectMode already instantiated");
    }
    
    // ----------------------------
    
    protected LineConnectMethod drawer;
    protected RelationshipType relType;
	protected DiagramElement sourceElem = null;
	protected DiagramElement targetElem = null;
	protected Point2D startPos = new Point2D.Double();
	protected Point2D tmpPos = new Point2D.Double();
	protected boolean isActive = false;

	public void setRelationshipType(RelationshipType relType){
		this.relType = relType;
		this.drawer = FactoryManager.get().getDefaultConnectMethod(relType);
	}
	
	@Override
	public void mousePressed(EditorMouseEvent event) {
		OntoumlEditor editor = AppTabManager.get().getCurrentDiagramEditor();
		double mx = event.getX(), my = event.getY();
		sourceElem = editor.getDiagram().getChildAt(mx, my);
		if (sourceElem!=null && ! (sourceElem instanceof NullElement)) {
			  startPos.setLocation(mx, my); 
			  tmpPos.setLocation(mx, my);
			  isActive = true;
		}		
	}
	
	@Override
	public void mouseReleased(EditorMouseEvent event) {
		OntoumlEditor editor = AppTabManager.get().getCurrentDiagramEditor();
		double mx = event.getX(), my = event.getY();
	    targetElem = editor.getDiagram().getChildAt(mx, my);	
	    tmpPos.setLocation(mx, my);
	    if(sourceElem !=null && targetElem !=null){
	    	UmlConnection conn = FactoryManager.get().createConnection(relType, sourceElem, targetElem); 
	    	AddConnectionOperation command = new AddConnectionOperation(editor, conn);
	    	command.run();
	    }
	    isActive = false;
	    editor.cancelEditing();
	    editor.redraw();		
	}
	
	@Override
	public void mouseDragged(EditorMouseEvent event) {
		double mx = event.getX(), my = event.getY();
	    tmpPos.setLocation(mx, my);
	    AppTabManager.get().getCurrentDiagramEditor().redraw();	    
	}

	@Override
	public void draw(DrawingContext drawingContext) {
		if(isActive){
		   drawer.drawLineSegments(drawingContext, startPos, tmpPos);
		}		
	}
	
	@Override
	public void mouseClicked(EditorMouseEvent event) {}
	@Override
	public void mouseMoved(EditorMouseEvent event) {}	
	@Override
	public void cancel() { isActive = false; }		
}
