package net.menthor.editor.v2.menu;

import org.tinyuml.umldraw.AssociationElement;

import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.editor.v2.commands.CommandListener;

public class TargetMultiplicityMenu extends MultiplicityMenu {

	private static final long serialVersionUID = 3797953970276009760L;
		
	public TargetMultiplicityMenu(CommandListener listener, String text){
		super(listener, text);	
	}
	
	public TargetMultiplicityMenu(CommandListener listener){
		super(listener, "Multiplicity on Target");		
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