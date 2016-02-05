package net.menthor.installer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import net.menthor.editor.Main;


public class WindowsInstaller implements Installer{
	public WindowsInstaller() throws IOException {
		configureInnoFile();
	}
	
	public void configureInnoFile() throws IOException{
		File file = new File("resources/windows/menthor.iss");
		
		FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(new BufferedReader(reader));
        String txt = "";
        while (scanner.hasNextLine()){
        	txt += scanner.nextLine()+"\n";
        }
        
        Pattern p = Pattern.compile("[^;]#define(.+)?MENTHOR_VERSION");
    	Matcher m = p.matcher(txt);
    	int blockEnd = 0;
    	while(m.find()){
    		blockEnd = m.end();
    		break;
    	}
    	
    	int firstQuote = txt.indexOf('"', blockEnd)+1;
    	int secondQuote = txt.indexOf('"', firstQuote);
    	
    	System.out.println(txt.subSequence(firstQuote, secondQuote));
    	
    	String version = net.menthor.editor.v2.MenthorEditor.MENTHOR_VERSION;
    	//String version = "2.3.4.5";
    	System.out.println(version);
    	txt = txt.substring(0, firstQuote) + version + txt.substring(secondQuote, txt.length());
    	
    	scanner.close();
    	
    	FileWriter file_result = new FileWriter(file);
        file_result.write(txt);
        file_result.close();
	}
}
