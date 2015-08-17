package net.menthor.editor.v2.types.settings;

import java.io.Serializable;

public enum OwlReasonerType implements Serializable {
	
	UNSELECTED("Unselected"), 
	HERMIT("Hermit"), 
	PELLET("Pellet");
	
	private String name;

	OwlReasonerType(String name)
	{
		this.name = name;
	}

	public static OwlReasonerType getByName(String name){
		if(UNSELECTED.getName().compareToIgnoreCase(name)==0) return UNSELECTED;
		if(HERMIT.getName().compareToIgnoreCase(name)==0) return HERMIT;
		if(PELLET.getName().compareToIgnoreCase(name)==0) return PELLET;
		return null;
	}
	
	public String toString(){ return getName(); }
	
	public String getName() { return name; }

	public static void main (String args[])
	{
		for(OwlAxiomsType c: OwlAxiomsType.values()){
			System.out.println(c);
		}
	}
}
