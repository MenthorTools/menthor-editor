package net.menthor.editor.v2.settings.owl;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.table.TableColumn;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.DataType;
import RefOntoUML.DecimalIntervalDimension;
import RefOntoUML.DecimalOrdinalDimension;
import RefOntoUML.DecimalRationalDimension;
import RefOntoUML.Enumeration;
import RefOntoUML.IntegerIntervalDimension;
import RefOntoUML.IntegerOrdinalDimension;
import RefOntoUML.IntegerRationalDimension;
import RefOntoUML.PrimitiveType;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.managers.MessageManager;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.ui.table.MappingTableModel;
import net.menthor.editor.v2.ui.table.MappingTablePane;

public class OwlPrimitiveTablePane extends MappingTablePane {
	
	private static final long serialVersionUID = -7587547341203464118L;

	private OntoUMLParser refparser;
	
	public OwlPrimitiveTablePane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle){
		super(sourceColumnTitle, refparser, targetColumnTitle);		
		this.refparser = refparser;
		/** Load primitive types as options*/
		List<RefOntoUML.DataType> sourcePrimitiveOptions = new ArrayList<RefOntoUML.DataType>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(DataType pt: refparser.getAllInstances(DataType.class)){
			if(!(pt instanceof Enumeration) && pt.getAttribute().isEmpty()){
				sourcePrimitiveOptions.add(pt);	
			}
		}
		Collections.sort(sourcePrimitiveOptions);
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray(), false));
		/** Load target options*/
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);
		ArrayList<String> owl2DataTypeLst = new ArrayList<String>();
		for(OWL2Datatype owl2DataType : OWL2Datatype.values()){
			owl2DataTypeLst.add(owl2DataType.toString());
		}
		Collections.sort(owl2DataTypeLst);
		typeColumn2.setCellEditor(createEditor(owl2DataTypeLst.toArray(), true));		
		table.setSurrendersFocusOnKeystroke(true);
		
		JButton loadDefaultMapBtn = addButton("Load Default Mappings", IconType.MENTHOR_IMPORT);
		loadDefaultMapBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!tableModel.hasNullEntry()) loadDefaultMappings();
				else{
					MessageManager.get().showError(OwlPrimitiveTablePane.this,"Table Entry","Please, fill the <no value> cells before move on.");
				}
			}});
	}	
	
	private void loadDefaultMappings(){
		Set<PrimitiveType> primitiveTypes = refparser.getAllInstances(PrimitiveType.class);
		Set<DataType> dataTypes = refparser.getAllInstances(DataType.class);
		dataTypes.removeAll(primitiveTypes);
		ArrayList<DataType> dataTypesList = new ArrayList<DataType>();
		dataTypesList.addAll(dataTypes);
		Collections.sort(dataTypesList);
		for(DataType dt: dataTypesList){
			OWL2Datatype owlType;
			if(dt instanceof IntegerIntervalDimension || dt instanceof IntegerOrdinalDimension || dt instanceof IntegerRationalDimension){
				owlType = OWL2Datatype.XSD_INTEGER;
			}else if(dt instanceof DecimalIntervalDimension || dt instanceof DecimalOrdinalDimension || dt instanceof DecimalRationalDimension){
				owlType = OWL2Datatype.XSD_DECIMAL;
			}else{
				owlType = OWL2Datatype.RDFS_LITERAL;
			}
			OwlSettingsMap.getInstance().setOwl2Datatype(dt, owlType.toString());
			((MappingTableModel)this.getTableModel()).addEntry(dt, owlType.toString());
		}
		
	}
	
	
}
