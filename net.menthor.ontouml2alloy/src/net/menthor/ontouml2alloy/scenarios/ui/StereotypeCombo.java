package net.menthor.ontouml2alloy.scenarios.ui;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.stereotypes.OntoUMLStereotype;

public class StereotypeCombo extends JComboBox<OntoUMLStereotype>{
	
	private static final long serialVersionUID = 2721908823135720575L;

	public StereotypeCombo(){
		ArrayList<OntoUMLStereotype> list = new ArrayList<OntoUMLStereotype>();
	
		for (OntoUMLStereotype s : RefOntoUML.stereotypes.ClassStereotype.getClassTypes()) {
			list.add(s);
		}
		for (OntoUMLStereotype s : RefOntoUML.stereotypes.DataTypeStereotype.getDataTypes()) {
			list.add(s);
		}
		for (OntoUMLStereotype s : RefOntoUML.stereotypes.RelationshipStereotype.getRelationshipTypes()) {
			list.add(s);
		}
		
		OntoUMLStereotype[] array = new OntoUMLStereotype[list.size()];
		array = list.toArray(array);
		
		setModel(new DefaultComboBoxModel<OntoUMLStereotype>(array));
	}
	
	public Class<? extends EObject> getSelectedMetaClass(){
		if(getSelectedItem()==null)
			return null;
		
		return ((OntoUMLStereotype)getSelectedItem()).getMetaclass();
	}
	
	

}
