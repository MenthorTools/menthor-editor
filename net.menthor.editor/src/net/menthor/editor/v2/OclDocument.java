package net.menthor.editor.v2;

/**
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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import RefOntoUML.impl.PackageableElementImpl;
import net.menthor.tocl.parser.TOCLParser;

public class OclDocument extends PackageableElementImpl implements Serializable {
		
	private static final long serialVersionUID = 1L;

	private Object container;
	public Object getContainer() { return container; }
	public void setContainer(Object epackage) { this.container = epackage; }
	
	private String oclstring = new String();
	public String getContentAsString() { return oclstring; }	
	public void setContentAsString(String oclcontent) { String content = oclcontent; this.oclstring = content; }
	public void addContentAsString(String oclcontent) { oclstring += "\n"+oclcontent+"\n"; }
	
	private String oclAbsolutePath =  new String();	
	public String getAbsolutePath() { return oclAbsolutePath; }	
	public void setAbsolutePath (String path) { oclAbsolutePath = path; }
	
	private TOCLParser oclparser;	
	public TOCLParser getParser() { return oclparser; }
	public void setParser(TOCLParser oclparser) { this.oclparser = oclparser; }
	
	@Override
	public String toString() { return name; }
	
	public void clear() {
		name="";
		oclstring="";
		oclAbsolutePath="";
		oclparser=null;
	}

	public String readFile (String filePath) throws IOException {
		String result = new String();		
		FileInputStream fstream = new FileInputStream(filePath);			
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;			
		while ((strLine = br.readLine()) != null) {
			result += strLine+"\n";
		}
		in.close();		
		return result;
	}
	
	public enum OclLoadType { FILE_PATH, STRING_CONTENT }
	
	public void load(String str, OclLoadType type) throws IOException {
		if  (type==OclLoadType.FILE_PATH){
			String content = readFile(str);			
			this.oclstring = content;						
			this.oclAbsolutePath = str;
			this.name = str.substring(str.lastIndexOf(File.separator),str.lastIndexOf("."));			
		}else if (type==OclLoadType.STRING_CONTENT){			
			String content = str;			
			this.oclstring = content;		
			this.oclAbsolutePath=null;
		}
	}
}

