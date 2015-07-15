package net.menthor.editor.transformation.owl;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import net.menthor.common.transformation.owl.OWLTransformationOptions;
import net.menthor.editor.model.UmlProject;
import net.menthor.editor.transformation.DestinationPane;
import net.menthor.editor.transformation.MappingType;
import net.menthor.editor.util.ApplicationResources;
import net.menthor.editor.util.ProjectSettings;

public class OWLConfigPane extends JPanel {

	private static final long serialVersionUID = -5681113361932739723L;
	
	private JButton cancelButton;
	private JButton okButton;
	private JLabel typeLabel;
	private OWLMappingTypePane typePanel;
	private JLabel filePathLabel;
	private DestinationPane destinationPanel;
	private UmlProject project;
	private JTextField iriText;
	private JLabel iriLabel;
		
	public String getURIText() { return iriText.getText(); }
	public boolean isFileSelected() { return destinationPanel.isFileSelected(); }
	public String getPathText() { return destinationPanel.getPathText(); }
	public MappingType getSelectedMapping() { return typePanel.getSelectedEntry(); }
	public boolean isNewTabSelected() { return destinationPanel.isNewTabSelected(); }	
	public JButton getOkButton() { return okButton; }
	public JButton getCancelButton() { return cancelButton; }
	
	public OWLConfigPane(final OWLTransformationOptions owlOptions, UmlProject project)
	{
		this.project = project;
		GroupLayout GenerateOWLPanelLayout = new GroupLayout((JComponent)this);				
		setLayout(GenerateOWLPanelLayout);				
		iriLabel = new JLabel();
		iriLabel.setText(ApplicationResources.getInstance().getString("dialog.owlsettings.ontologyiri"));
		iriText = new JTextField();

		filePathLabel = new JLabel();
		filePathLabel.setText(ApplicationResources.getInstance().getString("dialog.owlsettings.filepath"));
		filePathLabel.setEnabled(false);
		
		typeLabel = new JLabel();
		typeLabel.setText(ApplicationResources.getInstance().getString("dialog.owlsettings.type"));
		
		okButton = new JButton();
		okButton.setVisible(false);
		okButton.setText(ApplicationResources.getInstance().getString("stdcaption.ok"));
		cancelButton = new JButton();
		cancelButton.setVisible(false);
		cancelButton.setText(ApplicationResources.getInstance().getString("stdcaption.cancel"));
		typePanel = new OWLMappingTypePane();
		
		destinationPanel = new DestinationPane("OWL File (*.owl)","owl");
		
		GenerateOWLPanelLayout.setHorizontalGroup(GenerateOWLPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(GenerateOWLPanelLayout.createParallelGroup()
			    .addComponent(destinationPanel, GroupLayout.Alignment.LEADING, 0, 500, Short.MAX_VALUE)
			    .addComponent(typePanel, GroupLayout.Alignment.LEADING, 0, 500, Short.MAX_VALUE)
			    .addGroup(GroupLayout.Alignment.LEADING, GenerateOWLPanelLayout.createSequentialGroup()
			        .addComponent(iriLabel, 0, 90, Short.MAX_VALUE)
			        .addGroup(GenerateOWLPanelLayout.createParallelGroup()
			            .addComponent(iriText, GroupLayout.Alignment.LEADING, 0, 417, Short.MAX_VALUE)
			            .addGroup(GroupLayout.Alignment.LEADING, GenerateOWLPanelLayout.createSequentialGroup()
			                .addGap(0, 239, Short.MAX_VALUE)
			                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
			                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			                .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))))
			.addContainerGap());
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
			.addGroup(GenerateOWLPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addComponent(cancelButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(okButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
			.addContainerGap());
	
		this.setSize(543, 365);	
		myPostInit();
	}

	private void  myPostInit()
	{
		if(ProjectSettings.OWL_ONTOLOGY_IRI.getValue(project) != null && ProjectSettings.OWL_ONTOLOGY_IRI.getValue(project).length() > 0)
			iriText.setText(ProjectSettings.OWL_ONTOLOGY_IRI.getValue(project));
		else
			iriText.setText(getDefaultIRI());
		
		//fileButton.setSelected(ProjectSettings.OWL_GENERATE_FILE.getBoolValue(project));
		//enableOrDisableFileChooser(ProjectSettings.OWL_GENERATE_FILE.getBoolValue(project));
		//filePathText.setText(ProjectSettings.OWL_FILE_PATH.getValue(project));			
	}

	private String getDefaultIRI()
	{		
		String projectName = project.getName().replace(" ","");
//		return "http://nemo.inf.ufes.br/" + projectName + ".owl";
		return "http://www.menthor.net/" + projectName;
	}
}
