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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
				execute("swt-awt-win32-4332-x64.dll",binDir);
				execute("swt-gdip-win32-4332-x64.dll",binDir);								
				execute("swt-wgl-win32-4332-x64.dll",binDir);
				execute("swt-win32-4332-x64.dll",binDir);
				execute("swt-xulrunner-win32-4332-x64.dll",binDir);
			}
			if(osx=="win" && arch=="x86"){
				execute("swt-awt-win32-4332-x86.dll",binDir);
				execute("swt-gdip-win32-4332-x86.dll",binDir);								
				execute("swt-wgl-win32-4332-x86.dll",binDir);
				execute("swt-win32-4332-x86.dll",binDir);
				execute("swt-xulrunner-win32-4332-x86.dll",binDir);
				execute("swt-webkit-win32-4332-x86.dll",binDir);
			}
			if(osx=="mac" && arch=="x86"){
				execute("libswt-awt-cocoa-4332-x86.jnilib",binDir);
				execute("libswt-cocoa-4332-x86.jnilib",binDir);				
				execute("libswt-pi-cocoa-4332-x86.jnilib",binDir);
				execute("libswt-xulrunner-cocoa-4332-x86.jnilib",binDir);				
			}
			if(osx=="mac" && arch=="x64"){
				execute("libswt-awt-cocoa-4332-x64.jnilib",binDir);
				execute("libswt-cocoa-4332-x64.jnilib",binDir);				
				execute("libswt-pi-cocoa-4332-x64.jnilib",binDir);
				execute("libswt-xulrunner-cocoa-4332-x64.jnilib",binDir);				
			}
			if(osx=="linux" && arch=="x64"){
				execute("libswt-atk-gtk-4332-x64.so",binDir);
				execute("libswt-awt-gtk-4332-x64.so",binDir);				
				execute("libswt-cairo-gtk-4332-x64.so",binDir);
				execute("libswt-glx-gtk-4332-x64.so",binDir);				
				execute("libswt-gnome-gtk-4332-x64.so",binDir);
				execute("libswt-gtk-4332-x64.so",binDir);
				execute("libswt-mozilla-gtk-4332-x64.so",binDir);
				execute("libswt-pi-gtk-4332-x64.so",binDir);
				execute("libswt-pi3-gtk-4332-x64.so",binDir);
				execute("libswt-webkit-gtk-4332-x64.so",binDir);
				execute("libswt-xpcominit-gtk-4332-x64.so",binDir);
				execute("libswt-xulrunner-fix-x64.so",binDir);
				execute("libswt-xulrunner-gtk-4332-x64.so",binDir);
			}
			if(osx=="linux" && arch=="x86"){
				execute("libswt-atk-gtk-4332-x86.so",binDir);
				execute("libswt-awt-gtk-4332-x86.so",binDir);				
				execute("libswt-cairo-gtk-4332-x86.so",binDir);
				execute("libswt-glx-gtk-4332-x86.so",binDir);				
				execute("libswt-gnome-gtk-4332-x86.so",binDir);
				execute("libswt-gtk-4332-x86.so",binDir);
				execute("libswt-mozilla-gtk-4332-x86.so",binDir);
				execute("libswt-pi-gtk-4332-x86.so",binDir);
				execute("libswt-pi3-gtk-4332-x86.so",binDir);
				execute("libswt-webkit-gtk-4332-x86.so",binDir);
				execute("libswt-xpcominit-gtk-4332-x86.so",binDir);
				execute("libswt-xulrunner-fix-x86.so",binDir);
				execute("libswt-xulrunner-gtk-4332-x86.so",binDir);
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
	
	private String execute(String binName, File binDir) throws LoadingException, IOException
	{
		String binPackage = new String();		
		String outFolder = binDir.getAbsolutePath()+File.separator+binName;		
		String outPath = URLDecoder.decode(outFolder, "UTF-8");		
		File outFile = new File(outPath);
		if (outFile.exists()) return outFile.getAbsolutePath();				 
		String binResource = URLDecoder.decode(binPackage+binName,"UTF-8");
		String binWorkingDir = URLDecoder.decode(getBinWorkingDir()+binPackage+File.separator+binName,"UTF-8");
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(binResource);	
		if(is==null) is = this.getClass().getClassLoader().getResourceAsStream(File.separator+binResource);	
		if(is !=null) System.out.println("Reading from: "+binResource);
		if(is ==null) System.out.println("Reading from: "+binWorkingDir);
		if(is == null) is = new FileInputStream(binWorkingDir);		
		OutputStream out = new FileOutputStream(outFile);				
		// =========================
		// copy data flow -> MB x MB
		byte[] src = new byte[1024];
		int read = 0;
		while ((read = is.read(src)) != -1){
			out.write(src, 0, read);
		}
		is.close();
		out.flush();
		out.close();
		// =========================
		System.out.println("Extracted: "+outFile.getAbsolutePath());
		return outFile.getAbsolutePath();
	}

	private String getBinWorkingDir() {
		String dir = System.getProperty("user.dir");
		if (dir.contains("net.menthor.editor")) 
			dir = dir.replace("net.menthor.editor","net.menthor.swt").concat(File.separator).concat("src"+File.separator);
		else
			dir = "";
		return dir;
	}
}
