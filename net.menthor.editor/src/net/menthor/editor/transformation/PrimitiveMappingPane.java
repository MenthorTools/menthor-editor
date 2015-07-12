package net.menthor.editor.transformation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.PrimitiveType;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLElement;

public class PrimitiveMappingPane extends BaseMappingPane {
	
	private static final long serialVersionUID = -7587547341203464118L;

	public PrimitiveMappingPane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle)
	{
		super(sourceColumnTitle, refparser, targetColumnTitle);
		
		//load primitive types as options
		List<RefOntoUMLElement> sourcePrimitiveOptions = new ArrayList<RefOntoUMLElement>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(PrimitiveType pt: refparser.getAllInstances(PrimitiveType.class))
		{
			sourcePrimitiveOptions.add(new RefOntoUMLElement(pt, ""));	
		}		
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));

		//load target options
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
		typeColumn2.setCellEditor(createEditor(OWL2Datatype.values()));
		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}
