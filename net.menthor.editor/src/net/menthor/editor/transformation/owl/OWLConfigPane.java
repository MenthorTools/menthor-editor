package net.menthor.editor.transformation.owl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.menthor.common.transformation.owl.OWLTransformationOptions;
import net.menthor.editor.model.UmlProject;
import net.menthor.editor.transformation.MappingType;
import net.menthor.editor.util.ApplicationResources;
import net.menthor.editor.util.ConfigurationHelper;
import net.menthor.editor.util.ProjectSettings;

public class OWLConfigPane extends JPanel {

	private static final long serialVersionUID = -5681113361932739723L;

	private ButtonGroup destinationGroup;
	private JRadioButton fileButton;
	private JTextField filePathText;
	private JButton cancelButton;
	private JButton okButton;
	private JLabel typeLabel;
	private OWLMappingTypePane typePanel;
	private JButton browseButton;
	private JLabel filePathLabel;
	private JPanel destinationPanel;
	private JRadioButton newTabButton;	
	private UmlProject project;
	private JTextField iriText;
	private JLabel iriLabel;
		
	public String getURIText() { return iriText.getText(); }
	public boolean isFileSelected() { return fileButton.isSelected(); }
	public String getPathText() { return filePathText.getText(); }
	public MappingType getSelectedMapping() { return typePanel.getSelectedEntry(); }
	public boolean isNewTabSelected() { return newTabButton.isSelected(); }	
	public JButton getOkButton() { return okButton; }
	public JButton getCancelButton() { return cancelButton; }
	
	public OWLConfigPane(final OWLTransformationOptions owlOptions, UmlProject project)
	{
		this.project = project;
		GroupLayout GenerateOWLPanelLayout = new GroupLayout((JComponent)this);				
		setLayout(GenerateOWLPanelLayout);				
		destinationPanel = new JPanel();
		destinationGroup = new ButtonGroup();
		GroupLayout destinationPanelLayout = new GroupLayout((JComponent)destinationPanel);
		destinationPanel.setLayout(destinationPanelLayout);
		destinationPanel.setBorder(BorderFactory.createTitledBorder(ApplicationResources.getInstance().getString("dialog.owlsettings.destination")));
		iriLabel = new JLabel();
		iriLabel.setText(ApplicationResources.getInstance().getString("dialog.owlsettings.ontologyiri"));
		iriText = new JTextField();
		newTabButton = new JRadioButton();
		newTabButton.setText(ApplicationResources.getInstance().getString("dialog.owlsettings.newtab"));
		newTabButton.setSelected(true);
		destinationGroup.add(newTabButton);
		newTabButton.addActionListener(new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {					        
		        enableOrDisableFileChooser(false);
		    }
		});
		fileButton = new JRadioButton();
		fileButton.setText(ApplicationResources.getInstance().getString("dialog.owlsettings.file"));
		destinationGroup.add(fileButton);
		fileButton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {					        
		        enableOrDisableFileChooser(true);
		    }
		});
		filePathLabel = new JLabel();
		filePathLabel.setText(ApplicationResources.getInstance().getString("dialog.owlsettings.filepath"));
		filePathLabel.setEnabled(false);
		filePathText = new JTextField();
		filePathText.setEnabled(false);
		filePathText.setEditable(false);
		typeLabel = new JLabel();
		typeLabel.setText(ApplicationResources.getInstance().getString("dialog.owlsettings.type"));
		browseButton = new JButton();
		browseButton.setText("...");
		browseButton.setEnabled(false);
		browseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getFilePath();
			}
		});
		okButton = new JButton();
		okButton.setVisible(false);
		okButton.setText(ApplicationResources.getInstance().getString("stdcaption.ok"));
		cancelButton = new JButton();
		cancelButton.setVisible(false);
		cancelButton.setText(ApplicationResources.getInstance().getString("stdcaption.cancel"));
		typePanel = new OWLMappingTypePane();
		destinationPanelLayout.setHorizontalGroup(destinationPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(filePathLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(destinationPanelLayout.createParallelGroup()
			    .addComponent(filePathText, GroupLayout.Alignment.LEADING, 0, 362, Short.MAX_VALUE)
			    .addGroup(GroupLayout.Alignment.LEADING, destinationPanelLayout.createSequentialGroup()
			        .addGap(22)
			        .addComponent(newTabButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
			        .addGap(122)
			        .addComponent(fileButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
			        .addGap(0, 22, Short.MAX_VALUE)))
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(browseButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
			.addContainerGap());
		destinationPanelLayout.setVerticalGroup(destinationPanelLayout.createSequentialGroup()
			.addGroup(destinationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addComponent(newTabButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(fileButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(14)
			.addGroup(destinationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addComponent(filePathText, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(filePathLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(browseButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
			.addContainerGap());
		
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
		
		fileButton.setSelected(ProjectSettings.OWL_GENERATE_FILE.getBoolValue(project));
		enableOrDisableFileChooser(ProjectSettings.OWL_GENERATE_FILE.getBoolValue(project));
		filePathText.setText(ProjectSettings.OWL_FILE_PATH.getValue(project));			
	}

	private String getDefaultIRI()
	{		
		String projectName = project.getName().replace(" ","");
//		return "http://nemo.inf.ufes.br/" + projectName + ".owl";
		return "http://www.menthor.net/" + projectName;
	}

	private void enableOrDisableFileChooser(boolean flag) {
		filePathText.setEnabled(flag);
		filePathText.setEditable(flag);
		browseButton.setEnabled(flag);
		filePathLabel.setEnabled(flag);
	}

	private void getFilePath()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(ApplicationResources.getInstance().getString("stdcaption.selectfile"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("OWL File (*.owl)", "owl");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File selectedFile = ConfigurationHelper.getFileWithExtension(fileChooser.getSelectedFile(), ".owl");
			filePathText.setText(selectedFile.getAbsolutePath());
		}
	}
}
