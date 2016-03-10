package net.menthor.ootos.ontouml2owl_swrl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.menthor.common.settings.owl.OWL2Axiom;
import net.menthor.common.settings.owl.OWL2GeneralizationSet;
import net.menthor.common.settings.owl.OWL2Quality;
import net.menthor.common.settings.owl.OWL2Reasoner;
import net.menthor.common.settings.owl.OwlAxioms;
import net.menthor.common.settings.owl.OwlMappings;
import net.menthor.common.settings.owl.OwlOptions;
import net.menthor.ootos.util.MappedElement;
import net.menthor.ootos.util.MappingElements;
import net.menthor.ootos.util.StringUtil;

import org.eclipse.emf.common.util.EList;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLCardinalityRestriction;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNamedObject;
import org.semanticweb.owlapi.model.OWLNaryClassAxiom;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLObjectPropertyAtom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLVariable;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.Association;
import RefOntoUML.Characterization;
import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.FormalAssociation;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.Mediation;
import RefOntoUML.NamedElement;
import RefOntoUML.NominalQuality;
import RefOntoUML.PackageableElement;
import RefOntoUML.Phase;
import RefOntoUML.Property;
import RefOntoUML.Relator;
import RefOntoUML.Type;
import RefOntoUML.componentOf;
import RefOntoUML.memberOf;
import RefOntoUML.subCollectionOf;
import RefOntoUML.subQuantityOf;
import RefOntoUML.parser.OntoUMLParser;

/**
 * This class handle with OWL API and create all OWL elements
 * 
 * @author Freddy Brasileiro
 *
 */
public class OwlFactoryUtil {
	//OWL API
	private OWLOntologyManager manager;
	private OWLOntology ontology;
	private OWLDataFactory factory;
	
	private String owlNameSpace;
	
	MappingElements mappingProperties;
	
	private OwlAxioms owlAxioms;
	private OwlMappings owlMappings;
	private OntoUMLParser ontoParser;
	private String logMessage = "";
	private HashMap<String,Set<OWLObjectProperty>> hashAssociations = new HashMap<String,Set<OWLObjectProperty>>();;
	
	private Map<RefOntoUML.Element, OWL2Quality> lstQualityMappings;
	private Set<NominalQuality> lstNominalQualities;
	private Set<RefOntoUML.Element> lstMappedQualities;
	
	public OwlFactoryUtil(OntoUMLParser ontoParser, MappingElements mappingProperties, OwlOptions owlOptions, Set<RefOntoUML.Element> lstMappedQualities, Set<NominalQuality> lstNominalQualities, Map<RefOntoUML.Element, OWL2Quality> lstQualityMappings) throws OWLOntologyCreationException {
		this.ontoParser = ontoParser;
		
		this.manager = OWLManager.createOWLOntologyManager();
		this.factory = this.manager.getOWLDataFactory();
		this.owlNameSpace = ((OwlAxioms) owlOptions.getOwlAxioms()).getIRI()+"#";
		
		this.ontology = this.manager.createOntology(IRI.create(owlNameSpace));
		
		this.mappingProperties = mappingProperties;
		
		this.owlAxioms = (OwlAxioms) owlOptions.getOwlAxioms();
		this.owlMappings = (OwlMappings) owlOptions.getOwlMappings();
		this.owlNameSpace = ((OwlAxioms) owlOptions.getOwlAxioms()).getIRI()+"#";
		
		this.lstMappedQualities = lstMappedQualities;
		this.lstNominalQualities = lstNominalQualities;
		this.lstQualityMappings = lstQualityMappings;
	}
	
	/**
	 * @author Freddy Brasileiro
	 *
	 * @return the logMessage
	 */
	public String getLogMessage() {
		return logMessage;
	}
	
	/**
	 * @author Freddy Brasileiro
	 *
	 * @return the manager
	 */
	public OWLOntologyManager getManager() {
		return manager;
	}
	
	public String saveOntology() throws OWLOntologyStorageException, UnsupportedEncodingException{
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		manager.saveOntology(ontology, os);
		String owl = new String(os.toByteArray(),"UTF-8");
		//Process special characters
		owl = StringUtil.processSpecialCharacter(owl);
		return owl;
	}
	
	/**
	 * Return a OWL Classs for the ontCls
	 * */
	private OWLNamedIndividual getOwlNamedIndividual(String iri, String className){
		return factory.getOWLNamedIndividual(IRI.create(iri+className));
	}	
	private OWLClass getOwlClass(String iri, String className){
		return factory.getOWLClass(IRI.create(iri+className));
	}	
	private OWLClass getOwlClass(RefOntoUML.NamedElement ontCls){
		return getOwlClass(owlNameSpace, ontCls);
	}	
	private OWLClass getOwlClass(String iri, RefOntoUML.NamedElement ontCls){
		MappedElement mappedClass = mappingProperties.getMappedElement(ontCls);
		return getOwlClass(iri, mappedClass.getGeneratedName());
	}
	
	/**
	 * Return an OWLObjectProperty if the Association ass has some name
	 * or null otherwise;
	 * */
	private OWLObjectProperty getObjectProperty(RefOntoUML.Association ass){
		MappedElement mappedProperty = mappingProperties.getMappedElement(ass);
		String assName = mappedProperty.getGeneratedName();
		return factory.getOWLObjectProperty(IRI.create(owlNameSpace+assName));
	}

	/**
	 * Return an OWLObjectProperty if the Association ass has some name
	 * or null otherwise;
	 * */
	private OWLObjectProperty getObjectProperty(String assocName){
		return factory.getOWLObjectProperty(IRI.create(owlNameSpace+assocName));		
	}
	

	/**
	 * Return an OWLObjectProperty if the Association ass has some name
	 * or null otherwise;
	 * */
	private OWLObjectProperty getObjectProperty(String namespace, String assocName){
		return factory.getOWLObjectProperty(IRI.create(namespace+assocName));		
	}

	/**
	 * Return an OWLObjectProperty if the Association ass has some name
	 * or stereotype.destiny.source;
	 * */
	private OWLObjectProperty getInverseObjectProperty(RefOntoUML.Association ass){
		MappedElement mappedProperty = mappingProperties.getMappedElement(ass);
		String propName = mappedProperty.getInvGeneratedName();
		return factory.getOWLObjectProperty(IRI.create(owlNameSpace+propName));
	}
	
	/**
	 * Get the range of this type.
	 * The rages supported are: unsigned_int, int, unsigned_byte, 
	 * double, string, normalized_string, boolean, hex_binary, 
	 * short, byte, unsigned_long or null if doesn't have some match
	 * */
	private OWLDatatype getDataTypeRange(Classifier prop, Property mEnd) {
		String propType = OntoUMLParser.getStereotype(prop);
		return getDataTypeRange(prop, propType, mEnd);
	}
	
	private OWLDatatype getDataTypeRange(Property prop, Property mEnd) {
		Type propType = prop.getType();		
		return getDataTypeRange(prop, propType, mEnd);
	}

	/**
	 * Create a unique name for DataProperty
	 * */
	private String getDataPropertyName(NamedElement prop){
		MappedElement mappedProperty = mappingProperties.getMappedElement(prop);
		return owlNameSpace + mappedProperty.getGeneratedName();
	}
	
	public void createClass(RefOntoUML.Class ontCls){
		OWLClass owlCls = getOwlClass(ontCls);
		OWLDeclarationAxiom declarationAxiom = factory.getOWLDeclarationAxiom(owlCls);
		manager.addAxiom(ontology, declarationAxiom);
		
		createLabel(ontCls);
		putIntoUfoStructure(ontCls);
	}
	
	public void createLabel(NamedElement dtcls){
		if(!this.owlAxioms.getValue(OWL2Axiom.LABELS)) return;
		OWLClass owlCls = getOwlClass(dtcls);
		createLabel(owlCls, dtcls.getName());
	}
	
	private void createLabel(OWLNamedObject owlObj, String label){
		if(!this.owlAxioms.getValue(OWL2Axiom.LABELS)) return;
		OWLAnnotation commentAnno = factory.getOWLAnnotation( factory.getRDFSLabel(),  factory.getOWLLiteral(label));
		OWLAxiom commeAx = factory.getOWLAnnotationAssertionAxiom( owlObj.getIRI(), commentAnno);
		manager.applyChange(new AddAxiom(ontology, commeAx));
	}
	
	public void createLabel(NamedElement ass, NamedElement _RefOntoOwnerClass){
		if(!this.owlAxioms.getValue(OWL2Axiom.LABELS)) return;
		String _attributeName = getDataPropertyName(ass);
		OWLDataProperty owlProperty = factory.getOWLDataProperty(IRI.create(_attributeName));
		
		MappedElement mappedProperty = mappingProperties.getMappedElement(ass);
		
		String label;
		if(this.owlAxioms.getValue(OWL2Axiom.OBJ_PROP_BY_ENDS)){
			label = mappedProperty.getLabel();			
		}else{
			label = _RefOntoOwnerClass.getName() + "." + ass.getName();
		}
		createLabel(owlProperty, label);
		
	}
	
	private void putIntoUfoStructure(RefOntoUML.Class dtcls){
		if(!owlAxioms.getValue(OWL2Axiom.UFO_STRUCTURE)) return;
	
		OWLClass owlSuperCls = null;
		if(ontoParser.isCollective(dtcls)){
			owlSuperCls = getOwlClass("http://www.menthor.net/ontouml#", "Collection");
		}else if(ontoParser.isKind(dtcls)){
			owlSuperCls = getOwlClass("http://www.menthor.net/ontouml#", "FunctionalComplex");
		}else if(ontoParser.isQuantity(dtcls)){
			owlSuperCls = getOwlClass("http://www.menthor.net/ontouml#", "Quantity");
		}else if(ontoParser.isMode(dtcls)){
			owlSuperCls = getOwlClass("http://www.menthor.net/ontouml#", "Mode");
		}else if(ontoParser.isQuality(dtcls)){
			owlSuperCls = getOwlClass("http://www.menthor.net/ontouml#", "Quality");
		}else if(ontoParser.isRelator(dtcls)){
			owlSuperCls = getOwlClass("http://www.menthor.net/ontouml#", "Relator");
		}else if(!ontoParser.isMoment(dtcls) && !ontoParser.isObject(dtcls)){
			owlSuperCls = getOwlClass("http://www.menthor.net/ontouml#", "Event");
		}
		
		if(owlSuperCls != null){
			OWLClass owlCls = getOwlClass(dtcls);
			createSubClassOf(owlSuperCls, owlCls);
		}		
	}
	
	private void putIntoUfoStructure(Association ass) {
		if(!owlAxioms.getValue(OWL2Axiom.UFO_STRUCTURE)) return;
		
		OWLObjectProperty topProp = null;
		OWLObjectProperty topInvProp = null;
		
		Property srcMemberEnd = ass.getMemberEnd().get(0);
		
		boolean srcIsComposite = srcMemberEnd.isIsComposite();		
		
		RefOntoUML.Classifier srcT = (Classifier) srcMemberEnd.getType();
		
		if(ass instanceof subCollectionOf){
			if(srcIsComposite){
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "collectionWhole");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "collectionPart");
			}else{
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "collectionPart");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "collectionWhole");
			}
		}else if(ass instanceof memberOf){
			if(srcIsComposite){
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "isMemberOf");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "member");
			}else{
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "member");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "isMemberOf");
			}
		}else if(ass instanceof componentOf){
			if(srcIsComposite){
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "functionalWhole");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "functionalPart");
			}else{
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "functionalPart");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "functionalWhole");
			}
		}else if(ass instanceof subQuantityOf){
			if(srcIsComposite){
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "quantityWhole");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "quantityPart");
			}else{
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "quantityPart");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "quantityWhole");
			}
		}else if(ass instanceof MaterialAssociation){
			topProp = getObjectProperty("http://www.menthor.net/ontouml#", "materialProperty");
			topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "materialProperty");
		}else if(ass instanceof FormalAssociation){
			topProp = getObjectProperty("http://www.menthor.net/ontouml#", "formalProperty");
			topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "formalProperty");
		}else if(ass instanceof Mediation){
			if(ontoParser.isRelator(srcT)){
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "mediates");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "mediatedBy");
			}else{
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "mediatedBy");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "mediates");
			}
		}else if(ass instanceof Characterization){
			if(ontoParser.isQuality(srcT)){
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "bearer");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "intrinsicProperty");
			}else{
				topProp = getObjectProperty("http://www.menthor.net/ontouml#", "intrinsicProperty");
				topInvProp = getObjectProperty("http://www.menthor.net/ontouml#", "bearer");				
			}
		}
		
		if(topProp != null){
			MappedElement mappedProperty = mappingProperties.getMappedElement(ass);
			OWLObjectProperty owlProp = getObjectProperty(mappedProperty.getGeneratedName());
			OWLObjectProperty owlInvProp = getObjectProperty(mappedProperty.getInvGeneratedName());
			
			createSubPropertyOf(topProp, owlProp);
			createSubPropertyOf(topInvProp, owlInvProp);
		}else{
			logMessage  += "Warning: No UFO element founded for the association " + ass.getName() + " with the stereotype <" + OntoUMLParser.getStereotype(ass) + ">\n";
		}
	}

	/**
	 * Put all equivalentClass, disjointClass and subClassOf axioms from a class in just one axiom for only one class
	 * @param 
	 */
	public void processAxioms(){
		for(OWLClass currentClass : ontology.getClassesInSignature()){

			Set<OWLClassExpression> lstEquivalentExpression = new HashSet<OWLClassExpression>();
			Set<OWLClassExpression> lstSubClassOfExpression = new HashSet<OWLClassExpression>();

			Set<OWLClassAxiom> lstClassAxioms= ontology.getAxioms(currentClass);
			Iterator<OWLClassAxiom> itr = lstClassAxioms.iterator();

			//Process EquivalentClassAxiom
			while(itr.hasNext()) {
				OWLClassAxiom ax = itr.next();

				if(ax instanceof OWLEquivalentClassesAxiom){
					OWLNaryClassAxiom nax = (OWLNaryClassAxiom)ax;
					lstEquivalentExpression.addAll(nax.getClassExpressions());
					manager.removeAxiom(ontology, ax);
				} 
				if(ax instanceof OWLSubClassOfAxiom){
					OWLSubClassOfAxiom sax = (OWLSubClassOfAxiom)ax;
					lstSubClassOfExpression.add(sax.getSuperClass());
					manager.removeAxiom(ontology, ax);	
				}
			}

			if(lstEquivalentExpression.size() > 1){
				lstEquivalentExpression.remove(currentClass);
				createEquivalentIntersection(currentClass, lstEquivalentExpression);
			}
			
			if(lstSubClassOfExpression.size() > 1){
				createSubClassOfIntersection(currentClass, lstSubClassOfExpression);
			}else{
				Iterator<OWLClassExpression> i = lstSubClassOfExpression.iterator();
				while(i.hasNext()) {
					OWLClassExpression ax = i.next();

					try {
						createSubClassOf(ax.asOWLClass(), currentClass);
					}
					catch(Exception e) {

					}
				}
			}
		}
	}	
	
	public void createEquivalentIntersection(OWLClassExpression currentClass, Set<OWLClassExpression> lstEquivalentExpression){
		OWLObjectIntersectionOf oi = factory.getOWLObjectIntersectionOf(lstEquivalentExpression);
		OWLEquivalentClassesAxiom eqAx = factory.getOWLEquivalentClassesAxiom(currentClass, oi);
		manager.applyChange(new AddAxiom(ontology, eqAx));
	}
	
	public void createSubClassOfIntersection(OWLClassExpression currentClass, Set<OWLClassExpression> lstSubClassOfExpression){
		OWLObjectIntersectionOf oi = factory.getOWLObjectIntersectionOf(lstSubClassOfExpression);
		OWLSubClassOfAxiom sbAx = factory.getOWLSubClassOfAxiom(currentClass, oi);
		manager.applyChange(new AddAxiom(ontology, sbAx));
	}
	
	public void createComment(PackageableElement p, String comment){
		OWLClass cls = factory.getOWLClass(IRI.create(owlNameSpace+p.getName().replaceAll(" ", "_").replaceAll("\n", "_")));
		OWLAnnotation commentAnno = factory.getOWLAnnotation( factory.getRDFSComment(),  factory.getOWLLiteral(comment, "pt"));
		OWLAxiom ax = factory.getOWLAnnotationAssertionAxiom( cls.getIRI(), commentAnno);
		manager.applyChange(new AddAxiom(ontology, ax));
	}
	
	public void createComment(String comment){
		OWLAnnotation commentAnno = factory.getOWLAnnotation( factory.getRDFSComment(),  factory.getOWLLiteral(comment, "pt"));
		OWLAxiom ax = factory.getOWLAnnotationAssertionAxiom( IRI.create(owlNameSpace.substring(0,owlNameSpace.length()-1)), commentAnno);
		manager.applyChange(new AddAxiom(ontology, ax));
	}
	
	private OWLDatatype getDataTypeRange(NamedElement prop, Object propType, Property mEnd) {
		String range = "";
		OWL2Datatype owlPrimType = null;
		String owlPrimTypeStr = null;
		if(owlMappings.getAttributes().containsKey(prop)){
			owlPrimTypeStr = owlMappings.getAttributes().get(prop);
		}else if(owlMappings.getAttributes().containsKey(mEnd)){
			owlPrimTypeStr = owlMappings.getAttributes().get(mEnd);
		}else if(owlMappings.getPrimitives().containsKey(propType)){
			owlPrimTypeStr = owlMappings.getPrimitives().get(propType);
		}else if(owlMappings.getPrimitives().containsKey(prop)){
			owlPrimTypeStr = owlMappings.getPrimitives().get(prop);
		}else{
			range = mappingProperties.getName(propType);
		}
		
		if(owlPrimTypeStr != null){
			ArrayList<String> owl2DataTypeStrLst = new ArrayList<String>();
			for (OWL2Datatype owl2DataType : OWL2Datatype.values()) {
				owl2DataTypeStrLst.add(owl2DataType.toString());
			}
			if(owl2DataTypeStrLst.contains(owlPrimTypeStr)){
				owlPrimType = OWL2Datatype.valueOf(owlPrimTypeStr);
				range = owlPrimType.toString();
			}			
		}
		
		if(owlPrimType != null){
			return factory.getOWLDatatype(owlPrimType.getIRI());
		}else if(owlPrimType == null && owlPrimTypeStr != null){
			return factory.getOWLDatatype(IRI.create(this.owlNameSpace+owlPrimTypeStr));
		}else if (range.equalsIgnoreCase("unsigned_int") || range.equalsIgnoreCase("unsignedInt")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_UNSIGNED_INT.getIRI());
		}else if(range.equalsIgnoreCase("int") || range.equalsIgnoreCase("integer") || range.equalsIgnoreCase("IntegerIntervalDimension") || range.equalsIgnoreCase("IntegerOrdinalDimension") || range.equalsIgnoreCase("IntegerRationalDimension")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_INTEGER.getIRI());
		}else if(range.equalsIgnoreCase("unsigned_byte") || range.equalsIgnoreCase("unsignedByte")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_UNSIGNED_BYTE.getIRI());
		}else if(range.equalsIgnoreCase("double")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_DOUBLE.getIRI());
		}else if(range.equalsIgnoreCase("string") || range.equalsIgnoreCase("NominalQuality")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_STRING.getIRI());
		}else if(range.equalsIgnoreCase("normalized_string") || range.equalsIgnoreCase("normalizedString")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_NORMALIZED_STRING.getIRI());
		}else if(range.equalsIgnoreCase("boolean")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_BOOLEAN.getIRI());
		}else if(range.equalsIgnoreCase("hex_binary") || range.equalsIgnoreCase("hexBinary")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_HEX_BINARY.getIRI());
		}else if(range.equalsIgnoreCase("short")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_SHORT.getIRI());
		}else if(range.equalsIgnoreCase("byte")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_BYTE.getIRI());
		}else if(range.equalsIgnoreCase("unsigned_long") || range.equalsIgnoreCase("unsignedLong")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_UNSIGNED_LONG.getIRI());
		}else if(range.equalsIgnoreCase("anyURI")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_ANY_URI.getIRI());
		}else if(range.equalsIgnoreCase("base64Binary")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_BASE_64_BINARY.getIRI());
		}else if(range.equalsIgnoreCase("date")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_DATE_TIME.getIRI());
		}else if(range.equalsIgnoreCase("dateTime")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_DATE_TIME_STAMP.getIRI());
		}else if(range.equalsIgnoreCase("decimal") || range.equalsIgnoreCase("DecimalIntervalDimension") || range.equalsIgnoreCase("DecimalOrdinalDimension") || range.equalsIgnoreCase("DecimalRationalDimension")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_DECIMAL.getIRI());
		}else if(range.equalsIgnoreCase("Name")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_NAME.getIRI());
		}else if(range.equalsIgnoreCase("NCName")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_NCNAME.getIRI());
		}else if(range.equalsIgnoreCase("nonPositiveInteger")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_NON_POSITIVE_INTEGER.getIRI());
		}else if(range.equalsIgnoreCase("nonNegativeInteger")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_NON_NEGATIVE_INTEGER.getIRI());
		}else if(range.equalsIgnoreCase("unsignedShort")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_UNSIGNED_SHORT.getIRI());
		}else if(range.equalsIgnoreCase("negativeInteger")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_NEGATIVE_INTEGER.getIRI());
		}else if(range.equalsIgnoreCase("positiveInteger")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_POSITIVE_INTEGER.getIRI());
		}else if(range.equalsIgnoreCase("language")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_LANGUAGE.getIRI());
		}else if(range.equalsIgnoreCase("long")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_LONG.getIRI());
		}else if(range.equalsIgnoreCase("float")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_FLOAT.getIRI());
		}else if(range.equalsIgnoreCase("token")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_TOKEN.getIRI());
		}else if(range.equalsIgnoreCase("NMTOKEN")){
			return factory.getOWLDatatype(OWL2Datatype.XSD_NMTOKEN.getIRI());
		}
		
		return factory.getOWLDatatype(OWL2Datatype.RDFS_LITERAL.getIRI());
	}
	
	/**
	 * Used to create the Class attributes
	 * */
	public void createDataProperty(Property prop, RefOntoUML.Classifier _RefOntoOwnerClass, ArrayList<Integer> _lowerCard, ArrayList<Integer> _upperCard) {

		OWLDatatype tipoAtributo = null;
		OWLDataProperty atributo = null;
		
		String _attributeName = getDataPropertyName(prop);
		
		tipoAtributo = getDataTypeRange(prop, null);
		atributo = factory.getOWLDataProperty(IRI.create(_attributeName));
		
		OWLDeclarationAxiom declarationAxiom = factory.getOWLDeclarationAxiom(atributo);
		manager.addAxiom(ontology, declarationAxiom);
		
		createLabel(prop, _RefOntoOwnerClass);
		
		//Set the Range of the DataProperty
		createDataPropertyRange(atributo, tipoAtributo);
		
		//set the owner of this datatype (Domain)
		OWLClass _OWLownerClass = getOwlClass(_RefOntoOwnerClass);
		createDataPropertyDomain(atributo, _OWLownerClass);
		
		//Solving the cardinality of the attribute
		int upperCard = 1;
		int lowerCard = 1;

		//Multiply all last cardinality
		for(int i = 0; i < _lowerCard.size(); i++){
			lowerCard *= _lowerCard.get(i);
			if(upperCard == -1 || _upperCard.get(i) == -1){
				upperCard = -1;
			}else{
				upperCard *= _upperCard.get(i);
			}
		}

		if(upperCard ==-1 || prop.getUpper() == -1){
			upperCard = -1;
		}else{
			upperCard *= prop.getUpper();
		}
		lowerCard *= prop.getLower();

		createCardinality(atributo, tipoAtributo, _RefOntoOwnerClass, lowerCard, upperCard);		
	}
	
	public void createSubClassOf(Classifier general, Classifier specific) {
		OWLClass father = getOwlClass(general);
		OWLClass son = 	getOwlClass(specific);

		createSubClassOf(father, son);	
	}
	
	public void createSubClassOf(OWLClass general, OWLClass specific) {
		//Set subClassOf 
		OWLAxiom axiom = factory.getOWLSubClassOfAxiom(specific,general);	
		manager.applyChange(new AddAxiom(ontology, axiom));	
	}
	
	public void createSubPropertyOf(OWLObjectProperty topProperty, OWLObjectProperty prop){
		OWLSubObjectPropertyOfAxiom sopa = factory.getOWLSubObjectPropertyOfAxiom(prop,topProperty);
		manager.applyChange(new AddAxiom(ontology, sopa));
	}
	
	public void createSubPropertyOf(Association ass){
		MappedElement superMappedProperty = mappingProperties.getSuperProperty(ass);
		String superPropertyName = superMappedProperty.getGeneratedName();
		String invSuperPropertyName = superMappedProperty.getInvGeneratedName();
		OWLObjectProperty topProperty = getObjectProperty(superPropertyName);
		OWLObjectProperty invTopProperty = getObjectProperty(invSuperPropertyName);
		
		OWLObjectProperty prop = getObjectProperty(ass);
		OWLObjectProperty invProp = getInverseObjectProperty(ass);
		
		createSubPropertyOf(topProperty, prop);
		createSubPropertyOf(invTopProperty, invProp);
		
		createObjectPropertyInverse(topProperty, invTopProperty);
		
		//Used after to make associations disjoints
		String stereotype = OntoUMLParser.getStereotype(superMappedProperty.getProperty());
		putInHash(stereotype, topProperty);
		putInHash(stereotype, invTopProperty);
	}
	
	public void createObjectPropertyInverse(OWLObjectProperty property, OWLObjectProperty invProperty){
		if(!owlAxioms.getValue(OWL2Axiom.INVERSE)) return;
		manager.applyChange(new AddAxiom(ontology,factory.getOWLInverseObjectPropertiesAxiom(property, invProperty)));		
	}
	
	public void createObjectPropertyInverse(OWLObjectProperty property, OWLObjectProperty invProperty, OWLClass src, OWLClass dst){
		createObjectPropertyInverse(property, invProperty);
		createObjectPropertyDomain(dst, invProperty);
		createObjectPropertyRange(src, invProperty);
	}
	
	public void createDataPropertyDomain(OWLDataProperty dataProperty, OWLClass owlClass){
		OWLDataPropertyDomainAxiom axDomain = factory.getOWLDataPropertyDomainAxiom(dataProperty, owlClass);
		manager.applyChange(new AddAxiom(ontology, axDomain));
	}
	
	public void createDataPropertyDomain(Classifier datatype, Classifier qua, NamedElement cls){
		if(!owlAxioms.getValue(OWL2Axiom.DOMAIN)) return;
		String dataPropName = mappingProperties.getName(new Object[]{cls, qua, datatype});
		OWLDataProperty dataProperty = factory.getOWLDataProperty(IRI.create(owlNameSpace+dataPropName));
		OWLClass owlClass = getOwlClass(cls);
		createDataPropertyDomain(dataProperty, owlClass);				
	}
	
	public void createDataPropertyRange(OWLDataProperty dataProperty, OWLDataRange tipoAtributo){
		if(!owlAxioms.getValue(OWL2Axiom.RANGE)) return;
		OWLDataPropertyRangeAxiom axRange = factory.getOWLDataPropertyRangeAxiom(dataProperty, tipoAtributo);
		manager.applyChange(new AddAxiom(ontology, axRange));
	}
	
	public void createDataPropertyRange(Classifier datatype, Classifier qua, NamedElement cls, Property mEnd){
		if(!owlAxioms.getValue(OWL2Axiom.RANGE)) return;
		//Set the Range of the DataProperty
		OWLDatatype tipoAtributo = getDataTypeRange(datatype, mEnd);
		String dataPropName = mappingProperties.getName(new Object[]{cls, qua, datatype});
		OWLDataProperty dataProperty = factory.getOWLDataProperty(IRI.create(owlNameSpace+dataPropName));
		createDataPropertyRange(dataProperty, tipoAtributo);	
	}
	
	public void createCardinality(Classifier datatype, Property mEnd, Classifier qua, NamedElement cls, int lowerCard, int upperCard) {
		if(!owlAxioms.getValue(OWL2Axiom.CARDINALITIES)) return;
		String dataPropName = mappingProperties.getName(new Object[]{cls, qua, datatype});
		OWLDataProperty dataProperty = factory.getOWLDataProperty(IRI.create(owlNameSpace+dataPropName));
		OWLDatatype tipoAtributo = getDataTypeRange(datatype, mEnd);
		createCardinality(dataProperty, tipoAtributo, cls, lowerCard, upperCard);
	}
	
	private void createCardinality(OWLDataProperty dataProperty, OWLDatatype tipoAtributo, NamedElement cls, int lowerCard, int upperCard) {
		if(!owlAxioms.getValue(OWL2Axiom.CARDINALITIES)) return;
		OWLClass src = getOwlClass(cls);
		//generate the OWL DataProperty
		
		OWLEquivalentClassesAxiom ax = null;
		OWLSubClassOfAxiom sax = null; 
		if(upperCard == lowerCard){
			//x..x
			OWLDataExactCardinality oecr = factory.getOWLDataExactCardinality(lowerCard, dataProperty, tipoAtributo);
			ax = factory.getOWLEquivalentClassesAxiom(src, oecr);
		}else if(upperCard == -1 && lowerCard == 1){
			//1..*
			//OWLDatatype dataRange = factory.getOWLDatatype(OWL2Datatype.RDFS_LITERAL.getIRI());
			OWLDataSomeValuesFrom oecr = factory.getOWLDataSomeValuesFrom(dataProperty, tipoAtributo);
			ax = factory.getOWLEquivalentClassesAxiom(src, oecr);
		}else if (upperCard != -1 && lowerCard == 0){
			//0..*
			OWLDataMaxCardinality maxcard = factory.getOWLDataMaxCardinality(upperCard, dataProperty, tipoAtributo);
			sax = factory.getOWLSubClassOfAxiom(src, maxcard);
		}else if(upperCard == -1 && lowerCard != 0){
			//x..*
			OWLDataMinCardinality mincard = factory.getOWLDataMinCardinality(lowerCard, dataProperty, tipoAtributo);
			ax = factory.getOWLEquivalentClassesAxiom(src, mincard);	
		}else if(upperCard != -1 && lowerCard > 0){
			//x..n
			OWLDataMaxCardinality maxcard = factory.getOWLDataMaxCardinality(upperCard, dataProperty, tipoAtributo);
			OWLDataMinCardinality mincard = factory.getOWLDataMinCardinality(lowerCard, dataProperty, tipoAtributo);
			OWLObjectIntersectionOf oio =  factory.getOWLObjectIntersectionOf(maxcard,mincard);
			ax = factory.getOWLEquivalentClassesAxiom(src, oio);
		}else{
			logMessage += "Warning: The cardinality 0..* is not mapped to OWL (occurrence at association "+dataProperty.getIRI().toString().substring(dataProperty.getIRI().toString().indexOf("#")+1)+" , from classe "+src.getIRI().toString().substring(src.getIRI().toString().indexOf("#")+1)+");\n";
		}

		if(ax != null){
			manager.applyChange(new AddAxiom(ontology, ax));
		}

		if(sax != null){
			manager.applyChange(new AddAxiom(ontology, sax));
		}
	}

	private void createCardinality(OWLObjectProperty prop, OWLClass src, OWLClass dst, int lowerCard, int upperCard){
		if(!owlAxioms.getValue(OWL2Axiom.CARDINALITIES)) return;
		
		OWLEquivalentClassesAxiom ax = null;
		OWLSubClassOfAxiom sax = null; 

		if(upperCard == lowerCard){
			//x..x
			OWLObjectExactCardinality oecr = factory.getOWLObjectExactCardinality(lowerCard, prop, dst);
			ax = factory.getOWLEquivalentClassesAxiom(src, oecr);
		}else if(upperCard == -1 && lowerCard == 1){
			//1..*
			OWLObjectSomeValuesFrom oecr = factory.getOWLObjectSomeValuesFrom(prop, dst);
			ax = factory.getOWLEquivalentClassesAxiom(src, oecr);
		}else if (upperCard != -1 && lowerCard == 0){
			//0..*
			OWLObjectMaxCardinality maxcard = factory.getOWLObjectMaxCardinality(upperCard, prop,dst);
			sax = factory.getOWLSubClassOfAxiom(src, maxcard);
		}else if(upperCard == -1 && lowerCard != 0){
			//x..*
			OWLObjectMinCardinality mincard = factory.getOWLObjectMinCardinality(lowerCard, prop,dst);
			ax = factory.getOWLEquivalentClassesAxiom(src, mincard);	
		}else if(upperCard != -1 && lowerCard > 0){
			//x..n
			OWLObjectMaxCardinality maxcard = factory.getOWLObjectMaxCardinality(upperCard, prop,dst);
			OWLObjectMinCardinality mincard = factory.getOWLObjectMinCardinality(lowerCard, prop,dst);
			OWLObjectIntersectionOf oio =  factory.getOWLObjectIntersectionOf(maxcard,mincard);
			ax = factory.getOWLEquivalentClassesAxiom(src, oio);
		}else{
			logMessage += "Warning: The cardinality 0..* is not mapped to OWL (occurrence at association "+prop.getIRI().toString().substring(prop.getIRI().toString().indexOf("#")+1)+" , from classe "+src.getIRI().toString().substring(src.getIRI().toString().indexOf("#")+1)+" to class "+dst.getIRI().toString().substring(dst.getIRI().toString().indexOf("#")+1)+");\n";
		}

		if(ax != null){
			manager.applyChange(new AddAxiom(ontology, ax));
		}

		if(sax != null){
			manager.applyChange(new AddAxiom(ontology, sax));
		}
	}
	
	/**
	 * Create an Association and set the cardinality for the destiny
	 * @param lstDataType 
	 * */
	public void createObjectProperty(OWLObjectProperty prop){
		OWLDeclarationAxiom declAxiom = factory.getOWLDeclarationAxiom(prop);
		manager.addAxiom(ontology, declAxiom);
	}
	
	public void createObjectProperty(Association ass){
		int sideSrc = 0, sideDst = 1;
		
		OWLObjectProperty prop = getObjectProperty(ass);
		createObjectProperty(prop);

		RefOntoUML.Classifier srcT = (Classifier) ass.getMemberEnd().get(sideSrc).getType();
		RefOntoUML.Classifier tgtT = (Classifier) ass.getMemberEnd().get(sideDst).getType();
		
		createLabel(ass, srcT);
		
		//source class of the relation
		OWLClass src = getOwlClass(srcT);		

		//destination class of the relation
		OWLClass dst = getOwlClass(tgtT);
		
		//Set domain and range from the property
		if(owlAxioms.getValue(OWL2Axiom.DOMAIN) && isMappedAsOwlClass(srcT))
			createObjectPropertyDomain(srcT, prop);
		if(owlAxioms.getValue(OWL2Axiom.RANGE) && isMappedAsOwlClass(srcT))
			createObjectPropertyRange(tgtT, prop);
		
		if(!isMappedAsOwlClass(srcT) || !isMappedAsOwlClass(tgtT)) return;
		
		//Processing cardinality to the destiny
		int upperCard = ass.getMemberEnd().get(sideDst).getUpper();
		int lowerCard = ass.getMemberEnd().get(sideDst).getLower();

		createCardinality(prop, src, dst, lowerCard, upperCard);
		
		putIntoUfoStructure(ass);
		String stereotype = OntoUMLParser.getStereotype(ass);
		putInHash(stereotype, prop);
		
		OWLObjectProperty invProp = getInverseObjectProperty(ass);
		createObjectProperty(invProp);
		if(owlAxioms.getValue(OWL2Axiom.OBJ_PROP_BY_ENDS))
			createLabel(invProp, mappingProperties.getMappedElement(ass).getInvLabel());
		
		//Processing cardinality to the destiny
		upperCard = ass.getMemberEnd().get(sideDst).getUpper();
		lowerCard = ass.getMemberEnd().get(sideDst).getLower();

		createCardinality(invProp, dst, src, lowerCard, upperCard);
		putInHash(stereotype, invProp);
		
		createObjectPropertyInverse(prop, invProp, src, dst);
	}
	
	public void createObjectPropertyDomain(OWLClass src, OWLObjectProperty prop){
		if(owlAxioms.getValue(OWL2Axiom.DOMAIN))
			manager.applyChange(new AddAxiom(ontology, factory.getOWLObjectPropertyDomainAxiom(prop, src)));
	}
	
	public void createObjectPropertyDomain(RefOntoUML.Classifier srcT, OWLObjectProperty prop){
		OWLClass src = getOwlClass(srcT);
		if(owlAxioms.getValue(OWL2Axiom.DOMAIN) && isMappedAsOwlClass(srcT))
			createObjectPropertyDomain(src, prop);
	}
	
	public void createObjectPropertyRange(OWLClass dst, OWLObjectProperty prop){
		if(owlAxioms.getValue(OWL2Axiom.RANGE))
			manager.applyChange(new AddAxiom(ontology, factory.getOWLObjectPropertyRangeAxiom(prop, dst)));
	}
	
	public void createObjectPropertyRange(RefOntoUML.Classifier tgtT, OWLObjectProperty prop){
		OWLClass dst = getOwlClass(tgtT);
		if(owlAxioms.getValue(OWL2Axiom.RANGE) && isMappedAsOwlClass(tgtT))
			createObjectPropertyRange(dst, prop);
	}
	
	void removeUndesiredAxioms() {
		Set<OWLAxiom> axioms = ontology.getAxioms();
		for (OWLAxiom owlAxiom : axioms) {
			if(owlAxiom instanceof OWLFunctionalObjectPropertyAxiom && !owlAxioms.getValue(OWL2Axiom.FUNCTIONAL)){
				manager.removeAxiom(ontology, owlAxiom);
			}else if(owlAxiom instanceof OWLInverseFunctionalObjectPropertyAxiom && !owlAxioms.getValue(OWL2Axiom.INVERSE_FUNCTIONAL)){
				manager.removeAxiom(ontology, owlAxiom);
			}else if(owlAxiom instanceof OWLTransitiveObjectPropertyAxiom && (!owlAxioms.getValue(OWL2Axiom.TRANSITIVE) || owlAxioms.getReasoner().equals(OWL2Reasoner.PELLET))){
				if(owlAxioms.getReasoner().equals(OWL2Reasoner.PELLET)){
					logMessage += "The axiom Transitivity was removed because is not supported by Pellet.\n";
				}
				manager.removeAxiom(ontology, owlAxiom);
			}else if(owlAxiom instanceof OWLSymmetricObjectPropertyAxiom && !owlAxioms.getValue(OWL2Axiom.SYMMETRIC)){
				manager.removeAxiom(ontology, owlAxiom);
			}else if(owlAxiom instanceof OWLAsymmetricObjectPropertyAxiom && (!owlAxioms.getValue(OWL2Axiom.ASYMMETRIC) || owlAxioms.getReasoner().equals(OWL2Reasoner.PELLET))){
				if(owlAxioms.getReasoner().equals(OWL2Reasoner.PELLET)){
					logMessage += "The axiom Transitivity was removed because is not supported by Pellet.\n";
				}
				manager.removeAxiom(ontology, owlAxiom);
			}else if(owlAxiom instanceof OWLReflexiveObjectPropertyAxiom && !owlAxioms.getValue(OWL2Axiom.REFLEXIVE)){
				manager.removeAxiom(ontology, owlAxiom);
			}else if(owlAxiom instanceof OWLIrreflexiveObjectPropertyAxiom && !owlAxioms.getValue(OWL2Axiom.IRREFLEXIVE)){
				manager.removeAxiom(ontology, owlAxiom);
			}else if(owlAxiom instanceof OWLDisjointClassesAxiom && !owlAxioms.getValue(OWL2Axiom.DISJOINTNESS_OF_CLASSES)){
				manager.removeAxiom(ontology, owlAxiom);
			}else if(owlAxiom instanceof OWLDisjointObjectPropertiesAxiom && !owlAxioms.getValue(OWL2Axiom.DISJOINTNESS_OF_ASSOCIATIONS)){
				manager.removeAxiom(ontology, owlAxiom);
			}else if(owlAxiom instanceof OWLCardinalityRestriction && !owlAxioms.getValue(OWL2Axiom.CARDINALITIES)){
				manager.removeAxiom(ontology, owlAxiom);
			}else if(owlAxiom instanceof SWRLRule && !owlAxioms.getValue(OWL2Axiom.SWRL_RULES)){
				manager.removeAxiom(ontology, owlAxiom);
			}
		}		
	}
	
	public void createDisjointObjectProperties(){
		if(!owlAxioms.getValue(OWL2Axiom.DISJOINTNESS_OF_ASSOCIATIONS)) return;
		
		Set<OWLObjectProperty> lstOWLObjectProperty = new HashSet<OWLObjectProperty>();
		for (String stereotype : hashAssociations.keySet()) {
				if(!stereotype.equals("formal") && !stereotype.equals("material")){
					for (OWLObjectProperty prop : hashAssociations.get(stereotype)) {
						//For each ObjectProperty of a key (stereotype) make different for the 
						//properties of the other stereotypes (_stereotype)
							if(!lstOWLObjectProperty.contains(prop)) lstOWLObjectProperty.add(prop);
					}
				}
			
		}
		if(lstOWLObjectProperty.size() > 1){
			OWLDisjointObjectPropertiesAxiom axiom = factory.getOWLDisjointObjectPropertiesAxiom(lstOWLObjectProperty);
			manager.applyChange(new AddAxiom(ontology, axiom));
		}
	}
	
	private void putInHash(String stereotype, OWLObjectProperty prop){
		if(!hashAssociations.containsKey(stereotype)){
			hashAssociations.put(stereotype, new HashSet<OWLObjectProperty>());
		}
		hashAssociations.get(stereotype).add(prop);
	}	
	
	public void createGeneralizationSetAttributes(GeneralizationSet genSet){
		EList<Generalization> generalizations = genSet.getGeneralization();
		
		if(generalizations.get(0).getGeneral() instanceof DataType){
			return;
		}
		
		OWLClass father = getOwlClass(generalizations.get(0).getGeneral());

		Set<OWLClass> lstCls = new HashSet<OWLClass>();

		for(int i = 0; i < generalizations.size(); i++){
			OWLClass son = 	getOwlClass(generalizations.get(i).getSpecific());				

			//Set subClassOf 
			createSubClassOf(father, son);	

			//Used after to make the unionOf
			lstCls.add(son);
		}	

		if(lstCls.isEmpty()) return;
		
		if(!generalizations.isEmpty() && generalizations.size() > 1){
			if((genSet.isIsDisjoint() || genSet.getGeneralization().get(0).getSpecific() instanceof Phase) && owlAxioms.getValue(OWL2Axiom.DISJOINTNESS_OF_CLASSES)){
				//{disjoint, complete} or is a Phase Partition
				OWLAxiom axiom = factory.getOWLDisjointClassesAxiom(lstCls);		
				manager.applyChange(new AddAxiom(ontology, axiom));
			}
			if(genSet.isIsCovering() && owlAxioms.getValue(OWL2Axiom.COMPLETENESS_OF_CLASSES)){
				//Set all classes equivalents
				OWLObjectUnionOf ouf = factory.getOWLObjectUnionOf(lstCls);
				OWLEquivalentClassesAxiom eqclax = factory.getOWLEquivalentClassesAxiom(father, ouf);
				manager.addAxiom(ontology, eqclax);
			}		
		}
	}
	
	public void createBasicStructure() throws OWLOntologyCreationException {
		InputStream inputStream = Transformer.class.getResourceAsStream("/resources/owl_basic_structure_ontouml.owl");
		OWLOntology owlBasics = manager.loadOntologyFromOntologyDocument(inputStream);
		
		Set<OWLAxiom> tBoxAxioms = owlBasics.getAxioms();
		for (OWLAxiom owlAxiom : tBoxAxioms) {
			manager.addAxiom(ontology, owlAxiom);
		}		
	}
	
	public void createGenSetAsEnum(GeneralizationSet gs, OWL2GeneralizationSet mappingType){
		Set<Classifier> localGsSetMapChildren;
		if(mappingType.equals(OWL2GeneralizationSet.ALLCLASSES)){
			localGsSetMapChildren = ontoParser.getAllChildren(gs);					
		}else if(mappingType.equals(OWL2GeneralizationSet._1STCLASSES)){
			localGsSetMapChildren = ontoParser.getChildren(gs);
		}else{
			localGsSetMapChildren = ontoParser.getLeafChildren(gs);
		}
		
		OWLIndividual[] individuals = new OWLIndividual[localGsSetMapChildren.size()];
		int j = 0;
		for (Classifier classifier : localGsSetMapChildren) {
			OWLNamedIndividual individual = getOwlNamedIndividual(owlNameSpace, classifier.getName());
			individuals[j] = individual;
			j++;
		}	
		OWLObjectOneOf oneOf = factory.getOWLObjectOneOf(individuals);
		
		OWLClass owlGs = getOwlClass(this.owlNameSpace, gs.getName().replaceAll(" ", "_"));
		OWLEquivalentClassesAxiom ax = factory.getOWLEquivalentClassesAxiom(owlGs, oneOf);
		manager.applyChange(new AddAxiom(ontology, ax));
		
		int lowerCard;
		int upperCard;
		if(gs.isIsCovering() && gs.isIsDisjoint()){
			lowerCard = 1;
			upperCard = 1;
		}else if(gs.isIsCovering()){
			lowerCard = 1;
			upperCard = -1;
		}else{
			lowerCard = 0;
			upperCard = 1;
		}
		
		OWLObjectProperty prop = getObjectProperty("has_"+gs.getName());
		createObjectProperty(prop);
		
		OWLClass src = getOwlClass(gs.getGeneralization().get(0).getGeneral());
		
		createObjectPropertyDomain(src, prop);
		createObjectPropertyRange(owlGs, prop);
		
		createCardinality(prop, src, owlGs, lowerCard, upperCard);
	}

	/**
	 * These are variables used in the context of the process of attributes structured
	 * */
	public void createDataProperty(RefOntoUML.Classifier datatype, Association ass, RefOntoUML.Classifier _RefOntoOwnerClass) {
		OWLDataProperty dataProperty = null;
		
		String _attributeName = mappingProperties.getMappedElement(datatype).getGeneratedName();
		dataProperty = factory.getOWLDataProperty(IRI.create(owlNameSpace+_attributeName));
		
		createLabel(datatype);
		
		OWLClass _OWLownerClass = getOwlClass(_RefOntoOwnerClass);
		
		createDataPropertyDomain(dataProperty, _OWLownerClass);
		
		Type srcType = ass.getMemberEnd().get(0).getType();
		
		Property mEnd;
		if(srcType.equals(datatype)){
			mEnd = ass.getMemberEnd().get(0);
		}else{
			mEnd = ass.getMemberEnd().get(1);
		}
		OWLDatatype tipoAtributo = getDataTypeRange(datatype, mEnd);
		if(owlAxioms.getValue(OWL2Axiom.RANGE)){
			//Set the Range of the DataProperty
			createDataPropertyRange(dataProperty, tipoAtributo);			
		}
		
		//Processing cardinality to the destiny
		int upperCard = ass.getMemberEnd().get(1).getUpper();
		int lowerCard = ass.getMemberEnd().get(1).getLower();
		
		createCardinality(dataProperty, tipoAtributo, srcType, lowerCard, upperCard);
	}
	
	/**
	 * Create a SWRL for an Relator that have a material association between two of his mediations. 
	 * @param 
	 */
	public void createSWRLforRelator(Mediation mediation0, Mediation mediation1, MaterialAssociation material, Relator relator) {
		OWLObjectProperty propMediation0 = getObjectProperty(mediation0);
		OWLObjectProperty propMediation1 = getObjectProperty(mediation1);
		OWLObjectProperty propMaterial = getObjectProperty(material);

		OWLClass materialSource = getOwlClass(material.getMemberEnd().get(0).getType());
		OWLClass materialDestiny = getOwlClass(material.getMemberEnd().get(1).getType());
		OWLClass relatorClass = getOwlClass(relator);

		//SWRL

		//variables
		SWRLVariable varMaterialSource = factory.getSWRLVariable(IRI.create(owlNameSpace+"x"));
		SWRLVariable varMaterialDestiny = factory.getSWRLVariable(IRI.create(owlNameSpace+"y"));
		SWRLVariable varRelator = factory.getSWRLVariable(IRI.create(owlNameSpace+"z"));

		//Set the type of the variables
		SWRLAtom typeOfMaterialSource = factory.getSWRLClassAtom(materialSource, varMaterialSource); //A(?x)
		SWRLAtom typeOfMaterialDestiny = factory.getSWRLClassAtom(materialDestiny, varMaterialDestiny); //B(?y)
		SWRLAtom typeOfRelator = factory.getSWRLClassAtom(relatorClass, varRelator); //relator(?z)

		//Set all variables different between they
		SWRLAtom diffMatSrcMatDst = factory.getSWRLDifferentIndividualsAtom(varMaterialSource, varMaterialDestiny);
		SWRLAtom diffMatSrcRel = factory.getSWRLDifferentIndividualsAtom(varMaterialSource, varRelator);
		SWRLAtom diffMatDstRel = factory.getSWRLDifferentIndividualsAtom(varMaterialDestiny, varRelator);

		//Create the contraints
		Set<SWRLAtom> antecedent = new HashSet<SWRLAtom>();
		antecedent.add(diffMatSrcRel); //DifferentFrom(?x,?z)
		antecedent.add(diffMatDstRel); //DifferentFrom(?y,?z)
		antecedent.add(diffMatSrcMatDst); //DifferentFrom(?x,?x)
		antecedent.add(typeOfMaterialSource); //A(?x)
		antecedent.add(typeOfMaterialDestiny); //B(?y)
		antecedent.add(typeOfRelator); //relator(?z)
		SWRLObjectPropertyAtom sopa = factory.getSWRLObjectPropertyAtom(propMediation0, varRelator, varMaterialSource); 
		antecedent.add(sopa); //propMediation0(?x,?z)
		sopa = factory.getSWRLObjectPropertyAtom(propMediation1, varRelator, varMaterialDestiny);
		antecedent.add(sopa); //propMediation1(?z,?y)

		Set<SWRLAtom> consequent = new HashSet<SWRLAtom>();
		consequent.add(factory.getSWRLObjectPropertyAtom(propMaterial, varMaterialSource, varMaterialDestiny)); //propMaterial(?x,?y)

		SWRLRule rule = factory.getSWRLRule(antecedent,consequent);		

		manager.applyChange(new AddAxiom(ontology, rule));
	}
	
	boolean isMappedAsOwlClass(RefOntoUML.Classifier cls){
		Object qualityMappingType = lstQualityMappings.get(cls);
		if(		lstNominalQualities.contains(cls) || 
				lstMappedQualities.contains(cls) && qualityMappingType != null && qualityMappingType.equals(OWL2Quality.HIDE_QUALITY)||
				cls instanceof DataType){
			return false;
		}
		return true;
	}
}
