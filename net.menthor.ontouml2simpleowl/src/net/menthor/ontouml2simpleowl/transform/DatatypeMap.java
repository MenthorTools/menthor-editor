package net.menthor.ontouml2simpleowl.transform;

import java.util.HashMap;
import java.util.Map;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

public class DatatypeMap {

	private final static Map<String,IRI> builtInDataTypeMap = new HashMap<>();
	private final static Map<String,IRI> dataTypeMap = new HashMap<>();
	
	static {		
		// int => INT => INTEGER
		// datetime => XSD_DATE_TIME => XSD_DATE_TIME_STAMP
		// dateTime => XSD_DATE_TIME_STAMP
		
		builtInDataTypeMap.put("string", OWL2Datatype.XSD_STRING.getIRI());
		builtInDataTypeMap.put("int", OWL2Datatype.XSD_INT.getIRI());
		builtInDataTypeMap.put("integer", OWL2Datatype.XSD_INTEGER.getIRI());
		builtInDataTypeMap.put("boolean", OWL2Datatype.XSD_BOOLEAN.getIRI());
		builtInDataTypeMap.put("datetime", OWL2Datatype.XSD_DATE_TIME.getIRI());
		builtInDataTypeMap.put("date", OWL2Datatype.XSD_DATE_TIME.getIRI());
		builtInDataTypeMap.put("long", OWL2Datatype.XSD_LONG.getIRI());
		builtInDataTypeMap.put("float", OWL2Datatype.XSD_FLOAT.getIRI());
		builtInDataTypeMap.put("byte", OWL2Datatype.XSD_BYTE.getIRI());
		
		dataTypeMap.put("unsigned_int", OWL2Datatype.XSD_UNSIGNED_INT.getIRI());
		dataTypeMap.put("unsignedInt", OWL2Datatype.XSD_UNSIGNED_INT.getIRI());
		dataTypeMap.put("IntegerIntervalDimension", OWL2Datatype.XSD_INTEGER.getIRI());
		dataTypeMap.put("IntegerOrdinalDimension", OWL2Datatype.XSD_INTEGER.getIRI());
		dataTypeMap.put("IntegerRationalDimension", OWL2Datatype.XSD_INTEGER.getIRI());
		dataTypeMap.put("unsigned_byte", OWL2Datatype.XSD_UNSIGNED_BYTE.getIRI());
		dataTypeMap.put("unsignedByte", OWL2Datatype.XSD_UNSIGNED_BYTE.getIRI());
		dataTypeMap.put("double", OWL2Datatype.XSD_DOUBLE.getIRI());
		dataTypeMap.put("NominalQuality", OWL2Datatype.XSD_STRING.getIRI());
		dataTypeMap.put("normalized_string", OWL2Datatype.XSD_NORMALIZED_STRING.getIRI());
		dataTypeMap.put("normalizedString", OWL2Datatype.XSD_NORMALIZED_STRING.getIRI());
		dataTypeMap.put("hex_binary", OWL2Datatype.XSD_HEX_BINARY.getIRI());
		dataTypeMap.put("hexBinary", OWL2Datatype.XSD_HEX_BINARY.getIRI());
		dataTypeMap.put("short", OWL2Datatype.XSD_SHORT.getIRI());
		dataTypeMap.put("unsigned_long", OWL2Datatype.XSD_UNSIGNED_LONG.getIRI());
		dataTypeMap.put("unsignedLong", OWL2Datatype.XSD_UNSIGNED_LONG.getIRI());
		dataTypeMap.put("anyURI", OWL2Datatype.XSD_ANY_URI.getIRI());
		dataTypeMap.put("base64Binary", OWL2Datatype.XSD_BASE_64_BINARY.getIRI());
		dataTypeMap.put("decimal", OWL2Datatype.XSD_DECIMAL.getIRI());
		dataTypeMap.put("DecimalIntervalDimension", OWL2Datatype.XSD_DECIMAL.getIRI());
		dataTypeMap.put("DecimalOrdinalDimension", OWL2Datatype.XSD_DECIMAL.getIRI());
		dataTypeMap.put("DecimalRationalDimension", OWL2Datatype.XSD_DECIMAL.getIRI());
		dataTypeMap.put("Name", OWL2Datatype.XSD_NAME.getIRI());
		dataTypeMap.put("NCName", OWL2Datatype.XSD_NCNAME.getIRI());
		dataTypeMap.put("nonPositiveInteger", OWL2Datatype.XSD_NON_POSITIVE_INTEGER.getIRI());
		dataTypeMap.put("nonNegativeInteger", OWL2Datatype.XSD_NON_NEGATIVE_INTEGER.getIRI());
		dataTypeMap.put("unsignedShort", OWL2Datatype.XSD_UNSIGNED_SHORT.getIRI());
		dataTypeMap.put("negativeInteger", OWL2Datatype.XSD_NEGATIVE_INTEGER.getIRI());
		dataTypeMap.put("positiveInteger", OWL2Datatype.XSD_POSITIVE_INTEGER.getIRI());
		dataTypeMap.put("language", OWL2Datatype.XSD_LANGUAGE.getIRI());
		dataTypeMap.put("token", OWL2Datatype.XSD_TOKEN.getIRI());
		dataTypeMap.put("NMTOKEN", OWL2Datatype.XSD_NMTOKEN.getIRI());
	}
	
	private static OWLDataFactory f() {
		return OWLManager.getOWLDataFactory();
	}


	public static OWLDatatype getBuiltinType(String name) {
		name=name.toLowerCase();
		if ( builtInDataTypeMap.containsKey(name) ) {
			return f().getOWLDatatype(builtInDataTypeMap.get(name));
		} else {
			return null;
		}
	}
	
	public static OWLDatatype getType(String name) {
		name=name.toLowerCase();
		if (builtInDataTypeMap.containsKey(name)) {
			return f().getOWLDatatype(builtInDataTypeMap.get(name));
		}
		if (dataTypeMap.containsKey(name)) {
			return f().getOWLDatatype(dataTypeMap.get(name));
		}
		return f().getOWLDatatype(OWL2Datatype.RDFS_LITERAL.getIRI());
	}	
}
