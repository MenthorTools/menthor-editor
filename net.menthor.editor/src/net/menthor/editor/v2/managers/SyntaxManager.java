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
import net.menthor.editor.v2.element.ErrorElement;
import net.menthor.editor.v2.element.ProblemElement;
import net.menthor.editor.v2.element.ProblemElement.TypeProblem;
import net.menthor.editor.v2.feature.AlloyFeature;
import net.menthor.editor.v2.ui.app.manager.AppMessageManager;
import net.menthor.editor.v2.ui.app.manager.AppSplitPaneManager;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
import net.menthor.tocl.parser.TOCLParser;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;

public class SyntaxManager {

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
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();				
		try { 
			String name = ((RefOntoUML.Package)ProjectManager.get().getProject().getResource().getContents().get(0)).getName();
			if (name==null || name.isEmpty()) name = "model";
			TOCLParser toclparser = new TOCLParser(refparser,ProjectManager.get().getProject().getTempDir()+File.separator,name.toLowerCase());
			toclparser.parseTemporalOCL(AppTabManager.get().getConstraints());			
			AlloyFeature.get().oclOptions = new TOCL2AlloyOption(toclparser);
			String msg =  "Constraints are syntactically correct.\n";
			if(showSuccesfullyMessage) AppMessageManager.get().showSuccess("Constraints Parse",msg);			
		}catch(SemanticException e2){
			AppMessageManager.get().showError(e2, "OCL Semantics",  "Could not parse OCl constraints.");    		
		}catch(ParserException e1){
			AppMessageManager.get().showError(e1, "OCL Parser", "Could not parse OCl constraints.");    			
		}catch(Exception e4){
			AppMessageManager.get().showError(e4, "OCL", "Could not parse OCl constraints");			
		}				
	}
	
	//we want warnings and errors all together with the model verification
	public void verifyModel(){
		CursorManager.get().waitCursor();		
		double start = System.currentTimeMillis();
		
		//application warnings
		List<ProblemElement> warnings = WarningManager.get().verifyWarnings();
		//application errors
		List<ProblemElement> errors = new ArrayList<ProblemElement>();		
		errors.addAll(ErrorManager.get().getErrors());		
		//meta-model issues
		errors.addAll(getMetamodelErrors());
		
		Collections.sort(errors,new ProblemComparator());
		double end = System.currentTimeMillis();				
		int count=0;
		for(ProblemElement pe: errors) { count++; pe.setIdentifier(count); }		
		AppTabManager.get().addErrorsEditor(start, end, errors);		
		AppSplitPaneManager.get().forceShowInfo();
		if(errors.size()>0 && warnings.size()>0) {
			AppTabManager.get().selectErrorEditor();
			AppMessageManager.get().showError("Model Verified", "Model verified with "+errors.size()+" errors(s) and "+warnings.size()+" warning(s).");				
		}
		else if(errors.size()>0 && warnings.size()==0) {
			AppTabManager.get().selectErrorEditor();
			AppMessageManager.get().showError("Model Verified", "Model verified "+errors.size()+" errors(s).");				
		}
		else if(errors.size()==0 && warnings.size()>0) {
			AppTabManager.get().selectWarningEditor();
			AppMessageManager.get().showError("Model Verified", "Model verified with "+warnings.size()+" warning(s).");				
		} else {
			AppMessageManager.get().showSuccess("Model Verified", "Model is syntactically correct");
		}
		CursorManager.get().defaultCursor();
	}
	
	private List<ProblemElement> getMetamodelErrors(){
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
