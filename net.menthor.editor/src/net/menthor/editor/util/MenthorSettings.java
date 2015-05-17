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

public enum MenthorSettings {
	
	USER_LOCALE("USER_LOCALE", "en-US"),
	
	MENTHOR_SETTINGS_FILE("MENTHOR_SETTINGS_FILE", "cnf.xml"),
	
	MODEL_DEFAULT_FILE("MODEL_DEFAULT_FILE", "model.refontouml"),
	
	OCL_DEFAULT_FILE("OCL_DEFAULT_FILE","constraints.ocl"),
	
	PROJECT_DEFAULT_FILE("PROJECT_DEFAULT_FILE","project.dat"),
	
	OWL_DEFAULT_FILE("OWL_DEFAULT_FILE", "model.owl"),
	
	SBVR_DEFAULT_FILE("SBVR_DEFAULT_FILE", "model-sbvr.html"),
	
	SIMULATION_DEFAULT_FILE("SIMULATION_DEFAULT_FILE", "simulation.als"),
	
	SIMULATION_THEME_FILE("SIMULATION_SOLUTION_FILE", "standart_theme.thm"),
	
	SIMULATION_SOLUTION_FILE("SIMULATION_SOLUTION_FILE", "solution_output.xml"),
	
	RECENT_PROJECT_1("RECENT_PROJECT_1", ""),	
	RECENT_PROJECT_2("RECENT_PROJECT_2", ""),	
	RECENT_PROJECT_3("RECENT_PROJECT_3", ""),	
	RECENT_PROJECT_4("RECENT_PROJECT_4", ""),	
	RECENT_PROJECT_5("RECENT_PROJECT_5", ""),
	RECENT_PROJECT_6("RECENT_PROJECT_6", ""),
	RECENT_PROJECT_7("RECENT_PROJECT_7", ""),
	RECENT_PROJECT_8("RECENT_PROJECT_8", ""),
	RECENT_PROJECT_9("RECENT_PROJECT_9", ""),
	RECENT_PROJECT_10("RECENT_PROJECT_10", "");
	
	private final String propertyKey;
	private final String defaultValue;
	
	private MenthorSettings(String propertyKey, String defaultValue) {
		this.propertyKey = propertyKey;
		this.defaultValue = defaultValue;
	}

	public String getPropertyKey() {
		return this.propertyKey;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public String getValue() {
		Properties properties = ConfigurationHelper.getProperties();
		if(properties != null)
			return properties.getProperty(getPropertyKey(), getDefaultValue());
		
		return getDefaultValue();
	}
	
	public void setValue(String value) {
		Properties properties = ConfigurationHelper.getProperties();
		if(properties != null)
			properties.put(getPropertyKey(), value);
	}
	
	public int getIntValue()
	{
		String value = getValue();
		return Integer.parseInt(value);
	}
	
	public boolean getBoolValue()
	{
		String value = getValue();
		return Boolean.parseBoolean(value);
	}
}
