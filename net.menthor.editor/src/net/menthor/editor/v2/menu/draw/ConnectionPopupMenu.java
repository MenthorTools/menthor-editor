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

import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.GeneralizationElement;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.menu.BasePopupMenu;
import net.menthor.editor.v2.menu.ChangeRelationshipMenu;
import net.menthor.editor.v2.menu.InvertMenu;
import net.menthor.editor.v2.menu.LineStyleMenu;
import net.menthor.editor.v2.menu.MenuBuilder;
import net.menthor.editor.v2.menu.MetaAttributeMenu;
import net.menthor.editor.v2.menu.ReadingDirectionMenu;
import net.menthor.editor.v2.menu.SourceEndPointMenu;
import net.menthor.editor.v2.menu.TargetEndPointMenu;
import net.menthor.editor.v2.menu.VisibilityMenu;

public class ConnectionPopupMenu extends BasePopupMenu {

	private static final long serialVersionUID = 1L;
	
	private VisibilityMenu visibilityMenu;
	private LineStyleMenu styleMenu;
	private ChangeRelationshipMenu changeMenu;
	private InvertMenu invertMenu;
	private ReadingDirectionMenu directionMenu;
	private MetaAttributeMenu attrMenu;
	private SourceEndPointMenu srcEndMenu;
	private TargetEndPointMenu tgtEndMenu;
			
	public ConnectionPopupMenu(CommandListener listener){   
		super(listener);
		createMenuItem("Edit Properties", IconType.MENTHOR_EDIT, CommandType.EDIT);
		createMenuItem("Find in Project Browser", IconType.MENTHOR_TREE, CommandType.FIND_IN_PROJECT_BROWSER);		
		addSeparator();
		srcEndMenu = MenuBuilder.buildSourceEndPoint(listener, this, "Source End Point");
		tgtEndMenu = MenuBuilder.buildTargetEndPoint(listener, this, "Target End Point");
		addSeparator();
		createMenuItem("Reset Points", CommandType.RESET_POINTS);
		styleMenu = MenuBuilder.buildLineStyle(listener, this, "Line Style");
		visibilityMenu = MenuBuilder.buildVisibility(listener, this, "Visibility");
		directionMenu = MenuBuilder.buildReadingDirection(listener, this, "Reading Direction");		
		addSeparator();
		attrMenu = MenuBuilder.buildMetaAttribute(listener,this,"Meta Attribute");
		changeMenu = MenuBuilder.buildChangeRelationshipTo(listener, this, "Change To");
		invertMenu = MenuBuilder.buildInvert(listener, this, "Invert");		
		addSeparator();				
		createMenuItem("Erase",IconType.MENTHOR_ERASE, CommandType.ERASE);
		addSeparator();
		createMenuItem("Delete",IconType.MENTHOR_DELETE, CommandType.DELETE);
	}
		
	public void setContext(Object context){
		visibilityMenu.setContext(context);
		styleMenu.setContext(context);
		invertMenu.setContext(context);
		directionMenu.setContext(context);
		attrMenu.setContext(context);
		srcEndMenu.setContext(context);
		tgtEndMenu.setContext(context);
		if(context instanceof AssociationElement){
			visibilityMenu.getMenuItem(CommandType.SHOW_END_POINT_NAMES).setSelected(((AssociationElement)context).showRoles());
			visibilityMenu.getMenuItem(CommandType.SHOW_MULTIPLICITIES).setSelected(((AssociationElement)context).showMultiplicities());
			visibilityMenu.getMenuItem(CommandType.SHOW_NAME).setSelected(((AssociationElement)context).showName());
			visibilityMenu.getMenuItem(CommandType.SHOW_REDEFINITIONS).setSelected(((AssociationElement)context).showRedefining());
			visibilityMenu.getMenuItem(CommandType.SHOW_SUBSETTING).setSelected(((AssociationElement)context).showSubsetting());
			visibilityMenu.getMenuItem(CommandType.SHOW_STEREOTYPE).setSelected(((AssociationElement)context).showOntoUmlStereotype());
			RefOntoUML.Relationship rel = ((AssociationElement)context).getRelationship();
			changeMenu.setContext(rel);
			if(rel instanceof RefOntoUML.Meronymic) attrMenu.setVisible(true);
			else attrMenu.setVisible(false);
			RefOntoUML.Property srcEnd = ((RefOntoUML.Association)rel).getMemberEnd().get(0);
			RefOntoUML.Property tgtEnd = ((RefOntoUML.Association)rel).getMemberEnd().get(1);
			srcEndMenu.setText(srcEnd.getType().getName());
			tgtEndMenu.setText(tgtEnd.getType().getName());
		}
		else if(context instanceof GeneralizationElement){
			changeMenu.setContext(((GeneralizationElement)context).getGeneralization());
		}
		super.setContext(context);
	}
}
