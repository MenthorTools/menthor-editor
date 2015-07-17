package net.menthor.common.transformation;

public class MappingType {
	
	private String identifier = new String(); 
	
	private String displayName = new String();
	
	private String description = new String();
	
	public MappingType(String identifier, String displayName, String description)
	{
		this.identifier = identifier;
		this.description =description;
		this.displayName = displayName;
	}

	public String getDisplayName() { return displayName; }
	public String getIdentifier() { return identifier; }
	public String getDesctiprion() { return description; }	
	public String toString() { return displayName; }
	
	
}

