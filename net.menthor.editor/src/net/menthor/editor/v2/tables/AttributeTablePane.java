package net.menthor.editor.v2.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;

public class AttributeTablePane extends BaseTablePane {

	private static final long serialVersionUID = 2935299524810601918L;

	public AttributeTablePane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle){
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
