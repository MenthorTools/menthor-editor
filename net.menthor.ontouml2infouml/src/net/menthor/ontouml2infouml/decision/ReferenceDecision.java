package net.menthor.ontouml2infouml.decision;

public class ReferenceDecision implements Decision
{
	private static final long serialVersionUID = 1516834064790927005L;

	public boolean reference;
	public String attributeName;
	public AttributeType attributeType;
	public String typeName;
	
	public ReferenceDecision()
	{
		reference = true;
		attributeName = "id";
		attributeType = AttributeType.INT;
		typeName = "";
	}
	
	public void setAttributeType (AttributeType attributeType, String universalName)
	{
		this.attributeType = attributeType;

		if (attributeType == AttributeType.CUSTOM && typeName.compareTo("")== 0)
		{
			typeName = universalName + "ID";
		}
	}
}
