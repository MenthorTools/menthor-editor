package net.menthor.editor.transformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class MappingTypePane extends JPanel {

	private static final long serialVersionUID = 2408763450380277965L;
	
	@SuppressWarnings("rawtypes")
	private JComboBox mappingCombo;
	private JTextPane descriptionTextPane;
	private List<MappingType> mappings = new ArrayList<MappingType>();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addEntry(MappingType opt){
		this.mappings.add(opt);
		mappingCombo.setModel(new DefaultComboBoxModel(mappings.toArray()));
		mappingCombo.updateUI();
		descriptionTextPane.setText(opt.getDesctiprion());
	}
		
	public void selectEntry(String type)
	{
		for(MappingType mt: mappings){
			if(mt.getType().compareToIgnoreCase(type)==0) mappingCombo.setSelectedItem(mt);
		}
	}
	
	public MappingType getSelectedEntry()
	{
		return (MappingType) mappingCombo.getSelectedItem();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addEntries(List<MappingType> opt){
		this.mappings.addAll(opt);
		mappingCombo.setModel(new DefaultComboBoxModel(mappings.toArray()));
		mappingCombo.updateUI();	
		if(mappings.size()>0) descriptionTextPane.setText(mappings.get(0).getDesctiprion());
	}
	
	@SuppressWarnings("rawtypes")
	public MappingTypePane() 
	{
		setBorder(new TitledBorder(null, "Mapping Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		mappingCombo = new JComboBox();
		mappingCombo.setOpaque(false);
		mappingCombo.setFocusable(false);
		mappingCombo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MappingType mt = (MappingType) mappingCombo.getSelectedItem();
				descriptionTextPane.setText(mt.getDesctiprion());
			}
		});
		
		descriptionTextPane = new JTextPane();
		descriptionTextPane.setBackground(UIManager.getColor("Panel.background"));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(descriptionTextPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(mappingCombo, Alignment.LEADING, 0, 418, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(mappingCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(descriptionTextPane, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(10))
		);
		setLayout(groupLayout);
	}
}
