package net.menthor.editor.transformation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import net.menthor.common.transformation.GeneralizationMappingType;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.OntoUMLElement;

public class GeneralizationSetMappingPane extends BaseMappingPane {
	
	private static final long serialVersionUID = -7587547341203464118L;
	
	public GeneralizationSetMappingPane(OntoUMLParser refparser)
	{
		super("Generalization Sets",refparser, "Mapping classes", GeneralizationMappingType.valuesStr(), "Hide classes?");
		
		//load qualities as options
		List<OntoUMLElement> sourcePrimitiveOptions = new ArrayList<OntoUMLElement>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(GeneralizationSet qua: refparser.getAllInstances(GeneralizationSet.class))
		{
			sourcePrimitiveOptions.add(new OntoUMLElement(qua,""));	
		}		
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));

		//load target options
//		List<GeneralizationMappingType> gsMapTypeOptions = new ArrayList<GeneralizationMappingType>();
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
//		for (GeneralizationMappingType gsMapTypes : GeneralizationMappingType.values()) {
//			
//		}
		typeColumn2.setCellEditor(createEditor(GeneralizationMappingType.values()));
		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}

