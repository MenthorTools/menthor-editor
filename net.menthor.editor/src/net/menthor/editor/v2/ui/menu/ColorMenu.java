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

import java.util.ArrayList;

import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.shared.UmlDiagramElement;
import org.tinyuml.umldraw.shared.UmlNode;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.icon.IconType;

public class ColorMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public ColorMenu(ICommandListener listener, String text, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text, elements);		
		createMenuItem("Set", IconType.MENTHOR_COLOR_CHOOSER, CommandType.SET_BACKGROUND_COLOR);
		
		//Can only copy the style if only one element is selected. 
		if(helper.isSingleContext())
			createMenuItem("Copy", CommandType.COPY_BACKGROUND_COLOR);
		
		createMenuItem("Paste", CommandType.PASTE_BACKGROUND_COLOR);		
		parent.add(this);
	}
	
	public ColorMenu(ICommandListener listener, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Background Color", elements, parent);		
  	}
	
	public ColorMenu(ICommandListener listener, String text, UmlNode node, JPopupMenu parent){
		this(listener, text, setUpList(node), parent);	
	}
	
	public ColorMenu(ICommandListener listener, UmlNode node, JPopupMenu parent){
		this(listener, setUpList(node), parent);		
  	}
	

}
