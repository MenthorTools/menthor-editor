package net.menthor.editor.v2.tables;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.types.ColorMap;
import net.menthor.editor.v2.types.ColorType;
import RefOntoUML.parser.OntoUMLParser;

public class BaseTablePane extends JPanel {
	
	private static final long serialVersionUID = -7587547341203464118L;

	protected BaseTableModel tableModel;
	protected JScrollPane scrollpane = new JScrollPane();
	protected JTable table;	
	protected JPanel headerPane = new JPanel();
	protected JButton btnAdd;
	protected JButton btnDelete;
	protected JTextPane textPane = new JTextPane();
	
	public BaseTableModel getTableModel(){ return tableModel; }	
	public JPanel getHeaderPane() { return headerPane; }
	public void setText(String text) { textPane.setText(text); }
	
	public BaseTablePane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle, String choiceColumnTitle){
		tableModel = new ElementChoiceTableModel(sourceColumnTitle, targetColumnTitle, choiceColumnTitle);
		buildUI(refparser);
	}
	
	/** @wbp.parser.constructor */
	public BaseTablePane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle){
		tableModel = new DuoTableModel(sourceColumnTitle, targetColumnTitle);
		buildUI(refparser);
	}	
	
	public void addMapping(ActionEvent evt){
		tableModel.addEmptyEntry();		
	}
	
	public void refreshData(){
		tableModel.fireTableDataChanged();
	}
	
	public void deleteMapping(ActionEvent evt){
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
		btnAdd = new JButton();
		btnAdd.setPreferredSize(new Dimension(33, 30));
		btnAdd.setFocusable(false);
		btnAdd.setToolTipText("Add new mapping");
		btnAdd.setIcon(IconMap.getInstance().getSmallIcon(IconType.MENTHOR_ADD));
		btnAdd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addMapping(arg0);
			}
		});		
		btnDelete = new JButton();
		btnDelete.setPreferredSize(new Dimension(33, 30));
		btnDelete.setFocusable(false);
		btnDelete.setToolTipText("Delete selected mapping");
		btnDelete.setIcon(IconMap.getInstance().getSmallIcon(IconType.MENTHOR_DELETE));		
		btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteMapping(arg0);
			}
		});
		GroupLayout gl_headerPane = new GroupLayout(headerPane);
		gl_headerPane.setHorizontalGroup(
			gl_headerPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headerPane.createSequentialGroup()
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_headerPane.setVerticalGroup(
			gl_headerPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headerPane.createSequentialGroup()
					.addGroup(gl_headerPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_headerPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_headerPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDelete, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		headerPane.setLayout(gl_headerPane);
		add(scrollpane, BorderLayout.CENTER);
	}
		
	protected TableCellEditor createEditor(Object[] objects) {
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
        combo.setEditable(true);
        return new DefaultCellEditor(combo);
    }
}
