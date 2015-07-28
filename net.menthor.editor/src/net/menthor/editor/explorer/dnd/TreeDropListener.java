package net.menthor.editor.explorer.dnd;

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

/**
 * http://www.java2s.com/Code/Java/Swing-JFC/DnDdraganddropJTreecode.htm
 * 
 * @author John
 *
 */
public class TreeDropListener implements DropTargetListener {
	
	  DropTarget target;	
	  JTree targetTree;

	  public TreeDropListener(JTree tree) 
	  {
	    targetTree = tree;
	    target = new DropTarget(targetTree, this);
	  }

	  /** Drop Event Handlers */
	  private TreeNode getNodeForEvent(DropTargetDragEvent dtde) 
	  {
	    Point p = dtde.getLocation();
	    DropTargetContext dtc = dtde.getDropTargetContext();
	    JTree tree = (JTree) dtc.getComponent();
	    TreePath path = tree.getClosestPathForLocation(p.x, p.y);
	    return (TreeNode) path.getLastPathComponent();
	  }

	  public void dragEnter(DropTargetDragEvent dtde) 
	  {
	    TreeNode node = getNodeForEvent(dtde);
	    if (node.isLeaf()) dtde.rejectDrag();
	    else {
	      // start by supporting move operations
	      //dtde.acceptDrag(DnDConstants.ACTION_MOVE);
	      dtde.acceptDrag(dtde.getDropAction());
	    }
	  }

	  public void dragOver(DropTargetDragEvent dtde) 
	  {
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

	  public void drop(DropTargetDropEvent dtde) 
	  {
	    Point pt = dtde.getLocation();
	    DropTargetContext dtc = dtde.getDropTargetContext();
	    JTree tree = (JTree) dtc.getComponent();
	    TreePath parentpath = tree.getClosestPathForLocation(pt.x, pt.y);	    
	    DefaultMutableTreeNode parent = (DefaultMutableTreeNode) parentpath.getLastPathComponent();
	    Object parentObj = parent.getUserObject();
	    try {
	      Transferable tr = dtde.getTransferable();
	      DataFlavor[] flavors = tr.getTransferDataFlavors();
	      for (int i = 0; i < flavors.length; i++) 
	      {
	        if (tr.isDataFlavorSupported(flavors[i])) 
	        {
	          dtde.acceptDrop(dtde.getDropAction());
	          Object dataObj = tr.getTransferData(flavors[i]);
	          
	          /**droping an ontouml element*/
//	          if((dataObj instanceof RefOntoUMLElement) && ((parentObj instanceof RefOntoUMLElement))){	        	  
//	        	  //move at the ecore model
//	        	  RefOntoUML.Element parentElem = (RefOntoUML.Element) ((RefOntoUMLElement)parentObj).getElement();
//	        	  if(parentElem instanceof RefOntoUML.Package){
//	        		  RefOntoUML.Element elem = (RefOntoUML.Package) ((RefOntoUMLElement)dataObj).getElement();
//	        		  parentElem.eContents().add(elem);
//	        		  System.out.println("parent::"+parent.getUserObject());
//		        	  System.out.println("data::"+dataObj);
//	        	  }
//	        	  //move at tree model
//	        	  parent.insert(new DefaultMutableTreeNode(dataObj),parent.getChildCount());				
//	        	  TreePath p = (TreePath) tr.getTransferData(flavors[i]);
//		          DefaultMutableTreeNode node = (DefaultMutableTreeNode) p.getLastPathComponent();
//		          DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
//		          model.insertNodeInto(node, parent, 0);		          
//	          }
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
}
