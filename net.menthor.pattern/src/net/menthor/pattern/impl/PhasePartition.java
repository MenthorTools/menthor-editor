package net.menthor.pattern.impl;

import java.util.Arrays;

import net.menthor.assistant.util.UtilAssistant;
import net.menthor.common.ontoumlfixer.Fix;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Kind;
import RefOntoUML.Phase;
import RefOntoUML.Quantity;
import RefOntoUML.Role;
import RefOntoUML.SubKind;
import RefOntoUML.parser.OntoUMLParser;

public class PhasePartition extends AbstractPattern{

	public PhasePartition(OntoUMLParser parser, double x, double y) {
		super(parser, x, y, "/resource/PhasePartition.png", "Phase Partition");
	}

	private Classifier c;
	public PhasePartition(OntoUMLParser parser, Classifier c, double x, double y) {
		super(parser, x, y, "/resource/PhasePartition.png", "Phase Partition");
		this.c = c;
	}
	
	@Override
	public void runPattern() {
		if(dym==null || dm==null) return;
		dym.addHashTree(fillouthashTree(Arrays.asList(new Class[]{Kind.class, Collective.class, Quantity.class, SubKind.class, Phase.class, Role.class})));
		
		dym.addTableLine("general", "Sortal", new String[] {"Kind","Collective", "Quantity", "Subkind", "Phase", "Role"});
		
		if(c instanceof Phase){
			dym.addTableRigidLine("specific", UtilAssistant.getStringRepresentationClass(c), new String[] {"Phase"});
		}else{
			dym.addTableLine("specific", "Specific 1", new String[] {"Phase"});	
		}
		
		dym.addTableLine("specific", "Specific 2", new String[] {"Phase"});
		
		dym.setInitialItemCount(3);
		dym.setAddLineButtonAction("specific", "Specific N", new String[] {"Phase"});
		
		isPartitionPattern(Arrays.asList(new Class[]{Kind.class, Collective.class, Quantity.class, SubKind.class, Phase.class, Role.class}), Arrays.asList(new Class[]{Phase.class}));
		dm.open();
	}

	@Override
	public Fix getSpecificFix(){
		getPartitionFix();
		return fix;
	}

}
