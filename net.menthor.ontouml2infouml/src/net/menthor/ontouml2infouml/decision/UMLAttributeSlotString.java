package net.menthor.ontouml2infouml.decision;

import java.io.Serializable;

public class UMLAttributeSlotString implements Serializable
{
	private static final long serialVersionUID = -2902351985207388891L;
	
	public String startAttribute;
	public String endAttribute;
	public String durationAttribute;
	public String htAttribute;
	public String refAttribute;
	public String measurementAttribute;
	public String measureType;
	
	public UMLAttributeSlotString()
	{
		startAttribute = null;
		endAttribute = null;
		durationAttribute = null;
		htAttribute = null;
		refAttribute = null;
		measurementAttribute = null;
		measureType = null;
	}
}
