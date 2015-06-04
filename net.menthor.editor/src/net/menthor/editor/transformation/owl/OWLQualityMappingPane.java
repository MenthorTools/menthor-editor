package net.menthor.editor.transformation.owl;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JPanel;

import net.menthor.editor.explorer.OntoUMLElement;
import net.menthor.editor.transformation.QualityMappingPane;
import RefOntoUML.parser.OntoUMLParser;

public class OWLQualityMappingPane extends JPanel{

	private static final long serialVersionUID = -164010334881840365L;
	
	protected QualityMappingPane qualityPane;
	
	public HashMap<OntoUMLElement,String> getQualityMap()
	{
		return qualityPane.getTableModel().getEntries();
	}
	
	public OWLQualityMappingPane(OntoUMLParser refparser)
	{
		qualityPane = new QualityMappingPane("Quality",refparser, "OWL/RDF", new String[]{"Hide it","Maintain it"});
		
		qualityPane.setText("Hide the quality mapping its structures as datatype properties owned by the bearer type or maintain the quality as a Class mapingp the structures as datatype properties owned by the quality");
		
		setLayout(new BorderLayout(0,0));
		
		add(qualityPane, BorderLayout.CENTER);			
	}
}
