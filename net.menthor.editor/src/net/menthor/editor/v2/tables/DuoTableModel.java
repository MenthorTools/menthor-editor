package net.menthor.editor.v2.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public class DuoTableModel extends BaseTableModel {

	private static final long serialVersionUID = -8283265869688835740L;
	
	private List<Object> sourceList = new ArrayList<Object>(); 
	private List<Object> targetList = new ArrayList<Object>();
	
	//==========================================================
	//CONSTRUCTOR
	//==========================================================
	
	public DuoTableModel(String firstColTitle, String secondColTitle){
		super(new String[]{firstColTitle, secondColTitle});
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
		int size = sourceList.size();
		if(!sourceList.contains(elem) && !targetList.contains(target)){
			sourceList.add(elem);
			targetList.add(target);			
			fireTableRowsInserted(size, size);
		}else{
			//if exists a cell with null value(<no value>)...
			JOptionPane.showMessageDialog(null,"You need to fill all cells before insert a new row.",
			"Wait...", JOptionPane.INFORMATION_MESSAGE);			
		}
	}
	
	public HashMap<Object, Object> getEntries() throws Exception{
		HashMap<Object,Object> map = new HashMap<Object,Object>();		
		for(int i =0; i < sourceList.size(); i++){
			//look if exists null entries...
			if(sourceList.get(i) == null || targetList.get(i) == null){
				JOptionPane.showMessageDialog(null,"You need to fill the remaining cells before moving on.",
				"Wait...", JOptionPane.INFORMATION_MESSAGE);
				throw new Exception("The table is not completely filled. You need to fill the remaining cells before moving on.");
			}
			map.put(sourceList.get(i),targetList.get(i));
		}
		return map;
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
		//if value contains a String (<no value>), it is replaced by null
		if(value instanceof String) value=null; 		
		//looks for previous value of the cell
		Object previousValue;
		if(columnIndex == 0){
			previousValue = sourceList.get(rowIndex);
		}else{
			previousValue = targetList.get(rowIndex);
		}		
		//check if the value has changed
		if(previousValue == null && value == null || previousValue != null && value != null && previousValue.equals(value)) 
			return;		
		if(columnIndex == 0) {
			//look for all source elements and check if the actual value is already there
			for (Object existentValue : sourceList) {
				//if one of them is null, they are different
				if(existentValue == null && value != null || existentValue != null && value == null) 
					continue; //they are different				
				//if both are null or equal
				if((existentValue == null && value == null) || existentValue.equals(value)){
					JOptionPane.showMessageDialog(null,"A mapping for {" + value + "} already exists.",
					"Wait...",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
			sourceList.set(rowIndex, value);
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
