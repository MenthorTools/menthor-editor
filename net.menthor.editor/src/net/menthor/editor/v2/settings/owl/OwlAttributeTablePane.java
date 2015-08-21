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

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.tables.MappingTablePane;

public class OwlAttributeTablePane extends MappingTablePane {

	private static final long serialVersionUID = 2935299524810601918L;

	public OwlAttributeTablePane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle){
		super(sourceColumnTitle,refparser,targetColumnTitle);		
		/** Load attributes in the 1st column*/
		List<RefOntoUML.Element> sourcePrimitiveOptions = new ArrayList<RefOntoUML.Element>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(Property pt: refparser.getAllInstances(Property.class)){
			if(pt.getAssociation()==null && pt.getType()!=null) {
				sourcePrimitiveOptions.add(pt);
			}
		}
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));
		/** Load owl datatypes in the 2nd column */
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
		typeColumn2.setCellEditor(createEditor(OWL2Datatype.values()));		
		table.setSurrendersFocusOnKeystroke(true);
	}
}
