package net.menthor.editor.v2.managers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.JOptionPane;

import org.apache.commons.lang.SerializationUtils;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.settings.owl.OwlSettingsMap;
import net.menthor.editor.v2.util.Settings;

public class DeserializationManager extends BaseManager {

	// -------- Lazy Initialization

	private static class DeserializationLoader {
        private static final DeserializationManager INSTANCE = new DeserializationManager();
    }	
	public static DeserializationManager get() { 
		return DeserializationLoader.INSTANCE; 
	}	
    private DeserializationManager() {
        if (DeserializationLoader.INSTANCE != null) throw new IllegalStateException("DeserializationManager already instantiated");
    }		
    
    // ----------------------------
    
    private boolean isModelDeserialized;
	private boolean isOclDocumentsDeserialized;
	private boolean isUmlProjectDeserialized;
	
	@SuppressWarnings("unchecked")
	public List<Object> deserializeMenthorFile(File file) throws IOException, ClassNotFoundException {		
		Resource resource = RefOntoUMLEditingDomain.getInstance().createResource();
		ZipFile zipFile = new ZipFile(file);		
		Enumeration<ZipEntry> zipEntries = (Enumeration<ZipEntry>) zipFile.entries();
		List<OclDocument> oclDocs = new ArrayList<OclDocument>();
		UmlProject project = null;
		while(zipEntries.hasMoreElements()) {
			ZipEntry entry = zipEntries.nextElement();	
			InputStream is = zipFile.getInputStream(entry);
			String entryName = entry.getName();
			if(entryName.equals(Settings.MODEL_FILE.getValue()) && !isModelDeserialized) {
				deserializeModel(is, resource);
			}
			else if(entryName.equals(Settings.PROJECT_FILE.getValue()) && !isUmlProjectDeserialized) {
				project = deserializeUmlProject(is, resource);
			}
			else if(entryName.contains("ocl")) {
				oclDocs.add(deserializeOclDocument(is, entryName));
			}
			else if(entryName.equals(OwlSettingsMap.getInstance().getFileName()) && !isOclDocumentsDeserialized) {
				OwlSettingsMap.getInstance().load(is);
			}
			is.close();
		}
		zipFile.close();
		if(!isModelDeserialized) throw new IOException("Failed to deserialize model content");
		if(!isUmlProjectDeserialized) throw new IOException("Failed to deserialize DAT information");
		List<Object> list = new ArrayList<Object>();
		if(project==null) list.add(resource.getContents().get(0));		
		else list.add(project);
		list.addAll(oclDocs);		
		return list;
	}
	
	public void deserializeModel(InputStream is, Resource resource) throws IOException{		
		Map<Object,Object> loadOptions = ((XMLResourceImpl)resource).getDefaultLoadOptions();
		loadOptions.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		resource.load(is,loadOptions);	
		isModelDeserialized=true;
	}
	
	public OclDocument deserializeOclDocument(InputStream is, String entryName) throws IOException{		
		byte[] b = new byte[is.available()];		
		is.read(b);
		OclDocument oclDoc = new OclDocument();
		oclDoc.setName(entryName.replace(".ocl",""));
		oclDoc.addContentAsString(new String(b));
		return oclDoc;
	}
	
	public UmlProject deserializeUmlProject(InputStream is, Resource resource) throws IOException{
		byte[] bytes = new byte[is.available()];
		is.read(bytes);		
		UmlProject project = null;
		try{
			project = (UmlProject) SerializationUtils.deserialize(bytes);			        
			project.setResource(resource);
			isUmlProjectDeserialized=true;
		}catch(Exception e){			
			System.err.println(e.getLocalizedMessage());
			JOptionPane.showMessageDialog(null, 
			"The DAT information in this project is incompatible with this version of the editor. "
			+ "\nFor this reason we were not able to retrieve the diagrams...",
			"Incompatible DAT Information", JOptionPane.INFORMATION_MESSAGE);
		}
		return project;
	}
}
