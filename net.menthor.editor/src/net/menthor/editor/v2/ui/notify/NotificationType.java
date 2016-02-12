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
	DELETE("deleted","delete"), 
	MODIFY("modified","modify"), 
	MOVE("moved","move"), 
	RESIZE("resized", "resize"),	
	ALIGN("align","aligned"),
	MODIFY_VISIBILITY("visibility modified","modify visibility"),
	COLOR("colored","color"),
	MODIFY_LABEL_TEXT("label text modified","modify label text"),	
	RESET_CONNECTION_POINTS("connection points reseted","reset connection points"), 
	MODIFY_CONNECTION_POINTS("connection points modified","modify connection points"), 
	MODIFY_CONNECTION_TYPE("connection type modified","modify connection type");
	
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
