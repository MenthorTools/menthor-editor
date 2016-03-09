package net.menthor.editor.v2.ui.operation;

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

public enum OperationType {

	ADD("added","add"),	 
	ALIGN("align","aligned"),	
	DELETE("deleted","delete"),
	SUBSTITUTE("substituted", "substitute"),
	TRANSLATE("translated","translate"),
	MODIFY("modified","modify"),
	RENAME("renamed","rename"),
	RENAME_LABEL("label renamed","rename label"),	
	VISIBILITY("visibility changed","change visibility"),	 
	RESIZE("resized", "resize"),	
	COLOR("colored","set color"),
	RESET_POINTS("connection points reseted","reset connection points"),
	EDIT_POINTS("connection points edited","edit connection points"),
	CONNECTION_TYPE("connection type changed","change connection type");
	
	private String past;
	private String present;

	OperationType(String past, String present)
	{
		this.past = past;
		this.present = present;
	}
	
	public String toString() { 
		return presentTense(); 
	}
	
	public String pastTense() { 
		return past; 
	}
	
	public String presentTense() { 
		return present; 
	}
	
	public static void main (String args[])
	{
		for(OperationType c: OperationType.values()){
			System.out.println(c.past);
		}
	}
	
	
//}
}
