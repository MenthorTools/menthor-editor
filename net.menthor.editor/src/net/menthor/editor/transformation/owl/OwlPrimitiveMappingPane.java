package net.menthor.editor.transformation.owl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import net.menthor.editor.v2.tables.AttributeTablePane;
import net.menthor.editor.v2.tables.DuoTableModel;
import net.menthor.editor.v2.tables.PrimitiveTablePane;
import net.menthor.editor.v2.types.settings.OwlSettingsMap;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.Element;
import RefOntoUML.PrimitiveType;
import RefOntoUML.parser.OntoUMLParser;

public class OwlPrimitiveMappingPane extends JPanel{

	private static final long serialVersionUID = -4780878204262573447L;
	
	private PrimitiveTablePane primitivePane;
	private AttributeTablePane attributePane;
	
	public HashMap<Object,Object> getPrimitiveMap() throws Exception {
		return ((DuoTableModel)primitivePane.getTableModel()).getEntries();
	}
	
	public HashMap<Object,Object> getAttributeMap() throws Exception{
		return ((DuoTableModel)attributePane.getTableModel()).getEntries();
	}
	
	private OntoUMLParser refparser;
	
	//====================================================
	//Constructor and initializer methods 
	//====================================================
	
	public OwlPrimitiveMappingPane(OntoUMLParser refparser){
		this.refparser = refparser;
		buildUI();
		setdefault();
		loadFromXML();
	}
	
	private void buildUI(){
		primitivePane = new PrimitiveTablePane("Primitive Type",refparser, "OWL/RDF");		
		primitivePane.setText("Map a model primitive type to an OWL/RDF's data type");
		primitivePane.getHeaderPane().setPreferredSize(new Dimension(10,45));		
		primitivePane.setPreferredSize(new Dimension(100, 150));
		attributePane = new AttributeTablePane("Attribute",refparser, "OWL/RDF");
		attributePane.setPreferredSize(new Dimension(100, 150));
		attributePane.setText("Map a model attribute's primitive type to an OWL/RDF's data type");
		attributePane.getHeaderPane().setPreferredSize(new Dimension(10,45));		
		setLayout(new BorderLayout(0,0));		
		add(primitivePane, BorderLayout.CENTER);
		add(attributePane, BorderLayout.SOUTH);		
	}
			
	public void loadFromXML(){
		OwlSettingsMap.getInstance().load();
		if(refparser==null) return;
		Map<Element, OWL2Datatype> map = OwlSettingsMap.getInstance().getOwlDatatypes(refparser);		
		for(HashMap.Entry<Element,OWL2Datatype> entry: map.entrySet()){			
			addUIEntry(entry.getKey(), entry.getValue());
		}		
	}
	
	public void storeToXML() throws Exception{
		for(Entry<Object, Object> entry: getPrimitiveMap().entrySet()){
			OwlSettingsMap.getInstance().setOwlDatatype((RefOntoUML.Element)entry.getKey(),(OWL2Datatype)entry.getValue());
		}
		for(Entry<Object, Object> entry: getAttributeMap().entrySet()){
			OwlSettingsMap.getInstance().setOwlDatatype((RefOntoUML.Element)entry.getKey(),(OWL2Datatype)entry.getValue());
		}
		OwlSettingsMap.getInstance().store();
	}
	
	private void setdefault(){
		for(PrimitiveType pt: refparser.getAllInstances(PrimitiveType.class)){	
			if(pt.getName().compareToIgnoreCase("Integer")==0 || pt.getName().compareToIgnoreCase("Int")==0){
				OwlSettingsMap.getInstance().setOwlDatatype(pt, OWL2Datatype.XSD_INTEGER);
				addUIEntry(pt, OWL2Datatype.XSD_INTEGER);
			}
			if(pt.getName().compareToIgnoreCase("Boolean")==0){
				OwlSettingsMap.getInstance().setOwlDatatype(pt, OWL2Datatype.XSD_BOOLEAN);
				addUIEntry(pt, OWL2Datatype.XSD_BOOLEAN);
			}
			if(pt.getName().compareToIgnoreCase("String")==0){
				OwlSettingsMap.getInstance().setOwlDatatype(pt, OWL2Datatype.XSD_STRING);
				addUIEntry(pt, OWL2Datatype.XSD_STRING);
			}
			if(pt.getName().compareToIgnoreCase("Real")==0){
				OwlSettingsMap.getInstance().setOwlDatatype(pt, OWL2Datatype.XSD_DOUBLE);
				addUIEntry(pt, OWL2Datatype.XSD_DOUBLE);
			}
			if(pt.getName().compareToIgnoreCase("DateTime")==0){
				OwlSettingsMap.getInstance().setOwlDatatype(pt, OWL2Datatype.XSD_DATE_TIME_STAMP);
				addUIEntry(pt, OWL2Datatype.XSD_DATE_TIME_STAMP);				
			}
			if(pt.getName().compareToIgnoreCase("Date")==0){
				OwlSettingsMap.getInstance().setOwlDatatype(pt, OWL2Datatype.XSD_DATE_TIME);
				addUIEntry(pt, OWL2Datatype.XSD_DATE_TIME);	
			}
		}
	}
	
	private void addUIEntry(RefOntoUML.Element elem, OWL2Datatype owlDt){
		if(elem instanceof RefOntoUML.PrimitiveType){
			((DuoTableModel)primitivePane.getTableModel()).addEntry(elem, owlDt);
		}
		if(elem instanceof RefOntoUML.Property){
			((DuoTableModel)attributePane.getTableModel()).addEntry(elem, owlDt);
		}
	}
	
	
}
