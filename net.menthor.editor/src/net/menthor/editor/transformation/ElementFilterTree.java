package net.menthor.editor.transformation;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import net.menthor.editor.explorer.OntoUMLElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Association;
import RefOntoUML.Comment;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import RefOntoUML.Package;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;

public class ElementFilterTree extends CheckboxTree {

	private static final long serialVersionUID = 1L;
	
	public OntoUMLParser refparser;		
	public DefaultMutableTreeNode modelRootNode;		
	private DefaultTreeModel treeModel;
	private TreeCheckingModel checkingModel;
	
	private boolean disableClasses=false;
	private boolean disableDataTypes=false;
	private boolean disableAssociations=false;
	private boolean disableAttributes=false;
	private boolean disableEnds=false;
	private boolean disableProperties=false;
	private boolean disableGeneralizations=false;
	
	/** Create an instance of the filter tree */
	public static ElementFilterTree createFilter(OntoUMLParser refparser)
	{
		return new ElementFilterTree(
			new DefaultMutableTreeNode(new OntoUMLElement(refparser.getModel(),"")), 
			refparser
		);
	}
	
	public static ElementFilterTree createFilter(OntoUMLParser refparser, boolean disableDataTypes)
	{
		ElementFilterTree filter = createFilter(refparser);
		filter.disableDataTypes();
		return filter;
	}
	
	public void enableAll() 
	{ 
		disableClasses=false;
		disableDataTypes=false;
		disableAssociations=false;
		disableAttributes=false;
		disableEnds=false;
		disableProperties=false;
		disableGeneralizations=false;
	}
	public void disableClasses() { disableClasses=true; }
	public void disableDataTypes() { disableDataTypes=true; }
	public void disableAssociations() { disableAssociations=true; }
	public void disableAttributes() { disableAttributes=true; }
	public void disableEnds() { disableEnds=true; }
	public void diableProperties() { disableProperties=true; }
	public void disableGeneralizations() { disableGeneralizations=true; }
	
	/**Constructor */
	private ElementFilterTree (DefaultMutableTreeNode rootNode, OntoUMLParser refparser)
	{	
		super(rootNode);			
		this.refparser=refparser;
		this.modelRootNode = rootNode;		
		this.treeModel = new DefaultTreeModel(rootNode);
		setModel(treeModel);
		    
		getCheckingModel().setCheckingMode(TreeCheckingModel.CheckingMode.PROPAGATE);			
		checkingModel = getCheckingModel();
		
		ElementFilterRenderer cellRenderer = new ElementFilterRenderer();
		setCellRenderer(cellRenderer);
		
		draw(modelRootNode, refparser.getModel(), checkingModel, refparser);	
					
		addCheckingPath(new TreePath(modelRootNode.getPath()));		
		expandPath(new TreePath(modelRootNode.getPath()));
	}	

	/** Remove all nodes except the root node. */
    public void clear() 
    {
    	modelRootNode.removeAllChildren();
        treeModel.reload();
    }    
    
    public void resetSelection()
    {
    	
    }
    
    /** Get the selected node from the tree */
    public DefaultMutableTreeNode getSelectedNode()
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
    public DefaultMutableTreeNode addElement(Object child) 
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
	public DefaultMutableTreeNode getNode(EObject eobject)
    {	
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    	if (obj.equals(eobject)) { 
	    		return node;	    		
	    	}	    		
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element
	    EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    if (obj.equals(eobject)){ 
	    	return node;	
	    }	  
	    return null;
    }
    
    public DefaultMutableTreeNode addElement(DefaultMutableTreeNode parent, Object child) 
    {
    	return addElement(parent, child, false);
    }
    
    /** Add element to the filter */
    private DefaultMutableTreeNode addElement(DefaultMutableTreeNode parent, Object child, boolean shouldBeVisible) 
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
	public DefaultMutableTreeNode getRootNode()
	{
		return modelRootNode;
	}
			
	/** Create a node to the tree*/
	private DefaultMutableTreeNode createNode(Object object)
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
	private void draw(DefaultMutableTreeNode parent, Object object,TreeCheckingModel checkingModel,OntoUMLParser refparser) 
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
		
		/* Generalization */
		} else if (object instanceof RefOntoUML.Generalization && !disableGeneralizations)
		{
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),""));			
			parent.add(newNode);			
		
		/* GeneralizationSet */
		}else if (object instanceof RefOntoUML.GeneralizationSet)
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
		}else if (object instanceof RefOntoUML.Property && !disableProperties)
		{
			String alias = new String();
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Property)object);
			else alias = "";
			
			if(((RefOntoUML.Property)object).getAssociation()!=null && !disableEnds)
			{
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);
				checkingModel.setPathEnabled(new TreePath(newNode.getPath()),true);	
			
			}else if (((RefOntoUML.Property)object).getAssociation()==null && !disableAttributes)
			{
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);
				checkingModel.setPathEnabled(new TreePath(newNode.getPath()),true);
			}
							
		}else if (object instanceof RefOntoUML.Constraintx)
		{
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new OntoUMLElement(((EObject)object),""));			
			parent.add(newNode);
			
		/* Classifier */
		} else if (object instanceof RefOntoUML.Classifier)		
		{
			String alias = new String();
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
			else alias = "";
						
			//modelTree.collapsePath(new TreePath(newNode.getPath()));
				
			if (object instanceof RefOntoUML.Class && !disableClasses)
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
			
			if (object instanceof RefOntoUML.DataType && !disableDataTypes)
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
			
			if (object instanceof RefOntoUML.Association && !disableAssociations)
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
		}		
	}
		
	/** Get checked elements */
	public List<EObject> getCheckedElements ()
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
    	    	
	    return checkedNodes;
	}
	
	/** Get Unchecked Elements. */
	public List<EObject> getUncheckedElements ()
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
	
	/** Check Node. */
	@SuppressWarnings({ "rawtypes", "unused" })
	public void checkNode(DefaultMutableTreeNode node, boolean safe)
	{		
		EObject childObject;		
		addCheckingPath(new TreePath(node.getPath()));		
		
		Object userobj = node.getUserObject();
		Object obj=null;
		if (userobj instanceof OntoUMLElement) obj = ((OntoUMLElement)userobj).getElement();
		
		//unselected children only if was different than Association
    	if(safe && obj!=null && node.getChildCount()>0 && !(obj instanceof Association)) 
    	{
			Enumeration e = node.breadthFirstEnumeration();
			DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)e.nextElement();		
			
			while (e.hasMoreElements()) 
	    	{
				childNode = (DefaultMutableTreeNode)e.nextElement();
				childObject = ((OntoUMLElement)childNode.getUserObject()).getElement();		    		
				getCheckingModel().removeCheckingPath(new TreePath(childNode.getPath()));				
			}
    	}
	}
	
	/** Uncheck Node. */
	@SuppressWarnings({ "rawtypes", "unused" })
	public void uncheckNode(DefaultMutableTreeNode node, boolean safe)
	{		
		EObject childObject;		
		removeCheckingPath(new TreePath(node.getPath()));		
		
		Object userobj = node.getUserObject();
		Object obj=null;
		if (userobj instanceof OntoUMLElement) obj = ((OntoUMLElement)userobj).getElement();
		
		//unselected children only if was different than Association, Diagram or Project
    	if(safe && obj!=null && node.getChildCount()>0 && !(obj instanceof Association)) 
    	{
			Enumeration e = node.breadthFirstEnumeration();
			DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)e.nextElement();		
			
			while (e.hasMoreElements()) 
	    	{
				childNode = (DefaultMutableTreeNode)e.nextElement();
				childObject = ((OntoUMLElement)childNode.getUserObject()).getElement();		    		
				getCheckingModel().addCheckingPath(new TreePath(childNode.getPath()));				
			}
    	}
	}
	
	/** Check Element */
	@SuppressWarnings("rawtypes")
	public boolean checkElement(EObject element)
	{	
		boolean result = false;
		EObject rootEObj = ((OntoUMLElement)modelRootNode.getUserObject()).getElement();
		if (rootEObj.equals(element)) { result=true; select(modelRootNode); return result; }
		
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    	if (obj.equals(element)) { 
	    		result =true;
	    		
	    		this.setSelectionPath(new TreePath(node.getPath()));
	    		this.scrollPathToVisible(new TreePath(node.getPath())); 
		    		
	    		return result;
	    	}
	    		
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element
	    EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    if (obj.equals(element)){ 
	    	result =true;
	    	
	    	this.setSelectionPath(new TreePath(node.getPath()));
	    	this.scrollPathToVisible(new TreePath(node.getPath())); 
	    	
	    	return result;
	    }	    
	    return result;	    
	}
	
	/** Select node */
	public void select (DefaultMutableTreeNode  node)
	{
		this.setSelectionPath(new TreePath(node.getPath()));
		this.scrollPathToVisible(new TreePath(node.getPath()));		
	}
		
	/** Find Node */
	@SuppressWarnings("rawtypes")
	public ArrayList<DefaultMutableTreeNode> findName(String elementName)
	{		
		ArrayList<DefaultMutableTreeNode> list = new ArrayList<DefaultMutableTreeNode>();
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    	if (obj instanceof RefOntoUML.NamedElement){
	    		RefOntoUML.NamedElement namedElem = ((RefOntoUML.NamedElement)obj);	    		
	    		if(namedElem.getName()!=null && !namedElem.getName().isEmpty()){
			    	if (namedElem.getName().contains(elementName) || namedElem.getName().equalsIgnoreCase(elementName)) {			    		
			    		list.add(node);			    		
			    	}
	    		}
	    	}
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element
	    EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    if (obj instanceof RefOntoUML.NamedElement){
    		RefOntoUML.NamedElement namedElem = ((RefOntoUML.NamedElement)obj);    		
    		if(namedElem.getName()!=null && !namedElem.getName().isEmpty()){
		    	if (namedElem.getName().contains(elementName) || namedElem.getName().equalsIgnoreCase(elementName)) {		    		
		    		list.add(node);		    		
		    	}
    		}
    	}    
	    return list;
	}
	
	/** Check these elements. We do not concern with other elements*/
	@SuppressWarnings("rawtypes")
	public void check(List<EObject> elements) 
	{			   
		List<EObject> alreadyChecked = getCheckedElements();		
	    
		alreadyChecked.removeAll(elements);
		alreadyChecked.addAll(elements);		
		
	    Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    	if (alreadyChecked.contains(obj)) { checkNode(node,true); }	    			
	    		    		
	    	node = (DefaultMutableTreeNode)e.nextElement();	    
	    }
	    //last element
	    EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    if (alreadyChecked.contains(obj)) { checkNode(node,true); }    	    	
	}	
	 
	/** Check these elements in the tree uncheking all others (packageable elements) and ignoring packages */
	@SuppressWarnings("rawtypes")
	public void checkStrictly(List<EObject> elements) 
	{			   
	    Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    	if(!(obj instanceof RefOntoUML.Package)){
	    		if (elements.contains(obj)) { checkNode(node,true); }	    			
	    		else { uncheckNode(node,true); }
	    	}
	    	
	    	node = (DefaultMutableTreeNode)e.nextElement();	    
	    }
	    //last element
	    EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    if(!(obj instanceof RefOntoUML.Package)){
		    if (elements.contains(obj)) { checkNode(node,true); }  
		    else { uncheckNode(node,true); }
	    }		    
	}	
	
	/** Uncheck this elements */
	@SuppressWarnings("rawtypes")
	public void uncheck(List<EObject> elements) 
	{			   
		List<EObject> alreadyUnchecked = getUncheckedElements();		
	    
		alreadyUnchecked.removeAll(elements);
		alreadyUnchecked.addAll(elements);		
		
	    Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) 
	    {
	    	EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    	if (alreadyUnchecked.contains(obj)) { uncheckNode(node,true); }	    			
	    		    		
	    	node = (DefaultMutableTreeNode)e.nextElement();	    
	    }
	    //last element
	    EObject obj = ((OntoUMLElement)node.getUserObject()).getElement();
	    if (alreadyUnchecked.contains(obj)) { uncheckNode(node,true); }    	    	
	}	
	
	/** Initialize Unchecked Nodes. */
	private void initUncheckeNodes(EObject element, List<EObject> checkedElements,List<EObject> uncheckedElements) 
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
}
