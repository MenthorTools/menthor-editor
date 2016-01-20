package net.menthor.editor.v2.managers;

import java.awt.Component;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.umldraw.StructureDiagram;

import net.menthor.editor.ui.ConstraintEditor;
import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.ProjectReader;
import net.menthor.editor.ui.ProjectWriter;
import net.menthor.editor.ui.UmlProject;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.ui.StartPage;
import net.menthor.editor.v2.util.MenthorResourceFactoryImpl;
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
	public File getProjectFile(){ return projectFile; }
	
	public int confirmProjectClose(Component parentWindow){
		 return JOptionPane.showOptionDialog(parentWindow,
			"Do you really want to close the current project?",
			"Project Manager - Close", 
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			new String[]{"Save and Close", "Close", "Cancel"},
			"default"
		);	
	}
	
	public void createEmptyProject(){
		createEmptyProject(true,true);
	}

	public void createEmptyProject(boolean createRulesDocument, boolean createDiagram){
		project = new UmlProject();
		project.setSaveModelNeeded(false);
		browser.set(project, project.getModel());
		infoManager.setProject(project);
		if(createDiagram) diagramManager.newDiagram(project,null);
		if(createRulesDocument) diagramManager.newRulesDocument(null,false);
	}
	
	public UmlProject createProject(RefOntoUML.Package model, String oclContent){		
		return createProject(model,oclContent,true,true);
	}
	
	public UmlProject createProject(RefOntoUML.Package model, boolean createDefaultDiagram, boolean createDefaultRules){	
		return createProject(model,"", createDefaultDiagram,createDefaultRules);
	}
	
	public UmlProject createProject(RefOntoUML.Package model){		
		return createProject(model,"");
	}
	
	public void openRecentProject(){
		StartPage startPanel = (StartPage) diagramManager.getCurrentEditor();
		if(startPanel != null){
			openProject(startPanel.getSelectedRecentFile());
		}
	}
	
	public UmlProject createProject(RefOntoUML.Package model, String oclContent, boolean createDefaultDiagram, boolean createDefaultRules){		
		project = new UmlProject(model);		
		project.setSaveModelNeeded(false);		
		browser.set(project, model);
		infoManager.setProject(project);			
		for(OntoumlDiagram diagram: project.getDiagrams()) {
			diagramManager.createDiagramEditor((StructureDiagram)diagram);
		}		
		if(createDefaultDiagram){
			if(project.getDiagrams().size()==0)  diagramManager.newDiagram(project,null);
		}		
		if(createDefaultRules){
			diagramManager.newRulesDocument(oclContent,false);
		}		
		return project;
	}
	
	public UmlProject createProject(RefOntoUML.Package model, List<String> oclContent){		
		project = new UmlProject(model);		
		project.setSaveModelNeeded(false);		
		browser.set(project, model);
		infoManager.setProject(project);		
		for(OntoumlDiagram diagram: project.getDiagrams()){ 
			diagramManager.createDiagramEditor((StructureDiagram)diagram);
		}
		if(project.getDiagrams().size()==0){ 
			diagramManager.newDiagram(project,null);
		}
		for(String str: oclContent){
			diagramManager.newRulesDocument(str,false);
		}		
		return project;
	}
	
	public void closeProject(){
		if (project==null) return;			
		if(project.isSaveModelNeeded()){
			int response = confirmProjectClose(diagramManager);
			if(response==JOptionPane.YES_OPTION){
				diagramManager.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				saveProject();
				diagramManager.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));			
			}
		}		
		diagramManager.removeAll();
		diagramManager.getFrame().setTitle("Menthor Editor");	
		browser.clear();
		infoManager.eraseProject();										
		project=null;				
		diagramManager.addStartPanel(diagramManager,false);
		diagramManager.getFrame().showOnlyStartPage();
		diagramManager.getFrame().getMainMenu().disactivateSomeToBegin();			
		diagramManager.repaint();
		diagramManager.revalidate();
	}
	
	public void saveProject(){
		if (projectFile == null){
			int option = saveProjectAs();
			if (option!=JFileChooser.APPROVE_OPTION){
				diagramManager.repaint();
				diagramManager.revalidate();				
				return;
			}
		}else{
			saveProjectToFile(projectFile);
		}
		diagramManager.repaint();
		diagramManager.revalidate();
	}
	
	/** Save current Project to a file *.menthor */
	public File saveProjectToFile(File file){		
		project.setVersion(MenthorEditor.MENTHOR_VERSION);
		diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		if (file.exists()) file.delete();
		File result = null;
		try {
			if(!file.getName().endsWith(".menthor")) {
				file = new File(file.getCanonicalFile() + ".menthor");
			}						
			for(ConstraintEditor ce: diagramManager.getConstraintEditors()){				
				if(ce!=null) ce.getOclDocument().setContentAsString(ce.getText());
			}
			project.clearOpenedDiagrams();
			for(DiagramEditor editor: diagramManager.getDiagramEditors()){
				project.saveAsOpened(editor.getDiagram());
			}			
			result = ProjectWriter.getInstance().writeProject(diagramManager, file, project, Models.getOclDocList());		
			Settings.addRecentProject(file.getCanonicalPath());
			project.setName(file.getName().replace(".menthor",""));
			browser.refresh();
			diagramManager.saveAllDiagramNeeded(false);
			diagramManager.getFrame().setTitle(file.getName().replace(".menthor","")+" - Menthor Editor");
			diagramManager.invalidate();
			diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		} catch (Exception ex) {
			System.out.println("Failed to save Menthor project!");
			ex.printStackTrace();
			JOptionPane.showMessageDialog(diagramManager, ex.getMessage(), "Save Project", JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Menthor project successfully saved!");
		return result;
	}
	
	public int saveProjectAs(){
		JFileChooser fileChooser = new JFileChooser(lastSavePath){
			private static final long serialVersionUID = 1L;
			@Override
		    public void approveSelection(){
		        File f = getSelectedFile();
		        if(f.exists() && getDialogType() == SAVE_DIALOG){
		            int result = JOptionPane.showConfirmDialog(this, "\""+f.getName()+"\" already exists. Do you want to overwrite it?",
		            	"Existing file",JOptionPane.YES_NO_CANCEL_OPTION);
		            switch(result){
		                case JOptionPane.YES_OPTION:
		                    super.approveSelection();
		                    return;
		                case JOptionPane.NO_OPTION:
		                    return;
		                case JOptionPane.CLOSED_OPTION:
		                    return;
		                case JOptionPane.CANCEL_OPTION:
		                    cancelSelection();
		                    return;
		            }
		        }
		        super.approveSelection();
		    }    
		};
		fileChooser.setDialogTitle("Save Project");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Menthor Project (*.menthor)", "menthor", "menthor"); 
		fileChooser.addChoosableFileFilter(filter);
		if(Util.onWindows()) fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);			
		int option = fileChooser.showSaveDialog(diagramManager);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();			
			projectFile = saveProjectToFile(file);			
			diagramManager.getFrame().setTitle(file.getName().replace(".menthor","")+" - Menthor Editor");
			lastSavePath = file.getAbsolutePath();		
		}
		return option;
	}
	
	/** New Menthor Project. */
	public void newProject() 
	{				
		JFileChooser fileChooser = new JFileChooser(){
			private static final long serialVersionUID = 1L;
			@Override
		    public void approveSelection(){
		        File f = getSelectedFile();
		        if(f.exists()){
		            int result = JOptionPane.showConfirmDialog(this, "\""+f.getName()+"\" already exists. Do you want to overwrite it?",
		            	"Existing file",JOptionPane.YES_NO_CANCEL_OPTION);
		            switch(result){
		                case JOptionPane.YES_OPTION:
		                    super.approveSelection();
		                    return;
		                case JOptionPane.NO_OPTION:
		                    return;
		                case JOptionPane.CLOSED_OPTION:
		                    return;
		                case JOptionPane.CANCEL_OPTION:
		                    cancelSelection();
		                    return;
		            }
		        }
		        super.approveSelection();
		    }   
		};		
		fileChooser.setDialogTitle("New Project");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Menthor Project (*.menthor)", "menthor", "menthor"); 
		fileChooser.addChoosableFileFilter(filter);
		if(Util.onWindows()) fileChooser.setFileFilter(filter);
		fileChooser.setSelectedFile(new File("*.menthor"));
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showDialog(diagramManager,"OK") == JFileChooser.APPROVE_OPTION) {
			try {	
				File file = fileChooser.getSelectedFile();
				
				diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));				
				System.out.println("Creating New project");				
				closeProject();									
				if(!file.getName().endsWith(".menthor")) {
					file = new File(file.getCanonicalFile() + ".menthor");
				}else{
					file = new File(file.getCanonicalFile()+"");
				}
				JRootPane root = diagramManager.getFrame().getRootPane( );
				root.putClientProperty( "Window.documentFile", file );
				projectFile = file;
				createEmptyProject(false,true);				
				saveProjectToFile(file);
				diagramManager.getFrame().setTitle(file.getName().replace(".menthor","")+" - Menthor Editor");
				diagramManager.getFrame().forceShowBrowserPane();
				diagramManager.getFrame().forceShowPalettePane();				
				diagramManager.getFrame().getMainMenu().activateAll();
				System.out.println("New project succesffully created");
								
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(diagramManager, ex.getMessage(), "New Project", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
		diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}	

	/** Open an existing project. */
	public void openProject() 
	{		
		JFileChooser fileChooser = new JFileChooser(lastOpenPath);
		fileChooser.setDialogTitle("Open Project");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Menthor Project (*.menthor)", "menthor", "menthor"); 
		fileChooser.addChoosableFileFilter(filter);
		if(Util.onWindows()) fileChooser.setFileFilter(filter);	
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(diagramManager) == JFileChooser.APPROVE_OPTION) {
			try {
				diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				closeProject();				
				System.out.println("Opening Menthor project...");				
				File file = fileChooser.getSelectedFile();
				JRootPane root = diagramManager.getFrame().getRootPane( );
				root.putClientProperty( "Window.documentFile", file );
				projectFile = file;
				lastOpenPath = file.getAbsolutePath();
				ArrayList<Object> listFiles = ProjectReader.getInstance().readProject(file);
				openListFiles(listFiles);				
				diagramManager.getFrame().forceShowBrowserPane();
				diagramManager.getFrame().forceShowPalettePane();
				diagramManager.getFrame().getMainMenu().activateAll();
				
			} catch (Exception ex) {
				System.out.println("Failed to open Menthor project!");	
				JOptionPane.showMessageDialog(diagramManager, ex.getMessage(), "Open Project", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
			diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			System.out.println("Menthor project successfully opened!");	
		}		
	}
	
	public void openProject(String filePath) 
	{
		System.out.println("HEREEEEEE");
		diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		try {
			closeProject();
			System.out.println("Opening recent project");				
			File file = new File(filePath);
			JRootPane root = diagramManager.getFrame().getRootPane( );
			root.putClientProperty( "Window.documentFile", file );			
			projectFile = file;
			ArrayList<Object> listFiles = ProjectReader.getInstance().readProject(file);
			openListFiles(listFiles);	
			diagramManager.getFrame().forceShowBrowserPane();
			diagramManager.getFrame().forceShowPalettePane();		
			diagramManager.getFrame().getMainMenu().activateAll();
			
		} catch (Exception ex) {
			System.out.println("Failed to open Menthor project!");	
			JOptionPane.showMessageDialog(diagramManager, ex.getMessage(), "Open Project", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
		diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		System.out.println("Menthor project successfully opened!");	
	}
	
	@SuppressWarnings("unchecked")
	public void openExistingModel(Object list){
		if(list instanceof List<?>){
			List<Object> l = (List<Object>)list;
			RefOntoUML.Package model=null;
			if(l.size()>0) model = (RefOntoUML.Package)l.get(0);			
			if(l.size()>1 && l.get(1) instanceof List<?>){
				createProject(model, (List<String>) l.get(1));
			}
			else if(l.size()>1 && l.get(1) instanceof String){
				createProject(model, (String) l.get(1), true, true);
			} else{
				createProject(model, "",true,true);
			}
			diagramManager.getFrame().forceShowBrowserPane();
			diagramManager.getFrame().forceShowPalettePane();
			diagramManager.getFrame().getMainMenu().activateAll();	
		}		
	}
	
	/** Open Menthor project from the list of object read from stream as a result of the menthor file serialization */
	private void openListFiles(ArrayList<Object> listFiles) throws IOException {
		List<OclDocument> ocllist = new ArrayList<OclDocument>();
		for(int i=1; i<listFiles.size();i++){																
			OclDocument oclDoc = (OclDocument)listFiles.get(i);										
			ocllist.add(oclDoc);
		}
		Object o = listFiles.get(0);
		if(o instanceof UmlProject){
			project = (UmlProject)o;			
			browser.set(project, project.getModel(), ocllist);
			diagramManager.getFrame().getInfoManager().setProject(project);
			diagramManager.openDiagrams();
			project.setSaveModelNeeded(false);
		}else if(o instanceof RefOntoUML.Package){			
			RefOntoUML.Package model = (RefOntoUML.Package)o;
			createProject(model,true,false);
		}			
		Settings.addRecentProject(projectFile.getCanonicalPath());
		diagramManager.getFrame().setTitle(projectFile.getName().replace(".menthor","")+" - Menthor Editor");				
	}
	
	/** Import a Reference OntoUML model instance. */
	public void importFromXMI() 
	{
		JFileChooser fileChooser = new JFileChooser(lastImportPath);
		fileChooser.setDialogTitle("Importation");		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Reference OntoUML Model (*.refontouml)", "refontouml");
		fileChooser.addChoosableFileFilter(filter);
		if(Util.onWindows()) fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showOpenDialog(diagramManager) == JFileChooser.APPROVE_OPTION) {
			try {
				closeProject();
				diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new MenthorResourceFactoryImpl());
				resourceSet.getPackageRegistry().put(RefOntoUML.RefOntoUMLPackage.eNS_URI, RefOntoUML.RefOntoUMLPackage.eINSTANCE);
				File ecoreFile = new File(fileChooser.getSelectedFile().getPath());					
				org.eclipse.emf.common.util.URI fileURI = org.eclipse.emf.common.util.URI.createFileURI(ecoreFile.getAbsolutePath());		
				Resource resource = resourceSet.createResource(fileURI);		
				resource.load(Collections.emptyMap());
				File pFile = new File(ecoreFile.getAbsolutePath().replace(".refontouml", ".menthor"));
				JRootPane root = diagramManager.getFrame().getRootPane( );
				root.putClientProperty( "Window.documentFile", pFile );
				projectFile = pFile;
				lastOpenPath = projectFile.getAbsolutePath();
				createProject((RefOntoUML.Package)resource.getContents().get(0));
				saveProjectToFile(projectFile);
				lastImportPath = fileChooser.getSelectedFile().getAbsolutePath();
				Settings.addRecentProject(projectFile.getCanonicalPath());
				diagramManager.newDiagram();
				diagramManager.getFrame().setTitle(projectFile.getName().replace(".menthor","")+" - Menthor Editor");
				diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				diagramManager.getFrame().forceShowBrowserPane();
				diagramManager.getFrame().forceShowPalettePane();
				diagramManager.getFrame().getMainMenu().activateAll();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(diagramManager, ex.getMessage(),"Importation Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		diagramManager.getFrame().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	
}
