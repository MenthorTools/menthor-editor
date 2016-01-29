package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class TargetEndPointMenu extends BaseMenu {
	
	private static final long serialVersionUID = -4219134269612450867L;
	private TargetMultiplicityMenu multMenu;
	
	public TargetEndPointMenu(CommandListener listener, String text){
		super(listener, text);	
		build(listener);
	}
	
	public TargetEndPointMenu(CommandListener listener){
		super(listener, "Target End Point");		
	}
	
	@Override
	public void setContext(Object context){
		super.setContext(context);
		multMenu.setContext(context);
	}
	
	public void build(CommandListener listener){
		multMenu = MenuBuilder.buildTargetMultiplicity(listener,this,"Multiplicity");
		createMenuItem("End-Point Name",CommandType.SET_TARGET_END_POINT_NAME);	
		createMenuItem("Subsets",CommandType.SUBSETS_TARGET);
		createMenuItem("Redefines",CommandType.REDEFINES_TARGET);
	}
}
