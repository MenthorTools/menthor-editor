package net.menthor.editor.v2.commands;

import java.awt.Component;
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
 * 
 * @author John Guerson
 */

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.ui.diagram.DiagramEditor;

import net.menthor.editor.MainFrame;
import net.menthor.editor.DiagramManager;
import net.menthor.editor.v2.trees.BaseCheckBoxTree;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.PatternType;
import net.menthor.editor.v2.types.RelationshipType;

public class CommandMap {
	
	private static CommandMap instance = new CommandMap();
	
	private Map<CommandType, MethodCall> cmdMap = new HashMap<CommandType, MethodCall>();
	private Map<CommandType, String> descMap = new HashMap<CommandType, String>();
	public Map<CommandType, MethodCall> getMap() { return cmdMap; }
	
	public String getDescription(CommandType cmdType) { return descMap.get(cmdType); }	
	public MethodCall getMethodCall(CommandType cmdType){ return cmdMap.get(cmdType); }	
	public static CommandMap getInstance() { return instance; }
	
	public void addParameter(CommandType cmdType, Object parameter){
		if(getMap().get(cmdType)!=null) getMap().get(cmdType).set(parameter);
	}
	
	/** constructor */
	private CommandMap(){
		try {
			
			file();					
			exportation();
			importation();
			edit();
			tabs();
			diagram();
			rules();
			project();
			verificate();
			validate();
			window();
			help();
						
			dnd(); //palette's drag and drop
			additions(); //tree's additions			
			changes(); //stereotype change
			basetree(); 
			projecttree();
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	private void file() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.NEW_PROJECT,
				new MethodCall(DiagramManager.class.getMethod("newProject")));
		cmdMap.put(CommandType.OPEN_PROJECT,
				new MethodCall(DiagramManager.class.getMethod("openProject")));
		cmdMap.put(CommandType.CLOSE_PROJECT,
				new MethodCall(DiagramManager.class.getMethod("closeCurrentProject")));
		cmdMap.put(CommandType.OPEN_RECENT_PROJECT,
				new MethodCall(DiagramManager.class.getMethod("openRecentProject")));			
		cmdMap.put(CommandType.SAVE_PROJECT_AS,
				new MethodCall(DiagramManager.class.getMethod("saveProjectAs")));
		cmdMap.put(CommandType.SAVE_PROJECT,
				new MethodCall(DiagramManager.class.getMethod("saveProject")));
		cmdMap.put(CommandType.QUIT_MENTHOR,
				new MethodCall(MainFrame.class.getMethod("quitApplication")));
		cmdMap.put(CommandType.OPEN_LINK_WITH_BROWSER,
				new MethodCall(DiagramManager.class.getMethod("openLinkWithBrowser", String.class)));
	}
	
	private void exportation() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.EXPORT_TO_ECORE,
				new MethodCall(DiagramManager.class.getMethod("exportToEcore")));
		cmdMap.put(CommandType.EXPORT_TO_UML,
				new MethodCall(DiagramManager.class.getMethod("exportToUML")));
		cmdMap.put(CommandType.EXPORT_TO_PROFILE_UML,
				new MethodCall(DiagramManager.class.getMethod("exportToProfileUML")));		
		cmdMap.put(CommandType.EXPORT_TO_XMI,
				new MethodCall(DiagramManager.class.getMethod("exportToXMI")));
		cmdMap.put(CommandType.EXPORT_AS_PATTERN,
				new MethodCall(DiagramManager.class.getMethod("exportAsPattern")));
	}
	
	private void importation() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.IMPORT_FROM_XMI_EMF,
				new MethodCall(DiagramManager.class.getMethod("importFromXMI")));
		cmdMap.put(CommandType.IMPORT_FROM_PATTERN,
				new MethodCall(DiagramManager.class.getMethod("importFromPattern")));
		cmdMap.put(CommandType.IMPORT_FROM_XMI_EA,
				new MethodCall(DiagramManager.class.getMethod("importFromEA")));
		cmdMap.put(CommandType.IMPORT_FROM_XMI_EA_FILE,
				new MethodCall(DiagramManager.class.getMethod("importFromEARecent")));
	}

	private void basetree() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.MOVE_UP_TREE,
				new MethodCall(BaseCheckBoxTree.class.getMethod("moveUp")));
		cmdMap.put(CommandType.MOVE_DOWN_TREE,
				new MethodCall(BaseCheckBoxTree.class.getMethod("moveDown")));		
	}

	private void projecttree() throws NoSuchMethodException, SecurityException{		
		cmdMap.put(CommandType.MOVE_TO_DIAGRAM,
				new MethodCall(DiagramManager.class.getMethod("moveToDiagram", Object.class)));
		cmdMap.put(CommandType.FIND_IN_DIAGRAMS,
				new MethodCall(DiagramManager.class.getMethod("findInDiagrams", Object.class)));
	}
	
	private void edit() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.REDO,
				new MethodCall(DiagramManager.class.getMethod("redo")));
		cmdMap.put(CommandType.UNDO,
				new MethodCall(DiagramManager.class.getMethod("undo")));
		cmdMap.put(CommandType.RENAME,
				new MethodCall(DiagramManager.class.getMethod("rename", Object.class)));
		cmdMap.put(CommandType.EDIT, 
				new MethodCall(DiagramEditor.class.getMethod("editProperties", Object.class)));		
		cmdMap.put(CommandType.DELETE, 
				new MethodCall(DiagramEditor.class.getMethod("deleteSelection", Object.class)));		
		cmdMap.put(CommandType.ERASE, 
				new MethodCall(DiagramEditor.class.getMethod("excludeSelection", Object.class)));
	}
	
	private void rules() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.NEW_RULES,
				new MethodCall(DiagramManager.class.getMethod("newRulesDocument")));
		cmdMap.put(CommandType.CLOSE_RULES,
				new MethodCall(DiagramManager.class.getMethod("closeOclDocument")));
	}

	private void diagram() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.NEW_DIAGRAM,
				new MethodCall(DiagramManager.class.getMethod("newDiagram")));
		cmdMap.put(CommandType.CLOSE_DIAGRAM,
				new MethodCall(DiagramManager.class.getMethod("closeDiagram")));
		cmdMap.put(CommandType.SELECT_ALL_DIAGRAM,
				new MethodCall(DiagramEditor.class.getMethod("selectAll")));
		cmdMap.put(CommandType.SAVE_DIAGRAM_AS_IMAGE,
				new MethodCall(DiagramManager.class.getMethod("exportGfx")));
		cmdMap.put(CommandType.SHOW_GRID,
				new MethodCall(DiagramEditor.class.getMethod("showGrid")));		
		cmdMap.put(CommandType.REDRAW_DIAGRAM,
				new MethodCall(DiagramEditor.class.getMethod("redraw")));
		cmdMap.put(CommandType.FIT_TO_WINDOW,
				new MethodCall(DiagramEditor.class.getMethod("fitToWindow")));
		cmdMap.put(CommandType.ZOOM_OUT,
				new MethodCall(DiagramEditor.class.getMethod("zoomOut")));
		cmdMap.put(CommandType.ZOOM_AT_100,
				new MethodCall(DiagramEditor.class.getMethod("zoom100")));
		cmdMap.put(CommandType.ZOOM_IN,
				new MethodCall(DiagramEditor.class.getMethod("zoomIn")));
		cmdMap.put(CommandType.PUT_BACK,
				new MethodCall(DiagramEditor.class.getMethod("putToBack")));
		cmdMap.put(CommandType.BRING_TO_FRONT,
				new MethodCall(DiagramEditor.class.getMethod("bringToFront")));
		cmdMap.put(CommandType.ALIGN_VERTICAL,
				new MethodCall(DiagramEditor.class.getMethod("executeAlignCenterVertically")));
		cmdMap.put(CommandType.ALIGN_HORIZONTAL,
				new MethodCall(DiagramEditor.class.getMethod("executeAlignCenterHorizontally")));
		cmdMap.put(CommandType.ALIGN_TOP,
				new MethodCall(DiagramEditor.class.getMethod("executeAlignTop")));
		cmdMap.put(CommandType.ALIGN_BOTTOM,
				new MethodCall(DiagramEditor.class.getMethod("executeAlignBottom")));
		cmdMap.put(CommandType.ALIGN_LEFT,
				new MethodCall(DiagramEditor.class.getMethod("executeAlignLeft")));
		cmdMap.put(CommandType.ALIGN_RIGHT,
				new MethodCall(DiagramEditor.class.getMethod("executeAlignRight")));
		cmdMap.put(CommandType.RESET_POINTS, 
			new MethodCall(DiagramEditor.class.getMethod("resetConnectionPoints", Object.class)));
		cmdMap.put(CommandType.APPLY_DIRECT_STYLE, 
			new MethodCall(DiagramEditor.class.getMethod("toDirect", Object.class)));
		cmdMap.put(CommandType.APPLY_RECTILINEAR_STYLE, 
			new MethodCall(DiagramEditor.class.getMethod("toRectilinear", Object.class)));
		cmdMap.put(CommandType.APPLY_VERTICAL_STYLE, 
			new MethodCall(DiagramEditor.class.getMethod("toTreeStyleVertical", Object.class)));		
		cmdMap.put(CommandType.APPLY_HORIZONTAL_STYLE,
			new MethodCall(DiagramEditor.class.getMethod("toTreeStyleHorizontal", Object.class)));
		cmdMap.put(CommandType.FIND_IN_PROJECT_BROWSER, 
				new MethodCall(DiagramEditor.class.getMethod("findInProjectBrowser", Object.class)));
		cmdMap.put(CommandType.ADD_ALL_RELATED_ELEMENTS,
				new MethodCall(DiagramEditor.class.getMethod("addAllRelatedElements", Object.class)));
		cmdMap.put(CommandType.SETUP_BACKGROUND_COLOR,
				new MethodCall(DiagramEditor.class.getMethod("setupColor", Object.class)));
		cmdMap.put(CommandType.COPY_BACKGROUND_COLOR,
				new MethodCall(DiagramEditor.class.getMethod("copyColor", Object.class)));
		cmdMap.put(CommandType.PASTE_BACKGROUND_COLOR,
				new MethodCall(DiagramEditor.class.getMethod("pasteColor", Object.class)));
		cmdMap.put(CommandType.SHOW_ATTRIBUTES,
				new MethodCall(DiagramEditor.class.getMethod("showAttributes", Object.class)));
		cmdMap.put(CommandType.SET_BACKGROUND_COLOR,
				new MethodCall(DiagramEditor.class.getMethod("executeSetBackgroundColor")));	
		cmdMap.put(CommandType.ADD_GEN_SET_DIAGRAM, 
				new MethodCall(DiagramEditor.class.getMethod("addGeneralizationSet", Object.class)));
		cmdMap.put(CommandType.DELETE_GEN_SET_DIAGRAM,
				new MethodCall(DiagramEditor.class.getMethod("deleteGeneralizationSet", Object.class)));
		cmdMap.put(CommandType.SHOW_END_POINT_NAMES,
				new MethodCall(DiagramEditor.class.getMethod("showEndPointNames",Object.class)));
		cmdMap.put(CommandType.SHOW_MULTIPLICITIES,
				new MethodCall(DiagramEditor.class.getMethod("showMultiplicities",Object.class)));
		cmdMap.put(CommandType.SHOW_NAME,
				new MethodCall(DiagramEditor.class.getMethod("showName",Object.class)));
		cmdMap.put(CommandType.SHOW_REDEFINITIONS,
				new MethodCall(DiagramEditor.class.getMethod("showRedefinitions",Object.class)));
		cmdMap.put(CommandType.SHOW_SUBSETTING,
				new MethodCall(DiagramEditor.class.getMethod("showSubsetting",Object.class)));
		cmdMap.put(CommandType.SHOW_STEREOTYPE,
				new MethodCall(DiagramEditor.class.getMethod("showStereotype",Object.class)));
		cmdMap.put(CommandType.READING_DIRECTION_SOURCE,
				new MethodCall(DiagramEditor.class.getMethod("readingDesignToSource",Object.class)));
		cmdMap.put(CommandType.READING_DIRECTION_TARGET,
				new MethodCall(DiagramEditor.class.getMethod("readingDesignToTarget",Object.class)));
		cmdMap.put(CommandType.READING_DIRECTION_UNSPECIFIED,
				new MethodCall(DiagramEditor.class.getMethod("readingDesignUnspecified",Object.class)));
		cmdMap.put(CommandType.SUBSETS_SOURCE,
				new MethodCall(DiagramEditor.class.getMethod("subsetsSource", Object.class)));
		cmdMap.put(CommandType.SUBSETS_TARGET,
				new MethodCall(DiagramEditor.class.getMethod("subsetsTarget", Object.class)));
		cmdMap.put(CommandType.REDEFINES_SOURCE,
				new MethodCall(DiagramEditor.class.getMethod("redefinesSource", Object.class)));
		cmdMap.put(CommandType.REDEFINES_TARGET,
				new MethodCall(DiagramEditor.class.getMethod("redefinesTarget", Object.class)));
		cmdMap.put(CommandType.SET_ESSENTIAL,
				new MethodCall(DiagramEditor.class.getMethod("essential", Object.class)));
		cmdMap.put(CommandType.SET_INSEPARABLE,
				new MethodCall(DiagramEditor.class.getMethod("inseparable", Object.class)));
		cmdMap.put(CommandType.SET_IMMUTABLEPART,
				new MethodCall(DiagramEditor.class.getMethod("immutablePart", Object.class)));
		cmdMap.put(CommandType.SET_IMMUTABLEWHOLE,
				new MethodCall(DiagramEditor.class.getMethod("immutableWhole", Object.class)));
		cmdMap.put(CommandType.SET_SHAREABLE,
				new MethodCall(DiagramEditor.class.getMethod("shareable", Object.class)));
		cmdMap.put(CommandType.OPTIONAL_ON_SOURCE,
				new MethodCall(DiagramEditor.class.getMethod("optionalOnSource", Object.class)));
		cmdMap.put(CommandType.OPTIONAL_ON_TARGET,
				new MethodCall(DiagramEditor.class.getMethod("optionalOnTarget", Object.class)));
		cmdMap.put(CommandType.SINGULAR_ON_SOURCE,
				new MethodCall(DiagramEditor.class.getMethod("singularOnSource", Object.class)));
		cmdMap.put(CommandType.SINGULAR_ON_TARGET,
				new MethodCall(DiagramEditor.class.getMethod("singularOnTarget", Object.class)));
		cmdMap.put(CommandType.SOME_ON_SOURCE,
				new MethodCall(DiagramEditor.class.getMethod("someOnSource", Object.class)));
		cmdMap.put(CommandType.SOME_ON_TARGET,
				new MethodCall(DiagramEditor.class.getMethod("someOnTarget", Object.class)));
		cmdMap.put(CommandType.ANY_ON_SOURCE,
				new MethodCall(DiagramEditor.class.getMethod("anyOnSource", Object.class)));
		cmdMap.put(CommandType.ANY_ON_TARGET,				
				new MethodCall(DiagramEditor.class.getMethod("anyOnTarget", Object.class)));
		cmdMap.put(CommandType.TWO_ON_SOURCE,
				new MethodCall(DiagramEditor.class.getMethod("twoOnSource", Object.class)));
		cmdMap.put(CommandType.TWO_ON_TARGET,
				new MethodCall(DiagramEditor.class.getMethod("twoOnTarget", Object.class)));
		cmdMap.put(CommandType.TWO_AT_LEAST_ON_SOURCE,
				new MethodCall(DiagramEditor.class.getMethod("twoAtLeastOnSource", Object.class)));
		cmdMap.put(CommandType.TWO_AT_LEAST_ON_TARGET,
				new MethodCall(DiagramEditor.class.getMethod("twoAtLeastOnTarget", Object.class)));
		cmdMap.put(CommandType.OTHER_ON_SOURCE,
				new MethodCall(DiagramEditor.class.getMethod("otherOnSource", Object.class)));
		cmdMap.put(CommandType.OTHER_ON_TARGET,
				new MethodCall(DiagramEditor.class.getMethod("otherOnTarget", Object.class)));
		cmdMap.put(CommandType.SET_SOURCE_END_POINT_NAME,
				new MethodCall(DiagramEditor.class.getMethod("endPointNameOnSource", Object.class)));
		cmdMap.put(CommandType.SET_TARGET_END_POINT_NAME,
				new MethodCall(DiagramEditor.class.getMethod("endPointNameOnTarget", Object.class)));
		
	}
	
	private void project() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.FIND_TERM,
				new MethodCall(DiagramManager.class.getMethod("searchInProject")));		
		cmdMap.put(CommandType.COLLECT_STATISTICS,
				new MethodCall(DiagramManager.class.getMethod("collectStatistics")));		
	}
	
	private void tabs() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.CLOSE_THIS_TAB,
				new MethodCall(DiagramManager.class.getMethod("closeTab", Component.class)));
		cmdMap.put(CommandType.CLOSE_OTHER_TABS,
				new MethodCall(DiagramManager.class.getMethod("closeOthers", Component.class)));
		cmdMap.put(CommandType.CLOSE_ALL_TABS,
				new MethodCall(DiagramManager.class.getMethod("closeAll", Component.class)));
		cmdMap.put(CommandType.SELECT_TAB,
				new MethodCall(DiagramManager.class.getMethod("selectTab", Object.class)));
		cmdMap.put(CommandType.OPEN_TAB,
				new MethodCall(DiagramManager.class.getMethod("openTab", Object.class)));
	}
	
	private void window() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.PALETTE_OF_ELEMENTS,
				new MethodCall(MainFrame.class.getMethod("showPalettePane")));
		cmdMap.put(CommandType.PROJECT_BROWSER,
				new MethodCall(MainFrame.class.getMethod("showBrowserPane")));
		cmdMap.put(CommandType.CONSOLE,
				new MethodCall(MainFrame.class.getMethod("showFooterPane")));
	}
	
	private void help() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ABOUT,
				new MethodCall(DiagramManager.class.getMethod("about")));			
		cmdMap.put(CommandType.LICENSES, 
				new MethodCall(DiagramManager.class.getMethod("licenses")));
	}
	
	private void verificate() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.CHECK_MODEL_SYNTAX,
				new MethodCall(DiagramManager.class.getMethod("verifyModelSyntactically")));
		cmdMap.put(CommandType.PARSE_RULES, 
				new MethodCall(DiagramManager.class.getMethod("parseConstraints")));
	}
	
	private void validate() throws NoSuchMethodException, SecurityException{
		
		cmdMap.put(CommandType.SIMULATE_AND_CHECK,
				new MethodCall(DiagramManager.class.getMethod("simulate")));
		cmdMap.put(CommandType.IMPLEMENT_IN_OWL,
				new MethodCall(DiagramManager.class.getMethod("implementInOwl")));
		cmdMap.put(CommandType.SEARCH_FOR_ANTIPATTERNS, 
				new MethodCall(DiagramManager.class.getMethod("manageAntiPatterns")));
		cmdMap.put(CommandType.BUSINESS_VOCABULARY, 
				new MethodCall(DiagramManager.class.getMethod("generateSbvr")));
		cmdMap.put(CommandType.TEXTUAL_DESCRIPTION, 
				new MethodCall(DiagramManager.class.getMethod("callGlossary")));		
		cmdMap.put(CommandType.DESIGN_AS_INFO_UML, 
				new MethodCall(DiagramManager.class.getMethod("generateInfoUML")));
		cmdMap.put(CommandType.VALIDATE_PARTHOOD_TRANSITIVITY, 
				new MethodCall(DiagramManager.class.getMethod("validatesParthood")));
	}
	
	private void dnd() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.TB_DND_POINTER_MODE, 
				new MethodCall(DiagramEditor.class.getMethod("setSelectionMode")));		
		cmdMap.put(CommandType.TB_DND_KIND, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.KIND));
		cmdMap.put(CommandType.TB_DND_QUANTITY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.QUANTITY));
		cmdMap.put(CommandType.TB_DND_COLLECTIVE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.COLLECTIVE));
		cmdMap.put(CommandType.TB_DND_SUBKIND, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.SUBKIND));
		cmdMap.put(CommandType.TB_DND_PHASE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.PHASE));
		cmdMap.put(CommandType.TB_DND_ROLE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.ROLE));
		cmdMap.put(CommandType.TB_DND_CATEGORY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.CATEGORY));
		cmdMap.put(CommandType.TB_DND_ROLEMIXIN, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.ROLEMIXIN));
		cmdMap.put(CommandType.TB_DND_MIXIN, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.MIXIN));
		cmdMap.put(CommandType.TB_DND_MODE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.MODE));
		cmdMap.put(CommandType.TB_DND_RELATOR, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.RELATOR));
		cmdMap.put(CommandType.TB_DND_PERCEIVABLE_QUALITY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.PERCEIVABLE_QUALITY));
		cmdMap.put(CommandType.TB_DND_NOMINAL_QUALITY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.NOMINAL_QUALITY));
		cmdMap.put(CommandType.TB_DND_NONPERCEIVABLE_QUALITY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.NONPERCEIVABLE_QUALITY));
		
		cmdMap.put(CommandType.TB_DND_DATATYPE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.DATATYPE));
		cmdMap.put(CommandType.TB_DND_ENUMERATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.ENUMERATION));
		cmdMap.put(CommandType.TB_DND_PRIMITIVETYPE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.PRIMITIVETYPE));
		
		cmdMap.put(CommandType.TB_DND_GENERALIZATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.GENERALIZATION));
		cmdMap.put(CommandType.TB_DND_CHARACTERIZATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.CHARACTERIZATION));
		cmdMap.put(CommandType.TB_DND_FORMAL, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.FORMAL));
		cmdMap.put(CommandType.TB_DND_MATERIAL, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.MATERIAL));				
		cmdMap.put(CommandType.TB_DND_MEDIATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.MEDIATION));
		cmdMap.put(CommandType.TB_DND_MEMBEROF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.MEMBEROF));
		cmdMap.put(CommandType.TB_DND_SUBQUANTITYOF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.SUBQUANTITYOF));
		cmdMap.put(CommandType.TB_DND_SUBCOLLECTIONOF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.SUBCOLLECTIONOF));
		cmdMap.put(CommandType.TB_DND_COMPONENTOF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.COMPONENTOF));
		cmdMap.put(CommandType.TB_DND_DERIVATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.DERIVATION));
		cmdMap.put(CommandType.TB_DND_ASSOCIATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.ASSOCIATION));
		cmdMap.put(CommandType.TB_DND_STRUCTURATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.STRUCTURATION));
		
		cmdMap.put(CommandType.TB_DND_MIXIN_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.MIXIN));		
		cmdMap.put(CommandType.TB_DND_MIXIN_WITH_SUBKIND_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.MIXIN_WITH_SUBKIND));		
		cmdMap.put(CommandType.TB_DND_PHASE_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.PHASE_PARTITION));
		cmdMap.put(CommandType.TB_DND_SUBKIND_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.SUBKIND_PARTITION));		
		cmdMap.put(CommandType.TB_DND_ROLE_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.ROLE_PARTITION));		
		cmdMap.put(CommandType.TB_DND_GENERIC_RELATOR_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.GENERIC_RELATOR));		
		cmdMap.put(CommandType.TB_DND_DEPENDENT_ROLEMIXIN_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.DEPENDENT_ROLEMIXIN));		
		cmdMap.put(CommandType.TB_DND_KIND_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.KIND_PARTITION));		
		cmdMap.put(CommandType.TB_DND_COLLECTIVE_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.COLLECTIVE_PARTITION));		
		cmdMap.put(CommandType.TB_DND_QUANTITY_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.QUANTITY_PARTITION));		
		cmdMap.put(CommandType.TB_DND_CATEGORY_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.CATEGORY));		
		cmdMap.put(CommandType.TB_DND_COMPLETER_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.COMPLETER));		
		cmdMap.put(CommandType.TB_DND_ROLEMIXIN_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.ROLEMIXIN));		
		cmdMap.put(CommandType.TB_DND_CHARACTERIZATION_PATTERN,
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.CHARACTERIZATION));		
		cmdMap.put(CommandType.TB_DND_RIGID_WS_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.RIGID_WEAK_SUPPLEMENTATION));		
		cmdMap.put(CommandType.TB_DND_ANTIRIGID_WS_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.ANTIRIGID_WEAK_SUPPLEMENTATION));		
		cmdMap.put(CommandType.TB_DND_RELATOR_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.RELATOR));
		
		cmdMap.put(CommandType.TB_DND_DOMAIN_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",PatternType.class),PatternType.DOMAIN_PATTERN));
		
		cmdMap.put(CommandType.TB_DND_UNION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternCreationMode")));
		cmdMap.put(CommandType.TB_DND_EXCLUSION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternCreationModeEx")));				
		cmdMap.put(CommandType.TB_DND_SPECIALIZATION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternCreationModeSpecialization")));				
		cmdMap.put(CommandType.TB_DND_INTERSECTION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternCreationModeIntersection")));				
		cmdMap.put(CommandType.TB_DND_PASTSPECIALIZATION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternCreationModePastSpecialization")));				
		cmdMap.put(CommandType.TB_DND_PARTICIPATION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternCreationModeParticipation")));
	}
	
	private void additions() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ADD_KIND, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class, RefOntoUML.Element.class), ClassType.KIND));
		cmdMap.put(CommandType.ADD_SUBKIND, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.SUBKIND));
		cmdMap.put(CommandType.ADD_COLLECTIVE, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.COLLECTIVE));
		cmdMap.put(CommandType.ADD_QUANTITY, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.QUANTITY));
		cmdMap.put(CommandType.ADD_ROLE, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.ROLE));
		cmdMap.put(CommandType.ADD_PHASE, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.PHASE));
		cmdMap.put(CommandType.ADD_RELATOR, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.RELATOR));
		cmdMap.put(CommandType.ADD_MODE, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.MODE));		
		cmdMap.put(CommandType.ADD_PERCEIVABLE_QUALITY, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.PERCEIVABLE_QUALITY));
		cmdMap.put(CommandType.ADD_NONPERCEIVABLE_QUALITY, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.NONPERCEIVABLE_QUALITY));
		cmdMap.put(CommandType.ADD_NOMINAL_QUALITY, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.NOMINAL_QUALITY));
		cmdMap.put(CommandType.ADD_CATEGORY, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.CATEGORY));
		cmdMap.put(CommandType.ADD_MIXIN, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.MIXIN));
		cmdMap.put(CommandType.ADD_ROLEMIXIN, 
				new MethodCall(DiagramManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.ROLEMIXIN));
		cmdMap.put(CommandType.ADD_DATATYPE, 
				new MethodCall(DiagramManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.DATATYPE));
		cmdMap.put(CommandType.ADD_PRIMITIVETYPE, 
				new MethodCall(DiagramManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.PRIMITIVETYPE));
		cmdMap.put(CommandType.ADD_ENUMERATION, 
				new MethodCall(DiagramManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.ENUMERATION));
		cmdMap.put(CommandType.ADD_MEDIATION, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.MEDIATION));
		cmdMap.put(CommandType.ADD_CHARACTERIZATION, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.CHARACTERIZATION));
		cmdMap.put(CommandType.ADD_DERIVATION, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.DERIVATION));
		cmdMap.put(CommandType.ADD_COMPONENTOF, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.COMPONENTOF));
		cmdMap.put(CommandType.ADD_SUBCOLLECTIONOF, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.SUBCOLLECTIONOF));
		cmdMap.put(CommandType.ADD_SUBQUANTITYOF, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.SUBQUANTITYOF));
		cmdMap.put(CommandType.ADD_MEMBEROF, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.MEMBEROF));
		cmdMap.put(CommandType.ADD_STRUCTURATION, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.STRUCTURATION));
		cmdMap.put(CommandType.ADD_FORMAL, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.FORMAL));
		cmdMap.put(CommandType.ADD_MATERIAL, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.MATERIAL));
		cmdMap.put(CommandType.ADD_ASSOCIATION,	
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.ASSOCIATION));
		
		cmdMap.put(CommandType.ADD_PACKAGE, 
				new MethodCall(DiagramManager.class.getMethod("addPackage",RefOntoUML.Element.class)));
		cmdMap.put(CommandType.ADD_GENERALIZATION, 
				new MethodCall(DiagramManager.class.getMethod("addRelation", RelationshipType.class, EObject.class), RelationshipType.GENERALIZATION));
		cmdMap.put(CommandType.ADD_GENERALIZATIONSET, 
				new MethodCall(DiagramManager.class.getMethod("addGeneralizationSet",RefOntoUML.Element.class)));
		cmdMap.put(CommandType.ADD_COMMENT, 
				new MethodCall(DiagramManager.class.getMethod("addComment",RefOntoUML.Element.class)));
		cmdMap.put(CommandType.ADD_CONSTRAINT, 
				new MethodCall(DiagramManager.class.getMethod("addConstraintx",RefOntoUML.Element.class)));
		
		cmdMap.put(CommandType.ADD_DERIVATION_BY_UNION, 
				new MethodCall(DiagramManager.class.getMethod("deriveByUnion")));				
		cmdMap.put(CommandType.ADD_DERIVATION_BY_EXCLUSION, 
				new MethodCall(DiagramManager.class.getMethod("deriveByExclusion")));
		cmdMap.put(CommandType.ADD_DERIVATION_BY_SPECIALIZATION, 
				new MethodCall(DiagramManager.class.getMethod("deriveBySpecialization")));
		cmdMap.put(CommandType.ADD_DERIVATION_BY_INTERSECTION, 
				new MethodCall(DiagramManager.class.getMethod("deriveByIntersection")));
		cmdMap.put(CommandType.ADD_DERIVATION_BY_PAST_SPECIALIZATION, 
				new MethodCall(DiagramManager.class.getMethod("deriveByPastSpecialization")));
		cmdMap.put(CommandType.ADD_DERIVATION_BY_PARTICIPATION, 
				new MethodCall(DiagramManager.class.getMethod("deriveByParticipation")));
		
		cmdMap.put(CommandType.ADD_DIAGRAM, 
				new MethodCall(DiagramManager.class.getMethod("newDiagram", Object.class)));
		cmdMap.put(CommandType.ADD_RULES_DOCUMENT, 
				new MethodCall(DiagramManager.class.getMethod("newRulesDocument", Object.class)));
	}
	
	private void changes() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.CHANGE_TO_KIND, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.KIND));
		cmdMap.put(CommandType.CHANGE_TO_SUBKIND, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.SUBKIND));
		cmdMap.put(CommandType.CHANGE_TO_COLLECTIVE, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.COLLECTIVE));
		cmdMap.put(CommandType.CHANGE_TO_QUANTITY, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.QUANTITY));
		cmdMap.put(CommandType.CHANGE_TO_ROLE, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.ROLE));
		cmdMap.put(CommandType.CHANGE_TO_PHASE, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.PHASE));
		cmdMap.put(CommandType.CHANGE_TO_RELATOR, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.RELATOR));
		cmdMap.put(CommandType.CHANGE_TO_MODE, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.MODE));		
		cmdMap.put(CommandType.CHANGE_TO_PERCEIVABLE_QUALITY, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.PERCEIVABLE_QUALITY));
		cmdMap.put(CommandType.CHANGE_TO_NONPERCEIVABLE_QUALITY, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.NONPERCEIVABLE_QUALITY));
		cmdMap.put(CommandType.CHANGE_TO_NOMINAL_QUALITY, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.NOMINAL_QUALITY));
		cmdMap.put(CommandType.CHANGE_TO_CATEGORY, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.CATEGORY));
		cmdMap.put(CommandType.CHANGE_TO_MIXIN, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.MIXIN));
		cmdMap.put(CommandType.CHANGE_TO_ROLEMIXIN, 
				new MethodCall(DiagramManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.ROLEMIXIN));
		cmdMap.put(CommandType.CHANGE_TO_GENERALIZATION, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.GENERALIZATION));
		cmdMap.put(CommandType.CHANGE_TO_MEDIATION, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.MEDIATION));
		cmdMap.put(CommandType.CHANGE_TO_CHARACTERIZATION, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.CHARACTERIZATION));
		cmdMap.put(CommandType.CHANGE_TO_DERIVATION, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.DERIVATION));
		cmdMap.put(CommandType.CHANGE_TO_COMPONENTOF, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.COMPONENTOF));
		cmdMap.put(CommandType.CHANGE_TO_SUBCOLLECTIONOF, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.SUBCOLLECTIONOF));
		cmdMap.put(CommandType.CHANGE_TO_SUBQUANTITYOF, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.SUBQUANTITYOF));
		cmdMap.put(CommandType.CHANGE_TO_MEMBEROF, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.MEMBEROF));
		cmdMap.put(CommandType.CHANGE_TO_STRUCTURATION, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.STRUCTURATION));
		cmdMap.put(CommandType.CHANGE_TO_FORMAL, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.FORMAL));
		cmdMap.put(CommandType.CHANGE_TO_MATERIAL, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.MATERIAL));
		cmdMap.put(CommandType.CHANGE_TO_ASSOCIATION, 
				new MethodCall(DiagramManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.ASSOCIATION));
		
		cmdMap.put(CommandType.INVERT_END_NAMES, 
				new MethodCall(DiagramManager.class.getMethod("invertEndNames", RefOntoUML.Association.class)));
		cmdMap.put(CommandType.INVERT_END_POINTS, 
				new MethodCall(DiagramManager.class.getMethod("invertEndPoints",RefOntoUML.Association.class)));
		cmdMap.put(CommandType.INVERT_END_MULTIPLICITIES, 
				new MethodCall(DiagramManager.class.getMethod("invertEndMultiplicities",RefOntoUML.Association.class)));
		cmdMap.put(CommandType.INVERT_END_TYPES, 
				new MethodCall(DiagramManager.class.getMethod("invertEndTypes",RefOntoUML.Association.class)));
	}
	
//		selectorMap.put("LANGUAGE_GENERALIZATION_SPECIALIZATION", new MethodCall(
//				getClass().getMethod("runPatternByMenu",ElementType.class),ElementType.GENERALIZATIONSPECIALIZATION));
//
//		selectorMap.put("LANGUAGE_PARTITION_PATTERN", new MethodCall(
//				getClass().getMethod("runPatternByMenu",ElementType.class),ElementType.PARTITIONPATTERN));
//		
//		selectorMap.put("ADD_SUPERTYPE", new MethodCall(
//				getClass().getMethod("runPatternByMenu",ElementType.class),ElementType.ADDSUPERTYPE));
//		
//		selectorMap.put("ADD_SUBTYPE", new MethodCall(
//				getClass().getMethod("runPatternByMenu",ElementType.class),ElementType.ADDSUBTYPE));
//			
//		public void runPatternByMenu(PatternType type)
//		{
//			if (manager.isProjectLoaded()==false) return;
//			manager.runPattern(type, 0, 0);
//		}		

}
