package net.menthor.editor.v2.ui;

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

public class BaseTableModel extends AbstractTableModel 
{
	private static final long serialVersionUID = 1L;
	
	private String[] columnNames={};
    private Object[][] data = {};
    
	public BaseTableModel(String[] columnNames, Object[][] data){
		this.columnNames=columnNames;
		this.data=data;
	}
	
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
    	return false;        
    }

    public void setValueAt(Object value, int row, int col){ 
        data[row][col] = value;
        fireTableCellUpdated(row, col); 
    }

	public String getDataAsString(){
        int numRows = getRowCount();
        int numCols = getColumnCount();
        String result = new String();        
        for (int i=0; i < numRows; i++){            	
            for (int j=0; j < numCols; j++){                	
            	if(j>0){                		
            		String elem = (String)data[i][j];
            		result += "  " + elem.trim()+"\n";                		
            	}else if (j==0){
            		String title = (String)data[i][j];                		
            		if(!title.trim().isEmpty()){
            			result += "  "+"\n"+title+"\n\n";
            		}else{
            			result += "\n";
            		}
            	}
            }                
        }
        return result;
    }
}