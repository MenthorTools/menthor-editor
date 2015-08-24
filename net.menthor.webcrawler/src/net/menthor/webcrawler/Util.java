package net.menthor.webcrawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Util {

	public static void downloadFileFromURL(String url, String dirPath, String fileName) throws IOException{
		URL url2 = new URL(url);
		try{
			InputStream in = url2.openStream();	
			createDirectory(dirPath);
			File file = new File(dirPath+fileName);
			if(file.exists()) {
				System.out.println("File already exists: "+file.getAbsolutePath());
				return;
			}
			FileOutputStream fos = new FileOutputStream(file);			
			int length = -1;
			byte[] buffer = new byte[1024];
			while ((length = in.read(buffer)) > -1) {
				fos.write(buffer, 0, length);
			}
			fos.close();
			in.close();
			System.out.println("File downloaded: "+file.getAbsolutePath());
		}catch(java.net.ConnectException e){
			System.out.println("Connection refused: "+url);
		}
	}
	
	public static String replaceInvalidCharacteres(String title){		
		return title.replaceAll("[:\\\\/*?|<>]", "_");
	}
	
	public static void createDirectory(String dirPath){
		File theDir = new File(dirPath);	
		// if the directory does not exist, create it
		if (!theDir.exists()) {		    
		    boolean result = false;	
		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        //handle it
		    }
		    if(result) {    
		        System.out.println("DIR created: "+dirPath);  
		    }
		}
	}
}
