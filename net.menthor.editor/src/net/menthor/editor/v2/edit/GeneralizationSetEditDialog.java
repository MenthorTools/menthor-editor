package net.menthor.editor.v2.edit;

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

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.dialog.properties.GeneralizationSetEditionPanel;
import net.menthor.editor.ui.MainFrame;

public class GeneralizationSetEditDialog extends BaseEditDialog {

	private static final long serialVersionUID = 1L;
		
	private GeneralizationSet genSet;
	private GeneralizationSetEditionPanel genSetEdition;
	
	public GeneralizationSetEditDialog(final MainFrame parent, final GeneralizationSet genSet, boolean modal){
		super(parent, modal);
		this.genSet=genSet;
		initUI();
	}
	
	@Override
	public void confirm(ActionEvent arg0){
		genSetEdition.transferGenSetData();				
		dispose();
	}
	
	public void  initUI(){				
		setTitle(""+""+OntoUMLParser.getStereotype(genSet)+" "+ ((GeneralizationSet)genSet).getName());
		genSetEdition = new GeneralizationSetEditionPanel(this.getParent(), diagramManager, genSet);
		tabbedPane.add("Generalization Set", genSetEdition);		
		setSize(new Dimension(470, 410));
	}	
}
