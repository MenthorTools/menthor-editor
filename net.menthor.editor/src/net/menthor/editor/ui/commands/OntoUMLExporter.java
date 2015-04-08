package net.menthor.editor.ui.commands;

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
