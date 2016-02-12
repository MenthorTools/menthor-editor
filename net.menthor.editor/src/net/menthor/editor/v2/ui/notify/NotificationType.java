package net.menthor.editor.v2.ui.notify;

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

public enum NotificationType {

	ADD("added","add"),	 
	ALIGN("align","aligned"),
	CONNECTION_TYPE("connection type changed","change connection type"),
	DELETE("deleted","delete"), 
	EDIT_POINTS("connection points edited","edit connection points"),
	MOVE("moved","move"),
	MODIFY("modified","modify"),
	RENAME("renamed","rename"),
	RENAME_LABEL("label renamed","rename label"),
	RESET_POINTS("connection points reseted","reset connection points"),
	VISIBILITY("visibility changed","change visibility"),	 
	RESIZE("resized", "resize"),	
	COLOR("colored"," set color");
	
	private String past;
	private String present;

	NotificationType(String past, String present)
	{
		this.past = past;
		this.present = present;
	}
	
	public String toString() { 
		return getPresent(); 
	}
	
	public String getPast() { 
		return past; 
	}
	
	public String getPresent() { 
		return present; 
	}
	
	public static void main (String args[])
	{
		for(NotificationType c: NotificationType.values()){
			System.out.println(c.past);
		}
	}
	
	
//}
}
