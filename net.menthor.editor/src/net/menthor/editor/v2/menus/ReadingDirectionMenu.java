package net.menthor.editor.v2.menus;

import javax.swing.ButtonGroup;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class ReadingDirectionMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public ReadingDirectionMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public ReadingDirectionMenu(CommandListener listener){
		super(listener, "Reading Direction");		
		build();
  	}
	
	public void build(){
		ButtonGroup group = new ButtonGroup();
		group.add(createRadioMenuItem("To Source", CommandType.READING_DIRECTION_SOURCE));
		group.add(createRadioMenuItem("To Target", CommandType.READING_DIRECTION_TARGET));
		group.add(createRadioMenuItem("Unspecified", CommandType.READING_DIRECTION_UNSPECIFIED));
		sort();
	}
}