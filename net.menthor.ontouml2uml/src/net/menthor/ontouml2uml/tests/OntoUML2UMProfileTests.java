package net.menthor.ontouml2uml.tests;

import java.io.IOException;

import net.menthor.ontouml2uml.OntoUML2UML;
import net.menthor.ontouml2uml.OntoUML2UMLOption;
import RefOntoUML.parser.OntoUMLParser;

public class OntoUML2UMProfileTests {
	
	public static void main(String[] args)
	{
		try {
			
			String path1 = "src/br/ufes/inf/nemo/ontouml2uml/tests/models/Im�vel.refontouml";
			OntoUML2UML.convertToUMLProfile(new OntoUMLParser(path1), path1.replace(".refontouml", ".uml" ), new OntoUML2UMLOption(true,true));			
			System.out.println(OntoUML2UML.getLog());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
