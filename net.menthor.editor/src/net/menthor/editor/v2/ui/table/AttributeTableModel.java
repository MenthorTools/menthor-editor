
package net.menthor.editor.v2.ui.table;

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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.Property;
import RefOntoUML.impl.DataTypeImpl;
import RefOntoUML.util.RefOntoUMLFactoryUtil;

public class AttributeTableModel extends GenericTableModel {
	
	private static final long serialVersionUID = 156864519388945910L;
	
	private EList<Property> attributes = new BasicEList<Property>();
	private List<DataType> datatypes = new ArrayList<DataType>();

	private Classifier owner;
	
	//==========================================================
	//CONSTRUCTOR
	//==========================================================
	
	public AttributeTableModel(Classifier owner){
		super(new String[]{"Name", "Type", "Multiplicity"});		
		
		this.owner = owner;
		
		if(owner instanceof DataTypeImpl) {
			attributes.addAll(((DataType) owner).getOwnedAttribute());
		}
		else {
			attributes.addAll(((RefOntoUML.Class) owner).getOwnedAttribute());
		}
	}
	
	//==========================================================
	// GETTERS AND SETTERS
	//==========================================================

	public void setDataTypes(Collection<DataType> dataTypes){
		this.datatypes.clear();
		this.datatypes.addAll(dataTypes);
	}
	
	public EList<Property> getEntries(){ 
		return attributes; 
	}
	
	public EList<Property> getValidEntries() {
		EList<Property> validAttributes = new BasicEList<Property>();
		for (Property attribute : attributes) {
			if(attribute.getType()!=null){
				validAttributes.add(attribute);
			}
		}
		return validAttributes;
	}
	
	public Property getEntry(int index) { 
		return attributes.get(index); 
	}
	
	public Property getEntry(Property property){
		for(Property p: attributes){
			if (p.equals(property))
				return p;
		}
		return null;
	}
	
	//==========================================================
	//OVERRIDE: ENTRIES
	//==========================================================
	
	public void addEntry(Object entry){
		int size = attributes.size();
		if(!attributes.contains((Property)entry)){
			attributes.add((Property) entry);			
			fireTableRowsInserted(size, size);
		}
	}

	@Override
	public boolean hasNullEntry() {
		for(Property p: attributes){
			if(p==null) return true;
		}
		return false;
	}
	
	@Override
	public void moveUpEntry(int index) {
		attributes.move(index-1, index);
		fireTableRowsUpdated(index-1, index);
	}

	@Override
	public void moveDownEntry(int index) {
		attributes.move(index+1, index);
		fireTableRowsUpdated(index+1, index);
	}

	@Override
	public void removeEntryAt(int index) {
		attributes.remove(index);
		fireTableRowsDeleted(index, index);
	}
	
	@Override
	public void addEmptyEntry() {
		Property property = RefOntoUMLFactoryUtil.factory.createProperty();
		
		addAttribute(property);
		
		property.setType(null);
		property.setName("");
		RefOntoUMLFactoryUtil.setMultiplicity(property, 1, 1);		
		addEntry(property);
	}

	private void addAttribute(Property property) {
		if(owner == null)
			return;
		
		if(owner instanceof RefOntoUML.Class){
			((RefOntoUML.Class)owner).getOwnedAttribute().add(property);
		}
		else if (owner instanceof DataType){
			((DataType)owner).getOwnedAttribute().add(property);
		}
	}

	//==========================================================
	//OVERRIDE: VALUE
	//==========================================================
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(attributes.size() > 0){
			Property prp = (Property)attributes.get(rowIndex);						 
			switch(columnIndex) {
				case 0: return prp.getName();
				case 1: {
					String typeName = new String();
					if(prp.getType()!=null) typeName = prp.getType().getName();
					return typeName;
				}
				case 2: {
					if (prp.getLower()==prp.getUpper() && prp.getUpper()!=-1) return Integer.toString(prp.getLower());
					else if (prp.getLower()==prp.getUpper() && prp.getUpper()==-1) return "*";
					else if (prp.getUpper()==-1) return prp.getLower()+".."+"*";
					else return prp.getLower()+".."+prp.getUpper();
				}
			}
		}
		return null;
	}
		
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		if(value==null || attributes.size()<1) {
			return;
		}
		
		Property property = (Property) attributes.get(rowIndex);
		if(columnIndex == 0) {
			property.setName((String) value);
		} 
		if(columnIndex == 1){
			for(DataType dt: datatypes){
				if(dt.getName().equals((String)value)) property.setType(dt);
			}			
			if(property.getType()==null){
				DataType type = RefOntoUMLFactoryUtil.factory.createPrimitiveType();
				type.setName((String) value);
				property.setType(type);
				if(!datatypes.contains(type)) datatypes.add(type);
			}
		}
		if(columnIndex == 2){
			try {
				RefOntoUMLFactoryUtil.setMultiplicityFromString(property, (String)value);
			} catch (ParseException e) {				
				e.printStackTrace();
			}
		}
	}
	
	//==========================================================
	//OVERRIDE: COLUMNS & ROWS
	//==========================================================
			
	public Class<?> getColumnClass(int columnIndex) {
        if(attributes.size() > 0){
        	switch(columnIndex) {
				case 0: return String.class;
				case 1: return String.class;
				case 2: return String.class;
			}
		}
		return Object.class;
    }
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){ 
		return true;
	}
	
	public int getRowCount() { return attributes.size(); }
}
