package net.menthor.ontouml2simpleowl;

import java.io.ByteArrayOutputStream;

import net.menthor.ontouml2simpleowl.transform.Transformer;

import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;


/***
 * This class aims to provide a simple alternative for transforming a RefontoUML
 * model into an OWL Ontology. As opposed to other transformations this
 * transformation doesn't take into account part of the OntoUML model, instead,
 * the mapping is made directly, resulting in a cleaner ontolgy.
 * 
 * @author Antognoni Albuquerque
 */
public class OntoUML2SimpleOWL {
	/*
	 * Notas =====
	 * 
	 * Nesta transforma��o usamos o framework SiTra e a OWLAPI.
	 * 
	 * http://www.cs.bham.ac.uk/~bxb/Sitra/ http://owlapi.sourceforge.net/
	 * 
	 * SiTra � um framework simples escrito em Java que pode ser usado para
	 * qualquer tipo de transforma��o, principalmente na perspectiva MDD. Para
	 * us�-lo � necess�rio implementar apenas duas interfaces: Trasnformer
	 * (OWLTransformer) e Rule (OWLRule).
	 * 
	 * Optamos por utilizar a OWLAPI por ser uma API madura amplamente utilizada
	 * (inclusive pelo Proteg�) para manipula��o de ontologias expressas em OWL.
	 */

	/***
	 * Transforms a RefOntoUML model into a OWL Ontology.
	 * 
	 * @param model
	 * @param ontologyIRI
	 * @return OWL ontology
	 * @throws OWLOntologyCreationException
	 */
	public static String Transformation(RefOntoUML.Package model, String ontologyIRI) {
		try {
			if(!ontologyIRI.endsWith("#")) ontologyIRI += "#";
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			OWLXMLOntologyFormat owlxmlFormat = new OWLXMLOntologyFormat();
			Transformer transformer = new Transformer(ontologyIRI, model);
			transformer.transform(owlxmlFormat, out);
			return out.toString();
		} catch (Exception ex) {
			return "ERROR: " + ex.getMessage();
		}
	}
}
