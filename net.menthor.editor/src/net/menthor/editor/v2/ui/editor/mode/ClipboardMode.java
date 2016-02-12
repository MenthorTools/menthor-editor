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
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.shared.UmlNode;

import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
import net.menthor.editor.v2.ui.notify.command.AddNodeCommand;
import net.menthor.editor.v2.util.DrawUtil;

public class ClipboardMode implements IEditorMode {
	
	// -------- Lazy Initialization

	private static class ClipboardLoader {
        private static final ClipboardMode INSTANCE = new ClipboardMode();
    }	
	public static ClipboardMode get() { 
		return ClipboardLoader.INSTANCE; 
	}	
    private ClipboardMode() {
        if (ClipboardLoader.INSTANCE != null) throw new IllegalStateException("ClipboardManager already instantiated");
    }		
    
    // ----------------------------
	
	protected List<DiagramElement> clipboard = new ArrayList<DiagramElement>(); //copied elements
	protected Rectangle2D clipBounds;	
	protected Point2D tmpPos = new Point2D.Double();
	protected boolean isActive = false;
		
	public void clearClipboard(){
	  tmpPos = new Point2D.Double();
	  clipBounds = null;
	  clipboard.clear();
	  isActive=false;
	}
	
	public void cloneSelectedAndPutToClipboard(){
		OntoumlEditor de = AppTabManager.get().getCurrentDiagramEditor();
		cloneAndPutToClipboard(de.getSelectedElements());
	}
	
	public void cloneAndPutToClipboard(List<DiagramElement> diagramElementList){	
		isActive=true;
		OntoumlEditor de = AppTabManager.get().getCurrentDiagramEditor();		
		de.setEditorMode(this);
		clipboard.clear();		
		for(DiagramElement s: diagramElementList){
			if(s instanceof UmlNode) {
				UmlNode ce = FactoryManager.get().cloneNode((UmlNode)s);
			    if(!clipboard.contains(ce))clipboard.add(ce);
			}
		}
		initClipBounds();
		drawClipBounds();
	}
	
	public void cloneAndPutToClipboard(DiagramElement element){
		isActive=true;
		OntoumlEditor de = AppTabManager.get().getCurrentDiagramEditor();		
		de.setEditorMode(this);
		clipboard.clear();
		if(element instanceof UmlNode) {
			UmlNode ce = FactoryManager.get().cloneNode((UmlNode)element);
		    if(!clipboard.contains(ce))clipboard.add(ce);	
			initClipBounds();
			drawClipBounds();
		}		
	}
		
	public void createAndPutToClipboard(ClassType elementType){
		isActive=true;
		OntoumlEditor de = AppTabManager.get().getCurrentDiagramEditor();		
		de.setEditorMode(this);
		clipboard.clear();
	    UmlNode node = FactoryManager.get().createNode(elementType, de.getDiagram());	        
	    if(!clipboard.contains(node)) clipboard.add(node);	 
	   	initClipBounds();
	   	drawClipBounds();	 		
	}
	
	public void createAndPutToClipboard(DataType elementType){
		isActive=true;
		OntoumlEditor de = AppTabManager.get().getCurrentDiagramEditor();		
		de.setEditorMode(this);
		clipboard.clear();
	    UmlNode node = FactoryManager.get().createNode(elementType, de.getDiagram());	        
	    if(!clipboard.contains(node)) clipboard.add(node);
	    initClipBounds();
		drawClipBounds();
	}
	
	public UmlNode putToClipboard(RefOntoUML.Type type, boolean drawClipBounds) {
		isActive=true;
		OntoumlEditor de = AppTabManager.get().getCurrentDiagramEditor();		
		de.setEditorMode(this);
		clipboard.clear();
	    UmlNode node = FactoryManager.get().createNode(type, de.getDiagram());
	    if(!clipboard.contains(node))clipboard.add(node);
	    if(drawClipBounds){
	    	initClipBounds();
	    	drawClipBounds();
	    }			    
	    return node;
	}
	
	public void pasteClipboard(){
		OntoumlEditor de = AppTabManager.get().getCurrentDiagramEditor();
		for(Object o: clipboard){
			if(o instanceof UmlNode){				
				UmlNode ce = (UmlNode)o;				
				double ceCenterX = tmpPos.getX(); 
				double ceCenterY = tmpPos.getY();
				if(clipboard.size()>1) {
					Point2D.Double center = de.getCenterPointOnSelected();
					ceCenterX = ce.getAbsCenterX()+(ceCenterX - center.getX());
					ceCenterY = ce.getAbsCenterY()+(ceCenterY - center.getY());
				}				 
				AddNodeCommand cmd = new AddNodeCommand(de.getNotificator(), ce, ceCenterX-40, ceCenterY-20);		
				cmd.run();
			}			
		}
		de.cancelEditing();				
		clearClipboard();
		isActive=false;
	}
	
	/** draw the bounds of the copied elements in the clipboard */
	@Override
	public void draw(DrawingContext drawingContext) {
		if(isActive){
			drawClipBounds();
		}
	}
		
	private void updateClipBounds(){
		if(clipBounds!=null){
			clipBounds.setRect(tmpPos.getX()-(clipBounds.getWidth()/2), tmpPos.getY()-(clipBounds.getHeight()/2), 
			clipBounds.getWidth(), clipBounds.getHeight());
		}
	}
	
	private void drawClipBounds(){		
		if(clipBounds!=null) {
			DrawUtil.getDrawingContext().drawRectangle(
				clipBounds.getX(), clipBounds.getY(), 
				clipBounds.getWidth(), clipBounds.getHeight(), 
				null
			);
		}
	}
	
	private Rectangle2D initClipBounds() {
		double minx = Double.MAX_VALUE, miny = Double.MAX_VALUE;
	    double maxy = Double.MIN_VALUE, maxx = Double.MIN_VALUE;
	    if(clipBounds==null) {
	    	clipBounds = clipboard.get(0).getAbsoluteBounds();
	    }
		for (DiagramElement element : clipboard) {
	      Rectangle2D elemBounds = element.getAbsoluteBounds();
	      minx = Math.min(minx, elemBounds.getX());
	      miny = Math.min(miny, elemBounds.getY());
	      maxx = Math.max(maxx, elemBounds.getX() + elemBounds.getWidth());
	      maxy = Math.max(maxy, elemBounds.getY() + elemBounds.getHeight());
	    }
		if(clipBounds!=null) {
			clipBounds.setRect(minx, miny, maxx - minx, maxy - miny);		
		}
		return clipBounds; 
	}
	
	@Override
	public void mouseMoved(EditorMouseEvent event) {
		 tmpPos.setLocation(event.getX(), event.getY());
		 updateClipBounds();
		 AppTabManager.get().getCurrentDiagramEditor().redraw();
	}
	
	@Override
	public void mousePressed(EditorMouseEvent event) {		
		tmpPos.setLocation(event.getX(), event.getY());		
		pasteClipboard();
		AppTabManager.get().getCurrentDiagramEditor().redraw();
	}
	  
	@Override
	public void mouseReleased(EditorMouseEvent event){}	
	@Override
	public void mouseDragged(EditorMouseEvent event){}	
	@Override
	public void mouseClicked(EditorMouseEvent event){}	
	@Override
	public void cancel(){ isActive=false;}
}


