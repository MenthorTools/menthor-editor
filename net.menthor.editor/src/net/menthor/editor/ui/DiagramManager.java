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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IDisposable;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.DrawingContextImpl;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.EditorMouseEvent;
import org.tinyuml.ui.diagram.EditorStateListener;
import org.tinyuml.ui.diagram.SelectionListener;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.DiagramElementFactoryImpl;

import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.NamedElement;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLElementCustom;
import net.menthor.common.ontoumlparser.OntoUMLModelStatistic;
import net.menthor.common.ontoumlparser.OntoUMLModelStatistic.TypeDetail;
import net.menthor.editor.finder.FoundElement;
import net.menthor.editor.finder.FoundPane;
import net.menthor.editor.problems.ErrorPane;
import net.menthor.editor.problems.ProblemElement;
import net.menthor.editor.problems.ProblemPane;
import net.menthor.editor.problems.WarningPane;
import net.menthor.editor.statistician.StatisticalElement;
import net.menthor.editor.statistician.StatisticsPane;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
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
import net.menthor.editor.v2.util.Util;
import net.menthor.editor.validator.meronymic.ValidationDialog;
import net.menthor.ontouml2text.ontoUmlGlossary.ui.GlossaryGeneratorUI;

/**
 * Class responsible for managing and organizing the editors in tabs.
 * 
 * @author John Guerson
 */
public class DiagramManager extends JTabbedPane implements SelectionListener, EditorStateListener, IDisposable {

	private static final long serialVersionUID = 5019191384767258996L;
	
	public final MainFrame frame;	
	private CommandListener listener;
	private DiagramElementFactoryImpl elementFactory;
	private DrawingContext drawingContext;	
	
	public StartPage start;
	
	/** Get Frame */
	public MainFrame getFrame() { return frame; }
	/** Get Factory */
	public DiagramElementFactoryImpl getElementFactory() { return elementFactory; }
	/** Get drawing context */
	public DrawingContext getDrawingContext() { return drawingContext; }
	
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
	
	public StartPage getStartPage()
	{
		return start;
	}
	
	/** Adds a start panel to the manager */
	public JComponent addStartPanel(JTabbedPane pane, boolean closable)
	{
		start = new StartPage(frame);
		if(closable)addClosable(pane,"Welcome", start);
		else addNonClosable(pane,"Welcome", start);
		return start;
	}
			
	public void searchInProject()
	{
		addFinderPanel(this,true);
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
	
	public void collectStatistics()
	{
		addStatisticsPanel(frame.getDiagramManager(),true);
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
	
	/** Sets the dispatcher responsible for routing events of the editor */
	public void setCommandListener(CommandListener listener) 
	{
		this.listener = listener;
	}

	/** Gets the dispatcher responsible for routing events of the editor */
	public CommandListener getCommandListener() 
	{
		return listener;
	}

	/** Gets the current DiagramEditor (the editor displayed in the focused tab). If there's no suitable editor, returns null. */
	public Editor getCurrentEditor() 
	{
		if(this.getSelectedIndex() != -1){
			Object obj = this.getSelectedComponent();
			if(obj instanceof Editor) return (Editor) obj;	
		}
		return null;
	}

	/** Gets the wrapper for the selected DiagramEditor */
	public DiagramWrapper getCurrentWrapper()
	{
		if(this.getSelectedComponent() instanceof DiagramWrapper) return ((DiagramWrapper) this.getSelectedComponent());
		return null;
	}	

	/** Gets the selected DiagramEditor */
	public DiagramEditor getCurrentDiagramEditor() 
	{		
		if(this.getSelectedComponent() instanceof DiagramWrapper){			
			return ((DiagramWrapper) this.getSelectedComponent()).getDiagramEditor();
		}
		return null;
	}
	
	public ConstraintEditor getCurrentConstraintEditor()
	{
		if(this.getSelectedComponent() instanceof ConstraintEditor) return ((ConstraintEditor) this.getSelectedComponent());
		return null;
	}
		
	/** Useful method: Verifies if the element is contained in the list */
	public boolean contains (ArrayList<RefOntoUMLElementCustom> list, RefOntoUML.Element elem)
	{
		for(RefOntoUMLElementCustom coe: list){
			if(coe.getElement().equals(elem)) return true;
		}
		return false;
	}
	
	/** Return all opened diagram editors */
	public ArrayList<DiagramEditor> getDiagramEditors()
	{
		ArrayList<DiagramEditor> list = new ArrayList<DiagramEditor>();
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) list.add(((DiagramWrapper)c).getDiagramEditor());
		}
		return list;
	}
	
	/** Return all opened diagrams */
	public ArrayList<StructureDiagram> getOpenedDiagrams()
	{
		ArrayList<StructureDiagram> list = new ArrayList<StructureDiagram>();
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) list.add(((DiagramWrapper)c).getDiagramEditor().getDiagram());
		}
		return list;
	}
	
	/** Return all opened constraint editors */
	public ArrayList<ConstraintEditor> getConstraintEditors()
	{
		ArrayList<ConstraintEditor> list = new ArrayList<ConstraintEditor>();
		for(Component c: getComponents()){
			if(c instanceof ConstraintEditor) list.add((ConstraintEditor)c);
		}
		return list;
	}

	/** Select the tab which contains this editor */
	public void select(Editor editor)
	{		
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().equals(editor)) setSelectedComponent(c);
			}else{
				if(c.equals(editor)) setSelectedComponent(c);
			}
		}		
	}
	
	public void openTab(Object obj)
	{
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
	
	public void selectTab(Object obj)
	{
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
	public void select(StructureDiagram diagram)
	{		
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().getDiagram().equals(diagram)) setSelectedComponent(c);
			}
		}		
	}
	
	/** Select the tab which contains this ocl document */
	public void select(OclDocument oclDoc)
	{		
		for(Component c: getComponents()){
			if(c instanceof ConstraintEditor) {
				if(((ConstraintEditor) c).getOclDocument().equals(oclDoc)) setSelectedComponent(c);
			}
		}		
	}
	
	/** Get the diagram editor which encapsulates this diagram */
	public DiagramEditor getDiagramEditor(StructureDiagram diagram)
	{		
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
	public ConstraintEditor getConstraintEditor(OclDocument oclDoc)
	{		
		for(Component c: getComponents()){
			if(c instanceof ConstraintEditor) {
				if (((ConstraintEditor)c).getOclDocument().equals(oclDoc))
					return (ConstraintEditor)c;
			}
		}
		return null;
	}
	
	/** Report message to the status bar on the respective diagram */
	public void showStatus(DiagramEditor diagramEditor, String status) 
	{
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().equals(diagramEditor)){
					((DiagramWrapper) c).getStatusBar().report(status);
				}
			}
		}		
	}

	/** Get the tab index of this particular diagram */
	public int getTabIndex(StructureDiagram diagram)
	{		
		for(Component c: getComponents()){
			if(c instanceof DiagramWrapper) {
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return indexOfComponent(c);
			}
		}
		return -1;
	}
	
	public int getTabIndex(OclDocument oclDoc)
	{
		for(Component c: getComponents()){
			if(c instanceof ConstraintEditor) {
				if (((ConstraintEditor)c).getOclDocument().equals(oclDoc))
					return indexOfComponent(c);
			}
		}
		return -1;		
	}
	
	/** Gets the MainMenu from the application frame */
	public MainMenuBar getMainMenu() 
	{
		return frame.getMainMenu();
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
	
	public void setDefaultDiagramSize(StructureDiagram diagram)
	{
		double waste = 0;
		if(frame.isShowBrowserPane()) waste+=240;
		if(frame.isShowPalettePane()) waste+=240;
		diagram.setSize((Util.getScreenWorkingWidth()-waste+100)*3, (Util.getScreenWorkingHeight()-100)*3);
	}
	
	/** Close current diagram editor */
	public void closeDiagram()
	{
		Editor editor = getCurrentDiagramEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				boolean response = MessageManager.get().confirm("Save", "Your diagram has been modified. Save changes?");
				if(response) { ProjectManager.get().saveProject(); }
				else { return; }				
			}			
			DiagramManager.closeTab(getTabIndex(getCurrentDiagramEditor().getDiagram()),this);
		}
	}

	/** Close current diagram editor */
	public void closeOclDocument()
	{
		Editor editor = getCurrentConstraintEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				boolean response = MessageManager.get().confirm("Save", "Your rules document has been modified. Save changes?");
				if(response) { ProjectManager.get().saveProject(); }
				else { return; }
			}			
			DiagramManager.closeTab(getTabIndex(((ConstraintEditor)editor).getOclDocument()),this);
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
	
	public static void closeOthers(JTabbedPane pane,Component component)
	{	
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
	
	public void closeTab(Component c)
	{
		closeTab(indexOfComponent(c),this);
	}
	
	public static void closeTab(int i, JTabbedPane pane)
	{		
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
	
	/** Get the names of all diagrams */
	public ArrayList<String> getDiagramNames()
	{
		ArrayList<String> result = new ArrayList<String>();
		for(OntoumlDiagram d: ProjectManager.get().getProject().getDiagrams()){
			result.add(d.getName());			
		}
		return result;
	}
	
	/**Get the names of all ocl documents */
	public ArrayList<String> getOclDocumentNames()
	{
		ArrayList<String> result = new ArrayList<String>();
		for(OclDocument d: Models.getOclDocList()){
			result.add(d.getName());			
		}
		return result;
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
	
	/** Open diagrams loaded from the project. It only opens those diagrams saved as opened. */
	public void openDiagrams()
	{		
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
	
	public void set(){
		openDiagrams();
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
	
	public List<DiagramEditor> createDiagramEditors(List<OntoumlDiagram> diagrams){
		List<DiagramEditor> result = new ArrayList<DiagramEditor>();
		for(OntoumlDiagram diagram: diagrams) {
			result.add(createDiagramEditor((StructureDiagram)diagram));
		}
		return result;
	}
	
	/** Creates an editor for a given Diagram. */
	public DiagramEditor createDiagramEditor(OntoumlDiagram diagram)
	{		
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
	
	/** Creates an editor for a given OCL document. */
	public ConstraintEditor createConstraintEditor(OclDocument oclDoc)
	{		
		ConstraintEditor editor = new ConstraintEditor(frame, oclDoc);
		addClosable(this,oclDoc.getName(), editor);		
		return editor;
	}
	
		
	
	
	
	public boolean haveGeneralizationSet(List<Generalization> gens){
		boolean result = false;
		for(Generalization g: gens){
			if (g.getGeneralizationSet()!=null && !g.getGeneralizationSet().isEmpty()) result=true;
		}
		return result;
	}
	
	public List<Generalization> getGeneralizations(List<DiagramElement> diagramElements){
		List<Generalization> gens = new ArrayList<Generalization>();		
		for(DiagramElement dElem: diagramElements){
			if (dElem instanceof GeneralizationElement){
				Generalization gen = ((GeneralizationElement)dElem).getGeneralization();				
				if(gen!=null) gens.add(gen);
			}
		}
		return gens;
	}
	
	/** Strictly find by name */
	public ArrayList<FoundElement> strictlyFindByName(String text)
	{		
		ArrayList<FoundElement> result = new ArrayList<FoundElement>();
		OntoUMLParser refparser = Models.getRefparser();
		if(refparser!=null && text!=null /*&& !text.isEmpty()*/){
			for(EObject eobj: refparser.getAllInstances(EObject.class)){
				if (eobj instanceof NamedElement){
					String name = ((NamedElement)eobj).getName();
					if(name!=null){
						if(text.trim().isEmpty()) result.add(new FoundElement(eobj));
						else {
							if(name.trim().toLowerCase().compareToIgnoreCase(text)==0) result.add(new FoundElement(eobj));
							else if(name.trim().toLowerCase().contains(text.toLowerCase().trim())) result.add(new FoundElement(eobj));
						}
						
					}
				}
			}
		}		
		return result;
	}
	
	public List<GeneralizationSet> getGeneralizationSets(List<DiagramElement> diagramElements){
		// retain only generalization sets from selected
		List<GeneralizationSet> genSets = new ArrayList<GeneralizationSet>();		
		for(DiagramElement dElem: diagramElements){
			if (dElem instanceof GeneralizationElement){
				Generalization gen = ((GeneralizationElement)dElem).getGeneralization();
				if (gen.getGeneralizationSet()!=null && !gen.getGeneralizationSet().isEmpty()) {
					for(GeneralizationSet gs: gen.getGeneralizationSet()) {
						if (!genSets.contains(gs)) genSets.add(gs);				
					}
				}
			}
		}
		return genSets;
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
	
	public void showBottomView()
	{
		if(!frame.isShowFooterPane()) { getMainMenu().select(CommandType.CONSOLE,true); frame.showFooterPane(); }
	}
	
	/** Collect Statistics */
	public ArrayList<StatisticalElement> collectStatistic()
	{
		ArrayList<StatisticalElement> result = new ArrayList<StatisticalElement>();
		OntoUMLParser refparser = Models.getRefparser();
		if(refparser!=null){
			OntoUMLModelStatistic diagnostic = new OntoUMLModelStatistic(refparser);
			diagnostic.run();
			
			for (TypeDetail detail : diagnostic.getDetails()) {
				result.add(new StatisticalElement(detail));
			}

		}
		return result;
	}
	
	/** Open Statistics Panel */
	public void openStatisticPanel()
	{			
		addStatisticsPanel(frame.getInfoManager(),true);
		showBottomView();		
		frame.selectStatistic();		
	}
		
	/** Open the Text Description settings window */
	public void callGlossary() 
	{
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {								
				GlossaryGeneratorUI settings = new GlossaryGeneratorUI(Models.getRefparser());
				settings.setVisible(true);
			}
		});
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

	//===================================== @Inherited =======================================

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stateChanged(DiagramEditor editor, ChangeType changeType) 
	{
		if(changeType == ChangeType.ELEMENTS_ADDED) frame.selectPaletteDefaultElement();
		//frame.updateMenuAndToolbars(editor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void selectionStateChanged() {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseMoved(EditorMouseEvent event) {}

	public void validatesParthood() {
		ValidationDialog.open(Models.getRefparser(), frame);
		
	}
}