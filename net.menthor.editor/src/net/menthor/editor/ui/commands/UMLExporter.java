package net.menthor.editor.ui.commands;

import java.io.File;
import java.io.IOException;

import net.menthor.editor.DiagramManager;
import net.menthor.editor.Main;
import net.menthor.ontouml2uml.OntoUML2UML;
import net.menthor.ontouml2uml.OntoUML2UMLOption;
import RefOntoUML.parser.OntoUMLParser;

public class UMLExporter extends FileWriter {

	public void writeUML(DiagramManager manager, File file) throws IOException 
	{
		OntoUMLParser refparser = manager.getFrame().getProjectBrowser().getParser();
		String umlPath = file.getAbsolutePath();
		if(!umlPath.contains(".uml")) umlPath += ".uml";		
		OntoUML2UML.convertToUMLProfile(refparser,umlPath,new OntoUML2UMLOption(false,false));
		Main.printOutLine(OntoUML2UML.getLog());
	}

	protected String getSuffix() 
	{
		return ".uml";
	}
}