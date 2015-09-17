package net.menthor.ootos.util;

import java.util.HashMap;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import RefOntoUML.Association;
import RefOntoUML.Class;
import RefOntoUML.NamedElement;
import RefOntoUML.Property;
import RefOntoUML.impl.PropertyImpl;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.common.settings.owl.OWL2Axiom;
import net.menthor.common.settings.owl.OwlAxioms;
import net.menthor.common.settings.owl.OwlOptions;

/**
 * Generate and store the mapping of OntoUML properties to OWL properties.
 * 
 * @author Freddy Brasileiro
 *
 */
public class MappingElements {
	private OntoUMLParser ontoParser;
	private HashMap<String, MappedElement> elementByAlias = new HashMap<String, MappedElement>();
	private HashMap<String, MappedElement> elementByName = new HashMap<String, MappedElement>();
	private String outputMessages = "";
	private OwlOptions owlOptions;
	
	/**
	 * Return the log messages. 
	 * 
	 * @author Freddy Brasileiro
	 */
	public String getOutputMessages() {
		return outputMessages;
	}
	
	/**
	 * @author Freddy Brasileiro
	 *
	 * @param _ontoParser
	 * @param owlOptions
	 */
	public MappingElements(OntoUMLParser _ontoParser, OwlOptions owlOptions) {
		this.ontoParser = _ontoParser;
		this.owlOptions = owlOptions;
	}
	
	@SuppressWarnings("unused")
	private MappingElements() {}
	
	/**
	 * Returns the mapping of a property (see the class MappedProperty).
	 * If it is not mapped, it will be made.
	 * 
	 * @author Freddy Brasileiro
	 * 
	 * @param property
	 * @return
	 */
	public MappedElement getMappedElement(NamedElement element){
		String propertyAlias = ontoParser.getAlias(element);
		MappedElement mappedProperty;
		if(elementByAlias.containsKey(propertyAlias)){
			mappedProperty = elementByAlias.get(propertyAlias);
		}else{
			mappedProperty = generatePropertyName(element, null);
		}
		
		return mappedProperty;
	}

	/**
	 * Maps a property by its association name.
	 * The inverse association is named by prefixing "INV.".
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param property
	 * @param superMappedProperty
	 * @return
	 */
	private MappedElement generatePropertyNameByAssocName(NamedElement property, MappedElement superMappedProperty) {
		String propertyName = property.getName();
		propertyName = StringUtil.processSpecialCharacter(propertyName);
		String initialName = propertyName;

		String propertyAlias = ontoParser.getAlias(property);
		propertyAlias = propertyAlias.replace(" ", "_").replace("\n", "_");
		
		if(propertyName == null){
			propertyName = propertyAlias;
		}else{
			propertyName = propertyName.replace(" ", "_").replace("\n", "_");			
		}
		
		String source = null;
		String target = "";
		String stereotype = "";
		
		if(property instanceof Association){
			source = ((Association) property).getMemberEnd().get(0).getType().getName();
			target = ((Association) property).getMemberEnd().get(1).getType().getName();
		}else{
			source = ((PropertyImpl)property).getClass_().getName();
			if(((PropertyImpl)property).getType() != null)
				target = ((PropertyImpl)property).getType().getName();
		}
		
		source = source.replace(" ", "_").replace("\n", "_");
		target = target.replace(" ", "_").replace("\n", "_");
		stereotype = stereotype.replace(" ", "_").replace("\n", "_");
		
		if(stereotype.length() > 0){
			String aux = stereotype.substring(0, 1);
			aux = aux.toLowerCase();
			
			stereotype = aux + stereotype.substring(1);
		}
		
		if(property instanceof Association && (propertyName == null || propertyName.equals(""))){
			propertyName = stereotype + "." + source + "." + target;
			outputMessages += "Warning: An unnamed Association from <"+source+"> (source class) to <"+target+"> (target class) was mapped to OWL <"+propertyName+">;\n";
		}else if(property instanceof PropertyImpl){
			propertyName = source + "." + propertyName;
		}
		
		MappedElement secondAbstract = null, thirdAbstract = null;
		if(elementByName.containsKey(propertyName)){
			MappedElement oldMappedProperty = elementByName.get(propertyName);
			secondAbstract = refactorPropertyByName(property, oldMappedProperty);
			
			if(property instanceof Association){
				propertyName = propertyName + "." + source + "." + target;
			}
		}
		
		if(elementByName.containsKey(propertyName)){
			MappedElement oldMappedProperty = elementByName.get(propertyName);
			thirdAbstract = refactorPropertyByName(property, oldMappedProperty);
			
			if(property instanceof Association){
				propertyName = propertyAlias + "." + source + "." + target;				
			}
		}
		
		String invPropertyName = "INV." + propertyName;
		
		MappedElement newMappedProperty = new MappedElement(property, propertyName, invPropertyName, initialName, "inverse of " + initialName);
		if(secondAbstract != null){
			newMappedProperty.setMappedAsSubPropertyOf(secondAbstract);
		}else if(superMappedProperty != null){
			newMappedProperty.setMappedAsSubPropertyOf(superMappedProperty);
		}else if(thirdAbstract != null){
			newMappedProperty.setMappedAsSubPropertyOf(thirdAbstract);
		}
		
		if(newMappedProperty.isMappedAsSubPropertyOf()){
			String superName = newMappedProperty.getMappedAsSubPropertyOf().getGeneratedName();
			outputMessages += "Warning: The association <"+initialName+"> with repeated name was mapped as subPropertyOf <"+superName+"> with the name <"+propertyName+">;\n";
		}
		
		newMappedProperty.setLabel(initialName);
		
		elementByName.put(propertyName, newMappedProperty);
		elementByAlias.put(propertyAlias, newMappedProperty);
		
		return newMappedProperty;
	}
	
	/**
	 * Maps a property by the names of its association ends.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param property
	 * @param superMappedProperty
	 * @return
	 */
	private MappedElement generatePropertyNameByAssocEnd(NamedElement property) {
		String origSrcEndName;
		if(property instanceof Association){
			origSrcEndName = ((Association) property).getMemberEnd().get(0).getName();
			if(origSrcEndName == null || origSrcEndName.equals("")){
				origSrcEndName = "_"+((Association) property).getMemberEnd().get(0).getType().getName();
				outputMessages += "Warning: The source association end of the association <"+origSrcEndName+"> was empty and was renamed to <"+origSrcEndName+">;\n";				
			}
		}else{
			origSrcEndName = property.getName();
		}
		origSrcEndName = origSrcEndName.replaceAll(" ", "_").replaceAll("\n", "_");
		origSrcEndName = StringUtil.processSpecialCharacter(origSrcEndName);
		
		int i = 1;
		String srcEndName = origSrcEndName;
		while(elementByName.containsKey(srcEndName)){
			if(i == 1){
				MappedElement oldMappedProperty = elementByName.get(srcEndName);
				boolean isSource;
				if(oldMappedProperty.getGeneratedName().equals(srcEndName)){
					isSource = true;
				}else{
					isSource = false;
				}
				MappedElement abstractMappedProperty = new MappedElement(oldMappedProperty.getProperty(), oldMappedProperty.getGeneratedName(), oldMappedProperty.getInvGeneratedName(), true, oldMappedProperty.getLabel(), oldMappedProperty.getInvLabel());
				if(isSource){
					elementByName.put(abstractMappedProperty.getGeneratedName(), abstractMappedProperty);
				}else{
					elementByName.put(abstractMappedProperty.getInvGeneratedName(), abstractMappedProperty);
				}
				
				srcEndName = origSrcEndName + i;
				i++;
				
				if(isSource){
					oldMappedProperty.setGeneratedName(srcEndName);
					elementByName.put(oldMappedProperty.getGeneratedName(), oldMappedProperty);
				}else{
					oldMappedProperty.setInvGeneratedName(srcEndName);
					elementByName.put(oldMappedProperty.getInvGeneratedName(), oldMappedProperty);
				}
				
			}
			srcEndName = origSrcEndName + i;
			i++;			
		}
		if(i > 1){
			outputMessages += "Warning: The association end <"+origSrcEndName+"> with repeated name was renamed to <"+srcEndName+">;\n";
		}
		
		String origTgtEndName;
		if(property instanceof Association){
			origTgtEndName = ((Association) property).getMemberEnd().get(1).getName();
			if(origTgtEndName == null || origTgtEndName.equals("")){
				origTgtEndName = "_"+((Association) property).getMemberEnd().get(1).getType().getName();
				outputMessages += "Warning: The source association end of the association <"+origTgtEndName+"> was empty and was renamed to <"+origTgtEndName+">;\n";
			}
		}else{
			origTgtEndName = property.getName();
		}
		origTgtEndName = origTgtEndName.replaceAll(" ", "_").replaceAll("\n", "_");
		origTgtEndName = StringUtil.processSpecialCharacter(origTgtEndName);
		int j = 1;
		String tgtEndName = origTgtEndName;
		while(elementByName.containsKey(tgtEndName)){
			if(j == 1){
				MappedElement oldMappedProperty = elementByName.get(tgtEndName);
				boolean isSource;
				if(oldMappedProperty.getGeneratedName().equals(tgtEndName)){
					isSource = true;
				}else{
					isSource = false;
				}
				MappedElement abstractMappedProperty = new MappedElement(oldMappedProperty.getProperty(), oldMappedProperty.getGeneratedName(), oldMappedProperty.getInvGeneratedName(), true, oldMappedProperty.getLabel(), oldMappedProperty.getInvLabel());
				if(isSource){
					elementByName.put(abstractMappedProperty.getGeneratedName(), abstractMappedProperty);
				}else{
					elementByName.put(abstractMappedProperty.getInvGeneratedName(), abstractMappedProperty);
				}
				
				tgtEndName = origTgtEndName + j;
				j++;
				if(isSource){
					oldMappedProperty.setGeneratedName(tgtEndName);
					elementByName.put(oldMappedProperty.getGeneratedName(), oldMappedProperty);		
				}else{
					oldMappedProperty.setInvGeneratedName(tgtEndName);
					elementByName.put(oldMappedProperty.getInvGeneratedName(), oldMappedProperty);		
				}
						
			}
			tgtEndName = origTgtEndName + j;
			j++;			
		}
		if(j > 1){
			outputMessages += "Warning: The association end <"+origTgtEndName+"> with repeated name was renamed to <"+tgtEndName+">;\n";
		}
		
		MappedElement mappedProperty = new MappedElement(property, tgtEndName, srcEndName, origTgtEndName, origSrcEndName);
		elementByName.put(srcEndName, mappedProperty);
		elementByName.put(tgtEndName, mappedProperty);
		elementByAlias.put(ontoParser.getAlias(property), mappedProperty);
		
		return mappedProperty;
	}
	
	/**
	 * Re-maps a property by its name when a repeated name is found.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param _property
	 * @param property
	 * @return
	 */
	public MappedElement refactorPropertyByName(NamedElement _property, MappedElement property){
		MappedElement existentMappedProperty = elementByName.get(property.getGeneratedName());
		MappedElement abstractMappedProperty = existentMappedProperty;
		if(existentMappedProperty.isAbstract() == false){
			abstractMappedProperty = new MappedElement(_property, property.getGeneratedName(), property.getInvGeneratedName(), true, property.getLabel(), property.getInvLabel());//////////////////////////////
			elementByName.put(property.getGeneratedName(), abstractMappedProperty);
			generatePropertyName(existentMappedProperty.getProperty(), abstractMappedProperty);
		}		
		return abstractMappedProperty;
	}
	
	/**
	 * Maps a property by its name or by the names of its association ends, depending of the parametrization option.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param property
	 * @param superMappedProperty
	 * @return
	 */
	private MappedElement generatePropertyName(NamedElement property, MappedElement superMappedProperty) {
		if(((OwlAxioms)owlOptions.getOwlAxioms()).getValue(OWL2Axiom.OBJ_PROP_BY_ENDS)){
			return generatePropertyNameByAssocEnd(property);
		}else{
			return generatePropertyNameByAssocName(property, superMappedProperty);
		}		
	}
	
	/**
	 * Maps all properties (associations and attributes).
	 * 
	 * @author Freddy Brasileiro
	 *
	 */
	public void generateAllElementNames(){
		Set<RefOntoUML.Class> allClasses = ontoParser.getAllInstances(RefOntoUML.Class.class);
		for (Class class1 : allClasses) {
			generateClassName(class1);
		}
		
		System.out.println("Generating all property names");
		Set<Association> allAssociations = ontoParser.getAllInstances(RefOntoUML.Association.class);
		
		for (Association association : allAssociations) {
			generatePropertyName(association, null);
		}
		
		Set<Class> lstOntClass = ontoParser.getAllInstances(RefOntoUML.Class.class);
		for (Class ontCls : lstOntClass) {
			EList<Property> allAttributes = ontCls.getAttribute();
			for (Property attribute : allAttributes) {
				generatePropertyName(attribute, null);
			}
		}
		
		System.out.println(outputMessages);
	}
	
	private void generateClassName(Class ontCls) {
		String origClassName = ontCls.getName();
		String newName = origClassName.replaceAll(" ", "_").replaceAll("\n", "_");
		
		newName = refactorClassName(origClassName);
		MappedElement mappedProperty = new MappedElement(ontCls, newName, newName, origClassName, origClassName);
		elementByName.put(newName, mappedProperty);
		elementByAlias.put(ontoParser.getAlias(ontCls), mappedProperty);
		System.out.println();
	}
	
	private String refactorClassName(String actualName){
		int i = 1;
		String newName = actualName;
		while(elementByName.containsKey(newName)){
			if(i == 1){
				MappedElement oldMappedPElement = elementByName.get(newName);
				
				MappedElement abstractMappedProperty = new MappedElement(oldMappedPElement.getProperty(), oldMappedPElement.getGeneratedName(), oldMappedPElement.getGeneratedName(), true, oldMappedPElement.getLabel(), oldMappedPElement.getInvLabel());
				elementByName.put(abstractMappedProperty.getGeneratedName(), abstractMappedProperty);
				
				newName = actualName + i;
				i++;
				
				oldMappedPElement.setGeneratedName(newName);
				oldMappedPElement.setInvGeneratedName(newName);
				elementByName.put(oldMappedPElement.getGeneratedName(), oldMappedPElement);				
			}
			newName = actualName + i;
			i++;
		}		
		
		return newName;
	}

	/**
	 * Return true if the property is mapped as subPropertyOf another one.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param property
	 * @return
	 */
	public boolean isMappedAsSubPropertyOf(NamedElement property){
		String alias = ontoParser.getAlias(property);//.replace("\n", "_");
		MappedElement mappedProperty = elementByAlias.get(alias);
		
		if(mappedProperty.isMappedAsSubPropertyOf()){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Get the property mapped as super property of the specific one.  
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param property
	 * @return
	 */
	public MappedElement getSuperProperty(NamedElement property){
		String alias = ontoParser.getAlias(property);//.replace("\n", "_");
		MappedElement mappedProperty = elementByAlias.get(alias);
		
		MappedElement superMappedProperty = mappedProperty.getMappedAsSubPropertyOf();
		
		return superMappedProperty;
	}
	
	/**
	 * Get the top property mapped as super property of the specific one.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param property
	 * @return
	 */
	public MappedElement getTopSuperProperty(NamedElement property){
		String alias = ontoParser.getAlias(property).replace("\n", "_");
		MappedElement mappedProperty = elementByAlias.get(alias);
		
		MappedElement superMappedProperty = mappedProperty, topSuperMappedProperty;
		do {
			topSuperMappedProperty = superMappedProperty;
			
			superMappedProperty = superMappedProperty.getMappedAsSubPropertyOf();
		} while (superMappedProperty != null);		
		
		return topSuperMappedProperty;
	}
	
	public String getName(Object... elements){
		String name = "";
		for (Object elem : elements) {
			if(elem instanceof RefOntoUML.NamedElement){
				name += ((NamedElement) elem).getName() + ".";
			}else{
				name += elem + ".";
			}
		}
		int lastDot = name.lastIndexOf(".");
		name = name.substring(0, lastDot).replaceAll(" ", "_").replaceAll("\n", "_");
		
		return name;		
	}
	
	
}
