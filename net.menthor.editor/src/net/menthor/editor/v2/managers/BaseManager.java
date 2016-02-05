package net.menthor.editor.v2.managers;

import net.menthor.editor.ui.AppFrame;
import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.ui.tabbedpane.AppEditorTabbedPane;
import net.menthor.editor.v2.ui.tabbedpane.AppInfoTabbedPane;
import net.menthor.editor.v2.ui.tree.ProjectTree;

public class BaseManager {

	private static BaseManager instance = new BaseManager();
	public static BaseManager get() { return instance; }
	
	protected CommandListener listener(){ return frame(); }
	
	protected AppFrame frame(){ return MenthorEditor.getFrame(); }
	
	protected ProjectTree tree(){ return MenthorEditor.getFrame().getProjectBrowser().getTree(); }
	
	protected AppEditorTabbedPane editorTabbedPane() { return MenthorEditor.getFrame().getEditorTabbedPane(); }
	
	protected AppInfoTabbedPane infoTabbedPane() { return MenthorEditor.getFrame().getInfoTabbedPane(); }		
}
