package net.menthor.editor.ui;

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

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.settings.owl.OwlSettingsMap;
import net.menthor.editor.v2.util.Settings;

/**
 * This class writes the current model and diagram data to an XML file.
 */
public final class ProjectSerializer {

	private static ProjectSerializer instance = new ProjectSerializer();

	/**
	 * Returns the singleton instance.
	 */
	public static ProjectSerializer getInstance() {
		return instance;
	}

	/**
	 * Writes the specified UmlProject to a file.
	 */
	public File serialize(File file, UmlProject project, ArrayList<OclDocument> oclDocList) throws IOException {

		FileOutputStream dest = new FileOutputStream(file);
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
		
		System.out.println("Saving model XMI information in Menthor file...");
		//Save the model as a resource inside the file
		ZipEntry modelEntry = new ZipEntry(Settings.MODEL_FILE.getValue());			
		out.putNextEntry(modelEntry);
		Resource resource = project.getResource();
		resource.save(out, Collections.EMPTY_MAP);
		out.closeEntry();
		
		System.out.println("Saving XMI settings information in Menthor file...");
		//Save the owl settings as a XML file inside the menthor file
		ZipEntry owlSettingEntry = new ZipEntry(OwlSettingsMap.getInstance().getFileName());			
		out.putNextEntry(owlSettingEntry);
		OwlSettingsMap.getInstance().store(out);		
		out.closeEntry();
		
		System.out.println("Saving project DAT information in Menthor file...");
		//Save the project a.k.a the diagrams inside the file
		ZipEntry projectEntry = new ZipEntry(Settings.PROJECT_FILE.getValue());
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

		return file;
	}
	
	public String getSuffix() 
	{
		return ".menthor";
	}
}
