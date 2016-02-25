package net.menthor.editor.v2.ui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.OntoumlWrapper;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.NamedElement;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.ui.editor.EditorType;
import net.menthor.editor.v2.ui.editor.ErrorEditor;
import net.menthor.editor.v2.ui.editor.FindEditor;
import net.menthor.editor.v2.ui.editor.IEditor;
import net.menthor.editor.v2.ui.editor.OclEditor;
import net.menthor.editor.v2.ui.editor.StartEditor;
import net.menthor.editor.v2.ui.editor.StatisticsEditor;
import net.menthor.editor.v2.ui.editor.TextEditor;
import net.menthor.editor.v2.ui.editor.WarningEditor;
import net.menthor.editor.v2.ui.generic.GenericTabbedPane;
import net.menthor.editor.v2.ui.icon.IconType;

public class TabbedArea {
	
	private TopTabbedPane topPane = TopTabbedPane.get();
	private BottomTabbedPane bottomPane = BottomTabbedPane.get();
	
	public enum TabPositionType { TOP, BOTTOM }
	
	// -------- Lazy Initialization

	private static class TabbedAreaLoader {
        private static final TabbedArea INSTANCE = new TabbedArea();
    }	
	public static TabbedArea get() { 
		return TabbedAreaLoader.INSTANCE; 
	}	
    private TabbedArea() {
    	super();
        if (TabbedAreaLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }	
    
    // ----------------------------
    
    // component ------------------
    
    public List<Component> getComponents(){
    	List<Component> result = new ArrayList<Component>();    	
    	Component[] c2 = topPane.getComponents();
    	for(Component c: c2){ result.add(c); }
    	Component[] c1 = bottomPane.getComponents();
    	for(Component c: c1){ result.add(c); }
    	return result;
    }
    
    public List<Component> getTopComponents(){
    	List<Component> result = new ArrayList<Component>();    	
    	Component[] c2 = topPane.getComponents();
    	for(Component c: c2){ result.add(c); }
    	return result;
    }
    
    public List<Component> getBottomComponents(){
    	List<Component> result = new ArrayList<Component>();    	
    	Component[] c2 = bottomPane.getComponents();
    	for(Component c: c2){ result.add(c); }
    	return result;
    }
    
    public void setSelectedComponent(Component c){
    	if(bottomPane.indexOfComponent(c)!=-1) bottomPane.setSelectedComponent(c);
    	if(topPane.indexOfComponent(c)!=-1)topPane.setSelectedComponent(c);
    }
    
    // close ------------------
    
    public void closeThis(Component c)	{
		if(bottomPane.indexOfComponent(c)!=-1) bottomPane.closeThis(bottomPane.indexOfComponent(c));
		if(topPane.indexOfComponent(c)!=-1) topPane.closeThis(topPane.indexOfComponent(c));
	}
	
	public void closeOthers(Component c){
		if(bottomPane.indexOfComponent(c)!=-1) bottomPane.closeOthers(c);
		if(topPane.indexOfComponent(c)!=-1) topPane.closeOthers(c);
	}
	
	public void closeAll(Component c){
		if(bottomPane.indexOfComponent(c)!=-1) closeAll(bottomPane);
		if(topPane.indexOfComponent(c)!=-1) closeAll(topPane);
	}
	
	
	public IEditor closeSelectedOntoumlEditor(){
		IEditor editor = getSelectedOntoumlEditor();
		if(editor!=null){
			closeThis((Component)editor);
			return editor;
		}
		return null;
	}
	
	public IEditor closeSelectedOclEditor(){
		IEditor editor = getSelectedOclEditor();		
		if(editor!=null){	
			closeThis((Component)editor);
			return editor;
		}
		return null;
	}
	
    // select ------------------
	
	public boolean select(Object obj){
		if(obj==null) return false;
		if(obj instanceof OclDocument) {
			return select((OclDocument)obj);			
		}
		if(obj instanceof StructureDiagram) {
			return select((StructureDiagram)obj);			
		}
		for(Component c: getComponents()){
			if(c.equals(obj)) {
				setSelectedComponent(c);
				return true;
			}
			if(c instanceof OntoumlWrapper) {
				if(((OntoumlWrapper) c).getDiagramEditor().getDiagram().equals(obj)) {
					setSelectedComponent(c);
					return true;
				}
			}			
			if(c instanceof OclEditor) {
				if(((OclEditor) c).getOclDocument().equals(obj)) {
					setSelectedComponent(c);	
					return true;
				}
			}			
		}	
		return false;
	}
	
	public Component select(EditorType type){
    	for(Component c: getComponents()) {
			if(c instanceof IEditor) { 
				if(((IEditor) c).getEditorType().equals(type)){
					setSelectedComponent(c); 
					return c;
				}
			}
		}
    	return null;
    }
	
	public boolean select(IEditor editor){		
		for(Component c: getComponents()){
			if(c instanceof OntoumlWrapper) {
				if(((OntoumlWrapper) c).getDiagramEditor().equals(editor)) {
					setSelectedComponent(c);
					return true;
				}
			}else{
				if(c.equals(editor)) {
					setSelectedComponent(c);
					return true;
				}
			}
		}		
		return false;
	}
	
	public boolean select(StructureDiagram diagram){		
		for(Component c: getComponents()){
			if(c instanceof OntoumlWrapper) {
				OntoumlEditor editor = ((OntoumlWrapper) c).getDiagramEditor();
				if(editor.getDiagram().equals(diagram)) {
					setSelectedComponent(c);
					return true;
				}
			}
		}		
		return false;
	}
	
	public boolean select(OclDocument oclDoc){		
		for(Component c: getComponents()){
			if(c instanceof OclEditor && ((OclEditor) c).getOclDocument().equals(oclDoc)) {
				setSelectedComponent(c);
				return true;
			}
		}
		return false;
	}
	
    // getters (selected) ------------------
	
	public IEditor getSelectedTopEditor(){
		if(topPane.getSelectedIndex() != -1){
			Object obj = topPane.getSelectedComponent();
			if(obj instanceof IEditor) return (IEditor) obj;	
		}
		return null;
	}
	
	public IEditor getSelectedTopEditor(EditorType type){				
		IEditor editor = getSelectedTopEditor();
		if(editor!=null && editor.getEditorType().equals(type)) {
			return editor;
		}
		return null;				
	}
	
	public OclEditor getSelectedTopOclEditor(){				
		IEditor editor = getSelectedTopEditor(EditorType.OCL_EDITOR);
		return (OclEditor)editor;						
	}
	
	public OntoumlEditor getSelectedTopOntoumlEditor(){				
		IEditor editor = getSelectedTopEditor(EditorType.ONTOUML_EDITOR);
		if(editor instanceof OntoumlWrapper) return ((OntoumlWrapper)editor).getDiagramEditor();
		return null;						
	}
	
	public IEditor getSelectedBottomEditor(){
		if(bottomPane.getSelectedIndex() != -1){
			Object obj = bottomPane.getSelectedComponent();
			if(obj instanceof IEditor) return (IEditor) obj;	
		}
		return null;
	}
	
	public IEditor getSelectedBottomEditor(EditorType type){				
		IEditor editor = getSelectedBottomEditor();
		if(editor!=null && editor.getEditorType().equals(type)) {
			return editor;
		}
		return null;				
	}
	
	public OclEditor getSelectedBottomOclEditor(){				
		IEditor editor = getSelectedBottomEditor(EditorType.OCL_EDITOR);
		return (OclEditor)editor;						
	}
	
	public OclEditor getSelectedBottomOntoumlEditor(){				
		IEditor editor = getSelectedBottomEditor(EditorType.ONTOUML_EDITOR);
		return (OclEditor)editor;						
	}
	
	public OntoumlEditor getSelectedOntoumlEditor(){
		IEditor editor = getSelectedTopOntoumlEditor();
		if(editor==null) editor = getSelectedBottomOntoumlEditor();
		return (OntoumlEditor)editor;
	}
	
	public OclEditor getSelectedOclEditor(){
		IEditor editor = getSelectedTopOclEditor();
		if(editor==null) editor = getSelectedBottomOclEditor();
		return (OclEditor)editor;
	}
	
    // getters (editors) ------------------
	
	public IEditor getEditor(EditorType type){
		for(Component c: getComponents()){
			if(c instanceof IEditor) {
				if(((IEditor)c).getEditorType().equals(type)){
					return (IEditor)c;			
				}
			}
		}	
		return null;
	}
	
	public OclEditor getOclEditor(OclDocument oclDoc){		
		for(Component c: getComponents()){
			if(c instanceof OclEditor) {
				if (((OclEditor)c).getOclDocument().equals(oclDoc))
					return (OclEditor)c;
			}
		}
		return null;
	}
		
	public List<OntoumlEditor> getOntoumlEditors(List<OntoumlDiagram> diagrams){
		List<OntoumlEditor> result = new ArrayList<OntoumlEditor>();
		for(OntoumlDiagram diagram: diagrams){
			result.add(getOntoumlEditor(diagram));
		}
		return result;
	}
	
	public OntoumlEditor getOntoumlEditor(OntoumlDiagram diagram){		
		for(Component c: getComponents()){
			if(c instanceof OntoumlWrapper) {
				if (((OntoumlWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return ((OntoumlWrapper)c).getDiagramEditor();
			}
		}
		//create new one 
		OntoumlEditor editor = new OntoumlEditor(topPane.getListener(), topPane, diagram);		
		return editor;
	}
	
	public List<OclEditor> getOclEditors(){
		List<OclEditor> list = new ArrayList<OclEditor>();
		for(Component c: getComponents()){
			if(c instanceof OclEditor) list.add((OclEditor)c);
		}
		return list;
	}
	
	public List<OntoumlEditor> getOntoumlEditors(){
		List<OntoumlEditor> list = new ArrayList<OntoumlEditor>();
		for(Component c: getComponents()){
			if(c instanceof OntoumlWrapper) list.add(((OntoumlWrapper)c).getDiagramEditor());
		}
		return list;
	}
	
	public List<OntoumlDiagram> getDiagrams(){
		List<OntoumlDiagram> list = new ArrayList<>();
		for(Component c: getComponents()){
			if(c instanceof OntoumlWrapper) list.add(((OntoumlWrapper)c).getDiagramEditor().getDiagram());
		}
		return list;
	}
	
    // getters (index) ------------------
	
	public int getIndex(Object obj){
		if(obj instanceof StructureDiagram){
			return getIndex((StructureDiagram)obj);
		}else if(obj instanceof OclDocument){
			return getIndex((OclDocument)obj);
		}else if(obj instanceof IEditor){
			return getIndex((IEditor)obj);
		}
		return -1;
	}
	
	public int getIndex(IEditor editor){
		Component c = (Component)editor;
		if(editor instanceof OntoumlEditor) c = ((OntoumlEditor)editor).getWrapper();
		if(topPane.indexOfComponent(c)!=-1) return topPane.indexOfComponent(c);
		if(bottomPane.indexOfComponent(c)!=-1) return bottomPane.indexOfComponent(c);
		return -1;	
	}
	
	public int getIndex(OntoumlDiagram diagram){
		for(Component c: getComponents()){
			if(c instanceof OntoumlWrapper) {
				OntoumlEditor editor = ((OntoumlWrapper)c).getDiagramEditor();
				if (editor.getDiagram().equals(diagram)){
					return getIndex(editor);
				}
			}
		}
		return -1;
	}
	
	public int getIndex(OclDocument oclDoc){
		for(Component c: getComponents()){
			if(c instanceof OclEditor) {
				if (((OclEditor)c).getOclDocument().equals(oclDoc))
					return getIndex((IEditor)c);
			}
		}
		return -1;		
	}
    
    // is open ------------------
    
    public boolean isOpen(StructureDiagram diagram){
		if(getIndex(diagram)!=-1) return true;
		return false;	
	}
    
    public boolean isOpen(OclDocument oclDoc){
  		if(getIndex(oclDoc)!=-1) return true;
  		return false;	
  	}
    
    // remove ------------------
    
    public void remove(Component component){
    	if(topPane.indexOfComponent(component)!=-1) topPane.remove(component);
    	if(bottomPane.indexOfComponent(component)!=-1) bottomPane.remove(component);
    }
    
    public void remove(StructureDiagram diagram){
		for(Component c: getComponents()){
			if (c instanceof OntoumlWrapper){
				if (((OntoumlWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) {
					remove(c);
				}
			}
		}		
	}
    
    public void remove(OclDocument doc){		
		for(Component c: getComponents()){
			if (c instanceof OclEditor){
				if (((OclEditor)c).getOclDocument().equals(doc)) {
					remove(c);
				}
			}
		}	
	}
    
    // show ------------------
    
    public void showConsoleText(String text, boolean clear, boolean forceToShow){	
		bottomPane.showOutput(text, clear, forceToShow);
		select(EditorType.CONSOLE_EDITOR);
	}	
    
    // refresh/update ------------------
    
    public void initialState(){
    	topPane.initialState();    	
    	bottomPane.initialState();
    }
    
	public void refreshTitle(NamedElement item){
		int index = getIndex(item);
		if(index>=0 ){			
			topPane.setTitleAt(index, item.getName());			        
		}
		topPane.updateUI();
	}
	
    // add ------------------
    
    public void add(Object obj){
		if(!select(obj)){
			if(obj instanceof OntoumlDiagram) { 
				add((OntoumlDiagram)obj); 
				return; 
			}
			if(obj instanceof OclDocument) { 
				add((OclDocument)obj); 
				return; 
			}
		}		
	}
    
    public OntoumlEditor add(OntoumlDiagram diagram){		
		Component c = add(TabPositionType.TOP, true, EditorType.ONTOUML_EDITOR, diagram);
		if(c instanceof OntoumlWrapper) return ((OntoumlWrapper)c).getDiagramEditor();
		return null;
	}
    
    public List<OntoumlEditor> addAll(List<OntoumlDiagram> diagrams){
    	List<OntoumlEditor> result = new ArrayList<OntoumlEditor>();
		List<Component> cs = addAll(TabPositionType.TOP, true, EditorType.ONTOUML_EDITOR, diagrams);
		for(Component c: cs){
			if(c instanceof OntoumlWrapper) result.add(((OntoumlWrapper)c).getDiagramEditor());
		}
		return result;		
	}    
    
    public OclEditor add(OclDocument doc){		
		return (OclEditor)add(TabPositionType.TOP, true, EditorType.OCL_EDITOR, doc);
	}
    
    public List<Component> addAll(TabPositionType position, boolean closable, EditorType editorType, List<? extends NamedElement> contents){
    	List<Component> result = new ArrayList<Component>();
    	for(NamedElement ne: contents){
    		Component c = add(position,closable,editorType, ne);
    		if(c!=null) result.add(c);
    	}
    	return result;    	
    }
    
    public Component add(TabPositionType position, boolean closable, EditorType editorType){
    	return add(position, closable, editorType, null);
    }
    
    public Component add(TabPositionType position, boolean closable, EditorType editorType, NamedElement content){
    	if(select(content)) return null;
    	Component editor = null;
    	GenericTabbedPane tabbedpane = bottomPane;
    	if(position.equals(TabPositionType.TOP)) tabbedpane = topPane;
    	String title = "<empty>";
    	IconType icontype = null;
//    	if(editor==null){
			if(editorType.equals(EditorType.WARNING_EDITOR)) {
				editor = new WarningEditor(tabbedpane.getListener());
				title = "Warnings";
				icontype = IconType.MENTHOR_WARNING;
			}
			if(editorType.equals(EditorType.ERRORS_EDITOR)) {
				editor = new ErrorEditor(tabbedpane.getListener());
				title = "Errors";
				icontype = IconType.MENTHOR_ERROR;
			}
			if(editorType.equals(EditorType.STATISTICS_EDITOR)) {
				editor = new StatisticsEditor();
				title = "Statistics";
				icontype = IconType.MENTHOR_STATS;
			}
			if(editorType.equals(EditorType.FINDER_EDITOR)) {
				editor = new FindEditor(tabbedpane.getListener(), true);
				title = "Find";
				icontype = IconType.MENTHOR_SEARCH;
			}
			if(editorType.equals(EditorType.START_EDITOR)) {
				editor = new StartEditor(tabbedpane.getListener());
				title = "Welcome";
				icontype = null;
			}
			if(editorType.equals(EditorType.OCL_EDITOR)){
				editor = new OclEditor((Component)tabbedpane, (OclDocument)content);
				if(content!=null)title = content.getName();
				icontype = IconType.MENTHOR_CONSTRAINTDOC;	
			}	
			if(editorType.equals(EditorType.TXT_EDITOR)){
				editor = new TextEditor();
				title = "Text Editor";
				icontype = IconType.MENTHOR_DOC;	
			}	
			if(editorType.equals(EditorType.ONTOUML_EDITOR)){
				OntoumlEditor ontoumlEd = new OntoumlEditor(tabbedpane.getListener(),tabbedpane, (OntoumlDiagram)content);
				editor = new OntoumlWrapper(ontoumlEd, tabbedpane.getListener());
				ontoumlEd.setWrapper((OntoumlWrapper)editor);
				if(content!=null)title = content.getName();
				icontype = IconType.MENTHOR_DIAGRAM;	
			}	
			if(closable) tabbedpane.addClosableTab(title,icontype, editor);
			else tabbedpane.addNonClosableTab(title, icontype, editor);
//    	}		    	
    	return editor;
    }
    
    public TopTabbedPane editorsPane(){ return topPane; }
}
