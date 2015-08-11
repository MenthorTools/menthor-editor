package net.menthor.editor;

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
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.menthor.editor.v2.ui.SplashScreen;
import net.menthor.editor.v2.util.Directories;
import net.menthor.editor.v2.util.UIFontUtil;
import net.menthor.editor.v2.util.Util;

import org.eclipse.swt.SWTConfigurer;

public final class Main {
	
	public static MainFrame frame; 

	/**
	 * This variable MUST be composed as "a.b.c". Increment when is built a:
	 * 		a: new version of this application
	 * 		b: compilation with new features
	 * 		c: compilation with bug fixes
	 */	
	public static String MENTHOR_VERSION = "1.1.0 test";	
	public static String MENTHOR_COMPILATION_DATE = Util.getCompilationDateMessage();	
	public static SplashScreen splashScreen = new SplashScreen(MENTHOR_VERSION, MENTHOR_COMPILATION_DATE);
	
	/** Set System properties according to each Operating System */
	public static void setSystemProperties() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		//Needed for the embedded SWT Browser in Linux systems
		System.setProperty("sun.awt.xembedserver", "true");		
		// Enable better look-and-feel
        if (Util.onMac() || Util.onWindows()) {
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Menthor");
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
	 * The start method for this application.
	 * @param args the command line parameters
	 */
	public static void main(final String[] args) 
	{	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {				
				try {
					setSystemProperties();					
					UIFontUtil.setDefault();					
					SWTConfigurer.execute(Directories.getBinDir());					
					File alloyJarFile = Util.extractLib("alloy4.2.jar");
					System.out.println("Extracted: "+alloyJarFile.getAbsolutePath());											
					frame = new MainFrame();					
					frame.setLocationByPlatform(true);					
					String menthorFileName = "";
					for (String arg : args) {
						if(arg.endsWith(".menthor")){
							menthorFileName  = arg;
							break;
						}
					}
					if(!menthorFileName.equals("")){						
						frame.getDiagramManager().openProject(menthorFileName);
					}					
					frame.setVisible(true);
					frame.toFront();	
					splashScreen.close();					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "An unexpected error has ocurred.\n" + ex.getMessage(), "Sorry", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}					
			}			
		});				
	}
}
