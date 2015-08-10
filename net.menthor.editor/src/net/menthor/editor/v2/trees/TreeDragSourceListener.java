package net.menthor.editor.v2.trees;

/*
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
 * 
 * @author John Guerson
 */


import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

public class TreeDragSourceListener implements DragSourceListener {
	
	public void dragEnter(DragSourceDragEvent dsde){
		DragSourceContext context = dsde.getDragSourceContext();
		int dropAction = dsde.getDropAction();
		if ((dropAction & DnDConstants.ACTION_COPY) != 0) context.setCursor(DragSource.DefaultCopyDrop);
		else if ((dropAction & DnDConstants.ACTION_MOVE) != 0) context.setCursor(DragSource.DefaultMoveDrop);
		else context.setCursor(DragSource.DefaultMoveDrop);			
	}

	public void dragExit(DragSourceEvent dse) {}
	public void dragOver(DragSourceDragEvent dsde) {}
	public void dropActionChanged(DragSourceDragEvent dsde) { }
	
	public void dragDropEnd(DragSourceDropEvent dsde){
		if (dsde.getDropSuccess()){
			int dropAction = dsde.getDropAction();
			if (dropAction == DnDConstants.ACTION_MOVE) {}
		}
	}		
}
