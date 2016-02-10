package net.menthor.editor.v2.managers;

import net.menthor.editor.v2.ui.app.AppCommandListener;
import net.menthor.editor.v2.ui.app.AppEditorTabbedPane;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.app.AppInfoTabbedPane;
import net.menthor.editor.v2.ui.app.AppMultiSplitPane;
import net.menthor.editor.v2.ui.app.AppProjectBrowser;
import net.menthor.editor.v2.ui.tree.ProjectTree;

public class BaseManager {

	private static BaseManager instance = new BaseManager();
	public static BaseManager get() { return instance; }
	
	protected AppFrame frame(){ return AppFrame.get(); }
	protected ProjectTree tree(){ return browser().getTree(); }	
	
	protected AppCommandListener listener(){ return AppCommandListener.get(); }	
	protected AppMultiSplitPane splitPane() { return AppMultiSplitPane.get(); }	
	protected AppProjectBrowser browser() { return AppProjectBrowser.get(); }	
	protected AppEditorTabbedPane editorTabbedPane() { return AppEditorTabbedPane.get(); }	
	protected AppInfoTabbedPane infoTabbedPane() { return AppInfoTabbedPane.get(); }		
}
