package net.menthor.editor.v2.log;

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
 * 
 * @author John Guerson
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

	public static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");	
	public static String getTime(){ return dateFormat.format(new Date()); }

	public static PrintStream psOut;
	public static PrintStream psErr;
	public static boolean USE_FILE = false;
	
	public static void redirect(boolean useFile) throws SecurityException, IOException 
	{
		USE_FILE = useFile;
		 // initialize logging to go to rolling log file
        LogManager logManager = LogManager.getLogManager();
        logManager.reset();

        File file = new File("menthor.log");
        if(file.exists()) file.delete();
        
        // log file max size 10M, 1 rolling files, append-on-open
        Handler fileHandler = new FileHandler("menthor.log", 10000000, 1, true);
        SimpleFormatter formatter = new SimpleFormatter();        
        fileHandler.setFormatter(formatter);
        Logger.getLogger("").addHandler(fileHandler);        

        // preserve old stdout/stderr streams in case they might be useful
        //PrintStream stdout = System.out;
        //PrintStream stderr = System.err;
	
        // now rebind stdout/stderr to logger
        Logger logger;
        
        logger = Logger.getLogger("stdout");
        LogOutputStream losOut = new LogOutputStream(logger, LogStdLevel.STDOUT);
        psOut = new PrintStream(losOut, true);
        System.setOut(psOut);
	
        logger = Logger.getLogger("stderr");
        LogOutputStream losErr = new LogOutputStream(logger, LogStdLevel.STDERR);
        psErr = new PrintStream(losErr, true);
        System.setErr(psErr);
    }
	
	@SuppressWarnings("unused")
	private static void printOut(String msg){
		Object[] array = msg.split("\n");
		for(Object obj: array){
			if(!USE_FILE) System.out.print(getTime()+" - "+obj);
			else System.out.print(obj);			
		}
	}

	@SuppressWarnings("unused")
	private static void printErr(String msg){
		Object[] array = msg.split("\n");
		for(Object obj: array){
			if(!USE_FILE) System.err.print(getTime()+" - "+obj);
			else System.err.print(obj);			
		}
	}
	
	@SuppressWarnings("unused")
	private static void printErrLn(String msg) {
		Object[] array = msg.split("\n");
		for(Object obj: array){
			if(!USE_FILE) System.err.println(getTime()+" - "+obj);
			else System.err.println(obj);			
		}
	}
	
	@SuppressWarnings("unused")
	private static void printOutLn(String msg){
		Object[] array = msg.split("\n");
		for(Object obj: array){
			if(!USE_FILE) System.out.println(getTime()+" - "+obj);
			else System.out.println(obj);			
		}		
	}
}
