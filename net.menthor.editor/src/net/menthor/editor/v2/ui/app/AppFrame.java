
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

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.util.SystemUtil;
import net.menthor.editor.v2.util.Util;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = 3464348864344034246L;
		
	// -------- Lazy Initialization

	private static class AppFrameLoader {
        private static final AppFrame INSTANCE = new AppFrame();
    }	
	public static AppFrame get() { 
		return AppFrameLoader.INSTANCE; 
	}	
    private AppFrame() {
    	super();
    	setJMenuBar(AppMenuBar.get());		
		getContentPane().add(AppSplitPane.get(), BorderLayout.CENTER);
        if (AppFrameLoader.INSTANCE != null) throw new IllegalStateException("AppFrame already instantiated");
        buildUI();
    }		
    
    // ----------------------------
	
    public void buildUI() {	
		super.setIconImage(IconMap.getInstance().getImage(IconType.MENTHOR_APP_ICON));
		setTitle("Menthor Editor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setPreferredSize();		
		if(SystemUtil.onMac()) Util.enableFullScreenMode(this);	
		RefOntoUMLEditingDomain.getInstance().initialize();		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					quitApplication();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		pack();
	}
    
	public void initializeFrame(File projectFile){
		initializeFrame(projectFile,true);
	}
	
	public void initializeFrame(File projectFile, boolean forceDefaultUI){
		JRootPane root = getRootPane( );
		root.putClientProperty("Window.documentFile", projectFile);
		setTitle(projectFile.getName().replace(".menthor","")+" - Menthor Editor");
		if(forceDefaultUI){
			AppSplitPane.get().forceDefaultState();
		}
	}
	
	public void resetFrame(){
		setTitle("Menthor Editor");		
		AppSplitPane.get().forceInitialState();
	}
	
	public boolean quitApplication() throws IOException {
		if (canQuit()) {					
			AppEditorsPane.get().dispose();
			dispose();
			Thread.currentThread().interrupt();			
			System.gc();
			Runtime.getRuntime().exit(0);
			return true;
		}else{
			return false;
		}
	}	
		
	private boolean canQuit() throws IOException {		
		if(ProjectManager.get().getProject()==null) return true;		
		int response = JOptionPane.showOptionDialog(
			this, "Do you really want to quit?", "Quit application?", 
			JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
			new String[]{"Save and Exit", "Exit without saving", "Cancel"},
			"default"
		);		
		if(response==JOptionPane.YES_OPTION){
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			ProjectManager.get().saveProject();			
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));			
			return true;
		}
		if(response==JOptionPane.NO_OPTION){
			return true;
		}
		if(response==JOptionPane.CANCEL_OPTION){
			return false;
		}
		return true;
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
