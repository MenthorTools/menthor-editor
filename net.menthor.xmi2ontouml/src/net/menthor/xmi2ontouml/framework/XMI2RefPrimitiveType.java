package net.menthor.xmi2ontouml.framework;

import net.menthor.xmi2ontouml.xmiparser.XMIParser;
import RefOntoUML.PrimitiveType;

public class XMI2RefPrimitiveType extends XMI2RefDatatype
{	
	public XMI2RefPrimitiveType (Object XMIElement, XMIParser mapper) throws Exception
	{
		super(XMIElement, mapper);
		this.XMIElement = XMIElement;
		this.Mapper = mapper;
		
		this.hashProp = Mapper.getProperties(XMIElement);
		
		String name = (String) hashProp.get("name");
		if (name.equalsIgnoreCase("int") || name.equalsIgnoreCase("integer"))
		{
			this.RefOntoUMLElement = XMI2RefModel.INTEGER_PRIMITIVE;
    	}
		else if (name.equalsIgnoreCase("bool") || name.equalsIgnoreCase("boolean"))
		{
			this.RefOntoUMLElement = XMI2RefModel.BOOLEAN_PRIMITIVE;
    	}
		else if (name.equalsIgnoreCase("str") || name.equalsIgnoreCase("string") ||
    			name.equalsIgnoreCase("char") || name.equalsIgnoreCase("character"))
		{
			this.RefOntoUMLElement = XMI2RefModel.STRING_PRIMITIVE;
    		
    	} else if (name.equalsIgnoreCase("unlimited"))
    	{
    		this.RefOntoUMLElement = XMI2RefModel.UNLIMITED_NATURAL_PRIMITIVE;
    		
		} else if (name.equalsIgnoreCase("float") || name.equalsIgnoreCase("double"))
		{
			this.RefOntoUMLElement = XMI2RefModel.REAL_NATURAL_PRIMITIVE;
		}
    	else
    	{
    		this.RefOntoUMLElement = factory.createPrimitiveType();
    		deal();
    	}
		elemMap.put(XMIElement, this);
	}
	
	public XMI2RefPrimitiveType (PrimitiveType primType)
	{
		super();
		this.RefOntoUMLElement = primType;
	}
	
	@Override
	protected void createSubElements() throws Exception
	{
		if (this.RefOntoUMLElement != XMI2RefModel.INTEGER_PRIMITIVE &&
			this.RefOntoUMLElement != XMI2RefModel.BOOLEAN_PRIMITIVE &&
			this.RefOntoUMLElement != XMI2RefModel.STRING_PRIMITIVE &&
			this.RefOntoUMLElement != XMI2RefModel.UNLIMITED_NATURAL_PRIMITIVE)
		{
			super.createSubElements();
		}
	}
}
