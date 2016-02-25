package net.menthor.editor.v2.ui.controller;

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

import java.io.File;
import java.io.IOException;

import net.menthor.editor.v2.ui.FrameUI;
import net.menthor.editor.v2.ui.settings.ea.EASettingsDialog;
import net.menthor.editor.v2.util.SettingsUtil;
import net.menthor.editor.v2.util.Util;

public class ImportUIController {

	FrameUI frame = FrameUI.get();
	
	// -------- Lazy Initialization

	private static class ImportLoader {
        private static final ImportUIController INSTANCE = new ImportUIController();
    }	
	public static ImportUIController get() { 
		return ImportLoader.INSTANCE; 
	}	
    private ImportUIController() {
        if (ImportLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------
	
	public String lastImportEAPath = new String();	
	
	public File chooseEAFile() throws IOException{
		return Util.chooseFile(frame, lastImportEAPath, 
		"Import From EA", "XMI, XML (*.xmi, *.xml)", "xmi", "xml", false);
	}
	
	public void importFromEARecent() throws IOException {		
		lastImportEAPath = TabbedAreaUIController.get().getStartEditor().getSelectedRecentFile();
		new EASettingsDialog(frame, true,  lastImportEAPath);
		SettingsUtil.addRecentProject(lastImportEAPath);				
	}

	public void importFromEA() throws IOException{		
		File file = chooseEAFile();
		if(file!=null){
			lastImportEAPath = file.getAbsolutePath();
			new EASettingsDialog(frame, true, lastImportEAPath);
			SettingsUtil.addRecentProject(file.getCanonicalPath());
		}
	}
}
