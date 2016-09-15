
package net.menthor.editor.v2.commanders;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.MenthorFactory;
import org.tinyuml.umldraw.OccurenceMap;

import RefOntoUML.Constraintx;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.StringExpression;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.stereotypes.ClassStereotype;
import RefOntoUML.stereotypes.DataTypeStereotype;
import RefOntoUML.stereotypes.RelationshipStereotype;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.ui.controller.DialogUIController;
import net.menthor.editor.v2.ui.controller.MessageUIController;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.editor.v2.ui.operation.diagram.AddGeneralizationSetOperation;
import net.menthor.editor.v2.ui.operation.model.AddModelOperation;

public class AddCommander extends GenericCommander {

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
		return MessageUIController.get().confirm("Add Generalization Set",
			"There is already a generalization set in the selected generalizations.\nAre you sure you want to continue?"
		)==0;
	}
	
	/** Add relationship to the model. */
	public RefOntoUML.Relationship addRelationship(RelationshipStereotype stereotype, Object input)	{
		if(stereotype==null) return null;
		Element container = getContainer(input);		
		RefOntoUML.Relationship relationship = MenthorFactory.get().createRelationship(stereotype);		
		AddModelOperation cmd = new AddModelOperation(relationship,container);
		cmd.run();
		return relationship;
	}
	
	/** Add comment to the model. */
	public RefOntoUML.Comment addComment(Object input){
		Element container = getContainer(input);
		if(container!=null){
			RefOntoUML.Comment comment = MenthorFactory.get().createComment();
			AddModelOperation cmd = new AddModelOperation(comment,container);		
			cmd.run();
			return comment;
		}
		return null;
	}
	
	/** Add comment to the model */
	public void addComment(RefOntoUML.Comment c, RefOntoUML.Element eContainer){
		AddModelOperation cmd = new AddModelOperation(c,eContainer);		
		cmd.run();
	}
	
	/** Add package to the model.  */
	public void addPackage(Object input){	
		Element container = getContainer(input);
		if(container!=null){			
			RefOntoUML.Element newPackage = MenthorFactory.get().createPackage();
			AddModelOperation cmd = new AddModelOperation(newPackage,container);		
			cmd.run();
		}
	}
	
	/** Add constraint to the model */
	public void addConstraintx(Constraintx cmt, RefOntoUML.Element eContainer){
		AddModelOperation cmd = new AddModelOperation(cmt,eContainer);		
		cmd.run();
	}
	
	/** Add constraint to the model */
	public void addConstraintx(Object input){
		addConstraintx("",input);
	}
	
	/** Add constraint to the model*/
	public void addConstraintx(String text, Object input){
		Element container = getContainer(input);			
		if(container!=null){
			RefOntoUML.Constraintx element = MenthorFactory.get().createConstraintx();
			((StringExpression)element.getSpecification()).setSymbol(text);
			AddModelOperation cmd = new AddModelOperation(element,container);		
			cmd.run();				
		}
	}
	
	/** Add generalization set to the model  */
	public RefOntoUML.Element addGeneralizationSet(Object input){
		Element container = getContainer(input);			
		if(container!=null){
			RefOntoUML.Element element = MenthorFactory.get().createGeneralizationSet();		
			AddModelOperation cmd = new AddModelOperation(element,container);		
			cmd.run();
			return element;			
		}
		return null;
	}
	
	
	
	/** Add class to the model */
	public RefOntoUML.Element addClass(ClassStereotype stereotype, Object input){	
		Element container = getContainer(input);			
		if(container!=null){
			RefOntoUML.Element element = MenthorFactory.get().createClass(stereotype);		
			AddModelOperation cmd = new AddModelOperation(element,container);		
			cmd.run();		
			return element;
		}
		return null;
	}
	
	/** Add datatype to the model */
	public RefOntoUML.Element addDataType(DataTypeStereotype stereotype, Object input){
		Element eContainer = getContainer(input);			
		if(eContainer!=null){
			RefOntoUML.Element element = MenthorFactory.get().createDataType(stereotype);		
			AddModelOperation cmd = new AddModelOperation(element,eContainer);		
			cmd.run();		
			return element;
		}
		return null;
	}
	
	/** Create a generalizations from selected elements in the diagram */
	public void addGeneralizationSet(ArrayList<DiagramElement> genElems){
		GeneralizationSet genSet = addGeneralizationSet(currentEditor(),(List<DiagramElement>)genElems);		
		if(genSet!=null){		
			DialogUIController.get().callGeneralizationSetDialog(genSet,true);
		}	
	}
	
	/** Add generalization set to generalization diagram elements */
	public GeneralizationSet addGeneralizationSet(OntoumlEditor d, List<DiagramElement> diagramElements){		
		UmlProject project = ProjectUIController.get().getProject();
		List<Generalization> gens = OccurenceMap.get().getGeneralizations(diagramElements);
		boolean haveGenSet = OntoUMLParser.haveGeneralizationSet(gens);		
		if(gens.size()<1) return null;		
		if(haveGenSet){
			if(!confirmGenSetAddition()) return null;
		}		
		EObject eContainer = null;
		if(gens.size()>1) eContainer = gens.get(0).getSpecific().eContainer();	
		else eContainer = project.getModel();
		RefOntoUML.GeneralizationSet newgenset = (GeneralizationSet)MenthorFactory.get().createGeneralizationSet();
		((RefOntoUML.Package)eContainer).getPackagedElement().add(newgenset);
		((GeneralizationSet)newgenset).setIsCovering(true);
		((GeneralizationSet)newgenset).setIsDisjoint(true);
		((GeneralizationSet)newgenset).setName("gs");
		new AddGeneralizationSetOperation(d, newgenset, gens, project.getModel()).run();
		return (GeneralizationSet)newgenset;
	}
	
	private Element getContainer(Object input){				
		if(input instanceof DefaultMutableTreeNode){
			return (Element)((DefaultMutableTreeNode) input).getUserObject();
		}else{
			return (Element) input;
		}		
	}
}
