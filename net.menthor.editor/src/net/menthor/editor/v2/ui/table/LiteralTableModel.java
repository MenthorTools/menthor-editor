package net.menthor.editor.v2.ui.table;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import RefOntoUML.Classifier;
import RefOntoUML.Enumeration;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.impl.EnumerationImpl;
import RefOntoUML.util.RefOntoUMLFactoryUtil;

public class LiteralTableModel extends GenericTableModel {
	
	private static final long serialVersionUID = 156864519388945910L;
	
	private EList<EnumerationLiteral> literals = new BasicEList<EnumerationLiteral>();
		
	//==========================================================
	//CONSTRUCTOR
	//==========================================================
		
	public LiteralTableModel(Classifier owner){
		super(new String[]{"Name"});		
		if(owner instanceof EnumerationImpl) literals.addAll(((Enumeration) owner).getOwnedLiteral());
		else literals.addAll(((RefOntoUML.Enumeration)owner).getOwnedLiteral());
	}

	//==========================================================
	// GETTERS AND SETTERS
	//==========================================================
	
	public EList<EnumerationLiteral> getEntries(){
		return literals;
	}
	
	public EnumerationLiteral getEntry(int index){
		return literals.get(index);
	}
	
	public EnumerationLiteral getEntry(EnumerationLiteral literal){
		for(EnumerationLiteral p: literals){
			if (p.equals(literal))
				return p;
		}
		return null;
	}
	
	//==========================================================
	// OVERRIDE: ENTRIES
	//==========================================================
	
	public void addEntry(Object entry){
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
	
	@Override
	public void addEmptyEntry() {
		EnumerationLiteral literal = RefOntoUMLFactoryUtil.factory.createEnumerationLiteral();
		literal.setName("");				
		addEntry(literal);
	}

	@Override
	public boolean hasNullEntry() {
		for(EnumerationLiteral el: literals){
			if(el==null) return true;
		}	
		return false;
	}
	
	//==========================================================
	// OVERRIDE: VALUE
	//==========================================================
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(literals.size() > 0){
			EnumerationLiteral literal = (EnumerationLiteral)literals.get(rowIndex);
			switch(columnIndex) {
				case 0: return literal.getName();
			}
		}
		return null;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		EnumerationLiteral literal = (EnumerationLiteral) literals.get(rowIndex);
		if(columnIndex == 0) {
			literal.setName((String) value);
		}
	}
	
	//==========================================================
	// OVERRIDE: COLUMNS & ROWS
	//==========================================================
	
	public Class<?> getColumnClass(int columnIndex){
        if(literals.size() > 0){
        	switch(columnIndex){
				case 0: return String.class;				
			}
		}
		return Object.class;
    }

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){ 
		return true;
	}
	
	public int getRowCount() { return literals.size(); }
}
