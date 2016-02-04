package net.menthor.editor.v2.menu;

import javax.swing.JMenuItem;
import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Association;
import RefOntoUML.DataType;
import RefOntoUML.Generalization;
import RefOntoUML.Property;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
/**
 * Pop-up menu visible when right clicking an element in the project browser.
 * */
public class ProjectBrowserPopupMenu extends BasePopupMenu<DefaultMutableTreeNode> {
 
	private static final long serialVersionUID = 1L;
		
	AddClassMenu addClassMenu;
	AddRelationshipMenu addRelationshipMenu;
	AddDataTypeMenu addDataTypeMenu;
	ChangeStereotypeMenu changeStereotypeMenu;
	JMenuItem addGeneralization;
	JMenuItem addGeneralizationSetMenuItem;
	JMenuItem addCommentMenuItem;
	JMenuItem addConstraintMenuItem;
	JMenuItem addPackageMenuItem;
	JMenuItem addDiagramMenuItem;
	JMenuItem addOCLDocument;
	JMenuItem movetodiag;
	JMenuItem findindiag;
	
    public ProjectBrowserPopupMenu(final CommandListener listener, DefaultMutableTreeNode treeNode)
    {
    	super(listener,treeNode);
    	
    	Object element = treeNode.getUserObject();
    	
    	if(!(element instanceof Generalization)){
    		createMenuItem("Rename", CommandType.RENAME);
    		addSeparator();
    	}
    	
    	//TODO: check these methods...
    	
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
    		movetodiag = createMenuItem("Move To Diagram", IconType.MENTHOR_HAND_CURSOR, CommandType.MOVE_TO_DIAGRAM);    	
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
