
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

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import net.menthor.editor.v2.MenthorDomain;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.util.SystemUtil;
import net.menthor.editor.v2.util.Util;

public class FrameUI extends JFrame {

	private static final long serialVersionUID = 3464348864344034246L;
		
	// -------- Lazy Initialization

	private static class GUIFrameLoader {
        private static final FrameUI INSTANCE = new FrameUI();
    }	
	public static FrameUI get() { 
		return GUIFrameLoader.INSTANCE; 
	}	
    private FrameUI() {
    	super();
    	setJMenuBar(MenuBarUI.get());		
		getContentPane().add(SplitPaneUI.get(), BorderLayout.CENTER);
        if (GUIFrameLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
        buildUI();
    }		
    
    // ----------------------------
	
    private void buildUI() {	
		super.setIconImage(IconMap.getInstance().getImage(IconType.MENTHOR_APP_ICON));
		setTitle("Menthor Editor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setPreferredSize();		
		if(SystemUtil.onMac()) Util.enableFullScreenMode(this);	
		MenthorDomain.get().initialize();		
		pack();
	}
  
	
	private void setPreferredSize(){
		Dimension size = new Dimension(1000, 648);
		Dimension minimumSize = new Dimension(700, 650);
		this.setSize(size);
		this.setPreferredSize(size);
		this.setMinimumSize(minimumSize);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
