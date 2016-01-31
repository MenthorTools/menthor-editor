package net.menthor.editor.v2.managers;

import net.menthor.editor.ui.MainFrame;
import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.v2.EditorTabbedPane;
import net.menthor.editor.v2.InfoTabbedPane;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.tree.ProjectTree;

public class BaseManager {

	private static BaseManager instance = new BaseManager();
	public static BaseManager get() { return instance; }
	
	protected CommandListener listener(){ return frame(); }
	
	protected MainFrame frame(){ return MenthorEditor.getFrame(); }
	
	protected ProjectTree tree(){ return MenthorEditor.getFrame().getProjectBrowser().getTree(); }
	
	protected EditorTabbedPane editorTabbedPane() { return MenthorEditor.getFrame().getDiagramManager(); }
	
	protected InfoTabbedPane infoTabbedPane() { return MenthorEditor.getFrame().getInfoManager(); }		
}
