package net.menthor.editor.transformation.owl;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import net.menthor.editor.transformation.ChoiceElemMapTableModel;
import net.menthor.editor.transformation.GeneralizationSetMappingPane;
import RefOntoUML.parser.OntoUMLParser;

public class OwlGenSetMappingPane extends JPanel{

	private static final long serialVersionUID = -164010334881840365L;
	
	protected GeneralizationSetMappingPane gsPane;
	
	public Object[][] getGenSetEnumMappingMap()
	{
		return ((ChoiceElemMapTableModel)gsPane.getTableModel()).getEntries();
	}
	
	public OwlGenSetMappingPane(OntoUMLParser refparser)
	{
		gsPane = new GeneralizationSetMappingPane(refparser);
		
		gsPane.setText("Map specific classes from a Generalization Set to a Enumeration.");
		
		setLayout(new BorderLayout(0,0));
		
		add(gsPane, BorderLayout.CENTER);			
	}
}