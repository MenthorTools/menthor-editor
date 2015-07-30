package net.menthor.resources.icons;

public enum ClassType {

	CLASS("Class"), 
	KIND("Kind"), QUANTITY("Quantity"), COLLECTIVE("Collective"), 
	RELATOR("Relator"), MODE("Mode"), 
	PERCEIVABLE_QUALITY("Perceivable Quality"), NONPERCEIVABLE_QUALITY("Non Perceivable QUality"), NOMINAL_QUALITY("Nominal Quality"),
	SUBKIND("SubKind"), ROLE("Role"), PHASE("Phase"), 
	CATEGORY("Category"), MIXIN("Mixin"), ROLEMIXIN("RoleMixin"), PHASEMIXIN("PhaseMixin"),
	EVENT("Event"), POWERTYPE("PowerType");
	
	private String name;

	ClassType(String name)
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
		for(ClassType c: ClassType.values()){
			System.out.println(c.name);
		}
	}
}
