package net.menthor.editor.transformation.owl;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import net.menthor.common.transformation.DestinationEnum;
import net.menthor.common.transformation.MappingType;
import net.menthor.editor.model.UmlProject;
import net.menthor.editor.transformation.DestinationPane;
import net.menthor.editor.util.ApplicationResources;

public class OwlApproachPane extends JPanel {

	private static final long serialVersionUID = -5681113361932739723L;
	
	private JButton cancelButton;
	private JButton okButton;
	private OwlMappingTypePane typePanel;
	private DestinationPane destinationPanel;
	private UmlProject project;
	private JTextField iriText;
	private JLabel iriLabel;
		
	public String getURIText() { return iriText.getText(); }	
	public String getPathText() { return destinationPanel.getPath(); }
	public MappingType getSelectedMapping() { return typePanel.getMappingType(); }
	public DestinationEnum getDestination() { return destinationPanel.getDestination(); }
	
	private String getDefaultIRI()
	{		
		String projectName = project.getName().replace(" ","");
		return "http://www.menthor.net/" + projectName;
	}	
	
	public JButton getOkButton() { return okButton; }
	public JButton getCancelButton() { return cancelButton; }
	
	public OwlApproachPane(UmlProject project)
	{
		this.project = project;
		GroupLayout GenerateOWLPanelLayout = new GroupLayout((JComponent)this);				
		setLayout(GenerateOWLPanelLayout);				
		iriLabel = new JLabel();
		iriLabel.setText(ApplicationResources.getInstance().getString("dialog.owlsettings.ontologyiri"));
		iriText = new JTextField();
		iriText.setFont(new Font(iriText.getFont().getName(),Font.ITALIC,iriText.getFont().getSize()));
		
		okButton = new JButton();
		okButton.setVisible(false);
		okButton.setText(ApplicationResources.getInstance().getString("stdcaption.ok"));
		
		cancelButton = new JButton();
		cancelButton.setVisible(false);
		cancelButton.setText(ApplicationResources.getInstance().getString("stdcaption.cancel"));
		
		typePanel = new OwlMappingTypePane();
		
		destinationPanel = new DestinationPane("OWL (*.owl)","owl");
		destinationPanel.renameAppButton("Protégé");
		destinationPanel.selectTab();
		destinationPanel.enableFileChooser(false);
		
		GenerateOWLPanelLayout.setHorizontalGroup(GenerateOWLPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(GenerateOWLPanelLayout.createParallelGroup()
			    .addComponent(destinationPanel, GroupLayout.Alignment.LEADING, 0, 500, Short.MAX_VALUE)
			    .addComponent(typePanel, GroupLayout.Alignment.LEADING, 0, 500, Short.MAX_VALUE)
			    .addGroup(GroupLayout.Alignment.LEADING, GenerateOWLPanelLayout.createSequentialGroup()
			        .addComponent(iriLabel, 0, 90, Short.MAX_VALUE)
			        .addGroup(GenerateOWLPanelLayout.createParallelGroup()
			            .addComponent(iriText, GroupLayout.Alignment.LEADING, 0, 417, Short.MAX_VALUE)
			        )))			            
		);
		GenerateOWLPanelLayout.setVerticalGroup(GenerateOWLPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(GenerateOWLPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addComponent(iriText, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
			    .addComponent(iriLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(destinationPanel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(typePanel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)				 
		);
	
		this.setSize(543, 365);	
		
//		if(ProjectSettings.OWL_ONTOLOGY_IRI.getValue(project) != null && ProjectSettings.OWL_ONTOLOGY_IRI.getValue(project).length() > 0)
//			iriText.setText(ProjectSettings.OWL_ONTOLOGY_IRI.getValue(project));
//		else
			iriText.setText(getDefaultIRI());
	}
}
