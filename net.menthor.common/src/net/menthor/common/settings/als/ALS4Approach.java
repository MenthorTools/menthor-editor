package net.menthor.common.settings.als;


public enum ALS4Approach {
	
	
	BRANCHING("Branching World","Branching scenario where worlds states are ordered as a tree with branches towards the future "+
	"capturing that the future may unfold in different ways, where no joining branches are allowed. "+
	"In this approach, classes are Alloy binary relations between worlds and objects whilst relationships "+
	"are Alloy ternary/4-ary relations indexed by worlds.");


	
	private String description;
	private String name;
	
	ALS4Approach(String name, String description)
	{
		this.description = description;
		this.name = name;
	}

	public String getDescription() { return description; }
	public String getName() { return name; }
	
	public String toString(){
		return getName();
	}
	
	public static void main (String args[])
	{
		for(ALS4Approach c: ALS4Approach.values()){
			System.out.println(c);
		}
	}
}
