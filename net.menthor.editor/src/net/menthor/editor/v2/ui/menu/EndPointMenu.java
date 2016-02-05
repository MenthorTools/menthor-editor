package net.menthor.editor.v2.ui.menu;

import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.AssociationElement;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class EndPointMenu extends GenericMenu<AssociationElement> {
	
	private static final long serialVersionUID = -4219134269612450867L;
	protected MultiplicityMenu multMenu;
	protected boolean isSourceEnd, isTargetEnd;
	String endName;
	
	public EndPointMenu(CommandListener listener, AssociationElement associationElement, JPopupMenu parent, boolean isSourceEnd){
		super(listener, "End Point Name", associationElement);	
		
		this.isSourceEnd = isSourceEnd;
		this.isTargetEnd = !isSourceEnd;
		
		multMenu = new MultiplicityMenu(listener, associationElement, this, isSourceEnd);
		
		if(isSourceEnd){
			endName = associationElement.getAssociation().getMemberEnd().get(0).getName();
			createMenuItem("Name",CommandType.SET_SOURCE_END_POINT_NAME);
			createMenuItem("Subsets",CommandType.SUBSETS_SOURCE);
			createMenuItem("Redefines",CommandType.REDEFINES_SOURCE);
			//Sets the menu name as the end point name;
			this.setText("Source ("+endName+")");
		}
		else{
			endName = associationElement.getAssociation().getMemberEnd().get(1).getName();
			createMenuItem("Name",CommandType.SET_TARGET_END_POINT_NAME);
			createMenuItem("Subsets",CommandType.SUBSETS_TARGET);
			createMenuItem("Redefines",CommandType.REDEFINES_TARGET);
			//Sets the menu name as the end point name;
			this.setText("Target ("+endName+")");
		}

		parent.add(this);
	}
			
}
