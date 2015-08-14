package net.menthor.editor.transformation;

import java.util.ArrayList;
import java.util.List;

import net.menthor.editor.dialog.properties.BaseTableModel;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.util.RefOntoUMLElement;

public class ChoiceElemMapTableModel extends BaseTableModel{
	private static final long serialVersionUID = 156864519388945910L;
	private List<RefOntoUMLElement> sourceList = new ArrayList<RefOntoUMLElement>(); 
	private List<Object> targetList = new ArrayList<Object>();
	private List<Boolean> choiceOptions = new ArrayList<Boolean>();
	
	public ChoiceElemMapTableModel(String elementColumnTitle, String targetColumnTitle, String choiceColumnTitle) {
		super(new String[]{elementColumnTitle, targetColumnTitle, choiceColumnTitle});
	}
	
	public Object[][] getEntries()
	{
		Object[][] map = new Object[sourceList.size()][3];
		
		for(int i =0; i < sourceList.size(); i++)
		{
			map[i][0] = sourceList.get(i);
			map[i][1] = targetList.get(i);
			map[i][2] = choiceOptions.get(i);
		}
		return map;
	}
	
	public Object getTargetPrimitive(RefOntoUMLElement srcGs)
	{
		int idx = sourceList.indexOf(srcGs);
		if(idx>=0) return targetList.get(idx);
		else return null;
	}

	public Boolean getTargetHideClass(RefOntoUMLElement srcGs)
	{
		int idx = sourceList.indexOf(srcGs);
		if(idx>=0) return choiceOptions.get(idx);
		else return null;
	}

	public void addEntry(RefOntoUMLElement sourcePrimitive, String targetPrimitive, Boolean choiceOption)
	{
		int size = sourceList.size();
		if(!sourceList.contains(sourcePrimitive) && !targetList.contains(targetPrimitive)){
			sourceList.add(sourcePrimitive);
			targetList.add(targetPrimitive);		
			choiceOptions.add(choiceOption);
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
		addEntry(null, null, true);
	}
	
	@Override
	public void removeEntryAt(int index) {
		sourceList.remove(index);
		targetList.remove(index);
		choiceOptions.remove(index);
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
		if(sourceList.size() > 0 && targetList.size()>0 && choiceOptions.size()>0)
		{
			RefOntoUMLElement sourceValue = sourceList.get(rowIndex);
			Object targetValue = targetList.get(rowIndex);
			Boolean choiceOption = choiceOptions.get(rowIndex);
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
				case 2: 
				{
					if(choiceOption==null) return "<no value>";
					return choiceOption;
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
		if(value instanceof String) value=null; 
		
		if(columnIndex == 0) {
			sourceList.set(rowIndex, (RefOntoUMLElement)value);
		} 
		if(columnIndex == 1){			 
			targetList.set(rowIndex, (Object)value);
		}		
		if(columnIndex == 2){			 
			choiceOptions.set(rowIndex, (Boolean)value);
		}		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Class<?> getColumnClass(int columnIndex) {
        if(sourceList.size() > 0 && targetList.size()>0)
		{
        	switch(columnIndex) {
				case 0: return EObject.class;
				case 1: return Object.class;	
				case 2: return Boolean.class;
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
