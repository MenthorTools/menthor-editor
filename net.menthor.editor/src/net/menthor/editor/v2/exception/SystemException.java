package net.menthor.editor.v2.exception;

public class SystemException extends Exception {

	private static final long serialVersionUID = 625204333000926074L;

	private ErrorCode code;
	
	public SystemException(ErrorCode code){
		this.code=code;
	}
	
	public ErrorCode getErrorCode() { return code; }	
	public String getUserText() { return ErrorMsgMap.getInstance().getUserText(code); }
	
	public String toString(){
		return "Error "+getErrorCode()+": "+getUserText();
	}
}
