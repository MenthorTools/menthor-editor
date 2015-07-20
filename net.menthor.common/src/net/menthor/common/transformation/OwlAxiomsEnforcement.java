package net.menthor.common.transformation;



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
	public void setClassCompleteness(boolean classCompleteness) { this.classCompleteness = classCompleteness; }
	public boolean isObjectPropertyDisjointness() { return objectPropertyDisjointness; }
	public void setObjectPropertyDisjointness(boolean objectPropertyDisjointness) { this.objectPropertyDisjointness = objectPropertyDisjointness; }
	public boolean isClassDisjointness() { return classDisjointness; }	
	public void setClassDisjointness(boolean classDisjointness) { this.classDisjointness = classDisjointness; }
	public boolean isAssociationDisjointness() { return associationDisjointness; }
	public void setAssociationDisjointness(boolean associationDisjointness) { this.associationDisjointness = associationDisjointness; }
	public boolean isDomain() { return domain; }
	public void setDomain(boolean domain) { this.domain = domain; }
	public boolean isRange() { return range; }
	public void setRange(boolean range) { this.range = range; }
	public boolean isInverse() { return inverse; }
	public void setInverse(boolean inverse) { this.inverse = inverse; }
	public boolean isReflexive() { return reflexive; }
	public void setReflexive(boolean reflexive) { this.reflexive = reflexive; }
	public boolean isIrreflexive() { return irreflexive; }
	public void setIrreflexive(boolean irreflexive) { this.irreflexive = irreflexive; }
	public boolean isSymmetric() { return symmetric; }
	public void setSymmetric(boolean symmetric) { this.symmetric = symmetric; }
	public boolean isAsymmetric() { return asymmetric;}
	public void setAsymmetric(boolean y) { this.asymmetric = y; }
	public boolean isTransitive() { return transitive;}
	public void setTransitive(boolean transitive) { this.transitive = transitive; }
	public boolean isFunctional() { return functional; }
	public void setFunctional(boolean functional) { this.functional = functional; }
	public boolean isInverseFunctional() { return inverseFunctional; }
	public void setInverseFunctional(boolean inverseFunctional) { this.inverseFunctional = inverseFunctional; }
	public String getOntologyIri() { return ontologyIri; }
	public void setOntologyIri(String ontologyIri) { this.ontologyIri = ontologyIri; }	
	public void setCardinality(boolean cardinality) { this.cardinality = cardinality; }
	public boolean isSwrlRules() { return swrlRules; }
	public void setSwrlRules(boolean swrlRules) { this.swrlRules = swrlRules; }
	public boolean isCardinality() { return cardinality; }
	public boolean isUfoStructure() { return ufoStructure; }
	public void setUfoStructure(boolean ufoStructure) { this.ufoStructure = ufoStructure; }	
}
