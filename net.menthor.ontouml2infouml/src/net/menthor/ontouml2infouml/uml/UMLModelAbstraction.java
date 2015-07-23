package net.menthor.ontouml2infouml.uml;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.menthor.ontouml2infouml.Onto2InfoMap;
import net.menthor.ontouml2infouml.decision.AttributeType;
import net.menthor.ontouml2infouml.decision.MeasurementDecision;
import net.menthor.ontouml2infouml.decision.ReferenceDecision;
import net.menthor.ontouml2infouml.impl.Log;
import net.menthor.ontouml2infouml.impl.Transformation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

public class UMLModelAbstraction
{
	// Ecore ResourceSet
	ResourceSet resourceSet;
	// Ecore Resource
	public Resource resource;
	// UML Model
	public org.eclipse.uml2.uml.Model umlmodel;
	
	// PrimitiveTypes
	public org.eclipse.uml2.uml.DataType timeType;
	public org.eclipse.uml2.uml.DataType durationType;
	public org.eclipse.uml2.uml.PrimitiveType booleanType;
	public org.eclipse.uml2.uml.PrimitiveType integerType;
	public org.eclipse.uml2.uml.PrimitiveType stringType;
		
	// UML Factory	
	org.eclipse.uml2.uml.UMLFactory myfactory;
	
	boolean hasFile;
	String fileName;
	
	public UMLModelAbstraction()
	{
		myfactory = org.eclipse.uml2.uml.UMLFactory.eINSTANCE;
		hasFile = false;
		fileName = null;
	}
	
	public void createPrimitiveTypes()
	{
		createTimeType();
		createDurationType();
		createBooleanType();
		createIntegerType();
		createStringType();
	}
	
	// Loads a UML.Model from a file
	public boolean load (String fileAbsolutePath)
	{
		// ResourceSet
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);	
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);

		// File handling
		fileName = fileAbsolutePath;
		File file = new File(fileName);
		if (!file.isFile())
		{
			hasFile = false;
			//System.out.println("The corresponding UML model does not exist: " + file.getAbsolutePath());
		}
		else
		{
			// URI
			URI uri = URI.createFileURI(file.getAbsolutePath());
			
			// Additional things that I'm not sure if I need them
			Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();
			uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), uri.appendSegment("libraries").appendSegment(""));
			uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), uri.appendSegment("metamodels").appendSegment(""));
			uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), uri.appendSegment("profiles").appendSegment(""));
			
			// Resource
			resource = resourceSet.getResource(uri, true);			
			EObject root = resource.getContents().get(0);
			
			if (root instanceof org.eclipse.uml2.uml.Model)
			{
				umlmodel = (org.eclipse.uml2.uml.Model) root;
				return true;
			}
			else
			{
				System.out.println("The root element is not a UML.Model");
			}
		}
		
		return false;
	}
	
	public void save () throws IOException
	{		
		if (!hasFile)
		{
			// Create file
			URI uri = URI.createFileURI(new File(fileName).getAbsolutePath());
			// Create Resource
			resource = resourceSet.createResource(uri);			
			// Put the UML.Model in the Resource
			resource.getContents().add(umlmodel);
		}
		
		resource.save(Collections.EMPTY_MAP);
	}
	
	// Saves the UML model into a file
	public static void saveUMLModel (org.eclipse.uml2.uml.Model umlmodel, String fileAbsolutePath)
	{
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		
		URI uri = URI.createFileURI(new File(fileAbsolutePath).getAbsolutePath());
		
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(umlmodel);
		try
		{
			resource.save(Collections.EMPTY_MAP);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Adds a UML.PackageableElement to the UML.Model
	public void addPackageableElement (org.eclipse.uml2.uml.PackageableElement pe)
	{
		umlmodel.getPackagedElements().add(pe);
	}
	
	public boolean hasPackageableElement (org.eclipse.uml2.uml.PackageableElement pe)
	{
		return umlmodel.getPackagedElements().contains(pe);
	}
	
	// Removes a UML.PackageableElement from the UML.Model
	public void removePackageableElement (org.eclipse.uml2.uml.PackageableElement pe)
	{
		umlmodel.getPackagedElements().remove(pe);
	}
	
	// Removes all UML.Generalizations from a UML.Classifier
	public void removeAllGeneralizations (org.eclipse.uml2.uml.Classifier c)
	{
		c.getGeneralizations().clear();
	}
		
	// The DataType that will be referred to by all time attributes
	private void createTimeType ()
	{
		timeType = createDataType("Time");
	}
		
	// The DataType that will be referred to by all duration attributes
	private void createDurationType ()
	{
		durationType = createDataType("Duration");
	}
		
	private void createBooleanType ()
	{
		booleanType = createPrimitiveType("Boolean");
	}
		
	private void createIntegerType ()
	{
		integerType = createPrimitiveType("Integer");
	}
	
	private void createStringType ()
	{
		stringType = createPrimitiveType("String");
	}
	
	public org.eclipse.uml2.uml.Property addStartTime (RefOntoUML.Class c1)
	{
		org.eclipse.uml2.uml.Class c2 = (org.eclipse.uml2.uml.Class) Onto2InfoMap.getElement(c1);
		return addClassAttribute (c2, "start", timeType, true);
	}
	
	public org.eclipse.uml2.uml.Property addEndTime (RefOntoUML.Class c1)
	{
		org.eclipse.uml2.uml.Class c2 = (org.eclipse.uml2.uml.Class) Onto2InfoMap.getElement(c1);
		return addClassAttribute (c2, "end", timeType, false);
	}
	
	public org.eclipse.uml2.uml.Property addDuration (RefOntoUML.Class c1)
	{
		org.eclipse.uml2.uml.Class c2 = (org.eclipse.uml2.uml.Class) Onto2InfoMap.getElement(c1);
		return addClassAttribute (c2, "duration", durationType, true);
	}
	
	public org.eclipse.uml2.uml.Property addHistoryTrackingAttribute (RefOntoUML.Class c1)
	{
		org.eclipse.uml2.uml.Class c2 = (org.eclipse.uml2.uml.Class) Onto2InfoMap.getElement(c1);
		return addClassAttribute (c2, "current", booleanType, true);
	}
	
	public org.eclipse.uml2.uml.Property addReferenceAttribute (RefOntoUML.Class c1, ReferenceDecision decision)
	{
		org.eclipse.uml2.uml.Type type = getReferenceType(decision);
	
		org.eclipse.uml2.uml.Class c2 = (org.eclipse.uml2.uml.Class) Onto2InfoMap.getElement(c1);
		return addClassAttribute (c2, decision.attributeName, type, true);
	}
	
	public org.eclipse.uml2.uml.Type getReferenceType (ReferenceDecision decision)
	{
		org.eclipse.uml2.uml.Type type = null;
		
		if (decision.attributeType == AttributeType.INT)
		{
			type = integerType;
		}
		else if (decision.attributeType == AttributeType.STRING)
		{
			type = stringType;
		}
		else if (decision.attributeType == AttributeType.CUSTOM)
		{
			type = createDataType(decision.typeName);
			addPackageableElement(type);
		}
		
		return type;
	}
	
	public boolean isCustomType (org.eclipse.uml2.uml.Type type)
	{
		return type != integerType && type != stringType;	
	}
	
	public org.eclipse.uml2.uml.Property addMeasurementAttribute (RefOntoUML.Quality q1, org.eclipse.uml2.uml.Class c2, MeasurementDecision decision)
	{
		org.eclipse.uml2.uml.Type type = getMeasurementType(decision);
		return addClassAttribute (c2, q1.getName().toLowerCase(), type, true);
	}
		
	public org.eclipse.uml2.uml.Type getMeasurementType (MeasurementDecision decision)
	{
		org.eclipse.uml2.uml.Type type = null;
		
		if (decision.attributeType == AttributeType.INT)
		{
			type = integerType;
		}
		else if (decision.attributeType == AttributeType.STRING)
		{
			type = stringType;
		}
		else if (decision.attributeType == AttributeType.CUSTOM)
		{
			type = createDataType(decision.typeName);
			addPackageableElement(type);
		}
		
		return type;
	}
	
	// TODO: This method may be modularized
	public void addPrimitiveTypes (Transformation t)
	{
        // Time DataType
		if (!hasPackageableElement(timeType))
		{
			addPackageableElement(timeType);
			t.ui.writeLog("Created UML.DataType: " + timeType.getName());
			Log.addition();
		}
		
        // Duration DataType
		if (!hasPackageableElement(durationType))
		{
			addPackageableElement(durationType);
			t.ui.writeLog("Created UML.DataType: " + durationType.getName());
			Log.addition();
		}
		
        // Boolean PrimitiveType
		if (!hasPackageableElement(booleanType))
		{
			addPackageableElement(booleanType);
			t.ui.writeLog("Created UML.PrimitiveType: " + booleanType.getName());
			Log.addition();
		}
		
		// Integer PrimitiveType
		if (!hasPackageableElement(integerType))
		{
			addPackageableElement(integerType);
			t.ui.writeLog("Created UML.PrimitiveType: " + integerType.getName());
			Log.addition();
		}
		
		// String PrimitiveType
		if (!hasPackageableElement(stringType))
		{
			addPackageableElement(stringType);
			t.ui.writeLog("Created UML.PrimitiveType: " + stringType.getName());
			Log.addition();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* TODO: I think those methods should be in another class... 
	 * They do not refer specifically to the target UML model, but rather to UML convenience methods (perhaps, "fa" class is more appropriate) 
	 */
	
		
	// Set the basic attributes of DataType
	private void initializeClassifier (org.eclipse.uml2.uml.Classifier dataType, String name)
	{
		// visibility (Element)
		dataType.setVisibility(org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL);
		// name (NamedElement)
		dataType.setName(name);
		// isAbstract (Classifier)
		dataType.setIsAbstract(false);
	}
	
	private void initializeProperty (org.eclipse.uml2.uml.Property p, String name, org.eclipse.uml2.uml.Type type, int lower, int upper)
	{
		// name (NamedElement)
		p.setName(name);
		// isLeaf (RedefinableElement)
		p.setIsLeaf(true);
		// isStatic (Feature)
		p.setIsStatic(false);
		// isReadOnly (StructuralFeature)
		p.setIsReadOnly(false);

		// lower, upper (MultiplicityElement)            
		org.eclipse.uml2.uml.LiteralInteger lowerValue = myfactory.createLiteralInteger();
		org.eclipse.uml2.uml.LiteralUnlimitedNatural upperValue = myfactory.createLiteralUnlimitedNatural();
		lowerValue.setValue(lower);
		upperValue.setValue(upper);   
		p.setLowerValue(lowerValue);
		p.setUpperValue(upperValue);

		// Type (TypedElement)
		p.setType(type);

		// isDerived (Property)
		p.setIsDerived(false);        
		// aggregation (Property)
		p.setAggregation(org.eclipse.uml2.uml.AggregationKind.NONE_LITERAL);
	}
	
	private org.eclipse.uml2.uml.DataType createDataType (String name)
	{
		org.eclipse.uml2.uml.DataType dt = myfactory.createDataType();
		initializeClassifier (dt, name);
		return dt;
	}
	
	private org.eclipse.uml2.uml.PrimitiveType createPrimitiveType (String name)
	{
		org.eclipse.uml2.uml.PrimitiveType pt = myfactory.createPrimitiveType();
		initializeClassifier (pt, name);
		return pt;
	}
	
	public org.eclipse.uml2.uml.Class createMeasureType (String name)
	{
		org.eclipse.uml2.uml.Class measureType = myfactory.createClass();
		initializeClassifier (measureType, name);
		
		addPackageableElement(measureType);
		
		return measureType;
	}
	
	public void createMeasureAssociation (org.eclipse.uml2.uml.Class characterizedType, org.eclipse.uml2.uml.Class measureType)
	{
		// "Characterized Type" end
		org.eclipse.uml2.uml.Property characterizedEnd = myfactory.createProperty();
		initializeProperty(characterizedEnd, "", characterizedType, 1, 1);
		
		// "Measure Type" end
		org.eclipse.uml2.uml.Property measureEnd = myfactory.createProperty();
		initializeProperty(measureEnd, "", measureType, 1, -1);
		
		// Association
		org.eclipse.uml2.uml.Association measureAssociation = myfactory.createAssociation();
		initializeClassifier (measureAssociation, "");
		measureAssociation.getOwnedEnds().add(characterizedEnd);
		measureAssociation.getOwnedEnds().add(measureEnd);
		
		addPackageableElement(measureAssociation);
	}
	
	public org.eclipse.uml2.uml.Property addClassAttribute (org.eclipse.uml2.uml.Class c2, String name, org.eclipse.uml2.uml.Type type, boolean isRequired)
	{		
		org.eclipse.uml2.uml.Property p = myfactory.createProperty();
		
		initializeProperty(p, name, type, isRequired ? 1 : 0, 1);
		
		// Linking Class and Property
		c2.getOwnedAttributes().add(p);
		
		return p;
	}
	
	public void removeClassAttribute (RefOntoUML.Class c1, org.eclipse.uml2.uml.Property p)
	{
		org.eclipse.uml2.uml.Class c2 = (org.eclipse.uml2.uml.Class) Onto2InfoMap.getElement(c1);
		c2.getOwnedAttributes().remove(p);
	}
	
	public void removeClassAttribute (org.eclipse.uml2.uml.Property p)
	{
		p.getClass_().getOwnedAttributes().remove(p);
	}
	
	// Return a UML.Generalization between two UML.Classifiers, if it exists
	public org.eclipse.uml2.uml.Generalization getGeneralization (org.eclipse.uml2.uml.Classifier specific, org.eclipse.uml2.uml.Classifier general)
	{
		for (org.eclipse.uml2.uml.Generalization gen : specific.getGeneralizations())
		{
			if (gen.getGeneral() == general)
			{
				return gen;
			}
		}
		
		return null;
	}
	
	public void removeGeneralization (org.eclipse.uml2.uml.Classifier specific2, org.eclipse.uml2.uml.Generalization gen2)
	{
		specific2.getGeneralizations().remove(gen2);
	}
	
	// Created from scratch, no mapping
	public org.eclipse.uml2.uml.Generalization createGeneralization (org.eclipse.uml2.uml.Classifier specific, org.eclipse.uml2.uml.Classifier general)
	{
		org.eclipse.uml2.uml.Generalization gen = myfactory.createGeneralization();
		
		// specific
		gen.setSpecific(specific);
		specific.getGeneralizations().add(gen);		
		// general
		gen.setGeneral(general);

		return gen;
	}
	
	// Created from scratch, no mapping (for RoleMixin generalization only)
	public org.eclipse.uml2.uml.GeneralizationSet createGeneralizationSetForRoleMixin (RefOntoUML.RoleMixin roleMixin, List<org.eclipse.uml2.uml.Generalization> genlist)
	{
		org.eclipse.uml2.uml.GeneralizationSet gset = myfactory.createGeneralizationSet();
		
		// name
		gset.setName("");
		// visibility
		gset.setVisibility(org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL);
		// isDisjoint
		gset.setIsDisjoint(true);
		// isCovering (not always, only when all rigidSortals are in scope)
		gset.setIsCovering(genlist.size() == roleMixin.rigidSortals().size());
		
		// Linking the GeneralizationSet and the Generalizations
		for (org.eclipse.uml2.uml.Generalization gen : genlist)
		{
			gset.getGeneralizations().add(gen);
			gen.getGeneralizationSets().add(gset);
		}
		
		return gset;
	}
	
	public String generalizationSetToString (org.eclipse.uml2.uml.GeneralizationSet gset2)
	{
		// GeneralizationSet.general.name
		String name = gset2.getGeneralizations().get(0).getGeneral().getName();
		
		name += " {";
		
		// GeneralizationSet.specific.name
		for (org.eclipse.uml2.uml.Generalization gen2 : gset2.getGeneralizations())
		{
			name += gen2.getSpecific().getName();
			name += ", ";
		}
		
		name = name.substring(0, name.length()-2);
		name += "}";

		return name;
	}
	
	public String associationToString (org.eclipse.uml2.uml.Association a2)
	{
		org.eclipse.uml2.uml.Property memberEnd1 = a2.getMemberEnds().get(0);
		org.eclipse.uml2.uml.Property memberEnd2 = a2.getMemberEnds().get(1);
		String name = "";	
		
		// MemberEnd1
		name += memberEnd1.getType().getName();
		if (memberEnd1.getName().length() > 0)
		{
			name += " (" + memberEnd1.getName() + ")";
		}
		
		name += " <-> ";
		
		// MemberEnd2
		name += memberEnd2.getType().getName();
		if (memberEnd2.getName().length() > 0)
		{
			name += " (" + memberEnd2.getName() + ")";
		}
		
		return name; 
	}
}
