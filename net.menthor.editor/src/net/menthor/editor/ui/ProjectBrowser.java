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
import java.io.File;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.menthor.antipattern.application.AntiPatternList;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.toolbar.ProjectToolBar;
import net.menthor.editor.v2.trees.ProjectTree;
import net.menthor.editor.v2.trees.TreeVisibility;
import net.menthor.editor.v2.ui.RoundedPanel;
import net.menthor.editor.v2.ui.TitlePanel;
import net.menthor.ontouml2alloy.OntoUML2AlloyOptions;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;
import RefOntoUML.parser.OntoUMLParser;

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
			
	public List<OntoumlDiagram> getAllDiagrams(){
		return (List<OntoumlDiagram>) Models.getProject().getDiagrams();
	}
	
	public ProjectBrowser(MainFrame appframe, UmlProject project, RefOntoUML.Model model, OclDocument oclDoc){
		super();		
		Models.setProject(project);		
		frame = appframe;		
		scroll = new JScrollPane();		
		scroll.setBorder(null);		
		if (project!=null) set(project, model);		
		add(scroll, BorderLayout.CENTER);			
		RoundedPanel emptyTempPanel = new RoundedPanel();
		emptyTempPanel.setBackground(Color.WHITE);
		emptyTempPanel.setBorder(new EmptyBorder(0,0, 0, 0));
		scroll.setViewportView(emptyTempPanel);	
		
		scroll.setMinimumSize(new Dimension(0,0));
	}
	
	public void refresh(){				
		tree.updateUI();		
		updateUI();
	}
	
	public void clear(){
		//clear models
		Models.clear();
		
		RoundedPanel emptyTempPanel = new RoundedPanel();
		emptyTempPanel.setBackground(Color.WHITE);
		emptyTempPanel.setBorder(new EmptyBorder(0,0, 0, 0));
		scroll.setViewportView(emptyTempPanel);				
		emptyTempPanel.setPreferredSize(new Dimension(200,250));		
		updateUI();
	}	
  	
	public void set(UmlProject project, RefOntoUML.Package model){
		set(project,model,null);
	}
	
//	public void set(UmlProject project, RefOntoUML.Package model, OclDocument oclDoc){
//		//set models
//		List<OclDocument> list = new ArrayList<OclDocument>();
//		list.add(oclDoc);
//		set(project,model,list);
//	}
	
	public void set(UmlProject project, RefOntoUML.Package model, List<OclDocument> oclDocs){
		//set models
		Models.setProject(project);				
		Models.setRefparser(new OntoUMLParser(model));	
		if(oclDocs!=null){
			for(OclDocument s: oclDocs){
				Models.getOclDocList().add(s);
			}
		}
		String name = ((RefOntoUML.Package)project.getResource().getContents().get(0)).getName();
		if (name==null || name.isEmpty()) name = "model";		
		Models.setAlloySpec(new AlloySpecification(project.getTempDir()+File.separator+name.toLowerCase()+".als"));		
		Models.setOclOptions(new TOCL2AlloyOption());		
		Models.setRefOptions(new OntoUML2AlloyOptions());		
		Models.setAntipatterns(new AntiPatternList());
		
		toolbar = new ProjectToolBar(frame);		
		tree = ProjectTree.create(frame,
			Models.getRefparser(), 
			Models.getOclDocList(), 
			Models.getProject().getDiagrams(),
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
