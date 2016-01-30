package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.types.ClassType;

public class AddClassMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AddClassMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public AddClassMenu(CommandListener listener){
		super(listener, "Add Class");		
		build();
  	}
	
	public void build(){
		createMenuItem(ClassType.KIND.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_KIND);
		createMenuItem(ClassType.SUBKIND.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_SUBKIND);
		createMenuItem(ClassType.COLLECTIVE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_COLLECTIVE);
		createMenuItem(ClassType.QUANTITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_QUANTITY);
		createMenuItem(ClassType.PHASE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_PHASE);
		createMenuItem(ClassType.ROLE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_ROLE);
		createMenuItem(ClassType.CATEGORY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_CATEGORY);
		createMenuItem(ClassType.ROLEMIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_ROLEMIXIN);
		createMenuItem(ClassType.MIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_MIXIN);
		createMenuItem(ClassType.RELATOR.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_RELATOR);
		createMenuItem(ClassType.MODE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_MODE);
		createMenuItem(ClassType.PERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_PERCEIVABLE_QUALITY);
		createMenuItem(ClassType.NONPERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_NONPERCEIVABLE_QUALITY);
		createMenuItem(ClassType.NOMINAL_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_NOMINAL_QUALITY);
        sort();
	}
}
