package net.menthor.webcrawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Util {

	public static void downloadFileFromURL(String url, String path) throws IOException{
		URL url2 = new URL(url);
		try{
			InputStream in = url2.openStream();		
			File file = new File(path);
			if(file.exists()) {
				System.out.println("File already exists: "+path);
				return;
			}
			FileOutputStream fos = new FileOutputStream(file);
			System.out.println("Reading: "+url);
			int length = -1;
			byte[] buffer = new byte[1024];
			while ((length = in.read(buffer)) > -1) {
				fos.write(buffer, 0, length);
			}
			fos.close();
			in.close();
			System.out.println("File downloaded.");
		}catch(java.net.ConnectException e){
			System.out.println("Connection refused: "+url);
		}
	}
	
	public static String replaceInvalidCharacteres(String title){		
		return title.replaceAll("[:\\\\/*?|<>]", "_");
	}
}
