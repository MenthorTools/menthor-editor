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

import RefOntoUML.stereotypes.ClassStereotype;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.generic.GenericMenu;
import net.menthor.editor.v2.ui.icon.IconType;

public class AddClassMenu extends GenericMenu<DefaultMutableTreeNode> {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AddClassMenu(ICommandListener listener, String text, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		super(listener, text, treeNode);
		createMenuItem(ClassStereotype.KIND.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_KIND);
		createMenuItem(ClassStereotype.SUBKIND.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_SUBKIND);
		createMenuItem(ClassStereotype.COLLECTIVE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_COLLECTIVE);
		createMenuItem(ClassStereotype.QUANTITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_QUANTITY);
		createMenuItem(ClassStereotype.PHASE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_PHASE);
		createMenuItem(ClassStereotype.ROLE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_ROLE);
		createMenuItem(ClassStereotype.CATEGORY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_CATEGORY);
		createMenuItem(ClassStereotype.ROLEMIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_ROLEMIXIN);
		createMenuItem(ClassStereotype.MIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_MIXIN);
		createMenuItem(ClassStereotype.RELATOR.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_RELATOR);
		createMenuItem(ClassStereotype.MODE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_MODE);
		createMenuItem(ClassStereotype.PERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_PERCEIVABLE_QUALITY);
		createMenuItem(ClassStereotype.NONPERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_NONPERCEIVABLE_QUALITY);
		createMenuItem(ClassStereotype.NOMINAL_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_NOMINAL_QUALITY);
        sort();		
		parent.add(this);
	}
	
	public AddClassMenu(ICommandListener listener, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		this(listener, "Add Class", treeNode, parent);		
	}
}
