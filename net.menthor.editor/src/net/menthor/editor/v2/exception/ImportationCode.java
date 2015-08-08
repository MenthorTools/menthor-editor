package net.menthor.editor.v2.exception;

public enum ImportationCode implements ErrorCode {

	XMI_EA_NOT_IMPORTED(0x200),
	XMI_EMF_NOT_IMPORTED(0x201);
		
	private final int number;
	 
	private ImportationCode(int number) {
		this.number = number;
	}
 
	@Override
	public int getNumber(){
		return number;
	}
}
