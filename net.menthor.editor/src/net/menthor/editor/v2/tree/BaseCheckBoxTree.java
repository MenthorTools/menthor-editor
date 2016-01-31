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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.util.Util;

public class BaseCheckBoxTree extends CheckboxTree {

	private static final long serialVersionUID = 1L;

	protected DefaultMutableTreeNode modelRootNode;		
	protected SortTreeModel treeModel;
	protected TreeCheckingModel checkingModel;
	
	protected BaseCheckBoxTree(final CommandListener listener, DefaultMutableTreeNode rootNode){
		this(rootNode);
		/* Ctrl+Up / Ctrl+Down Key Stroke */
		if(Util.onMac()){
			getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, ActionEvent.META_MASK), "moveup");
			getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, ActionEvent.META_MASK), "movedown");
		}else{
			getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, ActionEvent.CTRL_MASK), "moveup");
			getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, ActionEvent.CTRL_MASK), "movedown");
		}
		getActionMap().put("moveup", new AbstractAction() {			
			private static final long serialVersionUID = -340479571291150368L;			
			@Override
		    public void actionPerformed(ActionEvent e) {				
				listener.handleCommand(CommandType.MOVE_UP_TREE.toString());
		    }
		});				
		getActionMap().put("movedown", new AbstractAction() {			
			private static final long serialVersionUID = -340479571291150368L;			
			@Override
		    public void actionPerformed(ActionEvent e) {				
				listener.handleCommand(CommandType.MOVE_DOWN_TREE.toString());
		    }
		});
	}
	
	/**Constructor */
	protected BaseCheckBoxTree(DefaultMutableTreeNode rootNode){
		super(rootNode);
		this.modelRootNode = rootNode;
		this.treeModel = new SortTreeModel(rootNode);
		setModel(treeModel);
		getCheckingModel().setCheckingMode(TreeCheckingModel.CheckingMode.PROPAGATE);			
		checkingModel = getCheckingModel();		
		setMinimumSize(new Dimension(0,0));
	}
	
	/** Remove all nodes except the root node. */
	public void clear(){
    	modelRootNode.removeAllChildren();
        treeModel.reload();
    }    
    
    public void resetSelection() { }
    
    /** Get the selected node from the tree */
    public DefaultMutableTreeNode getSelectedNode(){
    	DefaultMutableTreeNode selectedNode;
		TreePath parentPath = getSelectionPath(); 
	    if (parentPath == null){
	        selectedNode = modelRootNode;
	    }else{
	      selectedNode = (DefaultMutableTreeNode)(parentPath.getLastPathComponent());
	    }
	    return selectedNode;
    }
    
    /** Add child to the currently selected node. */
    public DefaultMutableTreeNode addChild(Object child){    		
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = getSelectionPath(); 
        if (parentPath == null){
            parentNode = modelRootNode;
        } else {
            parentNode = (DefaultMutableTreeNode)(parentPath.getLastPathComponent());
        } 
        return addChild(parentNode, child, true);
    }    
      
    public DefaultMutableTreeNode addChild(DefaultMutableTreeNode parent, Object child){
    	return addChild(parent, child, true);
    }
    
    /** Add element to the tree */
    protected DefaultMutableTreeNode addChild(DefaultMutableTreeNode parent, Object child, boolean shouldBeVisible){    	
		DefaultMutableTreeNode node = getNode(child);
		if(node!=null) return node;    	    	
		DefaultMutableTreeNode childNode = createNode(child);		
		if (parent == null) parent = modelRootNode;				
		//It is key to invoke this on the TreeModel, and NOT SortedTreeNode
		treeModel.insertNodeInto(childNode, parent, parent.getChildCount());		
		//Make sure the user can see the lovely new node.
		if (shouldBeVisible) scrollPathToVisible(new TreePath(childNode.getPath()));		
		return childNode;
    }
      	
  	public void moveUp(){	
  		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) getLastSelectedPathComponent();
  		if (selectedNode == null) return;
		DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
  		 // Check if this is the top node in its group
        if( selectedNode.getPreviousSibling() != null ){
            // Move the node up one
            SortTreeModel treeModel = (SortTreeModel)getModel();
            int newIndex = treeModel.getIndexOfChild(parent,selectedNode) - 1;
            treeModel.removeNodeFromParent(selectedNode);
            treeModel.insertNodeInto(selectedNode,parent,newIndex);
            // Select the node, make sure it's visible, and repaint the tree
            TreePath newPath = new TreePath(selectedNode.getPath());
            scrollPathToVisible(newPath);
            setSelectionPath(newPath);
            repaint();
        }
  	}
  	
  	public void moveDown(){	
  		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) getLastSelectedPathComponent();
  		if (selectedNode == null) return;
		DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
  		 // Check if this is the bottom node in its group
        if( selectedNode.getNextSibling() != null ){
            // Move the node down one
            SortTreeModel treeModel = (SortTreeModel)getModel();
            int newIndex = treeModel.getIndexOfChild(parent,selectedNode) + 1;
            treeModel.removeNodeFromParent(selectedNode);
            treeModel.insertNodeInto(selectedNode,parent,newIndex);
            // Select the node, make sure it's visible, and repaint the tree
            TreePath newPath = new TreePath(selectedNode.getPath());
            scrollPathToVisible(newPath);
            setSelectionPath(newPath);
            repaint();
        }
  	}
  	
    /** Get the root node from the tree */
    public DefaultMutableTreeNode getRootNode(){
		return modelRootNode;
	}
			
    public void colapseAll(){
    	collapsePath(new TreePath(modelRootNode.getPath()));
    }
    
    /** Get the node of this user object */
    @SuppressWarnings("rawtypes")
    public DefaultMutableTreeNode getNode(Object userObject){	
    	if(modelRootNode.getUserObject().equals(userObject)) return modelRootNode;
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()){	    	
    		Object obj = node.getUserObject();
    		if (obj.equals(userObject)) return node;	    		    		
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element	    
	    Object obj = node.getUserObject();
	    if (obj.equals(userObject)) return node;	    	  
	    return null;
    }
    
    /** Create a node to the tree*/
    public DefaultMutableTreeNode createNode(Object object){
    	return new DefaultMutableTreeNode(object);    
    }
    
	
	/** Get checked elements */
    public List<Object> getCheckedObjects () {		
		List<Object> checkedNodes = new ArrayList<Object>();
	    TreePath[] treepathList = getCheckingPaths();	    	
	    for (TreePath treepath : treepathList){	    	
	    	DefaultMutableTreeNode node = ((DefaultMutableTreeNode)treepath.getLastPathComponent());	    	
	    	Object elem = (Object)node.getUserObject();
	    	if(!checkedNodes.contains(elem)) checkedNodes.add(elem);	    		    		    	
	    }		    	
	    return checkedNodes;
	}
    
	/** Get Unchecked Elements. */
    public List<Object> getUncheckedObject (){
		List<Object> uncheckedNodes = new ArrayList<Object>();
		List<Object> checkedNodes = new ArrayList<Object>();
	    TreePath[] treepathList = getCheckingPaths();	    	
	    for (TreePath treepath : treepathList){	    	
	    	DefaultMutableTreeNode node = ((DefaultMutableTreeNode)treepath.getLastPathComponent());	    	
	    	Object elem = (Object)node.getUserObject();
	    	if(!checkedNodes.contains(elem)) checkedNodes.add(elem);	    	
	    }		    
	    return uncheckedNodes;
	}

	/** Check Node. */
	@SuppressWarnings({ "rawtypes", "unused" })
	protected void checkNode(DefaultMutableTreeNode node, boolean uncheckChildren){		
		Object childObject;		
		addCheckingPath(new TreePath(node.getPath()));				
		Object userobj = node.getUserObject();
		//unselected children only if was different than Association
    	if(uncheckChildren && userobj!=null && node.getChildCount()>0){
			Enumeration e = node.breadthFirstEnumeration();
			DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)e.nextElement();				
			while (e.hasMoreElements()){
				childNode = (DefaultMutableTreeNode)e.nextElement();				
				childObject = (Object)childNode.getUserObject();		    		
				getCheckingModel().removeCheckingPath(new TreePath(childNode.getPath()));				
			}
    	}
	}
	
	/** Uncheck Node. */
	@SuppressWarnings({ "rawtypes", "unused" })
	public void uncheckNode(DefaultMutableTreeNode node, boolean checkChildren){		
		Object childObject;		
		removeCheckingPath(new TreePath(node.getPath()));		
		Object userobj = node.getUserObject();				
		//unselected children only if was different than Association
    	if(checkChildren && userobj!=null && node.getChildCount()>0){
			Enumeration e = node.breadthFirstEnumeration();
			DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)e.nextElement();					
			while (e.hasMoreElements()) {
				childNode = (DefaultMutableTreeNode)e.nextElement();				
				childObject = (Object)childNode.getUserObject();		    		
				getCheckingModel().addCheckingPath(new TreePath(childNode.getPath()));				
			}
    	}
	}
	
	/** Select node */
	public void select (DefaultMutableTreeNode  node){
		this.setSelectionPath(new TreePath(node.getPath()));
		this.scrollPathToVisible(new TreePath(node.getPath()));		
	}
	
	/** Check these elements. We do not concern with other elements*/
	@SuppressWarnings("rawtypes")
	public void check(List<Object> elements){			   
		List<Object> alreadyChecked = getCheckedObjects();	    
		alreadyChecked.removeAll(elements);
		alreadyChecked.addAll(elements);				
	    Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) {	    	
	    	Object obj = (Object)node.getUserObject();
		    if (alreadyChecked.contains(obj)) { checkNode(node,true); }	    		    		    		
	    	node = (DefaultMutableTreeNode)e.nextElement();	    
	    }
	    //last element	    
	    Object obj = (Object)node.getUserObject();
		if (alreadyChecked.contains(obj)) { checkNode(node,true); }	    
	}	
	
	/** Check these elements in the tree uncheking all other leafs */
	@SuppressWarnings("rawtypes")
	public void checkStrictly(List<Object> elements){			   
	    Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) {	    	
	    	Object obj = (Object)node.getUserObject();
	    	if(node.isLeaf()){
	    		if (elements.contains(obj)) { checkNode(node,true); }	    			
	    		else { uncheckNode(node,true); }
	    	}	    		    	
	    	node = (DefaultMutableTreeNode)e.nextElement();	    
	    }
	    //last element	    
	    Object obj = (Object)node.getUserObject();
		if(node.isLeaf()){
		    if (elements.contains(obj)) { checkNode(node,true); }  
		    else { uncheckNode(node,true); }
	    }	    
	}	
	
	/** Uncheck this elements */
	@SuppressWarnings("rawtypes")
	public void uncheck(List<Object> elements){			   
		List<Object> alreadyUnchecked = getUncheckedObject();	    
		alreadyUnchecked.removeAll(elements);
		alreadyUnchecked.addAll(elements);				
	    Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()){	    	
	    	Object obj = (Object)node.getUserObject();
		    if (alreadyUnchecked.contains(obj)) { uncheckNode(node,true); }	    		    		    		
	    	node = (DefaultMutableTreeNode)e.nextElement();	    
	    }
	    //last element	    
	    Object obj = (Object)node.getUserObject();
		if (alreadyUnchecked.contains(obj)) { uncheckNode(node,true); }	    
	}	
	
	/** Check Element */
	@SuppressWarnings("rawtypes")
	public boolean checkObject(Object element){	
		boolean result = false;
		Object rootEObj = (Object)modelRootNode.getUserObject();
		if (rootEObj.equals(element)) { result=true; select(modelRootNode); return result; }		
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) {	    	
	    	Object obj = (Object)node.getUserObject();
	    	if (obj.equals(element)) { 
	    		result =true;		    		
	    		this.setSelectionPath(new TreePath(node.getPath()));
	    		this.scrollPathToVisible(new TreePath(node.getPath()));			    		
	    		return result;
	    	}	    		    		
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element	    
	    Object obj = (Object)node.getUserObject();
	    if (obj.equals(element)){ 
	    	result =true;		    	
	    	this.setSelectionPath(new TreePath(node.getPath()));
	    	this.scrollPathToVisible(new TreePath(node.getPath()));		    	
	    	return result;
	    }	    	    
	    return result;	    
	}
	
	/** Remove the currently selected node. */
    public void removeCurrentNode(){
        TreePath currentSelection = getSelectionPath();
        if (currentSelection != null){
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)(currentSelection.getLastPathComponent());
            MutableTreeNode parent = (MutableTreeNode)(currentNode.getParent());
            if (parent != null){
                treeModel.removeNodeFromParent(currentNode);
                treeModel.nodeChanged(parent);
                return;
            }
        }
    }    
}
