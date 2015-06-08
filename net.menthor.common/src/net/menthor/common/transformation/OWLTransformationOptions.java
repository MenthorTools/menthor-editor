package net.menthor.common.transformation;


public class OWLTransformationOptions extends TransformationOptions {
	String ontologyIri = "";
	MappingType mappingType;
	boolean generateFile = false;
	String filePath = "";
	
	//disjointness
	boolean disjointClassAxioms = true;
	boolean disjointAssociationAxioms = true;
	
	//associations
	boolean domainAxiom = true;
	boolean rangeAxiom = true;
	boolean inverseAxiom = true;
	
	//association binary association
	boolean reflexiveAxiom = true;
	boolean irreflexiveAxiom = true;
	boolean symmetricAxiom = true;
	boolean asymmetricreflexiveAxiom = true;
	boolean transitiveAxiom = true;
	boolean functionalAxiom = true;
	boolean inverseFunctionalAxiom = true;
	
	public MappingType getMappingType() {
		return mappingType;
	}
	public void setMappingType(MappingType mappingType) {
		this.mappingType = mappingType;
	}
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
	public boolean isAsymmetricreflexiveAxiom() {
		return asymmetricreflexiveAxiom;
	}
	public void setAsymmetricreflexiveAxiom(boolean asymmetricreflexiveAxiom) {
		this.asymmetricreflexiveAxiom = asymmetricreflexiveAxiom;
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
}
