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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.eclipse.emf.edit.provider.IDisposable;

import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.DrawingContextImpl;

import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.EditorMouseEvent;
import org.tinyuml.ui.diagram.EditorStateListener;
import org.tinyuml.ui.diagram.SelectionListener;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;

import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.DiagramElementFactoryImpl;

import net.menthor.editor.problems.ErrorPane;
import net.menthor.editor.problems.FoundPane;
import net.menthor.editor.problems.ProblemElement;
import net.menthor.editor.problems.ProblemPane;
import net.menthor.editor.problems.StatisticsPane;
import net.menthor.editor.problems.WarningPane;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.editors.Editor;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.managers.MessageManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.menubar.MainMenuBar;
import net.menthor.editor.v2.types.EditorType;
import net.menthor.editor.v2.ui.StartPage;
import net.menthor.editor.v2.util.RefOntoUMLEditingDomain;

public class DiagramManager extends JTabbedPane implements SelectionListener, EditorStateListener, IDisposable {

	private static final long serialVersionUID = 5019191384767258996L;
	
	public final MainFrame frame;	
	private CommandListener listener;
	private DiagramElementFactoryImpl elementFactory;
	private DrawingContext drawingContext;		
	public MainFrame getFrame() { return frame; }
	public DiagramElementFactoryImpl getElementFactory() { return elementFactory; }
	public DrawingContext getDrawingContext() { return drawingContext; }
	public MainMenuBar getMainMenu() { return frame.getMainMenu(); }
	public void setCommandListener(CommandListener listener){ this.listener = listener; }
	public CommandListener getCommandListener(){ return listener; }
	
	public StartPage start;
	public StartPage getStartPage() { return start; }
	
	/**
	 * Constructor for the DiagramManager class.
	 * @param frame the parent window {@link MainFrame}
	 */
	public DiagramManager(final MainFrame frame) 
	{
		super();
		this.frame = frame;		
		listener = frame;
		elementFactory = new DiagramElementFactoryImpl(); //doesn't have yet any diagram
		drawingContext =  new DrawingContextImpl();
		RefOntoUMLEditingDomain.getInstance().initialize();		
		setBorder(new EmptyBorder(0,0,0,0));		
		setBackground(Color.white);
		setMinimumSize(new Dimension(0,0));
	}
	
	/** Open diagrams loaded from the project. It only opens those diagrams saved as opened. */
	public void set(){
		if(ProjectManager.get().getProject().isAllClosed() && ProjectManager.get().getProject().getDiagrams().size()>0){
			System.out.println("Loading diagram \""+ProjectManager.get().getProject().getDiagrams().get(0).getName()+"\"");	
			createDiagramEditor((StructureDiagram)ProjectManager.get().getProject().getDiagrams().get(0));
		}else{
			for(OntoumlDiagram diagram: ProjectManager.get().getProject().getDiagrams()) {
				if(ProjectManager.get().getProject().isOpened(diagram)){
					System.out.println("Loading diagram \""+diagram.getName()+"\"");	
					createDiagramEditor((StructureDiagram)diagram);
				}
			}
		}
	}
	
	public void empty(){
		removeAll();
		getFrame().setTitle("Menthor Editor");
		addStartPanel(this,false);
		getFrame().showOnlyStartPage();
		getFrame().getMainMenu().disactivateSomeToBegin();			
		repaint();
		revalidate();
	}
		
	/** Adds a start panel to the manager */
	public JComponent addStartPanel(JTabbedPane pane, boolean closable)
	{
		start = new StartPage(frame);
		if(closable)addClosable(pane,"Welcome", start);
		else addNonClosable(pane,"Welcome", start);
		return start;
	}		
	
	/** Adds a Finder panel to the manager */
	public FoundPane addFinderPanel(JTabbedPane pane, boolean closable)
	{
		for(Component c: pane.getComponents()) {
			if(c instanceof FoundPane) { pane.setSelectedComponent(c); return (FoundPane)c; }
		}		
		FoundPane finder = new FoundPane(ProjectManager.get().getProject(),true);
		if(closable)addClosable(pane,"Find", finder);
		else addNonClosable(pane,"Find", finder);
		return finder;
	}
	
	/** Adds a Warning panel to the manager */
	public WarningPane addWarningsPanel(JTabbedPane pane, boolean closable)
	{		
		for(Component c: pane.getComponents()) {
			if(c instanceof WarningPane) { pane.setSelectedComponent(c); return (WarningPane)c; }
		}		
		WarningPane warningPane = new WarningPane(ProjectManager.get().getProject());
		if(closable) addClosable(pane,"Warnings", warningPane);
		else addNonClosable(pane,"Warnings", warningPane);
		return warningPane;
	}
	
	/** Adds a Problem panel to the manager */
	public ErrorPane addErrorsPanel(JTabbedPane pane, boolean closable)
	{		
		for(Component c: pane.getComponents()) {
			if(c instanceof ErrorPane) { pane.setSelectedComponent(c); return (ErrorPane)c; }
		}		
		ErrorPane problemsPane = new ErrorPane(ProjectManager.get().getProject());
		if(closable) addClosable(pane,"Errors", problemsPane);
		else addNonClosable(pane,"Errors", problemsPane);
		return problemsPane;
	}
		
	/** Adds a Statistics panel to the manager */
	public StatisticsPane addStatisticsPanel(JTabbedPane pane, boolean closable)
	{
		for(Component c: pane.getComponents()) {
			if(c instanceof StatisticsPane) { pane.setSelectedComponent(c); return (StatisticsPane)c; }
		}		
		StatisticsPane statPanel = new StatisticsPane(ProjectManager.get().getProject());
		if(closable) addClosable(pane,"Statistics", statPanel);
		else addNonClosable(pane,"Statistics", statPanel);
		return statPanel;
	}
			
	/** Gets the current DiagramEditor (the editor displayed in the focused tab). If there's no suitable editor, returns null. */
	public Editor getCurrentEditor(){
		if(this.getSelectedIndex() != -1){
			Object obj = this.getSelectedComponent();
			if(obj instanceof Editor) return (Editor) obj;	
		}
		return null;
	}

	/** Gets the wrapper for the selected DiagramEditor */
	public DiagramWrapper getCurrentWrapper(){
		if(this.getSelectedComponent() instanceof DiagramWrapper) return ((DiagramWrapper) this.getSelectedComponent());
		return null;
	}	

	/** Gets the selected DiagramEditor */
	public DiagramEditor getCurrentDiagramEditor(){		
		if(this.getSelectedComponent() instanceof DiagramWrapper){			
			return ((DiagramWrapper) this.getSelectedComponent()).getDiagramEditor();
		}
		return null;
	}
	
	public ConstraintEditor getCurrentConstraintEditor(){
		if(this.getSelectedComponent() instanceof ConstraintEditor) return ((ConstraintEditor) this.getSelectedComponent());
		return null;
	}
	
	/** Return all opened diagram editors */
	public ArrayList<DiagramEditor> getDiagramEditors(){
		ArrayList<DiagramEditor> list = new ArrayList<DiagramEditor>();
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) list.add(((DiagramWrapper)c).getDiagramEditor());
		}
		return list;
	}
	
	/** Return all opened diagrams */
	public ArrayList<StructureDiagram> getOpenedDiagrams(){
		ArrayList<StructureDiagram> list = new ArrayList<StructureDiagram>();
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) list.add(((DiagramWrapper)c).getDiagramEditor().getDiagram());
		}
		return list;
	}
	
	/** Return all opened constraint editors */
	public ArrayList<ConstraintEditor> getConstraintEditors(){
		ArrayList<ConstraintEditor> list = new ArrayList<ConstraintEditor>();
		for(Component c: getComponents()){
			if(c instanceof ConstraintEditor) list.add((ConstraintEditor)c);
		}
		return list;
	}

	/** Select the tab which contains this editor */
	public void select(Editor editor){		
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().equals(editor)) setSelectedComponent(c);
			}else{
				if(c.equals(editor)) setSelectedComponent(c);
			}
		}		
	}
	
	public void openTab(Object obj){
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().getDiagram().equals(obj)) { setSelectedComponent(c); return; }				
			}			
			if(c instanceof ConstraintEditor) {
				if(((ConstraintEditor) c).getOclDocument().equals(obj)) { setSelectedComponent(c); return; }	
			}
		}
		if(obj instanceof OntoumlDiagram) { createDiagramEditor((OntoumlDiagram)obj); return; }
		if(obj instanceof OclDocument) { createConstraintEditor((OclDocument)obj); return; }
		
	}
	
	public void selectTab(Object obj){
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().getDiagram().equals(obj)) setSelectedComponent(c);				
			}			
			if(c instanceof ConstraintEditor) {
				if(((ConstraintEditor) c).getOclDocument().equals(obj)) setSelectedComponent(c);	
			}
		}	
	}
	
	/** Select the tab which constains this diagram */
	public void select(StructureDiagram diagram){		
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().getDiagram().equals(diagram)) setSelectedComponent(c);
			}
		}		
	}
	
	/** Select the tab which contains this ocl document */
	public void select(OclDocument oclDoc){		
		for(Component c: getComponents()){
			if(c instanceof ConstraintEditor) {
				if(((ConstraintEditor) c).getOclDocument().equals(oclDoc)) setSelectedComponent(c);
			}
		}		
	}
	
	/** Get the diagram editor which encapsulates this diagram */
	public DiagramEditor getDiagramEditor(StructureDiagram diagram){		
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return ((DiagramWrapper)c).getDiagramEditor();
			}
		}
		DiagramEditor editor = new DiagramEditor(getFrame(),this,diagram);
		editor.addEditorStateListener(this);
		editor.addSelectionListener(this);
		editor.addAppCommandListener(this.getCommandListener());	
		return editor;
	}
	
	/** Get the diagram editor which encapsulates this ocl document */
	public ConstraintEditor getConstraintEditor(OclDocument oclDoc){		
		for(Component c: getComponents()){
			if(c instanceof ConstraintEditor) {
				if (((ConstraintEditor)c).getOclDocument().equals(oclDoc))
					return (ConstraintEditor)c;
			}
		}
		return null;
	}
	
	/** Report message to the status bar on the respective diagram */
	public void showStatus(DiagramEditor diagramEditor, String status){
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().equals(diagramEditor)){
					((DiagramWrapper) c).getStatusBar().report(status);
				}
			}
		}		
	}

	/** Get the tab index of this particular diagram */
	public int getTabIndex(StructureDiagram diagram){		
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return indexOfComponent(c);
			}
		}
		return -1;
	}
	
	public int getTabIndex(OclDocument oclDoc){
		for(Component c: getComponents()){
			if(c instanceof ConstraintEditor) {
				if (((ConstraintEditor)c).getOclDocument().equals(oclDoc))
					return indexOfComponent(c);
			}
		}
		return -1;		
	}
	
	/** Adds a new tab. */
	public Component addClosable(JTabbedPane pane, String text, Component component)
	{
		if (component==null) component = new JPanel();
		pane.addTab(text, component);		
		if(component instanceof DiagramWrapper){
			ClosableTabPanel tab = new ClosableTabPanel(pane,frame);
			Icon icon = IconMap.getInstance().getIcon(IconType.MENTHOR_DIAGRAM);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}
		if(component instanceof ConstraintEditor){
			ClosableTabPanel tab = new ClosableTabPanel(pane,frame);
			Icon icon = IconMap.getInstance().getIcon(IconType.MENTHOR_CONSTRAINTDOC);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}
		if(component instanceof TextEditor){
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getIcon(IconType.MENTHOR_DOC);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}
		if(component instanceof FoundPane){
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getIcon(IconType.MENTHOR_SEARCH);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}		
		if(component instanceof ProblemPane){
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getIcon(IconType.MENTHOR_ERROR);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}
		if(component instanceof StatisticsPane){
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getIcon(IconType.MENTHOR_STATS);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}		
		if(component instanceof WarningPane) {
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getIcon(IconType.MENTHOR_WARNING);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);			
		}
		if(component instanceof ErrorPane) {
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getIcon(IconType.MENTHOR_ERROR);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);			
		}
		pane.setSelectedComponent(component);
		return component;
	}

	/** Add Non Closable Tab */
	public static Component addNonClosable(JTabbedPane pane, String text, Component component)
	{
		if (component==null) component = new JPanel();
		pane.addTab(text, component);
		if(component instanceof ProblemPane) {
			pane.setIconAt(pane.indexOfComponent(component),
			IconMap.getInstance().getIcon(IconType.MENTHOR_CHECK)
			);		
		}
		if(component instanceof StatisticsPane) {
			pane.setIconAt(pane.indexOfComponent(component),
			IconMap.getInstance().getIcon(IconType.MENTHOR_STATS)
			);
		}
		if(component instanceof FoundPane) {
			pane.setIconAt(pane.indexOfComponent(component),
			IconMap.getInstance().getIcon(IconType.MENTHOR_SEARCH)
			);
		}
		if(component instanceof ConstraintEditor) {
			pane.setIconAt(pane.indexOfComponent(component),
			IconMap.getInstance().getIcon(IconType.MENTHOR_CONSTRAINTDOC)
			);
		}
		if(component instanceof DiagramWrapper) {
			pane.setIconAt(pane.indexOfComponent(component),
			IconMap.getInstance().getIcon(IconType.MENTHOR_DIAGRAM)
			);
		}
		if(component instanceof WarningPane) {
			pane.setIconAt(pane.indexOfComponent(component),
			IconMap.getInstance().getIcon(IconType.MENTHOR_WARNING)
			);
		}
		if(component instanceof ErrorPane) {
			pane.setIconAt(pane.indexOfComponent(component),
			IconMap.getInstance().getIcon(IconType.MENTHOR_ERROR)
			);
		}
		//setTabComponentAt(indexOfComponent(component),null);
		pane.setSelectedComponent(component);
		return component;
	}

	/** Dispose */
	@Override
	public void dispose() {
		int totalTabs = getTabCount();
		for(int i = 0; i < totalTabs; i++) {
			IDisposable disposable = (IDisposable) getComponentAt(i);
			if(disposable != null) disposable.dispose();			
		}
	}
	
	public void closeAll(Component c){
		closeAll(this);
	}
	
	public static void closeAll(JTabbedPane pane){
		 int tabCount = pane.getTabCount();         
         for (int i = 1; i < tabCount; i++) {
             closeTab(1, pane);
         }
	}
	
	public void closeOthers(Component component){
		closeOthers(this,component);
	}
	
	public static void closeOthers(JTabbedPane pane,Component component)	{	
		int selectedTabIndex = pane.indexOfComponent(component);		
		 // First remove higher indexes 
        int tabCount = pane.getTabCount();         
        if (selectedTabIndex < tabCount - 1) {
            for (int i = selectedTabIndex + 1; i < tabCount; i++) {
                closeTab(selectedTabIndex + 1,pane);
            }
        }         
        if (selectedTabIndex > 0) {
            for (int i = 1; i < selectedTabIndex; i++) {
                closeTab(1,pane);
            }
        }
	}
	
	public void closeTab(Component c)	{
		closeTab(indexOfComponent(c),this);
	}
	
	public static void closeTab(int i, JTabbedPane pane){		
		if (i != -1) {
			IDisposable disposable = (IDisposable) pane.getComponentAt(i);
			if(disposable != null) disposable.dispose();			
			pane.remove(i);
		}
	}
	
	public void removeDiagramFromTab(StructureDiagram diagram){
		for(Component c: getComponents()){
			if (c instanceof DiagramWrapper){
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) remove(c);
			}
		}		
	}
	
	public void removeOclDocTab(OclDocument doc){		
		for(Component c: getComponents()){
			if (c instanceof ConstraintEditor){
				if (((ConstraintEditor)c).getOclDocument().equals(doc)) remove(c);
			}
		}	
	}
	
	public void addFinderTab(){ 
		addFinderPanel(this,true); 
	}
	
	public void addStatisticsTab() { 
		addStatisticsPanel(frame.getDiagramManager(),true); 
	}
	
	/** Verifies if this diagram is already opened in a tab. */
	public boolean isDiagramOpened (StructureDiagram diagram)
	{
		for(Component c: getComponents())
			if (c instanceof DiagramWrapper)
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) return true;
		return false;
	}

	/** Verifies if this ocl document is already opened in a tab. */
	public boolean isOclDocumentOpened (OclDocument oclDoc)
	{
		for(Component c: getComponents())
			if (c instanceof ConstraintEditor)
				if (((ConstraintEditor)c).getOclDocument().equals(oclDoc)) return true;
		return false;
	}

	/** Creates an editor for a given Diagram. */
	public DiagramEditor createDiagramEditor(OntoumlDiagram diagram){		
		DiagramEditor editor = new DiagramEditor(frame, this, diagram);			
		editor.addEditorStateListener(this);
		editor.addSelectionListener(this);
		editor.addAppCommandListener(listener);
		// Add all the diagram elements of 'diagram' to the ModelHelper mapping.
		// Keeps trace of mappings between DiagramElement <-> Element.
		OccurenceManager.get().add(editor.getDiagram());
		//Add the diagram to the tabbed pane (this), through the wrapper
		DiagramWrapper wrapper = new DiagramWrapper(editor, listener);
		editor.setWrapper(wrapper);
		addClosable(this,((StructureDiagram)diagram).getLabelText(), wrapper);		
		return editor;
	}
	
	/** Close current diagram editor */
	public void closeCurrentDiagram()
	{
		Editor editor = getCurrentDiagramEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				boolean response = MessageManager.get().confirm("Save", "Your diagram has been modified. Save changes?");
				if(response) { ProjectManager.get().saveProject(); }
				else { return; }				
			}			
			closeTab(getTabIndex(getCurrentDiagramEditor().getDiagram()),this);
		}
	}

	/** Close current diagram editor */
	public void closeCurrentOclDocument()
	{
		Editor editor = getCurrentConstraintEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				boolean response = MessageManager.get().confirm("Save", "Your rules document has been modified. Save changes?");
				if(response) { ProjectManager.get().saveProject(); }
				else { return; }
			}			
			closeTab(getTabIndex(((ConstraintEditor)editor).getOclDocument()),this);
		}
	}
	
	public List<DiagramEditor> createDiagramEditors(List<OntoumlDiagram> diagrams){
		List<DiagramEditor> result = new ArrayList<DiagramEditor>();
		for(OntoumlDiagram diagram: diagrams) {
			result.add(createDiagramEditor((StructureDiagram)diagram));
		}
		return result;
	}
	
	/** Creates an editor for a given OCL document. */
	public ConstraintEditor createConstraintEditor(OclDocument oclDoc){		
		ConstraintEditor editor = new ConstraintEditor(frame, oclDoc);
		addClosable(this,oclDoc.getName(), editor);		
		return editor;
	}
	
	public void setErrorsOnTab(double startTime, double endTime, List<ProblemElement> errors){
		ErrorPane errorPane = addErrorsPanel(getFrame().getInfoManager(),true);
		errorPane.setData(errors);
		errorPane.setStatus(MessageFormat.format("Model verified in {0} ms, {1} error(s) found", (startTime - endTime),  errors.size()));
	}
	
	public void setWarningsOnTab(String message, List<ProblemElement> warnings){
		WarningPane warningsPane = addWarningsPanel(getFrame().getInfoManager(),true);
		warningsPane.setData(warnings);
		warningsPane.setStatus(message);
	}
	
	public void showInTextEditor(String content)
	{
		TextEditor textViz = (TextEditor) getEditorForProject(EditorType.TEXT_EDITOR);
		if(textViz == null){
			textViz = new TextEditor(ProjectManager.get().getProject());
			addClosable(this,"Text Editor", textViz);
		}else{
			setSelectedComponent(textViz);
		}
		textViz.setText(content);
	}
		
	private Editor getEditorForProject(EditorType nature){
		int totalTabs = getTabCount();
		for(int i = 0; i < totalTabs; i++){
			Editor editor = (Editor)getComponentAt(i);
			if(editor.getEditorType() == nature){
				return editor;
			}
		}
		return null;
	}
	
	/** Get working constraints */
	public String getWorkingConstraints()
	{
		String result = new String();
		for(OclDocument oclmodel: Models.getOclDocList())
		{				
			ConstraintEditor ce = getConstraintEditor(oclmodel);
			if(ce!=null) result+=ce.getText();
			else result+=oclmodel.getContentAsString();
		}
		return result;
	}
		
	// ------------ Editor State Listener --------------
	
	@Override
	public void stateChanged(DiagramEditor editor, ChangeType changeType){
		if(changeType == ChangeType.ELEMENTS_ADDED) frame.selectPaletteDefaultElement();
	}
	
	@Override
	public void mouseMoved(EditorMouseEvent event){}
	
	// ------------ Selection Listener --------------
	
	@Override
	public void selectionStateChanged(){}
		
}