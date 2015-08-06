package net.menthor.editor.v2.status;

/*
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
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class StatusPane extends JPanel implements StatusListener{
	
	private static final long serialVersionUID = 2153837501881399529L;
	
	private JLabel statusLabel = new JLabel();
	
	public void clear(){
		statusLabel.setText("");
	}
		
	public StatusPane(){
		super();		
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusLabel.setBackground(Color.WHITE);
		statusLabel.setBorder(null);		
		add(statusLabel, BorderLayout.CENTER);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(450, 22));
		setBorder(null);
	}

	public void report(String status){
		statusLabel.setText(status);
	}	
}