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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import net.menthor.common.transformation.MappingType;
import net.menthor.common.transformation.OWLTransformationOptions;
import net.menthor.editor.AppFrame;
import net.menthor.editor.DiagramManager;
import net.menthor.editor.dialog.MappingTypeComboItem;
import net.menthor.editor.model.UmlProject;
import net.menthor.editor.transformation.ElementFilterPane;
import net.menthor.editor.util.ApplicationResources;
import net.menthor.editor.util.ProjectSettings;
import RefOntoUML.parser.OntoUMLParser;

public class OWLSettingsDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = -4770351584655675698L;
	
	@SuppressWarnings("unused")
	private AppFrame frame;
	private DiagramManager manager;	
	private OntoUMLParser refparser;	
	private OWLTransformationOptions owlOptions;
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private ElementFilterPane filterPane = new ElementFilterPane();
	private OWLPrimitiveMappingPane primitivePane;
	private OWLQualityMappingPane qualityPane;
	private OWLAxiomFilterPane axiomsPane;
	private OWLConfigPane configPane;

	public OWLSettingsDialog(AppFrame frame, DiagramManager diagramManager, boolean modal) 
	{
		super(frame, modal);
		
		this.frame = frame;
		this.manager = diagramManager;		
		this.refparser = frame.getProjectBrowser().getParser();
		this.owlOptions = new OWLTransformationOptions();
		
		configPane = new OWLConfigPane(owlOptions, manager);		
		filterPane.fillContent(refparser);		
		primitivePane = new OWLPrimitiveMappingPane(refparser);
		qualityPane = new OWLQualityMappingPane(refparser);
		axiomsPane = new OWLAxiomFilterPane();
		
		addNonClosable(tabbedPane,"Config", configPane);
		addNonClosable(tabbedPane,"Filter", filterPane);
		addNonClosable(tabbedPane,"OWL Axioms", axiomsPane);
		addNonClosable(tabbedPane,"Primitive Types", primitivePane);
		addNonClosable(tabbedPane,"Qualities", qualityPane);
		
		tabbedPane.setSelectedComponent(configPane);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);		
		setTitle("OWL Settings");	
		setSize(new java.awt.Dimension(550, 420));
		
		configPane.getOkButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(validadeSettings())
				{
					saveSettings();
					manager.generateOwl(filterPane.getFilteredParser(),owlOptions);
		 			dispose();
				}
			}
		});
		getRootPane().setDefaultButton(configPane.getOkButton());
		
		configPane.getCancelButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
	}

	/** Add Non Closable Tab */
	public Component addNonClosable(JTabbedPane pane, String text, Component component)
	{
		if (component==null) component = new JPanel();
		pane.addTab(text, component);		
		pane.setSelectedComponent(component);
		return component;
	}
	
	protected boolean validadeSettings() 
	{		
		if(configPane.isNewTabSelected()) return true;			
		if(configPane.isFileSelected() && configPane.getPathText().length() > 0) return true;
		else JOptionPane.showMessageDialog(this, 
			ApplicationResources.getInstance().getString("dialog.owlsettings.error.informfilepath"), 
			ApplicationResources.getInstance().getString("dialog.owlsettings.title"),	
			JOptionPane.ERROR_MESSAGE);		
		return false;
	}
	
	private void saveSettings()
	{
		UmlProject project = manager.getCurrentProject();
		
		ProjectSettings.OWL_ONTOLOGY_IRI.setValue(project, configPane.getURIText());
		ProjectSettings.OWL_GENERATE_FILE.setValue(project, Boolean.toString(configPane.isFileSelected()));
		if(configPane.isFileSelected()) ProjectSettings.OWL_FILE_PATH.setValue(project, configPane.getPathText());		
		ProjectSettings.OWL_MAPPING_TYPE.setValue(project, ((MappingTypeComboItem) configPane.getMappingItem()).value);
		
		owlOptions.setOntologyIri(configPane.getURIText());
		owlOptions.setGenerateFile(configPane.isFileSelected());
		
		if(configPane.isFileSelected()) owlOptions.setFilePath(configPane.getPathText());
		owlOptions.setMappingType(MappingType.valueOf(((MappingTypeComboItem) configPane.getMappingItem()).value));
		
		//disjointness
		owlOptions.setDisjointClassAxioms(axiomsPane.isClassDisjointness());
		owlOptions.setDisjointAssociationAxioms(axiomsPane.isAssociatoinDisjointness());		
		
		//associations
		owlOptions.setDomainAxiom(axiomsPane.isDomain());
		owlOptions.setRangeAxiom(axiomsPane.isRange());
		owlOptions.setInverseAxiom(axiomsPane.isInverse());		
		
		//association binary association
		owlOptions.setReflexiveAxiom(axiomsPane.isReflexivity());
		owlOptions.setIrreflexiveAxiom(axiomsPane.isIrreflexive());
		owlOptions.setSymmetricAxiom(axiomsPane.isSymmetry());
		owlOptions.setAsymmetricreflexiveAxiom(axiomsPane.isAsymmetric());
		owlOptions.setTransitiveAxiom(axiomsPane.isTransitivity());
		owlOptions.setFunctionalAxiom(axiomsPane.isFunctional());
		owlOptions.setInverseFunctionalAxiom(axiomsPane.isInverseFunctional());		
		owlOptions.setCardinalityAxiom(axiomsPane.isCardinality());
		
		//swrl rules
		owlOptions.setSwrlRulesAxiom(axiomsPane.isRules());
		
		//cardinality
		owlOptions.setCardinalityAxiom(axiomsPane.isCardinality());
	}
}
