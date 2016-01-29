package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class InvertMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public InvertMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public InvertMenu(CommandListener listener){
		super(listener, "Invert");		
		build();
  	}
	
	public void build(){
		createMenuItem("End-Points Names", CommandType.INVERT_END_NAMES);
		createMenuItem("End-Points", CommandType.INVERT_END_POINTS);
		createMenuItem("End-Points Multiplicities", CommandType.INVERT_END_MULTIPLICITIES);
		createMenuItem("End-Points Types", CommandType.INVERT_END_TYPES);		
		sort();
	}
}
