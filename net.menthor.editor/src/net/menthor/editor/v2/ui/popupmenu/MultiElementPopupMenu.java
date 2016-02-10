package net.menthor.editor.v2.ui.popupmenu;

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

import javax.swing.JCheckBoxMenuItem;

import org.tinyuml.umldraw.MultiElementHelper;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.generic.GenericPopupMenu;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.ui.menu.AlignMenu;
import net.menthor.editor.v2.ui.menu.ColorMenu;
import net.menthor.editor.v2.ui.menu.GenSetMenu;
import net.menthor.editor.v2.ui.menu.LineStyleMenu;
import net.menthor.editor.v2.ui.menu.VisibilityMenu;

public class MultiElementPopupMenu extends GenericPopupMenu<ArrayList<UmlDiagramElement>> {

	private static final long serialVersionUID = 1L;
	
	public MultiElementHelper helper;	
	protected LineStyleMenu styleMenu;
	protected VisibilityMenu visMenu;
	protected AlignMenu alignMenu;
	protected GenSetMenu genSetMenu;
	protected ColorMenu colorMenu;
	protected JCheckBoxMenuItem attrItem;
		
	public MultiElementPopupMenu(ICommandListener listener, ArrayList<UmlDiagramElement> elements) {
		super(listener,elements);				
		helper = new MultiElementHelper(elements);		
		boolean addSeparator = false;		
		createMenuItem("Duplicate", CommandType.DUPLICATE);
		createMenuItem("Copy", CommandType.COPY);		
		addSeparator();		
		createMenuItem("Delete from Diagram",IconType.MENTHOR_ERASE, CommandType.ERASE);
		createMenuItem("Delete from Model",IconType.MENTHOR_DELETE, CommandType.DELETE);		
		addSeparator();		
		visMenu = new VisibilityMenu(listener, elements, this);		
		addSeparator();		
		if(helper.hasConnection()){	
			addSeparator = true;			
			styleMenu = new LineStyleMenu(listener, elements, this);
			createMenuItem("Reset Points", CommandType.RESET_POINTS);
		}		
		if(helper.hasClass()){
			if(addSeparator) addSeparator();			
			colorMenu = new ColorMenu(listener, elements, this);
			alignMenu = new AlignMenu(listener, elements, this);
		}		
		if(helper.hasGeneralization()){
			addSeparator();
			genSetMenu = new GenSetMenu(listener, elements, this);
		}					
	}
}

