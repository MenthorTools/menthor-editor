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

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

import org.tinyuml.umldraw.AssociationElement;

import RefOntoUML.Association;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class MultiplicityMenu extends BaseMenu<AssociationElement> {
		
	private static final long serialVersionUID = -3936734322891978516L;
	protected ButtonGroup group;
	protected JRadioButtonMenuItem optional;
	protected JRadioButtonMenuItem singular;
	protected JRadioButtonMenuItem any;
	protected JRadioButtonMenuItem some;
	protected JRadioButtonMenuItem two;
	protected JRadioButtonMenuItem twoAtLeast;
	protected JRadioButtonMenuItem other;
	
	protected boolean isSourceEnd, isTargetEnd;
	
	public MultiplicityMenu(CommandListener listener, String text, AssociationElement associationElement, JMenu parent, boolean isSourceEnd){
		super(listener, text, associationElement);
		
		this.isSourceEnd = isSourceEnd;
		this.isTargetEnd = !isSourceEnd;
		
		optional = createRadioMenuItem("0..1", CommandType.OPTIONAL_ON_TARGET);
		singular = createRadioMenuItem("1", CommandType.SINGULAR_ON_TARGET);
		any = createRadioMenuItem("0..*", CommandType.ANY_ON_TARGET);
		some = createRadioMenuItem("1..*", CommandType.SOME_ON_TARGET);
		two = createRadioMenuItem("2", CommandType.TWO_ON_TARGET);
		twoAtLeast = createRadioMenuItem("2..*", CommandType.TWO_AT_LEAST_ON_TARGET);
		other = createRadioMenuItem("Other", CommandType.OTHER_ON_TARGET);
		
		group = new ButtonGroup();
		group.add(optional);
		group.add(singular);
		group.add(any);
		group.add(some);
		group.add(two);
		group.add(twoAtLeast);
		group.add(other);
		sort();
		
		Association association = associationElement.getAssociation();
		
		String mult = "";
		
		if(isSourceEnd)
			RefOntoUMLFactoryUtil.getMultiplicityAsString(association.getMemberEnd().get(0));
		else
			RefOntoUMLFactoryUtil.getMultiplicityAsString(association.getMemberEnd().get(1));
		
		if(mult.equals("0..1")) 
			optional.setSelected(true);
		else if(mult.equals("1")) 
			singular.setSelected(true);
		else if(mult.equals("1..*")) 
			some.setSelected(true);
		else if(mult.equals("0..*") || mult.equals("*")) 
			any.setSelected(true);
		else if(mult.equals("2")) 
			two.setSelected(true);
		else if(mult.equals("2..*")) 
			twoAtLeast.setSelected(true);
		else 
			other.setSelected(true);		
		
		parent.add(this);
	}
	
	public MultiplicityMenu(CommandListener listener, AssociationElement associationElement, JMenu parent, boolean isSourceEnd){
		this(listener, "Multiplicity",associationElement,parent, isSourceEnd);	
  	}		
}
