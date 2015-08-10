package net.menthor.editor.v2.exception;

public enum IOCode implements ErrorCode {

	LICENSE_NOT_RETRIEVED(300);
	
	private final int number;
	 
	private IOCode(int number) {
		this.number = number;
	}
 
	@Override
	public int getNumber(){
		return number;
	}
}
