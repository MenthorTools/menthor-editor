package net.menthor.editor.v2.commands;

import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;

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
	QUIT_APPLICATION(null),

	REDO("Redo action"),	
	UNDO("Undo action"),
	DUPLICATE("Duplicate selected element"),
	COPY("Copy element to clipboard"),
	PASTE("Paste clipboard elements"),
	EDIT("Edit selected element(s)"),
	RENAME("Rename selected element"),
	DELETE("Delete selected element(s)"),
	ERASE("Erase selected element(s) from diagram"),
	DELETE_CURRENT("Delete selected element(s)"), 
	ERASE_CURRENT("Delete selected element(s) from diagram"),
	ADD_RELATED_ELEMENTS_TO_DIAGRAM("Add all related elements"),
		
	ADD_OCLDOCUMENT("Createa a new rules document"),
	CLOSE_OCL_EDITOR("Createa a new rules document"),
		
	INITIALIZE_SHOWGRID_MENUITEM(null),
	ADD_DIAGRAM("Create a new class diagram"), 
	CLOSE_DIAGRAM_EDITOR("Close current class diagram"),	
	REDRAW_DIAGRAM("Redraw the current class diagram"),
	SELECT_ALL("Select all elements on current diagram"),
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
	NEW_GEN_SET_DIAGRAM(null),
	APPLY_DIRECT_STYLE(null), 
	APPLY_RECTILINEAR_STYLE(null), 
	
	SET_BACKGROUND_COLOR("Setup background color for selected classes"),
	COPY_BACKGROUND_COLOR("Copy background color from selected classes"),
	PASTE_BACKGROUND_COLOR("Paste background color into selected classes"),
	
	SHOW_ATTRIBUTES(null),
	SHOW_END_POINT_NAMES(null),
	SHOW_SUBSETTING(null),
	SHOW_REDEFINITIONS(null),
	SHOW_MULTIPLICITIES(null),
	SHOW_NAME(null),
	SHOW_STEREOTYPE(null),
	SHOW_CLASS_STEREOTYPE(null),
	SHOW_NAMESPACE(null), 
	SHOW_PARENTS(null), 
	SHOW_GENERALIZATION_SETS(null), 
	READING_DIRECTION_SOURCE(null),
	READING_DIRECTION_TARGET(null),
	READING_DIRECTION_UNSPECIFIED(null),
	
	MOVE_SELECTED_TREE_TO_DIAGRAM(null),
	
	EXPORT_AS_PATTERN("Export current project as a pattern"),	
	EXPORT_TO_UML("Export current project to UML (UML2)"), 
	EXPORT_TO_PROFILE_UML("Export current project to Profile UML (UML2)"),
	EXPORT_TO_ECORE("Export current project to Ecore (EMF)"),
	EXPORT_TO_REFERENCE_ONTOUML("Export current project to XMI (EMF)"),
		
	IMPORT_FROM_XMI_EMF(null), 
	IMPORT_FROM_XMI_EA(null), 
	IMPORT_FROM_XMI_EA_FILE(null), 
	IMPORT_FROM_PATTERN(null),
	
	SHOW_PALETTE(null), 
	SHOW_PROJECT_BROWSER(null), 
	SHOW_INFO_TABBED_PANE(null),
		
	ABOUT(null), 
	LICENSES(null), 

	ADD_FINDER_EDITOR("Find a term in current project"),
	FIND_IN_PROJECT_BROWSER("Find a term in project browser"),
	FIND_BY_NAME("Find element strictly by its name"),
	ADD_STATISTICS_EDITOR("Collect statistics of current project"),
	
	MOVE_DOWN_TREE(null),
	MOVE_UP_TREE(null),
	ADD_TREE_NODE_TO_DIAGRAM(null),
	FIND_IN_DIAGRAMS(null),
	
	VERIFY_MODEL("Check syntax of the entire model"), 
	VERIFY_CONSTRAINTS("Check syntax of all OCL rules at the current project"),
	 
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
	PALLETE_CLASS("A simple UML class."),
	PALLETE_KIND("<html>A Kind provides identity to its instances. A Kind can be a Chair, a Person, a Car, etc.</html>"), 
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
	ADD_INTEGERINTERVAL_DIMENSION(null),
	ADD_INTEGERRATIONAL_DIMENSION(null),
	ADD_INTEGERORDINAL_DIMENSION(null),
	ADD_DECIMALORDINAL_DIMENSION(null),
	ADD_DECIMALRATIONAL_DIMENSION(null),
	ADD_DECIMALINTERVAL_DIMENSION(null),
	ADD_STRINGNOMINAL_STRUCTURE(null),
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
	
	ADD_DIAGRAM_TO_TREE_NODE(null),
	ADD_OCLDOCUMENT_TO_TREE_NODE(null),
	
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
	CHANGE_TO_CLASS(null),
	
	CHANGE_TO_DATATYPE(null),
	CHANGE_TO_PRIMITIVETYPE(null),
	CHANGE_TO_ENUMERATION(null),
	CHANGE_TO_DECIMALINTERVAL_DIMENSION(null),
	CHANGE_TO_DECIMALRATIONAL_DIMENSION(null),
	CHANGE_TO_DECIMALORDINAL_DIMENSION(null),
	CHANGE_TO_INTEGERINTERVAL_DIMENSION(null),
	CHANGE_TO_INTEGERRATIONAL_DIMENSION(null),
	CHANGE_TO_INTEGERORDINAL_DIMENSION(null),
	CHANGE_TO_MEASUREMENT_DOMAIN(null),
	CHANGE_TO_STRINGNOMINAL_STRUCTURE(null),
	
	INVERT_END_NAMES(null),
	INVERT_END_POINTS(null),
	INVERT_END_MULTIPLICITIES(null),
	INVERT_END_TYPES(null), 
	
	SET_ABSTRACT(null), 
	SET_DERIVED(null), 
	SET_EXTENSIONAL(null),
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
	
	//TODO: add actions
	
	DELETE_GS_DIAGRAM(null), 
	ADD_TO_GEN_SET_DIAGRAM(null), 
	REMOVE_FROM_GS_DIAGRAM(null),
	
	SHOW_ALL(null);
	
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
		if(classType==ClassType.QUANTITY) return PALLETE_QUANTITY;
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
	
	public static CommandType getPalleteCommandType(RelationshipType relType){		
		if(relType==RelationshipType.CHARACTERIZATION) return PALLETE_CHARACTERIZATION;
		if(relType==RelationshipType.COMPONENTOF) return PALLETE_COMPONENTOF;
		if(relType==RelationshipType.DERIVATION) return PALLETE_DERIVATION;
		if(relType==RelationshipType.FORMAL) return PALLETE_FORMAL;
		if(relType==RelationshipType.GENERALIZATION) return PALLETE_GENERALIZATION;
		if(relType==RelationshipType.MATERIAL) return PALLETE_MATERIAL;
		if(relType==RelationshipType.MEDIATION) return PALLETE_MEDIATION;
		if(relType==RelationshipType.MEMBEROF) return PALLETE_MEMBEROF;
		if(relType==RelationshipType.STRUCTURATION) return PALLETE_STRUCTURATION;
		if(relType==RelationshipType.SUBCOLLECTIONOF) return PALLETE_SUBCOLLECTIONOF;
		if(relType==RelationshipType.SUBQUANTITYOF) return PALLETE_SUBQUANTITYOF;
		if(relType==RelationshipType.ASSOCIATION) return PALLETE_ASSOCIATION;
		return PALLETE_ASSOCIATION;
	}
	
	public static CommandType getAddCommandType(ClassType classType){
		if(classType==ClassType.KIND) return ADD_KIND;
		if(classType==ClassType.QUANTITY) return ADD_QUANTITY;
		if(classType==ClassType.SUBKIND) return ADD_SUBKIND;
		if(classType==ClassType.COLLECTIVE) return ADD_COLLECTIVE;
		if(classType==ClassType.PHASE) return ADD_PHASE;
		if(classType==ClassType.ROLE) return ADD_ROLE;
		if(classType==ClassType.MIXIN) return ADD_MIXIN;
		if(classType==ClassType.CATEGORY) return ADD_CATEGORY;
		if(classType==ClassType.ROLEMIXIN) return ADD_ROLEMIXIN;
		if(classType==ClassType.MODE) return ADD_MODE;
		if(classType==ClassType.RELATOR) return ADD_RELATOR;
		if(classType==ClassType.NONPERCEIVABLE_QUALITY) return ADD_NONPERCEIVABLE_QUALITY;
		if(classType==ClassType.PERCEIVABLE_QUALITY) return ADD_PERCEIVABLE_QUALITY;
		if(classType==ClassType.NOMINAL_QUALITY) return ADD_NOMINAL_QUALITY;
		return ADD_CLASS;
	}
	
	public static CommandType getAddCommandType(RelationshipType relType){		
		if(relType==RelationshipType.CHARACTERIZATION) return ADD_CHARACTERIZATION;
		if(relType==RelationshipType.COMPONENTOF) return ADD_COMPONENTOF;
		if(relType==RelationshipType.DERIVATION) return ADD_DERIVATION;
		if(relType==RelationshipType.FORMAL) return ADD_FORMAL;
		if(relType==RelationshipType.GENERALIZATION) return ADD_GENERALIZATION;
		if(relType==RelationshipType.MATERIAL) return ADD_MATERIAL;
		if(relType==RelationshipType.MEDIATION) return ADD_MEDIATION;
		if(relType==RelationshipType.MEMBEROF) return ADD_MEMBEROF;
		if(relType==RelationshipType.STRUCTURATION) return ADD_STRUCTURATION;
		if(relType==RelationshipType.SUBCOLLECTIONOF) return ADD_SUBCOLLECTIONOF;
		if(relType==RelationshipType.SUBQUANTITYOF) return ADD_SUBQUANTITYOF;
		if(relType==RelationshipType.ASSOCIATION) return ADD_ASSOCIATION;
		return ADD_ASSOCIATION;
	}
	
	public static CommandType getAddCommandType(DataType dataType){
		if(dataType==DataType.DECIMALINTERVAL_DIMENSION) return ADD_DECIMALINTERVAL_DIMENSION;
		if(dataType==DataType.DECIMALORDINAL_DIMENSION) return ADD_DECIMALORDINAL_DIMENSION;
		if(dataType==DataType.DECIMALRATIONAL_DIMENSION) return ADD_DECIMALRATIONAL_DIMENSION;
		if(dataType==DataType.INTEGERINTERVAL_DIMENSION) return ADD_INTEGERINTERVAL_DIMENSION;
		if(dataType==DataType.INTEGERORDINAL_DIMENSION) return ADD_INTEGERORDINAL_DIMENSION;
		if(dataType==DataType.INTEGERRATIONAL_DIMENSION) return ADD_INTEGERRATIONAL_DIMENSION;
		if(dataType==DataType.MEASUREMENT_DOMAIN) return ADD_MEASUREMENT_DOMAIN;
		if(dataType==DataType.ENUMERATION) return ADD_ENUMERATION;
		if(dataType==DataType.STRINGNOMINAL_STRUCTURE) return ADD_STRINGNOMINAL_STRUCTURE;
		if(dataType==DataType.PRIMITIVETYPE) return ADD_PRIMITIVETYPE;
		if(dataType==DataType.DATATYPE) return ADD_DATATYPE;		
		return ADD_DATATYPE;
	}
	
	public static CommandType getChangeToCommandType(ClassType classType){
		if(classType==ClassType.KIND) return CHANGE_TO_KIND;
		if(classType==ClassType.QUANTITY) return CHANGE_TO_QUANTITY;
		if(classType==ClassType.SUBKIND) return CHANGE_TO_SUBKIND;
		if(classType==ClassType.COLLECTIVE) return CHANGE_TO_COLLECTIVE;
		if(classType==ClassType.PHASE) return CHANGE_TO_PHASE;
		if(classType==ClassType.ROLE) return CHANGE_TO_ROLE;
		if(classType==ClassType.MIXIN) return CHANGE_TO_MIXIN;
		if(classType==ClassType.CATEGORY) return CHANGE_TO_CATEGORY;
		if(classType==ClassType.ROLEMIXIN) return CHANGE_TO_ROLEMIXIN;
		if(classType==ClassType.MODE) return CHANGE_TO_MODE;
		if(classType==ClassType.RELATOR) return CHANGE_TO_RELATOR;
		if(classType==ClassType.NONPERCEIVABLE_QUALITY) return CHANGE_TO_NONPERCEIVABLE_QUALITY;
		if(classType==ClassType.PERCEIVABLE_QUALITY) return CHANGE_TO_PERCEIVABLE_QUALITY;
		if(classType==ClassType.NOMINAL_QUALITY) return CHANGE_TO_NOMINAL_QUALITY;
		return CHANGE_TO_CLASS;
	}
	
	public static CommandType getChangeToCommandType(RelationshipType relType){		
		if(relType==RelationshipType.CHARACTERIZATION) return CHANGE_TO_CHARACTERIZATION;
		if(relType==RelationshipType.COMPONENTOF) return CHANGE_TO_COMPONENTOF;
		if(relType==RelationshipType.DERIVATION) return CHANGE_TO_DERIVATION;
		if(relType==RelationshipType.FORMAL) return CHANGE_TO_FORMAL;
		if(relType==RelationshipType.GENERALIZATION) return CHANGE_TO_GENERALIZATION;
		if(relType==RelationshipType.MATERIAL) return CHANGE_TO_MATERIAL;
		if(relType==RelationshipType.MEDIATION) return CHANGE_TO_MEDIATION;
		if(relType==RelationshipType.MEMBEROF) return CHANGE_TO_MEMBEROF;
		if(relType==RelationshipType.STRUCTURATION) return CHANGE_TO_STRUCTURATION;
		if(relType==RelationshipType.SUBCOLLECTIONOF) return CHANGE_TO_SUBCOLLECTIONOF;
		if(relType==RelationshipType.SUBQUANTITYOF) return CHANGE_TO_SUBQUANTITYOF;
		if(relType==RelationshipType.ASSOCIATION) return CHANGE_TO_ASSOCIATION;
		return CHANGE_TO_ASSOCIATION;
	}
	
	public static CommandType getChangeToCommandType(DataType dataType){
		if(dataType==DataType.DECIMALINTERVAL_DIMENSION) return CHANGE_TO_DECIMALINTERVAL_DIMENSION;
		if(dataType==DataType.DECIMALORDINAL_DIMENSION) return CHANGE_TO_DECIMALORDINAL_DIMENSION;
		if(dataType==DataType.DECIMALRATIONAL_DIMENSION) return CHANGE_TO_DECIMALRATIONAL_DIMENSION;
		if(dataType==DataType.INTEGERINTERVAL_DIMENSION) return CHANGE_TO_INTEGERINTERVAL_DIMENSION;
		if(dataType==DataType.INTEGERORDINAL_DIMENSION) return CHANGE_TO_INTEGERORDINAL_DIMENSION;
		if(dataType==DataType.INTEGERRATIONAL_DIMENSION) return CHANGE_TO_INTEGERRATIONAL_DIMENSION;
		if(dataType==DataType.MEASUREMENT_DOMAIN) return CHANGE_TO_MEASUREMENT_DOMAIN;
		if(dataType==DataType.ENUMERATION) return CHANGE_TO_ENUMERATION;
		if(dataType==DataType.STRINGNOMINAL_STRUCTURE) return CHANGE_TO_STRINGNOMINAL_STRUCTURE;
		if(dataType==DataType.PRIMITIVETYPE) return CHANGE_TO_PRIMITIVETYPE;
		if(dataType==DataType.DATATYPE) return CHANGE_TO_DATATYPE;		
		return CHANGE_TO_DATATYPE;
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
