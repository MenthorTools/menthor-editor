package net.menthor.pattern.impl;

import java.util.Arrays;

import net.menthor.common.ontoumlfixer.Fix;
import RefOntoUML.Category;
import RefOntoUML.Kind;
import RefOntoUML.parser.OntoUMLParser;

public class KindPartition extends AbstractPattern{

	public KindPartition(OntoUMLParser parser, double x, double y) {
		super(parser, x, y,"/resources/patterns/KindPartition.png", "Kind Partition");
	}

	@Override
	public void runPattern(){
		if(dym==null || dm==null) return;
		dym.addHashTree(fillouthashTree(Arrays.asList(new Class[]{Category.class, Kind.class})));

		dym.addTableLine("general", "General", new String[] {"Category"});

		dym.addTableLine("specific", "Specific 1", new String[] {"Kind"});
		dym.addTableLine("specific", "Specific 2", new String[] {"Kind"});

		dym.setInitialItemCount(3);

		dym.setAddLineButtonAction("specific", "Specific N", new String[] {"Kind"});

		isPartitionPattern(Arrays.asList(new Class[]{Category.class}), Arrays.asList(new Class[]{Kind.class}));
		dm.open();
	}

	@Override
	public Fix getSpecificFix(){
		getPartitionFix();
		return fix;
	}
}
