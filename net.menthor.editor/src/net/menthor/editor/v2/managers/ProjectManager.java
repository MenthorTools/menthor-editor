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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipException;

import org.eclipse.emf.ecore.resource.Resource;
import org.tinyuml.ui.diagram.OntoumlEditor;

import RefOntoUML.util.RefOntoUMLResourceUtil;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.MenthorEditor;
import net.menthor.editor.v2.commanders.AddCommander;
import net.menthor.editor.v2.ui.controller.BrowserController;
import net.menthor.editor.v2.ui.controller.CursorController;
import net.menthor.editor.v2.ui.controller.FrameController;
import net.menthor.editor.v2.ui.controller.MessageController;
import net.menthor.editor.v2.ui.controller.TabbedAreaController;
import net.menthor.editor.v2.ui.editor.StartEditor;
import net.menthor.editor.v2.util.Settings;
import net.menthor.editor.v2.util.Util;

public class ProjectManager extends AbstractManager {
	
	// -------- Lazy Initialization

	private static class ProjectLoader {
        private static final ProjectManager INSTANCE = new ProjectManager();
    }	
	public static ProjectManager get() { 
		return ProjectLoader.INSTANCE; 
	}	
    private ProjectManager() {
        if (ProjectLoader.INSTANCE != null) throw new IllegalStateException("ProjectManager already instantiated");
    }		
    
    // ----------------------------
		
	private UmlProject project;
	private File projectFile;
	
	private String lastOpenPath = new String();
	private String lastSavePath = new String();
	private String lastImportPath = new String();
	
	public UmlProject getProject(){ return project; }
	
	public void setProject(UmlProject project){
		this.project = project;
		this.project.setSaveModelNeeded(false);
		//register elements
		OccurenceManager.get().addAll(project.getDiagrams());
		//initialize GUI
		BrowserController.get().initialize(project, listener());		
		TabbedAreaController.get().initialize(project);		
	}
	
	public File getProjectFile(){ return projectFile; }
	
	public File chooseNewFile() throws IOException{
		return Util.chooseFile(frame(), null, "New Project", "Menthor Project (*.menthor)", "menthor",true);
	}
	
	public File chooseOpenFile()throws IOException{
		return Util.chooseFile(frame(), lastOpenPath, "Open Project", "Menthor Project (*.menthor)", "menthor",false);
	}
	
	public File chooseSaveAsFile()throws IOException{
		return Util.chooseFile(frame(), lastSavePath, "Save Project As", "Menthor Project (*.menthor)", "menthor",true);
	}
	
	public File chooseImportFile()throws IOException{
		return Util.chooseFile(frame(), lastImportPath, "Import Model Content", "Reference Ontouml (*.refontouml)", "refontouml",false);
	}
	
	public boolean confirmClose(Component parentWindow){
		 return MessageController.get().option(parentWindow,
			"Close Project",
			"Do you really want to close the current project?",
			new String[]{"Save and Close", "Close", "Cancel"}
		);
	}
	
	public void createEmptyProject(){
		createEmptyProject(true,true);
	}

	public void createEmptyProject(boolean createRulesDocument, boolean createDiagram){
		project = new UmlProject();
		setProject(project);		
		if(createDiagram) AddCommander.get().newDiagram();
		if(createRulesDocument) AddCommander.get().newOclDocument();
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
		if(createDefaultDiagram && project.getDiagrams().size()==0) AddCommander.get().newDiagram();		
		if(createDefaultRules) AddCommander.get().newOclDocument(oclContent,false);		
		return project;
	}
	
	public UmlProject createProject(RefOntoUML.Package model, List<String> oclContent){		
		project = new UmlProject(model);
		setProject(project);
		if(project.getDiagrams().size()==0) AddCommander.get().newDiagram();
		for(String str: oclContent) AddCommander.get().newOclDocument(str,false);		
		return project;
	}
	
	public void closeProject(){					
		if(project!=null && project.isSaveModelNeeded()){ 
			if(confirmClose(frame())) saveProject();							
		}		
		project=null;
		infoPane().emptyOutput();		
		TabbedAreaController.get().backToInitialState();
	}
	
	public void openRecentProject(){
		StartEditor startPanel = (StartEditor) TabbedAreaController.get().selectedTopEditor();
		if(startPanel != null){
			openProjectFromFile(startPanel.getSelectedRecentFile());
		}
	}
	
	public void saveProject() {
		if (projectFile == null) saveProjectAs();			
		else serializeProject(projectFile);
	}
	
	public void newProject(){		
		try {
			File file = chooseNewFile();
			if(file==null) return;
			projectFile = file;
			CursorController.get().waitCursor();
			closeProject();
			createEmptyProject(false,true);				
			serializeProject(file);			
			FrameController.get().initializeFrame(file);														
		} catch (Exception ex) {
			MessageController.get().showError(ex, "New Project", "Could not create new project");
		}		
		CursorController.get().defaultCursor();
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
		
		splitPane().forceDefaultState();
	}
	
	public void openProject(){
		try {
			File file = chooseOpenFile();
			if(file==null) return;
			projectFile = file;
			lastOpenPath = file.getAbsolutePath();
			CursorController.get().waitCursor();			
			closeProject();
			deserializeProject(projectFile);
			FrameController.get().initializeFrame(file);			
		} catch (Exception ex) {
			MessageController.get().showError(ex, "Open Project", "Could not open existing project");
		}
		CursorController.get().defaultCursor();
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
		CursorController.get().waitCursor();
		try {
			closeProject();
			File file = new File(filePath);
			projectFile = file;						
			deserializeProject(projectFile);	
			FrameController.get().initializeFrame(file);
		} catch (Exception ex) {
			MessageController.get().showError(ex, "Open Project", "Could not open existing project from a file path");
		}
		CursorController.get().defaultCursor();		
	}
	
	public void saveProjectAs(){
		try{
			File file = chooseSaveAsFile();
			if(file==null) return;	
			CursorController.get().waitCursor();
			projectFile = serializeProject(file);			
			lastSavePath = file.getAbsolutePath();
			FrameController.get().initializeFrame(projectFile, false);			
		}catch (Exception ex) {
			MessageController.get().showError(ex, "Save Project As", "Could not save project");
		}		
		CursorController.get().defaultCursor();
	}
	
	public void importModelContent() {
		try {
			File file = chooseImportFile();		
			if(file==null) return;				
			projectFile = new File(file.getAbsolutePath().replace(".refontouml", ".menthor"));
			lastImportPath = projectFile.getAbsolutePath();
			CursorController.get().waitCursor();
			closeProject();
			Resource resource = RefOntoUMLResourceUtil.loadModel(file.getAbsolutePath());
			RefOntoUML.Package model = (RefOntoUML.Package)resource.getContents().get(0);
			createProject(model, true, false);
			serializeProject(projectFile);
			FrameController.get().initializeFrame(projectFile);			
		} catch (Exception ex) {
			MessageController.get().showError(ex, "Import Model Content", "Project content could not be imported from a Reference Ontouml file.");
		}		
		CursorController.get().defaultCursor();
	}

	/**serialize project */
	public File serializeProject(File file){
		File result = null;
		try {
			project.setVersion(MenthorEditor.MENTHOR_VERSION);		
			if (file.exists()) file.delete();
			TabbedAreaController.get().saveAllWorkingOclTexts();				
			project.clearOpenedDiagrams();
			for(OntoumlEditor editor: TabbedAreaController.get().getOntoumlEditors()){
				project.saveAsOpened(editor.getDiagram());
			}			
			result = SerializationManager.get().serializeMenthorFile(file, project, project.getOclDocList());
			project.setName(file.getName().replace(".menthor",""));
			browser().getTree().updateUI();
			project.saveAllDiagramNeeded(false);
			FrameController.get().initializeFrame(file, false);			
			Settings.addRecentProject(file.getCanonicalPath());
		} catch (Exception ex) {
			MessageController.get().showError(ex, "Write Project", "Could not serialize current project to a file");
		}				
		return result;
	}
	
	/**deserialize project 
	 * @throws IOException 
	 * @throws ZipException */
	public void deserializeProject(File file) throws ZipException, IOException {
		CursorController.get().waitCursor();

		setProject(DeserializationManager.get().deserializeMenthorFile(file));
			
		FrameController.get().initializeFrame(file, false);
		CursorController.get().defaultCursor();
		Settings.addRecentProject(file.getCanonicalPath());
	}
}
