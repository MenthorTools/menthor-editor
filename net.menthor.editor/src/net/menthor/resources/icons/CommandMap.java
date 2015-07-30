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

import java.util.HashMap;
import java.util.Map;

import org.tinyuml.ui.diagram.DiagramEditor;

import net.menthor.editor.AppFrame;
import net.menthor.editor.DiagramManager;
import net.menthor.editor.util.MethodCall;

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
		
//		cmdMap.put(CommandType.CREATE_KIND, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.KIND));
//		cmdMap.put(CommandType.CREATE_QUANTITY, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.QUANTITY));
//		cmdMap.put(CommandType.CREATE_COLLECTIVE, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.COLLECTIVE));
//		cmdMap.put(CommandType.CREATE_SUBKIND, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.SUBKIND));
//		cmdMap.put(CommandType.CREATE_PHASE, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.PHASE));
//		cmdMap.put(CommandType.CREATE_ROLE, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.ROLE));
//		cmdMap.put(CommandType.CREATE_CATEGORY, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.CATEGORY));
//		cmdMap.put(CommandType.CREATE_ROLEMIXIN, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.ROLEMIXIN));
//		cmdMap.put(CommandType.CREATE_MIXIN, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.MIXIN));
//		cmdMap.put(CommandType.CREATE_MODE, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.MODE));
//		cmdMap.put(CommandType.CREATE_RELATOR, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.RELATOR));
//		cmdMap.put(CommandType.CREATE_PERCEIVABLE_QUALITY, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.PERCEIVABLE_QUALITY));
//		cmdMap.put(CommandType.CREATE_NOMINAL_QUALITY, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.NOMINAL_QUALITY));
//		cmdMap.put(CommandType.CREATE_EVENT, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.EVENT));
//		cmdMap.put(CommandType.CREATE_POWERTYPE, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.POWERTYPE));
//		cmdMap.put(CommandType.CREATE_CLASS, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", ClassType.class), ClassType.CLASS));
//		
//		cmdMap.put(CommandType.CREATE_DATATYPE, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.DATATYPE));
//		cmdMap.put(CommandType.CREATE_ENUMERATION, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.ENUMERATION));
//		cmdMap.put(CommandType.CREATE_DIMENSION, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.DIMENSION));
//		cmdMap.put(CommandType.CREATE_DOMAIN, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.DOMAIN));
//		cmdMap.put(CommandType.CREATE_PRIMITIVETYPE, 
//				new MethodCall(DiagramEditor.class.getMethod("setCreationMode", DataType.class), DataType.PRIMITIVETYPE));
		
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
