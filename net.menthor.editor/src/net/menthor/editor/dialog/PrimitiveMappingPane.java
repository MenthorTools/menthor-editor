package net.menthor.editor.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import net.menthor.editor.dialog.properties.AttributesEditionPanel;
import net.menthor.editor.palette.ColorPalette;
import net.menthor.editor.palette.ColorPalette.ThemeColor;
import RefOntoUML.PrimitiveType;
import RefOntoUML.parser.OntoUMLParser;

public class PrimitiveMappingPane extends JPanel {
	
	private static final long serialVersionUID = -7587547341203464118L;

	private JScrollPane scrollpane = new JScrollPane();
	private JTable table = new JTable();
	private PrimitiveMappingTableModel tableModel;

	private JPanel headerPane;

	private JButton btnAdd;

	private JButton btnDelete;
	
	public PrimitiveMappingPane(String sourceLanguage, OntoUMLParser refparser, String targetLanguage, String[] targetPrimitiveOptions)
	{
		tableModel = new PrimitiveMappingTableModel(sourceLanguage, targetLanguage);
				
		scrollpane.setMinimumSize(new Dimension(0, 0));
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				
		scrollpane.setViewportView(table);
		table.setModel(tableModel);
		
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setFillsViewportHeight(true);
		table.setGridColor(Color.LIGHT_GRAY);		
		table.setSelectionBackground(ColorPalette.getInstance().getColor(ThemeColor.BLUE_MEDIUM));
		table.setSelectionForeground(Color.BLACK);
		table.setFocusable(false);	    
		table.setRowHeight(23);		
		
		setLayout(new BorderLayout(0,0));
		add(scrollpane, BorderLayout.CENTER);
		
		headerPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) headerPane.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(headerPane, BorderLayout.NORTH);
		
		btnAdd = new JButton("");
		btnAdd.setFocusable(false);
		btnAdd.setToolTipText("Add new primitive type mapping");
		//btnAdd.setText("Add");
		btnAdd.setIcon(new ImageIcon(AttributesEditionPanel.class.getResource("/resources/icons/x16/new.png")));
		btnAdd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addMapping(arg0);
			}
		});
		headerPane.add(btnAdd);
		
		btnDelete = new JButton("");
		btnDelete.setFocusable(false);
		btnDelete.setToolTipText("Delete selected primitive type mapping");
		//btnDelete.setText("Delete");
		btnDelete.setIcon(new ImageIcon(AttributesEditionPanel.class.getResource("/resources/icons/x16/cross.png")));
		btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteMapping(arg0);
			}
		});
		headerPane.add(btnDelete);
		
		List<String> sourcePrimitiveOptions = new ArrayList<String>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(PrimitiveType pt: refparser.getAllInstances(PrimitiveType.class))
		{
			sourcePrimitiveOptions.add(pt.getName());	
		}
		Collections.sort(sourcePrimitiveOptions);
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));

		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
		typeColumn2.setCellEditor(createEditor(targetPrimitiveOptions));
		
		table.setSurrendersFocusOnKeystroke(true);
	}
	
	public PrimitiveMappingTableModel getTableModel() { return tableModel; }
	
	protected void deleteMapping(ActionEvent evt) 
	{
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0 && selectedRow < tableModel.getRowCount()) 
		{
			tableModel.removeEntryAt(selectedRow);
		}
	}
	
	protected void addMapping(ActionEvent evt) 
	{
		tableModel.addEmptyEntry();		
	}
	
	public void refreshData()
	{
		tableModel.fireTableDataChanged();
	}
	
	private TableCellEditor createEditor(Object[] objects) 
	{
        @SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox combo = new JComboBox(objects) {
        	private static final long serialVersionUID = 1L;			
			@Override
			protected boolean processKeyBinding(KeyStroke ks, KeyEvent e, int condition, boolean pressed) 
			{
				boolean retValue = super.processKeyBinding(ks, e, condition,pressed);
                if (!retValue && isStartingCellEdit() && editor != null) {
                    // this is where the magic happens
                    // not quite right; sets the value, but doesn't advance the
                    // cursor position for AC
                    editor.setItem(String.valueOf(ks.getKeyChar()));
                }
                return retValue;
			}			
            private boolean isStartingCellEdit() 
            {
                JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, this);
                return table != null && table.isFocusOwner() && !Boolean.FALSE.equals((Boolean)table.getClientProperty("JTable.autoStartsEdit"));
            }
        };        
        //AutoCompleteDecorator.decorate(combo);
        combo.setEditable(true);
        return new DefaultCellEditor(combo);
    }
}
