package net.menthor.editor.v2.tree;

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

import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/** Code adapted from: {@link http://www.java2s.com/Code/Java/Swing-JFC/DnDdraganddropJTreecode.htm} */
public class TreeDragSourceListener implements DragSourceListener, DragGestureListener {

	private DragSource source;
	@SuppressWarnings("unused")
	private DragGestureRecognizer recognizer;
	private TransferableTreeNode transferable;
	@SuppressWarnings("unused")
	private DefaultMutableTreeNode oldNode;
	private JTree sourceTree;

	public TreeDragSourceListener(JTree tree, int actions) {
	    sourceTree = tree;
	    source = new DragSource();
	    recognizer = source.createDefaultDragGestureRecognizer(sourceTree, actions, this);
	}

	public void dragGestureRecognized(DragGestureEvent dge) {
	    TreePath path = sourceTree.getSelectionPath();
	    if ((path == null) || (path.getPathCount() <= 1)) {
	      // We can't move the root node or an empty selection
	      return;
	    }
	    oldNode = (DefaultMutableTreeNode) path.getLastPathComponent();
	    transferable = new TransferableTreeNode(path);
	    source.startDrag(dge, DragSource.DefaultMoveNoDrop, transferable, this);

	    // If you support dropping the node anywhere, you should probably
	    // start with a valid move cursor:
	    //source.startDrag(dge, DragSource.DefaultMoveDrop, transferable, this);
	}

	public void dragEnter(DragSourceDragEvent dsde) {}
	public void dragExit(DragSourceEvent dse) {}
	public void dragOver(DragSourceDragEvent dsde) {}
	public void dropActionChanged(DragSourceDragEvent dsde) {}
	public void dragDropEnd(DragSourceDropEvent dsde) {}	
}
