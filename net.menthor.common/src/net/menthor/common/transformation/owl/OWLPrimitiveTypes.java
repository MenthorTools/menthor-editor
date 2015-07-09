package net.menthor.common.transformation.owl;

import net.menthor.common.transformation.GeneralizationMappingType;

public enum OWLPrimitiveTypes {
	anyURI, base64Binary, date, dateTime, decimal, duration, ENTITIES, ENTITY, IDREFS, IDREF, ID, 
	gYearMonth, gYear, gMonthDay, gDay, gMonth, hexBinary, integer, language, Name, NCName,
	negativeInteger, NMTOKENS, NMTOKEN, nonNegativeInteger, nonPositiveInteger, normalizedString,
	NOTATION, positiveInteger, QName, string, time, token, unsignedLong, unsignedInt, unsignedShort, 
	unsignedByte,
	_short{
		@Override
		public String toString() {
			return "short";
	}},
	_long{
		@Override
		public String toString() {
			return "long";
	}}, 
	_int{
		@Override
		public String toString() {
			return "int";
	}},
	_float{
		@Override
		public String toString() {
			return "float";
	}},
	_double{
		@Override
		public String toString() {
			return "double";
	}},
	_boolean{
		@Override
		public String toString() {
			return "boolean";
	}}, 
	_byte{
		@Override
		public String toString() {
			return "byte";
	}};
	
	public static String[] valuesStr(){
		int length = GeneralizationMappingType.values().length;
		String[] values = new String[length];
		
		for (int i = 0; i < length; i++) {
			values[i] = GeneralizationMappingType.values()[i].toString();
		}
		
		return values;
	}
}
