package br.com.inf.nemo.ontouml2rdf;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Set;

import net.menthor.common.transformation.OWLTransformationOptions;

import org.eclipse.emf.common.util.EList;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Property;
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
import com.hp.hpl.jena.vocabulary.XSD;

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
		
		rdfModel.setNsPrefix(UFO.getPrefix(), UFO.getURI());
		rdfModel.setNsPrefix(MLT.getPrefix(), MLT.getURI());
	}
	
	public String transform() throws Exception{
		processClasses();
		processAssociations();
		processGeneralizations();
		processGeneralizationSets();
		processDataTypes();
		
		return ontModelToString();
	}
	
	private void processDataTypes() throws Exception {
		Set<RefOntoUML.DataType> lstDataTypes = ontoParser.getAllInstances(RefOntoUML.DataType.class);
		Set<RefOntoUML.PrimitiveType> lstPrimitiveTypes = ontoParser.getAllInstances(RefOntoUML.PrimitiveType.class);
		lstDataTypes.removeAll(lstPrimitiveTypes);
		for (DataType dataType : lstDataTypes) {
			ArrayList<Association> dataTypeAssocs = ontoParser.getDirectAssociations(dataType);
			for (Association association : dataTypeAssocs) {
				Type classPrefix;
				if(association.getMemberEnd().get(0).getType().equals(dataType)){
					classPrefix = association.getMemberEnd().get(1).getType();
				}else{
					classPrefix = association.getMemberEnd().get(0).getType();
				}
				processAttributes(dataType, classPrefix);
			}
		}		
	}

	private void processGeneralizationSets() {
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
	}

	private void processGeneralizations() {
		Set<RefOntoUML.Generalization> lstGeneralizations = ontoParser.getAllInstances(RefOntoUML.Generalization.class);
		for (Generalization generalization : lstGeneralizations) {
			Classifier specific = generalization.getSpecific();
			Resource specificRsrc = rdfModel.createResource(ontologyNS + specific.getName());
			
			Classifier general = generalization.getGeneral();
			Resource generalRsrc = rdfModel.createResource(ontologyNS + general.getName());
			
			Statement subClsStmt = rdfModel.createStatement(specificRsrc, RDFS.subClassOf, generalRsrc);
			rdfModel.add(subClsStmt);			
		}
		
	}

	private void processAssociations(){
		//create associations
		Set<RefOntoUML.Association> lstAssociations = ontoParser.getAllInstances(RefOntoUML.Association.class);
		for (RefOntoUML.Association assoc : lstAssociations) {
			createObjectProperty(assoc, false);
			createObjectProperty(assoc, true);
		}	
	}
	
	private void createObjectProperty(RefOntoUML.Association assoc, boolean isInverse){
		//get source and range
		Type source, range;
		if(isInverse){
			range = assoc.getMemberEnd().get(0).getType();
			source = assoc.getMemberEnd().get(1).getType();
		}else{
			source = assoc.getMemberEnd().get(0).getType();
			range = assoc.getMemberEnd().get(1).getType();			
		}
		Set<RefOntoUML.DataType> lstDataTypes = ontoParser.getAllInstances(RefOntoUML.DataType.class);
		if(lstDataTypes.contains(source) || lstDataTypes.contains(range)) return;
		
		//create association
		String stereotype = ontoParser.getStereotype(assoc);
		Resource stereotypeRsrc = UFO.resource(stereotype);
		String assocName = assoc.getName();
		if(isInverse) assocName = "INV." + assocName ;
		Resource assocRrsc = rdfModel.createResource(ontologyNS + assocName, stereotypeRsrc);
		
		
		Resource sourceRsrc = rdfModel.createResource(ontologyNS + source.getName());
		Resource rangeRsrc = rdfModel.createResource(ontologyNS + range.getName());
		
		createDomainAndRange(assocRrsc, sourceRsrc, rangeRsrc);
		createCardinalityAssoc(assoc, isInverse, sourceRsrc, rangeRsrc, assocRrsc);
		createInverse(assoc, isInverse, stereotypeRsrc, assocRrsc);
	}
	
	private void createDomainAndRange(Resource propertyRrsc, Resource sourceRsrc, Resource rangeRsrc){
		//set domain and range
		Statement sourceStatement = rdfModel.createStatement(propertyRrsc, RDFS.domain, sourceRsrc);
		rdfModel.add(sourceStatement);
		Statement rangeStatement = rdfModel.createStatement(propertyRrsc, RDFS.range, rangeRsrc);
		rdfModel.add(rangeStatement);	
	}
	
	private void createInverse(RefOntoUML.Association assoc, boolean isInverse, Resource stereotypeRsrc, Resource assocRrsc){
		//set inverse
		if(isInverse){
			Resource origAssocRrsc = rdfModel.createResource(ontologyNS + assoc.getName(), stereotypeRsrc);
			Statement invStmt = rdfModel.createStatement(origAssocRrsc, OWL2.inverseOf, assocRrsc);
			rdfModel.add(invStmt);
		}
	}
	
	private void createCardinalityAssoc(RefOntoUML.Association assoc, boolean isInverse, Resource sourceRsrc, Resource rangeRsrc, Resource assocRrsc){
		int rangeUpperCard, rangeLowerCard;
		if(isInverse){
			rangeUpperCard = assoc.getMemberEnd().get(0).getUpper();
			rangeLowerCard = assoc.getMemberEnd().get(0).getLower();
		}else{
			rangeUpperCard = assoc.getMemberEnd().get(1).getUpper();
			rangeLowerCard = assoc.getMemberEnd().get(1).getLower();
		}
		createCardinality(sourceRsrc, rangeRsrc, assocRrsc, rangeLowerCard, rangeUpperCard);
	}
	
	private void createCardinalityAttribute(Property att, Resource sourceRsrc, Resource rangeRsrc, Resource assocRrsc){
		int rangeUpperCard = att.getUpper(); 
		int rangeLowerCard = att.getLower();
		createCardinality(sourceRsrc, rangeRsrc, assocRrsc, rangeLowerCard, rangeUpperCard);
	}
	
	private void createCardinality(Resource sourceRsrc, Resource rangeRsrc, Resource propertyRrsc, int rangeLowerCard, int rangeUpperCard){
		Resource restriction = rdfModel.createResource();
		Statement restrStmt = rdfModel.createStatement(restriction, RDF.type, OWL2.Restriction);
		rdfModel.add(restrStmt);
		Statement stmtOnPro = rdfModel.createStatement(restriction, OWL2.onProperty, propertyRrsc);
		rdfModel.add(stmtOnPro);
		
		if(rangeLowerCard == rangeUpperCard || rangeLowerCard == 1 && rangeUpperCard == -1 || rangeUpperCard == -1){
			Statement subClsStmt = rdfModel.createStatement(sourceRsrc, RDFS.subClassOf, restriction);
			rdfModel.add(subClsStmt);
		}
		
		if(!(rangeLowerCard == 1 && rangeUpperCard == -1)){
			Statement propStatement = propertyRrsc.getProperty(RDF.type);
			RDFNode propType = propStatement.getObject();
			
			com.hp.hpl.jena.rdf.model.Property propRsrc;
			if(propType.asResource().equals(OWL2.DatatypeProperty)){
				propRsrc = OWL2.onDataRange;
			}else{
				propRsrc = OWL2.onClass;
			}
			Statement stmtOnCls = rdfModel.createStatement(restriction, propRsrc, rangeRsrc);
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
			Statement stmtOnProMax = rdfModel.createStatement(restrictionMax, OWL2.onProperty, propertyRrsc);
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
	}
	
	private void processClasses() throws Exception{
		//create classes
		Set<RefOntoUML.Class> lstClasses = ontoParser.getAllInstances(RefOntoUML.Class.class);
		Set<RefOntoUML.DataType> lstDataTypes = ontoParser.getAllInstances(RefOntoUML.DataType.class);
		lstClasses.removeAll(lstDataTypes);
		
		for (RefOntoUML.Class cls : lstClasses) {
			String stereotype = ontoParser.getStereotype(cls);
			Resource stereotypeRsrc = UFO.resource(stereotype);
			rdfModel.createResource(ontologyIRI+ "#" + cls.getName(), stereotypeRsrc);
			
			processAttributes(cls, null);
		}		
	}

	private void processAttributes(Classifier cls, Type classPrefix) throws Exception {
		EList<Property> attributes = cls.getAttribute();
		String clsName = cls.getName();
		if(classPrefix != null){
			clsName = classPrefix.getName() + "." + clsName;
		}
		
		for(Property att : attributes){
			String attName = att.getName();
			
			Resource attRsrc = rdfModel.createResource(ontologyIRI+ "#" + clsName + "." + attName, OWL2.DatatypeProperty);
			
			String stereotype = ontoParser.getStereotype(cls);
			Resource stereotypeRsrc = UFO.resource(stereotype);
			Resource clsRsrc;
			if(classPrefix != null){
				clsRsrc = rdfModel.createResource(ontologyIRI+ "#" + classPrefix.getName(), stereotypeRsrc);
			}else{
				clsRsrc = rdfModel.createResource(ontologyIRI+ "#" + clsName, stereotypeRsrc);
			}
			
			
			Type type = att.getType();
			Resource typeRsrc = getDataTypeRange(type);
			createDomainAndRange(attRsrc, clsRsrc, typeRsrc);	
			createCardinalityAttribute(att, clsRsrc, typeRsrc, attRsrc);
		}
	}	

	/**
	 * Get the range of this type.
	 * The rages supported are: unsigned_int, int, unsigned_byte, 
	 * double, string, normalized_string, boolean, hex_binary, 
	 * short, byte, unsigned_long or null if doesn't have some match
	 * @throws Exception 
	 * */
	private Resource getDataTypeRange(Type type) throws Exception{
		String range = type.getName();
		if (range.equalsIgnoreCase("unsigned_int")){
			return XSD.unsignedInt;
		}else if(range.equalsIgnoreCase("int") || range.equalsIgnoreCase("integer")){
			return XSD.integer;
		}else if(range.equalsIgnoreCase("unsigned_byte")){
			return XSD.unsignedByte;
		}else if(range.equalsIgnoreCase("double")){
			return XSD.xdouble;
		}else if(range.equalsIgnoreCase("string")){
			return XSD.xstring;
		}else if(range.equalsIgnoreCase("normalized_string")){
			return XSD.normalizedString;
		}else if(range.equalsIgnoreCase("boolean")){
			return XSD.xboolean;
		}else if(range.equalsIgnoreCase("hex_binary")){
			return XSD.hexBinary;
		}else if(range.equalsIgnoreCase("short")){
			return XSD.xshort;
		}else if(range.equalsIgnoreCase("byte")){
			return XSD.xbyte;
		}else if(range.equalsIgnoreCase("unsigned_long")){
			return XSD.unsignedLong;
		}
		throw new Exception("No mapped primitive type.");
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
