package net.menthor.editor.v2.ui.menu;

import java.awt.Component;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

/*
 * Pop-up shown when right-clicking a tab.
 * Context: Tab being clicked.
 * */
public class TabPopupMenu extends GenericPopupMenu<Component> {

	private static final long serialVersionUID = 8404322926387805476L;

	public TabPopupMenu(CommandListener listener, Component tab) {
		super(listener,tab);
		createMenuItem("Close This Tab", null, CommandType.CLOSE_THIS);
		createMenuItem("Close All Other Tabs", null, CommandType.CLOSE_OTHER);
		createMenuItem("Close All Tabs", null, CommandType.CLOSE_ALL);
	}
}
