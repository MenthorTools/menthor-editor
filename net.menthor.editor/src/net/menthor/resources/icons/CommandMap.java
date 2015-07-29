package net.menthor.resources.icons;

import java.util.HashMap;
import java.util.Map;

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
		cmdMap.put(CommandType.NEW_DIAGRAM,
				new MethodCall(DiagramManager.class.getMethod("newDiagram")));
		cmdMap.put(CommandType.CLOSE_DIAGRAM,
				new MethodCall(DiagramManager.class.getMethod("closeDiagram")));
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
		
		cmdMap.put(CommandType.SEARCH_TERM,
				new MethodCall(DiagramManager.class.getMethod("searchInProject")));
		cmdMap.put(CommandType.CHECK_SYNTAX,
				new MethodCall(DiagramManager.class.getMethod("verifyModelSyntactically")));
		cmdMap.put(CommandType.COLLECT_STATISTICS,
				new MethodCall(DiagramManager.class.getMethod("collectStatistics")));
		
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
