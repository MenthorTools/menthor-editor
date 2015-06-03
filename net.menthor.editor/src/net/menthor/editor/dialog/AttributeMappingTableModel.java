package net.menthor.editor.dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.menthor.editor.dialog.properties.BaseTableModel;
import RefOntoUML.Property;

public class AttributeMappingTableModel extends BaseTableModel {
	
	private static final long serialVersionUID = 156864519388945910L;
	private List<Property> sourceList = new ArrayList<Property>(); 
	private List<String> targetList = new ArrayList<String>();
	
	public AttributeMappingTableModel(String sourceLanguage, String targetLanguage)
	{
		super(new String[]{"Attribute", targetLanguage});
	}
	
	public String getTargetPrimivive(Property srcPrimitive)
	{
		int idx = sourceList.indexOf(srcPrimitive);
		if(idx>=0) return targetList.get(idx);
		else return null;
	}

	public Property getSourceAttribute(String tgtPrimitive)
	{
		int idx = targetList.indexOf(tgtPrimitive);
		if(idx>=0) return sourceList.get(idx);
		else return null;
	}
	
	public HashMap<Property, String> getEntries()
	{
		HashMap<Property,String> map = new HashMap<Property,String>();
		int i =0;
		for(Property src: sourceList)
		{
			map.put(src,targetList.get(i));
			i++;
		}
		return map;
	}
	
	public void addEntry(Property sourcePrimitive, String targetPrimitive)
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
			Property sourceValue = sourceList.get(rowIndex);
			String targetValue = targetList.get(rowIndex);			
			switch(columnIndex) {
				case 0: {
					if(sourceValue==null) return "<no value>";
					return sourceValue.getName()+": "+sourceValue.getType().getName();
				}
				case 1: 
				{
					if(targetValue==null || targetValue.isEmpty()) return "<no value>";
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
			sourceList.set(rowIndex, (Property)value);
		} 
		if(columnIndex == 1){			 
			targetList.set(rowIndex, (String)value);
		}		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Class<?> getColumnClass(int columnIndex) {
        if(sourceList.size() > 0 && targetList.size()>0)
		{
        	switch(columnIndex) {
				case 0: return String.class;
				case 1: return String.class;			
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

