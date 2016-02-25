package net.menthor.editor.v2.managers;

import java.util.ArrayList;
import java.util.List;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.common.ontoumlparser.OntoUMLModelStatistic;
import net.menthor.common.ontoumlparser.OntoUMLModelStatistic.TypeDetail;
import net.menthor.editor.v2.element.StatisticalElement;
import net.menthor.editor.v2.ui.controller.ProjectUIController;

public class StatisticsManager extends AbstractManager {

	// -------- Lazy Initialization

	private static class StatisticsLoader {
        private static final StatisticsManager INSTANCE = new StatisticsManager();
    }	
	public static StatisticsManager get() { 
		return StatisticsLoader.INSTANCE; 
	}	
    private StatisticsManager() {
        if (StatisticsLoader.INSTANCE != null) throw new IllegalStateException("StatisticsManager already instantiated");
    }		
    
    // ----------------------------
    
    public List<StatisticalElement> getStatistic(){
    	OntoUMLParser refparser = ProjectUIController.get().getProject().getRefParser();
		List<StatisticalElement> result = new ArrayList<StatisticalElement>();		
		if(refparser!=null){
			OntoUMLModelStatistic diagnostic = new OntoUMLModelStatistic(refparser);
			diagnostic.run();			
			for (TypeDetail detail : diagnostic.getDetails()) {
				result.add(new StatisticalElement(detail));
			}
		}
		return result;
	}

}
