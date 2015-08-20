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
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import net.menthor.common.settings.owl.OWL2Quality;

import net.menthor.editor.v2.tables.DuoTableModel;
import net.menthor.editor.v2.tables.QualityTablePane;

import RefOntoUML.Element;
import RefOntoUML.parser.OntoUMLParser;

public class OwlQualityPane extends JPanel{

	private static final long serialVersionUID = -164010334881840365L;
	
	protected OntoUMLParser refparser;
	protected QualityTablePane qualityPane;
	
	public Map<Object,Object> getQualityMap() throws Exception {
		return ((DuoTableModel)qualityPane.getTableModel()).getEntries();
	}
	
	//====================================================
	//Constructor and initializer methods 
	//====================================================
	
	public OwlQualityPane(OntoUMLParser refparser){
		this.refparser = refparser;	
		buildUI();
		loadFromXML();
	}
	
	private void buildUI(){
		qualityPane = new QualityTablePane("Structured Qualities",refparser, "OWL/RDF");		
		qualityPane.setText("Hide the quality and map its structures as datatype properties owned by the bearer type or maintain the quality as a Class and map the structures as datatype properties owned by the quality");		
		setLayout(new BorderLayout(0,0));		
		add(qualityPane, BorderLayout.CENTER);
	}
	
	//====================================================
	//Add UI Entry 
	//====================================================
	
	private void addUIEntry(RefOntoUML.Element elem, OWL2Quality owlDt){
		if(elem instanceof RefOntoUML.Quality){
			((DuoTableModel)qualityPane.getTableModel()).addEntry(elem, owlDt);
		}
	}
	
	//====================================================
	//Serializing methods
	//====================================================
	
	public void loadFromXML(){
		OwlSettingsMap.getInstance().load();
		if(refparser==null) return;
		Map<Element, OWL2Quality> map = OwlSettingsMap.getInstance().getOwl2Quality(refparser);		
		for(Map.Entry<Element,OWL2Quality> entry: map.entrySet()){			
			addUIEntry(entry.getKey(), entry.getValue());
		}		
	}
	
	public void storeToXML() throws Exception{
		for(Entry<Object, Object> entry: getQualityMap().entrySet()){
			OwlSettingsMap.getInstance().setOwl2Quality((RefOntoUML.Element)entry.getKey(),(OWL2Quality)entry.getValue());
		}
		OwlSettingsMap.getInstance().store();
	}	
}
