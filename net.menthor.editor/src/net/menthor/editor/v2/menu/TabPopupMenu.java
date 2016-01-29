package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class TabPopupMenu extends BasePopupMenu {

	private static final long serialVersionUID = 8404322926387805476L;

	public TabPopupMenu(CommandListener listener) {
		super(listener);
		createMenuItem("Close This Tab", null, CommandType.CLOSE_THIS_TAB);
		createMenuItem("Close All Other Tabs", null, CommandType.CLOSE_OTHER_TABS);
		createMenuItem("Close All Tabs", null, CommandType.CLOSE_ALL_TABS);
	}
}
