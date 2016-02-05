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

import javax.swing.table.AbstractTableModel;

public class StatisticsTableModel extends AbstractTableModel 
{
	private static final long serialVersionUID = 1L;
	
	public StatisticsTableModel(String[] columnNames, Object[][] data){
		this.columnNames=columnNames;
		this.data=data;
	}
	
	private String[] columnNames = {"Measure", "Count", "Type Percentage", "Total Percentage"};
    private Object[][] data = {};

    public int getColumnCount() { return columnNames.length; }
    public int getRowCount() { return data.length; }
    public String getColumnName(int col) {  return columnNames[col]; }

    public Object getValueAt(int row, int col) { return data[row][col]; }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box. */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) { return getValueAt(0, c).getClass(); }

    /* Don't need to implement this method unless your table's editable. */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 5) return false;
        else return true;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change. */
    public void setValueAt(Object value, int row, int col) { 
        data[row][col] = value;
        fireTableCellUpdated(row, col); 
    }
}