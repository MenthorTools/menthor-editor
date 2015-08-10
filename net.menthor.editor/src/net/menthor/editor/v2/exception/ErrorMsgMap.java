package net.menthor.editor.v2.exception;

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

import java.util.HashMap;
import java.util.Map;

public class ErrorMsgMap {

	private static ErrorMsgMap instance = new ErrorMsgMap();
	public static ErrorMsgMap getInstance() { return instance; }
	
	private Map<ErrorCode, String> map = new HashMap<ErrorCode, String>();
	
	public ErrorMsgMap(){
		map.put(ExportationCode.ECORE_NOT_EXPORTED,"Current project could not be exported to Ecore.");
		map.put(ExportationCode.IMAGE_NOT_EXPORTED,"Diagram could not be exported to image file (PNG)");
		map.put(ExportationCode.UML_NOT_EXPORTED,"Current project could not be exported to UML");
		map.put(ExportationCode.XMI_NOT_EXPORTED,"Current project could not be exported to XMI");
	}
	
	public String getUserText(ErrorCode code){
		return map.get(code);
	}
}
