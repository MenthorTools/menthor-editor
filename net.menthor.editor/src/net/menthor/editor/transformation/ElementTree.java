package net.menthor.editor.transformation;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Association;
import RefOntoUML.Comment;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import RefOntoUML.Package;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.OntoUMLElement;

public class ElementTree extends CheckboxTree {

	private static final long serialVersionUID = 1L;
	
	protected OntoUMLParser refparser;
	protected ElementVisibilityOption opt;
	
	protected DefaultMutableTreeNode modelRootNode;		
	protected DefaultTreeModel treeModel;
	protected TreeCheckingModel checkingModel;
	
	public OntoUMLParser getParser() { return refparser; }
	
	/** Create an instance of the filter tree */
	public static ElementTree createFilter(OntoUMLParser refparser, ElementVisibilityOption opt)
	{
		return new ElementTree(
			new DefaultMutableTreeNode(new OntoUMLElement(refparser.getModel(),"")), 
			refparser,
			opt
		);
	}
	
	public static ElementTree createFilter(OntoUMLParser refparser, boolean hideDataTypes, ElementVisibilityOption opt)
	{
		if(hideDataTypes) opt.hideDataTypes();
		ElementTree filter = createFilter(refparser, opt);
		return filter;
	}

	protected ElementTree(DefaultMutableTreeNode rootNode)
	{
		super(rootNode);
		this.modelRootNode = rootNode;
		this.treeModel = new DefaultTreeModel(rootNode);
		setModel(treeModel);
		getCheckingModel().setCheckingMode(TreeCheckingModel.CheckingMode.PROPAGATE);			
		checkingModel = getCheckingModel();		
	}
	
	/**Constructor */
	private ElementTree (DefaultMutableTreeNode rootNode, OntoUMLParser refparser, ElementVisibilityOption opt)
	{	
		this(rootNode);		
		this.refparser=refparser;		
		this.opt=opt;
		
		FilterCellRenderer cellRenderer = new FilterCellRenderer();
		setCellRenderer(cellRenderer);
		
		draw(modelRootNode, refparser.getModel(), checkingModel, refparser);	
					
		addCheckingPath(new TreePath(modelRootNode.getPath()));		
		expandPath(new TreePath(modelRootNode.getPath()));
	}	

	/** Remove all nodes except the root node. */
    protected void clear() 
    {
    	modelRootNode.removeAllChildren();
        treeModel.reload();
    }    
    
    protected void resetSelection()
    {
    	
    }
    
    /** Get the selected node from the tree */
    protected DefaultMutableTreeNode getSelectedNode()
    {
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
    protected DefaultMutableTreeNode addElement(Object child) 
    {    		
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = getSelectionPath(); 
        if (parentPath == null) 
        {
            parentNode = modelRootNode;
        } else {
            parentNode = (DefaultMutableTreeNode)(parentPath.getLastPathComponent());
        } 
        return addElement(parentNode, child, true);
    }    
       
    /** Get the node of this element */
    @SuppressWarnings("rawtypes")
    protected DefaultMutableTreeNode getNode(EObject eobject)
    {	
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	if(node.getUserObject() instanceof OntoUMLElement){
	    		EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    		if (obj.equals(eobject)) return node;	    		
	    	}	    		
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element
	    if(node.getUserObject() instanceof OntoUMLElement){
	    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    	if (obj.equals(eobject)) return node;	
	    }	  
	    return null;
    }
    
    protected DefaultMutableTreeNode addElement(DefaultMutableTreeNode parent, Object child) 
    {
    	return addElement(parent, child, false);
    }
    
    /** Add element to the filter */
    protected DefaultMutableTreeNode addElement(DefaultMutableTreeNode parent, Object child, boolean shouldBeVisible) 
    {
    	if(child instanceof EObject){
    		DefaultMutableTreeNode node = getNode((EObject)child);
    		if(node!=null) return node;
    	}
    	
		DefaultMutableTreeNode childNode = createNode(child);		
		if (parent == null) parent = modelRootNode;				
		//It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
		treeModel.insertNodeInto(childNode, parent, parent.getChildCount());		
		//Make sure the user can see the lovely new node.
		if (shouldBeVisible) scrollPathToVisible(new TreePath(childNode.getPath()));		
		return childNode;
    }
    
    /** Get the root node from the tree */
    protected DefaultMutableTreeNode getRootNode()
	{
		return modelRootNode;
	}
			
	/** Create a node to the tree*/
    protected DefaultMutableTreeNode createNode(Object object)
	{
		if (object instanceof RefOntoUML.Package || object instanceof RefOntoUML.Generalization || object instanceof RefOntoUML.GeneralizationSet || object instanceof RefOntoUML.Comment || object instanceof RefOntoUML.Constraintx) 
		{		
			return new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),""));
			
		}else if (object instanceof RefOntoUML.EnumerationLiteral){
			
			String alias = new String();				
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.EnumerationLiteral)object);
			else alias = "";		
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));
			checkingModel.setPathEnabled(new TreePath(node.getPath()),false);
			return node; 
					
		}else if ((object instanceof RefOntoUML.Property))
		{	
			String alias = new String();				
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Property)object);
			else alias = "";		
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));
			if(((RefOntoUML.Property)object).getAssociation()!=null) checkingModel.setPathEnabled(new TreePath(node.getPath()),false);				
			return node;
			
		}else if(object instanceof RefOntoUML.Classifier)
		{
			String alias = new String();				
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
			else alias = "";		
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));
				
			if (object instanceof RefOntoUML.Class)
			{				
				for (Property o: ((RefOntoUML.Class)object).getOwnedAttribute())
				{
					if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
					else alias = "";		
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)o),alias));
					node.add(child);
				}			
				for (Comment o: ((RefOntoUML.Class)object).getOwnedComment())
				{
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)o),""));
					node.add(child);
				}
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization())
				{
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)g),""));
					node.add(child);				
				}
			}		
			
			if (object instanceof RefOntoUML.DataType)
			{				
				for (Property o: ((RefOntoUML.DataType)object).getOwnedAttribute())
				{
					if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
					else alias = "";		
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)o),alias));
					node.add(child);
				}			
				for (Comment o: ((RefOntoUML.DataType)object).getOwnedComment())
				{
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)o),""));
					node.add(child);
				}
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization())
				{
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)g),""));
					node.add(child);				
				}
				
				if(object instanceof RefOntoUML.Enumeration){
					
					for(EnumerationLiteral lit: ((RefOntoUML.Enumeration)object).getOwnedLiteral())
					{
						DefaultMutableTreeNode child = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)lit),""));
						node.add(child);
					}
				}
			}		
			
			if (object instanceof RefOntoUML.Association){
				for (RefOntoUML.Property o: ((RefOntoUML.Association)object).getMemberEnd())
				{
					if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
					else alias = "";		
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)o),alias));
					node.add(child);					
					checkingModel.setPathEnabled(new TreePath(child.getPath()),false);					
				}
				for (Comment o: ((RefOntoUML.Association)object).getOwnedComment())
				{
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)o),""));
					node.add(child);
				}
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization())
				{
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)g),""));
					node.add(child);				
				}
			}
			
			return node;
		}else{
			return new DefaultMutableTreeNode(object);
		}
	}
	
	/** Draw */	
    protected void draw(DefaultMutableTreeNode parent, Object object,TreeCheckingModel checkingModel,OntoUMLParser refparser) 
	{		
		/* Model */
		if (object instanceof RefOntoUML.Model) 
		{
			EList<EObject> contents = ((EObject)object).eContents();
			for (EObject eobj : contents) 
			{
				draw(parent, (RefOntoUML.Element) eobj,checkingModel,refparser);
			}
			
		/* Package */
		} else if (object instanceof RefOntoUML.Package) 
		{
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),""));
			parent.add(newNode);
			expandPath(new TreePath(newNode.getPath()));
			
			EList<EObject> contents = ((EObject)object).eContents();
			for (EObject eobj : contents) 
			{
				draw(newNode, (RefOntoUML.Element) eobj,checkingModel,refparser);
			}
		
		/* Classifier */
		} else if (object instanceof RefOntoUML.Classifier)		
		{
			String alias = new String();
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
			else alias = "";
						
			//modelTree.collapsePath(new TreePath(newNode.getPath()));
				
			if (object instanceof RefOntoUML.Class && !opt.isHiddenClasses())
			{	
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);	
			
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization())
				{
					draw(newNode,g,checkingModel,refparser);
				}
				for (Property o: ((RefOntoUML.Class)object).getOwnedAttribute())
				{
					draw(newNode,o,checkingModel,refparser);
				}			
				for (Comment o: ((RefOntoUML.Class)object).getOwnedComment())
				{
					draw(newNode,o,checkingModel,refparser);
				}
			}		
			
			if (object instanceof RefOntoUML.DataType && !opt.isHiddenDataTypes())
			{	
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);	
				
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization())
				{
					draw(newNode,g,checkingModel,refparser);
				}
				for (Property o: ((RefOntoUML.DataType)object).getOwnedAttribute())
				{
					draw(newNode,o,checkingModel,refparser);
				}			
				for (Comment o: ((RefOntoUML.DataType)object).getOwnedComment())
				{
					draw(newNode,o,checkingModel,refparser);
				}
				if(object instanceof RefOntoUML.Enumeration){
					
					for(EnumerationLiteral lit: ((RefOntoUML.Enumeration)object).getOwnedLiteral())
					{
						draw(newNode,lit,checkingModel,refparser);
					}
				}
			}		
			
			if (object instanceof RefOntoUML.Association && !opt.isHiddenAssociations())
			{	
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);	
				
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization())
				{
					draw(newNode,g,checkingModel,refparser);
				}
				for (RefOntoUML.Property o: ((RefOntoUML.Association)object).getMemberEnd())
				{
					draw(newNode,o,checkingModel,refparser);
				}
				for (Comment o: ((RefOntoUML.Association)object).getOwnedComment())
				{
					draw(newNode,o,checkingModel,refparser);
				}
			}
		
		/* GeneralizationSet */
		}else if (object instanceof RefOntoUML.GeneralizationSet)
		{
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),""));			
			parent.add(newNode);
			
		/* Generalization */
		} else if (object instanceof RefOntoUML.Generalization && !opt.isHiddenGeneralizations())
		{
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),""));			
			parent.add(newNode);			
							
		}else if (object instanceof RefOntoUML.Comment)
		{
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),""));			
			parent.add(newNode);	
		
		}else if (object instanceof RefOntoUML.EnumerationLiteral)
		{				
			String alias = new String();			
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.EnumerationLiteral)object);
			else alias = "";		
			
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));
			parent.add(newNode);
			checkingModel.setPathEnabled(new TreePath(newNode.getPath()),false);			
		
		/* Property */
		}else if (object instanceof RefOntoUML.Property && !opt.isHiddenProperties())
		{
			String alias = new String();
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Property)object);
			else alias = "";
			
			if(((RefOntoUML.Property)object).getAssociation()!=null && !opt.isHiddenEnds())
			{
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);
				checkingModel.setPathEnabled(new TreePath(newNode.getPath()),true);	
			
			}else if (((RefOntoUML.Property)object).getAssociation()==null && !opt.isHiddenAttributes())
			{
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);
				checkingModel.setPathEnabled(new TreePath(newNode.getPath()),true);
			}
							
		}else if (object instanceof RefOntoUML.Constraintx)
		{
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),""));			
			parent.add(newNode);
		}
	}
		
	/** Get checked elements */
    protected List<EObject> getCheckedElements ()
	{		
		List<EObject> checkedNodes = new ArrayList<EObject>();
	    TreePath[] treepathList = getCheckingPaths();
	    	
	    for (TreePath treepath : treepathList) 
	    {	    	
	    	DefaultMutableTreeNode node = ((DefaultMutableTreeNode)treepath.getLastPathComponent());
	    	if (node.getUserObject() instanceof OntoUMLElement)
	    		checkedNodes.add(((OntoUMLElement)node.getUserObject()).getElement());	    		    	
	    }
		    	
	    return checkedNodes;
	}
	
	/** Get Unchecked Elements. */
    protected List<EObject> getUncheckedElements ()
	{
		List<EObject> uncheckedNodes = new ArrayList<EObject>();
		List<EObject> checkedNodes = new ArrayList<EObject>();
	    TreePath[] treepathList = getCheckingPaths();
	    	
	    for (TreePath treepath : treepathList) 
	    {	    	
	    	DefaultMutableTreeNode node = ((DefaultMutableTreeNode)treepath.getLastPathComponent());
	    	if (node.getUserObject() instanceof OntoUMLElement)
	    		checkedNodes.add(((OntoUMLElement)node.getUserObject()).getElement());	    		    	
	    }
		    
		OntoUMLElement rootObject = (OntoUMLElement) modelRootNode.getUserObject();
	    	    
		initUncheckeNodes(rootObject.getElement(), checkedNodes, uncheckedNodes);
    	    	
	    return uncheckedNodes;
	}
	
    /** Initialize Unchecked Nodes. */
	protected void initUncheckeNodes(EObject element, List<EObject> checkedElements,List<EObject> uncheckedElements) 
	{    	
    	if (element == null) return;    	
    	
    	Object[] elemArray = element.eContents().toArray();
		for (Object obj : elemArray) 
		{
			initUncheckeNodes((EObject)obj, checkedElements, uncheckedElements);
		}
    	
    	if (!checkedElements.contains(element)) 
    	{
    		if (element instanceof Package) 
    		{    			
    			// nothing to do in this case...
    		} else {    			
    			uncheckedElements.add(element);    			
    		}
    	}	
    }
	
	/** Check Node. */
	@SuppressWarnings({ "rawtypes", "unused" })
	protected void checkNode(DefaultMutableTreeNode node, boolean uncheckChildren)
	{		
		EObject childObject;		
		addCheckingPath(new TreePath(node.getPath()));		
		
		Object userobj = node.getUserObject();
		Object obj=null;
		if (userobj instanceof OntoUMLElement) obj = ((OntoUMLElement)userobj).getElement();
		
		//unselected children only if was different than Association
    	if(uncheckChildren && obj!=null && node.getChildCount()>0 && !(obj instanceof Association)) 
    	{
			Enumeration e = node.breadthFirstEnumeration();
			DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)e.nextElement();				
			while (e.hasMoreElements()) 
	    	{
				childNode = (DefaultMutableTreeNode)e.nextElement();
				if(childNode.getUserObject() instanceof OntoUMLElement)
				{
					childObject = ((OntoUMLElement)childNode.getUserObject()).getElement();		    		
					getCheckingModel().removeCheckingPath(new TreePath(childNode.getPath()));
				}
			}
    	}
	}
	
	/** Uncheck Node. */
	@SuppressWarnings({ "rawtypes", "unused" })
	protected void uncheckNode(DefaultMutableTreeNode node, boolean checkChildren)
	{		
		EObject childObject;		
		removeCheckingPath(new TreePath(node.getPath()));		
		
		Object userobj = node.getUserObject();
		Object obj=null;
		if (userobj instanceof OntoUMLElement) obj = ((OntoUMLElement)userobj).getElement();
		
		//unselected children only if was different than Association
    	if(checkChildren && obj!=null && node.getChildCount()>0 && !(obj instanceof Association)) 
    	{
			Enumeration e = node.breadthFirstEnumeration();
			DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)e.nextElement();		
			
			while (e.hasMoreElements()) 
	    	{
				childNode = (DefaultMutableTreeNode)e.nextElement();
				if(childNode.getUserObject() instanceof OntoUMLElement){
					childObject = ((OntoUMLElement)childNode.getUserObject()).getElement();		    		
					getCheckingModel().addCheckingPath(new TreePath(childNode.getPath()));
				}
			}
    	}
	}
	
	/** Check Element */
	@SuppressWarnings("rawtypes")
	protected boolean checkElement(EObject element)
	{	
		boolean result = false;
		EObject rootEObj = ((OntoUMLElement)modelRootNode.getUserObject()).getElement();
		if (rootEObj.equals(element)) { result=true; select(modelRootNode); return result; }
		
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	if(node.getUserObject() instanceof OntoUMLElement){
		    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
		    	if (obj.equals(element)) { 
		    		result =true;		    		
		    		this.setSelectionPath(new TreePath(node.getPath()));
		    		this.scrollPathToVisible(new TreePath(node.getPath()));			    		
		    		return result;
		    	}
	    	}	    		
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element
	    if(node.getUserObject() instanceof OntoUMLElement){
		    EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
		    if (obj.equals(element)){ 
		    	result =true;
		    	
		    	this.setSelectionPath(new TreePath(node.getPath()));
		    	this.scrollPathToVisible(new TreePath(node.getPath())); 
		    	
		    	return result;
		    }	    
	    }
	    return result;	    
	}
	
	/** Select node */
	protected void select (DefaultMutableTreeNode  node)
	{
		this.setSelectionPath(new TreePath(node.getPath()));
		this.scrollPathToVisible(new TreePath(node.getPath()));		
	}
		
	/** Find Node */
	@SuppressWarnings("rawtypes")
	protected ArrayList<DefaultMutableTreeNode> findName(String elementName)
	{		
		ArrayList<DefaultMutableTreeNode> list = new ArrayList<DefaultMutableTreeNode>();
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	if(node.getUserObject() instanceof OntoUMLElement)
	    	{
	    		OntoUMLElement obj = ((OntoUMLElement)node.getUserObject());		    		    		
		    	if(obj.getName()!=null && !obj.getName().isEmpty()){
				   	if (obj.getName().contains(elementName) || obj.getName().equalsIgnoreCase(elementName)) {			    		
				   		list.add(node);			    		
				   	}
		    	}		    	
	    	}
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element
	    if(node.getUserObject() instanceof OntoUMLElement){
	    	OntoUMLElement obj = ((OntoUMLElement)node.getUserObject());		        		
    		if(obj.getName()!=null && !obj.getName().isEmpty()){
		    	if (obj.getName().contains(elementName) || obj.getName().equalsIgnoreCase(elementName)) {		    		
		    		list.add(node);		    		
		    	}
    		}	    	
	    }
	    return list;
	}
	
	/** Check these elements. We do not concern with other elements*/
	@SuppressWarnings("rawtypes")
	protected void check(List<EObject> elements) 
	{			   
		List<EObject> alreadyChecked = getCheckedElements();		
	    
		alreadyChecked.removeAll(elements);
		alreadyChecked.addAll(elements);		
		
	    Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	if(node.getUserObject() instanceof OntoUMLElement){
		    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
		    	if (alreadyChecked.contains(obj)) { checkNode(node,true); }	    			
	    	}	    		    		
	    	node = (DefaultMutableTreeNode)e.nextElement();	    
	    }
	    //last element
	    if(node.getUserObject() instanceof OntoUMLElement){
		    EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
		    if (alreadyChecked.contains(obj)) { checkNode(node,true); }    	    	
	    }
	}	
	 
	/** Check these elements in the tree uncheking all others (packageable elements) and ignoring packages */
	@SuppressWarnings("rawtypes")
	protected void checkStrictly(List<EObject> elements) 
	{			   
	    Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	if(node.getUserObject() instanceof OntoUMLElement){
		    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
		    	if(!(obj instanceof RefOntoUML.Package)){
		    		if (elements.contains(obj)) { checkNode(node,true); }	    			
		    		else { uncheckNode(node,true); }
		    	}
	    	}	    	
	    	node = (DefaultMutableTreeNode)e.nextElement();	    
	    }
	    //last element
	    if(node.getUserObject() instanceof OntoUMLElement){
		    EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
		    if(!(obj instanceof RefOntoUML.Package)){
			    if (elements.contains(obj)) { checkNode(node,true); }  
			    else { uncheckNode(node,true); }
		    }
	    }
	}	
	
	/** Uncheck this elements */
	@SuppressWarnings("rawtypes")
	protected void uncheck(List<EObject> elements) 
	{			   
		List<EObject> alreadyUnchecked = getUncheckedElements();		
	    
		alreadyUnchecked.removeAll(elements);
		alreadyUnchecked.addAll(elements);		
		
	    Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	if(node.getUserObject() instanceof OntoUMLElement){
		    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
		    	if (alreadyUnchecked.contains(obj)) { uncheckNode(node,true); }
	    	}	    		    		
	    	node = (DefaultMutableTreeNode)e.nextElement();	    
	    }
	    //last element
	    if(node.getUserObject() instanceof OntoUMLElement){
		    EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
		    if (alreadyUnchecked.contains(obj)) { uncheckNode(node,true); }    	    	
	    }
	}	
}
