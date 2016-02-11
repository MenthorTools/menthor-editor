package net.menthor.editor.v2.commanders;

import java.util.ArrayList;
import java.util.Collection;

import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.commands.Command;

import net.menthor.editor.v2.ui.app.manager.AppTabManager;

public abstract class GenericCommander {
	
	public GenericCommander(){
		
	}
	
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
	
	public OntoumlEditor currentEditor(){
		return AppTabManager.get().getCurrentDiagramEditor();
	}
	
	public void execute(Command command){
		currentEditor().execute(command);
	}
	
}
