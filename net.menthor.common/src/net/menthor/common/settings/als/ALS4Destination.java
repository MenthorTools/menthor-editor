package net.menthor.common.settings.als;

public enum ALS4Destination {

	ANALYZER("Alloy Analyzer","Open the result by calling the Alloy Analyzer"), 
	TAB("Tab", "Visualize the result in an embedded text editor (a new tab in the current application)"),
	FILE("File","Write the result in a file"); 
	
	private String description;
	private String name;
	
	ALS4Destination(String name, String description)
	{
		this.description = description;
		this.name = name;
	}

	public String getDescription() { return description; }
	public String getName() { return name; }
	
	public static ALS4Destination getByName(String name){
		if(ANALYZER.getName().compareToIgnoreCase(name)==0) return ANALYZER;
		if(TAB.getName().compareToIgnoreCase(name)==0) return TAB;
		if(FILE.getName().compareToIgnoreCase(name)==0) return FILE;
		return null;
	}
	
	public String toString(){
		return getName();
	}
	
	public static void main (String args[])
	{
		for(ALS4Destination c: ALS4Destination.values()){
			System.out.println(c);
		}
	}
}
