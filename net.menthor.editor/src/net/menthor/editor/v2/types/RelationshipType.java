package net.menthor.editor.v2.types;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Association;
import RefOntoUML.Characterization;
import RefOntoUML.Derivation;
import RefOntoUML.FormalAssociation;
import RefOntoUML.Generalization;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.Mediation;
import RefOntoUML.Structuration;
import RefOntoUML.componentOf;
import RefOntoUML.memberOf;
import RefOntoUML.subCollectionOf;
import RefOntoUML.subQuantityOf;


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

public enum RelationshipType implements OntoUMLMetatype{
	
	ASSOCIATION("Association", Association.class), 
	CHARACTERIZATION("Characterization", Characterization.class), 
	MEDIATION("Mediation", Mediation.class), 
	DERIVATION("Derivation", Derivation.class), 
	STRUCTURATION("Structuration", Structuration.class), 
	FORMAL("Formal", FormalAssociation.class), 
	MATERIAL("Material", MaterialAssociation.class), 
	COMPONENTOF("ComponentOf", componentOf.class), 
	MEMBEROF("MemberOf", memberOf.class), 
	SUBCOLLECTIONOF("SubCollectionOf", subCollectionOf.class), 
	SUBQUANTITYOF("SubQuantityOf", subQuantityOf.class),
	GENERALIZATION("Generalization", Generalization.class); 
	
//  TODO: Associations to be added
//	SUBEVENTOF("SubEventOf", null), 
//	PARTICIPATION("Participation", null), 
//	TEMPORAL("Temporal", null),
//	INSTANCEOF("InstanceOf", null),
		
	private String name;
	private Class<? extends EObject> metaClass;

	RelationshipType(String name, Class<? extends EObject> metaClass)
	{
		this.name = name;
		this.metaClass = metaClass;
	}

	@Override
	public String toString() { 
		return getName(); 
	}
	
	@Override
	public Class<? extends EObject> getMetaclass(){ 
		return metaClass; 
	}
	
	@Override
	public String getName() { 
		return name; 
	}

	public boolean isAssociation(){
		if(this==GENERALIZATION)
			return false;
		return true;
	}
	
	public boolean isMeronymic(){
		if(!this.isAssociation())
			return false;
		
		if(this==COMPONENTOF || this==MEMBEROF ||this==SUBCOLLECTIONOF ||this==SUBQUANTITYOF)
			return true;
		
		return false;
	}
	
	public boolean isGeneralization(){
		return this==GENERALIZATION;
	}

	@Override
	public boolean isClass() {
		return false;
	}

	@Override
	public boolean isGeneralizationSet() {
		return false;
	}

	@Override
	public boolean isPackage() {
		return false;
	}
	
	@Override
	public boolean isDataType(){
		return false;
	}
	
	@Override
	public OntoUMLMetatype getMetatype(EObject relationship){
		return (OntoUMLMetatype)getRelationshipType(relationship);
	}
	
	public static RelationshipType getRelationshipType(EObject relationship) {
		for (RelationshipType value : RelationshipType.values()) {
			if(value!=ASSOCIATION && value.metaClass.isInstance(relationship))
				return value;
		}
		return ASSOCIATION;
	}
	
	public static void main (String args[])
	{
		for(RelationshipType c: RelationshipType.values()){
			System.out.println(c.name);
		}
	}
}
