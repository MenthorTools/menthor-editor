package net.menthor.editor.v2.menu;

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

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class VisibilityMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public VisibilityMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public VisibilityMenu(CommandListener listener){
		super(listener, "Visibility");		
		build();
  	}
	
	public void build(){
		createCheckBoxMenuItem("End-Point Names", CommandType.SHOW_END_POINT_NAMES);
		createCheckBoxMenuItem("Subsetting", CommandType.SHOW_SUBSETTING);
		createCheckBoxMenuItem("Redefining", CommandType.SHOW_REDEFINITIONS);
		createCheckBoxMenuItem("Multiplicities", CommandType.SHOW_MULTIPLICITIES);
		createCheckBoxMenuItem("Name", CommandType.SHOW_NAME);
		createCheckBoxMenuItem("Stereotype", CommandType.SHOW_STEREOTYPE);
		sort();
	}
}
