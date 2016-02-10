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

import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.shared.BaseConnection;
import org.tinyuml.umldraw.shared.NoteElement;
import org.tinyuml.umldraw.shared.UmlDiagramElement;
import org.tinyuml.umldraw.shared.UmlNode;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.generic.GenericPopupMenu;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.ui.menu.ChangeStereotypeMenu;
import net.menthor.editor.v2.ui.menu.ColorMenu;
import net.menthor.editor.v2.ui.menu.EndPointMenu;
import net.menthor.editor.v2.ui.menu.GenSetMenu;
import net.menthor.editor.v2.ui.menu.InvertMenu;
import net.menthor.editor.v2.ui.menu.LineStyleMenu;
import net.menthor.editor.v2.ui.menu.MetaAttributeMenu;
import net.menthor.editor.v2.ui.menu.ReadingDirectionMenu;
import net.menthor.editor.v2.ui.menu.VisibilityMenu;

public class SingleElementPopupMenu extends GenericPopupMenu<UmlDiagramElement> {

	private static final long serialVersionUID = 6980238001925458188L;
	
	//General menus
	protected VisibilityMenu visibilityMenu;
	protected MetaAttributeMenu metaAttributeMenu;
	protected ChangeStereotypeMenu changeStereotypeMenu;
	
	//Class only menus
	protected ColorMenu colorMenu;
	
	//Connection only menus 
	protected LineStyleMenu lineStyleMenu;
	protected InvertMenu invertMenu;
	
	//Generalization only menus
	protected GenSetMenu genSetMenu;
	
	//Association only menus
	protected ReadingDirectionMenu readingDirectionMenu;
	protected EndPointMenu sourceEndMenu, targetEndMenu;
	
	//creates the menu according to the element being clicked.
	public SingleElementPopupMenu(ICommandListener listener, UmlDiagramElement diagramElement) {
		super(listener, diagramElement);		
		//add default items to all cases
		createMenuItem("Edit Properties", IconType.MENTHOR_EDIT, CommandType.EDIT);
		addSeparator();
		createMenuItem("Duplicate", CommandType.DUPLICATE);
		createMenuItem("Copy", CommandType.COPY);
		addSeparator();
		createMenuItem("Delete from Diagram",IconType.MENTHOR_ERASE, CommandType.ERASE);
		createMenuItem("Delete from Model",IconType.MENTHOR_DELETE, CommandType.DELETE);
		addSeparator();
		createMenuItem("Find in Project Browser", IconType.MENTHOR_TREE, CommandType.FIND_IN_PROJECT_BROWSER);
		createMenuItem("Find in Diagrams", IconType.MENTHOR_SEARCH, CommandType.FIND_IN_DIAGRAMS);
		addSeparator();		
		if(diagramElement instanceof UmlNode){
			UmlNode node = (UmlNode) diagramElement;			
			createMenuItem("Add All Related Elements", CommandType.ADD_ALL_RELATED_ELEMENTS);
			addSeparator();			
			visibilityMenu = new VisibilityMenu(listener, node, this);
			colorMenu = new ColorMenu(listener,node,this);					
			if(diagramElement instanceof ClassElement){
				ClassElement classElement = (ClassElement) diagramElement;				
				addSeparator();				
				changeStereotypeMenu = new ChangeStereotypeMenu(listener, classElement.getClassifier(), this);
				metaAttributeMenu = new MetaAttributeMenu(listener,classElement,this);
				
			}
			if(diagramElement instanceof NoteElement){}
		}		
		else if(diagramElement instanceof BaseConnection){
			BaseConnection connection = (BaseConnection) diagramElement;			
			visibilityMenu = new VisibilityMenu(listener, connection, this);
			lineStyleMenu = new LineStyleMenu(listener, connection, this);
			createMenuItem("Reset Points", CommandType.RESET_POINTS);
			if(diagramElement instanceof AssociationElement){
				AssociationElement association = (AssociationElement) diagramElement;				
				readingDirectionMenu = new ReadingDirectionMenu(listener, association, this);				
				addSeparator();
				invertMenu = new InvertMenu(listener, connection, this);	
				changeStereotypeMenu = new ChangeStereotypeMenu(listener, association.getAssociation(), this);
				metaAttributeMenu = new MetaAttributeMenu(listener,association,this);
				sourceEndMenu = new EndPointMenu(listener, association, this, true);
				targetEndMenu = new EndPointMenu(listener, association, this, false);				
			}
			else if(diagramElement instanceof GeneralizationElement){
				GeneralizationElement generalization = (GeneralizationElement) diagramElement;				
				addSeparator();
				invertMenu = new InvertMenu(listener, connection, this);	
				changeStereotypeMenu = new ChangeStereotypeMenu(listener, generalization.getGeneralization(), this);				
				addSeparator();
				genSetMenu = new GenSetMenu(listener, generalization, this);
			}
		}
	}
}
