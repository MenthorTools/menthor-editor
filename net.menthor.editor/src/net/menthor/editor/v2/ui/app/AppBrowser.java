package net.menthor.editor.v2.ui.app;

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

import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.ui.tree.ProjectTree;
import net.menthor.editor.v2.ui.tree.TreeVisibility;
import net.menthor.editor.v2.ui.util.RoundedPanel;
import net.menthor.editor.v2.ui.util.TitlePane;

public class AppBrowser extends RoundedPanel{

	private static final long serialVersionUID = 5598591779372431118L;	
	
	// -------- Lazy Initialization

	private static class AppProjectBrowserLoader {
        private static final AppBrowser INSTANCE = new AppBrowser();
    }	
	public static AppBrowser get() { 
		return AppProjectBrowserLoader.INSTANCE; 
	}	
    private AppBrowser() {
    	super();
    	this.listener = AppCmdListener.get();
    	if (AppProjectBrowserLoader.INSTANCE != null) throw new IllegalStateException("AppProjectBrowser already instantiated");
        buildUI();
    }		
    
    // ----------------------------
	    
	private ICommandListener listener;
	private TitlePane titlePane;
	private JScrollPane scrollPane;
	private ProjectTree tree;
	
	public ProjectTree getTree() { return tree; }	
	
	public void buildUI(){
		scrollPane = new JScrollPane();		
		scrollPane.setBorder(null);		
		add(scrollPane, BorderLayout.CENTER);
		titlePane = new TitlePane("Project Browser", IconMap.getInstance().getIcon(IconType.MENTHOR_TREE));
		titlePane.setBackground(Color.LIGHT_GRAY);		
		RoundedPanel roundTitlePane = new RoundedPanel();
		roundTitlePane.add(titlePane, BorderLayout.NORTH);
		add(roundTitlePane, BorderLayout.NORTH);	
	}
	
	public void initialize(UmlProject project){	
		TreeVisibility viz = new TreeVisibility();
		viz.hideEnds();
		tree = ProjectTree.create(listener,project.getRefParser(),project.getOclDocList(),project, viz, false);
		scrollPane.setViewportView(tree);	
		scrollPane.setMinimumSize(new Dimension(0,0));
		updateUI();
	}
}
