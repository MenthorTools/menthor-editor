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

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import net.menthor.editor.ui.DiagramToolbar;
import net.menthor.editor.util.ApplicationResources;
import net.menthor.editor.util.IconLoader;

import org.tinyuml.ui.commands.AppCommandListener;

/**
 * This class manages and creates the application's main toolbar.
 *
 * @author Wei-ju Wu, John Guerson
 */
public class AppToolbar implements ActionListener {

	@SuppressWarnings("unused")
	private AppFrame frame;
	private JToolBar toolbar = new JToolBar();
	private List<AppCommandListener> listeners =
		new ArrayList<AppCommandListener>();
	private Map<String, JButton> jbuttonMap = new HashMap<String, JButton>();
	
	private JButton btnSave;	
	private JToggleButton btnToolBox;
	private JToggleButton btnBrowser;
	private JToggleButton btnBottomView;
	private JButton btnUndo;
	private JButton btnRedo;
	private JButton btnFind;
	@SuppressWarnings("unused")
	private JButton btnNew;
	@SuppressWarnings("unused")
	private JButton btnOpen;
	private JButton btnStats;
	private JButton btnVerify;
	private JButton btnText;
	private JButton btnAlloy;
	private JButton btnOWL;
	private JButton btnSBVR;
	private JButton btnAntiPattern;
	private JButton btnMeronymic;
	
	public JToggleButton getToolBoxButton() { return btnToolBox; }
	public JToggleButton getProjectBrowserButton() { return btnBrowser; }
	public JToggleButton getBottomViewButton() { return btnBottomView; }
	
	public void enableAll(boolean value)
	{
		btnToolBox.setEnabled(value);
		btnBrowser.setEnabled(value);
		btnBottomView.setEnabled(value);
		btnSave.setEnabled(value);
		btnUndo.setEnabled(value);
		btnRedo.setEnabled(value);
		btnStats.setEnabled(value);
		btnFind.setEnabled(value);
		btnStats.setEnabled(value);
		btnVerify.setEnabled(value);
		btnText.setEnabled(value);
		btnAlloy.setEnabled(value);
		btnOWL.setEnabled(value);
		btnSBVR.setEnabled(value);
		btnAntiPattern.setEnabled(value);
		btnMeronymic.setEnabled(value);
	}
	
	/**
	 * Constructor.
	 */
	public AppToolbar(final AppFrame frame) {
		this.frame = frame;
		
		
		btnNew = createButton("new");
		//createButton("newdiagram");
		btnOpen = createButton("open");
		btnSave = createButton("save");		
		//createButton("cut");
		//createButton("copy");
		//createButton("paste");
		btnUndo = createButton("undo");
		btnRedo = createButton("redo");
		btnFind = createButton("find");		
				
		btnToolBox = new JToggleButton("");
		btnToolBox.setSelected(frame.getMainMenu().isSelected("TOOLBOX"));
		btnToolBox.setToolTipText("Show/hide Toolbox Sidebar");
		btnToolBox.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		frame.getMainMenu().getToolBoxItem().setSelected(btnToolBox.isSelected());
        		frame.showToolBox();
        	}
        });
		btnToolBox.setFocusable(false);
		btnToolBox.setIcon(new ImageIcon(DiagramToolbar.class.getResource("/resources/icons/x16/hammer_screwdriver.png")));
		toolbar.add(btnToolBox);
		
		btnBrowser = new JToggleButton("");
		btnBrowser.setSelected(frame.getMainMenu().isSelected("BROWSER"));
		btnBrowser.setToolTipText("Show/hide Project Browser");
		btnBrowser.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		frame.getMainMenu().getProjectBrowserItem().setSelected(btnBrowser.isSelected());
        		frame.showProjectBrowser();
        	}
        });
		btnBrowser.setFocusable(false);
		btnBrowser.setIcon(new ImageIcon(DiagramToolbar.class.getResource("/resources/icons/x16/door_in.png")));
		toolbar.add(btnBrowser);
		
		btnBottomView = new JToggleButton("");
		btnBottomView.setSelected(frame.getMainMenu().isSelected("BOTTOMVIEW"));
		btnBottomView.setToolTipText("Show/hide Information Footer");
		btnBottomView.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		frame.getMainMenu().getBottomViewItem().setSelected(btnBottomView.isSelected());
        		frame.showBottomView();
        	}
        });
		btnBottomView.setFocusable(false);
		btnBottomView.setIcon(new ImageIcon(AppToolbar.class.getResource("/resources/icons/x16/layout_select_footer.png")));
		toolbar.add(btnBottomView);
				
		btnStats = createButton("statistics");
		
		btnVerify = createButton("verify");
		
		toolbar.addSeparator();
		btnText = createButton("generatetext");
		btnText.setToolTipText("" +
			"<html>Glossary of Terms: Transform your ontology into a Textual Description in Portuguese-BR.<br><br>"+
			"TIP: You may customize which packages or elements do you want to transform <br>" +
			"just deselecting/selecting them on the project browser.<br><br>" +
			"</html>");
		btnAlloy = createButton("generatealloy");
		btnAlloy.setToolTipText("" +
			"<html>Simulation & Checking: Validate your ontology using Alloy and its Analyzer. <br><br>"+
			"TIP: You may customize which packages or elements do you want to transform <br>" +
			"just deselecting/selecting them on the project browser.<br><br>" +
			"</html>");		
		btnOWL = createButton("generateowlsettings");
		btnOWL.setToolTipText("" +
			"<html>Semantic Web: Publish and Reason over your ontology using OWL/SWRL.<br><br>"+
			"TIP: You may customize which packages or elements  do you want to transform <br>" +
			"just deselecting/selecting them on the project browser.<br><br>" +
			"</html>");
		btnSBVR = createButton("generatesbvr");
		btnSBVR.setToolTipText("" +
			"<html>Business Vocabulary: Transform your ontology into a SBVR Document in HTML.<br><br>"+
			"TIP: You may customize which packages or elements  do you want to transform <br>" +
			"just deselecting/selecting them on the project browser.<br><br>" +
			"</html>");
		btnAntiPattern = createButton("antipattern");
		btnAntiPattern.setToolTipText("" +
			"<html>Anti-Patterns: Check and Fix your ontology detecting Anti-Patterns occurrences, if any. <br><br>"+
			"TIP: You may customize which packages or elements do you want to consider <br>" +
			"just deselecting/selecting them on the project browser.<br><br>" +
			"</html>");	
		btnMeronymic = createButton("partwhole");
		btnMeronymic.setToolTipText("" +
			"<html>Part-Whole Relations: Evaluate your ontology regarding the transitivity of meronymic relations.<br><br>"+
			"TIP: You may customize which packages or elements do you want to consider <br>" +
			"just deselecting/selecting them on the project browser.<br><br>" +
			"</html>");	
		enableButton("UNDO", true);
		enableButton("REDO", true);
		//enableButton("CUT", false);
		//enableButton("COPY", false);
		//enableButton("PASTE", false);
		
		toolbar.setFloatable(false);
		toolbar.setMargin(new Insets(5,5,5,5));
		
		enableAll(false);
	}

	/**
	 * Returns the toolbar.
	 * @return the toolbar
	 */
	public JToolBar getToolbar() { return toolbar; }

	/**
	 * Adds a CommandListener.
	 * @param l the CommandListener to add
	 */
	public void addCommandListener(AppCommandListener l) {
		listeners.add(l);
	}

	public void enableSaveButton(boolean value)
	{
		btnSave.setEnabled(value);
	}
	
	/**
	 * Creates the button with the specified name.
	 * @param name the resource name
	 * @return the button
	 */
	private JButton createButton(String name) {
		String prefix = "maintoolbar." + name;
		JButton button = new JButton(
				IconLoader.getInstance().getIcon(getResourceString(prefix + ".icon")));
		button.setMargin(new Insets(1, 1, 1, 1));
		String command = getResourceString(prefix + ".command");
		button.setActionCommand(command);
		button.addActionListener(this);
		button.setBorderPainted(false);
	    button.setFocusable(false);
		jbuttonMap.put(command, button);
		toolbar.add(button);
		button.setToolTipText(getResourceString(prefix + ".tooltip"));
		return button;
	}

	/**
	 * Returns the specified resource as a String object.
	 * @param property the property name
	 * @return the property value or null if not found
	 */
	private String getResourceString(String property) {
		return ApplicationResources.getInstance().getString(property);
	}

	/**
	 * {@inheritDoc}
	 */
	public void actionPerformed(ActionEvent e) {
		for (AppCommandListener l : listeners) {
			l.handleCommand(e.getActionCommand());
		}
	}

	/**
	 * Enables or disables the specified button associated with a command.
	 * @param command the action command string
	 * @param flag true if enabled, false to disable
	 */
	public void enableButton(String command, boolean flag) {
		jbuttonMap.get(command).setEnabled(flag);
	}
}
