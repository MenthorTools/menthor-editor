
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
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.AddConnectionCommand;
import org.tinyuml.ui.diagram.commands.AddGeneralizationSetCommand;
import org.tinyuml.ui.diagram.commands.AddNodeCommand;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Constraintx;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Package;
import RefOntoUML.StringExpression;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.util.Util;

public class AdditionManager extends BaseManager {

	// -------- Lazy Initialization
	
	private static class AdditionLoader {
        private static final AdditionManager INSTANCE = new AdditionManager();
    }	
	public static AdditionManager get() { 
		return AdditionLoader.INSTANCE; 
	}	
    private AdditionManager() {
        if (AdditionLoader.INSTANCE != null) throw new IllegalStateException("AdditionManager already instantiated");
    }		
    
    // ----------------------------
	
	public boolean confirmGenSetAddition(Component parentWindow){
		return MessageManager.get().confirm(parentWindow, "Add Generalization Set",
			"There is already a generalization set in the selected generalizations.\nAre you sure you want to continue?"
		);
	}
	
	/** Add relationship to the model. */
	public RefOntoUML.Relationship addRelationship(RelationshipType stereotype, EObject eContainer)	{
		RefOntoUML.Relationship relationship = FactoryManager.get().createRelationship(stereotype);		
		if (stereotype==RelationshipType.GENERALIZATION) { //generalizations are owned by a type
			AddConnectionCommand cmd = new AddConnectionCommand(null,null,relationship,(RefOntoUML.Classifier)eContainer,null,null);
			cmd.run();
		}else{
			AddConnectionCommand cmd = new AddConnectionCommand(null,null,relationship,null,null,eContainer);
			cmd.run();
		}
		return relationship;
	}
	
	/** Add comment to the model. */
	public RefOntoUML.Comment addComment(RefOntoUML.Element eContainer){
		RefOntoUML.Comment comment = FactoryManager.get().createComment();
		AddNodeCommand cmd = new AddNodeCommand(null,null,comment,0,0,eContainer);		
		cmd.run();
		return comment;
	}
	
	/** Add comment to the model */
	public void addComment(RefOntoUML.Comment c, RefOntoUML.Element eContainer){
		AddNodeCommand cmd = new AddNodeCommand(null,null,c,0,0,eContainer);		
		cmd.run();
	}
	
	/** Add package to the model.  */
	public void addPackage(DefaultMutableTreeNode node){
		
		if(!(node.getUserObject() instanceof RefOntoUML.Package))
			return;
		
		RefOntoUML.Package container = (RefOntoUML.Package) (node.getUserObject()) ;
		RefOntoUML.Element newPackage = FactoryManager.get().createPackage();

		AddNodeCommand cmd = new AddNodeCommand(null,null,newPackage,0,0,container);		
		cmd.run();
	}
	
	/** Add constraint to the model */
	public void addConstraintx(Constraintx cmt, RefOntoUML.Element eContainer){
		AddNodeCommand cmd = new AddNodeCommand(null,null,cmt,0,0,eContainer);		
		cmd.run();
	}
	
	/** Add constraint to the model */
	public void addConstraintx(RefOntoUML.Element eContainer){
		addConstraintx("",eContainer);
	}
	
	/** Add constraint to the model*/
	public void addConstraintx(String text, RefOntoUML.Element eContainer){
		RefOntoUML.Constraintx element = FactoryManager.get().createConstraintx();
		((StringExpression)element.getSpecification()).setSymbol(text);
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,eContainer);		
		cmd.run();				
	}
	
	/** Add generalization set to the model  */
	public RefOntoUML.Element addGeneralizationSet(RefOntoUML.Element eContainer){
		RefOntoUML.Element element = FactoryManager.get().createGeneralizationSet();		
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,eContainer);		
		cmd.run();		
		return element;
	}
	
	/** Add class to the model */
	public RefOntoUML.Element addClass(ClassType stereotype, RefOntoUML.Element eContainer){	
		RefOntoUML.Element element = FactoryManager.get().createClass(stereotype);		
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,eContainer);		
		cmd.run();		
		return element;
	}
	
	/** Add datatype to the model */
	public RefOntoUML.Element addDataType(DataType stereotype, RefOntoUML.Element eContainer){
		RefOntoUML.Element element = FactoryManager.get().createDataType(stereotype);		
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,eContainer);		
		cmd.run();		
		return element;
	}
	
	/** Add generalization set to generalization diagram elements */
	public GeneralizationSet addGeneralizationSet(DiagramEditor d, List<DiagramElement> diagramElements){		
		UmlProject project = ProjectManager.get().getProject();
		List<Generalization> gens = d.getGeneralizations(diagramElements);
		boolean haveGenSet = OntoUMLParser.haveGeneralizationSet(gens);
		
		if(gens.size()<1) 
			return null; 
		
		if(haveGenSet){
			if(!confirmGenSetAddition(frame())) return null;
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
	public void addOclDocument(Object eContainer){
		addOclDocument(eContainer, "", false);
	}
	
	/** Add ocl document to a container */
	public void addOclDocument(Object eContainer, String oclContent, boolean createTab){		
		
		if(!(eContainer instanceof DefaultMutableTreeNode) || !(((DefaultMutableTreeNode) eContainer).getUserObject() instanceof Package))
			return;
		
		Package pack = (Package) ((DefaultMutableTreeNode) eContainer).getUserObject();
				
		OclDocument oclDoc = new OclDocument();		
		oclDoc.setContainer(pack);
		if(oclContent!=null) oclDoc.setContentAsString(oclContent);
		oclDoc.setName("Rules"+Models.getOclDocList().size());		
		Models.getOclDocList().add(oclDoc);			
		DefaultMutableTreeNode container = tree().getNode(pack);
		tree().addChild(container, oclDoc);
		if(createTab) TabManager.get().addOclEditor(oclDoc);
	}
	
	public void newDiagram(){
		addDiagram(null);
	}

	public void addDiagram(Object input){		
		if(!(input instanceof DefaultMutableTreeNode) || !(((DefaultMutableTreeNode) input).getUserObject() instanceof Package)) return;		
		Package epackage = (Package) ((DefaultMutableTreeNode) input).getUserObject();				
		StructureDiagram diagram = new StructureDiagram(ProjectManager.get().getProject());
		if(epackage!=null) diagram.setContainer(epackage);
		setDefaultDiagramSize(diagram);
		diagram.setLabelText("Diagram"+ProjectManager.get().getProject().getDiagrams().size());
		ProjectManager.get().getProject().addDiagram(diagram);
		ProjectManager.get().getProject().saveDiagramNeeded(diagram,false);
		TabManager.get().addDiagramEditor(diagram);		
		DefaultMutableTreeNode container = tree().getNode(epackage);
		tree().addChild(container,diagram);
	}
	
	public void setDefaultDiagramSize(StructureDiagram diagram){
		double waste = 0;
		if(frame().isShowBrowserPane()) waste+=240;
		if(frame().isShowPalettePane()) waste+=240;
		diagram.setSize((Util.getScreenWorkingWidth()-waste+100)*3, (Util.getScreenWorkingHeight()-100)*3);
	}
}
