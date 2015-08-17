package net.menthor.ootos.util;

import RefOntoUML.NamedElement;

public class MappedProperty {
	private NamedElement property;
	private String generatedName;
	private String invGeneratedName;
	private MappedProperty mappedAsSubPropertyOf;
	private boolean isAbstract = false; 
	
	public MappedProperty(NamedElement _property, String _generatedName, String _invGeneratedName) {
		property = _property;
		generatedName = _generatedName;
		invGeneratedName = _invGeneratedName;
		if(property == null){
			System.out.println();
		}			
	}
	
	public MappedProperty(NamedElement _property, String _generatedName, String _invGeneratedName, boolean _isAbstract) {
		this(_property, _generatedName, _invGeneratedName);
		isAbstract = _isAbstract;
	}
	
	@SuppressWarnings("unused")
	private MappedProperty() {}
	
	public String getGeneratedName() {
		return generatedName;
	}
	
	public NamedElement getProperty() {
		return property;
	}
	
	@Override
	public String toString() {
		return generatedName;
	}

	public MappedProperty getMappedAsSubPropertyOf() {
		return mappedAsSubPropertyOf;
	}
	
	public void setMappedAsSubPropertyOf(MappedProperty mappedAsSubPropertyOf) {
		this.mappedAsSubPropertyOf = mappedAsSubPropertyOf;
	}
	
	public boolean isMappedAsSubPropertyOf() {
		if(mappedAsSubPropertyOf == null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isAbstract() {
		return isAbstract;
	}
	
	public String getInvGeneratedName() {
		return invGeneratedName;
	}
}
