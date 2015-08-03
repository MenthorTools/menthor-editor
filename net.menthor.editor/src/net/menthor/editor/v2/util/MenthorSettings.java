package net.menthor.editor.v2.util;

/*
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
	
	DEFAULT_SETTINGS_FILE("DEFAULT_SETTINGS_FILE", "settings.xml"),
	
	DEFAULT_MODEL_FILE("DEFAULT_MODEL_FILE", "model.refontouml"),
	
	DEFAULT_OCL_FILE("DEFAULT_OCL_FILE","constraints.ocl"),
	
	DEFAULT_PROJECT_FILE("DEFAULT_PROJECT_FILE","project.dat"),
	
	DEFAULT_OWL_FILE("DEFAULT_OWL_FILE", "model.owl"),
	
	DEFAULT_SBVR_FILE("DEFAULT_SBVR_FILE", "model-sbvr.html"),
	
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
	
	private final String key;
	private final String value;
	
	private MenthorSettings(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() { return this.key; }
	public String getDefaultValue() { return this.value; }

	public String getValue() {
		Properties properties = MenthorConfigurator.getProperties();
		if(properties != null) return properties.getProperty(getKey(), getDefaultValue());		
		return getDefaultValue();
	}
	
	public void setValue(String value) {
		Properties properties = MenthorConfigurator.getProperties();
		if(properties != null) properties.put(getKey(), value);
	}
	
	public int getIntValue() {
		String value = getValue();
		return Integer.parseInt(value);
	}
	
	public boolean getBoolValue() {
		String value = getValue();
		return Boolean.parseBoolean(value);
	}
}
