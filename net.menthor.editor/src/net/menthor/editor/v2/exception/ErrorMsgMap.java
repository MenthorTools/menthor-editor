package net.menthor.editor.v2.exception;

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
