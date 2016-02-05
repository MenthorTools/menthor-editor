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

import java.awt.Rectangle;
import java.awt.dnd.DnDConstants;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

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
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.menu.ProjectBrowserPopupMenu;
import net.menthor.editor.v2.util.Util;

public class ProjectTree extends BaseCheckBoxTree {

	private static final long serialVersionUID = 1L;
	
	protected TreeVisibility opt;
	private ProjectBrowserPopupMenu popupmenu;	
	protected OntoUMLParser refparser;	
	private TreeDragSourceListener dndSource;
	
	public TreeDragSourceListener getDndDragListener() { return dndSource; }
	public OntoUMLParser getParser(){ return refparser;}
	
	//------- Static ---------
	
	public static ProjectTree create(CommandListener listener, OntoUMLParser refparser, List<OclDocument> oclDocList, UmlProject project, TreeVisibility opt, boolean useCheckbox){
		if(refparser!=null) return new ProjectTree(listener, new DefaultMutableTreeNode(refparser.getModel()), refparser, oclDocList, project.getDiagrams(), opt, useCheckbox);
		else return null;		
	}

	public static ProjectTree create(CommandListener listener,OntoUMLParser refparser, TreeVisibility opt, boolean useCheckbox){
		if(refparser!=null) return new ProjectTree(listener, new DefaultMutableTreeNode(refparser.getModel()), refparser, null, null, opt, useCheckbox);
		else return null;
	}
	
	public static ProjectTree create(CommandListener listener, OntoUMLParser refparser, List<OclDocument> oclDocList,List<OntoumlDiagram> diagrams , TreeVisibility opt, boolean useCheckbox){
		if(refparser!=null) return new ProjectTree(listener, new DefaultMutableTreeNode(refparser.getModel()), refparser, oclDocList, diagrams, opt, useCheckbox);
		else return null;		
	}
		
	public static ProjectTree createPackageableTree(CommandListener listener,OntoUMLParser refparser, List<OclDocument> oclDocList, List<OntoumlDiagram> diagrams){	
		TreeVisibility opt = new TreeVisibility();
		opt.showOnlyPackageable();
		ProjectTree tree = create(listener,refparser, oclDocList, diagrams, opt, false);		
		return tree;
	}
		
	public static ProjectTree createPackageableTree(CommandListener listener,OntoUMLParser refparser){	
		TreeVisibility opt = new TreeVisibility();
		opt.showOnlyPackageable();
		ProjectTree tree = create(listener, refparser, opt, false);
		return tree;
	}
	
	//------- Constructor ---------
	
	public ProjectTree (DefaultMutableTreeNode rootNode){
		super(rootNode);
	}
	    
	public ProjectTree (final CommandListener listener, DefaultMutableTreeNode rootNode, OntoUMLParser refparser, List<OclDocument> oclDocList, List<OntoumlDiagram> diagrams, TreeVisibility opt, boolean useCheckbox){
		super(listener, rootNode);		
		this.opt=opt;		
		this.refparser=refparser;
		TreeCellRenderer cellRenderer = new TreeCellRenderer(useCheckbox);
		setCellRenderer(cellRenderer);		
		addModelElements(modelRootNode, rootNode.getUserObject());
		if(diagrams!=null) addDiagrams(diagrams);
		if(oclDocList!=null) addOclDocuments(oclDocList);
		addCheckingPath(new TreePath(modelRootNode.getPath()));		
		expandPath(new TreePath(modelRootNode.getPath()));	
		/* Select Action */
		addTreeSelectionListener(new TreeSelectionListener() {			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
				if(node!=null && node.getUserObject()!=null && (node.getUserObject() instanceof OntoumlDiagram || node.getUserObject() instanceof OclDocument)){
					listener.handleCommand(CommandType.SELECT_EDITOR.toString(), new Object[]{node.getUserObject()});		
				}
			}			
		});
		/* Delete Key Stroke */
		if(Util.onMac()){
			getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, ActionEvent.META_MASK), "delete");
		}else{
			getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK), "delete");
		}
		getActionMap().put("delete", new AbstractAction() {			
			private static final long serialVersionUID = -340479571291150368L;			
			@Override
		    public void actionPerformed(ActionEvent e) {				
		       listener.handleCommand(CommandType.DELETE.toString(), new Object[]{getSelectedNode().getUserObject()});
		    }
		});				
		
		/* Click */
		addMouseListener(new MouseAdapter(){
	        public void mouseClicked (MouseEvent e){	       	
	        	if (SwingUtilities.isRightMouseButton(e)){	            	
	        		openPopupMenu(e,listener);         
	            }
	        	if (e.getClickCount()==2 && SwingUtilities.isLeftMouseButton(e)){
	            	TreePath path = getPathForLocation(e.getX(),e.getY());
	            	if (path!=null){
	                	DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)(path.getLastPathComponent());
	                	if(currentNode!=null) listener.handleCommand(CommandType.EDIT.toString(), new Object[]{currentNode.getUserObject()});
	            	}
	            }
	        }
	    });
		/* Drag and Drop in the tree */		
		dndSource = new TreeDragSourceListener(this, DnDConstants.ACTION_MOVE);
		new TreeDropTargetListener(this);		
		/* Select Root */		
	    select(getRootNode());	    
	}	
	
	//------- Popup Menu ---------
	
	public void openPopupMenu(MouseEvent e, CommandListener listener){				
		TreePath path = getPathForLocation(e.getX (), e.getY());        	
    	setSelectionPath(path);
    	scrollPathToVisible(path);            
    	DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)(path.getLastPathComponent());
    	Rectangle pathBounds = getUI().getPathBounds(ProjectTree.this, path);
        if (pathBounds != null && pathBounds.contains(e.getX (),e.getY())){
        	popupmenu = new ProjectBrowserPopupMenu(listener,currentNode);
    		popupmenu.show(e.getComponent(), e.getX(), e.getY());
        }			
	}
	
	//------- Add ---------
	
    public void addOclDocuments(List<OclDocument> oclDocList){    			
		for(OclDocument c: oclDocList){
			PackageableElement refContainer = (PackageableElement)c.getContainer();
			DefaultMutableTreeNode parent = getNode(refContainer);
			if(parent!=null) addChild(parent, c);
			else addChild(modelRootNode,c);
		}		
    }
    
    public void addDiagrams(List<OntoumlDiagram> diagrams){
		for(OntoumlDiagram c: diagrams){						
			PackageableElement refContainer = (PackageableElement)c.getContainer();
			DefaultMutableTreeNode parent = getNode(refContainer);
			if(parent!=null) addChild(parent, c);
			else addChild(modelRootNode,c);
		}		
    }
    
    public void addModelElements(DefaultMutableTreeNode parent, Object object){    	
		/* Model */
		if (object instanceof RefOntoUML.Model){
			EList<EObject> contents = ((EObject)object).eContents();
			for (EObject eobj : contents){
				addModelElements(parent, eobj);
			}
		}		
		/* Package */
		else if (object instanceof RefOntoUML.Package){
			DefaultMutableTreeNode newNode = addChild(parent, object);			
			expandPath(new TreePath(newNode.getPath()));
			EList<EObject> contents = ((EObject)object).eContents();
			for (EObject eobj : contents){
				addModelElements(newNode,eobj);
			}		
		}		
		/* GeneralizationSet */
		else if (object instanceof RefOntoUML.GeneralizationSet && !opt.isHiddenGeneralizationSets()) {
			addChild(parent, object);	
		}		
		/* Generalization */
		else if (object instanceof RefOntoUML.Generalization && !opt.isHiddenGeneralizations()){
			addChild(parent, object);					
		}		
		/* Comment */
		else if (object instanceof RefOntoUML.Comment && !opt.isHiddenComments()){
			addChild(parent, object);
		}		
		/* EnumerationLiteral */
		else if (object instanceof RefOntoUML.EnumerationLiteral && !opt.isHiddenLiterals()){					
			DefaultMutableTreeNode newNode = addChild(parent, object);
			checkingModel.setPathEnabled(new TreePath(newNode.getPath()),false);	
		}		
		/* Property */
		else if (object instanceof RefOntoUML.Property && !opt.isHiddenProperties()) {			
			if(((RefOntoUML.Property)object).getAssociation()!=null && !opt.isHiddenEnds()){
				DefaultMutableTreeNode newNode = addChild(parent, object);
				checkingModel.setPathEnabled(new TreePath(newNode.getPath()),true);				
			}			
			else if (((RefOntoUML.Property)object).getAssociation()==null && !opt.isHiddenAttributes()){
				DefaultMutableTreeNode newNode = addChild(parent, object);
				checkingModel.setPathEnabled(new TreePath(newNode.getPath()),true);
			}		
		}		
		/* Constraintx */
		else if (object instanceof RefOntoUML.Constraintx && !opt.isHiddenConstraints()) {
			addChild(parent, object);	
		}		
		/* Classifier */
		else if (object instanceof RefOntoUML.Classifier){			
			/* Class */
			if (object instanceof RefOntoUML.Class && !opt.isHiddenClasses()){	
				DefaultMutableTreeNode newNode = addChild(parent, object);
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					if(!opt.isHiddenGeneralizations()) addModelElements(newNode,g);
				}
				for (Property o: ((RefOntoUML.Class)object).getOwnedAttribute()){
					if(!opt.isHiddenAttributes()) addModelElements(newNode,o);
				}			
				for (Comment o: ((RefOntoUML.Class)object).getOwnedComment()){
					if(!opt.isHiddenComments()) addModelElements(newNode,o);
				}
			}					
			/* DataType */
			if (object instanceof RefOntoUML.DataType && !opt.isHiddenDataTypes()){	
				DefaultMutableTreeNode newNode = addChild(parent, object);					
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization()){
					if(!opt.isHiddenGeneralizations()) addModelElements(newNode,g);
				}
				for (Property o: ((RefOntoUML.DataType)object).getOwnedAttribute()){
					if(!opt.isHiddenAttributes()) addModelElements(newNode,o);
				}			
				for (Comment o: ((RefOntoUML.DataType)object).getOwnedComment()){
					if(!opt.isHiddenComments()) addModelElements(newNode,o);
				}
				if(object instanceof RefOntoUML.Enumeration){					
					for(EnumerationLiteral lit: ((RefOntoUML.Enumeration)object).getOwnedLiteral()){
						addModelElements(newNode,lit);
					}
				}
			}			
			/* Association */
			if (object instanceof RefOntoUML.Association && !opt.isHiddenAssociations()){	
				DefaultMutableTreeNode newNode = addChild(parent, object);					
				for(Generalization g: ((RefOntoUML.Classifier) object).getGeneralization())	{
					if(!opt.isHiddenGeneralizations()) addModelElements(newNode,g);
				}
				for (RefOntoUML.Property o: ((RefOntoUML.Association)object).getMemberEnd()){
					if(!opt.isHiddenEnds()) addModelElements(newNode,o);
				}
				for (Comment o: ((RefOntoUML.Association)object).getOwnedComment()){
					if(!opt.isHiddenComments()) addModelElements(newNode,o);
				}
			}
		}		
    }
    
  //------- remove ---------
    
    public void remove(RefOntoUML.Element deletedElement){
    	/* remove generalizationSets too if the generalization is removed */
		if(deletedElement instanceof Generalization){
			checkObject(deletedElement);						
			removeCurrentNode();
			for(GeneralizationSet genSet: ((Generalization)deletedElement).getGeneralizationSet()){
				if(genSet.getGeneralization().size()==1 && genSet.getGeneralization().get(0).equals(deletedElement)) { checkObject(genSet); removeCurrentNode(); }
				if(genSet.getGeneralization().size()==0) { checkObject(genSet); removeCurrentNode(); }
			}
			return;
		}		
		checkObject(deletedElement);		
		removeCurrentNode();				
	}    

    //------- Find ---------
    
	@SuppressWarnings("rawtypes")
	public ArrayList<DefaultMutableTreeNode> findName(String name){		
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
