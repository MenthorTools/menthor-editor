package net.menthor.editor.v2.ui.controller;

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

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.OntoumlWrapper;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Element;
import RefOntoUML.NamedElement;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.element.ProblemElement;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.BottomTabbedPane;
import net.menthor.editor.v2.ui.TabbedArea;
import net.menthor.editor.v2.ui.TabbedArea.TabPositionType;
import net.menthor.editor.v2.ui.TopTabbedPane;
import net.menthor.editor.v2.ui.editor.EditorType;
import net.menthor.editor.v2.ui.editor.ErrorEditor;
import net.menthor.editor.v2.ui.editor.IEditor;
import net.menthor.editor.v2.ui.editor.OclEditor;
import net.menthor.editor.v2.ui.editor.StartEditor;
import net.menthor.editor.v2.ui.editor.TextEditor;
import net.menthor.editor.v2.ui.editor.WarningEditor;
import net.menthor.editor.v2.ui.icon.IconType;

public class TabbedAreaController {

	TabbedArea tabbedArea = TabbedArea.get();
	TopTabbedPane editorPane = TabbedArea.get().editorsPane();
	BottomTabbedPane infoPane = TabbedArea.get().infoPane();
	ICommandListener listener = CommandListener.get();
	
	// -------- Lazy Initialization

	private static class TabLoader {
        private static final TabbedAreaController INSTANCE = new TabbedAreaController();
    }	
	public static TabbedAreaController get() { 
		return TabLoader.INSTANCE; 
	}	
    private TabbedAreaController() {
        if (TabLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------
	
	/** add diagrams recorded as open in the project */
	public void initialize(UmlProject project){
		if(project.isAllClosed() && project.getDiagrams().size()>0){				
			addDiagramEditor((StructureDiagram)project.getDiagrams().get(0));
		}else{
			for(OntoumlDiagram diagram: project.getDiagrams()) {
				if(project.isOpened(diagram)){						
					addDiagramEditor((StructureDiagram)diagram);
				}
			}
		}		
	}
	
	/** clear the editor tabbed pane */
	public void backToInitialState(){
		editorPane.removeAll();
		TabbedAreaController.get().addStartEditor(false);
		editorPane.repaint();
		editorPane.revalidate();
		FrameController.get().resetFrame();		
	}	
	
	// ----- getters ----
	
	public StartEditor getStartEditor(){
		return (StartEditor)tabbedArea.getEditor(EditorType.START_EDITOR);
	}
	
	public IEditor selectedTopEditor(){
		return tabbedArea.selectedTopEditor();
	}
	
	public OntoumlEditor selectedTopOntoumlEditor(){		
		return tabbedArea.selectedTopOntoumlEditor();
	}
	
	public OclEditor selectedTopOclEditor(){
		return tabbedArea.selectedTopOclEditor();
	}
	
	public OntoumlEditor getOntoumlEditor(OntoumlDiagram diagram){		
		return tabbedArea.getOntoumlEditor(diagram);
	}
	
	public OclEditor getOclEditor(OclDocument oclDoc){		
		return tabbedArea.getOclEditor(oclDoc);
	}
	
	public List<OclEditor> getOclEditors(){
		return tabbedArea.getOclEditors();
	}
	
	public List<OntoumlEditor> getOntoumlEditors(){
		return tabbedArea.getOntoumlEditors();
	}
		
	public List<OntoumlDiagram> getDiagrams(){
		return tabbedArea.getDiagrams();
	}
	
	public String getConstraints(){
		String result = new String();
		for(OclDocument oclmodel: ProjectManager.get().getProject().getOclDocList()){				
			OclEditor ce = TabbedAreaController.get().getOclEditor(oclmodel);
			if(ce!=null) result+=ce.getText();
			else result+=oclmodel.getContentAsString();
		}
		return result;
	}
		
	//----- index -----
	
	public int getEditorIndex(IEditor editor){
		if(editor instanceof OntoumlEditor) return editorPane.indexOfComponent(((OntoumlEditor)editor).getWrapper());
		else return editorPane.indexOfComponent((Component)editor);
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
		for(Component c: editorPane.getComponents()){
			if(c instanceof OntoumlWrapper) {
				if (((OntoumlWrapper)c).getDiagramEditor().getDiagram().equals(diagram))
					return editorPane.indexOfComponent(c);
			}
		}
		return -1;
	}
	
	public int getEditorIndex(OclDocument oclDoc){
		for(Component c: editorPane.getComponents()){
			if(c instanceof OclEditor) {
				if (((OclEditor)c).getOclDocument().equals(oclDoc))
					return editorPane.indexOfComponent(c);
			}
		}
		return -1;		
	}
	
	//----- select -----
	
	public boolean selectEditor(Object obj){
		for(Component c: editorPane.getComponents()){
			if(c.equals(obj)) {
				editorPane.setSelectedComponent(c);
				return true;
			}
			if(c instanceof OntoumlWrapper) {
				if(((OntoumlWrapper) c).getDiagramEditor().getDiagram().equals(obj)) {
					editorPane.setSelectedComponent(c);
					return true;
				}
			}			
			if(c instanceof OclEditor) {
				if(((OclEditor) c).getOclDocument().equals(obj)) {
					editorPane.setSelectedComponent(c);	
					return true;
				}
			}
		}	
		return false;
	}
	
	public void selectEditor(StructureDiagram diagram){		
		for(Component c: editorPane.getComponents()){
			if(c instanceof OntoumlWrapper) {
				if(((OntoumlWrapper) c).getDiagramEditor().getDiagram().equals(diagram)) editorPane.setSelectedComponent(c);
			}
		}		
	}
	
	public boolean selectEditor(OclDocument oclDoc){		
		for(Component c: editorPane.getComponents()){
			if(c instanceof OclEditor && ((OclEditor) c).getOclDocument().equals(oclDoc)) {
				editorPane.setSelectedComponent(c);
				return true;
			}
		}
		return false;
	}
	
	public void selectEditor(IEditor editor){		
		for(Component c: editorPane.getComponents()){
			if(c instanceof OntoumlWrapper) {
				if(((OntoumlWrapper) c).getDiagramEditor().equals(editor)) editorPane.setSelectedComponent(c);
			}else{
				if(c.equals(editor)) editorPane.setSelectedComponent(c);
			}
		}		
	}
	
	
	//----- check -----
	
	public boolean isEditorOpen(StructureDiagram diagram){
		for(Component c: editorPane.getComponents())
			if (c instanceof OntoumlWrapper)
				if (((OntoumlWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) return true;
		return false;
	}

	public boolean isEditorOpen (OclDocument oclDoc){
		for(Component c: editorPane.getComponents())
			if (c instanceof OclEditor)
				if (((OclEditor)c).getOclDocument().equals(oclDoc)) return true;
		return false;
	}

	//----- close -----
	
	public void closeCurrentOclEditor(){
		IEditor editor = selectedTopOclEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				boolean response = MessageController.get().confirm("Save", 
				"Your rules document has been modified. Save changes?");
				if(response) { 
					ProjectManager.get().saveProject(); 
				}else{ 
					return;
				}
			}			
			editorPane.closeThis(getEditorIndex(((OclEditor)editor).getOclDocument()));
		}
	}
	
	public void closeCurrentDiagramEditor(){
		IEditor editor = selectedTopOntoumlEditor();
		if(editor!=null){
			if(editor.isSaveNeeded()){
				boolean response = MessageController.get().confirm("Save", 
				"Your diagram has been modified. Save changes?");
				if(response) { 
					ProjectManager.get().saveProject(); 
				}else{ 
					return; 
				}				
			}			
			editorPane.closeThis(getEditorIndex(((OntoumlEditor)editor).getDiagram()));
		}
	}
	
	//----- remove -----
	
	public void removeEditor(StructureDiagram diagram){
		for(Component c: editorPane.getComponents()){
			if (c instanceof OntoumlWrapper){
				if (((OntoumlWrapper)c).getDiagramEditor().getDiagram().equals(diagram)) editorPane.remove(c);
			}
		}		
	}
	
	public void removeEditor(OclDocument doc){		
		for(Component c: editorPane.getComponents()){
			if (c instanceof OclEditor){
				if (((OclEditor)c).getOclDocument().equals(doc)) editorPane.remove(c);
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
		OntoumlEditor editor = new OntoumlEditor(listener, editorPane, diagram);	
		OccurenceManager.get().add(editor.getDiagram());
		OntoumlWrapper wrapper = new OntoumlWrapper(editor, listener);
		editor.setWrapper(wrapper);
		editorPane.addClosableTab(((StructureDiagram)diagram).getLabelText(),IconType.MENTHOR_DIAGRAM, wrapper);		
		return editor;
	}
	
	public List<OntoumlEditor> addDiagramEditors(List<OntoumlDiagram> diagrams){		
		List<Component> added = tabbedArea.addAll(TabPositionType.TOP, true, EditorType.ONTOUML_EDITOR, diagrams);
		List<OntoumlEditor> result = new ArrayList<OntoumlEditor>();
		for(Component c: added) {
			if(c!=null) result.add((OntoumlEditor)c);
		}
		return result;
	}
	
	public OclEditor addOclEditor(OclDocument oclDoc){		
		return (OclEditor)tabbedArea.add(TabPositionType.TOP, true, EditorType.OCL_EDITOR,oclDoc);				
	}
	
	public StartEditor addStartEditor(boolean closable){
		return (StartEditor)tabbedArea.add(TabPositionType.TOP,closable, EditorType.START_EDITOR);
	}
	
	public void addFinderEditor(){
		tabbedArea.add(TabPositionType.TOP,true, EditorType.FINDER_EDITOR);
	}
	
	public void closeThis(Component c)	{
		tabbedArea.closeThis(c);
	}
	
	public void closeOthers(Component c){
		tabbedArea.closeOthers(c);
	}
	
	public void closeAll(Component c){
		tabbedArea.closeAll(c);
	}

	public Component select(EditorType c){
		return tabbedArea.select(c);
	}
	
	public void addStatisticsEditor() { 
		tabbedArea.add(TabPositionType.TOP,true, EditorType.STATISTICS_EDITOR);
	}
	
	public void addWarningsEditor(String message, List<ProblemElement> warnings){
		WarningEditor warningsPane = (WarningEditor)tabbedArea.add(TabPositionType.BOTTOM,true, EditorType.WARNING_EDITOR);
		warningsPane.setData(warnings);
		warningsPane.setStatus(message);
	}
	
	public void addErrorsEditor(double startTime, double endTime, List<ProblemElement> errors){
		ErrorEditor errorPane = (ErrorEditor)tabbedArea.add(TabPositionType.BOTTOM,true, EditorType.ERRORS_EDITOR);
		errorPane.setData(errors);
		errorPane.setStatus(MessageFormat.format("Model verified in {0} ms, {1} error(s) found", (startTime - endTime),  errors.size()));
	}
		
	public TextEditor addTextEditor(String content){
		TextEditor textViz = (TextEditor) TabbedAreaController.get().select(EditorType.TXT_EDITOR);
		if(textViz == null){
			textViz = new TextEditor();
			editorPane.addClosableTab("Text Editor", IconType.MENTHOR_DOC,textViz);
		}else{
			editorPane.setSelectedComponent(textViz);
		}
		textViz.setText(content);
		return textViz;
	}
	
	//---- show text -----
	
	public void showOutputInfo(String text, boolean clear, boolean showOutput){	
		infoPane.showOutput(text, clear, showOutput);
		tabbedArea.select(EditorType.CONSOLE_EDITOR);
	}
	
	//----- open -------
	
	public DiagramElement openedInADiagram(Element element){
		for(DiagramElement de: OccurenceManager.get().getDiagramElements(element)){
			for(OntoumlDiagram d: getDiagrams()){
				if(((StructureDiagram)d).getChildren().contains(de)) return de;				
			}
		}
		return null;
	}
	
	/** get diagram editors */
	public List<OntoumlEditor> getDiagramEditors(RefOntoUML.Element element){
		List<OntoumlEditor> list = new ArrayList<OntoumlEditor>();
		List<OntoumlDiagram> diagrams = OccurenceManager.get().getDiagrams(element);
		for(OntoumlDiagram diagram: diagrams){			
			OntoumlEditor editor = getOntoumlEditor((StructureDiagram)diagram);
			list.add(editor);			
		}
		return list;
	}
	
	public void saveOclContents(){
		for(OclEditor ce: getOclEditors()){				
			if(ce!=null) ce.getOclDocument().setContentAsString(ce.getText());
		}
	}
	
	//----- ------
	// Item is the OCLDocument or StructureDigram used to identify the tab that needs renaming.
	public void refreshTabTitle(NamedElement item){
		int index = getEditorIndex(item);		
		if(index>=0){ 
			TopTabbedPane.get().setTitleAt(index, item.getName());			        
		}		
		TopTabbedPane.get().updateUI();
	}
}
