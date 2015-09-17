package net.menthor.ontouml2infouml.impl;

import java.util.Map.Entry;

import net.menthor.ontouml2infouml.decision.TimeDecision;
import net.menthor.ontouml2infouml.decision.UMLAttributeSlot;

public class TimeTracking
{
	Transformation main;

	public TimeTracking (Transformation t)
	{
		this.main = t;
	}
	
	public void dealTimeTracking ()
	{		
        // Time Tracking
        for (Entry<RefOntoUML.Class, TimeDecision> entry : main.dh.timeMap.entrySet())
        {
        	if ((entry.getKey() instanceof RefOntoUML.Quality))
        		continue; // FIXME: Not dealing Qualities yet
        	
        	RefOntoUML.Class c1 = entry.getKey();
        	TimeDecision decision = entry.getValue();
        	UMLAttributeSlot slot = main.dh.getAttributeSlot(c1);

        	SlotManipulator startSM = new StartAttributeManipulator(slot);
        	SlotManipulator endSM = new EndAttributeManipulator(slot);
        	SlotManipulator durationSM = new DurationAttributeManipulator(slot);
        	
        	if (main.dh.inScope(c1))
        	{
        		// OntoUML.Class in scope
        		dealTimeAttribute (c1, decision.start, startSM);
        		dealTimeAttribute (c1, decision.end, endSM);
				dealTimeAttribute (c1, decision.duration, durationSM);
        	}
        	else
        	{
        		// OntoUML.Class out of scope
        		// UML.Class was already removed, but...
        		// One must clean the references in the UMLAttributeSlot
        		setSlotAttributeToNull (c1, startSM);
        		setSlotAttributeToNull (c1, endSM);
        		setSlotAttributeToNull (c1, durationSM);
        	}
        }
	}
	
	private void dealTimeAttribute (RefOntoUML.Class c1, boolean decision, SlotManipulator sm)
	{
		// StartTime
    	if (decision)
    	{
    		// Decision = true
    		if (sm.getSlotAttribute() == null)
    		{
    			// UML.Property (Attribute) does not exist
    			
    			// 1- Create a new time attribute (start, end or duration) for the UML.Class corresponding to c1
    			// 2- Set this new time attribute in the slot
    			sm.setSlotAttribute(sm.addTimeAttribute(c1));
    			
    			main.ui.writeLog("Created UML.Property for " + c1.getName() + " (" + sm.getSlotAttribute().getName() + ")");
    			Log.addition();
    		}
    	}
    	else
    	{
    		// Decision = false
    		if (sm.getSlotAttribute() != null)
    		{
    			// UML.Property (Attribute) exists
    			
    			// Remove it from the UML.Class
    			main.umlAbstraction.removeClassAttribute(c1, sm.getSlotAttribute());
    			
    			// The attribute must be removed from the Slot
    			setSlotAttributeToNull(c1, sm);
    		}
    	}
	}
	
	private void setSlotAttributeToNull (RefOntoUML.Class c1, SlotManipulator sm)
	{
		if (sm.getSlotAttribute() != null)
		{
			String attributeName = sm.getSlotAttribute().getName(); // Store the attribute name, before it becomes null (just for printing)
			// Set the attribute (start, end or duration) as null in the slot
			sm.setSlotAttribute(null);
			
			main.ui.writeLog("Removed UML.Property for " + c1.getName() + " (" + attributeName + ")");
			Log.removal();
		}
	}
	
	
	
	
	
	/* *************************** Internal Classes *************************** */
	
	interface SlotManipulator
	{
		public org.eclipse.uml2.uml.Property getSlotAttribute ();
		public void setSlotAttribute (org.eclipse.uml2.uml.Property p);
		public org.eclipse.uml2.uml.Property addTimeAttribute (RefOntoUML.Class c1);
	}
	
	class StartAttributeManipulator implements SlotManipulator
	{
		UMLAttributeSlot slot;
		
		public StartAttributeManipulator (UMLAttributeSlot slot)
		{
			this.slot = slot;
		}
		
		public org.eclipse.uml2.uml.Property getSlotAttribute ()
		{
			return slot.startAttribute;
		}
		
		public void setSlotAttribute (org.eclipse.uml2.uml.Property p)
		{
			slot.startAttribute = p;
		}
		
		public org.eclipse.uml2.uml.Property addTimeAttribute (RefOntoUML.Class c1)
		{
			return main.umlAbstraction.addStartTime(c1);
		}
	}
	
	class EndAttributeManipulator implements SlotManipulator
	{
		UMLAttributeSlot slot;
		
		public EndAttributeManipulator (UMLAttributeSlot slot)
		{
			this.slot = slot;
		}
		
		public org.eclipse.uml2.uml.Property getSlotAttribute ()
		{
			return slot.endAttribute;
		}
		
		public void setSlotAttribute (org.eclipse.uml2.uml.Property p)
		{
			slot.endAttribute = p;
		}
		
		public org.eclipse.uml2.uml.Property addTimeAttribute (RefOntoUML.Class c1)
		{
			return main.umlAbstraction.addEndTime(c1);
		}
	}
	
	class DurationAttributeManipulator implements SlotManipulator
	{
		UMLAttributeSlot slot;
		
		public DurationAttributeManipulator (UMLAttributeSlot slot)
		{
			this.slot = slot;
		}
		
		public org.eclipse.uml2.uml.Property getSlotAttribute ()
		{
			return slot.durationAttribute;
		}
		
		public void setSlotAttribute (org.eclipse.uml2.uml.Property p)
		{
			slot.durationAttribute = p;
		}
		
		public org.eclipse.uml2.uml.Property addTimeAttribute (RefOntoUML.Class c1)
		{
			return main.umlAbstraction.addDuration(c1);
		}
	}
	
	/* *************************** End *************************** */
}
