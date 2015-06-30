package net.menthor.virtuoso.instances;

public class ObjectPropertyInstance {
	private String ns, name, iri;
	private IndividualInstance source, target;
	
	public ObjectPropertyInstance(IndividualInstance source, String iri, IndividualInstance target) throws Exception {
		this.iri = iri;
		
		String[] splittedIri = iri.split("#");
		if(splittedIri.length < 2){
			throw new Exception();
		}
		
		this.ns = splittedIri[0];
		this.name = splittedIri[1];
		
		this.source = source;
		this.target = target;
	}
	
	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIri() {
		return iri;
	}

	public void setIri(String iri) {
		this.iri = iri;
	}

	public IndividualInstance getSource() {
		return source;
	}

	public void setSource(IndividualInstance source) {
		this.source = source;
	}

	public IndividualInstance getTarget() {
		return target;
	}

	public void setTarget(IndividualInstance target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return this.source.getName() + " -> " + this.name + " -> " + this.target.getName();
	}
}
