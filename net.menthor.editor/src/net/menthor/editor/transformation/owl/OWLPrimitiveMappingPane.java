package net.menthor.editor.transformation.owl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JPanel;

import net.menthor.editor.transformation.AttributeMappingPane;
import net.menthor.editor.transformation.ElementMappingTableModel;
import net.menthor.editor.transformation.PrimitiveMappingPane;
import RefOntoUML.PrimitiveType;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.OntoUMLElement;

public class OWLPrimitiveMappingPane extends JPanel{

	private static final long serialVersionUID = -4780878204262573447L;
	
	private PrimitiveMappingPane primitiveTypePane;
	private AttributeMappingPane primitiveAttrPane;
	
	public String[] getOWLPrimitiveTypes()
	{
		return new String[]{
			"anyURI", "base64Binary", "boolean", "byte","date", "dateTime", "decimal","double","duration",
			"ENTITIES","ENTITY","IDREFS","IDREF","ID","float",
			"gYearMonth", "gYear", "gMonthDay", "gDay","gMonth","hexBinary","int","integer","language","long", "Name",
			"NCName","negativeInteger", "NMTOKENS","NMTOKEN","nonNegativeInteger","nonPositiveInteger",
			"normalizedString","NOTATION", "positiveInteger","QName",
			"short","string","time","token","unsignedLong", "unsignedInt", "unsignedShort", "unsignedByte"
		};
	}
	
	public void addDefault(OntoUMLParser refparser)
	{
		for(PrimitiveType pt: refparser.getAllInstances(PrimitiveType.class))
		{	
			if(pt.getName().compareToIgnoreCase("Integer")==0 || pt.getName().compareToIgnoreCase("Int")==0){
				((ElementMappingTableModel)primitiveTypePane.getTableModel()).addEntry(new OntoUMLElement(pt,""), "integer");
			}
			if(pt.getName().compareToIgnoreCase("Boolean")==0){
				((ElementMappingTableModel)primitiveTypePane.getTableModel()).addEntry(new OntoUMLElement(pt,""), "boolean");
			}
			if(pt.getName().compareToIgnoreCase("String")==0){
				((ElementMappingTableModel)primitiveTypePane.getTableModel()).addEntry(new OntoUMLElement(pt,""), "string");
			}
			if(pt.getName().compareToIgnoreCase("Real")==0){
				((ElementMappingTableModel)primitiveTypePane.getTableModel()).addEntry(new OntoUMLElement(pt,""), "double");
			}
			if(pt.getName().compareToIgnoreCase("DateTime")==0){
				((ElementMappingTableModel)primitiveTypePane.getTableModel()).addEntry(new OntoUMLElement(pt,""), "dateTime");
			}
			if(pt.getName().compareToIgnoreCase("Date")==0){
				((ElementMappingTableModel)primitiveTypePane.getTableModel()).addEntry(new OntoUMLElement(pt,""), "date");
			}
		}
	}
	
	public HashMap<OntoUMLElement,String> getPrimitiveMap()
	{
		return ((ElementMappingTableModel)primitiveTypePane.getTableModel()).getEntries();
	}
	
	public HashMap<OntoUMLElement,String> getAttributeMap()
	{
		return ((ElementMappingTableModel)primitiveTypePane.getTableModel()).getEntries();
	}
	
	public OWLPrimitiveMappingPane(OntoUMLParser refparser)
	{
		primitiveTypePane = new PrimitiveMappingPane("Primitive Type",refparser, "OWL/RDF", getOWLPrimitiveTypes());
		addDefault(refparser);
		primitiveTypePane.setText("Map a primitive type to an OWL's primitive/derived data type");
		primitiveTypePane.getHeaderPane().setPreferredSize(new Dimension(10,45));
		
		primitiveTypePane.setPreferredSize(new Dimension(100, 150));
		primitiveAttrPane = new AttributeMappingPane("Attribute",refparser, "OWL/RDF", getOWLPrimitiveTypes());
		primitiveAttrPane.setPreferredSize(new Dimension(100, 150));
		primitiveAttrPane.setText("Map an attribute's primitive type to an OWL's primitive/derived data type");
		primitiveAttrPane.getHeaderPane().setPreferredSize(new Dimension(10,45));
		
		setLayout(new BorderLayout(0,0));
		
		add(primitiveTypePane, BorderLayout.CENTER);
		add(primitiveAttrPane, BorderLayout.SOUTH);		
	}
}
