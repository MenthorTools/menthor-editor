package net.menthor.common.settings.owl;

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

public enum OWL2GeneralizationSet {
	
	ALLCLASSES("All Classes"),
	LEAFCLASSES("Leaf Classes"),
	_1STCLASSES("1st Classes");
	
	private String name;

	OWL2GeneralizationSet(String value){
		this.name = value;
	}

	public String getName() { return name; }

	public static OWL2GeneralizationSet getByName(String name){
		if(ALLCLASSES.getName().compareToIgnoreCase(name)==0) return ALLCLASSES;
		else if(LEAFCLASSES.getName().compareToIgnoreCase(name)==0) return LEAFCLASSES;
		else if(_1STCLASSES.getName().compareToIgnoreCase(name)==0) return _1STCLASSES;
		else return null;
	}
	
	public String toString(){
		return getName();
	}
	
	public static void main (String args[])
	{
		for(OWL2GeneralizationSet c: OWL2GeneralizationSet.values()){
			System.out.println(c);
		}
	}
}
