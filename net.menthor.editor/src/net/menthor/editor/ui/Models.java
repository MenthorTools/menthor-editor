package net.menthor.editor.ui;

import java.util.ArrayList;
import java.util.List;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.antipattern.application.AntiPatternList;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;

public class Models {
	
	public static void set(UmlProject project){
		set(project,null);
	}
	
	public static void set(UmlProject project, List<OclDocument> oclDocs){
		setProject(project);				
		if(project!=null){
			setRefparser(new OntoUMLParser(project.getModel()));
			if(oclDocs!=null){
				for(OclDocument s: oclDocs){
					getOclDocList().add(s);
				}
			}
			String name = ((RefOntoUML.Package)project.getResource().getContents().get(0)).getName();
			if (name==null || name.isEmpty()) name = "model";					
			setAntipatterns(new AntiPatternList());
		}
	}
	
	private static UmlProject project;	
	public static UmlProject getProject() { return project; }
	public static void setProject(UmlProject project) { Models.project = project; }
	
	private static OntoUMLParser refparser;	
	public static OntoUMLParser getRefparser() { return refparser; }
	public static void setRefparser(OntoUMLParser refparser) { Models.refparser = refparser; }

	private static ArrayList<OclDocument> oclDocList = new ArrayList<OclDocument>();
	public static ArrayList<OclDocument> getOclDocList() { return oclDocList; }
	public static void setOclDocList(ArrayList<OclDocument> oclDocList) { Models.oclDocList = oclDocList; }

	private static AntiPatternList antipatterns;	
	public static AntiPatternList getAntipatterns() { return antipatterns; }
	public static void setAntipatterns(AntiPatternList antipatterns) { Models.antipatterns = antipatterns; }
		
	public static void clear() {
		Models.setProject(null);
		Models.setRefparser(null);
		Models.getOclDocList().clear();
	}
	
	public static List<String> getDiagramNames(){
		List<String> result = new ArrayList<String>();
		for(OntoumlDiagram d: project.getDiagrams()){
			result.add(d.getName());			
		}
		return result;
	}
	
	public static List<String> getOclDocumentNames(){
		List<String> result = new ArrayList<String>();
		for(OclDocument d: oclDocList){
			result.add(d.getName());			
		}
		return result;
	}
}
