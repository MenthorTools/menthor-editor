package net.menthor.editor.v2.types;

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

public enum RelationshipType {

	ASSOCIATION("Association"), 
	GENERALIZATION("Generalization"), 
	GENERALIZATIONSET("GeneralizationSet"),
	CHARACTERIZATION("Characterization"), 
	MEDIATION("Mediation"), 
	DERIVATION("Derivation"), 
	STRUCTURATION("Structuration"), 
	FORMAL("Formal"), 
	MATERIAL("Material"), 
	COMPONENTOF("ComponentOf"), 
	MEMBEROF("MemberOf"), 
	SUBCOLLECTIONOF("SubCollectionOf"), 
	SUBQUANTITYOF("SubQuantityOf"),
	SUBEVENTOF("SubEventOf"), 
	PARTICIPATION("Participation"), 
	TEMPORAL("Temporal"),
	INSTANCEOF("InstanceOf");
	
	private String name;

	RelationshipType(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public String getName() { return name; }

	public static RelationshipType getRelationshipType(RefOntoUML.Relationship type){
		if(type instanceof RefOntoUML.Generalization) return RelationshipType.GENERALIZATION;
		if(type instanceof RefOntoUML.Characterization) return RelationshipType.CHARACTERIZATION;
		if(type instanceof RefOntoUML.componentOf) return RelationshipType.COMPONENTOF;
		if(type instanceof RefOntoUML.Derivation) return RelationshipType.DERIVATION;
		if(type instanceof RefOntoUML.FormalAssociation) return RelationshipType.FORMAL;
		if(type instanceof RefOntoUML.MaterialAssociation) return RelationshipType.MATERIAL;
		if(type instanceof RefOntoUML.Mediation) return RelationshipType.MEDIATION;
		if(type instanceof RefOntoUML.memberOf) return RelationshipType.MEMBEROF;
		if(type instanceof RefOntoUML.Structuration) return RelationshipType.STRUCTURATION;
		if(type instanceof RefOntoUML.subCollectionOf) return RelationshipType.SUBCOLLECTIONOF;
		if(type instanceof RefOntoUML.subQuantityOf) return RelationshipType.SUBQUANTITYOF;
		if(type instanceof RefOntoUML.Association) return RelationshipType.ASSOCIATION;
		return RelationshipType.ASSOCIATION;		
	}
	
	public static void main (String args[])
	{
		for(RelationshipType c: RelationshipType.values()){
			System.out.println(c.name);
		}
	}
}
