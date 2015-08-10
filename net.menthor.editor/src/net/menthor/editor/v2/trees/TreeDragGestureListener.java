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


import java.awt.Cursor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.InvalidDnDOperationException;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class TreeDragGestureListener implements DragGestureListener 
{	
	public void dragGestureRecognized(DragGestureEvent dge){
    	// Can only drag leafs
        JTree tree = (JTree) dge.getComponent();
    	TreePath path = tree.getSelectionPath();
 	    if ((path == null) || (path.getPathCount() <= 1)){
 	      // We can't move the root node or an empty selection
 	      return;
 	    } 	    
 	    DefaultMutableTreeNode selection = (DefaultMutableTreeNode) path.getLastPathComponent();
 	    TransferableTreeNode node = new TransferableTreeNode(selection); 	    
 	    Cursor cursor = selectCursor (dge.getDragAction());
 	    try{
 	    	dge.startDrag(cursor , node, new TreeDragSourceListener());
 	    }catch(InvalidDnDOperationException e){
 	    	//
 	    }
    }
    
    public Cursor selectCursor (int action){
	   return (action == DnDConstants.ACTION_MOVE) ?
	   DragSource.DefaultMoveDrop : DragSource.DefaultCopyDrop;
	}
}