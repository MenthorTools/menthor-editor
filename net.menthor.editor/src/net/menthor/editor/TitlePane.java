package net.menthor.editor;

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

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class TitlePane extends JPanel {
	
	private static final long serialVersionUID = 7182319329510468466L;
	public JLabel title;
	
	public TitlePane()
	{		
		setBorder(new LineBorder(UIManager.getColor("Panel.background")));
		
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(3);
		flowLayout.setHgap(3);
		flowLayout.setAlignment(FlowLayout.LEFT);
		//panel.setBorder(new LineBorder(UIManager.getColor("TabbedPane.darkShadow")));
		//setBackground(new Color(0x999999));
		setBackground(new Color(0xDDDDDD));
		title = new JLabel();		
		title.setAlignmentY(Component.TOP_ALIGNMENT);
		add(title);				
		title.setText("Toolbox");
	}
	
	public TitlePane(String titleText, String iconPath)
	{
		this();
		if(iconPath!=null) title.setIcon(new ImageIcon(TitlePane.class.getResource(iconPath)));
		title.setText(titleText);
	}

}
