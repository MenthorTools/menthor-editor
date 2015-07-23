package net.menthor.ontouml2infouml;

import java.util.HashMap;
import java.util.Map.Entry;

/*
	Important usages of Map:
	
	replicateProperty -> Property.Type
	createAssociationRepresentingRoleClass -> Property.Type
	replicateAssociation -> Association.ownedEnds, Association.navigableOwnedEnds
	
	createArtificialGeneralization -> Generalization.general and Generalization.specific
	replicateGeneralization -> Generalization.general and Generalization.specific
	createGeneralizationSet -> GeneralizationSet.generalizations
	 
	 and perhaps others that I forgot...
 */

public class Onto2InfoMap
{
	// Maps RefOntoUML Elements to UML Elements (auxiliary for Properties, Generalizations and GeneralizationSets)
	public static HashMap <RefOntoUML.Element,org.eclipse.uml2.uml.Element> mymap;
	
	public static void initializeMap ()
	{
		mymap = new HashMap<RefOntoUML.Element, org.eclipse.uml2.uml.Element>();
	}
	
	// Relate Classifiers and Generalizations
	// This is important for solving Generalizations and Properties (relating Classifiers) and GeneralizationSets (relating Generalizations)
	public static void relateElements (RefOntoUML.Element c1, org.eclipse.uml2.uml.Element c2)
	{
		mymap.put(c1, c2);
	}

	public static org.eclipse.uml2.uml.Element getElement (RefOntoUML.Element e1)
	{
		return mymap.get(e1);
	}
	
	public static org.eclipse.uml2.uml.Classifier getClassifier (RefOntoUML.Classifier c1)
	{
		return (org.eclipse.uml2.uml.Classifier) getElement(c1);
	}
	
	public static org.eclipse.uml2.uml.Class getClass (RefOntoUML.Class c1)
	{
		return (org.eclipse.uml2.uml.Class) getElement(c1);
	}
	
	public static org.eclipse.uml2.uml.Association getAssociation (RefOntoUML.Association a1)
	{
		return (org.eclipse.uml2.uml.Association) getElement(a1);
	}
		
	public static org.eclipse.uml2.uml.Generalization getGeneralization (RefOntoUML.Generalization gen1)
	{
		return (org.eclipse.uml2.uml.Generalization) getElement(gen1);
	}
	
	// This is used for Roles of a RoleMixin
	public static org.eclipse.uml2.uml.Generalization getGeneralization (RefOntoUML.Role role)
	{
		return (org.eclipse.uml2.uml.Generalization) getElement(role);
	}
	
	public static org.eclipse.uml2.uml.GeneralizationSet getGeneralizationSet (RefOntoUML.GeneralizationSet gset1)
	{
		return (org.eclipse.uml2.uml.GeneralizationSet) getElement(gset1);
	}
	
	public static org.eclipse.uml2.uml.Type getType (RefOntoUML.Type type1)
	{
		return (org.eclipse.uml2.uml.Type) getElement(type1);
	}

	public static void removeElement (RefOntoUML.Element e1)
	{
		mymap.remove(e1);
	}
		
	public static void printMap ()
	{
		for (Entry<RefOntoUML.Element, org.eclipse.uml2.uml.Element> entry : mymap.entrySet())
		{
			System.out.println(entry.getKey());	
			System.out.println(entry.getValue());
			System.out.println();
		}
	}
}
