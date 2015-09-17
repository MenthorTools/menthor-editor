package net.menthor.ontouml2infouml.ui.content;

import java.util.LinkedList;

import RefOntoUML.util.RefOntoUMLModelAbstraction;

public class HistoryTimeModel
{
	public LinkedList<RefOntoUML.Class> model;
	
	public HistoryTimeModel (RefOntoUMLModelAbstraction ontoumlmodel)
	{
		// Root nodes = Substance Sortal + Relators
		model = new LinkedList<RefOntoUML.Class>();
		
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
