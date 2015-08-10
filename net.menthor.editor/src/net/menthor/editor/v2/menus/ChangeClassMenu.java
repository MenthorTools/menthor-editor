package net.menthor.editor.v2.menus;

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
 * 
 * @author John Guerson
 */

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.types.ClassType;

public class ChangeClassMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
		
	public ChangeClassMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public ChangeClassMenu(CommandListener listener){
		super(listener, "Change To");
		build();
	}
	
	public void build(){
		createMenuItem(ClassType.KIND.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_KIND);
		createMenuItem(ClassType.SUBKIND.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_SUBKIND);
		createMenuItem(ClassType.COLLECTIVE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_COLLECTIVE);
		createMenuItem(ClassType.QUANTITY.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_QUANTITY);
		createMenuItem(ClassType.PHASE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_PHASE);
		createMenuItem(ClassType.ROLE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_ROLE);
		createMenuItem(ClassType.CATEGORY.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_CATEGORY);
		createMenuItem(ClassType.ROLEMIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_ROLEMIXIN);
		createMenuItem(ClassType.MIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_MIXIN);
		createMenuItem(ClassType.RELATOR.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_RELATOR);
		createMenuItem(ClassType.MODE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_MODE);
		createMenuItem(ClassType.PERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_PERCEIVABLE_QUALITY);
		createMenuItem(ClassType.NONPERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_NONPERCEIVABLE_QUALITY);
		createMenuItem(ClassType.NOMINAL_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_NOMINAL_QUALITY);
		sort();
	}
}