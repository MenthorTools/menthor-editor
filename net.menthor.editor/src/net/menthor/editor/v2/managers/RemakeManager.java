package net.menthor.editor.v2.managers;

import java.util.List;
import java.util.Set;

import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.AssociationElement.ReadingDesign;
import org.tinyuml.umldraw.GeneralizationElement;

import RefOntoUML.Association;
import RefOntoUML.Generalization;
import RefOntoUML.Type;
import net.menthor.editor.ui.ElementMapper;
import net.menthor.editor.ui.Models;

public class RemakeManager extends BaseManager {

	private static RemakeManager instance = new RemakeManager();
	public static RemakeManager get() { return instance; }
		
	/** Re-make all associations in all diagrams they appear. */
	public void remakeAllAssociations(){
		Set<Association> list = Models.getRefparser().getAllInstances(Association.class);
		for(Association a: list){
			remakeRelationship(a);
		}
	}
		
	
	/** Re-make element in all diagrams they appear */
	public void remakeRelationship(RefOntoUML.Element element){
		List<DiagramEditor> editors = diagramManager.getDiagramEditors(element);
		for(DiagramEditor diagramEditor: editors ){
			remakeRelationship(element,diagramEditor);
		}
		if(editors==null || editors.size()==0){
			if (element instanceof RefOntoUML.Association){
				Type source = ((Association)element).getMemberEnd().get(0).getType();
				Type target = ((Association)element).getMemberEnd().get(1).getType();				
				for(DiagramEditor ed: diagramManager.getDiagramEditors(source)){
					if (diagramManager.getDiagramEditors(target).contains(ed)){						
						remakeRelationship(element, ed);
					}
				}				
			}
			if (element instanceof RefOntoUML.Generalization){
				Type general = ((Generalization)element).getGeneral();
				Type specific = ((Generalization)element).getSpecific();
				for(DiagramEditor ed: diagramManager.getDiagramEditors(general)){
					if (diagramManager.getDiagramEditors(specific).contains(ed)){
						remakeRelationship(element, ed);
					}
				}	
			}			
		}
	}
	
	/** Re-make element in the diagram */
	public void remakeRelationship(RefOntoUML.Element element, DiagramEditor d){
		boolean isRectilinear = false;
		boolean showName = false;
		boolean showOntoUMLStereotype = false;
		boolean showMultiplicities = false;
		boolean showRoles = false;
		ReadingDesign direction = ReadingDesign.UNDEFINED;		
		if(element instanceof Association){
			AssociationElement ae = (AssociationElement) ElementMapper.getDiagramElementByDiagram(element, d.getDiagram());
			if(ae!=null){
				isRectilinear = ae.isTreeStyle();			
				showName = ae.showName();
				showOntoUMLStereotype = ae.showOntoUmlStereotype();
				showRoles = false;//ae.showRoles();
				showMultiplicities = ae.showMultiplicities();				
				direction = ae.getReadingDesign();
			}
			DeletionManager.get().eraseElement(d, element);
			MoveManager.get().moveAssociation((Association) element, d, isRectilinear, showName, showOntoUMLStereotype, showMultiplicities, showRoles, direction);
		}
		if(element instanceof Generalization){			
			GeneralizationElement ge = (GeneralizationElement) ElementMapper.getDiagramElementByDiagram(element, d.getDiagram());
			if (ge!=null) isRectilinear = ge.isTreeStyle();			
			DeletionManager.get().eraseElement(d, element);
			MoveManager.get().moveGeneralization(d,(Generalization) element, isRectilinear);
		}		
	}
}
