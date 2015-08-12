package net.menthor.editor.v2.trees;

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

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.tree.TreePath;

public class TransferableTreeNode implements Transferable {

	public static DataFlavor TREE_PATH_FLAVOR = new DataFlavor(TreePath.class, "Tree Path");

	DataFlavor flavors[] = { TREE_PATH_FLAVOR };
	TreePath path;

	public TransferableTreeNode(TreePath tp) {
	    path = tp;
	}

	public synchronized DataFlavor[] getTransferDataFlavors() {
	    return flavors;
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {
	    return (flavor.getRepresentationClass() == TreePath.class);
	}

	public synchronized Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
	  if (isDataFlavorSupported(flavor)) {
	    return (Object) path;
	  }else{
	    throw new UnsupportedFlavorException(flavor);
	  }
	}
}

