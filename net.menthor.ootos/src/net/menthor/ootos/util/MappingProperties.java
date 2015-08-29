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
import net.menthor.common.settings.owl.OwlAxioms;
import net.menthor.common.settings.owl.OwlOptions;

/**
 * Generate and store the mapping of OntoUML properties to OWL properties.
 * 
 * @author Freddy Brasileiro
 *
 */
public class MappingProperties {
	private OntoUMLParser ontoParser;
	private HashMap<String, MappedProperty> propertyByAlias = new HashMap<String, MappedProperty>();
	private HashMap<String, MappedProperty> propertyByName = new HashMap<String, MappedProperty>();
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
	public MappingProperties(OntoUMLParser _ontoParser, OwlOptions owlOptions) {
		this.ontoParser = _ontoParser;
		this.owlOptions = owlOptions;
	}
	
	@SuppressWarnings("unused")
	private MappingProperties() {}
	
	/**
	 * Returns the mapping of a property (see the class MappedProperty).
	 * If it is not mapped, it will be made.
	 * 
	 * @author Freddy Brasileiro
	 * 
	 * @param property
	 * @return
	 */
	public MappedProperty getMappedProperty(NamedElement property){
		String propertyAlias = ontoParser.getAlias(property);
		MappedProperty mappedProperty;
		if(propertyByAlias.containsKey(propertyAlias)){
			mappedProperty = propertyByAlias.get(propertyAlias);
		}else{
			mappedProperty = generatePropertyName(property, null);
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
	private MappedProperty generatePropertyNameByAssocName(NamedElement property, MappedProperty superMappedProperty) {
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
		
		MappedProperty secondAbstract = null, thirdAbstract = null;
		if(propertyByName.containsKey(propertyName)){
			MappedProperty oldMappedProperty = propertyByName.get(propertyName);
			secondAbstract = refactorPropertyByName(property, oldMappedProperty);
			
			if(property instanceof Association){
				propertyName = propertyName + "." + source + "." + target;
			}
		}
		
		if(propertyByName.containsKey(propertyName)){
			MappedProperty oldMappedProperty = propertyByName.get(propertyName);
			thirdAbstract = refactorPropertyByName(property, oldMappedProperty);
			
			if(property instanceof Association){
				propertyName = propertyAlias + "." + source + "." + target;				
			}
		}
		
		String invPropertyName = "INV." + propertyName;
		
		MappedProperty newMappedProperty = new MappedProperty(property, propertyName, invPropertyName);
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
		
		propertyByName.put(propertyName, newMappedProperty);
		propertyByAlias.put(propertyAlias, newMappedProperty);
		
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
	private MappedProperty generatePropertyNameByAssocEnd(NamedElement property) {
		String origSrcEndName;
		if(property instanceof Association){
			origSrcEndName = ((Association) property).getMemberEnd().get(0).getName();
		}else{
			origSrcEndName = property.getName();
		}
		origSrcEndName = origSrcEndName.replaceAll(" ", "_").replaceAll("\n", "_");
		origSrcEndName = StringUtil.processSpecialCharacter(origSrcEndName);
		
		int i = 1;
		String srcEndName = origSrcEndName;
		while(propertyByName.containsKey(srcEndName)){
			if(i == 1){
				MappedProperty oldMappedProperty = propertyByName.get(srcEndName);
				boolean isSource;
				if(oldMappedProperty.getGeneratedName().equals(srcEndName)){
					isSource = true;
				}else{
					isSource = false;
				}
				MappedProperty abstractMappedProperty = new MappedProperty(oldMappedProperty.getProperty(), oldMappedProperty.getGeneratedName(), oldMappedProperty.getInvGeneratedName(), true);
				if(isSource){
					propertyByName.put(abstractMappedProperty.getGeneratedName(), abstractMappedProperty);
				}else{
					propertyByName.put(abstractMappedProperty.getInvGeneratedName(), abstractMappedProperty);
				}
				
				srcEndName = origSrcEndName + i;
				i++;
				
				if(isSource){
					oldMappedProperty.setGeneratedName(srcEndName);
					propertyByName.put(oldMappedProperty.getGeneratedName(), oldMappedProperty);
				}else{
					oldMappedProperty.setInvGeneratedName(srcEndName);
					propertyByName.put(oldMappedProperty.getInvGeneratedName(), oldMappedProperty);
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
		}else{
			origTgtEndName = property.getName();
		}
		origTgtEndName = origTgtEndName.replaceAll(" ", "_").replaceAll("\n", "_");
		origTgtEndName = StringUtil.processSpecialCharacter(origTgtEndName);
		int j = 1;
		String tgtEndName = origTgtEndName;
		while(propertyByName.containsKey(tgtEndName)){
			if(j == 1){
				MappedProperty oldMappedProperty = propertyByName.get(tgtEndName);
				boolean isSource;
				if(oldMappedProperty.getGeneratedName().equals(tgtEndName)){
					isSource = true;
				}else{
					isSource = false;
				}
				MappedProperty abstractMappedProperty = new MappedProperty(oldMappedProperty.getProperty(), oldMappedProperty.getGeneratedName(), oldMappedProperty.getInvGeneratedName(), true);
				if(isSource){
					propertyByName.put(abstractMappedProperty.getGeneratedName(), abstractMappedProperty);
				}else{
					propertyByName.put(abstractMappedProperty.getInvGeneratedName(), abstractMappedProperty);
				}
				
				tgtEndName = origTgtEndName + j;
				j++;
				if(isSource){
					oldMappedProperty.setGeneratedName(tgtEndName);
					propertyByName.put(oldMappedProperty.getGeneratedName(), oldMappedProperty);		
				}else{
					oldMappedProperty.setInvGeneratedName(tgtEndName);
					propertyByName.put(oldMappedProperty.getInvGeneratedName(), oldMappedProperty);		
				}
						
			}
			tgtEndName = origTgtEndName + j;
			j++;			
		}
		if(j > 1){
			outputMessages += "Warning: The association end <"+origTgtEndName+"> with repeated name was renamed to <"+tgtEndName+">;\n";
		}
		
		MappedProperty mappedProperty = new MappedProperty(property, tgtEndName, srcEndName);
		propertyByName.put(srcEndName, mappedProperty);
		propertyByName.put(tgtEndName, mappedProperty);
		propertyByAlias.put(ontoParser.getAlias(property), mappedProperty);
		
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
	public MappedProperty refactorPropertyByName(NamedElement _property, MappedProperty property){
		MappedProperty existentMappedProperty = propertyByName.get(property.getGeneratedName());
		MappedProperty abstractMappedProperty = existentMappedProperty;
		if(existentMappedProperty.isAbstract() == false){
			abstractMappedProperty = new MappedProperty(_property, property.getGeneratedName(), property.getInvGeneratedName(), true);//////////////////////////////
			propertyByName.put(property.getGeneratedName(), abstractMappedProperty);
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
	private MappedProperty generatePropertyName(NamedElement property, MappedProperty superMappedProperty) {
		if(((OwlAxioms)owlOptions.getOwlAxioms()).isAssocNamesByAssocEnds()){
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
	public void generateAllPropertyNames(){
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
		MappedProperty mappedProperty = propertyByAlias.get(alias);
		
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
	public MappedProperty getSuperProperty(NamedElement property){
		String alias = ontoParser.getAlias(property);//.replace("\n", "_");
		MappedProperty mappedProperty = propertyByAlias.get(alias);
		
		MappedProperty superMappedProperty = mappedProperty.getMappedAsSubPropertyOf();
		
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
	public MappedProperty getTopSuperProperty(NamedElement property){
		String alias = ontoParser.getAlias(property).replace("\n", "_");
		MappedProperty mappedProperty = propertyByAlias.get(alias);
		
		MappedProperty superMappedProperty = mappedProperty, topSuperMappedProperty;
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
