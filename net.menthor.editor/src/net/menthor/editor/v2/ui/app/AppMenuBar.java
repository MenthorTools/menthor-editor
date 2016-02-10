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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.managers.TabManager;
import net.menthor.editor.v2.ui.generic.GenericMenuBar;
import net.menthor.editor.v2.util.SystemUtil;

public class AppMenuBar extends GenericMenuBar {

	private static final long serialVersionUID = 2698337212571991120L;

	private static Color background = null; //Color.WHITE;
	
	private JMenu importation;
	private JMenu export;
	private JMenu edit;
	private JMenu evaluation;
	private JMenu transformation;	
	private JMenu rules;
	private JMenu project; 
	private JMenu diagram;
	private JMenu help;
	private JMenu window;
	
	/** constructor */
	public AppMenuBar(ICommandListener listener){
		super(listener, background);
		setBackground(background);		
		createFileMenu();
		createEditMenu();
		createDiagramMenu();
		createRulesMenu();
		createProjectMenu();
		createEvaluationMenu();
		createTransformationMenu();		
		createWindowMenu();
		createHelpMenu();
		disactivateSomeToBegin();
	}	
	
	public void disactivateSomeToBegin(){
		//menu items
		getMenuItem(CommandType.SAVE_PROJECT).setEnabled(false);
		getMenuItem(CommandType.SAVE_PROJECT).setEnabled(false);
		getMenuItem(CommandType.CLOSE_PROJECT).setEnabled(false);
		//menus
		export.setEnabled(false);		
		edit.setEnabled(false);
		evaluation.setEnabled(false);
		transformation.setEnabled(false);
		rules.setEnabled(false);
		project.setEnabled(false); 
		diagram.setEnabled(false);	
		window.setEnabled(false);
	}
	
	public void activateAll(){
		//menu items
		visibleAll(true); 
		enableAll(true);
		//menus
//		importation.setVisible(true);
		importation.setEnabled(true);
//		export.setVisible(true);
		export.setEnabled(true);
//		edit.setVisible(true);
		edit.setEnabled(true);
//		evaluation.setVisible(true);
		evaluation.setEnabled(true);
//		transformation.setVisible(true);
		transformation.setEnabled(true);
//		rules.setVisible(true);
		rules.setEnabled(true);
//		project.setVisible(true);
		project.setEnabled(true);
//		diagram.setVisible(true);
		diagram.setEnabled(true);
//		help.setVisible(true);
		help.setEnabled(true);
//		window.setVisible(true);
		window.setEnabled(true);
	}
	
	private void createFileMenu(){
		KeyStroke stroke;
		JMenu file = new JMenu("File");
		add(file);
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK);
		createMenuItem(file, "New", CommandType.NEW_PROJECT, background, stroke);		
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK);
		createMenuItem(file, "Open...", CommandType.OPEN_EXISTING_PROJECT, background,stroke);		
		file.addSeparator();
		createMenuItem(file, "Close", CommandType.CLOSE_PROJECT, background);		
		file.addSeparator();		
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);
		createMenuItem(file, "Save", CommandType.SAVE_PROJECT, background,stroke);		
		createMenuItem(file, "Save As...", CommandType.SAVE_PROJECT_AS, background);		
		file.addSeparator();		
		export = new JMenu("Export As");
		file.add(export);		
		createMenuItem(export, "XMI (.refontouml)", CommandType.EXPORT_TO_REFERENCE_ONTOUML, background);
		createMenuItem(export, "UML2 (.uml)", CommandType.EXPORT_TO_UML, background);
		createMenuItem(export, "Profile UML2 (.uml)", CommandType.EXPORT_TO_PROFILE_UML, background);
		createMenuItem(export, "Ecore (.ecore)", CommandType.EXPORT_TO_ECORE, background);		
		file.addSeparator();
		importation = new JMenu("Import From");
		file.add(importation);
		createMenuItem(importation, "XMI (.refontouml)", CommandType.IMPORT_FROM_XMI_EMF, background);
		createMenuItem(importation, "EA (.xml)", CommandType.IMPORT_FROM_XMI_EA, background);				
		file.addSeparator();
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK);
		/*if(Util.onMac()){
			 Application.getApplication().setQuitHandler(new QuitHandler(){
				@Override
				public void handleQuitRequestWith(QuitEvent arg0, QuitResponse resp) {
					if(!MenthorEditor.frame.quitApplication()){
					 	resp.cancelQuit();
					 }
				}
			});
			
			 
		}else{
		*/
			createMenuItem(file, "Quit", CommandType.QUIT_APPLICATION, background,stroke);
		//}
	}
	
	private void createEditMenu(){		
		KeyStroke stroke;
		edit = new JMenu("Edit");
		add(edit);		
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK);
		createMenuItem(edit, "Undo", CommandType.UNDO, background,stroke);	
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK);
		createMenuItem(edit, "Redo", CommandType.REDO, background,stroke);
		edit.addSeparator();
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK);
		createMenuItem(edit, "Copy", CommandType.COPY, background, stroke);
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK);
		createMenuItem(edit, "Paste", CommandType.PASTE, background, stroke);
		createMenuItem(edit, "Duplicate", CommandType.DUPLICATE, background);
		edit.addSeparator();
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke("BACK_SPACE");
		else stroke = KeyStroke.getKeyStroke("DELETE");
		createMenuItem(edit, "Erase", CommandType.ERASE, background, stroke);	
		edit.addSeparator();
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK);
		createMenuItem(edit, "Delete", CommandType.DELETE, background,stroke);	
	}
	
	private void createEvaluationMenu(){
		KeyStroke stroke;
		evaluation = new JMenu("Evaluate");
		add(evaluation);
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK);
		createMenuItem(evaluation, "Check Rules", CommandType.VERIFY_CONSTRAINTS, background,stroke);
		createMenuItem(evaluation, "Check Model", CommandType.VERIFY_MODEL, background);
		evaluation.addSeparator();
		createMenuItem(evaluation, "Visual Simulation (Alloy)", CommandType.ALLOY_SETTINGS, background);		
		evaluation.addSeparator();
		createMenuItem(evaluation, "Semantic Anti-Patterns", CommandType.SEARCH_FOR_ANTIPATTERNS, background);
		createMenuItem(evaluation, "Parthood Transitivities", CommandType.VALIDATE_PARTHOOD_TRANSITIVITY, background);
	}
	
	public void selectWindowMenu(boolean projectBrowser, boolean palette, boolean infoTabbedPane) {
		select(CommandType.SHOW_PROJECT_BROWSER, projectBrowser);
		select(CommandType.SHOW_PALETTE, projectBrowser);
		select(CommandType.SHOW_INFO_TABBED_PANE, projectBrowser);
	}
	
	private void createWindowMenu(){
		window = new JMenu("Window");
		add(window);
		createCheckBoxMenuItem(window, "Palette of Elements", CommandType.SHOW_PALETTE, background);
		createCheckBoxMenuItem(window, "Console", CommandType.SHOW_INFO_TABBED_PANE, background);
		createCheckBoxMenuItem(window, "Project Browser", CommandType.SHOW_PROJECT_BROWSER, background);	
		selectWindowMenu(false, false, false);
	}

	private void createTransformationMenu(){
		transformation = new JMenu("Transform");
		add(transformation);		
		createMenuItem(transformation, "Semantic Web (OWL/RDF)", CommandType.OWL_SETTINGS, background);		
		transformation.addSeparator();
		createMenuItem(transformation, "Business Vocabulary (SBVR)", CommandType.GENERATE_SBVR, background);
		createMenuItem(transformation, "Natural Language Description (PT-BR)", CommandType.GLOSSARY_SETTINGS, background);
	}
		
	private void createProjectMenu(){
		KeyStroke stroke;
		project = new JMenu("Project");
		add(project);		
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK);
		createMenuItem(project, "Find", CommandType.ADD_FINDER_EDITOR, background,stroke);
		createMenuItem(project, "Statistics", CommandType.ADD_STATISTICS_EDITOR, background);
	}	

	private void createRulesMenu(){
		rules = new JMenu("Rules");
		add(rules);
		createMenuItem(rules, "New", CommandType.NEW_OCLDOCUMENT, background);
		rules.addSeparator();
		createMenuItem(rules, "Close", CommandType.CLOSE_OCL_EDITOR, background);
	}
	
	private void createDiagramMenu(){		
		diagram = new JMenu("Diagram");
		diagram.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) { 
				for(ICommandListener l: getListeners()) {
					l.handleCommand(CommandType.INITIALIZE_SHOWGRID_MENUITEM.toString());
				}
			}
			@Override
			public void menuDeselected(MenuEvent e){}			
			@Override
			public void menuCanceled(MenuEvent e){}
		});		
		add(diagram);
		KeyStroke stroke;
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK);
		createMenuItem(diagram, "New", CommandType.NEW_DIAGRAM, background,stroke);
		diagram.addSeparator();
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK);
		createMenuItem(diagram, "Close", CommandType.CLOSE_DIAGRAM_EDITOR, background,stroke);
		diagram.addSeparator();		
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK);
		createMenuItem(diagram, "Select All", CommandType.SELECT_ALL_DIAGRAM, background,stroke);
		createMenuItem(diagram, "Redraw", CommandType.REDRAW_DIAGRAM, background);		
		createCheckBoxMenuItem(diagram, "Show Grid", CommandType.SHOW_GRID, background);
		diagram.addSeparator();
		createMenuItem(diagram, "Fit to Window", CommandType.FIT_TO_WINDOW, background);
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ActionEvent.CTRL_MASK);
		createMenuItem(diagram, "Zoom In", CommandType.ZOOM_IN, background);
		if(SystemUtil.onMac()) stroke = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.META_MASK);
		else stroke = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK);
		createMenuItem(diagram, "Zoom Out", CommandType.ZOOM_OUT, background);
		createMenuItem(diagram, "Zoom at 100%", CommandType.ZOOM_AT_100, background);	
		diagram.addSeparator();
		createMenuItem(diagram, "Save As Image", CommandType.EXPORT_TO_PNG, background);
	}
	
	private void createHelpMenu(){
		help = new JMenu("Help");
		add(help);
		/*if(Util.onMac()){
			Application.getApplication().setAboutHandler(new AboutHandler(){
				@Override
				public void handleAbout(AboutEvent arg0) {
					AboutDialog.open(MenthorEditor.frame,MenthorEditor.MENTHOR_COMPILATION_DATE,MenthorEditor.MENTHOR_VERSION);
				}		
			});
		 
		}else{
		*/
			createMenuItem(help, "About", CommandType.ABOUT, background);
		//}	
		createMenuItem(help, "Licenses", CommandType.LICENSES, background);
	}
	
	public void initializeShowGrid(){
		boolean isShownGrid = TabManager.get().getCurrentDiagramEditor().isShownGrid();
		getMenuItem(CommandType.SHOW_GRID).setSelected(isShownGrid);
	}
	
	public void selectShowGrid(boolean value){
		select(CommandType.SHOW_GRID,value);
	}	
}
