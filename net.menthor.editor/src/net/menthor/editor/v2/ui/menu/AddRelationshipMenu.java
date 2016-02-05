package net.menthor.editor.v2.ui.menu;

import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.ui.icon.IconType;

public class AddRelationshipMenu extends GenericMenu<DefaultMutableTreeNode> {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AddRelationshipMenu(ICommandListener listener, String text, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		super(listener, text, treeNode);	

		createMenuItem(RelationshipType.GENERALIZATION.getName(), IconType.MENTHOR_GENERALIZATION, CommandType.ADD_GENERALIZATION);
		createMenuItem(RelationshipType.CHARACTERIZATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_CHARACTERIZATION);
		createMenuItem(RelationshipType.MEDIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_MEDIATION);
		createMenuItem(RelationshipType.FORMAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_FORMAL);
		createMenuItem(RelationshipType.MATERIAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_MATERIAL);
		createMenuItem(RelationshipType.DERIVATION.getName(), IconType.MENTHOR_DERIVATION, CommandType.ADD_DERIVATION);
		createMenuItem(RelationshipType.COMPONENTOF.getName(), IconType.MENTHOR_COMPONENTOF, CommandType.ADD_COMPONENTOF);
		createMenuItem(RelationshipType.MEMBEROF.getName(), IconType.MENTHOR_MEMBEROF, CommandType.ADD_MEMBEROF);
		createMenuItem(RelationshipType.SUBCOLLECTIONOF.getName(), IconType.MENTHOR_SUBCOLLECTIONOF, CommandType.ADD_SUBCOLLECTIONOF);
		createMenuItem(RelationshipType.SUBQUANTITYOF.getName(), IconType.MENTHOR_SUBQUANTITYOF, CommandType.ADD_SUBQUANTITYOF);
		createMenuItem(RelationshipType.STRUCTURATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_STRUCTURATION);
		createMenuItem(RelationshipType.ASSOCIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_ASSOCIATION);
		
		sort();
		
		parent.add(this);
	}
	
	public AddRelationshipMenu(ICommandListener listener, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		this(listener, "Add Relationship", treeNode, parent);	
	}
}
