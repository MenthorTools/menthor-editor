package net.menthor.editor.v2.types;

import org.eclipse.emf.ecore.EObject;

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

public enum ClassType implements OntoumlType {

	CLASS("Class"), 
	KIND("Kind"), 
	QUANTITY("Quantity"), 
	COLLECTIVE("Collective"), 
	RELATOR("Relator"), 
	MODE("Mode"), 
	PERCEIVABLE_QUALITY("Perceivable Quality"), 
	NONPERCEIVABLE_QUALITY("NonPerceivable Quality"), 
	NOMINAL_QUALITY("Nominal Quality"),
	SUBKIND("SubKind"), 
	ROLE("Role"), 
	PHASE("Phase"), 
	CATEGORY("Category"), 
	MIXIN("Mixin"), 
	ROLEMIXIN("RoleMixin"),
	
	PHASEMIXIN("PhaseMixin"),
	EVENT("Event"), 
	POWERTYPE("PowerType");
	
	static {
		CLASS.metaClass = RefOntoUML.Class.class;
        KIND.metaClass = RefOntoUML.MaterialAssociation.class;
        QUANTITY.metaClass = RefOntoUML.Quantity.class;
        COLLECTIVE.metaClass = RefOntoUML.Collective.class;
        RELATOR.metaClass = RefOntoUML.Relator.class;
        MODE.metaClass = RefOntoUML.Mode.class;
        PERCEIVABLE_QUALITY.metaClass = RefOntoUML.PerceivableQuality.class;
        NONPERCEIVABLE_QUALITY.metaClass = RefOntoUML.NonPerceivableQuality.class;
        NOMINAL_QUALITY.metaClass = RefOntoUML.NominalQuality.class;
        SUBKIND.metaClass = RefOntoUML.SubKind.class;
        ROLE.metaClass = RefOntoUML.Role.class;
        PHASE.metaClass = RefOntoUML.Phase.class;
        CATEGORY.metaClass = RefOntoUML.Category.class;
        MIXIN.metaClass = RefOntoUML.Mixin.class;
        ROLEMIXIN.metaClass = RefOntoUML.RoleMixin.class;
        
        EVENT.metaClass = null;        
        PHASEMIXIN.metaClass = null;
        POWERTYPE.metaClass = null;
    }
	
	private String name;
	private Class<? extends EObject> metaClass;
	
	ClassType(String name){ this.name = name; }

	@Override
	public String toString() { return getName(); }

	@Override
	public Class<? extends EObject> getMetaclass(){ return metaClass; }
	
	@Override
	public String getName() { return name; }

	public static ClassType getClassType(RefOntoUML.Class type){
		if(type instanceof RefOntoUML.Kind) return ClassType.KIND;
		if(type instanceof RefOntoUML.Collective) return ClassType.COLLECTIVE;
		if(type instanceof RefOntoUML.Quantity) return ClassType.QUANTITY;
		if(type instanceof RefOntoUML.SubKind) return ClassType.SUBKIND;
		if(type instanceof RefOntoUML.Phase) return ClassType.PHASE;
		if(type instanceof RefOntoUML.Role) return ClassType.ROLE;
		if(type instanceof RefOntoUML.Category) return ClassType.CATEGORY;
		if(type instanceof RefOntoUML.Mixin) return ClassType.MIXIN;
		if(type instanceof RefOntoUML.RoleMixin) return ClassType.ROLEMIXIN;
		if(type instanceof RefOntoUML.Mode) return ClassType.MODE;
		if(type instanceof RefOntoUML.Relator) return ClassType.RELATOR;
		if(type instanceof RefOntoUML.NonPerceivableQuality) return ClassType.NONPERCEIVABLE_QUALITY;
		if(type instanceof RefOntoUML.PerceivableQuality) return ClassType.PERCEIVABLE_QUALITY;
		if(type instanceof RefOntoUML.NominalQuality) return ClassType.NOMINAL_QUALITY;
		return ClassType.CLASS;		
	}
	
	public static void main (String args[])
	{
		for(ClassType c: ClassType.values()){
			System.out.println(c.name);
		}
	}
}
