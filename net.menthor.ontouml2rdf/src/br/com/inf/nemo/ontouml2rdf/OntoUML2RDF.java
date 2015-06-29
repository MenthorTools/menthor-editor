package br.com.inf.nemo.ontouml2rdf;

import java.io.StringWriter;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import net.menthor.common.transformation.OWLTransformationOptions;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Type;
import RefOntoUML.parser.OntoUMLParser;
import br.ufes.inf.nemo.ufo_rdf.vocabulary.MLT;
import br.ufes.inf.nemo.ufo_rdf.vocabulary.UFO;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.vocabulary.OWL2;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

public class OntoUML2RDF {
	OWLTransformationOptions owlOptions;
	String ontologyIRI;
	String ontologyNS;
	OntoUMLParser ontoParser;
	OntModel rdfModel;
	
	public OntoUML2RDF(OWLTransformationOptions owlOptions, RefOntoUML.Package ontModel, String ontologyIRI) {
		this.ontoParser = new OntoUMLParser(ontModel);
		this.rdfModel = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
		this.ontologyIRI = ontologyIRI;
		this.owlOptions = owlOptions;
		this.ontologyNS = ontologyIRI + "#";
	}
	
	public String transform(){
		rdfModel.setNsPrefix(UFO.getPrefix(), UFO.getURI());
		rdfModel.setNsPrefix(MLT.getPrefix(), MLT.getURI());
		
		//create classes
		Set<RefOntoUML.Class> lstClasses = ontoParser.getAllInstances(RefOntoUML.Class.class);
		for (RefOntoUML.Class cls : lstClasses) {
			String stereotype = ontoParser.getStereotype(cls);
			Resource stereotypeRsrc = UFO.resource(stereotype);
			rdfModel.createResource(ontologyIRI+ "#" + cls.getName(), stereotypeRsrc);
		}
		
		createObjectProperties();
		
		Set<RefOntoUML.Generalization> lstGeneralizations = ontoParser.getAllInstances(RefOntoUML.Generalization.class);
		for (Generalization generalization : lstGeneralizations) {
			Classifier specific = generalization.getSpecific();
			Resource specificRsrc = rdfModel.createResource(ontologyNS + specific.getName());
			
			Classifier general = generalization.getGeneral();
			Resource generalRsrc = rdfModel.createResource(ontologyNS + general.getName());
			
			Statement subClsStmt = rdfModel.createStatement(specificRsrc, RDFS.subClassOf, generalRsrc);
			rdfModel.add(subClsStmt);			
		}
		
		Set<RefOntoUML.GeneralizationSet> lstGeneralizationSets = ontoParser.getAllInstances(RefOntoUML.GeneralizationSet.class);
		for (GeneralizationSet generalizationSet : lstGeneralizationSets) {
			boolean isCovering = generalizationSet.isIsCovering();
			boolean isDisjoint = generalizationSet.isIsDisjoint();
			
			if(!isCovering && !isDisjoint) continue;
			
			Resource generalRsrc = null;
			EList<Generalization> generalizations = generalizationSet.getGeneralization();
			
			if(generalizations.size() == 0) continue;
				
			RDFNode[] specificNodeList = new RDFNode[generalizations.size()];
			for (int i = 0; i < generalizations.size(); i++) {
				Classifier specific = generalizations.get(i).getSpecific();
				Resource specificRsrc = rdfModel.createResource(ontologyNS + specific.getName());
				
				Classifier general = generalizations.get(i).getGeneral();
				generalRsrc = rdfModel.createResource(ontologyNS + general.getName());
				
				specificNodeList[i] = specificRsrc;	
			}
			
			RDFList specificList = rdfModel.createList(specificNodeList);
			
			Statement stmt = null; 
			if(isCovering && isDisjoint){
				stmt = rdfModel.createStatement(generalRsrc, OWL2.disjointUnionOf, specificList);
			}else if(isDisjoint){
				Resource rsrc = rdfModel.createResource();
				Statement stmt2 = rdfModel.createStatement(rsrc, RDF.type, OWL2.AllDisjointClasses);
				rdfModel.add(stmt2);
				stmt = rdfModel.createStatement(rsrc, OWL2.members, specificList);
			}else if(isCovering){
				stmt = rdfModel.createStatement(generalRsrc, OWL2.unionOf, specificList);
			}
			rdfModel.add(stmt);
		}
		
		return ontModelToString();
	}
	
	public void createObjectProperties(){
		//create associations
		Set<RefOntoUML.Association> lstAssociations = ontoParser.getAllInstances(RefOntoUML.Association.class);
		for (RefOntoUML.Association assoc : lstAssociations) {
			createObjectProperty(assoc, false);
			createObjectProperty(assoc, true);
		}	
	}
	
	public void createObjectProperty(RefOntoUML.Association assoc, boolean isInverse){
		//create association
		String stereotype = ontoParser.getStereotype(assoc);
		Resource stereotypeRsrc = UFO.resource(stereotype);
		String assocName = assoc.getName();
		if(isInverse) assocName = "INV." + assocName ;
		Resource assocRrsc = rdfModel.createResource(ontologyNS + assocName, stereotypeRsrc);
		
		//get source and range
		Type source, range;
		
		int rangeUpperCard, rangeLowerCard;
		if(isInverse){
			range = assoc.getMemberEnd().get(0).getType();
			rangeUpperCard = assoc.getMemberEnd().get(0).getUpper();
			rangeLowerCard = assoc.getMemberEnd().get(0).getLower();
			
			source = assoc.getMemberEnd().get(1).getType();
		}else{
			source = assoc.getMemberEnd().get(0).getType();
			
			range = assoc.getMemberEnd().get(1).getType();			
			rangeUpperCard = assoc.getMemberEnd().get(1).getUpper();
			rangeLowerCard = assoc.getMemberEnd().get(1).getLower();
		}
		Resource sourceRsrc = rdfModel.createResource(ontologyNS + source.getName());
		Resource rangeRsrc = rdfModel.createResource(ontologyNS + range.getName());
		
		//set domain and range
		Statement sourceStatement = rdfModel.createStatement(assocRrsc, RDFS.domain, sourceRsrc);
		rdfModel.add(sourceStatement);
		Statement rangeStatement = rdfModel.createStatement(assocRrsc, RDFS.range, rangeRsrc);
		rdfModel.add(rangeStatement);	
		
		Resource restriction = rdfModel.createResource();
		Statement restrStmt = rdfModel.createStatement(restriction, RDF.type, OWL2.Restriction);
		rdfModel.add(restrStmt);
		Statement stmtOnPro = rdfModel.createStatement(restriction, OWL2.onProperty, assocRrsc);
		rdfModel.add(stmtOnPro);
		
		if(rangeLowerCard == rangeUpperCard || rangeLowerCard == 1 && rangeUpperCard == -1 || rangeUpperCard == -1){
			Statement subClsStmt = rdfModel.createStatement(sourceRsrc, RDFS.subClassOf, restriction);
			rdfModel.add(subClsStmt);
		}
		
		if(!(rangeLowerCard == 1 && rangeUpperCard == -1)){
			Statement stmtOnCls = rdfModel.createStatement(restriction, OWL2.onClass, rangeRsrc);
			rdfModel.add(stmtOnCls);			
		}
		
		Statement cardStmt;
		
		if(rangeLowerCard == rangeUpperCard){
			cardStmt = rdfModel.createStatement(restriction, OWL2.qualifiedCardinality, rdfModel.createTypedLiteral(rangeLowerCard));
		}else if(rangeLowerCard == 1 && rangeUpperCard == -1){
			cardStmt = rdfModel.createStatement(restriction, OWL2.someValuesFrom, rangeRsrc);			
		}else if(rangeUpperCard == -1){
			cardStmt = rdfModel.createStatement(restriction, OWL2.minQualifiedCardinality, rdfModel.createTypedLiteral(rangeLowerCard));			
		}else{
			cardStmt = rdfModel.createStatement(restriction, OWL2.minQualifiedCardinality, rdfModel.createTypedLiteral(rangeLowerCard));
			
			Resource restrictionMax = rdfModel.createResource();
			Statement restrStmtMax = rdfModel.createStatement(restrictionMax, RDF.type, OWL2.Restriction);
			rdfModel.add(restrStmtMax);
			Statement cardMaxStmt = rdfModel.createStatement(restrictionMax, OWL2.maxQualifiedCardinality, rdfModel.createTypedLiteral(rangeUpperCard));
			rdfModel.add(cardMaxStmt);
			Statement stmtOnProMax = rdfModel.createStatement(restrictionMax, OWL2.onProperty, assocRrsc);
			rdfModel.add(stmtOnProMax);
			Statement stmtOnClsMax = rdfModel.createStatement(restrictionMax, OWL2.onClass, rangeRsrc);
			rdfModel.add(stmtOnClsMax);
			
			RDFNode[] restricNodeList = new RDFNode[2];
			restricNodeList[0] = restriction;
			restricNodeList[1] = restrictionMax;
			RDFList restrictList = rdfModel.createList(restricNodeList);
			
			Resource clsRsrc = rdfModel.createResource();
			Statement subClsStmt = rdfModel.createStatement(sourceRsrc, RDFS.subClassOf, clsRsrc);
			rdfModel.add(subClsStmt);
			
			Statement clsStmt = rdfModel.createStatement(clsRsrc, RDF.type, OWL2.Class);
			rdfModel.add(clsStmt);
			
			Statement restrictStmt = rdfModel.createStatement(clsRsrc, OWL2.intersectionOf, restrictList);
			rdfModel.add(restrictStmt);			
		}		
		rdfModel.add(cardStmt);
		
//		Statement stmt
		
		//set inverse
		if(isInverse){
			Resource origAssocRrsc = rdfModel.createResource(ontologyNS + assoc.getName(), stereotypeRsrc);
			Statement invStmt = rdfModel.createStatement(origAssocRrsc, OWL2.inverseOf, assocRrsc);
			rdfModel.add(invStmt);
		}
	}
	
	private String ontModelToString(){
		String syntax = "RDF/XML-ABBREV";
//		String syntax = "TURTLE";
		StringWriter out = new StringWriter();
		rdfModel.write(out, syntax);
		String result = out.toString();
		return result;
	}
}
