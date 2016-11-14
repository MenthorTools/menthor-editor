package net.menthor.ontouml2simpleowl.transform;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLAxiomChange;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLProperty;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;

import RefOntoUML.Association;
import RefOntoUML.Class;
import RefOntoUML.Classifier;
import RefOntoUML.Comment;
import RefOntoUML.DataType;
import RefOntoUML.Derivation;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.MomentClass;
import RefOntoUML.NamedElement;
import RefOntoUML.Package;
import RefOntoUML.PackageableElement;
import RefOntoUML.Property;
import RefOntoUML.SubstanceSortal;
import RefOntoUML.parser.OntoUMLParser;

/**
 * Provides transformation of RefOntoUML models into OWL2DL ontologies using the OWLAPI.
 * @author Antognoni Albuquerque
 * @version 0.1
 */
public class Transformer {
	
	private IRI ontologyIRI;
	private OWLOntology ontology;
	private Package model;
	private OWLOntologyManager manager; 
	private Map<Element, Object> owlMappings; 	//Keep track of the mapped items
	private Map<Element, Set<String>> owlAnnotations; 	//Keep track of the elements' annotations 
	private OntoUMLParser ontoParser;
	
	/**
	 * Constructor for the transformer.
	 * @param ontologyIRI - the IRI used to identify uniquely he ontology
	 * @param model - the model to be transformed
	 * @throws OWLOntologyCreationException
	 */
 	public Transformer(String ontologyIRI, Package model) throws OWLOntologyCreationException {
 		
		this.model = model;
		ontoParser = new OntoUMLParser(model);
		owlMappings = new HashMap<Element, Object>();
		owlAnnotations = new HashMap<Element, Set<String>>();
		
		if(ontologyIRI.endsWith("#")){
			ontologyIRI = ontologyIRI.substring(0, ontologyIRI.length()-1);
		}
		//Simple validate the informed IRI. If it isn't good, we get a new one.
//		if(ontologyIRI.toLowerCase().startsWith("http://") && ontologyIRI.toLowerCase().endsWith(".owl"))
			this.ontologyIRI = IRI.create(ontologyIRI.replace(" ", ""));
//		else
//			this.ontologyIRI = IRI.create(getDefaultIRI("ontology"));
		
		//This manager is needed in order to work with OWLAPI
		manager = OWLManager.createOWLOntologyManager();
		ontology = manager.createOntology(this.ontologyIRI);
	}
	
 	/**
 	 * Transforms the informed model into an OWLOntology
 	 * @return the ontology
 	 */
	public OWLOntology transform()
	{
		if(model != null && model.getPackagedElement().size() > 0)
		{
			process(model);
			
			Set<OWLClassExpression> owlIdPcs = new HashSet<OWLClassExpression>();
			
			for (Element key : owlMappings.keySet()) {
				
				//If it's an Identity Provider Class (IDPC) we need to make it disjoint with the other IDPCs  
				if(key instanceof SubstanceSortal || key instanceof MomentClass)
					owlIdPcs.add((OWLClassExpression)owlMappings.get(key));
				
				if(isClosed(key))
					addClosureAxiom((OWLClass) owlMappings.get(key));
				
				if(isDefined(key))
					convertToDefined((OWLClass) owlMappings.get(key));
			}
			
			//Make the identity provider classes disjoint
			if(owlIdPcs.size() > 1)
			{
				OWLAxiom disjAxm = f().getOWLDisjointClassesAxiom(owlIdPcs);
				addAxiomToOntology(disjAxm);
			}
		
			return ontology;
		}
		
		return null;
	}
	
	/**
	 * Transforms the informed model into an OWLOntology
	 * @param format - the format used to encode the ontology
	 * @param out - the output stream to serialize the ontology
	 */
	public void transform(OWLOntologyFormat format, OutputStream out)
	{
		try {
			
			OWLOntology ont = transform();
			if(ont != null)
				manager.saveOntology(ont, format, out);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Adds an OWLEntity to the ontology.
	 * @param obj - the object to be added
	 */
	private void addEntityToOntology(OWLEntity obj, final String label)
	{
		final List<OWLAxiom> axioms = new ArrayList<>();
			
			final OWLEntity eObj = (OWLEntity) obj;
			final OWLDataFactory f = f();
			
			axioms.add( f.getOWLDeclarationAxiom(eObj) );
			axioms.add( f.getOWLAnnotationAssertionAxiom(
					f.getOWLAnnotationProperty(OWLRDFVocabulary.RDFS_LABEL.getIRI()), 
					eObj.getIRI(), 
					f.getOWLLiteral(label)) );
	
		manager.applyChanges(axioms.stream().map( new Function<OWLAxiom, OWLAxiomChange>() {
			@Override
			public OWLAxiomChange apply(OWLAxiom axm) {
				return new AddAxiom(ontology,axm);
			}
		} ).collect(Collectors.<OWLAxiomChange>toList()));
	}

	/**
	 * Adds an OWLAxiom to the ontology.
	 * @param axm - the object to be added
	 */
	private void addAxiomToOntology(OWLAxiom axm)
	{
		manager.applyChange(new AddAxiom(ontology, axm));
	}

	private OWLDataFactory f() {
		return OWLManager.getOWLDataFactory();
	}
	
	/**
	 * Converts the informed class to a defined class by adding an OWLEquivalenClassesAxiom to the ontology
	 * and removing the class super classes
	 * @param cls - the class to be converted
	 */
	private void convertToDefined(OWLClass cls)
	{		
		/* Get the class axioms */
        Set<OWLSubClassOfAxiom> axioms = ontology.getAxioms(AxiomType.SUBCLASS_OF);

        /* Collect those that assert superclasses of the class */
        SubClassCollector collector = new SubClassCollector(cls);

        //Percorre todas as suclasses da ontologia identificando as subclasses da classe informada
        for (OWLClassAxiom axiom : axioms) {
            axiom.accept(collector);
        }
        
        Set<OWLClassExpression> superClasses = new HashSet<OWLClassExpression>();
        
        /* For each axiom.... */
        for (OWLSubClassOfAxiom axiom : collector.getAxioms()) {
            /* Get the superclass */
            OWLClassExpression sup = axiom.getSuperClass();
            superClasses.add(sup);
            
            RemoveAxiom remAxiom = new RemoveAxiom(ontology, axiom);
            manager.applyChange(remAxiom);
        }

        OWLClassExpression intr = f().getOWLObjectIntersectionOf(superClasses);
    	OWLAxiom equiAxm = f().getOWLEquivalentClassesAxiom(cls, intr);
    	AddAxiom addAxiom = new AddAxiom(ontology, equiAxm);	
    	manager.applyChange(addAxiom);
  
	}
	
	/**
	 * Adds a closure axiom for the informed class, allowing dynamic classification.  
	 * @param cls - the class to be closed
	 */
	private void addClosureAxiom(OWLClass cls)
	{
		/* Get the class axioms */
        Set<OWLSubClassOfAxiom> axioms = ontology.getAxioms(AxiomType.SUBCLASS_OF);

        /* Collect those that assert superclasses of the class */
        SubClassCollector collector = new SubClassCollector(cls);

        for (OWLClassAxiom axiom : axioms) {
            axiom.accept(collector);
        }
        
        Map<OWLObjectPropertyExpression, Set<OWLClassExpression>> restrictions = new HashMap<OWLObjectPropertyExpression, Set<OWLClassExpression>>();

        /* For each axiom.... */
        for (OWLSubClassOfAxiom axiom : collector.getAxioms()) {
            /* Get the superclass */
            OWLClassExpression superClass = axiom.getSuperClass();

            /* Collect any existentials */
            ExistentialCollector ec = new ExistentialCollector(restrictions);
            superClass.accept(ec);
        }

        /* For any existentials.... */
        for (OWLObjectPropertyExpression prop : restrictions.keySet()) {
        	
            Set<OWLClassExpression> fillers = restrictions.get(prop);
            
            /* Create a union of the fillers */
            OWLClassExpression union = f().getOWLObjectUnionOf(fillers);

            /* Create a universal restriction */
            OWLClassExpression universal = f().getOWLObjectAllValuesFrom(prop, union);

            /* Create a new axiom */
            OWLAxiom newAxiom = f().getOWLSubClassOfAxiom(cls, universal);

            /* Now add the axiom to the ontology */
            AddAxiom addAxiom = new AddAxiom(ontology, newAxiom);
            /* Use the manager to apply the change */
            manager.applyChange(addAxiom);

        }
	}
		
	/**
	 * Coordinates the transformation of the model elements. This method should be called upon
	 * every element to be transformed.
	 * @param src - The model element to be transformed
	 * @return the result of the transformation
	 */
	private Object process(EObject src)
	{			
		Object trg = owlMappings.get(src);
		
		if(trg == null)
		{
			if(src instanceof Class)
				trg = processClass((Class) src);
			else if(src instanceof Association && !(src instanceof Derivation))
				trg = processAssociation((Association) src);
			else if(src instanceof Generalization)
				trg = processGeneralization((Generalization) src);
			else if(src instanceof GeneralizationSet)
				trg = processGeneralizationSet((GeneralizationSet) src);
			else if(src instanceof DataType)
				trg = processDatatype((DataType) src);
			else if(src instanceof Property)
				trg = processProperty((Property) src);
			else if(src instanceof Package)
				trg = processPackage((RefOntoUML.Package) src);
		}
		
		return trg;
	}
	
	private Set<Object> processPackage(RefOntoUML.Package pkg)
	{
		Set<Object> ret = new HashSet<Object>();
		
		for (PackageableElement elm : pkg.getPackagedElement()) {
			ret.add(process(elm));
		}
		
		owlMappings.put(pkg, ret);
		
		return ret;
	}
	
	private OWLClass processClass(RefOntoUML.Class cls)
	{
		OWLClass ocls = f().getOWLClass(createIRIForEntityName(cls.getName()));
		
		owlMappings.put(cls, ocls);
		addEntityToOntology(ocls, cls.getName());
				
		if(cls.getGeneralization().size() > 0)
		{
			for (Generalization gen : cls.getGeneralization()) {				
				process(gen);
			}
		}
		//If the class doesn't have any supertypes, we assume that its super type is OWL Thing
		else
		{
			OWLSubClassOfAxiom subAxm = f().getOWLSubClassOfAxiom(ocls, f().getOWLThing());
			addAxiomToOntology(subAxm);
		}
					
		for (Property prp : cls.getOwnedAttribute()) {				
			process(prp);
		}
				
		return ocls;
	}
	
 	private OWLEntity processDatatype(DataType dty)
	{
 		//If the DataType has the same name as a a built-in DataType, such as string or int we assume it is a built-in DataType
 		//Otherwise, we treat it as a regular class or a multi-dimensional DataType
 		String dtyName = dty.getName();
 		if(dtyName != null){
 			dtyName = dtyName.replace(" ", "");
 		}
 		OWLDatatype odty = DatatypeMap.getBuiltinType(dtyName);
 		if(odty != null) {
 			return odty;
 		} else {
			IRI dtyIRI = createIRIForEntityName(dtyName);
			OWLClass ocls = f().getOWLClass(dtyIRI);
			
			owlMappings.put(dty, ocls);
			addEntityToOntology(ocls,dty.getName());
			
			if(dty.getGeneralization().size() > 0)
			{
				for (Generalization gen : dty.getGeneralization()) {				
					process(gen);
				}
			}
			//If the datatype doesn't have any supertypes, we assume that its super type is OWL Thing
			else
			{
				OWLSubClassOfAxiom subAxm = f().getOWLSubClassOfAxiom(ocls, f().getOWLThing());
				addAxiomToOntology(subAxm);
			}
			
			for (Property prp : dty.getOwnedAttribute()) {				
				process(prp);
			}
			
			return ocls;
 		}
	}
 		
	private OWLAxiom processGeneralization(Generalization gen)
	{	
		OWLObject sub = (OWLObject) process(gen.getSpecific());
		OWLObject sup = (OWLObject) process(gen.getGeneral());
		
		OWLAxiom ogen = null;
		
		if(sub instanceof OWLClass && sup instanceof OWLClass)
			ogen = f().getOWLSubClassOfAxiom((OWLClass)sub, (OWLClass)sup);
		
		else if(sub instanceof OWLObjectProperty && sup instanceof OWLObjectProperty)
			ogen = f().getOWLSubObjectPropertyOfAxiom((OWLObjectProperty)sub, (OWLObjectProperty)sup);
			
		else if(sub instanceof OWLDataProperty && sup instanceof OWLDataProperty)
			ogen = f().getOWLSubDataPropertyOfAxiom((OWLDataProperty)sub, (OWLDataProperty)sup);
				
		owlMappings.put(gen, ogen);
		addAxiomToOntology(ogen);
		
		return ogen;
	}
			
	private Set<OWLAxiom> processGeneralizationSet(GeneralizationSet genSet)
	{	
		Set<OWLAxiom> ret = new HashSet<OWLAxiom>();
		Classifier general = null;
		OWLClass superType = null;
		Set<OWLClass> subTypes = new HashSet<OWLClass>();
		
		for (Generalization gen : genSet.getGeneralization()) {
			
			//This is not needed, but it is always good to ensure that all the generalizations
			//in a generalization set have the same general type
			
			if(general == null)
				general = gen.getGeneral();
			else
				assert(general == gen.getGeneral());
			
			OWLClass subType = (OWLClass) process(gen.getSpecific());
			subTypes.add(subType);
		}
		
		superType = (OWLClass) process(general);
		
		//If the generalization set is disjoint, we create a disjoint axiom for the ontology
		if(genSet.isIsDisjoint())
		{
			OWLAxiom disjAxm = f().getOWLDisjointClassesAxiom(subTypes);
			addAxiomToOntology(disjAxm);
			ret.add(disjAxm);
		}
		
		//if the generalization set is covering, we add an axiom stating that
		//the general type is equivalent to an union of the specific type
		if(genSet.isIsCovering())
		{
			OWLClassExpression unionOf = f().getOWLObjectUnionOf(subTypes);
			OWLAxiom equiAxm = f().getOWLEquivalentClassesAxiom(superType, unionOf);
			//axms.add(equiAxm);
			//addEquivalentClassAxiom(superType, unionOf);
			
			addAxiomToOntology(equiAxm);
			ret.add(equiAxm);
		}
		
		owlMappings.put(genSet, ret);
		
		return ret;
	}
	 	
	private IRI createIRIForEntityName(String name) {
//		return IRI.create(ontologyIRI + "#" + (name == null ? null:name.replace(" ", "")));
		return IRI.create(ontologyIRI + "/" + (name == null ? null:name.replace(" ", "-").toLowerCase()));
	}
	
	private OWLProperty<?,?> processProperty(final Property prp)
	{
		IRI propIRI = null;
		OWLClass dcls = null;
		OWLClass rcls = null;
		OWLDatatype rdty = null;
		
		Classifier clf = (Classifier) prp.eContainer();
		
		//If it has supertypes defined in annotations
		Set<Element> supElm = getSuperFromAnnotation(prp);
		
		String propName = prp.getName();

		//If the property is contained in a class, then it is a class attribute
		if(clf instanceof Class)
		{
			propIRI = createIRIForEntityName(propName);
			
			//The domain class is the class containing the property
			dcls = (OWLClass) process(clf);
			
			//Check if the range is a DataType
			rdty = DatatypeMap.getBuiltinType(prp.getType().getName());		
		}
		
		//If the property is contained in an Association its an endpoint of the association
		else if(clf instanceof Association)
		{
//			if(propName == null)
//			{
				String clfName = clf.getName();
				if(clfName == null || clfName.trim().isEmpty()){
					clfName = this.ontoParser.getAlias(clf);
				}
				//Check if it is a source or target inverse prop, naming accordingly
				if(prp == ((Association) clf).getMemberEnd().get(0))
					propName = clfName;
				else
					propName = "INV." + clfName;//capitalize(clfName);
//			}
			propIRI = createIRIForEntityName(propName);
			
			final Property oprp = prp;//.getOpposite();
			
			Object dclsObj = process(oprp.getType());
			if(dclsObj instanceof OWLClass){
				//Find the domain and range OWLClasses
				dcls = (OWLClass) dclsObj;
			}else if(dclsObj instanceof HashSet){
				process(oprp.getType());
				Object[] memberEnds = ((HashSet<OWLProperty>) dclsObj).toArray();
				OWLProperty owlProp = (OWLProperty) memberEnds[0];
				dcls = f().getOWLClass(owlProp.getIRI());
			}			
			
			//Check if the range is a DataType
			rdty = DatatypeMap.getBuiltinType(oprp.getType().getName());				
		}
		
		//Check if the range is a built in DataType we add a OWLDataProperty.
		//Otherwise, we add an OWLObjectProperty
		if(rdty != null)
		{
			OWLDataProperty oprp  = f().getOWLDataProperty(propIRI);
			addEntityToOntology(oprp,propName);
			
			OWLDataPropertyDomainAxiom daxPrp = f().getOWLDataPropertyDomainAxiom(oprp, dcls);
			addAxiomToOntology(daxPrp);
			
			OWLDataPropertyRangeAxiom raxPrp = f().getOWLDataPropertyRangeAxiom(oprp, rdty);
			addAxiomToOntology(raxPrp);
					
			owlMappings.put(prp, oprp);
	
			//If the property is annotated with supertype annotations, we include subproperty axioms			
			for (Element elm : supElm) {
				Object supObj = process(elm);
				if(supObj instanceof OWLDataProperty)
				{
					OWLAxiom subPrpAxm = f().getOWLSubDataPropertyOfAxiom(oprp, (OWLDataPropertyExpression) supObj);
					addAxiomToOntology(subPrpAxm);
				}
			}
						
			//We don't create subclass axioms (representing anonymous superclasses) or cardinality constraints for these kind 
			//of attributes as it is done with properties of associations.
			
			return oprp;
		}
		else
		{
			OWLObjectProperty oprp = f().getOWLObjectProperty(propIRI);
			addEntityToOntology(oprp,propName);
			
			OWLObjectPropertyDomainAxiom daxPrp = f().getOWLObjectPropertyDomainAxiom(oprp, dcls);
			addAxiomToOntology(daxPrp);
			
			if(prp.getOpposite() != null){
				final Property opositePRP = prp.getOpposite();
				
				Object rclsObj = process(opositePRP.getType());
				if(rclsObj instanceof OWLClass){
					rcls = (OWLClass) rclsObj;
				}else if(rclsObj instanceof HashSet){
					Object[] memberEnds = ((HashSet<OWLProperty>) rclsObj).toArray();
					OWLProperty owlProp = (OWLProperty) memberEnds[memberEnds.length-1];
					IRI dclsIri = owlProp.getIRI();
					rcls = f().getOWLClass(dclsIri);
				}	
				
				OWLObjectPropertyRangeAxiom raxPrp = f().getOWLObjectPropertyRangeAxiom(oprp, rcls);
				addAxiomToOntology(raxPrp);
						
				//Deal with cardinality
				OWLClassExpression expr = OWLAPIHelper.getCardinalityRestriction(opositePRP.getLower(), opositePRP.getUpper(), oprp, dcls, rcls);
				//Create an anonymous superclass for the Object Property
				OWLAxiom subAxm = f().getOWLSubClassOfAxiom(dcls, expr); 			
				addAxiomToOntology(subAxm);
			}
			
			owlMappings.put(prp, oprp);
			
			//If the property is annotated with supertype annotations, we include subproperty axioms			
			for (Element elm : supElm) {
				Object supObj = process(elm);
				if(supObj instanceof OWLObjectProperty)
				{
					OWLAxiom subPrpAxm = f().getOWLSubObjectPropertyOfAxiom(oprp, (OWLObjectPropertyExpression) supObj);
					addAxiomToOntology(subPrpAxm);
				}
			}
			
			//Deal with object Property characteristics from annotations
			
			addPropertyCharacteristics(prp,oprp);
			
			return oprp;
		}
	}
	
	private void addPropertyCharacteristics(final Property prp,final OWLObjectProperty oprp) {
		//Funcional
		if(getOWLAnnotations(prp).contains("functional"))
		{
			addAxiomToOntology(f().getOWLFunctionalObjectPropertyAxiom(oprp));
		}
		
		if(getOWLAnnotations(prp).contains("inversefunctional"))
		{
			addAxiomToOntology(f().getOWLInverseFunctionalObjectPropertyAxiom(oprp));
		}
		
		if(getOWLAnnotations(prp).contains("transitive"))
		{
			addAxiomToOntology(f().getOWLTransitiveObjectPropertyAxiom(oprp));
		}
		
		//Symmetric
		if(getOWLAnnotations(prp).contains("symmetric"))
		{
			addAxiomToOntology(f().getOWLSymmetricObjectPropertyAxiom(oprp));
		}
			
		//AntiSymmetric
		if(getOWLAnnotations(prp).contains("antisymmetric"))
		{
			addAxiomToOntology(f().getOWLAsymmetricObjectPropertyAxiom(oprp));
		}
		
		//Reflexive
		if(getOWLAnnotations(prp).contains("reflexive"))
		{
			addAxiomToOntology(f().getOWLReflexiveObjectPropertyAxiom(oprp));
		}
		
		//Irreflexive
		if(getOWLAnnotations(prp).contains("irreflexive"))
		{
			addAxiomToOntology(f().getOWLIrreflexiveObjectPropertyAxiom(oprp));
		}
	}
	
	@SuppressWarnings("rawtypes")
	private Set<OWLObject> processAssociation(Association asc)
	{
		Set<OWLObject> ret = new HashSet<OWLObject>();
		
		Property src = asc.getMemberEnd().get(0);
		Property trg = asc.getMemberEnd().get(1);
		
		OWLProperty srcOP = null;
		OWLProperty trgOP = null;
		
		//Target navigable 
//		if(asc.getNavigableOwnedEnd().contains(trg))
//		{
			srcOP = (OWLProperty) process(src); 
			ret.add(srcOP);
//		}
		
		//Source navigable
//		if(asc.getNavigableOwnedEnd().contains(src))
//		{
			trgOP = (OWLProperty) process(trg); 
			ret.add(trgOP);
//		}
		
		//Inverse axiom: no need for inverse axiom in DataType relations
		if((srcOP != null && trgOP != null) 
				&&  (src.getType() instanceof DataType == false 
				&& trg.getType() instanceof DataType == false ))
		{
			OWLInverseObjectPropertiesAxiom invAxm = f().getOWLInverseObjectPropertiesAxiom((OWLObjectProperty) srcOP, (OWLObjectProperty) trgOP);
			addAxiomToOntology(invAxm);
		}
			
		return ret;
	}
	
	private Set<String> getOWLAnnotations(Element elm)
	{
		if(!owlAnnotations.containsKey(elm))
		{
			Set<String> ret = new HashSet<String>();
			
			for (Comment ant : elm.getOwnedComment()) {
				String body = ant.getBody().toLowerCase();
				if(body.startsWith("owl:"))
				{
					body = body.substring(4);
					if(body.contains(","))
					{
						String[] args = body.split(",");
						for (String arg : args) {
							ret.add(arg.trim());
						}
					}
					
					ret.add(body.trim());
				}
			}
			
			
			owlAnnotations.put(elm, ret);
		}
		
		return owlAnnotations.get(elm);
	}
	
	private boolean isDefined(Element elm)
	{
		if(elm instanceof Class)
			return getOWLAnnotations(elm).contains("defined");
		return false;
	}
		
	private boolean isClosed(Element elm)
	{
		if(elm instanceof Class)
			return getOWLAnnotations(elm).contains("closed");
		return false;
	}
		
	/**
	 * Gets the set containing all the super classifiers for the informed element described by the super annotations. 
	 * @param elm - the annotated element
	 * @return the set containing all the super classifiers
	 */
	private Set<Element> getSuperFromAnnotation(Element elm)
	{
		Set<Element> ret = new HashSet<Element>();
		
		for(String ant : getOWLAnnotations(elm))
		{
			if(ant.startsWith("super="))
			{
				Element supElm = getElementByName(model.getPackagedElement(), ant.substring(ant.indexOf("=") + 1));
				ret.add((Element) supElm);
			}
		}
		
		return ret;
	}
			
	private Element getElementByName(EList<? extends EObject> list, String name) {
		
		if(name == null || name.equals(""))
			return null;
		
		Element ret = null;
		
		for (EObject elm : list) {
			if(elm instanceof NamedElement)
			{
				String elmName = ((NamedElement) elm).getName();
				if(elmName.toLowerCase().equals(name.toLowerCase()))
				{
					ret = (Element) elm;
					break;
				}
			}
			
			//If we didn't find the element we are looking for, keep trying:
			if(ret == null)
			{
				if(elm instanceof Class)
					ret = getElementByName(((Class) elm).getOwnedAttribute(), name);
				if(elm instanceof Association)
					ret = getElementByName(((Association) elm).getMemberEnd(), name);
				else if(elm instanceof Package)
					ret = getElementByName(((Package) elm).getPackagedElement(), name);
			}		
		}
		
		return ret;
	}
}
