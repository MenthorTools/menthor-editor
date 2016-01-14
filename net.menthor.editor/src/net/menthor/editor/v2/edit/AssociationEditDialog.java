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

import java.awt.event.ActionEvent;

import org.tinyuml.umldraw.AssociationElement;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Relationship;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.dialog.properties.AssociationEditionPanel;
import net.menthor.editor.dialog.properties.CommentsEditionPanel;
import net.menthor.editor.dialog.properties.PropertyEditionPanel;
import net.menthor.editor.ui.MainFrame;

public class AssociationEditDialog extends BaseEditDialog {
	
	private static final long serialVersionUID = -8725806095573893977L;

	private AssociationElement assocElement;
	private Relationship relationship;	
	private AssociationEditionPanel assocEdition;
	private PropertyEditionPanel end1Edition;
	private PropertyEditionPanel end2Edition;
	private CommentsEditionPanel commentsEdition;
	
	@Override
	public void confirm(ActionEvent arg0){		
		end1Edition.transferPropertyData();
		end2Edition.transferPropertyData();
		commentsEdition.transferCommentsData();
		//constraintsEdition.transferConstraintsData();
		assocEdition.transferAssocData();
	}	
	
	public AssociationEditDialog(final MainFrame parent, final AssociationElement assocElement, RefOntoUML.Relationship relationship, boolean modal){
		super(parent, modal);
		this.assocElement = assocElement;
		this.relationship = relationship;		
		setTitle(""+""+OntoUMLParser.getStereotype(this.relationship)+" "+ ((Classifier)relationship).getName());		
		
		assocEdition = new AssociationEditionPanel (diagramManager,this.assocElement,(Classifier)relationship,modal);
		tabbedPane.addTab("Association", assocEdition);				
		
		end1Edition = new PropertyEditionPanel(this,diagramManager,this.assocElement,(Classifier)relationship,((Association)relationship).getMemberEnd().get(0));
		tabbedPane.addTab("Source End",end1Edition);		
		
		end2Edition = new PropertyEditionPanel(this,diagramManager,this.assocElement,(Classifier)relationship,((Association)relationship).getMemberEnd().get(1));
		tabbedPane.addTab("Target End", end2Edition);		
		
		commentsEdition = new CommentsEditionPanel (diagramManager,this.assocElement,(Classifier)relationship);
		tabbedPane.addTab("Comments", commentsEdition);
	}
}

