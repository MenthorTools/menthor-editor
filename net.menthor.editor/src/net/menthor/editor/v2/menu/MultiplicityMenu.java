package net.menthor.editor.v2.menu;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

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
		build();
	}
	
	public MultiplicityMenu(CommandListener listener){
		super(listener, "Multiplicity");		
		build();
  	}
	
	public void build(){
		optional = createRadioMenuItem("0..1", CommandType.OPTIONAL_ON_SOURCE);
		singular = createRadioMenuItem("1", CommandType.SINGULAR_ON_SOURCE);
		any = createRadioMenuItem("0..*", CommandType.ANY_ON_SOURCE);
		some = createRadioMenuItem("1..*", CommandType.SOME_ON_SOURCE);
		two = createRadioMenuItem("2", CommandType.TWO_ON_SOURCE);
		twoAtLeast = createRadioMenuItem("2..*", CommandType.TWO_AT_LEAST_ON_SOURCE);
		other = createRadioMenuItem("Other", CommandType.OTHER_ON_SOURCE);
		group = new ButtonGroup();
		group.add(optional);
		group.add(singular);
		group.add(any);
		group.add(some);
		group.add(two);
		group.add(twoAtLeast);
		group.add(other);
		sort();
	}	
}
