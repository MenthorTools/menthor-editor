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

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * This class implements a BaseTableModel for class proprties, at the moment
 * it simply holds strings.
 */
public class StringTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 156864519388945910L;
	
	private List<String> entries = new LinkedList<String>();

	public void addEntry(String entry) {
		int size = entries.size();
		entries.add(entry);
		fireTableRowsInserted(size, size);
	}

	public void removeEntryAt(int index) {
		entries.remove(index);
		fireTableRowsDeleted(index, index);
	}
	
	public void moveUpEntry(int index) {
		String entry = entries.remove(index);
		entries.add(index - 1, entry);
		fireTableDataChanged();
	}

	public void moveDownEntry(int index) {
		String entry = entries.remove(index);
		entries.add(index + 1, entry);
		fireTableDataChanged();
	}

	public List<String> getEntries() { return entries; }	
	public int getRowCount() { return entries.size(); }
	public int getColumnCount() { return 1; }	
	public Object getValueAt(int rowIndex, int columnIndex) { return entries.get(rowIndex); }
	
	@Override
	public String getColumnName(int columnIndex) { return null; }	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) { return true; }
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) { entries.set(rowIndex, value.toString()); }	
}
