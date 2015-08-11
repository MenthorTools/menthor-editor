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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;

import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import net.menthor.common.ontoumlparser.OntoUMLModelStatistic;
import net.menthor.common.ontoumlparser.OntoUMLModelStatistic.TypeDetail;
import net.menthor.common.transformation.DestinationEnum;
import net.menthor.common.transformation.TransformationOption;
import net.menthor.editor.derivation.DerivedTypesOperations;
import net.menthor.editor.derivation.ExclusionDerivationOperations;
import net.menthor.editor.derivation.ExclusionPattern;
import net.menthor.editor.derivation.IntersectionPattern;
import net.menthor.editor.derivation.ParticipationDerivationOperations;
import net.menthor.editor.derivation.ParticipationPatternTypeChoice;
import net.menthor.editor.derivation.PastSpecializationPattern;
import net.menthor.editor.derivation.SpecializationPattern;
import net.menthor.editor.derivation.UnionPattern;
import net.menthor.editor.dialog.properties.ElementDialogCaller;
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
import net.menthor.editor.transformation.owl.OwlSettingsDialog;
import net.menthor.editor.ui.AlloySpecification;
import net.menthor.editor.ui.ApplicationResources;
import net.menthor.editor.ui.ClosableTabPanel;
import net.menthor.editor.ui.ConstraintEditor;
import net.menthor.editor.ui.DiagramWrapper;
import net.menthor.editor.ui.EASettingsDialog;
import net.menthor.editor.ui.LicensesDialog;
import net.menthor.editor.ui.ModelHelper;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.OWLHelper;
import net.menthor.editor.ui.PngWriter;
import net.menthor.editor.ui.ProjectBrowser;
import net.menthor.editor.ui.ProjectReader;
import net.menthor.editor.ui.ProjectWriter;
import net.menthor.editor.ui.TextEditor;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.editors.Editor;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.menus.MainMenuBar;
import net.menthor.editor.v2.trees.ProjectTree;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.EditorType;
import net.menthor.editor.v2.types.PatternType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.types.ResultType;
import net.menthor.editor.v2.types.ResultType.Result;
import net.menthor.editor.v2.ui.AboutDialog;
import net.menthor.editor.v2.ui.DiagramListDialog;
import net.menthor.editor.v2.ui.StartPage;
import net.menthor.editor.v2.util.AlloyAnalyzer;
import net.menthor.editor.v2.util.Directories;
import net.menthor.editor.v2.util.EcoreWriter;
import net.menthor.editor.v2.util.MenthorResourceFactoryImpl;
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

import org.apache.commons.lang.exception.ExceptionUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.jface.window.Window;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.DrawingContextImpl;
import org.tinyuml.draw.LineStyle;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.EditorMouseEvent;
import org.tinyuml.ui.diagram.EditorStateListener;
import org.tinyuml.ui.diagram.SelectionListener;
import org.tinyuml.ui.diagram.commands.AddConnectionCommand;
import org.tinyuml.ui.diagram.commands.AddGeneralizationSetCommand;
import org.tinyuml.ui.diagram.commands.AddNodeCommand;
import org.tinyuml.ui.diagram.commands.DeleteElementCommand;
import org.tinyuml.ui.diagram.commands.DeleteGeneralizationSetCommand;
import org.tinyuml.ui.diagram.commands.DiagramNotification;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;
import org.tinyuml.ui.diagram.commands.SetLabelTextCommand;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.AssociationElement.ReadingDesign;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.DiagramElementFactoryImpl;
import org.tinyuml.umldraw.shared.UmlConnection;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.Derivation;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.LiteralInteger;
import RefOntoUML.LiteralUnlimitedNatural;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.NamedElement;
import RefOntoUML.Property;
import RefOntoUML.Relationship;
import RefOntoUML.StringExpression;
import RefOntoUML.Type;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.parser.SyntacticVerificator;
import RefOntoUML.util.RefOntoUMLElementCustom;
import RefOntoUML.util.RefOntoUMLResourceUtil;

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
	
	private UmlProject currentProject;
	private File projectFile;
	public String lastOpenPath = new String();
	public String lastSavePath = new String();
	public String lastImportEAPath = new String();
	public String lastImportEcorePath = new String();
	public String lastExportEcorePath = new String();
	public String lastExportUMLPath = new String();
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
		ModelHelper.initializeHelper();		
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
		workingOnlyWithChecked();
		OntoUMLParser refparser = Models.getRefparser();
		generateSbvr((RefOntoUML.Model)refparser.createModelFromSelections(new Copier()));
	}
		
	public void generateInfoUML()
	{	
		workingOnlyWithChecked();
		OntoUMLParser refparser = Models.getRefparser();
		generateInfoUML((RefOntoUML.Model)refparser.createModelFromSelections(new Copier()));
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
		FoundPane finder = new FoundPane(frame.getDiagramManager().getCurrentProject(),true);
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
		WarningPane warningPane = new WarningPane(frame.getDiagramManager().getCurrentProject());
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
		ErrorPane problemsPane = new ErrorPane(frame.getDiagramManager().getCurrentProject());
		if(closable) addClosable(pane,"Errors", problemsPane);
		else addNonClosable(pane,"Errors", problemsPane);
		return problemsPane;
	}
	
	public void collectStatistics()
	{
		addStatisticsPanel(frame.getInfoManager(),true);
	}
	
	/** Adds a Statistics panel to the manager */
	public StatisticsPane addStatisticsPanel(JTabbedPane pane, boolean closable)
	{
		for(Component c: pane.getComponents()) {
			if(c instanceof StatisticsPane) { pane.setSelectedComponent(c); return (StatisticsPane)c; }
		}		
		StatisticsPane statPanel = new StatisticsPane(frame.getDiagramManager().getCurrentProject());
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

	/** Gets the project being edited */
	public UmlProject getCurrentProject() 
	{
		return currentProject;
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
		return new DiagramEditor(getFrame(),this,diagram);
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
		return projectFile;
	}

	/** Sets the file associated with the model. */
	public void setCurrentProjectFile(File modelFile)
	{
		projectFile = modelFile;
		if((this.getSelectedIndex() != -1)&& !(this.getSelectedComponent() instanceof StartPage))
		{
//			((DiagramEditorWrapper) this.getSelectedComponent()).setModelFile(modelFile);
		}
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
			Icon icon = IconMap.getInstance().getSmallIcon(IconType.MENTHOR_DIAGRAM);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}
		if(component instanceof ConstraintEditor){
			ClosableTabPanel tab = new ClosableTabPanel(pane,frame);
			Icon icon = IconMap.getInstance().getSmallIcon(IconType.MENTHOR_DOC_OCL);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}
		if(component instanceof TextEditor){
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getSmallIcon(IconType.MENTHOR_DOC);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}
		if(component instanceof FoundPane){
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getSmallIcon(IconType.MENTHOR_SEARCH);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}		
		if(component instanceof ProblemPane){
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getSmallIcon(IconType.MENTHOR_ERROR);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}
		if(component instanceof StatisticsPane){
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getSmallIcon(IconType.MENTHOR_STATS);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
		}		
		if(component instanceof WarningPane) {
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getSmallIcon(IconType.MENTHOR_WARNING);
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);			
		}
		if(component instanceof ErrorPane) {
			ClosableTabPanel tab = new ClosableTabPanel(pane,false,frame);
			Icon icon = IconMap.getInstance().getSmallIcon(IconType.MENTHOR_ERROR);
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
		if(component instanceof ProblemPane) pane.setIconAt(pane.indexOfComponent(component),new ImageIcon(pane.getClass().getResource("/resources/icons/x16/spellcheck.png")));		
		if(component instanceof StatisticsPane) pane.setIconAt(pane.indexOfComponent(component),new ImageIcon(pane.getClass().getResource("/resources/icons/x16/diagnostic.png")));
		if(component instanceof FoundPane) pane.setIconAt(pane.indexOfComponent(component),new ImageIcon(pane.getClass().getResource("/resources/icons/x16/find.png")));
		if(component instanceof ConstraintEditor) pane.setIconAt(pane.indexOfComponent(component),new ImageIcon(pane.getClass().getResource("/resources/icons/x16/text-editor.png")));
		if(component instanceof DiagramWrapper) pane.setIconAt(pane.indexOfComponent(component),new ImageIcon(pane.getClass().getResource("/resources/icons/x16/diagram.png")));
		if(component instanceof WarningPane) pane.setIconAt(pane.indexOfComponent(component),new ImageIcon(pane.getClass().getResource("/resources/icons/x16/exclamation_octagon_fram.png")));
		if(component instanceof ErrorPane) pane.setIconAt(pane.indexOfComponent(component),new ImageIcon(pane.getClass().getResource("/resources/icons/x16/cross_octagon.png")));
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
	
	/** Tell the application that we need to save the project i.e. the project was modified */
	public void saveProjectNeeded(boolean value)
	{
		currentProject.setSaveModelNeeded(value);		
		//frame.getMainToolBar().enableButton(CommandType.SAVE_PROJECT, value);
	}
	
	public boolean isSaveProjectNeeded()
	{
		return currentProject.isSaveModelNeeded();		
	}
	
	/** Tell the application that we need to save the diagram i.e. the diagram was modified */
	public void saveDiagramNeeded(StructureDiagram diagram, boolean value)
	{
		diagram.setSaveNeeded(value);
		saveProjectNeeded(value);
	}
	
	/** Tell the application that we need to save all diagrams i.e. the diagrams were all modified */
	public void saveAllDiagramNeeded(boolean value)
	{
		for(OntoumlDiagram d: getCurrentProject().getDiagrams()) ((StructureDiagram)d).setSaveNeeded(value);
		saveProjectNeeded(value);	
	}
	
	/** Create a project */
	public UmlProject createCurrentProject(RefOntoUML.Package model)
	{		
		currentProject = new UmlProject(model);
		saveProjectNeeded(false);
		frame.getProjectBrowser().set(currentProject);
		frame.getInfoManager().setProject(currentProject);
		
		for(OntoumlDiagram diagram: currentProject.getDiagrams()) 
			createDiagramEditor((StructureDiagram)diagram);
		
		if(currentProject.getDiagrams().size()==0) 
			newDiagram(currentProject,null);
		
		newRulesDocument(false);
		
		newRulesDocument(false);
		return currentProject;
	}

	/** Create a project */
	public void createEmptyCurrentProject()
	{
		currentProject = new UmlProject();
		saveProjectNeeded(false);
		frame.getProjectBrowser().set(currentProject);
		frame.getInfoManager().setProject(currentProject);
		newDiagram(currentProject,null);
		newRulesDocument(null);
	}

	/** Verifies if there is a project opened/loaded. */
	public boolean isProjectLoaded()
	{
		if (getCurrentProject()==null) {
			frame.showInformationMessageDialog("Menthor Project", "There is no Menthor Project opened");
			return false;
		}else{
			return true;
		}
	}

	/** Close Project */
	public void closeCurrentProject()
	{
		if (currentProject!=null){
			
			if(isSaveProjectNeeded()){
				int response = JOptionPane.showOptionDialog(
						this,
						"Do you really want to close the current project?",
						"Close project?", 
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						new String[]{"Save and Close", "Close", "Cancel"},
						"default");
				
				if(response==JOptionPane.YES_OPTION){
					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					saveProject();
					setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));			
				}
			}			
			System.out.println("Closing current project");
			removeAll();
			frame.setTitle("Menthor Editor");	
			frame.getProjectBrowser().clear();
			frame.getInfoManager().eraseProject();										
			currentProject=null;				
			addStartPanel(this,false);
			frame.showOnlyStartPage();

			System.out.println("Current project closed");
		}
		repaint();
		revalidate();
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
		StructureDiagram diagram = newDiagram(getCurrentProject(),null);
		saveDiagramNeeded(diagram,false);
	}
	
	/** Creates a new Diagram with in existing Project */
	public StructureDiagram newDiagram(UmlProject project){	
		return newDiagram(project,null);
	}
	
	/** Creates a new Diagram with in existing Project */
	public StructureDiagram newDiagram(Object epackage){	
		return newDiagram(getCurrentProject(),epackage);
	}
	
	/** Creates a new Diagram with in existing Project */
	public StructureDiagram newDiagram(UmlProject project, Object epackage){	
		StructureDiagram diagram = new StructureDiagram(project,elementFactory,drawingContext);
		if(epackage!=null)diagram.setContainer(epackage);
		setDefaultDiagramSize(diagram);
		diagram.setLabelText("Diagram"+getCurrentProject().getDiagrams().size());
		getCurrentProject().addDiagram(diagram);
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
		if (obj instanceof StructureDiagram) renameDiagram((StructureDiagram)obj);		
		else if (obj instanceof OclDocument) renameOclDocument((OclDocument)obj);							
		else if (obj instanceof RefOntoUML.Element) renameElement((RefOntoUML.Element)obj);		
	}
	
	//====================================================
	// NEW RULES DOCUMENT
	//====================================================
	
	/** Creates a new rules document on the current Project */
	public OclDocument newRulesDocument(){
		return newRulesDocument(null);		
	}
	
	/** Creates a new rules document with in existing Project */
	public OclDocument newRulesDocument(Object epackage){
		OclDocument oclDoc = new OclDocument();
		oclDoc.setContainer(epackage);
		ArrayList<OclDocument> docs = Models.getOclDocList();			
		oclDoc.setName("Rules"+docs.size());			
		docs.add(oclDoc);
		createConstraintEditor(oclDoc);		
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
				if (option== JOptionPane.YES_OPTION) {saveProject(); }
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
				if (option== JOptionPane.YES_OPTION) {saveProject(); }
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
		List<OntoumlDiagram> diagrams = ProjectBrowser.frame.getDiagramManager().getDiagrams((RefOntoUML.Element)element);
		DiagramListDialog.open(ProjectBrowser.frame, diagrams);		
	}
	
	/** Delete Diagram */
	public void deleteDiagram(StructureDiagram diagram, boolean showwarning)
	{
		int response = -1;
		if (showwarning){
			response = JOptionPane.showConfirmDialog(
				frame, 
				"Are you sure that you want to delete this diagram?\nThis action CANNOT be undone.", 
				"Delete diagram", 
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null
			);
		}else{
			response = Window.OK;
		}
		if(response==Window.OK)
		{	
			//first remove all the elements in the diagram
			for(DiagramElement dElem: diagram.getChildren()) {
				if(dElem instanceof ClassElement) deleteFromDiagram(((ClassElement)dElem).getClassifier(), getDiagramEditor(diagram));
				if(dElem instanceof AssociationElement) deleteFromDiagram(((AssociationElement)dElem).getRelationship(), getDiagramEditor(diagram));
				if(dElem instanceof GeneralizationElement) deleteFromDiagram(((GeneralizationElement)dElem).getRelationship(), getDiagramEditor(diagram));
			}
			//second deletes the diagram
			getCurrentProject().getDiagrams().remove(diagram);
			for(Component c: getComponents()){
				if (c instanceof DiagramWrapper){
					if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) remove(c);
				}
			}		
			//remove the diagram from the browser
			ProjectBrowser browser = frame.getProjectBrowser();
			browser.getTree().removeCurrentNode();
		}
	}

	/** Delete OCL Document */
	public void deleteOclDocument(OclDocument doc, boolean showwarning)
	{		
		int response = -1;
		if (showwarning){
			response = JOptionPane.showConfirmDialog(
				frame, 
				"Are you sure that you want to delete this document?\nThis action CANNOT be undone.", 
				"Delete document", 
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null
			);
		}else{
			response = Window.OK;
		}
		if(response==Window.OK)
		{	
			ProjectBrowser pb = frame.getProjectBrowser();
			Models.getOclDocList().remove(doc);
			for(Component c: getComponents()){
				if (c instanceof ConstraintEditor){
					if (((ConstraintEditor)c).getOclDocument().equals(doc)) remove(c);
				}
			}		
			pb.getTree().removeCurrentNode();
		}
	}
	
	/** Get the names of all diagrams */
	public ArrayList<String> getDiagramNames()
	{
		ArrayList<String> result = new ArrayList<String>();
		for(OntoumlDiagram d: currentProject.getDiagrams()){
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
	
	/** Rename diagram */
	public void renameDiagram(final StructureDiagram diagram)
	{
		String text = new String();    						
		text = (String)JOptionPane.showInputDialog(ProjectBrowser.frame,"Please, enter the new name:","Rename Diagram",JOptionPane.INFORMATION_MESSAGE,null,null,diagram.getName());    						
		final String newtext = text;		
		if(text!=null)
		{
			if(getDiagramNames().contains(text)){
				//diagram name must be unique
			}else{
				SwingUtilities.invokeLater(new Runnable() {				
					@Override
					public void run() {
						diagram.setName(newtext);
						int index = getTabIndex(diagram);					
						if(index>=0) setTitleAt(index, newtext);			        
						updateUI();
						getFrame().getProjectBrowser().refresh();				        
					}
				});				
			}
		}		
	}
	
	/** Rename OCL document */
	public void renameOclDocument(final OclDocument oclDoc)
	{
		String text = new String();    						
		text = (String)JOptionPane.showInputDialog(ProjectBrowser.frame,"Please, enter the new name:","Rename OCL Document",JOptionPane.INFORMATION_MESSAGE,null,null,oclDoc.getName());    						
		final String newtext = text;
		if(text!=null)
		{
			if(getOclDocumentNames().contains(text)){
				// ocl document name must be unique
			}else{
				SwingUtilities.invokeLater(new Runnable() {				
					@Override
					public void run() {
						oclDoc.setName(newtext);
						int index = getTabIndex(oclDoc);					
						if(index>=0) setTitleAt(index, newtext);			        
				        getFrame().getProjectBrowser().refresh();	
				        updateUI();
					}
				});
			}
		}		
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
	
	class MenthorFilter extends javax.swing.filechooser.FileFilter {
	    public boolean accept(File file) {
	        String filename = file.getName();
	        return filename.endsWith(".menthor");
	    }
	    public String getDescription() {
	        return "Menthor Project (*.menthor)";
	    }
	}
	
	/** New Menthor Project. */
	public void newProject() 
	{				
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("New Project");
		fileChooser.addChoosableFileFilter(new MenthorFilter());
		fileChooser.setSelectedFile(new File("*.menthor"));
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showDialog(this,"OK") == JFileChooser.APPROVE_OPTION) {
			try {			
				getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));				
				System.out.println("Creating New project");				
				closeCurrentProject();
				File file = fileChooser.getSelectedFile();				
				if (!file.exists()){
					if(!file.getName().endsWith(".menthor")) {
						file = new File(file.getCanonicalFile() + ".menthor");
					}else{
						file = new File(file.getCanonicalFile()+"");
					}
				}				
				JRootPane root = frame.getRootPane( );
				root.putClientProperty( "Window.documentFile", file );
				setCurrentProjectFile(file);
				createEmptyCurrentProject();				
				saveCurrentProjectToFile(file);
				frame.setTitle(file.getName().replace(".menthor","")+" - Menthor Editor");
				frame.forceShowBrowserPane();
				frame.forceShowPalettePane();				
				frame.getMainMenu().activateAll();
				System.out.println("New project succesffully created");
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), getResourceString("error.readfile.title"), JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}	

	/** Open diagrams loaded from the project. It only opens those diagrams saved as opened. */
	public void openDiagrams()
	{
		if(currentProject.isAllClosed() && currentProject.getDiagrams().size()>0){
			System.out.println("Loading diagram \""+currentProject.getDiagrams().get(0).getName()+"\"");	
			createDiagramEditor((StructureDiagram)currentProject.getDiagrams().get(0));
		}else{
			for(OntoumlDiagram diagram: currentProject.getDiagrams()) {
				if(currentProject.isOpened(diagram)){
					System.out.println("Loading diagram \""+diagram.getName()+"\"");	
					createDiagramEditor((StructureDiagram)diagram);
				}
			}
		}
	}
	
	/** Open an existing project. */
	public void openProject() 
	{		
		JFileChooser fileChooser = new JFileChooser(lastOpenPath);
		fileChooser.setDialogTitle("Open Project");
		fileChooser.addChoosableFileFilter(new MenthorFilter());	
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				closeCurrentProject();				
				System.out.println("Opening Menthor project...");				
				File file = fileChooser.getSelectedFile();
				JRootPane root = frame.getRootPane( );
				root.putClientProperty( "Window.documentFile", file );
				setCurrentProjectFile(file);
				lastOpenPath = file.getAbsolutePath();
				ArrayList<Object> listFiles = ProjectReader.getInstance().readProject(file);
				currentProject = (UmlProject) listFiles.get(0);
				openListFiles(listFiles);
				frame.forceShowBrowserPane();
				frame.forceShowPalettePane();
				frame.getMainMenu().activateAll();
				
			} catch (Exception ex) {
				System.out.println("Failed to open Menthor project!");	
				JOptionPane.showMessageDialog(this, ex.getMessage(), getResourceString("error.readfile.title"), JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
			getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			System.out.println("Menthor project successfully opened!");	
		}		
	}
	
	/** Open an existing project. */
	public void openRecentProject(){
		StartPage startPanel = (StartPage) getCurrentEditor();
		if(startPanel != null){
			openProject(startPanel.getSelectedRecentFile());
		}
	}
	public void openProject(String filePath) 
	{
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		try {
			closeCurrentProject();
			System.out.println("Opening recent project");				
			File file = new File(filePath);
			JRootPane root = frame.getRootPane( );
			root.putClientProperty( "Window.documentFile", file );			
			setCurrentProjectFile(file);
			ArrayList<Object> listFiles = ProjectReader.getInstance().readProject(file);
			currentProject = (UmlProject) listFiles.get(0);				
			openListFiles(listFiles);	
			frame.forceShowBrowserPane();
			frame.forceShowPalettePane();		
			frame.getMainMenu().activateAll();
			
		} catch (Exception ex) {
			System.out.println("Failed to open Menthor project!");	
			JOptionPane.showMessageDialog(this, ex.getMessage(), getResourceString("error.readfile.title"), JOptionPane.ERROR_MESSAGE);
		}
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		System.out.println("Menthor project successfully opened!");	
	}

	/** Open Menthor project from the list of object read from stream as a result of the menthor file serialization */
	private void openListFiles(ArrayList<Object> listFiles) throws IOException
	{
		currentProject = (UmlProject) listFiles.get(0);
		ProjectBrowser pb = frame.getProjectBrowser();		
		for(int i=1; i<listFiles.size();i++)
		{																
			OclDocument oclDoc = (OclDocument)listFiles.get(i);										
			Models.getOclDocList().add(oclDoc);
		}
		pb.set(currentProject);
		frame.getInfoManager().setProject(currentProject);	
		openDiagrams();
		saveProjectNeeded(false);				
		Settings.addRecentProject(projectFile.getCanonicalPath());
		frame.setTitle(projectFile.getName().replace(".menthor","")+" - Menthor Editor");				
	}
	
	/** Save current Project to a file *.menthor */
	private File saveCurrentProjectToFile(File file) 
	{
		System.out.println("Saving Menthor project...");
		currentProject.setVersion(Main.MENTHOR_VERSION);
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		if (file.exists()) file.delete();
		File result = null;
		try {
			if(!file.getName().endsWith(".menthor")) {
				file = new File(file.getCanonicalFile() + ".menthor");
			}						
			for(ConstraintEditor ce: getConstraintEditors()){				
				if(ce!=null) ce.getOclDocument().setContentAsString(ce.getText());
			}
			currentProject.clearOpenedDiagrams();
			for(DiagramEditor editor: getDiagramEditors()){
				currentProject.saveAsOpened(editor.getDiagram());
			}			
			result = ProjectWriter.getInstance().writeProject(this, file, currentProject, Models.getOclDocList());		
			Settings.addRecentProject(file.getCanonicalPath());
			getCurrentProject().setName(file.getName().replace(".menthor",""));
			getFrame().getProjectBrowser().refresh();
			saveAllDiagramNeeded(false);
			frame.setTitle(file.getName().replace(".menthor","")+" - Menthor Editor");
			invalidate();
			getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		} catch (Exception ex) {
			System.out.println("Failed to save Menthor project!");
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, ex.getMessage(), getResourceString("error.savefile.title"), JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Menthor project successfully saved!");
		return result;
	}

	/** Saves immediately if possible. */
	public void saveProject() 
	{
		if (getCurrentProjectFile() == null) 
		{
			int option = saveProjectAs();
			if (option!=JFileChooser.APPROVE_OPTION){
				repaint();
				revalidate();				
				return;
			}
		}else{
			saveCurrentProjectToFile(getCurrentProjectFile());
		}
		repaint();
		revalidate();
	}

	/** Saves the project with a file chooser. */
	public int saveProjectAs() 
	{
		JFileChooser fileChooser = new JFileChooser(lastSavePath);
		fileChooser.setDialogTitle("Save Project");
		fileChooser.addChoosableFileFilter(new MenthorFilter());
		fileChooser.setAcceptAllFileFilterUsed(false);
		int option = fileChooser.showSaveDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			setCurrentProjectFile(saveCurrentProjectToFile(fileChooser.getSelectedFile()));
			File file = fileChooser.getSelectedFile();
			frame.setTitle(file.getName().replace(".menthor","")+" - Menthor Editor");
			lastSavePath = file.getAbsolutePath();			
		}
		return option;
	}
	
	/** Export Model as a Menthor Pattern **/
	public int exportAsMenthorPattern() 
	{
		JFileChooser fileChooser = new JFileChooser(lastSavePath);
		fileChooser.setDialogTitle("Export as Menthor Pattern");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Menthor Project (*.menthorpattern)", "menthorpattern");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		int option = fileChooser.showSaveDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			setCurrentProjectFile(saveCurrentProjectToFile(fileChooser.getSelectedFile()));
			File file = fileChooser.getSelectedFile();
			frame.setTitle(file.getName().replace(".menthor","")+" - Menthor Editor");
			lastSavePath = file.getAbsolutePath();			
		}
		return option;
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
		ModelHelper.addMapping(editor.getDiagram());
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
		AboutDialog.open(getFrame(),Main.MENTHOR_COMPILATION_DATE,Main.MENTHOR_VERSION);
	}
	
	public void licenses()
	{
		LicensesDialog.open(getFrame());
	}

	/** Import a Reference OntoUML model instance. */
	public void importFromXMI() 
	{
		JFileChooser fileChooser = new JFileChooser(lastImportEcorePath);
		fileChooser.setDialogTitle(getResourceString("dialog.saveas.title"));
		fileChooser.setDialogTitle(getResourceString("dialog.importecore.title"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Reference OntoUML Model (*.refontouml)", "refontouml");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				closeCurrentProject();
				getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new MenthorResourceFactoryImpl());
				resourceSet.getPackageRegistry().put(RefOntoUML.RefOntoUMLPackage.eNS_URI, RefOntoUML.RefOntoUMLPackage.eINSTANCE);
				File ecoreFile = new File(fileChooser.getSelectedFile().getPath());					
				org.eclipse.emf.common.util.URI fileURI = org.eclipse.emf.common.util.URI.createFileURI(ecoreFile.getAbsolutePath());		
				Resource resource = resourceSet.createResource(fileURI);		
				resource.load(Collections.emptyMap());
				File projectFile = new File(ecoreFile.getAbsolutePath().replace(".refontouml", ".menthor"));
				JRootPane root = frame.getRootPane( );
				root.putClientProperty( "Window.documentFile", projectFile );
				setCurrentProjectFile(projectFile);
				lastOpenPath = projectFile.getAbsolutePath();
				createCurrentProject((RefOntoUML.Package)resource.getContents().get(0));
				saveCurrentProjectToFile(projectFile);
				lastImportEcorePath = fileChooser.getSelectedFile().getAbsolutePath();
				Settings.addRecentProject(projectFile.getCanonicalPath());
				newDiagram();
				frame.setTitle(projectFile.getName().replace(".menthor","")+" - Menthor Editor");
				getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				frame.forceShowBrowserPane();
				frame.forceShowPalettePane();
				frame.getMainMenu().activateAll();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(),getResourceString("dialog.importecore.title"),JOptionPane.ERROR_MESSAGE);
			}
		}
		getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	

	/** Import a model from a XMI file (from Enterprise Architect). 
	 * @throws IOException */
	public void importFromEA() throws IOException
	{		
		JFileChooser fileChooser = new JFileChooser(lastImportEAPath);
		fileChooser.setDialogTitle("Import from EA");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XMI, XML (*.xmi, *.xml)", "xmi", "xml");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			lastImportEAPath = file.getAbsolutePath();
			new EASettingsDialog(frame, true, this, lastImportEAPath);
			Settings.addRecentProject(file.getCanonicalPath());
		}		
	}
	
	public void importFromEARecent() throws IOException
	{		
		lastImportEAPath = getStartPage().getSelectedRecentFile();
		new EASettingsDialog(frame, true, this, lastImportEAPath);
		Settings.addRecentProject(lastImportEAPath);				
	}
	
	public void exportToEcore() 
	{
		if(getCurrentProject() != null) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Exportation");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Ecore (*.ecore)", "ecore");
			fileChooser.addChoosableFileFilter(filter);
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
		if(getCurrentProject() != null) {
			JFileChooser fileChooser = new JFileChooser(lastExportUMLPath);
			fileChooser.setDialogTitle("Exportation");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("UML2 (*.uml)", "uml");
			fileChooser.addChoosableFileFilter(filter);
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
		if(getCurrentProject() != null) {
			JFileChooser fileChooser = new JFileChooser(lastExportUMLPath);
			fileChooser.setDialogTitle("Exportation");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("UML2 (*.uml)", "uml");
			fileChooser.addChoosableFileFilter(filter);
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
		fileChooser.setDialogTitle(getResourceString("dialog.exportgfx.title"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Portable Network Graphics file (*.png)", "png");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {			
			try {
				PngWriter exporter = new PngWriter();
				exporter.writePNG(getCurrentDiagramEditor(), fileChooser.getSelectedFile());
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(),
						getResourceString("error.exportgfx.title"),
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/** 
	 *  Tell the application to work only with the set of elements contained in the diagram.
	 *  
	 *  This method check in the tree all the elements contained in the diagram.
	 *  If something is missing it completes the checking with the missing elements.
	 *  The elements checked  in the tree are then properly selected in the OntoUML parser.
	 *  This then enables all the application to work only with the selected/checked elements in the parser. 
	 */
	public void workingOnlyWith(StructureDiagram diagram)
	{
		// get elements from the diagram
		List<EObject> elements = ModelHelper.getElements(diagram);
		//complete missing/mandatory dependencies on the parser
		OntoUMLParser refparser = Models.getRefparser();				
		refparser.select((ArrayList<EObject>)elements,true);
		List<EObject> added = refparser.autoSelectDependencies(OntoUMLParser.NO_HIERARCHY,false);
		elements.removeAll(added);
		elements.addAll(added);
		//check in the tree the selected elements of the parser
		ProjectBrowser pb = frame.getProjectBrowser();
		//pb.getTree().check(elements, true);					
		pb.getTree().updateUI();		
		Models.setRefparser(refparser);
	}
	
	/** Tell the application to work only with the elements contained in these diagrams. */
	public void workingOnlyWith(ArrayList<StructureDiagram> diagrams)
	{
		ArrayList<EObject> elements = new ArrayList<EObject>();
		for(StructureDiagram sd: diagrams) {
			for(DiagramElement de: sd.getChildren()){
				if(de instanceof ClassElement) {
					Classifier c = ((ClassElement)de).getClassifier();
					elements.add(c);
					if(c instanceof RefOntoUML.Class) {
						for(Property attr: ((RefOntoUML.Class)c).getOwnedAttribute()) {
							elements.add(attr);
							if(!elements.contains(attr.getType())) elements.add(attr.getType());
						}
					}
					if(c instanceof RefOntoUML.DataType) {
						for(Property attr: ((RefOntoUML.DataType)c).getOwnedAttribute()) {
							elements.add(attr);
							if(!elements.contains(attr.getType())) elements.add(attr.getType());
						}
					}
				}
				if(de instanceof AssociationElement) { 
					Association r = (Association)((AssociationElement)de).getRelationship();
					elements.add(r.getMemberEnd().get(0));
					elements.add(r.getMemberEnd().get(1));
					elements.add(r);								
				}
				if(de instanceof GeneralizationElement) {
					Relationship rel = ((GeneralizationElement)de).getRelationship();
					elements.add(rel);
					elements.addAll(((Generalization)rel).getGeneralizationSet());				 
				}
			}		
		}			
		//complete missing/mandatory dependencies on the parser
		OntoUMLParser refparser = Models.getRefparser();				
		refparser.select((ArrayList<EObject>)elements,true);
		List<EObject> added = refparser.autoSelectDependencies(OntoUMLParser.NO_HIERARCHY,false);
		elements.removeAll(added);
		elements.addAll(added);
		//check in the tree the selected elements of the parser
		ProjectBrowser modeltree = frame.getProjectBrowser();
		//modeltree.getTree().check(elements, true);					
		modeltree.getTree().updateUI();		
		Models.setRefparser(refparser);
	}
	
	/** 
	 * Tell the application to work only with the checked elements in the tree.
	 * 
	 * This method check if some dependence is missing in the checking, completing it with the missing elements.
	 * The elements checked  in the tree are then properly selected in the OntoUML parser.
	 * This  enables all the application to work only with the checked elements in the parser/tree.
	 * @return 
	 */
	public List<Object> workingOnlyWithChecked()
	{	
		// This method does a lot of processing and updates the UI -- 
		//This causes lag and frozen ui because they take a lot of time on big models.
		//Suggestion: Call this method from a "doInBackground" of a SwingWorker and the commented ones from "done".
		OntoUMLParser refparser = Models.getRefparser();
		ProjectBrowser modeltree = frame.getProjectBrowser();			
		List<Object> selected = modeltree.getTree().getCheckedElements();
		List<EObject> result = new ArrayList<EObject>();
		for(Object c: selected){
			result.add((EObject)c);
		}
		refparser.select(result,true);		
		List<EObject> added = refparser.autoSelectDependencies(OntoUMLParser.NO_HIERARCHY,false);		
		selected.removeAll(added);
		selected.addAll(added);	
		
//		modeltree.getTree().checkModelElements(selected, true);			
		modeltree.getTree().updateUI();
	
		Models.setRefparser(refparser);
		
		return selected;
	}
	
	/** 
	 * Tell the application to work with all elements in the model.
	 * 
	 * This method check all the elements of the model in the tree. Then properly select them in the OntoUML parser.
	 * This  enables all the application to work with all the elements in the parser/tree.
	 */
	public void workingWithAll()
	{
		OntoUMLParser refparser = Models.getRefparser();
		ProjectBrowser pb = frame.getProjectBrowser();			
		//pb.getTree().checkModelElement(currentProject.getModel());
		refparser.selectAll();		
		pb.getTree().updateUI();		
		Models.setRefparser(refparser);
	}
	
	/** Add relationship to the model instance (not to diagram). */
	public RefOntoUML.Relationship addRelation(RelationshipType stereotype, EObject eContainer)
	{
		RefOntoUML.Relationship relationship = elementFactory.createRelationship(stereotype);
		// add default properties
		if(relationship instanceof RefOntoUML.Association) elementFactory.createPropertiesByDefault((RefOntoUML.Association)relationship);
		//to add only in the model do exactly as follow				
		if (stereotype==RelationshipType.GENERALIZATION) {
			AddConnectionCommand cmd = new AddConnectionCommand(null,null,relationship,(RefOntoUML.Classifier)eContainer,null,getCurrentProject(),null);
			cmd.run();
		}else{
			AddConnectionCommand cmd = new AddConnectionCommand(null,null,relationship,null,null,getCurrentProject(),eContainer);
			cmd.run();
		}
		return relationship;
	}

	/** Add comment to the model instance (not to diagram) */
	public RefOntoUML.Comment addComment(RefOntoUML.Element eContainer)
	{
		RefOntoUML.Comment comment = elementFactory.createComment();
		//to add only in the model do exactly as follow		
		AddNodeCommand cmd = new AddNodeCommand(null,null,comment,0,0,getCurrentProject(),eContainer);		
		cmd.run();
		return comment;
	}

	/** Add comment to the model instance (not to diagram) */
	public RefOntoUML.Element addPackage(RefOntoUML.Element eContainer)
	{
		RefOntoUML.Element comment = elementFactory.createPackage();
		//to add only in the model do exactly as follow		
		AddNodeCommand cmd = new AddNodeCommand(null,null,comment,0,0,getCurrentProject(),eContainer);		
		cmd.run();
		return comment;
	}
	
	/** Add constraintx to the model instance (not to diagram) */
	public void addConstraintx(Constraintx cmt, RefOntoUML.Element eContainer) 
	{
		//to add only in the model do exactly as follow		
		AddNodeCommand cmd = new AddNodeCommand(null,null,cmt,0,0,getCurrentProject(),eContainer);		
		cmd.run();
	}
	

	/** Add constraintx to the model instance (not to diagram) */
	public void addConstraintx(RefOntoUML.Element eContainer) 
	{
		addConstraintx("",eContainer);
	}
	
	/** Add constraintx to the model instance (not to diagram) */
	public void addConstraintx(String text, RefOntoUML.Element eContainer) 
	{
		RefOntoUML.Constraintx element = elementFactory.createConstraintx();
		((StringExpression)element.getSpecification()).setSymbol(text);
		//to add only in the model do exactly as follow		
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,getCurrentProject(),eContainer);		
		cmd.run();				
	}
	
	public void manageAntiPatterns()
	{			
		System.out.println("Opening anti-pattern dialog...");
		AntiPatternSearchDialog.open(getFrame());		
	}
	
	/** Add comment to the model instance (not to diagram) */
	public void addComment(RefOntoUML.Comment c, RefOntoUML.Element eContainer)
	{
		//to add only in the model do exactly as follow		
		AddNodeCommand cmd = new AddNodeCommand(null,null,c,0,0,getCurrentProject(),eContainer);		
		cmd.run();
	}
		
	/** Add element to the model instance (not to diagram).  */
	public RefOntoUML.Element addGeneralizationSet(RefOntoUML.Element eContainer)
	{
		RefOntoUML.Element element = elementFactory.createGeneralizationSet();		
		//to add only in the model do exactly as follow		
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,getCurrentProject(),eContainer);		
		cmd.run();		
		return element;
	}

	/** Add element to the model instance (not to diagram).  */
	public RefOntoUML.Element addClass(ClassType stereotype, RefOntoUML.Element eContainer)
	{	
		RefOntoUML.Element element = elementFactory.createClass(stereotype);		
		//to add only in the model do exactly as follow		
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,getCurrentProject(),eContainer);		
		cmd.run();		
		return element;
	}
	
	/** Add element to the model instance (not to diagram).  */
	public RefOntoUML.Element addDataType(DataType stereotype, RefOntoUML.Element eContainer)
	{
		RefOntoUML.Element element = elementFactory.createDataType(stereotype);		
		//to add only in the model do exactly as follow		
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,getCurrentProject(),eContainer);		
		cmd.run();		
		return element;
	}
	
	/** Rename an element. It updates the application accordingly (including the diagrams in which the element appears). It also shows a input dialog for text entry. */
	public void renameElement(RefOntoUML.Element element)
	{
		if (element instanceof NamedElement) 
		{
			String value = new String();    						
			value = (String)JOptionPane.showInputDialog(ProjectBrowser.frame,"Please, enter the new name:","Rename Element ",JOptionPane.INFORMATION_MESSAGE,null,null,((NamedElement)element).getName());    						
			if(value!=null)
			{
				((NamedElement)element).setName(value);
				ArrayList<DiagramEditor> editors = ProjectBrowser.frame.getDiagramManager().getDiagramEditors(element);
				ArrayList<DiagramElement> dElemList = ModelHelper.getDiagramElements(element);
				for(DiagramElement dElem: dElemList)
				{
					if (dElem instanceof ClassElement)
					{
						SetLabelTextCommand cmd = new SetLabelTextCommand((DiagramNotification)editors.get(0),((ClassElement)dElem).getMainLabel(),value,ProjectBrowser.frame.getDiagramManager().getCurrentProject());
						cmd.run();
					}
				}
				frame.getDiagramManager().updateMenthorFromModification(element, false);
			}
		}   
	}	
	
	public void delete(List<Object> elems){
		for(Object o: elems){
			delete(o);
		}
	}
	
	public void delete(Object elem)
	{	
		if (elem instanceof StructureDiagram)
		{
			frame.getDiagramManager().deleteDiagram((StructureDiagram)elem,true);    					
		}
		else if (elem instanceof OclDocument)
		{
			frame.getDiagramManager().deleteOclDocument((OclDocument)elem,true);    					
		}
		else if (elem instanceof RefOntoUML.Element){				
			frame.getDiagramManager().deleteFromMenthor((RefOntoUML.Element)elem,true);    					    					
		}				
	}
	
	/** Delete element from the model and every diagram in each it appears. */
	public void deleteFromMenthor(RefOntoUML.Element element, boolean showwarning)
	{	
		int response = -1;
		if (showwarning){
			response = JOptionPane.showConfirmDialog(frame, "WARNING: Are you sure you want to delete the selected items from the model \nand all the diagrams they might appear? This action can still be undone.\n", "Delete from Menthor Editor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
		}else{
			response = Window.OK;
		}
		if(response==Window.OK)
		{		
			ArrayList<RefOntoUML.Element> deletionList = new ArrayList<RefOntoUML.Element>();
			deletionList.add(element);
			ArrayList<DiagramEditor> editors = getDiagramEditors(element);
			//from diagrams & model
			for(DiagramEditor diagramEditor: editors)
			{
				if(element instanceof GeneralizationSet){	
					diagramEditor.execute(new DeleteGeneralizationSetCommand(diagramEditor, element, getCurrentProject()));
				}else{
					diagramEditor.execute(new DeleteElementCommand(diagramEditor,deletionList, diagramEditor.getProject(),true,true));
				}
			}
			// only from model
			if(editors==null || editors.size()==0)
			{		
				if(element instanceof GeneralizationSet){	
					DeleteGeneralizationSetCommand cmd = new DeleteGeneralizationSetCommand(null, element,getCurrentProject());
					cmd.run();
				}else{
					DeleteElementCommand cmd = new DeleteElementCommand(null,deletionList, getCurrentProject(),true,false);
					cmd.run();	
				}				
			}
		}
	}

	public void editProperties(Object element)
	{
    	if (element instanceof StructureDiagram){
    		StructureDiagram diagram = (StructureDiagram)element;
    		if (!frame.getDiagramManager().isDiagramOpened(diagram)){
    			frame.getDiagramManager().createDiagramEditor(diagram);
    		}
    	}    	
    	else if (element instanceof OclDocument){
    		OclDocument oclDoc = (OclDocument)element;
    		if (!frame.getDiagramManager().isOclDocumentOpened(oclDoc)) {    		
    			frame.getDiagramManager().createConstraintEditor(oclDoc);
    		}
    	}    	
    	else if(element instanceof RefOntoUML.Element){
    		RefOntoUML.Element e = (RefOntoUML.Element)element;
    		ElementDialogCaller.openDialog(e, frame);
    	}
	}
	
	/** Delete elements from the model and every diagram in each they appear. It shows a message before deletion. */
	public void deleteFromMenthor(Collection<DiagramElement> diagramElementList, boolean showmessage)
	{
		int response =-1;	
		ArrayList<RefOntoUML.Element> deletionList = (ArrayList<RefOntoUML.Element>)ModelHelper.getElements(diagramElementList);			
		if(deletionList.size()>0){		
			if(showmessage) response = JOptionPane.showConfirmDialog(frame, "WARNING: Are you sure you want to delete the selected items from the model \nand all the diagrams they might appear? This action can still be undone.\n", "Delete from Menthor Editor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
			if(response==Window.OK)
			{							
				if(deletionList.size()>0){
					ArrayList<DiagramEditor> editors = getDiagramEditors(deletionList.get(0));
					//from diagrams & model
					for(DiagramEditor diagramEditor: editors)
					{
						DeleteElementCommand cmd = new DeleteElementCommand(diagramEditor,deletionList, diagramEditor.getProject(),true,true);
						cmd.run();
					}	
					// only from model
					if(editors.size()==0)
					{		
						DeleteElementCommand cmd = new DeleteElementCommand(null,deletionList, getCurrentProject(),true,false);
						cmd.run();
					}
				}else{
					System.err.println("There is a diagram element without a corresponding model instance. Wrong behaviour.");
				}
			}
		}
	}

	/** Create a generalization set from selected diagram elements */
	public GeneralizationSet addGeneralizationSet(DiagramEditor d, Collection<DiagramElement> diagramElementsList) 
	{		
		// retain only generalizations from selected
		ArrayList<Generalization> gens = new ArrayList<Generalization>();
		boolean genSetAlreadyExists = false;
		for(DiagramElement dElem: diagramElementsList){
			if (dElem instanceof GeneralizationElement){
				Generalization gen = ((GeneralizationElement)dElem).getGeneralization();
				if (gen.getGeneralizationSet()!=null && !gen.getGeneralizationSet().isEmpty()) genSetAlreadyExists=true;
				if(gen!=null) gens.add(gen);
			}
		}
		if(gens.size()<=1) return null; 
		if(genSetAlreadyExists){
			int response = JOptionPane.showConfirmDialog(getFrame(), "There is already a generalization set in the selected generalizations.\nAre you sure you want to continue?", "Adding Generalization Set", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			if(response!=JOptionPane.OK_OPTION) return null;
		}
		//create default gen set
		EObject eContainer = null;
		if(gens.size()>1) eContainer = gens.get(0).getSpecific().eContainer();	
		else eContainer = getCurrentProject().getModel();
		RefOntoUML.GeneralizationSet newgenset = (GeneralizationSet)elementFactory.createGeneralizationSet();
		((RefOntoUML.Package)eContainer).getPackagedElement().add(newgenset);
		// init data of generalization set
		((GeneralizationSet)newgenset).setIsCovering(true);
		((GeneralizationSet)newgenset).setIsDisjoint(true);
		((GeneralizationSet)newgenset).setName("gs");
		
		d.execute(new AddGeneralizationSetCommand(d, d.getDiagram(), newgenset, gens, getCurrentProject(), getCurrentProject().getModel()));
				
		return (GeneralizationSet)newgenset;
	}
	
	/** Delete a generalization set from a list of selected diagram elements */
	public void deleteGeneralizationSet(DiagramEditor d, Collection<DiagramElement> diagramElementsList) 
	{	
		// retain only generalization sets from selected
		ArrayList<RefOntoUMLElementCustom> genSets = new ArrayList<RefOntoUMLElementCustom>();		
		for(DiagramElement dElem: diagramElementsList){
			if (dElem instanceof GeneralizationElement){
				Generalization gen = ((GeneralizationElement)dElem).getGeneralization();
				if (gen.getGeneralizationSet()!=null && !gen.getGeneralizationSet().isEmpty()) {
					for(GeneralizationSet gs: gen.getGeneralizationSet()) {
						if (!contains(genSets,(RefOntoUML.Element)gs)) genSets.add(new RefOntoUMLElementCustom(gs,""));				
					}
				}
			}
		}
		if(genSets.size()==0) return;
		if(genSets.size()==1){			
			frame.getDiagramManager().deleteFromMenthor((RefOntoUML.Element)genSets.get(0).getElement(),true);
		}else{
			RefOntoUMLElementCustom chosen = (RefOntoUMLElementCustom) JOptionPane.showInputDialog(getFrame(), 
					"Which generalization set do you want to delete?",
					"Deleting Generalization Set",
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					genSets.toArray(), 
					genSets.toArray()[0]);
			if(chosen!=null){
				frame.getDiagramManager().deleteFromMenthor((RefOntoUML.Element)chosen.getElement(),true);
			}		
		}			
	}
	
	/** Delete element from all diagrams in the project. (not from the model) */
	public void deleteFromAllDiagrams(RefOntoUML.Element element)
	{	
		if(element instanceof GeneralizationSet) return;
		if(element instanceof Constraintx) return;
		if(element instanceof Comment) return;
		ArrayList<RefOntoUML.Element> deletionList = new ArrayList<RefOntoUML.Element>();
		deletionList.add(element);
		for(DiagramEditor diagramEditor: getDiagramEditors(element))
		{			
			DeleteElementCommand cmd = new DeleteElementCommand(diagramEditor,deletionList, diagramEditor.getProject(),false,true);
			cmd.run();
		}		
	}

	/** Delete element from a particular diagram (do not delete it from the model). */
	public void deleteFromDiagram(RefOntoUML.Element element, DiagramEditor diagramEditor)
	{		
		if(element instanceof GeneralizationSet) return;
		if(element instanceof Constraintx) return;
		if(element instanceof Comment) return;
		ArrayList<RefOntoUML.Element> deletionList = new ArrayList<RefOntoUML.Element>();
		deletionList.add(element);		
		DeleteElementCommand cmd = new DeleteElementCommand(diagramEditor,deletionList, getCurrentProject(),false,true);
		cmd.run();		
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
		verificator.run(currentProject.getModel());			
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
		if(currentProject!=null)
		{
			ArrayList<ProblemElement> problems = verifyProblems();
			ArrayList<ProblemElement> warnings = verifyWarnings();
			
			showBottomView();
			
			if(problems.size()>0) frame.selectProblems();
			if(warnings.size()>0) frame.selectWarnings();
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
	
	/** Change multiplicity and update the connections in diagram */
	public void changeMultiplicity(RefOntoUML.Property property, int lowerValue, int upperValue)
	{
		LiteralInteger lower = getElementFactory().getFactory().createLiteralInteger();
		lower.setValue(lowerValue);
		LiteralUnlimitedNatural upper =  getElementFactory().getFactory().createLiteralUnlimitedNatural();
		upper.setValue(upperValue);				
		property.setLowerValue(lower);			
		property.setUpperValue(upper);
		refreshDiagramElement(property.getAssociation());
		getFrame().getProjectBrowser().refresh();
	}
	
	/** Change multiplicity from string and update the connections in diagrams */
	public void changeMultiplicity(RefOntoUML.Property property, String multiplicity) throws ParseException
	{
		ModelHelper.setMultiplicityFromString(property, multiplicity);
		refreshDiagramElement(property.getAssociation());
		getFrame().getProjectBrowser().refresh();
	}
	
	/** Change a class stereotype */ 
	public void changeClassStereotype(ClassType type, RefOntoUML.Element element) 
	{ 
		changeClassStereotype((RefOntoUML.Type)element, type.getName());
	}
	
	/** Change a class stereotype */ 
	public void changeClassStereotype(Type type, String stereo) 
	{   
		ArrayList<DiagramElement> diagramElemList = ModelHelper.getDiagramElements(type);		
   		OutcomeFixer fixer = new OutcomeFixer(Models.getRefparser().getModel());
   		Fix fix = fixer.changeClassStereotypeTo(type, fixer.getClassStereotype(stereo));   	
   		for(DiagramElement diagramElem: diagramElemList){
	   		if (diagramElem !=null && diagramElem instanceof ClassElement) {
	   			double x = ((ClassElement)diagramElem).getAbsoluteX1();
	   			double y = ((ClassElement)diagramElem).getAbsoluteY1();   	   		
	   	   		fix.setAddedPosition(fix.getAdded().get(0),x,y);
	   		}
   		}
   		updateMenthor(fix);
	}
	
	/** Change relation stereotype */ 
	public void changeRelationStereotype(RelationshipType type, RefOntoUML.Relationship element) 
	{	
		changeRelationStereotype(element, type.getName());
	}
	
	/** Change relation stereotype */ 
	public void changeRelationStereotype(Relationship type, String stereo) 
	{	
   		OutcomeFixer fixer = new OutcomeFixer(Models.getRefparser().getModel());
   		Fix fix = fixer.changeRelationStereotypeTo(type, fixer.getRelationshipStereotype(stereo));   		
   		updateMenthor(fix);   		   		
   	}

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
	
	/** Re-make element in the diagram . 
	 *  This actually deletes the current diagramElement and creates another diagramElement, including it in the diagram.*/
	public void remakeDiagramElement(RefOntoUML.Element element, DiagramEditor d)
	{
		boolean isRectilinear = false;
		boolean showName = false;
		boolean showOntoUMLStereotype = false;
		boolean showMultiplicities = false;
		boolean showRoles = false;
		ReadingDesign direction = ReadingDesign.UNDEFINED;		
		if(element instanceof Association)
		{
			AssociationElement ae = (AssociationElement) ModelHelper.getDiagramElementByEditor(element, d);
			if(ae!=null)
			{
				isRectilinear = ae.isTreeStyle();			
				showName = ae.showName();
				showOntoUMLStereotype = ae.showOntoUmlStereotype();
				showRoles = false;//ae.showRoles();
				showMultiplicities = ae.showMultiplicities();				
				direction = ae.getReadingDesign();
			}
			deleteFromDiagram(element, d);
			moveAssociationToDiagram((Association) element, d, isRectilinear, showName, showOntoUMLStereotype, showMultiplicities, showRoles, direction);
		}			
		else if(element instanceof Generalization)
		{			
			GeneralizationElement ge = (GeneralizationElement) ModelHelper.getDiagramElementByEditor(element, d);
			if (ge!=null) isRectilinear = ge.isTreeStyle();			
			deleteFromDiagram(element, d);
			moveGeneralizationToDiagram((Generalization) element, d, isRectilinear);
		}		
	}

	/** Re-make all association in all diagrams they appear.
	 *  This actually deletes all the diagramElements and creates other diagramElements, including them in their specific diagrams.
	 */
	public void remakeAllAssociationElements()
	{
		Set<Association> assocList = Models.getRefparser().getAllInstances(Association.class);
		for(Association assoc: assocList){
			remakeDiagramElement(assoc);
		}
	}
	
	/** Re-make element in all diagrams it appears. 
	 *  This actually deletes all the diagramElements and creates other diagramElements, including them in their specific diagrams. */
	public void remakeDiagramElement(RefOntoUML.Element element)
	{
		for(DiagramEditor diagramEditor: getDiagramEditors(element))
		{
			remakeDiagramElement(element,diagramEditor);
		}
		// if the element is not in any diagram, redesign it in the diagrams of its types.
		if(getDiagramEditors(element).size()==0)
		{
			if (element instanceof RefOntoUML.Association)
			{
				Type source = ((Association)element).getMemberEnd().get(0).getType();
				Type target = ((Association)element).getMemberEnd().get(1).getType();				
				for(DiagramEditor diagramEditor: getDiagramEditors(source))
				{
					if (getDiagramEditors(target).contains(diagramEditor))
					{						
						remakeDiagramElement(element, diagramEditor);
					}
				}				
			}
			if (element instanceof RefOntoUML.Generalization){
				Type general = ((Generalization)element).getGeneral();
				Type specific = ((Generalization)element).getSpecific();
				for(DiagramEditor diagramEditor: getDiagramEditors(general))
				{
					if (getDiagramEditors(specific).contains(diagramEditor))
					{
						remakeDiagramElement(element, diagramEditor);
					}
				}	
			}			
		}
	}

	/** Refresh element in all diagrams it appears. Just "redraw" the diagramElements. 
	 *  If the element is an association and the end-points are changed, call the remakeDiagramElement() method instead. */
	public void refreshDiagramElement(RefOntoUML.Element element)
	{
		for(DiagramEditor diagramEditor: getDiagramEditors(element))
		{
			refreshDiagramElement(element,diagramEditor);
		}
	}

	/** Refresh a diagram element. Just "redraw" it. 
	 *  If the element is an association and the end-points are changed, call the remakeDiagramElement() method instead. */
	public void refreshDiagramElement (RefOntoUML.Element element, DiagramEditor d)
	{		
		if (d!=null && !d.getDiagram().containsChild(element)) return;
		if (d!=null) 
		{
			ArrayList<DiagramElement> diagramElemList = ModelHelper.getDiagramElements(element);
			for(DiagramElement diagramElem: diagramElemList)
			{
				if(diagramElem!=null)
				{				
					ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
					list.add(diagramElem);
					d.notifyChange(list, ChangeType.ELEMENTS_MODIFIED, NotificationType.DO);
				}			
			}
		}		
	}
		
	/** Move generalization to a diagram. It creates a diagram element for that refonto instance adding it to the application map. */
	public void moveGeneralizationToDiagram(Generalization gen, DiagramEditor d, boolean isRectilinear)
	{		
		if (d.getDiagram().containsChild(gen.getGeneral()) && d.getDiagram().containsChild(gen.getSpecific()))
		{	
			UmlConnection conn = d.dragRelation(gen,gen.eContainer());			
			if (gen.getGeneralizationSet().size()>0) 
			{
				Classifier general = gen.getGeneral();
				Classifier specific = gen.getSpecific();
				ClassElement generalElem = (ClassElement)ModelHelper.getDiagramElementByEditor(general, d);
				ClassElement specificElem = (ClassElement)ModelHelper.getDiagramElementByEditor(specific, d);
				if (generalElem.getAbsoluteY1() < specificElem.getAbsoluteY1()) d.setLineStyle(conn, LineStyle.TREESTYLE_VERTICAL);
				else if (generalElem.getAbsoluteY1() > specificElem.getAbsoluteY1()) d.setLineStyle(conn, LineStyle.TREESTYLE_VERTICAL);
				else d.setLineStyle(conn, LineStyle.TREESTYLE_HORIZONTAL);
			}
			else if (isRectilinear) d.setLineStyle(conn,  LineStyle.RECTILINEAR);
			else d.setLineStyle(conn,  LineStyle.DIRECT);
			((GeneralizationElement)conn).setShowName(false);
		}
	}
	
	/** Move generalizations of an element to the diagram. 
	 *  It will only move the generalizations in which the general and specific classifiers are contained in the diagram.
	 */
	public void moveGeneralizationsToDiagram(RefOntoUML.Element element, EObject eContainer, DiagramEditor d)
	{
		OntoUMLParser refparser = Models.getRefparser();
		for(RefOntoUML.Generalization gen: refparser.getGeneralizations((RefOntoUML.Classifier)element))
		{
			if(!d.getDiagram().containsChild(gen)) moveGeneralizationToDiagram(gen, d, false);
		}
	}
	
	/**
	 *  Move associations of an element to the diagram. 
	 *  It will only move the association whose other end appears in the diagram
	 */
	public void moveAssociationsToDiagram(RefOntoUML.Element element, EObject eContainer, DiagramEditor d)
	{
		OntoUMLParser refparser = Models.getRefparser();
		
		for(RefOntoUML.Association a: refparser.getDirectAssociations((RefOntoUML.Classifier)element))
		{
			//bring derivation
			if(a instanceof MaterialAssociation)
			{						
				Derivation deriv = refparser.getDerivation((MaterialAssociation)a);
				if(deriv!=null) moveAssociationToDiagram(deriv, d, false, false, false, true, false, ReadingDesign.UNDEFINED);
			}			
			if(!d.getDiagram().containsChild(a)) moveAssociationToDiagram(a, d, false, true, true, true, false, ReadingDesign.UNDEFINED);		
		}
	}
	
	/** Move association to a diagram. It creates a diagram element for that refonto instance adding it to the application map. */
	public void moveAssociationToDiagram(Association association, DiagramEditor d, boolean isRectilinear, boolean showName, boolean showOntoUMLStereotype, boolean showMultiplicities, boolean showRoles, ReadingDesign direction)
	{		
		Type src = ((Association)association).getMemberEnd().get(0).getType();
		Type tgt = ((Association)association).getMemberEnd().get(1).getType();				
		if (d.getDiagram().containsChild(src) && d.getDiagram().containsChild(tgt))	
		{			
			AssociationElement conn = (AssociationElement) d.dragRelation(association,association.eContainer());
			if(isRectilinear) d.setLineStyle(conn, LineStyle.RECTILINEAR);
			else d.setLineStyle(conn, LineStyle.DIRECT);
			conn.setShowMultiplicities(showMultiplicities);
			conn.setShowName(showName);
			conn.setShowOntoUmlStereotype(showOntoUMLStereotype);
			conn.setShowRoles(showRoles);
			conn.setReadingDesign(direction);
			
			//bring derivation
			if(association instanceof MaterialAssociation){				
				OntoUMLParser refparser = Models.getRefparser();
				Derivation deriv = refparser.getDerivation((MaterialAssociation)association);
				if(deriv!=null) moveAssociationToDiagram(deriv, d, false, false, false, true, false, direction);
			}
		}
	}
	
	/** Move class to a diagram. It creates a diagram element for that refonto instance adding it to the application map. 
	 *  It also add related generalizations and associations */
	public void moveClassToDiagram(RefOntoUML.Element element, double x, double y, DiagramEditor d)
	{
		AddNodeCommand cmd = new AddNodeCommand(d,d.getDiagram(),element,x,y,getCurrentProject(),(RefOntoUML.Element)element.eContainer());		
		cmd.run();	
		 
		moveGeneralizationsToDiagram(element, element.eContainer(), d);
		   
		moveAssociationsToDiagram(element, element.eContainer(),d);
	}
		
	/** Move element to a Diagram */
	public void moveToDiagram(RefOntoUML.Element element, double x, double y, DiagramEditor d, boolean showmessage)
	{
		if (d!=null && d.getDiagram().containsChild(element) && showmessage)
		{
			if (element instanceof NamedElement) frame.showInformationMessageDialog("Moving to Diagram...", "\""+ModelHelper.getStereotype(element)+" "+((NamedElement)element).getName()+"\" already exists in diagram \""+d.getDiagram().getName()+"\"");			
			else if (element instanceof Generalization) frame.showInformationMessageDialog("Moving to Diagram...", "\"Generalization "+((Generalization)element).getSpecific().getName()+"->"+((Generalization)element).getSpecific().getName()+"\" already exists in diagram \""+d.getDiagram().getName()+"\"");
			DiagramElement de = ModelHelper.getDiagramElementByEditor(element, d);
			if(de!=null) d.select(de);
			return;			
		}
		if((element instanceof RefOntoUML.Class) || (element instanceof RefOntoUML.DataType)){			
			moveClassToDiagram(element, x, y, d);	
			//d.setDragElementMode(oClass,oClass.eContainer());
		}
		if((element instanceof RefOntoUML.Generalization)){			
			moveGeneralizationToDiagram((RefOntoUML.Generalization)element, d, false);
		}
		if((element instanceof RefOntoUML.Association)){			
			moveAssociationToDiagram((RefOntoUML.Association)element, d, false , true, true, true, false, ReadingDesign.UNDEFINED);
		}
	}
	
	public void moveToDiagram(Object element)
	{
		moveToDiagram((RefOntoUML.Element)element,getCurrentDiagramEditor(),true);
	}
	
	/** Move element to a Diagram */
	public void moveToDiagram(RefOntoUML.Element element, DiagramEditor d, boolean showmessage)
	{
		if (d!=null && d.getDiagram().containsChild(element) && showmessage)
		{
			if (element instanceof NamedElement) frame.showInformationMessageDialog("Moving to Diagram...", "\""+ModelHelper.getStereotype(element)+" "+((NamedElement)element).getName()+"\" already exists in diagram \""+d.getDiagram().getName()+"\"");			
			else if (element instanceof Generalization) frame.showInformationMessageDialog("Moving to Diagram...", "\"Generalization "+((Generalization)element).getSpecific().getName()+"->"+((Generalization)element).getSpecific().getName()+"\" already exists in diagram \""+d.getDiagram().getName()+"\"");
			DiagramElement de = ModelHelper.getDiagramElementByEditor(element, d);
			if(de!=null) d.select(de);
			return;			
		}
		if((element instanceof RefOntoUML.Class) || (element instanceof RefOntoUML.DataType)){				
			d.setDragElementMode((RefOntoUML.Type)element,element.eContainer());
			//moveClassToDiagram(element, x, y, d);	
		}
		if((element instanceof RefOntoUML.Generalization)){			
			moveGeneralizationToDiagram((RefOntoUML.Generalization)element, d, false);
		}
		if((element instanceof RefOntoUML.Association)){			
			moveAssociationToDiagram((RefOntoUML.Association)element, d, false , true, true, true, false, ReadingDesign.UNDEFINED);
		}
	}
	
	
	/** Mode tree selected element to a Diagram */
	public void moveSelectedToDiagram(DiagramEditor editor, Point location) 
	{
		DefaultMutableTreeNode node = frame.getProjectBrowser().getTree().getSelectedNode();
		Object obj = node.getUserObject();				
		moveToDiagram((RefOntoUML.Element)obj, location.x, location.y, editor, true);			
	}
	
	/** Invert end points of an association. This method switch the current properties of an association. 
	 *  The source becomes the target and vice-versa. */
	public void invertEndPoints(RefOntoUML.Association association)
	{
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		association.getMemberEnd().clear();	
   		association.getOwnedEnd().clear();
   		association.getNavigableOwnedEnd().clear();
   		association.getMemberEnd().add(target);
   		association.getMemberEnd().add(source);   	
   		association.getOwnedEnd().add(target);
   		association.getOwnedEnd().add(source);
   		association.getNavigableOwnedEnd().add(target);
   		association.getNavigableOwnedEnd().add(source);
   		ProjectTree tree = frame.getProjectBrowser().getTree();
   		tree.checkElement(source);
   		tree.removeCurrentNode();   		
   		tree.checkElement(association);
   		tree.addElement(source);  
   		tree.updateUI();
   		frame.getDiagramManager().updateMenthorFromModification(association, true);
	}
	
	/** Invert names of end points of an association. This method switch the current end names of an association. 
	 *  The source end name becomes the target end name and vice-versa. */
	public void invertEndNames(RefOntoUML.Association association)
	{
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		String sourceName = source.getName();
   		String targetName = target.getName();
   		source.setName(targetName);
   		target.setName(sourceName);
   		frame.getDiagramManager().updateMenthorFromModification(association, false);
	}
	
	/** Invert multiplicities of end points of an association. This method switch the current multiplicities of an association. 
	 *  The source end multiplicity becomes the target end multiplicity and vice-versa. */
	public void invertEndMultiplicities(RefOntoUML.Association association)
	{
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		LiteralInteger sourceLower = getElementFactory().getFactory().createLiteralInteger();
   		LiteralUnlimitedNatural sourceUpper = getElementFactory().getFactory().createLiteralUnlimitedNatural();
   		sourceLower.setValue(target.getLower());
   		sourceUpper.setValue(target.getUpper());   		
   		LiteralInteger targetLower = getElementFactory().getFactory().createLiteralInteger();
   		LiteralUnlimitedNatural targetUpper = getElementFactory().getFactory().createLiteralUnlimitedNatural();
   		targetUpper.setValue(source.getUpper());
   		targetLower.setValue(source.getLower());  	
   		source.setUpperValue(sourceUpper);
   		source.setLowerValue(sourceLower);
   		target.setUpperValue(targetUpper);
   		target.setLowerValue(targetLower);
   		frame.getDiagramManager().updateMenthorFromModification(association, false);
	}
	
	/** Invert types of end points of an association. This method switch the current types of an association. 
	 *  The source end type becomes the target end type and vice-versa. */
	public void invertEndTypes(RefOntoUML.Association association)
	{
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		Type sourceType = source.getType();
   		Type targetType = target.getType();
   		source.setType(targetType);
   		target.setType(sourceType);
   		frame.getDiagramManager().updateMenthorFromModification(association, true);
	}
		
	/** 
	 * Update the application accordingly to the refontouml instance created. This instance must be already be inserted in its container.
	 *  
	 * @param element: added element on refontouml root instance.
	 */
	public void updateMenthorFromInclusion(final RefOntoUML.Element addedElement)
	{		
		// add to the parser
		Models.getRefparser().addElement(addedElement);	
		
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				UmlProject project = ProjectBrowser.frame.getDiagramManager().getCurrentProject();
				// add to the tree
				ProjectTree tree = frame.getProjectBrowser().getTree();
				boolean found = tree.checkElement((EObject)addedElement);
				if(!found) {
					if(addedElement.eContainer()!=null) tree.checkElement(addedElement.eContainer());
					else if(addedElement instanceof EnumerationLiteral) tree.checkElement(((EnumerationLiteral)addedElement).getEnumeration());
					else tree.checkElement(project.getModel());					
					tree.addElement(addedElement);					
				} else {
					if(addedElement instanceof Generalization){
						tree.checkElement(addedElement);
						tree.removeCurrentNode();
						tree.checkElement(addedElement.eContainer());
						tree.addElement(addedElement);
					}
				}
				tree.updateUI();						
			}
		});		
	}
		
	/**
	 * Update the application accordingly to the list of refontouml elements added into the root model instance.
	 *  
	 * @param fix
	 */
	public void updateMenthorFromInclusion(Fix fix)
	{
		//classes and datatypes
		for(Object obj: fix.getAdded()){			
			if (obj instanceof RefOntoUML.Class||obj instanceof RefOntoUML.DataType) {	
				if (fix.getAddedPosition(obj).x!=-1 && fix.getAddedPosition(obj).y!=-1) 
				{						
					AddNodeCommand cmd = new AddNodeCommand((DiagramNotification)getCurrentDiagramEditor(),getCurrentDiagramEditor().getDiagram(),(RefOntoUML.Element)obj,
					fix.getAddedPosition(obj).x,fix.getAddedPosition(obj).y, getCurrentProject(),(RefOntoUML.Element)((EObject)obj).eContainer());		
					cmd.run();
				}
				else {
					AddNodeCommand cmd = new AddNodeCommand(null,null,(RefOntoUML.Element)obj,0,0,getCurrentProject(),(RefOntoUML.Element)((EObject)obj).eContainer());		
					cmd.run();									
				}
			}			
		}
		//relationships and attributes
		for(Object obj: fix.getAdded()) {
			if (obj instanceof RefOntoUML.Relationship && !(obj instanceof RefOntoUML.Derivation)) {
				updateMenthorFromInclusion((RefOntoUML.Element)obj);
				moveToDiagram((RefOntoUML.Element)obj, getCurrentDiagramEditor(),false);
			}
			if(obj instanceof RefOntoUML.Property){		
				updateMenthorFromInclusion((RefOntoUML.Element)obj);
			}
		}	
		//derivations
		for(Object obj: fix.getAdded()) {
			if (obj instanceof RefOntoUML.Derivation) {
				updateMenthorFromInclusion((RefOntoUML.Element)obj);
				moveToDiagram((RefOntoUML.Element)obj, getCurrentDiagramEditor(),false);
			}
		}	
		//generalization sets
		for(Object obj: fix.getAdded()) {
			if (obj instanceof RefOntoUML.GeneralizationSet) 
			{
				AddGeneralizationSetCommand cmd = new AddGeneralizationSetCommand((DiagramNotification)getCurrentDiagramEditor(),getCurrentDiagramEditor().getDiagram(),(RefOntoUML.Element)obj,
				((GeneralizationSet)obj).getGeneralization(),getCurrentProject(),(RefOntoUML.Element)((EObject)obj).eContainer());
				cmd.run(); 
			}
		}
	}	
		
	/**
	 * Update the application accordingly to the refontouml instance that were modified.
	 * 
	 * @param element: modified element on the refontouml root instance
	 */
	public void updateMenthorFromModification(final RefOntoUML.Element element, final boolean redesign)
	{
		updateMenthorFromInclusion(element);
		
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				// update the diagrams
				if (element instanceof RefOntoUML.Class || element instanceof RefOntoUML.DataType)
				{
					refreshDiagramElement((Classifier)element);			
				}
				if (element instanceof RefOntoUML.Association)
				{
					if (redesign) remakeDiagramElement((RefOntoUML.Element)element);
					else refreshDiagramElement((RefOntoUML.Element)element);
				}
				if (element instanceof RefOntoUML.Property)
				{
					Association assoc= ((RefOntoUML.Property)element).getAssociation();								
					if (assoc!=null){
						if(redesign) remakeDiagramElement((RefOntoUML.Element)assoc);
						else refreshDiagramElement((RefOntoUML.Element)assoc);
					}else{
						refreshDiagramElement((RefOntoUML.Element)(element).eContainer());
					}
				}		
				if (element instanceof RefOntoUML.Generalization)
				{
					if (redesign) remakeDiagramElement((RefOntoUML.Element)element); 
					else refreshDiagramElement((RefOntoUML.Element)element);
				}
				if(element instanceof RefOntoUML.GeneralizationSet)
				{
					for(Generalization gen: ((RefOntoUML.GeneralizationSet) element).getGeneralization()) updateMenthorFromModification(gen,false);
				}
			}
		});
	}
	
	/**
	 * Update the application accordingly to the list of refontouml elements modified into the root model instance.  
	 * 
	 * @param fix
	 */
	public void updateMenthorFromModification(Fix fix)
	{
		for(Object obj: fix.getModified())
		{
			boolean redesign=false;
						
			if (obj instanceof RefOntoUML.Property) {												
				if (((RefOntoUML.Property)obj).getAssociation()!=null) redesign=true;	else redesign=false;		
			}							
			else if (obj instanceof RefOntoUML.Association) {
				redesign=true;
			}
			else if (obj instanceof Generalization) {
				redesign=true;
			}
			else {
				redesign=false;
			}
			updateMenthorFromModification((RefOntoUML.Element)obj,redesign);
		}
	}
	
	/**
	 * Update the application accordingly to the refontouml instance that were deleted from the root refontouml instance
	 * 
	 * @param element: deleted element on the refontouml root instance
	 */
	@SuppressWarnings("unused")
	public void updateMenthorFromDeletion(final RefOntoUML.Element deletedElement)
	{		
		// delete from the parser
		Models.getRefparser().removeElement(deletedElement);
		
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				UmlProject project = frame.getDiagramManager().getCurrentProject();
											
				// delete from the tree
				ProjectBrowser browser = frame.getProjectBrowser();		
				browser.getTree().remove(deletedElement);
			}
		});
	}
	
	/** Update Menthor according to a Fix.  */
	public void updateMenthor (final Fix fix)
	{
		if (fix==null) return;	
		
		updateMenthorFromInclusion(fix);
				
		updateMenthorFromModification(fix);
		
		for(Object obj: fix.getDeleted()) {
			deleteFromMenthor((RefOntoUML.Element)obj,false);				
		}
		for(String str: fix.getAddedRules()){
			Models.getOclDocList().get(0).addContentAsString(str);		
		}
		return ;
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
		workingOnlyWithChecked();		
		openAlloySettings();
	}

	public void implementInOwl() 
	{	
		workingOnlyWithChecked();
		openOwlSettings();
	}
	
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
			String name = ((RefOntoUML.Package)getCurrentProject().getResource().getContents().get(0)).getName();
			if (name==null || name.isEmpty()) name = "model";
			TOCLParser toclparser = new TOCLParser(refparser,getCurrentProject().getTempDir()+File.separator,name.toLowerCase());
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
		TextEditor textViz = (TextEditor) getEditorForProject(getCurrentProject(), EditorType.TEXT_EDITOR);
		if(textViz == null){
			textViz = new TextEditor(getCurrentProject());
			addClosable(this,"Text Editor", textViz);
		}else{
			setSelectedComponent(textViz);
		}
		textViz.setText(content);
	}
	
	/** Run Transformation to Alloy */
	public void transformToAlloy(OntoUMLParser refparser, TransformationOption to)  
	{			
		try{
			if(to.getDestination()==DestinationEnum.FILE){
				if(to.getPath()!=null) Models.getAlloySpec().setAlloyPath(to.getPath());
			}
			runOntoUML2Alloy(refparser);		
			runTOCL2Alloy(refparser);			
			if(to.getDestination()==DestinationEnum.APP) {
				openAnalyzer(Models.getAlloySpec(),true, -1);			
			}
			if(to.getDestination()==DestinationEnum.TAB){				
				showInTextEditor(Models.getAlloySpec().getContent());
			}
			if(to.getDestination()==DestinationEnum.FILE){
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
	
	/** Open the OWL settings window	 */
	public void openOwlSettings() 
	{
		OwlSettingsDialog dialog = new OwlSettingsDialog(frame, 
			Models.getRefparser(),
			frame.getProjectBrowser().getAllDiagrams(),
			true
		);
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
	}	
	
	public void generateInfoUML(RefOntoUML.Package model) 
	{
		OntoUML2InfoUML.transformation(model, getCurrentProject().getTempDir()+File.separator+model.getName()+".uml");
	}	
	
	/**  Generate SBVR. In order to use the plug-in, we need to store the model into a file before. */
	public void generateSbvr(RefOntoUML.Model refpackage) 
	{
		ResultType result;
		String modelFileName = Util.getCanonPath(Directories.getTempDir(), Settings.DEFAULT_MODEL_FILE.getValue());
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
	public static String getResourceString(String property) 
	{
		return ApplicationResources.getInstance().getString(property);
	}

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

	/**
	 * Gets all DiagramEditors that contains a given element. 
	 * Some of them might appear opened in the Tab but others don't.
	 */
	public ArrayList<DiagramEditor> getDiagramEditors(RefOntoUML.Element element)
	{
		ArrayList<DiagramEditor> list = new ArrayList<DiagramEditor>();
		for(OntoumlDiagram d: currentProject.getDiagrams())
		{
			if(d instanceof StructureDiagram)
			{
				StructureDiagram diagram = (StructureDiagram)d;
				ArrayList<DiagramElement> elemList=new ArrayList<DiagramElement>();
				if(element instanceof Property){
					elemList = ModelHelper.getDiagramElements((RefOntoUML.Element)element.eContainer());
				}else if(element instanceof EnumerationLiteral){
					elemList = ModelHelper.getDiagramElements(((RefOntoUML.EnumerationLiteral)element).getEnumeration());
				}else if (element instanceof GeneralizationSet){
					for(Generalization gen: ((RefOntoUML.GeneralizationSet)element).getGeneralization()){
						elemList = ModelHelper.getDiagramElements(gen);
					}
				}else{
					elemList = ModelHelper.getDiagramElements(element);
				}
				for(DiagramElement elem: elemList){
					if (diagram.containsChild(elem)) {
						DiagramEditor editor = getDiagramEditor(diagram);						
						editor.addEditorStateListener(this);
						editor.addSelectionListener(this);
						editor.addAppCommandListener(listener);						
						list.add(editor);
					}	
				}				
			}
		}
		return list;
	}
	
	/**
	 * Gets all Diagrams that contains a given element. 
	 * Some of them might appear opened in the Tab but others don't.
	 */
	public List<OntoumlDiagram> getDiagrams(RefOntoUML.Element element)
	{
		ArrayList<OntoumlDiagram> list = new ArrayList<OntoumlDiagram>();
		for(OntoumlDiagram d: currentProject.getDiagrams())
		{
			if(d instanceof StructureDiagram)
			{
				StructureDiagram diagram = (StructureDiagram)d;
				ArrayList<DiagramElement> elemList=new ArrayList<DiagramElement>();
				if(element instanceof Property){
					elemList = ModelHelper.getDiagramElements((RefOntoUML.Element)element.eContainer());
				}else if(element instanceof EnumerationLiteral){
					elemList = ModelHelper.getDiagramElements(((RefOntoUML.EnumerationLiteral)element).getEnumeration());
				}else if (element instanceof GeneralizationSet){
					for(Generalization gen: ((RefOntoUML.GeneralizationSet)element).getGeneralization()){
						elemList = ModelHelper.getDiagramElements(gen);
					}
				}else{
					elemList = ModelHelper.getDiagramElements(element);
				}
				for(DiagramElement elem: elemList){
					if (diagram.containsChild(elem)) {											
						list.add(diagram);
					}	
				}				
			}
		}
		return list;
	}
	
	/** Generates OWL from the selected model */
	public void generateOwl(OntoUMLParser filteredParser, TransformationOption trOpt) 
	{
		RefOntoUML.Package model = filteredParser.createModelFromSelections(new Copier());
		ResultType result = OWLHelper.generateOwl(
			filteredParser, 
			model, 
			getWorkingConstraints(),			
			trOpt
		);
		if(result.getResultType() != Result.ERROR)
		{
			if(trOpt.getDestination()==DestinationEnum.TAB)
			{
				frame.getInfoManager().showOutputText(result.toString(), true, false);
				showInTextEditor((String)result.getData()[0]);
			}else{
				frame.getInfoManager().showOutputText(result.toString(), true, true);
			}
			frame.showSuccessfulMessageDialog("Success", "Project successfully transformed to OWL.");
		}else{
			frame.getInfoManager().showOutputText(result.toString(), true, true); 
			frame.showSuccessfulMessageDialog("Failed", "Project unsuccessfully transformed to OWL.");
		}
	}
	
	private Editor getEditorForProject(UmlProject project, EditorType nature)
	{
		int totalTabs = getTabCount();
		for(int i = 0; i < totalTabs; i++)
		{
			Editor editor = (Editor)getComponentAt(i);
			if(editor.getEditorType() == nature && getCurrentProject() == project)
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
		UmlProject project = getCurrentProject();
		ExclusionDerivationOperations.createExclusionDerivation(activeEditor, project, this, activeEditor.getSelectedElements(), new OutcomeFixer(this.getCurrentProject().getModel()));
		
	}
	
	@SuppressWarnings({ })
	public void deriveByUnion() 
	{
		DiagramEditor activeEditor = getCurrentDiagramEditor();
		UmlProject project = getCurrentProject();
		Fix fix = DerivedTypesOperations.createUnionDerivation(activeEditor, project,this);
		if(fix!=null) updateMenthor(fix);		
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
		UmlProject project = getCurrentProject();
		Fix fix = DerivedTypesOperations.createIntersectionDerivation(activeEditor, project,this);
		if(fix!=null)
			updateMenthor(fix);
		
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
		UmlProject project = getCurrentProject();
		Fix fix = DerivedTypesOperations.createSpecializationDerivation(activeEditor, project,this);
		if(fix!=null) updateMenthor(fix);
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
		UmlProject project = getCurrentProject();
		DerivedTypesOperations.createPastSpecializationDerivation(activeEditor, project,this);
	}
	public void deriveByParticipation() {
		DiagramEditor activeEditor = getCurrentDiagramEditor();
		UmlProject project = getCurrentProject();
		ParticipationDerivationOperations participation_derivation = new ParticipationDerivationOperations();
		participation_derivation.createDerivedType(activeEditor, project,this);
	}
	
	/** Save current Pattern Project to a file *.menthorpattern */
	@SuppressWarnings("unused")
	private File exportCurrentProjectToFile(File file) 
	{
		System.out.println("Saving Menthor Pattern project...");
		currentProject.setVersion(Main.MENTHOR_VERSION);
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
			currentProject.clearOpenedDiagrams();
			for(DiagramEditor editor: getDiagramEditors()){
				currentProject.saveAsOpened(editor.getDiagram());
			}			
			result = ProjectWriter.getInstance().writeProject(this, file, currentProject, Models.getOclDocList());		
			Settings.addRecentProject(file.getCanonicalPath());
			getCurrentProject().setName(file.getName().replace(".menthorpattern",""));
			getFrame().getProjectBrowser().refresh();
			saveAllDiagramNeeded(false);
			frame.setTitle(file.getName().replace(".menthor","")+" - Menthor Editor");
			invalidate();
			getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		} catch (Exception ex) {
			System.out.println("Failed to save Menthor Pattern project!");
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, ex.getMessage(), getResourceString("error.savefile.title"), JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Menthor Pattern project successfully saved!");
		return result;
	}

	//Export as .menthorpattern	
	public void exportAsPattern(){
		DomainPatternTool.exportModelAsPattern(currentProject);
		//call exportCurrentProject
		//call exportAsMenthorPattern
	}
	
	private UmlProject importPatternProjectFile(){
		UmlProject patternProject = null;
		
		JFileChooser fileChooser = new JFileChooser(lastOpenPath);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Menthor Project (*.menthor)", "menthor");
		fileChooser.setDialogTitle("Open Menthor Pattern Project");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setFileFilter(filter);		
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
				JOptionPane.showMessageDialog(this, ex.getMessage(), getResourceString("error.readfile.title"), JOptionPane.ERROR_MESSAGE);
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