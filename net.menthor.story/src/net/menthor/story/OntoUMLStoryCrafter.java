package net.menthor.story;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import RefOntoUML.Association;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLResourceUtil;
import stories.StoriesPackage;
import stories.Story;


public class OntoUMLStoryCrafter {
		
	public OntoUMLParser ontoparser;
	public String dirPath;	
	public String filePath;
	/**
	 * Constructor
	 * @throws IOException 
	 */
	public OntoUMLStoryCrafter (String input) throws IOException//(OntoUMLParser refparser, String fPath) throws IOException 
	{
		//filePath = fPath;
		//dirPath = filePath.substring(0,filePath.lastIndexOf(File.separator)+1);
		//ontoparser = refparser;	

		Resource resource = RefOntoUMLResourceUtil.loadModel(input);

		RefOntoUML.Package root = (RefOntoUML.Package)resource.getContents().get(0);
		OntoUMLParser gambiparser = new OntoUMLParser(root);
		ontoparser = gambiparser;
	}
	public String transform ()// throws Exception 
	{		
		
		for(RefOntoUML.Class c: this.ontoparser.getAllInstances(RefOntoUML.Class.class))		
		{
			System.out.println(c.getName());
		}
		return " ";
	}
	
	
	/**
	 * 
	 * Returns a xmi resource and saves it on a file
	 * @param outputpath
	 * @param container
	 * @return
	 */	
	public static Resource saveStory (String filename, String outputpath, Story container) 
	{
		ResourceSet rset = new ResourceSetImpl();					
		
		// Register the appropriate resource factory to handle all file extensions.
		//
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			(Resource.Factory.Registry.DEFAULT_EXTENSION, 
			 new XMIResourceFactoryImpl());
		// Register the package to ensure it is available during loading.
		//
		rset.getPackageRegistry().put
			(StoriesPackage.eNS_URI, 
			 StoriesPackage.eINSTANCE);

		
		URI fileURI = URI.createFileURI(filename);    
				
	    final Resource resource = rset.createResource(fileURI);    	
	    
	    //collectAll((Resource)container, resource);
	    
	    resource.getContents().add(container);    	
	
	    try{
	    	resource.save(new FileOutputStream(outputpath.concat(filename)),Collections.emptyMap());
	    	
	    }catch(IOException e){
	    	e.printStackTrace();
	    }
	    
	    return resource;		   	
	}
	/**
	 * 
	 * Returns a xmi resource and saves it on a file
	 * @param outputpath
	 * @param container
	 * @return
	 */
	public static Resource saveStory (String filename, Story container) 
	{
		return saveStory(filename,"",container);
	}
	
	public static Resource loadStory (String filename, String path) throws IOException 
	{
		ResourceSet rset = new ResourceSetImpl();					
		
		// Register the appropriate resource factory to handle all file extensions.
		//
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			(Resource.Factory.Registry.DEFAULT_EXTENSION, 
			 new XMIResourceFactoryImpl());
		// Register the package to ensure it is available during loading.
		//
		rset.getPackageRegistry().put
			(StoriesPackage.eNS_URI, 
			 StoriesPackage.eINSTANCE);
			
		
		//Essa implementa��o est� dando problemas com os URIs. Resolve mal. O problema � que na hora de resolver ele nao sabe o caminho e se o caminho est� na URI d� um outro tipo de problema.
	   // File file = new File(filename);
		URI fileURI = URI.createFileURI(filename);		
		Resource resource = rset.createResource(fileURI);		
		
		resource.load(new FileInputStream(path.concat(filename)),Collections.emptyMap());
		
		//collectAll(resource);
		return resource;		
		
	}
	
	
	public static  String getAuxPredicates(OntoUMLParser modelParser) {
		String result = new String();
		result+="pred direct_rel_in_w[x1,x2: univ , w:World]{\n";
		result+="	some (x1->x2 + x2->x1)\n"; 
		result+="				& (\n";
		for(Association a : modelParser.getAllInstances(Association.class)){
			result+="	w."+modelParser.getAlias(a)+"+\n";
		}
		result+=")\n\n//Association exists \n";
		result+="pred direct_rel[x1,x2: univ-World]{\n";
		result+="	 direct_rel_in_w[x1,x2,World]\n}\n\n";
		return result;
	}
}
