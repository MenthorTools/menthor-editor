package net.menthor.editor.v2.toolbars;

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

import java.awt.Color;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;

public class MainToolbar extends BaseToolBar {

	private static final long serialVersionUID = 8870790907921523710L;
	
	private static Color background = null; //Color.WHITE;
	
	/** constructor */
	public MainToolbar(CommandListener listener){
		super(listener, background, 32, 32);
		setBackground(background);
		createButton(IconType.MENTHOR_DOC, CommandType.NEW_PROJECT, background);
		createButton(IconType.MENTHOR_FOLDER,CommandType.OPEN_PROJECT, background);	
		createButton(IconType.MENTHOR_SAVE, CommandType.SAVE_PROJECT, background);
		createButton(IconType.MENTHOR_SEARCH,CommandType.FIND_TERM, background);		
		createButton(IconType.MENTHOR_CHECK,CommandType.CHECK_MODEL_SYNTAX, background);
		createButton(IconType.MENTHOR_STATS,CommandType.COLLECT_STATISTICS, background);
		createButton(IconType.MENTHOR_PLAY, CommandType.SIMULATE_AND_CHECK, background);
		createButton(IconType.MENTHOR_SEMANTIC_WEB, CommandType.IMPLEMENT_IN_OWL, background);				
		enableAll(false);
	}	
}
