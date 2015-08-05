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
	
	//====================================================
	// FILE
	//====================================================
	
	NEW_PROJECT("Create new menthor project"),
	OPEN_PROJECT("Open existing menthor project"), 
	OPEN_RECENT_PROJECT("Save current menthor project"), 
	CLOSE_PROJECT("Close current menthor project"), 
	SAVE_PROJECT_AS("Save current menthor project"), 
	SAVE_PROJECT("Save current menthor project as..."), 
	QUIT_MENTHOR(null),
	
	//====================================================
	// EDIT
	//====================================================
	REDO("Redo action"),	
	UNDO("Undo action"),
	EDIT_PROPERTIES_SELECTED("Edit properties of selected element(s)"),
	DELETE_SELECTED("Delete selected element(s)"),
	
	//====================================================
	// DIAGRAM
	//====================================================
	NEW_DIAGRAM("Create a new class diagram"), 
	CLOSE_DIAGRAM("Close current class diagram"),	
	REDRAW_DIAGRAM("Redraw the current class diagram"),
	SELECT_ALL_DIAGRAM("Select all elements on current diagram"),
	SAVE_DIAGRAM_AS_IMAGE("<html>Save diagram as PNG<br><br>TIP: Move your diagram as close as possible <br>to the upper left side of the grid.</hmtl>"),
	SHOW_GRID("Show grid in the diagram"),
	FIT_TO_WINDOW("Fit the diagram into the visible area of the grid"), 
	ZOOM_AT_100("Zoom at 100%"), 
	ZOOM_IN("Zoom in"), 
	ZOOM_OUT("Zoom out"),	
	ALIGN_TOP("Align selected elements on top"), 
	ALIGN_BOTTOM("Align selected elements on bottom"), 
	ALIGN_HORIZONTAL("Align selected elements horizontally"), 
	ALIGN_VERTICAL("Align selected elements vertically"), 
	ALIGN_LEFT("Align selected elements on left"), 
	ALIGN_RIGHT("Align selected elements on right"),
	BRING_TO_FRONT("Bring selected elements to front"), 
	PUT_BACK("Put selected elements back"), 
	SET_BACKGROUND_COLOR("Set the background color for selected classes"),		
	RESET_POINTS("Reset connection points in the selected relationship"),
	CHANGE_FROM_RECT_TO_DIRECT("Change line style from Rectilinear to Direct"), 
	CHANGE_FROM_DIRECT_TO_RECT("Change line style from Direct to Rectilinear"),
	APPLY_VERTICAL_STYLE("Apply vertical style on line"),
	APPLY_HORIZONTAL_STYLE("Apply horizontal style on line"),	
	
	//====================================================
	// EXPORT
	//====================================================
	EXPORT_AS_PATTERN("Export current project as a pattern"),	
	EXPORT_TO_UML("Export current project to UML (UML2)"), 
	EXPORT_TO_ECORE("Export current project to Ecore (EMF)"),
	EXPORT_TO_XMI("Export current project to XMI (EMF)"),
		
	//====================================================
	// IMPORT
	//====================================================	
	IMPORT_FROM_XMI_EMF(null), 
	IMPORT_FROM_XMI_EA(null), 
	IMPORT_FROM_XMI_EA_FILE(null), 
	IMPORT_FROM_PATTERN(null),

	//====================================================
	// WINDOW
	//====================================================
	PALETTE_OF_ELEMENTS(null), 
	PROJECT_BROWSER(null), 
	CONSOLE(null),
		
	//====================================================
	// HELP
	//====================================================
	ABOUT(null), 
	LICENSES(null), 

	//====================================================
	// PROJECT
	//====================================================
	FIND_TERM("Find a term in current project"),
	COLLECT_STATISTICS("Collect statistics of current project"),
	
	//====================================================
	// VERIFICATE
	//====================================================
	CHECK_MODEL_SYNTAX("Check syntax of current model"), 
	PARSE_CONSTRAINTS("Check syntax of current constraints"),
	 
	//====================================================
	// VALIDATE
	//====================================================
	SIMULATE_AND_CHECK("Simulate and check current project using Alloy"), 
	IMPLEMENT_IN_OWL("Generate current project implementation in OWL/RDF"),
	BUSINESS_VOCABULARY("Transform current project into a SBVR business vocabulary"),
	TEXTUAL_DESCRIPTION("Transform current project into Natural Language"),	
	DESIGN_AS_INFO_UML("Transform current project into an information model in UML"),
	SEARCH_FOR_ANTIPATTERNS("Search for semantic anti-patterns in current project"),
	VALIDATE_PARTHOOD_TRANSITIVITY("Validate the transitivity of parthood relationships"),
	
	//====================================================
	// TOOLBOX DRAG AND DROP: CLASS
	//====================================================
	TB_DND_POINTER_MODE(null),
	TB_DND_KIND(null), 
	TB_DND_QUANTITY(null), 
	TB_DND_COLLECTIVE(null), 
	TB_DND_SUBKIND(null), 
	TB_DND_PHASE(null), 
	TB_DND_ROLE(null),
	TB_DND_RELATOR(null), 
	TB_DND_MODE(null), 
	TB_DND_PERCEIVABLE_QUALITY(null), 
	TB_DND_NONPERCEIVABLE_QUALITY(null), 
	TB_DND_NOMINAL_QUALITY(null),
	TB_DND_CATEGORY(null), 
	TB_DND_MIXIN(null), 
	TB_DND_ROLEMIXIN(null), 
	TB_DND_PHASEMIXIN(null), 
	TB_DND_EVENT(null),	
	TB_DND_POWERTYPE(null), 
	TB_DND_CLASS(null),
	
	//====================================================
	// TOOLBOX DRAG AND DROP: DATATYPE
	//====================================================
	TB_DND_DATATYPE(null), 
	TB_DND_ENUMERATION(null),
	TB_DND_DIMENSION(null), 
	TB_DND_DOMAIN(null), 
	TB_DND_PRIMITIVETYPE(null),

	//====================================================
	// TOOLBOX DRAG AND DROP: RELATIONSHIP
	//====================================================
	TB_DND_GENERALIZATION(null), 
	TB_DND_MEDIATION(null), 
	TB_DND_CHARACTERIZATION(null), 
	TB_DND_DERIVATION(null), 
	TB_DND_FORMAL(null),
	TB_DND_MATERIAL(null), 
	TB_DND_STRUCTURATION(null), 
	TB_DND_COMPONENTOF(null), 
	TB_DND_MEMBEROF(null), 
	TB_DND_SUBCOLLECTIONOF(null), 
	TB_DND_SUBQUANTITYOF(null), 
	TB_DND_ASSOCIATION(null),

	//====================================================
	// TOOLBOX DRAG AND DROP: PATTERN
	//====================================================
	TB_DND_COMPLETER_PATTERN(null), 
	TB_DND_MIXIN_PATTERN(null), 
	TB_DND_MIXIN_WITH_SUBKIND_PATTERN(null),
	TB_DND_PHASE_PARTITION_PATTERN(null), 
	TB_DND_SUBKIND_PARTITION_PATTERN(null),
	TB_DND_ROLE_PARTITION_PATTERN(null),
	TB_DND_ROLEMIXIN_PATTERN(null), 
	TB_DND_RELATOR_PATTERN(null), 
	TB_DND_DEPENDENT_ROLEMIXIN_PATTERN(null),
	TB_DND_GENERIC_RELATOR_PATTERN(null), 
	TB_DND_CHARACTERIZATION_PATTERN(null), 
	TB_DND_RIGID_WS_PATTERN(null),
	TB_DND_ANTIRIGID_WS_PATTERN(null), 
	TB_DND_KIND_PARTITION_PATTERN(null), 
	TB_DND_QUANTITY_PARTITION_PATTERN(null),
	TB_DND_COLLECTIVE_PARTITION_PATTERN(null), 
	TB_DND_CATEGORY_PATTERN(null),
	
	//====================================================
	// TOOLBOX DRAG AND DROP: DOMAIN PATTERN
	//====================================================
	TB_DND_DOMAIN_PATTERN(null),

	//====================================================
	// TOOLBOX DRAG AND DROP: DERIVED PATTERN
	//====================================================	
	TB_DND_UNION_PATTERN(null), 
	TB_DND_EXCLUSION_PATTERN(null), 
	TB_DND_INTERSECTION_PATTERN(null), 
	TB_DND_SPECIALIZATION_PATTERN(null), 
	TB_DND_PASTSPECIALIZATION_PATTERN(null), 
	TB_DND_PARTICIPATION_PATTERN(null),
	
	//====================================================
	// ADD PACKAGE
	//====================================================
	ADD_PACKAGE(null),
	
	//====================================================
	// ADD CLASS
	//====================================================	
	ADD_CLASS(null),
	ADD_KIND(null),
	ADD_COLLECTIVE(null),
	ADD_QUANTITY(null),
	ADD_SUBKIND(null),
	ADD_ROLE(null),
	ADD_PHASE(null),
	ADD_MIXIN(null),
	ADD_ROLEMIXIN(null),
	ADD_CATEGORY(null),
	ADD_RELATOR(null),
	ADD_MODE(null),
	ADD_PERCEIVABLE_QUALITY(null),
	ADD_NONPERCEIVABLE_QUALITY(null),
	ADD_NOMINAL_QUALITY(null),
	
	//====================================================
	// ADD DATATYPE
	//====================================================	
	ADD_DATATYPE(null),
	ADD_ENUMERATION(null),
	ADD_PRIMITIVETYPE(null),
	
	//====================================================
	// ADD RELATIONSHIP
	//====================================================
	ADD_GENERALIZATION(null),
	ADD_GENERALIZATIONSET(null),
	ADD_MEDIATION(null),
	ADD_FORMAL(null),
	ADD_MATERIAL(null),
	ADD_CHARACTERIZATION(null),
	ADD_COMPONENTOF(null),
	ADD_MEMBEROF(null),
	ADD_SUBCOLLECTIONOF(null),
	ADD_SUBQUANTITYOF(null),
	ADD_DERIVATION(null),
	ADD_STRUCTURATION(null),
	ADD_ASSOCIATION(null),

	//====================================================
	// ADD DERIVED PATTERN
	//====================================================
	ADD_DERIVATION_BY_UNION(null),
	ADD_DERIVATION_BY_EXCLUSION(null),
	ADD_DERIVATION_BY_SPECIALIZATION(null),
	ADD_DERIVATION_BY_INTERSECTION(null),
	ADD_DERIVATION_BY_PAST_SPECIALIZATION(null),
	ADD_DERIVATION_BY_PARTICIPATION(null),

	//====================================================
	// CHANGE STEREOTYPE OF RELATIONSHIP
	//====================================================
	CHANGE_TO_GENERALIZATION(null),
	CHANGE_TO_GENERALIZATIONSET(null),
	CHANGE_TO_MEDIATION(null),
	CHANGE_TO_FORMAL(null),
	CHANGE_TO_MATERIAL(null),
	CHANGE_TO_CHARACTERIZATION(null),
	CHANGE_TO_COMPONENTOF(null),
	CHANGE_TO_MEMBEROF(null),
	CHANGE_TO_SUBCOLLECTIONOF(null),
	CHANGE_TO_SUBQUANTITYOF(null),
	CHANGE_TO_DERIVATION(null),
	CHANGE_TO_STRUCTURATION(null),
	CHANGE_TO_ASSOCIATION(null),
	
	//====================================================
	// CHANGE STEREOTYPE OF CLASS
	//====================================================
	CHANGE_TO_KIND(null),
	CHANGE_TO_SUBKIND(null),
	CHANGE_TO_COLLECTIVE(null),
	CHANGE_TO_QUANTITY(null),
	CHANGE_TO_ROLE(null),
	CHANGE_TO_PHASE(null),
	CHANGE_TO_CATEGORY(null),
	CHANGE_TO_MIXIN(null),
	CHANGE_TO_RELATOR(null),
	CHANGE_TO_MODE(null),
	CHANGE_TO_ROLEMIXIN(null),
	CHANGE_TO_PERCEIVABLE_QUALITY(null),
	CHANGE_TO_NONPERCEIVABLE_QUALITY(null),
	CHANGE_TO_NOMINAL_QUALITY(null),
	
	CREATE_DND_GENERALIZATIONSET(null),	
	DELETE_DND_GENERALIZATIONSET(null);
	
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
