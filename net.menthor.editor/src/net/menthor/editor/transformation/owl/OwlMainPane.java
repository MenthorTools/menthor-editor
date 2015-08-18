package net.menthor.editor.transformation.owl;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import net.menthor.common.settings.owl.OWL2Approach;
import net.menthor.common.settings.owl.OWL2Destination;
import net.menthor.editor.v2.settings.owl.OwlApproachPane;
import net.menthor.editor.v2.settings.owl.OwlDestinationPane;

public class OwlMainPane extends JPanel {

	private static final long serialVersionUID = -5681113361932739723L;
	
	private JButton cancelButton;
	private JButton okButton;
	private OwlApproachPane typePanel;
	private OwlDestinationPane destinationPanel;
		
	public String getPathText() { return destinationPanel.getPath(); }
	public OWL2Approach getSelectedMapping() { return typePanel.getApproach(); }
	public OWL2Destination getOWL2Destination() { return destinationPanel.getOWL2Destination(); }	
	public JButton getOkButton() { return okButton; }
	public JButton getCancelButton() { return cancelButton; }
	
	public OwlMainPane(){	
		buildUI();
	}
	
	public void buildUI(){
		GroupLayout GenerateOWLPanelLayout = new GroupLayout((JComponent)this);				
		setLayout(GenerateOWLPanelLayout);				
		okButton = new JButton();
		okButton.setVisible(false);
		okButton.setText("Ok");		
		cancelButton = new JButton();
		cancelButton.setVisible(false);
		cancelButton.setText("Cancel");		
		typePanel = new OwlApproachPane();		
		destinationPanel = new OwlDestinationPane();			
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
	
	public void loadFromXML(){
		
	}
	
	public void storeToXML(){
		typePanel.storeToXML();
	}
}
