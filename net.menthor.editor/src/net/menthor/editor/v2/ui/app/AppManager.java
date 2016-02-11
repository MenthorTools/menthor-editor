package net.menthor.editor.v2.ui.app;

import java.util.ArrayList;
import java.util.Collection;

/* 
 * A manager always manages menthor interface. 
 * To decide if a java class is a manager, see if it depends on some UI component of the application.
 * If so, that java class is supposed to extend AppManager.
 */

public abstract class AppManager {
	
	protected AppFrame frame(){ return AppFrame.get(); }	
	protected AppCmdListener listener(){ return AppCmdListener.get(); }	
	protected AppSplitPane splitPane() { return AppSplitPane.get(); }	
	protected AppBrowser browser() { return AppBrowser.get(); }	
	protected AppEditorsPane editorsPane() { return AppEditorsPane.get(); }	
	protected AppInfoPane infoPane() { return AppInfoPane.get(); }		
	
	public <T> ArrayList<T> setUpList(Object con, Class<T> type) {
		ArrayList<T> list = new ArrayList<T>();		
		if(type.isInstance(con)){
			list.add(type.cast(con));
		} else if (con instanceof Collection){
			for (Object item : (Collection<?>)con) {
				if(type.isInstance(item)){
					list.add(type.cast(item));
				}
			}
		}
		return list;
	}
}
