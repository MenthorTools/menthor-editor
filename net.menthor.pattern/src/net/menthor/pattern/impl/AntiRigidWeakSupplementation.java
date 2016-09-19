package net.menthor.pattern.impl;

import java.util.ArrayList;
import java.util.Arrays;

import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Generalization;
import RefOntoUML.Kind;
import RefOntoUML.Meronymic;
import RefOntoUML.Package;
import RefOntoUML.Quantity;
import RefOntoUML.Role;
import RefOntoUML.SubKind;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.stereotypes.RelationshipStereotype;

public class AntiRigidWeakSupplementation extends AbstractPattern {
	public AntiRigidWeakSupplementation(OntoUMLParser parser, double x, double y) {
		super(parser, x, y, "/resources/patterns/AntiRigidWeakSupplementation.png", "Anti-Rigid Weak Supplementation");
	}

	@Override
	public void runPattern() {
		if(dym==null || dm==null) return;
		dym.addHashTree(fillouthashTree(Arrays.asList(new Class[]{Kind.class, Quantity.class, Collective.class, SubKind.class, Role.class})));

		dym.addTableLine("type", "Type", new String[] {"Kind","Collective", "Quantity", "Subkind"});
		dym.addTableLine("complex", "Complex Type", new String[] {"Role"});
		dym.addTableLine("atomic", "Atomic Type", new String[] {"Role"});

		reuseGeneralizationSet(Arrays.asList(new Class[]{Kind.class, Collective.class, Quantity.class, SubKind.class}), Arrays.asList(new Class[]{Role.class}));
		
		dm.open();
	}

	@Override
	public Fix getSpecificFix() {
		Package root = parser.getModel();
		outcomeFixer = new OutcomeFixer(root);
		fix = new Fix();
		Fix _fix = new Fix();
		
		ArrayList<Generalization> generalizationList = new ArrayList<>();
		
		ArrayList<Object[]> types = dym.getRowsOf("type");
		ArrayList<Object[]> complexes = dym.getRowsOf("complex");
		ArrayList<Object[]> atomics = dym.getRowsOf("atomic");
		
		if(types == null || complexes == null || atomics == null)
			return null;

		Classifier type 	= getClassifier(types.get(0), x, y);
		Classifier complex 	= getClassifier(complexes.get(0), x-horizontalDistance/2, y+horizontalDistance*0.6);
		Classifier atomic 	= getClassifier(atomics.get(0),x+(1*verticalDistance)/4, y+horizontalDistance*0.6);

		Association componentOf = null;
		
		
		if(type != null){
			
			if(complex != null){
				_fix.addAll(outcomeFixer.createGeneralizationWithFix(complex, type));
				Generalization generalization = (Generalization) _fix.getAdded().get(_fix.getAdded().size()-1);
				generalizationList.add(generalization);		
				fix.addAll(_fix);
			}
			if(atomic != null){
				_fix = outcomeFixer.createGeneralizationWithFix(atomic, type);
				Generalization generalization = (Generalization) _fix.getAdded().get(_fix.getAdded().size()-1);
				generalizationList.add(generalization);
				fix.addAll(_fix);
			}
			if(generalizationList.size() == 2){
				fix.addAll(createGeneralizationSet(generalizationList, true, true, dym.getGeneralizationSetName()));
			}
		}

		if(complex != null && type != null){
			componentOf = (Association)outcomeFixer.createAssociationBetween(RelationshipStereotype.COMPONENTOF, "", complex, type).getAdded().get(0);
			
			((Meronymic)(componentOf)).setIsShareable(true);
			
			outcomeFixer.changePropertyMultiplicity(componentOf.getMemberEnd().get(0), "0..1");//complex
			outcomeFixer.changePropertyMultiplicity(componentOf.getMemberEnd().get(1), "2..*");//type
			
			fix.includeAdded(componentOf);
		}

		return fix;
	}

}
