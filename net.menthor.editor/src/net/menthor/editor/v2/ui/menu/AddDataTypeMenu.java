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

import RefOntoUML.stereotypes.DataTypeStereotype;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.generic.GenericMenu;
import net.menthor.editor.v2.ui.icon.IconType;

public class AddDataTypeMenu extends GenericMenu<DefaultMutableTreeNode> {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AddDataTypeMenu(ICommandListener listener, String text, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		super(listener, text, treeNode);
		createMenuItem(DataTypeStereotype.DATATYPE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DATATYPE);
		createMenuItem(DataTypeStereotype.ENUMERATION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_ENUMERATION);
		createMenuItem(DataTypeStereotype.PRIMITIVETYPE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_PRIMITIVETYPE);
		createMenuItem(DataTypeStereotype.INTEGERINTERVAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_INTEGERINTERVAL_DIMENSION);
		createMenuItem(DataTypeStereotype.INTEGERORDINAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_INTEGERORDINAL_DIMENSION);
		createMenuItem(DataTypeStereotype.INTEGERRATIONAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_INTEGERRATIONAL_DIMENSION);
		createMenuItem(DataTypeStereotype.DECIMALRATIONAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DECIMALRATIONAL_DIMENSION);
		createMenuItem(DataTypeStereotype.DECIMALORDINAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DECIMALORDINAL_DIMENSION);
		createMenuItem(DataTypeStereotype.DECIMALINTERVAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DECIMALINTERVAL_DIMENSION);
		createMenuItem(DataTypeStereotype.STRINGNOMINAL_STRUCTURE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_STRINGNOMINAL_STRUCTURE);
		createMenuItem(DataTypeStereotype.MEASUREMENT_DOMAIN.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_MEASUREMENT_DOMAIN);
		sort();
		parent.add(this);		
	}
	
	public AddDataTypeMenu(ICommandListener listener, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		this(listener, "Add DataType", treeNode, parent);
	}
}
