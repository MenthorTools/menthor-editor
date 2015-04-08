package net.menthor.editor.ui.commands;

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
import java.io.IOException;

import net.menthor.editor.model.UmlProject;
import net.menthor.editor.util.ModelHelper;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.tinyuml.ui.commands.FileWriter;

public class OntoUMLExporter extends FileWriter {

	public void writeOntoUML(Component comp, File file, UmlProject project) throws IOException 
	{
		if (canWrite(comp, file)) 
		{
			URI path = URI.createFileURI(getFileWithExtension(file).getPath());
			Resource resource = project.getResource();
			resource.setURI(path);
			ModelHelper.saveXMI(resource);
		}
	}

	protected String getSuffix() 
	{
		return ".refontouml";
	}
}
