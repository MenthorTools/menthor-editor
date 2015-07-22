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

public class RolePartition extends AbstractPattern{
	private Classifier c;
	public RolePartition(OntoUMLParser parser, Classifier c, double x, double y) {
		super(parser, x, y, "/resource/RolePartition.png", "Role Partition");
		this.c = c;
	}

	public RolePartition(OntoUMLParser parser, double x, double y) {
		super(parser, x, y, "/resource/RolePartition.png", "Role Partition");
	}
	
	@Override
	public void runPattern() {
		if(dym==null || dm==null) return;
		dym.addHashTree(fillouthashTree(Arrays.asList(new Class[]{Kind.class, Collective.class, Quantity.class, SubKind.class, Phase.class, Role.class})));

		dym.addTableLine("general", "General", new String[] {"Kind","Collective", "Quantity", "Subkind", "Phase", "Role"});

		if(c != null){
			dym.addTableRigidLine("specific", UtilAssistant.getStringRepresentationClass(c), new String[] {"Role"});
		}else{
			dym.addTableLine("specific", "Specific 1", new String[] {"Role"});
		}
		dym.addTableLine("specific", "Specific 2", new String[] {"Role"});

		dym.setInitialItemCount(3);

		dym.setAddLineButtonAction("specific", "Specific N", new String[] {"Role"});

		isPartitionPattern(Arrays.asList(new Class[]{Kind.class, Collective.class, Quantity.class, SubKind.class, Phase.class, Role.class}), Arrays.asList(new Class[]{Role.class}));

		dm.open();
	}

	@Override
	public Fix getSpecificFix(){
		getPartitionFix();
		return fix;
	}

}
