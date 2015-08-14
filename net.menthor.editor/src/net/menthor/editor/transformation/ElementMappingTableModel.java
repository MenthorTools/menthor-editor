package net.menthor.editor.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import net.menthor.editor.dialog.properties.BaseTableModel;
import RefOntoUML.util.RefOntoUMLElement;

public class ElementMappingTableModel extends BaseTableModel {
	
	private static final long serialVersionUID = 156864519388945910L;
	private List<RefOntoUMLElement> sourceList = new ArrayList<RefOntoUMLElement>(); 
	private List<Object> targetList = new ArrayList<Object>();
	
	public ElementMappingTableModel(String elementColumnTitle, String targetColumnTitle)
	{
		super(new String[]{elementColumnTitle, targetColumnTitle});
	}

	public HashMap<RefOntoUMLElement, Object> getEntries() throws Exception
	{
		HashMap<RefOntoUMLElement,Object> map = new HashMap<RefOntoUMLElement,Object>();
		
		
		for(int i =0; i < sourceList.size(); i++)
		{
			//look if exist null entries 
			if(sourceList.get(i) == null || targetList.get(i) == null){
				JOptionPane.showMessageDialog(null,"You need to fill all mapping cells before to move on.","Wait...",JOptionPane.INFORMATION_MESSAGE);
				throw new Exception("The HashMap is not full filled. You need to fill all mapping cells before to move on.");
			}
			map.put(sourceList.get(i),targetList.get(i));
		}
		return map;
	}
	
	public Object getTargetPrimivive(RefOntoUMLElement srcPrimitive)
	{
		int idx = sourceList.indexOf(srcPrimitive);
		if(idx>=0) return targetList.get(idx);
		else return null;
	}

	public RefOntoUMLElement getSourcePrimivive(Object tgtPrimitive)
	{
		int idx = targetList.indexOf(tgtPrimitive);
		if(idx>=0) return sourceList.get(idx);
		else return null;
	}
	
	public void addEntry(RefOntoUMLElement sourcePrimitive, Object targetPrimitive)
	{
		int size = sourceList.size();
		if(!sourceList.contains(sourcePrimitive) && !targetList.contains(targetPrimitive)){
			sourceList.add(sourcePrimitive);
			targetList.add(targetPrimitive);			
			fireTableRowsInserted(size, size);
		}else{
			//if exist a cell with null (<<no value>>)
			JOptionPane.showMessageDialog(null,"You need to fill all cells before insert a new row.","Wait...",JOptionPane.INFORMATION_MESSAGE);			
		}
	}

	@Override
	public void addEntry(Object entry) 
	{
		
	}

	@Override
	public void addEmptyEntry() 
	{
		addEntry(null, null);
	}
	
	@Override
	public void removeEntryAt(int index) {
		sourceList.remove(index);
		targetList.remove(index);
		
		fireTableRowsDeleted(index, index);
	}
	
	@Override
	public void moveUpEntry(int index) {
		fireTableRowsUpdated(index-1, index);
	}

	@Override
	public void moveDownEntry(int index) {
		fireTableRowsUpdated(index+1, index);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		if(sourceList.size() > 0 && targetList.size()>0)
		{
			RefOntoUMLElement sourceValue = sourceList.get(rowIndex);
			Object targetValue = targetList.get(rowIndex);			
			switch(columnIndex) {
				case 0: {
					if(sourceValue==null) return "<no value>";
					return sourceValue;
				}
				case 1: 
				{
					if(targetValue==null) return "<no value>";
					return targetValue;
				}				
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
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
			for (RefOntoUMLElement existentValue : sourceList) {
				//if one of them is null, they are different
				if(existentValue == null && value != null || existentValue != null && value == null) continue; //they are different
				
				//if both are null or equal
				if((existentValue == null && value == null) || existentValue.equals(value)){
					JOptionPane.showMessageDialog(null,"A mapping for {" + value + "} already exist.","Wait...",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
			sourceList.set(rowIndex, (RefOntoUMLElement)value);
		} 
		if(columnIndex == 1){			 
			targetList.set(rowIndex, value);
		}		
		super.setValueAt(value, rowIndex, columnIndex);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Class<?> getColumnClass(int columnIndex) {
        if(sourceList.size() > 0 && targetList.size()>0)
		{
        	switch(columnIndex) {
				case 0: return RefOntoUMLElement.class;
				case 1: return Object.class;			
			}
		}
		return Object.class;
    }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) 
	{ 
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int getRowCount() {
		if(sourceList == null){
			return 0;
		}else{
			return sourceList.size();
		}		 
	}

	/**
	 * {@inheritDoc}
	 */
	public int getColumnCount() { return columns.length; }
}
