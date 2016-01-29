package net.menthor.editor.v2.managers;

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

import java.awt.Component;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import org.eclipse.emf.edit.provider.IDisposable;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.umldraw.StructureDiagram;

import net.menthor.editor.ui.DiagramWrapper;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.StatisticsPane;
import net.menthor.editor.ui.UmlProject;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.editors.ConsoleEditor;
import net.menthor.editor.v2.editors.Editor;
import net.menthor.editor.v2.editors.ErrorEditor;
import net.menthor.editor.v2.editors.FindEditor;
import net.menthor.editor.v2.editors.OclEditor;
import net.menthor.editor.v2.editors.ProblemEditor;
import net.menthor.editor.v2.editors.TxtEditor;
import net.menthor.editor.v2.editors.WarningEditor;
import net.menthor.editor.v2.elements.ProblemElement;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.start.StartPage;
import net.menthor.editor.v2.types.EditorType;
import net.menthor.editor.v2.ui.ClosableTab;

public class TabManager extends BaseManager {

	// -------- Lazy Initialization

	private static class TabLoader {
        private static final TabManager INSTANCE = new TabManager();
    }	
	public static TabManager get() { 
		return TabLoader.INSTANCE; 
	}	
    private TabManager() {
        if (TabLoader.INSTANCE != null) throw new IllegalStateException("TabManager already instantiated");
    }		
    
    // ----------------------------
	
	/** add diagrams recorded as open in the project */
	public void initialize(UmlProject project){		
		if(project.isAllClosed() && project.getDiagrams().size()>0){				
			TabManager.get().addDiagramEditor((StructureDiagram)project.getDiagrams().get(0));
		}else{
			for(OntoumlDiagram diagram: project.getDiagrams()) {
				if(project.isOpened(diagram)){						
					TabManager.get().addDiagramEditor((StructureDiagram)diagram);
				}
			}
		}		
	}
	
	/** clear the editor tabbed pane */
	public void backToInitialState(){
		editorTabbedPane().removeAll();
		TabManager.get().addStartEditor(false);
		frame().setTitle("Menthor Editor");
		frame().showOnlyStartPage();
		frame().getMainMenu().disactivateSomeToBegin();			
		editorTabbedPane().repaint();
		editorTabbedPane().revalidate();
	}	
	
	// ----- getters ----
	
	public StartPage getStartEditor(){
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof StartPage) return(StartPage)c;			
		}	
		return null;
	}
	
	public Editor getCurrentEditor(){
		if(editorTabbedPane().getSelectedIndex() != -1){
			Object obj = editorTabbedPane().getSelectedComponent();
			if(obj instanceof Editor) return (Editor) obj;	
		}
		return null;
	}
	
	
	public Editor getEditor(EditorType nature){
		int totalTabs = editorTabbedPane().getTabCount();
		for(int i = 0; i < totalTabs; i++){
			Editor editor = (Editor)editorTabbedPane().getComponentAt(i);
			if(editor.getEditorType() == nature){
				return editor;
			}
		}
		return null;
	}
	
	public DiagramEditor getCurrentDiagramEditor(){		
		if(editorTabbedPane().getSelectedComponent() instanceof DiagramWrapper){			
			return ((DiagramWrapper) editorTabbedPane().getSelectedComponent()).getDiagramEditor();
		}
		return null;
	}
	
	public OclEditor getCurrentOclEditor(){
		if(editorTabbedPane().getSelectedComponent() instanceof OclEditor) {
			return ((OclEditor)editorTabbedPane().getSelectedComponent());
		}
		return null;
	}
	
	public DiagramEditor getDiagramEditor(StructureDiagram diagram){		
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof DiagramWrapper) {
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return ((DiagramWrapper)c).getDiagramEditor();
			}
		}
		DiagramEditor editor = new DiagramEditor(frame(),editorTabbedPane(),diagram);
		editor.addAppCommandListener(listener());
		return editor;
	}
	
	public OclEditor getOclEditor(OclDocument oclDoc){		
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof OclEditor) {
				if (((OclEditor)c).getOclDocument().equals(oclDoc))
					return (OclEditor)c;
			}
		}
		return null;
	}
	
	public List<DiagramEditor> getDiagramEditors(){
		List<DiagramEditor> list = new ArrayList<DiagramEditor>();
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof DiagramWrapper) list.add(((DiagramWrapper)c).getDiagramEditor());
		}
		return list;
	}
	
	public List<OclEditor> getOclEditors(){
		List<OclEditor> list = new ArrayList<OclEditor>();
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof OclEditor) list.add((OclEditor)c);
		}
		return list;
	}
	
	public ArrayList<StructureDiagram> getDiagrams(){
		ArrayList<StructureDiagram> list = new ArrayList<StructureDiagram>();
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof DiagramWrapper) list.add(((DiagramWrapper)c).getDiagramEditor().getDiagram());
		}
		return list;
	}
	
	public String getConstraints(){
		String result = new String();
		for(OclDocument oclmodel: Models.getOclDocList()){				
			OclEditor ce = TabManager.get().getOclEditor(oclmodel);
			if(ce!=null) result+=ce.getText();
			else result+=oclmodel.getContentAsString();
		}
		return result;
	}
		
	//----- index -----
	
	public int getEditorIndex(Editor editor){
		if(editor instanceof DiagramEditor) return editorTabbedPane().indexOfComponent(((DiagramEditor)editor).getWrapper());
		else return editorTabbedPane().indexOfComponent((Component)editor);
	}
	
	public int getEditorIndex(StructureDiagram diagram){		
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof DiagramWrapper) {
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return editorTabbedPane().indexOfComponent(c);
			}
		}
		return -1;
	}
	
	public int getEditorIndex(OclDocument oclDoc){
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof OclEditor) {
				if (((OclEditor)c).getOclDocument().equals(oclDoc))
					return editorTabbedPane().indexOfComponent(c);
			}
		}
		return -1;		
	}
	
	//----- select -----
	
	public boolean selectEditor(Object obj){
		for(Component c: editorTabbedPane().getComponents()){
			if(c.equals(obj)) {
				editorTabbedPane().setSelectedComponent(c);
				return true;
			}
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().getDiagram().equals(obj)) {
					editorTabbedPane().setSelectedComponent(c);
					return true;
				}
			}			
			if(c instanceof OclEditor) {
				if(((OclEditor) c).getOclDocument().equals(obj)) {
					editorTabbedPane().setSelectedComponent(c);	
					return true;
				}
			}
		}	
		return false;
	}
	
	public void selectEditor(StructureDiagram diagram){		
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().getDiagram().equals(diagram)) editorTabbedPane().setSelectedComponent(c);
			}
		}		
	}
	
	public void selectEditor(OclDocument oclDoc){		
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof OclEditor) {
				if(((OclEditor) c).getOclDocument().equals(oclDoc)) editorTabbedPane().setSelectedComponent(c);
			}
		}		
	}
	
	public void selectEditor(Editor editor){		
		for(Component c: editorTabbedPane().getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().equals(editor)) editorTabbedPane().setSelectedComponent(c);
			}else{
				if(c.equals(editor)) editorTabbedPane().setSelectedComponent(c);
			}
		}		
	}
	
	public void selectWarningEditor(){
		for(Component c: infoTabbedPane().getComponents()){
			if(c instanceof WarningEditor) {
				infoTabbedPane().setSelectedIndex(infoTabbedPane().indexOfComponent(c));	
			}
		}
	}
			
	public void selectErrorEditor(){
		for(Component c: infoTabbedPane().getComponents()){
			if(c instanceof ErrorEditor) {
				infoTabbedPane().setSelectedIndex(infoTabbedPane().indexOfComponent(c));	
			}
		}
	}
	
	public void selectConsoleEditor(){
		for(Component c: infoTabbedPane().getComponents()){
			if(c instanceof ConsoleEditor) {
				infoTabbedPane().setSelectedIndex(infoTabbedPane().indexOfComponent(c));	
			}
		}
	}
	
	//----- check -----
	
	public boolean isEditorOpen(StructureDiagram diagram){
		for(Component c: editorTabbedPane().getComponents())
			if (c instanceof DiagramWrapper)
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) return true;
		return false;
	}

	public boolean isEditorOpen (OclDocument oclDoc){
		for(Component c: editorTabbedPane().getComponents())
			if (c instanceof OclEditor)
				if (((OclEditor)c).getOclDocument().equals(oclDoc)) return true;
		return false;
	}

	//----- close -----
	
	public void closeCurrentOclEditor(){
		Editor editor = getCurrentOclEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				boolean response = MessageManager.get().confirm("Save", 
				"Your rules document has been modified. Save changes?");
				if(response) { 
					ProjectManager.get().saveProject(); 
				}else{ 
					return;
				}
			}			
			closeThis(getEditorIndex(((OclEditor)editor).getOclDocument()), editorTabbedPane());
		}
	}
	
	public void closeCurrentDiagramEditor(){
		Editor editor = getCurrentDiagramEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				boolean response = MessageManager.get().confirm("Save", 
				"Your diagram has been modified. Save changes?");
				if(response) { 
					ProjectManager.get().saveProject(); 
				}else{ 
					return; 
				}				
			}			
			closeThis(getEditorIndex(((DiagramEditor)editor).getDiagram()),editorTabbedPane());
		}
	}
	
	//----- remove -----
	
	public void removeEditor(StructureDiagram diagram){
		for(Component c: editorTabbedPane().getComponents()){
			if (c instanceof DiagramWrapper){
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) editorTabbedPane().remove(c);
			}
		}		
	}
	
	public void removeEditor(OclDocument doc){		
		for(Component c: editorTabbedPane().getComponents()){
			if (c instanceof OclEditor){
				if (((OclEditor)c).getOclDocument().equals(doc)) editorTabbedPane().remove(c);
			}
		}	
	}
	
	//----- add -----
	
	public void addEditor(Object obj){
		if(!selectEditor(obj)){
			if(obj instanceof OntoumlDiagram) { 
				addDiagramEditor((OntoumlDiagram)obj); 
				return; 
			}
			if(obj instanceof OclDocument) { 
				addOclEditor((OclDocument)obj); 
				return; 
			}
		}		
	}
	
	public DiagramEditor addDiagramEditor(OntoumlDiagram diagram){		
		DiagramEditor editor = new DiagramEditor(frame(), editorTabbedPane(), diagram);	
		editor.addAppCommandListener(listener());
		OccurenceManager.get().add(editor.getDiagram());
		DiagramWrapper wrapper = new DiagramWrapper(editor, listener());
		editor.setWrapper(wrapper);
		addClosableTab(editorTabbedPane(),((StructureDiagram)diagram).getLabelText(), wrapper);		
		return editor;
	}
	
	public List<DiagramEditor> addDiagramEditors(List<OntoumlDiagram> diagrams){
		List<DiagramEditor> result = new ArrayList<DiagramEditor>();
		for(OntoumlDiagram diagram: diagrams) {
			result.add(addDiagramEditor((StructureDiagram)diagram));
		}
		return result;
	}
	
	public OclEditor addOclEditor(OclDocument oclDoc){		
		OclEditor editor = new OclEditor(frame(), oclDoc);
		addClosableTab(editorTabbedPane(),oclDoc.getName(), editor);		
		return editor;
	}
	
	public StartPage addStartEditor(boolean closable){
		StartPage start = new StartPage(listener());
		if(closable)addClosableTab(editorTabbedPane(),"Welcome", start);
		else addNonClosableTab(editorTabbedPane(),"Welcome", start);
		return start;
	}
	
	public void addFinderEditor(){ 
		addFinderEditor(editorTabbedPane(),true, listener()); 
	}
	
	public FindEditor addFinderEditor(JTabbedPane pane, boolean closable, CommandListener listener){
		for(Component c: pane.getComponents()) {
			if(c instanceof FindEditor) { pane.setSelectedComponent(c); return (FindEditor)c; }
		}		
		FindEditor finder = new FindEditor(listener,true);
		if(closable)addClosableTab(pane,"Find", finder);
		else addNonClosableTab(pane,"Find", finder);
		return finder;
	}
	
	public void addStatisticsEditor() { 
		addStatisticsEditor(editorTabbedPane(),true); 
	}
	
	public StatisticsPane addStatisticsEditor(JTabbedPane pane, boolean closable){
		for(Component c: pane.getComponents()) {
			if(c instanceof StatisticsPane) { pane.setSelectedComponent(c); return (StatisticsPane)c; }
		}		
		StatisticsPane statPanel = new StatisticsPane(ProjectManager.get().getProject());
		if(closable) addClosableTab(pane,"Statistics", statPanel);
		else addNonClosableTab(pane,"Statistics", statPanel);
		return statPanel;
	}
	
	public void addWarningsEditor(String message, List<ProblemElement> warnings, CommandListener listener){
		WarningEditor warningsPane = addWarningsEditor(true, listener);
		warningsPane.setData(warnings);
		warningsPane.setStatus(message);
	}
	
	public WarningEditor addWarningsEditor(boolean closable, CommandListener listener){
		JTabbedPane pane = infoTabbedPane();
		for(Component c: pane.getComponents()) {
			if(c instanceof WarningEditor) { pane.setSelectedComponent(c); return (WarningEditor)c; }
		}		
		WarningEditor warningPane = new WarningEditor(listener);
		if(closable) addClosableTab(pane,"Warnings", warningPane);
		else addNonClosableTab(pane,"Warnings", warningPane);
		return warningPane;
	}
	
	public void addErrorsEditor(double startTime, double endTime, List<ProblemElement> errors, CommandListener listener){
		ErrorEditor errorPane = addErrorsEditor(true, listener);
		errorPane.setData(errors);
		errorPane.setStatus(MessageFormat.format("Model verified in {0} ms, {1} error(s) found", (startTime - endTime),  errors.size()));
	}
	
	public ErrorEditor addErrorsEditor(boolean closable, CommandListener listener){		
		JTabbedPane pane = infoTabbedPane();
		for(Component c: pane.getComponents()) {
			if(c instanceof ErrorEditor) { pane.setSelectedComponent(c); return (ErrorEditor)c; }
		}		
		ErrorEditor problemsPane = new ErrorEditor(listener);
		if(closable) addClosableTab(pane,"Errors", problemsPane);
		else addNonClosableTab(pane,"Errors", problemsPane);
		return problemsPane;
	}
	
	public TxtEditor addTextEditor(String content){
		TxtEditor textViz = (TxtEditor) TabManager.get().getEditor(EditorType.TXT_EDITOR);
		if(textViz == null){
			textViz = new TxtEditor();
			addClosableTab(editorTabbedPane(),"Text Editor", textViz);
		}else{
			editorTabbedPane().setSelectedComponent(textViz);
		}
		textViz.setText(content);
		return textViz;
	}
	
	// ---- close Tab ----
	
	public void closeThis(Component c)	{
		closeThis(editorTabbedPane().indexOfComponent(c),editorTabbedPane());
	}
	
	public void closeOthers(Component component){
		closeOthers(editorTabbedPane(),component);
	}
	
	public void closeAll(Component c){
		closeAll(editorTabbedPane());
	}
	
	public void closeAll(JTabbedPane pane){
		 int tabCount = pane.getTabCount();         
         for (int i = 1; i < tabCount; i++) {
             closeThis(1, pane);
         }
	}
	
	public void closeThis(int i, JTabbedPane pane){		
		if (i != -1) {
			IDisposable disposable = (IDisposable) pane.getComponentAt(i);
			if(disposable != null) disposable.dispose();			
			pane.remove(i);
		}
	}
	
	public void closeOthers(JTabbedPane pane,Component component)	{	
		int selectedTabIndex = pane.indexOfComponent(component);		
		 // First remove higher indexes 
        int tabCount = pane.getTabCount();         
        if (selectedTabIndex < tabCount - 1) {
            for (int i = selectedTabIndex + 1; i < tabCount; i++) {
                closeThis(selectedTabIndex + 1,pane);
            }
        }         
        if (selectedTabIndex > 0) {
            for (int i = 1; i < selectedTabIndex; i++) {
                closeThis(1,pane);
            }
        }
	}
	
	//----- closable tab -----
	
	public Component addNonClosableTab(JTabbedPane pane, String text, Component component){
		if (component==null) component = new JPanel();
		pane.addTab(text, component);
		setTabIcon(pane, component);
		pane.setSelectedComponent(component);
		return component;
	}
	
	public void setTabIcon(JTabbedPane pane, Component component){
		if(component instanceof OclEditor) {
			pane.setIconAt(pane.indexOfComponent(component), IconMap.getInstance().getIcon(IconType.MENTHOR_CONSTRAINTDOC));
		}
		if(component instanceof DiagramWrapper) {
			pane.setIconAt(pane.indexOfComponent(component), IconMap.getInstance().getIcon(IconType.MENTHOR_DIAGRAM));
		}
		if(component instanceof ProblemEditor) {
			pane.setIconAt(pane.indexOfComponent(component), IconMap.getInstance().getIcon(IconType.MENTHOR_CHECK));		
		}
		if(component instanceof StatisticsPane) {
			pane.setIconAt(pane.indexOfComponent(component), IconMap.getInstance().getIcon(IconType.MENTHOR_STATS));
		}
		if(component instanceof FindEditor) {
			pane.setIconAt(pane.indexOfComponent(component), IconMap.getInstance().getIcon(IconType.MENTHOR_SEARCH));
		}		
		if(component instanceof WarningEditor) {
			pane.setIconAt(pane.indexOfComponent(component), IconMap.getInstance().getIcon(IconType.MENTHOR_WARNING));
		}
		if(component instanceof ErrorEditor) {
			pane.setIconAt(pane.indexOfComponent(component), IconMap.getInstance().getIcon(IconType.MENTHOR_ERROR));
		}
	}
	
	public Component addClosableTab(JTabbedPane pane, String text, Component component){
		if (component==null) component = new JPanel();
		pane.addTab(text, component);		
		CommandListener listener = listener();
		ClosableTab tab = null; Icon icon = null;
		if(component instanceof DiagramWrapper){
			tab = new ClosableTab(pane, listener);
			icon = IconMap.getInstance().getIcon(IconType.MENTHOR_DIAGRAM);			
		}
		if(component instanceof OclEditor){
			tab = new ClosableTab(pane,listener);
			icon = IconMap.getInstance().getIcon(IconType.MENTHOR_CONSTRAINTDOC);
		}
		if(component instanceof TxtEditor){
			tab = new ClosableTab(pane,false,listener);
			icon = IconMap.getInstance().getIcon(IconType.MENTHOR_DOC);
		}
		if(component instanceof FindEditor){
			tab = new ClosableTab(pane,false,listener);
			icon = IconMap.getInstance().getIcon(IconType.MENTHOR_SEARCH);			
		}
		if(component instanceof ProblemEditor){
			tab = new ClosableTab(pane,false,listener);
			icon = IconMap.getInstance().getIcon(IconType.MENTHOR_ERROR);		
		}
		if(component instanceof StatisticsPane){
			tab = new ClosableTab(pane,false,listener);
			icon = IconMap.getInstance().getIcon(IconType.MENTHOR_STATS);		
		}
		if(component instanceof WarningEditor) {
			tab = new ClosableTab(pane,false,listener);
			icon = IconMap.getInstance().getIcon(IconType.MENTHOR_WARNING);					
		}
		if(component instanceof ErrorEditor) {
			tab = new ClosableTab(pane,false,listener);
			icon = IconMap.getInstance().getIcon(IconType.MENTHOR_ERROR);					
		}
		if(tab!=null){
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			pane.setTabComponentAt(pane.indexOfComponent(component),tab);
			pane.setSelectedComponent(component);
		}
		return component;
	}

	
}
