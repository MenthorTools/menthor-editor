package net.menthor.editor.v2.ui.manager;

import java.util.ArrayList;
import java.util.Collection;

import net.menthor.editor.v2.ui.app.AppBrowser;
import net.menthor.editor.v2.ui.app.AppCmdListener;
import net.menthor.editor.v2.ui.app.AppEditorsPane;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.app.AppInfoPane;
import net.menthor.editor.v2.ui.app.AppSplitPane;

public abstract class GenericUIManager {
	
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
