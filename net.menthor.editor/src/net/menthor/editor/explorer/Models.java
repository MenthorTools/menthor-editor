package net.menthor.editor.explorer;

import java.util.ArrayList;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.AlloySpecification;
import net.menthor.editor.ui.AntiPatternList;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.ontouml2alloy.OntoUML2AlloyOptions;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;

public class Models {

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
}
