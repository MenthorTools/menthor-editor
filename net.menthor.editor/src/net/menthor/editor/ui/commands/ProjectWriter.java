package net.menthor.editor.ui.commands;

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

import net.menthor.editor.Main;
import net.menthor.editor.model.OCLDocument;
import net.menthor.editor.model.UmlProject;
import net.menthor.editor.util.MenthorSettings;

import org.eclipse.emf.ecore.resource.Resource;
import org.tinyuml.ui.commands.FileWriter;

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
	public File writeProject(Component comp, File file, UmlProject project, ArrayList<OCLDocument> oclDocList) throws IOException {

		File outFile = getFileWithExtension(file);
		FileOutputStream dest = new FileOutputStream(outFile);
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
		
		Main.printOutLine("Saving model XMI information in Menthor file...");
		//Save the model as a resource inside the file
		ZipEntry modelEntry = new ZipEntry(MenthorSettings.MODEL_DEFAULT_FILE.getValue());			
		out.putNextEntry(modelEntry);
		Resource resource = project.getResource();
		resource.save(out, Collections.EMPTY_MAP);
		out.closeEntry();
		
		Main.printOutLine("Saving project DAT information in Menthor file...");
		//Save the project a.k.a the diagrams inside the file
		ZipEntry projectEntry = new ZipEntry(MenthorSettings.PROJECT_DEFAULT_FILE.getValue());
		out.putNextEntry(projectEntry);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(project); 
		oos.flush();
		out.closeEntry();
		
		Main.printOutLine("Saving OCL constraints in Menthor file...");
		//Save the OCL content in the editor inside the file
		for(OCLDocument oclDoc: oclDocList){
			String filename = new String();			
			filename = oclDoc.getName();
			ZipEntry  constraintEntry = new ZipEntry(filename+".ocl");			
			out.putNextEntry(constraintEntry);
			out.write(oclDoc.getContent().getBytes());
			out.closeEntry();
		}
		
		Main.printOutLine("Finalizing Menthor file...");
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
