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

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import org.jdesktop.swingx.MultiSplitLayout;
import org.jdesktop.swingx.MultiSplitPane;
import org.tinyuml.ui.commands.AppCommandDispatcher;
import org.tinyuml.ui.commands.AppCommandListener;

import edu.mit.csail.sdg.alloy4whole.SimpleGUICustom;
import net.menthor.editor.explorer.ProjectBrowser;
import net.menthor.editor.util.ApplicationResources;
import net.menthor.editor.util.MethodCall;
import net.menthor.resources.icons.CommandMap;
import net.menthor.resources.icons.CommandType;
import net.menthor.resources.icons.IconMap;

/**
 * @author Wei-ju Wu, John Guerson
 */
public class AppFrame extends JFrame implements AppCommandListener {

	private static final long serialVersionUID = 3464348864344034246L;
	
	private transient AppMenu mainMenu;
	private transient NewAppToolbar mainToolBar;
	
	private transient ToolboxPane toolManager;
	private transient TopViewPane topPane;
	private transient BottomViewPane bottomPane;
//	private transient DiagramManager diagramManager;
//	private transient InfoManager infoManager;
	private transient ProjectBrowserPane browserManager;
	
	private transient SimpleGUICustom analyzer;

	private transient MultiSplitPane multiSplitPane;

	private int browserWidth=230;
	private int toolboxWidth=230;
	private int infoHeight=200;
	
	/**
	 * Default constructor.
	 * */
	public AppFrame() {
		super();
		super.setIconImage(IconMap.getInstance().getImage("WINDOW"));
		setTitle(getResourceString("application.title"));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setPreferredSize();
		
		if(onMac()) {
			enableFullScreenMode(this);
		}
		
		installManagers();
		installMainMenu();
		installMainToolBar();
			  
		openOnlyStartPage();
		
			addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				quitApplication();
				Main.printOutLine("Menthor application closed");
			}
		});

		pack();
	}
		
	/** Returns true iff running on Mac OS X. **/
	public boolean onMac() {
      return System.getProperty("mrj.version")!=null || System.getProperty("os.name").toLowerCase(Locale.US).startsWith("mac ");                                     
	}
	
	public void enableFullScreenMode(Window window) {
        String className = "com.apple.eawt.FullScreenUtilities";
        String methodName = "setWindowCanFullScreen";
 
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, new Class<?>[] {
                    Window.class, boolean.class });
            method.invoke(null, window, true);
        } catch (Throwable t) {
            System.err.println("Full screen mode is not supported");
            t.printStackTrace();
        }
    }
	
	public void setPreferredSize()
	{
		Dimension size = new Dimension(1000, 648);
		Dimension minimumSize = new Dimension(700, 650);
		this.setSize(size);
		this.setPreferredSize(size);
		this.setMinimumSize(minimumSize);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
			
	public void setAlloyAnalyzer(SimpleGUICustom analyzer){
		this.analyzer = analyzer;
	}
	

	/**
	 * Adds the main menu.
	 */
	private void installMainMenu() {
		mainMenu = new AppMenu(this);
		mainMenu.addCommandListener(this);
		mainMenu.addCommandListener(getDiagramManager().getEditorDispatcher());
		setJMenuBar(mainMenu.getMenuBar());
	}
	
	/**
	 * Adds the main toolbar
	 */
	private void installMainToolBar() 
	{		
		mainToolBar = new NewAppToolbar(this);
		mainToolBar.addCommandListener(this);
		mainToolBar.addCommandListener(getDiagramManager().getEditorDispatcher());
		JPanel panel = new JPanel();		
		panel.setLayout(new BorderLayout(5,5));
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.add(mainToolBar, BorderLayout.WEST);		
		this.getContentPane().add(panel, BorderLayout.NORTH);
		//this.getContentPane().add(mainToolBar.getToolbar(), BorderLayout.NORTH);
	}

	public ProjectBrowser getProjectBrowser(){
		return browserManager.getProjectBrowser();
	}
	
	public ProjectBrowserPane getBrowserManager() {
		return browserManager;
	}
	
	public DiagramManager getDiagramManager() {
		return topPane.getDiagramManager();
	}
			
	public NewAppToolbar getMainToolBar()
	{
		return mainToolBar;
	}
	
	public static int GetScreenWorkingWidth() {
	    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
	}

	public static int GetScreenWorkingHeight() {
	    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	}

	public void openProjectBrowser()
	{
		int dividerSize = multiSplitPane.getMultiSplitLayout().getDividerSize();
		browserManager.getProjectBrowser().setPreferredSize(new Dimension(browserWidth,250));
		browserManager.setPreferredSize(new Dimension(browserWidth,250));
		toolManager.setPreferredSize(new Dimension(toolManager.getSize().width,250));
		toolManager.getPalleteAccordion().setPreferredSize(new Dimension(toolManager.getSize().width,250));
		bottomPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-browserWidth-toolManager.getSize().width-(2*dividerSize),bottomPane.getSize().height));
		topPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-browserWidth-toolManager.getSize().width-(2*dividerSize),topPane.getSize().height));	
		//getMainToolBar().getProjectBrowserButton().setSelected(true);
		getMainMenu().getProjectBrowserItem().setSelected(true);
	}
	
	public void openOnlyStartPage()
	{
		browserManager.getProjectBrowser().setPreferredSize(new Dimension(0,250));
		browserManager.setPreferredSize(new Dimension(0,250));			
		toolManager.setPreferredSize(new Dimension(0,250));
		toolManager.getPalleteAccordion().setPreferredSize(new Dimension(0,250));
		bottomPane.setPreferredSize(new Dimension(GetScreenWorkingWidth(),0));						
		topPane.setPreferredSize(new Dimension(GetScreenWorkingWidth(),GetScreenWorkingHeight()));
		//getMainToolBar().getProjectBrowserButton().setSelected(false);
		getMainMenu().getProjectBrowserItem().setSelected(false);
		//getMainToolBar().getToolBoxButton().setSelected(false);
		getMainMenu().getToolBoxItem().setSelected(false);
	}
	
	/**
	 * Adds the main diagram manager (the tabbed pane which holds the diagrams)
	 */
	private void installManagers() 
	{		
		topPane = new TopViewPane(this);		
		topPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-240-240,GetScreenWorkingHeight()));
		
		bottomPane= new BottomViewPane(this, null);
		bottomPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-240-240,0));
				
		browserManager = new ProjectBrowserPane(this);
		browserManager.setPreferredSize(new Dimension(230,250));
		browserManager.getProjectBrowser().setPreferredSize(new Dimension(230,250));
		
		toolManager = new ToolboxPane(this, getDiagramManager().getEditorDispatcher());
		toolManager.setPreferredSize(new Dimension(230,250));
		toolManager.getPalleteAccordion().setPreferredSize(new Dimension(230,250));
		
		//==========	
		
		String layoutDef = "(ROW weight=1.0 left (COLUMN middle.top middle.bottom) right)";
		MultiSplitLayout.Node modelRoot = MultiSplitLayout.parseModel(layoutDef);
		
		multiSplitPane = new MultiSplitPane();
		multiSplitPane.getMultiSplitLayout().setModel(modelRoot);
		multiSplitPane.add(toolManager, "left");
		multiSplitPane.add(browserManager, "right");
		multiSplitPane.add(topPane, "middle.top");		
		multiSplitPane.add(bottomPane, "middle.bottom");
		multiSplitPane.setBorder(null);
		multiSplitPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(multiSplitPane, BorderLayout.CENTER);
	}	
	
	public boolean isShowToolBox()
	{
		return !(toolManager.getPreferredSize().width == 0);
	}
	
	public boolean isShowBrowser()
	{
		return !(browserManager.getPreferredSize().width==0);
	}
	
	public boolean isShowBottomView()
	{
		return !(bottomPane.getPreferredSize().height == 0);
	}
	
	public void showBottomView()
	{
		int dividerSize = multiSplitPane.getMultiSplitLayout().getDividerSize();
		recordSplitSizes();
		multiSplitPane.getMultiSplitLayout().setFloatingDividers(true);	
		if(getMainMenu().isSelected("BOTTOMVIEW")){
			bottomPane.setPreferredSize(new Dimension(bottomPane.getSize().width,infoHeight));
			browserManager.getProjectBrowser().setPreferredSize(new Dimension(browserManager.getSize().width,250));
			browserManager.setPreferredSize(new Dimension(browserManager.getSize().width,250));
			toolManager.setPreferredSize(new Dimension(toolManager.getSize().width,250));
			toolManager.getPalleteAccordion().setPreferredSize(new Dimension(toolManager.getSize().width,250));			
			topPane.setPreferredSize(new Dimension(topPane.getSize().width,GetScreenWorkingHeight()-infoHeight-dividerSize-70));
			//getMainToolBar().getBottomViewButton().setSelected(true);			
		}else{
			bottomPane.setPreferredSize(new Dimension(bottomPane.getSize().width,0));
			browserManager.getProjectBrowser().setPreferredSize(new Dimension(browserManager.getSize().width,250));
			browserManager.setPreferredSize(new Dimension(browserManager.getSize().width,250));
			toolManager.setPreferredSize(new Dimension(toolManager.getSize().width,250));
			toolManager.getPalleteAccordion().setPreferredSize(new Dimension(toolManager.getSize().width,250));			
			topPane.setPreferredSize(new Dimension(topPane.getSize().width,GetScreenWorkingHeight()-dividerSize-70));	
			//getMainToolBar().getBottomViewButton().setSelected(false);			
		}		
		multiSplitPane.revalidate();	
	}
	
	public void recordSplitSizes()
	{
		if(toolManager.getSize().width!=0) toolboxWidth = toolManager.getSize().width;
		if(browserManager.getSize().width<10) browserWidth = browserManager.getSize().width;
		if(bottomPane.getSize().height!=0) infoHeight = bottomPane.getSize().height;
	}
	
	public void showProjectBrowser()
	{
		int dividerSize = multiSplitPane.getMultiSplitLayout().getDividerSize();
		recordSplitSizes();
		multiSplitPane.getMultiSplitLayout().setFloatingDividers(true);		
		if(getMainMenu().isSelected("BROWSER")){
			browserManager.getProjectBrowser().setPreferredSize(new Dimension(browserWidth,250));
			browserManager.setPreferredSize(new Dimension(browserWidth,250));
			toolManager.setPreferredSize(new Dimension(toolManager.getSize().width,250));
			toolManager.getPalleteAccordion().setPreferredSize(new Dimension(toolManager.getSize().width,250));
			bottomPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-browserWidth-toolManager.getSize().width-(2*dividerSize),bottomPane.getSize().height));
			topPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-browserWidth-toolManager.getSize().width-(2*dividerSize),topPane.getSize().height));	
			//getMainToolBar().getProjectBrowserButton().setSelected(true);
			getMainMenu().getProjectBrowserItem().setSelected(true);
		}else{
			browserManager.getProjectBrowser().setPreferredSize(new Dimension(0,250));
			browserManager.setPreferredSize(new Dimension(0,250));			
			toolManager.setPreferredSize(new Dimension(toolManager.getSize().width,250));
			toolManager.getPalleteAccordion().setPreferredSize(new Dimension(toolManager.getSize().width,250));
			bottomPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-toolManager.getSize().width-(2*dividerSize),bottomPane.getSize().height));						
			topPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-toolManager.getSize().width-(2*dividerSize),topPane.getSize().height));
			//getMainToolBar().getProjectBrowserButton().setSelected(false);
			getMainMenu().getProjectBrowserItem().setSelected(false);
		}		
		multiSplitPane.revalidate();
	}
	
	public void showToolBox()
	{		
		int dividerSize = multiSplitPane.getMultiSplitLayout().getDividerSize();
		recordSplitSizes();
		multiSplitPane.getMultiSplitLayout().setFloatingDividers(true);
		if(getMainMenu().isSelected("TOOLBOX")){
			toolManager.setPreferredSize(new Dimension(toolboxWidth,250));
			toolManager.getPalleteAccordion().setPreferredSize(new Dimension(toolboxWidth,250));
			browserManager.getProjectBrowser().setPreferredSize(new Dimension(browserManager.getSize().width,250));
			browserManager.setPreferredSize(new Dimension(browserManager.getSize().width,250));
			bottomPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-toolboxWidth-browserManager.getSize().width-(2*dividerSize),bottomPane.getSize().height));
			topPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-toolboxWidth-browserManager.getSize().width-(2*dividerSize),topPane.getSize().height));	
			//getMainToolBar().getToolBoxButton().setSelected(true);			
		}else{
			toolManager.setPreferredSize(new Dimension(0,250));
			toolManager.getPalleteAccordion().setPreferredSize(new Dimension(0,250));
			browserManager.getProjectBrowser().setPreferredSize(new Dimension(browserManager.getSize().width,250));
			browserManager.setPreferredSize(new Dimension(browserManager.getSize().width,250));
			bottomPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-browserManager.getSize().width-(2*dividerSize),bottomPane.getSize().height));						
			topPane.setPreferredSize(new Dimension(GetScreenWorkingWidth()-browserManager.getSize().width-(2*dividerSize),topPane.getSize().height));
			//getMainToolBar().getToolBoxButton().setSelected(false);
		}		
		multiSplitPane.revalidate();
	}
	
	/**
	 * Handles the fired commands.
	 * */
	@Override
	public void handleCommand(String command) {		
		MethodCall methodcall=null;
		if(CommandType.isValueOf(command)){
			methodcall = CommandMap.getInstance().getMap().get(CommandType.valueOf(command));
		}else{
			methodcall = getDiagramManager().getEditorDispatcher().getMap().get(command);
		}		
		if(methodcall.getMethod().getDeclaringClass() == AppCommandDispatcher.class){					
			methodcall.call(getDiagramManager().getEditorDispatcher());
		}else if(methodcall.getMethod().getDeclaringClass() == DiagramManager.class){
			methodcall.call(getDiagramManager());
		}else if(methodcall.getMethod().getDeclaringClass() == getClass()){
			methodcall.call(this);
		}else{
			System.out.println("Command not handled: "+methodcall.getMethod().getDeclaringClass()+" - "+methodcall);
		}
	}

	/**
	 * Displays the settings manager.
	 * */
	public void editSettings() {

	}

	/**
	 * Displays the about dialog.
	 * */
	public void about() {

	}

	/**
	 * Displays the help contents.
	 */
	public void displayHelpContents() {

	}

	/**
	 * Quits the application with confirmation.
	 * */
	public void quitApplication() {
		Main.printOutLine("Menthor application closed");
		
		if (canQuit()) {		
			
			getDiagramManager().dispose();

			dispose();
			Thread.currentThread().interrupt();
			
			System.gc();
			Runtime.getRuntime().exit(0);
		}
	}

	/**
	 * Checks if application can be quit safely.
	 * 
	 * @return true if can quit safely, false otherwise
	 */
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

	public InfoManager getInfoManager()
	{
		return bottomPane.getInfoManager();
	}
	
	/**
	 * Gets the application main menu.
	 * 
	 * @return {@link AppMenu} the main menu
	 * */
	public AppMenu getMainMenu() {
		return mainMenu;
	}
	
	/**
	 * Gets the tool manager (the tabbed pane responsible for managing the
	 * tools).
	 * 
	 * @return {@link ToolboxPane} the tool manager
	 * */
	public ToolboxPane getToolManager() {
		return toolManager;
	}
		
	/**
	 * Resets the active palette (in the tool manager) to the default element,
	 * the pointer.
	 * */
	public void selectPaletteDefaultElement() {
		toolManager.getElementsPalette().selectDefault();
	}

	// Helper method
	private String getResourceString(String property) {
		return ApplicationResources.getInstance().getString(property);
	}

	/**
	 * Reset the transient values for serialization.
	 * 
	 * @param stream
	 *            an ObjectInputStream
	 * @throws IOException
	 *             if I/O error occured
	 * @throws ClassNotFoundException
	 *             if class was not found
	 */
	private void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {

		mainMenu = null;
		mainToolBar = null;
		toolManager = null;
		topPane = null;		
		bottomPane = null;
	}

	/**
	 * Query the specified editor state and set the menu and the toolbars
	 * accordingly.
	 * 
	 * @param editor
	 *            the editor
	 */
//	public void updateMenuAndToolbars(DiagramEditor editor) {
//		
//		if(mainMenu != null && mainToolBar != null )
//		{
//			if(editor != null)
//			{
//				mainMenu.enableMenuItem("UNDO", editor.canUndo());
//				mainMenu.enableMenuItem("REDO", editor.canRedo());
//				mainToolBar.enableButton("UNDO", editor.canUndo());
//				mainToolBar.enableButton("REDO", editor.canRedo());
//			}
//			else
//			{
//				mainMenu.enableMenuItem("UNDO", false);
//				mainMenu.enableMenuItem("REDO", false);
//				mainToolBar.enableButton("UNDO", false);
//				mainToolBar.enableButton("REDO", false);
//			}
//		}
//	}
	
	/**
	 * Shoe Error Message Dialog.
	 * 
	 * @param title
	 * @param message
	 */
	public void showErrorMessageDialog(String title, String message)
	{
		JOptionPane.showMessageDialog(
			this,message,title,JOptionPane.ERROR_MESSAGE			
		);	
	}
	
	/**
	 * Show Warning Message Dialog.
	 * 
	 * @param title
	 * @param message
	 */
	public void showWarningMessageDialog(String title, String message)
	{
		JOptionPane.showMessageDialog(
			this,message,title,JOptionPane.WARNING_MESSAGE			
		);	
	}
	
	/**
	 * Show Successful Message Dialog.
	 * 
	 * @param title
	 * @param message
	 */
	public void showSuccessfulMessageDialog(String title, String message)
	{
		JOptionPane.showMessageDialog(
			this,message,title,JOptionPane.INFORMATION_MESSAGE			
		);
	}
	
	/**
	 * Show Information Message Dialog.
	 * 
	 * @param title
	 * @param message
	 */
	public void showInformationMessageDialog(String title, String message)
	{
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
	
	/** Get Alloy Analyzer.  */
	public SimpleGUICustom getAlloyAnalyzer()
	{
		return analyzer;
	}
	
	public void selectConsole()
	{	
		bottomPane.getInfoManager().selectConsole();
	}	
	
	public void selectWarnings()
	{
		bottomPane.getInfoManager().selectWarnings();
	}
	
	public void selectProblems()
	{
		bottomPane.getInfoManager().selectProblems();
	}
	
	public void selectStatistic()
	{
		bottomPane.getInfoManager().selectStatistic();
	}
}
