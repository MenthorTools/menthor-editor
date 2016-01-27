package net.menthor.editor.v2.menu.draw;

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

import javax.swing.JCheckBoxMenuItem;

import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.menu.BasePopupMenu;
import net.menthor.editor.v2.menu.ChangeClassMenu;
import net.menthor.editor.v2.menu.ColorMenu;
import net.menthor.editor.v2.menu.MenuBuilder;

public class NodePopupMenu extends BasePopupMenu {

	private static final long serialVersionUID = 6677159632748840951L;

	private ChangeClassMenu changeMenu;
	private ColorMenu color;	
	private JCheckBoxMenuItem attrItem;
	
	public NodePopupMenu(CommandListener listener) {
		super(listener);
		createMenuItem("Edit Properties", IconType.MENTHOR_EDIT, CommandType.EDIT);
		createMenuItem("Duplicate", CommandType.DUPLICATE);
		createMenuItem("Copy", CommandType.COPY);
		addSeparator();
		attrItem = createCheckBoxMenuItem("Show Attributes", CommandType.SHOW_ATTRIBUTES);
		addSeparator();
		createMenuItem("Find in Project Browser", IconType.MENTHOR_TREE, CommandType.FIND_IN_PROJECT_BROWSER);
		createMenuItem("Add All Related Elements", CommandType.ADD_ALL_RELATED_ELEMENTS);
		addSeparator();
		color = MenuBuilder.buildBackground(listener, this, "Background Color");
		addSeparator();
		changeMenu = new ChangeClassMenu(listener);
		add(changeMenu);
		addSeparator();
		createMenuItem("Erase",IconType.MENTHOR_ERASE, CommandType.ERASE);
		addSeparator();
		createMenuItem("Delete",IconType.MENTHOR_DELETE, CommandType.DELETE);
	}
	
	@Override
	public void setContext(Object object){
		if(object instanceof ClassElement){
			changeMenu.setContext(((ClassElement)object).getClassifier());
			attrItem.setSelected(((ClassElement)object).showAttributes());
		}
		color.setContext(object);
		super.setContext(object);
	}
}
