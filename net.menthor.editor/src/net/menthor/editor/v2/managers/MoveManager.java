package net.menthor.editor.v2.managers;

import java.awt.Point;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.LineStyle;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.AddNodeCommand;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.AssociationElement.ReadingDesign;
import org.tinyuml.umldraw.shared.UmlConnection;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Derivation;
import RefOntoUML.Generalization;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.NamedElement;
import RefOntoUML.Type;
import RefOntoUML.parser.OntoUMLParser;

import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.ModelHelper;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.ProjectBrowser;

public class MoveManager {

	public static ProjectBrowser browser;
	public static DiagramManager diagramManager;
	
	public static void setup(DiagramManager mg, ProjectBrowser pb){
		browser = pb;
		diagramManager = mg;
	}
	
	/** Move element to current diagram */
	public static void move(Object element){
		MoveManager.move((RefOntoUML.Element)element,-1, -1, diagramManager.getCurrentDiagramEditor(),true);
	}
	
	/** Mode selected element on the brwoser to a Diagram */
	public static void moveBrowserSelected(DiagramEditor editor, Point location){
		DefaultMutableTreeNode node = browser.getTree().getSelectedNode();
		Object obj = node.getUserObject();				
		MoveManager.move((RefOntoUML.Element)obj, location.x, location.y, editor, true);			
	}
	
	/** Move element to a Diagram */
	public static void move(RefOntoUML.Element element, double x, double y, DiagramEditor d, boolean showmessage){
		if (d!=null && d.getDiagram().containsChild(element) && showmessage){
			if (element instanceof NamedElement) {
				diagramManager.getFrame().showInformationMessageDialog(
					"Move Manager", element+"\" already exists in diagram "+d.getDiagram().getName());			
			}
			else if (element instanceof Generalization) {
				diagramManager.getFrame().showInformationMessageDialog(
					"Move Manager", element+" already exists in diagram "+d.getDiagram().getName());
			}
			DiagramElement de = ModelHelper.getDiagramElementByDiagram(element, d.getDiagram());
			if(de!=null) d.select(de);
			return;			
		}
		if((element instanceof RefOntoUML.Class) || (element instanceof RefOntoUML.DataType)){			
			MoveManager.moveClass(element, x, y, d);	
		}
		if((element instanceof RefOntoUML.Generalization)){			
			MoveManager.moveGeneralization(d, (RefOntoUML.Generalization)element, false);
		}
		if((element instanceof RefOntoUML.Association)){			
			MoveManager.moveAssociation((RefOntoUML.Association)element, d, false , true, true, true, false, ReadingDesign.UNDEFINED);
		}
	}
	
	/** Move generalization to a diagram. */
	public static void moveGeneralization(DiagramEditor d, Generalization gen, boolean isRectilinear){		
		if (d.getDiagram().containsChild(gen.getGeneral()) && d.getDiagram().containsChild(gen.getSpecific())){	
			UmlConnection conn = d.dragRelation(gen,(EObject)d.getDiagram().getContainer());			
			if (gen.getGeneralizationSet().size()>0){
				Classifier general = gen.getGeneral();
				Classifier specific = gen.getSpecific();
				ClassElement generalElem = (ClassElement)ModelHelper.getDiagramElementByDiagram(general, d.getDiagram());
				ClassElement specificElem = (ClassElement)ModelHelper.getDiagramElementByDiagram(specific, d.getDiagram());
				if (generalElem.getAbsoluteY1() < specificElem.getAbsoluteY1()) d.setLineStyle(conn, LineStyle.TREESTYLE_VERTICAL);
				else if (generalElem.getAbsoluteY1() > specificElem.getAbsoluteY1()) d.setLineStyle(conn, LineStyle.TREESTYLE_VERTICAL);
				else d.setLineStyle(conn, LineStyle.TREESTYLE_HORIZONTAL);
			}
			else if (isRectilinear) d.setLineStyle(conn,  LineStyle.RECTILINEAR);
			else d.setLineStyle(conn,  LineStyle.DIRECT);
			((GeneralizationElement)conn).setShowName(false);
		}
	}
	
	/** Move association to a diagram.*/
	public static void moveAssociation(Association association, DiagramEditor d, boolean isRectilinear, boolean showName, boolean showOntoUMLStereotype, boolean showMultiplicities, boolean showRoles, ReadingDesign direction){		
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
				OntoUMLParser refparser = Models.getRefparser();
				Derivation deriv = refparser.getDerivation((MaterialAssociation)association);
				if(deriv!=null) moveAssociation(deriv, d, false, false, false, true, false, direction);
			}
		}
	}
	
	/** Move associations of an element to the diagram. */
	public static void moveAssociations(RefOntoUML.Element element, DiagramEditor d){
		OntoUMLParser refparser = Models.getRefparser();		
		for(RefOntoUML.Association a: refparser.getDirectAssociations((RefOntoUML.Classifier)element)){
			if(a instanceof MaterialAssociation){						
				Derivation deriv = refparser.getDerivation((MaterialAssociation)a);
				if(deriv!=null) MoveManager.moveAssociation(deriv, d, false, false, false, true, false, ReadingDesign.UNDEFINED);
			}			
			if(!d.getDiagram().containsChild(a)) MoveManager.moveAssociation(a, d, false, true, true, true, false, ReadingDesign.UNDEFINED);		
		}
	}
	
	/** Move generalizations of an element to the diagram. */
	public static void moveGeneralizations(RefOntoUML.Element element, DiagramEditor d){
		OntoUMLParser refparser = Models.getRefparser();
		for(RefOntoUML.Generalization gen: refparser.getGeneralizations((RefOntoUML.Classifier)element)){
			if(!d.getDiagram().containsChild(gen)) MoveManager.moveGeneralization(d, gen, false);
		}
	}
	
	/** Move class to a diagram  */
	public static void moveClass(RefOntoUML.Element element, double x, double y, DiagramEditor d)	{
		AddNodeCommand cmd = new AddNodeCommand(d,d.getDiagram(),element,x,y, d.getProject(),(RefOntoUML.Element)element.eContainer());		
		cmd.run();			 
		MoveManager.moveGeneralizations(element,d);		   
		MoveManager.moveAssociations(element, d);
	}	
}
