
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
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.DrawingContextImpl;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.EditorMouseEvent;
import org.tinyuml.ui.diagram.EditorStateListener;
import org.tinyuml.ui.diagram.SelectionListener;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.DiagramElementFactoryImpl;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.NamedElement;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.parser.SyntacticVerificator;
import RefOntoUML.util.RefOntoUMLElementCustom;
import RefOntoUML.util.RefOntoUMLResourceUtil;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import net.menthor.common.ontoumlparser.OntoUMLModelStatistic;
import net.menthor.common.ontoumlparser.OntoUMLModelStatistic.TypeDetail;
import net.menthor.common.settings.als.ALS4Destination;
import net.menthor.common.settings.als.ALS4TransformationOption;
import net.menthor.common.settings.owl.OWL2Destination;
import net.menthor.common.settings.owl.OwlOptions;
import net.menthor.editor.derivation.DerivedTypesOperations;
import net.menthor.editor.derivation.ExclusionDerivationOperations;
import net.menthor.editor.derivation.ExclusionPattern;
import net.menthor.editor.derivation.IntersectionPattern;
import net.menthor.editor.derivation.ParticipationDerivationOperations;
import net.menthor.editor.derivation.ParticipationPatternTypeChoice;
import net.menthor.editor.derivation.PastSpecializationPattern;
import net.menthor.editor.derivation.SpecializationPattern;
import net.menthor.editor.derivation.UnionPattern;
import net.menthor.editor.finder.FoundElement;
import net.menthor.editor.finder.FoundPane;
import net.menthor.editor.pattern.DomainPatternTool;
import net.menthor.editor.pattern.PatternTool;
import net.menthor.editor.problems.ErrorElement;
import net.menthor.editor.problems.ErrorPane;
import net.menthor.editor.problems.ErrorVerificator;
import net.menthor.editor.problems.ProblemElement;
import net.menthor.editor.problems.ProblemElement.TypeProblem;
import net.menthor.editor.problems.ProblemPane;
import net.menthor.editor.problems.WarningPane;
import net.menthor.editor.problems.WarningVerificator;
import net.menthor.editor.statistician.StatisticalElement;
import net.menthor.editor.statistician.StatisticsPane;
import net.menthor.editor.transformation.alloy.AlsSettingsDialog;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.editors.Editor;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.managers.ChangeManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.UpdateManager;
import net.menthor.editor.v2.menubar.MainMenuBar;
import net.menthor.editor.v2.settings.ea.EASettingsDialog;
import net.menthor.editor.v2.settings.owl.OwlSettingsDialog;
import net.menthor.editor.v2.types.EditorType;
import net.menthor.editor.v2.types.PatternType;
import net.menthor.editor.v2.types.ResultType;
import net.menthor.editor.v2.types.ResultType.Result;
import net.menthor.editor.v2.ui.AboutDialog;
import net.menthor.editor.v2.ui.DiagramListDialog;
import net.menthor.editor.v2.ui.StartPage;
import net.menthor.editor.v2.util.AlloyAnalyzer;
import net.menthor.editor.v2.util.Directories;
import net.menthor.editor.v2.util.EcoreWriter;
import net.menthor.editor.v2.util.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.util.Settings;
import net.menthor.editor.v2.util.UMLWriter;
import net.menthor.editor.v2.util.Util;
import net.menthor.editor.v2.util.XMIWriter;
import net.menthor.editor.validator.antipattern.AntiPatternSearchDialog;
import net.menthor.editor.validator.meronymic.ValidationDialog;
import net.menthor.ontouml2alloy.OntoUML2AlloyOptions;
import net.menthor.ontouml2infouml.OntoUML2InfoUML;
import net.menthor.ontouml2sbvr.OntoUML2SBVR;
import net.menthor.ontouml2text.ontoUmlGlossary.ui.GlossaryGeneratorUI;
import net.menthor.tocl.parser.TOCLParser;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;

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
	
	public static String lastImportEAPath = new String();	
	public static String lastExportEcorePath = new String();
	public static String lastExportUMLPath = new String();
	
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
	
	public void runPatternByMenu(PatternType type)
	{
		runPattern(type, 0, 0);
	}

	public void generateSbvr()
	{
		//workingOnlyWithChecked();
		OntoUMLParser refparser = Models.getRefparser();
		//RefOntoUML.Package model = refparser.createModelFromSelections(new Copier());
		generateSbvr(refparser.getModel());
	}
		
	public void generateInfoUML()
	{	
		//workingOnlyWithChecked();
		OntoUMLParser refparser = Models.getRefparser();
		//RefOntoUML.Package model = refparser.createModelFromSelections(new Copier())
		generateInfoUML(refparser.getModel());
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
	
	/** Open Link With Browser */
	public void openLinkWithBrowser(String link)
	{
		Desktop desktop = Desktop.getDesktop();
		if( !desktop.isSupported(Desktop.Action.BROWSE)){
			System.err.println( "Desktop doesn't support the browse action (fatal)" );
			return;
		}
		try {
			java.net.URI uri = new java.net.URI(link);
			desktop.browse(uri);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
	
	/** Gets the file associated with the model. */
	public File getCurrentProjectFile()
	{
		return ProjectManager.get().getProjectFile();
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
	
	/** Tell the application that we need to save the diagram i.e. the diagram was modified */
	public void saveDiagramNeeded(StructureDiagram diagram, boolean value)
	{
		diagram.setSaveNeeded(value);
		ProjectManager.get().getProject().setSaveModelNeeded(value);
	}
	
	/** Tell the application that we need to save all diagrams i.e. the diagrams were all modified */
	public void saveAllDiagramNeeded(boolean value)
	{
		for(OntoumlDiagram d: ProjectManager.get().getProject().getDiagrams()) {
			((StructureDiagram)d).setSaveNeeded(value);
		}
		ProjectManager.get().getProject().setSaveModelNeeded(value);
	}
		
	/** Verifies if there is a project opened/loaded. */
	public boolean isProjectLoaded()
	{
		if (ProjectManager.get().getProject()==null) {
			frame.showInformationMessageDialog("Menthor Project", "There is no Menthor Project opened");
			return false;
		}else{
			return true;
		}
	}

	

	public void setDefaultDiagramSize(StructureDiagram diagram)
	{
		double waste = 0;
		if(frame.isShowBrowserPane()) waste+=240;
		if(frame.isShowPalettePane()) waste+=240;
		diagram.setSize((Util.getScreenWorkingWidth()-waste+100)*3, (Util.getScreenWorkingHeight()-100)*3);
	}
	
	//====================================================
	// NEW DIAGRAM
	//====================================================
	
	/** Creates a new diagram on the current Project */
	public void newDiagram(){
		StructureDiagram diagram = newDiagram(ProjectManager.get().getProject(),null);
		saveDiagramNeeded(diagram,false);
	}
	
	/** Creates a new Diagram with in existing Project */
	public StructureDiagram newDiagram(UmlProject project){	
		return newDiagram(project,null);
	}
	
	/** Creates a new Diagram with in existing Project */
	public StructureDiagram newDiagramAt(Object epackage){	
		return newDiagram(ProjectManager.get().getProject(),epackage);
	}
	
	/** Creates a new Diagram with in existing Project */
	public StructureDiagram newDiagram(UmlProject project, Object epackage){	
		StructureDiagram diagram = new StructureDiagram(project,elementFactory,drawingContext);
		if(epackage!=null)diagram.setContainer(epackage);
		setDefaultDiagramSize(diagram);
		diagram.setLabelText("Diagram"+ProjectManager.get().getProject().getDiagrams().size());
		ProjectManager.get().getProject().addDiagram(diagram);
		saveDiagramNeeded(diagram,false);
		createDiagramEditor(diagram);			
		//add the diagram from the browser
		ProjectBrowser browser = frame.getProjectBrowser();
		DefaultMutableTreeNode container = browser.getTree().getNode(epackage);
		browser.getTree().addElement(container,diagram);
		return diagram;
	}

	//====================================================
	// RENAME
	//====================================================
	
	public void rename(Object obj){		
		if (obj instanceof StructureDiagram) ChangeManager.get().renameDiagram((StructureDiagram)obj);		
		else if (obj instanceof OclDocument) ChangeManager.get().renameOclDocument((OclDocument)obj);							
		else if (obj instanceof RefOntoUML.Element) ChangeManager.get().renameElement((RefOntoUML.Element)obj);		
	}
	
	//====================================================
	// NEW RULES DOCUMENT
	//====================================================
	
	/** Creates a new rules document on the current Project */
	public OclDocument newRulesDocument(boolean createTab){
		return newRulesDocument(null, createTab);		
	}
	
	public OclDocument newRulesDocument(){
		return newRulesDocument(null, false);		
	}
	
	/** Creates a new rules document on the current Project */
	public OclDocument newRulesDocument(String oclcontent, boolean createTab){
		OclDocument oclDoc = newRulesDocumentAt(null,oclcontent, createTab);		
		return oclDoc;
	}
	
	public OclDocument newRulesDocumentAt(Object epackage, String oclContent){
		return newRulesDocumentAt(epackage,oclContent,true);
	}
	
	public OclDocument newRulesDocumentAt(Object epackage){
		return newRulesDocumentAt(epackage,"",false);
	}
	
	/** Creates a new rules document with in existing Project */
	public OclDocument newRulesDocumentAt(Object epackage, String oclContent, boolean createTab){
		OclDocument oclDoc = new OclDocument();		
		oclDoc.setContainer(epackage);
		if(oclContent!=null) oclDoc.setContentAsString(oclContent);
		oclDoc.setName("Rules"+Models.getOclDocList().size());
		Models.getOclDocList().add(oclDoc);
		if(createTab)createConstraintEditor(oclDoc);		
		//add the rules document from the browser
		ProjectBrowser browser = frame.getProjectBrowser();
		DefaultMutableTreeNode container = browser.getTree().getNode(epackage);
		browser.getTree().addElement(container,oclDoc);
		return oclDoc;
	}
	
	//====================================================
	
	/** Close current diagram editor */
	public void closeDiagram()
	{
		Editor editor = getCurrentDiagramEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				int option = JOptionPane.showConfirmDialog(getFrame(), "Your diagram has been modified. Save changes?","Save Project", JOptionPane.YES_NO_CANCEL_OPTION);
				if (option== JOptionPane.YES_OPTION) { ProjectManager.get().saveProject(); }
				else if (option==JOptionPane.CANCEL_OPTION) { return; }
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
				int option = JOptionPane.showConfirmDialog(getFrame(), "Your rules document has been modified. Save changes?","Save Project", JOptionPane.YES_NO_CANCEL_OPTION);
				if (option== JOptionPane.YES_OPTION) { ProjectManager.get().saveProject(); }
				else if (option==JOptionPane.CANCEL_OPTION) { return; }
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

	public void findInDiagrams(Object element){
		List<OntoumlDiagram> diagrams = OccurenceManager.get().getDiagrams((RefOntoUML.Element)element);
		DiagramListDialog.open(ProjectBrowser.frame, diagrams);		
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
		
	//========================================================================
	// OPEN PROJECT
	//========================================================================
	
	/** Export Model as a Menthor Pattern **/
	/*public int exportAsMenthorPattern() 
	{
		JFileChooser fileChooser = new JFileChooser(lastSavePath);
		fileChooser.setDialogTitle("Export as Menthor Pattern");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Menthor Project (*.menthorpattern)", "menthorpattern");
		fileChooser.addChoosableFileFilter(filter);
		if(Util.onWindows()) fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		int option = fileChooser.showSaveDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			setCurrentProjectFile(saveCurrentProjectToFile(fileChooser.getSelectedFile()));
			File file = fileChooser.getSelectedFile();
			frame.setTitle(file.getName().replace(".menthor","")+" - Menthor Editor");
			lastSavePath = file.getAbsolutePath();			
		}
		return option;
	}*/
	
	
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

	public void about()
	{
		AboutDialog.open(getFrame(),MenthorEditor.MENTHOR_COMPILATION_DATE,MenthorEditor.MENTHOR_VERSION);
	}
	
	public void licenses()
	{
		LicensesDialog.open(getFrame());
	}

	/** Import a model from a XMI file (from Enterprise Architect). 
	 * @throws IOException */
	public void importFromEA() throws IOException
	{		
		JFileChooser fileChooser = new JFileChooser(lastImportEAPath);
		fileChooser.setDialogTitle("Import from EA");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XMI, XML (*.xmi, *.xml)", "xmi", "xml");
		fileChooser.addChoosableFileFilter(filter);
		if(Util.onWindows()) fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			lastImportEAPath = file.getAbsolutePath();
			new EASettingsDialog(frame, true, frame, lastImportEAPath);
			Settings.addRecentProject(file.getCanonicalPath());
		}		
	}
	
	public void importFromEARecent() throws IOException
	{		
		lastImportEAPath = getStartPage().getSelectedRecentFile();
		new EASettingsDialog(frame, true, frame, lastImportEAPath);
		Settings.addRecentProject(lastImportEAPath);				
	}
	
	public void exportToEcore() 
	{
		if(ProjectManager.get().getProject() != null) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Exportation");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Ecore (*.ecore)", "ecore");
			fileChooser.addChoosableFileFilter(filter);
			if(Util.onWindows()) fileChooser.setFileFilter(filter);
			fileChooser.setAcceptAllFileFilterUsed(false);
			if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					EcoreWriter exporter = new EcoreWriter();
					exporter.toEcore(frame,Models.getRefparser(), fileChooser.getSelectedFile());					
					frame.showSuccessfulMessageDialog("Success", "Project successfully exported to Ecore.\nLocation: "+fileChooser.getSelectedFile().getAbsolutePath());
											
				} catch (Exception ex) {
					ex.printStackTrace();
					String msg = ex.getLocalizedMessage();
					if(msg==null || msg.isEmpty()) msg = ExceptionUtils.getStackTrace(ex);
					frame.showErrorMessageDialog("Failure", "Current project could not be exported to Ecore.\nMotive: "+msg);
				}
			}
			getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}
	
	/** Export the current model as an Ecore instance file (Reference model)*/
	public void exportToXMI() 
	{
		if(getCurrentEditor() != null) {
			JFileChooser fileChooser = new JFileChooser(lastExportEcorePath);
			fileChooser.setDialogTitle("Exportation");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Reference OntoUML (*.refontouml)", "refontouml");
			fileChooser.addChoosableFileFilter(filter);
			if(Util.onWindows()) fileChooser.setFileFilter(filter);
			fileChooser.setAcceptAllFileFilterUsed(false);
			if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					XMIWriter exporter = new XMIWriter();
					exporter.toRefontouml(frame,Models.getRefparser(), fileChooser.getSelectedFile());
					lastExportEcorePath = fileChooser.getSelectedFile().getAbsolutePath();
					frame.showSuccessfulMessageDialog("Success", "Project successfully exported to RefOntoUML.\nLocation: "+fileChooser.getSelectedFile().getAbsolutePath());
				} catch (Exception ex) {
					ex.printStackTrace();
					String msg = ex.getLocalizedMessage();
					if(msg==null || msg.isEmpty()) msg = ExceptionUtils.getStackTrace(ex);
					frame.showErrorMessageDialog("Failure", "Current project could not be exported to RefOntoUML.\nMotive: "+msg);					
				}
			}
			getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}	

	/** Export the current model as an UML2 instance file (EMF-implementation of UML)
	 *  This exporting loses all the UML stereotypes that distinguishes OntoUML from UML*/
	public void exportToProfileUML() 
	{
		if(ProjectManager.get().getProject() != null) {
			JFileChooser fileChooser = new JFileChooser(lastExportUMLPath);
			fileChooser.setDialogTitle("Exportation");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("UML2 (*.uml)", "uml");
			fileChooser.addChoosableFileFilter(filter);
			if(Util.onWindows()) fileChooser.setFileFilter(filter);
			fileChooser.setAcceptAllFileFilterUsed(false);
			if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					UMLWriter exporter = new UMLWriter();
					exporter.toProfileUML(frame,Models.getRefparser(), fileChooser.getSelectedFile());
					lastExportUMLPath = fileChooser.getSelectedFile().getAbsolutePath();
					frame.showSuccessfulMessageDialog("Success", "Project successfully exported to Profile UML.\nLocation: "+fileChooser.getSelectedFile().getAbsolutePath());
											
				} catch (Exception ex) {
					ex.printStackTrace();
					String msg = ex.getLocalizedMessage();
					if(msg==null || msg.isEmpty()) msg = ExceptionUtils.getStackTrace(ex);
					frame.showErrorMessageDialog("Failure", "Current project could not be exported to Profile UML.\nMotive: "+msg);
				}
			}
			getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}	
	
	public void exportToUML() 
	{
		if(ProjectManager.get().getProject() != null) {
			JFileChooser fileChooser = new JFileChooser(lastExportUMLPath);
			fileChooser.setDialogTitle("Exportation");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("UML2 (*.uml)", "uml");
			fileChooser.addChoosableFileFilter(filter);
			if(Util.onWindows()) fileChooser.setFileFilter(filter);
			fileChooser.setAcceptAllFileFilterUsed(false);
			if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					UMLWriter exporter = new UMLWriter();
					exporter.toUML(frame,Models.getRefparser(), fileChooser.getSelectedFile());
					lastExportUMLPath = fileChooser.getSelectedFile().getAbsolutePath();
					frame.showSuccessfulMessageDialog("Success", "Project successfully exported to UML.\nLocation: "+fileChooser.getSelectedFile().getAbsolutePath());
											
				} catch (Exception ex) {
					ex.printStackTrace();
					String msg = ex.getLocalizedMessage();
					if(msg==null || msg.isEmpty()) msg = ExceptionUtils.getStackTrace(ex);
					frame.showErrorMessageDialog("Failure", "Current project could not be exported to UML.\nMotive: "+msg);
				}
			}
			getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}	
	/** Exports graphics as PNG. */
	public void exportGfx() 
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Exportation");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Portable Network Graphics file (*.png)", "png");
		fileChooser.addChoosableFileFilter(filter);
		if(Util.onWindows()) fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {			
			try {
				PngWriter exporter = new PngWriter();
				exporter.writePNG(getCurrentDiagramEditor(), fileChooser.getSelectedFile());
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(),
						"Export Image Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
			
	public void manageAntiPatterns()
	{			
		System.out.println("Opening anti-pattern dialog...");
		AntiPatternSearchDialog.open(getFrame());		
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
	
	
			
	public void editProperties(Object element)
	{
		if (element instanceof ClassElement) {
			ClassElement classElement = (ClassElement) element;			
			ElementDialogCaller.callClassDialog(frame,classElement.getClassifier(),true);			
		} else if (element instanceof AssociationElement) {
			AssociationElement association = (AssociationElement) element;
			ElementDialogCaller.callAssociationDialog(frame,(Association)association.getRelationship(),true);
		} else if (element instanceof GeneralizationElement) {
			Generalization generalization = ((GeneralizationElement)element).getGeneralization();
			ElementDialogCaller.callGeneralizationDialog(frame, generalization, true);			
		} else if (element instanceof StructureDiagram){    		
    		openTab(element);
    	} else if (element instanceof OclDocument){
    		openTab(element);
    	} else if(element instanceof RefOntoUML.Element){
    		RefOntoUML.Element e = (RefOntoUML.Element)element;
    		ElementDialogCaller.openDialog(e, frame);
    	}
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
	
	private class DescriptionComparator implements Comparator<ProblemElement> 
    {
        @Override
        public int compare(ProblemElement o1, ProblemElement o2) {
            return o1.getDescription().compareToIgnoreCase(o2.getDescription());
        }
    }
	
	public ArrayList<ProblemElement> verifyProblems()
	{
		ErrorPane errorPane = addErrorsPanel(frame.getInfoManager(),true);
		int count=0;
		ArrayList<ProblemElement> problems = new ArrayList<ProblemElement>();			
		
		double start = System.currentTimeMillis();
		
		//loading syntactical problems...			
		SyntacticVerificator verificator = new SyntacticVerificator();
		verificator.run(ProjectManager.get().getProject().getModel());			
		for(RefOntoUML.Element elem: verificator.getMap().keySet()){
			for(String message: verificator.getMap().get(elem)){					
				problems.add(new ErrorElement(elem,0,message,TypeProblem.SYNTACTIC));
			}
		}					
		
		//loading application problems...
		ErrorVerificator errorVerificator = new ErrorVerificator(Models.getRefparser());
		errorVerificator.run();
		problems.addAll(errorVerificator.getErrors());			
		
		double end = System.currentTimeMillis();	
		
		Collections.sort(problems,new DescriptionComparator());
		for(ProblemElement pe: problems) { count++; pe.setIdentifier(count); }
		errorPane.setData(problems);
		errorPane.setStatus(
			MessageFormat.format("Model verified in {0} ms, {1} error(s) found", (end - start),  problems.size())
		);
		
		return problems;
	}
	
	public ArrayList<ProblemElement> verifyWarnings()
	{
		WarningPane warningsPane = addWarningsPanel(frame.getInfoManager(),true);
		int count=0;
		ArrayList<ProblemElement> warnings = new ArrayList<ProblemElement>();				
		//loading application warnings...
		WarningVerificator warningVerificator= new WarningVerificator(Models.getRefparser());
		warningVerificator.run();
		warnings.addAll(warningVerificator.getWarnings());		
		Collections.sort(warnings,new DescriptionComparator());
		for(ProblemElement pe: warnings) { count++; pe.setIdentifier(count); }
		warningsPane.setData(warnings);
		warningsPane.setStatus(warningVerificator.getTimingMessage());
		
		return warnings;
	}
	
	public void showBottomView()
	{
		if(!frame.isShowFooterPane()) { getMainMenu().select(CommandType.CONSOLE,true); frame.showFooterPane(); }
	}
	
	/** It runs the syntactical verification of the metamodel, plus the error and warnings verificator of the application */
	public void verifyModelSyntactically() 
	{
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		if(ProjectManager.get().getProject()!=null)
		{
			ArrayList<ProblemElement> errors = verifyProblems();
			ArrayList<ProblemElement> warnings = verifyWarnings();
			
			showBottomView();
			
			if(errors.size()>0 && warnings.size()>0) {
				frame.selectErrors();
				frame.showErrorMessageDialog("Problem", "Model verified with errors.\n"+errors.size()+" problem(s) and "+warnings.size()+" warning(s) found.");				
			}
			else if(errors.size()>0 && warnings.size()==0) {
				frame.selectErrors();
				frame.showErrorMessageDialog("Problem", "Model verified with errors.\n"+errors.size()+" problem(s) found.");				
			}
			else if(errors.size()==0 && warnings.size()>0) {
				frame.selectWarnings();
				frame.showErrorMessageDialog("Warning", "Model verified with warnings.\n"+warnings.size()+" warning(s) found.");				
			}
			else {
				frame.showSuccessfulMessageDialog("Success", "Model is syntactically correct");
			}			
		}
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
	
	//======================================================================
	//
	//             THE CODE ABOVE WAS REVIWED BY JOHN
	//              NOW, I NEED TO REVIEW THESE ONES BELOW....
	//======================================================================
	//======================================================================
	
	public void undo()
	{		
		if (isProjectLoaded()==false) return;
		if(getCurrentDiagramEditor()!=null){
			if(getCurrentDiagramEditor().canUndo()){
				getCurrentDiagramEditor().undo();
			}else{				
				getFrame().showInformationMessageDialog("Cannot Undo", "No other action to be undone.\n\n");
			}
		}
	}

	public void redo()
	{
		if (isProjectLoaded()==false) return;
		if(getCurrentDiagramEditor()!=null) 
		{			
			if(getCurrentDiagramEditor().canRedo()){
				getCurrentDiagramEditor().redo();
			}else{
				getFrame().showInformationMessageDialog("Cannot Redo", "No other action to be redone.\n\n");
			}
		}
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
	
	public void simulate()
	{					
		openAlloySettings();
	}

	//==============================================================
	//OWL TRANSFORMATION
	//==============================================================
	
	@SuppressWarnings("unchecked")
	public String generateOwl(Object context){
		if(context instanceof List<?>){
			List<Object> list = (List<Object>)context;
			OntoUMLParser filteredParser = null;
			OwlOptions opt = null;
			if(list.size()>0) filteredParser = (OntoUMLParser)list.get(0);
			if(list.size()>1) opt = (OwlOptions) list.get(1);
			if(filteredParser!=null && opt!=null) return generateOwl(filteredParser, opt);			
		}
		return "No parameter passed as argument to the transformation. Method could not be called";
	}
	
	public void callOwlSettings(){		
		OwlSettingsDialog dialog = new OwlSettingsDialog(frame, 
			Models.getRefparser(),
			frame.getProjectBrowser().getAllDiagrams()
		);
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
	}
	
	private String generateOwl(OntoUMLParser filteredParser, OwlOptions trOpt) 
	{
		RefOntoUML.Package model = filteredParser.createModelFromSelections(new Copier());
		ResultType result = OWLHelper.generateOwl(filteredParser, model, getWorkingConstraints(), trOpt);
		if(result.getResultType() != Result.ERROR){	
			if(trOpt.getDestination()==OWL2Destination.TAB)
			{
				frame.getInfoManager().showOutputText(result.toString(), true, false);
				showInTextEditor((String)result.getData()[0]);
			}else{
				frame.getInfoManager().showOutputText(result.toString(), true, true);
			}
			//frame.showSuccessfulMessageDialog("SUCCESS", "Project successfully transformed.");
			return "SUCCESS. Project successfully transformed.";
		}else{
			frame.getInfoManager().showOutputText(result.toString(), true, true); 
			//frame.showErrorMessageDialog("FAILURE", "Project could not be transformed.");
			return "FAILURE. Project could not be transformed.";
		}
	}
	
	//==============================================================
	
	/** Open the Alloy simulation settings window */
	public void openAlloySettings()
	{
		if (isProjectLoaded()==false) return;		
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		//parse TOCL
		parseConstraints(false);
		TOCL2AlloyOption oclOptions = Models.getOclOptions();
		//configure a default ontouml2alloy option
		OntoUML2AlloyOptions refOptions = Models.getRefOptions();
		OntoUMLParser refparser = Models.getRefparser();
		refOptions.check(refparser);
		// open settings
		AlsSettingsDialog.open(frame,
			Models.getRefparser(),
			frame.getProjectBrowser().getAllDiagrams(),
			refOptions, 
			oclOptions
		);	
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
	
	/** Parse constraints from the editor */
	public void parseConstraints(){
		parseConstraints(true);		
	}
	
	/** Parse constraints from the editor */
	public void parseConstraints(boolean showSuccesfullyMessage)
	{
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));		
		OntoUMLParser refparser = Models.getRefparser();		
		if (refparser==null) { frame.showErrorMessageDialog("Error","Inexistent model. You need to create an Menthor project first."); return; }		
		try { 
			String name = ((RefOntoUML.Package)ProjectManager.get().getProject().getResource().getContents().get(0)).getName();
			if (name==null || name.isEmpty()) name = "model";
			TOCLParser toclparser = new TOCLParser(refparser,ProjectManager.get().getProject().getTempDir()+File.separator,name.toLowerCase());
			toclparser.parseTemporalOCL(getWorkingConstraints());			
			Models.setOclOptions(new TOCL2AlloyOption(toclparser));
			String msg =  "Constraints are syntactically correct.\n";
			if(showSuccesfullyMessage) frame.showSuccessfulMessageDialog("Parsing Constraints",msg);			
		}catch(SemanticException e2){
			frame.showErrorMessageDialog("Semantic Error",  "Parser: "+e2.getLocalizedMessage());    		
			e2.printStackTrace();	

		}catch(ParserException e1){
			frame.showErrorMessageDialog("Parsing Error", "Parser: "+e1.getLocalizedMessage());    			
			e1.printStackTrace();    	

		}catch(Exception e4){
			frame.showErrorMessageDialog("Unexpected Error", e4.getLocalizedMessage());			
			e4.printStackTrace();
		}		
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));		
	}
	
	public void showInTextEditor(String content)
	{
		TextEditor textViz = (TextEditor) getEditorForProject(ProjectManager.get().getProject(), EditorType.TEXT_EDITOR);
		if(textViz == null){
			textViz = new TextEditor(ProjectManager.get().getProject());
			addClosable(this,"Text Editor", textViz);
		}else{
			setSelectedComponent(textViz);
		}
		textViz.setText(content);
	}
	
	/** Run Transformation to Alloy */
	public void transformToAlloy(OntoUMLParser refparser, ALS4TransformationOption to)  
	{			
		try{
			if(to.getDestination()==ALS4Destination.FILE){
				if(to.getPath()!=null) Models.getAlloySpec().setAlloyPath(to.getPath());
			}
			runOntoUML2Alloy(refparser);		
			runTOCL2Alloy(refparser);			
			if(to.getDestination()==ALS4Destination.ANALYZER) {
				openAnalyzer(Models.getAlloySpec(),true, -1);			
			}
			if(to.getDestination()==ALS4Destination.TAB){				
				showInTextEditor(Models.getAlloySpec().getContent());
			}
			if(to.getDestination()==ALS4Destination.FILE){
				frame.showSuccessfulMessageDialog("Success", "Project successfully transformed to Alloy.\nLocation: "+to.getPath());			
			}
		}catch(Exception e){
			e.printStackTrace();
			String msg = e.getLocalizedMessage();
			if(msg==null || msg.isEmpty()) msg = ExceptionUtils.getStackTrace(e);
			frame.showErrorMessageDialog("Failure", "Current project could not be transformed to Alloy.\nMotive: "+msg);
		}
	}
	
	/** Run transformation from OntoUML into Alloy */
	public void runOntoUML2Alloy(OntoUMLParser refparser) throws Exception
	{		
		OntoUML2AlloyOptions refOptions = Models.getRefOptions();
		if (refparser==null) { frame.showErrorMessageDialog("Error","Inexistent model. You need to create first a Menthor project."); return; }
		Models.getAlloySpec().setDomainModel(refparser,refOptions);
		Models.getAlloySpec().transformDomainModel();	
	}
	
	/** Run Transformation from TOCL into Alloy */
	public void runTOCL2Alloy(OntoUMLParser refparser)
	{				
		TOCL2AlloyOption oclOptions = Models.getOclOptions();
		AlloySpecification alloySpec = Models.getAlloySpec();
		if (refparser==null) { frame.showErrorMessageDialog("Error","Inexistent model. You need to create first a Menthor project."); return; }
		if (oclOptions.getParser()==null) { /*frame.showErrorMessageDialog("Error","Inexistent constraints. You need to first create constraints.");*/  return; }
		try {						
			// transforming...			
			String logMessage = alloySpec.transformConstraints(refparser, oclOptions.getParser(),oclOptions);
			// log details 
			if (!logMessage.isEmpty() && logMessage!=null)
			{				
				frame.showWarningMessageDialog("Transforming Temporal OCL into Alloy",logMessage);					
			}
		} catch (Exception e) {			
			frame.showErrorMessageDialog("Transforming Temporal OCL into Alloy",e.getLocalizedMessage());					
			e.printStackTrace();
		}		
	}
		
		
	/** Open the alloy specification with the alloy analyzer */
	public void openAnalyzer (final AlloySpecification alloymodel, final boolean showAnalyzer, final int cmdIndexToExecute) 
	{
		if (alloymodel.getAlloyPath().isEmpty() || alloymodel.getAlloyPath()==null) return;
		try{
			final Timer timer = new Timer(100, null);			
			ActionListener listener = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (AlloyAnalyzer.tool().isInitialized())
					{
						AlloyAnalyzer.tool().setTheme(alloymodel.getDirectory() + "standart_theme.thm");				
						AlloyAnalyzer.tool().doOpenFile(alloymodel.getAlloyPath());				
						if (cmdIndexToExecute>=0)AlloyAnalyzer.tool().doRun(cmdIndexToExecute);						
						timer.stop();
					}
				}
			};
			timer.addActionListener(listener);
			timer.start();
		}catch(Exception e){
			e.printStackTrace();
			if(e.getLocalizedMessage().isEmpty()) frame.showErrorMessageDialog("Opening alloy file", "A unexpected error has occurred. please report this to developers.");
			else frame.showErrorMessageDialog("Opening alloy file", e.getLocalizedMessage());					
		}
	}
	
	public void generateInfoUML(final RefOntoUML.Package model) 
	{
		if(Util.onMac()){
			com.apple.concurrent.Dispatch.getInstance().getNonBlockingMainQueueExecutor().execute( new Runnable(){        	
				@Override
				public void run() {
					OntoUML2InfoUML.transformation(model, ProjectManager.get().getProject().getTempDir()+File.separator+model.getName()+".uml");
				}
			});
		}else{
			OntoUML2InfoUML.transformation(model, ProjectManager.get().getProject().getTempDir()+File.separator+model.getName()+".uml");
		}
		
	}	
	
	/**  Generate SBVR. In order to use the plug-in, we need to store the model into a file before. */
	public void generateSbvr(RefOntoUML.Package refpackage) 
	{
		ResultType result;
		String name = new String();
		if(refpackage.getName()==null || refpackage.getName().isEmpty()) name = "model";
		else name = refpackage.getName();
		String modelFileName = Util.getCanonPath(Directories.getTempDir(), name+".refontouml");
		File modelFile = new File(modelFileName);  	
    	modelFile.deleteOnExit();    	
		try {			
			RefOntoUMLResourceUtil.saveModel(modelFileName, refpackage);
			OntoUML2SBVR.Transformation(modelFileName);			
			String docPage = modelFile.getPath().replace(".refontouml", ".html");			
			frame.getInfoManager().showOutputText("SBVR generated successfully", true, true); 
			result = new ResultType(Result.SUCESS, "SBVR generated successfully", new Object[] { docPage });			
		} catch (Exception ex) {
			ex.printStackTrace();
			result = new ResultType(Result.ERROR, "Error while generating the SBVR representaion. Details: " + ex.getMessage(), null);
		}		
		if(result.getResultType() != Result.ERROR)
		{
			frame.getInfoManager().showOutputText(result.toString(), true, true);			
			String htmlFilePath = (String) result.getData()[0];
			File file = new File(htmlFilePath);
			openLinkWithBrowser(file.toURI().toString());
		}else{
			frame.getInfoManager().showOutputText(result.toString(), true, true); 
		}
	}
	
	/**
	 * Exports a Complete OCL document
	 */
	public void exportOCL() 
	{
//		try{
//			OclDocument oclmodel = ProjectBrowser.getOclDocumentFor(getCurrentProject());
//			String path = FileChoosersUtil.saveOCLPathLocation(frame,oclmodel.getPath());	    		
//			if (path==null) return;			
//			if(getCurrentConstraintEditor()!=null){
//				oclmodel.setConstraints(getCurrentConstraintEditor().getText(),"CONTENT");
//				oclmodel.setPath(path);
//				FileUtil.copyStringToFile(getCurrentConstraintEditor().getText(), path);
//			}
//		}catch(IOException exception){
//			String msg = "An error ocurred while saving the constraints to an OCL document.\n"+exception.getMessage();
//			frame.showErrorMessageDialog("Saving OCL",msg);		       			
//			exception.printStackTrace();
//		}
	}

	/**
	 * Get Resource as String
	 * @return
	 */
//	public static String getResourceString(String property) 
//	{
//		return ApplicationResources.getInstance().getString(property);
//	}

	/**
	 * Imports a Complete OCL document
	 */
	public void importOCL() 
	{
//		try{
//			if (getCurrentProject()==null) newProject();			
//			OclDocument oclmodel = ProjectBrowser.getOclDocumentFor(getCurrentProject());
//			String path = FileChoosersUtil.openOCLPathLocation(frame,oclmodel.getPath());
//			if (path==null) return;
//			oclmodel.setConstraints(path,"PATH");			
//		} catch (IOException exception) {				
//			String msg = "An error ocurred while opening the OCL document.\n"+exception.getMessage();
//			frame.showErrorMessageDialog("Opening OCL",msg);
//			exception.printStackTrace();
//		}				
	}

	
		
	private Editor getEditorForProject(UmlProject project, EditorType nature)
	{
		int totalTabs = getTabCount();
		for(int i = 0; i < totalTabs; i++)
		{
			Editor editor = (Editor)getComponentAt(i);
			if(editor.getEditorType() == nature && ProjectManager.get().getProject() == project)
			{
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

	//===================================== @Older =======================================

//	@SuppressWarnings("unused")
//	private Editor getEditorForDiagram(StructureDiagram diagram, EditorType nature)
//	{
//		int totalTabs = getTabCount();
//		for(int i = 0; i < totalTabs; i++)
//		{
//			Editor editor = (Editor)getComponentAt(i);
//			if(editor.getEditorNature() == nature && editor.getDiagram() == diagram)
//			{
//				return editor;
//			}
//		}
//		return null;
//	}

	@SuppressWarnings({ })
	public void deriveByExclusion() 
	{
		DiagramEditor activeEditor = getCurrentDiagramEditor();
		UmlProject project = ProjectManager.get().getProject();
		ExclusionDerivationOperations.createExclusionDerivation(activeEditor, project, this, activeEditor.getSelectedElements(), new OutcomeFixer(ProjectManager.get().getProject().getModel()));
		
	}
	
	@SuppressWarnings({ })
	public void deriveByUnion() 
	{
		DiagramEditor activeEditor = getCurrentDiagramEditor();
		UmlProject project = ProjectManager.get().getProject();
		Fix fix = DerivedTypesOperations.createUnionDerivation(activeEditor, project,this);
		if(fix!=null) UpdateManager.get().update(fix);		
	}
	
	public void openDerivedTypePatternUnion(Double x, Double y) {
			
		JDialog dialog = new UnionPattern(this);
		this.setCenterDialog(dialog);
		((UnionPattern) dialog).setPosition(x, y);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	
	public void openDerivedTypePatternExclusion(Double x, Double y) {
		JDialog dialog = new ExclusionPattern(this);
		this.setCenterDialog(dialog);
		((ExclusionPattern) dialog).setPosition(x, y);
		dialog.setModal(true);
		dialog.setVisible(true);
	
	}
	
	public void setCenterDialog(JDialog dialog){
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		int x_1 = (screenSize.width - dialog.getWidth()) / 2;
		int y_2 = (screenSize.height - dialog.getHeight()) / 2;
		dialog.setLocation(x_1, y_2);
	}
	
	public void runPattern(final PatternType elementType, final double x, final double y) {
		PatternTool.runPattern(this, elementType, x, y);
	}

	public void runDomainPattern(final double x, final double y) {
		DomainPatternTool.runPattern(this, x, y);
	}

	public void openDerivedTypePatternIntersection(Double x, Double y) {
		JDialog dialog = new IntersectionPattern(this);
		this.setCenterDialog(dialog);
		((IntersectionPattern) dialog).setPosition(x, y);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	
	public void openDerivedTypePatternIntersection(Point p) {
		openDerivedTypePatternIntersection(p.getX(),p.getY());
	}
	
	public void deriveByIntersection() {
		DiagramEditor activeEditor = getCurrentDiagramEditor();
		UmlProject project = ProjectManager.get().getProject();
		Fix fix = DerivedTypesOperations.createIntersectionDerivation(activeEditor, project,this);
		if(fix!=null)
			UpdateManager.get().update(fix);
		
	}
	
	public void validatesParthood() {
		ValidationDialog.open(Models.getRefparser(), frame);
		
	}
	public void openDerivedTypePatternSpecialization(double x, double y) {
		
		JDialog dialog = new SpecializationPattern(this);
		this.setCenterDialog(dialog);
		((SpecializationPattern) dialog).setPosition(x, y);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	public void deriveBySpecialization() {
		DiagramEditor activeEditor = getCurrentDiagramEditor();
		UmlProject project = ProjectManager.get().getProject();
		Fix fix = DerivedTypesOperations.createSpecializationDerivation(activeEditor, project,this);
		if(fix!=null) UpdateManager.get().update(fix);
	}
	public void openDerivedTypePatternPastSpecialization(double x, double y) {
		JDialog dialog = new PastSpecializationPattern(this);
		this.setCenterDialog(dialog);
		((PastSpecializationPattern) dialog).setPosition(x, y);
		dialog.setModal(true);
		dialog.setVisible(true);
		
	}
	public void openDerivedTypePatternParticipation(double x, double y) {
		
		JDialog dialog = new ParticipationPatternTypeChoice(this);
		this.setCenterDialog(dialog);
		((ParticipationPatternTypeChoice) dialog).setPosition(x, y);
		dialog.setModal(true);
		dialog.setVisible(true);
		
	}
	public void deriveByPastSpecialization() {
		DiagramEditor activeEditor = getCurrentDiagramEditor();
		UmlProject project = ProjectManager.get().getProject();
		DerivedTypesOperations.createPastSpecializationDerivation(activeEditor, project,this);
	}
	public void deriveByParticipation() {
		DiagramEditor activeEditor = getCurrentDiagramEditor();
		UmlProject project = ProjectManager.get().getProject();
		ParticipationDerivationOperations participation_derivation = new ParticipationDerivationOperations();
		participation_derivation.createDerivedType(activeEditor, project,this);
	}
	
	/** Save current Pattern Project to a file *.menthorpattern */
	@SuppressWarnings("unused")
	private File exportCurrentProjectToFile(File file) 
	{
		System.out.println("Saving Menthor Pattern project...");
		ProjectManager.get().getProject().setVersion(MenthorEditor.MENTHOR_VERSION);
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		if (file.exists()) file.delete();
		File result = null;
		try {
			if(!file.getName().endsWith(".menthorpattern")) {
				if(file.getName().contains(".menthor"))
					file = new File(file.getCanonicalFile().toString().replaceAll(".menthor", ".menthorpattern"));
				else
					file = new File(file.getCanonicalFile() + ".menthorpattern");
			}						
			for(ConstraintEditor ce: getConstraintEditors()){				
				if(ce!=null) ce.getOclDocument().setContentAsString(ce.getText());
			}
			ProjectManager.get().getProject().clearOpenedDiagrams();
			for(DiagramEditor editor: getDiagramEditors()){
				ProjectManager.get().getProject().saveAsOpened(editor.getDiagram());
			}			
			result = ProjectWriter.getInstance().writeProject(this, file, ProjectManager.get().getProject(), Models.getOclDocList());		
			Settings.addRecentProject(file.getCanonicalPath());
			ProjectManager.get().getProject().setName(file.getName().replace(".menthorpattern",""));
			getFrame().getProjectBrowser().refresh();
			saveAllDiagramNeeded(false);
			frame.setTitle(file.getName().replace(".menthor","")+" - Menthor Editor");
			invalidate();
			getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		} catch (Exception ex) {
			System.out.println("Failed to save Menthor Pattern project!");
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Save File Error", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Menthor Pattern project successfully saved!");
		return result;
	}

	//Export as .menthorpattern	
	public void exportAsPattern(){
		DomainPatternTool.exportModelAsPattern(ProjectManager.get().getProject());
		//call exportCurrentProject
		//call exportAsMenthorPattern
	}
	
	private UmlProject importPatternProjectFile(){
		UmlProject patternProject = null;
		
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Menthor Project (*.menthor)", "menthor");
		fileChooser.setDialogTitle("Open Menthor Pattern Project");
		fileChooser.addChoosableFileFilter(filter);
		if(Util.onWindows()) fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				System.out.println("Opening Menthor project...");				
				File file = fileChooser.getSelectedFile();
	
				ArrayList<Object> listFiles = ProjectReader.getInstance().readProject(file);
				patternProject = (UmlProject) listFiles.get(0);
			} catch (Exception ex) {
				System.out.println("Failed to open Menthor project!");	
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Importation Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
			getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			System.out.println("Menthor project successfully opened!");	
		}
		
		return patternProject;
	}
	
	public void importFromPattern(){
		//opening .menthorpattern
		UmlProject patternProject = importPatternProjectFile();
		if(patternProject != null){		
			DomainPatternTool.initializeDomainPatternPalette(frame.getToolManager().getPalleteAccordion(), patternProject, listener, frame);
		}
	}

	private boolean isModelCompleter = false;
	
	public void setModelCompleter(boolean bool) {
		isModelCompleter = bool;
	}
	
	public void runModelCompleter(Classifier elem, double x, double y) {
		if(isModelCompleter)	
			PatternTool.runModelCompleter(this,elem, x, y);
	}	
}