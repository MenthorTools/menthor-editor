package net.menthor.editor.v2.ui.dialog;

import java.awt.BorderLayout;

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
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.PackageableElement;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.commanders.AddCommander;
import net.menthor.editor.v2.commanders.TransferCommander;
import net.menthor.editor.v2.ui.controller.DialogUIController;
import net.menthor.editor.v2.ui.controller.MessageUIController;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;

/**
 * @author John Guerson
 */
public class GeneralizationEditPane extends JPanel {

	private static final long serialVersionUID = 1L;
		
	private Generalization element;
		
	@SuppressWarnings("rawtypes")
	private JComboBox generalCombo;
	private JScrollPane scrollPane;
	@SuppressWarnings("rawtypes")
	private JComboBox specificCombo;
	private JList<RefOntoUML.Element> genSetList;
	private JButton btnRemove;
	private JButton btnAdd;
	@SuppressWarnings("rawtypes")
	private DefaultListModel genSetModel;
	private JLabel lblGeneral;
	private JButton btnNew; 
	private JButton btnEdit;
	private JLabel lblSpecific;
	private JLabel lblGs;
	private JPanel gsPane;
	private JPanel genPane;
		
	/** @wbp.parser.constructor */
	public GeneralizationEditPane(final Generalization element){		
		initData(element);
		initGUI();		
	}	
	
	public void initData(final Generalization element){
		this.element = element;
	}
	
	public void initGUI(){	
		setLayout(new BorderLayout(0, 0));
		genPane();
		gsPane();		
		add(genPane, BorderLayout.NORTH);
		add(gsPane, BorderLayout.CENTER);
		setData();
	}
	
	public void transferData(){
		TransferCommander.get().transferGeneralization(element, 
			(RefOntoUML.Type)generalCombo.getSelectedItem(), 
			(RefOntoUML.Type)specificCombo.getSelectedItem()
		);		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setData(){
		List<RefOntoUML.PackageableElement> types = ProjectUIController.get().getProject().getRefParser().getAllTypesSorted();				
    	generalCombo.setModel(new DefaultComboBoxModel(types.toArray()));
    	generalCombo.setSelectedItem(element.getGeneral());	
    	specificCombo.setModel(new DefaultComboBoxModel(types.toArray()));
    	specificCombo.setSelectedItem(element.getSpecific());	
	}	
	
	public void editGenSet(){
		if(genSetModel.size()>0){
			GeneralizationSet genSet = (GeneralizationSet)genSetList.getSelectedValue();
			DialogUIController.get().callGeneralizationSetDialog(genSet,true);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void newGenSet(){
		int response = MessageUIController.get().confirm(GeneralizationEditPane.this, "Add", "Are you sure you want to create a new generalization set?");
		if(response==0){
			PackageableElement genSet = (PackageableElement)AddCommander.get().addGeneralizationSet((RefOntoUML.Package)element.eContainer().eContainer());
			genSet.setName("gs");
			((GeneralizationSet)genSet).setIsCovering(true);
			((GeneralizationSet)genSet).setIsDisjoint(true);
			((GeneralizationSet)genSet).getGeneralization().add(element);
			element.getGeneralizationSet().add((GeneralizationSet)genSet);					
			DialogUIController.get().callGeneralizationSetDialog((GeneralizationSet)genSet,true);
			genSetModel.addElement(genSet);				
		}
	}
	
	public void removeGenSet(){
		if (genSetModel.size()>0){
			RefOntoUML.GeneralizationSet genSet = (RefOntoUML.GeneralizationSet)genSetList.getSelectedValue();			
			genSet.getGeneralization().remove(element);
			element.getGeneralizationSet().remove(genSet);			
			genSetModel.removeElement(genSetList.getSelectedValue());				
		}
	}
	
	@SuppressWarnings("unchecked")
	public void addGenSet(){
		OntoUMLParser refparser = ProjectUIController.get().getProject().getRefParser();
		ArrayList<RefOntoUML.GeneralizationSet> genSetList = new ArrayList<RefOntoUML.GeneralizationSet>();
		for(GeneralizationSet gs: refparser.getAllInstances(GeneralizationSet.class)){
			if (!(element.getGeneralizationSet().contains(gs))) genSetList.add(gs);
		}				
		if (genSetList.size()==0) {
			MessageUIController.get().showInfo(GeneralizationEditPane.this, "Generalization Set", "No generalization set left in the model.");
		}else{
			RefOntoUML.GeneralizationSet genSet = (RefOntoUML.GeneralizationSet) MessageUIController.get().input(
				GeneralizationEditPane.this,
				"Generalization Set",
		        "To which generalization set do you want to include "+element,		         
		        genSetList.toArray(), 
		        genSetList.toArray()[0]
			);
			if(genSet!=null){
				genSet.getGeneralization().add(element);
				element.getGeneralizationSet().add(genSet);
				genSetModel.addElement(genSet);
			}
		}	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void genPane(){
		genPane = new JPanel();
		genPane.setBorder(BorderFactory.createTitledBorder(""));
		lblSpecific = new JLabel("Specific:");		
		specificCombo = new JComboBox();
		specificCombo.setPreferredSize(new Dimension(350, 20));
		specificCombo.addItem(element.getSpecific());		
		lblGeneral = new JLabel("General:");		
		generalCombo = new JComboBox();
		generalCombo.setPreferredSize(new Dimension(350, 20));
		GroupLayout gl_genPane = new GroupLayout(genPane);
		gl_genPane.setHorizontalGroup(
			gl_genPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_genPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_genPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGeneral)
						.addComponent(lblSpecific))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_genPane.createParallelGroup(Alignment.LEADING)
						.addComponent(specificCombo, 0, 355, Short.MAX_VALUE)
						.addComponent(generalCombo, 0, 355, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_genPane.setVerticalGroup(
			gl_genPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_genPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_genPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(generalCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGeneral))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_genPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(specificCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSpecific))
					.addGap(20))
		);
		gl_genPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblSpecific, lblGeneral});
		genPane.setLayout(gl_genPane);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void gsPane(){
		gsPane = new JPanel();
		gsPane.setBorder(BorderFactory.createTitledBorder(""));				
		lblGs = new JLabel("Participating generalization sets :");		
		genSetModel = new DefaultListModel();
		for(GeneralizationSet gs: element.getGeneralizationSet()){
			genSetModel.addElement(gs);
		}		
		genSetList= new JList<RefOntoUML.Element>(genSetModel);		
		scrollPane = new JScrollPane(genSetList);		
		btnRemove = new JButton("");
		btnRemove.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_DELETE));
		btnRemove.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeGenSet();
			}
		});		
		btnAdd = new JButton("");
		btnAdd.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_ADD));
		btnAdd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addGenSet();			
			}
		});		
		btnNew = new JButton("");
		btnNew.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_ADD_GREEN));
		btnNew.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				newGenSet();
			}
		});		
		btnEdit = new JButton("");
		btnEdit.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_EDIT));
		btnEdit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editGenSet();
			}
		});		
		GroupLayout gl_gsPane = new GroupLayout(gsPane);
		gl_gsPane.setHorizontalGroup(
			gl_gsPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gsPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gsPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gsPane.createSequentialGroup()
							.addGroup(gl_gsPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_gsPane.createSequentialGroup()
									.addComponent(lblGs, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE))
								.addGroup(gl_gsPane.createSequentialGroup()
									.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_gsPane.setVerticalGroup(
			gl_gsPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_gsPane.createSequentialGroup()
					.addGap(3)
					.addComponent(lblGs, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(scrollPane)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_gsPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRemove)
						.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEdit))
					.addContainerGap())
		);
		gl_gsPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnRemove, btnAdd, btnNew, btnEdit});
		gl_gsPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRemove, btnAdd, btnNew, btnEdit});
		gsPane.setLayout(gl_gsPane);
	}
}
