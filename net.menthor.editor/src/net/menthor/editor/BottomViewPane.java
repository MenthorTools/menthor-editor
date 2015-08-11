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

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import net.menthor.editor.ui.UmlProject;

public class BottomViewPane  extends JPanel {

	private static final long serialVersionUID = -4823234075231975784L;
	
	public MainFrame frame;
	public InfoManager infoManager;
	public UmlProject project;
	
	public InfoManager getInfoManager() {
		return infoManager;
	}

	public MainFrame getFrame(){
		return frame;
	}
	
	@Override
	public void setPreferredSize(Dimension preferredSize) {
		infoManager.setPreferredSize(preferredSize);
		super.setPreferredSize(preferredSize);
	};
	
	@Override
	public void setSize(Dimension preferredSize) {
		infoManager.setSize(preferredSize);
		super.setPreferredSize(preferredSize);
	};
	
	public BottomViewPane (final MainFrame frame, UmlProject project) 
	{
		//setBackground(Color.WHITE);
		setMinimumSize(new Dimension(0,0));
		setLayout(new BorderLayout(0,0));
		this.frame = frame;	
		this.project = project;
		
		infoManager = new InfoManager(frame,project);
		infoManager.setTabPlacement(JTabbedPane.TOP);		
				
		add(infoManager,BorderLayout.CENTER);
		
		//TitlePane panel = new TitlePane("Information Footer",null);		
		//panel.title.setIcon(new ImageIcon(BottomViewPane.class.getResource("/resources/icons/x16/layout_select_footer.png")));
		//add(panel, BorderLayout.NORTH);
	}
}