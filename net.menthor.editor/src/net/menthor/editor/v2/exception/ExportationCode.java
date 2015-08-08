package net.menthor.editor.v2.exception;

public enum ExportationCode implements ErrorCode {

	IMAGE_NOT_EXPORTED(0x100),
	UML_NOT_EXPORTED(0x101),
	ECORE_NOT_EXPORTED(0x102),
	XMI_NOT_EXPORTED(0x103);
	
	private final int number;
	 
	private ExportationCode(int number) {
		this.number = number;
	}
 
	@Override
	public int getNumber(){
		return number;
	}
}
