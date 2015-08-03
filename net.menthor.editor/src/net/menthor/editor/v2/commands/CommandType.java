package net.menthor.editor.v2.commands;

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

public enum CommandType {		
	
	/** project */
	NEW_PROJECT("Create new menthor project"),
	OPEN_PROJECT("Open existing menthor project"), 
	OPEN_RECENT_PROJECT("Save current menthor project"), 
	CLOSE_PROJECT("Close current menthor project"), 
	SAVE_PROJECT_AS("Save current menthor project"), 
	SAVE_PROJECT("Save current menthor project as..."), 
	
	/** functionality */
	SEARCH_TERM("Search a term in current project"), 
	CHECK_SYNTAX("Check syntax of current project"), 
	COLLECT_STATISTICS("Collect statistics of current project"), 
	SIMULATE("Simulate and check current project using Alloy"), 
	IMPLEMENT_IN_OWL("Generate current project implementation in OWL/RDF"),
	
	/** diagram */
	NEW_DIAGRAM("Create a new class diagram"), 
	CLOSE_DIAGRAM("Close current class diagram"),	
	REDO_DIAGRAM("Redo action on current class diagram"), 
	UNDO_DIAGRAM("Undo action on current class diagram"), 
	SHOW_GRID(null),
	ALIGN_TOP(null), 
	ALIGN_BOTTOM(null), 
	ALIGN_HORIZONTAL(null), 
	ALIGN_VERTICAL(null), 
	ALIGN_LEFT(null), 
	ALIGN_RIGHT(null),
	BRING_TO_FRONT(null), 
	PUT_BACK(null), 
	SET_BACKGROUND_COLOR("Set the background color for selected classes"), 
	FIT_TO_WINDOW(null), 
	ZOOM_AT_100(null), 
	ZOOM_IN(null), 
	ZOOM_OUT(null),
	
	/** exportation */
	EXPORT_IMAGE("<html>Save diagram as PNG<br><br>TIP: Move your diagram as close as possible <br>to the upper left side of the grid.<br><br> </hmtl>"), 
	EXPORT_UML(null), 
	EXPORT_ECORE(null), 
	EXPORT_PATTERN(null), 
	EXPORT_OCL(null),
	
	/** importation */	
	IMPORT_ECORE(null), 
	IMPORT_PATTERN(null), 
	IMPORT_XMI(null), 
	IMPORT_XMI_FROM_FILE(null), 
	IMPORT_OCL(null),
	
	/** application */
	EDIT_SETTINGS(null), 
	QUIT_MENTHOR(null),
	
	/** help */
	ABOUT(null), 
	HELP_CONTENTS(null), 
	
	/** class creation */
	POINTER_MODE(null),
	CREATE_KIND(null), 
	CREATE_QUANTITY(null), 
	CREATE_COLLECTIVE(null), 
	CREATE_SUBKIND(null), 
	CREATE_PHASE(null), 
	CREATE_ROLE(null),
	CREATE_RELATOR(null), 
	CREATE_MODE(null), 
	CREATE_PERCEIVABLE_QUALITY(null), 
	CREATE_NONPERCEIVABLE_QUALITY(null), 
	CREATE_NOMINAL_QUALITY(null),
	CREATE_CATEGORY(null), 
	CREATE_MIXIN(null), 
	CREATE_ROLEMIXIN(null), 
	CREATE_PHASEMIXIN(null), 
	CREATE_EVENT(null), 
	CREATE_POWERTYPE(null), 
	CREATE_CLASS(null),
	
	/** data-type creation*/
	CREATE_DATATYPE(null), 
	CREATE_ENUMERATION(null),
	CREATE_DIMENSION(null), 
	CREATE_DOMAIN(null), 
	CREATE_PRIMITIVETYPE(null),
	
	/** relationship creation*/
	CREATE_GENERALIZATION(null), 
	CREATE_MEDIATION(null), 
	CREATE_CHARACTERIZATION(null), 
	CREATE_DERIVATION(null), 
	CREATE_FORMAL(null),
	CREATE_MATERIAL(null), 
	CREATE_STRUCTURATION(null), 
	CREATE_COMPONENTOF(null), 
	CREATE_MEMBEROF(null), 
	CREATE_SUBCOLLECTIONOF(null), 
	CREATE_SUBQUANTITYOF(null), 
	CREATE_ASSOCIATION(null),
	
	/** pattern */
	CALL_COMPLETER_PATTERN(null), 
	CALL_MIXIN_PATTERN(null), 
	CALL_MIXIN_WITH_SUBKIND_PATTERN(null),
	CALL_PHASE_PARTITION_PATTERN(null), 
	CALL_SUBKIND_PARTITION_PATTERN(null),
	CALL_ROLE_PARTITION_PATTERN(null),
	CALL_ROLEMIXIN_PATTERN(null), 
	CALL_RELATOR_PATTERN(null), 
	CALL_DEPENDENT_ROLEMIXIN_PATTERN(null),
	CALL_GENERIC_RELATOR_PATTERN(null), 
	CALL_CHARACTERIZATION_PATTERN(null), 
	CALL_RIGID_WS_PATTERN(null),
	CALL_ANTIRIGID_WS_PATTERN(null), 
	CALL_KIND_PARTITION_PATTERN(null), 
	CALL_QUANTITY_PARTITION_PATTERN(null),
	CALL_COLLECTIVE_PARTITION_PATTERN(null), 
	CALL_CATEGORY_PATTERN(null),
	
	/** domain pattern */
	CALL_DOMAIN_PATTERN(null),
	
	/** derived pattern */
	CALL_UNION_PATTERN(null), 
	CALL_EXCLUSION_PATTERN(null), 
	CALL_INTERSECTION_PATTERN(null), 
	CALL_SPECIALIZATION_PATTERN(null), 
	CALL_PASTSPECIALIZATION_PATTERN(null), 
	CALL_PARTICIPATION_PATTERN(null);
	
	private String description;

	CommandType(String description)
	{
		this.description = description;
	}

	public String getDescription() { return description; }

	public static void main (String args[])
	{
		for(CommandType c: CommandType.values()){
			System.out.println(c.description);
		}
	}
	
	public static boolean isValueOf(String command)
	{
		for(CommandType ct: values()){
			if(ct.toString().compareToIgnoreCase(command)==0) return true;
		}
		return false;
	}
}
