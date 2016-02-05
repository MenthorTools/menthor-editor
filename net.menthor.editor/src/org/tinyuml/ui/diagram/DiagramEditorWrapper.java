package org.tinyuml.ui.diagram;

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

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.types.EditorType;
import net.menthor.editor.v2.ui.RoundedPanel;
import net.menthor.editor.v2.ui.editor.base.IEditor;
import net.menthor.editor.v2.ui.statusbar.StatusBar;
import net.menthor.editor.v2.ui.toolbar.DiagramToolBar;
import net.menthor.editor.v2.ui.tree.DiagramDropListener;

public class DiagramEditorWrapper extends RoundedPanel implements IEditor{

	private static final long serialVersionUID = -1962960747434759099L;
	
	private DiagramToolBar diagramToolbar;		
	private JScrollPane scrollpane;
	private DiagramEditor diagramEditor;
	private StatusBar statusPane;
	public DropTarget dndTarget;
	
	public DiagramEditor getDiagramEditor() { return diagramEditor; }
	public DiagramToolBar getToolBar() { return diagramToolbar; }	
	public StatusBar getStatusBar() { return statusPane; }
	public JScrollPane getScrollPane() { return scrollpane; }
	
	public DiagramEditorWrapper(final DiagramEditor editor, ICommandListener editorDispatcher){
		super();
		this.diagramEditor = editor;	
		diagramToolbar = new DiagramToolBar(editor.getListener());		
		statusPane = new StatusBar();		
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
		add(statusPane,BorderLayout.SOUTH);		
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
		
	@Override
	public boolean isSaveNeeded() { return diagramEditor.isSaveNeeded(); }

	@Override
	public EditorType getEditorType() { return diagramEditor.getEditorType(); }

	@Override
	public void dispose() { diagramEditor.dispose(); }

	@Override
	public void propagateNewTitle(String title) { diagramEditor.propagateNewTitle(title); }
}
