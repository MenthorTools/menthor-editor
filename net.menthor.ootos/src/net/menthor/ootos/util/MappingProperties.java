package net.menthor.ootos.util;

import java.util.HashMap;
import java.util.Set;

import net.menthor.common.transformation.OwlAxiomsEnforcement;
import net.menthor.common.transformation.TransformationOption;

import org.eclipse.emf.common.util.EList;

import RefOntoUML.Association;
import RefOntoUML.Class;
import RefOntoUML.NamedElement;
import RefOntoUML.Property;
import RefOntoUML.impl.PropertyImpl;
import RefOntoUML.parser.OntoUMLParser;

public class MappingProperties {
	private OntoUMLParser ontoParser;
	private HashMap<String, MappedProperty> propertyByAlias = new HashMap<String, MappedProperty>();
	private HashMap<String, MappedProperty> propertyByName = new HashMap<String, MappedProperty>();
	private String outputMessages = "";
	TransformationOption owlOptions;
	
	public String getOutputMessages() {
		return outputMessages;
	}
	
	public MappingProperties(OntoUMLParser _ontoParser, TransformationOption owlOptions) {
		this.ontoParser = _ontoParser;
		this.owlOptions = owlOptions;
	}
	
	@SuppressWarnings("unused")
	private MappingProperties() {}
	
	public MappedProperty getPropertyName(NamedElement property){
		String propertyAlias = ontoParser.getAlias(property);
		MappedProperty mappedProperty;
		if(propertyByAlias.containsKey(propertyAlias)){
			mappedProperty = propertyByAlias.get(propertyAlias);
		}else{
			mappedProperty = generatePropertyName(property, null);
		}
		
		return mappedProperty;
	}

	private MappedProperty generatePropertyNameByAssocName(NamedElement property, MappedProperty superMappedProperty) {
		String propertyName = property.getName();
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
			secondAbstract = refactorProperty(property, oldMappedProperty);
			
			//concatena source e target no NOME da nova propriedade
			if(property instanceof Association){
				propertyName = propertyName + "." + source + "." + target;
			}
		}
		
		if(propertyByName.containsKey(propertyName)){
			MappedProperty oldMappedProperty = propertyByName.get(propertyName);
			thirdAbstract = refactorProperty(property, oldMappedProperty);
			
			//concatena source e target no ALIAS da nova propriedade
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
		
		propertyByName.put(propertyName, newMappedProperty);
		propertyByAlias.put(propertyAlias, newMappedProperty);
		
		return newMappedProperty;
	}
	
	private MappedProperty generatePropertyNameByAssocEnd(NamedElement property, MappedProperty superMappedProperty) {
		return null;
	}
	
	private MappedProperty generatePropertyName(NamedElement property, MappedProperty superMappedProperty) {
		if(((OwlAxiomsEnforcement)owlOptions.getAxiomsEnforcement()).isNamedByAssocEnds()){
			return generatePropertyNameByAssocEnd(property, superMappedProperty);
		}else{
			return generatePropertyNameByAssocName(property, superMappedProperty);
		}		
	}
	
	public MappedProperty refactorProperty(NamedElement _property, MappedProperty property){
		//pega a propriedade que ja possui esse nome e gera outro nome para ela
		MappedProperty existentMappedProperty = propertyByName.get(property.getGeneratedName());
		MappedProperty abstractMappedProperty = existentMappedProperty;
		if(existentMappedProperty.isAbstract() == false){
			abstractMappedProperty = new MappedProperty(_property, property.getGeneratedName(), property.getInvGeneratedName(), true);//////////////////////////////
			propertyByName.put(property.getGeneratedName(), abstractMappedProperty);
			generatePropertyName(existentMappedProperty.getProperty(), abstractMappedProperty);
		}		
		return abstractMappedProperty;
	}
	
	public void generateAllPropertyNames(){
		System.out.println("Generating all property names");
		Set<Association> allAssociations = ontoParser.getAllInstances(RefOntoUML.Association.class);
		
		for (Association association : allAssociations) {
			generatePropertyName(association, null);
//			generatePropertyName(association, null, false);
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
	
	public boolean isMappedAsSubRelationOf(NamedElement property){
		String alias = ontoParser.getAlias(property).replace("\n", "_");
		MappedProperty mappedProperty = propertyByAlias.get(alias);
		
		if(mappedProperty.isMappedAsSubPropertyOf()){
			return true;
		}
		
		return false;
	}
	
	public MappedProperty getSuperProperty(NamedElement property){
		String alias = ontoParser.getAlias(property).replace("\n", "_");
		MappedProperty mappedProperty = propertyByAlias.get(alias);
		
		MappedProperty superMappedProperty = mappedProperty.getMappedAsSubPropertyOf();
		
		return superMappedProperty;
	}
	
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
}
