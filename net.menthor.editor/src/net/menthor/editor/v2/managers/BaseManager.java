package net.menthor.editor.v2.managers;

import net.menthor.editor.v2.MenthorEditor;
import net.menthor.editor.v2.commands.AppCommandListener;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.AppFrame;
import net.menthor.editor.v2.ui.splitpane.AppMultiSplitPane;
import net.menthor.editor.v2.ui.tabbedpane.AppEditorTabbedPane;
import net.menthor.editor.v2.ui.tabbedpane.AppInfoTabbedPane;
import net.menthor.editor.v2.ui.tree.ProjectTree;

public class BaseManager {

	private static BaseManager instance = new BaseManager();
	public static BaseManager get() { return instance; }
	
	protected AppFrame frame(){ return MenthorEditor.getFrame(); }
	
	protected ICommandListener listener(){ return AppCommandListener.get(); }
	
	protected AppMultiSplitPane splitPane() { return MenthorEditor.getFrame().getSplitPane(); }
	
	protected ProjectTree tree(){ return MenthorEditor.getFrame().getProjectBrowser().getTree(); }
	
	protected AppEditorTabbedPane editorTabbedPane() { return MenthorEditor.getFrame().getEditorTabbedPane(); }
	
	protected AppInfoTabbedPane infoTabbedPane() { return MenthorEditor.getFrame().getInfoTabbedPane(); }		
}
