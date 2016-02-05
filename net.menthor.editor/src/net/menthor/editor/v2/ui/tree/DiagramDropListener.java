package net.menthor.editor.v2.ui.tree;
 
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
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class DiagramDropListener implements DropTargetListener{
	  
	private ICommandListener listener;
	private Point location = new Point();
	@SuppressWarnings("unused")
	private boolean dragInProgress = false;
  
	public DiagramDropListener(ICommandListener listener){
		this.listener = listener;
	}

	public void dragEnter(DropTargetDragEvent dtde){ location = dtde.getLocation(); dragInProgress = true; }
	public void dragOver(DropTargetDragEvent dtde){ location = dtde.getLocation(); }
	public void dragExit(DropTargetEvent dte) { dragInProgress = false; }
	public void dropActionChanged(DropTargetDragEvent dtde) {}

	public void drop(DropTargetDropEvent dtde){
		location = dtde.getLocation();
		dragInProgress = false; 		  		  
		DropTargetContext dtc = dtde.getDropTargetContext();			    
	  	if (dtc.getComponent()==null) { dtde.rejectDrop(); return; }		  
	  	try {			 
	  		Transferable tr = dtde.getTransferable();			  
	  		if(tr.isDataFlavorSupported(TransferableTreeNode.TREE_PATH_FLAVOR)){
	  			dtde.acceptDrop(DnDConstants.ACTION_MOVE);
	  			
	  			listener.handleCommand(CommandType.MOVE_SELECTED_TREE_TO_DIAGRAM.toString(), new Object[]{location});
	  			
	  			dtde.dropComplete(true);
	  		}			  
	  		dtde.rejectDrop();			  
	  	}catch (Exception e) {
	  		e.printStackTrace();
	  		dtde.rejectDrop();			  
	  	}
	}
}
