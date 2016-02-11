package net.menthor.editor.v2.ui.app.manager;

import net.menthor.editor.v2.ui.app.AppBrowser;
import net.menthor.editor.v2.ui.app.AppCmdListener;
import net.menthor.editor.v2.ui.app.AppEditorsPane;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.app.AppInfoPane;
import net.menthor.editor.v2.ui.app.AppSplitPane;

public abstract class AppGenericManager {
	
	protected AppFrame frame(){ return AppFrame.get(); }	
	protected AppCmdListener listener(){ return AppCmdListener.get(); }	
	protected AppSplitPane splitPane() { return AppSplitPane.get(); }	
	protected AppBrowser browser() { return AppBrowser.get(); }	
	protected AppEditorsPane editorsPane() { return AppEditorsPane.get(); }	
	protected AppInfoPane infoPane() { return AppInfoPane.get(); }		
}
