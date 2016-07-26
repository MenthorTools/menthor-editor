package net.menthor.ootos.ontouml2owl_swrl;


import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import RefOntoUML.Association;
import RefOntoUML.Class;
import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.Derivation;
import RefOntoUML.Enumeration;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.Mediation;
import RefOntoUML.NominalQuality;
import RefOntoUML.PackageableElement;
import RefOntoUML.PrimitiveType;
import RefOntoUML.Property;
import RefOntoUML.Relator;
import RefOntoUML.Structuration;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.common.settings.owl.OWL2Axiom;
import net.menthor.common.settings.owl.OWL2GeneralizationSet;
import net.menthor.common.settings.owl.OWL2Quality;
import net.menthor.common.settings.owl.OwlAxioms;
import net.menthor.common.settings.owl.OwlMappings;
import net.menthor.common.settings.owl.OwlOptions;
import net.menthor.ootos.ocl2owl_swrl.OCL2OWL_SWRL;
import net.menthor.ootos.util.MappingElements;

public class Transformer {
	/**
	 * Considerations:
	 * - Chain of DataTypes can be infinity if a datatype x has a datatype y and y has a datatype x
	 * - Multiply the bounds of the associations in chain of datatypes
	 * */
	//Global Variables
	private OntoUMLParser ontoParser;

	private Set<Class> lstOntClass;
	private Set<GeneralizationSet> lstGenSets;
	private Set<Generalization> lstGen;
	private Set<Relator> lstRelator;
	private Set<DataType> lstDataType;
	private Set<Enumeration> lstEnumerations;
	private Set<Association> lstAssociation;
	private Set<NominalQuality> lstNominalQualities;
	private ArrayList<Property> dataTypesProcesseds = new ArrayList<Property>();
	private Set<Classifier> lstGsSetMapChildren = new HashSet<Classifier>();
	private ArrayList<RefOntoUML.Classifier> lstDataTypeAndNominalQualities = new ArrayList<RefOntoUML.Classifier>();
	private Map<RefOntoUML.Element, OWL2Quality> lstQualityMappings;
	private Set<RefOntoUML.Element> lstMappedQualities;
	
	private String owlNameSpace;

	private OwlFactoryUtil owlFactoryUtil;
	//ocl 2 swrl
	String oclRules;
	
	//
	MappingElements mappingElements;
	
	//Editor Application
	private String errors = "\n";

	private OwlAxioms owlAxioms;
	private OwlMappings owlMappings;
	private OwlOptions owlOptions;

	

	public String getErrors(){
		errors = mappingElements.getOutputMessages() + errors;
		return errors;
	}

	/**
	 * Initialize the Transformer
	 * @throws OWLOntologyCreationException 
	 * */
	public Transformer(OntoUMLParser model, String _oclRules, OwlOptions owlOptions) throws OWLOntologyCreationException {
		ontoParser = model;
		
		this.owlNameSpace = ((OwlAxioms) owlOptions.getOwlAxioms()).getIRI()+"#";
		
		this.owlOptions = owlOptions;
		this.owlAxioms = (OwlAxioms) owlOptions.getOwlAxioms();
		this.owlMappings = (OwlMappings) owlOptions.getOwlMappings();
		
		this.mappingElements = new MappingElements(ontoParser, owlOptions);
		this.mappingElements.generateAllElementNames();
		this.lstQualityMappings = owlOptions.getOwlMappings().getQualities();
		this.lstMappedQualities = lstQualityMappings.keySet();
		this.lstNominalQualities = ontoParser.getAllInstances(RefOntoUML.NominalQuality.class);
		
		this.owlFactoryUtil = new OwlFactoryUtil(ontoParser, mappingElements, owlOptions, lstMappedQualities, lstNominalQualities, lstQualityMappings);
		
		this.lstOntClass = ontoParser.getAllInstances(RefOntoUML.Class.class);
		this.lstOntClass.removeAll(lstNominalQualities);
		
		
		this.lstOntClass.removeAll(lstMappedQualities);
		
		this.lstGenSets = ontoParser.getAllInstances(GeneralizationSet.class);
		this.lstGen = ontoParser.getAllInstances(Generalization.class);
		
		createGsSetMappingStructure();
				
		this.lstRelator = ontoParser.getAllInstances(Relator.class);
		this.lstDataType = ontoParser.getAllInstances(RefOntoUML.DataType.class);
		Set<PrimitiveType> lstPrimitiveTypes = ontoParser.getAllInstances(RefOntoUML.PrimitiveType.class);
		this.lstDataType.removeAll(lstPrimitiveTypes);
		
		this.lstEnumerations = ontoParser.getAllInstances(RefOntoUML.Enumeration.class); 
		lstDataType.removeAll(this.lstEnumerations);
		
		this.lstDataTypeAndNominalQualities.addAll(lstDataType);
		this.lstDataTypeAndNominalQualities.addAll(lstNominalQualities);
		
		this.lstAssociation = ontoParser.getAllInstances(RefOntoUML.Association.class);
		
		this.oclRules = _oclRules;		
	}

	/**
	 * Transform a RefOntoUML.Model to OWL
	 * 
	 * @param ecoreModel
	 * @return a String with the OWL code
	 * @throws Exception 
	 */
	public String transform(String tempDir) throws Exception {
		if(owlAxioms.getValue(OWL2Axiom.UFO_STRUCTURE)) createBasicStructure();
		
		processClass();

		processClassAttributes();
		processDataTypes();
		processEnumerations();
		
		processSuppressedQualitiesAsAttributes();
		
		processGeneralizations();

		processAssociation();
		processRelator();
		
		processDisjointAssociation();

		processAnnotation();

		processAxiom();

		processGenSetsMappings();

		this.errors += owlFactoryUtil.getLogMessage();
		
		if(oclRules != null && !oclRules.trim().isEmpty() && owlAxioms.getValue(OWL2Axiom.SWRL_RULES)){
			OCL2OWL_SWRL ocl2owl_swrl = new OCL2OWL_SWRL(this.mappingElements, owlOptions, oclRules, ontoParser, owlFactoryUtil.getManager(), owlNameSpace);
			ocl2owl_swrl.Transformation(tempDir);
			this.errors += "\n" + ocl2owl_swrl.errors;
		}
		
		removeUndesiredAxioms();
		
		String owl = owlFactoryUtil.saveOntology();
		
		return owl;
	}

	/**
	 * @author Freddy Brasileiro
	 *
	 */
	private void removeUndesiredAxioms() {
		owlFactoryUtil.removeUndesiredAxioms();		
	}

	//generalization sets are mapped to enumerations
	private void createGsSetMappingStructure() {
		Object[][] genSetEnumMappings = this.owlMappings.getGeneralizationSets();
		if(genSetEnumMappings == null) return;
		for(int i = 0; i < genSetEnumMappings.length; i++){
			Boolean hide = (Boolean) genSetEnumMappings[i][2];
			if(hide){
				GeneralizationSet gsElem = (GeneralizationSet)genSetEnumMappings[i][0];				
				OWL2GeneralizationSet mappingType = (OWL2GeneralizationSet) genSetEnumMappings[i][1];
				if(mappingType.equals(OWL2GeneralizationSet.ALLCLASSES)){
					lstGsSetMapChildren = ontoParser.getAllChildren(gsElem);					
				}else if(mappingType.equals(OWL2GeneralizationSet._1STCLASSES)){
					lstGsSetMapChildren = ontoParser.getChildren(gsElem);
				}else{
					lstGsSetMapChildren = ontoParser.getLeafChildren(gsElem);
				}
				
				lstOntClass.removeAll(lstGsSetMapChildren);
				
				lstGenSets.remove(gsElem);
				
				for (Generalization generalization : gsElem.getGeneralization()) {
					lstGen.remove(generalization);
				}
			}
		}
	}

	private void processGenSetsMappings() {
		Object[][] genSetEnumMappings = owlMappings.getGeneralizationSets();
		if(genSetEnumMappings == null) return;
		for(int i = 0; i < genSetEnumMappings.length; i++){
			GeneralizationSet gs = (GeneralizationSet) genSetEnumMappings[i][0];
			OWL2GeneralizationSet mappingType = (OWL2GeneralizationSet) genSetEnumMappings[i][1];
			owlFactoryUtil.createGenSetAsEnum(gs, mappingType);
		}
	}
	
	private void createBasicStructure() throws OWLOntologyCreationException {
		owlFactoryUtil.createBasicStructure();		
	}
	
	/**
	 * Set all stereotype of association disjoint between they
	 * */
	private void processDisjointAssociation() {
		owlFactoryUtil.createDisjointObjectProperties();		
	}

	/**
	 * Create the SWRL between Relator.Source and Relator.Destiny by its Material associations
	 * */
	private void processRelator() {
		Set<MaterialAssociation> materials = null;
		ArrayList<Mediation> mediations = null;

		Mediation mediation0 = null;
		Mediation mediation1 = null;

		for (Relator relator : lstRelator) {
			try{
				materials = getRelatorMaterials(relator);
				mediations = ontoParser.getMediations(relator);

				//Get the triple <Mediation,Material,Mediation>
				for (MaterialAssociation material : materials) {
					//Clean up the variables
					mediation0 = null;
					mediation1 = null;
					for (Mediation mediation : mediations) {
						//Verify source of the material
						if(material.getMemberEnd().get(0).getType().equals(mediation.getMemberEnd().get(0).getType()) 
								|| material.getMemberEnd().get(0).getType().equals(mediation.getMemberEnd().get(1).getType())){
							mediation0 = mediation;
						}

						//Verify target of the material
						if(material.getMemberEnd().get(1).getType().equals(mediation.getMemberEnd().get(0).getType()) 
								|| material.getMemberEnd().get(1).getType().equals(mediation.getMemberEnd().get(1).getType())){
							mediation1 = mediation;
						}
						if(mediation0 != null && mediation1 != null && owlAxioms.getValue(OWL2Axiom.SWRL_RULES)){
							//Now we have the Material and Mediations of the member-ends of the Material
							owlFactoryUtil.createSWRLforRelator(mediation0, mediation1, material, relator);
							break;
						}
					}
				}
			}catch(Exception e){
				errors += "The Relator does not exist;\n";
			}
		}
	}
	
	/**
	 * Return the Mediations and Material Relation from a specific Relator 'r'
	 * 
	 * @param relator
	 * @return A list with the all MaterialAssociation from the Relator
	 */
	private Set<MaterialAssociation> getRelatorMaterials(Relator r){
		Set<MaterialAssociation> lst = new HashSet<MaterialAssociation>();
		MaterialAssociation material;

		Set<Derivation> lstDerivation = ontoParser.getAllInstances(RefOntoUML.Derivation.class);
		for(Derivation derivation:lstDerivation){
			//Verify the member-ends of the derivations, relators and materials
			//One side is the Relator and other is the Material
			if(derivation.getMemberEnd().get(1).getType().equals(r)){
				material = (MaterialAssociation)derivation.getMemberEnd().get(0).getType();
				lst.add(material);
			}else if(derivation.getMemberEnd().get(0).getType().equals(r)){
				material = (MaterialAssociation)derivation.getMemberEnd().get(1).getType();
				lst.add(material);
			}
		}
		return lst;
	}

	private void processAssociation() {
		for (Association ass : lstAssociation) {
			RefOntoUML.Classifier srcT = (Classifier) ass.getMemberEnd().get(0).getType();
			RefOntoUML.Classifier tgtT = (Classifier) ass.getMemberEnd().get(1).getType();
			if(!owlFactoryUtil.isMappedAsOwlClass(srcT) || !owlFactoryUtil.isMappedAsOwlClass(tgtT)){
				continue;
			}
			
			if(lstGsSetMapChildren.contains(srcT) || lstGsSetMapChildren.contains(tgtT)) continue;
			if(lstDataType.contains(srcT) || lstDataType.contains(tgtT)) continue;
			
			owlFactoryUtil.createObjectProperty(ass);

			if(mappingElements.isMappedAsSubPropertyOf(ass)){
				owlFactoryUtil.createSubPropertyOf(ass);					
			}			
		}
	}

	private void processGeneralizations() {
		//First process all GeneralizationSet
		processGeneralizationSet();

		//Process Generalizations
		for(Generalization gen : lstGen){
			Classifier general = gen.getGeneral();
			Classifier specific = gen.getSpecific();
			
			if(!owlFactoryUtil.isMappedAsOwlClass(general) || !owlFactoryUtil.isMappedAsOwlClass(specific)){
				continue;
			}
			if(lstGsSetMapChildren.contains(general) || lstGsSetMapChildren.contains(specific)) continue;
			
			owlFactoryUtil.createSubClassOf(general, specific);	
		}
	}

	/**
	 * Create all GeneralizationSets
	 * */
	private void processGeneralizationSet() {
		for(GeneralizationSet gen : lstGenSets){
			owlFactoryUtil.createGeneralizationSetAttributes(gen);			
		}
	}

	/**
	 * Process the simple DataTypes (as class attributes), DataTypes in class (class with
	 * stereotype DataType) and DataType structured (DataType that has other DataTypes).
	 * */
	private void processClassAttributes() {
		ArrayList<String> existentClasses = new ArrayList<String>();
		ArrayList<String> duplicatedClasses = new ArrayList<String>();
		for(RefOntoUML.Class ontCls: lstOntClass){
			if(lstGsSetMapChildren.contains(ontCls)) continue;
			
			if(existentClasses.contains(ontCls.getName())){
				duplicatedClasses.add(ontCls.getName());
			}else{
				existentClasses.add(ontCls.getName());
			}
			
			//has some attribute
			if(!ontCls.getAttribute().isEmpty()){
				for(Property prop:ontCls.getAttribute()){
					//Set the owner class of the datatype
					ArrayList<Integer> _lowerCard = new ArrayList<Integer>();
					ArrayList<Integer> _upperCard = new ArrayList<Integer>();
					_upperCard.add(1);
					_lowerCard.add(1);
					owlFactoryUtil.createDataProperty(prop, ontCls, _lowerCard, _upperCard);
				}
			}
		}
		for (String className : duplicatedClasses) {
			errors += "Warning: Duplicated names were founded for the class: " + className + "\n";
		}
	}

	private void processDataTypes(){
		ArrayList<String> existentClasses = new ArrayList<String>();
		ArrayList<String> duplicatedClasses = new ArrayList<String>();
		RefOntoUML.Classifier _RefOntoOwnerClass = null;
		for(RefOntoUML.Classifier dtcls: lstDataTypeAndNominalQualities){
			if(existentClasses.contains(dtcls.getName())){
				duplicatedClasses.add(dtcls.getName());
			}else{
				existentClasses.add(dtcls.getName());
			}
			
			if(dtcls.getAttribute().isEmpty()){
				//pegar todos os Structuration, setar todos como Owner
				ArrayList<Association> assocs = ontoParser.getDirectAssociations(dtcls);
				for (Association ass : assocs) {
					EList<Property> mEnds = ass.getMemberEnd();
					if(mEnds.get(0).getType().equals(dtcls)){
						_RefOntoOwnerClass = (Classifier) mEnds.get(1).getType();
					}else{
						_RefOntoOwnerClass = (Classifier) mEnds.get(0).getType();
					}
					if(!owlFactoryUtil.isMappedAsOwlClass(_RefOntoOwnerClass)) continue;
					owlFactoryUtil.createDataProperty(dtcls, ass, _RefOntoOwnerClass);
				}
			}else{
				
				for(Property prop:dtcls.getAttribute()){
					if(dataTypesProcesseds.contains(prop)){
						continue;
					}
					dataTypesProcesseds.add(prop);
					owlFactoryUtil.createLabel(dtcls);
					
					ArrayList<Integer> _upperCard = new ArrayList<Integer>();
					ArrayList<Integer> _lowerCard = new ArrayList<Integer>();
					_upperCard.add(1);
					_lowerCard.add(1);
					owlFactoryUtil.createDataProperty(prop, dtcls, _lowerCard, _upperCard);
				}
			}
		}
		for (String className : duplicatedClasses) {
			errors += "Warning: Duplicated names were founded for the Datatype: " + className + "\n";
		}
	}
	
	private void processEnumerations(){
		ArrayList<String> existentClasses = new ArrayList<String>();
		ArrayList<String> duplicatedClasses = new ArrayList<String>();
		RefOntoUML.Classifier _RefOntoOwnerClass = null;
		for(RefOntoUML.Classifier enums : this.lstEnumerations){
			if(existentClasses.contains(enums.getName())){
				duplicatedClasses.add(enums.getName());
			}else{
				existentClasses.add(enums.getName());
			}
			
			owlFactoryUtil.createClass(enums);
			
			//pegar todos os Structuration, setar todos como Owner
			ArrayList<Association> assocs = ontoParser.getDirectAssociations(enums);
			for (Association ass : assocs) {
				EList<Property> mEnds = ass.getMemberEnd();
				if(mEnds.get(0).getType().equals(enums)){
					_RefOntoOwnerClass = (Classifier) mEnds.get(1).getType();
				}else{
					_RefOntoOwnerClass = (Classifier) mEnds.get(0).getType();
				}
				owlFactoryUtil.createObjectProperty(ass);
				
			}
			
			RefOntoUML.Enumeration asEnumeration = (Enumeration) enums;
			
			if(!asEnumeration.getOwnedLiteral().isEmpty()){
				for(EnumerationLiteral literal : asEnumeration.getOwnedLiteral()){
					owlFactoryUtil.createIndividual(literal);					
				}
				owlFactoryUtil.createOneOf(enums, asEnumeration.getOwnedLiteral());
			}
		}
		for (String className : duplicatedClasses) {
			errors += "Warning: Duplicated names were founded for the Datatype: " + className + "\n";
		}
	}
		
	private void processSuppressedQualitiesAsAttributes() {
		for(Entry<RefOntoUML.Element, OWL2Quality> quaEntry : lstQualityMappings.entrySet()){
			Classifier qua = (Classifier) quaEntry.getKey();
			
			ArrayList<Association> assocs = ontoParser.getIndirectAssociations(qua);
			assocs.addAll(ontoParser.getDirectAssociations(qua));
			ArrayList<Association> assocToDataTypes = new ArrayList<Association>();
			ArrayList<Association> assocToClasses = new ArrayList<Association>();
			
			//look for direct and indirect associations...
			//then, separate the Datatypes that structures this Quality
			//from the Classes that are characterized by this Quality
			for (Association assoc : assocs) {
				if(assoc instanceof Structuration){
					assocToDataTypes.add(assoc);
				}else{
					assocToClasses.add(assoc);
				}
			}
			
			//for each class, is created a list of DataProperties
			for (Association assToClass : assocToClasses) {
				RefOntoUML.Classifier srcT = (Classifier) assToClass.getMemberEnd().get(0).getType();
				RefOntoUML.Classifier tgtT = (Classifier) assToClass.getMemberEnd().get(1).getType();
				
				//look if the related class is in source or target
				Classifier cls;
				if(srcT.equals(qua)){
					cls = tgtT;
				}else{
					cls = srcT;
				}
				
				//look for each DataType
				for (Association assocToDataType : assocToDataTypes) {
					RefOntoUML.Classifier srcT2 = (Classifier) assocToDataType.getMemberEnd().get(0).getType();
					RefOntoUML.Classifier tgtT2 = (Classifier) assocToDataType.getMemberEnd().get(1).getType();
					
					//look if the DataType is in the source or target
					Classifier datatype;
					int dtTpSide;
					if(ontoParser.isDatatype(srcT2)){
						datatype = srcT2;
						dtTpSide  = 0;
					}else{
						datatype = tgtT2;
						dtTpSide = 1;
					}
										
					owlFactoryUtil.createDataPropertyDomain(datatype, qua, cls);
					owlFactoryUtil.createDataPropertyRange(datatype, qua, cls, assocToDataType.getMemberEnd().get(dtTpSide));
					
					//get lower and upper bounds
					int lowerCard = assocToDataType.getMemberEnd().get(dtTpSide).getLower();
					int upperCard = assocToDataType.getMemberEnd().get(dtTpSide).getUpper();
					
					//create the dataproperty and its cardinality
					owlFactoryUtil.createCardinality(datatype, assocToDataType.getMemberEnd().get(dtTpSide), qua, cls, lowerCard, upperCard);
				}
			}
		}
	}
	
	/**
	 * Process all OntoUML class.
	 * This method is the funnel between OntoUML and OWL.
	 * It create a OWLClass for each RefOntoUML.Class
	 * */
	private void processClass() {
		ArrayList<RefOntoUML.Class> existentClasses = new ArrayList<RefOntoUML.Class>();
		ArrayList<RefOntoUML.Class> duplicatedClasses = new ArrayList<RefOntoUML.Class>();
		for(RefOntoUML.Class ontCls: lstOntClass){
			if(existentClasses.contains(ontCls)){
				duplicatedClasses.add(ontCls);
			}else{
				existentClasses.add(ontCls);
			}
			
			owlFactoryUtil.createClass(ontCls);			
		}
		
		for (RefOntoUML.Class className : duplicatedClasses) {
			errors += "Warning: Duplicated names were founded for the class: " + className.getName() + "\n";
		}
	}	
	
	/**
	 * Create the annotation present in the RefOntoUML.
	 * Create annotations for the ontology, class and dataproperty
	 * @param 
	 */
	private void processAnnotation(){
		if(!this.owlAxioms.getValue(OWL2Axiom.COMMENTS)) return;
			
		for(PackageableElement p : ontoParser.getAllInstances(PackageableElement.class)){
			if(p.getOwnedComment() != null && !p.getOwnedComment().isEmpty()){
				if(p instanceof Class){
					for(RefOntoUML.Comment c : p.getOwnedComment()){
						String comment = c.getBody().replaceAll("\\<[^>]*>","").replaceAll("\"", "");
						comment = Normalizer.normalize(comment, Normalizer.Form.NFD);  
						comment = comment.replaceAll("[^\\p{ASCII}]", "");
						owlFactoryUtil.createComment(p, comment);						
					}
				}else{
					for(RefOntoUML.Comment c : p.getOwnedComment()){
						String comment = c.getBody().replaceAll("\\<[^>]*>","").replaceAll("\"", "");
						comment = Normalizer.normalize(comment, Normalizer.Form.NFD);  
						comment = comment.replaceAll("[^\\p{ASCII}]", "");  
						owlFactoryUtil.createComment(comment);
					}
				}
			}
		}
	}
	
	private void processAxiom(){
		owlFactoryUtil.processAxioms();
	}
}