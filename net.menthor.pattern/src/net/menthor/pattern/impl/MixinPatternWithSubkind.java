package net.menthor.pattern.impl;

import java.util.ArrayList;
import java.util.Arrays;

import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Generalization;
import RefOntoUML.Kind;
import RefOntoUML.Mixin;
import RefOntoUML.Package;
import RefOntoUML.Phase;
import RefOntoUML.Quantity;
import RefOntoUML.Role;
import RefOntoUML.SubKind;
import RefOntoUML.parser.OntoUMLParser;

public class MixinPatternWithSubkind extends AbstractPattern{

	public MixinPatternWithSubkind(OntoUMLParser parser, double x, double y) {
		super(parser, x, y, "/resources/patterns/MixinPatternWithSubkind.png", "Mixin Pattern With Subkind");
	}

	@Override
	public void runPattern() {
		if(dym==null || dm==null) return;
		dym.addHashTree(fillouthashTree(Arrays.asList(new Class[]{Kind.class, Quantity.class, Collective.class, SubKind.class, Mixin.class, Role.class, Phase.class})));
		
		dym.addTableLine("mixin", "Mixin", new String[] {"Mixin"});

		dym.addTableLine("sortal", "Sortal", new String[] {"Kind","Collective", "Quantity"});

		dym.addTableLine("subkind", "Subkind", new String[] {"Subkind"});
		dym.addTableLine("antirigidsortal", "Anti Rigid Sortal", new String[] {"Role","Phase"});

		dm.open();
	}

	@Override
	public Fix getSpecificFix(){
		Package root = parser.getModel();
		outcomeFixer = new OutcomeFixer(root);
		fix = new Fix();
		Fix _fix = new Fix();

		ArrayList<Generalization> generalizationList = new ArrayList<>();

		ArrayList<Object[]> mixins = dym.getRowsOf("mixin");
		ArrayList<Object[]> sortals = dym.getRowsOf("sortal");
		ArrayList<Object[]> subkinds = dym.getRowsOf("subkind");
		ArrayList<Object[]> antirigids = dym.getRowsOf("antirigidsortal");
		
		if(mixins == null || sortals == null || subkinds == null || antirigids == null)
			return null;

		Classifier mixin 	= getClassifier(mixins.get(0), x, y);
		Classifier sortal 	= getClassifier(sortals.get(0), x-verticalDistance/2, y);
		Classifier subkind 	= getClassifier(subkinds.get(0),x+(0*verticalDistance)/3, y+horizontalDistance);
		Classifier antirigid 	= getClassifier(antirigids.get(0),x+(1*verticalDistance)/3, y+horizontalDistance);


		if(mixin != null){
			if(subkind != null){
				_fix.addAll(outcomeFixer.createGeneralizationWithFix(subkind, mixin));
				Generalization generalization = (Generalization) _fix.getAdded().get(_fix.getAdded().size()-1);
				generalizationList.add(generalization);
				fix.addAll(_fix);
			}

			if(antirigid != null){
				_fix.addAll(outcomeFixer.createGeneralizationWithFix(antirigid, mixin));
				Generalization generalization = (Generalization) _fix.getAdded().get(_fix.getAdded().size()-1);
				generalizationList.add(generalization);
				fix.addAll(_fix);
			}

			if(subkind != null && antirigid != null){
				fix.addAll(createGeneralizationSet(generalizationList, true, true, dym.getGeneralizationSetName()));
			}
		}

		if(sortal != null){
			if(subkind != null){
				fix.addAll(outcomeFixer.createGeneralizationWithFix(subkind,sortal));
			}
		}

		return fix;
	}

}
