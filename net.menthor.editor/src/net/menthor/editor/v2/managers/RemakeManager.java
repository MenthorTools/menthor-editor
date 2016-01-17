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
import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.ModelHelper;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.ProjectBrowser;

public class RemakeManager {

	public static ProjectBrowser browser;
	public static DiagramManager diagramManager;
	
	public static void setup(DiagramManager mg, ProjectBrowser pb){
		browser = pb;
		diagramManager = mg;
	}

	/** Re-make all associations in all diagrams they appear. */
	public void remakeAllAssociations(){
		Set<Association> list = Models.getRefparser().getAllInstances(Association.class);
		for(Association a: list){
			RemakeManager.remakeRelationship(a);
		}
	}
		
	
	/** Re-make element in all diagrams they appear */
	public static void remakeRelationship(RefOntoUML.Element element){
		List<DiagramEditor> editors = diagramManager.getDiagramEditors(element);
		for(DiagramEditor diagramEditor: editors ){
			RemakeManager.remakeRelationship(element,diagramEditor);
		}
		if(editors==null || editors.size()==0){
			if (element instanceof RefOntoUML.Association){
				Type source = ((Association)element).getMemberEnd().get(0).getType();
				Type target = ((Association)element).getMemberEnd().get(1).getType();				
				for(DiagramEditor ed: diagramManager.getDiagramEditors(source)){
					if (diagramManager.getDiagramEditors(target).contains(ed)){						
						RemakeManager.remakeRelationship(element, ed);
					}
				}				
			}
			if (element instanceof RefOntoUML.Generalization){
				Type general = ((Generalization)element).getGeneral();
				Type specific = ((Generalization)element).getSpecific();
				for(DiagramEditor ed: diagramManager.getDiagramEditors(general)){
					if (diagramManager.getDiagramEditors(specific).contains(ed)){
						RemakeManager.remakeRelationship(element, ed);
					}
				}	
			}			
		}
	}
	
	/** Re-make element in the diagram */
	public static void remakeRelationship(RefOntoUML.Element element, DiagramEditor d){
		boolean isRectilinear = false;
		boolean showName = false;
		boolean showOntoUMLStereotype = false;
		boolean showMultiplicities = false;
		boolean showRoles = false;
		ReadingDesign direction = ReadingDesign.UNDEFINED;		
		if(element instanceof Association){
			AssociationElement ae = (AssociationElement) ModelHelper.getDiagramElementByDiagram(element, d.getDiagram());
			if(ae!=null){
				isRectilinear = ae.isTreeStyle();			
				showName = ae.showName();
				showOntoUMLStereotype = ae.showOntoUmlStereotype();
				showRoles = false;//ae.showRoles();
				showMultiplicities = ae.showMultiplicities();				
				direction = ae.getReadingDesign();
			}
			DeletionManager.eraseElement(d, element);
			MoveManager.moveAssociation((Association) element, d, isRectilinear, showName, showOntoUMLStereotype, showMultiplicities, showRoles, direction);
		}
		if(element instanceof Generalization){			
			GeneralizationElement ge = (GeneralizationElement) ModelHelper.getDiagramElementByDiagram(element, d.getDiagram());
			if (ge!=null) isRectilinear = ge.isTreeStyle();			
			DeletionManager.eraseElement(d, element);
			MoveManager.moveGeneralization(d,(Generalization) element, isRectilinear);
		}		
	}
}
