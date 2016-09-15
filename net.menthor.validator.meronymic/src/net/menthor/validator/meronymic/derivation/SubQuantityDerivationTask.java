package net.menthor.validator.meronymic.derivation;

import net.menthor.common.ontouml2directedgraph.EdgePath;
import net.menthor.validator.meronymic.derivation.DerivedMeronymic.PatternType;
import net.menthor.validator.meronymic.derivation.ui.DerivedTableModel;
import RefOntoUML.Classifier;
import RefOntoUML.subQuantityOf;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.stereotypes.RelationshipStereotype;

public class SubQuantityDerivationTask extends DerivationTask<subQuantityOf>{
	
	
	
	public SubQuantityDerivationTask(OntoUMLParser parser, DerivedTableModel tableModel) {
		super(parser, tableModel);
		
		existing.addAll(parser.getAllInstances(subQuantityOf.class));
	}
	
	
	public void deriveSubQuantityOf(){

		if(!arePathsSet())
			setPaths();
		
		for (EdgePath path : paths) {
			if(path.isCycle() || path.getEdges().size()==1)
				continue;
			
			Classifier whole = (Classifier) path.getIdOfNode(0);
			Classifier part = (Classifier) path.getIdOfNode(path.getEdges().size());
			
			derived.add(createDerivedSubQauntityOf(path, whole, part));
		}
	}

	private DerivedMeronymic createDerivedSubQauntityOf(EdgePath path, Classifier whole, Classifier part) {
		return createDerivedMeronymic(path, whole, part, PatternType.DIRECT_SUBQUANTITY_PARTHOOD, getDirect(whole, part,subQuantityOf.class), RelationshipStereotype.SUBQUANTITYOF);
	}
	

	@Override
	protected Boolean doInBackground() throws Exception {
		System.out.println("Quantity Derivation: creating quantities graph...");
		setPaths();
		System.out.println("Quantity Derivation: deriving sub-quantities...");
		deriveSubQuantityOf();
		System.out.println("Quantity Derivation: "+derived.size()+" quantities derived");
		System.out.println("Quantity Derivation: derivation completed!");
		System.out.println("Quantity Derivation: a total of "+derived.size()+" relations were derived!");
		setProgress(34);
		return true;
	}	
}
