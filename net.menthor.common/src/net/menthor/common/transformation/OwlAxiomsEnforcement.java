package net.menthor.common.transformation;

import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.util.RefOntoUMLElement;


public class OwlAxiomsEnforcement extends AxiomsEnforcement {
	
	/**ontology IRI*/
	String ontologyIri = new String();
	
	/**disjointness*/
	private boolean classDisjointness = true;
	private boolean objectPropertyDisjointness = true;
	private boolean associationDisjointness = true;
	private boolean classCompleteness = true;
	
	/**associations*/
	private boolean domain = true;
	private boolean range = true;
	private boolean inverse = true;
	
	/**association binary association*/
	private boolean reflexive = true;
	private boolean irreflexive = true;
	private boolean symmetric = true;
	private boolean asymmetric = true;
	private boolean transitive = true;
	private boolean functional = true;
	private boolean inverseFunctional = true;
	
	/**swrl rules*/
	private boolean swrlRules = true;
	
	/**cardinality*/
	private boolean cardinality = true;
	
	/**ufo's structure*/
	private boolean ufoStructure = false;
	
	public boolean isClassCompleteness() { return classCompleteness; }
	public void setEnforcingCompleteOfClass(boolean completeClassAxiom) { this.classCompleteness = completeClassAxiom; }
	public boolean isObjectPropertyDisjointness() { return objectPropertyDisjointness; }
	public void setEnforcingDisjointOfObjectProperty(boolean disjointObjectPropertyAxioms) { this.objectPropertyDisjointness = disjointObjectPropertyAxioms; }
	public boolean isClassDisjointness() { return classDisjointness; }	
	public void setEnforcingDisjointOfClass(boolean disjointClassAxioms) { this.classDisjointness = disjointClassAxioms; }
	public boolean isAssociationDisjointness() { return associationDisjointness; }
	public void setEnforcingDisjointOfAssociation(boolean disjointAssociationAxioms) { this.associationDisjointness = disjointAssociationAxioms; }
	public boolean isDomain() { return domain; }
	public void setEnforcingDomain(boolean domainAxiom) { this.domain = domainAxiom; }
	public boolean isRange() { return range; }
	public void setEnforcingRange(boolean rangeAxiom) { this.range = rangeAxiom; }
	public boolean isInverse() { return inverse; }
	public void setEnforcingInverse(boolean inverseAxiom) { this.inverse = inverseAxiom; }
	public boolean isEnforcingReflexive() { return reflexive; }
	public void setEnforcingReflexive(boolean reflexiveAxiom) { this.reflexive = reflexiveAxiom; }
	public boolean isEnforcingIrreflexive() { return irreflexive; }
	public void setEnforcingIrreflexive(boolean irreflexiveAxiom) { this.irreflexive = irreflexiveAxiom; }
	public boolean isEnforcingSymmetric() { return symmetric; }
	public void setEnforcingSymmetric(boolean symmetricAxiom) { this.symmetric = symmetricAxiom; }
	public boolean isEnforcingAsymmetric() { return asymmetric;}
	public void setEnforcingAsymmetric(boolean asymmetricreflexiveAxiom) { this.asymmetric = asymmetricreflexiveAxiom; }
	public boolean isEnforcingTransitive() { return transitive;}
	public void setEnforcingTransitive(boolean transitiveAxiom) { this.transitive = transitiveAxiom; }
	public boolean isEnforcingFunctional() { return functional; }
	public void setEnforcingFunctional(boolean functionalAxiom) { this.functional = functionalAxiom; }
	public boolean isEnforcingInverseFunctional() { return inverseFunctional; }
	public void setEnforcingInverseFunctional(boolean inverseFunctionalAxiom) { this.inverseFunctional = inverseFunctionalAxiom; }
	public String getOntologyIri() { return ontologyIri; }
	public void setOntologyIri(String ontologyIri) { this.ontologyIri = ontologyIri; }	
	public void setEnforcingCardinality(boolean cardinality) { this.cardinality = cardinality; }
	public boolean isEnforcingSwrlRules() { return swrlRules; }
	public void setEnforcingSwrlRules(boolean swrlRulesAxiom) { this.swrlRules = swrlRulesAxiom; }
	public boolean isEnforcingCardinality() { return cardinality; }
	public boolean isEnforcingUfoStructure() { return ufoStructure; }
	public void setEnforcingUfoStructure(boolean ufoStructure) { this.ufoStructure = ufoStructure; }
	
	//==========================================================
	HashMap<EObject, Object> primitiveTypeMappingsEObject = new HashMap<EObject, Object>();
	HashMap<EObject, Object> attributeMappingsEObject = new HashMap<EObject, Object>();	
	HashMap<EObject, Object> qualityMappingsEObject = new HashMap<EObject, Object>();	
	Object[][] genSetEnumMappings;
	
	public void setQualityTypeMappingsOntoUMLElement(HashMap<RefOntoUMLElement, Object> qualityMappingsOntoUMLElement) 
	{
		for (Entry<RefOntoUMLElement, Object> entry : qualityMappingsOntoUMLElement.entrySet()){
			qualityMappingsEObject.put(entry.getKey().getElement(),entry.getValue());
		}
	}
	
	public void setPrimitiveTypeMappingsOntoUMLElement(HashMap<RefOntoUMLElement, Object> primitiveTypeMappingsOntoUMLElement)
	{
		for (Entry<RefOntoUMLElement, Object> entry : primitiveTypeMappingsOntoUMLElement.entrySet()) {
			primitiveTypeMappingsEObject.put(entry.getKey().getElement(),entry.getValue());
		}
	}
	
	public void setAttributeMappingsOntoUMLElement(HashMap<RefOntoUMLElement, Object> attributeMappingsOntoUMLElement) 
	{
		for (Entry<RefOntoUMLElement, Object> entry : attributeMappingsOntoUMLElement.entrySet()) {
			attributeMappingsEObject.put(entry.getKey().getElement(),entry.getValue());
		}
	}	
	
	public void setGenSetEnumMappings(Object[][] genSetEnumMappings) 
	{
		this.genSetEnumMappings = genSetEnumMappings;
	}
	
	public Object[][] getGenSetEnumMappings() {
		return genSetEnumMappings;
	}
	
	public HashMap<EObject, Object> getAttributeMappingsEObject() {
		return attributeMappingsEObject;
	}
	public HashMap<EObject, Object> getPrimitiveTypeMappingsEObject() {
		return primitiveTypeMappingsEObject;
	}
	
}
