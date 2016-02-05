package net.menthor.editor.v2.ui.tree;

import java.util.Comparator;

import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("rawtypes")
class TreeStringComparator implements Comparator {
	
	public int compare(Object o1, Object o2) {
	    if (!(o1 instanceof DefaultMutableTreeNode && o2 instanceof DefaultMutableTreeNode)) {
	      throw new IllegalArgumentException("Can only compare DefaultMutableTreeNode objects");
	    }
	    String s1 = ((DefaultMutableTreeNode) o1).getUserObject().toString();
	    String s2 = ((DefaultMutableTreeNode) o2).getUserObject().toString();
	    return s1.compareToIgnoreCase(s2);
	}
}