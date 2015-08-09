package net.menthor.editor.v2.menus;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class MetaAttributeMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public MetaAttributeMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public MetaAttributeMenu(CommandListener listener){
		super(listener, "Meta Attribute");		
		build();
  	}
	
	public void build(){
		createCheckBoxMenuItem("Essential", CommandType.SET_ESSENTIAL);
		createCheckBoxMenuItem("Inseparable", CommandType.SET_INSEPARABLE);		
		createCheckBoxMenuItem("Immutable Part", CommandType.SET_IMMUTABLEPART);
		createCheckBoxMenuItem("Immutable Whole", CommandType.SET_IMMUTABLEWHOLE);
		createCheckBoxMenuItem("Shareable", CommandType.SET_SHAREABLE);
		sort();
	}

}
