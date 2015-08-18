package net.menthor.editor.v2.settings;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public abstract class BaseApproachPane extends JPanel {

	private static final long serialVersionUID = 2408763450380277965L;
	
	@SuppressWarnings("rawtypes")
	protected JComboBox approachesCombo;
	protected JTextPane descriptionTextPane;	
	
	//====================================================
	//Constructor and Initializer Methods 
	//====================================================
	
	public BaseApproachPane()	{
		buildUI();
	}
	
	@SuppressWarnings({ "rawtypes" })
	private void buildUI(){
		setBorder(new TitledBorder(null, "Approach", TitledBorder.LEADING, TitledBorder.TOP, null, null));		
		approachesCombo = new JComboBox();		
		approachesCombo.setOpaque(false);
		approachesCombo.setFocusable(false);				
		descriptionTextPane = new JTextPane();
		descriptionTextPane.setBackground(UIManager.getColor("Panel.background"));		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(descriptionTextPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(approachesCombo, Alignment.LEADING, 0, 418, Short.MAX_VALUE))
					.addContainerGap())
		);		
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(approachesCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(descriptionTextPane, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(10))
		);
		setLayout(groupLayout);
	}	
}
