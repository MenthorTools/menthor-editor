package net.menthor.xmi2ontouml.xmiparser;

import java.util.Map;
import java.util.List;

import net.menthor.xmi2ontouml.util.ElementType;

public interface XMIParser {
	
	public Object getRoot();
	
	public String getStereotype(Object element);
	
	/** These are distinctions from our new metam-odel for OntoUML */
	// ======================================================
	// quality:{perceivable, non-perceivable,nominal}, participation:{change, destruction,creation}, etc.
	public String getNature(Object element); 
	// Integer, Decimal, Boolean, String, Real
	public String getBasicType(Object element);
	// Interval, Ordinal, Rational, Nominal
	public String getScaleType(Object element);
	// ======================================================
	
	// Retorna uma lista de elementos do tipo 'type' no escopo do elemento 'element'
	public List<Object> getElements(Object element, ElementType type);
	
	public Map<String, Object> getProperties(Object element);


	
}
