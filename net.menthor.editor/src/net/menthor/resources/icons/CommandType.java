package net.menthor.resources.icons;

public enum CommandType {		
	/** project */
	NEW_PROJECT, OPEN_PROJECT, OPEN_RECENT_PROJECT, CLOSE_PROJECT, 
	SAVE_PROJECT_AS, SAVE_PROJECT, 
	/** functionality */
	SEARCH_TERM, CHECK_SYNTAX, COLLECT_STATISTICS,
	/** diagram */
	NEW_DIAGRAM, CLOSE_DIAGRAM,
	/** exportation */
	EXPORT_IMAGE, EXPORT_UML, EXPORT_ECORE, EXPORT_PATTERN, EXPORT_OCL,
	/** importation */
	IMPORT_ECORE, IMPORT_PATTERN, IMPORT_XMI, IMPORT_XMI_FROM_FILE, IMPORT_OCL,
	/** application */
	EDIT_SETTINGS, QUIT_MENTHOR,
	/** help */
	ABOUT, HELP_CONTENTS;
	
	public static boolean isValueOf(String command)
	{
		for(CommandType ct: values()){
			if(ct.toString().compareToIgnoreCase(command)==0) return true;
		}
		return false;
	}
}
