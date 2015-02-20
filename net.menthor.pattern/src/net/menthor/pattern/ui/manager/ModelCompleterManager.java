package net.menthor.pattern.ui.manager;

import java.util.ArrayList;
import java.util.Set;

import net.menthor.pattern.dynamic.ui.ModelCompleterIdentity;
import RefOntoUML.Classifier;
import RefOntoUML.Phase;
import RefOntoUML.Role;
import RefOntoUML.SubKind;
import RefOntoUML.parser.OntoUMLParser;

public class ModelCompleterManager {
	
	public static void getCompleterIdentityWindow(OntoUMLParser parser, ModelCompleterIdentity window){
		ArrayList<Classifier> list = new ArrayList<>();
		Set<? extends Classifier> set = parser.getAllInstances(Classifier.class);
		for (Classifier c : set) {
			if(c instanceof Phase || c instanceof Role || c instanceof SubKind){
				if(parser.getAllParents(c).isEmpty()){
					list.add(c);
				}
			}
		}

		for (Classifier c : list) {
			window.addLine(parser, c);
		}
		
	}
}
