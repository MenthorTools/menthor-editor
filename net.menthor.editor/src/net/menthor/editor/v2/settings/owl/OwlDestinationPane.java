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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import net.menthor.common.settings.owl.OWL2Destination;
import net.menthor.editor.v2.settings.BaseDestinationPane;

public class OwlDestinationPane extends BaseDestinationPane {

	private static final long serialVersionUID = 6066954995570622615L;

	private List<JRadioButton> radios = new ArrayList<JRadioButton>();
	
	//====================================================
	//Constructor and Initializer Methods 
	//====================================================

	public OwlDestinationPane() {
		super("OWL (*.owl)","owl");
		buildUI();
	}
	
	private void buildUI(){
		for(OWL2Destination d: OWL2Destination.values()){
			JRadioButton radio = new JRadioButton(d.toString());
			radioPane.add(radio);
			group.add(radio);
			radios.add(radio);
		}
		getRadioButton(OWL2Destination.FILE).addActionListener(new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {					        
		        enableFileChooser(true);
		    }
		});
		getRadioButton(OWL2Destination.PROTEGE).addActionListener(new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {					        
		        enableFileChooser(false);
		    }
		});
		getRadioButton(OWL2Destination.TAB).addActionListener(new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {					        
		        enableFileChooser(false);
		    }
		});
		select(OWL2Destination.TAB);
		getRadioButton(OWL2Destination.PROTEGE).setEnabled(false);
		enableFileChooser(false);	
	}
	
	//====================================================
	//Getters, Setters & Selectors 
	//====================================================

	private JRadioButton getRadioButton(OWL2Destination dest){
		for(JRadioButton r: radios){
			if(r.getText().compareToIgnoreCase(dest.getName())==0) return r;
		}
		return null;
	}
	
	public OWL2Destination getOWL2Destination() { 
		if(getRadioButton(OWL2Destination.FILE).isSelected()){
			return OWL2Destination.FILE;
		}
		else if(getRadioButton(OWL2Destination.PROTEGE).isSelected()){
			return OWL2Destination.PROTEGE;
		}else{
			return OWL2Destination.TAB;
		}
	}
	
	public void select(OWL2Destination dest){
		getRadioButton(dest).setSelected(true);
	}

	//====================================================
	//ADd UI Entry
	//====================================================
	
	public void addUIEntry(OWL2Destination dest, String filepath){
		select(dest);
		if(filepath!=null) setPath(filepath);
	}
	
	//====================================================
	//Serializing methods
	//====================================================
	
	public void loadFromXML(){
		OwlSettingsMap.getInstance().load();
		OWL2Destination dest = OwlSettingsMap.getInstance().getDestination();
		String path = OwlSettingsMap.getInstance().getPath();
		addUIEntry(dest, path);
	}
	
	public void storeToXML(){		
		OwlSettingsMap.getInstance().setDestination(getOWL2Destination(), getPath());
		OwlSettingsMap.getInstance().store();
	}
}
