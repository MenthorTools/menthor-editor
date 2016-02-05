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

import java.util.Comparator;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

class SortTreeModel extends DefaultTreeModel {
	  
	private static final long serialVersionUID = -3688752043502623815L;
	
	@SuppressWarnings("rawtypes")
	private Comparator comparator = new TreeObjectComparator();

	public SortTreeModel(TreeNode node) {
		super(node);
	}

	public SortTreeModel(TreeNode node, boolean asksAllowsChildren) {
	    super(node, asksAllowsChildren);
	}

	public void insertNodeInto(MutableTreeNode child, MutableTreeNode parent) {
	    int index = findIndexFor(child, parent);
	    super.insertNodeInto(child, parent, index);
	}

	public void insertNodeInto(MutableTreeNode child, MutableTreeNode par, int i) {
	    // The index is useless in this model, so just ignore it.
	    insertNodeInto(child, par);
	}

	// Perform a recursive binary search on the children to find the right
	// insertion point for the next node.
	@SuppressWarnings("unchecked")
	private int findIndexFor(MutableTreeNode child, MutableTreeNode parent) {
	    int cc = parent.getChildCount();
	    if (cc == 0) {
	      return 0;
	    }
	    if (cc == 1) {
	      return comparator.compare(child, parent.getChildAt(0)) <= 0 ? 0 : 1;
	    }
	    return findIndexFor(child, parent, 0, cc - 1); // First & last index
	}

	@SuppressWarnings("unchecked")
	private int findIndexFor(MutableTreeNode child, MutableTreeNode parent, int i1, int i2) {
	    if (i1 == i2) {
	      return comparator.compare(child, parent.getChildAt(i1)) <= 0 ? i1 : i1 + 1;
	    }
	    int half = (i1 + i2) / 2;
	    if (comparator.compare(child, parent.getChildAt(half)) <= 0) {
	      return findIndexFor(child, parent, i1, half);
	    }
	    return findIndexFor(child, parent, half + 1, i2);
	}
}
