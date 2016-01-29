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

import net.menthor.editor.ui.LicensesDialog;
import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.v2.ui.AboutDialog;

public class HelpManager extends BaseManager {

	// -------- Lazy Initialization

	private static class HelpLoader {
        private static final HelpManager INSTANCE = new HelpManager();
    }	
	public static HelpManager get() { 
		return HelpLoader.INSTANCE; 
	}	
    private HelpManager() {
        if (HelpLoader.INSTANCE != null) throw new IllegalStateException("HelpManager already instantiated");
    }		
    
    // ----------------------------
	
	public void about(){
		AboutDialog.open(
			listener(),
			MenthorEditor.MENTHOR_COMPILATION_DATE,
			MenthorEditor.MENTHOR_VERSION
		);
	}
	
	public void licenses(){
		LicensesDialog.open(frame());
	}

}
