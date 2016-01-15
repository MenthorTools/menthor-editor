package net.menthor.editor.v2.menu;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;

import net.menthor.editor.v2.commands.CommandListener;

public class MultiplicityMenu extends BaseMenu {
		
	private static final long serialVersionUID = -3936734322891978516L;
	protected ButtonGroup group;
	protected JRadioButtonMenuItem optional;
	protected JRadioButtonMenuItem singular;
	protected JRadioButtonMenuItem any;
	protected JRadioButtonMenuItem some;
	protected JRadioButtonMenuItem two;
	protected JRadioButtonMenuItem twoAtLeast;
	protected JRadioButtonMenuItem other;
	
	public MultiplicityMenu(CommandListener listener, String text){
		super(listener, text);	
	}
	
	public MultiplicityMenu(CommandListener listener){
		super(listener, "Multiplicity");	
  	}		
}
