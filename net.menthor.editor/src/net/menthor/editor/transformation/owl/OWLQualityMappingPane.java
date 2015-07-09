package net.menthor.editor.transformation.owl;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JPanel;

import net.menthor.editor.transformation.ElementMappingTableModel;
import net.menthor.editor.transformation.QualityMappingPane;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.OntoUMLElement;

public class OWLQualityMappingPane extends JPanel{

	private static final long serialVersionUID = -164010334881840365L;
	
	protected QualityMappingPane qualityPane;
	
	public HashMap<OntoUMLElement,Object> getQualityMap()
	{
		return ((ElementMappingTableModel)qualityPane.getTableModel()).getEntries();
	}
	
	public OWLQualityMappingPane(OntoUMLParser refparser)
	{
		qualityPane = new QualityMappingPane("Quality and Structures",refparser, "OWL/RDF");
		
		qualityPane.setText("Hide the quality and map its structures as datatype properties owned by the bearer type or maintain the quality as a Class and map the structures as datatype properties owned by the quality");
		
		setLayout(new BorderLayout(0,0));
		
		add(qualityPane, BorderLayout.CENTER);			
	}
}
