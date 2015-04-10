package net.menthor.editor.explorer.dnd;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class TransferableTreeNode extends DefaultMutableTreeNode implements Transferable, Serializable {
		
	private static final long serialVersionUID = 4942655854902893464L;
	
	final static int NODE = 0;
	final static int TREE_PATH = 1;
	final static int STRING = 2;
	final static int PLAIN_TEXT = 3;
	
	final public static DataFlavor DEFAULT_MUTABLE_TREENODE_FLAVOR = new DataFlavor(DefaultMutableTreeNode.class, "Default Mutable Tree Node");
	final public static DataFlavor TREE_PATH_FLAVOR = new DataFlavor(TreePath.class, "Tree Path");
	
	@SuppressWarnings("deprecation")
	static DataFlavor flavors[] = { DEFAULT_MUTABLE_TREENODE_FLAVOR, TREE_PATH_FLAVOR, DataFlavor.stringFlavor, DataFlavor.plainTextFlavor };
	
	private DefaultMutableTreeNode data;
	private TreePath path;
	
	public TransferableTreeNode(DefaultMutableTreeNode data) 
	{
		this.data = data;
	}

	public TransferableTreeNode(TreePath path) 
	{
		this.path = path;
	}
			
	public DataFlavor[] getTransferDataFlavors() 
	{
		return flavors;
	}

	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException 
	{
		Object returnObject;
		if (flavor.equals(flavors[NODE])) 
		{
			Object userObject = data.getUserObject();
			if (userObject == null) returnObject = data;
			else returnObject = userObject;			
		} 
		else if (flavor.equals(flavors[TREE_PATH])) 
		{			
			return path;
		} 
		else if (flavor.equals(flavors[STRING])) 
		{
			Object userObject = data.getUserObject();
			if (userObject == null) returnObject = data.toString();
			else returnObject = userObject.toString();			
		} 
		else if (flavor.equals(flavors[PLAIN_TEXT])) 
		{
			Object userObject = data.getUserObject();
			String string;
			if (userObject == null) string = data.toString();
			else string = userObject.toString();			
			returnObject = new ByteArrayInputStream(string.getBytes("Unicode"));
		} 
		else throw new UnsupportedFlavorException(flavor);		
		return returnObject;
	}
	
	public boolean isDataFlavorSupported(DataFlavor flavor) 
	{
		boolean returnValue = false;
		for (int i = 0, n = flavors.length; i < n; i++) 
		{
			if (flavor.equals(flavors[i])) 
			{
				returnValue = true;
				break;
			}
		}
		return returnValue;
	}
}