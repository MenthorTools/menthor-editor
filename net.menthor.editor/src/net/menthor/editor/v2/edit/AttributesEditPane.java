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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import org.tinyuml.umldraw.ClassElement;

import RefOntoUML.Class;
import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.Property;
import net.menthor.editor.ui.Models;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.managers.TransferManager;
import net.menthor.editor.v2.tables.AttributeTableModel;
import net.menthor.editor.v2.types.ColorMap;
import net.menthor.editor.v2.types.ColorType;

public class AttributesEditPane extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Component parent;

	private ClassElement classElement;	
	private Classifier element;	
	private Map<String, DataType> datatypes;
	private AttributeTableModel tablemodel;
	
	private JButton btnDelete;
	private JButton btnCreate;
	private JButton btnUp;
	private JButton btnDown;
	private JScrollPane scrollpane;
	private JTable table;	
	private JPanel panel;
	private JButton btnEdit;
	private JCheckBox cbxVisible;
			
	public AttributesEditPane(final Component parent, final ClassElement classElement, final Classifier element){
		this.classElement = classElement;
		this.element = element;
		this.parent=parent;
		initUI();
	}
	
	public void initDataTypesMap(){
		datatypes = new HashMap<String, DataType>();		
		for (DataType item : Models.getRefparser().getAllInstances(RefOntoUML.DataType.class)) {			
			datatypes.put(item.getName(), item);
		}
		tablemodel.setDataTypes(datatypes.values());
	}
	
	public void transferData(){
		if (classElement !=null) classElement.setShowAttributes(cbxVisible.isSelected());
		TransferManager.get().transferNewDataTypes(getNewDataTypes());	
		TransferManager.get().transferAttributes(element, tablemodel.getEntries());
		if(classElement!=null){
			classElement.reinitAttributesCompartment();
			classElement.invalidate();
		}
	}
	
	public void setData(){
		initDataTypesMap();		
		table.setSurrendersFocusOnKeystroke(true);
		TableColumn dtColumn = table.getColumnModel().getColumn(1);	
		dtColumn.setCellEditor(createEditor(datatypes.keySet().toArray()));
		TableColumn multColumn = table.getColumnModel().getColumn(2);	
		multColumn.setCellEditor(createEditor(new String[]{"1","0..1","0..*","1..*"}));		
		if(element instanceof DataType){
			for (Property attribute : ((DataType)element).getOwnedAttribute()) {
				tablemodel.addEntry(attribute);
			}
		}
		if(element instanceof Class){
			for (Property attribute : ((Class)element).getOwnedAttribute()) {
				tablemodel.addEntry(attribute);
			}
		}		
		if (classElement !=null) { 
			cbxVisible.setSelected(classElement.showAttributes());
			cbxVisible.setEnabled(true); 
		}else{ 
			cbxVisible.setSelected(false); 
			cbxVisible.setEnabled(false); 
		}
	}
		
	public List<RefOntoUML.Type> getNewDataTypes(){		
		List<RefOntoUML.Type> result = new ArrayList<RefOntoUML.Type>();
		for (Property property : tablemodel.getEntries()){			
			if(datatypes.keySet().contains(property.getType().getName().trim()) == false)
				result.add(property.getType());
		}
		return result;
	}
	
	public void moveUpAttribute(){
		int row = table.getSelectedRow();
		if (row >=0  && row < table.getRowCount()){
			tablemodel.moveUpEntry(row);
			table.setRowSelectionInterval(row - 1, row - 1);
		}
	}

	public void moveDownAttribute(){
		int row = table.getSelectedRow();
		if (row >=0  && row < table.getRowCount()){
			tablemodel.moveDownEntry(row);
			table.setRowSelectionInterval(row + 1, row + 1);
		}
	}
	
	public void addAttribute(ActionEvent evt){
		tablemodel.addEmptyEntry();		
	}
	
	public void deleteAttribute(ActionEvent evt){
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0 && selectedRow < tablemodel.getRowCount()){
			tablemodel.removeEntryAt(selectedRow);
		}
	}
	
	public void editAttribute(){
		int row = table.getSelectedRow();
		if(row>=0){
			Property p = tablemodel.getEntry(row);
			AttributeEditDialog dialog = null;
			if (parent instanceof JFrame){
				dialog = new AttributeEditDialog((JFrame)parent,classElement, element, p, false);    				
			}else if (parent instanceof JDialog) {
				dialog = new AttributeEditDialog((JDialog)parent, classElement, element, p, false);    			
			}
			dialog.setLocationRelativeTo(parent);
			dialog.setVisible(true);
		}
	}
	
	public void refreshData(){
		tablemodel.fireTableDataChanged();
	}
	
	public void initUI(){
		setSize(450,221);
		tablemodel = new AttributeTableModel(element);		
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
		btnCreate.setToolTipText("Add new attribute to this class");
		btnCreate.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_ADD));
		btnCreate.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addAttribute(arg0);
			}
		});		
		btnDelete = new JButton("");
		btnDelete.setFocusable(false);
		btnDelete.setToolTipText("Delete selected attribute");
		btnDelete.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_DELETE));
		btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteAttribute(arg0);
			}
		});		
		btnUp = new JButton("");
		btnUp.setFocusable(false);
		btnUp.setToolTipText("Move up selected attribute");
		btnUp.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_UP));
		btnUp.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				moveUpAttribute();
			}
		});		
		btnDown = new JButton("");
		btnDown.setFocusable(false);
		btnDown.setToolTipText("Move down selected attribute");
		btnDown.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_DOWN));
		btnDown.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				moveDownAttribute();
			}
		});		
		btnEdit = new JButton("");
		btnEdit.setEnabled(true);
		btnEdit.setFocusable(false);
		btnEdit.setToolTipText("Edit selected attribute");
		btnEdit.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_EDIT));
		btnEdit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editAttribute();
			}
		});		
		setLayout(null);
		cbxVisible = new JCheckBox("Turn attributes visible");
		cbxVisible.setPreferredSize(new Dimension(140, 20));
		cbxVisible.setHorizontalAlignment(SwingConstants.LEFT);		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollpane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbxVisible, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxVisible, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollpane, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
					.addGap(10))
		);
		panel.setLayout(gl_panel);
		add(panel);
		
		setData();
	}	
	
	private TableCellEditor createEditor(Object[] objects){
        @SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox combo = new JComboBox(objects) {
        	private static final long serialVersionUID = 1L;			
			@Override
			protected boolean processKeyBinding(KeyStroke ks, KeyEvent e, int condition, boolean pressed){
				boolean retValue = super.processKeyBinding(ks, e, condition,pressed);
                if (!retValue && isStartingCellEdit() && editor != null) {
                    // this is where the magic happens
                    // not quite right; sets the value, but doesn't advance the
                    // cursor position for AC
                    editor.setItem(String.valueOf(ks.getKeyChar()));
                }
                return retValue;
			}			
            private boolean isStartingCellEdit(){
                JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, this);
                return table != null && table.isFocusOwner() && !Boolean.FALSE.equals((Boolean)table.getClientProperty("JTable.autoStartsEdit"));
            }
        };        
        combo.setEditable(true);
        return new DefaultCellEditor(combo);
    }
}
