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
import java.util.List;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.UmlDiagram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Comment;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLElement;

public class ElementTree extends BaseCheckBoxTree {

	private static final long serialVersionUID = 1L;
	
	protected OntoUMLParser refparser;
	public OntoUMLParser getParser() { return refparser; }
	
	protected List<OclDocument> oclDocList = new ArrayList<OclDocument>();
	public List<OclDocument> getOclDocuments() { return oclDocList; }
	
	protected ElementTreeVisibility opt;
		
	/** Create an instance of the tree */
	public static ElementTree createElementTree(OntoUMLParser refparser, List<OclDocument> oclDocList, ElementTreeVisibility opt, boolean checkboxVisible){
		if(refparser!=null){
			return new ElementTree(
				new DefaultMutableTreeNode(new RefOntoUMLElement(refparser.getModel(),"")), 
				refparser, oclDocList,
				opt, 
				checkboxVisible
			);
		}else{
			return null;
		}
	}
	
	/** Create an instance of the tree */
	public static ElementTree createElementTree(OntoUMLParser refparser, boolean hideDataTypes, ElementTreeVisibility opt, boolean checkboxVisible){
		if(hideDataTypes) opt.hideDataTypes();
		ElementTree tree = createElementTree(refparser, null, opt,checkboxVisible);
		return tree;
	}
	
	/**Constructor */
	protected ElementTree (DefaultMutableTreeNode rootNode){
		super(rootNode);
	}
	
	/**Constructor */
	private ElementTree (DefaultMutableTreeNode rootNode, OntoUMLParser refparser, List<OclDocument> oclDocList, ElementTreeVisibility opt, boolean checkboxVisible){	
		super(rootNode);		
		this.refparser=refparser;
		this.oclDocList=oclDocList;
		this.opt=opt;		
		TreeCellRenderer cellRenderer = new TreeCellRenderer(checkboxVisible);
		setCellRenderer(cellRenderer);		
		drawElement(modelRootNode, refparser.getModel(), checkingModel, refparser,oclDocList);					
		addCheckingPath(new TreePath(modelRootNode.getPath()));		
		expandPath(new TreePath(modelRootNode.getPath()));
	}	
	    
	/** Create a node to the tree*/
    public DefaultMutableTreeNode createNode(EObject object)
    {
    	/* Package, Generalization, GneralizationSet, Comment, Constraintx, UmlDiagram, OclDocument */
		if (object instanceof RefOntoUML.Package || object instanceof RefOntoUML.Generalization || 
		object instanceof RefOntoUML.GeneralizationSet || object instanceof RefOntoUML.Comment || 
		object instanceof RefOntoUML.Constraintx || object instanceof UmlDiagram || object instanceof OclDocument)
		{		
			return new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),""));
			
		/* Enumeration Literal */
		}else if (object instanceof RefOntoUML.EnumerationLiteral){			
			String alias = new String();				
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.EnumerationLiteral)object);
			else alias = "";		
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),alias));
			checkingModel.setPathEnabled(new TreePath(node.getPath()),false);
			return node; 					
			
		/* Property */
		}else if ((object instanceof RefOntoUML.Property)){	
			String alias = new String();				
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Property)object);
			else alias = "";		
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),alias));
			if(((RefOntoUML.Property)object).getAssociation()!=null) checkingModel.setPathEnabled(new TreePath(node.getPath()),false);				
			return node;
			
		/* Classifier */
		}else if(object instanceof RefOntoUML.Classifier){
			String alias = new String();				
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
			else alias = "";		
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),alias));
			
			/* Class */
			if (object instanceof RefOntoUML.Class){				
				for (Property o: ((RefOntoUML.Class)object).getOwnedAttribute()){
					if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
					else alias = "";		
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)o),alias));
					node.add(child);
				}			
				for (Comment o: ((RefOntoUML.Class)object).getOwnedComment()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)o),""));
					node.add(child);
				}
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)g),""));
					node.add(child);				
				}
			}			
			
			/* DataType */
			if (object instanceof RefOntoUML.DataType){				
				for (Property o: ((RefOntoUML.DataType)object).getOwnedAttribute()){
					if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
					else alias = "";		
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)o),alias));
					node.add(child);
				}			
				for (Comment o: ((RefOntoUML.DataType)object).getOwnedComment()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)o),""));
					node.add(child);
				}
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)g),""));
					node.add(child);				
				}				
				if(object instanceof RefOntoUML.Enumeration){					
					for(EnumerationLiteral lit: ((RefOntoUML.Enumeration)object).getOwnedLiteral()){
						DefaultMutableTreeNode child = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)lit),""));
						node.add(child);
					}
				}
			}			
			
			/* Association */
			if (object instanceof RefOntoUML.Association){
				for (RefOntoUML.Property o: ((RefOntoUML.Association)object).getMemberEnd()){
					if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
					else alias = "";		
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)o),alias));
					node.add(child);					
					checkingModel.setPathEnabled(new TreePath(child.getPath()),false);					
				}
				for (Comment o: ((RefOntoUML.Association)object).getOwnedComment()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)o),""));
					node.add(child);
				}
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					DefaultMutableTreeNode child = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)g),""));
					node.add(child);				
				}
			}			
			return node;
		}else{
			return super.createNode(object);
		}
	}
	
	/** Draw */	
    protected void drawElement(DefaultMutableTreeNode parent, Object object,TreeCheckingModel checkingModel, OntoUMLParser refparser, List<OclDocument> oclDocList)
    {    	
		/* Model */
		if (object instanceof RefOntoUML.Model){
			EList<EObject> contents = ((EObject)object).eContents();
			for (EObject eobj : contents){
				ElementTree.this.drawElement(parent, (RefOntoUML.Element) eobj,checkingModel,refparser,oclDocList);
			}			
			
		/* Package */
		} else if (object instanceof RefOntoUML.Package){
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),""));
			parent.add(newNode);
			expandPath(new TreePath(newNode.getPath()));			
			EList<EObject> contents = ((EObject)object).eContents();
			for (EObject eobj : contents){
				ElementTree.this.drawElement(newNode, (RefOntoUML.Element) eobj,checkingModel,refparser,oclDocList);
			}		
			
		/* GeneralizationSet */
		}else if (object instanceof RefOntoUML.GeneralizationSet) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),""));			
			parent.add(newNode);	
			
		/* UmlDiagram */
		}else if (object instanceof UmlDiagram) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),""));			
			parent.add(newNode);
			
		/* OclDocument */
		}else if (object instanceof OclDocument) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),""));			
			parent.add(newNode);
			
		/* Generalization */
		} else if (object instanceof RefOntoUML.Generalization && !opt.isHiddenGeneralizations()){
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),""));			
			parent.add(newNode);					
			
		/* Comment */
		}else if (object instanceof RefOntoUML.Comment){
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),""));			
			parent.add(newNode);			
		
		/* EnumerationLiteral */
		}else if (object instanceof RefOntoUML.EnumerationLiteral){				
			String alias = new String();			
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.EnumerationLiteral)object);
			else alias = "";					
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),alias));
			parent.add(newNode);
			checkingModel.setPathEnabled(new TreePath(newNode.getPath()),false);	
			
		/* Property */
		}else if (object instanceof RefOntoUML.Property && !opt.isHiddenProperties()) {
			String alias = new String();
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Property)object);
			else alias = "";			
			if(((RefOntoUML.Property)object).getAssociation()!=null && !opt.isHiddenEnds()){
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);
				checkingModel.setPathEnabled(new TreePath(newNode.getPath()),true);				
			}else if (((RefOntoUML.Property)object).getAssociation()==null && !opt.isHiddenAttributes()){
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);
				checkingModel.setPathEnabled(new TreePath(newNode.getPath()),true);
			}		
			
		/* Constraintx */
		}else if (object instanceof RefOntoUML.Constraintx) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),""));			
			parent.add(newNode);	
			
		/* Classifier */
		} else if (object instanceof RefOntoUML.Classifier)		
		{
			String alias = new String();
			if (refparser!=null) alias = refparser.getAlias((RefOntoUML.Classifier)object);
			else alias = "";						
			//modelTree.collapsePath(new TreePath(newNode.getPath()));	
			
			/* Class */
			if (object instanceof RefOntoUML.Class && !opt.isHiddenClasses()){	
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					ElementTree.this.drawElement(newNode,g,checkingModel,refparser,oclDocList);
				}
				for (Property o: ((RefOntoUML.Class)object).getOwnedAttribute()){
					ElementTree.this.drawElement(newNode,o,checkingModel,refparser,oclDocList);
				}			
				for (Comment o: ((RefOntoUML.Class)object).getOwnedComment()){
					ElementTree.this.drawElement(newNode,o,checkingModel,refparser,oclDocList);
				}
			}		
			
			/* DataType */
			if (object instanceof RefOntoUML.DataType && !opt.isHiddenDataTypes()){	
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);					
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					ElementTree.this.drawElement(newNode,g,checkingModel,refparser,oclDocList);
				}
				for (Property o: ((RefOntoUML.DataType)object).getOwnedAttribute()){
					ElementTree.this.drawElement(newNode,o,checkingModel,refparser,oclDocList);
				}			
				for (Comment o: ((RefOntoUML.DataType)object).getOwnedComment()){
					ElementTree.this.drawElement(newNode,o,checkingModel,refparser,oclDocList);
				}
				if(object instanceof RefOntoUML.Enumeration){					
					for(EnumerationLiteral lit: ((RefOntoUML.Enumeration)object).getOwnedLiteral()){
						ElementTree.this.drawElement(newNode,lit,checkingModel,refparser,oclDocList);
					}
				}
			}
			
			/* Association */
			if (object instanceof RefOntoUML.Association && !opt.isHiddenAssociations()){	
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new RefOntoUMLElement(((EObject)object),alias));			
				parent.add(newNode);					
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization())	{
					ElementTree.this.drawElement(newNode,g,checkingModel,refparser,oclDocList);
				}
				for (RefOntoUML.Property o: ((RefOntoUML.Association)object).getMemberEnd()){
					ElementTree.this.drawElement(newNode,o,checkingModel,refparser,oclDocList);
				}
				for (Comment o: ((RefOntoUML.Association)object).getOwnedComment()){
					ElementTree.this.drawElement(newNode,o,checkingModel,refparser,oclDocList);
				}
			}
		}
	}	
}
