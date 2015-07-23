package net.menthor.ontouml2infouml.ui.content;

import java.util.LinkedList;

import RefOntoUML.util.RefOntoUMLModelAbstraction;

public class MeasurementModel
{
	public LinkedList<RefOntoUML.Class> model;
	
	public MeasurementModel (RefOntoUMLModelAbstraction ontoumlmodel)
	{
		// Qualities
		model = new LinkedList<RefOntoUML.Class>(ontoumlmodel.qualities);
	}
}
