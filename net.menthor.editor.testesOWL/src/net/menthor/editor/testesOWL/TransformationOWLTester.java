package net.menthor.editor.testesOWL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Set;

import net.menthor.common.settings.owl.OWL2Destination;
import net.menthor.common.transformation.OwlAxiomsEnforcement;
import net.menthor.common.transformation.OwlMappingsEnforcement;
import net.menthor.common.transformation.TransformationOption;
import net.menthor.ontouml2temporalowl.verbose.FileManager;
import net.menthor.ootos.OntoUML2OWL;
import org.eclipse.ocl.ParserException;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;

import RefOntoUML.parser.OntoUMLParser;

public class TransformationOWLTester {
	public static class GenericExtFilter implements FilenameFilter {

		private String ext;

		public GenericExtFilter(String ext) {
			this.ext = ext;
		}

		public boolean accept(File dir, String name) {
			return (name.endsWith(ext));
		}
	}

	public static void main(String[] args) {
		//we open the inputs directory and then open each of the folders inside. Each folders contain a model.refontouml inside that will be used for testing.
		File inputdir = new File("resources/inputs");
		File[] inputdirectoryListing = inputdir.listFiles();
		if (inputdirectoryListing != null) {
			//the for below opens each test folder
			for (File fileFolders : inputdirectoryListing) {
				GenericExtFilter filter = new GenericExtFilter(".refontouml");
				File[] refontoumls = fileFolders.listFiles(filter); //we are only interested in the .refontouml files inside each test folder. 
				
				if(refontoumls == null) continue; //if it's not a directory, we skip it (for example, the file could be an O.S. hidden file such as Mac's .DS_STORE)
				
				for (int i = 0 ; i< refontoumls.length; i++) {
					File refonto = refontoumls[i];
					String owlModelName = fileFolders.getName();
					if(i>0) owlModelName+=i;//We expect only one file per folder but this is included for safety
					System.out.println("Generating owl for " + owlModelName+ " model");
					//the code below prepares for the owl model transformation
					TransformationOption to  = new TransformationOption(null, OWL2Destination.FILE, "resources/outputs/"+owlModelName + ".owl");
					OwlAxiomsEnforcement x = new OwlAxiomsEnforcement();
					x.setOntologyIri("http://www.menthor.net/testesOWL/"+owlModelName);
					x.setSwrlRules(false);
					to.setAxiomsEnforcement(x);
					to.setMappingsEnforcement(new OwlMappingsEnforcement());
					OntoUML2OWL onto2owl = new OntoUML2OWL();
					String model;
					try {
						//the actual owl transformation
						model = onto2owl.Transformation(new OntoUMLParser(refonto.getAbsolutePath()), new String(),to,"resources/temp");
						String owlFileName = to.getPath();
						//saving owl model
						FileManager fileManager = new FileManager(owlFileName);
						fileManager.write(model);
						fileManager.done();
						
						//now we compare with the reference model
						File transformedModel = new File("resources/outputs/"+owlModelName + ".owl");
						//File referenceModel = new File("resources/referenceOutputs/"+owlModelName + ".owl");
						File referenceModel = new File("resources/outputs/"+owlModelName + ".owl");
						/*boolean compare = compareFiles(transformedModel,referenceModel);
						
						if(compare) System.out.println("Model " + owlModelName+ " is identical to the reference model");
						else System.out.println("WARNING: Model " + owlModelName+ " is different from the reference model!");
*/						
						FileInputStream transformedModelIP = new FileInputStream(transformedModel);
						OntModel transformedOntModel = ModelFactory.createOntologyModel();
						transformedOntModel.read(transformedModelIP,null);	

						FileInputStream refModelIP = new FileInputStream(referenceModel);
						OntModel refOntModel = ModelFactory.createOntologyModel();
						refOntModel.read(refModelIP,null);	
						
						Set<Statement> refSet = refOntModel.listStatements().toSet();
						Set<Statement> tranformedSet = transformedOntModel.listStatements().toSet();
						
						
						
						if (!refSet.containsAll(tranformedSet) || !tranformedSet.containsAll(refSet) )System.out.println("WARNING: Model " + owlModelName+ " is different from the reference model!");
						else System.out.println("Model " + owlModelName+ " is identical to the reference model");
/*
						if(!transformedOntModel.containsAll(refOntModel) || !refOntModel.containsAll(transformedOntModel)){
							System.out.println("WARNING: Model " + owlModelName+ " is different from the reference model!");
							Model difmodel = transformedOntModel.difference(refOntModel);
							FileManager diffileManager = new FileManager("resources/diffs/"+owlModelName + ".owl");
							StringWriter out = new StringWriter();
							difmodel.write(out,"RDF/XML");
							diffileManager.write(out.toString());
							diffileManager.done();
							
						}
							
						else System.out.println("Model " + owlModelName+ " is identical to the reference model");
	*/					
						
					} catch (ParserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}

			}
		} else {
			System.out.println("Folder opening failed");
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}
//		
//		//now we will check if the reference models are identical to the generated models 
//		File referencedir = new File("resources/referenceOutputs");
//		File[] refdirectoryListing = referencedir.listFiles();
//		if (refdirectoryListing != null) {
//			//the for below opens each test folder
//			for (File fileFolders : refdirectoryListing) {
//				GenericExtFilter filter = new GenericExtFilter(".refontouml");
//				File[] refontoumls = fileFolders.listFiles(filter); //we are only interested in the .refontouml files inside each test folder. 
//				
//				if(refontoumls == null) continue; //if it's not a directory, we skip it (for example, the file could be an O.S. hidden file such as Mac's .DS_STORE)
//				
//				for (int i = 0 ; i< refontoumls.length; i++) {
//					File refonto = refontoumls[i];
//					String owlModelName = fileFolders.getName();
//					if(i>0) owlModelName+=i;//We expect only one file per folder but this is included for safety
//					System.out.println("Generating owl for " + owlModelName+ " model");
//				}
//			}
//		}
	}
	
	public static boolean compareFiles(File file1, File file2) throws java.io.IOException {
	    String s1 = "";
	    String s2 = "";
	    String y = "", z = "";

	    BufferedReader bfr = new BufferedReader(new FileReader(file1));
	    BufferedReader bfr1 = new BufferedReader(new FileReader(file2));

	    while ((z = bfr1.readLine()) != null)
	        s1 += z;

	    while ((y = bfr.readLine()) != null)
	        s2 += y;
	    
	    bfr.close();
	    bfr1.close();

	    if (s1.equals(s2)) return true;
	    else return false;
	    
	}

}
