package net.menthor.editor.v2.ui.tree;

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
import java.util.List;

import javax.swing.JScrollPane;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.UmlProject;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.RoundedPanel;
import net.menthor.editor.v2.ui.TitlePanel;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;

public class AppProjectBrowser extends RoundedPanel{

	private static final long serialVersionUID = 5598591779372431118L;	
	
	private ICommandListener listener;
	private TitlePanel titlePane;
	private JScrollPane scrollPane;
	private ProjectTree tree;
	
	public ProjectTree getTree() { return tree; }	
	
	public AppProjectBrowser(ICommandListener listener){
		super();
		this.listener = listener;
		scrollPane = new JScrollPane();		
		scrollPane.setBorder(null);		
		add(scrollPane, BorderLayout.CENTER);
		titlePane = new TitlePanel("Project Browser", IconMap.getInstance().getIcon(IconType.MENTHOR_TREE));
		titlePane.setBackground(Color.LIGHT_GRAY);		
		RoundedPanel roundTitlePane = new RoundedPanel();
		roundTitlePane.add(titlePane, BorderLayout.NORTH);
		add(roundTitlePane, BorderLayout.NORTH);	
	}
		  	
	public void initialize(UmlProject project, OntoUMLParser refparser, List<OclDocument> oclDocs){	
		TreeVisibility viz = new TreeVisibility();
		viz.hideEnds();
		tree = ProjectTree.create(listener,refparser,oclDocs,project, viz, false);
		scrollPane.setViewportView(tree);	
		scrollPane.setMinimumSize(new Dimension(0,0));
		updateUI();
	}
}
