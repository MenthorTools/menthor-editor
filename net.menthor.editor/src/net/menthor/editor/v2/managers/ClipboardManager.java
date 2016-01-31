package net.menthor.editor.v2.managers;

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

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.AddNodeCommand;
import org.tinyuml.umldraw.shared.UmlNode;

import net.menthor.editor.ui.FactoryManager;
import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.v2.editors.base.EditorMode;
import net.menthor.editor.v2.editors.base.EditorMouseEvent;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;

public class ClipboardManager extends BaseManager implements EditorMode {
	
	// -------- Lazy Initialization

	private static class ClipboardLoader {
        private static final ClipboardManager INSTANCE = new ClipboardManager();
    }	
	public static ClipboardManager get() { 
		return ClipboardLoader.INSTANCE; 
	}	
    private ClipboardManager() {
        if (ClipboardLoader.INSTANCE != null) throw new IllegalStateException("ClipboardManager already instantiated");
    }		
    
    // ----------------------------
	
	protected List<DiagramElement> clipboard = new ArrayList<DiagramElement>(); //copied elements
	protected Rectangle2D clipBounds;
	protected Point2D tmpPos = new Point2D.Double();
		
	public void clearClipboard(){
	  tmpPos = new Point2D.Double();
	  clipBounds = null;
	  clipboard.clear();
	}
	
	/** copy selected elements and put the copies in the clipboard */
	public void copySelectedToClipboard(){
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
		copyToClipboard(de.getSelectedElements());		
	}
	
	/** create given class from stereotype and put the created class to clipboard */
	public void copyToClipboard(ClassType elementType){
		UmlNode node = ClipboardManager.get().createNode(elementType);
		copyToClipboard(node);
	}
	
	/** create given datatype from a stereotype and put the created datatype to clipboard */
	public void copyToClipboard(DataType elementType){
		UmlNode node = ClipboardManager.get().createNode(elementType);
		copyToClipboard(node);
	}
	
	/** copy given elements and put the copies in the clipboard */
	public void copyToClipboard(List<DiagramElement> elements){
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
		DrawingContext context = MenthorEditor.getFrame().getDrawingContext();
		de.setEditorMode(this);
		clipboard.clear();		
		cloneNodes(elements);
		initClipBounds();
		drawClipBounds(context);
	}
	
	/** copy given element and put the copy to clipboard */
	public void copyToClipboard(DiagramElement element){
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
		DrawingContext context = MenthorEditor.getFrame().getDrawingContext();
		de.setEditorMode(this);
		clipboard.clear();
		if(element instanceof UmlNode) {
			cloneNode((UmlNode)element);
			initClipBounds();
			drawClipBounds(context);
		}		
	}
		
	
	/** paste clipboard elements to current diagram */
	public void pasteClipboard(){
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
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
				AddNodeCommand cmd = new AddNodeCommand(de, ce, ceCenterX-40, ceCenterY-20);		
				cmd.run();
			}			
		}
		de.cancelEditing();				
		de.select(clipboard);		
		clearClipboard();
	}
	
	/** draw the bounds of the copied elements in the clipboard */
	@Override
	public void draw(DrawingContext drawingContext) {
//		if(clipBounds==null) initClipBounds();
		drawClipBounds(drawingContext);
	}
		
	private void updateClipBounds(){
		if(clipBounds!=null){
			clipBounds.setRect(tmpPos.getX()-(clipBounds.getWidth()/2), tmpPos.getY()-(clipBounds.getHeight()/2), 
			clipBounds.getWidth(), clipBounds.getHeight());
		}
	}
	
	private void drawClipBounds(DrawingContext drawingContext){		
		if(clipBounds!=null) {
			drawingContext.drawRectangle(clipBounds.getX(), clipBounds.getY(), clipBounds.getWidth(), clipBounds.getHeight(), null);
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
		 TabManager.get().getCurrentDiagramEditor().redraw();
	}
	
	@Override
	public void mousePressed(EditorMouseEvent event) {
		tmpPos.setLocation(event.getX(), event.getY());
		pasteClipboard();
		TabManager.get().getCurrentDiagramEditor().redraw();
	}
	
	@Override
	public void mouseClicked(EditorMouseEvent event){}	
	@Override
	public void mouseReleased(EditorMouseEvent event){}
	@Override
	public void mouseDragged(EditorMouseEvent event){}
	@Override
	public void stateChanged(){}
	@Override
	public void cancel(){}
	
	
	/** clone a node and put the cloned node to clipboard */
	public UmlNode cloneNode(UmlNode node){		 	    
		UmlNode ce = (UmlNode)node.clone();	        
	    ce.setParent(node.getDiagram());	    
		if(!clipboard.contains(ce))clipboard.add(ce);
		OccurenceManager.get().add(ce.getClassifier(), ce);
	    return ce;
	}		  
	
	public void cloneNodes(List<DiagramElement> selected){
		for(DiagramElement s: selected){
			if(s instanceof UmlNode) cloneNode((UmlNode)s);
		}
	}
	
	/** create a node from a stereotype and put the created node to clipboard */
	public UmlNode createNode(ClassType stereotype) {
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
	    UmlNode node = FactoryManager.get().createNode(stereotype, de.getDiagram());	        
	    node.setParent(de.getDiagram());    
	    if(!clipboard.contains(node))clipboard.add(node);
	    OccurenceManager.get().add(node.getClassifier(), node);
	    return node;
	}
		  
	/** clone a node from a stereotype and put the created node to clipboard */
	public UmlNode createNode(DataType stereotype) {
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
	    UmlNode node = FactoryManager.get().createNode(stereotype, de.getDiagram());
	    node.setParent(de.getDiagram());    
	    if(!clipboard.contains(node))clipboard.add(node);
	    OccurenceManager.get().add(node.getClassifier(), node);
	    return node;
	}
		  
	/** create a node and put the created node to clipboard */
	public UmlNode createNode(RefOntoUML.Type type, EObject eContainer) {
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();		
	    UmlNode node = FactoryManager.get().createNode(type, eContainer, de.getDiagram());
	    node.setParent(de.getDiagram());
	    if(!clipboard.contains(node))clipboard.add(node);
	    OccurenceManager.get().add(node.getClassifier(), node);
	    return node;
	}
}


