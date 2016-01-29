package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class FoundPopupMenu extends BasePopupMenu {

	private static final long serialVersionUID = 2665584279780047982L;
	
	public FoundPopupMenu(final CommandListener listener){
    	super(listener);
		createMenuItem("Find in Project Browser", CommandType.FIND_IN_PROJECT_BROWSER);
		createMenuItem("Find in Diagrams", CommandType.FIND_IN_DIAGRAMS);
		createMenuItem("Edit Properties", CommandType.EDIT);
	}	
}
