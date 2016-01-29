package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.types.RelationshipType;

public class ChangeRelationshipMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
		
	public ChangeRelationshipMenu(CommandListener listener){
		super(listener, "Change To");	
		build();
	}
	
	public ChangeRelationshipMenu(CommandListener listener,String text){
		super(listener, text);	
		build();
	}
	
	public void build(){
		createMenuItem(RelationshipType.GENERALIZATION.getName(), IconType.MENTHOR_GENERALIZATION, CommandType.CHANGE_TO_GENERALIZATION);
		createMenuItem(RelationshipType.CHARACTERIZATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_CHARACTERIZATION);
		createMenuItem(RelationshipType.MEDIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_MEDIATION);
		createMenuItem(RelationshipType.FORMAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_FORMAL);
		createMenuItem(RelationshipType.MATERIAL.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_MATERIAL);
		createMenuItem(RelationshipType.DERIVATION.getName(), IconType.MENTHOR_DERIVATION, CommandType.CHANGE_TO_DERIVATION);
		createMenuItem(RelationshipType.COMPONENTOF.getName(), IconType.MENTHOR_COMPONENTOF, CommandType.CHANGE_TO_COMPONENTOF);
		createMenuItem(RelationshipType.MEMBEROF.getName(), IconType.MENTHOR_MEMBEROF, CommandType.CHANGE_TO_MEMBEROF);
		createMenuItem(RelationshipType.SUBCOLLECTIONOF.getName(), IconType.MENTHOR_SUBCOLLECTIONOF, CommandType.CHANGE_TO_SUBCOLLECTIONOF);
		createMenuItem(RelationshipType.SUBQUANTITYOF.getName(), IconType.MENTHOR_SUBQUANTITYOF, CommandType.CHANGE_TO_SUBQUANTITYOF);
		createMenuItem(RelationshipType.STRUCTURATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_STRUCTURATION);
		createMenuItem(RelationshipType.ASSOCIATION.getName(), IconType.MENTHOR_ASSOCIATION, CommandType.CHANGE_TO_ASSOCIATION);
		sort();
	}
}
