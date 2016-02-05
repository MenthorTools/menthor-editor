
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
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import org.tinyuml.ui.diagram.DiagramEditor;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandMap;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.commands.MethodCall;
import net.menthor.editor.v2.managers.AdditionManager;
import net.menthor.editor.v2.managers.AlignManager;
import net.menthor.editor.v2.managers.AlloyManager;
import net.menthor.editor.v2.managers.AntiPatternManager;
import net.menthor.editor.v2.managers.ChangeManager;
import net.menthor.editor.v2.managers.ClipboardManager;
import net.menthor.editor.v2.managers.ConnectManager;
import net.menthor.editor.v2.managers.CursorManager;
import net.menthor.editor.v2.managers.DeletionManager;
import net.menthor.editor.v2.managers.DuplicateManager;
import net.menthor.editor.v2.managers.EditManager;
import net.menthor.editor.v2.managers.ErrorManager;
import net.menthor.editor.v2.managers.ExportManager;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.FilterManager;
import net.menthor.editor.v2.managers.FindManager;
import net.menthor.editor.v2.managers.GlossaryManager;
import net.menthor.editor.v2.managers.HelpManager;
import net.menthor.editor.v2.managers.ImportManager;
import net.menthor.editor.v2.managers.MoveManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.OwlManager;
import net.menthor.editor.v2.managers.ParthoodManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.RedoManager;
import net.menthor.editor.v2.managers.RemakeManager;
import net.menthor.editor.v2.managers.RenameManager;
import net.menthor.editor.v2.managers.SbvrManager;
import net.menthor.editor.v2.managers.StatisticsManager;
import net.menthor.editor.v2.managers.SyntaxManager;
import net.menthor.editor.v2.managers.TabManager;
import net.menthor.editor.v2.managers.TransferManager;
import net.menthor.editor.v2.managers.UndoManager;
import net.menthor.editor.v2.managers.UpdateManager;
import net.menthor.editor.v2.managers.WarningManager;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.ui.menubar.AppMenuBar;
import net.menthor.editor.v2.ui.palette.AppPalette;
import net.menthor.editor.v2.ui.splitpane.AppMultiSplitPane;
import net.menthor.editor.v2.ui.tabbedpane.AppEditorTabbedPane;
import net.menthor.editor.v2.ui.tabbedpane.AppInfoTabbedPane;
import net.menthor.editor.v2.ui.toolbar.AppToolBar;
import net.menthor.editor.v2.ui.tree.AppProjectBrowser;
import net.menthor.editor.v2.ui.tree.BaseCheckBoxTree;
import net.menthor.editor.v2.util.Util;

public class AppFrame extends JFrame implements CommandListener {

	private static final long serialVersionUID = 3464348864344034246L;
	
	private transient AppMenuBar appMenu;
	private transient AppToolBar appToolBar;	
	private transient AppMultiSplitPane appSplitPane;
	private transient AppPalette appPallete;
	private transient AppProjectBrowser appProjectBrowser;	
	private transient AppEditorTabbedPane appEditorTabbedPane;
	private transient AppInfoTabbedPane appInfoTabbedPane;
	
	public AppProjectBrowser getProjectBrowser(){ return appProjectBrowser; }		
	public AppEditorTabbedPane getEditorTabbedPane() { return appEditorTabbedPane; }
	public AppInfoTabbedPane getInfoTabbedPane() { return appInfoTabbedPane; }
	public AppPalette getPallete() { return appPallete; }
	
	public void initializeFrame(File projectFile){
		initializeFrame(projectFile,true);
	}
	
	public void initializeFrame(File projectFile, boolean forceDefaultUI){
		JRootPane root = getRootPane( );
		root.putClientProperty("Window.documentFile", projectFile);
		setTitle(projectFile.getName().replace(".menthor","")+" - Menthor Editor");
		if(forceDefaultUI){
			forceDefaultUI();
		}
	}
	
	public void resetFrame(){
		setTitle("Menthor Editor");
		appMenu.disactivateSomeToBegin();
		appMenu.selectWindowMenu(false, false, false);
		appSplitPane.forceShowOnlyTopPane();
	}
	
	public boolean quitApplication() throws IOException {
		if (canQuit()) {					
			getEditorTabbedPane().dispose();
			dispose();
			Thread.currentThread().interrupt();			
			System.gc();
			Runtime.getRuntime().exit(0);
			return true;
		}else{
			return false;
		}
	}	
	
	public AppFrame() {
		super();
		super.setIconImage(IconMap.getInstance().getImage(IconType.MENTHOR_APP_ICON));
		setTitle("Menthor Editor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setPreferredSize();		
		if(Util.onMac()) Util.enableFullScreenMode(this);	
		RefOntoUMLEditingDomain.getInstance().initialize();
		buildComponents();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					quitApplication();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		pack();
	}
	
	@SuppressWarnings("unused")
	private void buildMenuBar(){
		appToolBar = new AppToolBar(this);		
		appToolBar.addCommandListener(this);
		JPanel panel = new JPanel();		
		panel.setLayout(new BorderLayout(5,5));
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(appToolBar, BorderLayout.WEST);		
		this.getContentPane().add(panel, BorderLayout.NORTH);
	}
	
	private void buildComponents(){
		appMenu = new AppMenuBar(this);
		setJMenuBar(appMenu);		
		appInfoTabbedPane= new AppInfoTabbedPane();
		appEditorTabbedPane = new AppEditorTabbedPane();
		appProjectBrowser = new AppProjectBrowser(this);
		appPallete = new AppPalette(this);				
		appSplitPane = new AppMultiSplitPane(appPallete, appEditorTabbedPane, appInfoTabbedPane, appProjectBrowser);
		getContentPane().add(appSplitPane, BorderLayout.CENTER);
	}
	
	private boolean canQuit() throws IOException {		
		if(ProjectManager.get().getProject()==null) return true;		
		int response = JOptionPane.showOptionDialog(
			this, "Do you really want to quit?", "Quit application?", 
			JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
			new String[]{"Save and Exit", "Exit without saving", "Cancel"},
			"default"
		);		
		if(response==JOptionPane.YES_OPTION){
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			ProjectManager.get().saveProject();			
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
	
	private void setPreferredSize(){
		Dimension size = new Dimension(1000, 648);
		Dimension minimumSize = new Dimension(700, 650);
		this.setSize(size);
		this.setPreferredSize(size);
		this.setMinimumSize(minimumSize);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
		
	//---- menu -----
	
	
	public void initializeShowGridMenuItem(boolean value){
		appMenu.getMenuItem(CommandType.SHOW_GRID).setSelected(value);
	}
	
	public void selectShowGridMenuItem(boolean value){
		appMenu.select(CommandType.SHOW_GRID,value);
	}
	
	
	//---- splitpane -----
	
	public boolean isShowPalettePane(){
		return appSplitPane.isShowLeftPane();
	}
	
	public boolean isShowBrowserPane(){
		return appSplitPane.isShowRightPane();
	}
	
	public boolean isShowFooterPane(){
		return appSplitPane.isShowBottomPane();
	}
	
	//---- menu & splitpane -----
	
	public void forceDefaultUI(){
		forceShowBrowserPane();
		forceShowPalettePane();
		appMenu.activateAll();
	}
	
	public void forceShowBrowserPane(){
		appSplitPane.forceShowRightPane();		
		appMenu.select(CommandType.PROJECT_BROWSER,true);
	}
	
	public void showFooterPane(){		
		if(appMenu.isSelected(CommandType.INFO_TABBED_PANE)){			
			appSplitPane.showBottomPane();
			appMenu.select(CommandType.INFO_TABBED_PANE,true);			
		}else{			
			appSplitPane.hideBottomPane();
			appMenu.select(CommandType.INFO_TABBED_PANE,false);			
		}		
	}
	
	public void showBrowserPane(){		
		if(appMenu.isSelected(CommandType.PROJECT_BROWSER)){
			appSplitPane.showRightPane();			
			appMenu.select(CommandType.PROJECT_BROWSER,true);
		}else{
			appSplitPane.hideRightPane();
			appMenu.select(CommandType.PROJECT_BROWSER,false);
		}		

	}
	
	public void showPalettePane() {		
		if(appMenu.isSelected(CommandType.PALETTE)){
			appSplitPane.showLeftPane();
			appMenu.select(CommandType.PALETTE,true);
		}else{			
			appSplitPane.hideLeftPane();
			appMenu.select(CommandType.PALETTE,false);
		}		
	}
	
	public void forceShowPalettePane(){
		appSplitPane.forceShowLeftPane();
		appMenu.select(CommandType.PALETTE,true);
	}
	
	public void forceShowFooterPane(){
		if(!isShowFooterPane()) { 
			appMenu.select(CommandType.INFO_TABBED_PANE,true); 
		}
		showFooterPane();
	}
	
	//--- command listener ----
	
	private MethodCall getMethodCall(String command, Object[] parameters){
		MethodCall methodcall=null;		
		CommandType cmdType = CommandType.valueOf(command);
		if(CommandType.isValueOf(command)){
			if(parameters!=null) CommandMap.getInstance().addParameters(cmdType, parameters);			
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
			}else if(methodcall.getMethod().getDeclaringClass() == AppEditorTabbedPane.class){
				return methodcall.call(getEditorTabbedPane());
				
			}else if(methodcall.getMethod().getDeclaringClass() == AdditionManager.class){
				return methodcall.call(AdditionManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ChangeManager.class){
				return methodcall.call(ChangeManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DeletionManager.class){
				return methodcall.call(DeletionManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == EditManager.class){
				return methodcall.call(EditManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == FilterManager.class){
				return methodcall.call(FilterManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == HelpManager.class){
				return methodcall.call(HelpManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == MoveManager.class){
				return methodcall.call(MoveManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == OccurenceManager.class){
				return methodcall.call(OccurenceManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == ProjectManager.class){
				return methodcall.call(ProjectManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RemakeManager.class){
				return methodcall.call(RemakeManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == TransferManager.class){
				return methodcall.call(TransferManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == UpdateManager.class){
				return methodcall.call(UpdateManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RenameManager.class){
				return methodcall.call(RenameManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == SbvrManager.class){
				return methodcall.call(SbvrManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ExportManager.class){
				return methodcall.call(ExportManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ImportManager.class){
				return methodcall.call(ImportManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == AlloyManager.class){
				return methodcall.call(AlloyManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == SyntaxManager.class){
				return methodcall.call(SyntaxManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == AntiPatternManager.class){
				return methodcall.call(AntiPatternManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == UndoManager.class){
				return methodcall.call(UndoManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RedoManager.class){
				return methodcall.call(RedoManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == OwlManager.class){
				return methodcall.call(OwlManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DuplicateManager.class){
				return methodcall.call(DuplicateManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ClipboardManager.class){
				return methodcall.call(ClipboardManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ConnectManager.class){
				return methodcall.call(ConnectManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == OccurenceManager.class){
				return methodcall.call(OccurenceManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ParthoodManager.class){
				return methodcall.call(ParthoodManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == GlossaryManager.class){
				return methodcall.call(GlossaryManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == TabManager.class){
				return methodcall.call(TabManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == FindManager.class){
				return methodcall.call(FindManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == WarningManager.class){
				return methodcall.call(WarningManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ErrorManager.class){
				return methodcall.call(ErrorManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == StatisticsManager.class){
				return methodcall.call(StatisticsManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == FactoryManager.class){
				return methodcall.call(FactoryManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == AlignManager.class){
				return methodcall.call(AlignManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DiagramEditor.class){
				return methodcall.call(TabManager.get().getCurrentDiagramEditor());
			}else if(methodcall.getMethod().getDeclaringClass() == BaseCheckBoxTree.class){
				return methodcall.call(appProjectBrowser.getTree());		
			}
		}catch(java.lang.IllegalArgumentException e){
			System.err.println("Method not called. Reason: "+e.getLocalizedMessage());
			System.err.println(methodcall);			
		}
		return null;
	}
	
	/** Handles the fired commands. */
	@Override
	public Object handleCommand(String command, Object[] parameters) {	
		CursorManager.get().waitCursor();		
		MethodCall methodcall = getMethodCall(command,parameters);
		System.out.println(methodcall);
		Object result=null;
		if(methodcall!=null) result = callMethod(methodcall);
		CursorManager.get().defaultCursor();
		return result;		
	}
	
	/** Handles the fired commands. */
	@Override
	public Object handleCommand(String command) {	
		CursorManager.get().waitCursor();
		MethodCall methodcall = getMethodCall(command,null);
		System.out.println(methodcall);
		Object result=null;
		if(methodcall!=null) result = callMethod(methodcall);
		CursorManager.get().defaultCursor();
		return result;		
	}
}
