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
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import net.menthor.common.settings.owl.OWL2GeneralizationSet;

import net.menthor.editor.v2.tables.DuoChoiceTableModel;
import net.menthor.editor.v2.tables.GenSetTablePane;

import RefOntoUML.Element;
import RefOntoUML.parser.OntoUMLParser;

public class OwlGenSetPane extends JPanel{

	private static final long serialVersionUID = -164010334881840365L;
	
	protected OntoUMLParser refparser;
	protected GenSetTablePane gsPane;
	
	public Object[][] getGeneralizationSetMap(){
		return ((DuoChoiceTableModel)gsPane.getTableModel()).getEntriesAsMatrix();
	}
	
	//====================================================
	//Constructor and initializer methods 
	//====================================================
	
	public OwlGenSetPane(OntoUMLParser refparser){
		this.refparser = refparser;
		buildUI();
		loadFromXML();
	}
	
	private void buildUI(){
		gsPane = new GenSetTablePane(refparser);		
		gsPane.setText("Map specific classes from a Generalization Set to an OWL's Enumeration.");		
		setLayout(new BorderLayout(0,0));		
		add(gsPane, BorderLayout.CENTER);
	}
	
	//====================================================
	//Add UI Entry 
	//====================================================
	
	private void addUIEntry(RefOntoUML.Element elem, OWL2GeneralizationSet owlGs, Boolean choice){
		if(elem instanceof RefOntoUML.GeneralizationSet){
			((DuoChoiceTableModel)gsPane.getTableModel()).addEntry(elem, owlGs, choice);
		}
	}
	
	//====================================================
	//Serializing methods
	//====================================================
		
	public void loadFromXML(){
		OwlSettingsMap.getInstance().load();
		if(refparser==null) return;
		Map<Element, OWL2GeneralizationSet> map = OwlSettingsMap.getInstance().getOwl2GenSets(refparser);
		Map<Element, Boolean> map2 = OwlSettingsMap.getInstance().getOwl2GenSetChoices(refparser);
		for(HashMap.Entry<Element,OWL2GeneralizationSet> entry: map.entrySet()){			
			addUIEntry(entry.getKey(), entry.getValue(), map2.get(entry.getKey()));
		}		
	}
	
	public void storeToXML() throws Exception{
		Object [][] matrix = getGeneralizationSetMap();
		for(int i=0; i<matrix.length;i++){
			Element genSet = (Element) matrix[i][0];
			OWL2GeneralizationSet genMapping = (OWL2GeneralizationSet) matrix[i][1];			
			Boolean choice = (Boolean) matrix[i][2];
			OwlSettingsMap.getInstance().setOwl2GenSet(genSet,genMapping,choice);			
		}		
		OwlSettingsMap.getInstance().store();
	}	
}