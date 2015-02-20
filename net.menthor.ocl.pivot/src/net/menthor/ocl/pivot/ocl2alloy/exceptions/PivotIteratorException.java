package net.menthor.ocl.pivot.ocl2alloy.exceptions;


public class PivotIteratorException extends PivotOCLToAlloyException {

	private static final long serialVersionUID = 1L;

	public PivotIteratorException (String iterator, String justification) 
	{
		super(iterator+" - Unsupported Iterator : "+justification);
	}
}
