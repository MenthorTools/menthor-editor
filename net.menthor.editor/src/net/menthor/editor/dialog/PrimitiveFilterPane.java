package net.menthor.editor.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JPanel;

import RefOntoUML.PrimitiveType;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;

public class PrimitiveFilterPane extends JPanel{

	private static final long serialVersionUID = -4780878204262573447L;
	
	private PrimitiveMappingPane primitiveTypePane;
	private AttributeMappingPane primitiveAttrPane;
	
	public String[] getOWLPrimitiveTypes()
	{
		return new String[]{
			"boolean", "date","dateTime", "decimal","double","duration","float","integer","string","time"
		};
	}
	
	public void addDefault(OntoUMLParser refparser)
	{
		for(PrimitiveType pt: refparser.getAllInstances(PrimitiveType.class))
		{	
			if(pt.getName().compareToIgnoreCase("Integer")==0 || pt.getName().compareToIgnoreCase("Int")==0){
				primitiveTypePane.getTableModel().addEntry(pt.getName(), "integer");
			}
			if(pt.getName().compareToIgnoreCase("Boolean")==0){
				primitiveTypePane.getTableModel().addEntry(pt.getName(), "boolean");
			}
			if(pt.getName().compareToIgnoreCase("String")==0){
				primitiveTypePane.getTableModel().addEntry(pt.getName(), "string");
			}
			if(pt.getName().compareToIgnoreCase("Real")==0){
				primitiveTypePane.getTableModel().addEntry(pt.getName(), "double");
			}
			if(pt.getName().compareToIgnoreCase("DateTime")==0){
				primitiveTypePane.getTableModel().addEntry(pt.getName(), "dateTime");
			}
			if(pt.getName().compareToIgnoreCase("Date")==0){
				primitiveTypePane.getTableModel().addEntry(pt.getName(), "date");
			}
		}
	}
	
	public HashMap<String,String> getPrimitiveMap()
	{
		return primitiveTypePane.getTableModel().getEntries();
	}
	
	public HashMap<Property,String> getAttributeMap()
	{
		return primitiveAttrPane.getTableModel().getEntries();
	}
	
	public PrimitiveFilterPane(OntoUMLParser refparser)
	{
		primitiveTypePane = new PrimitiveMappingPane("OntoUML",refparser, "OWL/RDF", getOWLPrimitiveTypes());
		addDefault(refparser);
		primitiveTypePane.setPreferredSize(new Dimension(100, 150));
		primitiveAttrPane = new AttributeMappingPane("OntoUML",refparser, "OWL/RDF", getOWLPrimitiveTypes());
		primitiveAttrPane.setPreferredSize(new Dimension(100, 150));
		setLayout(new BorderLayout(0,0));
		add(primitiveTypePane, BorderLayout.CENTER);
		add(primitiveAttrPane, BorderLayout.SOUTH);		
	}
}
