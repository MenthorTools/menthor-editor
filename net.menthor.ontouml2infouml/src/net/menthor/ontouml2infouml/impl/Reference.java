package net.menthor.ontouml2infouml.impl;

import java.util.Map.Entry;

import net.menthor.ontouml2infouml.decision.ReferenceDecision;
import net.menthor.ontouml2infouml.decision.UMLAttributeSlot;

public class Reference
{
	Transformation main;
	
	public Reference (Transformation t)
	{
		this.main = t;
	}
	
	public void dealReference ()
	{
		// Reference
		for (Entry<RefOntoUML.Class, ReferenceDecision> entry : main.dh.referenceMap.entrySet())
		{
			RefOntoUML.Class c1 = entry.getKey();
			ReferenceDecision decision = entry.getValue();
			UMLAttributeSlot slot = main.dh.getAttributeSlot(c1);
			
			if (main.dh.inScope(c1))
			{
				// Reference decision
				if (decision.reference)
				{
					// Reference = true
					if (slot.refAttribute == null)
					{
						// UML.Property (Attribute) does not exist
	        			slot.refAttribute = main.umlAbstraction.addReferenceAttribute(c1, decision);
	        			
	        			main.ui.writeLog("Created UML.Property for " + c1.getName() + ": " + slot.refAttribute.getName());
	        			Log.addition();
					}
					else
					{
						// UML.Property (Attribute) exists
						
						// Check if the attribute has changed
						org.eclipse.uml2.uml.Type type = main.umlAbstraction.getReferenceType (decision);
						org.eclipse.uml2.uml.Type pastType = slot.refAttribute.getType();
											
						// If the past type was Custom
						if (main.umlAbstraction.isCustomType(pastType))
						{
							// Simply delete the past CustomType (even if CustomType is chosen again FIXME)
							main.umlAbstraction.removePackageableElement(slot.refAttribute.getType());
						}
							
						if (pastType != type)
						{
							// A change of type happened	
							// Update the type
							slot.refAttribute.setType(type);
							
							// TODO: display in the ui that a change happened
						}
						
						// Update the attribute's name
						slot.refAttribute.setName(decision.attributeName);
					}
				}
				else
				{
					// Reference = false
					if (slot.refAttribute != null)
					{
	        			// UML.Property (Attribute) exists
	        			// Remove it from the UML.Class
	        			main.umlAbstraction.removeClassAttribute(c1, slot.refAttribute);
	        			// Remove it from the UMLAttributeSlot
	        			slot.refAttribute = null;
	        			
	        			main.ui.writeLog("Removed UML.Property for " + c1.getName() + " (Reference)");
	        			Log.removal();
					}
				}
			}
			else
			{
        		// OntoUML.Class out of scope
        		// UML.Class was already removed, but...
        		if (slot.refAttribute != null)
        		{
        			// Clear the UMLAttributeSlot
        			slot.refAttribute = null;
        			main.ui.writeLog("Removed UML.Property for " + c1.getName() + " (Reference)");
        			Log.removal();
        		}
			}
		}
	}
}
