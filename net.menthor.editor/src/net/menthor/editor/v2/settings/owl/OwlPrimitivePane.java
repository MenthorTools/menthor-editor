package net.menthor.editor.v2.settings.owl;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import net.menthor.editor.v2.tables.AttributeTablePane;
import net.menthor.editor.v2.tables.DuoTableModel;
import net.menthor.editor.v2.tables.PrimitiveTablePane;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import RefOntoUML.Element;
import RefOntoUML.PrimitiveType;
import RefOntoUML.parser.OntoUMLParser;

public class OwlPrimitivePane extends JPanel{

	private static final long serialVersionUID = -4780878204262573447L;
	
	private PrimitiveTablePane primitivePane;
	private AttributeTablePane attributePane;
	
	public Map<Object,Object> getPrimitiveMap() throws Exception {
		return ((DuoTableModel)primitivePane.getTableModel()).getEntries();
	}
	
	public Map<Object,Object> getAttributeMap() throws Exception{
		return ((DuoTableModel)attributePane.getTableModel()).getEntries();
	}
	
	private OntoUMLParser refparser;
	
	//====================================================
	//Constructor and Initializer Methods 
	//====================================================
	
	public OwlPrimitivePane(OntoUMLParser refparser){
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
		
	//====================================================
	//Add UI Entry 
	//====================================================
	
	private void addUIEntry(RefOntoUML.Element elem, OWL2Datatype owlDt){
		if(elem instanceof RefOntoUML.PrimitiveType){
			((DuoTableModel)primitivePane.getTableModel()).addEntry(elem, owlDt);
		}
		if(elem instanceof RefOntoUML.Property){
			((DuoTableModel)attributePane.getTableModel()).addEntry(elem, owlDt);
		}
	}
	
	//====================================================
	//Serializing methods
	//====================================================
	
	public void loadFromXML(){
		OwlSettingsMap.getInstance().load();
		if(refparser==null) return;
		Map<Element, OWL2Datatype> map = OwlSettingsMap.getInstance().getOwl2Datatypes(refparser);		
		for(Map.Entry<Element,OWL2Datatype> entry: map.entrySet()){			
			addUIEntry(entry.getKey(), entry.getValue());
		}		
	}
	
	public void storeToXML() throws Exception{
		for(Entry<Object, Object> entry: getPrimitiveMap().entrySet()){
			OwlSettingsMap.getInstance().setOwl2Datatype((RefOntoUML.Element)entry.getKey(),(OWL2Datatype)entry.getValue());
		}
		for(Entry<Object, Object> entry: getAttributeMap().entrySet()){
			OwlSettingsMap.getInstance().setOwl2Datatype((RefOntoUML.Element)entry.getKey(),(OWL2Datatype)entry.getValue());
		}
		OwlSettingsMap.getInstance().store();
	}
	
	private void setdefault(){
		for(PrimitiveType pt: refparser.getAllInstances(PrimitiveType.class)){	
			if(pt.getName().compareToIgnoreCase("Integer")==0 || pt.getName().compareToIgnoreCase("Int")==0){
				OwlSettingsMap.getInstance().setOwl2Datatype(pt, OWL2Datatype.XSD_INTEGER);
				addUIEntry(pt, OWL2Datatype.XSD_INTEGER);
			}
			if(pt.getName().compareToIgnoreCase("Boolean")==0){
				OwlSettingsMap.getInstance().setOwl2Datatype(pt, OWL2Datatype.XSD_BOOLEAN);
				addUIEntry(pt, OWL2Datatype.XSD_BOOLEAN);
			}
			if(pt.getName().compareToIgnoreCase("String")==0){
				OwlSettingsMap.getInstance().setOwl2Datatype(pt, OWL2Datatype.XSD_STRING);
				addUIEntry(pt, OWL2Datatype.XSD_STRING);
			}
			if(pt.getName().compareToIgnoreCase("Real")==0){
				OwlSettingsMap.getInstance().setOwl2Datatype(pt, OWL2Datatype.XSD_DOUBLE);
				addUIEntry(pt, OWL2Datatype.XSD_DOUBLE);
			}
			if(pt.getName().compareToIgnoreCase("DateTime")==0){
				OwlSettingsMap.getInstance().setOwl2Datatype(pt, OWL2Datatype.XSD_DATE_TIME_STAMP);
				addUIEntry(pt, OWL2Datatype.XSD_DATE_TIME_STAMP);				
			}
			if(pt.getName().compareToIgnoreCase("Date")==0){
				OwlSettingsMap.getInstance().setOwl2Datatype(pt, OWL2Datatype.XSD_DATE_TIME);
				addUIEntry(pt, OWL2Datatype.XSD_DATE_TIME);	
			}
		}
	}
	
	
}
