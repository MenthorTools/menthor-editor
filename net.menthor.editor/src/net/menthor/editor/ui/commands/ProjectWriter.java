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
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.tinyuml.ui.commands.FileWriter;

import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.util.MenthorSettings;

/**
 * This class writes the current model and diagram data to an XML file.
 */
public final class ProjectWriter extends FileWriter {

	private static ProjectWriter instance = new ProjectWriter();

	/**
	 * Returns the singleton instance.
	 */
	public static ProjectWriter getInstance() {
		return instance;
	}

	/**
	 * Writes the specified UmlProject to a file.
	 */
	public File writeProject(Component comp, File file, UmlProject project, ArrayList<OclDocument> oclDocList) throws IOException {

		File outFile = getFileWithExtension(file);
		FileOutputStream dest = new FileOutputStream(outFile);
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
		
		System.out.println("Saving model XMI information in Menthor file...");
		//Save the model as a resource inside the file
		ZipEntry modelEntry = new ZipEntry(MenthorSettings.DEFAULT_MODEL_FILE.getValue());			
		out.putNextEntry(modelEntry);
		Resource resource = project.getResource();
		resource.save(out, Collections.EMPTY_MAP);
		out.closeEntry();
		
		System.out.println("Saving project DAT information in Menthor file...");
		//Save the project a.k.a the diagrams inside the file
		ZipEntry projectEntry = new ZipEntry(MenthorSettings.DEFAULT_PROJECT_FILE.getValue());
		out.putNextEntry(projectEntry);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(project); 
		oos.flush();
		out.closeEntry();
		
		System.out.println("Saving OCL constraints in Menthor file...");
		//Save the OCL content in the editor inside the file
		for(OclDocument oclDoc: oclDocList){
			String filename = new String();			
			filename = oclDoc.getName();
			ZipEntry  constraintEntry = new ZipEntry(filename+".ocl");			
			out.putNextEntry(constraintEntry);
			out.write(oclDoc.getContentAsString().getBytes());
			out.closeEntry();
		}
		
		System.out.println("Finalizing Menthor file...");
		//Flushes and closes the zip file
		out.flush();
		out.finish();
		out.close();

		return outFile;
	}
	
	public String getSuffix() 
	{
		return ".menthor";
	}
}
