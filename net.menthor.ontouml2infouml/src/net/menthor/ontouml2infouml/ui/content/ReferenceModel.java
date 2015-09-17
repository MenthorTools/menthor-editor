package net.menthor.ontouml2infouml.ui.content;

import java.util.LinkedList;

import RefOntoUML.util.RefOntoUMLModelAbstraction;

public class ReferenceModel
{
	public LinkedList<RefOntoUML.Class> model;
	
	public ReferenceModel (RefOntoUMLModelAbstraction ontoumlmodel)
	{
		// Root nodes = Substance Sortal + Relators + Category
		model = new LinkedList<RefOntoUML.Class>();
		
		for (RefOntoUML.Category cat : ontoumlmodel.categories)
		{
			model.add(cat);
		}
		for (RefOntoUML.SubstanceSortal ss : ontoumlmodel.substanceSortals)
		{
			model.add(ss);
		}
		for (RefOntoUML.Relator r : ontoumlmodel.relators)
		{
			model.add(r);
		}
	}
}
