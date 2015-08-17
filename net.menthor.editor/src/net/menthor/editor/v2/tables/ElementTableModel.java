package net.menthor.editor.v2.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public class ElementTableModel extends BaseTableModel {
	
	private static final long serialVersionUID = 156864519388945910L;
	
	private List<RefOntoUML.Element> sourceList = new ArrayList<RefOntoUML.Element>(); 
	private List<Object> targetList = new ArrayList<Object>();
	
	//==========================================================
	//CONSTRUCTOR
	//==========================================================
	
	public ElementTableModel(String elementColumnTitle, String targetColumnTitle){
		super(new String[]{elementColumnTitle, targetColumnTitle});
	}

	//==========================================================
	// GETTERS AND SETTERS
	//==========================================================
	
	public Object getTarget(RefOntoUML.Element elem){
		int idx = sourceList.indexOf(elem);
		if(idx>=0) return targetList.get(idx);
		else return null;
	}

	public RefOntoUML.Element getElement(Object target){
		int idx = targetList.indexOf(target);
		if(idx>=0) return sourceList.get(idx);
		else return null;
	}
	
	//==========================================================
	//ENTRIES
	//==========================================================
	
	public void addEntry(RefOntoUML.Element elem, Object target)	{
		int size = sourceList.size();
		if(!sourceList.contains(elem) && !targetList.contains(target)){
			sourceList.add(elem);
			targetList.add(target);			
			fireTableRowsInserted(size, size);
		}else{
			//if exist a cell with null (<<no value>>)
			JOptionPane.showMessageDialog(null,"You need to fill all cells before insert a new row.","Wait...",JOptionPane.INFORMATION_MESSAGE);			
		}
	}

	@Override
	public void addEntry(Object entry){ 
		
	}

	@Override
	public void addEmptyEntry() { 
		addEntry(null, null);
	}
	
	@Override
	public void removeEntryAt(int index) {
		sourceList.remove(index);
		targetList.remove(index);		
		fireTableRowsDeleted(index, index);
	}
	
	public HashMap<RefOntoUML.Element, Object> getEntries() throws Exception{
		HashMap<RefOntoUML.Element,Object> map = new HashMap<RefOntoUML.Element,Object>();		
		for(int i =0; i < sourceList.size(); i++){
			//look if exist null entries 
			if(sourceList.get(i) == null || targetList.get(i) == null){
				JOptionPane.showMessageDialog(null,"You need to fill the remaining cells before moving on.","Wait...",JOptionPane.INFORMATION_MESSAGE);
				throw new Exception("The table is not completely filled. You need to fill the remaining cells before moving on.");
			}
			map.put(sourceList.get(i),targetList.get(i));
		}
		return map;
	}
	
	@Override
	public void moveUpEntry(int index) {
		fireTableRowsUpdated(index-1, index);
	}

	@Override
	public void moveDownEntry(int index) {
		fireTableRowsUpdated(index+1, index);
	}
	
	//==========================================================
	//BASE TABLE MODEL
	//==========================================================
	
	public Object getValueAt(int rowIndex, int columnIndex){
		if(sourceList.size() > 0 && targetList.size()>0){
			RefOntoUML.Element sourceValue = sourceList.get(rowIndex);
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
		//if value contais a String (<<no value>>), it is replaced by null
		if(value instanceof String) value=null; 		
		//look for the previous value of the cell
		Object previousValue;
		if(columnIndex == 0){
			previousValue = sourceList.get(rowIndex);
		}else{
			previousValue = targetList.get(rowIndex);
		}
		
		//check if the value changed
		if(previousValue == null && value == null || previousValue != null && value != null && previousValue.equals(value)) return;//no changes
		
		if(columnIndex == 0) {
			//look for all source elements and check if the actual value is already there
			for (RefOntoUML.Element existentValue : sourceList) {
				//if one of them is null, they are different
				if(existentValue == null && value != null || existentValue != null && value == null) continue; //they are different
				
				//if both are null or equal
				if((existentValue == null && value == null) || existentValue.equals(value)){
					JOptionPane.showMessageDialog(null,"A mapping for {" + value + "} already exist.","Wait...",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
			sourceList.set(rowIndex, (RefOntoUML.Element)value);
		} 
		if(columnIndex == 1){			 
			targetList.set(rowIndex, value);
		}		
		super.setValueAt(value, rowIndex, columnIndex);
	}
	
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
        if(sourceList.size() > 0 && targetList.size()>0){
        	switch(columnIndex) {
				case 0: return RefOntoUML.Element.class;
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
	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		if(sourceList == null){
			return 0;
		}else{
			return sourceList.size();
		}		 
	}
	
	@Override
	public int getColumnCount() { 
		return columns.length; 
	}
}
