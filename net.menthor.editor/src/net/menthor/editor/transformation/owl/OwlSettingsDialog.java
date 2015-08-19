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

import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.MainFrame;

import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.settings.BaseSettingsDialog;
import net.menthor.editor.v2.settings.owl.OwlAxiomsPane;
import net.menthor.editor.v2.settings.owl.OwlGenSetPane;
import net.menthor.editor.v2.settings.owl.OwlMainPane;
import net.menthor.editor.v2.settings.owl.OwlPrimitivePane;
import net.menthor.editor.v2.settings.owl.OwlQualityPane;
import net.menthor.editor.v2.settings.owl.OwlSettingsMap;

public class OwlSettingsDialog extends BaseSettingsDialog {
	
	private static final long serialVersionUID = -6094162448551064500L;
	
	private OwlMainPane mainPane;
	private OwlAxiomsPane axiomsPane;
	private OwlPrimitivePane primitivePane;
	private OwlQualityPane qualityPane;
	private OwlGenSetPane gsPane;
	
	public OwlSettingsDialog(final MainFrame owner, OntoUMLParser refparser, List<OntoumlDiagram> diagrams, boolean modal){
		super(owner, refparser, diagrams, modal);		
		buildUI(refparser);
	}
	
	private void buildUI(OntoUMLParser refparser){
		mainPane = new OwlMainPane();
		primitivePane = new OwlPrimitivePane(refparser);
		qualityPane = new OwlQualityPane(refparser);
		gsPane = new OwlGenSetPane(refparser);
		axiomsPane = new OwlAxiomsPane();		
		addNonClosable("Main", mainPane);
		addNonClosable("Filter", getFilter());
		addNonClosable("Axioms", axiomsPane);
		addNonClosable("Primitive Types", primitivePane);
		addNonClosable("Qualities", qualityPane);
		addNonClosable("Generalization Sets", gsPane);		
		tabbedPane.setSelectedComponent(mainPane);				
		setTitle("OWL Settings");
		getOkButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				okActionPerformed(evt);
			}
		});
	}
		
	private void okActionPerformed(ActionEvent evt){				
		try {
			axiomsPane.storeToXML();
			primitivePane.storeToXML();
			qualityPane.storeToXML();
			gsPane.storeToXML();
			mainPane.storeToXML();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		/**base options*/
		TransformationOption transOpt = new TransformationOption(
			mainPane.getSelectedMapping(), 
			mainPane.getOWL2Destination(),
			mainPane.getPathText()
		);
		
		/**owl axioms*/
		OwlAxiomsEnforcement axioms = OwlSettingsMap.getInstance().getOwlAxiomsEnforcement();				
		transOpt.setAxiomsEnforcement(axioms);
		
		/**owl mappings customizations*/
		OwlMappingsEnforcement mappings = new OwlMappingsEnforcement();
		try {
			mappings.setAttributeMappings(primitivePane.getAttributeMap());
			mappings.setGenSetMappings(gsPane.getGeneralizationSetMap());										
			mappings.setPrimitiveMappings(primitivePane.getPrimitiveMap());										
			mappings.setQualityMappings(qualityPane.getQualityMap());					
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		transOpt.setMappingsEnforcement(mappings);
		
		if(frame instanceof MainFrame){
			DiagramManager manager = ((MainFrame)frame).getDiagramManager();
			
			/**generate*/
			manager.generateOwl(
				filterPane.getFilteredParser(),							 
				transOpt
			);
		}				
		
		dispose();
	}	
}
