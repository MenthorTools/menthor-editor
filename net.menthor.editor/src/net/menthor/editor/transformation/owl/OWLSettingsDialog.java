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

import net.menthor.common.transformation.OwlAxiomsEnforcement;
import net.menthor.common.transformation.TransformationOption;
import net.menthor.editor.AppFrame;
import net.menthor.editor.DiagramManager;
import net.menthor.editor.model.UmlProject;
import net.menthor.editor.transformation.TransformationDialog;
import net.menthor.editor.util.ProjectSettings;

import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.parser.OntoUMLParser;

public class OWLSettingsDialog extends TransformationDialog {
	
	private static final long serialVersionUID = -6094162448551064500L;
	
	private OwlAxiomsEnforcement owlOptions;
	
	private OWLPrimitiveMappingPane primitivePane;
	private OWLQualityMappingPane qualityPane;
	private OWLAxiomFilterPane axiomsPane;
	private OWLConfigPane configPane;
	private OWLGeneralizationSetPane gsPane;

	public OWLSettingsDialog(final AppFrame owner, OntoUMLParser refparser, List<StructureDiagram> diagrams, boolean modal) 
	{
		super(owner, refparser, diagrams, modal);
		
		this.owlOptions = new OwlAxiomsEnforcement();
		
		if(owner instanceof AppFrame){
			UmlProject project = ((AppFrame)owner).getDiagramManager().getCurrentProject();
			configPane = new OWLConfigPane(owlOptions, project);
		}
		
		primitivePane = new OWLPrimitiveMappingPane(owner.getProjectBrowser().getParser());
		qualityPane = new OWLQualityMappingPane(owner.getProjectBrowser().getParser());
		gsPane = new OWLGeneralizationSetPane(owner.getProjectBrowser().getParser());
		axiomsPane = new OWLAxiomFilterPane();
		
		addNonClosable("Approach", configPane);
		addNonClosable("Filter", getFilter());
		addNonClosable("Axioms", axiomsPane);
		addNonClosable("Primitive Types", primitivePane);
		addNonClosable("Qualities", qualityPane);
		addNonClosable("Generalization Sets", gsPane);
		
		tabbedPane.setSelectedComponent(configPane);
				
		setTitle("OWL Settings");	
				
		getOkButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(validadeSettings())
				{
					//saveSettings();
					TransformationOption transOpt = new TransformationOption(
						configPane.getSelectedMapping(), 
						configPane.getDestination(),
						configPane.getPathText()
					);
					
//					System.out.println(filterPane.getFilteredParser());
					if(owner instanceof AppFrame){
						DiagramManager manager = ((AppFrame)owner).getDiagramManager();
						manager.generateOwl(
							filterPane.getFilteredParser(), 
							owlOptions, 
							transOpt
						);
					}					
		 			dispose();
				}
			}
		});
	}
	
	public boolean validadeSettings() 
	{		
//		if(configPane.isNewTabSelected()) return true;			
//		if(configPane.isFileSelected() && configPane.getPathText().length() > 0) return true;
//		else JOptionPane.showMessageDialog(this, 
//			ApplicationResources.getInstance().getString("dialog.owlsettings.error.informfilepath"), 
//			ApplicationResources.getInstance().getString("dialog.owlsettings.title"),	
//			JOptionPane.ERROR_MESSAGE);		
		return true;
	}
	
	public void saveSettings()
	{
		if(getParent() instanceof AppFrame){
			DiagramManager manager = ((AppFrame)getParent()).getDiagramManager();
			UmlProject project = manager.getCurrentProject();
		
			ProjectSettings.OWL_ONTOLOGY_IRI.setValue(project, configPane.getURIText());
			//ProjectSettings.OWL_GENERATE_FILE.setValue(project, Boolean.toString(configPane.isFileSelected()));
			//if(configPane.isFileSelected()) ProjectSettings.OWL_FILE_PATH.setValue(project, configPane.getPathText());		
			//ProjectSettings.OWL_MAPPING_TYPE.setValue(project, ((MappingTypeComboItem) configPane.getSelectedMapping()).value);
		}
		
		owlOptions.setOntologyIri(configPane.getURIText());
//		owlOptions.setGenerateFile(configPane.isFileSelected());
		
//		if(configPane.isFileSelected()) owlOptions.setFilePath(configPane.getPathText());
		//owlOptions.setMappingType(configPane.getSelectedMapping());
		
		//disjointness
		owlOptions.setEnforcingDisjointOfClass(axiomsPane.isClassDisjointness());
		owlOptions.setEnforcingDisjointOfAssociation(axiomsPane.isAssociatoinDisjointness());		
		
		//associations
		owlOptions.setEnforcingDomain(axiomsPane.isDomain());
		owlOptions.setEnforcingRange(axiomsPane.isRange());
		owlOptions.setEnforcingInverse(axiomsPane.isInverse());		
		
		//association binary association
		owlOptions.setEnforcingReflexive(axiomsPane.isReflexivity());
		owlOptions.setEnforcingIrreflexive(axiomsPane.isIrreflexive());
		owlOptions.setEnforcingSymmetric(axiomsPane.isSymmetry());
		owlOptions.setEnforcingAsymmetric(axiomsPane.isAsymmetric());
		owlOptions.setEnforcingTransitive(axiomsPane.isTransitivity());
		owlOptions.setEnforcingFunctional(axiomsPane.isFunctional());
		owlOptions.setEnforcingInverseFunctional(axiomsPane.isInverseFunctional());		
		owlOptions.setEnforcingCardinality(axiomsPane.isCardinality());
		
		//swrl rules
		owlOptions.setEnforcingSwrlRules(axiomsPane.isRules());
		
		//cardinality
		owlOptions.setEnforcingCardinality(axiomsPane.isCardinality());
		
		owlOptions.setEnforcingUfoStructure(axiomsPane.isUfoStructure());
		
		owlOptions.setGenSetEnumMappings(gsPane.getGenSetEnumMappingMap());
		
		owlOptions.setEnforcingCompleteOfClass(axiomsPane.isComplete());
		
		owlOptions.setPrimitiveTypeMappingsOntoUMLElement(primitivePane.getPrimitiveMap());
		owlOptions.setAttributeMappingsOntoUMLElement(primitivePane.getAttributeMap());
		
		owlOptions.setQualityTypeMappingsOntoUMLElement(qualityPane.getQualityMap());
	}
}
