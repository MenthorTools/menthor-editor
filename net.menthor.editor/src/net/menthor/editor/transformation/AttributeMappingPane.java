package net.menthor.editor.transformation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.OntoUMLElement;

public class AttributeMappingPane extends BaseMappingPane {

	private static final long serialVersionUID = 2935299524810601918L;

	public AttributeMappingPane(String sourceColumnTitle, OntoUMLParser refparser, String targetColumnTitle)
	{
		super(sourceColumnTitle,refparser,targetColumnTitle);
		
		//load attributes as options
		List<OntoUMLElement> sourcePrimitiveOptions = new ArrayList<OntoUMLElement>();
		TableColumn typeColumn = table.getColumnModel().getColumn(0);	
		for(Property pt: refparser.getAllInstances(Property.class))
		{
			if(pt.getAssociation()==null && pt.getType()!=null) {
				sourcePrimitiveOptions.add(new OntoUMLElement(pt,""));
			}
		}
		typeColumn.setCellEditor(createEditor(sourcePrimitiveOptions.toArray()));

		//load target options
		TableColumn typeColumn2 = table.getColumnModel().getColumn(1);	
		typeColumn2.setCellEditor(createEditor(OWL2Datatype.values()));
		
		table.setSurrendersFocusOnKeystroke(true);
	}
}
