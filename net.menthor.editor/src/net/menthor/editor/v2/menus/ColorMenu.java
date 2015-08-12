package net.menthor.editor.v2.menus;

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
import net.menthor.editor.v2.icon.IconType;

public class ColorMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public ColorMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public ColorMenu(CommandListener listener){
		super(listener, "Background Color");		
		build();
  	}
	
	public void build(){
		createMenuItem("Set", IconType.MENTHOR_COLOR_CHOOSER, CommandType.SETUP_BACKGROUND_COLOR);
		createMenuItem("Copy", CommandType.COPY_BACKGROUND_COLOR);
		createMenuItem("Paste", CommandType.PASTE_BACKGROUND_COLOR);		
		sort();
	}

}
