package net.menthor.editor.v2.ui.table;

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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

import net.menthor.editor.v2.ui.color.ColorMap;
import net.menthor.editor.v2.ui.color.ColorType;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;
import RefOntoUML.parser.OntoUMLParser;
import javax.swing.ListSelectionModel;

public class MappingTablePane extends JPanel {
	
	private static final long serialVersionUID = -7587547341203464118L;

	protected MappingTableModel tableModel;
	
	protected JScrollPane scrollpane = new JScrollPane();
	protected JTable table;	
	protected JPanel headerPane = new JPanel();
	protected JButton btnAdd;
	protected JButton btnDelete;
	protected JTextPane textPane = new JTextPane();
	private JPanel panel;
	
	public MappingTableModel getTableModel(){ return tableModel; }	
	public JPanel getHeaderPane() { return headerPane; }
	public void setText(String text) { textPane.setText(text); }
	
	public MappingTablePane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle, String choiceColumnTitle){
		tableModel = new MappingChoiceTableModel(sourceColumnTitle, targetColumnTitle, choiceColumnTitle);
		buildUI(refparser);
	}
	
	/** @wbp.parser.constructor */
	public MappingTablePane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle){
		tableModel = new MappingTableModel(sourceColumnTitle, targetColumnTitle);
		buildUI(refparser);
	}	
	
	public void addMapping(ActionEvent evt){
		tableModel.addEmptyEntry();		
	}
	
	public void refreshData(){
		tableModel.fireTableDataChanged();
	}
		
	public void deleteMapping(ActionEvent evt){
		for(int i = table.getSelectedRows().length-1; i >= 0; i--){
			int selectedRow = table.getSelectedRows()[i];
			table.editingStopped(new ChangeEvent(table));		
			if (selectedRow >= 0 && selectedRow < tableModel.getRowCount()){
				tableModel.removeEntryAt(selectedRow);
			}
		}
	}
	
	public void deleteSingleMapping(ActionEvent evt){
		int selectedRow = table.getSelectedRow();		
		table.editingStopped(new ChangeEvent(table));		
		if (selectedRow >= 0 && selectedRow < tableModel.getRowCount()){
			tableModel.removeEntryAt(selectedRow);
		}
	}
	
	private void buildUI(OntoUMLParser refparser){
		scrollpane.setMinimumSize(new Dimension(0, 0));
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));		
		table = new JTable(tableModel);		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollpane.setViewportView(table);		
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setFillsViewportHeight(true);
		table.setGridColor(Color.LIGHT_GRAY);		
		table.setSelectionBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE));
		table.setSelectionForeground(Color.BLACK);
		table.setFocusable(false);	    
		table.setRowHeight(23);
		
		headerPane.setPreferredSize(new Dimension(10, 60));		
		setLayout(new BorderLayout(0,0));		
		add(headerPane, BorderLayout.NORTH);
		textPane.setEditable(false);
		textPane.setMargin(new Insets(10, 10, 5, 3));
		textPane.setPreferredSize(new Dimension(6, 50));
		textPane.setBackground(UIManager.getColor("Panel.background"));		
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		btnAdd = new JButton();
		panel.add(btnAdd);
		btnAdd.setPreferredSize(new Dimension(33, 30));
		btnAdd.setFocusable(false);
		btnAdd.setToolTipText("Add new mapping");
		btnAdd.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_ADD));
		btnDelete = new JButton();
		panel.add(btnDelete);
		btnDelete.setPreferredSize(new Dimension(33, 30));
		btnDelete.setFocusable(false);
		btnDelete.setToolTipText("Delete selected mapping");
		btnDelete.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_DELETE));		
		btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteMapping(arg0);
			}
		});
		btnAdd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!tableModel.hasNullEntry()) addMapping(arg0);
				else{
					JOptionPane.showMessageDialog(null,"Please, fill the <no value> cells before moving on.",
					"Invalid Entry", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		headerPane.setLayout(new BorderLayout(0, 0));
		headerPane.add(panel, BorderLayout.EAST);
		headerPane.add(textPane, BorderLayout.CENTER);
		add(scrollpane, BorderLayout.CENTER);
	}
	
	protected TableCellEditor createEditor(Object[] objects, boolean isEditable) {
        @SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox combo = new JComboBox(objects) {
        	private static final long serialVersionUID = 1L;			
			@Override
			protected boolean processKeyBinding(KeyStroke ks, KeyEvent e, int condition, boolean pressed){
				boolean retValue = super.processKeyBinding(ks, e, condition,pressed);
                if (!retValue && isStartingCellEdit() && editor != null) {
                    editor.setItem(String.valueOf(ks.getKeyChar()));
                }
                return retValue;
			}			
            private boolean isStartingCellEdit(){
                JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, this);
                return table != null && table.isFocusOwner() && !Boolean.FALSE.equals((Boolean)table.getClientProperty("JTable.autoStartsEdit"));
            }
        };        
        combo.setEditable(isEditable);
        return new DefaultCellEditor(combo);
    }
	
	protected JButton addButton(String toolTipText, IconType iconType) {
		JButton newBtn = new JButton();
		panel.add(newBtn);
		newBtn.setPreferredSize(new Dimension(33, 30));
		newBtn.setFocusable(false);
		newBtn.setToolTipText(toolTipText);
		newBtn.setIcon(IconMap.getInstance().getIcon(iconType));
		
		return newBtn;
	}
}
