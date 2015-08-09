package net.menthor.editor.v2.menus;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class VisibilityMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public VisibilityMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public VisibilityMenu(CommandListener listener){
		super(listener, "Visibility");		
		build();
  	}
	
	public void build(){
		createCheckBoxMenuItem("End-Point Names", CommandType.SHOW_END_POINT_NAMES);
		createCheckBoxMenuItem("Subsetting", CommandType.SHOW_SUBSETTING);
		createCheckBoxMenuItem("Redefining", CommandType.SHOW_REDEFINITIONS);
		createCheckBoxMenuItem("Multiplicities", CommandType.SHOW_MULTIPLICITIES);
		createCheckBoxMenuItem("Name", CommandType.SHOW_NAME);
		createCheckBoxMenuItem("Stereotype", CommandType.SHOW_STEREOTYPE);
		sort();
	}
}
