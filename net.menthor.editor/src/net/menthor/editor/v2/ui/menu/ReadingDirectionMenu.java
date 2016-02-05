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

import javax.swing.ButtonGroup;
import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.AssociationElement;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class ReadingDirectionMenu extends GenericMenu<AssociationElement> {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public ReadingDirectionMenu(CommandListener listener, String text, AssociationElement associationElement, JPopupMenu parent){
		super(listener, text, associationElement);	
		build();
		parent.add(this);
	}
	
	public ReadingDirectionMenu(CommandListener listener, AssociationElement associationElement, JPopupMenu parent){
		this(listener, "Reading Direction", associationElement, parent);		
  	}
	
	public void build(){
		ButtonGroup group = new ButtonGroup();
		group.add(createRadioMenuItem("To Source", CommandType.READING_DIRECTION_SOURCE));
		group.add(createRadioMenuItem("To Target", CommandType.READING_DIRECTION_TARGET));
		group.add(createRadioMenuItem("Unspecified", CommandType.READING_DIRECTION_UNSPECIFIED));
		sort();
	}
}