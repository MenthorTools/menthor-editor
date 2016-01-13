package net.menthor.editor.v2.menu;

import javax.swing.JMenuItem;

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

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;

public class TreePopupMenu extends BasePopupMenu {
 
	private static final long serialVersionUID = 1L;
	
	private BaseMenu addclass;
	private BaseMenu addrel;
	private BaseMenu adddata;
	private BaseMenu changeclass;
	private BaseMenu changerel;
	private BaseMenu invert;
	private JMenuItem addgen;
	private JMenuItem addgenset;
	private JMenuItem addcomm;
	private JMenuItem addconst;
	private JMenuItem addpack;
	private JMenuItem adddiag;
	private JMenuItem adddoc;
	@SuppressWarnings("unused")
	private JMenuItem movetodiag;
	@SuppressWarnings("unused")
	private JMenuItem findindiag;
	
    public TreePopupMenu(final CommandListener listener)
    {
    	super(listener);
    	movetodiag = createMenuItem("Move To Diagram", IconType.MENTHOR_HAND_CURSOR, CommandType.MOVE_TO_DIAGRAM);    	
    	findindiag = createMenuItem("Find In Diagrams", IconType.MENTHOR_SEARCH, CommandType.FIND_IN_DIAGRAMS);
    	adddiag = createMenuItem("Add Diagram", CommandType.ADD_DIAGRAM);
    	adddoc = createMenuItem("Add Rules Document", CommandType.ADD_RULES_DOCUMENT);    	
    	addpack = createMenuItem("Add Package", CommandType.ADD_PACKAGE);    	
    	addclass = MenuBuilder.buildAddClass(listener, this, "Add Class");				
		addrel = MenuBuilder.buildAddRelationship(listener, this, "Add Relationship");    	
    	adddata = MenuBuilder.buildAddDataType(listener, this, "Add DataType"); 
    	addgenset = createMenuItem("Add Generalization Set", CommandType.ADD_GENERALIZATIONSET);    	
    	addconst = createMenuItem("Add Constraint", CommandType.ADD_CONSTRAINT);
    	addgen = createMenuItem("Add Generalization", CommandType.ADD_GENERALIZATION);    	
    	addcomm = createMenuItem("Add Comment", CommandType.ADD_COMMENT);
    	addSeparator();    	
    	createMenuItem("Rename", CommandType.RENAME);
    	changeclass = MenuBuilder.buildChangeClassTo(listener, this, "Change Class to");
    	changerel = MenuBuilder.buildChangeRelationshipTo(listener, this, "Change Relationship to");
    	invert = MenuBuilder.buildInvert(listener,this, "Invert");
    	addSeparator();
    	createMenuItem("Delete", IconType.MENTHOR_DELETE, CommandType.DELETE);
    }
    
	@Override
	public void setContext(Object context){
		addclass.setContext(context);
		addrel.setContext(context);
		adddata.setContext(context);
		changeclass.setContext(context);
		changerel.setContext(context);
		invert.setContext(context);		
		
		if(!(context instanceof RefOntoUML.Package)) {
			adddiag.setVisible(false);
			adddoc.setVisible(false);
			addpack.setVisible(false);
			addclass.setVisible(false);
			addrel.setVisible(false);
			adddata.setVisible(false);
			addgenset.setVisible(false);
			addconst.setVisible(false);
		}else{
			adddiag.setVisible(true);
			adddoc.setVisible(true);
			addpack.setVisible(true);
			addclass.setVisible(true);
			addrel.setVisible(true);
			adddata.setVisible(true);
			addgenset.setVisible(true);
			addconst.setVisible(true);
		}
		
		if(context instanceof RefOntoUML.Classifier) {
			addgen.setVisible(true);
			addcomm.setVisible(true);
		}else{
			addgen.setVisible(false);
			addcomm.setVisible(false);
		}
		
		if(context instanceof RefOntoUML.Class) changeclass.setVisible(true);
		else changeclass.setVisible(false);
		if(context instanceof RefOntoUML.Association) changerel.setVisible(true);
		else changerel.setVisible(false);
		if(context instanceof RefOntoUML.Property) invert.setVisible(true);
		else invert.setVisible(false);
		
		super.setContext(context);
	}
}
