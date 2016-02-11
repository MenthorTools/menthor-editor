package net.menthor.editor.v2.commanders;

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

import java.awt.Component;

import javax.swing.tree.DefaultMutableTreeNode;

import org.tinyuml.ui.diagram.commands.Command;
import org.tinyuml.ui.diagram.commands.RenameCommand;

import RefOntoUML.NamedElement;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.app.manager.AppMessageManager;

//Class to deal with renaning elements on the project browser.
public class RenameCommander extends GenericCommander {

	// -------- Lazy Initialization

	private static class RenameLoader {
        private static final RenameCommander INSTANCE = new RenameCommander();
    }	
	public static RenameCommander get() { 
		return RenameLoader.INSTANCE; 
	}	
    private RenameCommander() {
        if (RenameLoader.INSTANCE != null) throw new IllegalStateException("RenameManager already instantiated");
    }		
    
    // ----------------------------
	
	public String askForElementName(Component parentWindow, String oldName){
		return (String)AppMessageManager.get().input(parentWindow,
			"Please, enter a new name for the this element:",
			"Rename Manager",			
			null,
			oldName
		);
	}
	
	public void rename(Object obj){
		Object element = obj;
		NamedElement namedElement;
		
		//Added this verification to allow the method to be called from different sources. Currently, it is only called from the tree.
		if(obj instanceof DefaultMutableTreeNode){
			element = ((DefaultMutableTreeNode)obj).getUserObject();
		}
		
		if (element instanceof NamedElement){
			namedElement = (NamedElement) element;
			String newName = askForElementName(AppFrame.get(), namedElement.getName());
			Command command = new RenameCommand(namedElement, newName);
			command.run();
		}
					
		
	}
	
	
}
