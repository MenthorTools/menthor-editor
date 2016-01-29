package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.types.RelationshipType;

public class AddRelationshipMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AddRelationshipMenu(CommandListener listener, String text){
		super(listener, text);	
		build();
	}
	
	public AddRelationshipMenu(CommandListener listener){
		super(listener, "Add Relationship");	
		build();
	}
	
	public void build(){
		createMenuItem(RelationshipType.GENERALIZATION.getName(), IconType.MENTHOR_GENERALIZATION, CommandType.ADD_GENERALIZATION);
		createMenuItem(RelationshipType.CHARACTERIZATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_CHARACTERIZATION);
		createMenuItem(RelationshipType.MEDIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_MEDIATION);
		createMenuItem(RelationshipType.FORMAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_FORMAL);
		createMenuItem(RelationshipType.MATERIAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_MATERIAL);
		createMenuItem(RelationshipType.DERIVATION.getName(), IconType.MENTHOR_DERIVATION, CommandType.ADD_DERIVATION);
		createMenuItem(RelationshipType.COMPONENTOF.getName(), IconType.MENTHOR_COMPONENTOF, CommandType.ADD_COMPONENTOF);
		createMenuItem(RelationshipType.MEMBEROF.getName(), IconType.MENTHOR_MEMBEROF, CommandType.ADD_MEMBEROF);
		createMenuItem(RelationshipType.SUBCOLLECTIONOF.getName(), IconType.MENTHOR_SUBCOLLECTIONOF, CommandType.ADD_SUBCOLLECTIONOF);
		createMenuItem(RelationshipType.SUBQUANTITYOF.getName(), IconType.MENTHOR_SUBQUANTITYOF, CommandType.ADD_SUBQUANTITYOF);
		createMenuItem(RelationshipType.STRUCTURATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_STRUCTURATION);
		createMenuItem(RelationshipType.ASSOCIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.ADD_ASSOCIATION);
		sort();
	}
}
