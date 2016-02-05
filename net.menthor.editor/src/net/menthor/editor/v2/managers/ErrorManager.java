package net.menthor.editor.v2.managers;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.AggregationKind;
import RefOntoUML.Association;
import RefOntoUML.DataType;
import RefOntoUML.Meronymic;
import RefOntoUML.MixinClass;
import RefOntoUML.NamedElement;
import RefOntoUML.PrimitiveType;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.Models;
import net.menthor.editor.v2.element.ErrorElement;
import net.menthor.editor.v2.element.ProblemElement;
import net.menthor.editor.v2.element.ProblemElement.TypeProblem;

public class ErrorManager extends BaseManager {

	// -------- Lazy Initialization

	private static class ErrorLoader {
        private static final ErrorManager INSTANCE = new ErrorManager();
    }	
	public static ErrorManager get() { 
		return ErrorLoader.INSTANCE; 
	}	
    protected ErrorManager() {
        if (ErrorLoader.INSTANCE != null) throw new IllegalStateException("ErrorManager already instantiated");
    }		
	   
    // ----------------------------
        
	private double start =0 ;
	private double end =0 ;
	private List<ErrorElement> errors;
	
	public List<ProblemElement> verifyErrors(){
		double start = System.currentTimeMillis();		
		List<ProblemElement> problems = new ArrayList<ProblemElement>();		
		problems.addAll(getErrors());		
		Collections.sort(problems,new ProblemComparator());
		double end = System.currentTimeMillis();				
		int count=0;
		for(ProblemElement pe: problems) { count++; pe.setIdentifier(count); }		
		TabManager.get().addErrorsEditor(start, end, problems, listener());
		return problems;
	}
	
	public String getTimingMessage(){
		int n = 0;
		if(errors!=null) n = errors.size();
		return MessageFormat.format("Model verified in {0} ms, {1} error(s) found", (end - start), n);
	}

	public List<ErrorElement> getErrors(){	
		errors = new ArrayList<ErrorElement>();
		start = System.currentTimeMillis();		
		List<String> names = new ArrayList<String>();
		for(EObject c: Models.getRefparser().getElements()){			
			checkInvalidStereotype(c);
			checkOclKeyword(c);
			checkMixinsNotAbstract(c);
			checkAssociationArity(c);
			checkAggregationKind(c);
			checkPropertyType(c);
			checkDuplicateName(c, names);
		}
		end = System.currentTimeMillis();
		return errors;
	}
	
	private void checkInvalidStereotype(EObject c){
		OntoUMLParser refparser = Models.getRefparser();
		if(c instanceof RefOntoUML.Class || c instanceof RefOntoUML.Relationship || c instanceof RefOntoUML.DataType){
			if (!refparser.isValidStereotype(c)){
				String message = "Invalid stereotype";
				errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
			}			
		}
	}
	
	private void checkOclKeyword(EObject c){
		OntoUMLParser refparser = Models.getRefparser();
		if(!(c instanceof PrimitiveType) && (c instanceof NamedElement)){
			if(refparser.isOCLkeyword(((NamedElement)c).getName())){
				String message = "Name contains an OCL keyword";
				errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
			}
		}
	}
	
	private void checkMixinsNotAbstract(EObject c){
		if((c instanceof MixinClass) && (((MixinClass)c).isIsAbstract()== false)){ 
			String message = "Mixin not abstract";
			errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
		}		
	}
	
	private void checkAssociationArity(EObject c){
		if(c instanceof Association){
			if(((Association)c).getMemberEnd().size()!=2){ 
				String message = "Association has not two association ends";				
				errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
			}
		}
	}
	
	private void checkAggregationKind(EObject c){
		if(c instanceof Meronymic){
			Meronymic m = (Meronymic)c;
			if(m.getMemberEnd().size()==2){
				if(m.wholeEnd().getAggregation().equals(AggregationKind.NONE)){
					String message = "Whole must have aggregation kind equal to composite or shared";
					errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
				}
				if(!m.partEnd().getAggregation().equals(AggregationKind.NONE)){
					String message = "Part must have aggregation kind equal to none";
					errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
				}
			}
		}
	}
	
	private void checkPropertyType(EObject c){
		if(c instanceof Property){
			if(((Property)c).getType()==null){
				String message = new String();
				if(((Property)c).getAssociation()==null) message = "Attribute type is null";
				else message = "Association end type is null";
				errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
			}
		}
	}
	
	private void checkDuplicateName(EObject c, List<String> existingNames){
		if(c instanceof RefOntoUML.Class || c instanceof DataType){
			String name = ((NamedElement)c).getName();
			if(!existingNames.contains(name)){
				existingNames.add(name);	
			}else{
				String message = new String();
				message = "Duplicated Name. There is more than one type with that same name.";					
				errors.add(new ErrorElement(c,0,message,TypeProblem.APP));
			}				
		}
	}
	
	private class ProblemComparator implements Comparator<ProblemElement>{
        @Override
        public int compare(ProblemElement o1, ProblemElement o2) {
            return o1.getDescription().compareToIgnoreCase(o2.getDescription());
        }
    }
}
