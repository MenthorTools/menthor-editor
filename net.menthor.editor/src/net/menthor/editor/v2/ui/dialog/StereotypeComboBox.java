package net.menthor.editor.v2.ui.dialog;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.OntoUMLMetatype;
import net.menthor.editor.v2.types.RelationshipType;

@SuppressWarnings("rawtypes")
public class StereotypeComboBox extends JComboBox{

	private static final long serialVersionUID = 291715977335360487L;
	
	@SuppressWarnings("unchecked")
	StereotypeComboBox(RefOntoUML.Element element){		
		if(element instanceof RefOntoUML.Class) setModel(new DefaultComboBoxModel(ClassType.values()));
		else if(element instanceof RefOntoUML.DataType) setModel(new DefaultComboBoxModel(DataType.values()));
		else if(element instanceof RefOntoUML.Association) setModel(new DefaultComboBoxModel(RelationshipType.values()));
	}
	
	public void setSelected(RefOntoUML.Element element){
		if(element instanceof RefOntoUML.Class) setSelectedItem(ClassType.getClassType(element));
		else if(element instanceof RefOntoUML.DataType) setSelectedItem(DataType.getDataType((RefOntoUML.DataType)element));
		else if(element instanceof RefOntoUML.Association) setSelectedItem(RelationshipType.getRelationshipType((RefOntoUML.Association)element));
		setEnabled(true);
	}
	
	public String getSelectedName(){
		OntoUMLMetatype stereo = (OntoUMLMetatype) getSelectedItem();
		return stereo.getName();
	}
}
