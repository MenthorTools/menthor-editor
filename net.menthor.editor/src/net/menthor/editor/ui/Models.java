package net.menthor.editor.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.antipattern.application.AntiPatternList;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.ontouml2alloy.OntoUML2AlloyOptions;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;

public class Models {
	
	public static void set(UmlProject project, RefOntoUML.Package model){
		set(project,model,null);
	}
	
	public static void set(UmlProject project, RefOntoUML.Package model, List<OclDocument> oclDocs){
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
			setAlloySpec(new AlloySpecification(project.getTempDir()+File.separator+name.toLowerCase()+".als"));		
			setOclOptions(new TOCL2AlloyOption());		
			setRefOptions(new OntoUML2AlloyOptions());		
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

	private static AlloySpecification alloySpec;	
	public static AlloySpecification getAlloySpec() { return alloySpec; }
	public static void setAlloySpec(AlloySpecification alloySpec) { Models.alloySpec = alloySpec; }

	private static AntiPatternList antipatterns;	
	public static AntiPatternList getAntipatterns() { return antipatterns; }
	public static void setAntipatterns(AntiPatternList antipatterns) { Models.antipatterns = antipatterns; }

	private static OntoUML2AlloyOptions refOptions;
	public static OntoUML2AlloyOptions getRefOptions() { return refOptions; }
	public static void setRefOptions(OntoUML2AlloyOptions refOptions) { Models.refOptions = refOptions; }

	private static TOCL2AlloyOption oclOptions;
	public static TOCL2AlloyOption getOclOptions() { return oclOptions; }
	public static void setOclOptions(TOCL2AlloyOption oclOptions) { Models.oclOptions = oclOptions; }
	
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
