package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class LineStyleMenu  extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public LineStyleMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public LineStyleMenu(CommandListener listener){
		super(listener, "Visibility");		
		build();
  	}
	
	public void build(){
		createMenuItem("Direct", CommandType.APPLY_DIRECT_STYLE);
		createMenuItem("Rectilinear", CommandType.APPLY_RECTILINEAR_STYLE);
		createMenuItem("Tree Style Horizontal", CommandType.APPLY_HORIZONTAL_STYLE);
		createMenuItem("Tree Style Vertical", CommandType.APPLY_VERTICAL_STYLE);		
		sort();
	}
}
