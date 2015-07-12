package net.menthor.editor.transformation;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import net.menthor.editor.util.ModelHelper;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLElement;

public class DiagramTree extends ElementTree {

	private static final long serialVersionUID = 1L;
	
	private List<StructureDiagram> diagrams;
	
	/** Create an instance of the filter tree */
	public static DiagramTree createFilter(OntoUMLParser refparser, List<StructureDiagram> diagrams, ElementVisibilityOption opt)
	{
		return new DiagramTree(
				new DefaultMutableTreeNode(new RefOntoUMLElement(refparser.getModel(),"")), 
				refparser,
				diagrams,
				opt);
	}
	
	/**Constructor */
	private DiagramTree (DefaultMutableTreeNode rootNode, OntoUMLParser refparser, List<StructureDiagram> diagrams, ElementVisibilityOption opt)
	{	
		super(rootNode);			
		this.refparser = refparser;		
		this.diagrams=diagrams;
		this.opt=opt;
		
		Collections.sort(this.diagrams);
		
		FilterCellRenderer cellRenderer = new FilterCellRenderer();
		setCellRenderer(cellRenderer);
		
		drawDiagrams(modelRootNode, refparser.getModel(), checkingModel, refparser);	
					
		addCheckingPath(new TreePath(modelRootNode.getPath()));		
		expandPath(new TreePath(modelRootNode.getPath()));
	}	

    /** Get the node of this element */
    @SuppressWarnings("rawtypes")
	protected DefaultMutableTreeNode getNode(StructureDiagram object)
    {	
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	if(node.getUserObject() instanceof StructureDiagram){
	    		EObject obj = ((StructureDiagram)node.getUserObject());
	    		if (obj.equals(object)) return node;	    		
	    	}	    		
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element
	    if(node.getUserObject() instanceof StructureDiagram){
	    	EObject obj = ((StructureDiagram)node.getUserObject());
	    	if (obj.equals(object)) return node;	
	    }	  
	    return null;
    }
            
    /** Add element to the filter */
    @Override
    protected DefaultMutableTreeNode addElement(DefaultMutableTreeNode parent, Object child, boolean shouldBeVisible) 
    {
    	if(child instanceof EObject)
    	{ 
    		super.addElement(parent,child,shouldBeVisible); 
    	}
    	else if (child instanceof StructureDiagram)
    	{    		
    		DefaultMutableTreeNode node = getNode((StructureDiagram)child);
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
	protected void drawDiagrams(DefaultMutableTreeNode parent, Object object, TreeCheckingModel checkingModel, OntoUMLParser refparser) 
	{				
		if(object instanceof RefOntoUML.Model) {			
			for (StructureDiagram diagram : diagrams) {
				//diagram
				DefaultMutableTreeNode dNode = new DefaultMutableTreeNode(diagram);
				parent.add(dNode);
				expandPath(new TreePath(dNode.getPath()));
				
				//diagram elements
				List<EObject> contents = ModelHelper.getPackageableElements(diagram);
				for(EObject eobj: contents){
					super.drawElement(dNode, (RefOntoUML.Element) eobj, checkingModel, refparser);
				}
			}	
		}
	}
		
	/** Get checked elements */
	public List<StructureDiagram> getCheckedDiagrams ()
	{	
		List<StructureDiagram> checkedNodes = new ArrayList<StructureDiagram>();
	    TreePath[] treepathList = getCheckingPaths();
	    	
	    for (TreePath treepath : treepathList) 
	    {	    	
	    	DefaultMutableTreeNode node = ((DefaultMutableTreeNode)treepath.getLastPathComponent());
	    	if (node.getUserObject() instanceof StructureDiagram)
	    		checkedNodes.add(((StructureDiagram)node.getUserObject()));	    		    	
	    }
	    
	    return checkedNodes;
	}
	
	/** Get Unchecked Elements. */
	public List<StructureDiagram> getUncheckedDiagrams ()
	{
		List<StructureDiagram> result = new ArrayList<StructureDiagram>();
		if(diagrams!=null) result.addAll(diagrams);
		result.removeAll(getCheckedDiagrams());
		return result;
	}
	
	/** Check Node. */
	@SuppressWarnings({ "rawtypes", "unused" })
	protected void checkNode(DefaultMutableTreeNode node, boolean uncheckChildren)
	{			
		if(node.getUserObject() instanceof StructureDiagram || getRootNode().equals(node))
		{
			addCheckingPath(new TreePath(node.getPath()));	

			//uncheck children
	    	if(uncheckChildren && node.getChildCount()>0) 
	    	{
	    		EObject childObject;
				Enumeration e = node.breadthFirstEnumeration();
				DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)e.nextElement();				
				while (e.hasMoreElements()) 
		    	{			
					if(childNode.getUserObject() instanceof RefOntoUMLElement){
						super.checkNode(node, uncheckChildren);
					}					
					childNode = (DefaultMutableTreeNode)e.nextElement();
				}
	    	}			
		}
		else if(node.getUserObject() instanceof RefOntoUMLElement) {
			super.checkNode(node, uncheckChildren);
		}		
	}
	
	/** Uncheck Node. */
	@SuppressWarnings({ "rawtypes", "unused" })
	protected void uncheckNode(DefaultMutableTreeNode node, boolean checkChildren)
	{		
		if(node.getUserObject() instanceof StructureDiagram || getRootNode().equals(node))
		{
			removeCheckingPath(new TreePath(node.getPath()));

			//check children
	    	if(checkChildren && node.getChildCount()>0) 
	    	{
	    		EObject childObject;
				Enumeration e = node.breadthFirstEnumeration();
				DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)e.nextElement();				
				while (e.hasMoreElements()) 
		    	{					
					if(childNode.getUserObject() instanceof RefOntoUMLElement){
						super.uncheckNode(childNode, checkChildren);
					}
					childNode = (DefaultMutableTreeNode)e.nextElement();
				}
	    	}
		}
		else if(node.getUserObject() instanceof RefOntoUMLElement) {
			super.uncheckNode(node, checkChildren);
		}
	}	
}
