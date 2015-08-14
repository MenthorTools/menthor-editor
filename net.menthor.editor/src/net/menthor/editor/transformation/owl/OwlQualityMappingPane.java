package net.menthor.editor.transformation.owl;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JPanel;

import net.menthor.editor.transformation.ElementMappingTableModel;
import net.menthor.editor.transformation.QualityMappingPane;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLElement;

public class OwlQualityMappingPane extends JPanel{

	private static final long serialVersionUID = -164010334881840365L;
	
	protected QualityMappingPane qualityPane;
	
	public HashMap<RefOntoUMLElement,Object> getQualityMap() throws Exception
	{
		return ((ElementMappingTableModel)qualityPane.getTableModel()).getEntries();
	}
	
	public OwlQualityMappingPane(OntoUMLParser refparser)
	{
		qualityPane = new QualityMappingPane("Structured Qualities",refparser, "OWL/RDF");
		
		qualityPane.setText("Hide the quality and map its structures as datatype properties owned by the bearer type or maintain the quality as a Class and map the structures as datatype properties owned by the quality");
		
		setLayout(new BorderLayout(0,0));
		
		add(qualityPane, BorderLayout.CENTER);			
	}
}
