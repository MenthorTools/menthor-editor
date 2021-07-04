package net.menthor.ontouml2simpleowl.transform;

import org.junit.Assert;
import org.junit.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLObjectProperty;

public class OWLAPIHelperTest {

	@Test
	public void testGetCardinalityRestrictionInvalidInput()
	{
		final OWLObjectProperty op = OWLAPIHelper.f().getOWLObjectProperty(IRI.create("http://examp.le/op"));
		final OWLClass cSrc = OWLAPIHelper.f().getOWLClass((IRI.create("http://examp.le/cs")));
		final OWLClass cTgt = OWLAPIHelper.f().getOWLClass((IRI.create("http://examp.le/ct")));
		final OWLClassExpression e = OWLAPIHelper.getCardinalityRestriction(0, 0, op, cSrc,cTgt);
		
		Assert.assertTrue(e.isOWLNothing());
	}	
}
