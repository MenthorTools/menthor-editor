package net.menthor.editor.v2.ui.menu;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.element.FoundElement;
import net.menthor.editor.v2.commands.CommandType;

public class FoundPopupMenu extends GenericPopupMenu<FoundElement> {

	private static final long serialVersionUID = 2665584279780047982L;
	
	public FoundPopupMenu(final ICommandListener listener, FoundElement element){
    	super(listener, element);
		createMenuItem("Find in Project Browser", CommandType.FIND_IN_PROJECT_BROWSER);
		createMenuItem("Find in Diagrams", CommandType.FIND_IN_DIAGRAMS);
		createMenuItem("Edit Properties", CommandType.EDIT);
	}	
}
