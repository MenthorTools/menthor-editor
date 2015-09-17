package net.menthor.ontouml2infouml.decision;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.menthor.ontouml2infouml.ui.content.HistoryTimeModel;
import net.menthor.ontouml2infouml.ui.content.ReferenceModel;
import RefOntoUML.util.RefOntoUMLModelAbstraction;

public class DecisionHandler
{
	public Map<RefOntoUML.Class, ScopeDecision> scopeMap;
	public Map<RefOntoUML.Class, HistoryDecision> historyMap;
	public Map<RefOntoUML.Class, TimeDecision> timeMap;
	public Map<RefOntoUML.Class, ReferenceDecision> referenceMap;
	public Map<RefOntoUML.Class, MeasurementDecision> measurementMap;
	
	public Map<RefOntoUML.Class, UMLAttributeSlot> attributeMap;
	
	public DecisionHandler(RefOntoUMLModelAbstraction ma)
	{
    	scopeMap = new HashMap<RefOntoUML.Class, ScopeDecision>();
    	historyMap = new HashMap<RefOntoUML.Class, HistoryDecision>();
    	timeMap = new HashMap<RefOntoUML.Class, TimeDecision>();
    	referenceMap = new HashMap<RefOntoUML.Class, ReferenceDecision>();
    	measurementMap = new HashMap<RefOntoUML.Class, MeasurementDecision>();
    	attributeMap = new HashMap<RefOntoUML.Class, UMLAttributeSlot>();
    	initializeDecisions(ma);
	}
	
	private void initializeDecisions (RefOntoUMLModelAbstraction ontoAbstraction)
	{
		for (RefOntoUML.Class c : ontoAbstraction.classes)
		{
			// Scope Decisions (OntoUML.Class)
			scopeMap.put(c, new ScopeDecision());
			
			// UML Attributes (History, Time, Reference, Measurement)
			attributeMap.put(c, new UMLAttributeSlot());
		}
		
		// History and Time Tracking Decisions
		HistoryTimeModel htModel = new HistoryTimeModel(ontoAbstraction);
		// Qualities are shown in their own panel, so they are not in HistoryTimeModel 
		htModel.model.addAll(ontoAbstraction.qualities);
		for (RefOntoUML.Class c : htModel.model)
		{
			historyMap.put(c, new HistoryDecision());
			timeMap.put(c, new TimeDecision());
		}
		
		// Reference Decisions
		ReferenceModel refModel = new ReferenceModel(ontoAbstraction);
		for (RefOntoUML.Class c : refModel.model)
		{
			referenceMap.put(c, new ReferenceDecision());
		}
		
		// Measurement Decisions
		for (RefOntoUML.Class c : ontoAbstraction.qualities)
		{
			measurementMap.put(c, new MeasurementDecision(c.getName()));
		}
	}
		
	public boolean inScope(RefOntoUML.Classifier c)
	{
		return scopeMap.get(c).scope;
	}
	
	public void setScopeDecision (Object o, boolean value)
	{
		//System.out.println("setting scope to " + value + " -> " + o);
		scopeMap.get(o).scope = value;
	}
	
	public void setStartTimeDecision (RefOntoUML.Class c, boolean value)
	{
		//System.out.println("setting -> " + c.getName() +  " -> " + value);
		timeMap.get(c).start = value;
	}
	
	public boolean getStartTimeDecision (RefOntoUML.Class c)
	{
		return timeMap.get(c).start;
	}
	
	public void setEndTimeDecision (RefOntoUML.Class c, boolean value)
	{
		//System.out.println("setting -> " + c.getName() +  " -> " + value);
		timeMap.get(c).end = value;
	}
	
	public boolean getEndTimeDecision (RefOntoUML.Class c)
	{
		return timeMap.get(c).end;
	}
	
	public void setDurationDecision (RefOntoUML.Class c, boolean value)
	{
		//System.out.println("setting -> " + c.getName() +  " -> " + value);
		timeMap.get(c).duration = value;
	}
	
	public boolean getDurationDecision (RefOntoUML.Class c)
	{
		return timeMap.get(c).duration;
	}

	public void setHTPastDecision (RefOntoUML.Class c, boolean value)
	{
		//System.out.println("HT: past: setting -> " + c.getName() +  " -> " + value);
		historyMap.get(c).past = value;
	}
	
	public boolean getHTPastDecision (RefOntoUML.Class c)
	{
		return historyMap.get(c).past;
	}
	
	public void setHTPresentDecision (RefOntoUML.Class c, boolean value)
	{
		//System.out.println("HT: present: setting -> " + c.getName() +  " -> " + value);
		historyMap.get(c).present = value;
	}
	
	public boolean getHTPresentDecision (RefOntoUML.Class c)
	{
		return historyMap.get(c).present;
	}
	
	
	
	
	
	/* Reference */	
	
	public boolean getReferenceDecision (RefOntoUML.Class c)
	{
		return referenceMap.get(c).reference;
	}
	
	public String getReferenceAttributeName (RefOntoUML.Class c)
	{
		return referenceMap.get(c).attributeName;
	}
	
	public AttributeType getReferenceAttributeType (RefOntoUML.Class c)
	{
		return referenceMap.get(c).attributeType;
	}
	
	public String getReferenceTypeName (RefOntoUML.Class c)
	{
		return referenceMap.get(c).typeName;
	}
	
	public void setReferenceDecision (Object o, boolean value)
	{
		//System.out.println("setting reference to " + value + " -> " + o);
		referenceMap.get(o).reference = value;
	}
	
	public void setReferenceAttributeName (Object o, String attributeName)
	{
		referenceMap.get(o).attributeName = attributeName;
	}
	
	public void setReferenceAttributeType (Object o, AttributeType attributeType)
	{
		referenceMap.get(o).setAttributeType(attributeType, ((RefOntoUML.Class)o).getName());
	}
	
	public void setReferenceTypeName (Object o, String typeName)
	{
		referenceMap.get(o).typeName = typeName;
	}
	
	
	
	
	
	/* Measurement */	
	
	public AttributeType getMeasurementAttributeType (RefOntoUML.Class c)
	{
		return measurementMap.get(c).attributeType;
	}
	
	public String getMeasurementTypeName (RefOntoUML.Class c)
	{
		return measurementMap.get(c).typeName;
	}	
	
	public void setMeasurementAttributeType (Object o, AttributeType attributeType)
	{
		measurementMap.get(o).attributeType = attributeType;
	}
	
	public void setMeasurementTypeName (Object o, String typeName)
	{
		measurementMap.get(o).typeName = typeName;
	}
	
	public UMLAttributeSlot getAttributeSlot (RefOntoUML.Class c)
	{
		return attributeMap.get(c);
	}
		
	public void printTimeDecisions ()
	{
		for (Entry<RefOntoUML.Class, TimeDecision> e : timeMap.entrySet())
		{
			System.out.println(
					e.getKey().getName() +
					" " + e.getValue().start +
					" " + e.getValue().end +
					" " + e.getValue().duration);
		}
	}
	
	public void printScopeDecisions ()
	{
		for (Entry<RefOntoUML.Class, ScopeDecision> e : scopeMap.entrySet())
		{
			System.out.println(
					e.getKey().getName() +
					" " + e.getValue().scope);
		}
	}
}
