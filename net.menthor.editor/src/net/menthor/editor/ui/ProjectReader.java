package net.menthor.editor.ui;

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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.settings.owl.OwlSettingsMap;
import net.menthor.editor.v2.util.FileReader;
import net.menthor.editor.v2.util.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.util.Settings;

/** Reads a model from a file. Models are stored and retrieved using serialization. */
public final class ProjectReader extends FileReader {

	private static ProjectReader instance = new ProjectReader();
	public static ProjectReader getInstance() { return instance; }

	/** Reads a UmlProject object from a file. */
	@SuppressWarnings("unused")
	public ArrayList<Object> readProject(File file) throws IOException, ClassNotFoundException 
	{		
		// first element is UmlProject, the second the OCL String content.
		ArrayList<Object> list = new ArrayList<Object>();
		
		boolean modelLoaded = false, projectLoaded = false, constraintLoaded = false;
		ArrayList<OclDocument> constraintContent = new ArrayList<OclDocument>();
		ZipFile inFile = new ZipFile(file);	
		
		//Read the model and the project file 
		Resource resource = RefOntoUMLEditingDomain.getInstance().createResource();
		UmlProject project = null;
		
		@SuppressWarnings("unchecked")
		Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) inFile.entries();
		   
		ZipEntry entry;
		while(entries.hasMoreElements()) {
			entry = entries.nextElement();			
			if(entry.getName().equals(Settings.MODEL_FILE.getValue()) && !modelLoaded)
			{
				System.out.println("Loading model XMI information from Menthor file...");
				InputStream in = inFile.getInputStream(entry);
				
				/**Load options that significantly improved the performance of loading EMF Model instances (by Tiago)*/
				Map<Object,Object> loadOptions = ((XMLResourceImpl)resource).getDefaultLoadOptions();
				loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
				loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
				resource.load(in,loadOptions);
				
				//resource.load(in, Collections.EMPTY_MAP);

				in.close();
				modelLoaded = true;
			}
			else if (entry.getName().equals(Settings.PROJECT_FILE.getValue()) && !projectLoaded)
			{
				System.out.println("Loading project DAT information from Menthor file...");
				InputStream in = inFile.getInputStream(entry);
				ObjectInputStream oin = new ObjectInputStream(in);
				project = (UmlProject) oin.readObject(); 
				in.close();
				projectLoaded = true;
			}
			else if (entry.getName().contains("ocl"))
			{
				System.out.println("Loading constraints information from Menthor file...");
				InputStream is = inFile.getInputStream(entry);
								
				byte[] b = new byte[is.available()];
				is.read(b);
				OclDocument oclDoc = new OclDocument();
				oclDoc.setName(entry.getName().replace(".ocl",""));
				oclDoc.addContentAsString(new String(b));
				constraintContent.add(oclDoc);
					
				is.close();
				constraintLoaded = true;
			}
			else if(entry.getName().equals(OwlSettingsMap.getInstance().getFileName()))
			{
				System.out.println("Loading Owl Settings information from Menthor file...");
				InputStream in = inFile.getInputStream(entry);								
				OwlSettingsMap.getInstance().load(in);					
				in.close();				
			}
		}
		
		inFile.close();
		
		if(!projectLoaded || !modelLoaded)
			throw new IOException("Failed to load Menthor Project!");
		
		project.setResource(resource);
		
		list.add(project);
		list.addAll(constraintContent);
		
		return list;
	}

	public String getSuffix() 
	{
		return ".menthor";
	}
}
