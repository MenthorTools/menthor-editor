package net.menthor.editor.v2.menu;

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

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;

public class PalettePopupMenu extends BasePopupMenu {

	private static final long serialVersionUID = -2133010759680525956L;

	List<JMenuItem> datatypes = new ArrayList<JMenuItem>();
	List<JMenuItem> classes = new ArrayList<JMenuItem>();
	List<JMenuItem> relationships = new ArrayList<JMenuItem>();
	
	public PalettePopupMenu(CommandListener listener){
		super(listener);
				
		classes.add(createMenuItem(ClassType.KIND.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_KIND, false));
		classes.add(createMenuItem(ClassType.SUBKIND.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_SUBKIND, false));
		classes.add(createMenuItem(ClassType.COLLECTIVE.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_COLLECTIVE, false));
		classes.add(createMenuItem(ClassType.QUANTITY.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_QUANTITY, false));
		classes.add(createMenuItem(ClassType.PHASE.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_PHASE, false));
		classes.add(createMenuItem(ClassType.ROLE.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_ROLE, false));
		classes.add(createMenuItem(ClassType.CATEGORY.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_CATEGORY, false));
		classes.add(createMenuItem(ClassType.ROLEMIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_ROLEMIXIN, false));
		classes.add(createMenuItem(ClassType.MIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_MIXIN, false));
		classes.add(createMenuItem(ClassType.RELATOR.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_RELATOR, false));
		classes.add(createMenuItem(ClassType.MODE.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_MODE, false));
		classes.add(createMenuItem(ClassType.PERCEIVABLEQUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_PERCEIVABLE_QUALITY, false));
		classes.add(createMenuItem(ClassType.NONPERCEIVABLEQUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_NONPERCEIVABLE_QUALITY, false));
		classes.add(createMenuItem(ClassType.NOMINALQUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_NOMINAL_QUALITY, false));
		
		datatypes.add(createMenuItem(DataType.DATATYPE.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_DATATYPE, false));
		datatypes.add(createMenuItem(DataType.ENUMERATION.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_ENUMERATION, false));
		datatypes.add(createMenuItem(DataType.PRIMITIVETYPE.getName(), IconType.MENTHOR_CLASS, CommandType.TB_DND_PRIMITIVETYPE, false));
		
		relationships.add(createMenuItem(RelationshipType.GENERALIZATION.getName(), IconType.MENTHOR_GENERALIZATION, CommandType.TB_DND_GENERALIZATION, false));
		relationships.add(createMenuItem(RelationshipType.CHARACTERIZATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.TB_DND_CHARACTERIZATION, false));
		relationships.add(createMenuItem(RelationshipType.MEDIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.TB_DND_MEDIATION, false));
		relationships.add(createMenuItem(RelationshipType.FORMAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.TB_DND_FORMAL, false));
		relationships.add(createMenuItem(RelationshipType.MATERIAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.TB_DND_MATERIAL, false));
		relationships.add(createMenuItem(RelationshipType.DERIVATION.getName(), IconType.MENTHOR_DERIVATION, CommandType.TB_DND_DERIVATION, false));
		relationships.add(createMenuItem(RelationshipType.COMPONENTOF.getName(), IconType.MENTHOR_COMPONENTOF, CommandType.TB_DND_COMPONENTOF, false));
		relationships.add(createMenuItem(RelationshipType.MEMBEROF.getName(), IconType.MENTHOR_MEMBEROF, CommandType.TB_DND_MEMBEROF, false));
		relationships.add(createMenuItem(RelationshipType.SUBCOLLECTIONOF.getName(), IconType.MENTHOR_SUBCOLLECTIONOF, CommandType.TB_DND_SUBCOLLECTIONOF, false));
		relationships.add(createMenuItem(RelationshipType.SUBQUANTITYOF.getName(), IconType.MENTHOR_SUBQUANTITYOF, CommandType.TB_DND_SUBQUANTITYOF, false));
		relationships.add(createMenuItem(RelationshipType.STRUCTURATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.TB_DND_STRUCTURATION, false));
		relationships.add(createMenuItem(RelationshipType.ASSOCIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.TB_DND_ASSOCIATION, false));
		
		sort();
	}
	
	public void sort()
	{
		List<JMenuItem> cs = sort(classes);		
		List<JMenuItem> ds = sort(datatypes);
		List<JMenuItem> rs = sort(relationships);
		addSeparator();
		createMenuItem("Mouse Pointer", IconType.MENTHOR_MOUSE_POINTER, CommandType.TB_DND_POINTER_MODE);		
		for(JMenuItem pe: cs) add(pe);		
		for(JMenuItem pe: ds) add(pe);
		addSeparator();
		for(JMenuItem pe: rs) add(pe);		
	}
	
}

