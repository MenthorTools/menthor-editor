package net.menthor.ontouml2infouml.decision;

public enum AttributeType
{
	INT, STRING, CUSTOM;

	@Override
	public String toString()
	{		
		return super.toString().toLowerCase();
	}
}
