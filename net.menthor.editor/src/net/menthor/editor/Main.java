package net.menthor.editor;

/**
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.menthor.editor.v2.ui.SplashScreen;
import net.menthor.editor.v2.util.Directories;
import net.menthor.editor.v2.util.UIFontUtil;
import net.menthor.editor.v2.util.Util;

import org.eclipse.swt.SWTConfigurer;

/**
 * This is the start class of the Menthor Editor application. Menthor Editor is based on the TinyUML project by Wei-ju Wu.
 * It also benefits from MIT's project called Alloy developed by Daniel Jackson (see http://alloy.mit.edu/)
 * 
 * @author John Guerson
 */
public final class Main {
	
	public static AppFrame frame; 

	/**
	 * This variable MUST be composed as "a.b.c". Increment when is built a:
	 * 		a: new version of this application
	 * 		b: compilation with new features
	 * 		c: compilation with bug fixes
	 */	
	public static String MENTHOR_VERSION = "1.1.0 test"; 
	
	public static String MENTHOR_COMPILATION_DATE = getCompilationDateMessage();
	
	public static SplashScreen splashScreen = new SplashScreen(MENTHOR_VERSION, MENTHOR_COMPILATION_DATE);
	    
	/**
	 * get compilation date message.
	 */
	private static String getCompilationDateMessage(){
		DateFormat dateFormat = new SimpleDateFormat("d, yyyy");
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		return c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH ) + " " + dateFormat.format(date);
	}
	
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
	 * Private constructor.
	 */
	private Main() { }
	
	
	
	public static void publish(final String msg)
	{
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				Thread thread = new Thread() {
				      public void run() {
						splashScreen.setStatusLabel(msg);										
					}
				};
				thread.start();
			}
		});
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
					publish("Redirecting system to a log...");					
					//Log.redirect(false);
					
					publish("Setting system properties...");
					setSystemProperties();
					
					publish("Setting system font...");
					UIFontUtil.setDefault();
					
					publish("Configuring SWT");
					SWTConfigurer.execute(Directories.getBinDir());
					
					publish("Extracting Alloy files...");
					File alloyJarFile = Util.extractLib("alloy4.2.jar");
					System.out.println("Extracted: "+alloyJarFile.getAbsolutePath());
					
					publish("Loading application...");						
					frame = new AppFrame();
					
					publish("Setting window location...");
					frame.setLocationByPlatform(true);
					
					String menthorFileName = "";
					for (String arg : args) {
						if(arg.endsWith(".menthor")){
							menthorFileName  = arg;
							break;
						}
					}
					if(!menthorFileName.equals("")){
						publish("Opening project: " + menthorFileName + "...");
						frame.getDiagramManager().openProject(menthorFileName);
					}
					
					//publish("Enjoy Menthor Editor!");
					//Thread.sleep(1000);
					
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
