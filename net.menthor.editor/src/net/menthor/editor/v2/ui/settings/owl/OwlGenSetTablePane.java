package net.menthor.editor.v2.ui.settings.owl;

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
import java.util.Collections;
import java.util.List;

import javax.swing.table.TableColumn;

import net.menthor.common.settings.owl.OWL2GeneralizationSet;
import net.menthor.editor.v2.ui.table.MappingTablePane;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;

public class OwlGenSetTablePane extends MappingTablePane {
	
	private static final long serialVersionUID = -7587547341203464118L;
	
	public OwlGenSetTablePane(OntoUMLParser refparser){
		super("Generalization Set",refparser, "Which classes", "Hide");		
		/** Load qualities as options */
		List<RefOntoUML.Element> sourcePrimitiveOptions = new ArrayList<RefOntoUML.Element>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(GeneralizationSet qua: refparser.getAllInstances(GeneralizationSet.class)){
			sourcePrimitiveOptions.add(qua);
		}	
		Collections.sort(sourcePrimitiveOptions);
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray(), false));
		
		/** Load target options */
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);		
		typeColumn2.setCellEditor(createEditor(OWL2GeneralizationSet.values(), false));		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}

