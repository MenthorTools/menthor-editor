package net.menthor.editor.ui;

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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.dnd.DropTarget;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.editors.Editor;
import net.menthor.editor.v2.status.StatusPane;
import net.menthor.editor.v2.toolbar.DiagramToolBar;
import net.menthor.editor.v2.trees.DiagramDropListener;
import net.menthor.editor.v2.types.EditorType;
import net.menthor.editor.v2.ui.RoundedPanel;

import org.tinyuml.ui.diagram.DiagramEditor;

/** Wrapper class for DiagramEditor responsible for providing toolbar and a statusbar for the diagram. */
public class DiagramWrapper extends RoundedPanel implements Editor{

	private static final long serialVersionUID = -1962960747434759099L;
	
	private DiagramToolBar diagramToolbar;
	public DiagramToolBar getToolBar() { return diagramToolbar; }
	
	private DiagramEditor editor;
	public DiagramEditor getDiagramEditor() { return editor; }
	
	private StatusPane diagramStatus;
	public StatusPane getStatusBar() { return diagramStatus; }
	
	private JScrollPane scrollpane;
	public JScrollPane getScrollPane() { return scrollpane; }
	
	public DropTarget dndTarget;
	
	public DiagramWrapper(final DiagramEditor editor, CommandListener editorDispatcher){
		super();
		this.editor = editor;	
		diagramToolbar = new DiagramToolBar(editor.getListener());		
		diagramStatus = new StatusPane();		
		scrollpane = new JScrollPane();
		scrollpane.setBackground(Color.WHITE);
		scrollpane.getVerticalScrollBar().setUnitIncrement(16);
		scrollpane.getHorizontalScrollBar().setUnitIncrement(16);
		scrollpane.setWheelScrollingEnabled(true);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setViewportView(editor);
		scrollpane.setBorder(new EmptyBorder(0,0,0,0));		
		add(diagramToolbar,BorderLayout.NORTH);
		add(scrollpane,BorderLayout.CENTER);
		add(diagramStatus,BorderLayout.SOUTH);		
		/* drag from the tree and drop at the diagram */		
	    dndTarget = new DropTarget(editor, new DiagramDropListener(editor.getListener()));
	}	
	
	public void setViewportCenter(Point p) {
	    JViewport vp = (JViewport) scrollpane.getViewport();
	    Rectangle viewRect = vp.getViewRect();
	    viewRect.x = p.x - viewRect.width / 2;
	    viewRect.y = p.y - viewRect.height / 2;
	    scrollpane.scrollRectToVisible(viewRect);
	}
	
	public Point getViewportCenter() {
	    JViewport vp = (JViewport) this.getParent();
	    Point p = vp.getViewPosition();
	    return new Point(p.x+vp.getWidth()/2,p.y+vp.getHeight()/2);
	}
	
	public boolean contains(RefOntoUML.Element element){
		return editor.getDiagram().containsChild(ElementMapper.getDiagramElementByDiagram(element,editor.getDiagram()));
	}
	
	@Override
	public boolean isSaveNeeded() {
		return editor.isSaveNeeded();
	}

	@Override
	public EditorType getEditorType() {
		return EditorType.ONTOUML_DIAGRAM;
	}

	@Override
	public void dispose() {
		
	}
}
