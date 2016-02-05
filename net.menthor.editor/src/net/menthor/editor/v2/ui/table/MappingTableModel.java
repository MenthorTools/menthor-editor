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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class MappingTableModel extends GenericTableModel {

	private static final long serialVersionUID = -8283265869688835740L;
	
	protected List<Object> sourceList = new ArrayList<Object>(); 
	protected List<Object> targetList = new ArrayList<Object>();
	
	//==========================================================
	//CONSTRUCTOR
	//==========================================================
	
	public MappingTableModel(String firstColTitle, String secondColTitle){
		super(new String[]{firstColTitle, secondColTitle});
	}

	public MappingTableModel(String[] columns) {
		super(columns);
	}
	
	//==========================================================
	// GETTERS AND SETTERS
	//==========================================================
	
	public Object getTarget(Object elem){
		int idx = sourceList.indexOf(elem);
		if(idx>=0) return targetList.get(idx);
		else return null;
	}

	public Object getSource(Object target){
		int idx = targetList.indexOf(target);
		if(idx>=0) return sourceList.get(idx);
		else return null;
	}
		
	public Map<Object, Object> getEntries() throws Exception{
		Map<Object,Object> map = new HashMap<Object,Object>();		
		for(int i =0; i < sourceList.size(); i++){
			map.put(sourceList.get(i),targetList.get(i));			
		}
		return map;
	}
	
	//==========================================================
	//OVERRIDE: ENTRIES
	//==========================================================
	
	@Override
	public void addEmptyEntry() {
		addEntry(null, null);
		super.addEmptyEntry();
	}
	
	@Override
	public void removeEntryAt(int index) {
		sourceList.remove(index);
		targetList.remove(index);		
		super.removeEntryAt(index);
	}
	
	public void addEntry(Object elem, Object target){		
		if(!sourceList.contains(elem)){
			int size = sourceList.size();
			sourceList.add(elem);
			targetList.add(target);			
			fireTableRowsInserted(size, size);
		}
	}
	
	public boolean hasNullEntry(){
		for(int i =0; i < sourceList.size(); i++){	
			if(sourceList.get(i) == null || targetList.get(i) == null){
				return true;
			}		
		}		
		return false;
	}
	
	//==========================================================
	//OVERRIDE: VALUES
	//=========================================================
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex){
		if(sourceList.size() > 0 && targetList.size()>0){
			Object sourceValue = sourceList.get(rowIndex);
			Object targetValue = targetList.get(rowIndex);			
			switch(columnIndex){
				case 0: {
					if(sourceValue==null) return "<no value>";
					return sourceValue;
				}
				case 1: {
					if(targetValue==null) return "<no value>";
					return targetValue;
				}				
			}
		}
		return null;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {		
		if(columnIndex == 0){
			int indexOf = sourceList.indexOf(value);
			if(indexOf != -1 && indexOf!= rowIndex){
				JOptionPane.showMessageDialog(null,"" + value + " was already mappped. \nPlease, choose a different element.",
				"Invalid Entry",JOptionPane.ERROR_MESSAGE);
				return;
			}else{
				sourceList.set(rowIndex, value);	
			}
		}
		if(columnIndex == 1){			 
			targetList.set(rowIndex, value);
		}		
		super.setValueAt(value, rowIndex, columnIndex);
	}
	
	//==========================================================
	//OVERRIDE: COLUMNS & ROWS
	//==========================================================
			
	@Override
	public Class<?> getColumnClass(int columnIndex) {
        if(sourceList.size() > 0 && targetList.size()>0){
        	switch(columnIndex) {
				case 0: return Object.class;
				case 1: return Object.class;			
			}
		}
		return Object.class;
    }
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){ 
		return true;
	}
	
	@Override
	public int getRowCount() {
		if(sourceList == null) return 0;
		else return sourceList.size();	 
	}	
}
