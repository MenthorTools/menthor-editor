package net.menthor.editor.v2.ui.menu;

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

import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

import RefOntoUML.stereotypes.RelationshipStereotype;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.generic.GenericMenu;
import net.menthor.editor.v2.ui.icon.IconType;

public class AddRelationshipMenu extends GenericMenu<DefaultMutableTreeNode> {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AddRelationshipMenu(ICommandListener listener, String text, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		super(listener, text, treeNode);
		createMenuItem(RelationshipStereotype.GENERALIZATION.getName(), IconType.MENTHOR_GENERALIZATION, CommandType.ADD_GENERALIZATION);
		createMenuItem(RelationshipStereotype.CHARACTERIZATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_CHARACTERIZATION);
		createMenuItem(RelationshipStereotype.MEDIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_MEDIATION);
		createMenuItem(RelationshipStereotype.FORMAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_FORMAL);
		createMenuItem(RelationshipStereotype.MATERIAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_MATERIAL);
		createMenuItem(RelationshipStereotype.DERIVATION.getName(), IconType.MENTHOR_DERIVATION, CommandType.ADD_DERIVATION);
		createMenuItem(RelationshipStereotype.COMPONENTOF.getName(), IconType.MENTHOR_COMPONENTOF, CommandType.ADD_COMPONENTOF);
		createMenuItem(RelationshipStereotype.MEMBEROF.getName(), IconType.MENTHOR_MEMBEROF, CommandType.ADD_MEMBEROF);
		createMenuItem(RelationshipStereotype.SUBCOLLECTIONOF.getName(), IconType.MENTHOR_SUBCOLLECTIONOF, CommandType.ADD_SUBCOLLECTIONOF);
		createMenuItem(RelationshipStereotype.SUBQUANTITYOF.getName(), IconType.MENTHOR_SUBQUANTITYOF, CommandType.ADD_SUBQUANTITYOF);
		createMenuItem(RelationshipStereotype.STRUCTURATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_STRUCTURATION);
		createMenuItem(RelationshipStereotype.ASSOCIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_ASSOCIATION);
		sort();		
		parent.add(this);
	}
	
	public AddRelationshipMenu(ICommandListener listener, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		this(listener, "Add Relationship", treeNode, parent);	
	}
}
