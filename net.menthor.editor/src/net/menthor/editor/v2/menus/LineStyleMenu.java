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

public class LineStyleMenu  extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public LineStyleMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public LineStyleMenu(CommandListener listener){
		super(listener, "Visibility");		
		build();
  	}
	
	public void build(){
		createMenuItem("Direct", CommandType.APPLY_DIRECT_STYLE);
		createMenuItem("Rectilinear", CommandType.APPLY_RECTILINEAR_STYLE);
		createMenuItem("Tree Style Horizontal", CommandType.APPLY_HORIZONTAL_STYLE);
		createMenuItem("Tree Style Vertical", CommandType.APPLY_VERTICAL_STYLE);		
		sort();
	}
}
