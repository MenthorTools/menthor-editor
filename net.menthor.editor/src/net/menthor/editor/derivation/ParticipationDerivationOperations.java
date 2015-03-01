package net.menthor.editor.derivation;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import net.menthor.common.ontoumlfixer.RelationStereotype;
import net.menthor.editor.DiagramManager;
import net.menthor.editor.draw.DiagramElement;
import net.menthor.editor.model.UmlProject;
import net.menthor.editor.ui.diagram.DiagramEditor;
import net.menthor.editor.umldraw.structure.ClassElement;
import net.menthor.editor.umldraw.structure.GeneralizationElement;
import net.menthor.ontouml2text.descriptionSpace.descriptionCategories.Category;
import net.menthor.ontouml2text.descriptionSpace.descriptionCategories.RoleMixin;
import RefOntoUML.Classifier;
import RefOntoUML.Mixin;
import RefOntoUML.MixinClass;
import RefOntoUML.ObjectClass;
import RefOntoUML.SortalClass;
import RefOntoUML.SubstanceSortal;
import apple.awt.CList;

public class ParticipationDerivationOperations {

	public void createDerivedType(DiagramEditor activeEditor,
			UmlProject project, DiagramManager diagramManager) {
	
		
		Fix mainFix = new Fix();
		
		OutcomeFixer of = new OutcomeFixer(diagramManager.getCurrentProject().getModel());
		DerivedTypesOperations.setOf(of);
		DerivedTypesOperations.setDman(diagramManager);
		DerivedTypesOperations.setMainfix(mainFix);
		
		JPanel panel= selectTypesWithDerivation(activeEditor.getSelectedElements());
		List<DiagramElement> classes = activeEditor.getSelectedElements();
		of = new OutcomeFixer(diagramManager.getCurrentProject().getModel());
		Point2D.Double relator_point= findPointtoRelator(activeEditor.getSelectedElements());
		Classifier relator=DerivedTypesOperations.includeElement(relator_point, "", "Relator");
		ArrayList<Fix> fixs= new ArrayList<Fix>();
		Fix fix;
		for (int i = 0; i < activeEditor.getSelectedElements().size(); i++) {
			
			Classifier c = ((ClassElement) activeEditor.getSelectedElements().get(i)).getClassifier();
			
			if(! (c instanceof  ObjectClass)){
				return;
			}
			
			if(((JCheckBox) panel.getComponent(i)).isSelected()){
				Point2D.Double point = new Double(((ClassElement)classes.get(i)).getAbsoluteX1(),((ClassElement)classes.get(i)).getAbsoluteY1()+100);
				Classifier role = null;
				if((c instanceof SortalClass)){
					role= DerivedTypesOperations.includeElement(point, "", "Role");
				}else{
					role= DerivedTypesOperations.includeElement(point, "", "RoleMixin");
				}
				Fix role_fix =of.createGeneralization(role, ((ClassElement) activeEditor.getSelectedElements().get(i)).getClassifier());
				fixs.add(role_fix);
				fix = of.createAssociationBetween(RelationStereotype.MEDIATION, "",
						role, relator);
				fixs.add(fix);
			}
		}
		
		for (Fix fix_ : fixs) {
			mainFix.addAll(fix_);
		}
	
		
		diagramManager.updateMenthor(mainFix);
	}

	private Double findPointtoRelator(List<DiagramElement> selectedElements) {
		double left_point, right_point, high_point, low_point;
		Point2D.Double point = new Point2D.Double();
		/*
		 *  find the left and the right point
		 */
		left_point= ((ClassElement)selectedElements.get(0)).getAbsoluteX1();
		right_point= ((ClassElement)selectedElements.get(0)).getAbsoluteX1();
		high_point= ((ClassElement)selectedElements.get(0)).getAbsoluteY1();
		low_point= ((ClassElement)selectedElements.get(0)).getAbsoluteY1();
		
		for (DiagramElement diagramElement : selectedElements) {
			if(((ClassElement)diagramElement).getAbsoluteX1()<left_point){
				left_point=((ClassElement)diagramElement).getAbsoluteX1();
			}
			if(((ClassElement)diagramElement).getAbsoluteX1()>right_point){
				right_point=((ClassElement)diagramElement).getAbsoluteX1();
			}
			if(((ClassElement)diagramElement).getAbsoluteY1()<low_point){
				low_point=((ClassElement)diagramElement).getAbsoluteY1();
			}
			if(((ClassElement)diagramElement).getAbsoluteY1()>high_point){
				high_point=((ClassElement)diagramElement).getAbsoluteY1();
			}
		}
		point.x= ((right_point-left_point)/2) +left_point;
		point.y= ((high_point-low_point)/2)+low_point+180;

		return point;
	}

	public static JPanel selectTypesWithDerivation(List<DiagramElement> list) {

		JPanel p = new JPanel(new BorderLayout(5, 5));

		JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		
		for (DiagramElement diagramElement : list) {
			JCheckBox check = new JCheckBox(((ClassElement)diagramElement).getLabelText());
			controls.add(check);
		}
		
		p.add(controls, BorderLayout.CENTER);
		ArrayList<String> values = new ArrayList<String>();
		values.add("OK");
		values.add("Cancel");

		int value = JOptionPane.showOptionDialog(null, p,
				"Types With Derivation", JOptionPane.OK_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, values.toArray(),
				values.toArray()[0]);
		
		return controls;
	}
	
	
}
