package net.menthor.editor.util;

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

import java.util.Properties;

import net.menthor.editor.model.UmlProject;

public enum ProjectSettings {
	
	OWL_ONTOLOGY_IRI("OWL_ONTOLOGY_IRI", ""),
	OWL_GENERATE_FILE("OWL_GENERATE_FILE", "false"),
	OWL_FILE_PATH("OWL_FILE_PATH", ""),
	OWL_MAPPING_TYPE("OWL_MAPPING_TYPE", "OOTOS");
	
	private final String propertyKey;
	private final String defaultValue;
	
	private ProjectSettings(String propertyKey, String defaultValue) {
		this.propertyKey = propertyKey;
		this.defaultValue = defaultValue;
	}

	public String getPropertyKey() {
		return this.propertyKey;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public String getValue(UmlProject project) {
		Properties properties = project.getProperties();
		if(properties != null)
			return properties.getProperty(getPropertyKey(), getDefaultValue());
		
		return getDefaultValue();
	}
	
	public void setValue(UmlProject project, String value) {
		Properties properties = project.getProperties();
		if(properties != null)
			properties.put(getPropertyKey(), value);
	}
	
	public int getIntValue(UmlProject project)
	{
		String value = getValue(project);
		return Integer.parseInt(value);
	}
	
	public boolean getBoolValue(UmlProject project)
	{
		String value = getValue(project);
		return Boolean.parseBoolean(value);
	}
}