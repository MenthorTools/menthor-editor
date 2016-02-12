package net.menthor.editor.v2.ui.notify.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.BaseConnection;
import org.tinyuml.umldraw.shared.UmlConnection;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.Property;
import RefOntoUML.Relationship;
import RefOntoUML.impl.AssociationImpl;
import RefOntoUML.impl.GeneralizationImpl;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.resource.RefOntoUMLEditingDomain;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

public class AddConnectionCommand extends DiagramCommand {

	private static final long serialVersionUID = 2924451842640450250L;	
	
	private StructureDiagram parent;
	private DiagramElement diagramElement;	
	private boolean onDiagram=false;
	
	private RefOntoUML.Element relationship;
	private Classifier source;
	private Classifier target;
	private EObject eContainer;	
	
	/** add on the diagram */
	public AddConnectionCommand(OntoumlEditor editor, UmlConnection conn){
		ontoumlEditor = editor;
		if(ontoumlEditor!=null){
			onDiagram = true;
			parent = ontoumlEditor.getDiagram();
		}
		diagramElement = conn;			
		if(diagramElement==null){			
			diagramElement = OccurenceManager.get().getDiagramElement(relationship, parent);			
		}
		if (diagramElement==null){
			diagramElement = OccurenceManager.get().getDiagramElement(relationship);
		}
		relationship = (RefOntoUML.Element)diagramElement.getModelObject();		
		if(relationship!=null) {
			source = OntoUMLParser.getSourceType(relationship); 
			target = OntoUMLParser.getTargetType(relationship); 
			eContainer = (RefOntoUML.Element)relationship.eContainer();
		}				
	}
	
	/** add on the model */
	public AddConnectionCommand(RefOntoUML.Element relationship, Classifier aSource, Classifier aTarget, EObject eContainer){
		this.relationship = relationship;
		this.eContainer = eContainer;
		this.onDiagram = false;
		if(aSource==null){
			source = OntoUMLParser.getSourceType(relationship);
		}else{
			source = aSource;
		}
		if(aTarget==null) {
			target = OntoUMLParser.getTargetType(relationship);
		}else {
			target = aTarget;		
		}		
	}

	@Override
	public void undo(){
		super.undo();		
		
			RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().undo();
			UpdateCommander.get().updateFromDeletion(relationship);
		
		if(onDiagram){				
			parent.removeChild(diagramElement);
			OccurenceManager.get().remove(diagramElement);		
			notifier.notifyUndo(this, diagramElement, NotificationType.ADD);			
		}	
	}

	public void run() {	    
		super.run();
			addToModel();		
			UpdateCommander.get().updateFromAddition(relationship);
		if(onDiagram){
			List<DiagramElement> list = new ArrayList<DiagramElement>();
			addToDiagram(isRedo);
			OccurenceManager.get().add(relationship, diagramElement);	
			list.add(diagramElement);
			notifier.notify(this, (List<DiagramElement>) list, NotificationType.ADD, isRedo ? ActionType.REDO : ActionType.DO);
		}		
	}
		
	@SuppressWarnings("unused")
	private void addToDiagram (boolean redo)
	{
		//set sides on the diagram element
		if (diagramElement instanceof BaseConnection) {                         
            BaseConnection connection = (BaseConnection) diagramElement;                            
            if (connection.getRelationship() instanceof GeneralizationImpl)
            {
            	GeneralizationImpl generalization  = (GeneralizationImpl) connection.getRelationship();
            	generalization.setSpecific(source);
            	generalization.setGeneral(target);
            }
            else if(connection.getRelationship() instanceof AssociationImpl)
            {
                AssociationImpl association  = (AssociationImpl) connection.getRelationship();
                association.getMemberEnd().get(0).setType(source);
                association.getMemberEnd().get(1).setType(target);                              
            }
		}
		
		//add to diagram
		parent.addChild(diagramElement);
//		diagramElement.setParent((CompositeNode)parent);
		
		// bug in designing. not best solution, but it works.
		Relationship relationship = ((UmlConnection)diagramElement).getRelationship();		
		if (source instanceof Relationship || target instanceof Relationship)  diagramElement.invalidate();		
	}
	
	private void addToModel()
	{			
//		System.out.println("Adding = "+relationship);
		if (relationship instanceof Association){
			
			//set sides on the element
			Property p1 = ((Association)relationship).getMemberEnd().get(0);
			Property p2 = ((Association)relationship).getMemberEnd().get(1);			
			if(source!=null) {
				p1.setType(source);
				p1.setName(source.getName().trim().toLowerCase());
			}			
			if(target!=null) {
				p2.setType(target);
				p2.setName(target.getName().trim().toLowerCase());
			}
			
			// add to model
			if(eContainer==null){
				AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ProjectManager.get().getProject().getModel().getPackagedElement(), relationship);
				RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
			}else{				
				AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ((RefOntoUML.Package)eContainer).getPackagedElement(), relationship);
				RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);
			}			
		}
		if (relationship instanceof Generalization)
		{	
			//set sides on the element
			((Generalization)relationship).setSpecific(source);
			((Generalization)relationship).setSpecific(target);
			
			//add to model
			if(source!=null){
				AddCommand cmd = new AddCommand(RefOntoUMLEditingDomain.getInstance().createDomain(), ((RefOntoUML.Classifier)source).getGeneralization(), (RefOntoUML.Generalization)relationship);
				RefOntoUMLEditingDomain.getInstance().createDomain().getCommandStack().execute(cmd);				
			}
						
		}		
	}	
}

