package net.menthor.editor.transformation;

public class MappingType {
	
	private String type = new String();
	private String displayName = new String();
	private String description = new String();
	
	public MappingType(String type, String displayName, String description)
	{
		this.type = type;
		this.description =description;
		this.displayName = displayName;
	}

	public String getDisplayName() { return displayName; }
	public String getType() { return type; }
	public String getDesctiprion() { return description; }	
	public String toString() { return displayName; }
	
	
}

