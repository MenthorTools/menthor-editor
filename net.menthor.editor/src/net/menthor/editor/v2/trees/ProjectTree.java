package net.menthor.editor.v2.trees;

/*
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

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Comment;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.NamedElement;
import RefOntoUML.PackageableElement;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;

public class ProjectTree extends BaseCheckBoxTree {

	private static final long serialVersionUID = 1L;
	
	protected TreeVisibility opt;
	
	protected OntoUMLParser refparser;
	public OntoUMLParser getParser(){ return refparser;}
		
	//==========================================================
    // STATIC CONSTRUCTORS
	//==========================================================
	
	public static ProjectTree create(CommandListener listener, OntoUMLParser refparser, List<OclDocument> oclDocList, List<OntoumlDiagram> diagrams, TreeVisibility opt, boolean useCheckbox)
	{
		if(refparser!=null) return new ProjectTree(listener, new DefaultMutableTreeNode(refparser.getModel()), refparser, oclDocList, diagrams, opt, useCheckbox);
		else return null;		
	}
	
	public static ProjectTree createPackageableTree(CommandListener listener,OntoUMLParser refparser, List<OclDocument> oclDocList, List<OntoumlDiagram> diagrams)
	{	
		TreeVisibility opt = new TreeVisibility();
		opt.showOnlyPackageable();
		ProjectTree tree = create(listener,refparser, oclDocList, diagrams, opt, false);
		
		return tree;
	}
	
	public static ProjectTree create(CommandListener listener,OntoUMLParser refparser, TreeVisibility opt, boolean useCheckbox)
	{		
		ProjectTree tree = create(listener,refparser, null, null, opt,useCheckbox);
		return tree;
	}
	
	public static ProjectTree createPackageableTree(CommandListener listener,OntoUMLParser refparser)
	{	
		TreeVisibility opt = new TreeVisibility();
		opt.showOnlyPackageable();
		ProjectTree tree = create(listener, refparser, null, null, opt, false);
		return tree;
	}
	
	//==========================================================
    // CONSTRUCTOR
	//==========================================================
		
	protected ProjectTree (DefaultMutableTreeNode rootNode){
		super(rootNode);
	}
	    
	protected ProjectTree (final CommandListener listener, DefaultMutableTreeNode rootNode, OntoUMLParser refparser, List<OclDocument> oclDocList, List<OntoumlDiagram> diagrams, TreeVisibility opt, boolean useCheckbox){
		
		super(rootNode);		
		this.opt=opt;		
		this.refparser=refparser;
		TreeCellRenderer cellRenderer = new TreeCellRenderer(useCheckbox);
		setCellRenderer(cellRenderer);		
		drawElements(modelRootNode, rootNode.getUserObject());
		if(diagrams!=null) drawDiagrams(diagrams);
		if(oclDocList!=null) drawRules(oclDocList);
		addCheckingPath(new TreePath(modelRootNode.getPath()));		
		expandPath(new TreePath(modelRootNode.getPath()));	
		addTreeSelectionListener(new TreeSelectionListener() {			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
				if(node!=null && node.getUserObject()!=null && (node.getUserObject() instanceof OntoumlDiagram || node.getUserObject() instanceof OclDocument)){
					listener.handleCommand(CommandType.SELECT_TAB.toString(),node.getUserObject());		
				}
			}			
		});
	}	
	
	//==========================================================
	// DRAW TREE
	//==========================================================
	
    protected void drawRules(List<OclDocument> oclDocList)
    {    			
		for(OclDocument c: oclDocList){
			PackageableElement refContainer = (PackageableElement)c.getContainer();
			DefaultMutableTreeNode parent = getNode(refContainer);
			DefaultMutableTreeNode newNode = createNode(c);			
			if(parent!=null)parent.add(newNode);
			else modelRootNode.add(newNode);
		}		
    }
    
    protected void drawDiagrams(List<OntoumlDiagram> diagrams)
    {
		for(OntoumlDiagram c: diagrams){						
			PackageableElement refContainer = (PackageableElement)c.getContainer();
			DefaultMutableTreeNode parent = getNode(refContainer);
			DefaultMutableTreeNode newNode = createNode(c);			
			if(parent!=null)parent.add(newNode);
			else modelRootNode.add(newNode);
		}		
    }
    
    protected void drawElements(DefaultMutableTreeNode parent, Object object)
    {    	
		/* Model */
		if (object instanceof RefOntoUML.Model){
			EList<EObject> contents = ((EObject)object).eContents();
			for (EObject eobj : contents){
				ProjectTree.this.drawElements(parent, eobj);
			}
		}
		
		/* Package */
		else if (object instanceof RefOntoUML.Package){
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);
			parent.add(newNode);
			expandPath(new TreePath(newNode.getPath()));
			EList<EObject> contents = ((EObject)object).eContents();
			for (EObject eobj : contents){
				ProjectTree.this.drawElements(newNode,eobj);
			}		
		}
		
		/* GeneralizationSet */
		else if (object instanceof RefOntoUML.GeneralizationSet && !opt.isHiddenGeneralizationSets()) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);			
			parent.add(newNode);	
		}
		
		/* Generalization */
		else if (object instanceof RefOntoUML.Generalization && !opt.isHiddenGeneralizations()){
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);			
			parent.add(newNode);					
		}
		
		/* Comment */
		else if (object instanceof RefOntoUML.Comment && !opt.isHiddenComments()){
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);			
			parent.add(newNode);			
		}
		
		/* EnumerationLiteral */
		else if (object instanceof RefOntoUML.EnumerationLiteral && !opt.isHiddenLiterals()){					
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);
			parent.add(newNode);
			checkingModel.setPathEnabled(new TreePath(newNode.getPath()),false);	
		}
		
		/* Property */
		else if (object instanceof RefOntoUML.Property && !opt.isHiddenProperties()) {
			
			if(((RefOntoUML.Property)object).getAssociation()!=null && !opt.isHiddenEnds()){
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);			
				parent.add(newNode);
				checkingModel.setPathEnabled(new TreePath(newNode.getPath()),true);				
			}
			
			else if (((RefOntoUML.Property)object).getAssociation()==null && !opt.isHiddenAttributes()){
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);			
				parent.add(newNode);
				checkingModel.setPathEnabled(new TreePath(newNode.getPath()),true);
			}		
		}
		
		/* Constraintx */
		else if (object instanceof RefOntoUML.Constraintx && !opt.isHiddenConstraints()) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);			
			parent.add(newNode);	
		}
		
		/* Classifier */
		else if (object instanceof RefOntoUML.Classifier){
			
			/* Class */
			if (object instanceof RefOntoUML.Class && !opt.isHiddenClasses()){	
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);			
				parent.add(newNode);
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					if(!opt.isHiddenGeneralizations()) ProjectTree.this.drawElements(newNode,g);
				}
				for (Property o: ((RefOntoUML.Class)object).getOwnedAttribute()){
					if(!opt.isHiddenAttributes()) ProjectTree.this.drawElements(newNode,o);
				}			
				for (Comment o: ((RefOntoUML.Class)object).getOwnedComment()){
					if(!opt.isHiddenComments()) ProjectTree.this.drawElements(newNode,o);
				}
			}		
			
			/* DataType */
			if (object instanceof RefOntoUML.DataType && !opt.isHiddenDataTypes()){	
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);			
				parent.add(newNode);					
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					if(!opt.isHiddenGeneralizations()) ProjectTree.this.drawElements(newNode,g);
				}
				for (Property o: ((RefOntoUML.DataType)object).getOwnedAttribute()){
					if(!opt.isHiddenAttributes()) ProjectTree.this.drawElements(newNode,o);
				}			
				for (Comment o: ((RefOntoUML.DataType)object).getOwnedComment()){
					if(!opt.isHiddenComments()) ProjectTree.this.drawElements(newNode,o);
				}
				if(object instanceof RefOntoUML.Enumeration){					
					for(EnumerationLiteral lit: ((RefOntoUML.Enumeration)object).getOwnedLiteral()){
						ProjectTree.this.drawElements(newNode,lit);
					}
				}
			}
			
			/* Association */
			if (object instanceof RefOntoUML.Association && !opt.isHiddenAssociations()){	
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(object);			
				parent.add(newNode);					
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization())	{
					if(!opt.isHiddenGeneralizations()) ProjectTree.this.drawElements(newNode,g);
				}
				for (RefOntoUML.Property o: ((RefOntoUML.Association)object).getMemberEnd()){
					if(!opt.isHiddenEnds()) ProjectTree.this.drawElements(newNode,o);
				}
				for (Comment o: ((RefOntoUML.Association)object).getOwnedComment()){
					if(!opt.isHiddenComments()) ProjectTree.this.drawElements(newNode,o);
				}
			}
		}		
    }
    
	//==========================================================
    // CREATE NODE
	//==========================================================
    
	@Override
    public DefaultMutableTreeNode createNode(Object object)
    {		
		/* Generalization or Comment */
		if(object instanceof RefOntoUML.Generalization || object instanceof RefOntoUML.Comment){
			return new DefaultMutableTreeNode(object);	
		}
			
		/* Enumeration Literal */
		else if (object instanceof RefOntoUML.EnumerationLiteral){			
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(object);
			checkingModel.setPathEnabled(new TreePath(node.getPath()),false);
			return node; 					
		}
		
		/* Property */
		else if ((object instanceof RefOntoUML.Property)){		
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(object);
			if(((RefOntoUML.Property)object).getAssociation()!=null) checkingModel.setPathEnabled(new TreePath(node.getPath()),false);				
			return node;
		}
		
		/* Classifier */
		else if(object instanceof RefOntoUML.Classifier){			
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(object);			
			
			/* Class: Attributes, Comments and Generalizations */
			if (object instanceof RefOntoUML.Class){				
				for (Property o: ((RefOntoUML.Class)object).getOwnedAttribute()){					
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(o);
					node.add(child);
				}			
				for (Comment o: ((RefOntoUML.Class)object).getOwnedComment()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(o);
					node.add(child);
				}
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(g);
					node.add(child);
				}
			}			
			/* DataType: Attributes, Comments and Generalizations */
			if (object instanceof RefOntoUML.DataType){				
				for (Property o: ((RefOntoUML.DataType)object).getOwnedAttribute()){					
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(o);
					node.add(child);
				}			
				for (Comment o: ((RefOntoUML.DataType)object).getOwnedComment()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(o);
					node.add(child);
				}
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(g);
					node.add(child);				
				}				
				if(object instanceof RefOntoUML.Enumeration){					
					for(EnumerationLiteral lit: ((RefOntoUML.Enumeration)object).getOwnedLiteral()){
						DefaultMutableTreeNode child = new DefaultMutableTreeNode(lit);
						node.add(child);
					}
				}
			}			
			
			/* Association: Properties, Comments and Generalizations */
			if (object instanceof RefOntoUML.Association){
				for (RefOntoUML.Property o: ((RefOntoUML.Association)object).getMemberEnd()){					
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(o);
					node.add(child);
					checkingModel.setPathEnabled(new TreePath(child.getPath()),false);					
				}
				for (Comment o: ((RefOntoUML.Association)object).getOwnedComment()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(o);
					node.add(child);
				}
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(g);
					node.add(child);				
				}
			}
			
			return node;
		}
		
		else{
			if(object instanceof PackageableElement) return super.createNode(object);
			return null;
		}
	}
        
	//==========================================================
    // REMOVE OBJECT
	//==========================================================
	
    public void remove(RefOntoUML.Element deletedElement){		
    	
    	/* Generalization */
		if(deletedElement instanceof Generalization){
			checkElement(deletedElement);						
			removeCurrentNode();
			for(GeneralizationSet genSet: ((Generalization)deletedElement).getGeneralizationSet()){
				if(genSet.getGeneralization().size()==1 && genSet.getGeneralization().get(0).equals(deletedElement)) { checkElement(genSet); removeCurrentNode(); }
				if(genSet.getGeneralization().size()==0) { checkElement(genSet); removeCurrentNode(); }
			}
			return;
		}		
		checkElement(deletedElement);		
		removeCurrentNode();				
	}    

    //==========================================================
    // FIND 
	//==========================================================
    
    /** Find Node */
	@SuppressWarnings("rawtypes")
	public ArrayList<DefaultMutableTreeNode> findName(String name)
	{		
		ArrayList<DefaultMutableTreeNode> list = new ArrayList<DefaultMutableTreeNode>();
		Enumeration e = modelRootNode.breadthFirstEnumeration();
	    DefaultMutableTreeNode  node = (DefaultMutableTreeNode)e.nextElement();
	    while (e.hasMoreElements()) {	    	
	    	Object obj = ((Object)node.getUserObject());	
    		if(obj instanceof NamedElement){
    			NamedElement namedElem = (NamedElement)obj;
		    	if(namedElem.getName()!=null && !namedElem.getName().isEmpty()){
				   	if (namedElem.getName().contains(name) || namedElem.getName().equalsIgnoreCase(name)) {			    		
				   		list.add(node);			    		
				   	}
		    	}	    	
    		}
	    	node = (DefaultMutableTreeNode)e.nextElement();
	    }
	    //last element
	    Object obj = ((Object)node.getUserObject());	
		if(obj instanceof NamedElement){
			NamedElement namedElem = (NamedElement)obj;        		
    		if(namedElem.getName()!=null && !namedElem.getName().isEmpty()){
		    	if (namedElem.getName().contains(name) || namedElem.getName().equalsIgnoreCase(name)) {		    		
		    		list.add(node);		    		
		    	}
    		}	    	
	    }
	    return list;
	}
}
