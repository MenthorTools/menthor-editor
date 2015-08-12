package net.menthor.editor.ui;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import net.menthor.editor.v2.util.MenthorResourceFactoryImpl;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.Property;
import RefOntoUML.RefOntoUMLFactory;
import RefOntoUML.Relationship;
import RefOntoUML.impl.DataTypeImpl;
import RefOntoUML.impl.NamedElementImpl;
import RefOntoUML.impl.RefOntoUMLPackageImpl;
import RefOntoUML.parser.OntoUMLNameHelper;

/**
 * @author John Guerson
 */
public class ModelHelper {

//	private static Diagnostician validator;
	private static ResourceSet resourceSet;
	private static RefOntoUMLFactory factory;
	private static ComposedAdapterFactory adapterFactory; // TODO Cleanup
	private static AdapterFactoryEditingDomain editingDomain; // TODO Cleanup
	private static boolean initialized = false;
	
	private static HashMap<Element,ArrayList<DiagramElement>> mappings;

	private ModelHelper() {
	}
	
	public static Resource createResource() {
		if (!initialized) {
			initializeHelper();
		}
		Resource resource = resourceSet.createResource(URI.createFileURI(""));
		
		return resource;
	}
	
	public static void initializeHelper() {
		try{
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new MenthorResourceFactoryImpl());

		resourceSet.getPackageRegistry().put(RefOntoUML.RefOntoUMLPackage.eNS_URI, RefOntoUML.RefOntoUMLPackage.eINSTANCE);
		
		RefOntoUMLPackageImpl.init();
		
		
//		validator = Diagnostician.INSTANCE;
		
		factory = RefOntoUMLFactory.eINSTANCE;
		adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
//		adapterFactory
//				.addAdapterFactory(new RefOntoUMLItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// As the first validation takes long due to initialization process,
		// we start it here so the user doesn't get the initialization hit
		//validator.validate(factory.createClass());
		
		//validator2 = RefOntoUMLValidator.INSTANCE;
		
		mappings = new HashMap<Element, ArrayList<DiagramElement>>();
		
		initialized = true;
		} catch(Exception e ){
			e.printStackTrace();
		}
	}
	
	//Adds mapping from RefOntoUMLElement to DiagramElement (metamodel->concretemodel)
	//Returns true if the element was successfully added;
	public static boolean addMapping (Element element, DiagramElement diagramElement)
	{
		if (!initialized) initializeHelper();
		
		if (element==null || diagramElement==null) return false;
		
		if(mappings.get(element)==null)
		{
			ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
			list.add(diagramElement);
//			System.out.println("Add #0 to Map = "+diagramElement);
			mappings.put(element, list);
			return true;
			
		}else if(mappings.get(element)!=null)
		{
			if(!mappings.get(element).contains(diagramElement))
			{
//				System.out.println("Add #"+mappings.get(element).size()+" to Map = "+diagramElement);
				mappings.get(element).add(diagramElement);
				return true;
			}			
		}
		return false;
	}
	
	public static boolean removeMapping(DiagramElement diagramElem)
	{	
		if (!initialized) initializeHelper();
		
		RefOntoUML.Element element = getElement(diagramElem);
		if (element==null) return false;
		
		if(element!=null)
		{
			if(mappings.get(element).indexOf(diagramElem)!=-1){
//				System.out.println("Remove #"+mappings.get(element).indexOf(diagramElem)+" to Map = "+diagramElem);
				mappings.get(element).remove(diagramElem);	
				return true;
			}
			
			if (mappings.get(element).size()==0)
			{
				System.err.println("Trying to remove the diagram element {"+diagramElem+"} of the Map but the list is empty. We then will remove that entry.");
				mappings.remove(element);
				return false;
			}			
		}		
		
		return false;
	}
	
	/** For test */
	public static void printMap()
	{
		for(RefOntoUML.Element e: mappings.keySet())
		{	
			System.out.println("refonto = "+e);
			for(DiagramElement de: mappings.get(e)){
				System.out.println("diagram = "+de);
			}
			System.out.println("======================");
		}
	}
	
	public static boolean addMapping (StructureDiagram diagram)
	{
		boolean succeeds=false;
		for(DiagramElement dElem: diagram.getChildren())
		{
			if (dElem instanceof ClassElement) {
				ModelHelper.addMapping(((ClassElement)dElem).getClassifier(), dElem);
				succeeds=true;
			}
			if (dElem instanceof AssociationElement) {
				ModelHelper.addMapping(((AssociationElement)dElem).getRelationship(), dElem);
				succeeds=true;
			}
			if (dElem instanceof GeneralizationElement) {
				ModelHelper.addMapping(((GeneralizationElement)dElem).getRelationship(), dElem);
				succeeds=true;
			}
		}
		return succeeds;
	}
	
//	public static boolean removeMapping(Element element)
//	{
//		ArrayList<DiagramElement> result;
//		if (!initialized) initializeHelper();		
//		if (element==null) return false;				
//		result = mappings.remove(element);		
//		if (result!=null) return true;
//		else return false;
//	}
//	
	/**
	 * If the element is not found in diagram "editor", the method searches for its diagram element without an editor attached to it.
	 * We need that because the diagram element might be created without a diagram in the first place.
	 * 
	 */
	public static DiagramElement getDiagramElementByEditor (Element element, DiagramEditor editor){
		
		if (!initialized) initializeHelper();
		
		if(mappings.get(element)==null) return null;
		
		ArrayList<DiagramElement> found = new ArrayList<DiagramElement>();		
		if(mappings.get(element)!=null && mappings.get(element).size()>0)
		{			
			if(editor!=null){
				for(DiagramElement de: mappings.get(element))
				{					
					if (editor.getDiagram().getChildren().contains(de)) { found.add(de); }				
				}
			}
		}	

		if(found.size()>1)
		{
			System.err.println("The model instance {"+element+"} has 2 diagram elements for the same diagram editor.");
			return null;
		}
		if(found.size()==0)
		{		
			for(DiagramElement de: mappings.get(element))
			{
				boolean attachedToDiagram=false;
				for(DiagramEditor d: ProjectBrowser.frame.getDiagramManager().getDiagramEditors()){
					if(d.getDiagram().getChildren().contains(de)) attachedToDiagram =true;
				}	
				if (!attachedToDiagram) return de;
			}						
			return null;
			
		}else{			
			return found.get(0);
		}	
	}
	
	public static ArrayList<DiagramElement> getDiagramElements (Element element){
		
		if (!initialized) initializeHelper();
		
		if(mappings.get(element)!=null) return mappings.get(element);
		
		return new ArrayList<DiagramElement>();

	}

//	public static HashMap<Element,ArrayList<DiagramElement>> getMapping()
//	{
//		return mappings;
//	}
	
    public static RefOntoUML.Element getElement(DiagramElement value) 
    {    	
        for (Entry<RefOntoUML.Element,ArrayList<DiagramElement>> entry : mappings.entrySet()) 
        {
            if (entry.getValue().contains(value)) 
            {
                return entry.getKey();
            }
        }
        return null;
    }	    
	    
    public static List<EObject> getElements(StructureDiagram diagram)
	{
		ArrayList<EObject> elements = new ArrayList<EObject>();
		for(DiagramElement de: diagram.getChildren()){
			if(de instanceof ClassElement) {
				Classifier c = ((ClassElement)de).getClassifier();
				elements.add(c);
				if(c instanceof RefOntoUML.Class) {
					for(Property attr: ((RefOntoUML.Class)c).getOwnedAttribute()) {
						elements.add(attr);
						if(!elements.contains(attr.getType())) elements.add(attr.getType());
					}
				}
				if(c instanceof RefOntoUML.DataType) {
					for(Property attr: ((RefOntoUML.DataType)c).getOwnedAttribute()) {
						elements.add(attr);
						if(!elements.contains(attr.getType())) elements.add(attr.getType());
					}
				}
			}
			if(de instanceof AssociationElement) { 
				Association r = (Association)((AssociationElement)de).getRelationship();
				elements.add(r.getMemberEnd().get(0));
				elements.add(r.getMemberEnd().get(1));
				elements.add(r);								
			}
			if(de instanceof GeneralizationElement) {
				Relationship rel = ((GeneralizationElement)de).getRelationship();
				elements.add(rel);
				elements.addAll(((Generalization)rel).getGeneralizationSet());				 
			}
		}	
		return elements;
	}
    
	public static Collection<DiagramElement> getDiagramElements(Collection<Element> elements)
	{
		ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();		
		for(Element elem: elements){
			ArrayList<DiagramElement> dElem =mappings.get(elem);
			if(dElem!=null) list.addAll(dElem);
		}
		return list;
	}	
 
	public static Collection<DiagramElement> getDiagramElementsByEditor(Collection<Element> elements, DiagramEditor editor)
	{		
		if(editor==null) return new ArrayList<DiagramElement>();
		return getDiagramElementsByDiagram(elements, editor.getDiagram());
	}	
	
	public static Collection<DiagramElement> getDiagramElementsByDiagram(Collection<Element> elements, StructureDiagram diagram)
	{
		ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();		
		for(Element elem: elements){
			ArrayList<DiagramElement> dElem = mappings.get(elem);
			if(dElem!=null){
				for(DiagramElement de: dElem){
					if (diagram.containsChild(de)) list.add(de);
				}
			}
		}
		return list;
	}
	
	public static Collection<Element> getElements(Collection<DiagramElement> diagramElements)
	{
		ArrayList<Element> list = new ArrayList<Element>();		
		for(DiagramElement e: diagramElements){
			Element elem = getElement(e);
			if(elem!=null) list.add(elem);
		}
		return list;
	}
	
	public static Collection<DiagramElement> getAllDiagramElements()
	{
		ArrayList<DiagramElement> result = new ArrayList<DiagramElement>();	
		for(ArrayList<DiagramElement> l: mappings.values()){
			result.addAll(l);
		}
		return result;
	}
	
	public static String getAllDiagramElementsString()
	{
		String result = new String("Diagram Elements:");
		for(DiagramElement elem: getAllDiagramElements()){
			result += elem.toString()+"\n";
		}
		return result;
	}
	
	public static RefOntoUMLFactory getFactory() {
		if (!initialized) {
			initializeHelper();
		}
		return factory;
	}

	public AdapterFactoryEditingDomain getEditingDomain() {
		if(editingDomain == null)
			editingDomain = ModelHelper.createAdapterEditingDomain();
		return editingDomain;
	}
	
	public static AdapterFactoryEditingDomain createAdapterEditingDomain() {
		if (!initialized) {
			initializeHelper();
		}
		
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				new BasicCommandStack(), resourceSet);
		
		return editingDomain;
	}
	
	public static String getUUIDFromElement(Element element)
	{
		return element.eResource().getURIFragment(element);
	}
	
	public static Element getElementByUUID(RefOntoUML.Package model, String uuid)
	{
		return (Element) model.eResource().getEObject(uuid);
	}
	
	/**
	 * Handles the objects name when showing the error message
	 */
	public static String handleName(Object element)
	{
		String name = "[unnamed]";
		if(element instanceof NamedElementImpl)
		{
			NamedElementImpl namedElement = (NamedElementImpl) element;
			if (namedElement.getName() != null)
				name = namedElement.getName();
		}
		
		return OntoUMLNameHelper.getTypeName((EObject) element,true)+" "+name;
	}
	
	public static String getClassAsStereotype(EObject eObject) {
		String ret = eObject.eClass().getName().toLowerCase()
				.replace("association", "");
		return "\u00AB"+ret+"\u00BB";
	}
	
	public static List<DataType> getModelDataTypes(UmlProject project) {
		List<DataType> dataTypes = new LinkedList<DataType>();
		Iterator<?> it = project.getModel().getPackagedElement().iterator();
		while (it.hasNext())
		{
			Object element = it.next();
			if(element instanceof DataTypeImpl)
				dataTypes.add((DataType) element);
		}
		return dataTypes;
	}
	
	public static ChangeRecorder getChangeRecorder()
	{
		if (!initialized) {
			initializeHelper();
		}
		return new ChangeRecorder(resourceSet);
	}
}
