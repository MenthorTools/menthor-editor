package net.menthor.editor.v2.settings;

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
import java.awt.Component;
import java.awt.Frame;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import net.menthor.editor.ui.FilterPane;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.ui.ProgressPane;
import RefOntoUML.parser.OntoUMLParser;

public class BaseSettingsDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = -4770351584655675698L;
	
	protected CommandListener listener;
	
	protected OntoUMLParser refparser;
	protected List<OntoumlDiagram> diagrams;	
	
	protected FilterPane filterPane = new FilterPane();
	public FilterPane getFilter() { return filterPane; }
	
	protected JButton btnOk;
	public JButton getOkButton() { return btnOk; }
	
	protected JButton btnCancel;			
	public JButton getCancelButton() { return btnCancel; }
	
	protected JTabbedPane tabbedPane = new JTabbedPane();
	protected JPanel principalPane;	
	
	protected ProgressPane progressPane;
	public ProgressPane getProgressPane() { return progressPane; }
	
	protected BaseSettingsDialog(CommandListener listener, OntoUMLParser refparser, List<OntoumlDiagram> diagrams){
		super((Frame)listener, false);		
		this.listener = listener;
		this.refparser = refparser;
		this.diagrams=diagrams;		
		this.progressPane = new ProgressPane();
		filterPane.fillContent(refparser, diagrams);				
		getContentPane().add(tabbedPane, BorderLayout.CENTER);		
		getContentPane().add(progressPane, BorderLayout.SOUTH);		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);			
		setSize(new java.awt.Dimension(550, 420));		
	}

	/** Add Non Closable Tab */
	protected Component addNonClosable(String text, Component component){
		if (component==null) component = new JPanel();
		tabbedPane.addTab(text, component);		
		tabbedPane.setSelectedComponent(component);
		return component;
	}
}

