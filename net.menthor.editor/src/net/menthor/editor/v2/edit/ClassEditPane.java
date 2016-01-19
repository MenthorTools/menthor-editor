package net.menthor.editor.v2.edit;

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

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.MixinClass;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.v2.managers.TransferManager;

public class ClassEditPane extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private DiagramManager diagramManager;
	private Classifier element;
	
	private JCheckBox btnAbstract;		
	private JCheckBox btnExtensional;
	private JTextField nameField;
	private JPanel contentPane;
	private JLabel lblStereo;
	@SuppressWarnings("rawtypes")
	protected JComboBox stereoCombo;
	protected JLabel lblName;
	
	@SuppressWarnings("rawtypes")
	public JComboBox getStereotypeComboBox() { return stereoCombo; }
	public void selectNameText() { nameField.selectAll(); }
	
	/** Transfer data from GUI to the model/Menthor */
	public void transferData(){
		TransferManager.get().transferClass(element, 
			nameField.getText(), 
			btnExtensional.isSelected(), 
			btnAbstract.isSelected(), 
			(String) getStereotypeComboBox().getSelectedItem()
		);		
	}
	
	/** Set data from model to the GUI */
	public void setData(){		
		if (element instanceof MixinClass) btnAbstract.setEnabled(false);
		else btnAbstract.setEnabled(true);
		if (element instanceof Collective) btnExtensional.setEnabled(true);
		else btnExtensional.setEnabled(false);
		nameField.setText(element.getName());		
		btnAbstract.setSelected(element.isIsAbstract());
		stereoCombo.setSelectedItem(OntoUMLParser.getStereotype(element).trim());
		stereoCombo.setEnabled(true);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ClassEditPane(DiagramManager diagramManager, RefOntoUML.Classifier element){	
		this.diagramManager = diagramManager;
		this.element = element;
		
		setPreferredSize(new Dimension(451, 80));
		
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createTitledBorder(""));		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPane, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
		);		
		this.setLayout(groupLayout);		
				
		lblName = new JLabel("Name:");		
		nameField = new JTextField();
		nameField.setColumns(10);		
		btnAbstract = new JCheckBox("Abstract");
		btnExtensional = new JCheckBox("Extensional");		
		lblStereo = new JLabel("Classifier:");		
		stereoCombo = new JComboBox();
		stereoCombo.setModel(new DefaultComboBoxModel(OntoUMLParser.getStereotypes()));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblStereo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(stereoCombo, 0, 184, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnAbstract)
							.addGap(7)
							.addComponent(btnExtensional))
						.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
					.addGap(17))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStereo)
						.addComponent(stereoCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExtensional)
						.addComponent(btnAbstract))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		setData();
	}
		
}
