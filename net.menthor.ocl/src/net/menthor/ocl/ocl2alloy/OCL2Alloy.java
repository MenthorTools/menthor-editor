package net.menthor.ocl.ocl2alloy;

import net.menthor.ocl.ocl2alloy.exception.IteratorException;
import net.menthor.ocl.ocl2alloy.exception.LiteralException;
import net.menthor.ocl.ocl2alloy.exception.OperationException;
import net.menthor.ocl.ocl2alloy.exception.StereotypeException;
import net.menthor.ocl.ocl2alloy.exception.TypeException;
import net.menthor.ocl.parser.OCLParser;

import org.eclipse.uml2.uml.Constraint;

/**
 * @author John Guerson
 */

public class OCL2Alloy {	
	
	public static String log;		
	public static Boolean succeeds;
	
	public static String convertToAlloy(OCLParser oclparser)
	{
		String result = new String();			
		log = new String();		
		succeeds = false;		
		OCL2AlloyOption opt = new OCL2AlloyOption(oclparser);
		OCL2AlloyVisitor myVisitor = new OCL2AlloyVisitor(oclparser,oclparser.getOntoUMLParser(), opt);				
		for(Constraint ct: oclparser.getConstraints())
		{	
			try{				
				result += myVisitor.visitConstraint(ct);		
				succeeds = true;				
			}catch(IteratorException e){
				log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false;				
			}catch(LiteralException e){
				log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false;				
			}catch(OperationException e){
				log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false;				
			}catch(StereotypeException e){
				log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false;				
			}catch(TypeException e){
				log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false; 
			}			
		}		
		if (myVisitor.getLibrary()!=null && !myVisitor.getLibrary().isEmpty()) result += myVisitor.getLibrary();		
		return result;
	}	
	
	public static String convertToAlloy (OCLParser oclparser, OCL2AlloyOption opt)
	{
		String result = new String();			
		log = new String();		
		succeeds = false;		
		OCL2AlloyVisitor myVisitor = new OCL2AlloyVisitor(oclparser,oclparser.getOntoUMLParser(),opt);				
		for(Constraint ct: oclparser.getConstraints())
		{	
			try{
				result += myVisitor.visitConstraint(ct);				
				succeeds = true;				
			}catch(IteratorException e){
				log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false;				
			}catch(LiteralException e){
				log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false;				
			}catch(OperationException e){
				log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false;				
			}catch(StereotypeException e){
				log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false;				
			}catch(TypeException e){
				log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false; 
			}			
		}				
		if (myVisitor.getLibrary()!=null && !myVisitor.getLibrary().isEmpty()) result += myVisitor.getLibrary();		
		return result;
	}

	public static String convertConstraintToAlloy (Constraint ct, String stereo, OCLParser oclparser)
	{
		if (stereo.equalsIgnoreCase("SIMULATION")) stereo = "SIMULATE";
		if (stereo.equalsIgnoreCase("ASSERTION")) stereo = "CHECK";
		if (stereo.equalsIgnoreCase("RESTRICT")) stereo = "FACT";
		if (!stereo.equalsIgnoreCase("FACT") && !stereo.equalsIgnoreCase("SIMULATE") && !stereo.equalsIgnoreCase("CHECK")) {
			log += "Invalid Alloy stereotype. Possible values are: FACT, SIMULATE or CHECK. ";
			succeeds = false;
			return ""; 
		}		
		String result = new String();	
		log = new String();		
		succeeds = false;				
		OCL2AlloyOption opt = new OCL2AlloyOption();
		opt.getTransformationType().set(opt.getTransformationType().indexOf(ct),stereo);
		OCL2AlloyVisitor myVisitor = new OCL2AlloyVisitor(oclparser, oclparser.getOntoUMLParser(), opt);		
		try{						
			result += myVisitor.visitConstraint(ct); succeeds = true;						
		}catch(IteratorException e){
			log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false; 			
		}catch(LiteralException e){
			log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false; 			
		}catch(OperationException e){
			log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false; 			
		}catch(StereotypeException e){
			log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false; 			
		}catch(TypeException e){
			log += "Conversion: "+ct.getName()+"\n"+e.getMessage()+"\n"; succeeds=false; 
		}				
		if (myVisitor.getLibrary()!=null && !myVisitor.getLibrary().isEmpty()) result += myVisitor.getLibrary();		
		return result;
	}
}
