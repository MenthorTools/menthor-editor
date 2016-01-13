package net.menthor.editor.v2.menu;

import org.tinyuml.umldraw.AssociationElement;

import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.editor.v2.commands.CommandListener;

public class SourceMultiplicityMenu extends MultiplicityMenu {

	private static final long serialVersionUID = 3797953970276009760L;
		
	public SourceMultiplicityMenu(CommandListener listener, String text){
		super(listener, text);	
	}
	
	public SourceMultiplicityMenu(CommandListener listener){
		super(listener, "Multiplicity on Source");		
  	}
	
	@Override
	public void setContext(Object context){		
		this.context = context;	
		if(context instanceof AssociationElement){
			RefOntoUML.Association rel = (RefOntoUML.Association)((AssociationElement)context).getRelationship();
			String mult = RefOntoUMLFactoryUtil.getMultiplicityAsString(rel.getMemberEnd().get(0));
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
