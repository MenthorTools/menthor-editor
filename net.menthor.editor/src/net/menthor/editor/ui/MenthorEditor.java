package net.menthor.editor.ui;

/*
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 - John Guerson, Tiago Sales and Freddy Brasileiro
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
import javax.swing.UnsupportedLookAndFeelException;

import net.menthor.editor.v2.managers.MessageManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.TabManager;
import net.menthor.editor.v2.settings.owl.OwlSettingsMap;
import net.menthor.editor.v2.ui.startpage.SplashScreen;
import net.menthor.editor.v2.ui.tabbedpane.AppEditorTabbedPane;
import net.menthor.editor.v2.ui.tabbedpane.AppInfoTabbedPane;
import net.menthor.editor.v2.ui.tree.ProjectTree;
import net.menthor.editor.v2.util.DirectoryUtil;
import net.menthor.editor.v2.util.UIFontUtil;
import net.menthor.editor.v2.util.Util;
import net.menthor.swt.SWTConfigurer;

public final class MenthorEditor {
	
	private static AppFrame frame; 
	public static AppFrame getFrame(){ return frame; }
	
	/**
	 * This variable MUST be composed as "a.b.c". Increment when is built a:
	 * 		a: new version of this application
	 * 		b: compilation with new features
	 * 		c: compilation with bug fixes
	 */	
	public static String MENTHOR_VERSION = "1.1.3";	
	public static String MENTHOR_COMPILATION_DATE = Util.getCompilationDateMessage();	
	public static SplashScreen splashScreen = new SplashScreen(MENTHOR_VERSION, MENTHOR_COMPILATION_DATE);
	
	/** Set System properties according to each Operating System */
	public static void setSystemProperties() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		//Needed for the embedded SWT Browser in Linux systems
		System.setProperty("sun.awt.xembedserver", "true");		
		// Enable better look-and-feel
        if (Util.onMac() || Util.onWindows()) {
        	//This sets the name of the application for Mac. However, it also requires a VM argument: -Xdock:name="Menthor Editor"
        	System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Menthor Editor");
            System.setProperty("com.apple.mrj.application.growbox.intrudes","true");
            System.setProperty("com.apple.mrj.application.live-resize","true");
            System.setProperty("com.apple.macos.useScreenMenuBar","true");
            System.setProperty("apple.laf.useScreenMenuBar","true");                        
            System.setProperty("com.apple.eawt.CocoaComponent.CompatibilityMode","false");
            System.setProperty("apple.awt.fileDialogForDirectories", "true");
        }        
		
        if(Util.onMac()){
        	System.setProperty("org.eclipse.emf.ecore.EPackage.Registry.INSTANCE", "org.eclipse.emf.ecore.impl.EPackageRegistryImpl");
        }else{
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	
        }
        
		//if (!onMac()&&!onWindows()) UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");		
		UIManager.put("TabbedPane.focus", new Color(0, 0, 0, 0));
	
		UIManager.put("OptionPane.yesButtonText","Yes");
		UIManager.put("OptionPane.noButtonText", "No");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		UIManager.put("OptionPane.titleText","Title");
	}
	
	/**
	 * Check args if there is a Menthor project to open
	 * If true, open it
	 * 
	 * @param args
	 */
	public static void checkAndOpenProject(final String[] args){
		String menthorFileName = "";
		for (String arg : args) {
			if(arg.endsWith(".menthor")){
				menthorFileName  = arg;
				break;
			}
		}
		if(!menthorFileName.equals("")){						
			ProjectManager.get().openProjectFromFile(menthorFileName);
		}	
	}
	
	/**  
	 * The start method for this application.
	 * @param args the command line parameters
	 */
	public static void main(final String[] args) 
	{	
		try {
			setSystemProperties();					
			UIFontUtil.setDefault();					
			SWTConfigurer.execute(DirectoryUtil.getBinDir());
			
			OwlSettingsMap.getInstance();
			
			//File alloyJarFile = Util.extractLib("alloy4.2.jar");
			//System.out.println("Extracted: "+alloyJarFile.getAbsolutePath());											
			frame = new AppFrame();
			TabManager.get().addStartEditor(false);
			frame.setLocationByPlatform(true);					
			checkAndOpenProject(args);					
			frame.setVisible(true);
			frame.toFront();	
			
				
		} catch (Exception ex) {
			MessageManager.get().showError(ex, "Menthor Editor", "Could not start Menthor Editor application due to an internal error.");
		}	
		splashScreen.close();
	}
	
	public static AppEditorTabbedPane getDiagramManager(){ return getFrame().getEditorTabbedPane(); }
	public static ProjectTree getProjectTree(){ return getFrame().getProjectBrowser().getTree(); }
	public static AppInfoTabbedPane getInfoManager(){ return getFrame().getInfoTabbedPane(); }	
}
