package net.menthor.ontouml2alloy.rules;

import java.util.Set;

import net.menthor.alloy.AlloyFactory;
import net.menthor.alloy.BinaryOperation;
import net.menthor.alloy.BinaryOperator;
import net.menthor.alloy.CompareOperation;
import net.menthor.alloy.CompareOperator;
import net.menthor.alloy.VariableReference;
import RefOntoUML.Classifier;
import RefOntoUML.parser.OntoUMLParser;

public class AbstractnessClassRule {

	/**
	 * Create Abstract Clause Rule Compare Operation in Alloy.
	 * 
	 * BinaryOperation with union operator(+) to represent the completeness
	 * between abstract father(Classifiers) and his concrete childs.
	 * 
	 * "abstract_father = concrete_child1 + concrete_child2 + concrete_child3 + ..." 
	 * 
	 * @param ontoparser: OntoUML Parser
	 * @param factory: Alloy Factory
	 * @param c: OntoUML.Classifier
	 * @return
	 */ 
	public static CompareOperation createCompareOperation(OntoUMLParser ontoparser, AlloyFactory factory, Classifier c) 
	{		
		Set<Classifier> concretes = ontoparser.getAllConcreteChildren(c);						
		if(concretes.size() > 0)
		{
			BinaryOperation bo = factory.createBinaryOperation();			
			CompareOperation co = factory.createCompareOperation();
			co.setOperator(CompareOperator.EQUAL);			
			VariableReference vr = factory.createVariableReference();
			vr.setVariable(ontoparser.getAlias(c));			
			co.setLeftExpression(vr);			
			int cont = 1;
			for(Classifier classifier : concretes)
			{
				if(concretes.size() == 1) 
				{
					vr = factory.createVariableReference();
					vr.setVariable(ontoparser.getAlias(classifier));					
					co.setRightExpression(vr);
					break;
				}
				if(cont == 1)
				{
					bo.setOperator(BinaryOperator.UNION);
					vr = factory.createVariableReference();
					vr.setVariable(ontoparser.getAlias(classifier));
					bo.setLeftExpression(vr);
					co.setRightExpression(bo);
				}
				if(cont > 1 && cont != concretes.size())
				{
					vr = factory.createVariableReference();
					vr.setVariable(ontoparser.getAlias(classifier));
					bo.setRightExpression(factory.createBinaryOperation());
					((BinaryOperation)bo.getRightExpression()).setOperator(BinaryOperator.UNION);
					((BinaryOperation)bo.getRightExpression()).setLeftExpression(vr);
					bo = ((BinaryOperation)bo.getRightExpression());
				}
				if(cont == concretes.size())
				{
					vr = factory.createVariableReference();
					vr.setVariable(ontoparser.getAlias(classifier));
					bo.setRightExpression(vr);
				}
				cont++;
			}
			return co;			
		}
		return null;
	}	}
