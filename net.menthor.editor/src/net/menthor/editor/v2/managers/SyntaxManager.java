package net.menthor.editor.v2.managers;

/**
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
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;

import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.parser.SyntacticVerificator;
import net.menthor.editor.ui.ErrorVerificator;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.WarningVerificator;
import net.menthor.editor.v2.elements.ErrorElement;
import net.menthor.editor.v2.elements.ProblemElement;
import net.menthor.editor.v2.elements.ProblemElement.TypeProblem;
import net.menthor.tocl.parser.TOCLParser;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;

public class SyntaxManager extends BaseManager{

	// -------- Lazy Initialization

	private static class SyntaxLoader {
        private static final SyntaxManager INSTANCE = new SyntaxManager();
    }	
	public static SyntaxManager get() { 
		return SyntaxLoader.INSTANCE; 
	}	
    private SyntaxManager() {
        if (SyntaxLoader.INSTANCE != null) throw new IllegalStateException("SyntaxManager already instantiated");
    }		
    
    // ----------------------------
	
	public void verifyConstraints(){
		verifyConstraints(true);		
	}
	
	public void verifyConstraints(boolean showSuccesfullyMessage){
		OntoUMLParser refparser = Models.getRefparser();				
		try { 
			String name = ((RefOntoUML.Package)ProjectManager.get().getProject().getResource().getContents().get(0)).getName();
			if (name==null || name.isEmpty()) name = "model";
			TOCLParser toclparser = new TOCLParser(refparser,ProjectManager.get().getProject().getTempDir()+File.separator,name.toLowerCase());
			toclparser.parseTemporalOCL(TabManager.get().getConstraints());			
			Models.setOclOptions(new TOCL2AlloyOption(toclparser));
			String msg =  "Constraints are syntactically correct.\n";
			if(showSuccesfullyMessage) MessageManager.get().showSuccess("Constraints Parse",msg);			
		}catch(SemanticException e2){
			MessageManager.get().showError(e2, "OCL Semantics",  "Could not parse OCl constraints.");    		
		}catch(ParserException e1){
			MessageManager.get().showError(e1, "OCL Parser", "Could not parse OCl constraints.");    			
		}catch(Exception e4){
			MessageManager.get().showError(e4, "OCL", "Could not parse OCl constraints");			
		}				
	}
	
	public void verifyModel(){
		CursorManager.get().waitCursor();		
		List<ProblemElement> errors = verifyErrors();
		List<ProblemElement> warnings = verifyWarnings();
		frame().forceShowFooterPane();
		if(errors.size()>0 && warnings.size()>0) {
			TabManager.get().selectErrorEditor();
			MessageManager.get().showError("Model Verified", "Model verified with "+errors.size()+" errors(s) and "+warnings.size()+" warning(s).");				
		}
		else if(errors.size()>0 && warnings.size()==0) {
			TabManager.get().selectErrorEditor();
			MessageManager.get().showError("Model Verified", "Model verified "+errors.size()+" errors(s).");				
		}
		else if(errors.size()==0 && warnings.size()>0) {
			TabManager.get().selectWarningEditor();
			MessageManager.get().showError("Model Verified", "Model verified with "+warnings.size()+" warning(s).");				
		} else {
			MessageManager.get().showSuccess("Model Verified", "Model is syntactically correct");
		}
		CursorManager.get().defaultCursor();
	}
	
	public List<ProblemElement> verifyErrors(){
		double start = System.currentTimeMillis();		
		List<ProblemElement> problems = new ArrayList<ProblemElement>();		
		problems.addAll(getMetamodelErrors());	
		problems.addAll(getApplicationErrors());		
		Collections.sort(problems,new ProblemComparator());
		double end = System.currentTimeMillis();				
		int count=0;
		for(ProblemElement pe: problems) { count++; pe.setIdentifier(count); }		
		TabManager.get().addErrorsEditor(start, end, problems, listener());
		return problems;
	}
	
	public List<ProblemElement> verifyWarnings(){		
		List<ProblemElement> warnings = new ArrayList<ProblemElement>();
		WarningVerificator verificator = new WarningVerificator(Models.getRefparser());					
		verificator.run();
		warnings.addAll(verificator.getWarnings());		
		Collections.sort(warnings,new ProblemComparator());		
		int count=0;
		for(ProblemElement pe: warnings) { count++; pe.setIdentifier(count); }
		TabManager.get().addWarningsEditor(verificator.getTimingMessage(), warnings, listener());
		return warnings;
	}
	
	public List<ProblemElement> getApplicationErrors(){
		List<ProblemElement> result = new ArrayList<ProblemElement>();
		ErrorVerificator errorVerificator = new ErrorVerificator(Models.getRefparser());
		errorVerificator.run();
		result.addAll(errorVerificator.getErrors());
		return result;
	}
	
	public List<ProblemElement> getMetamodelErrors(){
		List<ProblemElement> result = new ArrayList<ProblemElement>();
		SyntacticVerificator verificator = new SyntacticVerificator();
		verificator.run(ProjectManager.get().getProject().getModel());			
		for(RefOntoUML.Element elem: verificator.getMap().keySet()){
			for(String message: verificator.getMap().get(elem)){					
				result.add(new ErrorElement(elem,0,message,TypeProblem.SYNTACTIC));
			}
		}	
		return result;
	}
	
	private class ProblemComparator implements Comparator<ProblemElement>{
        @Override
        public int compare(ProblemElement o1, ProblemElement o2) {
            return o1.getDescription().compareToIgnoreCase(o2.getDescription());
        }
    }
}
