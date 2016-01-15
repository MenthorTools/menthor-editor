package net.menthor.editor.v2.menu;

import javax.swing.ButtonGroup;

import org.tinyuml.umldraw.AssociationElement;

import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class TargetMultiplicityMenu extends MultiplicityMenu {

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
		optional = createRadioMenuItem("0..1", CommandType.OPTIONAL_ON_TARGET);
		singular = createRadioMenuItem("1", CommandType.SINGULAR_ON_TARGET);
		any = createRadioMenuItem("0..*", CommandType.ANY_ON_TARGET);
		some = createRadioMenuItem("1..*", CommandType.SOME_ON_TARGET);
		two = createRadioMenuItem("2", CommandType.TWO_ON_TARGET);
		twoAtLeast = createRadioMenuItem("2..*", CommandType.TWO_AT_LEAST_ON_TARGET);
		other = createRadioMenuItem("Other", CommandType.OTHER_ON_TARGET);
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
	@Override
	public void setContext(Object context){		
		this.context = context;	
		if(context instanceof AssociationElement){
			RefOntoUML.Association rel = (RefOntoUML.Association)((AssociationElement)context).getRelationship();
			String mult = RefOntoUMLFactoryUtil.getMultiplicityAsString(rel.getMemberEnd().get(1));
			if(mult.equals("0..1")) optional.setSelected(true);
			else if(mult.equals("1")) singular.setSelected(true);
			else if(mult.equals("1..*")) some.setSelected(true);
			else if(mult.equals("0..*") || mult.equals("*")) any.setSelected(true);
			else if(mult.equals("2")) two.setSelected(true);
			else if(mult.equals("2..*")) twoAtLeast.setSelected(true);
			else other.setSelected(true);		
		}
	}
}