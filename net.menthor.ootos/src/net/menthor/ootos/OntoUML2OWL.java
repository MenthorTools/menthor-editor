package net.menthor.ootos;

import java.io.File;

import net.menthor.common.resource.RefOntoUMLResourceFactoryImpl;
import net.menthor.common.transformation.TransformationOption;
import net.menthor.ootos.ontouml2owl_swrl.Transformer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import RefOntoUML.parser.OntoUMLParser;

public class OntoUML2OWL {
	public String errors = "";
	/***
	 * Transforms a RefOntoUML model into a OWL Ontology.
	 * 
	 * @param model
	 * @param ontologyIRI
	 * @return OWL ontology
	 * @throws Exception 
	 * @throws ParserException 
	 * @throws OWLOntologyCreationException
	 */
	public String Transformation(OntoUMLParser ecoreModel, String oclRules, TransformationOption owlOptions, String tempDir) throws ParserException, Exception {
		Transformer transformer = new Transformer(ecoreModel, oclRules, owlOptions);
		String transform = transformer.transform(tempDir);
		this.errors = transformer.getErrors();
		return transform;
	}

	/***
	 * Transforms a RefOntoUML model into a OWL Ontology.
	 * 
	 * @param modelFile
	 * @param ontologyIRI
	 * @return OWL ontology
	 * @throws Exception 
	 * @throws ParserException 
	 * @throws OWLOntologyCreationException
	 */
	public String Transformation(File modelFile, String nameSpace, String oclRules, TransformationOption owlOptions, String tempDir) throws ParserException, Exception {
		OntoUMLParser ecoreModel = intialize(modelFile);
		Transformer transformer = new Transformer(ecoreModel, oclRules, owlOptions);
		String transform = transformer.transform(tempDir);
		this.errors = transformer.getErrors();
		return transform;
	}


	public static OntoUMLParser intialize(File address) {
		try{
			//Criar um ResourceSet para "gerenciar" o resource do modelo
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new RefOntoUMLResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(RefOntoUML.RefOntoUMLPackage.eNS_URI,RefOntoUML.RefOntoUMLPackage.eINSTANCE);

			Resource resource = resourceSet.getResource(URI.createFileURI(address.getAbsolutePath()),true);
			
			return (OntoUMLParser) resource.getContents().get(0);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;

	}

	//	public static void main(String[] args) {
	//		String oclRules = "";
	//		String ret = null;
	//		try {
	//			OntoUML2OWL ontoUML2OWL = new OntoUML2OWL();
	//			ret = ontoUML2OWL.Transformation(intialize(new File("TesteWithRoles.refontouml")), "http://abcd/ontology/", oclRules);
	//			String errors = ontoUML2OWL.errors;
	//			System.out.println(errors);
	//			
	//		} catch (ParserException e1) {
	//			// TODO Auto-generated catch block
	//			e1.printStackTrace();
	//		} catch (Exception e1) {
	//			// TODO Auto-generated catch block
	//			e1.printStackTrace();
	//		}
	//		File arquivo;   
	//
	//		arquivo = new File("arquivo.owl");  // Chamou e nomeou o arquivo txt.  
	//		try{
	//			FileOutputStream fos = new FileOutputStream(arquivo);  // Perceba que estamos instanciando uma classe aqui. A FileOutputStream. Pesquise sobre ela!  
	//			fos.write(ret.getBytes());    
	//			fos.close();  // Fecha o arquivo. Nunca esquecer disso.  
	//		}catch(Exception e){
	//			e.printStackTrace();
	//		}
	//		System.out.println("foi");
	//	}
}
