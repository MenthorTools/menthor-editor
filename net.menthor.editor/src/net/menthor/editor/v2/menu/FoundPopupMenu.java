package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.elements.FoundElement;

public class FoundPopupMenu extends BasePopupMenu<FoundElement> {

	private static final long serialVersionUID = 2665584279780047982L;
	
	public FoundPopupMenu(final CommandListener listener, FoundElement element){
    	super(listener, element);
		createMenuItem("Find in Project Browser", CommandType.FIND_IN_PROJECT_BROWSER);
		createMenuItem("Find in Diagrams", CommandType.FIND_IN_DIAGRAMS);
		createMenuItem("Edit Properties", CommandType.EDIT);
	}	
}
