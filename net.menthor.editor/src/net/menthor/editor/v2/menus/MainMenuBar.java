package net.menthor.editor.v2.menus;

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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.KeyStroke;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.util.Util;

public class MainMenuBar extends BaseMenuBar {

	private static final long serialVersionUID = 2698337212571991120L;

	private static Color background = null; //Color.WHITE;
	
	private void createFileMenu(){
		KeyStroke stroke;
		JMenu file = new JMenu("File");
		add(file);
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK);
		createMenuItem(file, "New", CommandType.NEW_PROJECT, background, stroke);		
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK);
		createMenuItem(file, "Open...", CommandType.OPEN_PROJECT, background,stroke);		
		file.addSeparator();
		createMenuItem(file, "Close", CommandType.CLOSE_PROJECT, background);		
		file.addSeparator();		
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);
		createMenuItem(file, "Save", CommandType.SAVE_PROJECT, background,stroke);		
		createMenuItem(file, "Save As...", CommandType.SAVE_PROJECT_AS, background);		
		file.addSeparator();		
		JMenu export = new JMenu("Export");
		file.add(export);		
		createMenuItem(export, "XMI (Ecore Metamodel)", CommandType.EXPORT_TO_XMI, background);
		createMenuItem(export, "UML (UML2)", CommandType.EXPORT_TO_UML, background);
		createMenuItem(export, "Ecore (EMF)", CommandType.EXPORT_TO_ECORE, background);
		createMenuItem(export, "As Pattern (Menthor)", CommandType.EXPORT_AS_PATTERN, background);
		file.addSeparator();
		JMenu importation = new JMenu("Import");
		file.add(importation);
		createMenuItem(importation, "XMI (Ecore Metamodel)", CommandType.IMPORT_FROM_XMI_EMF, background);
		createMenuItem(importation, "XMI (EA)", CommandType.IMPORT_FROM_XMI_EA, background);
		createMenuItem(importation, "From a Pattern (Menthor)", CommandType.IMPORT_FROM_PATTERN, background);		
		file.addSeparator();
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK);
		createMenuItem(file, "Quit", CommandType.QUIT_MENTHOR, background,stroke);
	}
	
	private void createEditMenu(){		
		KeyStroke stroke;
		JMenu edit = new JMenu("Edit");
		add(edit);		
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK);
		createMenuItem(edit, "Undo", CommandType.UNDO, background,stroke);	
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK);
		createMenuItem(edit, "Redo", CommandType.REDO, background,stroke);
		edit.addSeparator();		
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke("BACK_SPACE");
		else stroke = KeyStroke.getKeyStroke("DELETE");
		createMenuItem(edit, "Erase", CommandType.ERASE, background, stroke);	
		edit.addSeparator();
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK);
		createMenuItem(edit, "Delete", CommandType.DELETE, background,stroke);	
	}
	
	private void createVerificateMenu(){
		KeyStroke stroke;
		JMenu verificate = new JMenu("Verificate");
		add(verificate);
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK);
		createMenuItem(verificate, "Parse All Rules", CommandType.PARSE_RULES, background,stroke);
		createMenuItem(verificate, "Check All Model Syntax", CommandType.CHECK_MODEL_SYNTAX, background);
	}
	
	public void selectWindowMenu(boolean projectBrowser, boolean palette, boolean console) {
		select(CommandType.PROJECT_BROWSER, projectBrowser);
		select(CommandType.PALETTE_OF_ELEMENTS, projectBrowser);
		select(CommandType.CONSOLE, projectBrowser);
	}
	
	private void createWindowMenu(){
		JMenu window = new JMenu("Window");
		add(window);
		createCheckBoxMenuItem(window, "Palette of Elements", CommandType.PALETTE_OF_ELEMENTS, background);
		createCheckBoxMenuItem(window, "Console", CommandType.CONSOLE, background);
		createCheckBoxMenuItem(window, "Project Browser", CommandType.PROJECT_BROWSER, background);		
	}
	
	private void createValidateMenu(){		
		JMenu validate = new JMenu("Validate");
		add(validate);		
		createMenuItem(validate, "Visual Simulation (Alloy)", CommandType.SIMULATE_AND_CHECK, background);
		createMenuItem(validate, "Semantic Web (OWL/RDF)", CommandType.IMPLEMENT_IN_OWL, background);
		validate.addSeparator();
		createMenuItem(validate, "Semantic Anti-Patterns", CommandType.SEARCH_FOR_ANTIPATTERNS, background);
		createMenuItem(validate, "Parthood Transitivities", CommandType.VALIDATE_PARTHOOD_TRANSITIVITY, background);
		validate.addSeparator();
		createMenuItem(validate, "Business Vocabulary (SBVR)", CommandType.BUSINESS_VOCABULARY, background);
		createMenuItem(validate, "Natural Language Description (PT-BR)", CommandType.TEXTUAL_DESCRIPTION, background);
		validate.addSeparator();
		createMenuItem(validate, "Information Model (UML)", CommandType.DESIGN_AS_INFO_UML, background);
				
	}
	
	private void createProjectMenu(){
		KeyStroke stroke;
		JMenu project = new JMenu("Project");
		add(project);		
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK);
		createMenuItem(project, "Find", CommandType.FIND_TERM, background,stroke);
		createMenuItem(project, "Collect Statistics", CommandType.COLLECT_STATISTICS, background);
	}
	

	private void createRulesMenu(){
		JMenu rules = new JMenu("Rules");
		add(rules);
		createMenuItem(rules, "New", CommandType.NEW_RULES, background);
		rules.addSeparator();
		createMenuItem(rules, "Close", CommandType.CLOSE_RULES, background);
	}
	
	private void createDiagramMenu(){
		KeyStroke stroke;
		JMenu diagram = new JMenu("Diagram");
		add(diagram);
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK);
		createMenuItem(diagram, "New", CommandType.NEW_DIAGRAM, background,stroke);
		diagram.addSeparator();
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK);
		createMenuItem(diagram, "Close", CommandType.CLOSE_DIAGRAM, background,stroke);
		diagram.addSeparator();		
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK);
		createMenuItem(diagram, "Select All", CommandType.SELECT_ALL_DIAGRAM, background,stroke);
		createMenuItem(diagram, "Redraw", CommandType.REDRAW_DIAGRAM, background);
		createMenuItem(diagram, "Show Grid", CommandType.SHOW_GRID, background);
		diagram.addSeparator();
		createMenuItem(diagram, "Fit to Window", CommandType.FIT_TO_WINDOW, background);
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ActionEvent.CTRL_MASK);
		createMenuItem(diagram, "Zoom In", CommandType.ZOOM_IN, background);
		if(Util.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK);
		createMenuItem(diagram, "Zoom Out", CommandType.ZOOM_OUT, background);
		createMenuItem(diagram, "Zoom at 100%", CommandType.ZOOM_AT_100, background);	
		diagram.addSeparator();
		createMenuItem(diagram, "Save As Image", CommandType.SAVE_DIAGRAM_AS_IMAGE, background);
	}
	
	private void createHelpMenu(){
		JMenu help = new JMenu("Help");
		add(help);		
		createMenuItem(help, "About", CommandType.ABOUT, background);
		createMenuItem(help, "Licenses", CommandType.LICENSES, background);
	}
	
	/** constructor */
	public MainMenuBar(CommandListener listener){
		super(listener, background);
		setBackground(background);		
		createFileMenu();
		createEditMenu();
		createDiagramMenu();
		createRulesMenu();
		createProjectMenu();
		createVerificateMenu();
		createValidateMenu();
		createWindowMenu();
		createHelpMenu();
	}	

}
