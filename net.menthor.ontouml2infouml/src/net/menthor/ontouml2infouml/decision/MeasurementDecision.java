package net.menthor.ontouml2infouml.decision;

public class MeasurementDecision implements Decision
{
	private static final long serialVersionUID = -3251772059826202190L;

	public AttributeType attributeType;
	public String typeName;
	
	public MeasurementDecision(String qualityName)
	{
		attributeType = AttributeType.CUSTOM;
		typeName = qualityName.replace(" ", "") + "Value";
	}
}
