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
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.shared.BaseConnection;

import net.menthor.editor.v2.commanders.AddCommander;
import net.menthor.editor.v2.commanders.AlignCommander;
import net.menthor.editor.v2.commanders.ChangeCommander;
import net.menthor.editor.v2.commanders.DeleteCommander;
import net.menthor.editor.v2.commanders.ColorCommander;
import net.menthor.editor.v2.commanders.DuplicateCommander;
import net.menthor.editor.v2.commanders.MoveCommander;
import net.menthor.editor.v2.commanders.RenameCommander;
import net.menthor.editor.v2.commanders.VisibilityCommander;
import net.menthor.editor.v2.feature.AlloyFeature;
import net.menthor.editor.v2.feature.OwlFeature;
import net.menthor.editor.v2.feature.ParthoodFeature;
import net.menthor.editor.v2.feature.SbvrFeature;
import net.menthor.editor.v2.managers.AntiPatternManager;
import net.menthor.editor.v2.managers.EditManager;
import net.menthor.editor.v2.managers.ExportManager;
import net.menthor.editor.v2.managers.FindManager;
import net.menthor.editor.v2.managers.GlossaryManager;
import net.menthor.editor.v2.managers.HelpManager;
import net.menthor.editor.v2.managers.ImportManager;
import net.menthor.editor.v2.managers.MetaPropertyManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.RedoManager;
import net.menthor.editor.v2.managers.SyntaxManager;
import net.menthor.editor.v2.managers.UndoManager;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.app.AppMenuBar;
import net.menthor.editor.v2.ui.app.AppSplitPane;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
import net.menthor.editor.v2.ui.editor.mode.ClipboardMode;

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
	
	private void applicationOperations() throws NoSuchMethodException, SecurityException{
		appFrame();
		appMenuBar();
		appSplitPane();
	}
	
	private void appMenuBar() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.INITIALIZE_SHOWGRID_MENUITEM,
				new MethodCall(AppMenuBar.class.getMethod("initializeShowGrid")));		
	}
	private void appFrame() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.QUIT_APPLICATION,
				new MethodCall(AppFrame.class.getMethod("quitApplication")));
	}
	private void appSplitPane() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.SHOW_PALETTE,
				new MethodCall(AppSplitPane.class.getMethod("showPalette")));
		cmdMap.put(CommandType.SHOW_PROJECT_BROWSER,
				new MethodCall(AppSplitPane.class.getMethod("showProjectBrowser")));
		cmdMap.put(CommandType.SHOW_INFO_TABBED_PANE,
				new MethodCall(AppSplitPane.class.getMethod("showInfoTabbedPane")));		
	}
	
	//-------------- essential manager operations --------------
	
	private void essentialOperations() throws NoSuchMethodException, SecurityException{
		project();
		tabs();
		edit();
		addition();			
		change(); 
		find();		
		move();		
		help();
	}
	
	private void project() throws NoSuchMethodException, SecurityException{
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
	
	private void help() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ABOUT,
				new MethodCall(HelpManager.class.getMethod("about")));			
		cmdMap.put(CommandType.LICENSES, 
				new MethodCall(HelpManager.class.getMethod("licenses")));
	}
		
	private void move() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.MOVE_UP_TREE,
				new MethodCall(MoveCommander.class.getMethod("moveUpSelectedOnTree")));
		cmdMap.put(CommandType.MOVE_DOWN_TREE,
				new MethodCall(MoveCommander.class.getMethod("moveDownSelectedOnTree")));
		cmdMap.put(CommandType.MOVE_SELECTED_TREE_TO_DIAGRAM,
				new MethodCall(MoveCommander.class.getMethod("moveSelectedOnTreeToDiagram", Point.class)));
		cmdMap.put(CommandType.MOVE_TREE_NODE_TO_DIAGRAM,
				new MethodCall(MoveCommander.class.getMethod("move", DefaultMutableTreeNode.class)));		
	}
		
	private void find()throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.FIND_IN_DIAGRAMS,
				new MethodCall(FindManager.class.getMethod("findInDiagrams", Object.class)));
		cmdMap.put(CommandType.FIND_IN_PROJECT_BROWSER, 
				new MethodCall(FindManager.class.getMethod("findInProjectTree", Object.class)));
		cmdMap.put(CommandType.FIND_BY_NAME, 
				new MethodCall(FindManager.class.getMethod("findByName", String.class)));
	}
	
	private void edit() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.REDO,
				new MethodCall(RedoManager.class.getMethod("redo")));
		cmdMap.put(CommandType.UNDO,
				new MethodCall(UndoManager.class.getMethod("undo")));
		cmdMap.put(CommandType.DUPLICATE,
				new MethodCall(DuplicateCommander.class.getMethod("duplicate", Object.class)));
		cmdMap.put(CommandType.COPY,
				new MethodCall(ClipboardMode.class.getMethod("cloneSelectedAndPutToClipboard")));
		cmdMap.put(CommandType.PASTE,
				new MethodCall(ClipboardMode.class.getMethod("pasteClipboard")));
		cmdMap.put(CommandType.RENAME,
				new MethodCall(RenameCommander.class.getMethod("rename", Object.class)));
		cmdMap.put(CommandType.EDIT, 
				new MethodCall(EditManager.class.getMethod("edit", Object.class)));		
		cmdMap.put(CommandType.DELETE, 
				new MethodCall(DeleteCommander.class.getMethod("delete", Object.class)));		
	}
	
	private void addition() throws NoSuchMethodException, SecurityException{
		for(ClassType ct: ClassType.values()){		
			CommandType cmdType = CommandType.getAddCommandType(ct);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(AddCommander.class.getMethod("addClass", ClassType.class, RefOntoUML.Element.class), ct));
			}
		}
		for(DataType dt: DataType.values()){		
			CommandType cmdType = CommandType.getAddCommandType(dt);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(AddCommander.class.getMethod("addDataType", DataType.class, RefOntoUML.Element.class), dt));
			}
		}		
		for(RelationshipType rt: RelationshipType.values()){		
			CommandType cmdType = CommandType.getChangeToCommandType(rt);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(AddCommander.class.getMethod("addRelationship", RelationshipType.class, EObject.class), rt));
			}
		}	
		cmdMap.put(CommandType.ADD_PACKAGE, 
				new MethodCall(AddCommander.class.getMethod("addPackage",DefaultMutableTreeNode.class)));		
		cmdMap.put(CommandType.ADD_GENERALIZATIONSET, 
				new MethodCall(AddCommander.class.getMethod("addGeneralizationSet",RefOntoUML.Element.class)));
		cmdMap.put(CommandType.ADD_COMMENT, 
				new MethodCall(AddCommander.class.getMethod("addComment",RefOntoUML.Element.class)));
		cmdMap.put(CommandType.ADD_CONSTRAINT, 
				new MethodCall(AddCommander.class.getMethod("addConstraintx",RefOntoUML.Element.class)));		
		cmdMap.put(CommandType.ADD_OCLDOCUMENT, 
				new MethodCall(AddCommander.class.getMethod("addOclDocument", Object.class)));		
		cmdMap.put(CommandType.ADD_DIAGRAM, 
				new MethodCall(AddCommander.class.getMethod("addDiagram", Object.class)));		
		cmdMap.put(CommandType.NEW_OCLDOCUMENT,
				new MethodCall(AddCommander.class.getMethod("newOclDocument")));
		cmdMap.put(CommandType.NEW_DIAGRAM,
				new MethodCall(AddCommander.class.getMethod("newDiagram")));
	}
	
	private void change() throws NoSuchMethodException, SecurityException{
		for(ClassType ct: ClassType.values()){		
			CommandType cmdType = CommandType.getChangeToCommandType(ct);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(ChangeCommander.class.getMethod("changeClassStereotype", ClassType.class, RefOntoUML.Element.class), ct));
			}
		}
		for(RelationshipType rt: RelationshipType.values()){		
			CommandType cmdType = CommandType.getChangeToCommandType(rt);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(ChangeCommander.class.getMethod("changeRelationStereotype", RelationshipType.class, RefOntoUML.Relationship.class), rt));
			}
		}		
		cmdMap.put(CommandType.INVERT_END_NAMES, 
				new MethodCall(ChangeCommander.class.getMethod("invertEndNames", BaseConnection.class)));
		cmdMap.put(CommandType.INVERT_END_POINTS, 
				new MethodCall(ChangeCommander.class.getMethod("invertEndPoints",BaseConnection.class)));
		cmdMap.put(CommandType.INVERT_END_MULTIPLICITIES, 
				new MethodCall(ChangeCommander.class.getMethod("invertEndMultiplicities",BaseConnection.class)));
		cmdMap.put(CommandType.INVERT_END_TYPES, 
				new MethodCall(ChangeCommander.class.getMethod("invertEndTypes",BaseConnection.class)));
	}
	
	private void tabs() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.CLOSE_THIS,
				new MethodCall(AppTabManager.class.getMethod("closeThis", Component.class)));
		cmdMap.put(CommandType.CLOSE_OTHER,
				new MethodCall(AppTabManager.class.getMethod("closeOthers", Component.class)));
		cmdMap.put(CommandType.CLOSE_ALL,
				new MethodCall(AppTabManager.class.getMethod("closeAll", Component.class)));
		cmdMap.put(CommandType.SELECT_EDITOR,
				new MethodCall(AppTabManager.class.getMethod("selectEditor", Object.class)));
		cmdMap.put(CommandType.ADD_EDITOR,
				new MethodCall(AppTabManager.class.getMethod("addEditor", Object.class)));		
		cmdMap.put(CommandType.CLOSE_OCL_EDITOR,
				new MethodCall(AppTabManager.class.getMethod("closeCurrentOclEditor")));
		cmdMap.put(CommandType.CLOSE_DIAGRAM_EDITOR,
				new MethodCall(AppTabManager.class.getMethod("closeCurrentDiagramEditor")));		
		cmdMap.put(CommandType.ADD_FINDER_EDITOR,
				new MethodCall(AppTabManager.class.getMethod("addFinderEditor")));		
		cmdMap.put(CommandType.ADD_STATISTICS_EDITOR,
				new MethodCall(AppTabManager.class.getMethod("addStatisticsEditor")));
	}
	
	/** constructor */
	private CommandMap(){
		try {		
			applicationOperations();	
			essentialOperations();		
			
			diagramEditor();
			colorCommander();
			alignCommander();
			visibilityCommander();
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
			
			metaPropertyManager();
			
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private void colorCommander() throws NoSuchMethodException, SecurityException {
		cmdMap.put(CommandType.SET_BACKGROUND_COLOR,
				new MethodCall(ColorCommander.class.getMethod("setBackgroundColor", Object.class)));
		cmdMap.put(CommandType.COPY_BACKGROUND_COLOR,
				new MethodCall(ColorCommander.class.getMethod("copyBackgroundColor", Object.class)));
		cmdMap.put(CommandType.PASTE_BACKGROUND_COLOR,
				new MethodCall(ColorCommander.class.getMethod("pasteBackgroundColor", Object.class)));
	}
	
	private void visibilityCommander() throws NoSuchMethodException, SecurityException {
		cmdMap.put(CommandType.SHOW_END_POINT_NAMES,
				new MethodCall(VisibilityCommander.class.getMethod("showEndPointNames",Object.class)));
		cmdMap.put(CommandType.SHOW_MULTIPLICITIES,
				new MethodCall(VisibilityCommander.class.getMethod("showMultiplicities",Object.class)));
		cmdMap.put(CommandType.SHOW_NAME,
				new MethodCall(VisibilityCommander.class.getMethod("showName",Object.class)));
		cmdMap.put(CommandType.SHOW_REDEFINITIONS,
				new MethodCall(VisibilityCommander.class.getMethod("showRedefinitions",Object.class)));
		cmdMap.put(CommandType.SHOW_SUBSETTING,
				new MethodCall(VisibilityCommander.class.getMethod("showSubsetting",Object.class)));
		cmdMap.put(CommandType.SHOW_STEREOTYPE,
				new MethodCall(VisibilityCommander.class.getMethod("showStereotype",Object.class)));
		cmdMap.put(CommandType.SHOW_ALL,
				new MethodCall(VisibilityCommander.class.getMethod("showAll", Object.class)));
		cmdMap.put(CommandType.SHOW_ATTRIBUTES,
				new MethodCall(VisibilityCommander.class.getMethod("showAttributes", Object.class)));
		cmdMap.put(CommandType.SHOW_PARENTS,
				new MethodCall(VisibilityCommander.class.getMethod("showParents",Object.class)));
		cmdMap.put(CommandType.SHOW_NAMESPACE,
				new MethodCall(VisibilityCommander.class.getMethod("showNamespace",Object.class)));
		cmdMap.put(CommandType.SHOW_CLASS_STEREOTYPE,
				new MethodCall(VisibilityCommander.class.getMethod("showClassStereotype",Object.class)));
		cmdMap.put(CommandType.SHOW_GENERALIZATION_SETS,
				new MethodCall(VisibilityCommander.class.getMethod("showGeneralizationSet",Object.class)));
	}

	private void metaPropertyManager() throws NoSuchMethodException, SecurityException {
		cmdMap.put(CommandType.SUBSETS_SOURCE,
				new MethodCall(MetaPropertyManager.class.getMethod("subsetsSource", Object.class)));
		cmdMap.put(CommandType.SUBSETS_TARGET,
				new MethodCall(MetaPropertyManager.class.getMethod("subsetsTarget", Object.class)));
		cmdMap.put(CommandType.REDEFINES_SOURCE,
				new MethodCall(MetaPropertyManager.class.getMethod("redefinesSource", Object.class)));
		cmdMap.put(CommandType.REDEFINES_TARGET,
				new MethodCall(MetaPropertyManager.class.getMethod("redefinesTarget", Object.class)));
		cmdMap.put(CommandType.SET_ESSENTIAL,
				new MethodCall(MetaPropertyManager.class.getMethod("setEssential", Object.class)));
		cmdMap.put(CommandType.SET_INSEPARABLE,
				new MethodCall(MetaPropertyManager.class.getMethod("setInseparable", Object.class)));
		cmdMap.put(CommandType.SET_IMMUTABLEPART,
				new MethodCall(MetaPropertyManager.class.getMethod("setImmutablePart", Object.class)));
		cmdMap.put(CommandType.SET_IMMUTABLEWHOLE,
				new MethodCall(MetaPropertyManager.class.getMethod("setImmutableWhole", Object.class)));
		cmdMap.put(CommandType.SET_SHAREABLE,
				new MethodCall(MetaPropertyManager.class.getMethod("setShareable", Object.class)));
		cmdMap.put(CommandType.SET_ABSTRACT,
				new MethodCall(MetaPropertyManager.class.getMethod("setAbstract", Object.class)));
		cmdMap.put(CommandType.SET_DERIVED,
				new MethodCall(MetaPropertyManager.class.getMethod("setDerived", Object.class)));
		cmdMap.put(CommandType.SET_EXTENSIONAL,
				new MethodCall(MetaPropertyManager.class.getMethod("setExtensional", Object.class)));
		cmdMap.put(CommandType.OPTIONAL_ON_SOURCE,
				new MethodCall(MetaPropertyManager.class.getMethod("optionalOnSource", Object.class)));
		cmdMap.put(CommandType.OPTIONAL_ON_TARGET,
				new MethodCall(MetaPropertyManager.class.getMethod("optionalOnTarget", Object.class)));
		cmdMap.put(CommandType.SINGULAR_ON_SOURCE,
				new MethodCall(MetaPropertyManager.class.getMethod("singularOnSource", Object.class)));
		cmdMap.put(CommandType.SINGULAR_ON_TARGET,
				new MethodCall(MetaPropertyManager.class.getMethod("singularOnTarget", Object.class)));
		cmdMap.put(CommandType.SOME_ON_SOURCE,
				new MethodCall(MetaPropertyManager.class.getMethod("someOnSource", Object.class)));
		cmdMap.put(CommandType.SOME_ON_TARGET,
				new MethodCall(MetaPropertyManager.class.getMethod("someOnTarget", Object.class)));
		cmdMap.put(CommandType.ANY_ON_SOURCE,
				new MethodCall(MetaPropertyManager.class.getMethod("anyOnSource", Object.class)));
		cmdMap.put(CommandType.ANY_ON_TARGET,				
				new MethodCall(MetaPropertyManager.class.getMethod("anyOnTarget", Object.class)));
		cmdMap.put(CommandType.TWO_ON_SOURCE,
				new MethodCall(MetaPropertyManager.class.getMethod("twoOnSource", Object.class)));
		cmdMap.put(CommandType.TWO_ON_TARGET,
				new MethodCall(MetaPropertyManager.class.getMethod("twoOnTarget", Object.class)));
		cmdMap.put(CommandType.TWO_AT_LEAST_ON_SOURCE,
				new MethodCall(MetaPropertyManager.class.getMethod("twoAtLeastOnSource", Object.class)));
		cmdMap.put(CommandType.TWO_AT_LEAST_ON_TARGET,
				new MethodCall(MetaPropertyManager.class.getMethod("twoAtLeastOnTarget", Object.class)));
		cmdMap.put(CommandType.OTHER_ON_SOURCE,
				new MethodCall(MetaPropertyManager.class.getMethod("otherOnSource", Object.class)));
		cmdMap.put(CommandType.OTHER_ON_TARGET,
				new MethodCall(MetaPropertyManager.class.getMethod("otherOnTarget", Object.class)));
		cmdMap.put(CommandType.SET_SOURCE_END_POINT_NAME,
				new MethodCall(MetaPropertyManager.class.getMethod("endPointNameOnSource", Object.class)));
		cmdMap.put(CommandType.SET_TARGET_END_POINT_NAME,
				new MethodCall(MetaPropertyManager.class.getMethod("endPointNameOnTarget", Object.class)));	
		
	}

	private void alignCommander() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ALIGN_VERTICAL,
				new MethodCall(AlignCommander.class.getMethod("executeAlignCenterVertically",ArrayList.class)));
		cmdMap.put(CommandType.ALIGN_HORIZONTAL,
				new MethodCall(AlignCommander.class.getMethod("executeAlignCenterHorizontally",ArrayList.class)));
		cmdMap.put(CommandType.ALIGN_TOP,
				new MethodCall(AlignCommander.class.getMethod("executeAlignTop",ArrayList.class)));
		cmdMap.put(CommandType.ALIGN_BOTTOM,
				new MethodCall(AlignCommander.class.getMethod("executeAlignBottom",ArrayList.class)));
		cmdMap.put(CommandType.ALIGN_LEFT,
				new MethodCall(AlignCommander.class.getMethod("executeAlignLeft",ArrayList.class)));
		cmdMap.put(CommandType.ALIGN_RIGHT,
				new MethodCall(AlignCommander.class.getMethod("executeAlignRight",ArrayList.class)));
	}
	
	
	private void diagramEditor() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.SHOW_GRID,
				new MethodCall(OntoumlEditor.class.getMethod("showGrid")));
		cmdMap.put(CommandType.ERASE, 
				new MethodCall(OntoumlEditor.class.getMethod("excludeSelection", Object.class)));		
		cmdMap.put(CommandType.SELECT_ALL_DIAGRAM,
				new MethodCall(OntoumlEditor.class.getMethod("selectAll")));
		cmdMap.put(CommandType.REDRAW_DIAGRAM,
				new MethodCall(OntoumlEditor.class.getMethod("redraw")));
		cmdMap.put(CommandType.FIT_TO_WINDOW,
				new MethodCall(OntoumlEditor.class.getMethod("fitToWindow")));
		cmdMap.put(CommandType.ZOOM_OUT,
				new MethodCall(OntoumlEditor.class.getMethod("zoomOut")));
		cmdMap.put(CommandType.ZOOM_AT_100,
				new MethodCall(OntoumlEditor.class.getMethod("zoom100")));
		cmdMap.put(CommandType.ZOOM_IN,
				new MethodCall(OntoumlEditor.class.getMethod("zoomIn")));
		cmdMap.put(CommandType.PUT_BACK,
				new MethodCall(OntoumlEditor.class.getMethod("putToBack")));
		cmdMap.put(CommandType.BRING_TO_FRONT,
				new MethodCall(OntoumlEditor.class.getMethod("bringToFront")));
		cmdMap.put(CommandType.RESET_POINTS, 
			new MethodCall(OntoumlEditor.class.getMethod("resetConnectionPoints", Object.class)));
		cmdMap.put(CommandType.APPLY_DIRECT_STYLE, 
			new MethodCall(OntoumlEditor.class.getMethod("toDirect", Object.class)));
		cmdMap.put(CommandType.APPLY_RECTILINEAR_STYLE, 
			new MethodCall(OntoumlEditor.class.getMethod("toRectilinear", Object.class)));
		cmdMap.put(CommandType.APPLY_VERTICAL_STYLE, 
			new MethodCall(OntoumlEditor.class.getMethod("toTreeStyleVertical", Object.class)));		
		cmdMap.put(CommandType.APPLY_HORIZONTAL_STYLE,
			new MethodCall(OntoumlEditor.class.getMethod("toTreeStyleHorizontal", Object.class)));		
		cmdMap.put(CommandType.ADD_ALL_RELATED_ELEMENTS,
				new MethodCall(OntoumlEditor.class.getMethod("addAllRelatedElements", Object.class)));
		
		cmdMap.put(CommandType.NEW_GEN_SET_DIAGRAM, 
				new MethodCall(OntoumlEditor.class.getMethod("addGeneralizationSet", ArrayList.class)));
		cmdMap.put(CommandType.DELETE_GEN_SET_DIAGRAM,
				new MethodCall(OntoumlEditor.class.getMethod("deleteGeneralizationSet", Object.class)));
		
		cmdMap.put(CommandType.READING_DIRECTION_SOURCE,
				new MethodCall(OntoumlEditor.class.getMethod("readingDesignToSource",Object.class)));
		cmdMap.put(CommandType.READING_DIRECTION_TARGET,
				new MethodCall(OntoumlEditor.class.getMethod("readingDesignToTarget",Object.class)));
		cmdMap.put(CommandType.READING_DIRECTION_UNSPECIFIED,
				new MethodCall(OntoumlEditor.class.getMethod("readingDesignUnspecified",Object.class)));
					
	}
	
	private void palleteDragAndDrop() throws NoSuchMethodException, SecurityException{
		
		cmdMap.put(CommandType.PALLETE_POINTER_MODE, 
				new MethodCall(OntoumlEditor.class.getMethod("setSelectionMode")));	
		
		for(ClassType ct: ClassType.values()){		
			CommandType cmdType = CommandType.getPalleteCommandType(ct);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(ClipboardMode.class.getMethod("createAndPutToClipboard", ClassType.class), ct));
			}
		}
		for(DataType dt: DataType.values()){
			CommandType cmdType = CommandType.getPalleteCommandType(dt);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(ClipboardMode.class.getMethod("createAndPutToClipboard", DataType.class), dt));
			}
		}	
		for(RelationshipType dt: RelationshipType.values()){
			CommandType cmdType = CommandType.getPalleteCommandType(dt);
			if(cmdType!=null){
				cmdMap.put(cmdType, new MethodCall(OntoumlEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), dt));
			}
		}		
	}
	
	
	private void sbvrManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.GENERATE_SBVR, 
				new MethodCall(SbvrFeature.class.getMethod("generateSbvr")));
		cmdMap.put(CommandType.OPEN_LINK_WITH_BROWSER,
				new MethodCall(SbvrFeature.class.getMethod("openLinkWithBrowser", String.class)));		
	}
	
	private void alloyManager() throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.ALLOY_SETTINGS,
			new MethodCall(AlloyFeature.class.getMethod("openAlloySettings")));
	}
	
	private void owlManager()throws NoSuchMethodException, SecurityException{
		cmdMap.put(CommandType.OWL_SETTINGS,
				new MethodCall(OwlFeature.class.getMethod("callOwlSettings")));
		cmdMap.put(CommandType.GENERATE_OWL,
				new MethodCall(OwlFeature.class.getMethod("generateOwl", Object.class)));
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
				new MethodCall(ParthoodFeature.class.getMethod("evaluateParthoods")));
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
