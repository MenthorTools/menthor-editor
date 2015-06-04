package net.menthor.editor.transformation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import net.menthor.editor.explorer.OntoUMLElement;
import RefOntoUML.PrimitiveType;
import RefOntoUML.parser.OntoUMLParser;

public class PrimitiveMappingPane extends BaseMappingPane {
	
	private static final long serialVersionUID = -7587547341203464118L;

	public PrimitiveMappingPane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle, String[] targetOptions)
	{
		super(sourceColumnTitle, refparser, targetColumnTitle, targetOptions);
		
		//load primitive types as options
		List<OntoUMLElement> sourcePrimitiveOptions = new ArrayList<OntoUMLElement>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(PrimitiveType pt: refparser.getAllInstances(PrimitiveType.class))
		{
			sourcePrimitiveOptions.add(new OntoUMLElement(pt, ""));	
		}		
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));

		//load target options
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
		typeColumn2.setCellEditor(createEditor(targetOptions));
		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}
