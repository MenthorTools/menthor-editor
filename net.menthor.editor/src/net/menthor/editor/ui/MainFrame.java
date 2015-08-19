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
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandMap;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.commands.MethodCall;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.menus.MainMenuBar;
import net.menthor.editor.v2.palette.PalettePane;
import net.menthor.editor.v2.toolbars.MainToolbar;
import net.menthor.editor.v2.trees.BaseCheckBoxTree;
import net.menthor.editor.v2.ui.BaseMultiSplitPane;
import net.menthor.editor.v2.util.Util;

import org.tinyuml.ui.diagram.DiagramEditor;

public class MainFrame extends JFrame implements CommandListener {

	private static final long serialVersionUID = 3464348864344034246L;
	
	private transient MainMenuBar mainMenu;
	private transient MainToolbar mainToolBar;	
	private transient BaseMultiSplitPane multiSplitPane;
	private transient PalettePane palettePane;
	private transient ProjectBrowser browserPane;	
	private transient TopViewPane editorsPane;
	private transient BottomViewPane footerPane;
	
	public MainFrame() {
		super();
		super.setIconImage(IconMap.getInstance().getImage(IconType.MENTHOR_APP_ICON));
		setTitle("Menthor Editor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setPreferredSize();		
		if(Util.onMac()) Util.enableFullScreenMode(this);		
		installMainMenu();
//		installMainToolBar();
		installMultiSplitPane();		
		showOnlyStartPage();		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				quitApplication();
				
			}
		});
		pack();
	}
	
	public void quitApplication() {
		if (canQuit()) {					
			getDiagramManager().dispose();
			dispose();
			Thread.currentThread().interrupt();			
			System.gc();
			Runtime.getRuntime().exit(0);
		}
	}	
	
	private void setPreferredSize(){
		Dimension size = new Dimension(1000, 648);
		Dimension minimumSize = new Dimension(700, 650);
		this.setSize(size);
		this.setPreferredSize(size);
		this.setMinimumSize(minimumSize);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
			
	private boolean canQuit() {		
		if(getDiagramManager().getCurrentProject()==null)
			return true;		
		int response = JOptionPane.showOptionDialog(
			this,
			"Do you really want to quit?",
			"Quit application?", 
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			new String[]{"Save and Exit", "Exit without saving", "Cancel"},
			"default");		
		if(response==JOptionPane.YES_OPTION){
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			getDiagramManager().saveProject();			
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));			
			return true;
		}
		if(response==JOptionPane.NO_OPTION){
			return true;
		}
		if(response==JOptionPane.CANCEL_OPTION){
			return false;
		}
		return true;
	}
		
	private void installMainMenu() {
		mainMenu = new MainMenuBar(this);
		setJMenuBar(mainMenu);
	}
	
	@SuppressWarnings("unused")
	private void installMainToolBar(){		
		mainToolBar = new MainToolbar(this);		
		mainToolBar.addCommandListener(getDiagramManager().getCommandListener());
		JPanel panel = new JPanel();		
		panel.setLayout(new BorderLayout(5,5));
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(mainToolBar, BorderLayout.WEST);		
		this.getContentPane().add(panel, BorderLayout.NORTH);
	}

	private void installMultiSplitPane(){		
		editorsPane = new TopViewPane(this);		
		footerPane= new BottomViewPane(this, null);
		browserPane = new ProjectBrowser(this,null,null);
		palettePane = new PalettePane(this);
		multiSplitPane = new BaseMultiSplitPane(palettePane, editorsPane, footerPane, browserPane);
		getContentPane().add(multiSplitPane, BorderLayout.CENTER);
	}	
	
	
	public ProjectBrowser getProjectBrowser(){ return browserPane; }		
	public DiagramManager getDiagramManager() { return editorsPane.getDiagramManager(); }
	public InfoManager getInfoManager() { return footerPane.getInfoManager(); }
//	public MainToolbar getMainToolBar() { return mainToolBar; }
	public MainMenuBar getMainMenu() { return mainMenu; }	
	public PalettePane getToolManager() { return palettePane; }
	public void selectConsole() { footerPane.getInfoManager().selectConsole(); }		
	public void selectWarnings() { footerPane.getInfoManager().selectWarnings(); }	
	public void selectProblems() { footerPane.getInfoManager().selectProblems(); }	
	public void selectStatistic() { footerPane.getInfoManager().selectStatistic(); }
	
	public void forceShowBrowserPane(){
		multiSplitPane.forceShowRightPane();		
		getMainMenu().select(CommandType.PROJECT_BROWSER,true);
	}
	
	public void forceShowPalettePane(){
		multiSplitPane.forceShowLeftPane();
		getMainMenu().select(CommandType.PALETTE_OF_ELEMENTS,true);
	}
	
	public void showOnlyStartPage(){
		multiSplitPane.forceShowOnlyTopPane();
		getMainMenu().select(CommandType.PALETTE_OF_ELEMENTS,false);
		getMainMenu().select(CommandType.CONSOLE,false);		
		getMainMenu().select(CommandType.PROJECT_BROWSER,false);
	}
	
	public boolean isShowPalettePane(){
		return multiSplitPane.isShowLeftPane();
	}
	
	public boolean isShowBrowserPane(){
		return multiSplitPane.isShowRightPane();
	}
	
	public boolean isShowFooterPane(){
		return multiSplitPane.isShowBottomPane();
	}
	
	public void showFooterPane(){
		if(getMainMenu().isSelected(CommandType.CONSOLE)){			
			multiSplitPane.showBottomPane();
			getMainMenu().select(CommandType.CONSOLE,true);			
		}else{			
			multiSplitPane.hideBottomPane();
			getMainMenu().select(CommandType.CONSOLE,false);			
		}		
	}
	
	public void showBrowserPane(){		
		if(getMainMenu().isSelected(CommandType.PROJECT_BROWSER)){
			multiSplitPane.showRightPane();			
			getMainMenu().select(CommandType.PROJECT_BROWSER,true);
		}else{
			multiSplitPane.hideRightPane();
			getMainMenu().select(CommandType.PROJECT_BROWSER,false);
		}		

	}
	
	public void showPalettePane() {		
		if(getMainMenu().isSelected(CommandType.PALETTE_OF_ELEMENTS)){
			multiSplitPane.showLeftPane();
			getMainMenu().select(CommandType.PALETTE_OF_ELEMENTS,true);
		}else{			
			multiSplitPane.hideLeftPane();
			getMainMenu().select(CommandType.PALETTE_OF_ELEMENTS,false);
		}		
	}
	
	//=========================================================================
	
	private MethodCall getMethodCall(String command, Object parameter){
		MethodCall methodcall=null;
		CommandType cmdType = CommandType.valueOf(command);
		if(CommandType.isValueOf(command)){
			if(parameter!=null) CommandMap.getInstance().addParameter(cmdType, parameter);
			methodcall = CommandMap.getInstance().getMethodCall(cmdType);			
		}
		if(methodcall==null){
			System.err.println("A method call could not be found for command type: "+cmdType);
			return null;
		}
		return methodcall;
	}

	private Object callMethod(MethodCall methodcall){
		try{
			if(methodcall.getMethod().getDeclaringClass() == getClass()){
				return methodcall.call(this);
			}else if(methodcall.getMethod().getDeclaringClass() == DiagramManager.class){
				return methodcall.call(getDiagramManager());
			}else if(methodcall.getMethod().getDeclaringClass() == DiagramEditor.class){
				return methodcall.call(getDiagramManager().getCurrentDiagramEditor());
			}else if(methodcall.getMethod().getDeclaringClass() == BaseCheckBoxTree.class){
				return methodcall.call(getProjectBrowser().getTree());		
			}
		}catch(java.lang.IllegalArgumentException e){
			System.err.println("Method not called. Reason: "+e.getLocalizedMessage());
			System.err.println(methodcall);			
		}
		return null;
	}
	
	/** Handles the fired commands. */
	@Override
	public Object handleCommand(String command, Object parameter) {	
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		MethodCall methodcall = getMethodCall(command,parameter);
		System.out.println(methodcall);
		Object result=null;
		if(methodcall!=null) result = callMethod(methodcall);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		return result;		
	}
	
	/** Handles the fired commands. */
	@Override
	public Object handleCommand(String command) {	
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		MethodCall methodcall = getMethodCall(command,null);
		System.out.println(methodcall);
		Object result=null;
		if(methodcall!=null) result = callMethod(methodcall);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		return result;		
	}
	
	//============

	/**
	 * Resets the active palette (in the tool manager) to the default element,
	 * the pointer.
	 * */
	public void selectPaletteDefaultElement() {
		palettePane.getClassPalette().selectDefault();
	}

	public void showErrorMessageDialog(String title, String message){
		JOptionPane.showMessageDialog(
			this,message,title,JOptionPane.ERROR_MESSAGE			
		);	
	}
	
	public void showWarningMessageDialog(String title, String message){
		JOptionPane.showMessageDialog(
			this,message,title,JOptionPane.WARNING_MESSAGE			
		);	
	}
		
	public void showSuccessfulMessageDialog(String title, String message){
		JOptionPane.showMessageDialog(
			this,message,title,JOptionPane.INFORMATION_MESSAGE			
		);
	}
	
	public void showInformationMessageDialog(String title, String message){
		JTextArea textArea = new JTextArea(message);
		textArea.setColumns(30);
		textArea.setLineWrap( true );
		textArea.setWrapStyleWord(true);
		textArea.setSize(textArea.getPreferredSize().width, 1);
		textArea.setBackground(this.getBackground());		
		JOptionPane.showMessageDialog(
			this, textArea,title,JOptionPane.ERROR_MESSAGE
		);
	}
}
