
package net.menthor.editor.v2.types;

import org.eclipse.emf.ecore.EObject;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

public enum DataType implements OntoUMLMetatype{

	DATATYPE("DataType", RefOntoUML.DataType.class), 
	ENUMERATION("Enumeration", RefOntoUML.Enumeration.class), 
	PRIMITIVETYPE("PrimitiveType", RefOntoUML.PrimitiveType.class),
	MEASUREMENT_DOMAIN("Measurement Domain", RefOntoUML.MeasurementDomain.class),
	INTEGERRATIONAL_DIMENSION("IntegerRational Dimension", RefOntoUML.IntegerRationalDimension.class), 
	INTEGERORDINAL_DIMENSION("IntegerOrdinal Dimension", RefOntoUML.IntegerOrdinalDimension.class), 
	INTEGERINTERVAL_DIMENSION("IntegerInterval Dimension", RefOntoUML.IntegerIntervalDimension.class), 
	DECIMALRATIONAL_DIMENSION("DecimalRational Dimension", RefOntoUML.DecimalRationalDimension.class), 
	DECIMALORDINAL_DIMENSION("DecimalOrdinal Dimension", RefOntoUML.DecimalOrdinalDimension.class), 
	DECIMALINTERVAL_DIMENSION("DecimalInterval Dimension", RefOntoUML.DecimalIntervalDimension.class),
	STRINGNOMINAL_STRUCTURE("StringNominal Structure", RefOntoUML.StringNominalStructure.class);
	
	private String name;
	private Class<? extends EObject> metaClass;
	
	DataType(String name)
	{
		this.name = name;
	}

	DataType(String name, Class<? extends EObject> metaClass)
	{
		this.name = name;
		this.metaClass = metaClass;
	}
	
	@Override
	public String toString() {
		return getName();
	}

	@Override
	public Class<? extends EObject> getMetaclass(){ 
		return metaClass; 
	}
	
	@Override
	public String getName() { 
		return name; 
	}
	
	@Override
	public OntoUMLMetatype getMetatype(EObject datatype){
		return (OntoUMLMetatype)getDataType(datatype);
	}
	
	public static DataType getDataType(EObject dataType){
		if(dataType instanceof RefOntoUML.DecimalIntervalDimension) return DECIMALINTERVAL_DIMENSION;
		if(dataType instanceof RefOntoUML.DecimalOrdinalDimension) return DECIMALORDINAL_DIMENSION;
		if(dataType instanceof RefOntoUML.DecimalRationalDimension) return DECIMALRATIONAL_DIMENSION;
		if(dataType instanceof RefOntoUML.IntegerIntervalDimension) return INTEGERINTERVAL_DIMENSION;
		if(dataType instanceof RefOntoUML.IntegerOrdinalDimension) return INTEGERORDINAL_DIMENSION;
		if(dataType instanceof RefOntoUML.IntegerRationalDimension) return INTEGERRATIONAL_DIMENSION;
		if(dataType instanceof RefOntoUML.MeasurementDomain) return MEASUREMENT_DOMAIN;
		if(dataType instanceof RefOntoUML.Enumeration) return ENUMERATION;
		if(dataType instanceof RefOntoUML.StringNominalStructure) return STRINGNOMINAL_STRUCTURE;
		if(dataType instanceof RefOntoUML.PrimitiveType) return PRIMITIVETYPE;
		if(dataType instanceof RefOntoUML.DataType) return DATATYPE;		
		return DATATYPE;
	}
	
	public static void main (String args[])
	{
		for(DataType c: DataType.values()){
			System.out.println(c.name);
		}
	}

	@Override
	public boolean isDataType(){
		return true;
	}
	
	@Override
	public boolean isAssociation() {
		return false;
	}

	@Override
	public boolean isMeronymic() {
		return false;
	}

	@Override
	public boolean isGeneralization() {
		return false;
	}

	@Override
	public boolean isClass() {
		return false;
	}

	@Override
	public boolean isGeneralizationSet() {
		return false;
	}

	@Override
	public boolean isPackage() {
		return false;
	}
}
