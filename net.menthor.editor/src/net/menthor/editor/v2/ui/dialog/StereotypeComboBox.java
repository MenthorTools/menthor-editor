package net.menthor.editor.v2.ui.dialog;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import RefOntoUML.stereotypes.ClassStereotype;
import RefOntoUML.stereotypes.DataTypeStereotype;
import RefOntoUML.stereotypes.OntoUMLStereotype;
import RefOntoUML.stereotypes.RelationshipStereotype;

@SuppressWarnings("rawtypes")
public class StereotypeComboBox extends JComboBox{

	private static final long serialVersionUID = 291715977335360487L;
	
	@SuppressWarnings("unchecked")
	StereotypeComboBox(RefOntoUML.Element element){		
		if(element instanceof RefOntoUML.Class) setModel(new DefaultComboBoxModel(ClassStereotype.values()));
		else if(element instanceof RefOntoUML.DataType) setModel(new DefaultComboBoxModel(DataTypeStereotype.values()));
		else if(element instanceof RefOntoUML.Association) setModel(new DefaultComboBoxModel(RelationshipStereotype.values()));
	}
	
	public void setSelected(RefOntoUML.Element element){
		if(element instanceof RefOntoUML.Class) setSelectedItem(ClassStereotype.getClassType(element));
		else if(element instanceof RefOntoUML.DataType) setSelectedItem(DataTypeStereotype.getDataType((RefOntoUML.DataType)element));
		else if(element instanceof RefOntoUML.Association) setSelectedItem(RelationshipStereotype.getRelationshipType((RefOntoUML.Association)element));
		setEnabled(true);
	}
	
	public String getSelectedName(){
		OntoUMLStereotype stereo = (OntoUMLStereotype) getSelectedItem();
		return stereo.getName();
	}
}
