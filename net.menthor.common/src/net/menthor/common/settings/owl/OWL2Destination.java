package net.menthor.common.settings.owl;

public enum OWL2Destination {
	
	PROTEGE("Protégé","Open the result by calling Protégé"), 
	TAB("Tab", "Visualize the result in an embedded text editor (a new tab in the current application)"),
	FILE("File","Write the result in a file"); 
	
	private String description;
	private String name;
	
	OWL2Destination(String name, String description)
	{
		this.description = description;
		this.name = name;
	}

	public String getDescription() { return description; }
	public String getName() { return name; }
	
	public static OWL2Destination getByName(String name){
		if(PROTEGE.getName().compareToIgnoreCase(name)==0) return PROTEGE;
		if(TAB.getName().compareToIgnoreCase(name)==0) return TAB;
		if(FILE.getName().compareToIgnoreCase(name)==0) return FILE;
		return null;
	}
	
	public String toString(){
		return getName();
	}
	
	public static void main (String args[])
	{
		for(OWL2Destination c: OWL2Destination.values()){
			System.out.println(c);
		}
	}
}
