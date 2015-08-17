package net.menthor.common.transformation;


public enum QualityMappingType {
	
	HIDE_QUALITY("Ignore (hide) the quality"),
	MAINTAIN_QUALITY("Maintain the quality");
	
	private String name;

	QualityMappingType(String value){
		this.name = value;
	}

	public String getName() { return name; }

	public static QualityMappingType getByName(String name){
		if(HIDE_QUALITY.getName().compareToIgnoreCase(name)==0) return HIDE_QUALITY;
		else if(MAINTAIN_QUALITY.getName().compareToIgnoreCase(name)==0) return MAINTAIN_QUALITY;
		else return null;
	}
	
	public String toString(){
		return getName();
	}
	
	public static void main (String args[])
	{
		for(QualityMappingType c: QualityMappingType.values()){
			System.out.println(c);
		}
	}
}
