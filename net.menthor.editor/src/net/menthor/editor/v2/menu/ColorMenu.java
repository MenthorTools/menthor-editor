package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;

public class ColorMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public ColorMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public ColorMenu(CommandListener listener){
		super(listener, "Background Color");		
		build();
  	}
	
	public void build(){
		createMenuItem("Set", IconType.MENTHOR_COLOR_CHOOSER, CommandType.SETUP_BACKGROUND_COLOR);
		createMenuItem("Copy", CommandType.COPY_BACKGROUND_COLOR);
		createMenuItem("Paste", CommandType.PASTE_BACKGROUND_COLOR);		
		sort();
	}

}
