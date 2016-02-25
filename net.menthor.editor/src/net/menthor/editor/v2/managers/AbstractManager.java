package net.menthor.editor.v2.managers;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.ui.BrowserUI;
import net.menthor.editor.v2.ui.FrameUI;
import net.menthor.editor.v2.ui.MenuBarUI;
import net.menthor.editor.v2.ui.SplitPaneUI;
import net.menthor.editor.v2.ui.TopTabbedPaneUI;
import net.menthor.editor.v2.ui.BottomTabbedPaneUI;

public abstract class AbstractManager {

	public CommandListener listener(){ return CommandListener.get(); }
	public FrameUI frame(){ return FrameUI.get(); }
	public BrowserUI browser(){ return BrowserUI.get(); }
	public SplitPaneUI splitPane(){ return SplitPaneUI.get(); }
	public TopTabbedPaneUI editorsPane(){ return TopTabbedPaneUI.get(); }
	public BottomTabbedPaneUI infoPane(){ return BottomTabbedPaneUI.get(); }
	public MenuBarUI menubar(){ return MenuBarUI.get(); }
	
}
