package net.menthor.editor.v2.ui.app.manager;

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
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.OntoumlWrapper;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Element;
import RefOntoUML.NamedElement;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.element.ProblemElement;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.app.AppEditorsPane;
import net.menthor.editor.v2.ui.editor.ConsoleEditor;
import net.menthor.editor.v2.ui.editor.EditorType;
import net.menthor.editor.v2.ui.editor.ErrorEditor;
import net.menthor.editor.v2.ui.editor.FindEditor;
import net.menthor.editor.v2.ui.editor.IEditor;
import net.menthor.editor.v2.ui.editor.OclEditor;
import net.menthor.editor.v2.ui.editor.ProblemEditor;
import net.menthor.editor.v2.ui.editor.StartEditor;
import net.menthor.editor.v2.ui.editor.StatisticsEditor;
import net.menthor.editor.v2.ui.editor.TextEditor;
import net.menthor.editor.v2.ui.editor.WarningEditor;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.ui.util.ClosableTab;

public class AppTabManager extends AppGenericManager {

	// -------- Lazy Initialization

	private static class TabLoader {
        private static final AppTabManager INSTANCE = new AppTabManager();
    }	
	public static AppTabManager get() { 
		return TabLoader.INSTANCE; 
	}	
    private AppTabManager() {
        if (TabLoader.INSTANCE != null) throw new IllegalStateException("TabManager already instantiated");
    }		
    
    // ----------------------------
	
	/** add diagrams recorded as open in the project */
	public void initialize(UmlProject project){		
		if(project.isAllClosed() && project.getDiagrams().size()>0){				
			AppTabManager.get().addDiagramEditor((StructureDiagram)project.getDiagrams().get(0));
		}else{
			for(OntoumlDiagram diagram: project.getDiagrams()) {
				if(project.isOpened(diagram)){						
					AppTabManager.get().addDiagramEditor((StructureDiagram)diagram);
				}
			}
		}		
	}
	
	/** clear the editor tabbed pane */
	public void backToInitialState(){
		editorsPane().removeAll();
		AppTabManager.get().addStartEditor(false);
		editorsPane().repaint();
		editorsPane().revalidate();
		frame().resetFrame();		
	}	
	
	// ----- getters ----
	
	public StartEditor getStartEditor(){
		for(Component c: editorsPane().getComponents()){
			if(c instanceof StartEditor) return(StartEditor)c;			
		}	
		return null;
	}
	
	public IEditor getCurrentEditor(){
		if(editorsPane().getSelectedIndex() != -1){
			Object obj = editorsPane().getSelectedComponent();
			if(obj instanceof IEditor) return (IEditor) obj;	
		}
		return null;
	}
	
	
	public IEditor getEditor(EditorType nature){
		int totalTabs = editorsPane().getTabCount();
		for(int i = 0; i < totalTabs; i++){
			IEditor editor = (IEditor)editorsPane().getComponentAt(i);
			if(editor.getEditorType() == nature){
				return editor;
			}
		}
		return null;
	}
	
	public OntoumlEditor getCurrentDiagramEditor(){		
		if(editorsPane().getSelectedComponent() instanceof OntoumlWrapper){			
			return ((OntoumlWrapper) editorsPane().getSelectedComponent()).getDiagramEditor();
		}
		return null;
	}
	
	public OclEditor getCurrentOclEditor(){
		if(editorsPane().getSelectedComponent() instanceof OclEditor) {
			return ((OclEditor)editorsPane().getSelectedComponent());
		}
		return null;
	}
	
	public OntoumlEditor getDiagramEditor(StructureDiagram diagram){		
		for(Component c: editorsPane().getComponents()){
			if(c instanceof OntoumlWrapper) {
				if (((OntoumlWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return ((OntoumlWrapper)c).getDiagramEditor();
			}
		}
		OntoumlEditor editor = new OntoumlEditor(frame(),listener(), editorsPane(),diagram);
		editor.addAppCommandListener(listener());
		return editor;
	}
	
	public OclEditor getOclEditor(OclDocument oclDoc){		
		for(Component c: editorsPane().getComponents()){
			if(c instanceof OclEditor) {
				if (((OclEditor)c).getOclDocument().equals(oclDoc))
					return (OclEditor)c;
			}
		}
		return null;
	}
	
	public List<OntoumlEditor> getDiagramEditors(){
		List<OntoumlEditor> list = new ArrayList<OntoumlEditor>();
		for(Component c: editorsPane().getComponents()){
			if(c instanceof OntoumlWrapper) list.add(((OntoumlWrapper)c).getDiagramEditor());
		}
		return list;
	}
	
	public List<OclEditor> getOclEditors(){
		List<OclEditor> list = new ArrayList<OclEditor>();
		for(Component c: editorsPane().getComponents()){
			if(c instanceof OclEditor) list.add((OclEditor)c);
		}
		return list;
	}
	
	public ArrayList<StructureDiagram> getDiagrams(){
		ArrayList<StructureDiagram> list = new ArrayList<StructureDiagram>();
		for(Component c: editorsPane().getComponents()){
			if(c instanceof OntoumlWrapper) list.add(((OntoumlWrapper)c).getDiagramEditor().getDiagram());
		}
		return list;
	}
	
	public String getConstraints(){
		String result = new String();
		for(OclDocument oclmodel: ProjectManager.get().getProject().getOclDocList()){				
			OclEditor ce = AppTabManager.get().getOclEditor(oclmodel);
			if(ce!=null) result+=ce.getText();
			else result+=oclmodel.getContentAsString();
		}
		return result;
	}
		
	//----- index -----
	
	public int getEditorIndex(IEditor editor){
		if(editor instanceof OntoumlEditor) return editorsPane().indexOfComponent(((OntoumlEditor)editor).getWrapper());
		else return editorsPane().indexOfComponent((Component)editor);
	}
	
	public int getEditorIndex(Object obj){
		if(obj instanceof StructureDiagram){
			return getEditorIndex((StructureDiagram)obj);
		}
		else if(obj instanceof OclDocument){
			return getEditorIndex((OclDocument)obj);
		}
		
		return -1;
	}
	
	public int getEditorIndex(StructureDiagram diagram){		
		for(Component c: editorsPane().getComponents()){
			if(c instanceof OntoumlWrapper) {
				if (((OntoumlWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return editorsPane().indexOfComponent(c);
			}
		}
		return -1;
	}
	
	public int getEditorIndex(OclDocument oclDoc){
		for(Component c: editorsPane().getComponents()){
			if(c instanceof OclEditor) {
				if (((OclEditor)c).getOclDocument().equals(oclDoc))
					return editorsPane().indexOfComponent(c);
			}
		}
		return -1;		
	}
	
	//----- select -----
	
	public boolean selectEditor(Object obj){
		for(Component c: editorsPane().getComponents()){
			if(c.equals(obj)) {
				editorsPane().setSelectedComponent(c);
				return true;
			}
			if(c instanceof OntoumlWrapper) {
				if(((OntoumlWrapper) c).getDiagramEditor().getDiagram().equals(obj)) {
					editorsPane().setSelectedComponent(c);
					return true;
				}
			}			
			if(c instanceof OclEditor) {
				if(((OclEditor) c).getOclDocument().equals(obj)) {
					editorsPane().setSelectedComponent(c);	
					return true;
				}
			}
		}	
		return false;
	}
	
	public void selectEditor(StructureDiagram diagram){		
		for(Component c: editorsPane().getComponents()){
			if(c instanceof OntoumlWrapper) {
				if(((OntoumlWrapper) c).getDiagramEditor().getDiagram().equals(diagram)) editorsPane().setSelectedComponent(c);
			}
		}		
	}
	
	public boolean selectEditor(OclDocument oclDoc){		
		for(Component c: editorsPane().getComponents()){
			if(c instanceof OclEditor && ((OclEditor) c).getOclDocument().equals(oclDoc)) {
				editorsPane().setSelectedComponent(c);
				return true;
			}
		}
		return false;
	}
	
	public void selectEditor(IEditor editor){		
		for(Component c: editorsPane().getComponents()){
			if(c instanceof OntoumlWrapper) {
				if(((OntoumlWrapper) c).getDiagramEditor().equals(editor)) editorsPane().setSelectedComponent(c);
			}else{
				if(c.equals(editor)) editorsPane().setSelectedComponent(c);
			}
		}		
	}
	
	public void selectWarningEditor(){
		for(Component c: infoPane().getComponents()){
			if(c instanceof WarningEditor) {
				infoPane().setSelectedIndex(infoPane().indexOfComponent(c));	
			}
		}
	}
			
	public void selectErrorEditor(){
		for(Component c: infoPane().getComponents()){
			if(c instanceof ErrorEditor) {
				infoPane().setSelectedIndex(infoPane().indexOfComponent(c));	
			}
		}
	}
	
	public void selectConsoleEditor(){
		for(Component c: infoPane().getComponents()){
			if(c instanceof ConsoleEditor) {
				infoPane().setSelectedIndex(infoPane().indexOfComponent(c));	
			}
		}
	}
	
	//----- check -----
	
	public boolean isEditorOpen(StructureDiagram diagram){
		for(Component c: editorsPane().getComponents())
			if (c instanceof OntoumlWrapper)
				if (((OntoumlWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) return true;
		return false;
	}

	public boolean isEditorOpen (OclDocument oclDoc){
		for(Component c: editorsPane().getComponents())
			if (c instanceof OclEditor)
				if (((OclEditor)c).getOclDocument().equals(oclDoc)) return true;
		return false;
	}

	//----- close -----
	
	public void closeCurrentOclEditor(){
		IEditor editor = getCurrentOclEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				boolean response = AppMessageManager.get().confirm("Save", 
				"Your rules document has been modified. Save changes?");
				if(response) { 
					ProjectManager.get().saveProject(); 
				}else{ 
					return;
				}
			}			
			closeThis(getEditorIndex(((OclEditor)editor).getOclDocument()), editorsPane());
		}
	}
	
	public void closeCurrentDiagramEditor(){
		IEditor editor = getCurrentDiagramEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				boolean response = AppMessageManager.get().confirm("Save", 
				"Your diagram has been modified. Save changes?");
				if(response) { 
					ProjectManager.get().saveProject(); 
				}else{ 
					return; 
				}				
			}			
			closeThis(getEditorIndex(((OntoumlEditor)editor).getDiagram()),editorsPane());
		}
	}
	
	//----- remove -----
	
	public void removeEditor(StructureDiagram diagram){
		for(Component c: editorsPane().getComponents()){
			if (c instanceof OntoumlWrapper){
				if (((OntoumlWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) editorsPane().remove(c);
			}
		}		
	}
	
	public void removeEditor(OclDocument doc){		
		for(Component c: editorsPane().getComponents()){
			if (c instanceof OclEditor){
				if (((OclEditor)c).getOclDocument().equals(doc)) editorsPane().remove(c);
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
	
	public OntoumlEditor addDiagramEditor(OntoumlDiagram diagram){		
		OntoumlEditor editor = new OntoumlEditor(frame(), listener(), editorsPane(), diagram);	
		editor.addAppCommandListener(listener());
		OccurenceManager.get().add(editor.getDiagram());
		OntoumlWrapper wrapper = new OntoumlWrapper(editor, listener());
		editor.setWrapper(wrapper);
		addClosableTab(editorsPane(),((StructureDiagram)diagram).getLabelText(), wrapper);		
		return editor;
	}
	
	public List<OntoumlEditor> addDiagramEditors(List<OntoumlDiagram> diagrams){
		List<OntoumlEditor> result = new ArrayList<OntoumlEditor>();
		for(OntoumlDiagram diagram: diagrams) {
			result.add(addDiagramEditor((StructureDiagram)diagram));
		}
		return result;
	}
	
	public OclEditor addOclEditor(OclDocument oclDoc){		
		OclEditor editor = new OclEditor(frame(), oclDoc);
		addClosableTab(editorsPane(),oclDoc.getName(), editor);		
		return editor;
	}
	
	public StartEditor addStartEditor(boolean closable){
		StartEditor start = new StartEditor(listener());
		if(closable)addClosableTab(editorsPane(),"Welcome", start);
		else addNonClosableTab(editorsPane(),"Welcome", start);
		return start;
	}
	
	public void addFinderEditor(){ 
		addFinderEditor(editorsPane(),true, listener()); 
	}
	
	public FindEditor addFinderEditor(JTabbedPane pane, boolean closable, ICommandListener listener){
		for(Component c: pane.getComponents()) {
			if(c instanceof FindEditor) { pane.setSelectedComponent(c); return (FindEditor)c; }
		}		
		FindEditor finder = new FindEditor(listener,true);
		if(closable)addClosableTab(pane,"Find", finder);
		else addNonClosableTab(pane,"Find", finder);
		return finder;
	}
	
	public void addStatisticsEditor() { 
		addStatisticsEditor(editorsPane(),true); 
	}
	
	public StatisticsEditor addStatisticsEditor(JTabbedPane pane, boolean closable){
		for(Component c: pane.getComponents()) {
			if(c instanceof StatisticsEditor) { pane.setSelectedComponent(c); return (StatisticsEditor)c; }
		}		
		StatisticsEditor statPanel = new StatisticsEditor();
		if(closable) addClosableTab(pane,"Statistics", statPanel);
		else addNonClosableTab(pane,"Statistics", statPanel);
		return statPanel;
	}
	
	public void addWarningsEditor(String message, List<ProblemElement> warnings, ICommandListener listener){
		WarningEditor warningsPane = addWarningsEditor(true, listener);
		warningsPane.setData(warnings);
		warningsPane.setStatus(message);
	}
	
	public WarningEditor addWarningsEditor(boolean closable, ICommandListener listener){
		JTabbedPane pane = infoPane();
		for(Component c: pane.getComponents()) {
			if(c instanceof WarningEditor) { pane.setSelectedComponent(c); return (WarningEditor)c; }
		}		
		WarningEditor warningPane = new WarningEditor(listener);
		if(closable) addClosableTab(pane,"Warnings", warningPane);
		else addNonClosableTab(pane,"Warnings", warningPane);
		return warningPane;
	}
	
	public void addErrorsEditor(double startTime, double endTime, List<ProblemElement> errors){
		ErrorEditor errorPane = addErrorsEditor(true, listener());
		errorPane.setData(errors);
		errorPane.setStatus(MessageFormat.format("Model verified in {0} ms, {1} error(s) found", (startTime - endTime),  errors.size()));
	}
	
	public ErrorEditor addErrorsEditor(boolean closable, ICommandListener listener){		
		JTabbedPane pane = infoPane();
		for(Component c: pane.getComponents()) {
			if(c instanceof ErrorEditor) { pane.setSelectedComponent(c); return (ErrorEditor)c; }
		}		
		ErrorEditor problemsPane = new ErrorEditor(listener);
		if(closable) addClosableTab(pane,"Errors", problemsPane);
		else addNonClosableTab(pane,"Errors", problemsPane);
		return problemsPane;
	}
	
	public TextEditor addTextEditor(String content){
		TextEditor textViz = (TextEditor) AppTabManager.get().getEditor(EditorType.TXT_EDITOR);
		if(textViz == null){
			textViz = new TextEditor();
			addClosableTab(editorsPane(),"Text Editor", textViz);
		}else{
			editorsPane().setSelectedComponent(textViz);
		}
		textViz.setText(content);
		return textViz;
	}
	
	// ---- close Tab ----
	
	public void closeThis(Component c)	{
		closeThis(editorsPane().indexOfComponent(c),editorsPane());
	}
	
	public void closeOthers(Component component){
		closeOthers(editorsPane(),component);
	}
	
	public void closeAll(Component c){
		closeAll(editorsPane());
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
		if(component instanceof OntoumlWrapper) {
			pane.setIconAt(pane.indexOfComponent(component), IconMap.getInstance().getIcon(IconType.MENTHOR_DIAGRAM));
		}
		if(component instanceof ProblemEditor) {
			pane.setIconAt(pane.indexOfComponent(component), IconMap.getInstance().getIcon(IconType.MENTHOR_CHECK));		
		}
		if(component instanceof StatisticsEditor) {
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
		ICommandListener listener = listener();
		ClosableTab tab = null; Icon icon = null;
		if(component instanceof OntoumlWrapper){
			tab = new ClosableTab(pane, listener);
			icon = IconMap.getInstance().getIcon(IconType.MENTHOR_DIAGRAM);			
		}
		if(component instanceof OclEditor){
			tab = new ClosableTab(pane,listener);
			icon = IconMap.getInstance().getIcon(IconType.MENTHOR_CONSTRAINTDOC);
		}
		if(component instanceof TextEditor){
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
		if(component instanceof StatisticsEditor){
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
	
	//---- show text -----
	
	public void showOutputInfo(String text, boolean clear, boolean showOutput){	
		infoPane().showOutput(text, clear, showOutput);
	}
	
	//----- open -------
	
	public DiagramElement openedInADiagram(Element element){
		for(DiagramElement de: OccurenceManager.get().getDiagramElements(element)){
			for(StructureDiagram d: getDiagrams()){
				if(d.getChildren().contains(de)) return de;				
			}
		}
		return null;
	}
	
	/** get diagram editors */
	public List<OntoumlEditor> getDiagramEditors(RefOntoUML.Element element){
		List<OntoumlEditor> list = new ArrayList<OntoumlEditor>();
		List<OntoumlDiagram> diagrams = OccurenceManager.get().getDiagrams(element);
		for(OntoumlDiagram diagram: diagrams){			
			OntoumlEditor editor = getDiagramEditor((StructureDiagram)diagram);
			list.add(editor);			
		}
		return list;
	}
	
	//----- ------
	// Item is the OCLDocument or StructureDigram used to identify the tab that needs renaming.
	public void refrashTabTitle(NamedElement item){
		int index = getEditorIndex(item);	
		
		if(index>=0){ 
			AppEditorsPane.get().setTitleAt(index, item.getName());			        
		}
		
		AppEditorsPane.get().updateUI();
	}
}
