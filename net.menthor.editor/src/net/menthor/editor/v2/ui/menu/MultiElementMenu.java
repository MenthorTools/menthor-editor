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
import java.util.List;

import org.tinyuml.umldraw.MultiElementHelper;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.generic.GenericMenu;

public class MultiElementMenu extends GenericMenu<List<UmlDiagramElement>> {

	private static final long serialVersionUID = -1814132796163307505L;
	
	public MultiElementHelper helper;
	
	public MultiElementMenu(ICommandListener listener, String text, List<UmlDiagramElement> elements) {
		super(listener, text, elements);
		helper = new MultiElementHelper(elements);
	}
	
	static List<UmlDiagramElement> setUpList(UmlDiagramElement element){
		List<UmlDiagramElement> elements = new ArrayList<UmlDiagramElement>();
		elements.add(element);
		return elements;
	}
	
}
