package net.menthor.resources.icons;

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

public enum CommandType {		
	/** project */
	NEW_PROJECT, OPEN_PROJECT, OPEN_RECENT_PROJECT, CLOSE_PROJECT, 
	SAVE_PROJECT_AS, SAVE_PROJECT, 
	/** functionality */
	SEARCH_TERM, CHECK_SYNTAX, COLLECT_STATISTICS, SIMULATE, IMPLEMENT_IN_OWL,
	/** diagram */
	NEW_DIAGRAM, CLOSE_DIAGRAM,	
	/** exportation */
	EXPORT_IMAGE, EXPORT_UML, EXPORT_ECORE, EXPORT_PATTERN, EXPORT_OCL,
	/** importation */
	IMPORT_ECORE, IMPORT_PATTERN, IMPORT_XMI, IMPORT_XMI_FROM_FILE, IMPORT_OCL,
	/** application */
	EDIT_SETTINGS, QUIT_MENTHOR,
	/** help */
	ABOUT, HELP_CONTENTS, 
	/** class creation */
	CREATE_KIND, CREATE_QUANTITY, CREATE_COLLECTIVE, CREATE_SUBKIND, CREATE_PHASE, CREATE_ROLE,
	CREATE_RELATOR, CREATE_MODE, CREATE_PERCEIVABLE_QUALITY, CREATE_NONPERCEIVABLE_QUALITY, CREATE_NOMINAL_QUALITY,
	CREATE_CATEGORY, CREATE_MIXIN, CREATE_ROLEMIXIN, CREATE_PHASEMIXIN, CREATE_EVENT, CREATE_POWERTYPE, CREATE_CLASS,
	/** datatype creation*/
	CREATE_DATATYPE, CREATE_ENUMERATION,
	CREATE_DIMENSION, CREATE_DOMAIN, CREATE_PRIMITIVETYPE,
	/** relationship creation*/
	CREATE_GENERALIZATION, CREATE_MEDIATION, CREATE_CHARACTERIZATION, CREATE_DERIVATION, CREATE_FORMAL,
	CREATE_MATERIAL, CREATE_STRUCTURATION, CREATE_COMPONENTOF, CREATE_MEMBEROF, CREATE_SUBCOLLECTIONOF, 
	CREATE_SUBQUANTITYOF, CREATE_ASSOCIATION;
	
	public static boolean isValueOf(String command)
	{
		for(CommandType ct: values()){
			if(ct.toString().compareToIgnoreCase(command)==0) return true;
		}
		return false;
	}
}
