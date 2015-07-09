package net.menthor.editor.transformation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import net.menthor.common.transformation.QualityMappingTypes;
import RefOntoUML.Quality;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.OntoUMLElement;

public class QualityMappingPane extends BaseMappingPane {
	
	private static final long serialVersionUID = -7587547341203464118L;
	
	public QualityMappingPane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle)
	{
		super(sourceColumnTitle, refparser, targetColumnTitle);
		
		//load qualities as options
		List<OntoUMLElement> sourcePrimitiveOptions = new ArrayList<OntoUMLElement>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(Quality qua: refparser.getAllInstances(Quality.class))
		{
			sourcePrimitiveOptions.add(new OntoUMLElement(qua,""));	
		}		
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));

		//load target options
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
		typeColumn2.setCellEditor(createEditor(QualityMappingTypes.values()));
		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}

