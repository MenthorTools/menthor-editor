package net.menthor.ontouml2infouml.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.menthor.ontouml2infouml.Onto2InfoMap;
import net.menthor.ontouml2infouml.decision.Decision;
import net.menthor.ontouml2infouml.decision.DecisionHandler;
import net.menthor.ontouml2infouml.decision.HistoryDecision;
import net.menthor.ontouml2infouml.decision.MeasurementDecision;
import net.menthor.ontouml2infouml.decision.ReferenceDecision;
import net.menthor.ontouml2infouml.decision.ScopeDecision;
import net.menthor.ontouml2infouml.decision.TimeDecision;
import net.menthor.ontouml2infouml.decision.UMLAttributeSlot;
import net.menthor.ontouml2infouml.decision.UMLAttributeSlotString;
import net.menthor.ontouml2infouml.uml.UMLModelAbstraction;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class Serializer
{
	// Gets the UUID of an EObject, given its Resource
	public static String getUUID (Resource resource, EObject element)
	{
		return resource.getURIFragment(element);
		// Could have done: element.eResource().getURIFragment(element)
	}

	// Gets an EObject by UUID, given its Resource
	public static EObject getEObject (Resource resource, String uuid)
	{
		return resource.getEObject(uuid);
		// Could have done something like: model.eResource().getEObject(uuid)
	}
	
	


	
		
	// Saves the Maps for OntoUML->UML, OntoUML->Decisions and OntoUML->UMLAttributes
	public static void saveMap (Resource ontoumlResource, Resource umlResource, String fileName, DecisionHandler dh, UMLModelAbstraction umlAbstraction) throws IOException
	{
		SerializedContent content = new SerializedContent();
		
		// Converts the OntoUML<->UML Map into an ID<->ID Map
		content.idMap = convertOntoInfoMap (ontoumlResource, umlResource);
		
		// Converts the OntoUML<->Decision Map into an ID<->Decision Map
		content.scopeIdMap = convertDecisionMap (ontoumlResource, dh.scopeMap);
		content.historyIdMap = convertDecisionMap (ontoumlResource, dh.historyMap);
		content.timeIdMap = convertDecisionMap (ontoumlResource, dh.timeMap);
		content.referenceIdMap = convertDecisionMap (ontoumlResource, dh.referenceMap);
		content.measurementIdMap = convertDecisionMap (ontoumlResource, dh.measurementMap);
		
		// Converts the OntoUML<->UMLAttributeSlot Map into an ID<->UMLAttributeSlotString Map
		content.attributeIdMap = convertAttributeMap (ontoumlResource, umlResource, dh);
		
		content.timePrimitiveId = getUUID (umlResource, umlAbstraction.timeType);
		content.durationPrimitiveId = getUUID (umlResource, umlAbstraction.durationType);
		content.booleanPrimitiveId = getUUID (umlResource, umlAbstraction.booleanType);
		content.integerPrimitiveId = getUUID (umlResource, umlAbstraction.integerType);
		content.stringPrimitiveId = getUUID (umlResource, umlAbstraction.stringType);
		
		// Saves the fake Maps into a file
		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		fos = new FileOutputStream(fileName);
		out = new ObjectOutputStream(fos);
		out.writeObject(content);
		out.close();
	}
	
	public static Map<String, String> convertOntoInfoMap (Resource ontoumlResource, Resource umlResource)
	{
		Map<String, String> idMap = new HashMap<String, String>();
		
		for (Entry<RefOntoUML.Element, org.eclipse.uml2.uml.Element> entry : Onto2InfoMap.mymap.entrySet())
		{
			String ontoumlID = getUUID (ontoumlResource, entry.getKey());
			String umlID = getUUID (umlResource, entry.getValue());
			idMap.put(ontoumlID, umlID);
		}
		
		return idMap;
	}
	
	// Coverts a Map<OntoUML.Class, Decision> into a Map<String, Decision>
	// I'm using "Bounded Wildcards" in this method
	// http://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html
	private static Map<String, Decision> convertDecisionMap (Resource ontoumlResource, Map<RefOntoUML.Class, ? extends Decision> map)
	{
		Map<String, Decision> idMap = new HashMap<String, Decision>();
		
		for (Entry<RefOntoUML.Class, ? extends Decision> entry : map.entrySet())
		{
			String ontoumlID = getUUID (ontoumlResource, entry.getKey());
			idMap.put(ontoumlID, entry.getValue());
		}
		
		return idMap;
	}
	
	private static Map<String, UMLAttributeSlotString> convertAttributeMap (Resource ontoumlResource, Resource umlResource, DecisionHandler dh)
	{
		Map<String, UMLAttributeSlotString> idMap = new HashMap<String, UMLAttributeSlotString>();
		
		for (Entry<RefOntoUML.Class, UMLAttributeSlot> entry : dh.attributeMap.entrySet())
		{
			String ontoumlID = getUUID (ontoumlResource, entry.getKey());
			
			UMLAttributeSlot slot = entry.getValue();
			UMLAttributeSlotString stringSlot = new UMLAttributeSlotString();
			
			if (slot.startAttribute != null)
				stringSlot.startAttribute = getUUID (umlResource, slot.startAttribute);
			
			if (slot.endAttribute != null)
				stringSlot.endAttribute = getUUID (umlResource, slot.endAttribute);
			
			if (slot.durationAttribute != null)
				stringSlot.durationAttribute = getUUID (umlResource, slot.durationAttribute);
			
			if (slot.htAttribute != null)
				stringSlot.htAttribute = getUUID (umlResource, slot.htAttribute);
			
			if (slot.refAttribute != null)
				stringSlot.refAttribute = getUUID (umlResource, slot.refAttribute);
			
			if (slot.measurementAttribute != null)
				stringSlot.measurementAttribute = getUUID (umlResource, slot.measurementAttribute);
			
			if (slot.measureType != null)
				stringSlot.measureType = getUUID (umlResource, slot.measureType);
			
			idMap.put(ontoumlID, stringSlot);
		}
		
		return idMap;
	}
	
	
	
	

	
	
	// Loads the OntoUML[ID]<->UML[ID] Map from a file
	public static void loadMap (Resource ontoumlResource, Resource umlResource, String fileName, DecisionHandler dh, UMLModelAbstraction umlAbstraction)
	throws IOException, ClassNotFoundException
	{
		SerializedContent content;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		// Loads the ID <-> ID Map from file
		fis = new FileInputStream(fileName);
		in = new ObjectInputStream(fis);
		content = (SerializedContent) in.readObject();
		in.close();
		
		// Convert it to RefOntoUML.Element <-> UML.Element Map
		loadOntoInfoMap (ontoumlResource, umlResource, content.idMap);
		loadScopeMap(ontoumlResource, content.scopeIdMap, dh);
		loadHistoryMap(ontoumlResource, content.historyIdMap, dh);
		loadTimeMap(ontoumlResource, content.timeIdMap, dh);
		loadReferenceMap(ontoumlResource, content.referenceIdMap, dh);
		loadMeasurementMap(ontoumlResource, content.measurementIdMap, dh);
		loadAttributeMap(ontoumlResource, umlResource, content.attributeIdMap, dh);
		
		umlAbstraction.timeType = (org.eclipse.uml2.uml.DataType) getEObject(umlResource, content.timePrimitiveId);
		umlAbstraction.durationType = (org.eclipse.uml2.uml.DataType) getEObject(umlResource, content.durationPrimitiveId);
		umlAbstraction.booleanType = (org.eclipse.uml2.uml.PrimitiveType) getEObject(umlResource, content.booleanPrimitiveId);
		umlAbstraction.integerType = (org.eclipse.uml2.uml.PrimitiveType) getEObject(umlResource, content.integerPrimitiveId);
		umlAbstraction.stringType = (org.eclipse.uml2.uml.PrimitiveType) getEObject(umlResource, content.stringPrimitiveId);
	}
	
	public static void loadOntoInfoMap (Resource ontoumlResource, Resource umlResource, Map<String, String> idMap)
	{
		Onto2InfoMap.initializeMap();
		
		for (Entry<String, String> entry : idMap.entrySet())
		{
			RefOntoUML.Element ontoumlObj = (RefOntoUML.Element) getEObject (ontoumlResource, entry.getKey());
			org.eclipse.uml2.uml.Element umlObj = (org.eclipse.uml2.uml.Element) getEObject (umlResource, entry.getValue());
			Onto2InfoMap.mymap.put(ontoumlObj, umlObj);
		}
	}	
	
	private static void loadScopeMap (Resource ontoumlResource, Map<String, Decision> idMap, DecisionHandler dh)
	{
		dh.scopeMap = new HashMap<RefOntoUML.Class, ScopeDecision>();
		
		for (Entry<String, Decision> entry : idMap.entrySet())
		{
			RefOntoUML.Class ontoumlObj = (RefOntoUML.Class) getEObject (ontoumlResource, entry.getKey());
			dh.scopeMap.put(ontoumlObj, (ScopeDecision) entry.getValue());
		}
	}
	
	private static void loadHistoryMap (Resource ontoumlResource, Map<String, Decision> idMap, DecisionHandler dh)
	{
		dh.historyMap = new HashMap<RefOntoUML.Class, HistoryDecision>();
		
		for (Entry<String, Decision> entry : idMap.entrySet())
		{
			RefOntoUML.Class ontoumlObj = (RefOntoUML.Class) getEObject (ontoumlResource, entry.getKey());
			dh.historyMap.put(ontoumlObj, (HistoryDecision) entry.getValue());
		}
	}
	
	private static void loadTimeMap (Resource ontoumlResource, Map<String, Decision> idMap, DecisionHandler dh)
	{
		dh.timeMap = new HashMap<RefOntoUML.Class, TimeDecision>();
		
		for (Entry<String, Decision> entry : idMap.entrySet())
		{
			RefOntoUML.Class ontoumlObj = (RefOntoUML.Class) getEObject (ontoumlResource, entry.getKey());
			dh.timeMap.put(ontoumlObj, (TimeDecision) entry.getValue());
		}
	}
	
	private static void loadReferenceMap (Resource ontoumlResource, Map<String, Decision> idMap, DecisionHandler dh)
	{
		dh.referenceMap = new HashMap<RefOntoUML.Class, ReferenceDecision>();
		
		for (Entry<String, Decision> entry : idMap.entrySet())
		{
			RefOntoUML.Class ontoumlObj = (RefOntoUML.Class) getEObject (ontoumlResource, entry.getKey());
			dh.referenceMap.put(ontoumlObj, (ReferenceDecision) entry.getValue());
		}
	}
	
	private static void loadMeasurementMap (Resource ontoumlResource, Map<String, Decision> idMap, DecisionHandler dh)
	{
		dh.measurementMap = new HashMap<RefOntoUML.Class, MeasurementDecision>();
		
		for (Entry<String, Decision> entry : idMap.entrySet())
		{
			RefOntoUML.Class ontoumlObj = (RefOntoUML.Class) getEObject (ontoumlResource, entry.getKey());
			dh.measurementMap.put(ontoumlObj, (MeasurementDecision) entry.getValue());
		}
	}
	
	private static void loadAttributeMap (Resource ontoumlResource, Resource umlResource, Map<String, UMLAttributeSlotString> idMap, DecisionHandler dh)
	{
		dh.attributeMap = new HashMap<RefOntoUML.Class, UMLAttributeSlot>();
		
		for (Entry<String, UMLAttributeSlotString> entry : idMap.entrySet())
		{
			RefOntoUML.Class ontoumlObj = (RefOntoUML.Class) getEObject (ontoumlResource, entry.getKey());
			
			UMLAttributeSlotString stringSlot = entry.getValue();
			UMLAttributeSlot slot = new UMLAttributeSlot();
			
			if (stringSlot.startAttribute != null)
				slot.startAttribute = (org.eclipse.uml2.uml.Property) getEObject(umlResource, stringSlot.startAttribute);
			
			if (stringSlot.endAttribute != null)
				slot.endAttribute = (org.eclipse.uml2.uml.Property) getEObject(umlResource, stringSlot.endAttribute);
			
			if (stringSlot.durationAttribute != null)
				slot.durationAttribute = (org.eclipse.uml2.uml.Property) getEObject(umlResource, stringSlot.durationAttribute);
			
			if (stringSlot.htAttribute != null)
				slot.htAttribute = (org.eclipse.uml2.uml.Property) getEObject(umlResource, stringSlot.htAttribute);
			
			if (stringSlot.refAttribute != null)
				slot.refAttribute = (org.eclipse.uml2.uml.Property) getEObject(umlResource, stringSlot.refAttribute);
			
			if (stringSlot.measurementAttribute != null)
				slot.measurementAttribute = (org.eclipse.uml2.uml.Property) getEObject(umlResource, stringSlot.measurementAttribute);
			
			if (stringSlot.measureType != null)
				slot.measureType = (org.eclipse.uml2.uml.Class) getEObject(umlResource, stringSlot.measureType);
			
			dh.attributeMap.put(ontoumlObj, slot);
		}
	}	
}
