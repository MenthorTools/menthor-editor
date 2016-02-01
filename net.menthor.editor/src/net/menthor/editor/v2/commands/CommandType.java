package net.menthor.editor.v2.commands;

import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;

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
	
	NEW_PROJECT("Create new menthor project"),
	NEW_PROJECT_FROM_MODEL("Create new menthor project from a model in memory"),
	OPEN_EXISTING_PROJECT("Open existing menthor project"),	
	OPEN_RECENT_PROJECT("Save current menthor project"), 
	CLOSE_PROJECT("Close current menthor project"), 
	SAVE_PROJECT_AS("Save current menthor project"), 
	SAVE_PROJECT("Save current menthor project as..."), 
	OPEN_LINK_WITH_BROWSER("Open link with browser"),	
	QUIT_MENTHOR(null),

	REDO("Redo action"),	
	UNDO("Undo action"),
	DUPLICATE("Duplicate selected element"),
	COPY("Copy element to clipboard"),
	PASTE("Paste clipboard elements"),
	EDIT("Edit selected element(s)"),
	RENAME("Rename selected element"),
	DELETE("Delete selected element(s)"),
	ERASE("Erase selected element(s)"),
	ADD_ALL_RELATED_ELEMENTS("Add all related elements"),
		
	NEW_OCLDOCUMENT("Createa a new rules document"),
	CLOSE_OCL_EDITOR("Createa a new rules document"),
		
	INITIALIZE_SHOWGRID_MENUITEM(null),
	NEW_DIAGRAM("Create a new class diagram"), 
	CLOSE_DIAGRAM_EDITOR("Close current class diagram"),	
	REDRAW_DIAGRAM("Redraw the current class diagram"),
	SELECT_ALL_DIAGRAM("Select all elements on current diagram"),
	EXPORT_TO_PNG("<html>Save diagram as PNG<br><br>TIP: Move your diagram as close as possible <br>to the upper left side of the grid.</hmtl>"),
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
	RESET_POINTS("Reset connection points in the selected relationship"),
	CHANGE_FROM_RECT_TO_DIRECT("Change line style from Rectilinear to Direct"), 
	CHANGE_FROM_DIRECT_TO_RECT("Change line style from Direct to Rectilinear"),
	APPLY_VERTICAL_STYLE("Apply vertical style on line"),
	APPLY_HORIZONTAL_STYLE("Apply horizontal style on line"),	
	DELETE_GEN_SET_DIAGRAM(null),
	ADD_GEN_SET_DIAGRAM(null),
	APPLY_DIRECT_STYLE(null), 
	APPLY_RECTILINEAR_STYLE(null), 
	SET_BACKGROUND_COLOR("Set the background color for selected classes"),
	SETUP_BACKGROUND_COLOR("Setup background color for selected classes"),
	COPY_BACKGROUND_COLOR("Copy background color from selected classes"),
	PASTE_BACKGROUND_COLOR("Paste background color into selected classes"),
	SHOW_ATTRIBUTES(null),
	SHOW_END_POINT_NAMES(null),
	SHOW_SUBSETTING(null),
	SHOW_REDEFINITIONS(null),
	SHOW_MULTIPLICITIES(null),
	SHOW_NAME(null),
	SHOW_STEREOTYPE(null),
	READING_DIRECTION_SOURCE(null),
	READING_DIRECTION_TARGET(null),
	READING_DIRECTION_UNSPECIFIED(null),
	SUBSETS_SOURCE(null),
	SUBSETS_TARGET(null),
	REDEFINES_SOURCE(null),
	REDEFINES_TARGET(null),
	SET_INSEPARABLE(null),
	SET_ESSENTIAL(null),
	SET_IMMUTABLEWHOLE(null),
	SET_IMMUTABLEPART(null),
	SET_SHAREABLE(null),
	OPTIONAL_ON_SOURCE(null),
	OPTIONAL_ON_TARGET(null),
	SINGULAR_ON_TARGET(null),
	SINGULAR_ON_SOURCE(null),
	SOME_ON_TARGET(null),
	SOME_ON_SOURCE(null),
	ANY_ON_SOURCE(null),
	ANY_ON_TARGET(null),
	TWO_ON_SOURCE(null),
	TWO_ON_TARGET(null),
	TWO_AT_LEAST_ON_SOURCE(null),
	TWO_AT_LEAST_ON_TARGET(null),
	OTHER_ON_SOURCE(null),
	OTHER_ON_TARGET(null),
	SET_SOURCE_END_POINT_NAME(null),
	SET_TARGET_END_POINT_NAME(null),
	BRING_FROM_PROJECT_BROWSER(null),
	
	EXPORT_AS_PATTERN("Export current project as a pattern"),	
	EXPORT_TO_UML("Export current project to UML (UML2)"), 
	EXPORT_TO_PROFILE_UML("Export current project to Profile UML (UML2)"),
	EXPORT_TO_ECORE("Export current project to Ecore (EMF)"),
	EXPORT_TO_REFERENCE_ONTOUML("Export current project to XMI (EMF)"),
		
	IMPORT_FROM_XMI_EMF(null), 
	IMPORT_FROM_XMI_EA(null), 
	IMPORT_FROM_XMI_EA_FILE(null), 
	IMPORT_FROM_PATTERN(null),
	
	PALETTE_OF_ELEMENTS(null), 
	PROJECT_BROWSER(null), 
	CONSOLE(null),
		
	ABOUT(null), 
	LICENSES(null), 

	ADD_FINDER_EDITOR("Find a term in current project"),
	FIND_IN_PROJECT_BROWSER("Find a term in project browser"),
	FIND_BY_NAME("Find element strictly by its name"),
	ADD_STATISTICS_EDITOR("Collect statistics of current project"),
	
	MOVE_DOWN_TREE(null),
	MOVE_UP_TREE(null),
	MOVE_TO_DIAGRAM(null),
	FIND_IN_DIAGRAMS(null),
	
	VERIFY_MODEL("Check syntax of the entire model"), 
	VERIFY_CONSTRAINTS("Check syntax of all rules at the current project"),
	 
	ALLOY_SETTINGS("Simulate and check current project using Alloy"), 
	OWL_SETTINGS("Generate current project implementation in OWL/RDF"),
	GENERATE_OWL("Generate current project implementation in OWL/RDF"),
	GENERATE_SBVR("Transform current project into a SBVR business vocabulary"),
	GLOSSARY_SETTINGS("Transform current project into Natural Language"),	
	SEARCH_FOR_ANTIPATTERNS("Search for semantic anti-patterns in current project"),
	VALIDATE_PARTHOOD_TRANSITIVITY("Validate the transitivity of parthood relationships"),
	
	SELECT_EDITOR("Select tab"),
	ADD_EDITOR("Add to a tab"),
	CLOSE_THIS("Close this tab"),
	CLOSE_OTHER("Close all other tabs except this one"),
	CLOSE_ALL("Close all tabs"),
	
	PALLETE_POINTER_MODE(null),
	PALLETE_CLASS(null),
	PALLETE_KIND(null), 
	PALLETE_QUANTITY(null), 
	PALLETE_COLLECTIVE(null), 
	PALLETE_SUBKIND(null), 
	PALLETE_PHASE(null), 
	PALLETE_ROLE(null),
	PALLETE_RELATOR(null), 
	PALLETE_MODE(null), 
	PALLETE_PERCEIVABLE_QUALITY(null), 
	PALLETE_NONPERCEIVABLE_QUALITY(null), 
	PALLETE_NOMINAL_QUALITY(null),
	PALLETE_CATEGORY(null), 
	PALLETE_MIXIN(null), 
	PALLETE_ROLEMIXIN(null), 
	PALLETE_PHASEMIXIN(null), 
	PALLETE_EVENT(null),	
	PALLETE_POWERTYPE(null), 
		
	PALLETE_DATATYPE(null), 
	PALLETE_ENUMERATION(null),
	PALLETE_PRIMITIVETYPE(null),
	PALLETE_MEASUREMENT_DOMAIN(null),
	PALLETE_INTEGERINTERVAL_DIMENSION(null),
	PALLETE_INTEGERRATIONAL_DIMENSION(null),
	PALLETE_INTEGERORDINAL_DIMENSION(null),
	PALLETE_DECIMALINTERVAL_DIMENSION(null),
	PALLETE_DECIMALRATIONAL_DIMENSION(null),
	PALLETE_DECIMALORDINAL_DIMENSION(null),
	PALLETE_STRINGNOMINAL_STRUCTURE(null),

	PALLETE_GENERALIZATION(null),
	PALLETE_GENERALIZATIONSET(null), 
	PALLETE_MEDIATION(null), 
	PALLETE_CHARACTERIZATION(null), 
	PALLETE_DERIVATION(null), 
	PALLETE_FORMAL(null),
	PALLETE_MATERIAL(null), 
	PALLETE_STRUCTURATION(null), 
	PALLETE_COMPONENTOF(null), 
	PALLETE_MEMBEROF(null), 
	PALLETE_SUBCOLLECTIONOF(null), 
	PALLETE_SUBQUANTITYOF(null), 
	PALLETE_ASSOCIATION(null),
		
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
		
	ADD_DATATYPE(null),
	ADD_ENUMERATION(null),
	ADD_PRIMITIVETYPE(null),
	ADD_INTEGER_INTERVAL_DIMENSION(null),
	ADD_INTEGER_RATIONAL_DIMENSION(null),
	ADD_INTEGER_ORDINAL_DIMENSION(null),
	ADD_DECIMAL_ORDINAL_DIMENSION(null),
	ADD_DECIMAL_RATIONAL_DIMENSION(null),
	ADD_DECIMAL_INTERVAL_DIMENSION(null),
	ADD_STRING_NOMINAL_STRUCTURE(null),
	ADD_MEASUREMENT_DOMAIN(null),
	
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
	
	ADD_PACKAGE(null),
	ADD_COMMENT(null),
	ADD_CONSTRAINT(null),
	
	ADD_DIAGRAM(null),
	ADD_OCLDOCUMENT(null),
	
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
	
	INVERT_END_NAMES(null),
	INVERT_END_POINTS(null),
	INVERT_END_MULTIPLICITIES(null),
	INVERT_END_TYPES(null);
	
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
	
	public static CommandType getPalleteCommandType(ClassType classType){
		if(classType==ClassType.KIND) return PALLETE_KIND;
		if(classType==ClassType.SUBKIND) return PALLETE_SUBKIND;
		if(classType==ClassType.COLLECTIVE) return PALLETE_COLLECTIVE;
		if(classType==ClassType.PHASE) return PALLETE_PHASE;
		if(classType==ClassType.ROLE) return PALLETE_ROLE;
		if(classType==ClassType.MIXIN) return PALLETE_MIXIN;
		if(classType==ClassType.CATEGORY) return PALLETE_CATEGORY;
		if(classType==ClassType.ROLEMIXIN) return PALLETE_ROLEMIXIN;
		if(classType==ClassType.MODE) return PALLETE_MODE;
		if(classType==ClassType.RELATOR) return PALLETE_RELATOR;
		if(classType==ClassType.NONPERCEIVABLE_QUALITY) return PALLETE_NONPERCEIVABLE_QUALITY;
		if(classType==ClassType.PERCEIVABLE_QUALITY) return PALLETE_PERCEIVABLE_QUALITY;
		if(classType==ClassType.NOMINAL_QUALITY) return PALLETE_NOMINAL_QUALITY;
		return PALLETE_CLASS;
	}
	
	public static CommandType getPalleteCommandType(DataType dataType){
		if(dataType==DataType.DECIMALINTERVAL_DIMENSION) return PALLETE_DECIMALINTERVAL_DIMENSION;
		if(dataType==DataType.DECIMALORDINAL_DIMENSION) return PALLETE_DECIMALORDINAL_DIMENSION;
		if(dataType==DataType.DECIMALRATIONAL_DIMENSION) return PALLETE_DECIMALRATIONAL_DIMENSION;
		if(dataType==DataType.INTEGERINTERVAL_DIMENSION) return PALLETE_INTEGERINTERVAL_DIMENSION;
		if(dataType==DataType.INTEGERORDINAL_DIMENSION) return PALLETE_INTEGERORDINAL_DIMENSION;
		if(dataType==DataType.INTEGERRATIONAL_DIMENSION) return PALLETE_INTEGERRATIONAL_DIMENSION;
		if(dataType==DataType.MEASUREMENT_DOMAIN) return PALLETE_MEASUREMENT_DOMAIN;
		if(dataType==DataType.ENUMERATION) return PALLETE_ENUMERATION;
		if(dataType==DataType.STRINGNOMINAL_STRUCTURE) return PALLETE_STRINGNOMINAL_STRUCTURE;
		if(dataType==DataType.PRIMITIVETYPE) return PALLETE_PRIMITIVETYPE;
		if(dataType==DataType.DATATYPE) return PALLETE_DATATYPE;		
		return PALLETE_DATATYPE;
	}
	
	public static CommandType getCommandType(String command){
		for(CommandType ct: values()){			
			if(ct.toString().compareToIgnoreCase(command)==0) return ct;
		}
		return null;
	}
	
	public static boolean isValueOf(String command)
	{
		for(CommandType ct: values()){
			if(ct.toString().compareToIgnoreCase(command)==0) return true;
		}
		return false;
	}
}
