package net.menthor.editor.transformation.owl;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import net.menthor.common.transformation.DestinationEnum;
import net.menthor.common.transformation.MappingType;
import net.menthor.editor.transformation.DestinationPane;

public class OwlApproachPane extends JPanel {

	private static final long serialVersionUID = -5681113361932739723L;
	
	private JButton cancelButton;
	private JButton okButton;
	private OwlMappingTypePane typePanel;
	private DestinationPane destinationPanel;
		
	public String getPathText() { return destinationPanel.getPath(); }
	public MappingType getSelectedMapping() { return typePanel.getMappingType(); }
	public DestinationEnum getDestination() { return destinationPanel.getDestination(); }
	
	public JButton getOkButton() { return okButton; }
	public JButton getCancelButton() { return cancelButton; }
	
	public OwlApproachPane()
	{	
		GroupLayout GenerateOWLPanelLayout = new GroupLayout((JComponent)this);				
		setLayout(GenerateOWLPanelLayout);				
				
		okButton = new JButton();
		okButton.setVisible(false);
		okButton.setText("Ok");
		
		cancelButton = new JButton();
		cancelButton.setVisible(false);
		cancelButton.setText("Cancel");
		
		typePanel = new OwlMappingTypePane();
		
		destinationPanel = new DestinationPane("OWL (*.owl)","owl");
		destinationPanel.renameAppButton("Protégé");
		destinationPanel.selectTab();
		destinationPanel.getAppButton().setEnabled(false);
		destinationPanel.enableFileChooser(false);
		
		GenerateOWLPanelLayout.setHorizontalGroup(GenerateOWLPanelLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(GenerateOWLPanelLayout.createParallelGroup()
			    .addComponent(destinationPanel, GroupLayout.Alignment.LEADING, 0, 500, Short.MAX_VALUE)
			    .addComponent(typePanel, GroupLayout.Alignment.LEADING, 0, 500, Short.MAX_VALUE)
			)			        			            
		);
		GenerateOWLPanelLayout.setVerticalGroup(GenerateOWLPanelLayout.createSequentialGroup()
			.addContainerGap()			 
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(destinationPanel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(typePanel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)				 
		);
	
		this.setSize(650, 365);		
	}
}
