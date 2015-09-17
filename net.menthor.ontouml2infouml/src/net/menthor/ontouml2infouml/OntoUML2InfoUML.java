package net.menthor.ontouml2infouml;

import java.io.File;
import java.io.IOException;

import net.menthor.ontouml2infouml.decision.DecisionHandler;
import net.menthor.ontouml2infouml.impl.Transformation;
import net.menthor.ontouml2infouml.serialize.Serializer;
import net.menthor.ontouml2infouml.ui.Onto2InfoInterface;
import net.menthor.ontouml2infouml.uml.UMLModelAbstraction;

import org.eclipse.core.resources.IProject;

import RefOntoUML.util.RefOntoUMLModelAbstraction;

public class OntoUML2InfoUML
{
	// OntoUML Model wrapper
	static RefOntoUMLModelAbstraction ontoAbstraction;
	// UML Model wrapper
	static UMLModelAbstraction umlAbstraction;
	// Decisions made by the user
	static DecisionHandler dh;
	// User Interface
	static Onto2InfoInterface ui;
	
	static RefOntoUML.Package refmodel;
	// ontouml file (arg[0] on debug)
	static String ontofilename;
	// uml file
	static String umlfilename;
	// map file
	static String mapfilename;

	// preloaded the UML Model, the Onto<->UML mappings and the user decisions
	static boolean preloaded = false;

	public static IProject project = null;
	
	public static void main(String[] args)
	{
		transformation("test/MScRunningExample.refontouml");
	}
	
	public static void transformation(RefOntoUML.Package model, String umlfileName)
	{
		refmodel = model;
		umlfilename = umlfileName;
		mapfilename = umlfilename.replace(".uml", ".dec");
		
		ontoAbstraction = new RefOntoUMLModelAbstraction();
		umlAbstraction = new UMLModelAbstraction();
		ui = new Onto2InfoInterface();
		
		try{
			// OntoUML Model
			if (!ontoAbstraction.load(refmodel))
			{
				System.out.println("Unable to load " + refmodel);
				return;
			}
			if (!ontoAbstraction.process())
			{
				System.out.println("Unable to process OntoUML model");
				return;	
			}
			
			dh = new DecisionHandler(ontoAbstraction); // TODO: initialize decisions only if they were not pre-loaded?
			
			// UML Model, if any
			if (umlAbstraction.load(umlfilename))
			{
				// TODO: in case of Exception here, delete the Map and the UML model (this.exception())
				// Loads the user Decisions, the OntoUML<->UML mappings
				Serializer.loadMap(ontoAbstraction.resource, umlAbstraction.resource, mapfilename, dh, umlAbstraction);
				preloaded = true;
			}
			else
			{
				Onto2InfoMap.initializeMap();
				umlAbstraction.createPrimitiveTypes();
				preloaded = false;
			}
			
			Transformation t = new Transformation(ontoAbstraction, umlAbstraction, ui);
			
			ui.load(ontoAbstraction, dh, t, project);
			// Program execution stops here, until the user closes the window			
		}
		catch (Exception e)
		{
			System.out.println("A terrible execution problem has happened.");
			e.printStackTrace();
		}
	}
	
	public static void transformation (String fileAbsolutePath)
	{
		ontofilename = fileAbsolutePath;
		umlfilename = fileAbsolutePath.replace(".refontouml", " [info].uml");
		mapfilename = fileAbsolutePath.replace(".refontouml", ".dec");

		ontoAbstraction = new RefOntoUMLModelAbstraction();
		umlAbstraction = new UMLModelAbstraction();
		ui = new Onto2InfoInterface();
		
		try
		{
			// OntoUML Model
			if (!ontoAbstraction.load(fileAbsolutePath))
			{
				System.out.println("Unable to load " + fileAbsolutePath);
				return;
			}
	
			if (!ontoAbstraction.process())
			{
				System.out.println("Unable to process OntoUML model");
				return;	
			}
			
			dh = new DecisionHandler(ontoAbstraction); // TODO: initialize decisions only if they were not pre-loaded?
			
			// UML Model, if any
			if (umlAbstraction.load(umlfilename))
			{
				// TODO: in case of Exception here, delete the Map and the UML model (this.exception())
				// Loads the user Decisions, the OntoUML<->UML mappings
				Serializer.loadMap(ontoAbstraction.resource, umlAbstraction.resource, mapfilename, dh, umlAbstraction);
				preloaded = true;
			}
			else
			{
				Onto2InfoMap.initializeMap();
				umlAbstraction.createPrimitiveTypes();
				preloaded = false;
			}
			
			Transformation t = new Transformation(ontoAbstraction, umlAbstraction, ui);
			
			ui.load(ontoAbstraction, dh, t, project);
			// Program execution stops here, until the user closes the window			
		}
		catch (Exception e)
		{
			System.out.println("A terrible execution problem has happened.");
			e.printStackTrace();
		}
	}
	
	public static void initialCallback ()
	{
		if (preloaded)
		{
			if(ontofilename!=null) ui.writeText("Loaded the domain ontology (" + ontofilename + ")");
			else ui.writeText("Loaded the domain ontology (" + refmodel + ")");
			ui.writeText("Loaded the information model (" + umlfilename + ")");
			ui.writeText("Loaded the decisions (" + mapfilename + ")");
		}
	}
	
	public static void saveMap () throws IOException
	{
		//if (true) throw new RuntimeException(); // for debug
		Serializer.saveMap(ontoAbstraction.resource, umlAbstraction.resource, umlfilename.replace(".uml", ".dec"), dh, umlAbstraction);
	}
	
	public static void exception()
	{
		// TODO: Dialog asking for permission?
		File f = new File(umlfilename);
		if (f.delete())
			ui.writeText("File " + umlfilename + " was deleted");

		f = new File (mapfilename);
		if (f.delete())
			ui.writeText("File " + mapfilename + " was deleted");
		
		// FIXME: reinitialize some variables
		
		ui.refreshWorkspace();
	}
}
