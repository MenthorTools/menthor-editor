package net.menthor.editor.v2.managers;

import java.awt.Component;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.AddConnectionCommand;
import org.tinyuml.ui.diagram.commands.AddGeneralizationSetCommand;
import org.tinyuml.ui.diagram.commands.AddNodeCommand;
import org.tinyuml.umldraw.shared.DiagramElementFactoryImpl;

import RefOntoUML.Constraintx;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.StringExpression;
import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.ProjectBrowser;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;

public class AdditionManager {

	public static ProjectBrowser browser;
	public static DiagramManager diagramManager;
	public static DiagramElementFactoryImpl factory;
	
	public static void setup(DiagramManager mg, ProjectBrowser pb){
		browser = pb;
		diagramManager = mg;
		factory = mg.getElementFactory();
	}
	
	public static int confirmGenSetAddition(Component parentWindow){
		return JOptionPane.showConfirmDialog(parentWindow, 
			"There is already a generalization set in the selected generalizations.\nAre you sure you want to continue?", 
			"Addition Manager - Generalization Set", 
			JOptionPane.YES_NO_OPTION, 
			JOptionPane.QUESTION_MESSAGE, 
			null
		);
	}
	
	/** Add relationship to the model. */
	public RefOntoUML.Relationship addRelationship(RelationshipType stereotype, EObject eContainer)	{
		RefOntoUML.Relationship relationship = factory.createRelationship(stereotype);
		if(relationship instanceof RefOntoUML.Association) factory.createPropertiesByDefault((RefOntoUML.Association)relationship);
		if (stereotype==RelationshipType.GENERALIZATION) { //generalizations are owned by a type
			AddConnectionCommand cmd = new AddConnectionCommand(null,null,relationship,(RefOntoUML.Classifier)eContainer,null,diagramManager.getCurrentProject(),null);
			cmd.run();
		}else{
			AddConnectionCommand cmd = new AddConnectionCommand(null,null,relationship,null,null,diagramManager.getCurrentProject(),eContainer);
			cmd.run();
		}
		return relationship;
	}
	
	/** Add comment to the model. */
	public static RefOntoUML.Comment addComment(RefOntoUML.Element eContainer){
		RefOntoUML.Comment comment = factory.createComment();
		AddNodeCommand cmd = new AddNodeCommand(null,null,comment,0,0,diagramManager.getCurrentProject(),eContainer);		
		cmd.run();
		return comment;
	}
	
	/** Add comment to the model */
	public static void addComment(RefOntoUML.Comment c, RefOntoUML.Element eContainer){
		AddNodeCommand cmd = new AddNodeCommand(null,null,c,0,0,diagramManager.getCurrentProject(),eContainer);		
		cmd.run();
	}
	
	/** Add package to the model.  */
	public static RefOntoUML.Element addPackage(RefOntoUML.Element eContainer){
		RefOntoUML.Element comment = factory.createPackage();
		//to add only in the model do exactly as follow		
		AddNodeCommand cmd = new AddNodeCommand(null,null,comment,0,0,diagramManager.getCurrentProject(),eContainer);		
		cmd.run();
		return comment;
	}
	
	/** Add constraint to the model */
	public static void addConstraintx(Constraintx cmt, RefOntoUML.Element eContainer){
		//to add only in the model do exactly as follow		
		AddNodeCommand cmd = new AddNodeCommand(null,null,cmt,0,0,diagramManager.getCurrentProject(),eContainer);		
		cmd.run();
	}
	
	/** Add constraint to the model */
	public static void addConstraintx(RefOntoUML.Element eContainer){
		addConstraintx("",eContainer);
	}
	
	/** Add constraint to the model*/
	public static void addConstraintx(String text, RefOntoUML.Element eContainer){
		RefOntoUML.Constraintx element = factory.createConstraintx();
		((StringExpression)element.getSpecification()).setSymbol(text);
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,diagramManager.getCurrentProject(),eContainer);		
		cmd.run();				
	}
	
	/** Add generalization set to the model  */
	public static RefOntoUML.Element addGeneralizationSet(RefOntoUML.Element eContainer){
		RefOntoUML.Element element = factory.createGeneralizationSet();		
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,diagramManager.getCurrentProject(),eContainer);		
		cmd.run();		
		return element;
	}
	
	/** Add class to the model */
	public static RefOntoUML.Element addClass(ClassType stereotype, RefOntoUML.Element eContainer){	
		RefOntoUML.Element element = factory.createClass(stereotype);		
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,diagramManager.getCurrentProject(),eContainer);		
		cmd.run();		
		return element;
	}
	
	/** Add datatype to the model */
	public static RefOntoUML.Element addDataType(DataType stereotype, RefOntoUML.Element eContainer){
		RefOntoUML.Element element = factory.createDataType(stereotype);		
		AddNodeCommand cmd = new AddNodeCommand(null,null,element,0,0,diagramManager.getCurrentProject(),eContainer);		
		cmd.run();		
		return element;
	}
	
	/** Add generalization set to generalization diagram elements */
	public static GeneralizationSet addGeneralizationSet(DiagramEditor d, List<DiagramElement> diagramElements){		
		UmlProject project = diagramManager.getCurrentProject();
		List<Generalization> gens = diagramManager.getGeneralizations(diagramElements);
		boolean haveGenSet = diagramManager.haveGeneralizationSet(gens);
		if(gens.size()<=1) return null; 
		if(haveGenSet){
			int response = confirmGenSetAddition(diagramManager);
			if(response!=JOptionPane.OK_OPTION) return null;
		}
		EObject eContainer = null;
		if(gens.size()>1) eContainer = gens.get(0).getSpecific().eContainer();	
		else eContainer = project.getModel();
		RefOntoUML.GeneralizationSet newgenset = (GeneralizationSet)factory.createGeneralizationSet();
		((RefOntoUML.Package)eContainer).getPackagedElement().add(newgenset);
		((GeneralizationSet)newgenset).setIsCovering(true);
		((GeneralizationSet)newgenset).setIsDisjoint(true);
		((GeneralizationSet)newgenset).setName("gs");
		new AddGeneralizationSetCommand(d, d.getDiagram(), newgenset, gens, project, project.getModel()).run();
		return (GeneralizationSet)newgenset;
	}
}
