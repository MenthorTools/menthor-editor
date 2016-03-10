package net.menthor.editor.v2.ui.menu;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.AssociationElement;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.generic.GenericMenu;
import net.menthor.editor.v2.commands.CommandType;

public class EndPointMenu extends GenericMenu<AssociationElement> {
	
	private static final long serialVersionUID = -4219134269612450867L;
	protected MultiplicityMenu multMenu;
	protected boolean isSourceEnd, isTargetEnd;
	protected String endName;
	
	public EndPointMenu(ICommandListener listener, AssociationElement associationElement, JPopupMenu parent, boolean isSourceEnd){
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
