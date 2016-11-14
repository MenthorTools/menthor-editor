package net.menthor.ontouml2simpleowl.transform;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

public class DatatypeMap {

	private static OWLDataFactory f() {
		return OWLManager.getOWLDataFactory();
	}

	public static OWLDatatype getBuiltinType(String name) {
		if (name.equalsIgnoreCase("string")) {
			return f().getOWLDatatype(OWL2Datatype.XSD_STRING.getIRI());
		} else if (name.equalsIgnoreCase("int")) {
			return f().getOWLDatatype(OWL2Datatype.XSD_INT.getIRI());
		} else if (name.equalsIgnoreCase("integer")) {
			return f().getOWLDatatype(OWL2Datatype.XSD_INTEGER.getIRI());
		} else if (name.equalsIgnoreCase("boolean")) {
			return f().getOWLDatatype(OWL2Datatype.XSD_BOOLEAN.getIRI());
		} else if (name.equalsIgnoreCase("datetime") || name.equalsIgnoreCase("date")) {
			return f().getOWLDatatype(OWL2Datatype.XSD_DATE_TIME.getIRI());
		} else if (name.equalsIgnoreCase("long")) {
			return f().getOWLDatatype(OWL2Datatype.XSD_LONG.getIRI());
		} else if (name.equalsIgnoreCase("float")) {
			return f().getOWLDatatype(OWL2Datatype.XSD_FLOAT.getIRI());
		} else if (name.equalsIgnoreCase("byte")) {
			return f().getOWLDatatype(OWL2Datatype.XSD_BYTE.getIRI());
		}

		return null;
	}
	
	public static OWLDatatype getType(String name) {
		if (name.equalsIgnoreCase("unsigned_int") || name.equalsIgnoreCase("unsignedInt")){
			return f().getOWLDatatype(OWL2Datatype.XSD_UNSIGNED_INT.getIRI());
		}else if(name.equalsIgnoreCase("int") || name.equalsIgnoreCase("integer") || name.equalsIgnoreCase("IntegerIntervalDimension") || name.equalsIgnoreCase("IntegerOrdinalDimension") || name.equalsIgnoreCase("IntegerRationalDimension")){
			return f().getOWLDatatype(OWL2Datatype.XSD_INTEGER.getIRI());
		}else if(name.equalsIgnoreCase("unsigned_byte") || name.equalsIgnoreCase("unsignedByte")){
			return f().getOWLDatatype(OWL2Datatype.XSD_UNSIGNED_BYTE.getIRI());
		}else if(name.equalsIgnoreCase("double")){
			return f().getOWLDatatype(OWL2Datatype.XSD_DOUBLE.getIRI());
		}else if(name.equalsIgnoreCase("string") || name.equalsIgnoreCase("NominalQuality")){
			return f().getOWLDatatype(OWL2Datatype.XSD_STRING.getIRI());
		}else if(name.equalsIgnoreCase("normalized_string") || name.equalsIgnoreCase("normalizedString")){
			return f().getOWLDatatype(OWL2Datatype.XSD_NORMALIZED_STRING.getIRI());
		}else if(name.equalsIgnoreCase("boolean")){
			return f().getOWLDatatype(OWL2Datatype.XSD_BOOLEAN.getIRI());
		}else if(name.equalsIgnoreCase("hex_binary") || name.equalsIgnoreCase("hexBinary")){
			return f().getOWLDatatype(OWL2Datatype.XSD_HEX_BINARY.getIRI());
		}else if(name.equalsIgnoreCase("short")){
			return f().getOWLDatatype(OWL2Datatype.XSD_SHORT.getIRI());
		}else if(name.equalsIgnoreCase("byte")){
			return f().getOWLDatatype(OWL2Datatype.XSD_BYTE.getIRI());
		}else if(name.equalsIgnoreCase("unsigned_long") || name.equalsIgnoreCase("unsignedLong")){
			return f().getOWLDatatype(OWL2Datatype.XSD_UNSIGNED_LONG.getIRI());
		}else if(name.equalsIgnoreCase("anyURI")){
			return f().getOWLDatatype(OWL2Datatype.XSD_ANY_URI.getIRI());
		}else if(name.equalsIgnoreCase("base64Binary")){
			return f().getOWLDatatype(OWL2Datatype.XSD_BASE_64_BINARY.getIRI());
		}else if(name.equalsIgnoreCase("date")){
			return f().getOWLDatatype(OWL2Datatype.XSD_DATE_TIME.getIRI());
		}else if(name.equalsIgnoreCase("dateTime")){
			return f().getOWLDatatype(OWL2Datatype.XSD_DATE_TIME_STAMP.getIRI());
		}else if(name.equalsIgnoreCase("decimal") || name.equalsIgnoreCase("DecimalIntervalDimension") || name.equalsIgnoreCase("DecimalOrdinalDimension") || name.equalsIgnoreCase("DecimalRationalDimension")){
			return f().getOWLDatatype(OWL2Datatype.XSD_DECIMAL.getIRI());
		}else if(name.equalsIgnoreCase("Name")){
			return f().getOWLDatatype(OWL2Datatype.XSD_NAME.getIRI());
		}else if(name.equalsIgnoreCase("NCName")){
			return f().getOWLDatatype(OWL2Datatype.XSD_NCNAME.getIRI());
		}else if(name.equalsIgnoreCase("nonPositiveInteger")){
			return f().getOWLDatatype(OWL2Datatype.XSD_NON_POSITIVE_INTEGER.getIRI());
		}else if(name.equalsIgnoreCase("nonNegativeInteger")){
			return f().getOWLDatatype(OWL2Datatype.XSD_NON_NEGATIVE_INTEGER.getIRI());
		}else if(name.equalsIgnoreCase("unsignedShort")){
			return f().getOWLDatatype(OWL2Datatype.XSD_UNSIGNED_SHORT.getIRI());
		}else if(name.equalsIgnoreCase("negativeInteger")){
			return f().getOWLDatatype(OWL2Datatype.XSD_NEGATIVE_INTEGER.getIRI());
		}else if(name.equalsIgnoreCase("positiveInteger")){
			return f().getOWLDatatype(OWL2Datatype.XSD_POSITIVE_INTEGER.getIRI());
		}else if(name.equalsIgnoreCase("language")){
			return f().getOWLDatatype(OWL2Datatype.XSD_LANGUAGE.getIRI());
		}else if(name.equalsIgnoreCase("long")){
			return f().getOWLDatatype(OWL2Datatype.XSD_LONG.getIRI());
		}else if(name.equalsIgnoreCase("float")){
			return f().getOWLDatatype(OWL2Datatype.XSD_FLOAT.getIRI());
		}else if(name.equalsIgnoreCase("token")){
			return f().getOWLDatatype(OWL2Datatype.XSD_TOKEN.getIRI());
		}else if(name.equalsIgnoreCase("NMTOKEN")){
			return f().getOWLDatatype(OWL2Datatype.XSD_NMTOKEN.getIRI());
		}
		
		return f().getOWLDatatype(OWL2Datatype.RDFS_LITERAL.getIRI());
	}	
}
