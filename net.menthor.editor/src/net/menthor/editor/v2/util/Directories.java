package net.menthor.editor.v2.util;

/*
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
import java.util.Date;
import java.util.Random;

public final class Directories {
	
	private static File BIN_DIR = null;
	private static String TEMP_DIR = null;
		
	/** Create an empty temporary directory for use, designate it "deleteOnExit", then return it.
     *  It is guaranteed to be a canonical absolute path. */
    public static String makeTempDir() {
    	return makeDir(new File(getTempDir()));
    }

	/** Create an empty temporary directory for use, designate it "deleteOnExit", then return it.
     *  It is guaranteed to be a canonical absolute path. */
    public static String makeBinDir() {
    	return makeDir(getBinDir());
    }
    
    public static String makeDir(File binDir) {
        Random r=new Random(new Date().getTime());
        while(true) {
            int i=r.nextInt(1000000);
            String dest = binDir.getAbsolutePath() + File.separatorChar+i;
            File f=new File(dest);
            if (f.mkdirs()) {
                f.deleteOnExit();
                return Util.canon(dest);
            }
        }
    }
    
	/** Return menthor temporary directory */
	public static String getTempDir() {
		if (TEMP_DIR != null) return TEMP_DIR;		
		String temp = System.getProperty("java.io.tmpdir");		
		if (temp == null || temp.length() == 0){
			System.err.println("Error. JVM need to specify a temporary directory using java.io.tmpdir property.");
		}
		//String username = System.getProperty("user.name");
		File tempfile = new File(temp + File.separatorChar + "menthor_tmp");		
		tempfile.mkdirs();
		String ans = Util.canon(tempfile.getPath());		
		if (!tempfile.isDirectory()) {
			System.err.println("Error. Cannot create the temporary directory "	+ ans);
		}
		if (!Util.onWindows()) {
			String[] args = { "chmod", "700", ans };
			try {
				Runtime.getRuntime().exec(args).waitFor();
			}catch (Throwable ex) {
				// We only intend to make a best effort.
			}
		}		
		return TEMP_DIR = ans;
	}

	public static File getBinDir() {
		if (BIN_DIR != null) return BIN_DIR;	
		String temp = System.getProperty("java.io.tmpdir");			
		if (temp == null || temp.length() == 0) {
			System.out.println("Error. JVM need to specify a temporary directory using java.io.tmpdir property.");
		}
		//String username = System.getProperty("user.name");
		File tempfile = new File(temp + File.separatorChar + "menthor_bin");			
		tempfile.mkdirs();
		String ans = Util.canon(tempfile.getPath());			
		if (!tempfile.isDirectory()) {
			System.out.println("Error. Cannot create the temporary directory "	+ ans);
		}
		if (!Util.onWindows()){
			String[] args = { "chmod", "700", ans };
			try {
				Runtime.getRuntime().exec(args).waitFor();
			} catch (Throwable ex) {
				// We only intend to make a best effort.
			} 
		}				
		BIN_DIR = tempfile.getAbsoluteFile();		
		return BIN_DIR;
	}		
}
