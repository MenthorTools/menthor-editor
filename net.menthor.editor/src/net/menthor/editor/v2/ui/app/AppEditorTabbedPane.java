package net.menthor.editor.v2.ui.app;

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
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.eclipse.emf.edit.provider.IDisposable;

public class AppEditorTabbedPane extends JTabbedPane implements IDisposable {

	private static final long serialVersionUID = 5019191384767258996L;
		
	// -------- Lazy Initialization

	private static class AppEditorTabbedPaneLoader {
        private static final AppEditorTabbedPane INSTANCE = new AppEditorTabbedPane();
    }	
	public static AppEditorTabbedPane get() { 
		return AppEditorTabbedPaneLoader.INSTANCE; 
	}	
    private AppEditorTabbedPane() {
        if (AppEditorTabbedPaneLoader.INSTANCE != null) throw new IllegalStateException("AppEditorTabbedPane already instantiated");
        buildUI();
    }		
    
    // ----------------------------
	    
	private void buildUI(){
		setBorder(new EmptyBorder(0,0,0,0));		
		setBackground(Color.white);
		setMinimumSize(new Dimension(0,0));
		setTabPlacement(JTabbedPane.TOP);
	}
			
	@Override
	public void dispose() {
		int totalTabs = getTabCount();
		for(int i = 0; i < totalTabs; i++) {
			IDisposable disposable = (IDisposable) getComponentAt(i);
			if(disposable != null) disposable.dispose();			
		}
	}	
}