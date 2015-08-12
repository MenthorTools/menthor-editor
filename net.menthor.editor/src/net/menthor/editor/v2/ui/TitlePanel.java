package net.menthor.editor.v2.ui;

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

import javax.swing.Icon;
import javax.swing.JLabel;

public class TitlePanel extends RoundedPanel {
	
	private static final long serialVersionUID = -531131162599115843L;
	
	private JLabel titleLabel;
	
	public TitlePanel(String name, Icon icon){		
		setLayout(new BorderLayout());
		titleLabel = new JLabel(name, icon, JLabel.LEFT);		
		titleLabel.setFocusable(false);		
		add(titleLabel, BorderLayout.CENTER);
		setMaximumSize(new Dimension(32767, 24));
		Dimension size = new Dimension(200, 24);
		setSize(size);
		setPreferredSize(size);		
	}
	
	public void setIcon(Icon icon){
		titleLabel.setIcon(icon);
	}
}
