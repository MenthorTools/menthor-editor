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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.tinyuml.ui.diagram.DiagramEditor;

import RefOntoUML.util.RefOntoUMLResourceUtil;
import net.menthor.editor.ui.ConstraintEditor;
import net.menthor.editor.ui.DATException;
import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.ProjectReader;
import net.menthor.editor.ui.ProjectWriter;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.ui.StartPage;
import net.menthor.editor.v2.util.Settings;
import net.menthor.editor.v2.util.Util;

public class ProjectManager extends BaseManager {
	
	private static ProjectManager instance = new ProjectManager();
	public static ProjectManager get() { return instance; }
		
	private UmlProject project;
	private File projectFile;
	
	private String lastOpenPath = new String();
	private String lastSavePath = new String();
	private String lastImportPath = new String();
	
	public UmlProject getProject(){ return project; }
	
	public void setProject(UmlProject project){
		this.project = project;
		this.project.setSaveModelNeeded(false);		
		browser.set(this.project, project.getModel());
		infoManager.set(this.project);
		diagramManager.set();
	}
	
	public File getProjectFile(){ return projectFile; }
	
	public File chooseNewFile() throws IOException{
		return Util.chooseFile(diagramManager, null, "New Project", "Menthor Project (*.menthor)", "menthor");
	}
	
	public File chooseOpenFile()throws IOException{
		return Util.chooseFile(diagramManager, lastOpenPath, "Open Project", "Menthor Project (*.menthor)", "menthor");
	}
	
	public File chooseSaveAsFile()throws IOException{
		return Util.chooseFile(diagramManager, lastSavePath, "Save Project As", "Menthor Project (*.menthor)", "menthor");
	}
	
	public File chooseImportFile()throws IOException{
		return Util.chooseFile(diagramManager, lastImportPath, "Import Model Content", "Reference Ontouml (*.refontouml)", "refontouml");
	}
	
	public boolean confirmClose(Component parentWindow){
		 return MessageManager.get().option(parentWindow,
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
		if(createDiagram) AdditionManager.get().newDiagram();
		if(createRulesDocument) AdditionManager.get().newOclDocument();
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
		if(createDefaultDiagram && project.getDiagrams().size()==0) AdditionManager.get().newDiagram();		
		if(createDefaultRules) AdditionManager.get().newOclDocument(oclContent,false);		
		return project;
	}
	
	public UmlProject createProject(RefOntoUML.Package model, List<String> oclContent){		
		project = new UmlProject(model);
		setProject(project);
		if(project.getDiagrams().size()==0) AdditionManager.get().newDiagram();
		for(String str: oclContent) AdditionManager.get().newOclDocument(str,false);		
		return project;
	}
	
	public void closeProject(){					
		if(project!=null && project.isSaveModelNeeded()){ 
			if(confirmClose(diagramManager)) saveProject();							
		}		
		project=null;		
		browser.empty();
		infoManager.empty();		
		diagramManager.empty();
	}
	
	public void openRecentProject(){
		StartPage startPanel = (StartPage) diagramManager.getCurrentEditor();
		if(startPanel != null){
			openProjectFromFile(startPanel.getSelectedRecentFile());
		}
	}
	
	public void saveProject() {
		if (projectFile == null) saveProjectAs();			
		else writeProject(projectFile);
	}
	
	public void newProject(){		
		try {
			File file = chooseNewFile();
			if(file==null) return;
			projectFile = file;
			CursorManager.get().waitCursor();
			closeProject();
			createEmptyProject(false,true);				
			writeProject(file);			
			diagramManager.getFrame().set(file);														
		} catch (Exception ex) {
			MessageManager.get().showError(ex, "New Project", "Could not create new project");
		}		
		CursorManager.get().defaultCursor();
	}	

	@SuppressWarnings("unchecked")
	public void newProject(Object object){
		if(!(object instanceof List<?>)) return;
		List<Object> list = (List<Object>)object;
		RefOntoUML.Package model=null;
		if(list.size()>0) model = (RefOntoUML.Package)list.get(0);		
		if(list.size()>1 && list.get(1) instanceof List<?>){
			createProject(model, (List<String>) list.get(1));
		}
		else if(list.size()>1 && list.get(1) instanceof String){
			createProject(model, (String) list.get(1), true, true);
		} else{
			createProject(model, "",true,true);
		}		
	}
	
	public void openProject(){
		try {
			File file = chooseOpenFile();
			if(file==null) return;
			projectFile = file;
			lastOpenPath = file.getAbsolutePath();
			CursorManager.get().waitCursor();			
			closeProject();
			readProject(projectFile);
			diagramManager.getFrame().set(file);			
		} catch (Exception ex) {
			MessageManager.get().showError(ex, "Open Project", "Could not open existing project");
		}
		CursorManager.get().defaultCursor();
	}
	
	public void openProjectFromFile(String filePath){
		CursorManager.get().waitCursor();
		try {
			closeProject();
			File file = new File(filePath);
			projectFile = file;						
			readProject(projectFile);	
			diagramManager.getFrame().set(file);
		} catch (Exception ex) {
			MessageManager.get().showError(ex, "Open Project", "Could not open existing project from a file path");
		}
		CursorManager.get().defaultCursor();		
	}
	
	public void saveProjectAs(){
		try{
			File file = chooseSaveAsFile();
			if(file==null) return;	
			CursorManager.get().waitCursor();
			projectFile = writeProject(file);			
			lastSavePath = file.getAbsolutePath();
			diagramManager.getFrame().set(projectFile, false);			
		}catch (Exception ex) {
			MessageManager.get().showError(ex, "Save Project As", "Could not save project");
		}		
		CursorManager.get().defaultCursor();
	}
	
	public void importModelContent() {
		try {
			File file = chooseImportFile();		
			if(file==null) return;				
			projectFile = new File(file.getAbsolutePath().replace(".refontouml", ".menthor"));
			lastImportPath = projectFile.getAbsolutePath();
			CursorManager.get().waitCursor();
			closeProject();
			Resource resource = RefOntoUMLResourceUtil.loadModel(file.getAbsolutePath());
			RefOntoUML.Package model = (RefOntoUML.Package)resource.getContents().get(0);
			createProject(model, true, false);
			writeProject(projectFile);
			diagramManager.getFrame().set(projectFile);			
		} catch (Exception ex) {
			MessageManager.get().showError(ex, "Import Model Content", "Project content could not be imported from a Reference Ontouml file.");
		}		
		CursorManager.get().defaultCursor();
	}

	public File writeProject(File file){
		File result = null;
		try {
			project.setVersion(MenthorEditor.MENTHOR_VERSION);		
			if (file.exists()) file.delete();
			for(ConstraintEditor ce: diagramManager.getConstraintEditors()){				
				if(ce!=null) ce.getOclDocument().setContentAsString(ce.getText());
			}
			project.clearOpenedDiagrams();
			for(DiagramEditor editor: diagramManager.getDiagramEditors()){
				project.saveAsOpened(editor.getDiagram());
			}			
			result = ProjectWriter.getInstance().writeProject(diagramManager, file, project, Models.getOclDocList());
			project.setName(file.getName().replace(".menthor",""));
			browser.refresh();
			project.saveAllDiagramNeeded(false);
			diagramManager.getFrame().set(file, false);			
			Settings.addRecentProject(file.getCanonicalPath());
		} catch (Exception ex) {
			MessageManager.get().showError(ex, "Write Project", "Could not serialize current project to a file");
		}				
		return result;
	}
	
	private void readProject(File file) throws IOException, ClassNotFoundException, DATException {
		CursorManager.get().waitCursor();
		ArrayList<Object> listFiles = ProjectReader.getInstance().readProject(file);
		List<OclDocument> ocllist = new ArrayList<OclDocument>();
		for(int i=1; i<listFiles.size();i++){																
			ocllist.add((OclDocument)listFiles.get(i));
		}
		Object o = listFiles.get(0);
		if(o instanceof UmlProject) setProject((UmlProject)o);
		if(o instanceof RefOntoUML.Package) createProject((RefOntoUML.Package)o,true,false);
		diagramManager.getFrame().set(file, false);
		CursorManager.get().defaultCursor();
		Settings.addRecentProject(file.getCanonicalPath());
	}
}
