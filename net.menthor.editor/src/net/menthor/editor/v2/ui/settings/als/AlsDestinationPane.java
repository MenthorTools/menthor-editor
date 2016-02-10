package net.menthor.editor.v2.ui.settings.als;

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

import net.menthor.common.settings.als.ALS4Destination;
import net.menthor.editor.v2.ui.generic.GenericDestinePane;

public class AlsDestinationPane extends GenericDestinePane {

	private static final long serialVersionUID = 6066954995570622615L;

	private List<JRadioButton> radios = new ArrayList<JRadioButton>();
	
	//====================================================
	//Constructor and Initializer Methods 
	//====================================================

	public AlsDestinationPane() {
		super("Alloy (*.als)","als");
		buildUI();
	}
	
	private void buildUI(){
		for(ALS4Destination d: ALS4Destination.values()){
			JRadioButton radio = new JRadioButton(d.toString());
			radioPane.add(radio);
			group.add(radio);
			radios.add(radio);
		}
		getRadioButton(ALS4Destination.FILE).addActionListener(new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {					        
		        enableFileChooser(true);
		    }
		});
		getRadioButton(ALS4Destination.ANALYZER).addActionListener(new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {					        
		        enableFileChooser(false);
		    }
		});
		getRadioButton(ALS4Destination.TAB).addActionListener(new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {					        
		        enableFileChooser(false);
		    }
		});
		select(ALS4Destination.ANALYZER);		
		enableFileChooser(false);	
	}
	
	//====================================================
	//Getters, Setters & Selectors 
	//====================================================

	private JRadioButton getRadioButton(ALS4Destination dest){
		for(JRadioButton r: radios){
			if(r.getText().compareToIgnoreCase(dest.getName())==0) return r;
		}
		return null;
	}
	
	public ALS4Destination getALS4Destination() { 
		if(getRadioButton(ALS4Destination.FILE).isSelected()){
			return ALS4Destination.FILE;
		}
		else if(getRadioButton(ALS4Destination.ANALYZER).isSelected()){
			return ALS4Destination.ANALYZER;
		}else{
			return ALS4Destination.TAB;
		}
	}
	
	public void select(ALS4Destination dest){
		getRadioButton(dest).setSelected(true);
	}

}