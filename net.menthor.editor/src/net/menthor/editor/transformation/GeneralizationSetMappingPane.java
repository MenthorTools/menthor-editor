package net.menthor.editor.transformation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import net.menthor.common.transformation.GenMappingEnum;
import net.menthor.editor.v2.tables.BaseTablePane;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLElement;

public class GeneralizationSetMappingPane extends BaseTablePane {
	
	private static final long serialVersionUID = -7587547341203464118L;
	
	public GeneralizationSetMappingPane(OntoUMLParser refparser)
	{
		super("Generalization Sets",refparser, "Mapping classes", "Hide classes?");
		
		//load qualities as options
		List<RefOntoUMLElement> sourcePrimitiveOptions = new ArrayList<RefOntoUMLElement>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(GeneralizationSet qua: refparser.getAllInstances(GeneralizationSet.class))
		{
			sourcePrimitiveOptions.add(new RefOntoUMLElement(qua,""));	
		}		
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));

		//load target options
//		List<GeneralizationMappingType> gsMapTypeOptions = new ArrayList<GeneralizationMappingType>();
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
//		for (GeneralizationMappingType gsMapTypes : GeneralizationMappingType.values()) {
//			
//		}
		typeColumn2.setCellEditor(createEditor(GenMappingEnum.values()));
		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}

