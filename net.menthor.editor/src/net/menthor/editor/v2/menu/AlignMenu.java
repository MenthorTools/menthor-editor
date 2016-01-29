package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class AlignMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AlignMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public AlignMenu(CommandListener listener){
		super(listener, "Align");		
		build();
  	}
	
	public void build(){
		createMenuItem("Top", CommandType.ALIGN_TOP);				
		createMenuItem("Bottom", CommandType.ALIGN_BOTTOM);
		createMenuItem("Left", CommandType.ALIGN_LEFT);
		createMenuItem("Right", CommandType.ALIGN_RIGHT);
		createMenuItem("Horizontal", CommandType.ALIGN_HORIZONTAL);
		createMenuItem("Vertical", CommandType.ALIGN_VERTICAL);
		sort();
	}
}
