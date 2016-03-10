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

import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.OntoumlWrapper;
import org.tinyuml.umldraw.OccurenceMap;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.NamedElement;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.element.ProblemElement;
import net.menthor.editor.v2.ui.TabbedAreaUI;
import net.menthor.editor.v2.ui.TabbedAreaUI.TabPositionType;
import net.menthor.editor.v2.ui.TopTabbedPaneUI;
import net.menthor.editor.v2.ui.editor.EditorType;
import net.menthor.editor.v2.ui.editor.ErrorEditor;
import net.menthor.editor.v2.ui.editor.IEditor;
import net.menthor.editor.v2.ui.editor.OclEditor;
import net.menthor.editor.v2.ui.editor.StartEditor;
import net.menthor.editor.v2.ui.editor.TextEditor;
import net.menthor.editor.v2.ui.editor.WarningEditor;

public class TabbedAreaUIController {

	TabbedAreaUI tabbedArea = TabbedAreaUI.get();
	TopTabbedPaneUI editorPane = TabbedAreaUI.get().editorsPane();
		
	// -------- Lazy Initialization

	private static class TabLoader {
        private static final TabbedAreaUIController INSTANCE = new TabbedAreaUIController();
    }	
	public static TabbedAreaUIController get() { 
		return TabLoader.INSTANCE; 
	}	
    private TabbedAreaUIController() {
        if (TabLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------
	
	/** add diagrams recorded as open in the project */
	public void initialize(UmlProject project){
		if(project.isAllClosed() && project.getDiagrams().size()>0){				
			add((StructureDiagram)project.getDiagrams().get(0));
		}else{
			for(OntoumlDiagram diagram: project.getDiagrams()) {
				if(project.isOpened(diagram)){						
					add((StructureDiagram)diagram);
				}
			}
		}		
	}
	
	/** clear the editor tabbed pane */
	public void backToInitialState(){
		tabbedArea.initialState();
		TabbedAreaUIController.get().addWelcome(false);		
		FrameUIController.get().resetFrame();		
	}	
	
	// ----- ocl working text ----
	
	public String getWorkingOclText(){
		String result = new String();
		for(OclDocument oclmodel: ProjectUIController.get().getProject().getOclDocList()){				
			OclEditor ce = getOclEditor(oclmodel);
			if(ce!=null) result+=ce.getText();
			else result+=oclmodel.getContentAsString();
		}
		return result;
	}

	public void saveAllWorkingOclTexts(){
		for(OclEditor ce: getOclEditors()){				
			if(ce!=null) ce.getOclDocument().setContentAsString(ce.getText());
		}
	}
	
	// ----- refresh ----
	
	public void refreshTabTitle(NamedElement item){
		tabbedArea.refreshTitle(item);
	}
	
	// ----- getters ----
	
	public StartEditor getStartEditor(){
		return (StartEditor)tabbedArea.getEditor(EditorType.START_EDITOR);
	}
	
	public IEditor getSelectedTopEditor(){
		return tabbedArea.getSelectedTopEditor();
	}
	
	public OntoumlEditor getSelectedTopOntoumlEditor(){		
		return tabbedArea.getSelectedTopOntoumlEditor();
	}
	
	public OclEditor getSelectedTopOclEditor(){
		return tabbedArea.getSelectedTopOclEditor();
	}
	
	public OntoumlEditor getOntoumlEditor(OntoumlDiagram diagram){		
		return tabbedArea.getOntoumlEditor(diagram);
	}
	
	public List<OntoumlEditor> getOntoumlEditors(List<OntoumlDiagram> diagrams){		
		return tabbedArea.getOntoumlEditors(diagrams);
	}
	
	public List<OntoumlEditor> getOntoumlEditors(){
		return tabbedArea.getOntoumlEditors();
	}
	
	public List<OntoumlDiagram> getDiagrams(){
		return tabbedArea.getDiagrams();
	}
	
	public List<OntoumlEditor> getOntoumlEditors(RefOntoUML.Element element){		
		List<OntoumlDiagram> diagrams = OccurenceMap.get().getDiagrams(element);
		return tabbedArea.getOntoumlEditors(diagrams);	
	}
	
	public OclEditor getOclEditor(OclDocument oclDoc){		
		return tabbedArea.getOclEditor(oclDoc);
	}
	
	public List<OclEditor> getOclEditors(){
		return tabbedArea.getOclEditors();
	}
	
	//----- index -----
	
	public int getIndex(IEditor editor){
		return tabbedArea.getIndex(editor);
	}

	public int getIndex(StructureDiagram diagram){		
		return tabbedArea.getIndex(diagram);
	}
	
	public int getIndex(OclDocument oclDoc){
		return tabbedArea.getIndex(oclDoc);	
	}
	
	public int getIndex(Object obj){
		return tabbedArea.getIndex(obj);
	}
	
	//----- select -----
	
	public Component select(EditorType c){
		return tabbedArea.select(c);
	}
	
	public boolean select(Object obj){
		return tabbedArea.select(obj);
	}
	
	public boolean select(StructureDiagram diagram){		
		return tabbedArea.select(diagram);	
	}
	
	public boolean select(OclDocument oclDoc){		
		return tabbedArea.select(oclDoc);
	}
	
	public boolean select(IEditor editor){		
		return tabbedArea.select(editor);	
	}
	
	//----- check -----
	
	public boolean isOpen(StructureDiagram diagram){
		return tabbedArea.isOpen(diagram);
	}

	public boolean isOpen (OclDocument oclDoc){
		return tabbedArea.isOpen(oclDoc);
	}

	//----- close -----
	
	public void closeEditor(Component editor){
		
		if(editor instanceof OntoumlWrapper){
			editor = ((OntoumlWrapper)editor).getDiagramEditor();
		}
		
		if(editor instanceof OntoumlEditor){
			closeOntoumlEditor((OntoumlEditor) editor);
		}
		else if(editor instanceof OclEditor){
			closeOclEditor((OclEditor) editor);
		}
		else {
			closeTab(editor);
		}
	}
	
	public void closeSelectedOclEditor(){
		closeOclEditor(tabbedArea.getSelectedOclEditor());
	}
	
	public void closeSelectedOntoumlEditor(){
		closeOntoumlEditor(tabbedArea.getSelectedOntoumlEditor());
	}
	
	public void closeOthers(Component c){
		closeMultipleEditors(getSiblingEditors(c, false));
	}
	
	public void closeAll(Component c){
		closeMultipleEditors(getSiblingEditors(c, true));
	}
	
	private void closeMultipleEditors(List<Component> editorList) {
		for (Component editor : editorList) {
			if(!(editor instanceof StartEditor)){
				closeEditor(editor);
			}
		}
	}
	
	private List<Component> getSiblingEditors(Component c, boolean keepInputComponent) {
		List<Component> topEditors = tabbedArea.getTopComponents();
		List<Component> bottomEditors = tabbedArea.getBottomComponents();
		List<Component> siblings = null;
		
		if(topEditors.contains(c)){
			siblings = topEditors;
		}
		else if (bottomEditors.contains(c)){
			siblings = bottomEditors;
		}
		else {	
			siblings = new ArrayList<Component>();
		}
		
		if(!keepInputComponent){
			siblings.remove(c);
		}
		
		return siblings;
	}
	
	private void closeOclEditor(OclEditor editor){
		closeEditor(editor, "Your rules document has been modified. Save changes?");
	}
	
	private void closeOntoumlEditor(OntoumlEditor editor){
		closeEditor(editor, "Your diagram has been modified. Save changes?");
	}
	
	private void closeEditor(IEditor editor, String message) {
		boolean confirmClose = true;
		
		//If the editor needs saving, ask for confirmation
		if(editor !=null && editor.isSaveNeeded()){
			int response = MessageUIController.get().confirm("Save", message);
			
			if(response==0){
				ProjectUIController.get().saveProject();
			}
			if(response==1){
				editor.setSaveNeeded(false);
			}
			
			confirmClose = response==0 || response==1; 
		}
		
		if(editor instanceof OntoumlEditor){
			editor = ((OntoumlEditor) editor).getWrapper();
		}
		
		if(confirmClose) {
			closeTab((Component) editor);
		}
	}
	
	public void closeTab(Component c)	{
		tabbedArea.closeThis(c);
	}
	
	//----- remove -----
	
	public void remove(StructureDiagram diagram){
		tabbedArea.remove(diagram);	
	}
	
	public void remove(OclDocument doc){		
		tabbedArea.remove(doc);	
	}
	
	//----- show -----
	
	public void showConsoleText(String text, boolean clear, boolean forceToShow){	
		tabbedArea.showConsoleText(text, clear, forceToShow);
	}
	
	//----- add -----
	
	public void add(Object obj){
		tabbedArea.add(obj);	
	}
	
	public OclEditor add(OclDocument oclDoc){		
		return tabbedArea.add(oclDoc);				
	}
	
	public OntoumlEditor add(OntoumlDiagram diagram){		
		return tabbedArea.add(diagram);
	}
	
	public List<OntoumlEditor> addAll(List<OntoumlDiagram> diagrams){		
		return tabbedArea.addAll(diagrams);
	}
	
	public StartEditor addWelcome(boolean closable){
		return (StartEditor)tabbedArea.add(TabPositionType.TOP,closable, EditorType.START_EDITOR);
	}
	
	public void addFinder(){
		tabbedArea.add(TabPositionType.TOP,true, EditorType.FINDER_EDITOR);
	}
	
	public void addStatistics() { 
		tabbedArea.add(TabPositionType.TOP,true, EditorType.STATISTICS_EDITOR);
	}
	
	public void addWarnings(String message, List<ProblemElement> warnings){
		IEditor editor = tabbedArea.getEditor(EditorType.WARNING_EDITOR);
		WarningEditor warningsPane = null;
		
		if(editor!=null && editor instanceof WarningEditor){
			warningsPane = (WarningEditor) editor;
		}
		else {
			warningsPane = (WarningEditor)tabbedArea.add(TabPositionType.BOTTOM,true, EditorType.WARNING_EDITOR);
		}
		
		warningsPane.setData(warnings);
		warningsPane.setStatus(message);
	}
	
	public void addErrors(double startTime, double endTime, List<ProblemElement> errors){
		IEditor editor = tabbedArea.getEditor(EditorType.ERRORS_EDITOR);
		ErrorEditor errorPane = null;
		
		if(editor!=null && editor instanceof ErrorEditor){
			errorPane = (ErrorEditor) editor;
		}
		else {
			errorPane = (ErrorEditor)tabbedArea.add(TabPositionType.BOTTOM,true, EditorType.ERRORS_EDITOR);
		}
		
		errorPane.setData(errors);
		errorPane.setStatus(MessageFormat.format("Model verified in {0} ms, {1} error(s) found", (startTime - endTime),  errors.size()));
		
	}
		
	public TextEditor addText(String text){		
		TextEditor textViz = (TextEditor) select(EditorType.TXT_EDITOR);
		if(textViz == null) textViz = (TextEditor)tabbedArea.add(TabPositionType.TOP, true, EditorType.TXT_EDITOR);		
		textViz.setText(text);
		return textViz;
	}
}
