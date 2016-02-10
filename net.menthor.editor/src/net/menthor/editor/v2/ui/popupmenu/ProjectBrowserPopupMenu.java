package net.menthor.editor.v2.ui.popupmenu;

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

import javax.swing.JMenuItem;
import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Association;
import RefOntoUML.DataType;
import RefOntoUML.Generalization;
import RefOntoUML.Property;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.generic.GenericPopupMenu;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.ui.menu.AddClassMenu;
import net.menthor.editor.v2.ui.menu.AddDataTypeMenu;
import net.menthor.editor.v2.ui.menu.AddRelationshipMenu;
import net.menthor.editor.v2.ui.menu.ChangeStereotypeMenu;

/**
 * Pop-up menu visible when right clicking an element in the project browser.
 */
public class ProjectBrowserPopupMenu extends GenericPopupMenu<DefaultMutableTreeNode> {
 
	private static final long serialVersionUID = 1L;
		
	protected AddClassMenu addClassMenu;
	protected AddRelationshipMenu addRelationshipMenu;
	protected AddDataTypeMenu addDataTypeMenu;
	protected ChangeStereotypeMenu changeStereotypeMenu;
	protected JMenuItem addGeneralization;
	protected JMenuItem addGeneralizationSetMenuItem;
	protected JMenuItem addCommentMenuItem;
	protected JMenuItem addConstraintMenuItem;
	protected JMenuItem addPackageMenuItem;
	protected JMenuItem addDiagramMenuItem;
	protected JMenuItem addOCLDocument;
	protected JMenuItem movetodiag;
	protected JMenuItem findindiag;
	
    public ProjectBrowserPopupMenu(final ICommandListener listener, DefaultMutableTreeNode treeNode){
    	super(listener,treeNode);    	
    	Object element = treeNode.getUserObject();    	
    	if(!(element instanceof Generalization)){
    		createMenuItem("Rename", CommandType.RENAME);
    		addSeparator();
    	}    	
    	createMenuItem("Duplicate", CommandType.DUPLICATE); 
    	createMenuItem("Copy", CommandType.COPY);
    	createMenuItem("Paste", CommandType.PASTE);    	
    	if(!(element instanceof Property)){
			addSeparator();
			createMenuItem("Delete", IconType.MENTHOR_DELETE, CommandType.DELETE);
    	}    	
    	if(element instanceof RefOntoUML.Package){
    		addSeparator();
    		addPackageMenuItem = createMenuItem("Add Package", CommandType.ADD_PACKAGE); 
    		addDiagramMenuItem = createMenuItem("Add Diagram", CommandType.ADD_DIAGRAM);
        	addOCLDocument = createMenuItem("Add Rules Document", CommandType.ADD_OCLDOCUMENT);        	
        	addSeparator();
    		addClassMenu = new AddClassMenu(listener, treeNode, this);
    		addRelationshipMenu = new AddRelationshipMenu(listener, treeNode, this);
    		addDataTypeMenu = new AddDataTypeMenu(listener, treeNode, this);    		
    		addSeparator();
        	addGeneralizationSetMenuItem = createMenuItem("Add Generalization Set", CommandType.ADD_GENERALIZATIONSET);    	
        	addConstraintMenuItem = createMenuItem("Add Constraint", CommandType.ADD_CONSTRAINT);    	
        	addCommentMenuItem = createMenuItem("Add Comment", CommandType.ADD_COMMENT);
    	}    	
    	if(element instanceof Association || element instanceof RefOntoUML.Class || element instanceof Generalization || element instanceof DataType){
    		addSeparator();
    		movetodiag = createMenuItem("Move To Diagram", IconType.MENTHOR_HAND_CURSOR, CommandType.MOVE_TREE_NODE_TO_DIAGRAM);    	
        	findindiag = createMenuItem("Find In Diagrams", IconType.MENTHOR_SEARCH, CommandType.FIND_IN_DIAGRAMS);        	
        	addSeparator();
        	changeStereotypeMenu = new ChangeStereotypeMenu(listener, (EObject) element, this);
    	}    	
    	if(element instanceof Association || element instanceof RefOntoUML.Class || element instanceof DataType){
    		addSeparator();
        	addGeneralization = createMenuItem("Add Generalization", CommandType.ADD_GENERALIZATION);
    	}    	
    }
}
