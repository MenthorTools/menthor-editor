package RefOntoUML.stereotypes;

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

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.GeneralizationSet;
import RefOntoUML.Model;
import RefOntoUML.Property;

public enum StructuralStereotype implements OntoUMLStereotype {

	PACKAGE("Package",RefOntoUML.Package.class), 
	MODEL("Model", Model.class), 
	GENERALIZATION_SET("Generalization Set", GeneralizationSet.class), 
	PROPERTY("Property", Property.class);
	
	private String name;
	private Class<? extends EObject> metaClass;

	StructuralStereotype(String name, Class<? extends EObject> metaClass)
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
		return false;
	}

	@Override
	public boolean isDataType() {
		return false;
	}
	
	@Override
	public boolean isGeneralizationSet() {
		return this==GENERALIZATION_SET;
	}

	@Override
	public boolean isPackage() {
		return this==PACKAGE;
	}
	
	public static void main (String args[])
	{
		for(StructuralStereotype c: StructuralStereotype.values()){
			System.out.println(c.name);
		}
	}

	@Override
	public OntoUMLStereotype getMetatype(EObject element) {		
		if(element instanceof RefOntoUML.Package) return PACKAGE;
		if(element instanceof RefOntoUML.Model) return MODEL;
		if(element instanceof RefOntoUML.GeneralizationSet) return GENERALIZATION_SET;
		if(element instanceof RefOntoUML.Property) return PROPERTY;
		return null;
	}
}
