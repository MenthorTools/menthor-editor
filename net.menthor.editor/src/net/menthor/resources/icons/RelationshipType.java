package net.menthor.resources.icons;

public enum RelationshipType {

	ASSOCIATION("Association"), 
	GENERALIZATION("Generalization"), GENERALIZATIONSET("Generalization Set"),
	CHARACTERIZATION("Characterization"), MEDIATION("Mediation"), DERIVATION("Derivation"), STRUCTURATION("Structuration"), 
	FORMAL("Formal"), MATERIAL("Material"), 
	COMPONENTOF("ComponentOf"), MEMBEROF("MemberOf"), SUBCOLLECTIONOF("SubCollectionOf"), SUBQUANTITYOF("SubQuantityOf"),
	SUBEVENTOF("SubEventOf"), PARTICIPATION("Participation"), TEMPORAL("Temporal"),
	INSTANCEOF("InstanceOf");
	
	private String name;

	RelationshipType(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() {
		return name();
	}

	public String getName() { return name; }

	public static void main (String args[])
	{
		for(RelationshipType c: RelationshipType.values()){
			System.out.println(c.name);
		}
	}
}
