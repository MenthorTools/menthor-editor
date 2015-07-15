package net.menthor.common.transformation.owl;

import java.util.HashMap;
import java.util.Map.Entry;

import net.menthor.common.transformation.TransformationOptions;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.util.RefOntoUMLElement;


public class OWLTransformationOptions extends TransformationOptions {
	String ontologyIri = "";
	//MappingType mappingType;
	boolean generateFile = false;
	String filePath = "";
	
	//disjointness
	boolean disjointClassAxioms = true;
	boolean disjointObjectPropertyAxioms = true;
	boolean disjointAssociationAxioms = true;
	boolean completeClassAxiom = true;
	
	//associations
	boolean domainAxiom = true;
	boolean rangeAxiom = true;
	boolean inverseAxiom = true;
	
	//association binary association
	boolean reflexiveAxiom = true;
	boolean irreflexiveAxiom = true;
	boolean symmetricAxiom = true;
	boolean asymmetricAxiom = true;
	boolean transitiveAxiom = true;
	boolean functionalAxiom = true;
	boolean inverseFunctionalAxiom = true;
	
	//swrl rules
	boolean swrlRulesAxiom = true;
	
	//cardinality
	boolean cardinalityAxiom = true;
	
	boolean ufoStructure = false;
	
	HashMap<RefOntoUMLElement, Object> primitiveTypeMappingsOntoUMLElement = new HashMap<RefOntoUMLElement, Object>();
	HashMap<RefOntoUMLElement, Object> attributeMappingsOntoUMLElement = new HashMap<RefOntoUMLElement, Object>();
	HashMap<EObject, Object> primitiveTypeMappingsEObject = new HashMap<EObject, Object>();
	HashMap<EObject, Object> attributeMappingsEObject = new HashMap<EObject, Object>();
	
	public HashMap<RefOntoUMLElement, Object> getAttributeMappingsOntoUMLElement() {
		return attributeMappingsOntoUMLElement;
	}
	public HashMap<RefOntoUMLElement, Object> getPrimitiveTypeMappingsOntoUMLElement() {
		return primitiveTypeMappingsOntoUMLElement;
	}
	public void setPrimitiveTypeMappingsOntoUMLElement(HashMap<RefOntoUMLElement, Object> primitiveTypeMappingsOntoUMLElement) {
		this.primitiveTypeMappingsOntoUMLElement = primitiveTypeMappingsOntoUMLElement;
		
		for (Entry<RefOntoUMLElement, Object> entry : primitiveTypeMappingsOntoUMLElement.entrySet()) {
			primitiveTypeMappingsEObject.put(entry.getKey().getElement(),entry.getValue());
		}
	}
	public void setAttributeMappingsOntoUMLElement(HashMap<RefOntoUMLElement, Object> attributeMappingsOntoUMLElement) {
		this.attributeMappingsOntoUMLElement = attributeMappingsOntoUMLElement;

		for (Entry<RefOntoUMLElement, Object> entry : attributeMappingsOntoUMLElement.entrySet()) {
			attributeMappingsEObject.put(entry.getKey().getElement(),entry.getValue());
		}
	}	
	public HashMap<EObject, Object> getAttributeMappingsEObject() {
		return attributeMappingsEObject;
	}
	public HashMap<EObject, Object> getPrimitiveTypeMappingsEObject() {
		return primitiveTypeMappingsEObject;
	}
	public boolean isCompleteClassAxiom() {
		return completeClassAxiom;
	}
	public void setCompleteClassAxiom(boolean completeClassAxiom) {
		this.completeClassAxiom = completeClassAxiom;
	}
	public boolean isDisjointObjectPropertyAxioms() {
		return disjointObjectPropertyAxioms;
	}
	public void setDisjointObjectPropertyAxioms(boolean disjointObjectPropertyAxioms) {
		this.disjointObjectPropertyAxioms = disjointObjectPropertyAxioms;
	}
//	public MappingType getMappingType() {
//		return mappingType;
//	}
//	public void setMappingType(MappingType mappingType) {
//		this.mappingType = mappingType;
//	}
	public boolean isDisjointClassAxioms() {
		return disjointClassAxioms;
	}
	public void setDisjointClassAxioms(boolean disjointClassAxioms) {
		this.disjointClassAxioms = disjointClassAxioms;
	}
	public boolean isDisjointAssociationAxioms() {
		return disjointAssociationAxioms;
	}
	public void setDisjointAssociationAxioms(boolean disjointAssociationAxioms) {
		this.disjointAssociationAxioms = disjointAssociationAxioms;
	}
	public boolean isDomainAxiom() {
		return domainAxiom;
	}
	public void setDomainAxiom(boolean domainAxiom) {
		this.domainAxiom = domainAxiom;
	}
	public boolean isRangeAxiom() {
		return rangeAxiom;
	}
	public void setRangeAxiom(boolean rangeAxiom) {
		this.rangeAxiom = rangeAxiom;
	}
	public boolean isInverseAxiom() {
		return inverseAxiom;
	}
	public void setInverseAxiom(boolean inverseAxiom) {
		this.inverseAxiom = inverseAxiom;
	}
	public boolean isReflexiveAxiom() {
		return reflexiveAxiom;
	}
	public void setReflexiveAxiom(boolean reflexiveAxiom) {
		this.reflexiveAxiom = reflexiveAxiom;
	}
	public boolean isIrreflexiveAxiom() {
		return irreflexiveAxiom;
	}
	public void setIrreflexiveAxiom(boolean irreflexiveAxiom) {
		this.irreflexiveAxiom = irreflexiveAxiom;
	}
	public boolean isSymmetricAxiom() {
		return symmetricAxiom;
	}
	public void setSymmetricAxiom(boolean symmetricAxiom) {
		this.symmetricAxiom = symmetricAxiom;
	}
	public boolean isAsymmetricAxiom() {
		return asymmetricAxiom;
	}
	public void setAsymmetricAxiom(boolean asymmetricreflexiveAxiom) {
		this.asymmetricAxiom = asymmetricreflexiveAxiom;
	}
	public boolean isTransitiveAxiom() {
		return transitiveAxiom;
	}
	public void setTransitiveAxiom(boolean transitiveAxiom) {
		this.transitiveAxiom = transitiveAxiom;
	}
	public boolean isFunctionalAxiom() {
		return functionalAxiom;
	}
	public void setFunctionalAxiom(boolean functionalAxiom) {
		this.functionalAxiom = functionalAxiom;
	}
	public boolean isInverseFunctionalAxiom() {
		return inverseFunctionalAxiom;
	}
	public void setInverseFunctionalAxiom(boolean inverseFunctionalAxiom) {
		this.inverseFunctionalAxiom = inverseFunctionalAxiom;
	}
	public String getOntologyIri() {
		return ontologyIri;
	}
	public void setOntologyIri(String ontologyIri) {
		this.ontologyIri = ontologyIri;
	}
	public boolean isGenerateFile() {
		return generateFile;
	}
	public void setGenerateFile(boolean generateFile) {
		this.generateFile = generateFile;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setCardinalityAxiom(boolean cardinality) {
		this.cardinalityAxiom = cardinality;		
	}
	public boolean isSwrlRulesAxiom() {
		return swrlRulesAxiom;
	}
	public void setSwrlRulesAxiom(boolean swrlRulesAxiom) {
		this.swrlRulesAxiom = swrlRulesAxiom;
	}
	public boolean isCardinalityAxiom() {
		return cardinalityAxiom;
	}
	public boolean isUfoStructure() {
		return ufoStructure;
	}
	public void setUfoStructure(boolean ufoStructure) {
		this.ufoStructure = ufoStructure;
	}
	
}
