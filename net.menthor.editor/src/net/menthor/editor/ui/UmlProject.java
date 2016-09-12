package net.menthor.editor.ui;

import java.io.IOException;

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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Association;
import RefOntoUML.Class;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.PackageableElement;
import RefOntoUML.impl.GeneralizationSetImpl;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.antipattern.AntiPatternList;
import net.menthor.editor.v2.MenthorDomain;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.ui.MenthorEditor;
import net.menthor.editor.v2.util.DirectoryUtil;

/** The UmlProject is serialized to a binary file in order to store the diagrams and its graphics allElements. */
public class UmlProject implements Serializable {
		
	private static final long serialVersionUID = 1L;	
	
	/** name and version */
	private String name = new String();	
	private String version = new String();
	
	private transient OntoUMLParser refparser;
	
	private transient AntiPatternList antipatterns;	
	public AntiPatternList getAntipatterns() { return antipatterns; }
	public void setAntipatterns(AntiPatternList antipatterns) { this.antipatterns = antipatterns; }
	
	private transient List<OclDocument> oclDocList = new ArrayList<OclDocument>();
	public List<OclDocument> getOclDocList() { return oclDocList; }
	public void setOclDocList(List<OclDocument> oclDocList) { this.oclDocList = oclDocList; }
	public void clearOclDocs(){ this.getOclDocList().clear(); }
	public List<String> getOclDocumentNames(){
		List<String> result = new ArrayList<String>();
		for(OclDocument d: oclDocList){
			result.add(d.getName());			
		}
		return result;
	}
	
	/** is save needed */
	private transient boolean saveNeeded = false;
	
	/** The model (contained in a resource) is serialized separately, 
	 *  by its own means so here it is transient. */
	private transient Resource resource;
	
	private List<OntoumlDiagram> diagrams = new ArrayList<OntoumlDiagram>();
	private ArrayList<Integer> openedDiagrams = new ArrayList<Integer>();
	
	/** The settings */
	private Properties properties;
	
	public static transient String tempDir;
	public static transient String binDir;	
	
	public String getVersion() { return version; }	
	public String getName () { return name; }	
	public void setVersion(String version) { this.version = version; }	
	public void setName (String name) { this.name = name; }	
	public int getVersionAsInt() { return Integer.parseInt(version.replaceAll("[.]", "")); }
	public void addDiagram(OntoumlDiagram diagram) { diagrams.add(diagram); }		
	public List<OntoumlDiagram> getDiagrams() { return diagrams; }
	public RefOntoUML.Package getModel() {		
		return (RefOntoUML.Package) resource.getContents().get(0); 
	}
	public void setSaveModelNeeded(boolean saveNeeded) { this.saveNeeded = saveNeeded; }
	public boolean isSaveModelNeeded() { return saveNeeded; }
	public Properties getProperties() { return properties; }
	public void setProperties(Properties properties) { this.properties = properties; }
	public ArrayList<Integer> getOpenedDiagrams() { return openedDiagrams; }
	public void setResource(Resource resource) { this.resource = resource; }	
	public boolean contains(PackageableElement element) { return getModel().getPackagedElement().contains(element); }
	public Resource getResource() { return resource; }
	public EList<PackageableElement> getElements() { return getModel().getPackagedElement();}
	
	@Override
	public String toString() { return "Menthor Project"; }
	
	public UmlProject(RefOntoUML.Package model) {
		super();
		properties = new Properties();		
		resource = MenthorDomain.get().createResource();
		resource.getContents().add(model);		
		MenthorDomain.get().createDomain();
		name = "New Project";
		version = MenthorEditor.MENTHOR_VERSION;
		refparser = new OntoUMLParser(model);
		oclDocList = new ArrayList<OclDocument>();
	}
	
	public UmlProject() {
		super();
		properties = new Properties();
		resource = MenthorDomain.get().createResource();		
		RefOntoUML.Package model = createAndAddRootModel();		
		MenthorDomain.get().createDomain();
		name = "New Project";		
		version = MenthorEditor.MENTHOR_VERSION;
		refparser = new OntoUMLParser(model);
		oclDocList = new ArrayList<OclDocument>();
	}
	
	private RefOntoUML.Package createAndAddRootModel() {
		RefOntoUML.Package model = RefOntoUMLFactoryUtil.factory.createModel();
		model.setName("Model");
		resource.getContents().add(model);
		return model;
	}
	
	public OntoUMLParser getRefParser(){ 
		if(refparser==null && getModel()!=null) refparser = new OntoUMLParser(getModel());
		return refparser; 
	}
	
	public void saveAllDiagramNeeded(boolean value){
		for(OntoumlDiagram d: getDiagrams()) {
			((StructureDiagram)d).setSaveNeeded(value);
		}
		setSaveModelNeeded(value);
	}

	public void saveDiagramNeeded(StructureDiagram diagram, boolean value){
		diagram.setSaveNeeded(value);
		setSaveModelNeeded(value);
	}
	
	public void clearOpenedDiagrams(){
		if(openedDiagrams!=null) openedDiagrams.clear();
		else openedDiagrams = new ArrayList<Integer>();
	}
	
	public void saveAsOpened(OntoumlDiagram diagram){
		int index = diagrams.indexOf(diagram);
		if(index>=0) {
			if(openedDiagrams!=null){
				if(!openedDiagrams.contains(index)) openedDiagrams.add(index);
			}
		}
	}
	
	public boolean isAllClosed(){
		boolean allClosed = true;
		if (openedDiagrams!=null){
			for(OntoumlDiagram diagram: diagrams)
			if(openedDiagrams.contains(diagram)) allClosed=false;
		}
		return allClosed;
	}

	public boolean isOpened(OntoumlDiagram diagram){
		if (openedDiagrams!=null){
			return openedDiagrams.contains(diagrams.indexOf(diagram));
		}
		return false;
	}
	
	public Set<RefOntoUML.Class> getClasses() {
		Set<RefOntoUML.Class> classes = new HashSet<RefOntoUML.Class>();
		for (PackageableElement item : getElements()) {
			if (item instanceof RefOntoUML.Class) {
				classes.add((Class) item);
			}
		}
		return classes;
	}

	public Set<Generalization> getGeneralizations() {
		Set<Generalization> generalizations = new HashSet<Generalization>();
		for (PackageableElement item : getElements()) {
			if (item instanceof RefOntoUML.Class) {
				generalizations.addAll(((RefOntoUML.Class) item)
						.getGeneralization());
			}
		}
		return generalizations;
	}

	public Set<GeneralizationSet> getGeneralizationSets() {
		Set<GeneralizationSet> generalizationSets = new HashSet<GeneralizationSet>();
		for (PackageableElement item : getElements()) {
			if (item instanceof GeneralizationSetImpl) {
				generalizationSets.add((GeneralizationSet) item);
			}
		}
		return generalizationSets;
	}
	
	public Set<Association> getAssociations() {
		Set<Association> associations = new HashSet<Association>();
		for (PackageableElement item : getElements()) {
			if (item instanceof Association) {
				associations.add((Association) item);
			}
		}
		return associations;
	}
	
	public String getTempDir(){
		if(tempDir == null) tempDir = DirectoryUtil.makeTempDir();		
		return tempDir;
	}

	public String getBinDir(){
		if(binDir == null) binDir = DirectoryUtil.makeBinDir();		
		return binDir;
	}
	
	public static String createTempDir(){
		if(tempDir == null) tempDir = DirectoryUtil.makeTempDir();		
		return tempDir;
	}
	
	public static String createBinDir(){
		if(binDir == null) binDir = DirectoryUtil.makeBinDir();		
		return binDir;
	}
	

	public List<String> getDiagramNames(){
		List<String> result = new ArrayList<String>();
		for(OntoumlDiagram d: getDiagrams()){
			result.add(d.getName());			
		}
		return result;
	}
}
