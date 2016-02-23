package net.menthor.editor.v2.commanders;

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

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.LineStyle;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.AssociationElement.ReadingDesign;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlConnection;
import org.tinyuml.umldraw.shared.UmlNode;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.Derivation;
import RefOntoUML.Generalization;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.NamedElement;
import RefOntoUML.Relationship;
import RefOntoUML.Type;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.controller.BrowserController;
import net.menthor.editor.v2.ui.controller.MessageController;
import net.menthor.editor.v2.ui.controller.TabbedAreaController;
import net.menthor.editor.v2.ui.editor.mode.SelectMode;
import net.menthor.editor.v2.ui.operation.diagram.AddNodeOperation;

public class AddToDiagramCommander extends GenericCommander {
	
	// -------- Lazy Initialization
	
	private static class MoveLoader {
        private static final AddToDiagramCommander INSTANCE = new AddToDiagramCommander();
    }	
	public static AddToDiagramCommander get() { 
		return MoveLoader.INSTANCE; 
	}	
    private AddToDiagramCommander() {
        if (MoveLoader.INSTANCE != null) throw new IllegalStateException("MoveManager already instantiated");
    }		
    
    // ----------------------------
		
	public void moveDownSelectedOnTree(){
		BrowserController.get().moveDown();
	}
	
	public void moveUpSelectedOnTree(){
		BrowserController.get().moveUp();
	}
	
	public void moveSelectedOnTreeToDiagram(Point p){
		OntoumlEditor editor = TabbedAreaController.get().selectedTopOntoumlEditor();
		DefaultMutableTreeNode node = BrowserController.get().selected();
		Object obj = node.getUserObject();				
		addToDiagram((RefOntoUML.Element)obj, p.x, p.y, editor, true);	
	}
	
	/** Move element from project browser to current diagram */
	public void addToDiagram(DefaultMutableTreeNode treeNode){
		Object modelElement = treeNode.getUserObject();
		if(modelElement instanceof RefOntoUML.Class || modelElement instanceof Relationship || modelElement instanceof DataType)
			addToDiagram((RefOntoUML.Element)modelElement,40,40, TabbedAreaController.get().selectedTopOntoumlEditor(),true);
	}
	
	public void addToDiagram(Object element, OntoumlEditor editor){
		addToDiagram((RefOntoUML.Element)element,-1, -1, editor,true);
	}
	
	/** Move element to a Diagram */
	public void addToDiagram(RefOntoUML.Element element, double x, double y, OntoumlEditor d, boolean showmessage){
		if (d!=null && d.getDiagram().containsChild(element) && showmessage){
			if (element instanceof NamedElement) {
				MessageController.get().showInfo("Move Element", element+"\" already exists in diagram "+d.getDiagram().getName());			
			}
			else if (element instanceof Generalization) {
				MessageController.get().showInfo("Move Generalization", element+" already exists in diagram "+d.getDiagram().getName());
			}
			DiagramElement de = OccurenceManager.get().getDiagramElement(element, d.getDiagram());
			if(de!=null) SelectMode.get().select(de);
			return;			
		}
		if((element instanceof RefOntoUML.Class) || (element instanceof RefOntoUML.DataType)){			
			addClassToDiagram(element, x, y, d);	
		}
		if((element instanceof RefOntoUML.Generalization)){			
			addGeneralizationToDiagram(d, (RefOntoUML.Generalization)element, false);
		}
		if((element instanceof RefOntoUML.Association)){			
			addAssociationToDiagram((RefOntoUML.Association)element, d, false , true, true, true, false, ReadingDesign.UNDEFINED);
		}
	}
	
	/** Move generalization to a diagram. */
	public void addGeneralizationToDiagram(OntoumlEditor d, Generalization gen, boolean isRectilinear){		
		if (d.getDiagram().containsChild(gen.getGeneral()) && d.getDiagram().containsChild(gen.getSpecific())){	
			UmlConnection conn = d.dragRelation(gen,(EObject)d.getDiagram().getContainer());			
			if (gen.getGeneralizationSet().size()>0){
				Classifier general = gen.getGeneral();
				Classifier specific = gen.getSpecific();
				ClassElement generalElem = (ClassElement)OccurenceManager.get().getDiagramElement(general, d.getDiagram());
				ClassElement specificElem = (ClassElement)OccurenceManager.get().getDiagramElement(specific, d.getDiagram());
				if (generalElem.getAbsoluteY1() < specificElem.getAbsoluteY1()) d.setLineStyle(conn, LineStyle.TREESTYLE_VERTICAL);
				else if (generalElem.getAbsoluteY1() > specificElem.getAbsoluteY1()) d.setLineStyle(conn, LineStyle.TREESTYLE_VERTICAL);
				else d.setLineStyle(conn, LineStyle.TREESTYLE_HORIZONTAL);
			}
			else if (isRectilinear) d.setLineStyle(conn,  LineStyle.RECTILINEAR);
			else d.setLineStyle(conn,  LineStyle.DIRECT);
		}
	}
	
	/** Move association to a diagram.*/
	public void addAssociationToDiagram(Association association, OntoumlEditor d, boolean isRectilinear, boolean showName, boolean showOntoUMLStereotype, boolean showMultiplicities, boolean showRoles, ReadingDesign direction){		
		Type src = ((Association)association).getMemberEnd().get(0).getType();
		Type tgt = ((Association)association).getMemberEnd().get(1).getType();				
		if (d.getDiagram().containsChild(src) && d.getDiagram().containsChild(tgt)){			
			AssociationElement conn = (AssociationElement) d.dragRelation(association,(EObject)d.getDiagram().getContainer());
			if(isRectilinear) d.setLineStyle(conn, LineStyle.RECTILINEAR);
			else d.setLineStyle(conn, LineStyle.DIRECT);
			conn.setShowMultiplicities(showMultiplicities);
			conn.setShowName(showName);
			conn.setShowOntoUmlStereotype(showOntoUMLStereotype);
			conn.setShowRoles(showRoles);
			conn.setReadingDesign(direction);			
			if(association instanceof MaterialAssociation){				
				OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();
				Derivation deriv = refparser.getDerivation((MaterialAssociation)association);
				if(deriv!=null) addAssociationToDiagram(deriv, d, false, false, false, true, false, direction);
			}
		}
	}
	
	/** Move associations of an element to the diagram. */
	public void addAssociationsToDiagram(RefOntoUML.Element element, OntoumlEditor d){
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();		
		for(RefOntoUML.Association a: refparser.getDirectAssociations((RefOntoUML.Classifier)element)){
			if(a instanceof MaterialAssociation){						
				Derivation deriv = refparser.getDerivation((MaterialAssociation)a);
				if(deriv!=null) addAssociationToDiagram(deriv, d, false, false, false, true, false, ReadingDesign.UNDEFINED);
			}			
			if(!d.getDiagram().containsChild(a)) addAssociationToDiagram(a, d, false, true, true, true, false, ReadingDesign.UNDEFINED);		
		}
	}
	
	/** Move generalizations of an element to the diagram. */
	public void addGeneralizationsToDiagram(RefOntoUML.Element element, OntoumlEditor d){
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();
		for(RefOntoUML.Generalization gen: refparser.getGeneralizations((RefOntoUML.Classifier)element)){
			if(!d.getDiagram().containsChild(gen)) addGeneralizationToDiagram(d, gen, false);
		}
	}
	
	/** Move class to a diagram  */
	public void addClassToDiagram(RefOntoUML.Element element, double x, double y, OntoumlEditor d)	{
		UmlNode node = FactoryManager.get().createNode((RefOntoUML.Type)element, (RefOntoUML.Element)element.eContainer());
		AddNodeOperation cmd = new AddNodeOperation(d,node, x,y);		
		cmd.run();
		addGeneralizationsToDiagram(element,d);		   
		addAssociationsToDiagram(element, d);
	}
	
	/** Bring related elements to diagram */
	public void addRelatedElementsToDiagram(Object diagramElement) {
		
		if(!(diagramElement instanceof ClassElement) || !(((DiagramElement) diagramElement).getDiagram() instanceof StructureDiagram))
			return;
		
		ClassElement ce = (ClassElement)diagramElement;
		StructureDiagram diagram = (StructureDiagram) ce.getDiagram();
		
		Classifier element = ce.getClassifier();
		
		double x = ce.getAbsoluteX2()+30;
		double y = ce.getAbsoluteY1()-30;
		int row = 0;
		int column = 0;
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();			
		HashSet<Type> addedTypes = new HashSet<Type>();			
		ArrayList<Relationship> relatedAssociations = new ArrayList<Relationship>();
		relatedAssociations.addAll(refparser.getDirectAssociations(element));
		relatedAssociations.addAll(refparser.getDirectGeneralizations(element));		
		for(Relationship rel: relatedAssociations){
			try{
				if(diagram.containsChild(rel)) continue;					
				Classifier source = null, target = null;					
				if(rel instanceof Association){
					source = (Classifier)((Association)rel).getMemberEnd().get(0).getType();
					target = (Classifier)((Association)rel).getMemberEnd().get(1).getType();
					addedTypes.add((Association)rel);
				}					
				if(rel instanceof Generalization){
					source = (Classifier)((Generalization)rel).getGeneral();
					target = (Classifier)((Generalization)rel).getSpecific();
				}					
				if(source!=null && !diagram.containsChild(source)) { 
					addToDiagram(source,x+100*column,y+75*row,currentEditor(),false); 
					row++; 						
					if(row>2) {
						row=0; column++;
					} 
					addedTypes.add(source);
				}						
				if(target!=null && !diagram.containsChild(target)) {  
					addToDiagram(target,x+100*column,y+75*row,currentEditor(),false); 
					row++;						
					if(row>2) {
						row=0; 
						column++;
					}
					addedTypes.add(target);
				}					
				if(diagram.containsChild(source) && diagram.containsChild(target)) 
					addToDiagram(rel, -1, -1, currentEditor(), false);					
			}catch(Exception e){					
				MessageController.get().showError(e, "Related Elements", "Could not add all related elements.");
			}
		}			
		HashSet<Type> typesInDiagram = new HashSet<Type>();
		for (DiagramElement de : diagram.getChildren()) {
			if(de instanceof ClassElement)
				typesInDiagram.add(((ClassElement) de).getClassifier());
		}			
		for (Association a : refparser.getAssociationsBetween(typesInDiagram)) {
			Type source = a.getMemberEnd().get(0).getType();
			Type target = a.getMemberEnd().get(1).getType();				
			if(!diagram.containsChild(a) && (addedTypes.contains(source) || addedTypes.contains(target)))
				addToDiagram(a, -1, -1,currentEditor(), false);
		}			
		for (Generalization g : refparser.getGeneralizationsBetween(typesInDiagram)) {
			RefOntoUML.Type specific = g.getSpecific();
			RefOntoUML.Type general = g.getGeneral();			
			if(!diagram.containsChild(g) && (addedTypes.contains(specific) || addedTypes.contains(general)))
				addToDiagram(g,-1,-1,currentEditor(), false);
		}			
		
	}
}
