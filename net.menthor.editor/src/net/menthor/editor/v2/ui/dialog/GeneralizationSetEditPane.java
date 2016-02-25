package net.menthor.editor.v2.ui.dialog;

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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLElementCustom;
import net.menthor.editor.v2.commanders.TransferCommander;
import net.menthor.editor.v2.ui.controller.MessageUIController;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;

public class GeneralizationSetEditPane extends JPanel {
	
	private static final long serialVersionUID = 1L;
		
	private GeneralizationSet genSet;
	
	private JTextField textField;		
	private JButton btnAdd;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JCheckBox cbxDisjoint;
	private JCheckBox cbxCovering;
	private JLabel lblName;
	@SuppressWarnings("rawtypes")
	private DefaultListModel genModel;
	private JList<RefOntoUMLElementCustom> genList;
	private JLabel lblParticipatingGeneralizations;
	private JPanel gsPane;
	private JPanel gensPane;
		
	/** @wbp.parser.constructor */
	public GeneralizationSetEditPane(final GeneralizationSet genSet){		
		this.genSet = genSet;
		initGUI();		
	}		
			
	public void setData(){
		cbxCovering.setSelected(genSet.isIsCovering());
		cbxDisjoint.setSelected(genSet.isIsDisjoint());
		textField.setText(genSet.getName());				
	}
	
	public void transferData(){
		TransferCommander.get().transferGeneralizationSet(genSet,
			textField.getText(),
			cbxDisjoint.isSelected(),
			cbxCovering.isSelected()
		); 
	}
	
	public void initGUI(){				
		setLayout(new BorderLayout(0, 0));
		gsPane();
		gensPane();				
		add(gensPane, BorderLayout.CENTER);
		add(gsPane, BorderLayout.NORTH);		
		setData();
	}
	
	public void deleteGen(){
		RefOntoUMLElementCustom gen = (RefOntoUMLElementCustom)genList.getSelectedValue();		
		genSet.getGeneralization().remove(((Generalization)gen.getElement()));
		((Generalization)gen.getElement()).getGeneralizationSet().remove(genSet);		
		genModel.removeElement(genList.getSelectedValue());	
	}
	
	@SuppressWarnings("unchecked")
	public void addGen(){
		OntoUMLParser refparser = ProjectUIController.get().getProject().getRefParser();
		ArrayList<RefOntoUMLElementCustom> list = new ArrayList<RefOntoUMLElementCustom>();
		for(Generalization g: refparser.getAllInstances(Generalization.class)){
			if (!(genSet.getGeneralization().contains(g))) list.add(new RefOntoUMLElementCustom(g,""));
		}				
		if (list.size()==0) {
			MessageUIController.get().showInfo(GeneralizationSetEditPane.this, "Generalization Set", "No generalization left in the model.");
		}else{
			RefOntoUMLElementCustom selected = (RefOntoUMLElementCustom) MessageUIController.get().input(
				GeneralizationSetEditPane.this, 
				"Generalization Set",
		        "Which generalization do you want to include in Generalization Set"+genSet.getName(),		         
		        list.toArray(), 
		        list.toArray()[0]
			);
			if(selected!=null){			
				genSet.getGeneralization().add(((Generalization)selected.getElement()));
				((Generalization)selected.getElement()).getGeneralizationSet().add(genSet);
				genModel.addElement(selected);
			}
		}		
	}
	
	public void gsPane(){
		gsPane = new JPanel();
		gsPane.setBorder(BorderFactory.createTitledBorder(""));
		lblName = new JLabel("Name:");		
		textField = new JTextField();
		textField.setColumns(10);		
		cbxCovering = new JCheckBox("Covering/Complete");		
		cbxDisjoint = new JCheckBox("Disjoint");		
		GroupLayout gl_gsPane = new GroupLayout(gsPane);
		gl_gsPane.setHorizontalGroup(
			gl_gsPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_gsPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gsPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_gsPane.createSequentialGroup()
							.addComponent(cbxDisjoint)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbxCovering))
						.addGroup(gl_gsPane.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_gsPane.setVerticalGroup(
			gl_gsPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gsPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gsPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_gsPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxCovering)
						.addComponent(cbxDisjoint))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gsPane.setLayout(gl_gsPane);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void gensPane(){
		gensPane = new JPanel();
		gensPane.setBorder(BorderFactory.createTitledBorder(""));		
		genModel = new DefaultListModel();
		for(Generalization gen: genSet.getGeneralization()){
			genModel.addElement(new RefOntoUMLElementCustom(gen,""));
		}		
		genList = new JList<RefOntoUMLElementCustom>(genModel);		
		scrollPane = new JScrollPane(genList);		
		lblParticipatingGeneralizations = new JLabel("Participating generalizations:");		
		btnAdd = new JButton("");		
		btnAdd.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_ADD));
		btnAdd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addGen();		
			}
		});				
		btnDelete = new JButton("");
		btnDelete.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_DELETE));
		btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				deleteGen();			
			}
		});		
		GroupLayout gl_gensPane = new GroupLayout(gensPane);
		gl_gensPane.setHorizontalGroup(
			gl_gensPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gensPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gensPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_gensPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(lblParticipatingGeneralizations, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_gensPane.setVerticalGroup(
			gl_gensPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_gensPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblParticipatingGeneralizations, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_gensPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(4))
		);
		gensPane.setLayout(gl_gensPane);
	}	
}
