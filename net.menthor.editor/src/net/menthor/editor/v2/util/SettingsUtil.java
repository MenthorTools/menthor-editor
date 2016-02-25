package net.menthor.editor.v2.util;

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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.Properties;

public enum SettingsUtil {
	
	USER_LOCALE("USER_LOCALE", "en-US"),	
	SETTINGS_FILE("SETTINGS_FILE", "settings.xml"),
	
	MODEL_FILE("MODEL_FILE", "model.refontouml"),
	PROJECT_FILE("PROJECT_FILE","project.dat"),
	OWL_CONFIG_FILE("OWL_CONFIG_FILE","owl-cnf.xml"),
	OCL_FILE("OCL_FILE",".ocl"),
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
	private static Properties properties;
	
	/** Constructor */
	private SettingsUtil(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() { return this.key; }
	public String getDefaultValue() { return this.value; }

	public String getValue() {
		Properties properties = getProperties();
		if(properties != null) return properties.getProperty(getKey(), getDefaultValue());		
		return getDefaultValue();
	}
	
	public void setValue(String value) {
		Properties properties = getProperties();
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
		
	public static boolean saveProperties(){
		if(properties != null) {
			File file = new File(Util.getCanonPath(DirectoryUtil.getTempDir(), SettingsUtil.SETTINGS_FILE.getValue()));
			try {
				FileOutputStream out = new FileOutputStream(file);
				properties.storeToXML(out, "Menthor Configuration File", "UTF-8");
				Util.close(out);
				return true;
			} catch (Exception ex) {}
		}		
		return false;
	}
	
	public static Properties getProperties() {
		if(properties != null) return properties;		
		properties = new Properties();		
		File file = new File(Util.getCanonPath(DirectoryUtil.getTempDir(), SettingsUtil.SETTINGS_FILE.getValue()));
		if(file.exists()) {
			try {
				FileInputStream in = new FileInputStream(file);
				properties.loadFromXML(in);
				Util.close(in);
			} catch (Exception ex) {}
		}	
		return properties;
	}

	public static void addRecentProject(String path) {
		if(!SettingsUtil.RECENT_PROJECT_1.getValue().equals(path)) {
			int histSize = 10;		
			for (int i = histSize-1; i > 0; i--) {
				SettingsUtil setting = SettingsUtil.valueOf("RECENT_PROJECT_" + i); 
				SettingsUtil nextSetting = SettingsUtil.valueOf("RECENT_PROJECT_" + (i + 1));
				nextSetting.setValue(setting.getValue());
			}			
			SettingsUtil.RECENT_PROJECT_1.setValue(path);
			saveProperties();
		}
	}
	
	public static String[] getRecentProjects() {
		int histSize = 10;
		String[] ans = new String[histSize];		
		for (int i = 1; i < histSize; i++) {
			ans[i] = SettingsUtil.valueOf("RECENT_PROJECT_" + i).getValue();
		}		
		return ans;
	}

}
