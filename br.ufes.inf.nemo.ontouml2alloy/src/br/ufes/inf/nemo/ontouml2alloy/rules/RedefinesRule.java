package br.ufes.inf.nemo.ontouml2alloy.rules;

import net.menthor.alloy.AlloyFactory;
import net.menthor.alloy.BinaryOperation;
import net.menthor.alloy.BinaryOperator;
import net.menthor.alloy.CompareOperation;
import net.menthor.alloy.CompareOperator;
import net.menthor.alloy.QuantificationExpression;
import net.menthor.alloy.Quantificator;
import RefOntoUML.Association;
import RefOntoUML.Property;
import RefOntoUML.Type;
import RefOntoUML.parser.OntoUMLParser;
import br.ufes.inf.nemo.ontouml2alloy.util.AlloyAPI;

public class RedefinesRule {

	/**
	 * Create a constraints for redefined properties.
	 * 
	 * For example: all x: World | all a: A, c: C | a.p1[w] = c.p2[w] 
	 */
	public static QuantificationExpression createQuantificationExpression (AlloyFactory factory, OntoUMLParser ontoparser, Property property, Property subsetted) 
	{	
		QuantificationExpression qe1 = AlloyAPI.createQuantificationExpression(factory, Quantificator.ALL, "w", "World");
		
		Association assoc = property.getAssociation();
		Type source=null;
		if (assoc.getMemberEnd().get(0).equals(property)) source = assoc.getMemberEnd().get(1).getType();
		else source = assoc.getMemberEnd().get(0).getType();
				
		Association subSettedAssoc = subsetted.getAssociation();
		Type sourceSubsetted=null;
		if (subSettedAssoc.getMemberEnd().get(0).equals(subsetted)) sourceSubsetted = subSettedAssoc.getMemberEnd().get(1).getType();
		else sourceSubsetted = subSettedAssoc.getMemberEnd().get(0).getType();
		
		QuantificationExpression qe2 = AlloyAPI.createQuantificationExpression(factory, Quantificator.ALL, "self", "w", ontoparser.getAlias(source),"sub","w",ontoparser.getAlias(sourceSubsetted));		
		qe1.setExpression(qe2);
		
		BinaryOperation binOp1 = AlloyAPI.createBinaryOperation(factory, "self", BinaryOperator.JOIN, ontoparser.getAlias(property)+"[w]");
		BinaryOperation binOp2 = AlloyAPI.createBinaryOperation(factory, "sub", BinaryOperator.JOIN, ontoparser.getAlias(subsetted)+"[w]");
		
		CompareOperation cOp = factory.createCompareOperation();
		cOp.setLeftExpression(binOp1);
		cOp.setRightExpression(binOp2);
		cOp.setOperator(CompareOperator.EQUAL);
		qe2.setExpression(cOp);
		
		return qe1;
	}
}
