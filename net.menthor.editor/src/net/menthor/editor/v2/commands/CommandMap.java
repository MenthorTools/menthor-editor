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

import java.util.HashMap;
import java.util.Map;

import org.tinyuml.ui.diagram.DiagramEditor;

import net.menthor.editor.AppFrame;
import net.menthor.editor.DiagramManager;
import net.menthor.editor.model.ElementType;
import net.menthor.editor.v2.types.RelationshipType;

public class CommandMap {
	
	private static CommandMap instance = new CommandMap();
	
	private Map<CommandType, MethodCall> cmdMap = new HashMap<CommandType, MethodCall>();
	private Map<CommandType, String> descMap = new HashMap<CommandType, String>();
	public Map<CommandType, MethodCall> getMap() { return cmdMap; }
	
	public String getDescription(CommandType cmdType) {
		return descMap.get(cmdType);
	}
	/** constructor */
	private CommandMap(){
		try {
		
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

		cmdMap.put(CommandType.NEW_DIAGRAM,
				new MethodCall(DiagramManager.class.getMethod("newDiagram")));
		cmdMap.put(CommandType.CLOSE_DIAGRAM,
				new MethodCall(DiagramManager.class.getMethod("closeDiagram")));
		cmdMap.put(CommandType.FIT_TO_WINDOW,
				new MethodCall(DiagramEditor.class.getMethod("fitToWindow")));
		cmdMap.put(CommandType.ZOOM_OUT,
				new MethodCall(DiagramEditor.class.getMethod("zoomOut")));
		cmdMap.put(CommandType.ZOOM_AT_100,
				new MethodCall(DiagramEditor.class.getMethod("zoom100")));
		cmdMap.put(CommandType.ZOOM_IN,
				new MethodCall(DiagramEditor.class.getMethod("zoomIn")));
		cmdMap.put(CommandType.EXPORT_IMAGE,
				new MethodCall(DiagramManager.class.getMethod("exportGfx")));
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
		cmdMap.put(CommandType.SHOW_GRID,
				new MethodCall(DiagramEditor.class.getMethod("showGrid")));
		cmdMap.put(CommandType.SET_BACKGROUND_COLOR,
				new MethodCall(DiagramEditor.class.getMethod("executeSetBackgroundColor")));		
		cmdMap.put(CommandType.REDO_DIAGRAM,
				new MethodCall(DiagramEditor.class.getMethod("redo")));
		cmdMap.put(CommandType.UNDO_DIAGRAM,
				new MethodCall(DiagramEditor.class.getMethod("undo")));
		
		cmdMap.put(CommandType.POINTER_MODE, 
				new MethodCall(DiagramEditor.class.getMethod("setSelectionMode")));
		
		cmdMap.put(CommandType.CREATE_KIND, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.KIND));
		cmdMap.put(CommandType.CREATE_QUANTITY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.QUANTITY));
		cmdMap.put(CommandType.CREATE_COLLECTIVE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.COLLECTIVE));
		cmdMap.put(CommandType.CREATE_SUBKIND, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.SUBKIND));
		cmdMap.put(CommandType.CREATE_PHASE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.PHASE));
		cmdMap.put(CommandType.CREATE_ROLE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.ROLE));
		cmdMap.put(CommandType.CREATE_CATEGORY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.CATEGORY));
		cmdMap.put(CommandType.CREATE_ROLEMIXIN, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.ROLEMIXIN));
		cmdMap.put(CommandType.CREATE_MIXIN, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.MIXIN));
		cmdMap.put(CommandType.CREATE_MODE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.MODE));
		cmdMap.put(CommandType.CREATE_RELATOR, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.RELATOR));
		cmdMap.put(CommandType.CREATE_PERCEIVABLE_QUALITY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.PERCEIVABLEQUALITY));
		cmdMap.put(CommandType.CREATE_NOMINAL_QUALITY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.NOMINALQUALITY));
		cmdMap.put(CommandType.CREATE_NONPERCEIVABLE_QUALITY, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.NONPERCEIVABLEQUALITY));
		
		cmdMap.put(CommandType.CREATE_DATATYPE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.DATATYPE));
		cmdMap.put(CommandType.CREATE_ENUMERATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.ENUMERATION));
		cmdMap.put(CommandType.CREATE_PRIMITIVETYPE, 
				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ElementType.class), ElementType.PRIMITIVETYPE));
		
		cmdMap.put(CommandType.CREATE_GENERALIZATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.GENERALIZATION));
		cmdMap.put(CommandType.CREATE_CHARACTERIZATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.CHARACTERIZATION));
		cmdMap.put(CommandType.CREATE_FORMAL, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.FORMAL));
		cmdMap.put(CommandType.CREATE_MATERIAL, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.MATERIAL));				
		cmdMap.put(CommandType.CREATE_MEDIATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.MEDIATION));
		cmdMap.put(CommandType.CREATE_MEMBEROF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.MEMBEROF));
		cmdMap.put(CommandType.CREATE_SUBQUANTITYOF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.SUBQUANTITYOF));
		cmdMap.put(CommandType.CREATE_SUBCOLLECTIONOF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.SUBCOLLECTIONOF));
		cmdMap.put(CommandType.CREATE_COMPONENTOF, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.COMPONENTOF));
		cmdMap.put(CommandType.CREATE_DERIVATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.DERIVATION));
		cmdMap.put(CommandType.CREATE_ASSOCIATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.ASSOCIATION));
		cmdMap.put(CommandType.CREATE_STRUCTURATION, 
				new MethodCall(DiagramEditor.class.getMethod("setCreateConnectionMode", RelationshipType.class), RelationshipType.STRUCTURATION));
		
		cmdMap.put(CommandType.CALL_MIXIN_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.PATTERN_MIXIN_PATTERN));		
		cmdMap.put(CommandType.CALL_MIXIN_WITH_SUBKIND_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.PATTERN_MIXIN_PATTERN_WITH_SUBKIND));		
		cmdMap.put(CommandType.CALL_PHASE_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.PATTERN_PHASE_PARTITION));
		cmdMap.put(CommandType.CALL_SUBKIND_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.PATTERN_SUBKIND_PARTITION));		
		cmdMap.put(CommandType.CALL_ROLE_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.PATTERN_ROLE_PARTITION));		
		cmdMap.put(CommandType.CALL_GENERIC_RELATOR_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.GENERIC_RELATOR));		
		cmdMap.put(CommandType.CALL_DEPENDENT_ROLEMIXIN_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.DEPENDENT_ROLEMIXIN));		
		cmdMap.put(CommandType.CALL_KIND_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.KIND_PARTITION));		
		cmdMap.put(CommandType.CALL_COLLECTIVE_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.COLLECTIVE_PARTITION));		
		cmdMap.put(CommandType.CALL_QUANTITY_PARTITION_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.QUANTITY_PARTITION));		
		cmdMap.put(CommandType.CALL_CATEGORY_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.CATEGORY_PATTERN));		
		cmdMap.put(CommandType.CALL_COMPLETER_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.PATTERN_COMPLETER));		
		cmdMap.put(CommandType.CALL_ROLEMIXIN_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.PATTERN_ROLEMIXIN));		
		cmdMap.put(CommandType.CALL_CHARACTERIZATION_PATTERN,
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.CHARACTERIZATION_PATTERN));		
		cmdMap.put(CommandType.CALL_RIGID_WS_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.RIGID_WEAK_SUPPLEMENTATION));		
		cmdMap.put(CommandType.CALL_ANTIRIGID_WS_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.ANTIRIGID_WEAK_SUPPLEMENTATION));		
		cmdMap.put(CommandType.CALL_RELATOR_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.PATTERN_RELATOR));
		
		cmdMap.put(CommandType.CALL_DOMAIN_PATTERN, 
				new MethodCall(DiagramEditor.class.getMethod("setPatternMode",ElementType.class),ElementType.DOMAIN_PATTERN));
		
		cmdMap.put(CommandType.CALL_UNION_PATTERN, 
				new MethodCall(DiagramManager.class.getMethod("deriveByUnion")));
		cmdMap.put(CommandType.CALL_EXCLUSION_PATTERN, 
				new MethodCall(DiagramManager.class.getMethod("deriveByExclusion")));
		cmdMap.put(CommandType.CALL_SPECIALIZATION_PATTERN, 
				new MethodCall(DiagramManager.class.getMethod("deriveBySpecialization")));
		cmdMap.put(CommandType.CALL_INTERSECTION_PATTERN, 
				new MethodCall(DiagramManager.class.getMethod("deriveByIntersection")));
		cmdMap.put(CommandType.CALL_PASTSPECIALIZATION_PATTERN, 
				new MethodCall(DiagramManager.class.getMethod("deriveByPastSpecialization")));
		cmdMap.put(CommandType.CALL_PARTICIPATION_PATTERN, 
				new MethodCall(DiagramManager.class.getMethod("deriveByParticipation")));
		
		cmdMap.put(CommandType.SEARCH_TERM,
				new MethodCall(DiagramManager.class.getMethod("searchInProject")));
		cmdMap.put(CommandType.CHECK_SYNTAX,
				new MethodCall(DiagramManager.class.getMethod("verifyModelSyntactically")));
		cmdMap.put(CommandType.COLLECT_STATISTICS,
				new MethodCall(DiagramManager.class.getMethod("collectStatistics")));
		cmdMap.put(CommandType.SIMULATE,
				new MethodCall(DiagramManager.class.getMethod("simulate")));
		cmdMap.put(CommandType.IMPLEMENT_IN_OWL,
				new MethodCall(DiagramManager.class.getMethod("implementInOwl")));
		
		cmdMap.put(CommandType.EXPORT_IMAGE,
				new MethodCall(DiagramManager.class.getMethod("exportGfx")));
		cmdMap.put(CommandType.EXPORT_ECORE,
				new MethodCall(DiagramManager.class.getMethod("exportEcore")));
		cmdMap.put(CommandType.EXPORT_UML,
				new MethodCall(DiagramManager.class.getMethod("exportUML")));
		cmdMap.put(CommandType.EXPORT_PATTERN,
				new MethodCall(DiagramManager.class.getMethod("exportPattern")));
		cmdMap.put(CommandType.EXPORT_OCL,
				new MethodCall(DiagramManager.class.getMethod("exportOCL")));
		
		cmdMap.put(CommandType.IMPORT_ECORE,
				new MethodCall(DiagramManager.class.getMethod("importEcore")));
		cmdMap.put(CommandType.IMPORT_PATTERN,
				new MethodCall(DiagramManager.class.getMethod("importPattern")));
		cmdMap.put(CommandType.IMPORT_XMI,
				new MethodCall(DiagramManager.class.getMethod("importXMI")));
		cmdMap.put(CommandType.IMPORT_XMI_FROM_FILE,
				new MethodCall(DiagramManager.class.getMethod("importXMIFromRecent")));		
		cmdMap.put(CommandType.IMPORT_OCL,
				new MethodCall(DiagramManager.class.getMethod("importOCL")));
		
		cmdMap.put(CommandType.EDIT_SETTINGS, 
				new MethodCall(AppFrame.class.getMethod("editSettings")));
		cmdMap.put(CommandType.QUIT_MENTHOR,
				new MethodCall(AppFrame.class.getMethod("quitApplication")));
		cmdMap.put(CommandType.ABOUT,
				new MethodCall(AppFrame.class.getMethod("about")));			
		cmdMap.put(CommandType.HELP_CONTENTS, 
				new MethodCall(AppFrame.class.getMethod("displayHelpContents")));
		
		} catch (NoSuchMethodException e) {		
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	public static CommandMap getInstance() { return instance; }
}
