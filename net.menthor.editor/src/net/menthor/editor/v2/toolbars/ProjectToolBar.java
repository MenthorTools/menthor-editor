package net.menthor.editor.v2.toolbars;

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
 */

import java.awt.Color;

import javax.swing.UIManager;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;

public class ProjectToolBar extends BaseToolBar {

	private static final long serialVersionUID = 1809611076455179596L;

	private static Color background = UIManager.getColor("Panel.background"); //Color.WHITE;
	
	public ProjectToolBar(CommandListener listener){
		super(listener, background, 16, 16);
		setFloatable(false);
		setBackground(background);
		createButton(IconType.MENTHOR_UP, CommandType.MOVE_UP_TREE, background);
		createButton(IconType.MENTHOR_DOWN, CommandType.MOVE_DOWN_TREE, background);
	}	
}