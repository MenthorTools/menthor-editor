package net.menthor.editor.v2.commands;

import java.awt.Component;

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

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.ui.diagram.DiagramEditor;

import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.MainFrame;
import net.menthor.editor.v2.managers.AdditionManager;
import net.menthor.editor.v2.managers.AlloyManager;
import net.menthor.editor.v2.managers.AntiPatternManager;
import net.menthor.editor.v2.managers.ChangeManager;
import net.menthor.editor.v2.managers.ClipboardManager;
import net.menthor.editor.v2.managers.DeletionManager;
import net.menthor.editor.v2.managers.DuplicateManager;
import net.menthor.editor.v2.managers.EditManager;
import net.menthor.editor.v2.managers.ExportManager;
import net.menthor.editor.v2.managers.GlossaryManager;
import net.menthor.editor.v2.managers.HelpManager;
import net.menthor.editor.v2.managers.ImportManager;
import net.menthor.editor.v2.managers.MoveManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.OwlManager;
import net.menthor.editor.v2.managers.ParthoodManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.RedoManager;
import net.menthor.editor.v2.managers.RenameManager;
import net.menthor.editor.v2.managers.SbvrManager;
import net.menthor.editor.v2.managers.SyntaxManager;
import net.menthor.editor.v2.managers.UndoManager;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
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
		if(getMap().get(cmdType)!=null) {
			getMap().get(cmdType).addParameter(parameter);
		}
	}
	
	public void addParameters(CommandType cmdType, Object[] parameters){
		if(getMap().get(cmdType)!=null) {			
			getMap().get(cmdType).addParameters(parameters);
		}
	}
	
	/** constructor */
	private CommandMap(){
		try {		
			projectManager();	
			mainFrame();
			helpManager();
			additionManager();			
			changeManager(); 
			occurenceManager();
			baseActionManagers();
			moveManager();
			tabManager();
			
			diagramEditor();
			dragAndDrop();
			
			exportManager();
			importManager();
			syntaxManager();
			antiPatternManager();
			owlManager();
			sbvrManager();
			alloyManager();
			parthoodManager();
			glossaryManager();
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private void diagramEditor() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ERASE, 
				new MethodCall(DiagramEditor.class.getMethod("excludeSelection", Object.class)));		
		cmdMap.put(CommandType.SELECT_ALL_DIAGRAM,
				new MethodCall(DiagramEditor.class.getMethod("selectAll")));		
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
				new MethodCall(DiagramEditor.class.getMethod("setupColorOnSelected")));	
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
		cmdMap.put(CommandType.BRING_FROM_PROJECT_BROWSER,
				new MethodCall(DiagramEditor.class.getMethod("bringFromProjectBrowser", Point.class)));		
	}
	
	private void dragAndDrop() throws NoSuchMethodException, SecurityException{
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
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.PERCEIVABLEQUALITY));
		cmdMap.put(CommandType.TB_DND_NOMINAL_QUALITY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.NOMINALQUALITY));
		cmdMap.put(CommandType.TB_DND_NONPERCEIVABLE_QUALITY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.NONPERCEIVABLEQUALITY));
		
		cmdMap.put(CommandType.TB_DND_DATATYPE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.DATATYPE));
		cmdMap.put(CommandType.TB_DND_ENUMERATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.ENUMERATION));
		cmdMap.put(CommandType.TB_DND_PRIMITIVETYPE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.PRIMITIVETYPE));
		cmdMap.put(CommandType.TB_DND_MEASUREMENT_DOMAIN, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.MEASUREMENTDOMAIN));
		cmdMap.put(CommandType.TB_DND_STRING_NOMINAL_DIMENSION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.STRINGNOMINALSTRUCTURE));
		cmdMap.put(CommandType.TB_DND_INTEGER_INTERVAL_DIMENSION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.INTEGERINTERVALDIMENSION));
		cmdMap.put(CommandType.TB_DND_INTEGER_RATIONAL_DIMENSION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.INTEGERRATIONALDIMENSION));
		cmdMap.put(CommandType.TB_DND_INTEGER_ORDINAL_DIMENSION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.INTEGERORDINALDIMENSION));
		cmdMap.put(CommandType.TB_DND_DECIMAL_ORDINAL_DIMENSION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.DECIMALORDINALDIMENSION));
		cmdMap.put(CommandType.TB_DND_DECIMAL_RATIONAL_DIMENSION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.DECIMALRATIONALDIMENSION));
		cmdMap.put(CommandType.TB_DND_DECIMAL_INTERVAL_DIMENSION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.DECIMALINTERVALDIMENSION));
		
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
	}
	
	private void tabManager() throws NoSuchMethodException, SecurityException{
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
		cmdMap.put(CommandType.CLOSE_RULES_TAB,
				new MethodCall(DiagramManager.class.getMethod("closeCurrentOclDocument")));
		cmdMap.put(CommandType.CLOSE_DIAGRAM_TAB,
				new MethodCall(DiagramManager.class.getMethod("closeCurrentDiagram")));		
		cmdMap.put(CommandType.ADD_FINDER_TAB,
				new MethodCall(DiagramManager.class.getMethod("addFinderTab")));		
		cmdMap.put(CommandType.ADD_STATISTICS_TAB,
				new MethodCall(DiagramManager.class.getMethod("addStatisticsTab")));
	}
	
	private void moveManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.MOVE_UP_TREE,
				new MethodCall(MoveManager.class.getMethod("moveUpSelectedOnTree")));
		cmdMap.put(CommandType.MOVE_DOWN_TREE,
				new MethodCall(MoveManager.class.getMethod("moveDownSelectedOnTree")));
		cmdMap.put(CommandType.MOVE_TO_DIAGRAM,
				new MethodCall(MoveManager.class.getMethod("move", Object.class)));		
	}
	
	
	private void occurenceManager()throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.FIND_IN_DIAGRAMS,
				new MethodCall(OccurenceManager.class.getMethod("findInDiagrams", Object.class)));
	}
	
	private void baseActionManagers() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.REDO,
				new MethodCall(RedoManager.class.getMethod("redo")));
		cmdMap.put(CommandType.UNDO,
				new MethodCall(UndoManager.class.getMethod("undo")));
		cmdMap.put(CommandType.DUPLICATE,
				new MethodCall(DuplicateManager.class.getMethod("duplicate", Object.class)));
		cmdMap.put(CommandType.COPY,
				new MethodCall(ClipboardManager.class.getMethod("copySelectedToClipboard")));
		cmdMap.put(CommandType.PASTE,
				new MethodCall(ClipboardManager.class.getMethod("pasteClipboard")));
		cmdMap.put(CommandType.RENAME,
				new MethodCall(RenameManager.class.getMethod("rename", Object.class)));
		cmdMap.put(CommandType.EDIT, 
				new MethodCall(EditManager.class.getMethod("edit", Object.class)));		
		cmdMap.put(CommandType.DELETE, 
				new MethodCall(DeletionManager.class.getMethod("delete", Object.class)));
	}

	private void sbvrManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.GENERATE_SBVR, 
				new MethodCall(SbvrManager.class.getMethod("generateSbvr")));
		cmdMap.put(CommandType.OPEN_LINK_WITH_BROWSER,
				new MethodCall(SbvrManager.class.getMethod("openLinkWithBrowser", String.class)));		
	}
	
	private void alloyManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ALLOY_SETTINGS,
			new MethodCall(AlloyManager.class.getMethod("openAlloySettings")));
	}
	
	private void owlManager()throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.CALL_OWL_SETTINGS,
				new MethodCall(OwlManager.class.getMethod("callOwlSettings")));
		cmdMap.put(CommandType.GENERATE_OWL,
				new MethodCall(OwlManager.class.getMethod("generateOwl", Object.class)));
	}
	
	private void glossaryManager()throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.TEXTUAL_DESCRIPTION, 
			new MethodCall(GlossaryManager.class.getMethod("openGlossarySettings")));
	}
	
	private void antiPatternManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.SEARCH_FOR_ANTIPATTERNS, 
				new MethodCall(AntiPatternManager.class.getMethod("detectAntiPatterns")));
	}
	
	private void parthoodManager()throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.VALIDATE_PARTHOOD_TRANSITIVITY, 
				new MethodCall(ParthoodManager.class.getMethod("evaluateParthoods")));
	}
	
	private void syntaxManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.VERIFY_CONSTRAINTS, 
			new MethodCall(SyntaxManager.class.getMethod("verifyConstraints")));
		cmdMap.put(CommandType.VERIFY_MODEL,
				new MethodCall(SyntaxManager.class.getMethod("verifyModel")));		
	}
	
	private void mainFrame() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.PALETTE_OF_ELEMENTS,
				new MethodCall(MainFrame.class.getMethod("showPalettePane")));
		cmdMap.put(CommandType.PROJECT_BROWSER,
				new MethodCall(MainFrame.class.getMethod("showBrowserPane")));
		cmdMap.put(CommandType.CONSOLE,
				new MethodCall(MainFrame.class.getMethod("showFooterPane")));
		cmdMap.put(CommandType.QUIT_MENTHOR,
				new MethodCall(MainFrame.class.getMethod("quitApplication")));
	}
	
	private void exportManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.EXPORT_TO_ECORE,
				new MethodCall(ExportManager.class.getMethod("exportToEcore")));
		cmdMap.put(CommandType.EXPORT_TO_UML,
				new MethodCall(ExportManager.class.getMethod("exportToUML")));
		cmdMap.put(CommandType.EXPORT_TO_PROFILE_UML,
				new MethodCall(ExportManager.class.getMethod("exportToProfileUML")));		
		cmdMap.put(CommandType.EXPORT_TO_REFERENCE_ONTOUML,
				new MethodCall(ExportManager.class.getMethod("exportToReferenceOntouml")));		
		cmdMap.put(CommandType.EXPORT_TO_PNG,
				new MethodCall(ExportManager.class.getMethod("exportToPng")));
	}
	
	private void projectManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.NEW_PROJECT,
				new MethodCall(ProjectManager.class.getMethod("newProject")));
		cmdMap.put(CommandType.NEW_PROJECT_FROM_MODEL,
				new MethodCall(ProjectManager.class.getMethod("newProject", Object.class)));
		cmdMap.put(CommandType.OPEN_EXISTING_PROJECT,
				new MethodCall(ProjectManager.class.getMethod("openProject")));		
		cmdMap.put(CommandType.OPEN_RECENT_PROJECT,
				new MethodCall(ProjectManager.class.getMethod("openRecentProject")));
		cmdMap.put(CommandType.CLOSE_PROJECT,
				new MethodCall(ProjectManager.class.getMethod("closeProject")));
		cmdMap.put(CommandType.SAVE_PROJECT_AS,
				new MethodCall(ProjectManager.class.getMethod("saveProjectAs")));
		cmdMap.put(CommandType.SAVE_PROJECT,
				new MethodCall(ProjectManager.class.getMethod("saveProject")));		
		cmdMap.put(CommandType.IMPORT_FROM_XMI_EMF,
				new MethodCall(ProjectManager.class.getMethod("importModelContent")));
	}
	
	private void importManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.IMPORT_FROM_XMI_EA,
				new MethodCall(ImportManager.class.getMethod("importFromEA")));
		cmdMap.put(CommandType.IMPORT_FROM_XMI_EA_FILE,
				new MethodCall(ImportManager.class.getMethod("importFromEARecent")));
	}
	
	private void helpManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ABOUT,
				new MethodCall(HelpManager.class.getMethod("about")));			
		cmdMap.put(CommandType.LICENSES, 
				new MethodCall(HelpManager.class.getMethod("licenses")));
	}
	
	private void additionManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ADD_KIND, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class, RefOntoUML.Element.class), ClassType.KIND));
		cmdMap.put(CommandType.ADD_SUBKIND, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.SUBKIND));
		cmdMap.put(CommandType.ADD_COLLECTIVE, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.COLLECTIVE));
		cmdMap.put(CommandType.ADD_QUANTITY, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.QUANTITY));
		cmdMap.put(CommandType.ADD_ROLE, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.ROLE));
		cmdMap.put(CommandType.ADD_PHASE, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.PHASE));
		cmdMap.put(CommandType.ADD_RELATOR, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.RELATOR));
		cmdMap.put(CommandType.ADD_MODE, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.MODE));		
		cmdMap.put(CommandType.ADD_PERCEIVABLE_QUALITY, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.PERCEIVABLEQUALITY));
		cmdMap.put(CommandType.ADD_NONPERCEIVABLE_QUALITY, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.NONPERCEIVABLEQUALITY));
		cmdMap.put(CommandType.ADD_NOMINAL_QUALITY, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.NOMINALQUALITY));
		cmdMap.put(CommandType.ADD_CATEGORY, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.CATEGORY));
		cmdMap.put(CommandType.ADD_MIXIN, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.MIXIN));
		cmdMap.put(CommandType.ADD_ROLEMIXIN, 
				new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class,RefOntoUML.Element.class), ClassType.ROLEMIXIN));
		cmdMap.put(CommandType.ADD_DATATYPE, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.DATATYPE));
		cmdMap.put(CommandType.ADD_PRIMITIVETYPE, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.PRIMITIVETYPE));
		cmdMap.put(CommandType.ADD_ENUMERATION, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.ENUMERATION));
		cmdMap.put(CommandType.ADD_MEASUREMENT_DOMAIN, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.MEASUREMENTDOMAIN));
		cmdMap.put(CommandType.ADD_STRING_NOMINAL_STRUCTURE, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.STRINGNOMINALSTRUCTURE));
		cmdMap.put(CommandType.ADD_INTEGER_INTERVAL_DIMENSION, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.INTEGERINTERVALDIMENSION));
		cmdMap.put(CommandType.ADD_INTEGER_RATIONAL_DIMENSION, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.INTEGERRATIONALDIMENSION));
		cmdMap.put(CommandType.ADD_INTEGER_ORDINAL_DIMENSION, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.INTEGERORDINALDIMENSION));
		cmdMap.put(CommandType.ADD_DECIMAL_ORDINAL_DIMENSION, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.DECIMALORDINALDIMENSION));
		cmdMap.put(CommandType.ADD_DECIMAL_RATIONAL_DIMENSION, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.DECIMALRATIONALDIMENSION));
		cmdMap.put(CommandType.ADD_DECIMAL_INTERVAL_DIMENSION, 
				new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class,RefOntoUML.Element.class), DataType.DECIMALINTERVALDIMENSION));
		cmdMap.put(CommandType.ADD_MEDIATION, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.MEDIATION));
		cmdMap.put(CommandType.ADD_CHARACTERIZATION, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.CHARACTERIZATION));
		cmdMap.put(CommandType.ADD_DERIVATION, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.DERIVATION));
		cmdMap.put(CommandType.ADD_COMPONENTOF, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.COMPONENTOF));
		cmdMap.put(CommandType.ADD_SUBCOLLECTIONOF, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.SUBCOLLECTIONOF));
		cmdMap.put(CommandType.ADD_SUBQUANTITYOF, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.SUBQUANTITYOF));
		cmdMap.put(CommandType.ADD_MEMBEROF, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.MEMBEROF));
		cmdMap.put(CommandType.ADD_STRUCTURATION, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.STRUCTURATION));
		cmdMap.put(CommandType.ADD_FORMAL, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.FORMAL));
		cmdMap.put(CommandType.ADD_MATERIAL, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.MATERIAL));
		cmdMap.put(CommandType.ADD_ASSOCIATION,	
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.ASSOCIATION));
		cmdMap.put(CommandType.ADD_PACKAGE, 
				new MethodCall(AdditionManager.class.getMethod("addPackage",RefOntoUML.Element.class)));
		cmdMap.put(CommandType.ADD_GENERALIZATION, 
				new MethodCall(AdditionManager.class.getMethod("addRelationship", RelationshipType.class, EObject.class), RelationshipType.GENERALIZATION));
		cmdMap.put(CommandType.ADD_GENERALIZATIONSET, 
				new MethodCall(AdditionManager.class.getMethod("addGeneralizationSet",RefOntoUML.Element.class)));
		cmdMap.put(CommandType.ADD_COMMENT, 
				new MethodCall(AdditionManager.class.getMethod("addComment",RefOntoUML.Element.class)));
		cmdMap.put(CommandType.ADD_CONSTRAINT, 
				new MethodCall(AdditionManager.class.getMethod("addConstraintx",RefOntoUML.Element.class)));		
		cmdMap.put(CommandType.ADD_OCLDOCUMENT, 
				new MethodCall(AdditionManager.class.getMethod("addOclDocument", Object.class)));		
		cmdMap.put(CommandType.ADD_DIAGRAM, 
				new MethodCall(AdditionManager.class.getMethod("addDiagram", Object.class)));
		
		cmdMap.put(CommandType.NEW_OCLDOCUMENT,
				new MethodCall(AdditionManager.class.getMethod("newOclDocument")));
		cmdMap.put(CommandType.NEW_DIAGRAM,
				new MethodCall(AdditionManager.class.getMethod("newDiagram")));
	}
	
	private void changeManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.CHANGE_TO_KIND, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.KIND));
		cmdMap.put(CommandType.CHANGE_TO_SUBKIND, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.SUBKIND));
		cmdMap.put(CommandType.CHANGE_TO_COLLECTIVE, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.COLLECTIVE));
		cmdMap.put(CommandType.CHANGE_TO_QUANTITY, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.QUANTITY));
		cmdMap.put(CommandType.CHANGE_TO_ROLE, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.ROLE));
		cmdMap.put(CommandType.CHANGE_TO_PHASE, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.PHASE));
		cmdMap.put(CommandType.CHANGE_TO_RELATOR, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.RELATOR));
		cmdMap.put(CommandType.CHANGE_TO_MODE, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.MODE));		
		cmdMap.put(CommandType.CHANGE_TO_PERCEIVABLE_QUALITY, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.PERCEIVABLEQUALITY));
		cmdMap.put(CommandType.CHANGE_TO_NONPERCEIVABLE_QUALITY, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.NONPERCEIVABLEQUALITY));
		cmdMap.put(CommandType.CHANGE_TO_NOMINAL_QUALITY, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.NOMINALQUALITY));
		cmdMap.put(CommandType.CHANGE_TO_CATEGORY, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.CATEGORY));
		cmdMap.put(CommandType.CHANGE_TO_MIXIN, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.MIXIN));
		cmdMap.put(CommandType.CHANGE_TO_ROLEMIXIN, 
				new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class,RefOntoUML.Element.class), ClassType.ROLEMIXIN));
		cmdMap.put(CommandType.CHANGE_TO_GENERALIZATION, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.GENERALIZATION));
		cmdMap.put(CommandType.CHANGE_TO_MEDIATION, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.MEDIATION));
		cmdMap.put(CommandType.CHANGE_TO_CHARACTERIZATION, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.CHARACTERIZATION));
		cmdMap.put(CommandType.CHANGE_TO_DERIVATION, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.DERIVATION));
		cmdMap.put(CommandType.CHANGE_TO_COMPONENTOF, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.COMPONENTOF));
		cmdMap.put(CommandType.CHANGE_TO_SUBCOLLECTIONOF, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.SUBCOLLECTIONOF));
		cmdMap.put(CommandType.CHANGE_TO_SUBQUANTITYOF, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.SUBQUANTITYOF));
		cmdMap.put(CommandType.CHANGE_TO_MEMBEROF, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.MEMBEROF));
		cmdMap.put(CommandType.CHANGE_TO_STRUCTURATION, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.STRUCTURATION));
		cmdMap.put(CommandType.CHANGE_TO_FORMAL, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.FORMAL));
		cmdMap.put(CommandType.CHANGE_TO_MATERIAL, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.MATERIAL));
		cmdMap.put(CommandType.CHANGE_TO_ASSOCIATION, 
				new MethodCall(ChangeManager.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), RelationshipType.ASSOCIATION));
		cmdMap.put(CommandType.INVERT_END_NAMES, 
				new MethodCall(ChangeManager.class.getMethod("invertEndNames", RefOntoUML.Association.class)));
		cmdMap.put(CommandType.INVERT_END_POINTS, 
				new MethodCall(ChangeManager.class.getMethod("invertEndPoints",RefOntoUML.Association.class)));
		cmdMap.put(CommandType.INVERT_END_MULTIPLICITIES, 
				new MethodCall(ChangeManager.class.getMethod("invertEndMultiplicities",RefOntoUML.Association.class)));
		cmdMap.put(CommandType.INVERT_END_TYPES, 
				new MethodCall(ChangeManager.class.getMethod("invertEndTypes",RefOntoUML.Association.class)));
	}
}
