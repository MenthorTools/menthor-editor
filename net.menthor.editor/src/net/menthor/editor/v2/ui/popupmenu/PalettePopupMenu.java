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
import java.util.List;

import javax.swing.JMenuItem;

import RefOntoUML.stereotypes.ClassStereotype;
import RefOntoUML.stereotypes.DataTypeStereotype;
import RefOntoUML.stereotypes.RelationshipStereotype;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.generic.GenericPopupMenu;
import net.menthor.editor.v2.ui.icon.IconType;

/**
 * Pop-up menu used as a shortcut for creating model elements on a diagram. 
 * It shows every available element in the language, i.e. all association and class stereotypes.
 * Currently accessible by pressing space.
 * Context: Currently visible diagram.
 * */
public class PalettePopupMenu extends GenericPopupMenu<Object> {

	private static final long serialVersionUID = -2133010759680525956L;

	List<JMenuItem> datatypes = new ArrayList<JMenuItem>();
	List<JMenuItem> classes = new ArrayList<JMenuItem>();
	List<JMenuItem> relationships = new ArrayList<JMenuItem>();
	
	public PalettePopupMenu(ICommandListener listener){
		super(listener,null);				
		classes.add(createMenuItem(ClassStereotype.KIND.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_KIND, false));
		classes.add(createMenuItem(ClassStereotype.SUBKIND.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_SUBKIND, false));
		classes.add(createMenuItem(ClassStereotype.COLLECTIVE.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_COLLECTIVE, false));
		classes.add(createMenuItem(ClassStereotype.QUANTITY.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_QUANTITY, false));
		classes.add(createMenuItem(ClassStereotype.PHASE.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_PHASE, false));
		classes.add(createMenuItem(ClassStereotype.ROLE.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_ROLE, false));
		classes.add(createMenuItem(ClassStereotype.CATEGORY.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_CATEGORY, false));
		classes.add(createMenuItem(ClassStereotype.ROLEMIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_ROLEMIXIN, false));
		classes.add(createMenuItem(ClassStereotype.MIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_MIXIN, false));
		classes.add(createMenuItem(ClassStereotype.RELATOR.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_RELATOR, false));
		classes.add(createMenuItem(ClassStereotype.MODE.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_MODE, false));
		classes.add(createMenuItem(ClassStereotype.PERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_PERCEIVABLE_QUALITY, false));
		classes.add(createMenuItem(ClassStereotype.NONPERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_NONPERCEIVABLE_QUALITY, false));
		classes.add(createMenuItem(ClassStereotype.NOMINAL_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_NOMINAL_QUALITY, false));		
		datatypes.add(createMenuItem(DataTypeStereotype.DATATYPE.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_DATATYPE, false));
		datatypes.add(createMenuItem(DataTypeStereotype.ENUMERATION.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_ENUMERATION, false));
		datatypes.add(createMenuItem(DataTypeStereotype.PRIMITIVETYPE.getName(), IconType.MENTHOR_CLASS, CommandType.PALLETE_PRIMITIVETYPE, false));		
		relationships.add(createMenuItem(RelationshipStereotype.GENERALIZATION.getName(), IconType.MENTHOR_GENERALIZATION, CommandType.PALLETE_GENERALIZATION, false));
		relationships.add(createMenuItem(RelationshipStereotype.CHARACTERIZATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.PALLETE_CHARACTERIZATION, false));
		relationships.add(createMenuItem(RelationshipStereotype.MEDIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.PALLETE_MEDIATION, false));
		relationships.add(createMenuItem(RelationshipStereotype.FORMAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.PALLETE_FORMAL, false));
		relationships.add(createMenuItem(RelationshipStereotype.MATERIAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.PALLETE_MATERIAL, false));
		relationships.add(createMenuItem(RelationshipStereotype.DERIVATION.getName(), IconType.MENTHOR_DERIVATION, CommandType.PALLETE_DERIVATION, false));
		relationships.add(createMenuItem(RelationshipStereotype.COMPONENTOF.getName(), IconType.MENTHOR_COMPONENTOF, CommandType.PALLETE_COMPONENTOF, false));
		relationships.add(createMenuItem(RelationshipStereotype.MEMBEROF.getName(), IconType.MENTHOR_MEMBEROF, CommandType.PALLETE_MEMBEROF, false));
		relationships.add(createMenuItem(RelationshipStereotype.SUBCOLLECTIONOF.getName(), IconType.MENTHOR_SUBCOLLECTIONOF, CommandType.PALLETE_SUBCOLLECTIONOF, false));
		relationships.add(createMenuItem(RelationshipStereotype.SUBQUANTITYOF.getName(), IconType.MENTHOR_SUBQUANTITYOF, CommandType.PALLETE_SUBQUANTITYOF, false));
		relationships.add(createMenuItem(RelationshipStereotype.STRUCTURATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.PALLETE_STRUCTURATION, false));
		relationships.add(createMenuItem(RelationshipStereotype.ASSOCIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.PALLETE_ASSOCIATION, false));		
		sort();
	}
	
	public void sort(){
		List<JMenuItem> cs = sort(classes);		
		List<JMenuItem> ds = sort(datatypes);
		List<JMenuItem> rs = sort(relationships);
		createMenuItem("Mouse Pointer", IconType.MENTHOR_MOUSE_POINTER, CommandType.PALLETE_POINTER_MODE);		
		addSeparator();
		for(JMenuItem pe: cs) add(pe);
		addSeparator();
		for(JMenuItem pe: ds) add(pe);
		addSeparator();
		for(JMenuItem pe: rs) add(pe);		
	}	
}

