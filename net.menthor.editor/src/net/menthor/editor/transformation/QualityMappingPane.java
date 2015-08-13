package net.menthor.editor.transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.TableColumn;

import RefOntoUML.Quality;
import RefOntoUML.SubKind;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLElement;

public class QualityMappingPane extends BaseMappingPane {
	
	private static final long serialVersionUID = -7587547341203464118L;
	
	public QualityMappingPane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle)
	{
		super(sourceColumnTitle, refparser, targetColumnTitle);
		
		//load qualities as options
		List<RefOntoUMLElement> sourcePrimitiveOptions = new ArrayList<RefOntoUMLElement>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(Quality qua: refparser.getAllInstances(Quality.class))
		{
			sourcePrimitiveOptions.add(new RefOntoUMLElement(qua,""));	
		}	
		for(SubKind sbk: refparser.getAllInstances(SubKind.class))
		{
			if(refparser.isQuality(sbk)) {
				sourcePrimitiveOptions.add(new RefOntoUMLElement(sbk,""));	
			}
		}	
		
		Collections.sort(sourcePrimitiveOptions);
		
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));

		//load target options
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
		typeColumn2.setCellEditor(createEditor(QualityMappingType.values()));
		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}

