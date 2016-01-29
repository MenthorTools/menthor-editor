package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class SourceEndPointMenu extends BaseMenu {
	
	private static final long serialVersionUID = -4219134269612450867L;
	private SourceMultiplicityMenu multMenu;
	
	public SourceEndPointMenu(CommandListener listener, String text){
		super(listener, text);	
		build(listener);
	}
	
	public SourceEndPointMenu(CommandListener listener){
		super(listener, "Source End Point");		
	}
	
	@Override
	public void setContext(Object context){
		super.setContext(context);
		multMenu.setContext(context);
	}
	
	public void build(CommandListener listener){
		multMenu = MenuBuilder.buildSourceMultiplicity(listener,this,"Multiplicity");
		createMenuItem("End-Point Name",CommandType.SET_SOURCE_END_POINT_NAME);	
		createMenuItem("Subsets",CommandType.SUBSETS_SOURCE);
		createMenuItem("Redefines",CommandType.REDEFINES_SOURCE);
	}
}
