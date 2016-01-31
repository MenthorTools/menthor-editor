
package net.menthor.editor.v2.types;


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

public enum DataType {

	DATATYPE("DataType"), 
	ENUMERATION("Enumeration"), 
	PRIMITIVETYPE("PrimitiveType"),
	MEASUREMENT_DOMAIN("Measurement Domain"),
	INTEGERRATIONAL_DIMENSION("IntegerRational Dimension"), 
	INTEGERORDINAL_DIMENSION("IntegerOrdinal Dimension"), 
	INTEGERINTERVAL_DIMENSION("IntegerInterval Dimension"), 
	DECIMALRATIONAL_DIMENSION("DecimalRational Dimension"), 
	DECIMALORDINAL_DIMENSION("DecimalOrdinal Dimension"), 
	DECIMALINTERVAL_DIMENSION("DecimalInterval Dimension"),
	STRINGNOMINAL_STRUCTURE("StringNominal Structure");
	
	private String name;
	
	DataType(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public String getEnumString() { return name.toUpperCase().replace(" ", "_"); }
	public String getName() { return name; }

	public static DataType getDataType(RefOntoUML.DataType type){
		return getDataType(type.eClass().getName().replace(" ", ""));		
	}
	
	public static DataType getDataType(String dataType){
		for(DataType ct: values()){
			if(ct.toString().replace(" ","").compareToIgnoreCase(dataType)==0) return ct;
		}
		return null;
	}
	
	public static void main (String args[])
	{
		for(DataType c: DataType.values()){
			System.out.println(c.name);
		}
	}
}
