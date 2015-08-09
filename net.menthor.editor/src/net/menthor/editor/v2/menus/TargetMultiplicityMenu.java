package net.menthor.editor.v2.menus;

import javax.swing.ButtonGroup;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class TargetMultiplicityMenu  extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public TargetMultiplicityMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public TargetMultiplicityMenu(CommandListener listener){
		super(listener, "Multiplicity on Target");		
		build();
  	}
	
	public void build(){
		ButtonGroup group = new ButtonGroup();
		group.add(createRadioMenuItem("0..1", CommandType.OPTIONAL_ON_TARGET));
		group.add(createRadioMenuItem("1", CommandType.SINGULAR_ON_TARGET));		
		group.add(createRadioMenuItem("0..*", CommandType.ANY_ON_TARGET));
		group.add(createRadioMenuItem("1..*", CommandType.SOME_ON_TARGET));
		group.add(createRadioMenuItem("2", CommandType.TWO_ON_TARGET));
		group.add(createRadioMenuItem("2..*", CommandType.TWO_AT_LEAST_ON_TARGET));
		group.add(createRadioMenuItem("Other", CommandType.OTHER_ON_TARGET));
		sort();
	}
}