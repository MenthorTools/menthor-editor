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

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.LineStyle;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.commands.AddNodeCommand;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.AssociationElement.ReadingDesign;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.shared.UmlConnection;

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
import net.menthor.editor.v2.managers.MessageManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.manager.BrowserManager;
import net.menthor.editor.v2.ui.manager.TabManager;

public class MoveCommander {
	
	// -------- Lazy Initialization
	
	private static class MoveLoader {
        private static final MoveCommander INSTANCE = new MoveCommander();
    }	
	public static MoveCommander get() { 
		return MoveLoader.INSTANCE; 
	}	
    private MoveCommander() {
        if (MoveLoader.INSTANCE != null) throw new IllegalStateException("MoveManager already instantiated");
    }		
    
    // ----------------------------
		
	public void moveDownSelectedOnTree(){
		BrowserManager.get().moveDown();
	}
	
	public void moveUpSelectedOnTree(){
		BrowserManager.get().moveUp();
	}
	
	public void moveSelectedOnTreeToDiagram(Point p){
		OntoumlEditor editor = TabManager.get().getCurrentDiagramEditor();
		DefaultMutableTreeNode node = BrowserManager.get().selected();
		Object obj = node.getUserObject();				
		move((RefOntoUML.Element)obj, p.x, p.y, editor, true);	
	}
	
	/** Move element from project browser to current diagram */
	public void move(DefaultMutableTreeNode treeNode){
		Object modelElement = treeNode.getUserObject();
		if(modelElement instanceof RefOntoUML.Class || modelElement instanceof Relationship || modelElement instanceof DataType)
			move((RefOntoUML.Element)modelElement,-1, -1, TabManager.get().getCurrentDiagramEditor(),true);
	}
	
	public void move(Object element, OntoumlEditor editor){
		move((RefOntoUML.Element)element,-1, -1, editor,true);
	}
	
	/** Move element to a Diagram */
	public void move(RefOntoUML.Element element, double x, double y, OntoumlEditor d, boolean showmessage){
		if (d!=null && d.getDiagram().containsChild(element) && showmessage){
			if (element instanceof NamedElement) {
				MessageManager.get().showInfo("Move Element", element+"\" already exists in diagram "+d.getDiagram().getName());			
			}
			else if (element instanceof Generalization) {
				MessageManager.get().showInfo("Move Generalization", element+" already exists in diagram "+d.getDiagram().getName());
			}
			DiagramElement de = OccurenceManager.get().getDiagramElement(element, d.getDiagram());
			if(de!=null) d.select(de);
			return;			
		}
		if((element instanceof RefOntoUML.Class) || (element instanceof RefOntoUML.DataType)){			
			moveClass(element, x, y, d);	
		}
		if((element instanceof RefOntoUML.Generalization)){			
			moveGeneralization(d, (RefOntoUML.Generalization)element, false);
		}
		if((element instanceof RefOntoUML.Association)){			
			moveAssociation((RefOntoUML.Association)element, d, false , true, true, true, false, ReadingDesign.UNDEFINED);
		}
	}
	
	/** Move generalization to a diagram. */
	public void moveGeneralization(OntoumlEditor d, Generalization gen, boolean isRectilinear){		
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
	public void moveAssociation(Association association, OntoumlEditor d, boolean isRectilinear, boolean showName, boolean showOntoUMLStereotype, boolean showMultiplicities, boolean showRoles, ReadingDesign direction){		
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
				if(deriv!=null) moveAssociation(deriv, d, false, false, false, true, false, direction);
			}
		}
	}
	
	/** Move associations of an element to the diagram. */
	public void moveAssociations(RefOntoUML.Element element, OntoumlEditor d){
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();		
		for(RefOntoUML.Association a: refparser.getDirectAssociations((RefOntoUML.Classifier)element)){
			if(a instanceof MaterialAssociation){						
				Derivation deriv = refparser.getDerivation((MaterialAssociation)a);
				if(deriv!=null) moveAssociation(deriv, d, false, false, false, true, false, ReadingDesign.UNDEFINED);
			}			
			if(!d.getDiagram().containsChild(a)) moveAssociation(a, d, false, true, true, true, false, ReadingDesign.UNDEFINED);		
		}
	}
	
	/** Move generalizations of an element to the diagram. */
	public void moveGeneralizations(RefOntoUML.Element element, OntoumlEditor d){
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();
		for(RefOntoUML.Generalization gen: refparser.getGeneralizations((RefOntoUML.Classifier)element)){
			if(!d.getDiagram().containsChild(gen)) moveGeneralization(d, gen, false);
		}
	}
	
	/** Move class to a diagram  */
	public void moveClass(RefOntoUML.Element element, double x, double y, OntoumlEditor d)	{
		AddNodeCommand cmd = new AddNodeCommand(d,d.getDiagram(),element,x,y, (RefOntoUML.Element)element.eContainer());		
		cmd.run();
		moveGeneralizations(element,d);		   
		moveAssociations(element, d);
	}	
}
