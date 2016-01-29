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

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;

public class TreeDropTargetListener implements DropTargetListener {

	@SuppressWarnings("unused")
	private DropTarget target;
	private JTree targetTree;
	 
	public TreeDropTargetListener(JTree tree) {
	    targetTree = tree;
	    target = new DropTarget(targetTree, this);
	}

	private TreeNode getNodeForEvent(DropTargetDragEvent dtde) {
	    Point p = dtde.getLocation();
	    DropTargetContext dtc = dtde.getDropTargetContext();
	    JTree tree = (JTree) dtc.getComponent();
	    TreePath path = tree.getClosestPathForLocation(p.x, p.y);
	    return (TreeNode) path.getLastPathComponent();
	}

	public void dragEnter(DropTargetDragEvent dtde) {
		TreeNode dragStartedNode = getNodeForEvent(dtde);
	    if (dragStartedNode.isLeaf()) {
	      dtde.rejectDrag();
	    } else {
	      // start by supporting move operations
	      //dtde.acceptDrag(DnDConstants.ACTION_MOVE);
	      dtde.acceptDrag(dtde.getDropAction());
	    }
	}

	public void dragOver(DropTargetDragEvent dtde) {
	    TreeNode node = getNodeForEvent(dtde);	    
	    if (node.isLeaf()) {
	      dtde.rejectDrag();
	    } else {
	      // start by supporting move operations
	      //dtde.acceptDrag(DnDConstants.ACTION_MOVE);
	      dtde.acceptDrag(dtde.getDropAction());
	    }
	}

	public void dragExit(DropTargetEvent dte) {}
	public void dropActionChanged(DropTargetDragEvent dtde) {}

	public void drop(DropTargetDropEvent dtde) {
	    Point pt = dtde.getLocation();
	    DropTargetContext dtc = dtde.getDropTargetContext();
	    JTree tree = (JTree) dtc.getComponent();
	    TreePath parentpath = tree.getClosestPathForLocation(pt.x, pt.y);
	    DefaultMutableTreeNode parent = (DefaultMutableTreeNode) parentpath.getLastPathComponent();	    
	    //we only accept drops within packages
	  	if (!(parent.getUserObject() instanceof RefOntoUML.Package)) {
	  	     dtde.rejectDrop();	  	     
	  	     return;
	  	}	  	  
	    try {
	      Transferable tr = dtde.getTransferable();
	      DataFlavor[] flavors = tr.getTransferDataFlavors();
	      for (int i = 0; i < flavors.length; i++) {
	        if (tr.isDataFlavorSupported(flavors[i])) {
	          dtde.acceptDrop(dtde.getDropAction());
	          //make the dnd movement
		  	  DefaultMutableTreeNode dropNode = (DefaultMutableTreeNode)targetTree.getSelectionPath().getLastPathComponent();		  	  	          	          
	          DefaultTreeModel model = (DefaultTreeModel) tree.getModel();	          
	          model.removeNodeFromParent(dropNode);	          
	          model.insertNodeInto(dropNode, parent, 0);
	          addToNewContainer(dropNode.getUserObject(),parent.getUserObject());	          
	          dtde.dropComplete(true);
	          return;
	        }
	      }
	      dtde.rejectDrop();
	    } catch (Exception e) {
	      e.printStackTrace();
	      dtde.rejectDrop();
	    }
	}
	
	//==================================================
	//ADD TO NEW CONTAINER
	//==================================================
	
	private void addToNewContainer(Object obj, Object container){
		if((obj instanceof RefOntoUML.PackageableElement) && (container instanceof RefOntoUML.Package)){
			if(obj instanceof OclDocument){
				((OclDocument)obj).setContainer(container);
			}
			else if(obj instanceof OntoumlDiagram){
				((OntoumlDiagram)obj).setContainer(container);
			}
			else if(obj instanceof RefOntoUML.Element){
				((RefOntoUML.Package)container).getPackagedElement().add((RefOntoUML.PackageableElement)obj);
			}
			//System.out.println("Parent:"+container);
			//System.out.println("Transfered:"+obj);
		}  	
	}
}

