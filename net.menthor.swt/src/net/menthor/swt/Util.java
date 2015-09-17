package net.menthor.swt;

import java.io.File;
import java.util.Locale;

public class Util {
	
	public String getBinWorkingDir() {
		String dir = System.getProperty("user.dir");
		if (dir.contains("net.menthor.editor")) 
			dir = dir.replace("net.menthor.editor","org.eclipse.swt").concat(File.separator).concat("src"+File.separator);
		else
			dir = "";
		return dir;
	}
	
	public static String getSwtFileName(){
		return "swt-"+Util.getOSx()+"-"+Util.getArch()+".jar";    	
	}
	
	public static String getOSx(){ 
		if (onWindows()) return "win"; else if (onMac()) return "mac"; else return "linux"; 
	}
			
	public static String getArch(){ 
		String osArch = System.getProperty("os.arch").toLowerCase();
		String arch = osArch.contains("64") ? "x64" : "x86";                
        return arch;
	}
	
	public static boolean onWindows() {
		return System.getProperty("os.name").toLowerCase(Locale.US).startsWith("windows");
	};
		
	public static boolean onMac() {
      return System.getProperty("mrj.version")!=null || System.getProperty("os.name").toLowerCase(Locale.US).startsWith("mac ");                                     
	}
}
