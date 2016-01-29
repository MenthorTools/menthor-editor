package net.menthor.editor.v2.managers;

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

	private static TabManager instance = new TabManager();
	public static TabManager get() { return instance; }
	
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
	
	public void setCurrentEditorName(String newName){
		Editor currentEditor = getCurrentEditor();
        if(currentEditor instanceof DiagramEditor) ((DiagramEditor)currentEditor).getDiagram().setName(newName);
        if(currentEditor instanceof OclEditor)((OclEditor)currentEditor).getOclDocument().setName(newName);
        browser.refresh();
	}
	
	// ----- getters ----
	
	public StartPage getStartEditor(){
		for(Component c: diagramManager.getComponents()){
			if(c instanceof StartPage) return(StartPage)c;			
		}	
		return null;
	}
	
	public Editor getCurrentEditor(){
		if(diagramManager.getSelectedIndex() != -1){
			Object obj = diagramManager.getSelectedComponent();
			if(obj instanceof Editor) return (Editor) obj;	
		}
		return null;
	}
	
	
	public Editor getEditor(EditorType nature){
		int totalTabs = diagramManager.getTabCount();
		for(int i = 0; i < totalTabs; i++){
			Editor editor = (Editor)diagramManager.getComponentAt(i);
			if(editor.getEditorType() == nature){
				return editor;
			}
		}
		return null;
	}
	
	public DiagramEditor getCurrentDiagramEditor(){		
		if(diagramManager.getSelectedComponent() instanceof DiagramWrapper){			
			return ((DiagramWrapper) diagramManager.getSelectedComponent()).getDiagramEditor();
		}
		return null;
	}
	
	public OclEditor getCurrentOclEditor(){
		if(diagramManager.getSelectedComponent() instanceof OclEditor) {
			return ((OclEditor)diagramManager.getSelectedComponent());
		}
		return null;
	}
	
	public DiagramEditor getDiagramEditor(StructureDiagram diagram){		
		for(Component c: diagramManager.getComponents()){
			if(c instanceof DiagramWrapper) {
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return ((DiagramWrapper)c).getDiagramEditor();
			}
		}
		DiagramEditor editor = new DiagramEditor(diagramManager.getFrame(),diagramManager,diagram);
		editor.addAppCommandListener(diagramManager.getCommandListener());
		editor.addEditorStateListener(diagramManager);
		editor.addSelectionListener(diagramManager);
		return editor;
	}
	
	public OclEditor getOclEditor(OclDocument oclDoc){		
		for(Component c: diagramManager.getComponents()){
			if(c instanceof OclEditor) {
				if (((OclEditor)c).getOclDocument().equals(oclDoc))
					return (OclEditor)c;
			}
		}
		return null;
	}
	
	public List<DiagramEditor> getDiagramEditors(){
		List<DiagramEditor> list = new ArrayList<DiagramEditor>();
		for(Component c: diagramManager.getComponents()){
			if(c instanceof DiagramWrapper) list.add(((DiagramWrapper)c).getDiagramEditor());
		}
		return list;
	}
	
	public List<OclEditor> getOclEditors(){
		List<OclEditor> list = new ArrayList<OclEditor>();
		for(Component c: diagramManager.getComponents()){
			if(c instanceof OclEditor) list.add((OclEditor)c);
		}
		return list;
	}
	
	public ArrayList<StructureDiagram> getDiagrams(){
		ArrayList<StructureDiagram> list = new ArrayList<StructureDiagram>();
		for(Component c: diagramManager.getComponents()){
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
		if(editor instanceof DiagramEditor) return diagramManager.indexOfComponent(((DiagramEditor)editor).getWrapper());
		else return diagramManager.indexOfComponent((Component)editor);
	}
	
	public int getEditorIndex(StructureDiagram diagram){		
		for(Component c: diagramManager.getComponents()){
			if(c instanceof DiagramWrapper) {
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return diagramManager.indexOfComponent(c);
			}
		}
		return -1;
	}
	
	public int getEditorIndex(OclDocument oclDoc){
		for(Component c: diagramManager.getComponents()){
			if(c instanceof OclEditor) {
				if (((OclEditor)c).getOclDocument().equals(oclDoc))
					return diagramManager.indexOfComponent(c);
			}
		}
		return -1;		
	}
	
	//----- select -----
	
	public boolean selectEditor(Object obj){
		for(Component c: diagramManager.getComponents()){
			if(c.equals(obj)) {
				diagramManager.setSelectedComponent(c);
				return true;
			}
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().getDiagram().equals(obj)) {
					diagramManager.setSelectedComponent(c);
					return true;
				}
			}			
			if(c instanceof OclEditor) {
				if(((OclEditor) c).getOclDocument().equals(obj)) {
					diagramManager.setSelectedComponent(c);	
					return true;
				}
			}
		}	
		return false;
	}
	
	public void selectEditor(StructureDiagram diagram){		
		for(Component c: diagramManager.getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().getDiagram().equals(diagram)) diagramManager.setSelectedComponent(c);
			}
		}		
	}
	
	public void selectEditor(OclDocument oclDoc){		
		for(Component c: diagramManager.getComponents()){
			if(c instanceof OclEditor) {
				if(((OclEditor) c).getOclDocument().equals(oclDoc)) diagramManager.setSelectedComponent(c);
			}
		}		
	}
	
	public void selectEditor(Editor editor){		
		for(Component c: diagramManager.getComponents()){
			if(c instanceof DiagramWrapper) {
				if(((DiagramWrapper) c).getDiagramEditor().equals(editor)) diagramManager.setSelectedComponent(c);
			}else{
				if(c.equals(editor)) diagramManager.setSelectedComponent(c);
			}
		}		
	}
	
	//----- are open -----
	
	public boolean isEditorOpen(StructureDiagram diagram){
		for(Component c: diagramManager.getComponents())
			if (c instanceof DiagramWrapper)
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) return true;
		return false;
	}

	public boolean isEditorOpen (OclDocument oclDoc){
		for(Component c: diagramManager.getComponents())
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
			closeThis(getEditorIndex(((OclEditor)editor).getOclDocument()), diagramManager);
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
			closeThis(getEditorIndex(((DiagramEditor)editor).getDiagram()),diagramManager);
		}
	}
	
	//----- remove -----
	
	public void removeEditor(StructureDiagram diagram){
		for(Component c: diagramManager.getComponents()){
			if (c instanceof DiagramWrapper){
				if (((DiagramWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) diagramManager.remove(c);
			}
		}		
	}
	
	public void removeEditor(OclDocument doc){		
		for(Component c: diagramManager.getComponents()){
			if (c instanceof OclEditor){
				if (((OclEditor)c).getOclDocument().equals(doc)) diagramManager.remove(c);
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
		DiagramEditor editor = new DiagramEditor(diagramManager.getFrame(), diagramManager, diagram);			
		editor.addEditorStateListener(diagramManager);
		editor.addSelectionListener(diagramManager);
		editor.addAppCommandListener(diagramManager.getCommandListener());
		OccurenceManager.get().add(editor.getDiagram());
		DiagramWrapper wrapper = new DiagramWrapper(editor, diagramManager.getCommandListener());
		editor.setWrapper(wrapper);
		addClosableTab(diagramManager,((StructureDiagram)diagram).getLabelText(), wrapper);		
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
		OclEditor editor = new OclEditor(diagramManager.getFrame(), oclDoc);
		addClosableTab(diagramManager,oclDoc.getName(), editor);		
		return editor;
	}
	
	public StartPage addStartEditor(boolean closable){
		StartPage start = new StartPage(diagramManager.getCommandListener());
		if(closable)addClosableTab(diagramManager,"Welcome", start);
		else addNonClosableTab(diagramManager,"Welcome", start);
		return start;
	}
	
	public void addFinderEditor(){ 
		addFinderEditor(diagramManager,true, diagramManager.getCommandListener()); 
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
		addStatisticsEditor(diagramManager,true); 
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
	
	public void addWarningsEditor(JTabbedPane pane, String message, List<ProblemElement> warnings, CommandListener listener){
		WarningEditor warningsPane = addWarningsEditor(pane,true, listener);
		warningsPane.setData(warnings);
		warningsPane.setStatus(message);
	}
	
	public WarningEditor addWarningsEditor(JTabbedPane pane, boolean closable, CommandListener listener){		
		for(Component c: pane.getComponents()) {
			if(c instanceof WarningEditor) { pane.setSelectedComponent(c); return (WarningEditor)c; }
		}		
		WarningEditor warningPane = new WarningEditor(listener);
		if(closable) addClosableTab(pane,"Warnings", warningPane);
		else addNonClosableTab(pane,"Warnings", warningPane);
		return warningPane;
	}
	
	public void addErrorsEditor(JTabbedPane pane, double startTime, double endTime, List<ProblemElement> errors, CommandListener listener){
		ErrorEditor errorPane = addErrorsEditor(pane,true, listener);
		errorPane.setData(errors);
		errorPane.setStatus(MessageFormat.format("Model verified in {0} ms, {1} error(s) found", (startTime - endTime),  errors.size()));
	}
	
	public ErrorEditor addErrorsEditor(JTabbedPane pane, boolean closable, CommandListener listener){		
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
			addClosableTab(diagramManager,"Text Editor", textViz);
		}else{
			diagramManager.setSelectedComponent(textViz);
		}
		textViz.setText(content);
		return textViz;
	}
	
	// ---- close generic ----
	
	public void closeThis(Component c)	{
		closeThis(diagramManager.indexOfComponent(c),diagramManager);
	}
	
	public void closeOthers(Component component){
		closeOthers(diagramManager,component);
	}
	
	public void closeAll(Component c){
		closeAll(diagramManager);
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
	
	//----- add generic -----
	
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
		CommandListener listener = diagramManager.getCommandListener();
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
