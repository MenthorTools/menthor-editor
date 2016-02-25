package net.menthor.editor.v2.managers;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.NamedElement;
import net.menthor.editor.v2.element.ProblemElement;
import net.menthor.editor.v2.element.ProblemElement.TypeProblem;
import net.menthor.editor.v2.ui.controller.ProjectController;
import net.menthor.editor.v2.ui.controller.TabbedAreaController;
import net.menthor.editor.v2.element.WarningElement;

public class WarningManager extends AbstractManager {

	// -------- Lazy Initialization

	private static class WarningLoader {
        private static final WarningManager INSTANCE = new WarningManager();
    }	
	public static WarningManager get() { 
		return WarningLoader.INSTANCE; 
	}	
    protected WarningManager() {
        if (WarningLoader.INSTANCE != null) throw new IllegalStateException("WarningManager already instantiated");
    }		
	   
    // ----------------------------
    
    private double start =0 ;
	private double end =0 ;	
	private List<WarningElement> warnings;
	
	public List<ProblemElement> verifyWarnings(){		
		List<ProblemElement> result = new ArrayList<ProblemElement>();
		List<WarningElement> warnings = getWarnings();		
		result.addAll(warnings);		
		Collections.sort(result,new ProblemComparator());		
		int count=0;
		for(ProblemElement pe: result) { count++; pe.setIdentifier(count); }
		TabbedAreaController.get().addWarnings(getTimingMessage(), result);
		return result;
	}
	
	public String getTimingMessage(){
		int n = 0;
		if(warnings!=null) n = warnings.size();
		return MessageFormat.format("Model verified in {0} ms, {1} warning(s) found", (end - start), n);
	}
	
	private List<WarningElement> getWarnings(){
    	warnings = new ArrayList<WarningElement>();
		start = System.currentTimeMillis();
		checkUnnamedElements();		
		end = System.currentTimeMillis();
		return warnings;
	}
	 
	private void checkUnnamedElements(){		
		for(EObject c: ProjectController.get().getProject().getRefParser().getElements()){			
			if(c instanceof NamedElement){
				NamedElement ne = (NamedElement)c;
				if (ne.getName()==null || ne.getName().trim().isEmpty()){ 				
					String message = "Unnamed element";
					warnings.add(new WarningElement(c,0,message,TypeProblem.APP));
									
				}
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
