package net.menthor.editor.v2.commanders;

import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.DiagramElement;

import net.menthor.editor.v2.ui.controller.TabbedAreaController;
import net.menthor.editor.v2.ui.operation.diagram.AlignOperation;
import net.menthor.editor.v2.ui.operation.diagram.AlignOperation.Alignment;

public class AlignCommander {

	// -------- Lazy Initialization

	private static class DuplicateLoader {
        private static final AlignCommander INSTANCE = new AlignCommander();
    }	
	public static AlignCommander get() { 
		return DuplicateLoader.INSTANCE; 
	}	
    private AlignCommander() {
        if (DuplicateLoader.INSTANCE != null) throw new IllegalStateException("AlignCommander already instantiated");
    }		
    
    // ----------------------------
	
    public void executeAlignCenterVertically(ArrayList<DiagramElement> diagramElements){
    	executeAlign(diagramElements, Alignment.CENTER_VERTICAL);
	}
	
	public void executeAlignCenterHorizontally(ArrayList<DiagramElement> diagramElements){
		executeAlign(diagramElements, Alignment.CENTER_HORIZONTAL);
	}
	
	public void executeAlignBottom(ArrayList<DiagramElement> diagramElements){
		executeAlign(diagramElements, Alignment.BOTTOM);
	}
		
	public void executeAlignTop(ArrayList<DiagramElement> diagramElements){
		executeAlign(diagramElements, Alignment.TOP);
	}
	
	public void executeAlignRight(ArrayList<DiagramElement> diagramElements){
		executeAlign(diagramElements, Alignment.RIGHT);
	}
	
	public void executeAlignLeft(ArrayList<DiagramElement> diagramElements){
		executeAlign(diagramElements, Alignment.LEFT);
	}
	
	private void executeAlign(List<DiagramElement> diagramElements, Alignment mode ) {
		AlignOperation command = new AlignOperation(TabbedAreaController.get().getSelectedTopOntoumlEditor(), diagramElements, mode);
		command.run();
	}
	
	
}
