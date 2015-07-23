package net.menthor.ontouml2infouml.impl;

import java.util.Map.Entry;

import net.menthor.ontouml2infouml.Onto2InfoMap;
import net.menthor.ontouml2infouml.decision.MeasurementDecision;
import net.menthor.ontouml2infouml.decision.UMLAttributeSlot;

/*

 TESTS:
 
 - Scope=true, HT=false
 - Scope=false, HT=false
 
- Scope=true, HT=false
- Scope=true, HT=true

- Scope=true, HT=true
- Scope=true, HT=false

- Scope=true, HT=true
- Scope=false

- HT=true, TT=true
- HT=true, TT=false 
 
 */

public class Measurement
{
	Transformation main;
	
	public Measurement (Transformation t)
	{
		this.main = t;
	}
	
	public void dealMeasurement ()
	{
		for (Entry<RefOntoUML.Class, MeasurementDecision> entry : main.dh.measurementMap.entrySet())
		{
			// Quality
			RefOntoUML.Quality q1 = (RefOntoUML.Quality) entry.getKey();
			// Characterized Universal
			RefOntoUML.Class c1 = (RefOntoUML.Class) q1.characterized();
			
			MeasurementDecision decision = entry.getValue();
			UMLAttributeSlot slot = main.dh.getAttributeSlot(q1);
			
			if (main.dh.inScope(c1))
			{
				// Characterized Universal inside the scope				
				if (main.dh.inScope(q1))
				{
					// Quality inside the scope
					qualityInScope(q1, c1, decision, slot);
				}
				else
				{
					// Quality outside the scope
					cIn_qOut(slot);
				}
			}
			else
			{
				// Characterized Universal outside the scope
				cOut(slot);
			}
		}
	}
	
	
	
	/* ------------------------------------ Measurement ------------------------------------ */
	
	private void qualityInScope (RefOntoUML.Quality q1, RefOntoUML.Class c1, MeasurementDecision decision, UMLAttributeSlot slot)
	{
		if (slot.measurementAttribute == null)
		{
			// Measurement attribute does NOT exist
			
			if (main.dh.getHTPastDecision(q1))
			{
				// History Tracking = true
				addHistoryTracking(q1, c1, decision, slot);
			}
			else
			{
				// History Tracking = false
				// Measurement attribute goes to the "Characterized Type"
				addAttributeToCharacterizedType(q1, c1, decision, slot);
			}
		}
		else
		{
			// Measurement attribute exists
			
			if (main.dh.getHTPastDecision(q1))
			{
				if (slot.measureType == null)
				{
					// from HT=false to HT=true
					removeAttributeFromCharacterizedType(slot);
				}
					
				addHistoryTracking(q1, c1, decision, slot);
			}
			else if (!main.dh.getHTPastDecision(q1))
			{
				if (slot.measureType != null)
				{
					// from HT=true to HT=false
					removeHistoryTracking(slot);
				}
								
				addAttributeToCharacterizedType(q1, c1, decision, slot);
			}
			else
			{
				// Check for changes in names or data types
				changesInAttribute(decision, slot);
			}
		}
	}
	
	private void changesInAttribute(MeasurementDecision decision, UMLAttributeSlot slot)
	{
		// Check if the attribute has changed
		org.eclipse.uml2.uml.Type type = main.umlAbstraction.getMeasurementType (decision);
		org.eclipse.uml2.uml.Type pastType = slot.measurementAttribute.getType();
							
		// If the past type was Custom
		if (main.umlAbstraction.isCustomType(pastType))
		{
			// Simply delete the past CustomType (even if CustomType is chosen again FIXME)
			main.umlAbstraction.removePackageableElement(slot.measurementAttribute.getType());
		}
			
		if (pastType != type)
		{
			// A change of type happened	
			// Update the type
			slot.measurementAttribute.setType(type);
			
			// TODO: display in the ui that a change happened
		}
	}
	
	private void addAttributeToCharacterizedType (RefOntoUML.Quality q1, RefOntoUML.Class c1, MeasurementDecision decision, UMLAttributeSlot slot)
	{
		slot.measurementAttribute = main.umlAbstraction.addMeasurementAttribute(q1, (org.eclipse.uml2.uml.Class) Onto2InfoMap.getElement(c1), decision);
		
		main.ui.writeLog("Created attribute for " + c1.getName() + ": " + slot.measurementAttribute.getName());
		Log.addition();
	}
	
	private void cIn_qOut (UMLAttributeSlot slot)
	{
		removeHistoryTracking(slot);
		removeAttributeFromCharacterizedType(slot);
	}
	
	private void removeAttributeFromCharacterizedType (UMLAttributeSlot slot)
	{
		if (slot.measurementAttribute != null)
		{
			// The "Characterized Type" remains...
				
			// Remove the measurement attribute from the "Characterized Type"
			main.ui.writeLog("Removed attribute from " + slot.measurementAttribute.getClass_().getName() + ": " + slot.measurementAttribute.getName());
			Log.removal();
			
			main.umlAbstraction.removeClassAttribute(slot.measurementAttribute);
						
			// Clear the UMLAttributeSlot
			slot.measurementAttribute = null;
		}
	}
	
	private void cOut (UMLAttributeSlot slot)
	{
		removeHistoryTracking(slot);
		
		if (slot.measurementAttribute != null)
		{			
			main.ui.writeLog("Removed attribute from " + slot.measurementAttribute.getClass_().getName() + ": " + slot.measurementAttribute.getName());
			Log.removal();
			
			// Clear the UMLAttributeSlot
			slot.measurementAttribute = null;
		}
	}
	
	
	
	/* ------------------------------------ History Tracking ------------------------------------ */
	
	private void addHistoryTracking(RefOntoUML.Quality q1, RefOntoUML.Class c1, MeasurementDecision decision, UMLAttributeSlot slot)
	{
		if (slot.measureType == null)
		{
			// create "Measure Type"
			slot.measureType = main.umlAbstraction.createMeasureType(q1.getName() + " Measure");
			
			main.ui.writeLog("Created " + slot.measureType.getName());
			Log.addition();
			
			// add the "Measurement Attribute" to the "Measure type"
			slot.measurementAttribute = main.umlAbstraction.addMeasurementAttribute(q1, slot.measureType, decision);
			
			main.ui.writeLog("Created attribute for " + slot.measureType.getName() + ": " + slot.measurementAttribute.getName());
			Log.addition();
			
			// create "Measure Association" (between the "Characterized Type" and the "Measure Type")
			main.umlAbstraction.createMeasureAssociation((org.eclipse.uml2.uml.Class)Onto2InfoMap.getElement(c1), slot.measureType);
		}
			
		if (main.dh.getStartTimeDecision(q1))
		{
			addTimeTracking(slot);
		}
		else
		{
			removeTimeTracking(slot);
		}
	}
	
	private void removeHistoryTracking (UMLAttributeSlot slot)
	{
		if (slot.measureType != null)
		{
			// Remove the "Time attribute"
			removeTimeTracking (slot);
			
			// Remove the "Measurement attribute"
			main.ui.writeLog("Removed attribute from " + slot.measureType.getName() + ": " + slot.measurementAttribute.getName());
			Log.removal();			
			main.umlAbstraction.removeClassAttribute(slot.measurementAttribute);						
			slot.measurementAttribute = null;
			
			// Remove the "Measure Association"
			main.umlAbstraction.removePackageableElement(slot.measureType.getAssociations().get(0));
			
			// Remove the "Measure Type"
			main.umlAbstraction.removePackageableElement(slot.measureType);
						
			main.ui.writeLog("Removed " + slot.measureType.getName());
			Log.removal();
			
			slot.measureType = null;
		}
	}
	
	
	
	/* ------------------------------------ Time Tracking ------------------------------------ */
	
	private void addTimeTracking(UMLAttributeSlot slot)
	{
		if (slot.startAttribute == null)
		{
			// create "Time Attribute"
			slot.startAttribute = main.umlAbstraction.addClassAttribute (slot.measureType, "time", main.umlAbstraction.timeType, true);
			
			main.ui.writeLog("Created attribute for " + slot.measureType.getName() + ": " + slot.startAttribute.getName());
			Log.addition();
		}
	}
	
	private void removeTimeTracking (UMLAttributeSlot slot)
	{
		if (slot.startAttribute != null)
		{
			// Remove the "Time attribute" from the "Measure Type"
			slot.startAttribute.getClass_().getOwnedAttributes().remove(slot.startAttribute);
			
			main.ui.writeLog("Removed attribute from " + slot.measureType.getName() + ": " + slot.startAttribute.getName());
			Log.removal();
			
			slot.startAttribute = null;
		}
	}
}
