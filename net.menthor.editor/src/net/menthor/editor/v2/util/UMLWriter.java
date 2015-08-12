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

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.ontouml2uml.OntoUML2UML;
import net.menthor.ontouml2uml.OntoUML2UMLOption;

public class UMLWriter extends FileWriter {

	public void toProfileUML(Component parent, OntoUMLParser refparser, File outputfile) throws Exception{
		if (canWrite(parent, outputfile)){
			outputfile = Util.getFileWithExtension(outputfile, getSuffix());
			String umlPath = outputfile.getAbsolutePath();				
			OntoUML2UML.convertToUMLProfile(refparser,umlPath,new OntoUML2UMLOption(false,false));
		}
	}

	public void toUML(Component parent, OntoUMLParser refparser, File outputfile) throws Exception{
		if (canWrite(parent, outputfile)){
			outputfile = Util.getFileWithExtension(outputfile, getSuffix());
			String umlPath = outputfile.getAbsolutePath();				
			OntoUML2UML.convertToUML(refparser,umlPath,new OntoUML2UMLOption(false,false));
		}	
	}
	
	protected String getSuffix() { return ".uml"; }
}