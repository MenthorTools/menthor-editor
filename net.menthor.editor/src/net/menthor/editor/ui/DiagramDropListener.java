package net.menthor.editor.ui;
  
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import org.tinyuml.ui.diagram.DiagramEditor;

import net.menthor.editor.v2.trees.TransferableTreeNode;

public class DiagramDropListener implements DropTargetListener{
	  
	  DiagramEditor targetEditor;
	  Point location = new Point();
	  boolean dragInProgress = false;
	  
	  public DiagramDropListener(DiagramEditor targetEditor) 
	  {
		  this.targetEditor = targetEditor;
	  }

	  public void dragEnter(DropTargetDragEvent dtde) 
	  {
		  location = dtde.getLocation();	
		  dragInProgress = true;
	  }

	  public void dragOver(DropTargetDragEvent dtde) 
	  {
		  location = dtde.getLocation();		  
	  }

	  public void dragExit(DropTargetEvent dte) { dragInProgress = false; }

	  public void dropActionChanged(DropTargetDragEvent dtde) {}

	  public void drop(DropTargetDropEvent dtde) 
	  {
		  location = dtde.getLocation();
		  dragInProgress = false; 
		  dtde.acceptDrop(DnDConstants.ACTION_MOVE);
		  
		  DropTargetContext dtc = dtde.getDropTargetContext();	    
		  DiagramEditor editor = (DiagramEditor) dtc.getComponent();	    
		  if (editor==null) { dtde.rejectDrop(); return; }		  
		  try {			 
			  Transferable tr = dtde.getTransferable();			  
			  if(tr.isDataFlavorSupported(TransferableTreeNode.DEFAULT_MUTABLE_TREENODE_FLAVOR))
			  {  
				  /** we may try to move the selected item from the tree, this should solve this issue (for now). */
				  targetEditor.getDiagramManager().moveSelectedToDiagram(targetEditor, location);
				  dtde.dropComplete(true);
			  }			  
			  dtde.rejectDrop();
			  
		  } catch (Exception e) {
			  e.printStackTrace();
			  dtde.rejectDrop();
			  
		  }
	  }
	}
