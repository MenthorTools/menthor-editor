package net.menthor.tocl.tocl2alloy;

import java.util.ArrayList;

import net.menthor.ocl.ocl2alloy.OCL2AlloyOption;
import net.menthor.tocl.parser.TOCLParser;

import org.eclipse.uml2.uml.Constraint;

public class TOCL2AlloyOption extends OCL2AlloyOption {

	public ArrayList<Integer> indexes = new ArrayList<Integer>();
		
	public TOCL2AlloyOption(TOCLParser toclparser)
	{
		super(toclparser);
		indexes=toclparser.getTemporalConstraintsIndexes();
	}

	public TOCL2AlloyOption() { }
		
	public TOCLParser getParser()
	{
		return (TOCLParser)super.getParser();
	}
	
	@Override
	public String getConstraintType(Constraint ct) 
	{
		if (indexes.contains(getConstraintList().indexOf(ct))) return "temporal";
		else return super.getConstraintType(ct);
	}
}
