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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import org.eclipse.emf.common.util.EList;
import org.tinyuml.umldraw.ClassElement;

import RefOntoUML.Classifier;
import RefOntoUML.Enumeration;
import RefOntoUML.EnumerationLiteral;
import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.managers.TransferManager;
import net.menthor.editor.v2.tables.LiteralTableModel;
import net.menthor.editor.v2.types.ColorMap;
import net.menthor.editor.v2.types.ColorType;

public class LiteralEditPane extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private DiagramManager diagramManager;
		
	private ClassElement classElement;	
	private Classifier element;
			 
	private JButton btnDelete;
	private JButton btnCreate;
	private JButton btnUp;
	private JButton btnDown;
	private JScrollPane scrollpane;
	private JTable table;
	private LiteralTableModel tablemodel;
	private JPanel panel;
	private JCheckBox cbxVisible;
			
	public LiteralEditPane(final DiagramManager diagramManager, final ClassElement classElement, final Classifier element){
		this.diagramManager = diagramManager;
		this.classElement = classElement;
		this.element = element;
		initUI();
	}
	
	public void setData(){				
		if (classElement !=null) { 
			cbxVisible.setSelected(classElement.showAttributes());
			cbxVisible.setEnabled(true); 
		}else{ 
			cbxVisible.setSelected(false); 
			cbxVisible.setEnabled(false); 
		}
		if(element instanceof Enumeration){
			Enumeration enumeration = (Enumeration)element;			
			for (EnumerationLiteral literal : enumeration.getOwnedLiteral()) {
				tablemodel.addEntry(literal);
			}
		}
	}
	
	public void transferData(){
		EList<EnumerationLiteral> enumLiterals = tablemodel.getEntries();		
		if(!cbxVisible.isSelected() && enumLiterals.size()>0) cbxVisible.setSelected(true);
		if (classElement !=null) classElement.setShowAttributes(cbxVisible.isSelected());				
		TransferManager.transferLiterals(element, enumLiterals);			
		classElement.reinitAttributesCompartment();
		classElement.invalidate();
	}
	
	public void moveUpLiteral(){
		int row = table.getSelectedRow();
		if (row >=0  && row < table.getRowCount()){
			tablemodel.moveUpEntry(row);
			table.setRowSelectionInterval(row - 1, row - 1);
		}
	}

	public void moveDownLiteral(){
		int row = table.getSelectedRow();
		if (row >=0  && row < table.getRowCount()){
			tablemodel.moveDownEntry(row);
			table.setRowSelectionInterval(row + 1, row + 1);
		}
	}
	
	public void addLiteral(ActionEvent evt){
		tablemodel.addEmptyEntry();		
	}
	
	public void deleteLiteral(ActionEvent evt){
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0 && selectedRow < tablemodel.getRowCount()){
			tablemodel.removeEntryAt(selectedRow);
		}
	}
	
	public void refreshData(){
		tablemodel.fireTableDataChanged();
	}
	
	public void initUI(){
		setSize(450,221);
		setLayout(null);
		tablemodel = new LiteralTableModel(((RefOntoUML.Enumeration)element));		
		panel = new JPanel();
		panel.setBounds(0, 0, 450, 221);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		scrollpane = new JScrollPane();		
		scrollpane.setMinimumSize(new Dimension(0, 0));
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));		
		table = new JTable();		
		scrollpane.setViewportView(table);
		table.setModel(tablemodel);		
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setFillsViewportHeight(true);
		table.setGridColor(Color.LIGHT_GRAY);		
		table.setSelectionBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE));
		table.setSelectionForeground(Color.BLACK);
		table.setFocusable(false);	    
		table.setRowHeight(23);		
		btnCreate = new JButton("");
		btnCreate.setFocusable(false);
		btnCreate.setToolTipText("Add new value to this enumeration");
		btnCreate.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_ADD));
		btnCreate.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addLiteral(arg0);
			}
		});
		btnDelete = new JButton("");
		btnDelete.setFocusable(false);
		btnDelete.setToolTipText("Delete selected values");
		btnDelete.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_DELETE));
		btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteLiteral(arg0);
			}
		});		
		btnUp = new JButton("");
		btnUp.setFocusable(false);
		btnUp.setToolTipText("Move up selected value");
		btnUp.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_UP));
		btnUp.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				moveUpLiteral();
			}
		});		
		btnDown = new JButton("");
		btnDown.setFocusable(false);
		btnDown.setToolTipText("Move down selected value");
		btnDown.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_DOWN));
		btnDown.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				moveDownLiteral();
			}
		});		
		cbxVisible = new JCheckBox("Turn literals visible");
		cbxVisible.setPreferredSize(new Dimension(140, 20));
		cbxVisible.setHorizontalAlignment(SwingConstants.LEFT);		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollpane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbxVisible, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxVisible, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollpane, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(10))
		);
		panel.setLayout(gl_panel);		
		add(panel);
		
		setData();
	}
}

