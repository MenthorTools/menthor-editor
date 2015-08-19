package net.menthor.editor.v2.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.PrimitiveType;
import RefOntoUML.parser.OntoUMLParser;

public class PrimitiveTablePane extends BaseTablePane {
	
	private static final long serialVersionUID = -7587547341203464118L;

	public PrimitiveTablePane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle){
		super(sourceColumnTitle, refparser, targetColumnTitle);		
		/** Load primitive types as options*/
		List<RefOntoUML.PrimitiveType> sourcePrimitiveOptions = new ArrayList<RefOntoUML.PrimitiveType>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(PrimitiveType pt: refparser.getAllInstances(PrimitiveType.class)){
			sourcePrimitiveOptions.add(pt);	
		}		
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));
		/** Load target options*/
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
		typeColumn2.setCellEditor(createEditor(OWL2Datatype.values()));		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}
