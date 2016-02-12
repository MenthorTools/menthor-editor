
package net.menthor.editor.v2.commanders;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Classifier;
import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Package;
import RefOntoUML.Relationship;
import RefOntoUML.StringExpression;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.ui.app.manager.AppBrowserManager;
import net.menthor.editor.v2.ui.app.manager.AppMessageManager;
import net.menthor.editor.v2.ui.app.manager.AppSplitPaneManager;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
import net.menthor.editor.v2.ui.notify.diagram.AddConnectionCommand;
import net.menthor.editor.v2.ui.notify.diagram.AddGeneralizationSetCommand;
import net.menthor.editor.v2.ui.notify.diagram.AddNodeCommand;
import net.menthor.editor.v2.util.Util;

public class AddCommander {

	// -------- Lazy Initialization
	
	private static class AdditionLoader {
        private static final AddCommander INSTANCE = new AddCommander();
    }	
	public static AddCommander get() { 
		return AdditionLoader.INSTANCE; 
	}	
    private AddCommander() {
        if (AdditionLoader.INSTANCE != null) throw new IllegalStateException("AdditionCommander already instantiated");
    }		
    
    // ----------------------------
	
	private boolean confirmGenSetAddition(){
		return AppMessageManager.get().confirm("Add Generalization Set",
			"There is already a generalization set in the selected generalizations.\nAre you sure you want to continue?"
		);
	}
	
	/** Add relationship to the model. */
	public RefOntoUML.Relationship addRelationship(RelationshipType stereotype, Object input)	{
		AddConnectionCommand cmd = null;
		Relationship relationship = null;
		
		if(stereotype==null){
			return null;
		}
		
		if(input instanceof DefaultMutableTreeNode){
			input = ((DefaultMutableTreeNode) input).getUserObject();
		}
		
		//generalizations are owned by a type
		if(stereotype.isGeneralization() && input instanceof Classifier){
			relationship = FactoryManager.get().createRelationship(stereotype);
			cmd = new AddConnectionCommand(relationship,(Classifier)input,null,null);
			cmd.run();
		}
		//associations are owned by a package
		else if (stereotype.isAssociation() && input instanceof Package) { 
			relationship = FactoryManager.get().createRelationship(stereotype);
			cmd = new AddConnectionCommand(relationship,null,null,(Package)input);
			cmd.run();
		}
		
		return relationship;
	}
	
	/** Add comment to the model. */
	public RefOntoUML.Comment addComment(Object input){
		Package container = getContainer(input);
		Comment newElement = null;
		
		if(container!=null){
			newElement = FactoryManager.get().createComment();
			AddNodeCommand cmd = new AddNodeCommand(null,null,newElement,0,0,container);		
			cmd.run();
		}
		
		return newElement;
	}
	
	/** Add comment to the model */
	public void addComment(RefOntoUML.Comment c, RefOntoUML.Element eContainer){
		AddNodeCommand cmd = new AddNodeCommand(null,null,c,0,0,eContainer);		
		cmd.run();
	}
	
	/** Add package to the model.  */
	public void addPackage(Object input){		
		Package container = getContainer(input);
		Element newElement = null;
		
		if(container!=null){
			newElement = FactoryManager.get().createPackage();
			AddNodeCommand cmd = new AddNodeCommand(null,null,newElement,0,0,container);		
			cmd.run();
		}
	}
	
	/** Add constraint to the model */
	public void addConstraintx(Constraintx cmt, RefOntoUML.Element eContainer){
		AddNodeCommand cmd = new AddNodeCommand(null,null,cmt,0,0,eContainer);		
		cmd.run();
	}
	
	/** Add constraint to the model */
	public void addConstraintx(Object input){
		addConstraintx("",input);
	}
	
	/** Add constraint to the model*/
	public void addConstraintx(String text, Object input){
		Package container = getContainer(input);
		Constraintx newElement = null;
		
		if(container!=null){
			newElement = FactoryManager.get().createConstraintx();
			((StringExpression)newElement.getSpecification()).setSymbol(text);
			AddNodeCommand cmd = new AddNodeCommand(null,null,newElement,0,0,container);		
			cmd.run();		
		}
	}
	
	/** Add generalization set to the model  */
	public RefOntoUML.Element addGeneralizationSet(Object input){
		Package container = getContainer(input);
		RefOntoUML.Element newElement = null;
		
		if(container!=null){
			newElement = FactoryManager.get().createGeneralizationSet();		
			AddNodeCommand cmd = new AddNodeCommand(null,null,newElement,0,0,container);		
			cmd.run();
		}
		return newElement;
	}
	
	/** Add class to the model */
	public RefOntoUML.Element addClass(ClassType stereotype, Object input){
		Package container = getContainer(input);
		RefOntoUML.Element newElement = null;
		
		if(container!=null){
			newElement = FactoryManager.get().createClass(stereotype);		
			AddNodeCommand cmd = new AddNodeCommand(null,null,newElement,0,0,container);		
			cmd.run();
		}
		
		return newElement;
	}
	
	/** Add datatype to the model */
	public RefOntoUML.Element addDataType(DataType stereotype, Object input){
		Package container = getContainer(input);
		RefOntoUML.Element newElement = null;
		
		if(container!=null){
			newElement = FactoryManager.get().createDataType(stereotype);		
			AddNodeCommand cmd = new AddNodeCommand(null,null,newElement,0,0,container);		
			cmd.run();
		}
		
		return newElement;
	}
	
	/** Add generalization set to generalization diagram elements */
	public GeneralizationSet addGeneralizationSet(OntoumlEditor d, List<DiagramElement> diagramElements){		
		UmlProject project = ProjectManager.get().getProject();
		List<Generalization> gens = d.getGeneralizations(diagramElements);
		boolean haveGenSet = OntoUMLParser.haveGeneralizationSet(gens);		
		if(gens.size()<1) return null;		
		if(haveGenSet){
			if(!confirmGenSetAddition()) return null;
		}		
		EObject eContainer = null;
		if(gens.size()>1) eContainer = gens.get(0).getSpecific().eContainer();	
		else eContainer = project.getModel();
		RefOntoUML.GeneralizationSet newgenset = (GeneralizationSet)FactoryManager.get().createGeneralizationSet();
		((RefOntoUML.Package)eContainer).getPackagedElement().add(newgenset);
		((GeneralizationSet)newgenset).setIsCovering(true);
		((GeneralizationSet)newgenset).setIsDisjoint(true);
		((GeneralizationSet)newgenset).setName("gs");
		new AddGeneralizationSetCommand(d, d.getDiagram(), newgenset, gens, project.getModel()).run();
		return (GeneralizationSet)newgenset;
	}
	
	/** New ocl document */
	public void newOclDocument(){
		newOclDocument(null, false);		
	}
	
	/** New ocl document */
	public void newOclDocument(String oclcontent, boolean createTab){
		addOclDocument(null, oclcontent, createTab);		
	}
	
	/** Add ocl document to a container */
	public void addOclDocument(Object treeNode){
		addOclDocument(treeNode, "", false);
	}
	
	/** Add ocl document to a container */
	public void addOclDocument(Object treeNode, String oclContent, boolean createTab){				
		if(treeNode==null || !(treeNode instanceof DefaultMutableTreeNode) || !(((DefaultMutableTreeNode)treeNode).getUserObject() instanceof Package)){
			treeNode = AppBrowserManager.get().root();
		}
		OclDocument oclDoc = new OclDocument();
		Package pack = (Package) ((DefaultMutableTreeNode) treeNode).getUserObject();
		oclDoc.setContainer(pack);		
		if(oclContent!=null) oclDoc.setContentAsString(oclContent);
		oclDoc.setName("OclDocument"+ProjectManager.get().getProject().getOclDocList().size());		
		ProjectManager.get().getProject().getOclDocList().add(oclDoc);		
		AppBrowserManager.get().add((DefaultMutableTreeNode)treeNode, oclDoc);		
		if(createTab) AppTabManager.get().addOclEditor(oclDoc);
	}
	
	public void newDiagram(){
		addDiagram(null);
	}

	public void addDiagram(Object treeNode){
		if(treeNode==null || !(treeNode instanceof DefaultMutableTreeNode) || !(((DefaultMutableTreeNode)treeNode).getUserObject() instanceof Package)){
			treeNode = AppBrowserManager.get().root();
		}
		StructureDiagram diagram = new StructureDiagram(ProjectManager.get().getProject());		
		Package epackage = (Package) ((DefaultMutableTreeNode) treeNode).getUserObject();
		diagram.setContainer(epackage);		
		setDefaultDiagramSize(diagram);
		diagram.setLabelText("Diagram"+ProjectManager.get().getProject().getDiagrams().size());
		ProjectManager.get().getProject().addDiagram(diagram);
		ProjectManager.get().getProject().saveDiagramNeeded(diagram,false);
		AppTabManager.get().addDiagramEditor(diagram);				
		if(treeNode!=null) AppBrowserManager.get().add((DefaultMutableTreeNode)treeNode,diagram);
	}
	
	public void setDefaultDiagramSize(StructureDiagram diagram){
		double waste = 0;
		if(AppSplitPaneManager.get().isShowProjectBrowser()) waste+=240;
		if(AppSplitPaneManager.get().isShowPalette()) waste+=240;
		diagram.setSize((Util.getScreenWorkingWidth()-waste+100)*3, (Util.getScreenWorkingHeight()-100)*3);
	}
	
	private Package getContainer(Object input){
		Object element;
		
		if(input instanceof DefaultMutableTreeNode){
			element = ((DefaultMutableTreeNode) input).getUserObject();
		}
		else{
			element = input;
		}
		
		if(element instanceof Package){
			return (Package) element;
		}
		
		return null;
	}
}
