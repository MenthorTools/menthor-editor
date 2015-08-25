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

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import net.menthor.common.settings.owl.OWL2Approach;
import net.menthor.editor.v2.settings.BaseApproachPane;

public class OwlApproachPane extends BaseApproachPane {

	private static final long serialVersionUID = -4968883469407719592L;
	
	//====================================================
	//Constructor and Initializer Methods 
	//====================================================
	
	public OwlApproachPane(){
		super();
		descriptionTextPane.setBackground(SystemColor.menu);
		descriptionTextPane.setEditable(false);
		buildUI();
		loadFromXML();
	}
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void buildUI(){		
		approachesCombo.setModel(new DefaultComboBoxModel(OWL2Approach.values()));
		approachesCombo.setSelectedItem(OWL2Approach.OOTOS);		
		approachesCombo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				OWL2Approach mt = (OWL2Approach) approachesCombo.getSelectedItem();
				descriptionTextPane.setText(mt.getDescription());
			}
		});
		
		descriptionTextPane.setText(OWL2Approach.OOTOS.getDescription());
	}	
	
	//====================================================
	//Getters & Setters
	//====================================================
		
	public OWL2Approach getApproach(){
		return (OWL2Approach) approachesCombo.getSelectedItem();
	}
	
	//====================================================
	//Add UI Approach
	//====================================================
	
	public void addUIEntry(OWL2Approach approach){
		approachesCombo.setSelectedItem(approach);	
		descriptionTextPane.setText(approach.getDescription());
	}
	
	//====================================================
	//Serializing methods
	//====================================================
	
	public void loadFromXML(){
		OwlSettingsMap.getInstance().load();
		OWL2Approach approach = OwlSettingsMap.getInstance().getApproach();			
		addUIEntry(approach);
	}
	
	public void storeToXML(){		
		OwlSettingsMap.getInstance().setApproach(getApproach());
		OwlSettingsMap.getInstance().store();
	}
}