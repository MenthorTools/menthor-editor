package net.menthor.editor.v2.edit;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

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

import org.tinyuml.umldraw.GeneralizationElement;

import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.Relationship;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.MainFrame;

public class GeneralizationEditDialog extends BaseEditDialog {

	private static final long serialVersionUID = 1L;
	
	private Relationship relationship;
			
	private GeneralizationEditPane genEdition;
	
	public GeneralizationEditDialog(final MainFrame parent, final GeneralizationElement genElement, RefOntoUML.Relationship relationship, boolean modal){
		super(parent, modal);		
		this.relationship = relationship;
		initUI();
	}
	
	@Override
	public void confirm(ActionEvent arg0){
		genEdition.transferData();				
		dispose();
	}
	
	public void  initUI(){		
		String stereo = OntoUMLParser.getStereotype(relationship);
		Classifier specific = ((Generalization)relationship).getSpecific();
		Classifier general = ((Generalization)relationship).getGeneral();
		if (general!=null) setTitle(""+""+stereo+" "+ specific.getName()+" -> "+general.getName());
		else setTitle(""+""+stereo+" "+ specific.getName()+" -> null");
		setSize(new Dimension(470, 370));		
		genEdition = new GeneralizationEditPane(this.getParent(), diagramManager, (Generalization)relationship);
		tabbedPane.add("Generalization", genEdition);
	}
}
