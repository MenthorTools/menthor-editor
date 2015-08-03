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

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;

import edu.mit.csail.sdg.alloy4.Util;

/** A helper class which provides settings and file management facilities. */
public final class MenthorConfigurator {
	
	private static File BIN_DIR = null;
	private static String TEMP_DIR = null;
	
	private static Properties propertiesStore;
		
	public static boolean saveProperties(){
		if(propertiesStore != null) {
			File file = new File(getCanonPath(getTempDir(), MenthorSettings.DEFAULT_SETTINGS_FILE.getValue()));
			try {
				FileOutputStream out = new FileOutputStream(file);
				propertiesStore.storeToXML(out, "Menthor Configuration File", "UTF-8");
				close(out);
				return true;
			} catch (Exception ex) {}
		}		
		return false;
	}
	
	public static Properties getProperties() {
		if(propertiesStore != null) return propertiesStore;		
		propertiesStore = new Properties();		
		File file = new File(getCanonPath(getTempDir(), MenthorSettings.DEFAULT_SETTINGS_FILE.getValue()));
		if(file.exists()) {
			try {
				FileInputStream in = new FileInputStream(file);
				propertiesStore.loadFromXML(in);
				close(in);
			} catch (Exception ex) {}
		}
		return propertiesStore;
	}

	public static void addRecentProject(String path) {
		if(!MenthorSettings.RECENT_PROJECT_1.getValue().equals(path)) {
			int histSize = 10;		
			for (int i = histSize-1; i > 0; i--) {
				MenthorSettings setting = MenthorSettings.valueOf("RECENT_PROJECT_" + i); 
				MenthorSettings nextSetting = MenthorSettings.valueOf("RECENT_PROJECT_" + (i + 1));
				nextSetting.setValue(setting.getValue());
			}			
			MenthorSettings.RECENT_PROJECT_1.setValue(path);
			saveProperties();
		}
	}
	
	public static String[] getRecentProjects() {
		int histSize = 10;
		String[] ans = new String[histSize];		
		for (int i = 1; i < histSize; i++) {
			ans[i] = MenthorSettings.valueOf("RECENT_PROJECT_" + i).getValue();
		}		
		return ans;
	}

	public static boolean onWindows() {
		return System.getProperty("os.name").toLowerCase(Locale.US).startsWith("windows");
	};

	public static boolean onMac() {
		return System.getProperty("mrj.version") != null || System.getProperty("os.name").toLowerCase(Locale.US).startsWith("mac ");
	}

	public static String getFileName(String filePath) {
		return new File(filePath).getName();
	}

	public static String getUserDir() {
		return canon(System.getProperty("user.name"));
	}

	public static String getCanonPath(String dir, String fileName) {
		return canon(dir + File.separatorChar + fileName);
	}
	
  /**
   * Inspects the name of the specified file and checks if it ends with the
   * specified suffix. If not, a new file will be created, appending the suffix
   * to the file name, otherwise the original file object will be returned. 
   */
	public static File getFileWithExtension(File file, String extension) {
	    String path = file.getPath();
	    File result = file;
	    Pattern pattern = Pattern.compile(".*\\" + extension);
	    if (!pattern.matcher(path).matches()) {
	      path = path + extension;
	      result = new File(path);
	    }
	    return result;
	  }
	
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
		String ans = canon(tempfile.getPath());		
		if (!tempfile.isDirectory()) {
			System.err.println("Error. Cannot create the temporary directory "	+ ans);
		}
		if (!onWindows()) {
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
		String ans = canon(tempfile.getPath());			
		if (!tempfile.isDirectory()) {
			System.out.println("Error. Cannot create the temporary directory "	+ ans);
		}
		if (!onWindows()){
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
	
	/** This returns the constant prefix to denote whether Util.readAll() should read from a JAR or read from the file system.
	 * (The reason we made this into a "method" rather than a constant String is that it is used
	 * by Util.canon() which is called by many static initializer blocks... so if we made this into a static field
	 * of Util, then it may not be initialized yet when we need it!)
	 */
	public static String jarPrefix() { return File.separator + "$alloy$" + File.separator; }
	   
	/** Returns the canonical absolute path for a file.
	    * If an IO error occurred, or if the file doesn't exist yet,
	    * we will at least return a noncanonical but absolute path for it.
	    * <p> Note: if filename=="", we return "".
	    */
	public static final String canonical(String filename) {
		if (filename==null || filename.length()==0) return "";
		if (filename.startsWith(jarPrefix())) {
			char sep = File.separatorChar, other = (sep=='/' ? '\\' : '/');
			return filename.replace(other, sep);
		}
		File file = new File(filename);
		try { 
			return file.getCanonicalPath(); 
		} catch(IOException ex) { 
			return file.getAbsolutePath(); 
		}
	}

	public static final String canon(String filename) {
		if (filename == null || filename.length() == 0) return "";		
		File file = new File(filename);
		try {
			return file.getCanonicalPath();
		} catch (IOException ex) {
			return file.getAbsolutePath();
		}
	}
	
	/**
	 * Copy the list of files from JAR into the destination directory, then set
	 * the correct permissions on them if possible.
	 * 
	 * @param executable - if true, we will attempt to set the file's "executable" permission (failure to do this is ignored)
	 * @param keepPath   - if true, the full path will be created for the destination file
	 * @param destdir    - the destination directory
	 * @param names      - the files to copy from the JAR
	 */
	public static void copy(boolean executable, boolean keepPath, String destdir, String... names) {
		String[] args = new String[names.length + 2];
		// This does not work on Windows, but the  "executable" bit is not needed on Windows anyway.
		args[0] = "/bin/chmod"; 
		// 700 means read+write+executable; 600 means read+write.
		args[1] = (executable ? "700" : "600"); 
		int j = 2;
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			String destname = name;
			if (!keepPath) {
				int ii = destname.lastIndexOf('/');
				if (ii >= 0) destname = destname.substring(ii + 1);
			}
			destname = (destdir + '/' + destname).replace('/', File.separatorChar);
			int last = destname.lastIndexOf(File.separatorChar);
			new File(destname.substring(0, last + 1)).mkdirs(); // Error will be caught later by the file copy
			if (copy(name, destname)) {
				args[j] = destname;
				j++;
			}
		}
		if (onWindows() || j <= 2) return;
		String[] realargs = new String[j];
		for (int i = 0; i < j; i++) realargs[i] = args[i];
		try {
			Runtime.getRuntime().exec(realargs).waitFor();
		} catch (Throwable ex) { } // We only intend to make a best effort
	}

	/**
	 * Copy the given file from JAR into the destination file; if the
	 * destination file exists, we then do nothing. Returns true iff a file was
	 * created and written.
	 */
	private static boolean copy(String sourcename, String destname) {
		File destfileobj = new File(destname);
		if (destfileobj.isFile() && destfileobj.length() > 0) return false;
		boolean result = true;
		InputStream in = null;
		FileOutputStream out = null;
		try {
			in = MenthorConfigurator.class.getClassLoader().getResourceAsStream(sourcename);
			// This means the file is not relevant for this setup, so we don't pop up a fatal dialog
			if (in == null) return false; 
			out = new FileOutputStream(destname);
			byte[] b = new byte[16384];
			while (true) {
				int numRead = in.read(b);
				if (numRead < 0) break;
				if (numRead > 0) out.write(b, 0, numRead);
			}
		} catch (IOException e) {
			result = false;
		}
		if (!close(out)) result = false;
		if (!close(in)) result = false;
		if (!result) System.err.println("Error occurred in creating the file \"" + destname + "\"");
		return true;
	}

	/**
	 * Attempt to close the file/stream/reader/writer and return true if and
	 * only if we successfully closed it. (If object==null, we return true right away)
	 */
	public static boolean close(Closeable object) {
		if (object == null) return true;
		boolean ans = true;
		try {
			if (object instanceof PrintStream && ((PrintStream) object).checkError()) ans = false;
			if (object instanceof PrintWriter && ((PrintWriter) object).checkError()) ans = false;
			object.close();
			return ans;
		} catch (Throwable ex) {
			return false;
		}
	}
	
	/** Extract a file from menthor's /lib class path */
	public static File extractLib(String fileNameWithExtension) throws IOException
	{
		String destFolderPath = MenthorConfigurator.class.getProtectionDomain().getCodeSource().getLocation().getPath();	
		if(destFolderPath.lastIndexOf("/") < destFolderPath.lastIndexOf(".")){
			int lastBar = destFolderPath.lastIndexOf("/");
			destFolderPath = destFolderPath.substring(0, lastBar+1);
		}
		destFolderPath += fileNameWithExtension;
		String alloyPath = URLDecoder.decode(destFolderPath, "UTF-8");		
		File alloyJarFile = new File(alloyPath);
		if (alloyJarFile.exists()) {
			return alloyJarFile;
		}				
		InputStream is = MenthorConfigurator.class.getClassLoader().getResourceAsStream(fileNameWithExtension);		
		if(is == null){
			is = new FileInputStream("lib/"+fileNameWithExtension);
		}
		OutputStream out = new FileOutputStream(alloyJarFile);				
		// copy data flow -> MB x MB
		byte[] src = new byte[1024];
		int read = 0;
		while ((read = is.read(src)) != -1){
			out.write(src, 0, read);
		}
		is.close();
		out.flush();
		out.close();		
		return alloyJarFile;
	}
}
