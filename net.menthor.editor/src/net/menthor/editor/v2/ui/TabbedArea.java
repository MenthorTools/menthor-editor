package net.menthor.editor.v2.ui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.OntoumlWrapper;

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
    
    public List<Component> getComponents(){
    	List<Component> result = new ArrayList<Component>();
    	Component[] c1 = bottomPane.getComponents();
    	for(Component c: c1){ result.add(c); }
    	Component[] c2 = topPane.getComponents();
    	for(Component c: c2){ result.add(c); }    	
    	return result;
    }
    
    public void setSelectedComponent(Component c){
    	bottomPane.setSelectedComponent(c);
    	topPane.setSelectedComponent(c);
    }
    
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
	
	public IEditor selectedTopEditor(){
		if(topPane.getSelectedIndex() != -1){
			Object obj = topPane.getSelectedComponent();
			if(obj instanceof IEditor) return (IEditor) obj;	
		}
		return null;
	}
	
	public IEditor selectedTopEditor(EditorType type){				
		IEditor editor = selectedTopEditor();
		if(editor!=null && editor.getEditorType().equals(type)) {
			return editor;
		}
		return null;				
	}
	
	public OclEditor selectedTopOclEditor(){				
		IEditor editor = selectedTopEditor(EditorType.OCL_EDITOR);
		return (OclEditor)editor;						
	}
	
	public OntoumlEditor selectedTopOntoumlEditor(){				
		IEditor editor = selectedTopEditor(EditorType.ONTOUML_EDITOR);
		if(editor instanceof OntoumlWrapper) return ((OntoumlWrapper)editor).getDiagramEditor();
		return null;						
	}
	
	public IEditor selectedBottomEditor(){
		if(bottomPane.getSelectedIndex() != -1){
			Object obj = bottomPane.getSelectedComponent();
			if(obj instanceof IEditor) return (IEditor) obj;	
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
    	Component editor = select(editorType);
    	GenericTabbedPane tabbedpane = bottomPane;
    	if(position.equals(TabPositionType.TOP)) tabbedpane = topPane;
    	String title = "<empty>";
    	IconType icontype = null;
    	if(editor==null){
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
			if(editorType.equals(EditorType.ONTOUML_EDITOR)){
				editor = new OntoumlEditor(tabbedpane.getListener(),tabbedpane, (OntoumlDiagram)content);
				if(content!=null)title = content.getName();
				icontype = IconType.MENTHOR_DIAGRAM;	
			}	
			if(closable) tabbedpane.addClosableTab(title,icontype, editor);
			else tabbedpane.addNonClosableTab(title, icontype, editor);
    	}		    	
    	return editor;
    }
    
    public TopTabbedPane editorsPane(){ return topPane; }
    public BottomTabbedPane infoPane(){ return bottomPane; }
}
