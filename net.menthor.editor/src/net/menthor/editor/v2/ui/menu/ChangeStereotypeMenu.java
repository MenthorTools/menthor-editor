package net.menthor.editor.v2.ui.menu;

import javax.swing.JPopupMenu;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Relationship;
import RefOntoUML.stereotypes.ClassStereotype;
import RefOntoUML.stereotypes.DataTypeStereotype;
import RefOntoUML.stereotypes.RelationshipStereotype;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.generic.GenericMenu;
import net.menthor.editor.v2.ui.icon.IconType;

public class ChangeStereotypeMenu extends GenericMenu<EObject> {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public ChangeStereotypeMenu(ICommandListener listener, EObject element, JPopupMenu parent){
		this(listener, "Change Stereotype To", element,parent);
	}
	
	public ChangeStereotypeMenu(ICommandListener listener, String text, EObject element, JPopupMenu parent){
		super(listener, text, element);			
		if(element instanceof RefOntoUML.Class){
			createMenuItem(ClassStereotype.KIND.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_KIND);
			createMenuItem(ClassStereotype.SUBKIND.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_SUBKIND);
			createMenuItem(ClassStereotype.COLLECTIVE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_COLLECTIVE);
			createMenuItem(ClassStereotype.QUANTITY.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_QUANTITY);
			createMenuItem(ClassStereotype.PHASE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_PHASE);
			createMenuItem(ClassStereotype.ROLE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_ROLE);
			createMenuItem(ClassStereotype.CATEGORY.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_CATEGORY);
			createMenuItem(ClassStereotype.ROLEMIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_ROLEMIXIN);
			createMenuItem(ClassStereotype.MIXIN.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_MIXIN);
			createMenuItem(ClassStereotype.RELATOR.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_RELATOR);
			createMenuItem(ClassStereotype.MODE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_MODE);
			createMenuItem(ClassStereotype.PERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_PERCEIVABLE_QUALITY);
			createMenuItem(ClassStereotype.NONPERCEIVABLE_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_NONPERCEIVABLE_QUALITY);
			createMenuItem(ClassStereotype.NOMINAL_QUALITY.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_NOMINAL_QUALITY);
		}
		else if (element instanceof Relationship){
			createMenuItem(RelationshipStereotype.GENERALIZATION.getName(), IconType.MENTHOR_GENERALIZATION, CommandType.CHANGE_TO_GENERALIZATION);
			createMenuItem(RelationshipStereotype.CHARACTERIZATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_CHARACTERIZATION);
			createMenuItem(RelationshipStereotype.MEDIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_MEDIATION);
			createMenuItem(RelationshipStereotype.FORMAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_FORMAL);
			createMenuItem(RelationshipStereotype.MATERIAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_MATERIAL);
			createMenuItem(RelationshipStereotype.DERIVATION.getName(), IconType.MENTHOR_DERIVATION, CommandType.CHANGE_TO_DERIVATION);
			createMenuItem(RelationshipStereotype.COMPONENTOF.getName(), IconType.MENTHOR_COMPONENTOF, CommandType.CHANGE_TO_COMPONENTOF);
			createMenuItem(RelationshipStereotype.MEMBEROF.getName(), IconType.MENTHOR_MEMBEROF, CommandType.CHANGE_TO_MEMBEROF);
			createMenuItem(RelationshipStereotype.SUBCOLLECTIONOF.getName(), IconType.MENTHOR_SUBCOLLECTIONOF, CommandType.CHANGE_TO_SUBCOLLECTIONOF);
			createMenuItem(RelationshipStereotype.SUBQUANTITYOF.getName(), IconType.MENTHOR_SUBQUANTITYOF, CommandType.CHANGE_TO_SUBQUANTITYOF);
			createMenuItem(RelationshipStereotype.STRUCTURATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_STRUCTURATION);
			createMenuItem(RelationshipStereotype.ASSOCIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_ASSOCIATION);
		}
		else if (element instanceof RefOntoUML.DataType){
			createMenuItem(DataTypeStereotype.DATATYPE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_DATATYPE);
			createMenuItem(DataTypeStereotype.ENUMERATION.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_ENUMERATION);
			createMenuItem(DataTypeStereotype.PRIMITIVETYPE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_PRIMITIVETYPE);
			createMenuItem(DataTypeStereotype.DECIMALINTERVAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_DECIMALINTERVAL_DIMENSION);
			createMenuItem(DataTypeStereotype.DECIMALORDINAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_DECIMALORDINAL_DIMENSION);
			createMenuItem(DataTypeStereotype.DECIMALRATIONAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_DECIMALRATIONAL_DIMENSION);
			createMenuItem(DataTypeStereotype.INTEGERINTERVAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_INTEGERINTERVAL_DIMENSION);
			createMenuItem(DataTypeStereotype.INTEGERORDINAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_INTEGERORDINAL_DIMENSION);
			createMenuItem(DataTypeStereotype.INTEGERRATIONAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_INTEGERRATIONAL_DIMENSION);
			createMenuItem(DataTypeStereotype.STRINGNOMINAL_STRUCTURE.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_STRINGNOMINAL_STRUCTURE);
			createMenuItem(DataTypeStereotype.MEASUREMENT_DOMAIN.getName(), IconType.MENTHOR_CLASS, CommandType.CHANGE_TO_MEASUREMENT_DOMAIN);
		}
		sort();		
		parent.add(this);
	}
}