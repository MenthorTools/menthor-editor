package net.menthor.ontouml2infouml.impl;

import java.util.Map.Entry;

import net.menthor.ontouml2infouml.decision.HistoryDecision;
import net.menthor.ontouml2infouml.decision.UMLAttributeSlot;

public class HistoryTracking
{
	Transformation main;
	
	public HistoryTracking (Transformation t)
	{
		this.main = t;
	}
	
	public void dealHistoryTracking ()
	{
        // History Tracking
        for (Entry<RefOntoUML.Class, HistoryDecision> entry : main.dh.historyMap.entrySet())
        {
        	if (entry.getKey() instanceof RefOntoUML.Quality)
        		continue; // FIXME: Not dealing with Qualities yet (and perhaps the HT decision on qualities should be on MeasurementDecision, not here)
        	
        	RefOntoUML.Class c1 = entry.getKey();
        	HistoryDecision decision = entry.getValue();
        	UMLAttributeSlot slot = main.dh.getAttributeSlot(c1);
        	
        	if (main.dh.inScope(c1))
        	{
        		// OntoUML.Class in scope        		
	        	if (decision.requiresAttribute())
	        	{
	        		// HistoryTracking = true
	        		if (slot.htAttribute == null)
	        		{
	        			// UML.Property (Attribute) does not exist
	        			slot.htAttribute = main.umlAbstraction.addHistoryTrackingAttribute(c1);
	        			
	        			main.ui.writeLog("Created UML.Property for " + c1.getName() + ": " + slot.htAttribute.getName());
	        			Log.addition();
	        		}
	        	}
	        	else
	        	{
	        		// HistoryTracking = false
	        		if (slot.htAttribute != null)
	        		{
	        			// UML.Property (Attribute) exists
	        			// Remove it from the UML.Class
	        			main.umlAbstraction.removeClassAttribute(c1, slot.htAttribute);
	        			// Remove it from the HistoryDecision
	        			slot.htAttribute = null;
	        			
	        			main.ui.writeLog("Removed UML.Property for " + c1.getName() + " (History Tracking)");
	        			Log.removal();
	        		}
	        	}
        	}
        	else
        	{
        		// OntoUML.Class out of scope
        		// UML.Class was already removed, but...
        		if (slot.htAttribute != null)
        		{
        			// Clear the UMLAttributeSlot
        			slot.htAttribute = null;
        			main.ui.writeLog("Removed UML.Property for " + c1.getName() + " (History Tracking)");
        			Log.removal();
        		}
        	}
        }
	}
}
