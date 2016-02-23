package net.menthor.editor.v2.managers;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.ui.Browser;
import net.menthor.editor.v2.ui.Frame;
import net.menthor.editor.v2.ui.MenuBar;
import net.menthor.editor.v2.ui.SplitPane;
import net.menthor.editor.v2.ui.TopTabbedPane;
import net.menthor.editor.v2.ui.BottomTabbedPane;

public abstract class AbstractManager {

	public CommandListener listener(){ return CommandListener.get(); }
	public Frame frame(){ return Frame.get(); }
	public Browser browser(){ return Browser.get(); }
	public SplitPane splitPane(){ return SplitPane.get(); }
	public TopTabbedPane editorsPane(){ return TopTabbedPane.get(); }
	public BottomTabbedPane infoPane(){ return BottomTabbedPane.get(); }
	public MenuBar menubar(){ return MenuBar.get(); }
	
}
