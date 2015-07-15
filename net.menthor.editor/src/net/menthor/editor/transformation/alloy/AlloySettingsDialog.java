package net.menthor.editor.transformation.alloy;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;

import net.menthor.editor.AppFrame;
import net.menthor.editor.dialog.properties.ConstraintSimulationPanel;
import net.menthor.editor.transformation.DestinationPane;
import net.menthor.editor.transformation.TransformationDialog;
import net.menthor.ontouml2alloy.OntoUML2AlloyOptions;
import net.menthor.tocl.parser.TOCLParser;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;

import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.parser.OntoUMLParser;

/**
 * @author John Guerson
 */

public class AlloySettingsDialog extends TransformationDialog {
	
	private static final long serialVersionUID = 7877781445149017806L;
	
	private ConstraintSimulationPanel constraintSimulationPanel;
	private AlloyModelSimulationPanel modelSimulationPanel;	
	private TOCLParser toclparser;
	private AlloyMappingTypePane mapPane;
	private DestinationPane destPane;
	
	private JPanel axiomPane;
	private JPanel principalPane;
	/**
	 * @wbp.parser.constructor
	 */
	public AlloySettingsDialog(AppFrame owner, OntoUMLParser refparser, List<StructureDiagram> diagrams, boolean modal) 
	{
		super(owner, refparser, diagrams, modal);
				
		principalPane = new JPanel();
		principalPane.setLayout(new BorderLayout(5,5));
		
		destPane = new DestinationPane("Alloy (*.als)","als");
		destPane.renameAppButton("Alloy Analyzer");
		principalPane.add(destPane, BorderLayout.NORTH);
		
		mapPane = new AlloyMappingTypePane();
		principalPane.add(mapPane,BorderLayout.CENTER);
		
		modelSimulationPanel = new AlloyModelSimulationPanel();		
		constraintSimulationPanel = new ConstraintSimulationPanel();
		
		axiomPane = new JPanel();
		axiomPane.setLayout(new BorderLayout(5, 5));		
		axiomPane.add(modelSimulationPanel, BorderLayout.NORTH);	
		
		addNonClosable("Principal", principalPane);
		addNonClosable("Filter", getFilter());
		addNonClosable("Axioms", axiomPane);
		
		tabbedPane.setSelectedComponent(principalPane);
		
		setTitle("Alloy Settings");		
		getOkButton().addActionListener(new ActionListener() 
		{
       		public void actionPerformed(ActionEvent event) 
       		{
       			OkActionPerformed(event);
       		}
       	});
	}
	
	/** Launch the Dialog. */
	public static void open(AppFrame owner, OntoUMLParser refparser, List<StructureDiagram> diagrams, OntoUML2AlloyOptions refOptions, TOCL2AlloyOption oclOptions)
	{
		try {			
			AlloySettingsDialog dialog = new AlloySettingsDialog(owner, refparser, diagrams, refOptions, oclOptions);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(owner);			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public AlloySettingsDialog(AppFrame owner, OntoUMLParser refparser, List<StructureDiagram> diagrams, OntoUML2AlloyOptions refOptions, TOCL2AlloyOption oclOptions)
	{
		this(owner,refparser,diagrams, false);	
		
		this.toclparser = oclOptions.getParser();
		
		modelSimulationPanel.setOntoUMLOptionsPane(refOptions,owner);
		
		constraintSimulationPanel.setOCLOptionPane(oclOptions,owner);		
		if (oclOptions.getConstraintList().size()>0) {
			axiomPane.add(constraintSimulationPanel, BorderLayout.CENTER);
		}				
		invalidate();
	}
		
	public void OkActionPerformed(ActionEvent event)
	{
		OntoUML2AlloyOptions ontoumlOptions = new OntoUML2AlloyOptions();
		ontoumlOptions.antiRigidity = modelSimulationPanel.isSelectedAntirigidity(); 
		ontoumlOptions.identityPrinciple = modelSimulationPanel.isSelectedIdentityPrinciple();
		ontoumlOptions.weakSupplementation = modelSimulationPanel.isSelectedWeakSupplementation();
		ontoumlOptions.relatorConstraint = modelSimulationPanel.isSelectedRelatorConstraint();			    	
		
		if(getOwner() instanceof AppFrame){
			((AppFrame)getOwner()).getProjectBrowser().setOntoUMLOption(ontoumlOptions);
		}
				
		TOCL2AlloyOption oclOptions = new TOCL2AlloyOption(toclparser);		
		oclOptions.setTransformationType(constraintSimulationPanel.getTransformationsTypesListSelected());
    	oclOptions.setCommandScope(constraintSimulationPanel.getScopesListSelected());    			
    	oclOptions.setBiwidth(constraintSimulationPanel.getBitWidthListSelected());
    	oclOptions.setWorldScope(constraintSimulationPanel.getWorldScopeListSelected());
		oclOptions.setConstraintList(constraintSimulationPanel.getConstraintListSelected());
    	
		if(getOwner() instanceof AppFrame){
			((AppFrame)getOwner()).getProjectBrowser().setOCLOption(oclOptions);
		}		  
		
		//dispose();
		if(getOwner() instanceof AppFrame){			
			((AppFrame)getOwner()).getDiagramManager().transformToAlloy(filterPane.getFilteredParser());
		}
	}
}
