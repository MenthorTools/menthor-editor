package net.menthor.editor.v2.util;

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

import java.awt.Component;
import java.io.File;

import net.menthor.ontouml2ecore.OntoUML2Ecore;
import net.menthor.ontouml2ecore.OntoUML2EcoreOption;

import RefOntoUML.parser.OntoUMLParser;

public class EcoreWriter extends FileWriter {

	public void toEcore(Component parent, OntoUMLParser refparser, File outputfile) throws Exception{
		if (canWrite(parent, outputfile)){
			outputfile = Util.getFileWithExtension(outputfile, getSuffix());
			String path = outputfile.getAbsolutePath();				
			OntoUML2Ecore.convertToEcore(refparser,path,new OntoUML2EcoreOption(false,false));
		}
	}
	
	protected String getSuffix() { return ".ecore"; } 

}