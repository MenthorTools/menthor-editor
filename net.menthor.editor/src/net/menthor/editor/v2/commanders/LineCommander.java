package net.menthor.editor.v2.commanders;

import java.util.List;

import org.tinyuml.draw.RectilinearConnection;
import org.tinyuml.draw.SimpleConnection;
import org.tinyuml.draw.TreeConnection;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.AssociationElement.ReadingDesign;
import org.tinyuml.umldraw.shared.UmlConnection;

import net.menthor.editor.v2.ui.operation.IDiagramOperation;
import net.menthor.editor.v2.ui.operation.diagram.LineStyleOperation;
import net.menthor.editor.v2.ui.operation.diagram.ReadingDesignOperation;
import net.menthor.editor.v2.ui.operation.diagram.ResetPointsOperation;

public class LineCommander extends GenericCommander {

	// -------- Lazy Initialization

	private static class DuplicateLoader {
        private static final LineCommander INSTANCE = new LineCommander();
    }	
	public static LineCommander get() { 
		return DuplicateLoader.INSTANCE; 
	}	
    private LineCommander() {
        if (DuplicateLoader.INSTANCE != null) throw new IllegalStateException("AlignCommander already instantiated");
    }		
    
    // ----------------------------
	
    public void readingDesignToTarget(Object input){
		if (input instanceof AssociationElement) {	
			setReadingDesign((AssociationElement) input,ReadingDesign.DESTINATION);
		}
	}
	
	public void readingDesignUnspecified(Object input){
		if (input instanceof AssociationElement) {	
			setReadingDesign((AssociationElement) input,ReadingDesign.UNDEFINED);
		}
	}
		
	public void readingDesignToSource(Object input){
		if (input instanceof AssociationElement) {	
			setReadingDesign((AssociationElement) input,ReadingDesign.SOURCE);
		}
	}
	
	private void setReadingDesign (AssociationElement association, ReadingDesign newDesign){
		execute(new ReadingDesignOperation(currentEditor(), association, newDesign));
	}
	
	/** Switches a direct connection into a rectilinear one. */
	public void toRectilinear() {
		toRectilinear(SelectCommanderMode.get().getSelectedElements());
	}
	public void toRectilinear(Object input) {		
		List<UmlConnection> connections = setUpAsList(input, UmlConnection.class);
		
		for(UmlConnection connection: connections){
			execute(new LineStyleOperation(currentEditor(), connection, new RectilinearConnection(connection)));
		}
		
		SelectCommanderMode.get().deselectAll();	
	}
	
	/** Switches a direct connection into a tree vertical one. */
	public void toTreeStyleVertical(){
		toTreeStyleVertical(SelectCommanderMode.get().getSelectedElements());
	}
	
	public void toTreeStyleVertical(Object input){		
		List<UmlConnection> connections = setUpAsList(input, UmlConnection.class);
		
		for(UmlConnection connection: connections){
			execute(new LineStyleOperation(currentEditor(), connection, new TreeConnection(connection,true)));
		}
		
		SelectCommanderMode.get().deselectAll();
	}
	
	/** Switches a direct connection into a tree horizontal one. */
	public void toTreeStyleHorizontal(){
		toTreeStyleHorizontal(SelectCommanderMode.get().getSelectedElements());		
	}
	
	public void toTreeStyleHorizontal(Object input){		
		List<UmlConnection> connections = setUpAsList(input, UmlConnection.class);
		
		for(UmlConnection connection: connections){
			execute(new LineStyleOperation(currentEditor(), connection, new TreeConnection(connection,false)));
		}		
		
		SelectCommanderMode.get().deselectAll();		
	}
	
	
	/** Switches a rectilinear connection to a direct one. */
	public void toDirect(){
		toDirect(SelectCommanderMode.get().getSelectedElements());		
	}
	
	public void toDirect(Object input){
		List<UmlConnection> connections = setUpAsList(input, UmlConnection.class);
		
		for(UmlConnection connection: connections){
			execute(new LineStyleOperation(currentEditor(), connection, new SimpleConnection(connection)));
		}

		SelectCommanderMode.get().deselectAll();
	}
	
	
	/**
	 * Resets the current connection's points.
	 */
	public void resetConnectionPoints(){
		resetConnectionPoints(SelectCommanderMode.get().getSelectedElements());
	}

	public void resetConnectionPoints(Object input){
		List<UmlConnection> connections = setUpAsList(input, UmlConnection.class);
		
		for(UmlConnection connection: connections){
			execute(new ResetPointsOperation(currentEditor(), connection));
		}
	}
	private void execute(IDiagramOperation operation) {
		operation.run();
		
		
	}
	
	
	
	
}
