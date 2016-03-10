package net.menthor.editor.v2.util;

import java.awt.Color;
import java.util.Locale;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SystemUtil {

	public static boolean onMac() {
		return System.getProperty("mrj.version") != null || System.getProperty("os.name").toLowerCase(Locale.US).startsWith("mac ");
	}
	
	public static boolean onWindows() {
		return System.getProperty("os.name").toLowerCase(Locale.US).startsWith("windows");
	};
	
	public static String getOSx(){ 
		if (onWindows()) return "win"; else if (onMac()) return "mac"; else return "linux"; 
	}
			
	public static String getArch() { 
		String osArch = System.getProperty("os.arch").toLowerCase();
		String arch = osArch.contains("64") ? "x64" : "x86";                
        return arch;
	}
	
	public static void set() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{		
		//Needed for the embedded SWT Browser in Linux systems
		System.setProperty("sun.awt.xembedserver", "true");		
		// Enable better look-and-feel
        if (onMac() || onWindows()) {
        	//This sets the name of the application for Mac. However, it also requires a VM argument: -Xdock:name="Menthor Editor"
        	System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Menthor Editor");
            System.setProperty("com.apple.mrj.application.growbox.intrudes","true");
            System.setProperty("com.apple.mrj.application.live-resize","true");
            System.setProperty("com.apple.macos.useScreenMenuBar","true");
            System.setProperty("apple.laf.useScreenMenuBar","true");                        
            System.setProperty("com.apple.eawt.CocoaComponent.CompatibilityMode","false");
            System.setProperty("apple.awt.fileDialogForDirectories", "true");
        }
        if(onMac()){
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
}
