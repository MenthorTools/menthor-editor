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

import java.util.ArrayList;
import java.util.List;

public class MappingChoiceTableModel extends MappingTableModel{
	
	private static final long serialVersionUID = 156864519388945910L;
	
	private List<Boolean> choiceOptions = new ArrayList<Boolean>();
	
	//==========================================================
	//CONSTRUCTOR
	//==========================================================
	
	public MappingChoiceTableModel(String elementColumnTitle, String targetColumnTitle, String choiceColumnTitle) {
		super(new String[]{elementColumnTitle, targetColumnTitle, choiceColumnTitle});
	}
	
	//==========================================================
	// GETTERS AND SETTERS
	//==========================================================
	
	public Object[][] getEntriesAsMatrix(){
		Object[][] map = new Object[sourceList.size()][3];		
		for(int i =0; i < sourceList.size(); i++){
			map[i][0] = sourceList.get(i);
			map[i][1] = targetList.get(i);
			map[i][2] = choiceOptions.get(i);
		}
		return map;
	}
	
	public Boolean getChoice(Object source){
		int idx = sourceList.indexOf(source);
		if(idx>=0) return choiceOptions.get(idx);
		else return null;
	}

	//==========================================================
	//OVERRIDE: ENTRIES
	//==========================================================
	
	@Override
	public void addEmptyEntry(){
		addEntry(null, null, true);
	}

	public void addEntry(Object source, Object target, Boolean choice){
		int size = sourceList.size();
		if(!sourceList.contains(source) && !targetList.contains(target)){
			sourceList.add(source);
			targetList.add(target);		
			choiceOptions.add(choice);
			fireTableRowsInserted(size, size);
		}
	}
	
	@Override
	public void removeEntryAt(int index) {
		sourceList.remove(index);
		targetList.remove(index);
		choiceOptions.remove(index);
		fireTableRowsDeleted(index, index);
	}
		
	//==========================================================
	//OVERRIDE: VALUES
	//=========================================================
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex){		
		switch(columnIndex){
			case 0: {
				return super.getValueAt(rowIndex, columnIndex);
			}
			case 1: {
				return super.getValueAt(rowIndex, columnIndex);
			}	
			case 2: {
				if(choiceOptions.size()>0){
					Boolean choiceOption = choiceOptions.get(rowIndex);
					if(choiceOption==null) return false;					
					return choiceOption;
				}				
			}
		}
		return null;
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		switch(columnIndex){
			case 0: {
				super.setValueAt(value, rowIndex, columnIndex);
				break;
			}
			case 1: {
				super.setValueAt(value, rowIndex, columnIndex);
				break;
			}	
			case 2: {	
				choiceOptions.set(rowIndex, (Boolean)value);
				break;
			}
		}
	}
	
	//==========================================================
	//OVERRIDE: COLUMNS & ROWS
	//==========================================================

	@Override
	public Class<?> getColumnClass(int columnIndex) {        
    	switch(columnIndex) {
			case 0: return super.getColumnClass(columnIndex);
			case 1: return super.getColumnClass(columnIndex);
			case 2: {
				if(choiceOptions.size() > 0){
					return Boolean.class;
				}
			}
		}		
    	return Object.class;
    }	
}
