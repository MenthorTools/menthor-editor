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
import org.tinyuml.umldraw.shared.BaseConnection;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.generic.GenericMenu;
import net.menthor.editor.v2.commands.CommandType;

public class InvertMenu extends GenericMenu<BaseConnection> {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public InvertMenu(ICommandListener listener, String text, BaseConnection connection, JPopupMenu parent){
		super(listener, text, connection);		
		createMenuItem("End-Points", CommandType.INVERT_END_POINTS);		
		if(connection instanceof AssociationElement) {
			createMenuItem("End-Points Names", CommandType.INVERT_END_NAMES);
			createMenuItem("End-Points Multiplicities", CommandType.INVERT_END_MULTIPLICITIES);
			createMenuItem("End-Points Types", CommandType.INVERT_END_TYPES);
		}		
		parent.add(this);
	}
	
	public InvertMenu(ICommandListener listener, BaseConnection connection, JPopupMenu parent){
		this(listener, "Invert Ends", connection, parent);		
  	}
}
