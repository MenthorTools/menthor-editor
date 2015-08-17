package net.menthor.editor.v2.tables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.TableColumn;

import net.menthor.common.transformation.QualityMappingType;
import RefOntoUML.parser.OntoUMLParser;

public class QualityTablePane extends BaseTablePane {
	
	private static final long serialVersionUID = -7587547341203464118L;
	
	public QualityTablePane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle){
		super(sourceColumnTitle, refparser, targetColumnTitle);		
		/** Load qualities as options*/
		List<RefOntoUML.Element> sourcePrimitiveOptions = new ArrayList<RefOntoUML.Element>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(RefOntoUML.Class sbk: refparser.getAllInstances(RefOntoUML.Class.class)){
			if(refparser.isQuality(sbk)) {
				sourcePrimitiveOptions.add(sbk);	
			}
		}		
		Collections.sort(sourcePrimitiveOptions);		
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));
		/** Load target options*/
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
		typeColumn2.setCellEditor(createEditor(QualityMappingType.values()));		
		table.setSurrendersFocusOnKeystroke(true);
	}	
}

