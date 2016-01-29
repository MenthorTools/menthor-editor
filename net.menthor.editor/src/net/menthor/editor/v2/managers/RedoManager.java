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

import org.tinyuml.ui.diagram.DiagramEditor;

public class RedoManager extends BaseManager {

	// -------- Lazy Initialization

	private static class RedoLoader {
        private static final RedoManager INSTANCE = new RedoManager();
    }	
	public static RedoManager get() { 
		return RedoLoader.INSTANCE; 
	}	
    private RedoManager() {
        if (RedoLoader.INSTANCE != null) throw new IllegalStateException("RedoManager already instantiated");
    }		
    
    // ----------------------------
	
	public void redo(){
		DiagramEditor editor = TabManager.get().getCurrentDiagramEditor();
		if(editor==null) return;		
		if(editor.canRedo()) editor.redo();
		else MessageManager.get().showError("Cannot Redo", "No other action to be redone.\n");			
	}
}
