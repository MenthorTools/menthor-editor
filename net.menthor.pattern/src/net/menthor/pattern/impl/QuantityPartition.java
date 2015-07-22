package net.menthor.pattern.impl;

import java.util.Arrays;

import net.menthor.common.ontoumlfixer.Fix;
import RefOntoUML.Category;
import RefOntoUML.Quantity;
import RefOntoUML.parser.OntoUMLParser;

public class QuantityPartition extends AbstractPattern{

	public QuantityPartition(OntoUMLParser parser, double x, double y) {
		super(parser, x, y,"/resource/QuantityPartition.png", "Quantity Partition");
	}

	@Override
	public void runPattern(){
		if(dym==null || dm==null) return;
		dym.addHashTree(fillouthashTree(Arrays.asList(new Class[]{Category.class, Quantity.class})));

		dym.addTableLine("general", "General", new String[] {"Category"});

		dym.addTableLine("specific", "Specific 1", new String[] {"Quantity"});
		dym.addTableLine("specific", "Specific 2", new String[] {"Quantity"});

		dym.setInitialItemCount(3);

		dym.setAddLineButtonAction("specific", "Specific N", new String[] {"Quantity"});

		isPartitionPattern(Arrays.asList(new Class[]{Category.class}), Arrays.asList(new Class[]{Quantity.class}));
		dm.open();
	}

	@Override
	public Fix getSpecificFix(){
		getPartitionFix();
		return fix;
	}
}
