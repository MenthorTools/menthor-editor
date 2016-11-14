package net.menthor.ontouml2simpleowl.transform;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectCardinalityRestriction;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;

public class OWLAPIHelper {
	
	
	private static OWLDataFactory f() {
		return OWLManager.getOWLDataFactory();		
	}
	
	public static OWLClassExpression getCardinalityRestriction(int lower, int upper, OWLObjectProperty objProp, OWLClass owlSrc, OWLClass owlTrg)
	{
		// Multiplicities: 1, 3, 7
		if(lower == upper && lower > 0)
		{
			OWLObjectExactCardinality trgExact = f().getOWLObjectExactCardinality(lower, objProp, owlTrg);
			return trgExact;
		}
		// Multiplicities: 1..*, 0..*, *
		else if((lower == -1 || lower == 0 || lower == 1 ) && upper == -1)
		{
			OWLObjectSomeValuesFrom trgSome = f().getOWLObjectSomeValuesFrom(objProp, owlTrg);
			return trgSome;
		}
		else
		{
			//Deal with cardinality
			OWLObjectCardinalityRestriction trgLower = null;
			OWLObjectCardinalityRestriction trgUpper = null;
			
			// Multiplicities: 1..3, 0..3, 2..*
			if(lower > 0)
			{
				trgLower = f().getOWLObjectMinCardinality(lower, objProp, owlTrg);
			}
			if(upper > 0)
			{
				trgUpper = f().getOWLObjectMaxCardinality(upper, objProp, owlTrg);
			}
			
			if(trgLower != null && trgUpper != null)
			{
				OWLObjectIntersectionOf objInt = f().getOWLObjectIntersectionOf(trgLower, trgUpper);
				return objInt;
			}
			else if(trgLower != null)
			{
				return trgLower;
			}
			else
			{
				return trgUpper;
			}
		}
	}
	
}
