package net.menthor.editor.v2.ui.app;

/* A manager always manages menthor interface. 
 * To decide if a java class is a manager, see if it depends on some UI component of the application.
 * If so, that java class is supposed to extend AppManager. If not, it should extend GenericCommander 
 */

public abstract class AppManager {
	
	protected AppFrame frame(){ return AppFrame.get(); }	
	protected AppCmdListener listener(){ return AppCmdListener.get(); }	
	protected AppSplitPane splitPane() { return AppSplitPane.get(); }	
	protected AppBrowser browser() { return AppBrowser.get(); }	
	protected AppEditorsPane editorsPane() { return AppEditorsPane.get(); }	
	protected AppInfoPane infoPane() { return AppInfoPane.get(); }		
}
