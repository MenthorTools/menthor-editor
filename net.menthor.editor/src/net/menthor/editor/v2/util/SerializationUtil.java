package net.menthor.editor.v2.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.emf.ecore.resource.Resource;

import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.ui.settings.owl.OwlSettingsMap;

public class SerializationUtil {
	
	// -------- Lazy Initialization

	private static class SerializationLoader {
        private static final SerializationUtil INSTANCE = new SerializationUtil();
    }	
	public static SerializationUtil get() { 
		return SerializationLoader.INSTANCE; 
	}	
    private SerializationUtil() {
        if (SerializationLoader.INSTANCE != null) throw new IllegalStateException("SerializationManager already instantiated");
    }		
    
    // ----------------------------
    
    public void serializeModel(Resource resource, ZipOutputStream out) throws IOException{
    	ZipEntry modelEntry = new ZipEntry(SettingsUtil.MODEL_FILE.getValue());			
		out.putNextEntry(modelEntry);
		resource.save(out, Collections.EMPTY_MAP);
		out.closeEntry();
    }
    
    public void serializeOwlSettings(ZipOutputStream out) throws IOException{
		ZipEntry owlSettingEntry = new ZipEntry(OwlSettingsMap.getInstance().getFileName());			
		out.putNextEntry(owlSettingEntry);
		OwlSettingsMap.getInstance().store(out);		
		out.closeEntry();
    }
    
    public void serializeUmlProject(UmlProject project, ZipOutputStream out) throws IOException{
    	ZipEntry projectEntry = new ZipEntry(SettingsUtil.PROJECT_FILE.getValue());
		out.putNextEntry(projectEntry);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(project); 
		oos.flush();
		out.closeEntry();
    }
    
    public void serializeOclDocuments(List<OclDocument> docs, ZipOutputStream out) throws IOException{
    	for(OclDocument oclDoc: docs){
			String filename = new String();			
			filename = oclDoc.getName();
			ZipEntry  constraintEntry = new ZipEntry(filename+".ocl");			
			out.putNextEntry(constraintEntry);
			out.write(oclDoc.getContentAsString().getBytes());
			out.closeEntry();
		}
    }
    
    public File serializeMenthorFile(File file, UmlProject project, List<OclDocument> oclDocList) throws IOException {
		FileOutputStream dest = new FileOutputStream(file);
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
		serializeModel(project.getResource(),out);
		serializeOwlSettings(out);
		serializeUmlProject(project, out);
		serializeOclDocuments(oclDocList, out);
		out.flush();
		out.finish();
		out.close();
		return file;
	}

}
