package net.menthor.editor.v2.ui.notify.diagram;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.Node;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlNode;

import RefOntoUML.Classifier;

import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.IDiagramCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;
import net.menthor.editor.v2.ui.notify.model.AddElementCommand;

public class AddNodeCommand extends AddElementCommand implements IDiagramCommand {

	private static final long serialVersionUID = -3148409380703192555L;
	
	protected OntoumlEditor ontoumlEditor;
	
	protected StructureDiagram parent;
	protected DiagramElement diagramElement;
	protected double absx;
	protected double absy;	
	
	public OntoumlEditor getOntoumlEditor(){
		return ontoumlEditor;
	}
	
	public AddNodeCommand(OntoumlEditor editor, UmlNode node, double x, double y){				
		super();
		ontoumlEditor = editor;		
		if(editor!=null) parent = editor.getDiagram();
		absx = x;
		absy = y;
		diagramElement = node;		
		if(diagramElement==null) diagramElement = OccurenceManager.get().getDiagramElement(element, parent);		
		if(diagramElement==null){			
			if(parent!=null) this.diagramElement = FactoryManager.get().createNode((RefOntoUML.Type)element, parent);
			else this.diagramElement = FactoryManager.get().createNode((RefOntoUML.Type)element, eContainer);					
		}		
		element = (RefOntoUML.Element)diagramElement.getModelObject();
		eContainer = (RefOntoUML.Element)element.eContainer();
	}

	@Override
	public void undo(){		
		super.undo();
		parent.removeChild(diagramElement);			
		OccurenceManager.get().remove(diagramElement);		
		notifier.notifyUndo(this, diagramElement, NotificationType.ADD);		
	}

	public void run(){				
		super.runWithoutNotifying();					
		addToDiagram();				
		notifier.notify(this, diagramElement, NotificationType.ADD, isRedo ? ActionType.REDO : ActionType.DO);		
	}	
	
	public void addToDiagram (){
		parent.addChild(diagramElement);
		if(diagramElement instanceof Node){			
			((Node)diagramElement).setAbsolutePos(absx, absy);
			showAttributesCompartment();
		}		
	}
	
	private void showAttributesCompartment(){
		Classifier c = ((ClassElement)diagramElement).getClassifier();
		if (c instanceof RefOntoUML.Class){
			if (((RefOntoUML.Class)c).getOwnedAttribute().size()>0){
				((ClassElement)diagramElement).setShowAttributes(true);
			}
		}
		if (c instanceof RefOntoUML.DataType){
			if (((RefOntoUML.DataType)c).getOwnedAttribute().size()>0){
				((ClassElement)diagramElement).setShowAttributes(true);
			}
		}
	}
	
}
