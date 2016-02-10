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

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;

import org.tinyuml.draw.Connection;
import org.tinyuml.draw.RectilinearConnection;
import org.tinyuml.draw.SimpleConnection;
import org.tinyuml.draw.TreeConnection;
import org.tinyuml.umldraw.shared.BaseConnection;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class LineStyleMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	protected JCheckBoxMenuItem directMenuItem;
	protected JCheckBoxMenuItem rectilinearMenuItem;
	protected JCheckBoxMenuItem treeHorizontalMenuItem;
	protected JCheckBoxMenuItem treeVerticalMenuItem;
	
	public LineStyleMenu(ICommandListener listener, String text, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text, elements);		
		directMenuItem = createCheckBoxMenuItem("Direct", CommandType.APPLY_DIRECT_STYLE);
		rectilinearMenuItem = createCheckBoxMenuItem("Rectilinear", CommandType.APPLY_RECTILINEAR_STYLE);
		treeHorizontalMenuItem = createCheckBoxMenuItem("Tree Style Horizontal", CommandType.APPLY_HORIZONTAL_STYLE);
		treeVerticalMenuItem = createCheckBoxMenuItem("Tree Style Vertical", CommandType.APPLY_VERTICAL_STYLE);
		updateCheckboxState();
		parent.add(this);
	}
	
	private void updateCheckboxState() {		
		if(helper.isSingleContext() && context.get(0) instanceof BaseConnection){
			Connection connection = ((BaseConnection) context.get(0)).getConnection();			
			if(connection instanceof SimpleConnection)
				directMenuItem.setSelected(true);
			else if(connection instanceof TreeConnection){
				treeVerticalMenuItem.setSelected(((TreeConnection)connection).isVertical());
				treeHorizontalMenuItem.setSelected(((TreeConnection)connection).isHorizontal());
			}
			else if (connection instanceof RectilinearConnection){
				rectilinearMenuItem.setSelected(true);
			}
		}		
	}

	public LineStyleMenu(ICommandListener listener, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Line Style", elements, parent);		
  	}
	
	public LineStyleMenu(ICommandListener listener, String text, BaseConnection connection, JPopupMenu parent){
		this(listener, text, setUpList(connection), parent);	
	}
	
	public LineStyleMenu(ICommandListener listener, BaseConnection connection, JPopupMenu parent){
		this(listener, setUpList(connection), parent);		
  	}
	
}
