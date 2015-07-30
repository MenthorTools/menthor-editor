package net.menthor.resources.icons;

public enum DataType {

	DATATYPE("DataType"), DIMENSION("Dimension"), DOMAIN("Domain"), 
	ENUMERATION("Enumeration"), PRIMITIVETYPE("Primitive Type");
	
	private String name;

	DataType(String name)
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
		for(DataType c: DataType.values()){
			System.out.println(c.name);
		}
	}
}
