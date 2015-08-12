package net.menthor.editor.v2.menus.draw;

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

import java.util.List;

import javax.swing.JCheckBoxMenuItem;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.menus.AlignMenu;
import net.menthor.editor.v2.menus.BasePopupMenu;
import net.menthor.editor.v2.menus.ColorMenu;
import net.menthor.editor.v2.menus.GenSetMenu;
import net.menthor.editor.v2.menus.LineStyleMenu;
import net.menthor.editor.v2.menus.MenuBuilder;
import net.menthor.editor.v2.menus.VisibilityMenu;

import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;

public class MultiElementPopupMenu extends BasePopupMenu {

	private static final long serialVersionUID = 1L;
	
	private LineStyleMenu styleMenu;
	private VisibilityMenu visMenu;
	@SuppressWarnings("unused")
	private AlignMenu alignMenu;
	private GenSetMenu genSetMenu;
	private ColorMenu colorMenu;
	private JCheckBoxMenuItem attrItem;
	
	@SuppressWarnings("unchecked")
	@Override
	public void setContext(Object object){
		styleMenu.setContext(object);
		visMenu.setContext(object);
		genSetMenu.setContext(object);
		colorMenu.setContext(object);
		
		//we do not set the context for this menu
		//the context is the set of selected elements of the diagram
		//alignMenu.setContext(object);
		
		if(object instanceof List<?>){		
			List<Object> list = (List<Object>)object;
			if(containsClass(list)) {
				attrItem.setSelected(someShowAttributes(list));
				attrItem.setVisible(true);
			} else attrItem.setVisible(false);
			visMenu.getMenuItem(CommandType.SHOW_END_POINT_NAMES).setSelected(someShowEndNames(list));
			visMenu.getMenuItem(CommandType.SHOW_MULTIPLICITIES).setSelected(someShowMultiplicities(list));
			visMenu.getMenuItem(CommandType.SHOW_NAME).setSelected(someShowName(list));
			visMenu.getMenuItem(CommandType.SHOW_REDEFINITIONS).setSelected(someShowRedefining(list));
			visMenu.getMenuItem(CommandType.SHOW_SUBSETTING).setSelected(someShowSubsetting(list));
			visMenu.getMenuItem(CommandType.SHOW_STEREOTYPE).setSelected(someShowStereotype(list));			
		}
		super.setContext(object);
	}
	
	public MultiElementPopupMenu(CommandListener listener) {
		super(listener);				
		genSetMenu = MenuBuilder.buildGenSet(listener, this, "Generalization Set");
		addSeparator();
		createMenuItem("Reset Points", CommandType.RESET_POINTS);
		styleMenu = MenuBuilder.buildLineStyle(listener, this, "Line Style");
		visMenu = MenuBuilder.buildVisibility(listener, this, "Visibility");
		alignMenu = MenuBuilder.buildAlign(listener, this, "Align");	
		colorMenu = MenuBuilder.buildBackground(listener, this, "Background Color");
		attrItem = createCheckBoxMenuItem("Show Class Attributes", CommandType.SHOW_ATTRIBUTES);
		addSeparator();
		createMenuItem("Erase",IconType.MENTHOR_ERASE, CommandType.ERASE);
		addSeparator();
		createMenuItem("Delete",IconType.MENTHOR_DELETE, CommandType.DELETE);
	}
	
	//=============================================
	//helpers
	//=============================================
	
	private boolean someShowAttributes(List<Object> objs){
		for(Object o: objs){
			if(o instanceof ClassElement)
				if(((ClassElement)o).showAttributes()) return true;
		}
		return false;
	}
	
	private boolean containsClass(List<Object> objs){
		for(Object o: objs){
			if(o instanceof ClassElement)
				return true;
		}
		return false;
	}
	
	private boolean someShowEndNames(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showRoles()) return true;
		}
		return false;
	}
	
	private boolean someShowMultiplicities(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showMultiplicities()) return true;
		}
		return false;
	}
	
	private boolean someShowName(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showName()) return true;
		}
		return false;
	}
	
	private boolean someShowRedefining(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showRedefining()) return true;
		}
		return false;
	}
	
	private boolean someShowSubsetting(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showSubsetting()) return true;
		}
		return false;
	}
	
	private boolean someShowStereotype(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showOntoUmlStereotype()) return true;
		}
		return false;
	}
}

