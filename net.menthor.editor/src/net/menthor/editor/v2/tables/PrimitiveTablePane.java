package net.menthor.editor.v2.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.DataType;
import RefOntoUML.Enumeration;
import RefOntoUML.parser.OntoUMLParser;

public class PrimitiveTablePane extends BaseTablePane {
	
	private static final long serialVersionUID = -7587547341203464118L;

	public PrimitiveTablePane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle){
		super(sourceColumnTitle, refparser, targetColumnTitle);		
		/** Load primitive types as options*/
		List<RefOntoUML.DataType> sourcePrimitiveOptions = new ArrayList<RefOntoUML.DataType>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(DataType pt: refparser.getAllInstances(DataType.class)){
			if(!(pt instanceof Enumeration)) sourcePrimitiveOptions.add(pt);	
		}
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));
		/** Load target options*/
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
		typeColumn2.setCellEditor(createEditor(OWL2Datatype.values()));		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}
