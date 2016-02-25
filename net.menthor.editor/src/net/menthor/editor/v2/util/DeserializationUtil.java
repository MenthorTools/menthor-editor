package net.menthor.editor.v2.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.MenthorDomain;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.ui.settings.owl.OwlSettingsMap;

public class DeserializationUtil {

	// -------- Lazy Initialization

	private static final String LOADING_ERROR_TITLE = "Loading error";

	private static class DeserializationLoader {
        private static final DeserializationUtil INSTANCE = new DeserializationUtil();
    }	
	public static DeserializationUtil get() { 
		return DeserializationLoader.INSTANCE; 
	}	
    private DeserializationUtil() {
        if (DeserializationLoader.INSTANCE != null) throw new IllegalStateException("DeserializationManager already instantiated");
    }		
    
    // ----------------------------
    
	public UmlProject deserialize(File file) throws ZipException, IOException {		
		Resource resource = MenthorDomain.get().createResource();
		
		ZipFile zipFile = new ZipFile(file);		
		Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
		List<OclDocument> oclDocs = new ArrayList<OclDocument>();
		UmlProject project = null;
		
		deserializeModel(zipFile,resource);
		//if the model does not contain a root package it is not valid, therefore no project information would make sense
		if(resource.getContents().size()==0){
			project = new UmlProject();
		}
		else {
			project = deserializeUmlProject(zipFile, resource);
			//if there was an error in loading the project information
			if(project==null || !(project instanceof UmlProject)){
				project = new UmlProject((RefOntoUML.Package)resource.getContents().get(0));
			}
		}
		
		deserializeOWLConfigurations(zipFile);
		
		while(zipEntries.hasMoreElements()) {
			ZipEntry entry = zipEntries.nextElement();	
			if(entry.getName().contains("ocl")) {
				oclDocs.add(deserializeOclDocument(zipFile, entry));
			}
		}
		
		project.setOclDocList(oclDocs);
		
		zipFile.close();
		
		return project;
	}
	
	private void deserializeOWLConfigurations(ZipFile zipFile) {
		try{
			InputStream is = getInputStream(zipFile,SettingsUtil.OWL_CONFIG_FILE);
			OwlSettingsMap.getInstance().load(is);
			is.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, 
			"Cannot read OWL configurations!",
			LOADING_ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	private InputStream getInputStream(ZipFile zipFile, SettingsUtil entry) throws IOException{
		return zipFile.getInputStream(zipFile.getEntry(entry.getValue()));
	}
	
	public void deserializeModel(ZipFile zipFile, Resource resource) {		
		
		try{
			InputStream is = getInputStream(zipFile,SettingsUtil.MODEL_FILE);
			Map<Object,Object> loadOptions = ((XMLResourceImpl)resource).getDefaultLoadOptions();
			loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
			loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
			resource.load(is,loadOptions);
			is.close();
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, 
			"Cannot read model contents!",
			LOADING_ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public UmlProject deserializeUmlProject(ZipFile zipFile, Resource resource) {
		
		UmlProject project = null;
		
		try{
			InputStream is = getInputStream(zipFile,SettingsUtil.PROJECT_FILE);
			try{
				ObjectInputStream ois = new ObjectInputStream(is);
				project = (UmlProject) ois.readObject();			        
				project.setResource(resource);
			}catch(Exception e){			
				JOptionPane.showMessageDialog(null, 
				"The DAT information in this project is incompatible with this version of the editor. "
				+ "\nFor this reason we were not able to retrieve the diagrams...",
				LOADING_ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
			}
			is.close();
		}catch (Exception e){
			System.err.println(e.getLocalizedMessage());
			JOptionPane.showMessageDialog(null, 
			"Cannot read project contents!",
			LOADING_ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
		}
		
		return project;
	}
	
	public OclDocument deserializeOclDocument(ZipFile zipFile, ZipEntry entry) {		
		OclDocument oclDoc = new OclDocument();
		
		try{
			InputStream is = zipFile.getInputStream(entry);
			byte[] b = new byte[is.available()];		
			is.read(b);
			oclDoc.setName(entry.getName().replace(".ocl",""));
			oclDoc.addContentAsString(new String(b));
			is.close();
			
		}catch (Exception e){
			System.err.println(e.getLocalizedMessage());
			JOptionPane.showMessageDialog(null, 
			"Cannot read contents of OCL document: <"+entry.getName()+">",
			LOADING_ERROR_TITLE, JOptionPane.INFORMATION_MESSAGE);
		}
		
		return oclDoc;
	}
}
