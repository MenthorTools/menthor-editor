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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.parser.OntoUMLParser;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;
import net.menthor.editor.v2.OntoumlDiagram;

public class DiagramStrictTree extends ProjectTree {

	private static final long serialVersionUID = 1L;
	
	private List<OntoumlDiagram> diagrams;
	
	/** Create an instance of the tree */
	public static DiagramStrictTree createDiagramTree(OntoUMLParser refparser, List<OntoumlDiagram> diagrams, TreeVisibility opt, boolean checkboxVisible){
		if(refparser!=null){
			return new DiagramStrictTree(new DefaultMutableTreeNode(refparser.getModel()), 
			refparser, diagrams, opt,checkboxVisible);
		}else{
			return null;
		}
	}
	
	/**Constructor */
	private DiagramStrictTree (DefaultMutableTreeNode rootNode, OntoUMLParser refparser, List<OntoumlDiagram> diagrams, TreeVisibility opt, boolean checkboxVisible){	
		super(rootNode);			
		this.diagrams=diagrams;
		this.opt=opt;		
		//Collections.sort(this.diagrams);		
		TreeCellRenderer cellRenderer = new TreeCellRenderer(checkboxVisible);
		setCellRenderer(cellRenderer);		
		drawDiagrams(modelRootNode, refparser.getModel(), checkingModel, refparser);					
		addCheckingPath(new TreePath(modelRootNode.getPath()));		
		expandPath(new TreePath(modelRootNode.getPath()));
	}	

    /** Get the node of this element */
    @SuppressWarnings("rawtypes")
	protected DefaultMutableTreeNode getNode(OntoumlDiagram object){	
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()){
	    	if(node.getUserObject() instanceof OntoumlDiagram){
	    		EObject obj = ((OntoumlDiagram)node.getUserObject());
	    		if (obj.equals(object)) return node;	    		
	    	}	    		
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element
	    if(node.getUserObject() instanceof OntoumlDiagram){
	    	EObject obj = ((OntoumlDiagram)node.getUserObject());
	    	if (obj.equals(object)) return node;	
	    }	  
	    return null;
    }
            
    /** Add element to the tree */
    @Override
	public DefaultMutableTreeNode addElement(DefaultMutableTreeNode parent, Object child, boolean shouldBeVisible) 
    {
    	if(child instanceof Object){ 
    		super.addElement(parent,child,shouldBeVisible); 
    	}
    	else if (child instanceof OntoumlDiagram){    		
    		DefaultMutableTreeNode node = getNode((OntoumlDiagram)child);
    		if(node!=null) return node;
    	}    	
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);		
		if (parent == null) parent = modelRootNode;				
		//It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
		treeModel.insertNodeInto(childNode, parent, parent.getChildCount());		
		//Make sure the user can see the lovely new node.
		if (shouldBeVisible) scrollPathToVisible(new TreePath(childNode.getPath()));		
		return childNode;
    }
    			
	/** Draw */	
	protected void drawDiagrams(DefaultMutableTreeNode parent, Object object, TreeCheckingModel checkingModel, OntoUMLParser refparser){				
		if(object instanceof RefOntoUML.Model) {			
			for (OntoumlDiagram diagram : diagrams) {
				DefaultMutableTreeNode dNode = new DefaultMutableTreeNode(diagram);
				parent.add(dNode);
				expandPath(new TreePath(dNode.getPath()));				
				//diagram elements
				List<EObject> contents = diagram.getPackageableElements();
				for(EObject eobj: contents){
					super.drawElements(dNode, (RefOntoUML.Element) eobj);
				}
			}	
		}
	}
		
	/** Get checked elements */
	public List<OntoumlDiagram> getCheckedDiagrams(){	
		List<OntoumlDiagram> checkedNodes = new ArrayList<OntoumlDiagram>();
	    TreePath[] treepathList = getCheckingPaths();	    	
	    for (TreePath treepath : treepathList){	    	
	    	DefaultMutableTreeNode node = ((DefaultMutableTreeNode)treepath.getLastPathComponent());
	    	if (node.getUserObject() instanceof OntoumlDiagram)
	    		checkedNodes.add(((OntoumlDiagram)node.getUserObject()));	    		    	
	    }	    
	    return checkedNodes;
	}
	
	/** Get Unchecked Elements. */
	public List<OntoumlDiagram> getUncheckedDiagrams (){
		List<OntoumlDiagram> result = new ArrayList<OntoumlDiagram>();
		if(diagrams!=null) result.addAll(diagrams);
		result.removeAll(getCheckedDiagrams());
		return result;
	}
	
	/** Check Node. */
	@SuppressWarnings({ "rawtypes", "unused" })
	protected void checkNode(DefaultMutableTreeNode node, boolean uncheckChildren){			
		if(node.getUserObject() instanceof OntoumlDiagram || getRootNode().equals(node))
		{
			addCheckingPath(new TreePath(node.getPath()));	
			//uncheck children
	    	if(uncheckChildren && node.getChildCount()>0){
	    		EObject childObject;
				Enumeration e = node.breadthFirstEnumeration();
				DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)e.nextElement();				
				while (e.hasMoreElements()){			
					if(childNode.isLeaf()){
						super.checkNode(node, uncheckChildren);
					}					
					childNode = (DefaultMutableTreeNode)e.nextElement();
				}
	    	}			
		}
		else if(node.isLeaf()) {
			super.checkNode(node, uncheckChildren);
		}		
	}
	
	/** Uncheck Node. */
	@SuppressWarnings({ "rawtypes", "unused" })
	public void uncheckNode(DefaultMutableTreeNode node, boolean checkChildren){		
		if(node.getUserObject() instanceof OntoumlDiagram || getRootNode().equals(node))
		{
			removeCheckingPath(new TreePath(node.getPath()));
			//check children
	    	if(checkChildren && node.getChildCount()>0){
	    		EObject childObject;
				Enumeration e = node.breadthFirstEnumeration();
				DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)e.nextElement();				
				while (e.hasMoreElements()){					
					if(node.isLeaf()){
						super.uncheckNode(childNode, checkChildren);
					}
					childNode = (DefaultMutableTreeNode)e.nextElement();
				}
	    	}
		}
		else if(node.isLeaf()) {
			super.uncheckNode(node, checkChildren);
		}
	}	
}
