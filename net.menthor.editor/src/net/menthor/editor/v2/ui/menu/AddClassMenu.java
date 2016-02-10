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

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.ui.generic.GenericMenu;
import net.menthor.editor.v2.ui.icon.IconType;

public class AddClassMenu extends GenericMenu<DefaultMutableTreeNode> {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AddClassMenu(ICommandListener listener, String text, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		super(listener, text, treeNode);
		createMenuItem(ClassType.KIND.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_KIND);
		createMenuItem(ClassType.SUBKIND.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_SUBKIND);
		createMenuItem(ClassType.COLLECTIVE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_COLLECTIVE);
		createMenuItem(ClassType.QUANTITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_QUANTITY);
		createMenuItem(ClassType.PHASE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_PHASE);
		createMenuItem(ClassType.ROLE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_ROLE);
		createMenuItem(ClassType.CATEGORY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_CATEGORY);
		createMenuItem(ClassType.ROLEMIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_ROLEMIXIN);
		createMenuItem(ClassType.MIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_MIXIN);
		createMenuItem(ClassType.RELATOR.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_RELATOR);
		createMenuItem(ClassType.MODE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_MODE);
		createMenuItem(ClassType.PERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_PERCEIVABLE_QUALITY);
		createMenuItem(ClassType.NONPERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_NONPERCEIVABLE_QUALITY);
		createMenuItem(ClassType.NOMINAL_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_NOMINAL_QUALITY);
        sort();		
		parent.add(this);
	}
	
	public AddClassMenu(ICommandListener listener, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		this(listener, "Add Class", treeNode, parent);		
	}
}
