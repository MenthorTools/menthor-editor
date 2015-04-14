package net.menthor.editor.explorer.dnd;

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
	public void dragGestureRecognized(DragGestureEvent dge) 
    {
    	// Can only drag leafs
        JTree tree = (JTree) dge.getComponent();
    	TreePath path = tree.getSelectionPath();
 	    if ((path == null) || (path.getPathCount() <= 1)) 
 	    {
 	      // We can't move the root node or an empty selection
 	      return;
 	    }
 	    
 	    DefaultMutableTreeNode selection = (DefaultMutableTreeNode) path.getLastPathComponent();
 	    TransferableTreeNode node = new TransferableTreeNode(selection);
 	    
 	    Cursor cursor = selectCursor (dge.getDragAction());
 	    try{
 	    	dge.startDrag(cursor , node, new TreeDragSourceListener());
 	    }catch(InvalidDnDOperationException e){
 	    	 e.printStackTrace(); 	    	 
 	    }
    }
    
    public Cursor selectCursor (int action) 
	{
	   return (action == DnDConstants.ACTION_MOVE) ?
	   DragSource.DefaultMoveDrop : DragSource.DefaultCopyDrop;
	}
}