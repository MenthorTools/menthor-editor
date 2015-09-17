package net.menthor.ontouml2sbvr;

import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;

import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;

public class RefOntoUMLUtil
{
	public static Classifier getGSetGeneral (GeneralizationSet gs)
	{
		return gs.getGeneralization().get(0).getGeneral();
	}	                                                     
	
	public static LinkedList<Classifier> getGSetSpecifics (GeneralizationSet gs)
	{
		LinkedList<Classifier> specifics = new LinkedList<Classifier>();
		
		for (Iterator<Generalization> gens2 = gs.getGeneralization().iterator(); gens2.hasNext();)
		{
			specifics.add(gens2.next().getSpecific());
		}
		
		return specifics;		
	}
	
	public static LinkedList<String> getGSetSpecificsName (GeneralizationSet gs)
	{
		LinkedList<String> specifics = new LinkedList<String>();
				
		for (Iterator<Generalization> gens2 = gs.getGeneralization().iterator(); gens2.hasNext();)
		{
			specifics.add(gens2.next().getSpecific().getName());
		}
		
		return specifics;
	}
	
	public static LinkedList<String> IncludedInCs (Classifier c)
	{
		LinkedList<String> gsets = new LinkedList<String>();
		
		for (Iterator<Generalization> it = c.getGeneralization().iterator(); it.hasNext();)
		{
			EList<GeneralizationSet> aux = it.next().getGeneralizationSet();
			if (aux.size() != 0)
			{
				GeneralizationSet gs = aux.get(0);
				gsets.add(getGSetName(gs));
			}
		}
		
		if (gsets.size() == 0)
			return null;
		
		return gsets;
	}
	
	public static String getGSetName (GeneralizationSet gs)
	{
		String gsName;
		
		if (gs.getName() != null)
		{
			// If it has a name
			gsName = gs.getName();
		}
		else
		{
			gsName = "";
			
			// The General
			gsName += getGSetGeneral(gs).getName() + ": ";
			
			// The Specifics
			LinkedList<String> specifics = getGSetSpecificsName(gs);
			for (Iterator<String> it = specifics.iterator(); it.hasNext();)
			{
				gsName += it.next();
				if (it.hasNext())
					gsName += ", ";
			}
		}
		
		return gsName;
	}
}
