package net.menthor.editor.transformation.owl;

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
import java.awt.event.ActionListener;
import java.util.List;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.common.transformation.OwlAxiomsEnforcement;
import net.menthor.common.transformation.OwlMappingsEnforcement;
import net.menthor.common.transformation.TransformationOption;
import net.menthor.editor.MainFrame;
import net.menthor.editor.DiagramManager;
import net.menthor.editor.transformation.TransformationDialog;
import net.menthor.editor.ui.Models;
import net.menthor.editor.v2.OntoumlDiagram;

public class OwlSettingsDialog extends TransformationDialog {
	
	private static final long serialVersionUID = -6094162448551064500L;
	
	private OwlApproachPane approachPane;
	private OwlAxiomPane axiomsPane;
	private OwlPrimitiveMappingPane primitivePane;
	private OwlQualityMappingPane qualityPane;
	private OwlGenSetMappingPane gsPane;
	
	public OwlSettingsDialog(final MainFrame owner, OntoUMLParser refparser, List<OntoumlDiagram> diagrams, boolean modal) 
	{
		super(owner, refparser, diagrams, modal);
		
		approachPane = new OwlApproachPane(owner.getDiagramManager().getCurrentProject().getName());
		primitivePane = new OwlPrimitiveMappingPane(Models.getRefparser());
		qualityPane = new OwlQualityMappingPane(Models.getRefparser());
		gsPane = new OwlGenSetMappingPane(Models.getRefparser());
		axiomsPane = new OwlAxiomPane();
		
		addNonClosable("Approach", approachPane);
		addNonClosable("Filter", getFilter());
		addNonClosable("Axioms", axiomsPane);
		addNonClosable("Primitive Types", primitivePane);
//		addNonClosable("Qualities", qualityPane);
		addNonClosable("Generalization Sets", gsPane);
		
		tabbedPane.setSelectedComponent(approachPane);
				
		setTitle("OWL Settings");	
				
		getOkButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {				
									
				/**base options*/
				TransformationOption transOpt = new TransformationOption(
					approachPane.getSelectedMapping(), 
					approachPane.getDestination(),
					approachPane.getPathText()
				);
				
				/**owl axioms*/
				OwlAxiomsEnforcement axioms = axiomsPane.getOwlAxiomsEnforcement();
				axioms.setOntologyIri(approachPane.getURIText());
				transOpt.setAxiomsEnforcement(axioms);
				
				/**owl mappings customizations*/
				OwlMappingsEnforcement mappings = new OwlMappingsEnforcement();
				mappings.setAttributeMappings(primitivePane.getAttributeMap());
				mappings.setGenSetMappings(gsPane.getGenSetEnumMappingMap());										
				mappings.setPrimitiveMappings(primitivePane.getPrimitiveMap());										
				mappings.setQualityMappings(qualityPane.getQualityMap());
				transOpt.setMappingsEnforcement(mappings);
				
				if(owner instanceof MainFrame){
					DiagramManager manager = ((MainFrame)owner).getDiagramManager();
					
					/**generate*/
					manager.generateOwl(
						filterPane.getFilteredParser(),							 
						transOpt
					);
				}				
				
	 			//dispose();
			}
		});
	}	
}
