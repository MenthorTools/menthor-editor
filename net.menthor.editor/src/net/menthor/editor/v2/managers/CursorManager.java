package net.menthor.editor.v2.managers;

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

import java.awt.Component;
import java.awt.Cursor;

import javax.swing.RootPaneContainer;

import net.menthor.editor.v2.ui.app.manager.AppGenericManager;

public class CursorManager extends AppGenericManager {

	// -------- Lazy Initialization

	private static class CursorLoader {
        private static final CursorManager INSTANCE = new CursorManager();
    }	
	public static CursorManager get() { 
		return CursorLoader.INSTANCE; 
	}	
    private CursorManager() {
        if (CursorLoader.INSTANCE != null) throw new IllegalStateException("CursorManager already instantiated");
    }		
    
    // ----------------------------
		
	public void waitCursor(){
		int cursorType = Cursor.WAIT_CURSOR;
		Component glassPane = ((RootPaneContainer)editorsPane().getTopLevelAncestor()).getGlassPane();
		glassPane.setCursor(Cursor.getPredefinedCursor(cursorType));
		glassPane.setVisible(cursorType != Cursor.DEFAULT_CURSOR);
	}
	
	public void defaultCursor(){
		int cursorType = Cursor.DEFAULT_CURSOR;
		Component glassPane = ((RootPaneContainer)editorsPane().getTopLevelAncestor()).getGlassPane();
		glassPane.setCursor(Cursor.getPredefinedCursor(cursorType));
		glassPane.setVisible(cursorType != Cursor.DEFAULT_CURSOR);
	}
	
	public void handCursor(){
		int cursorType = Cursor.HAND_CURSOR;
		Component glassPane = ((RootPaneContainer)editorsPane().getTopLevelAncestor()).getGlassPane();
		glassPane.setCursor(Cursor.getPredefinedCursor(cursorType));
		glassPane.setVisible(cursorType != Cursor.DEFAULT_CURSOR);
	}
	
	public void crossHairCursor(){
		int cursorType = Cursor.CROSSHAIR_CURSOR;
		Component glassPane = ((RootPaneContainer)editorsPane().getTopLevelAncestor()).getGlassPane();
		glassPane.setCursor(Cursor.getPredefinedCursor(cursorType));
		glassPane.setVisible(cursorType != Cursor.DEFAULT_CURSOR);
	}
}
