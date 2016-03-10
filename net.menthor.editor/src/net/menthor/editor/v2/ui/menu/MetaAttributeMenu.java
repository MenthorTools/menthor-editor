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

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.shared.UmlDiagramElement;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Element;
import RefOntoUML.Meronymic;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.generic.GenericMenu;

public class MetaAttributeMenu extends GenericMenu<UmlDiagramElement> {

	private static final long serialVersionUID = 3797953970276009760L;
	protected JCheckBoxMenuItem isAbstractMenu, isExtensionalMenu, isDerivedMenu;
	protected JCheckBoxMenuItem isEssentialMenu, isInseparableMenu, isImmutablePartMenu, isImmutableWholeMenu, isShareableMenu;
	
	public MetaAttributeMenu(ICommandListener listener, String text, UmlDiagramElement element, JPopupMenu parent){
		super(listener, text, element);		
		Element modelElement = (Element)element.getModelObject();		
		if(modelElement instanceof Classifier){
			isAbstractMenu = createCheckBoxMenuItem("Abstract", CommandType.SET_ABSTRACT); //TODO: Check command
			isAbstractMenu.setSelected(((Classifier) modelElement).isIsAbstract());
		}		
		if(modelElement instanceof Collective){
			isExtensionalMenu = createCheckBoxMenuItem("Extensional", CommandType.SET_EXTENSIONAL); //TODO: Check command
			isExtensionalMenu.setSelected(((Collective) modelElement).isIsExtensional());
		}		
		if(modelElement instanceof Association){
			isDerivedMenu = createCheckBoxMenuItem("Derived", CommandType.SET_DERIVED);//TODO: Check command
			isDerivedMenu.setSelected(((Association) modelElement).isIsDerived());
		}		
		if(modelElement instanceof Meronymic){			
			Meronymic meronymic = (Meronymic)modelElement;			
			addSeparator();			
			isEssentialMenu = createCheckBoxMenuItem("Essential", CommandType.SET_ESSENTIAL);
			isEssentialMenu.setSelected(meronymic.isIsEssential());			
			isInseparableMenu = createCheckBoxMenuItem("Inseparable", CommandType.SET_INSEPARABLE);		
			isInseparableMenu.setSelected(meronymic.isIsInseparable());			
			isImmutablePartMenu = createCheckBoxMenuItem("Immutable Part", CommandType.SET_IMMUTABLEPART);
			isImmutablePartMenu.setSelected(meronymic.isIsImmutablePart());			
			isImmutableWholeMenu = createCheckBoxMenuItem("Immutable Whole", CommandType.SET_IMMUTABLEWHOLE);
			isImmutableWholeMenu.setSelected(meronymic.isIsImmutableWhole());			
			isShareableMenu = createCheckBoxMenuItem("Shareable", CommandType.SET_SHAREABLE);
			isShareableMenu.setSelected(meronymic.isIsShareable());
		}		
		parent.add(this);
	}
	
	public MetaAttributeMenu(ICommandListener listener, UmlDiagramElement element, JPopupMenu parent){
		this(listener, "Meta Attributes", element, parent);		
  	}

}
