package net.menthor.editor.v2.types;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Category;
import RefOntoUML.Collective;
import RefOntoUML.Kind;
import RefOntoUML.Mixin;
import RefOntoUML.Mode;
import RefOntoUML.NominalQuality;
import RefOntoUML.NonPerceivableQuality;
import RefOntoUML.PerceivableQuality;
import RefOntoUML.Phase;
import RefOntoUML.Quantity;
import RefOntoUML.Relator;
import RefOntoUML.Role;
import RefOntoUML.RoleMixin;
import RefOntoUML.SubKind;

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

public enum ClassType implements OntoUMLMetatype {
	
	CLASS("Class",RefOntoUML.Class.class),
	KIND("Kind", Kind.class), 
	QUANTITY("Quantity", Quantity.class), 
	COLLECTIVE("Collective", Collective.class), 
	RELATOR("Relator", Relator.class), 
	MODE("Mode", Mode.class), 
	PERCEIVABLE_QUALITY("Perceivable Quality", PerceivableQuality.class), 
	NONPERCEIVABLE_QUALITY("NonPerceivable Quality", NonPerceivableQuality.class), 
	NOMINAL_QUALITY("Nominal Quality", NominalQuality.class),
	SUBKIND("SubKind", SubKind.class), 
	ROLE("Role", Role.class), 
	PHASE("Phase", Phase.class), 
	CATEGORY("Category", Category.class), 
	MIXIN("Mixin", Mixin.class), 
	ROLEMIXIN("RoleMixin", RoleMixin.class);
	

//  TODO: Classes to be added	
//	PHASEMIXIN("PhaseMixin",null),
//	EVENT("Event",null), 
//	POWERTYPE("PowerType",null);
	
	private String name;
	private Class<? extends EObject> metaClass;

	ClassType(String name, Class<? extends EObject> metaClass)
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

	@Override
	public boolean isAssociation() {
		return false;
	}

	@Override
	public boolean isMeronymic() {
		return false;
	}

	@Override
	public boolean isGeneralization() {
		return false;
	}

	@Override
	public boolean isClass() {
		return true;
	}

	@Override
	public boolean isGeneralizationSet() {
		return false;
	}

	@Override
	public boolean isDataType() {
		return false;
	}
	
	@Override
	public boolean isPackage() {
		return false;
	}
	
	public static void main (String args[])
	{
		for(ClassType c: ClassType.values()){
			System.out.println(c.name);
		}
	}
	
	@Override
	public OntoUMLMetatype getMetatype(EObject element){
		return (OntoUMLMetatype)getClassType(element);
	}

	public static ClassType getClassType(EObject element) {
		for (ClassType value : ClassType.values()) {
			if(value!=CLASS && value.metaClass.isInstance(element))
				return value;
		}
		return CLASS;
	}

	public static ClassType getClassType(String value) {
		for (ClassType item : ClassType.values()) {
			if(item.getName().compareToIgnoreCase(value)==0)
				return item;
		}
		return CLASS;
	}
}
