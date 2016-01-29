package net.menthor.editor.ui;

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
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.toolbar.ProjectToolBar;
import net.menthor.editor.v2.tree.ProjectTree;
import net.menthor.editor.v2.tree.TreeVisibility;
import net.menthor.editor.v2.ui.RoundedPanel;
import net.menthor.editor.v2.ui.TitlePanel;

/**
 * @author John Guerson
 */
public class ProjectBrowser extends RoundedPanel{

	private static final long serialVersionUID = 5598591779372431118L;	
	
	public static MainFrame frame;
	
	private JScrollPane scroll;	
	private ProjectTree tree;
	public ProjectTree getTree() { return tree; }	
	private ProjectToolBar toolbar;
	
	public ProjectBrowser(MainFrame appframe, UmlProject project, RefOntoUML.Model model, OclDocument oclDoc){
		super();		
		Models.set(project, model);
		frame = appframe;		
		scroll = new JScrollPane();		
		scroll.setBorder(null);		
		add(scroll, BorderLayout.CENTER);
		initialize();
	}
	  	
	public void initialize(){	
		toolbar = new ProjectToolBar(frame);		
		tree = ProjectTree.create(frame,
			Models.getRefparser(), 
			Models.getOclDocList(), 
			Models.getProject(),
			new TreeVisibility(), 
			false
		);		
		TitlePanel title = new TitlePanel("Project Browser", IconMap.getInstance().getIcon(IconType.MENTHOR_TREE));
		title.setBackground(Color.LIGHT_GRAY);		
		RoundedPanel panel = new RoundedPanel();
		panel.add(title, BorderLayout.NORTH);
		panel.add(toolbar, BorderLayout.CENTER);				
		add(panel, BorderLayout.NORTH);				
		scroll.setViewportView(tree);	
		scroll.setMinimumSize(new Dimension(0,0));
		updateUI();
	}
}
