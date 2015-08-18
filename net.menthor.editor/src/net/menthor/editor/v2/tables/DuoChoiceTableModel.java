package net.menthor.editor.v2.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DuoChoiceTableModel extends DuoTableModel{
	
	private static final long serialVersionUID = 156864519388945910L;
	
	private List<Boolean> choiceOptions = new ArrayList<Boolean>();
	
	//==========================================================
	//CONSTRUCTOR
	//==========================================================
	
	public DuoChoiceTableModel(String elementColumnTitle, String targetColumnTitle, String choiceColumnTitle) {
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
		}else{
			JOptionPane.showMessageDialog(null,"Please, fulfill the \"<no value>\" cells in the table \nbefore adding a new entry.",
			"Empty cells", JOptionPane.INFORMATION_MESSAGE);			
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
					if(choiceOption==null) return "false";					
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
				choiceOptions.set(rowIndex, Boolean.parseBoolean((String)value));
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
