package net.menthor.ontouml2sbvr;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import RefOntoUML.Class;
import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.Package;

public class OntoUML2SBVR
{
	public static void main (String args[])
	{
		OntoUML2SBVR.Transformation(args[0]);
	}
	
	public static void Transformation(String fileName)
	{
		// Configure ResourceSet
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(RefOntoUML.RefOntoUMLPackage.eNS_URI,RefOntoUML.RefOntoUMLPackage.eINSTANCE);
				
		// Open the model
		File sourceFile = new File(fileName);
		//sourceFile.deleteOnExit();
		
		if (!sourceFile.isFile())
		{
			System.out.println("Error accessing: " + sourceFile.getAbsolutePath());
			return;
		}		
		URI uri = URI.createFileURI(sourceFile.getAbsolutePath());
						
		try
		{
			// Read the objects in the model
			Resource resource = resourceSet.getResource(uri, true);
			EObject eObj = resource.getContents().get(0);

			if (!(eObj instanceof Package))
				return;
			
			Package p = (Package)eObj;
			
			FileManager myfile = new FileManager(sourceFile);
			myfile.serial = false;
			TreeNavigator treeNavigator = new TreeNavigatorImpl();
			treeNavigator.build((RefOntoUML.Package)p);
			myfile.addTreeNavigator(treeNavigator);

			List<Classifier> mainClasses = new LinkedList<>();
			for (Classifier c : treeNavigator.getClasses())
				if (c.parents().size() == 0)
					mainClasses.add(c);
			for (Classifier c : mainClasses)
				myfile.DealNode((Class)c, !myfile.serial);
			
			for (DataType dt : treeNavigator.getDataTypes())
				myfile.DealDataType(dt);

			for (Map.Entry<String, Classifier> ar : treeNavigator.getAssociationRoles())
				myfile.DealAssociationRole(ar.getKey(), ar.getValue());

			myfile.Done();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
