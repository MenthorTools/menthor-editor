package net.menthor.editor.v2.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import net.menthor.common.settings.owl.OWL2GeneralizationSet;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;

public class GenSetTablePane extends BaseTablePane {
	
	private static final long serialVersionUID = -7587547341203464118L;
	
	public GenSetTablePane(OntoUMLParser refparser){
		super("Generalization Sets",refparser, "Mapping classes", "Hide classes?");		
		/** Load qualities as options */
		List<RefOntoUML.Element> sourcePrimitiveOptions = new ArrayList<RefOntoUML.Element>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(GeneralizationSet qua: refparser.getAllInstances(GeneralizationSet.class)){
			sourcePrimitiveOptions.add(qua);
		}		
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));
		/** Load target options */
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);
		typeColumn2.setCellEditor(createEditor(OWL2GeneralizationSet.values()));		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}

