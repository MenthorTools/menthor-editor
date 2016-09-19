/***************************************************************************
 * SWT Autoloader - everything in a jar                                    *
 * Copyright (C) 2005 by Silvio Moioli                                     *
 * silvio@moioli.net                                                       * 
 *                                                                         *
 * A brief tutorial on how to use this class is provided in the readme     *
 * file included in the distribution package.                              *
 * Use of this software is subject to the terms in the LICENSE.txt file    *
 ***************************************************************************/
package net.menthor.swt;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 
 * Enables SWT auto-loading from the jar file. A brief tutorial on how to use
 * this class is provided in the readme file included in the distribution
 * package.
 * 
 * @author Silvio Moioli, John Guerson
 * 
 * @version 1.1
 */

public class BinaryLoader {
	
	private File jarFile = null;	
	public File getJarFile() { return jarFile; }
	
	private String osx = "undef";
	private String arch = "undef";
		
	public static void load(File binDir) throws LoadingException, IOException
	{	
		BinaryLoader loader = new BinaryLoader(null, Util.getOSx(), Util.getArch());		
		loader.extract(binDir);
		loader.includeInJavaPath(binDir);		
	}

	/** Constructor */
	private BinaryLoader(String jarName, String osx, String arch) {
		this.osx = osx;		
		this.arch = arch;
		if (jarName!=null  && !jarName.isEmpty()){		
			String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();		
			String fileName = path+jarName;		
			try{
				String decodedPath = URLDecoder.decode(fileName, "UTF-8");			
			    jarFile = new File(decodedPath);
			    if(!jarFile.exists()) return;
			}catch(UnsupportedEncodingException cantHappen){ 
				/*Never gets here*/ 
			}			
		}
	}
	
	/** Extract */
	private void extract(File binDir)
	{
		try {
			if(osx=="win"&& arch=="x64"){		
				Util.extract("swt-awt-win32-4527-x64.dll",binDir);
				Util.extract("swt-gdip-win32-4527-x64.dll",binDir);								
				Util.extract("swt-wgl-win32-4527-x64.dll",binDir);
				Util.extract("swt-win32-4527-x64.dll",binDir);
				Util.extract("swt-xulrunner-win32-4527-x64.dll",binDir);
			}
			if(osx=="win" && arch=="x86"){
				Util.extract("swt-awt-win32-4332-x86.dll",binDir);
				Util.extract("swt-gdip-win32-4332-x86.dll",binDir);								
				Util.extract("swt-wgl-win32-4332-x86.dll",binDir);
				Util.extract("swt-win32-4332-x86.dll",binDir);
				Util.extract("swt-xulrunner-win32-4332-x86.dll",binDir);
				Util.extract("swt-webkit-win32-4332-x86.dll",binDir);
			}
			if(osx=="mac" && arch=="x86"){
				Util.extract("libswt-awt-cocoa-4332-x86.jnilib",binDir);
				Util.extract("libswt-cocoa-4332-x86.jnilib",binDir);				
				Util.extract("libswt-pi-cocoa-4332-x86.jnilib",binDir);
				Util.extract("libswt-xulrunner-cocoa-4332-x86.jnilib",binDir);				
			}
			if(osx=="mac" && arch=="x64"){
				Util.extract("libswt-awt-cocoa-4332-x64.jnilib",binDir);
				Util.extract("libswt-cocoa-4332-x64.jnilib",binDir);				
				Util.extract("libswt-pi-cocoa-4332-x64.jnilib",binDir);
				Util.extract("libswt-xulrunner-cocoa-4332-x64.jnilib",binDir);				
			}
			if(osx=="linux" && arch=="x64"){
				Util.extract("libswt-atk-gtk-4332-x64.so",binDir);
				Util.extract("libswt-awt-gtk-4332-x64.so",binDir);				
				Util.extract("libswt-cairo-gtk-4332-x64.so",binDir);
				Util.extract("libswt-glx-gtk-4332-x64.so",binDir);				
				Util.extract("libswt-gnome-gtk-4332-x64.so",binDir);
				Util.extract("libswt-gtk-4332-x64.so",binDir);
				Util.extract("libswt-mozilla-gtk-4332-x64.so",binDir);
				Util.extract("libswt-pi-gtk-4332-x64.so",binDir);
				Util.extract("libswt-pi3-gtk-4332-x64.so",binDir);
				Util.extract("libswt-webkit-gtk-4332-x64.so",binDir);
				Util.extract("libswt-xpcominit-gtk-4332-x64.so",binDir);
				Util.extract("libswt-xulrunner-fix-x64.so",binDir);
				Util.extract("libswt-xulrunner-gtk-4332-x64.so",binDir);
			}
			if(osx=="linux" && arch=="x86"){
				Util.extract("libswt-atk-gtk-4332-x86.so",binDir);
				Util.extract("libswt-awt-gtk-4332-x86.so",binDir);				
				Util.extract("libswt-cairo-gtk-4332-x86.so",binDir);
				Util.extract("libswt-glx-gtk-4332-x86.so",binDir);				
				Util.extract("libswt-gnome-gtk-4332-x86.so",binDir);
				Util.extract("libswt-gtk-4332-x86.so",binDir);
				Util.extract("libswt-mozilla-gtk-4332-x86.so",binDir);
				Util.extract("libswt-pi-gtk-4332-x86.so",binDir);
				Util.extract("libswt-pi3-gtk-4332-x86.so",binDir);
				Util.extract("libswt-webkit-gtk-4332-x86.so",binDir);
				Util.extract("libswt-xpcominit-gtk-4332-x86.so",binDir);
				Util.extract("libswt-xulrunner-fix-x86.so",binDir);
				Util.extract("libswt-xulrunner-gtk-4332-x86.so",binDir);
			}
			
		} catch (LoadingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void includeInJavaPath(File binDir)
	{
        try {
            System.setProperty("java.library.path", binDir.getAbsolutePath());
            // The above line is actually useless on Sun JDK/JRE (see Sun's bug ID 4280189)
            // The following 4 lines should work for Sun's JDK/JRE (though they probably won't work for others)
            String[] newarray = new String[]{binDir.getAbsolutePath()};
            java.lang.reflect.Field old = ClassLoader.class.getDeclaredField("usr_paths");
            old.setAccessible(true);
            old.set(null,newarray);
        } catch (Throwable ex) {
        	/* Should never get here */
        }
	}
}
