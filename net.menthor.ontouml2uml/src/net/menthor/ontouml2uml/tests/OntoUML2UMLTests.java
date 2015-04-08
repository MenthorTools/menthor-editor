package net.menthor.ontouml2uml.tests;

import java.io.IOException;

import net.menthor.ontouml2uml.OntoUML2UML;
import net.menthor.ontouml2uml.OntoUML2UMLOption;
import RefOntoUML.parser.OntoUMLParser;

/**
 * This class is used to test cases of the transformation.
 * 
 * @author John Guerson
 *
 */
public class OntoUML2UMLTests {

	public static void main(String[] args)
	{
		try {
						
			String path1 = "src/net/menthor/ontouml2uml/tests/models/Imóvel.refontouml";			
			OntoUML2UML.convertToUML(new OntoUMLParser(path1), path1.replace(".refontouml", ".uml" ), new OntoUML2UMLOption(true,true));
			System.out.println(OntoUML2UML.getLog());
			
			String path2 = "src/net/menthor/ontouml2uml/tests/models/Project.refontouml";
			OntoUML2UML.convertToUML(new OntoUMLParser(path2),path2.replace(".refontouml", ".uml" ), new OntoUML2UMLOption(true,true));
			System.out.println(OntoUML2UML.getLog());
			
			String path3 = "src/net/menthor/ontouml2uml/tests/models/RoadTrafficAccident.refontouml";
			OntoUML2UML.convertToUML(new OntoUMLParser(path3),path3.replace(".refontouml", ".uml" ), new OntoUML2UMLOption(true,true));
			System.out.println(OntoUML2UML.getLog());
			
			String path4 = "src/net/menthor/ontouml2uml/tests/models/EnumTest.refontouml";
			OntoUML2UML.convertToUML(new OntoUMLParser(path4),path4.replace(".refontouml", ".uml" ), new OntoUML2UMLOption(true,true));
			System.out.println(OntoUML2UML.getLog());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
