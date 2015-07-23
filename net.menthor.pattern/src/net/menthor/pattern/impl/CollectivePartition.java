package net.menthor.pattern.impl;

import java.util.Arrays;

import net.menthor.common.ontoumlfixer.Fix;
import RefOntoUML.Category;
import RefOntoUML.Collective;
import RefOntoUML.parser.OntoUMLParser;

public class CollectivePartition extends AbstractPattern{

	public CollectivePartition(OntoUMLParser parser, double x, double y) {
		super(parser, x, y,"/resources/patterns/CollectivePartition.png", "Collective Partition");
	}

	@Override
	public void runPattern(){
		if(dym==null || dm==null) return;
		dym.addHashTree(fillouthashTree(Arrays.asList(new Class[]{Category.class, Collective.class})));

		dym.addTableLine("general", "General", new String[] {"Category"});

		dym.addTableLine("specific", "Specific 1", new String[] {"Collective"});
		dym.addTableLine("specific", "Specific 2", new String[] {"Collective"});

		dym.setInitialItemCount(3);

		dym.setAddLineButtonAction("specific", "Specific N", new String[] {"Collective"});

		isPartitionPattern(Arrays.asList(new Class[]{Category.class}), Arrays.asList(new Class[]{Collective.class}));
		dm.open();
	}

	@Override
	public Fix getSpecificFix(){
		getPartitionFix();
		return fix;
	}
}
