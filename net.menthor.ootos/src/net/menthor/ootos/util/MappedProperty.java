package net.menthor.ootos.util;

import RefOntoUML.NamedElement;

/**
 * Represents the mapping of a OntoUML property to an OWL property.
 * 
 * @author Freddy Brasileiro
 */
public class MappedProperty {
	private NamedElement property;
	private String generatedName;
	private String invGeneratedName;
	private MappedProperty mappedAsSubPropertyOf;
	private boolean isAbstract = false; 
	private String label;
	
	/**
	 * Represents the 
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param _property
	 * @param _generatedName
	 * @param _invGeneratedName
	 */
	public MappedProperty(NamedElement _property, String _generatedName, String _invGeneratedName) {
		property = _property;
		generatedName = _generatedName;
		invGeneratedName = _invGeneratedName;
	}
	
	/**
	 * @author Freddy Brasileiro
	 *
	 * @param _property
	 * @param _generatedName
	 * @param _invGeneratedName
	 * @param _isAbstract
	 */
	public MappedProperty(NamedElement _property, String _generatedName, String _invGeneratedName, boolean _isAbstract) {
		this(_property, _generatedName, _invGeneratedName);
		isAbstract = _isAbstract;
	}
	
	@SuppressWarnings("unused")
	private MappedProperty() {}
	
	/**
	 * Returns the generated name.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @return
	 */
	public String getGeneratedName() {
		return generatedName;
	}
	
	/**
	 * Returns the OntoUML property mapped to OWL 
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @return
	 */
	public NamedElement getProperty() {
		return property;
	}
	
	@Override
	public String toString() {
		String ret = "\n";
		ret += "association: " + generatedName + "\n";
		ret += "inverse: " + invGeneratedName + "\n";
		if(isAbstract) ret += "ABSTRACT\n";
		return ret;
	}

	/**
	 * Get the super property.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @return
	 */
	public MappedProperty getMappedAsSubPropertyOf() {
		return mappedAsSubPropertyOf;
	}
	
	/**
	 * Set the super property.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param mappedAsSubPropertyOf
	 */
	public void setMappedAsSubPropertyOf(MappedProperty mappedAsSubPropertyOf) {
		this.mappedAsSubPropertyOf = mappedAsSubPropertyOf;
	}
	
	/**
	 * Return true if the property is mapped as subPropertyOf another one.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @return
	 */
	public boolean isMappedAsSubPropertyOf() {
		if(mappedAsSubPropertyOf == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Return true if this is an abstract property.
	 * i.e., two or more properties have the same name, they had the name refactored and will be mapped as subPropertyOf this abstract one.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @return
	 */
	public boolean isAbstract() {
		return isAbstract;
	}
	
	/**
	 * Return the generated name for the inverse property.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @return
	 */
	public String getInvGeneratedName() {
		return invGeneratedName;
	}
	
	/**
	 * Set the generated name.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param generatedName
	 */
	public void setGeneratedName(String generatedName) {
		this.generatedName = generatedName;
	}
	
	/**
	 * Set the generated name for the inverse.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param invGeneratedName
	 */
	public void setInvGeneratedName(String invGeneratedName) {
		this.invGeneratedName = invGeneratedName;
	}
	
	/**
	 * Returns the generated label for this property.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Sets the label for this property.
	 * 
	 * @author Freddy Brasileiro
	 *
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}
