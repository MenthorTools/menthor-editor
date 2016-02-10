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

import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class VisibilityMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	private JCheckBoxMenuItem showNamespace;
	private JCheckBoxMenuItem showStereotypeItem;
	private JCheckBoxMenuItem showEndPointItem;
	private JCheckBoxMenuItem showSubsettingItem;
	private JCheckBoxMenuItem showRedefiningItem;
	private JCheckBoxMenuItem showMultiplicitiesItem;
	private JCheckBoxMenuItem showNameItem;
	private JCheckBoxMenuItem showAttributes;
	private JCheckBoxMenuItem showGeneralizationSets;
	private JCheckBoxMenuItem showParents;
	private JCheckBoxMenuItem showAll;
		
	public VisibilityMenu(ICommandListener listener, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Visibility",elements,parent);		
  	}
	
	public VisibilityMenu(ICommandListener listener, UmlDiagramElement element, JPopupMenu parent){
		this(listener, "Visibility",setUpList(element),parent);		
  	}
		
	public VisibilityMenu(ICommandListener listener, String text, UmlDiagramElement element, JPopupMenu parent){
		this(listener, text, setUpList(element), parent);		
  	}
	
	public VisibilityMenu(ICommandListener listener, String text, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text, elements);	
		build();
		updateSelectedState();
		parent.add(this);
	}
	
	private void build(){
		boolean needSeparator = false;		
		if(helper.hasAssociation() || helper.hasClass()){
			showAll = createCheckBoxMenuItem("All", CommandType.SHOW_ALL);
			addSeparator();
		}		
		if(helper.hasAssociation()){
			showStereotypeItem = createCheckBoxMenuItem("Association Stereotype", CommandType.SHOW_STEREOTYPE);
			showNameItem = createCheckBoxMenuItem("Association Name", CommandType.SHOW_NAME);
			showEndPointItem = createCheckBoxMenuItem("Show EndPoint Name", CommandType.SHOW_END_POINT_NAMES);
			showMultiplicitiesItem = createCheckBoxMenuItem("Multiplicities", CommandType.SHOW_MULTIPLICITIES);
			showSubsettingItem = createCheckBoxMenuItem("Subsetting", CommandType.SHOW_SUBSETTING); 
			showRedefiningItem = createCheckBoxMenuItem("Redefining", CommandType.SHOW_REDEFINITIONS);
			needSeparator = true;
		}		
		if (helper.hasClass()){
			if(needSeparator) addSeparator();			
			showAttributes = createCheckBoxMenuItem("Attributes", CommandType.SHOW_ATTRIBUTES);
			showStereotypeItem = createCheckBoxMenuItem("Class Stereotype", CommandType.SHOW_CLASS_STEREOTYPE); //TODO: Check action	
			showNamespace = createCheckBoxMenuItem("Namespace", CommandType.SHOW_NAMESPACE); //TODO: Check action			
			showParents = createCheckBoxMenuItem("Parents", CommandType.SHOW_PARENTS); //TODO: Check action
			needSeparator = true;
		}		
		if (helper.hasGeneralization()){
			if(needSeparator) addSeparator();			
			showGeneralizationSets = createCheckBoxMenuItem("Generalization Sets", CommandType.SHOW_GENERALIZATION_SETS); //TODO: Check action
			needSeparator = true;
		}
	}
	
	private void updateSelectedState(){
		//only updates if a single element was selected
		if(!helper.isSingleContext()) return;		
		UmlDiagramElement element = context.get(0);		
		if(element instanceof AssociationElement){
			AssociationElement associationElement = (AssociationElement) element;			
			showStereotypeItem.setSelected(associationElement.showOntoUmlStereotype());
			showEndPointItem.setSelected(associationElement.showRoles());
			showSubsettingItem.setSelected(associationElement.showSubsetting());
			showRedefiningItem.setSelected(associationElement.showRedefining());
			showMultiplicitiesItem.setSelected(associationElement.showMultiplicities());
			showNameItem.setSelected(associationElement.showName());			
			showAll.setSelected(associationElement.showOntoUmlStereotype() && associationElement.showRoles() && associationElement.showSubsetting() && 
			associationElement.showRedefining() && associationElement.showName() && associationElement.showMultiplicities());
		}
		else if(element instanceof ClassElement){
			ClassElement classElement = (ClassElement)element;
			showStereotypeItem.setSelected(classElement.showStereotypes());
			showAttributes.setSelected(classElement.showAttributes());
			showNamespace.setSelected(classElement.showNamespace());
			showParents.setSelected(classElement.showParents());			
			showAll.setSelected(classElement.showStereotypes() && classElement.showAttributes() && classElement.showNamespace() && classElement.showParents());
		}
		else if(element instanceof GeneralizationElement){
			GeneralizationElement generalizationElement = (GeneralizationElement)element;
			showGeneralizationSets.setSelected(generalizationElement.showName());
		}
	}
	
}
