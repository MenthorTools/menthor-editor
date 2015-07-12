package net.menthor.editor.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

	public HashMap<RefOntoUMLElement, Object> getEntries()
	{
		HashMap<RefOntoUMLElement,Object> map = new HashMap<RefOntoUMLElement,Object>();
		int i =0;
		for(RefOntoUMLElement src: sourceList)
		{
			map.put(src,targetList.get(i));
			i++;
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
		if(columnIndex == 0) {
			sourceList.set(rowIndex, (RefOntoUMLElement)value);
		} 
		if(columnIndex == 1){			 
			targetList.set(rowIndex, value);
		}		
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
	public int getRowCount() { return sourceList.size(); }

	/**
	 * {@inheritDoc}
	 */
	public int getColumnCount() { return columns.length; }
}
