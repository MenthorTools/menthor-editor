package net.menthor.ontouml2uml.tests;

import java.io.IOException;

import net.menthor.ontouml2uml.OntoUML2UML;
import net.menthor.ontouml2uml.OntoUML2UMLOption;
import RefOntoUML.parser.OntoUMLParser;

public class OntoUML2ReifiedUMLTests {
	
	public static void main(String[] args)
	{
		try {
						
			String path1 = "src/net/menthor/ontouml2uml/tests/models/Imóvel.refontouml";
			OntoUML2UML.convertToTemporalUML(new OntoUMLParser(path1), path1.replace(".refontouml", ".uml" ), new OntoUML2UMLOption(true,true), false);
			System.out.println(OntoUML2UML.getLog());
			
			String path2 = "src/net/menthor/ontouml2uml/tests/models/Project.refontouml";
			OntoUML2UML.convertToTemporalUML(new OntoUMLParser(path2),path2.replace(".refontouml", ".uml" ), new OntoUML2UMLOption(true,true), false);
			System.out.println(OntoUML2UML.getLog());
			
			String path3 = "src/net/menthor/ontouml2uml/tests/models/RoadTrafficAccident.refontouml";
			OntoUML2UML.convertToTemporalUML(new OntoUMLParser(path3),path3.replace(".refontouml", ".uml" ), new OntoUML2UMLOption(true,true), false);
			System.out.println(OntoUML2UML.getLog());
			
			String path4 = "src/net/menthor/ontouml2uml/tests/models/EnumTest.refontouml";
			OntoUML2UML.convertToTemporalUML(new OntoUMLParser(path4),path4.replace(".refontouml", ".uml" ), new OntoUML2UMLOption(true,true), false);
			System.out.println(OntoUML2UML.getLog());
			
			String path5 = "src/net/menthor/ontouml2uml/tests/models/RunningExample.refontouml";
			OntoUML2UML.convertToTemporalUML(new OntoUMLParser(path5),path5.replace(".refontouml", ".uml" ), new OntoUML2UMLOption(true,true), false);
			System.out.println(OntoUML2UML.getLog());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
