package net.menthor.editor.v2.ui.notify;

public enum ActionType {

	DO(""), 
	UNDO("undo"), 
	REDO("redo");
	
	private String name;

	ActionType(String name)
	{
		this.name = name;
	}
	
	public String toString() { 
		return getName(); 
	}
	
	public String getName() { 
		return name; 
	}
	
	public static void main (String args[])
	{
		for(ActionType c: ActionType.values()){
			System.out.println(c.name);
		}
	}
}
