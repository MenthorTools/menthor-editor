package net.menthor.swt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Locale;

public class Util {
	
	public static String getBinWorkingDir() {
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
		
	public static String extract(String fileName, File destinationFolder) throws LoadingException, IOException
	{
		String binPackage = new String();		
		String outFolder = destinationFolder.getAbsolutePath()+File.separator+fileName;		
		String outPath = URLDecoder.decode(outFolder, "UTF-8");		
		File outFile = new File(outPath);						 
		String binResource = URLDecoder.decode(binPackage+fileName,"UTF-8");
		String binWorkingDir = URLDecoder.decode(getBinWorkingDir()+binPackage+File.separator+fileName,"UTF-8");
		InputStream is = Util.class.getClassLoader().getResourceAsStream(binResource);	
		if(is==null) is = Util.class.getClassLoader().getResourceAsStream(File.separator+binResource);	
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
}
