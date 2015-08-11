package net.menthor.editor.v2.menus;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class GenSetMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public GenSetMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public GenSetMenu(CommandListener listener){
		super(listener, "Generalization Set");		
		build();
  	}
	
	public void build(){
		createMenuItem("Add", CommandType.ADD_GEN_SET_DIAGRAM);
		createMenuItem("Remove", CommandType.DELETE_GEN_SET_DIAGRAM);		
		sort();
	}
}
