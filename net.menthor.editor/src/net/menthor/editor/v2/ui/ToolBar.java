package net.menthor.editor.v2.ui;

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
import net.menthor.editor.v2.ui.generic.GenericToolBar;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.ui.toolbar.ToolBarButton;

public class ToolBar extends GenericToolBar {

	private static final long serialVersionUID = 8870790907921523710L;
	
	// -------- Lazy Initialization

	private static class GUIToolBarLoader {
        private static final ToolBar INSTANCE = new ToolBar();
    }	
	public static ToolBar get() { 
		return GUIToolBarLoader.INSTANCE; 
	}	
    private ToolBar() {
    	super(CommandListener.get(), background);
    	if (GUIToolBarLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
        buildUI();
    }		
    
    // ----------------------------
	    
	private static Color background = null; //Color.WHITE;
	
	/** constructor */
	public void buildUI(){		
		setBackground(background);
		new ToolBarButton(IconType.MENTHOR_DOC, CommandType.NEW_PROJECT, background, this);
		new ToolBarButton(IconType.MENTHOR_FOLDER,CommandType.OPEN_EXISTING_PROJECT, background, this);	
		new ToolBarButton(IconType.MENTHOR_SAVE, CommandType.SAVE_PROJECT, background, this);
		new ToolBarButton(IconType.MENTHOR_SEARCH,CommandType.ADD_FINDER_EDITOR, background, this);		
		new ToolBarButton(IconType.MENTHOR_CHECK,CommandType.VERIFY_MODEL, background, this);
		new ToolBarButton(IconType.MENTHOR_STATS,CommandType.ADD_STATISTICS_EDITOR, background, this);
		new ToolBarButton(IconType.MENTHOR_PLAY, CommandType.ALLOY_SETTINGS, background, this);
		new ToolBarButton(IconType.MENTHOR_SEMANTIC_WEB, CommandType.OWL_SETTINGS, background, this);				
		enableAll(false);
	}	
}
