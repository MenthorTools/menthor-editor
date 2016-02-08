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

import java.util.List;
import java.util.Set;

import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.AssociationElement.ReadingDesign;
import org.tinyuml.umldraw.GeneralizationElement;

import RefOntoUML.Association;
import RefOntoUML.Generalization;
import RefOntoUML.Type;

public class RemakeManager extends BaseManager {

	// -------- Lazy Initialization
	
	private static class RemakeLoader {
        private static final RemakeManager INSTANCE = new RemakeManager();
    }	
	public static RemakeManager get() { 
		return RemakeLoader.INSTANCE; 
	}	
    private RemakeManager() {
        if (RemakeLoader.INSTANCE != null) throw new IllegalStateException("RemakeManager already instantiated");
    }		
    
    // ----------------------------
	
	/** Re-make all associations in all diagrams they appear. */
	public void remakeAllAssociations(){
		Set<Association> list = ProjectManager.get().getProject().getRefParser().getAllInstances(Association.class);
		for(Association a: list){
			remakeRelationship(a);
		}
	}
		
	
	/** Re-make element in all diagrams they appear */
	public void remakeRelationship(RefOntoUML.Element element){
		List<DiagramEditor> editors = OccurenceManager.get().getDiagramEditors(element);
		for(DiagramEditor diagramEditor: editors ){
			remakeRelationship(element,diagramEditor);
		}
		if(editors==null || editors.size()==0){
			if (element instanceof RefOntoUML.Association){
				Type source = ((Association)element).getMemberEnd().get(0).getType();
				Type target = ((Association)element).getMemberEnd().get(1).getType();				
				for(DiagramEditor ed: OccurenceManager.get().getDiagramEditors(source)){
					if (OccurenceManager.get().getDiagramEditors(target).contains(ed)){						
						remakeRelationship(element, ed);
					}
				}				
			}
			if (element instanceof RefOntoUML.Generalization){
				Type general = ((Generalization)element).getGeneral();
				Type specific = ((Generalization)element).getSpecific();
				for(DiagramEditor ed: OccurenceManager.get().getDiagramEditors(general)){
					if (OccurenceManager.get().getDiagramEditors(specific).contains(ed)){
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
			AssociationElement ae = (AssociationElement) OccurenceManager.get().getDiagramElement(element, d.getDiagram());
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
			GeneralizationElement ge = (GeneralizationElement) OccurenceManager.get().getDiagramElement(element, d.getDiagram());
			if (ge!=null) isRectilinear = ge.isTreeStyle();			
			DeletionManager.get().eraseElement(d, element);
			MoveManager.get().moveGeneralization(d,(Generalization) element, isRectilinear);
		}		
	}
}
