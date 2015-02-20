package net.menthor.ontouml2alloy.rules;

import net.menthor.alloy.AlloyFactory;
import net.menthor.alloy.BinaryOperation;
import net.menthor.alloy.BinaryOperator;
import net.menthor.alloy.CompareOperation;
import net.menthor.alloy.CompareOperator;
import net.menthor.alloy.DisjointExpression;
import net.menthor.alloy.VariableReference;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;

public class GeneralizationSetRule {


	/**
	 * Create Complete Compare Operation in Alloy for Generalization Sets that are complete.
	 * 
	 *  disj[Child1, Child2, Child3,...]
	 */
	public static DisjointExpression createDisjointExpression (OntoUMLParser ontoparser, AlloyFactory factory, GeneralizationSet gs)
	{
		DisjointExpression disj = factory.createDisjointExpression();
		for(Generalization gen : gs.getGeneralization())
		{
			if(ontoparser.isSelected(gen))
			{
				VariableReference vr = factory.createVariableReference();
				vr.setVariable(ontoparser.getAlias(gen.getSpecific()));
				disj.getSet().add(vr);
			}
		}
		return disj;
	}
	
	/**
	 * Create Complete Compare Operation in Alloy for Generalization Sets that are complete.
	 * 
	 * Father = Child1 + Child2 + Child3 + ...
	 */
	public static CompareOperation createCompleteCompareOperation (OntoUMLParser ontoparser, AlloyFactory factory, GeneralizationSet gs)
	{
		if (ontoparser.retainSelected(gs.getGeneralization()).size() == 0) return null;		
		CompareOperation co = factory.createCompareOperation();
		co.setOperator(CompareOperator.EQUAL);		
		VariableReference vr = factory.createVariableReference();		
		vr.setVariable(ontoparser.getAlias(gs.parent()));		
		co.setLeftExpression(vr);		
		int cont = 1;		
		BinaryOperation bo = factory.createBinaryOperation();
		for(Generalization gen : ontoparser.retainSelected(gs.getGeneralization()))
		{
			if(ontoparser.retainSelected(gs.getGeneralization()).size() == 1)
			{
				VariableReference vr1 = factory.createVariableReference();					
				vr1.setVariable(ontoparser.getAlias(gen.getSpecific()));				
				co.setRightExpression(vr1);				
				break;
			}
			if(cont == 1)
			{
				bo.setOperator(BinaryOperator.UNION);
				vr = factory.createVariableReference();				
				vr.setVariable(ontoparser.getAlias(gen.getSpecific()));
				bo.setLeftExpression(vr);
				co.setRightExpression(bo);
			}			
			if(cont > 1 && cont != gs.getGeneralization().size())
			{
				vr = factory.createVariableReference();				
				vr.setVariable(ontoparser.getAlias(gen.getSpecific()));
				bo.setRightExpression(factory.createBinaryOperation());
				((BinaryOperation)bo.getRightExpression()).setOperator(BinaryOperator.UNION);
				((BinaryOperation)bo.getRightExpression()).setLeftExpression(vr);
				bo = ((BinaryOperation)bo.getRightExpression());
			}
			if(cont == gs.getGeneralization().size())
			{
				vr = factory.createVariableReference();				
				vr.setVariable(ontoparser.getAlias(gen.getSpecific()));
				bo.setRightExpression(vr);
			}			
			cont++;
		}
		return co;
	}
}
