package net.menthor.editor.v2.types;

/*
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
 * 
 * @author John Guerson
 */

public enum PatternType {
 
	PHASE_PARTITION("Phase Partition"),
	SUBKIND_PARTITION("SubKind Partition"), 
	ROLE_PARTITION("Role Partition"),
	KIND_PARTITION("Kind Partition"), 
	COLLECTIVE_PARTITION("Collective Partition"), 
	QUANTITY_PARTITION("Quantity Partition"),	
	ROLEMIXIN("RoleMixin"), 
	RELATOR("Relator"),
	CATEGORY("Category"),	 
	MIXIN("Mixin"), 
	MIXIN_WITH_SUBKIND("Mixin with Subkind"),	
	DEPENDENT_ROLEMIXIN("Dependent RoleMixin"), 
	GENERIC_RELATOR("Generic Relator"),
	CHARACTERIZATION("Characterization"),
	RIGID_WEAK_SUPPLEMENTATION("Rigid Weak Supplementation"),
	ANTIRIGID_WEAK_SUPPLEMENTATION("AntiRigid Weak Supplementation"),
	COMPLETER("Complete"),
	DOMAIN_PATTERN("Domain Dependent Pattern");
	
	private String name;

	PatternType(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public String getName() { return name; }

	public static void main (String args[])
	{
		for(PatternType c: PatternType.values()){
			System.out.println(c.name);
		}
	}
}
