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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipException;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.resource.Resource;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.OccurenceMap;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Package;
import RefOntoUML.util.RefOntoUMLResourceUtil;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.ui.FrameUI;
import net.menthor.editor.v2.ui.MenthorEditor;
import net.menthor.editor.v2.ui.editor.StartEditor;
import net.menthor.editor.v2.util.DeserializationUtil;
import net.menthor.editor.v2.util.SerializationUtil;
import net.menthor.editor.v2.util.SettingsUtil;
import net.menthor.editor.v2.util.Util;

public class ProjectUIController {
	
	FrameUI frame = FrameUI.get();
	UmlProject project;
	File projectFile;
	
	// -------- Lazy Initialization

	private static class ProjectLoader {
        private static final ProjectUIController INSTANCE = new ProjectUIController();
    }	
	public static ProjectUIController get() { 
		return ProjectLoader.INSTANCE; 
	}	
    private ProjectUIController() {
        if (ProjectLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------
		
	private String lastOpenPath = new String();
	private String lastSavePath = new String();
	private String lastImportPath = new String();
	
	public UmlProject getProject(){ return project; }
	
	public void setProject(UmlProject project){
		this.project = project;
		this.project.setVersion(MenthorEditor.MENTHOR_VERSION);
		this.project.setSaveModelNeeded(false);
		//register elements
		OccurenceMap.get().addAll(project.getDiagrams());
		//initialize GUI
		BrowserUIController.get().initialize(project);		
		TabbedAreaUIController.get().initialize(project);		
	}
	
	public void saveProjectDataBeforeSerialize(){
		TabbedAreaUIController.get().saveAllWorkingOclTexts();
		if (projectFile.exists()) projectFile.delete();
		this.project.clearOpenedDiagrams();
		for(OntoumlEditor editor: TabbedAreaUIController.get().getOntoumlEditors()){
			this.project.saveAsOpened(editor.getDiagram());
		}
		String name = projectFile.getName().replace(".menthor","");
		this.project.setName(name);			
		this.project.saveAllDiagramNeeded(false);
	}
	
	public File getProjectFile(){ return projectFile; }
	
	public File chooseNewFile() throws IOException{
		return Util.chooseFile(frame, null, "New Project", "Menthor Project (*.menthor)", "menthor",true);
	}
	
	public File chooseOpenFile()throws IOException{
		return Util.chooseFile(frame, lastOpenPath, "Open Project", "Menthor Project (*.menthor)", "menthor",false);
	}
	
	public File chooseSaveAsFile()throws IOException{
		return Util.chooseFile(frame, lastSavePath, "Save Project As", "Menthor Project (*.menthor)", "menthor",true);
	}
	
	public File chooseImportFile()throws IOException{
		return Util.chooseFile(frame, lastImportPath, "Import Model Content", "Reference Ontouml (*.refontouml)", "refontouml",false);
	}
	
	public boolean confirmClose(Component parentWindow){
		 return MessageUIController.get().option(parentWindow,
			"Close Project",
			"Do you really want to close the current project?",
			new String[]{"Save and Close", "Close", "Cancel"}
		);
	}
	
	public void addOclDocument(){
		addOclDocument(null, false);		
	}
	
	public OclDocument addOclDocument(String oclcontent, boolean createTab){
		OclDocument oclDoc = new OclDocument();
		Package pack = (Package) (BrowserUIController.get().root()).getUserObject();
		oclDoc.setContainer(pack);		
		if(oclcontent!=null) oclDoc.setContentAsString(oclcontent);
		oclDoc.setName("OclDocument"+project.getOclDocList().size());		
		project.getOclDocList().add(oclDoc);				
		if(createTab) TabbedAreaUIController.get().add(oclDoc);
		return oclDoc;
	}
	
	public void addOclDocument(Object treeNode){
		OclDocument oclDoc = addOclDocument("", false);
		if(treeNode==null || !(treeNode instanceof DefaultMutableTreeNode) || 
		!(((DefaultMutableTreeNode)treeNode).getUserObject() instanceof Package)){
			treeNode = BrowserUIController.get().root();
		}
		BrowserUIController.get().add((DefaultMutableTreeNode)treeNode, oclDoc);
	}	
	
	public StructureDiagram addDiagram(){
		StructureDiagram diagram = new StructureDiagram(project);		
		Package epackage = (Package) (BrowserUIController.get().root()).getUserObject();
		diagram.setContainer(epackage);		
		setDefaultDiagramSize(diagram);
		diagram.setLabelText("Diagram"+project.getDiagrams().size());
		project.addDiagram(diagram);
		project.saveDiagramNeeded(diagram,false);
		TabbedAreaUIController.get().add(diagram);
		return diagram;
	}

	private void setDefaultDiagramSize(StructureDiagram diagram){
		double waste = 0;
		if(SplitPaneUIController.get().isShowProjectBrowser()) waste+=240;
		if(SplitPaneUIController.get().isShowPalette()) waste+=240;
		diagram.setSize((Util.getScreenWorkingWidth()-waste+100)*3, (Util.getScreenWorkingHeight()-100)*3);
	}
	
	public void addDiagram(Object treeNode){
		StructureDiagram diagram = addDiagram();
		if(treeNode==null || !(treeNode instanceof DefaultMutableTreeNode) || !(((DefaultMutableTreeNode)treeNode).getUserObject() instanceof Package)){
			treeNode = BrowserUIController.get().root();
		}		
		if(treeNode!=null) BrowserUIController.get().add((DefaultMutableTreeNode)treeNode,diagram);
	}
	
	public void createEmptyProject(){
		createEmptyProject(true,true);
	}

	public void createEmptyProject(boolean createRulesDocument, boolean createDiagram){
		project = new UmlProject();
		setProject(project);		
		if(createDiagram) addDiagram();
		if(createRulesDocument) addOclDocument();
	}
	
	public UmlProject createProject(RefOntoUML.Package model, String oclContent){		
		return createProject(model,oclContent,true,true);
	}
	
	public UmlProject createProject(RefOntoUML.Package model, boolean createDefaultDiagram, boolean createDefaultRules){	
		return createProject(model,"", createDefaultDiagram, createDefaultRules);
	}
	
	public UmlProject createProject(RefOntoUML.Package model){		
		return createProject(model,"");
	}
	
	public UmlProject createProject(RefOntoUML.Package model, String oclContent, boolean createDefaultDiagram, boolean createDefaultRules){		
		project = new UmlProject(model);
		setProject(project);
		if(createDefaultDiagram && project.getDiagrams().size()==0) addDiagram();		
		if(createDefaultRules) addOclDocument(oclContent,false);		
		return project;
	}
	
	public UmlProject createProject(RefOntoUML.Package model, List<String> oclContent){		
		project = new UmlProject(model);
		setProject(project);
		if(project.getDiagrams().size()==0) addDiagram();
		for(String str: oclContent) addOclDocument(str,false);		
		return project;
	}
	
	public void closeProject(){					
		if(project!=null && project.isSaveModelNeeded()){ 
			if(confirmClose(frame)) saveProject();							
		}		
		project=null;				
		TabbedAreaUIController.get().backToInitialState();
	}
	
	public void openRecentProject(){
		StartEditor startPanel = (StartEditor) TabbedAreaUIController.get().getSelectedTopEditor();
		if(startPanel != null){
			openProjectFromFile(startPanel.getSelectedRecentFile());
		}
	}
	
	public void saveProject() {
		if (projectFile == null) saveProjectAs();			
		else serializeProject();
	}
	
	public void newProject(){		
		try {
			File file = chooseNewFile();
			if(file==null) return;
			projectFile = file;
			CursorUIController.get().waitCursor();
			closeProject();
			createEmptyProject(false,true);				
			serializeProject();			
			FrameUIController.get().initializeFrame(file);														
		} catch (Exception ex) {
			MessageUIController.get().showError(ex, "New Project", "Could not create new project");
		}		
		CursorUIController.get().defaultCursor();
	}	

	@SuppressWarnings("unchecked")
	public void newProject(Object object){
		if(!(object instanceof List<?>)) return;
		List<Object> list = (List<Object>)object;
		RefOntoUML.Package model=null;
		if(list.size()>0) model = (RefOntoUML.Package)list.get(0);		
		
		if(list.size()>1 && list.get(1) instanceof List<?>){
			createProject(model, (List<String>) list.get(1));
		}else if(list.size()>1 && list.get(1) instanceof String){
			createProject(model, (String) list.get(1), true, true);
		}else{
			createProject(model, "",true,true);
		}
		
		SplitPaneUIController.get().forceDefaultState();
	}
	
	public void openProject(){
		try {
			File file = chooseOpenFile();
			if(file==null) return;
			projectFile = file;
			lastOpenPath = file.getAbsolutePath();
			CursorUIController.get().waitCursor();			
			closeProject();
			deserializeProject();
			FrameUIController.get().initializeFrame(file);			
		} catch (Exception ex) {
			MessageUIController.get().showError(ex, "Open Project", "Could not open existing project");
		}
		CursorUIController.get().defaultCursor();
	}
	
	public void openProjectFromArgs(String[] args){		
		String fileName = "";
		for (String arg : args){
			if(arg.endsWith(".menthor")){
				fileName  = arg;
				break;
			}
		}
		if(!fileName.equals("")){						
			openProjectFromFile(fileName);
		}
	}
	
	public void openProjectFromFile(String filePath){
		CursorUIController.get().waitCursor();
		try {
			closeProject();
			File file = new File(filePath);
			projectFile = file;						
			deserializeProject();	
			FrameUIController.get().initializeFrame(file);
		} catch (Exception ex) {
			MessageUIController.get().showError(ex, "Open Project", "Could not open existing project from a file path");
		}
		CursorUIController.get().defaultCursor();		
	}
	
	public void saveProjectAs(){
		try{
			File file = chooseSaveAsFile();
			if(file==null) return;	
			CursorUIController.get().waitCursor();
			projectFile = file;
			serializeProject();
			lastSavePath = file.getAbsolutePath();
			FrameUIController.get().initializeFrame(projectFile, false);			
		}catch (Exception ex) {
			MessageUIController.get().showError(ex, "Save Project As", "Could not save project");
		}		
		CursorUIController.get().defaultCursor();
	}
	
	public void importModelContent() {
		try {
			File file = chooseImportFile();		
			if(file==null) return;				
			projectFile = new File(file.getAbsolutePath().replace(".refontouml", ".menthor"));
			lastImportPath = projectFile.getAbsolutePath();
			CursorUIController.get().waitCursor();
			closeProject();
			Resource resource = RefOntoUMLResourceUtil.loadModel(file.getAbsolutePath());
			RefOntoUML.Package model = (RefOntoUML.Package)resource.getContents().get(0);
			createProject(model, true, false);
			serializeProject();
			FrameUIController.get().initializeFrame(projectFile);			
		} catch (Exception ex) {
			MessageUIController.get().showError(ex, "Import Model Content", "Project content could not be imported from a Reference Ontouml file.");
		}		
		CursorUIController.get().defaultCursor();
	}

	public File serializeProject(){
		File result = null;
		try {
			CursorUIController.get().waitCursor();						
			saveProjectDataBeforeSerialize();
			result = SerializationUtil.get().serializeMenthorFile(projectFile, project, project.getOclDocList());
			SettingsUtil.addRecentProject(projectFile.getCanonicalPath());
			BrowserUIController.get().updateUI();
			FrameUIController.get().initializeFrame(projectFile, false);			
			CursorUIController.get().defaultCursor();		
		} catch (Exception ex) {
			MessageUIController.get().showError(ex, "Write Project", "Could not serialize current project to a file");
		}				
		return result;
	}

	public void deserializeProject() throws ZipException, IOException {
		CursorUIController.get().waitCursor();
		UmlProject project = DeserializationUtil.get().deserialize(projectFile);
		setProject(project);			
		SettingsUtil.addRecentProject(projectFile.getCanonicalPath());
		FrameUIController.get().initializeFrame(projectFile, false);
		CursorUIController.get().defaultCursor();		
	}
}
