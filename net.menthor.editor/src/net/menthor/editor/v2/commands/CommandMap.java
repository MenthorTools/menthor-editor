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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.umldraw.shared.BaseConnection;

import net.menthor.editor.v2.AppFrame;
import net.menthor.editor.v2.managers.AdditionManager;
import net.menthor.editor.v2.managers.AlignManager;
import net.menthor.editor.v2.managers.AlloyManager;
import net.menthor.editor.v2.managers.AntiPatternManager;
import net.menthor.editor.v2.managers.ChangeManager;
import net.menthor.editor.v2.managers.ClipboardManager;
import net.menthor.editor.v2.managers.DeletionManager;
import net.menthor.editor.v2.managers.DuplicateManager;
import net.menthor.editor.v2.managers.EditManager;
import net.menthor.editor.v2.managers.ExportManager;
import net.menthor.editor.v2.managers.FindManager;
import net.menthor.editor.v2.managers.GlossaryManager;
import net.menthor.editor.v2.managers.HelpManager;
import net.menthor.editor.v2.managers.ImportManager;
import net.menthor.editor.v2.managers.MoveManager;
import net.menthor.editor.v2.managers.OwlManager;
import net.menthor.editor.v2.managers.ParthoodManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.RedoManager;
import net.menthor.editor.v2.managers.RenameManager;
import net.menthor.editor.v2.managers.SbvrManager;
import net.menthor.editor.v2.managers.SyntaxManager;
import net.menthor.editor.v2.managers.TabManager;
import net.menthor.editor.v2.managers.UndoManager;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.ui.menubar.AppMenuBar;
import net.menthor.editor.v2.ui.splitpane.AppMultiSplitPane;

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
	
	//-------------- application --------------
	
	private void application() throws NoSuchMethodException, SecurityException{
		appFrame();
		menu();
		splitPane();
	}
	
	private void menu() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.INITIALIZE_SHOWGRID_MENUITEM,
				new MethodCall(AppMenuBar.class.getMethod("initializeShowGrid")));		
	}
	private void appFrame() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.QUIT_APPLICATION,
				new MethodCall(AppFrame.class.getMethod("quitApplication")));
	}
	private void splitPane() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.SHOW_PALETTE,
				new MethodCall(AppMultiSplitPane.class.getMethod("showPalette")));
		cmdMap.put(CommandType.SHOW_PROJECT_BROWSER,
				new MethodCall(AppMultiSplitPane.class.getMethod("showProjectBrowser")));
		cmdMap.put(CommandType.SHOW_INFO_TABBED_PANE,
				new MethodCall(AppMultiSplitPane.class.getMethod("showInfoTabbedPane")));		
	}
	
	//-------------- core --------------
	
	private void core() throws NoSuchMethodException, SecurityException{
		projectManager();		
		tabManager();
		editionManagers();
		additionManager();			
		changeManager(); 
		findManager();		
		moveManager();		
		helpManager();
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
	
	private void helpManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ABOUT,
				new MethodCall(HelpManager.class.getMethod("about")));			
		cmdMap.put(CommandType.LICENSES, 
				new MethodCall(HelpManager.class.getMethod("licenses")));
	}
		
	private void moveManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.MOVE_UP_TREE,
				new MethodCall(MoveManager.class.getMethod("moveUpSelectedOnTree")));
		cmdMap.put(CommandType.MOVE_DOWN_TREE,
				new MethodCall(MoveManager.class.getMethod("moveDownSelectedOnTree")));
		cmdMap.put(CommandType.MOVE_SELECTED_TO_DIAGRAM,
				new MethodCall(MoveManager.class.getMethod("moveSelectedOnTreeToDiagram", Point.class)));
		cmdMap.put(CommandType.MOVE_TO_DIAGRAM,
				new MethodCall(MoveManager.class.getMethod("move", DefaultMutableTreeNode.class)));		
	}
		
	private void findManager()throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.FIND_IN_DIAGRAMS,
				new MethodCall(FindManager.class.getMethod("findInDiagrams", Object.class)));
		cmdMap.put(CommandType.FIND_IN_PROJECT_BROWSER, 
				new MethodCall(FindManager.class.getMethod("findInProjectTree", Object.class)));
		cmdMap.put(CommandType.FIND_BY_NAME, 
				new MethodCall(FindManager.class.getMethod("findByName", String.class)));
	}
	
	private void editionManagers() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.REDO,
				new MethodCall(RedoManager.class.getMethod("redo")));
		cmdMap.put(CommandType.UNDO,
				new MethodCall(UndoManager.class.getMethod("undo")));
		cmdMap.put(CommandType.DUPLICATE,
				new MethodCall(DuplicateManager.class.getMethod("duplicate", Object.class)));
		cmdMap.put(CommandType.COPY,
				new MethodCall(ClipboardManager.class.getMethod("cloneSelectedAndPutToClipboard")));
		cmdMap.put(CommandType.PASTE,
				new MethodCall(ClipboardManager.class.getMethod("pasteClipboard")));
		cmdMap.put(CommandType.RENAME,
				new MethodCall(RenameManager.class.getMethod("rename", Object.class)));
		cmdMap.put(CommandType.EDIT, 
				new MethodCall(EditManager.class.getMethod("edit", Object.class)));		
		cmdMap.put(CommandType.DELETE, 
				new MethodCall(DeletionManager.class.getMethod("delete", Object.class)));
	}
	
	private void additionManager() throws NoSuchMethodException, SecurityException{
		for(ClassType ct: ClassType.values()){		
			CommandType cmdType = CommandType.getAddCommandType(ct);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(AdditionManager.class.getMethod("addClass", ClassType.class, RefOntoUML.Element.class), ct));
			}
		}
		for(DataType dt: DataType.values()){		
			CommandType cmdType = CommandType.getAddCommandType(dt);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(AdditionManager.class.getMethod("addDataType", DataType.class, RefOntoUML.Element.class), dt));
			}
		}		
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
				new MethodCall(AdditionManager.class.getMethod("addPackage",DefaultMutableTreeNode.class)));
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
		for(ClassType ct: ClassType.values()){		
			CommandType cmdType = CommandType.getChangeToCommandType(ct);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(ChangeManager.class.getMethod("changeClassStereotype", ClassType.class, RefOntoUML.Element.class), ct));
			}
		}
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
				new MethodCall(ChangeManager.class.getMethod("invertEndNames", BaseConnection.class)));
		cmdMap.put(CommandType.INVERT_END_POINTS, 
				new MethodCall(ChangeManager.class.getMethod("invertEndPoints",BaseConnection.class)));
		cmdMap.put(CommandType.INVERT_END_MULTIPLICITIES, 
				new MethodCall(ChangeManager.class.getMethod("invertEndMultiplicities",BaseConnection.class)));
		cmdMap.put(CommandType.INVERT_END_TYPES, 
				new MethodCall(ChangeManager.class.getMethod("invertEndTypes",BaseConnection.class)));
	}
	
	/** constructor */
	private CommandMap(){
		try {		
			application();	
			core();		
			
			diagramEditor();
			alignManager();
			palleteDragAndDrop();
			
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
	
	private void alignManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ALIGN_VERTICAL,
				new MethodCall(AlignManager.class.getMethod("executeAlignCenterVertically",ArrayList.class)));
		cmdMap.put(CommandType.ALIGN_HORIZONTAL,
				new MethodCall(AlignManager.class.getMethod("executeAlignCenterHorizontally",ArrayList.class)));
		cmdMap.put(CommandType.ALIGN_TOP,
				new MethodCall(AlignManager.class.getMethod("executeAlignTop",ArrayList.class)));
		cmdMap.put(CommandType.ALIGN_BOTTOM,
				new MethodCall(AlignManager.class.getMethod("executeAlignBottom",ArrayList.class)));
		cmdMap.put(CommandType.ALIGN_LEFT,
				new MethodCall(AlignManager.class.getMethod("executeAlignLeft",ArrayList.class)));
		cmdMap.put(CommandType.ALIGN_RIGHT,
				new MethodCall(AlignManager.class.getMethod("executeAlignRight",ArrayList.class)));
	}
	
	
	private void diagramEditor() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.SHOW_GRID,
				new MethodCall(DiagramEditor.class.getMethod("showGrid")));
		cmdMap.put(CommandType.ERASE, 
				new MethodCall(DiagramEditor.class.getMethod("excludeSelection", Object.class)));		
		cmdMap.put(CommandType.SELECT_ALL_DIAGRAM,
				new MethodCall(DiagramEditor.class.getMethod("selectAll")));
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
		cmdMap.put(CommandType.NEW_GEN_SET_DIAGRAM, 
				new MethodCall(DiagramEditor.class.getMethod("addGeneralizationSet", ArrayList.class)));
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
	
	private void palleteDragAndDrop() throws NoSuchMethodException, SecurityException{
		
		cmdMap.put(CommandType.PALLETE_POINTER_MODE, 
				new MethodCall(DiagramEditor.class.getMethod("setSelectionMode")));	
		
		for(ClassType ct: ClassType.values()){		
			CommandType cmdType = CommandType.getPalleteCommandType(ct);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(ClipboardManager.class.getMethod("createAndPutToClipboard", ClassType.class), ct));
			}
		}
		for(DataType dt: DataType.values()){
			CommandType cmdType = CommandType.getPalleteCommandType(dt);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(ClipboardManager.class.getMethod("createAndPutToClipboard", DataType.class), dt));
			}
		}		
		cmdMap.put(CommandType.PALLETE_GENERALIZATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.GENERALIZATION));
		cmdMap.put(CommandType.PALLETE_CHARACTERIZATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.CHARACTERIZATION));
		cmdMap.put(CommandType.PALLETE_FORMAL, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.FORMAL));
		cmdMap.put(CommandType.PALLETE_MATERIAL, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.MATERIAL));				
		cmdMap.put(CommandType.PALLETE_MEDIATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.MEDIATION));
		cmdMap.put(CommandType.PALLETE_MEMBEROF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.MEMBEROF));
		cmdMap.put(CommandType.PALLETE_SUBQUANTITYOF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.SUBQUANTITYOF));
		cmdMap.put(CommandType.PALLETE_SUBCOLLECTIONOF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.SUBCOLLECTIONOF));
		cmdMap.put(CommandType.PALLETE_COMPONENTOF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.COMPONENTOF));
		cmdMap.put(CommandType.PALLETE_DERIVATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.DERIVATION));
		cmdMap.put(CommandType.PALLETE_ASSOCIATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.ASSOCIATION));
		cmdMap.put(CommandType.PALLETE_STRUCTURATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.STRUCTURATION));
	}
	
	private void tabManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.CLOSE_THIS,
				new MethodCall(TabManager.class.getMethod("closeThis", Component.class)));
		cmdMap.put(CommandType.CLOSE_OTHER,
				new MethodCall(TabManager.class.getMethod("closeOthers", Component.class)));
		cmdMap.put(CommandType.CLOSE_ALL,
				new MethodCall(TabManager.class.getMethod("closeAll", Component.class)));
		cmdMap.put(CommandType.SELECT_EDITOR,
				new MethodCall(TabManager.class.getMethod("selectEditor", Object.class)));
		cmdMap.put(CommandType.ADD_EDITOR,
				new MethodCall(TabManager.class.getMethod("addEditor", Object.class)));		
		cmdMap.put(CommandType.CLOSE_OCL_EDITOR,
				new MethodCall(TabManager.class.getMethod("closeCurrentOclEditor")));
		cmdMap.put(CommandType.CLOSE_DIAGRAM_EDITOR,
				new MethodCall(TabManager.class.getMethod("closeCurrentDiagramEditor")));		
		cmdMap.put(CommandType.ADD_FINDER_EDITOR,
				new MethodCall(TabManager.class.getMethod("addFinderEditor")));		
		cmdMap.put(CommandType.ADD_STATISTICS_EDITOR,
				new MethodCall(TabManager.class.getMethod("addStatisticsEditor")));
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
		cmdMap.put(CommandType.OWL_SETTINGS,
				new MethodCall(OwlManager.class.getMethod("callOwlSettings")));
		cmdMap.put(CommandType.GENERATE_OWL,
				new MethodCall(OwlManager.class.getMethod("generateOwl", Object.class)));
	}
	
	private void glossaryManager()throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.GLOSSARY_SETTINGS, 
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
	
		
	private void importManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.IMPORT_FROM_XMI_EA,
				new MethodCall(ImportManager.class.getMethod("importFromEA")));
		cmdMap.put(CommandType.IMPORT_FROM_XMI_EA_FILE,
				new MethodCall(ImportManager.class.getMethod("importFromEARecent")));
	}
	
	
}
