package net.menthor.common.transformation;

public enum GenSetMappingType {
	
	ALLCLASSES("All Classes"),
	LEAFCLASSES("Leaf Classes"),
	_1STCLASSES("1st Classes");
	
	private String name;

	GenSetMappingType(String value){
		this.name = value;
	}

	public String getName() { return name; }

	public static GenSetMappingType getByName(String name){
		if(ALLCLASSES.getName().compareToIgnoreCase(name)==0) return ALLCLASSES;
		else if(LEAFCLASSES.getName().compareToIgnoreCase(name)==0) return LEAFCLASSES;
		else if(_1STCLASSES.getName().compareToIgnoreCase(name)==0) return _1STCLASSES;
		else return null;
	}
	
	public String toString(){
		return getName();
	}
	
	public static void main (String args[])
	{
		for(GenSetMappingType c: GenSetMappingType.values()){
			System.out.println(c);
		}
	}
}
