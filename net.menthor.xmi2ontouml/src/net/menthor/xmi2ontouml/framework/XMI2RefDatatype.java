package net.menthor.xmi2ontouml.framework;

import net.menthor.xmi2ontouml.util.ElementType;
import net.menthor.xmi2ontouml.xmiparser.XMIParser;
import RefOntoUML.DataType;
import RefOntoUML.Property;

public class XMI2RefDatatype extends XMI2RefClassifier
{
	public XMI2RefDatatype() {}
	
	public XMI2RefDatatype (Object XMIElement, XMIParser mapper) throws Exception
	{
		super(XMIElement, mapper);
		
		this.RefOntoUMLElement = solveStereotype(mapper.getStereotype(XMIElement), mapper.getBasicType(XMIElement), mapper.getScaleType(XMIElement));
		deal();
	}
	
	public XMI2RefDatatype (Object XMIElement, XMIParser mapper, DataType datatype) throws Exception
	{
		super(XMIElement, mapper, datatype);
	}
	
	private DataType solveStereotype(String stereotype, String basicType, String scale) throws Exception
	{		
		if (stereotype.equalsIgnoreCase("dimension")){
			if(basicType.equalsIgnoreCase("integer") && scale.equalsIgnoreCase("interval")) return factory.createIntegerIntervalDimension();
			else if(basicType.equalsIgnoreCase("decimal") && scale.equalsIgnoreCase("interval")) return factory.createDecimalIntervalDimension();			
			else if(basicType.equalsIgnoreCase("integer") && scale.equalsIgnoreCase("ordinal")) return factory.createIntegerOrdinalDimension();
			else if(basicType.equalsIgnoreCase("decimal") && scale.equalsIgnoreCase("ordinal")) return factory.createDecimalOrdinalDimension();
			else if(basicType.equalsIgnoreCase("integer") && scale.equalsIgnoreCase("rational")) return factory.createIntegerRationalDimension();
			else if(basicType.equalsIgnoreCase("decimal") && scale.equalsIgnoreCase("rational")) return factory.createDecimalRationalDimension();
			else if(basicType.equalsIgnoreCase("string") && scale.equalsIgnoreCase("nominal")) return factory.createStringNominalStructure();
			else return factory.createDataType();
		}  		
		
		else if (stereotype.equalsIgnoreCase("domain")){
			return factory.createMeasurementDomain();
		}
    				
    	else if (unknownStereotypeOpt == 0)
    		return factory.createDataType();
		
    	else if (unknownStereotypeOpt == 1)
    		return null;
		
    	else
    	{//TODO colocar isso no ontoUML error e também gerar warning
    		String error;
    		
    		if (stereotype == null || stereotype == "")
    			error = "Stereotype undefined for datatype "+hashProp.get("name");
    		
    		else
    			error = "Unknown Stereotype '"+stereotype+"' found in datatype "+hashProp.get("name");
    		
    		throw new Exception(error);
    	}
	}
		
	@Override
	protected void deal()
	{
		if (((DataType)RefOntoUMLElement).getName() == null || (
				!((DataType)RefOntoUMLElement).getName().equalsIgnoreCase("Integer") &&
				!((DataType)RefOntoUMLElement).getName().equalsIgnoreCase("Boolean") && 
				!((DataType)RefOntoUMLElement).getName().equalsIgnoreCase("String") &&
				!((DataType)RefOntoUMLElement).getName().equalsIgnoreCase("Unlimited Natural")))
		{
			super.deal();
		}
	}

	@Override
	public void dealReferences() {}
	
	@Override
	protected void createSubElements() throws Exception
	{
		for (Object prop : this.Mapper.getElements(XMIElement, ElementType.PROPERTY))
		{
			XMI2RefProperty xmi2refprop = new XMI2RefProperty(prop, Mapper);
			if (xmi2refprop.RefOntoUMLElement != null)
			{
//				listProperties.add(xmi2refprop);
				((DataType)RefOntoUMLElement).getOwnedAttribute().add((Property)xmi2refprop.getRefOntoUMLElement());
			}
		}
		
		super.createSubElements();
	}
}
