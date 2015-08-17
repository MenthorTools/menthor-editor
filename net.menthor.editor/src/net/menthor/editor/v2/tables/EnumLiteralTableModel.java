package net.menthor.editor.v2.tables;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import RefOntoUML.Classifier;
import RefOntoUML.Enumeration;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.impl.EnumerationImpl;
import RefOntoUML.util.RefOntoUMLFactoryUtil;

/**
 * This class implements a BaseTableModel for class RefOntoUML.Proprties
 * 
 * @author John Guerson
 */
public class EnumLiteralTableModel extends BaseTableModel {
	
	private static final long serialVersionUID = 156864519388945910L;
	private EList<EnumerationLiteral> literals = new BasicEList<EnumerationLiteral>();
		
	public EnumLiteralTableModel(Classifier owner)
	{
		super(new String[]{"Name"});
		
		if(owner instanceof EnumerationImpl) literals.addAll(((Enumeration) owner).getOwnedLiteral());
		else literals.addAll(((RefOntoUML.Enumeration)owner).getOwnedLiteral());
	}

	public EList<EnumerationLiteral> getEntries()
	{
		return literals;
	}
	
	public EnumerationLiteral getEntry(int index)
	{
		return literals.get(index);
	}
	
	public EnumerationLiteral getEntry(EnumerationLiteral literal)
	{
		for(EnumerationLiteral p: literals)
		{
			if (p.equals(literal))
				return p;
		}
		return null;
	}
	
	/**
	 * Adds an entry (item) to the model.
	 * @param entry the entry to add
	 */
	public void addEntry(Object entry)
	{
		int size = literals.size();
		if(!literals.contains((EnumerationLiteral)entry)){
			literals.add((EnumerationLiteral) entry);			
			fireTableRowsInserted(size, size);
		}
	}

	@Override
	public void moveUpEntry(int index) {
		literals.move(index-1, index);
		fireTableRowsUpdated(index-1, index);
	}

	@Override
	public void moveDownEntry(int index) {
		literals.move(index+1, index);
		fireTableRowsUpdated(index+1, index);
	}

	@Override
	public void removeEntryAt(int index) {
		literals.remove(index);
		fireTableRowsDeleted(index, index);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addEmptyEntry() {
		EnumerationLiteral literal = RefOntoUMLFactoryUtil.factory.createEnumerationLiteral();
		literal.setName("");				
		addEntry(literal);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(literals.size() > 0)
		{
			EnumerationLiteral literal = (EnumerationLiteral)literals.get(rowIndex);		
						 
			switch(columnIndex) {
				case 0: return literal.getName();
				case 1: 
				{
					
				}
				case 2: {
					
				}
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Class<?> getColumnClass(int columnIndex) {
        if(literals.size() > 0)
		{
        	switch(columnIndex) {
				case 0: return String.class;
				case 1: 
				case 2: 
			}
		}
		return Object.class;
    }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		EnumerationLiteral literal = (EnumerationLiteral) literals.get(rowIndex);
		if(columnIndex == 0) {
			literal.setName((String) value);
		} 
		if(columnIndex == 1){			 
			
		}
		if(columnIndex == 2){
			
		}
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
	public int getRowCount() { return literals.size(); }

	/**
	 * {@inheritDoc}
	 */
	public int getColumnCount() { return columns.length; }

}
