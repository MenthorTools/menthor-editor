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
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/** See the template used at: http://www.java2s.com/Code/Java/Swing-JFC/DnDdraganddropJTreecode.htm */
public class TreeDropTargetListener implements DropTargetListener {
	
	  DropTarget target;	
	  JTree targetTree;

	  public TreeDropTargetListener(JTree tree){
	    targetTree = tree;
	    target = new DropTarget(targetTree, this);
	  }

	  /** Drop Event Handlers */
	  private TreeNode getNodeForEvent(DropTargetDragEvent dtde){
		  Point p = dtde.getLocation();
		  DropTargetContext dtc = dtde.getDropTargetContext();
		  JTree tree = (JTree) dtc.getComponent();
		  TreePath path = tree.getClosestPathForLocation(p.x, p.y);
		  return (TreeNode) path.getLastPathComponent();
	  }

	  public void dragEnter(DropTargetDragEvent dtde) {
		  TreeNode node = getNodeForEvent(dtde);
		  if (node.isLeaf()) dtde.rejectDrag();
		  else {
			  // start by supporting move operations
			  //dtde.acceptDrag(DnDConstants.ACTION_MOVE);
			  dtde.acceptDrag(dtde.getDropAction());
		  }
	  }

	  public void dragOver(DropTargetDragEvent dtde){
		  TreeNode node = getNodeForEvent(dtde);
		  if (node.isLeaf()) dtde.rejectDrag();
		  else {
			  // start by supporting move operations
			  //dtde.acceptDrag(DnDConstants.ACTION_MOVE);
			  dtde.acceptDrag(dtde.getDropAction());
		  }
	  }

	  public void dragExit(DropTargetEvent dte) {}

	  public void dropActionChanged(DropTargetDragEvent dtde) {}

	  @SuppressWarnings("unused")
	  public void drop(DropTargetDropEvent dtde){
		  Point pt = dtde.getLocation();
		  DropTargetContext dtc = dtde.getDropTargetContext();
		  JTree tree = (JTree) dtc.getComponent();
		  TreePath parentpath = tree.getClosestPathForLocation(pt.x, pt.y);	    
		  DefaultMutableTreeNode parent = (DefaultMutableTreeNode) parentpath.getLastPathComponent();
		  Object parentObj = parent.getUserObject();
		  try {
			  Transferable tr = dtde.getTransferable();
			  DataFlavor[] flavors = tr.getTransferDataFlavors();
			  for(int i = 0; i < flavors.length; i++){
				  if (tr.isDataFlavorSupported(flavors[i])){
					  dtde.acceptDrop(dtde.getDropAction());
					  Object dataObj = tr.getTransferData(flavors[i]);	          
					  
					  /* dropping */
//	          		  if((dataObj instanceof RefOntoUMLElement) && ((parentObj instanceof RefOntoUMLElement))){	        	  
//		        	  	  //move at the ecore model
//		        	      RefOntoUML.Element parentElem = (RefOntoUML.Element) ((RefOntoUMLElement)parentObj).getElement();
//		        	      if(parentElem instanceof RefOntoUML.Package){
//		        		  RefOntoUML.Element elem = (RefOntoUML.Package) ((RefOntoUMLElement)dataObj).getElement();
//		        		  parentElem.eContents().add(elem);
//		        		  System.out.println("parent::"+parent.getUserObject());
//			        	  System.out.println("data::"+dataObj);
//	        	      }
//	        	  	  //move at tree model
//	        	      parent.insert(new DefaultMutableTreeNode(dataObj),parent.getChildCount());				
//	        	      TreePath p = (TreePath) tr.getTransferData(flavors[i]);
//		              DefaultMutableTreeNode node = (DefaultMutableTreeNode) p.getLastPathComponent();
//		              DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
//		              model.insertNodeInto(node, parent, 0);		          
				      
					  dtde.dropComplete(true);
					  return;
				  }
			  }
			  dtde.rejectDrop();
	    }catch(Exception e) {
	      e.printStackTrace();
	      dtde.rejectDrop();
	    }	  
	}
}
