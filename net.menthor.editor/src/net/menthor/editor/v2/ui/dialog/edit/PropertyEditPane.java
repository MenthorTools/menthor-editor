package net.menthor.editor.v2.ui.dialog.edit;

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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.tinyuml.draw.DiagramElement;

import RefOntoUML.Association;
import RefOntoUML.Characterization;
import RefOntoUML.Classifier;
import RefOntoUML.Mediation;
import RefOntoUML.Meronymic;
import RefOntoUML.Property;
import RefOntoUML.Structuration;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.Models;
import net.menthor.editor.v2.managers.TransferManager;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;

public class PropertyEditPane extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Component parent;
		
	private OntoUMLParser refparser;
	private Classifier ownerElement;
	private Property property;	
	
	private JTextField nameField;
	private JLabel lblMultiplicity;
	@SuppressWarnings("rawtypes")
	private JComboBox multCombo;
	private JLabel lblAggregationKind;
	@SuppressWarnings("rawtypes")
	private JComboBox aggregCombo;
	private JButton btnRedefined;
	private JButton btnSubsetted;
	private JCheckBox cbxDerived;
	private JCheckBox cbxUnique;
	private JCheckBox cbxOrdered;
	private JCheckBox cbxReadOnly;
	@SuppressWarnings("rawtypes")
	private JComboBox typeCombo;
	private JLabel lblName;
	private JLabel lblType;
	private JLabel lblSubsetted;
	private JLabel lblRedefined;
	private JPanel mainPanel;
	private JPanel optionsPanel;
	private JPanel listPanel;
	private JPanel multPanel;
	private JTextField subsettedText;
	private JTextField redefinedText;
	
	public PropertyEditPane(Component parent, DiagramElement ownerDiagramElement, RefOntoUML.Classifier ownerElem, final Property property){
		setBorder(new EmptyBorder(10, 10, 10, 10));
		this.parent=parent;		
		this.refparser = Models.getRefparser();
		this.property = property;		
		this.ownerElement = ownerElem;	
		initGUI();		
	}
	
	/** Transfer data from GUI to model/Menthor */
	public void transferData(){
		if(cbxDerived.isSelected()) {
			nameField.setText(nameField.getText().replace("/",""));
		}		
		TransferManager.get().transferProperty(property,
			nameField.getText(),
			cbxDerived.isSelected(),
			cbxOrdered.isSelected(),
			cbxReadOnly.isSelected(),
			cbxUnique.isSelected(),
			(String)aggregCombo.getSelectedItem(),			
			(String)multCombo.getSelectedItem(),
			(RefOntoUML.Type)typeCombo.getSelectedItem()
		);
	}
	
	/** Set GUI data from the model element*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setData(){
		nameField.setText(property.getName());
		cbxDerived.setSelected(property.isIsDerived());
		cbxOrdered.setSelected(property.isIsOrdered());
		cbxReadOnly.setSelected(property.isIsReadOnly());
		cbxUnique.setSelected(property.isIsUnique());
		aggregCombo.setSelectedItem(property.getAggregation().getName());		
		if (ownerElement instanceof Mediation || ownerElement instanceof Characterization || ownerElement instanceof Structuration){
			if (property.equals(((Association)ownerElement).getMemberEnd().get(0))) cbxReadOnly.setEnabled(true);
			else cbxReadOnly.setEnabled(false);
		}				
		if (ownerElement instanceof Meronymic) aggregCombo.setEnabled(true);
		else aggregCombo.setEnabled(false);
		String multiplicity = new String();
		if (property.getLower()==property.getUpper() && property.getUpper()!=-1) multiplicity = Integer.toString(property.getLower());
		else if (property.getLower()==property.getUpper() && property.getUpper()==-1) multiplicity = "*";
		else if (property.getUpper()==-1) multiplicity = property.getLower()+".."+"*";
		else multiplicity = property.getLower()+".."+property.getUpper();		
		if(multiplicity.compareToIgnoreCase("1")==0) multCombo.setSelectedIndex(0);
		else if(multiplicity.compareToIgnoreCase("0..1")==0)multCombo.setSelectedIndex(1);
		else if(multiplicity.compareToIgnoreCase("0..*")==0)multCombo.setSelectedIndex(2);
		else if(multiplicity.compareToIgnoreCase("1..*")==0) multCombo.setSelectedIndex(3);
		else { multCombo.setSelectedItem(multiplicity); }		
		String subsettedStr = OntoUMLParser.getSubsettedAsString(property);
		subsettedText.setText(subsettedStr);		
		String redefinedStr = OntoUMLParser.getRedefinedAsString(property);
		redefinedText.setText(redefinedStr);		
		RefOntoUML.PackageableElement value = property.getType();									    	
		List<RefOntoUML.PackageableElement> types = refparser.getAllTypesSorted();
    	typeCombo.setModel(new DefaultComboBoxModel(types.toArray()));
    	typeCombo.setSelectedItem(value);    	
	}
	
	public void editRedefined(){
		if (parent instanceof JFrame) PropertyListEditDialog.open((JFrame)parent,redefinedText, "Redefined", property, refparser);
		else PropertyListEditDialog.open((JDialog)parent,redefinedText, "Redefined", property, refparser);
	}
	
	public void editSubsetted(){
		if (parent instanceof JFrame) PropertyListEditDialog.open((JFrame)parent,subsettedText, "Subsetted", property, refparser);
		else PropertyListEditDialog.open((JDialog)parent,subsettedText, "Subsetted", property, refparser);
	}
	
	/** 
	 * Made with Windows Builder on Eclipse 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initGUI (){	
		setPreferredSize(new Dimension(456, 268));
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createTitledBorder(""));		
		optionsPanel = new JPanel();
		optionsPanel.setBorder(BorderFactory.createTitledBorder(""));		
		listPanel = new JPanel();
		listPanel.setBorder(BorderFactory.createTitledBorder(""));		
		multPanel = new JPanel();
		multPanel.setBorder(BorderFactory.createTitledBorder(""));		
		lblMultiplicity = new JLabel("Multiplicity:");		
		multCombo = new JComboBox();
		multCombo.setModel(new DefaultComboBoxModel(new String[] {"1", "0..1", "0..*", "1..*"}));
		multCombo.setPreferredSize(new Dimension(80, 20));
		multCombo.setEditable(true);		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(multPanel, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
				.addComponent(listPanel, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(multPanel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(2))
		);		
		lblAggregationKind = new JLabel("Aggregation Kind:");		
		aggregCombo = new JComboBox();
		aggregCombo.setModel(new DefaultComboBoxModel(new String[] {"none", "shared", "composite"}));
		aggregCombo.setPreferredSize(new Dimension(80, 20));
		GroupLayout gl_multPanel = new GroupLayout(multPanel);
		gl_multPanel.setHorizontalGroup(
			gl_multPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_multPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_multPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblMultiplicity, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAggregationKind, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_multPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(aggregCombo, 0, 134, Short.MAX_VALUE)
						.addComponent(multCombo, 0, 134, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_multPanel.setVerticalGroup(
			gl_multPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_multPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_multPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMultiplicity)
						.addComponent(multCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_multPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(aggregCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAggregationKind))
					.addContainerGap())
		);
		multPanel.setLayout(gl_multPanel);		
		btnSubsetted = new JButton("");
		btnSubsetted.setPreferredSize(new Dimension(30, 25));
		btnSubsetted.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_EDIT));
		btnSubsetted.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editSubsetted();
			}
		});		
		subsettedText = new JTextField();
		subsettedText.setEditable(false);
		subsettedText.setColumns(10);
		subsettedText.setPreferredSize(new Dimension(300, 20));		
		redefinedText = new JTextField();
		redefinedText.setEditable(false);
		redefinedText.setColumns(10);
		redefinedText.setSize(new Dimension(100, 50));		
		btnRedefined = new JButton("");
		btnRedefined.setPreferredSize(new Dimension(30, 25));
		btnRedefined.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_EDIT));
		btnRedefined.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editRedefined();
			}
		});		
		lblSubsetted = new JLabel("Subsetted:");		
		lblRedefined = new JLabel("Redefined:");		
		GroupLayout gl_listPanel = new GroupLayout(listPanel);
		gl_listPanel.setHorizontalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_listPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_listPanel.createSequentialGroup()
							.addComponent(lblSubsetted)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(subsettedText, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
						.addGroup(gl_listPanel.createSequentialGroup()
							.addComponent(lblRedefined)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(redefinedText, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)))
					.addGap(6)
					.addGroup(gl_listPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSubsetted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRedefined, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_listPanel.setVerticalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_listPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSubsetted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_listPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(subsettedText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSubsetted)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_listPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_listPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(redefinedText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRedefined))
						.addComponent(btnRedefined, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		listPanel.setLayout(gl_listPanel);		
		cbxDerived = new JCheckBox("Derived");
		cbxDerived.setPreferredSize(new Dimension(70, 20));		
		cbxUnique = new JCheckBox("Unique");
		cbxUnique.setPreferredSize(new Dimension(95, 20));		
		cbxOrdered = new JCheckBox("Ordered");
		cbxOrdered.setPreferredSize(new Dimension(75, 20));		
		cbxReadOnly = new JCheckBox("Read Only");
		cbxReadOnly.setPreferredSize(new Dimension(100, 20));
		GroupLayout gl_optionsPanel = new GroupLayout(optionsPanel);
		gl_optionsPanel.setHorizontalGroup(
			gl_optionsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_optionsPanel.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_optionsPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_optionsPanel.createSequentialGroup()
							.addComponent(cbxDerived, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(cbxUnique, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_optionsPanel.createSequentialGroup()
							.addComponent(cbxOrdered, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbxReadOnly, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		gl_optionsPanel.setVerticalGroup(
			gl_optionsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_optionsPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_optionsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(cbxDerived, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxUnique, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_optionsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxReadOnly, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxOrdered, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		optionsPanel.setLayout(gl_optionsPanel);		
		lblName = new JLabel("Name:");		
		nameField = new JTextField();
		nameField.setColumns(10);		
		lblType = new JLabel("Type:");		
		typeCombo = new JComboBox();
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblType, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(typeCombo, 0, 334, Short.MAX_VALUE)
						.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblType)
						.addComponent(typeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		mainPanel.setLayout(gl_mainPanel);
		setLayout(groupLayout);
		
		setData();
	}
}
