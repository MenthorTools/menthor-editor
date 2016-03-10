package net.menthor.editor.v2.ui.settings.owl;

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

import javax.swing.JPanel;

import net.menthor.common.settings.owl.OWL2Approach;
import net.menthor.common.settings.owl.OWL2Destination;

public class OwlMainPane extends JPanel {

	private static final long serialVersionUID = -5681113361932739723L;
		
	private OwlApproachPane approachPane;
	private OwlDestinationPane destinationPane;
		
	//====================================================
	//Constructor and Initializer Methods 
	//====================================================
	
	public OwlMainPane(){	
		buildUI();
		loadFromXML();
	}
	
	private void buildUI(){				
		approachPane = new OwlApproachPane();		
		destinationPane = new OwlDestinationPane();		
		setLayout(new BorderLayout(5, 5));
		add(destinationPane, BorderLayout.NORTH);
		add(approachPane, BorderLayout.CENTER);		
	}
	
	//====================================================
	//Serialization
	//====================================================
	
	public void loadFromXML(){
		approachPane.loadFromXML();
		destinationPane.loadFromXML();
	}
	
	public void storeToXML(){
		approachPane.storeToXML();
		destinationPane.storeToXML();
	}

	//====================================================
	//Getters & Setters
	//====================================================
	
	public OWL2Approach getSelectedMapping() { 
		return approachPane.getApproach(); 
	}
	
	public OWL2Destination getOWL2Destination() { 
		return destinationPane.getOWL2Destination(); 
	}
	
	public String getPathText() { 
		return destinationPane.getPath(); 
	}
}
