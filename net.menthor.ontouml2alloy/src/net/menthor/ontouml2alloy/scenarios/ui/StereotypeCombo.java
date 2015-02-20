package net.menthor.ontouml2alloy.scenarios.ui;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import net.menthor.common.ontoumlfixer.ClassStereotype;
import net.menthor.common.ontoumlfixer.RelationStereotype;
import net.menthor.common.ontoumlfixer.Stereotype;

import org.eclipse.emf.ecore.EObject;

public class StereotypeCombo extends JComboBox<Stereotype>{
	
	private static final long serialVersionUID = 2721908823135720575L;

	public StereotypeCombo(){
		ArrayList<Stereotype> list = new ArrayList<Stereotype>();
	
		for (Stereotype s : ClassStereotype.getClassStereotypes()) {
			list.add(s);
		}
		for (Stereotype s : RelationStereotype.getAssociationStereotypes()) {
			list.add(s);
		}
		
		Stereotype[] array = new Stereotype[list.size()];
		array = list.toArray(array);
		
		setModel(new DefaultComboBoxModel<Stereotype>(array));
	}
	
	public Class<? extends EObject> getSelectedMetaClass(){
		if(getSelectedItem()==null)
			return null;
		
		return ((Stereotype)getSelectedItem()).getMetaclass();
	}
	
	

}
