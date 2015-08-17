package net.menthor.editor.v2.tables;

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

public abstract class BaseTableModel extends AbstractTableModel 
{
	private static final long serialVersionUID = 1L;
	
	protected String[] columns={};
	    
	public BaseTableModel(String[] columnNames){
		this.columns=columnNames;
	}
	
	public abstract void addEntry(Object entry);	
	public abstract void addEmptyEntry();	
	public abstract Object getEntries() throws Exception;	
	public abstract void moveUpEntry(int index);	
	public abstract void moveDownEntry(int index);	
	public abstract void removeEntryAt(int index);
	public abstract int getRowCount();
	public abstract Object getValueAt(int row, int col);
	
	public int getColumnCount(){
        return columns.length;
    }
    
    public String getColumnName(int col){
        return columns[col];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c){
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col){        
    	return false;        
    }
}