package net.menthor.editor.v2.commanders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.tinyuml.ui.diagram.OntoumlEditor;

import net.menthor.editor.v2.ui.controller.TabbedAreaController;
import net.menthor.editor.v2.ui.operation.IUndoableOperation;

public abstract class GenericCommander {
	
	public GenericCommander(){
		
	}
	
	public <T> ArrayList<T> setUpAsList(Object con, Class<T> type) {
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
	
	@SuppressWarnings({ "unchecked", "unused" })
	/** useful method to retain in a list only objects of a certain type */
	private <T> List<T> retainOnly(List<?> objectList, Class<T> type_){
		List<T> filteredList = new ArrayList<>();		
		for (Object diagramElement : objectList) {
			if(type_.isInstance(diagramElement)){
				filteredList.add((T) diagramElement);
			}
		}		
		return filteredList;
	}
	
	public OntoumlEditor currentEditor(){
		return TabbedAreaController.get().getSelectedTopOntoumlEditor();
	}
	
	public void execute(IUndoableOperation command){
		currentEditor().execute(command);
	}
	
}
